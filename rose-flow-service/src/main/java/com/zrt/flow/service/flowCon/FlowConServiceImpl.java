package com.zrt.flow.service.flowCon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zrt.commons.date.DateUtil;
import com.zrt.flow.service.runnable.RunnableService;
import com.zrt.flow.service.serial.SerialService;
import com.zrt.mybatis.domain.FbBusAddFile;
import com.zrt.mybatis.domain.FbBusAddFileExample;
import com.zrt.mybatis.domain.FbBusAddRelevance;
import com.zrt.mybatis.domain.FbBusAddRelevanceExample;
import com.zrt.mybatis.domain.FbBusCheck;
import com.zrt.mybatis.domain.FbBusCondition;
import com.zrt.mybatis.domain.FbBusInst;
import com.zrt.mybatis.mapper.FbBusAddFileMapper;
import com.zrt.mybatis.mapper.FbBusAddRelevanceMapper;
import com.zrt.mybatis.mapper.FbBusCheckMapper;
import com.zrt.mybatis.mapper.FbBusConditionMapper;
import com.zrt.mybatis.mapper.FbBusInstMapper;

@Service
public class FlowConServiceImpl implements FlowConService {

	@Autowired
	private FbBusConditionMapper fbBusConditionMapper;
	@Autowired
	private FbBusAddFileMapper fbBusAddFileMapper;
	@Autowired
	private FbBusAddRelevanceMapper fbBusAddRelevanceMapper;
	@Autowired
	private SerialService serialService;
	@Autowired
	private FbBusCheckMapper fbBusCheckMapper;
	@Autowired
	private FbBusInstMapper fbBusInstMapper;
    @Value("${im.notify.sender_id}")
	private String systemEmpId;
    @Autowired
	private RunnableService runnableService;
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void res(Map<String, Object> map) throws Exception {

		String conId = (String) map.get("con_id");
		FbBusCondition con = fbBusConditionMapper.selectByPrimaryKey(conId);
		con.setResContent((String) map.get("res_content"));
		con.setResDateTime(DateUtil.getCurrentDateTime());
		con.setConStatus("2");
		fbBusConditionMapper.updateByPrimaryKeySelective(con);

		// 获取上次添加的附件并删除
		FbBusAddFileExample example = new FbBusAddFileExample();
		example.createCriteria().andConIdEqualTo(conId).andConTypeEqualTo("1");
		List<FbBusAddFile> fileList = fbBusAddFileMapper.selectByExample(example);
		if (fileList != null && fileList.size() > 0) {
			for (FbBusAddFile file : fileList) {
				fbBusAddFileMapper.deleteByPrimaryKey(file.getId());
			}
		}
		// 添加新的附件
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> newFileList = (List<Map<String, Object>>) map.get("file");
		if (newFileList != null && newFileList.size() > 0) {
			for (Map<String, Object> fileMap : newFileList) {
				String fileUrl = (String) fileMap.get("file_url");
				String fileName = (String) fileMap.get("file_name");
				String fileType = (String) fileMap.get("file_type");
				FbBusAddFile file = new FbBusAddFile();
				file.setId(serialService.getUUID());
				file.setConId(conId);
				file.setConType("1");
				file.setCreateDateTime(DateUtil.getCurrentDateTime());
				file.setFileName(fileName);
				file.setFileType(fileType);
				file.setFileUrl(fileUrl);
				fbBusAddFileMapper.insert(file);
			}
		}
		// 获取上次添加的关联信息并删除
		FbBusAddRelevanceExample relExample = new FbBusAddRelevanceExample();
		example.createCriteria().andConIdEqualTo(conId).andConTypeEqualTo("1");
		List<FbBusAddRelevance> relList = fbBusAddRelevanceMapper.selectByExample(relExample);
		if (fileList != null && fileList.size() > 0) {
			for (FbBusAddRelevance rel : relList) {
				fbBusAddRelevanceMapper.deleteByPrimaryKey(rel.getId());
			}
		}
		// 添加新的关联信息
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> newRelList = (List<Map<String, Object>>) map.get("rel");
		if (newRelList != null && newRelList.size() > 0) {
			for (Map<String, Object> relMap : newRelList) {
				String relId = (String) relMap.get("rel_id");
				String relName = (String) relMap.get("rel_name");
				String relType = (String) relMap.get("rel_type");
				FbBusAddRelevance rel = new FbBusAddRelevance();
				rel.setId(serialService.getUUID());
				rel.setConId(conId);
				rel.setConType("1");
				rel.setCreateDateTime(DateUtil.getCurrentDateTime());
				rel.setRelName(relName);
				rel.setRelType(relType);
				rel.setRelId(relId);
				fbBusAddRelevanceMapper.insert(rel);
			}
		}
		
		
		//附条件回复通知审核人
		String inst_id =con.getInstId();
		//获取审核人信息
		String check_id=con.getCheckId();
		FbBusCheck fbBusCheck=fbBusCheckMapper.selectByPrimaryKey(check_id);
		//获取到流程实例信息
 		FbBusInst fbBusInst=fbBusInstMapper.selectByPrimaryKey(inst_id);
		//待办人讯息通知
   		 Map<String, Object> inforMap=new HashMap<String, Object>();
   		 inforMap.put("title", "附条件回复流程通知");
   		 inforMap.put("content", "您有一个标题为《"+fbBusInst.getFbTitle()+"》的流程附条件回复!");
   		 inforMap.put("sender", systemEmpId);
   		 inforMap.put("receiver", fbBusCheck.getCheckEmpId());//通知人
   		 inforMap.put("category", "flowInfor");//类别(内部讯息(innerInfor) ,流程讯息(flowInfor), 公文讯息(docInfor), 公示讯息(pubInfor), 问卷讯息(askInfor), 日程讯息(dayInfor))
   		 inforMap.put("bus_type", "FB05");//待办类型
   		 inforMap.put("bus_id", fbBusCheck.getInstId());//待办类型
   		 Map<String, Object> busDomainMap=new HashMap<String, Object>();
   		 ObjectMapper objMapper=new ObjectMapper();
   		 busDomainMap.put("inst_id", fbBusInst.getId());//流程实例id
   		 busDomainMap.put("task_id", null);//代办任务id
   		 busDomainMap.put("cur_tag_id", null);//待办节点id
   		 busDomainMap.put("cur_tag_name", null);//待办节点id
   		 busDomainMap.put("category", "flowInfor");//类别(内部讯息(innerInfor) ,流程讯息(flowInfor), 公文讯息(docInfor), 公示讯息(pubInfor), 问卷讯息(askInfor), 日程讯息(dayInfor))
   		 busDomainMap.put("bus_type", "FB05");//待办类型
   		 String domainStr= objMapper.writeValueAsString(busDomainMap);
   		 inforMap.put("bus_domain", domainStr);
   		 runnableService.inforCall(inforMap);

	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void confirm(Map<String, Object> map) throws Exception {

		String conId = (String) map.get("con_id");
		FbBusCondition con = fbBusConditionMapper.selectByPrimaryKey(conId);
		con.setConStatus((String) map.get("con_status"));
		con.setRevDateTime(DateUtil.getCurrentDateTime());
		fbBusConditionMapper.updateByPrimaryKeySelective(con);

		
		//附条件审核通知发起人
		//条件复核结果
		String con_status=(String) map.get("con_status");
		String conStatusStr=null;
		if("1".equals(con_status)){
			conStatusStr="符合";
		}else{
			conStatusStr="不符合";
		}
		String inst_id =con.getInstId();
		//获取到流程实例信息
 		FbBusInst fbBusInst=fbBusInstMapper.selectByPrimaryKey(inst_id);
		//待办人讯息通知
   		 Map<String, Object> inforMap=new HashMap<String, Object>();
   		 inforMap.put("title", "附条件复核意见流程通知");
   		 inforMap.put("content", "您有一个标题为《"+fbBusInst.getFbTitle()+"》的流程附条件复核，复核结果："+conStatusStr);
   		 inforMap.put("sender", systemEmpId);
   		 inforMap.put("receiver", fbBusInst.getApplyId());
   		 inforMap.put("category", "flowInfor");//类别(内部讯息(innerInfor) ,流程讯息(flowInfor), 公文讯息(docInfor), 公示讯息(pubInfor), 问卷讯息(askInfor), 日程讯息(dayInfor))
   		 inforMap.put("bus_type", "FB05");//待办类型
   		inforMap.put("bus_id", fbBusInst.getId());//实例id
   		 Map<String, Object> busDomainMap=new HashMap<String, Object>();
   		 ObjectMapper objMapper=new ObjectMapper();
   		 busDomainMap.put("inst_id", fbBusInst.getId());//流程实例id
   		 busDomainMap.put("task_id", null);//代办任务id
   		 busDomainMap.put("cur_tag_id", null);//待办节点id
   		 busDomainMap.put("cur_tag_name", null);//待办节点id
   		 busDomainMap.put("category", "flowInfor");//类别(内部讯息(innerInfor) ,流程讯息(flowInfor), 公文讯息(docInfor), 公示讯息(pubInfor), 问卷讯息(askInfor), 日程讯息(dayInfor))
   		 busDomainMap.put("bus_type", "FB05");//待办类型
   		 String domainStr= objMapper.writeValueAsString(busDomainMap);
   		 inforMap.put("bus_domain", domainStr);
   		 runnableService.inforCall(inforMap);
	}

}
