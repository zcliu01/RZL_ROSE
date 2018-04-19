package com.zrt.flow.service.flowself;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.PageInit;
import com.zrt.commons.cons.Constants;
import com.zrt.commons.date.DateUtil;
import com.zrt.flow.domain.InstInfoDomain;
import com.zrt.flow.domain.TaskDomain;
import com.zrt.flow.mapper.flowself.FlowselfMapper;
import com.zrt.flow.service.act.ActProcessService;
import com.zrt.flow.service.contacts.ContactsService;
import com.zrt.flow.service.process.ProcessCommonService;
import com.zrt.flow.service.redis.RedisService;
import com.zrt.flow.service.runnable.RunnableService;
import com.zrt.mybatis.domain.FbBusCheck;
import com.zrt.mybatis.domain.FbBusCheckExample;
import com.zrt.mybatis.domain.FbBusHandle;
import com.zrt.mybatis.domain.FbBusHandleExample;
import com.zrt.mybatis.domain.FbBusJoinSign;
import com.zrt.mybatis.domain.FbBusJoinSignExample;
import com.zrt.mybatis.mapper.FbBusCheckMapper;
import com.zrt.mybatis.mapper.FbBusHandleMapper;
import com.zrt.mybatis.mapper.FbBusJoinSignMapper;

@Service("flowselfServiceImp")
public class FlowselfServiceImp implements FlowselfService {
	private static final Logger log = LoggerFactory.getLogger(FlowselfServiceImp.class);

	@Autowired
	private FbBusJoinSignMapper fbBusJoinSignMapper;

	@Autowired
	private FlowselfMapper flowselfMapper;
	@Autowired
	private FbBusCheckMapper fbBusCheckMapper;

	@Autowired
	private ContactsService contactsService;

	@Autowired
	private ProcessCommonService processCommonService;
	@Autowired
	private ActProcessService actProcessService;
	@Autowired
	private RunnableService runnableService;
	@Autowired
	private FbBusHandleMapper fbBusHandleMapper;
	@Autowired
	private RedisService redisService;

