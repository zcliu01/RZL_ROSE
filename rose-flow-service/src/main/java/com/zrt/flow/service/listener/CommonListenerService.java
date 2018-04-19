package com.zrt.flow.service.listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.bpmn.model.ExtensionElement;
import org.activiti.editor.language.json.converter.SelfExtensionConstans;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.task.IdentityLink;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zrt.commons.AppException;
import com.zrt.commons.cons.Constants;
import com.zrt.commons.date.DateUtil;
import com.zrt.flow.domain.CheckDomain;
import com.zrt.flow.domain.InstDomain;
import com.zrt.flow.mapper.act.ListenMapper;
import com.zrt.flow.service.act.ActProcessService;
import com.zrt.flow.service.process.ProcessCommonService;
import com.zrt.flow.service.runnable.RunnableService;
import com.zrt.flow.service.sec.SecService;
import com.zrt.mybatis.domain.FbBusCheck;
import com.zrt.mybatis.domain.FbBusEntrust;
import com.zrt.mybatis.domain.FbBusInst;
import com.zrt.mybatis.domain.FbBusPredeal;
import com.zrt.mybatis.mapper.FbBusCheckMapper;
import com.zrt.mybatis.mapper.FbBusInstMapper;
import com.zrt.mybatis.mapper.FbBusPredealMapper;

@Service
public class CommonListenerService {

	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private HistoryService historyService;

	@Autowired
	private ManagementService managementService;
	@Autowired
	private ListenMapper listenMapper;
	@Autowired
	private FbBusPredealMapper fbBusPredealMapper;

	@Autowired
	private ProcessCommonService processCommonService;
	@Autowired
	private ActProcessService actProcessService;
	@Autowired
	private FbBusInstMapper fbBusInstMapper;
	@Autowired
	private SecService secService;

	@Autowired
	private RunnableService runnableService;

	@Value("${im.notify.sender_id}")
	private String systemEmpId;

	@Autowired
	private FbBusCheckMapper fbBusCheckMapper;

