package com.zrt.flow.service.flownotify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.AppException;
import com.zrt.commons.PageInit;
import com.zrt.commons.date.DateUtil;
import com.zrt.flow.domain.InstInfoDomain;
import com.zrt.flow.domain.NotifyEmpDomain;
import com.zrt.flow.domain.TaskDomain;
import com.zrt.flow.mapper.flownotify.FlownotifyMapper;
import com.zrt.flow.service.act.ActProcessService;
import com.zrt.flow.service.contacts.ContactsService;
import com.zrt.flow.service.process.ProcessCommonService;
import com.zrt.flow.service.runnable.RunnableService;
import com.zrt.flow.service.serial.SerialService;
import com.zrt.mybatis.domain.FbBusCheck;
import com.zrt.mybatis.domain.FbBusHandle;
import com.zrt.mybatis.domain.FbBusHandleExample;
import com.zrt.mybatis.domain.FbBusInst;
import com.zrt.mybatis.domain.FbBusInstNotify;
import com.zrt.mybatis.domain.FbBusInstNotifyEmp;
import com.zrt.mybatis.mapper.FbBusHandleMapper;
import com.zrt.mybatis.mapper.FbBusInstMapper;
import com.zrt.mybatis.mapper.FbBusInstNotifyEmpMapper;
import com.zrt.mybatis.mapper.FbBusInstNotifyMapper;

/**
 * Created by dwliu on 2017/9/20.
 */
@Service
public class FlownotifyServiceImpl implements FlownotifyService {

    @Autowired
    private FlownotifyMapper flownotifyMapper;
    @Autowired
    private ActProcessService actProcessService;
    @Autowired
	private ContactsService contactsService;
    @Autowired
	private ProcessCommonService processCommonService;
    @Autowired
	private SerialService serialService;
    @Autowired
	private FbBusInstNotifyMapper fbBusInstNotifyMapper;
    @Autowired
	private FbBusInstNotifyEmpMapper fbBusInstNotifyEmpMapper;
    @Autowired
	private FbBusInstMapper fbBusInstMapper;
    @Value("${im.notify.sender_id}")
	private String systemEmpId;
    @Autowired
	private RunnableService runnableService;
	@Autowired
	private FbBusHandleMapper fbBusHandleMapper;
    
    /**
     * 我知会的
     */
    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> selfList(Map<String, Object> appMap) throws Exception {
    	  PageInit.setPage(appMap);
          PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
                  Integer.parseInt(appMap.get("maxResult").toString())).setReasonable(false);
          //我知会的
          appMap.put("tel_emp_id", appMap.get("emp_id"));
          List<InstInfoDomain> listMap = flownotifyMapper.selfList(appMap);
          
