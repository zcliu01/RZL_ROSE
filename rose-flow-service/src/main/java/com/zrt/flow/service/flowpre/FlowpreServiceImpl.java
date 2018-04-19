package com.zrt.flow.service.flowpre;

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
import com.zrt.flow.domain.TaskDomain;
import com.zrt.flow.mapper.flowpre.FlowpreCustomMapper;
import com.zrt.flow.service.act.ActProcessService;
import com.zrt.flow.service.contacts.ContactsService;
import com.zrt.flow.service.serial.SerialService;
import com.zrt.mybatis.domain.FbBusEntrust;
import com.zrt.mybatis.domain.FbBusPredeal;
import com.zrt.mybatis.domain.FbBusPredealExample;
import com.zrt.mybatis.domain.FbBusPredealExample.Criteria;
import com.zrt.mybatis.mapper.FbBusPredealMapper;

@Service
public class FlowpreServiceImpl implements FlowpreService {

	@Autowired
	private FlowpreCustomMapper flowpreMapper;
	@Autowired
	private FbBusPredealMapper fbBusPredealMapper;
	@Autowired
	private SerialService serialService;
	@Autowired
	private ContactsService contactsService;
	@Autowired
	private ActProcessService actProcessService;

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getMyPreList(Map<String, Object> appMap) throws Exception {
		PageInit.setPage(appMap);
		PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
				Integer.parseInt(appMap.get("maxResult").toString())).setReasonable(false);

		// 预处理人是我
		if (StringUtils.isNotBlank((String) appMap.get("cur_tag_assignee_id"))) {
			appMap.put("cur_tag_assignee", appMap.get("cur_tag_assignee_id"));
		}
		appMap.put("check_emp_id", appMap.get("emp_id"));
		List<InstInfoDomain> listMap = flowpreMapper.getMyPreList(appMap);