	/***
	 * 我发起所有的流程实例
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> selfApply(Map<String, Object> appMap) throws Exception {
		PageInit.setPage(appMap);
		// PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
		// Integer.parseInt(appMap.get("maxResult").toString())).setReasonable(false);
		// 查询所有的实例列表
		// 发起人是我
		appMap.put("apply_id", appMap.get("emp_id"));
		List<InstInfoDomain> listMap = flowselfMapper.instList(appMap);
		Map<String, Object> countMap = flowselfMapper.instListCount(appMap);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		PageInfo<InstInfoDomain> pageInfo = new PageInfo<InstInfoDomain>(listMap);
		for (InstInfoDomain inst : listMap) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("inst_id", inst.getInstId());// 流程实例id
			dataMap.put("apply_id", inst.getApplyId());
			dataMap.put("apply_name", inst.getApplyName());
			dataMap.put("org_id", inst.getOrgId());
			dataMap.put("org_name", inst.getOrgName());
			// 发起人头像
			if ("app".equals((String) appMap.get("reqType"))) {
				Map<String, Object> applyEmpData = getEmpInfo(inst.getApplyId());
				String headPhoto = (String) applyEmpData.get("emp_head_photo");
				if (StringUtils.isNotBlank(headPhoto)) {
					dataMap.put("apply_emp_head_photo", headPhoto);
				} else {
					dataMap.put("apply_emp_head_photo", "");
				}
			}
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
			dataList.add(dataMap);
		}
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", dataList);
		resMap.put("data", dataMap);
		resMap.put("count", countMap.get("totalCount"));
		return resMap;
	}

	/***
	 * 我的待办
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> selfDoList(Map<String, Object> appMap) throws Exception {
		PageInit.setPage(appMap);
		PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
				Integer.parseInt(appMap.get("maxResult").toString())).setReasonable(false);
		// 查询我的待办
		// 当前待办人是我
		appMap.put("cur_tag_assignee", appMap.get("emp_id"));
		List<Map<String, Object>> listMap = flowselfMapper.selfDoList(appMap);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(listMap);
		for (Map<String, Object> inst : listMap) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("inst_id", inst.get("inst_id"));// 流程实例id
			dataMap.put("t_code", inst.get("inst_t_code"));// 流程编号
			dataMap.put("t_name", inst.get("inst_t_name"));// 流程名称
			dataMap.put("project_flag", inst.get("inst_project_flag"));// 项目类
			dataMap.put("handle_flag", inst.get("inst_handle_flag"));// 流程签报类
			dataMap.put("org_id", inst.get("inst_org_id"));// 流程编号
			dataMap.put("org_name", inst.get("inst_org_name"));// 流程名称
			dataMap.put("fb_title", inst.get("inst_fb_title"));// 流程标题
			dataMap.put("t_type_id", inst.get("inst_t_type_id"));// 一级分类名称
			dataMap.put("t_type_name", inst.get("inst_t_type_name"));// 二级分类名称
			dataMap.put("parent_t_type_id", inst.get("inst_parent_t_type_id"));// 二级分类
			dataMap.put("parent_t_type_name", inst.get("inst_parent_t_type_name"));// 一级分类
			dataMap.put("apply_id", inst.get("inst_apply_id"));// 申请人id
			dataMap.put("apply_name", inst.get("inst_apply_name"));// 申请人姓名
			// 发起人头像
			if ("app".equals((String) appMap.get("reqType"))) {
				Map<String, Object> applyEmpData = getEmpInfo((String) inst.get("inst_apply_id"));
				String headPhoto = (String) applyEmpData.get("emp_head_photo");
				if (StringUtils.isNotBlank(headPhoto)) {
					dataMap.put("apply_emp_head_photo", headPhoto);
				} else {
					dataMap.put("apply_emp_head_photo", "");
				}
			}
			dataMap.put("cur_tag_id", inst.get("tk_cur_tag_id"));// 当前节点id
			dataMap.put("cur_tag_name", inst.get("tk_cur_tag_name"));// 当前节点名称
			dataMap.put("apply_tag_id", inst.get("inst_apply_tag_id"));// 当前节点id
			dataMap.put("apply_tag_name", inst.get("inst_apply_tag_name"));// 当前节点名称
			dataMap.put("start_date_time", inst.get("inst_start_date_time"));// 开始时间
			dataMap.put("fb_content", inst.get("inst_fb_content"));// 内容

			// 如果当前待办会签出去了，显示为协作中（inst_status:8）；所有会签结束后，显示为协作结束（inst_status:9）
			String instStatus = (String) inst.get("inst_status");
			if (!"1".equals(inst.get("inst_handle_flag"))) {
				String curEmpId = (String) appMap.get("emp_id");
				String instId = (String) inst.get("inst_id");
				String tagId = (String) inst.get("tk_cur_tag_id");
				FbBusCheckExample checkExample = new FbBusCheckExample();
				checkExample.createCriteria().andInstIdEqualTo(instId).andCheckEmpIdEqualTo(curEmpId)
						.andInstTagEqualTo(tagId).andCheckTypeEqualTo("4");
				List<FbBusCheck> checkList = fbBusCheckMapper.selectByExample(checkExample);
				if (null != checkList && !checkList.isEmpty()) {
					String checkId = checkList.get(0).getId();
					FbBusJoinSignExample signExample = new FbBusJoinSignExample();
					signExample.createCriteria().andCheckIdEqualTo(checkId);
					List<FbBusJoinSign> signList = fbBusJoinSignMapper.selectByExample(signExample);
					if (null != signList && !signList.isEmpty()) {
						for (FbBusJoinSign sign : signList) {
							String signCheckStatus = sign.getCheckStatus();
							if (!"1".equals(signCheckStatus)) {
								dataMap.put("inst_status", "8");// 流程状态(0:草稿,1:审核中,2:已审核,3,已发起,8,协作中，9协作完成)
								break;
							} else {
								dataMap.put("inst_status", "9");// 流程状态(0:草稿,1:审核中,2:已审核,3,已发起,8,协作中，9协作完成)
							}
						}

					}
				} else {
					dataMap.put("inst_status", instStatus);// 流程状态(0:草稿,1:审核中,2:已审核,3,已发起,8,协作中，9协作完成)
				}
			} else {
				dataMap.put("inst_status", instStatus);// 流程状态(0:草稿,1:审核中,2:已审核,3,已发起,8,协作中，9协作完成)
			}

			dataMap.put("check_type", inst.get("check_type"));// 待办类型（0：普通，1：会签）
			dataMap.put("sign_id", inst.get("sign_id"));// 会签id
			dataMap.put("task_id", inst.get("tk_task_id"));// 待办任务id
			dataMap.put("handle_id", inst.get("handle_id"));// 签报id
			dataList.add(dataMap);
		}
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 过滤筛选条件（1审核中；3：已发起；8协作中；9协作完成）
		String reqInstStatus = (String) appMap.get("req_inst_status");
		List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
		if (StringUtils.isNotBlank(reqInstStatus) && null != dataList && !dataList.isEmpty()) {
			for (Map<String, Object> inMap : dataList) {
				String instStatus = (String) inMap.get("inst_status");
				if ("1".equals(reqInstStatus) && "1".equals(instStatus)) {//审核中
					resList.add(inMap);
				}
				if ("3".equals(reqInstStatus) && "3".equals(instStatus)) {//已发起
					resList.add(inMap);
				}
				if ("8".equals(reqInstStatus) && "8".equals(instStatus)) {//协作中
					resList.add(inMap);
				}
				if ("9".equals(reqInstStatus) && "9".equals(instStatus)) {//协作完成
					resList.add(inMap);
				}
			}

			dataMap.put("list", resList);
			resMap.put("data", dataMap);
			resMap.put("count", resList.size());
		} else {

			dataMap.put("list", dataList);
			resMap.put("data", dataMap);
			resMap.put("count", pageInfo.getTotal());
		}

		return resMap;
	}

	/**
	 * 会签审批
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	@Override
	public Map<String, Object> selfSign(Map<String, Object> appMap) throws Exception {
		// 会签id
		List<Map<String, Object>> paramList = (List<Map<String, Object>>) appMap.get("param");
		// 会签意见
		String check_comment = (String) appMap.get("check_comment");
		for (Map<String, Object> map : paramList) {
			// 会签id
			FbBusJoinSign fbBusJoinSign = fbBusJoinSignMapper.selectByPrimaryKey((String) map.get("sign_id"));
			fbBusJoinSign.setCheckDateTime(DateUtil.getCurrentDateTime());// 会签时间
			fbBusJoinSign.setUpdateDateTime(DateUtil.getCurrentDateTime());// 更新时间
			fbBusJoinSign.setSignStatus("1");// 已会签
			fbBusJoinSign.setCheckComment(check_comment);// 会签意见
			fbBusJoinSign.setCheckStatus("1");// 暂时会签的都先填1，会签审核状态(0:拒绝,1:同意)
			fbBusJoinSignMapper.updateByPrimaryKey(fbBusJoinSign);
		}

		return null;
	}

	/**
	 * 批量审批
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	@Override
	public Map<String, Object> check(Map<String, Object> appMap) throws Exception {
		// 待办实例
		List<Map<String, Object>> paramList = (List<Map<String, Object>>) appMap.get("param");
		// 审批意见
		String check_comment = (String) appMap.get("check_comment");
		// 审批结果审核状态(0:拒绝,1:同意)
		String check_status = (String) appMap.get("check_status");
		// 是否规避审批
		String repeat_flag = (String) appMap.get("repeat_flag");
		String cur_date = DateUtil.getCurrentDateTime();
		for (Map<String, Object> map : paramList) {
			map.put("repeat_flag", repeat_flag);
			map.put("check_status", check_status);
			map.put("check_comment", check_comment);
			map.put("check_type", Constants.CHECK_TYPE_0);
			map.put("emp_id", appMap.get("emp_id"));
			map.put("check_date_time", cur_date);
			map.put("read_date_time", cur_date);
			processCommonService.commonCheck(map, null);

			// 已阅消息通知
			Map<String, Object> readInforMap = new HashMap<String, Object>();
			readInforMap.put("bus_id", (String) map.get("inst_id"));
			readInforMap.put("bus_domain", (String) map.get("task_id"));
			runnableService.sendReadInfor(readInforMap);
		}
		return null;
	}

	/**
	 * 我已办
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> selfHasDoList(Map<String, Object> appMap) throws Exception {
		PageInit.setPage(appMap);
		PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
				Integer.parseInt(appMap.get("maxResult").toString())).setReasonable(false);
		// 已办人是我
		appMap.put("check_emp_id", appMap.get("emp_id"));
		// 查询我的已办所有实例分页
		// List<Map<String, Object>>
		// listMapByPage=flowselfMapper.selfHasDoListByPage(appMap);
		// 根据分页完的流程实例查询所有已办
		List<Map<String, Object>> listMap = flowselfMapper.selfHasDoList(appMap);
		for (int i = 0; i < listMap.size() - 1; i++) {
			for (int j = listMap.size() - 1; j > i; j--) {
				if (listMap.get(j).get("inst_id").equals(listMap.get(i).get("inst_id"))) {
					listMap.remove(j);
				}
			}
		}
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(listMap);

		for (Map<String, Object> inst : listMap) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("inst_id", inst.get("inst_id"));// 流程实例id
			dataMap.put("apply_id", inst.get("inst_apply_id"));
			dataMap.put("apply_name", inst.get("inst_apply_name"));
			dataMap.put("org_id", inst.get("inst_org_id"));
			dataMap.put("org_name", inst.get("inst_org_name"));
			// 发起人头像
			if ("app".equals((String) appMap.get("reqType"))) {
				// 获取redis中员工信息
				// Map<String, Object> empdataMap = redisService.getRedis();
				// String headPhoto = "";
				// @SuppressWarnings("unchecked")
				// List<Map<String, Object>> empList = (List<Map<String,
				// Object>>)
				// empdataMap.get("empInfoList");
				// for (Map<String, Object> empMap : empList) {
				// for (String key : empMap.keySet()) {
				// if (((String) inst.get("inst_apply_id")).equals(key)) {
				// headPhoto = (String) ((Map<String, Object>)
				// empMap.get(key)).get("emp_head_photo");
				// }
				// }
				// }

				Map<String, Object> applyEmpData = getEmpInfo((String) inst.get("inst_apply_id"));
				String headPhoto = (String) applyEmpData.get("emp_head_photo");
				if (StringUtils.isNotBlank(headPhoto)) {
					dataMap.put("apply_emp_head_photo", headPhoto);
				} else {
					dataMap.put("apply_emp_head_photo", "");
				}
			}

			dataMap.put("t_code", inst.get("inst_t_code"));
			dataMap.put("t_name", inst.get("inst_t_name"));
			dataMap.put("fb_title", inst.get("inst_fb_title"));
			dataMap.put("t_type_id", inst.get("inst_t_type_id"));
			dataMap.put("t_type_name", inst.get("inst_t_type_name"));
			dataMap.put("parent_t_type_id", inst.get("inst_parent_t_type_id"));
			dataMap.put("parent_t_type_name", inst.get("inst_parent_t_type_name"));
			dataMap.put("fb_content", inst.get("inst_fb_content"));
			dataMap.put("inst_status", inst.get("inst_status"));
			dataMap.put("start_date_time", inst.get("inst_start_date_time"));
			dataMap.put("project_flag", inst.get("inst_project_flag"));// 项目类
			dataMap.put("handle_flag", inst.get("inst_handle_flag"));// 流程签报类
			dataMap.put("handle_id", inst.get("handle_id"));// 流程签id
			// 当前节点信息
			// List<TaskDomain> taskList= inst.getTaskList();//代办人列表
			// List<Map<String, Object>> assList = new ArrayList<>();
			/**
			 * List<Map<String, Object>>
			 * taskList=actProcessService.tagInfoList((String)inst.get("inst_id"
			 * ));
			 * 
			 * for(Map<String, Object> tk:taskList){ Map<String, Object>
			 * assigneeMap=new HashMap<String, Object>();
			 * assigneeMap.put("cur_tag_id", tk.get("cur_tag_id"));
			 * assigneeMap.put("cur_tag_name", tk.get("cur_tag_name"));
			 * assigneeMap.put("cur_tag_assignee", tk.get("cur_tag_assignee"));
			 * if(tk.get("cur_tag_assignee")!=null &&
			 * !"".equals(tk.get("cur_tag_assignee"))){
			 * assigneeMap.put("cur_tag_assignee_name",
			 * getEmpInfo((String)tk.get("cur_tag_assignee")).get("emp_name"));
			 * }else{ assigneeMap.put("cur_tag_assignee_name", null);
			 * 
			 * } assList.add(assigneeMap);
			 * 
			 * }
			 **/
			// if ("0".equals(inst.get("inst_handle_flag"))) {
			// List<Map<String, Object>> taskList =
			// actProcessService.tagInfoList((String) inst.get("inst_id"));
			//
			// for (Map<String, Object> tk : taskList) {
			// Map<String, Object> assigneeMap = new HashMap<String, Object>();
			// assigneeMap.put("cur_tag_id", tk.get("cur_tag_id"));
			// assigneeMap.put("cur_tag_name", tk.get("cur_tag_name"));
			// assigneeMap.put("cur_tag_assignee", tk.get("cur_tag_assignee"));
			// if (tk.get("cur_tag_assignee") != null &&
			// !"".equals(tk.get("cur_tag_assignee"))) {
			// Map<String, Object> empMap = getEmpInfo((String)
			// tk.get("cur_tag_assignee"));
			// if (!empMap.isEmpty() && null != empMap) {
			// String assigneeName = (String) empMap.get("emp_name");
			// if (StringUtils.isNotBlank(assigneeName)) {
			// assigneeMap.put("cur_tag_assignee_name", assigneeName);
			// }
			// } else {
			// assigneeMap.put("cur_tag_assignee_name", null);
			// }
			// } else {
			// assigneeMap.put("cur_tag_assignee_name", null);
			//
			// }
			// assList.add(assigneeMap);
			//
			// }
			// } else if ("1".equals(inst.get("inst_handle_flag"))) {
			// // 查询签报类代办人
			// FbBusHandleExample handleExample = new FbBusHandleExample();
			// com.zrt.mybatis.domain.FbBusHandleExample.Criteria handleCriteria
			// = handleExample.createCriteria();
			// handleCriteria.andInstIdEqualTo((String) inst.get("inst_id"));
			// handleCriteria.andHandleStatusEqualTo("0");// 未签报的
			// List<FbBusHandle> handleList =
			// fbBusHandleMapper.selectByExample(handleExample);
			// for (FbBusHandle handle : handleList) {
			// Map<String, Object> assigneeMap = new HashMap<String, Object>();
			// assigneeMap.put("cur_tag_id", null);
			// assigneeMap.put("cur_tag_name", null);
			// assigneeMap.put("cur_tag_assignee", handle.getHandleEmpId());
			// assigneeMap.put("cur_tag_assignee_name",
			// handle.getHandleEmpName());
			// assList.add(assigneeMap);
			// }
			// }
			// dataMap.put("assignee_list", assList);
			dataList.add(dataMap);
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

