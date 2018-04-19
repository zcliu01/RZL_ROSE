package com.zrt.flow.service.flowoper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.PageInit;
import com.zrt.flow.domain.InstInfoDomain;
import com.zrt.flow.domain.TaskDomain;
import com.zrt.flow.mapper.flowoper.FlowoperMapper;
import com.zrt.flow.service.contacts.ContactsService;
import com.zrt.mybatis.domain.FbBusHandle;
import com.zrt.mybatis.domain.FbBusHandleExample;
import com.zrt.mybatis.mapper.FbBusHandleMapper;

@Service("flowoperServiceImp")
public class FlowoperServiceImp implements FlowoperService {
	private static final Logger log = LoggerFactory.getLogger(FlowoperServiceImp.class);

	@Autowired
	private ContactsService contactsService;

	@Autowired
	private FlowoperMapper flowoperMapper;

	@Autowired
	private FbBusHandleMapper fbBusHandleMapper;

	/***
	 * 所有的流程实例
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> flowList(Map<String, Object> appMap) throws Exception {
		PageInit.setPage(appMap);
		// PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
		// Integer.parseInt(appMap.get("maxResult").toString())).setReasonable(false);
		// 查询所有的实例列表
		if (StringUtils.isNotBlank((String) appMap.get("begin_start_date_time"))) {
			appMap.put("begin_start_date_time",
					(((String) appMap.get("begin_start_date_time")).replace("-", "")) + "000000");
		}
		if (StringUtils.isNotBlank((String) appMap.get("end_start_date_time"))) {
			appMap.put("end_start_date_time", ((String) appMap.get("end_start_date_time")).replace("-", "") + "235959");
		}
		List<InstInfoDomain> listMap = flowoperMapper.instList(appMap);
		// Map<String, Object> totalCountMap =
		// flowoperMapper.instListCount(appMap);
		List<InstInfoDomain> instListCount = flowoperMapper.instCount(appMap);
		// PageInfo<InstInfoDomain> pageInfo = new
		// PageInfo<InstInfoDomain>(listMap);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		for (InstInfoDomain inst : listMap) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("inst_id", inst.getInstId());// 流程实例id
			dataMap.put("apply_id", inst.getApplyId());
			dataMap.put("apply_name", inst.getApplyName());
			dataMap.put("org_id", inst.getOrgId());
			dataMap.put("org_name", inst.getOrgName());
			// 发起人头像
			Map<String, Object> applyEmpData = getEmpInfo(inst.getApplyId());
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
			dataMap.put("handle_flag", inst.getHandleFlag());
			dataMap.put("project_flag", inst.getProjectFlag());
			// 当前节点信息
			String assigneeNames = "";
			List<TaskDomain> taskList = inst.getTaskList();// 代办人列表
			List<Map<String, Object>> assList = new ArrayList<>();
			if ("0".equals(inst.getHandleFlag())) {
				for (TaskDomain tk : taskList) {
					Map<String, Object> assigneeMap = new HashMap<String, Object>();
					assigneeMap.put("cur_tag_id", tk.getCurTagId());
					assigneeMap.put("cur_tag_name", tk.getCurTagName());
					assigneeMap.put("cur_tag_assignee", tk.getCurTagAssignee());
					if (tk.getCurTagAssignee() != null && !"".equals(tk.getCurTagAssignee())) {
						Map<String, Object> empMap = getEmpInfo(tk.getCurTagAssignee());
						if (!empMap.isEmpty() && null != empMap) {
							String assigneeName = (String) empMap.get("emp_name");
							if (StringUtils.isNotBlank(assigneeName)) {
								assigneeMap.put("cur_tag_assignee_name", assigneeName);
								assigneeNames = assigneeName + ";";
							}
						} else {
							assigneeMap.put("cur_tag_assignee_name", null);
						}
					} else {
						assigneeMap.put("cur_tag_assignee_name", null);

					}
					assList.add(assigneeMap);

				}
			} else if ("1".equals(inst.getHandleFlag())) {
				// 查询签报类代办人
				FbBusHandleExample handleExample = new FbBusHandleExample();
				com.zrt.mybatis.domain.FbBusHandleExample.Criteria handleCriteria = handleExample.createCriteria();
				handleCriteria.andInstIdEqualTo(inst.getInstId());
				handleCriteria.andHandleStatusEqualTo("0");// 未签报的
				List<FbBusHandle> handleList = fbBusHandleMapper.selectByExample(handleExample);
				for (FbBusHandle handle : handleList) {
					Map<String, Object> assigneeMap = new HashMap<String, Object>();
					assigneeMap.put("cur_tag_id", null);
					assigneeMap.put("cur_tag_name", null);
					assigneeMap.put("cur_tag_assignee", handle.getHandleEmpId());
					assigneeMap.put("cur_tag_assignee_name", handle.getHandleEmpName());
					assList.add(assigneeMap);
				}
			}
			dataMap.put("assignee_list", assList);
			if (assigneeNames.endsWith(";")) {
				assigneeNames = assigneeNames.substring(0, assigneeNames.length() - 1);
			}
			dataMap.put("cur_tag_assignee_names", assigneeNames);
			dataList.add(dataMap);
		}

		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", dataList);
		resMap.put("data", dataMap);
		// resMap.put("count", totalCountMap.get("totalCount"));
		resMap.put("count", instListCount.size());
		return resMap;
	}

	/***
	 * 所有的委托流程
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> entrustList(Map<String, Object> appMap) throws Exception {
		PageInit.setPage(appMap);
		PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
				Integer.parseInt(appMap.get("maxResult").toString())).setReasonable(false);
		// 查询所有的实例列表
		List<Map<String, Object>> listMap = flowoperMapper.entedList(appMap);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(listMap);
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", listMap);
		resMap.put("data", dataMap);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	/**
	 * 所有的预处理列表
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> preList(Map<String, Object> appMap) throws Exception {
		if (StringUtils.isNotBlank((String) appMap.get("begin_start_date_time"))) {
			appMap.put("begin_start_date_time", ((String) appMap.get("begin_start_date_time")).replace("-", ""));
		}
		if (StringUtils.isNotBlank((String) appMap.get("end_start_date_time"))) {
			appMap.put("end_start_date_time", ((String) appMap.get("end_start_date_time")).replace("-", ""));
		}
		if (StringUtils.isNoneBlank((String) appMap.get("cur_tag_assignee_id"))) {
			appMap.put("cur_tag_assignee", appMap.get("cur_tag_assignee_id"));
		}
		PageInit.setPage(appMap);
		PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
				Integer.parseInt(appMap.get("maxResult").toString())).setReasonable(false);
		// 查询所有的实例列表
		// 当前登录人已办
		// appMap.put("check_emp_id", appMap.get("emp_id"));
		List<InstInfoDomain> listMap = flowoperMapper.preList(appMap);
		PageInfo<InstInfoDomain> pageInfo = new PageInfo<InstInfoDomain>(listMap);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		for (InstInfoDomain inst : listMap) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("inst_id", inst.getInstId());// 流程实例id
			dataMap.put("apply_id", inst.getApplyId());
			dataMap.put("apply_name", inst.getApplyName());
			dataMap.put("org_id", inst.getOrgId());
			dataMap.put("org_name", inst.getOrgName());
			// 发起人头像
			Map<String, Object> applyEmpData = getEmpInfo(inst.getApplyId());
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
			// 预处理人信息
			dataMap.put("predeal_id", inst.getPredealId());
			dataMap.put("predeal_name", inst.getPredealName());
			dataMap.put("pre_id", inst.getPreId());
			// 当前节点信息
			List<TaskDomain> taskList = inst.getTaskList();// 代办人列表
			List<Map<String, Object>> assList = new ArrayList<>();
			if ("0".equals(inst.getHandleFlag())) {
				for (TaskDomain tk : taskList) {
					Map<String, Object> assigneeMap = new HashMap<String, Object>();
					assigneeMap.put("cur_tag_id", tk.getCurTagId());
					assigneeMap.put("cur_tag_name", tk.getCurTagName());
					assigneeMap.put("cur_tag_assignee", tk.getCurTagAssignee());
					if (tk.getCurTagAssignee() != null && !"".equals(tk.getCurTagAssignee())) {
						assigneeMap.put("cur_tag_assignee_name", getEmpInfo(tk.getCurTagAssignee()).get("emp_name"));
					} else {
						assigneeMap.put("cur_tag_assignee_name", null);

					}
					assList.add(assigneeMap);

				}
			} else if ("1".equals(inst.getHandleFlag())) {
				// 查询签报类代办人
				FbBusHandleExample handleExample = new FbBusHandleExample();
				com.zrt.mybatis.domain.FbBusHandleExample.Criteria handleCriteria = handleExample.createCriteria();
				handleCriteria.andInstIdEqualTo(inst.getInstId());
				handleCriteria.andHandleStatusEqualTo("0");// 未签报的
				List<FbBusHandle> handleList = fbBusHandleMapper.selectByExample(handleExample);
				for (FbBusHandle handle : handleList) {
					Map<String, Object> assigneeMap = new HashMap<String, Object>();
					assigneeMap.put("cur_tag_id", null);
					assigneeMap.put("cur_tag_name", null);
					assigneeMap.put("cur_tag_assignee", handle.getHandleEmpId());
					assigneeMap.put("cur_tag_assignee_name", handle.getHandleEmpName());
					assList.add(assigneeMap);
				}
			}
			dataMap.put("assignee_list", assList);
			if (null != assList && !assList.isEmpty()) {
				dataList.add(dataMap);
			}
		}
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", dataList);
		resMap.put("data", dataMap);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	public Map<String, Object> getEmpInfo(String emp_id) {
		Map<String, Object> conmap = new HashMap<>();
		conmap.put("search", emp_id);
		Map<String, Object> result = contactsService.commonEmpSearch(conmap);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> li = (List<Map<String, Object>>) result.get("data");
		Map<String, Object> data = new HashMap<String, Object>();
		if (null != li && li.size() > 0) {
			data = li.get(0);
		}
		return data;
	}

}