		PageInfo<InstInfoDomain> pageInfo = new PageInfo<InstInfoDomain>(listMap);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
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
			dataMap.put("project_flag", inst.getProjectFlag());// 项目表示
			dataMap.put("handle_flag", inst.getHandleFlag());// 签报类型
			dataMap.put("fb_title", inst.getFbTitle());
			dataMap.put("t_type_id", inst.gettTypeId());
			dataMap.put("t_type_name", inst.gettTypeName());
			dataMap.put("parent_t_type_id", inst.getParentTTypeId());
			dataMap.put("parent_t_type_name", inst.getParentTTypeName());
			dataMap.put("fb_content", inst.getFbContent());
			dataMap.put("inst_status", inst.getInstStatus());
			dataMap.put("start_date_time", inst.getStartDateTime());
			dataMap.put("id", inst.getPreId());// 预处理id
			dataMap.put("pre_tag_id", inst.getPreTagId());// 预处理节点id
			dataMap.put("pre_tag_name", inst.getPreTagName());// 预处理节点名称
			dataMap.put("pre_status", inst.getPreStatus());// 预处理状态
			// 当前节点信息
			List<TaskDomain> taskList = inst.getTaskList();// 代办人列表
			List<Map<String, Object>> assList = new ArrayList<>();
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
			if (null == assList || assList.isEmpty()) {
				continue;
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
	public Map<String, Object> getAppMyPreList(Map<String, Object> appMap) throws Exception {

		return getMyPreList(appMap);
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void deal(Map<String, Object> map) throws Exception {

		String empId = (String) map.get("emp_id");
		Map<String, Object> empMap = searchEmpMapByEmpId(empId);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> preTagList = (List<Map<String, Object>>) map.get("param");
		if (preTagList != null && preTagList.size() > 0) {
			for (Map<String, Object> tagMap : preTagList) {
				FbBusPredeal fbBusPredeal = new FbBusPredeal();
				fbBusPredeal.setId(serialService.getUUID());
				fbBusPredeal.setCheckEmpId(empId);
				fbBusPredeal.setCheckEmpName((String) empMap.get("emp_name"));
				fbBusPredeal.setOrgId((String) empMap.get("org_id"));
				fbBusPredeal.setOrgName((String) empMap.get("org_name"));
				fbBusPredeal.setCheckStatus((String) map.get("check_status"));
				fbBusPredeal.setCheckComment((String) map.get("check_comment"));
				fbBusPredeal.setInstId((String) tagMap.get("inst_id"));
				fbBusPredeal.setInstTag((String) tagMap.get("pre_tag_id"));
				fbBusPredeal.setInstTagName((String) tagMap.get("pre_tag_name"));
				fbBusPredeal.setCreateDateTime(DateUtil.getCurrentDateTime());
				fbBusPredeal.setRepeatFlag((String) map.get("repeat_flag"));
				fbBusPredeal.setPreStatus("0");

				fbBusPredealMapper.insert(fbBusPredeal);
			}
		}

	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void cancel(Map<String, Object> map) throws Exception {

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> preIdList = (List<Map<String, Object>>) map.get("param");
		if (preIdList != null && preIdList.size() > 0) {
			for (Map<String, Object> preIdMap : preIdList) {
				String preId = (String) preIdMap.get("id");
				fbBusPredealMapper.deleteByPrimaryKey(preId);
			}
		}
	}

	/**
	 * 根据员工ID获取员工的相关信息
	 */
	public Map<String, Object> searchEmpMapByEmpId(String empId) {

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("type", "0");
		resMap.put("search", empId);
		Map<String, Object> dataMap = contactsService.commonEmpSearch(resMap);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> empList = (List<Map<String, Object>>) dataMap.get("data");
		if (empList != null && empList.size() > 0) {
			Map<String, Object> empMap = empList.get(0);
			return empMap;
		} else {
			return null;
		}

	}

	/***
	 * 查询代办预处理列表
	 */
	@Override
	public Map<String, Object> instPreList(Map<String, Object> map) throws Exception {
		String assignee = (String) map.get("emp_id");// 登录人id
		map.put("check_emp_id", assignee);
		if (StringUtils.isNoneBlank((String) map.get("cur_tag_assignee_id"))) {
			map.put("cur_tag_assignee", map.get("cur_tag_assignee_id"));
		}
		// 获取代办预处理列表
		List<InstInfoDomain> preList = flowpreMapper.preList(map);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		for (InstInfoDomain inst : preList) {

			// 根据流程业务id，查询当前登录人是否委托过该流程
			List<FbBusEntrust> entList = inst.getEntList();
			// 该流程实例上面需要我审核的,
			List<String> assigneeList = new ArrayList<String>();
			if (entList != null && !entList.isEmpty()) {
				Boolean entSelfFlag = false;
				for (FbBusEntrust ent : entList) {
					// 先判断我是否委托过
					if (ent.getCheckEmpId().equals(assignee)) {
						entSelfFlag = true;
						break;
					}
				}

				if (!entSelfFlag) {// 说明没有委托
					// 没有委托，就只查询审批节点是我自己的
					assigneeList.add(assignee);
				}
				for (FbBusEntrust ent : entList) {
					if (ent.getEntEmpId().equals(assignee)) {// 说明我被委托过，我是该流程的受托人
						String oldEmpId = ent.getCheckEmpId();// 流程原审核人
						assigneeList.add(oldEmpId);
					}
				}
			} else {
				// 没有委托，就只查询审批节点是我自己的
				assigneeList.add(assignee);
			}
			// 预处理节点信息查询;如果是需要指定的节点就过滤掉
			List<Map<String, Object>> tagList = actProcessService.preSelfTagInfo(inst.getInstId());

			if (tagList.isEmpty()) {// 说明没有匹配的
				continue;
			}
			Boolean preFlag = false;
			for (Map<String, Object> preMap : tagList) {
				String act_assigne = (String) preMap.get("check_emp_id");// 预节点审批人
				for (String checkEmpId : assigneeList) {
					if (checkEmpId.equals(act_assigne)) {
						// 如果預處理節點有我待处理的则
						preFlag = true;
						break;
					}
				}
			}
			// 如果预处理节点没有我的待办，则跳过
			if (!preFlag) {
				continue;
			}
			Map<String, Object> preTag = (Map<String, Object>) tagList.get(0);
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("inst_id", inst.getInstId());
			dataMap.put("apply_id", inst.getApplyId());
			dataMap.put("apply_name", inst.getApplyName());
			// 发起人头像
			Map<String, Object> applyEmpData = getEmpInfo(inst.getApplyId());
			dataMap.put("apply_emp_head_photo", applyEmpData.get("emp_head_photo"));
			dataMap.put("org_id", inst.getOrgId());
			dataMap.put("org_name", inst.getOrgName());
			dataMap.put("t_code", inst.gettCode());
			dataMap.put("t_name", inst.gettName());
			dataMap.put("project_flag", inst.getProjectFlag());// 项目表示
			dataMap.put("handle_flag", inst.getHandleFlag());// 签报类型
			dataMap.put("fb_title", inst.getFbTitle());
			dataMap.put("t_type_id", inst.gettTypeId());
			dataMap.put("t_type_name", inst.gettTypeName());
			dataMap.put("parent_t_type_id", inst.getParentTTypeId());
			dataMap.put("parent_t_type_name", inst.getParentTTypeName());
			dataMap.put("fb_content", inst.getFbContent());
			dataMap.put("inst_status", inst.getInstStatus());
			dataMap.put("start_date_time", inst.getStartDateTime());
			// 当前节点信息
			List<TaskDomain> taskList = inst.getTaskList();// 代办人列表
			List<Map<String, Object>> assList = new ArrayList<>();
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
						}
					} else {
						assigneeMap.put("cur_tag_assignee_name", null);
					}
				} else {
					assigneeMap.put("cur_tag_assignee_name", null);

				}
				assList.add(assigneeMap);
			}
			if (null == assList || assList.isEmpty()) {
				continue;
			}
			dataMap.put("assignee_list", assList);
			// 预处理节点信息
			dataMap.put("pre_tag_id", preTag.get("inst_tag"));
			dataMap.put("pre_tag_name", preTag.get("inst_tag"));
			dataMap.put("pre_tag_assignee", preTag.get("check_emp_id"));
			dataMap.put("id", "");// 预处理表id
			dataMap.put("pre_check_status", "0");// 预处理设置状态(0:未设置,1:已设置)
			dataMap.put("pre_status", "0");// 预处理状态(0:未处理,1:已处理),预处理查询此时都还是0

			// 判断是否预处理过这个这个流程实例
			FbBusPredealExample example = new FbBusPredealExample();
			Criteria criteria = example.createCriteria();
			criteria.andCheckEmpIdEqualTo(assignee);
			criteria.andInstIdEqualTo(inst.getInstId());
			List<FbBusPredeal> preDealList = fbBusPredealMapper.selectByExample(example);
			if (!preDealList.isEmpty()) {
				continue;
				// 已存在
				// FbBusPredeal fbBusPredeal =preDealList.get(0);
				// dataMap.put("id", fbBusPredeal.getId());
				// dataMap.put("pre_check_status", "1");//预处理设置状态(0:未设置,1:已设置)
				// dataMap.put("pre_status",
				// "0");//预处理状态(0:未处理,1:已处理),预处理查询此时都还是0
			}

			dataList.add(dataMap);

		}

		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", dataList);
		resMap.put("data", dataMap);
		resMap.put("count", dataList.size());
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