          PageInfo<InstInfoDomain> pageInfo = new PageInfo<InstInfoDomain>(listMap);
          List<Map<String, Object>> dataList=new ArrayList<Map<String, Object>>();
  		for(InstInfoDomain inst:listMap){
  			Map<String, Object> dataMap=new HashMap<String, Object>();
  			dataMap.put("inst_id", inst.getInstId());//流程实例id
  			dataMap.put("apply_id", inst.getApplyId());
  			dataMap.put("apply_name", inst.getApplyName());
  			dataMap.put("org_id", inst.getOrgId());
  			dataMap.put("org_name", inst.getOrgName());
  			//发起人头像
  			Map<String, Object> applyEmpData=getEmpInfo(inst.getApplyId());
  			dataMap.put("apply_emp_head_photo", applyEmpData.get("emp_head_photo"));
  			dataMap.put("t_code", inst.gettCode());
  			dataMap.put("t_name", inst.gettName());
  			dataMap.put("fb_title", inst.getFbTitle());
  			dataMap.put("t_type_id", inst.gettTypeId());
  			dataMap.put("t_type_name", inst.gettTypeName());
  			dataMap.put("parent_t_type_id", inst.getParentTTypeId());
  			dataMap.put("parent_t_type_name", inst.getParentTTypeName());
  			dataMap.put("fb_content", inst.getFbContent());
  			dataMap.put("inst_status", inst.getInstStatus());
  			dataMap.put("start_date_time", inst.getStartDateTime());
  			dataMap.put("tel_emp_id", inst.getTelEmpId());
  			dataMap.put("tel_emp_name", inst.getTelEmpName());
  			dataMap.put("handle_flag", inst.getHandleFlag());
			dataMap.put("project_flag", inst.getProjectFlag());
  			//知会人员list
  			List<NotifyEmpDomain> notifyEmpList= inst.getNotifyEmpList();//被知会人list
  			List<Map<String, Object>> nyList=new ArrayList<>();
  			for(NotifyEmpDomain tk:notifyEmpList){
  				Map<String, Object> assigneeMap=new HashMap<String, Object>();
  				assigneeMap.put("notify_emp_id", tk.getNotifyEmpId());//
  				assigneeMap.put("notify_emp_name", tk.getNotifyEmpName());
  				//查询被知会人机构头像信息
  				Map<String, Object> notifyEmpData=getEmpInfo(tk.getNotifyEmpId());
  				if(notifyEmpData==null){
  					throw new AppException("被知会人信息查询失败");
  				}
  				assigneeMap.put("notify_org_id", notifyEmpData.get("org_id"));//
  				assigneeMap.put("notify_org_name", notifyEmpData.get("org_name"));
  				assigneeMap.put("notify_emp_head_photo", notifyEmpData.get("emp_head_photo"));
  				nyList.add(assigneeMap);
  				
  			}
  			dataMap.put("notify_list", nyList);
  			//当前节点信息
  			List<TaskDomain> taskList= inst.getTaskList();//代办人列表
  			List<Map<String, Object>> assList=new ArrayList<>();
  			if("0".equals(inst.getHandleFlag())){
				for(TaskDomain tk:taskList){
					Map<String, Object> assigneeMap=new HashMap<String, Object>();
					assigneeMap.put("cur_tag_id", tk.getCurTagId());
					assigneeMap.put("cur_tag_name", tk.getCurTagName());
					assigneeMap.put("cur_tag_assignee", tk.getCurTagAssignee());
					if(tk.getCurTagAssignee()!=null && !"".equals(tk.getCurTagAssignee())){
						assigneeMap.put("cur_tag_assignee_name", getEmpInfo(tk.getCurTagAssignee()).get("emp_name"));
					}else{
						assigneeMap.put("cur_tag_assignee_name", null);

					}
					assList.add(assigneeMap);
					
				}
			}else if("1".equals(inst.getHandleFlag())){
				//查询签报类代办人
				FbBusHandleExample handleExample=new FbBusHandleExample();
				com.zrt.mybatis.domain.FbBusHandleExample.Criteria handleCriteria=handleExample.createCriteria();
				handleCriteria.andInstIdEqualTo(inst.getInstId());
				handleCriteria.andHandleStatusEqualTo("0");//未签报的
				List<FbBusHandle> handleList=fbBusHandleMapper.selectByExample(handleExample);
				for(FbBusHandle handle:handleList){
					Map<String, Object> assigneeMap=new HashMap<String, Object>();
					assigneeMap.put("cur_tag_id", null);
					assigneeMap.put("cur_tag_name", null);
					assigneeMap.put("cur_tag_assignee",handle.getHandleEmpId());
					assigneeMap.put("cur_tag_assignee_name", handle.getHandleEmpName());
					assList.add(assigneeMap);
				}
			}
  			dataMap.put("assignee_list", assList);
  			dataList.add(dataMap);
  		}
          Map<String, Object> resMap = new HashMap<String, Object>();
          Map<String, Object> dataMap = new HashMap<String, Object>();
          dataMap.put("list", dataList);
          resMap.put("data", dataMap);
          resMap.put("count", pageInfo.getTotal());
          return resMap;
    }

    @Override
    public Map<String, Object> appSelfList(Map<String, Object> appMap) throws Exception {
    	  PageInit.setPage(appMap);
          PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
                  Integer.parseInt(appMap.get("maxResult").toString())).setReasonable(false);
          //我知会的
          appMap.put("tel_emp_id", appMap.get("emp_id"));
          List<InstInfoDomain> listMap = flownotifyMapper.selfList(appMap);
          
          PageInfo<InstInfoDomain> pageInfo = new PageInfo<InstInfoDomain>(listMap);
          List<Map<String, Object>> dataList=new ArrayList<Map<String, Object>>();
  		for(InstInfoDomain inst:listMap){
  			Map<String, Object> dataMap=new HashMap<String, Object>();
  			dataMap.put("inst_id", inst.getInstId());//流程实例id
  			dataMap.put("apply_id", inst.getApplyId());
  			dataMap.put("apply_name", inst.getApplyName());
  			dataMap.put("org_id", inst.getOrgId());
  			dataMap.put("org_name", inst.getOrgName());
  			dataMap.put("t_code", inst.gettCode());
  			dataMap.put("t_name", inst.gettName());
  			dataMap.put("fb_title", inst.getFbTitle());
  			dataMap.put("t_type_id", inst.gettTypeId());
  			dataMap.put("t_type_name", inst.gettTypeName());
  			dataMap.put("parent_t_type_id", inst.getParentTTypeId());
  			dataMap.put("parent_t_type_name", inst.getParentTTypeName());
  			dataMap.put("fb_content", inst.getFbContent());
  			dataMap.put("inst_status", inst.getInstStatus());
  			dataMap.put("start_date_time", inst.getStartDateTime());
  			dataMap.put("notify_emp_id", inst.getTelEmpId());
  			dataMap.put("tel_emp_name", inst.getTelEmpName());
  			dataMap.put("handle_flag", inst.getHandleFlag());
			dataMap.put("project_flag", inst.getProjectFlag());
  			//知会人员list
  			List<NotifyEmpDomain> notifyEmpList= inst.getNotifyEmpList();//被知会人list
  			List<Map<String, Object>> nyList=new ArrayList<>();
  			for(NotifyEmpDomain tk:notifyEmpList){
  				Map<String, Object> assigneeMap=new HashMap<String, Object>();
  				assigneeMap.put("notify_emp_id", tk.getNotifyEmpId());//
  				assigneeMap.put("notify_emp_name", tk.getNotifyEmpName());
  				nyList.add(assigneeMap);
  				
  			}
  			dataMap.put("notify_list", nyList);
  			//当前节点信息
  			List<TaskDomain> taskList= inst.getTaskList();//代办人列表
  			List<Map<String, Object>> assList=new ArrayList<>();
  			if("0".equals(inst.getHandleFlag())){
				for(TaskDomain tk:taskList){
					Map<String, Object> assigneeMap=new HashMap<String, Object>();
					assigneeMap.put("cur_tag_id", tk.getCurTagId());
					assigneeMap.put("cur_tag_name", tk.getCurTagName());
					assigneeMap.put("cur_tag_assignee", tk.getCurTagAssignee());
					if(tk.getCurTagAssignee()!=null && !"".equals(tk.getCurTagAssignee())){
						assigneeMap.put("cur_tag_assignee_name", getEmpInfo(tk.getCurTagAssignee()).get("emp_name"));
					}else{
						assigneeMap.put("cur_tag_assignee_name", null);

					}
					assList.add(assigneeMap);
					
				}
			}else if("1".equals(inst.getHandleFlag())){
				//查询签报类代办人
				FbBusHandleExample handleExample=new FbBusHandleExample();
				com.zrt.mybatis.domain.FbBusHandleExample.Criteria handleCriteria=handleExample.createCriteria();
				handleCriteria.andInstIdEqualTo(inst.getInstId());
				handleCriteria.andHandleStatusEqualTo("0");//未签报的
				List<FbBusHandle> handleList=fbBusHandleMapper.selectByExample(handleExample);
				for(FbBusHandle handle:handleList){
					Map<String, Object> assigneeMap=new HashMap<String, Object>();
					assigneeMap.put("cur_tag_id", null);
					assigneeMap.put("cur_tag_name", null);
					assigneeMap.put("cur_tag_assignee",handle.getHandleEmpId());
					assigneeMap.put("cur_tag_assignee_name", handle.getHandleEmpName());
					assList.add(assigneeMap);
				}
			}
  			dataMap.put("assignee_list", assList);
  			dataList.add(dataMap);
  		}
          Map<String, Object> resMap = new HashMap<String, Object>();
          Map<String, Object> dataMap = new HashMap<String, Object>();
          dataMap.put("list", dataList);
          resMap.put("data", dataMap);
          resMap.put("count", pageInfo.getTotal());
          return resMap;
    }

    /**
     * 知会我的
     */
    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> notifyList(Map<String, Object> appMap) throws Exception {
        PageInit.setPage(appMap);
        PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
                Integer.parseInt(appMap.get("maxResult").toString())).setReasonable(false);
        //知会我的
       //被知会人是我
        appMap.put("notify_emp_id", appMap.get("emp_id"));
        List<InstInfoDomain> listMap = flownotifyMapper.notifyList(appMap);
        
        PageInfo<InstInfoDomain> pageInfo = new PageInfo<InstInfoDomain>(listMap);
        List<Map<String, Object>> dataList=new ArrayList<Map<String, Object>>();
		for(InstInfoDomain inst:listMap){
			Map<String, Object> dataMap=new HashMap<String, Object>();
			dataMap.put("inst_id", inst.getInstId());//流程实例id
			dataMap.put("apply_id", inst.getApplyId());
			dataMap.put("apply_name", inst.getApplyName());
			dataMap.put("org_id", inst.getOrgId());
			dataMap.put("org_name", inst.getOrgName());
			//发起人头像
  			Map<String, Object> applyEmpData=getEmpInfo(inst.getApplyId());
  			dataMap.put("apply_emp_head_photo", applyEmpData.get("emp_head_photo"));
			dataMap.put("t_code", inst.gettCode());
			dataMap.put("t_name", inst.gettName());
			dataMap.put("fb_title", inst.getFbTitle());
			dataMap.put("t_type_id", inst.gettTypeId());
			dataMap.put("t_type_name", inst.gettTypeName());
			dataMap.put("parent_t_type_id", inst.getParentTTypeId());
			dataMap.put("parent_t_type_name", inst.getParentTTypeName());
			dataMap.put("fb_content", inst.getFbContent());
			dataMap.put("inst_status", inst.getInstStatus());
			dataMap.put("start_date_time", inst.getStartDateTime());
			dataMap.put("tel_emp_id", inst.getTelEmpId());
			dataMap.put("tel_emp_name", inst.getTelEmpName());
			dataMap.put("tel_org_id", inst.getTelOrgId());
			dataMap.put("tel_org_name", inst.getTelOrgName());
			//知会人头像
			Map<String, Object> telEmpData=getEmpInfo(inst.getTelEmpId());
  			dataMap.put("tel_emp_head_photo", telEmpData.get("emp_head_photo"));
			dataMap.put("handle_flag", inst.getHandleFlag());
			dataMap.put("project_flag", inst.getProjectFlag());
			//当前节点信息
			List<TaskDomain> taskList= inst.getTaskList();//代办人列表
			List<Map<String, Object>> assList=new ArrayList<>();
			if("0".equals(inst.getHandleFlag())){
				for(TaskDomain tk:taskList){
					Map<String, Object> assigneeMap=new HashMap<String, Object>();
					assigneeMap.put("cur_tag_id", tk.getCurTagId());
					assigneeMap.put("cur_tag_name", tk.getCurTagName());
					assigneeMap.put("cur_tag_assignee", tk.getCurTagAssignee());
					if(tk.getCurTagAssignee()!=null && !"".equals(tk.getCurTagAssignee())){
						assigneeMap.put("cur_tag_assignee_name", getEmpInfo(tk.getCurTagAssignee()).get("emp_name"));
					}else{
						assigneeMap.put("cur_tag_assignee_name", null);

					}
					assList.add(assigneeMap);
					
				}
			}else if("1".equals(inst.getHandleFlag())){
				//查询签报类代办人
				FbBusHandleExample handleExample=new FbBusHandleExample();
				com.zrt.mybatis.domain.FbBusHandleExample.Criteria handleCriteria=handleExample.createCriteria();
				handleCriteria.andInstIdEqualTo(inst.getInstId());
				handleCriteria.andHandleStatusEqualTo("0");//未签报的
				List<FbBusHandle> handleList=fbBusHandleMapper.selectByExample(handleExample);
				for(FbBusHandle handle:handleList){
					Map<String, Object> assigneeMap=new HashMap<String, Object>();
					assigneeMap.put("cur_tag_id", null);
					assigneeMap.put("cur_tag_name", null);
					assigneeMap.put("cur_tag_assignee",handle.getHandleEmpId());
					assigneeMap.put("cur_tag_assignee_name", handle.getHandleEmpName());
					assList.add(assigneeMap);
				}
			}
			dataMap.put("assignee_list", assList);
			dataList.add(dataMap);
		}
        Map<String, Object> resMap = new HashMap<String, Object>();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("list", dataList);
        resMap.put("data", dataMap);
        resMap.put("count", pageInfo.getTotal());
        return resMap;
    }

    @Override
    public Map<String, Object> appNotifyList(Map<String, Object> appMap) throws Exception {
    	 PageInit.setPage(appMap);
         PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
                 Integer.parseInt(appMap.get("maxResult").toString())).setReasonable(false);
         //知会我的
        //被知会人是我
         appMap.put("notify_emp_id", appMap.get("emp_id"));
         List<InstInfoDomain> listMap = flownotifyMapper.notifyList(appMap);
         
         PageInfo<InstInfoDomain> pageInfo = new PageInfo<InstInfoDomain>(listMap);
         List<Map<String, Object>> dataList=new ArrayList<Map<String, Object>>();
 		for(InstInfoDomain inst:listMap){
 			Map<String, Object> dataMap=new HashMap<String, Object>();
 			dataMap.put("inst_id", inst.getInstId());//流程实例id
 			dataMap.put("apply_id", inst.getApplyId());
 			dataMap.put("apply_name", inst.getApplyName());
 			dataMap.put("org_id", inst.getOrgId());
 			dataMap.put("org_name", inst.getOrgName());
 			dataMap.put("t_code", inst.gettCode());
 			dataMap.put("t_name", inst.gettName());
 			dataMap.put("fb_title", inst.getFbTitle());
 			dataMap.put("t_type_id", inst.gettTypeId());
 			dataMap.put("t_type_name", inst.gettTypeName());
 			dataMap.put("parent_t_type_id", inst.getParentTTypeId());
 			dataMap.put("parent_t_type_name", inst.getParentTTypeName());
 			dataMap.put("fb_content", inst.getFbContent());
 			dataMap.put("inst_status", inst.getInstStatus());
 			dataMap.put("start_date_time", inst.getStartDateTime());
 			dataMap.put("tel_emp_id", inst.getTelEmpId());
 			dataMap.put("tel_emp_name", inst.getTelEmpName());
 			dataMap.put("handle_flag", inst.getHandleFlag());
			dataMap.put("project_flag", inst.getProjectFlag());
 			//当前节点信息
 			List<TaskDomain> taskList= inst.getTaskList();//代办人列表
 			List<Map<String, Object>> assList=new ArrayList<>();
 			if("0".equals(inst.getHandleFlag())){
				for(TaskDomain tk:taskList){
					Map<String, Object> assigneeMap=new HashMap<String, Object>();
					assigneeMap.put("cur_tag_id", tk.getCurTagId());
					assigneeMap.put("cur_tag_name", tk.getCurTagName());
					assigneeMap.put("cur_tag_assignee", tk.getCurTagAssignee());
					if(tk.getCurTagAssignee()!=null && !"".equals(tk.getCurTagAssignee())){
						assigneeMap.put("cur_tag_assignee_name", getEmpInfo(tk.getCurTagAssignee()).get("emp_name"));
					}else{
						assigneeMap.put("cur_tag_assignee_name", null);

					}
					assList.add(assigneeMap);
					
				}
			}else if("1".equals(inst.getHandleFlag())){
				//查询签报类代办人
				FbBusHandleExample handleExample=new FbBusHandleExample();
				com.zrt.mybatis.domain.FbBusHandleExample.Criteria handleCriteria=handleExample.createCriteria();
				handleCriteria.andInstIdEqualTo(inst.getInstId());
				handleCriteria.andHandleStatusEqualTo("0");//未签报的
				List<FbBusHandle> handleList=fbBusHandleMapper.selectByExample(handleExample);
				for(FbBusHandle handle:handleList){
					Map<String, Object> assigneeMap=new HashMap<String, Object>();
					assigneeMap.put("cur_tag_id", null);
					assigneeMap.put("cur_tag_name", null);
					assigneeMap.put("cur_tag_assignee",handle.getHandleEmpId());
					assigneeMap.put("cur_tag_assignee_name", handle.getHandleEmpName());
					assList.add(assigneeMap);
				}
			}
 			dataMap.put("assignee_list", assList);
 			dataList.add(dataMap);
 		}
         Map<String, Object> resMap = new HashMap<String, Object>();
         Map<String, Object> dataMap = new HashMap<String, Object>();
         dataMap.put("list", dataList);
         resMap.put("data", dataMap);
         resMap.put("count", pageInfo.getTotal());
         return resMap;
    }
    
    
	public Map<String, Object> getEmpInfo(String emp_id){
		Map<String, Object> conmap = new HashMap<>();
		conmap.put("search", emp_id);
		Map<String, Object> result = contactsService.commonEmpSearch(conmap);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> li = (List<Map<String, Object>>) result.get("data");
		Map<String, Object> data = null;
		if (null != li && li.size() > 0) {
			data = li.get(0);
		}
		return data;
	}
	
	/**
	 * 只会
	 */
	@Transactional(rollbackFor={Throwable.class},propagation=Propagation.REQUIRED)
	@Override
	public Map<String, Object> notify(Map<String, Object> appMap) throws Exception {
		
		
		
		//判断是否创建了阅读信息,保存或更新审核表
		FbBusCheck fbBusCheck=processCommonService.checkSave(appMap,null,(String)appMap.get("cur_tag_id"),(String)appMap.get("cur_tag_name"));
		//
		String signEmpIds=(String)appMap.get("notify_emp_ids");
		String cur_date=DateUtil.getCurrentDateTime();
		String[] signEmpIdArr=null;
		signEmpIdArr=signEmpIds.split(";");
		//知会主表
		FbBusInstNotify fbBusInstNotify=new FbBusInstNotify();
		String notifyId=serialService.getUUID();
		fbBusInstNotify.setId(notifyId);
		fbBusInstNotify.setTelEmpId(fbBusCheck.getCheckEmpId());
		fbBusInstNotify.setTelEmpName(fbBusCheck.getCheckEmpName());
		fbBusInstNotify.setOrgId(fbBusCheck.getOrgId());
		fbBusInstNotify.setOrgName(fbBusCheck.getOrgName());
		fbBusInstNotify.setInstId((String)appMap.get("inst_id"));
		fbBusInstNotify.setInstTag(fbBusCheck.getInstTag());
		fbBusInstNotify.setInstTagName(fbBusCheck.getInstTagName());
		fbBusInstNotify.setCreateDateTime(cur_date);
		fbBusInstNotify.setUpdateDateTime(cur_date);
		fbBusInstNotifyMapper.insert(fbBusInstNotify);
		for(int i=0;i<signEmpIdArr.length;i++){
			String signEmpId=signEmpIdArr[i];
			if(signEmpId==null || "".equals(signEmpId)){
				continue;
			}
			//判断是否知会过
			Map<String, Object> paramMap=new HashMap<String, Object>();
			paramMap.put("tel_emp_id", appMap.get("emp_id"));//知会人
			paramMap.put("inst_id", appMap.get("inst_id"));//流程发起id
			paramMap.put("cur_tag_id", appMap.get("cur_tag_id"));//当前节点id
			paramMap.put("notify_emp_id", signEmpId);//被知会人
			//查询该流程是否知会过
			List<Map<String, Object>> noList=flownotifyMapper.tagNotifyList(paramMap);
			if(noList!=null && !noList.isEmpty()){
				//如果存在知会人，知会节点，被知会人就抛出错误
				throw new AppException("该流程已知会过");
			}
			Map<String, Object> empData=getEmpInfo(signEmpId);
			FbBusInstNotifyEmp fbBusInstNotifyEmp=new FbBusInstNotifyEmp();
			fbBusInstNotifyEmp.setId(serialService.getUUID());//id
			fbBusInstNotifyEmp.setNotifyEmpId(signEmpId);
			fbBusInstNotifyEmp.setNotifyEmpName((String)empData.get("emp_name"));
			fbBusInstNotifyEmp.setNotifyOrgId((String)empData.get("org_id"));
			fbBusInstNotifyEmp.setNotifyOrgName((String)empData.get("org_name"));
			fbBusInstNotifyEmp.setCreateDateTime(cur_date);//会签时间
			fbBusInstNotifyEmp.setUpdateDateTime(cur_date);//更新时间
			fbBusInstNotifyEmp.setNotifyId(notifyId);//知会表id
			fbBusInstNotifyEmpMapper.insert(fbBusInstNotifyEmp);
		}
		
		if(signEmpIdArr!=null && signEmpIdArr.length>0){
			//获取到流程实例信息
	 		FbBusInst fbBusInst=fbBusInstMapper.selectByPrimaryKey((String) appMap.get("inst_id"));
			//待办人讯息通知
	   		 Map<String, Object> inforMap=new HashMap<String, Object>();
	   		 inforMap.put("title", "知会流程通知");
	   		 inforMap.put("content", "您有一个标题为《"+fbBusInst.getFbTitle()+"》的流程知会!");
	   		 inforMap.put("sender", systemEmpId);
	   		 inforMap.put("receiver", signEmpIds);
	   		 inforMap.put("category", "flowInfor");//类别(内部讯息(innerInfor) ,流程讯息(flowInfor), 公文讯息(docInfor), 公示讯息(pubInfor), 问卷讯息(askInfor), 日程讯息(dayInfor))
	   		 inforMap.put("bus_type", "FB06");//待办类型
	   		inforMap.put("bus_id", fbBusInst.getId());//实例id
	   		 Map<String, Object> busDomainMap=new HashMap<String, Object>();
	   		 ObjectMapper objMapper=new ObjectMapper();
	   		 busDomainMap.put("inst_id", fbBusInst.getId());//流程实例id
	   		 busDomainMap.put("task_id", (String) appMap.get("task_id"));//代办任务id
	   		 busDomainMap.put("cur_tag_id", (String) appMap.get("cur_tag_id"));//待办节点id
	   		 busDomainMap.put("cur_tag_name", (String) appMap.get("cur_tag_name"));//待办节点id
	   		 busDomainMap.put("category", "flowInfor");//类别(内部讯息(innerInfor) ,流程讯息(flowInfor), 公文讯息(docInfor), 公示讯息(pubInfor), 问卷讯息(askInfor), 日程讯息(dayInfor))
	   		 busDomainMap.put("bus_type", "FB06");//待办类型
	   		 String domainStr= objMapper.writeValueAsString(busDomainMap);
	   		 inforMap.put("bus_domain", domainStr);
	   		 runnableService.inforCall(inforMap);
		}
			
		return null;
	}
}
