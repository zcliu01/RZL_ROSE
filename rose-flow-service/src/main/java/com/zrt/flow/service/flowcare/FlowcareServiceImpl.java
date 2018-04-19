package com.zrt.flow.service.flowcare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.PageInit;
import com.zrt.commons.date.DateUtil;
import com.zrt.flow.domain.InstInfoDomain;
import com.zrt.flow.mapper.flowcare.FlowcareMapper;
import com.zrt.flow.service.act.ActProcessService;
import com.zrt.flow.service.contacts.ContactsService;
import com.zrt.flow.service.serial.SerialService;
import com.zrt.mybatis.domain.FbBusCare;
import com.zrt.mybatis.domain.FbBusCareExample;
import com.zrt.mybatis.domain.FbBusCareExample.Criteria;
import com.zrt.mybatis.mapper.FbBusCareMapper;

/**
 * 我的关注 Created by dwliu on 2017/9/21.
 */
@Service
public class FlowcareServiceImpl implements FlowcareService {

	@Autowired
	private FlowcareMapper flowcareMapper;
	@Autowired
	private FbBusCareMapper fbBusCareMapper;
	@Autowired
	private SerialService serialService;
	@Autowired
	private ActProcessService actProcessService;
	@Autowired
	private ContactsService contactsService;

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> flowcareList(Map<String, Object> appMap) throws Exception {
		PageInit.setPage(appMap);
		PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
				Integer.parseInt(appMap.get("maxResult").toString())).setReasonable(false);
		// 已办人是我
		if (StringUtils.isNotBlank((String) appMap.get("begin_start_date_time"))) {
			appMap.put("begin_start_date_time",
					((String) appMap.get("begin_start_date_time")).replace("-", "") + "000000");
		}
		if (StringUtils.isNotBlank((String) appMap.get("end_start_date_time"))) {
			appMap.put("end_start_date_time", ((String) appMap.get("end_start_date_time")).replace("-", "") + "235959");
		}
		appMap.put("care_emp_id", appMap.get("emp_id"));
		// 根据分页完的流程实例查询所有已办
		List<InstInfoDomain> listMap = flowcareMapper.flowcareList(appMap);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		PageInfo<InstInfoDomain> pageInfo = new PageInfo<InstInfoDomain>(listMap);
		for (InstInfoDomain inst : listMap) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("inst_id", inst.getInstId());// 流程实例id
			dataMap.put("apply_id", inst.getApplyId());
			dataMap.put("apply_name", inst.getApplyName());
			// 发起人头像
			Map<String, Object> applyEmpData = getEmpInfo(inst.getApplyId());
			dataMap.put("apply_emp_head_photo", applyEmpData.get("emp_head_photo"));
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
			dataMap.put("project_flag", inst.getProjectFlag());// 项目类
			dataMap.put("handle_flag", inst.getHandleFlag());// 流程签报类
			// 当前节点信息
			// List<TaskDomain> taskList= inst.getTaskList();//代办人列表
			List<Map<String, Object>> taskList = actProcessService.tagInfoList(inst.getInstId());
			List<Map<String, Object>> assList = new ArrayList<>();
			for (Map<String, Object> tk : taskList) {
				Map<String, Object> assigneeMap = new HashMap<String, Object>();
				assigneeMap.put("cur_tag_id", tk.get("cur_tag_id"));
				assigneeMap.put("cur_tag_name", tk.get("cur_tag_name"));
				assigneeMap.put("cur_tag_assignee", tk.get("cur_tag_assignee"));
				if (tk.get("cur_tag_assignee") != null && !"".equals(tk.get("cur_tag_assignee"))) {
					assigneeMap.put("cur_tag_assignee_name",
							getEmpInfo((String) tk.get("cur_tag_assignee")).get("emp_name"));
				} else {
					assigneeMap.put("cur_tag_assignee_name", null);

				}
				assList.add(assigneeMap);

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
	@Transactional(readOnly = true)
	public Map<String, Object> appFlowcareList(Map<String, Object> appMap) throws Exception {
		PageInit.setPage(appMap);
		PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
				Integer.parseInt(appMap.get("maxResult").toString())).setReasonable(false);
		// 已办人是我
		appMap.put("care_emp_id", appMap.get("emp_id"));
		// 根据分页完的流程实例查询所有已办
		if (StringUtils.isNotBlank((String) appMap.get("begin_start_date_time"))) {
			appMap.put("begin_start_date_time",
					((String) appMap.get("begin_start_date_time")).replace("-", "") + "000000");
		}
		if (StringUtils.isNotBlank((String) appMap.get("end_start_date_time"))) {
			appMap.put("end_start_date_time", ((String) appMap.get("end_start_date_time")).replace("-", "") + "235959");
		}
		List<InstInfoDomain> listMap = flowcareMapper.flowcareList(appMap);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		PageInfo<InstInfoDomain> pageInfo = new PageInfo<InstInfoDomain>(listMap);
		for (InstInfoDomain inst : listMap) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("inst_id", inst.getInstId());// 流程实例id
			dataMap.put("apply_id", inst.getApplyId());
			dataMap.put("apply_name", inst.getApplyName());
			// 发起人头像
			Map<String, Object> applyEmpData = getEmpInfo(inst.getApplyId());
			dataMap.put("apply_emp_head_photo", applyEmpData.get("emp_head_photo"));
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
			dataMap.put("project_flag", inst.getProjectFlag());// 项目类
			dataMap.put("handle_flag", inst.getHandleFlag());// 流程签报类
			// 当前节点信息
			// List<TaskDomain> taskList= inst.getTaskList();//代办人列表
			List<Map<String, Object>> taskList = actProcessService.tagInfoList(inst.getInstId());
			List<Map<String, Object>> assList = new ArrayList<>();
			for (Map<String, Object> tk : taskList) {
				Map<String, Object> assigneeMap = new HashMap<String, Object>();
				assigneeMap.put("cur_tag_id", tk.get("cur_tag_id"));
				assigneeMap.put("cur_tag_name", tk.get("cur_tag_name"));
				assigneeMap.put("cur_tag_assignee", tk.get("cur_tag_assignee"));
				assigneeMap.put("cur_tag_assignee_name",
						getEmpInfo((String) tk.get("cur_tag_assignee")).get("emp_name"));
				assList.add(assigneeMap);

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
	 * 关注
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	@Override
	public Map<String, Object> careSave(Map<String, Object> appMap) throws Exception {

		// 判断当前登录人是否关注过该实例节点
		FbBusCareExample example = new FbBusCareExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpIdEqualTo((String) appMap.get("emp_id"));// 当前登录人
		criteria.andInstIdEqualTo((String) appMap.get("inst_id"));// 流程发起id
		criteria.andInstTagEqualTo((String) appMap.get("care_tag_id"));// 流程节点id
		List<FbBusCare> fbCareList = fbBusCareMapper.selectByExample(example);// 该节点关注的列表
		if (fbCareList.isEmpty()) {
			// 说明没有关注过
			String curr_date = DateUtil.getCurrentDateTime();// 当前时间
			FbBusCare fbBusCare = new FbBusCare();
			fbBusCare.setId(serialService.getUUID());
			fbBusCare.setEmpId((String) appMap.get("emp_id"));// 登录人id
			fbBusCare.setInstId((String) appMap.get("inst_id"));
			fbBusCare.setInstTag((String) appMap.get("care_tag_id"));
			fbBusCare.setInstTagName((String) appMap.get("care_tag_name"));
			fbBusCare.setCreateDateTime(curr_date);
			fbBusCare.setUpdateDateTime(curr_date);
			fbBusCareMapper.insert(fbBusCare);
		}

		return null;
	}

	public Map<String, Object> getEmpInfo(String emp_id) {
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
	 * 取消关注
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> careCancle(Map<String, Object> appMap) throws Exception {
		FbBusCareExample example = new FbBusCareExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpIdEqualTo((String) appMap.get("emp_id"));// 当前登录人
		criteria.andInstIdEqualTo((String) appMap.get("inst_id"));// 流程发起id
		criteria.andInstTagEqualTo((String) appMap.get("care_tag_id"));// 流程节点id
		fbBusCareMapper.deleteByExample(example);
		return null;
	}
}