	/**
	 * 待回复流程
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> selfApplyRes(Map<String, Object> appMap) throws Exception {
		PageInit.setPage(appMap);
		// PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
		// Integer.parseInt(appMap.get("maxResult").toString())).setReasonable(false);
		// 查询所有的实例列表
		// 发起人是我
		appMap.put("apply_id", appMap.get("emp_id"));
		List<InstInfoDomain> listMap = flowselfMapper.instResList(appMap);
		Map<String, Object> countMap = flowselfMapper.instResListCount(appMap);
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
			dataList.add(dataMap);
		}
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", dataList);
		resMap.put("data", dataMap);
		resMap.put("count", countMap.get("totalCount"));
		return resMap;
	}

	@Override
	public Map<String, Object> selfApplyConfirm(Map<String, Object> appMap) throws Exception {
		PageInit.setPage(appMap);
		PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
				Integer.parseInt(appMap.get("maxResult").toString())).setReasonable(false);
		// 查询我的待办
		// 当前待办人是我
		appMap.put("cur_tag_assignee", appMap.get("emp_id"));
		List<Map<String, Object>> listMap = flowselfMapper.selfApplyConfirm(appMap);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(listMap);
		for (Map<String, Object> inst : listMap) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("inst_id", inst.get("inst_id"));// 流程实例id
			dataMap.put("t_code", inst.get("inst_t_code"));// 流程编号
			dataMap.put("t_name", inst.get("inst_t_name"));// 流程名称
			dataMap.put("project_flag", inst.get("inst_project_flag"));// 项目类
			dataMap.put("handle_flag", inst.get("inst_handle_flag"));// 流程签报类
			dataMap.put("org_id", inst.get("inst_org_id"));// 流程编号
			dataMap.put("org_name", inst.get("inst_org_name"));// 流程名称
			dataMap.put("fb_title", inst.get("inst_fb_title"));// 流程标题
			dataMap.put("t_type_id", inst.get("inst_t_type_id"));// 一级分类名称
			dataMap.put("t_type_name", inst.get("inst_t_type_name"));// 二级分类名称
			dataMap.put("parent_t_type_id", inst.get("inst_parent_t_type_id"));// 二级分类
			dataMap.put("parent_t_type_name", inst.get("inst_parent_t_type_name"));// 一级分类
			dataMap.put("apply_id", inst.get("inst_apply_id"));// 申请人id
			dataMap.put("apply_name", inst.get("inst_apply_name"));// 申请人姓名
			// 发起人头像
			Map<String, Object> applyEmpData = getEmpInfo((String) inst.get("inst_apply_id"));
			dataMap.put("apply_emp_head_photo", applyEmpData.get("emp_head_photo"));
			dataMap.put("cur_tag_id", inst.get("tk_cur_tag_id"));// 当前节点id
			dataMap.put("cur_tag_name", inst.get("tk_cur_tag_name"));// 当前节点名称
			dataMap.put("apply_tag_id", inst.get("inst_apply_tag_id"));// 当前节点id
			dataMap.put("apply_tag_name", inst.get("inst_apply_tag_name"));// 当前节点名称
			dataMap.put("start_date_time", inst.get("inst_start_date_time"));// 开始时间
			dataMap.put("fb_content", inst.get("inst_fb_content"));// 内容
			dataMap.put("inst_status", inst.get("inst_status"));// 流程状态(0:草稿,1:审核中,2:已审核,3,已发起)
			dataList.add(dataMap);
		}
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", dataList);
		resMap.put("data", dataMap);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

}