	/**
	 * 根据流程实例id，查询出待办人
	 * 
	 * @param instId
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void assigneeList(DelegateTask delegateTask) throws Exception, AppException {
		// 获取当前任务的变量
		ActivityExecution execution = (ActivityExecution) delegateTask.getExecution();
		ActivityImpl actImpl = (ActivityImpl) execution.getActivity();
		Map<String, Object> activityInfo = new HashMap<String, Object>();

		// 获取当前节点自定义属性
		@SuppressWarnings("unchecked")
		Map<String, List<ExtensionElement>> extensionMap = (Map<String, List<ExtensionElement>>) actImpl
				.getProperty(SelfExtensionConstans.EXTENSION_ELEMENT_OPERATIONS);
		if (extensionMap != null) {
			for (String key : extensionMap.keySet()) {
				List<ExtensionElement> extensionList = extensionMap.get(key);
				for (ExtensionElement en : extensionList) {
					String enName = en.getName();// 扩展字段名
					String enValue = en.getElementText();// 扩展字段值
					activityInfo.put(enName, enValue);
				}
			}
		}
		Map<String, Object> varParamsMap = execution.getVariables();
		// 获取节点属性,是否支持指定审批人是否支持指定审批人0：否，1：是
		String nextAssignee = (String) activityInfo.get("isassignee");
		List<String> nextConditionsList = new ArrayList<String>();
		List<String> nextGroupList = new ArrayList<String>();
		if (nextAssignee != null && "1".equals(nextAssignee)) {

			String nextAss = (String) varParamsMap.get("next_tag_assignee");// 下一节点审批人参数

			if (nextAss == null || "".equals(nextAss)) {
				// 如果获取的参数为空，则跳过新创建的任务
				Map<String, Object> variables = new HashMap<>();
				variables.put("deal_status", "1");
				taskService.complete(delegateTask.getId(), variables);
				System.out.println("---指定节点自动审批通过");
				return;
			}
			// 说明当前节点是需要指定审批人的
			// 多人是;分号分割
			if (nextAss.endsWith(";")) {
				// 如果是以；分号结尾，那么就截取掉最后一位
				nextAss = nextAss.substring(0, nextAss.length() - 1);
			}
			String[] asses = nextAss.split(";");
			// 先删除原先绑定的任务节点组数据
			// 获取共同审批人
			Set<IdentityLink> nextConditions = delegateTask.getCandidates();

			for (Iterator<IdentityLink> iterator = nextConditions.iterator(); iterator.hasNext();) {
				IdentityLink idLink = iterator.next();
				String groupId = idLink.getGroupId();// 组id
				String userId = idLink.getUserId();
				if (userId != null && !"".equals(userId)) {
					// 说明的候选人
					nextConditionsList.add(userId);
				}
				if (groupId != null && !"".equals(groupId)) {
					// 说明候选组
					nextGroupList.add(groupId);
				}

			}

			List<String> nextAssList = (List<String>) varParamsMap.get("next_tag_assignee_list");// 下一节点审批人参数
			String parentId = delegateTask.getExecution().getParentId();
			// 如果有父任务id，则是会签任务
			if (parentId != null && !"".equals(parentId)) {
				// 代表是会签任务需要指定审批人
				// 如果该任务有过指定的预置审批人，则删除
				if (nextConditionsList != null && nextConditionsList.size() > 0) {
					for (String ss : nextConditionsList) {
						delegateTask.deleteCandidateUser(ss);
					}
				}
				if (nextGroupList != null && nextGroupList.size() > 0) {
					for (String ss : nextGroupList) {
						delegateTask.deleteCandidateGroup(ss);
					}
				}
			} else {
				// 代表串行节点
				if (nextConditionsList != null && nextConditionsList.size() > 0) {
					for (String ss : nextConditionsList) {
						delegateTask.deleteCandidateUser(ss);
					}
				}
				if (nextGroupList != null && nextGroupList.size() > 0) {
					for (String ss : nextGroupList) {
						delegateTask.deleteCandidateGroup(ss);
					}
				}
				// 如果是一人
				if (asses.length == 1) {
					delegateTask.setAssignee(asses[0]);
				} else {
					delegateTask.addCandidateUsers(Arrays.asList(asses));
				}
			}

		}

		// 任务id
		String taskId = delegateTask.getId();
		// activiti流程实例id
		String instId = delegateTask.getProcessInstanceId();
		// 任务节点id
		String actId = delegateTask.getTaskDefinitionKey();
		// 任务节点名称
		String actName = delegateTask.getName();
		// 获取审批人
		String assignee = delegateTask.getAssignee();
		// 获取共同审批人
		Set<IdentityLink> conditions = delegateTask.getCandidates();
		List<String> conditionsList = new ArrayList<String>();
		List<String> groupList = new ArrayList<String>();

		for (Iterator<IdentityLink> iterator = conditions.iterator(); iterator.hasNext();) {
			IdentityLink idLink = iterator.next();
			String groupId = idLink.getGroupId();// 组id
			String userId = idLink.getUserId();
			if (userId != null && !"".equals(userId)) {
				// 说明的候选人
				conditionsList.add(userId);
			}
			if (groupId != null && !"".equals(groupId)) {
				// 说明候选组
				groupList.add(groupId);
			}

		}
		// 如果审批人空,判断候选人
		if (assignee == null || "".equals(assignee)) {
			if (conditionsList.size() == 1) {
				// 说明只有一个候选待办人
				assignee = conditionsList.get(0);
			}
			// 如果候选人还是为空
			// 判断审批件角色是否有审批人
			if (assignee == null || "".equals(assignee)) {
				if (groupList != null && !groupList.isEmpty()) {
					// 查询该候选组里面有多少人
					List<Map<String, Object>> roleUserList = processCommonService.roleUsers(groupList);
					if (!roleUserList.isEmpty()) {
						if (roleUserList.size() == 1) {
							assignee = (String) ((HashMap<String, Object>) roleUserList.get(0)).get("emp_id");
						}
					}
				}
			}
		}

		// 获取共同审批组
		// delegateTask.add

		// 根据流程实例id，查询出具体的业务id
		HistoricProcessInstance hisInstance = historyService.createHistoricProcessInstanceQuery()
				.processInstanceId(instId).singleResult();
		// 具体发起人的业务id
		String busId = hisInstance.getBusinessKey();
		String instanceId = hisInstance.getId();

		// 如果审批人为空，那么判断是否是查询主管领导
		if (assignee == null || "".equals(assignee)) {
			// 解析该流程所有节点
			List<Map<String, Object>> actAllList = actProcessService
					.getDefAssigneeList(hisInstance.getProcessDefinitionId());
			for (Map<String, Object> aMap : actAllList) {
				if (actId.equals(aMap.get("act_id"))) {
					// 当前节点id等于该节点id,获取主分管信息
					String upmanage = (String) aMap.get("upmanage");
					// 获取到流程实例信息
					FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(busId);
					if (upmanage != null && !"".equals(upmanage)) {
						// HistoricActivityInstance
						// hisActInstance=actProcessService.findHistoricUserTask(instanceId);
						HistoricActivityInstance hisActInstance = null;
						// 查询当前流程实例审批结束的历史节点
						List<HistoricActivityInstance> historicActivityInstances = historyService
								.createHistoricActivityInstanceQuery().activityType("userTask")
								.processInstanceId(instId).finished().orderByHistoricActivityInstanceEndTime().desc()
								.list();
						if (historicActivityInstances.size() > 0) {
							hisActInstance = historicActivityInstances.get(0);
						}
						// 说明还没有节点审批完成
						if (hisActInstance == null) {
							// 级别审批人(0:发起人一级审批,1:发起人二级审批,2:发起人三级审批,3:发起人四级审批,4:发起人五级审批,5:前一审批人一级审批,6:前一审批人二级审批,7:前一审批人三级审批,8:前一审批人四级审批,9:前一审批人五级审批)
							if ("0".equals(upmanage) || "1".equals(upmanage) || "2".equals(upmanage)
									|| "3".equals(upmanage) || "4".equals(upmanage)) {
								Map<String, Object> paramMap = new HashMap<String, Object>();
								paramMap.put("org_id", fbBusInst.getOrgId());// 发起人部门
								List<Map<String, Object>> dataList = (List<Map<String, Object>>) secService
										.upManageSearch(paramMap);
								if ("0".equals(upmanage)) {// 一级审批人
									if (null != dataList && !dataList.isEmpty()) {
										for (Map<String, Object> dataMap : dataList) {
											int checkOrder = (int) dataMap.get("check_order");
											if (1 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}
									if (StringUtils.isBlank(assignee)) {
										taskComple(delegateTask);
									}
								} else if ("1".equals(upmanage)) {// 二级审批人
									if (null != dataList && !dataList.isEmpty()) {
										for (Map<String, Object> dataMap : dataList) {
											int checkOrder = (int) dataMap.get("check_order");
											if (2 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}
									if (StringUtils.isBlank(assignee)) {
										taskComple(delegateTask);
									}

								} else if ("2".equals(upmanage)) {// 三级审批人
									if (null != dataList && !dataList.isEmpty()) {
										for (Map<String, Object> dataMap : dataList) {
											int checkOrder = (int) dataMap.get("check_order");
											if (3 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}
									if (StringUtils.isBlank(assignee)) {
										taskComple(delegateTask);
									}

								} else if ("3".equals(upmanage)) {// 四级审批人
									if (null != dataList && !dataList.isEmpty()) {
										for (Map<String, Object> dataMap : dataList) {
											int checkOrder = (int) dataMap.get("check_order");
											if (4 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}
									if (StringUtils.isBlank(assignee)) {
										taskComple(delegateTask);
									}
								} else if ("4".equals(upmanage)) {// 五级审批人
									if (null != dataList && !dataList.isEmpty()) {
										for (Map<String, Object> dataMap : dataList) {
											int checkOrder = (int) dataMap.get("check_order");
											if (5 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}
									if (StringUtils.isBlank(assignee)) {
										taskComple(delegateTask);
									}
								}
							}
						} else {
							// 查询该流程最新审核的信息
							FbBusCheck fbBusCheck = processCommonService.queryLastInfor(busId);
							String beforAssignee = fbBusCheck.getCheckEmpId();// 上一任务审批人
							// if(!actId.equals(beforTaskActId)){
							// 如果上一任务节点id，不等于当前创建的任务节点id，说明跳转节点了，那么在查询主管信息
							// 级别审批人(0:发起人一级审批,1:发起人二级审批,2:发起人三级审批,3:发起人四级审批,4:发起人五级审批,5:前一审批人一级审批,6:前一审批人二级审批,7:前一审批人三级审批,8:前一审批人四级审批,9:前一审批人五级审批)
							if ("0".equals(upmanage) || "1".equals(upmanage) || "2".equals(upmanage)
									|| "3".equals(upmanage) || "4".equals(upmanage)) {
								Map<String, Object> paramMap = new HashMap<String, Object>();
								paramMap.put("org_id", fbBusInst.getOrgId());// 发起人部门
								@SuppressWarnings("unchecked")
								List<Map<String, Object>> dataList = (List<Map<String, Object>>) secService
										.upManageSearch(paramMap);
								if ("0".equals(upmanage)) {// 一级审批人
									if (null != dataList && !dataList.isEmpty()) {
										for (Map<String, Object> dataMap : dataList) {
											int checkOrder = (int) dataMap.get("check_order");
											if (1 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}
									if (StringUtils.isBlank(assignee)) {
										taskComple(delegateTask);
									}
								} else if ("1".equals(upmanage)) {// 二级审批人
									if (null != dataList && !dataList.isEmpty()) {
										for (Map<String, Object> dataMap : dataList) {
											int checkOrder = (int) dataMap.get("check_order");
											if (2 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}
									if (StringUtils.isBlank(assignee)) {
										taskComple(delegateTask);
									}
								} else if ("2".equals(upmanage)) {// 三级审批人
									if (null != dataList && !dataList.isEmpty()) {
										for (Map<String, Object> dataMap : dataList) {
											int checkOrder = (int) dataMap.get("check_order");
											if (3 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}
									if (StringUtils.isBlank(assignee)) {
										taskComple(delegateTask);
									}
								} else if ("3".equals(upmanage)) {// 四级审批人
									if (null != dataList && !dataList.isEmpty()) {
										for (Map<String, Object> dataMap : dataList) {
											int checkOrder = (int) dataMap.get("check_order");
											if (4 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}
									if (StringUtils.isBlank(assignee)) {
										taskComple(delegateTask);
									}
								} else if ("4".equals(upmanage)) {// 五级审批人
									if (null != dataList && !dataList.isEmpty()) {
										for (Map<String, Object> dataMap : dataList) {
											int checkOrder = (int) dataMap.get("check_order");
											if (5 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}
									if (StringUtils.isBlank(assignee)) {
										taskComple(delegateTask);
									}
								}
							} else if ("5".equals(upmanage) || "6".equals(upmanage) || "7".equals(upmanage)
									|| "8".equals(upmanage) || "9".equals(upmanage) || "up".equals(upmanage)) {
								Map<String, Object> paramMap = new HashMap<String, Object>();
								paramMap.put("emp_id", beforAssignee);// 上一节点审批人id
								@SuppressWarnings("unchecked")
								List<Map<String, Object>> dataList = (List<Map<String, Object>>) secService
										.manageSearch(paramMap);
								if ("5".equals(upmanage)) {// 一级审批人
									if (null != dataList && !dataList.isEmpty()) {
										for (Map<String, Object> dataMap : dataList) {
											int checkOrder = (int) dataMap.get("check_order");
											if (1 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}
									if (StringUtils.isBlank(assignee)) {
										taskComple(delegateTask);
									}
								} else if ("6".equals(upmanage)) {// 二级审批人
									if (null != dataList && !dataList.isEmpty()) {
										for (Map<String, Object> dataMap : dataList) {
											int checkOrder = (int) dataMap.get("check_order");
											if (2 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}
									if (StringUtils.isBlank(assignee)) {
										taskComple(delegateTask);
									}
								} else if ("7".equals(upmanage)) {// 三级审批人
									if (null != dataList && !dataList.isEmpty()) {
										for (Map<String, Object> dataMap : dataList) {
											int checkOrder = (int) dataMap.get("check_order");
											if (3 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}
									if (StringUtils.isBlank(assignee)) {
										taskComple(delegateTask);
									}
								} else if ("8".equals(upmanage)) {// 四级审批人
									if (null != dataList && !dataList.isEmpty()) {
										for (Map<String, Object> dataMap : dataList) {
											int checkOrder = (int) dataMap.get("check_order");
											if (4 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}
									if (StringUtils.isBlank(assignee)) {
										taskComple(delegateTask);
									}
								} else if ("9".equals(upmanage)) {// 五级审批人
									if (null != dataList && !dataList.isEmpty()) {
										for (Map<String, Object> dataMap : dataList) {
											int checkOrder = (int) dataMap.get("check_order");
											if (5 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}
									if (StringUtils.isBlank(assignee)) {
										taskComple(delegateTask);
									}
								} else if ("up".equals(upmanage)) {// 前一审批人上级
									if (null != dataList && !dataList.isEmpty()) {
										int resOrder = 0;
										String firstOrder = "";
										for (Map<String, Object> dataMap : dataList) {
											String checkEmpId = (String) dataMap.get("check_emp_id");
											int checkOrder = (int) dataMap.get("check_order");
											if (checkOrder == 1) {
												firstOrder = checkEmpId;
											}

											if (beforAssignee.equals(checkEmpId)) {
												resOrder = checkOrder + 1;
											}

											if (checkOrder == resOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
										if (StringUtils.isBlank(assignee) && resOrder == 0) {
											assignee = firstOrder;
										}

									}
									if (StringUtils.isBlank(assignee)) {
										taskComple(delegateTask);
									}
								}
							}
							// }
						}

					}
					// 当前任务设置审批人
					delegateTask.setAssignee(assignee);
					break;
				}

			}

		}

		// 根据busId查询发起实例的模版，委托信息，预处理信息
		// 根据业务id，查询当前业务流程的具体信息
		if (assignee != null && !"".equals(assignee)) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("check_emp_id", assignee);
			paramMap.put("inst_id", busId);
			// 根据任务审批人，查询该流程业务相关信息，预处理，规避重复审批.......
			List<InstDomain> list = listenMapper.instInfoList(paramMap);

			for (InstDomain instDomain : list) {
				// 流程进行委托过的
				List<FbBusEntrust> entList = instDomain.getEntList();
				String entId = null;// 受托人id
				String entName = null;// 受托人姓名

				// 委托列表不为空，说明当前审批人设置过委托，那么要查询受托人信息
				if (entList != null && entList.size() > 0) {
					// 一个人一个委托流程最多一个人，取一条
					FbBusEntrust ent = entList.get(0);
					// 任务持有人
					delegateTask.setOwner(assignee);
					// 任务受托人
					entId = ent.getEntEmpId();
					delegateTask.setAssignee(entId);
					// 如果存在委托就要查询受托人的预处理，审核信息
					Map<String, Object> entMap = new HashMap<String, Object>();
					paramMap.put("check_emp_id", entId);
					paramMap.put("inst_id", busId);
					List<InstDomain> entInstlist = listenMapper.instInfoList(entMap);
					if (entInstlist != null && entInstlist.size() > 0) {
						InstDomain entInstDomain = entInstlist.get(0);
						commonBus(entInstDomain, delegateTask);
					}

				} else {
					commonBus(instDomain, delegateTask);
				}
			}
		}
	}

	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void commonBus(InstDomain instDomain, DelegateTask delegateTask) throws Exception {
		// 任务id
		String taskId = delegateTask.getId();
		// activiti流程实例id
		String instId = delegateTask.getProcessInstanceId();
		// 任务节点id
		String actId = delegateTask.getTaskDefinitionKey();
		// 任务节点名称
		String actName = delegateTask.getName();
		// 获取审批人
		String assignee = delegateTask.getAssignee();
		String currDate = DateUtil.getCurrentDateTime();
		// 如果不存在委托，当前审批人就是自己
		// 实例预处理过的
		List<FbBusPredeal> preList = instDomain.getPreList();
		// 实例已经处理过的
		List<CheckDomain> checkList = instDomain.getCheckList();

		FbBusPredeal fbBusPredeal = null;
		// 说明该任务处理标识
		Boolean dealFlag = false;
		for (FbBusPredeal pre : preList) {
			// 预处理状态

			fbBusPredeal = pre;
			// 更新预处理信息
			// 更新预处理信息为已预处理
			fbBusPredeal.setPreStatus("1");
			fbBusPredeal.setUpdateDateTime(currDate);
			fbBusPredealMapper.updateByPrimaryKey(fbBusPredeal);
			// 保存审核信息
			Map<String, Object> checkMap = new HashMap<String, Object>();
			checkMap.put("emp_id", fbBusPredeal.getCheckEmpId());
			checkMap.put("emp_name", fbBusPredeal.getCheckEmpName());
			checkMap.put("check_type", Constants.CHECK_TYPE_5);
			checkMap.put("check_status", fbBusPredeal.getCheckStatus());// 预处理状态
			checkMap.put("inst_id", fbBusPredeal.getInstId());// 业务id
			checkMap.put("check_comment", fbBusPredeal.getCheckComment());// 预处理意见
			checkMap.put("task_id", taskId);// 任务 id
			checkMap.put("repeat_flag", fbBusPredeal.getRepeatFlag());// 规避重复
			checkMap.put("org_id", fbBusPredeal.getOrgId());// 机构id
			checkMap.put("org_name", fbBusPredeal.getOrgName());// 机构名称
			commonCheck(checkMap, delegateTask);
			dealFlag = true;
			break;

		}
		if (!dealFlag) {
			for (CheckDomain check : checkList) {
				String repeatFlag = check.getRepeatFlag();
				// 如果规避重复审批
				if ("1".equals(repeatFlag)) {
					// 保存审核信息
					Map<String, Object> checkMap = new HashMap<String, Object>();
					checkMap.put("emp_id", check.getCheckEmpId());
					checkMap.put("check_type", Constants.CHECK_TYPE_0);
					checkMap.put("check_status", Constants.CHECK_STATUS_1);// 处理状态
					checkMap.put("inst_id", check.getInstId());// 业务id
					checkMap.put("check_comment", check.getCheckComment());// 预处理意见
					checkMap.put("task_id", taskId);// 任务 id
					checkMap.put("repeat_flag", check.getRepeatFlag());// 规避重复
					commonCheck(checkMap, delegateTask);
					dealFlag = true;
					break;
				}
			}

		}
		// 如果没有预处理，也没有规避重复审批
		if (!dealFlag) {
			// 获取共同审批人
			Set<IdentityLink> conditions = delegateTask.getCandidates();
			List<String> conditionsList = new ArrayList<String>();
			List<String> groupList = new ArrayList<String>();
			if (assignee != null && !"".equals(assignee)) {
				conditionsList.add(assignee);
			}
			for (Iterator<IdentityLink> iterator = conditions.iterator(); iterator.hasNext();) {
				IdentityLink idLink = iterator.next();
				String groupId = idLink.getGroupId();// 组id
				String userId = idLink.getUserId();
				if (userId != null && !"".equals(userId)) {
					// 说明的候选人
					conditionsList.add(userId);
				}
				if (groupId != null && !"".equals(groupId)) {
					// 说明候选组
					groupList.add(groupId);
				}

			}

			if (groupList != null && !groupList.isEmpty()) {
				// 查询该候选组里面有多少人
				List<Map<String, Object>> roleUserList = processCommonService.roleUsers(groupList);
				if (!roleUserList.isEmpty()) {
					for (Map<String, Object> user : roleUserList) {
						conditionsList.add((String) user.get("emp_id"));
					}
				}
			}
			// 待办人讯息通知
			Map<String, Object> inforMap = new HashMap<String, Object>();
			// 判断assginee是否为空，如果不为空则只给assginee推送消息，否则给conditions推送
			if (assignee != null && !"".equals(assignee)) {
				inforMap.put("receiver", assignee);
				// 待办人IM消息通知
				/**
				 * Map<String, Object> imMap=new HashMap<String, Object>();
				 * imMap.put("sender", systemEmpId); imMap.put("receiver",
				 * assignee); imMap.put("msgContent",
				 * "您有一个标题为《"+instDomain.getFbTitle()+"》的流程待处理!");
				 * imMap.put("msgDomain", domainStr);
				 * runnableService.imCall(imMap);
				 **/
			} else {
				if (conditionsList != null && !conditionsList.isEmpty()) {
					StringBuffer sb = new StringBuffer();
					for (int i = 0; i < conditionsList.size(); i++) {
						String empId = conditionsList.get(i);
						if (i == conditionsList.size() - 1) {
							// 最后一天数据最后不追加;
							sb = sb.append(empId);
						} else {
							sb = sb.append(empId).append(";");
						}

					}
					// 待办人讯息通知
					inforMap.put("receiver", sb.toString());
				}
			}

			if ((assignee != null && !"".equals(assignee)) || (conditionsList != null && !conditionsList.isEmpty())) {
				// 待办人讯息通知
				// inforMap.put("title", "待办流程通知");
				// inforMap.put("content", "您有一个标题为《" + instDomain.getFbTitle()
				// + "》的流程待处理!");
				// inforMap.put("sender", systemEmpId);
				// inforMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
				// // ,流程讯息(flowInfor),
				// // 公文讯息(docInfor),
				// // 公示讯息(pubInfor),
				// // 问卷讯息(askInfor),
				// // 日程讯息(dayInfor))
				// inforMap.put("bus_type", "FB01");// 待办类型
				// inforMap.put("bus_id", instDomain.getId());// 实例id
				// Map<String, Object> busDomainMap = new HashMap<String,
				// Object>();
				// ObjectMapper objMapper = new ObjectMapper();
				// busDomainMap.put("inst_id", instDomain.getId());// 流程实例id
				// busDomainMap.put("task_id", taskId);// 代办任务id
				// busDomainMap.put("cur_tag_id", actId);// 待办节点id
				// busDomainMap.put("cur_tag_name", actName);// 待办节点id
				// busDomainMap.put("category", "flowInfor");//
				// 类别(内部讯息(innerInfor)
				// // ,流程讯息(flowInfor),
				// // 公文讯息(docInfor),
				// // 公示讯息(pubInfor),
				// // 问卷讯息(askInfor),
				// // 日程讯息(dayInfor))
				// busDomainMap.put("bus_type", "FB01");// 待办类型
				//
				// String domainStr =
				// objMapper.writeValueAsString(busDomainMap);
				// inforMap.put("bus_domain", domainStr);
				// runnableService.inforCall(inforMap);
			}

		}
	}

	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void commonCheck(Map<String, Object> appMap, DelegateTask delegateTask) throws Exception {
		// 审核状态(0:拒绝,1:同意)
		String check_status = (String) appMap.get("check_status");
		// 审核方式：0：普通，1:附条件同意,2:驳回至,3,加签,4会签,5:预处理,6:委托
		String check_type = (String) appMap.get("check_type");
		// 任务id
		String task_id = (String) appMap.get("task_id");

		// 处理本地业务信息
		// 审核id
		String check_id = processCommonService.getId();
		// 业务id,也是申请inst_id
		String bus_id = (String) appMap.get("inst_id");

		// 审核业务信息保存
		String cur_date = DateUtil.getCurrentDateTime();
		appMap.put("read_date_time", cur_date);
		appMap.put("check_date_time", cur_date);
		checkBus(appMap, bus_id, check_id, delegateTask);

		if (Constants.CHECK_STATUS_1.equals(check_status)) {
			// 参数传递
			Map<String, Object> variables = new HashMap<>();
			variables.put("deal_status", check_status);
			taskService.complete(task_id, variables);
		} else {
			actProcessService.deleteInst(bus_id, "reject");
		}

		// 更新流程实例信息，更新时间，更新审批状态
		processCommonService.instDeal(bus_id, check_status, check_type);

	}

	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void checkBus(Map<String, Object> appMap, String busId, String checkId, DelegateTask delegateTask) {
		// 保存审核信息表
		String check_id = processCommonService.getId();
		if (checkId != null) {
			check_id = checkId;
		}
		Map<String, Object> empData = processCommonService.getEmpInfo((String) appMap.get("emp_id"));
		String cur_date = DateUtil.getCurrentDateTime();
		FbBusCheck fbBusCheck = new FbBusCheck();
		fbBusCheck.setId(check_id);// 审核id
		fbBusCheck.setCheckEmpId((String) appMap.get("emp_id"));// 审核人id
		fbBusCheck.setCheckEmpName((String) empData.get("emp_name"));// 审核人姓名
		fbBusCheck.setOrgId((String) empData.get("org_id"));// 所在机构组织id
		fbBusCheck.setOrgName((String) empData.get("org_name"));// 组织机构名称
		fbBusCheck.setInstId((String) appMap.get("inst_id"));// 申请id，也是业务id
		fbBusCheck.setInstTag(delegateTask.getTaskDefinitionKey());// 当前节点id
		fbBusCheck.setInstTagName(delegateTask.getName());// 当前节点名称
		fbBusCheck.setCreateDateTime(cur_date);// 当前时间
		fbBusCheck.setUpdateDateTime(cur_date);// 更新时间
		fbBusCheck.setCheckStatus((String) appMap.get("check_status"));// 审核状态审核状态(0:拒绝,1:同意)
		fbBusCheck.setCheckType((String) appMap.get("check_type"));// 审核方式：0：普通，1:附条件同意,2:驳回至,3,加签,4会签,5:预处理,6:委托
		fbBusCheck.setCheckComment((String) appMap.get("check_comment"));// 审核意见
		fbBusCheck.setOldEmpId(null);//// 原审核人id
		fbBusCheck.setOldEmpName(null);//// 原审核人name
		fbBusCheck.setArriveDateTime(DateUtil.getDateFormat(delegateTask.getCreateTime(), "yyyyMMddHHmmss"));// 到达时间
		fbBusCheck.setReadDateTime((String) appMap.get("read_date_time"));// 阅读时间
		fbBusCheck.setTaskId((String) appMap.get("task_id"));// 任务id
		fbBusCheck.setRepeatFlag((String) appMap.get("repeat_flag"));// 是否规避重复审批0:否，1:是
		fbBusCheck.setCheckDateTime((String) appMap.get("check_date_time"));// 审核时间
		fbBusCheck.setCheckDesc((String) appMap.get("check_desc"));// 备注
		fbBusCheckMapper.insert(fbBusCheck);
	}

	public void taskComple(DelegateTask delegateTask) {
		Map<String, Object> variables = new HashMap<>();
		variables.put("deal_status", "1");
		taskService.complete(delegateTask.getId(), variables);
		System.out.println("---指定节点自动审批通过");
	}
}
