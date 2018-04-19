package com.zrt.flow.service.act;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.ExtensionElement;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.editor.language.json.converter.SelfExtensionConstans;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.javax.el.ValueExpression;
import org.activiti.engine.impl.juel.ExpressionFactoryImpl;
import org.activiti.engine.impl.juel.SimpleContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.impl.pvm.process.TransitionImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.commons.AppException;
import com.zrt.flow.mapper.act.ActMapper;
import com.zrt.flow.service.contacts.ContactsService;
import com.zrt.flow.service.process.ProcessCommonService;
import com.zrt.flow.service.sec.SecService;
import com.zrt.mybatis.domain.FbBusCheck;
import com.zrt.mybatis.domain.FbBusCheckExample;
import com.zrt.mybatis.domain.FbBusInst;
import com.zrt.mybatis.mapper.FbBusCheckMapper;
import com.zrt.mybatis.mapper.FbBusInstMapper;

@Service
public class ActProcessService {
	private static final Logger log = LoggerFactory.getLogger(ActProcessService.class);

	@Autowired
	private ProcessEngine processEngine;
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
	private ActMapper actMapper;
	@Autowired
	private ContactsService contactsService;
	@Autowired
	private ProcessCommonService processCommonService;
	@Autowired
	private FbBusInstMapper fbBusInstMapper;
	@Autowired
	private FbBusCheckMapper fbBusCheckMapper;
	@Autowired
	private SecService secService;

	/**
	 * 根据当前任务ID，查询可以驳回的任务节点
	 * 
	 * @param taskId
	 *            当前任务ID
	 */
	public List<ActivityImpl> findBackAvtivity(String taskId) throws Exception {
		List<ActivityImpl> rtnList = null;
		if (isJointTask(taskId)) {// 会签任务节点，不允许驳回
			rtnList = new ArrayList<ActivityImpl>();
		} else {
			rtnList = iteratorBackActivity(taskId, findActivitiImpl(taskId, null), new ArrayList<ActivityImpl>(),
					new ArrayList<ActivityImpl>());
		}
		return reverList(rtnList);
	}

	/**
	 * 根据当前任务ID，判断是否是多实例任务
	 * 
	 * @param taskId
	 *            当前任务ID
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Boolean isJointTask(String taskId) throws Exception {
		Boolean flag = false;
		// 获取任务实例
		TaskEntity taskEntity = findTaskById(taskId);
		ExecutionEntity executionEmtity = (ExecutionEntity) runtimeService.createExecutionQuery()
				.executionId(taskEntity.getExecutionId()).singleResult();
		// 任务需要的变量
		Map<String, Object> varMap = taskEntity.getProcessVariables();
		// 多实例任务参数
		Object nrOfInstances = varMap.get("nrOfInstances");
		String parentId = executionEmtity.getParentId();
		// 如果有这个变量说明是多实例任务
		if (parentId != null) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 审批通过(驳回直接跳回功能需后续扩展)
	 * 
	 * @param taskId
	 *            当前任务ID
	 * @param variables
	 *            流程存储参数
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void passProcess(String taskId, Map<String, Object> variables) throws Exception {
		// 待验证.parentTaskId(taskId).
		List<Task> tasks = taskService.createTaskQuery().taskId(taskId).excludeSubtasks()
				.taskDescription("jointProcess").list();
		for (Task task : tasks) {// 级联结束本节点发起的会签任务
			commitProcess(task.getId(), null, null);
		}
		commitProcess(taskId, variables, null);
	}

	/**
	 * 驳回流程
	 * 
	 * @param taskId
	 *            当前任务ID
	 * @param activityId
	 *            驳回节点ID
	 * @param variables
	 *            流程存储参数
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void backProcess(String taskId, String activityId, Map<String, Object> variables) throws Exception {
		if (StringUtils.isEmpty(activityId)) {
			throw new Exception("驳回目标节点ID为空！");
		}

		// 查询本节点发起的会签任务，并结束 //暂时这样写，待验证.parentTaskId(taskId).
		List<Task> tasks = taskService.createTaskQuery().taskId(taskId).excludeSubtasks()
				.taskDescription("jointProcess").list();
		for (Task task : tasks) {
			commitProcess(task.getId(), null, null);
		}

		// 查找所有并行任务节点，同时驳回
		List<Task> taskList = findTaskListByKey(findProcessInstanceByTaskId(taskId).getId(),
				findTaskById(taskId).getTaskDefinitionKey());
		for (Task task : taskList) {
			commitProcess(task.getId(), variables, activityId);
		}
	}

	/**
	 * 取回流程
	 * 
	 * @param taskId
	 *            当前任务ID
	 * @param activityId
	 *            取回节点ID
	 * @throws Exception
	 */
	public void callBackProcess(String taskId, String activityId) throws Exception {
		if (StringUtils.isEmpty(activityId)) {
			throw new Exception("目标节点ID为空！");
		}

		// 查找所有并行任务节点，同时取回
		List<Task> taskList = findTaskListByKey(findProcessInstanceByTaskId(taskId).getId(),
				findTaskById(taskId).getTaskDefinitionKey());
		for (Task task : taskList) {
			commitProcess(task.getId(), null, activityId);
		}
	}

	/**
	 * 中止流程(特权人直接审批通过等)
	 * 
	 * @param taskId
	 */
	public void endProcess(String taskId) throws Exception {
		ActivityImpl endActivity = findActivitiImpl(taskId, "end");
		commitProcess(taskId, null, endActivity.getId());
	}

	/**
	 * 会签操作
	 * 
	 * @param taskId
	 *            当前任务ID
	 * @param userCodes
	 *            会签人账号集合
	 * @throws Exception
	 */
	public void jointProcess(String taskId, List<String> userCodes) throws Exception {
		for (String userCode : userCodes) {
			TaskEntity task = (TaskEntity) taskService.newTask();
			task.setAssignee(userCode);
			task.setName(findTaskById(taskId).getName() + "-会签");
			task.setProcessDefinitionId(findProcessDefinitionEntityByTaskId(taskId).getId());
			task.setProcessInstanceId(findProcessInstanceByTaskId(taskId).getId());
			task.setParentTaskId(taskId);
			task.setDescription("jointProcess");
			taskService.saveTask(task);
		}
	}

	/**
	 * 转办流程
	 * 
	 * @param taskId
	 *            当前任务节点ID
	 * @param userCode
	 *            被转办人Code
	 */
	public void transferAssignee(String taskId, String userCode) {
		taskService.setAssignee(taskId, userCode);
	}

	/**
	 * *************************************************************************
	 * *************************************************************************
	 * *<br>
	 * ************************************************以下为流程转向操作核心逻辑************
	 * ******************************************************************<br>
	 * *************************************************************************
	 * *************************************************************************
	 * *<br>
	 */

	/**
	 * @param taskId
	 *            当前任务ID
	 * @param variables
	 *            流程变量
	 * @param activityId
	 *            流程转向执行任务节点ID<br>
	 *            此参数为空，默认为提交操作
	 * @throws Exception
	 */
	public void commitProcess(String taskId, Map<String, Object> variables, String activityId) throws Exception {
		if (variables == null) {
			variables = new HashMap<String, Object>();
		}
		// 跳转节点为空，默认提交操作
		if (StringUtils.isEmpty(activityId)) {
			taskService.complete(taskId, variables);
		} else {// 流程转向操作
			turnTransition(taskId, activityId, variables);
		}
	}

	/**
	 * 清空指定活动节点流向
	 * 
	 * @param activityImpl
	 *            活动节点
	 * @return 节点流向集合
	 */
	private List<PvmTransition> clearTransition(ActivityImpl activityImpl) {
		// 存储当前节点所有流向临时变量
		List<PvmTransition> oriPvmTransitionList = new ArrayList<PvmTransition>();
		// 获取当前节点所有流向，存储到临时变量，然后清空
		List<PvmTransition> pvmTransitionList = activityImpl.getOutgoingTransitions();
		for (PvmTransition pvmTransition : pvmTransitionList) {
			oriPvmTransitionList.add(pvmTransition);
		}
		pvmTransitionList.clear();

		return oriPvmTransitionList;
	}

	/**
	 * 还原指定活动节点流向
	 * 
	 * @param activityImpl
	 *            活动节点
	 * @param oriPvmTransitionList
	 *            原有节点流向集合
	 */
	private void restoreTransition(ActivityImpl activityImpl, List<PvmTransition> oriPvmTransitionList) {
		// 清空现有流向
		List<PvmTransition> pvmTransitionList = activityImpl.getOutgoingTransitions();
		pvmTransitionList.clear();
		// 还原以前流向
		for (PvmTransition pvmTransition : oriPvmTransitionList) {
			pvmTransitionList.add(pvmTransition);
		}
	}

	/**
	 * 流程转向操作
	 * 
	 * @param taskId
	 *            当前任务ID
	 * @param activityId
	 *            目标节点任务ID
	 * @param variables
	 *            流程变量
	 * @throws Exception
	 */
	private void turnTransition(String taskId, String activityId, Map<String, Object> variables) throws Exception {
		// 当前节点
		ActivityImpl currActivity = findActivitiImpl(taskId, null);
		// 清空当前流向
		List<PvmTransition> oriPvmTransitionList = clearTransition(currActivity);

		// 创建新流向
		TransitionImpl newTransition = currActivity.createOutgoingTransition();
		// 目标节点
		ActivityImpl pointActivity = findActivitiImpl(taskId, activityId);
		// 设置新流向的目标节点
		newTransition.setDestination(pointActivity);

		// 执行转向任务
		taskService.complete(taskId, variables);
		// 删除目标节点新流入
		pointActivity.getIncomingTransitions().remove(newTransition);

		// 还原以前流向
		restoreTransition(currActivity, oriPvmTransitionList);
	}

	/**
	 * *************************************************************************
	 * *************************************************************************
	 * *<br>
	 * ************************************************以上为流程转向操作核心逻辑************
	 * ******************************************************************<br>
	 * *************************************************************************
	 * *************************************************************************
	 * *<br>
	 */

	/**
	 * *************************************************************************
	 * *************************************************************************
	 * *<br>
	 * ************************************************以下为查询流程驳回节点核心逻辑**********
	 * *****************************************************************<br>
	 * *************************************************************************
	 * *************************************************************************
	 * *<br>
	 */

	/**
	 * 迭代循环流程树结构，查询当前节点可驳回的任务节点
	 * 
	 * @param taskId
	 *            当前任务ID
	 * @param currActivity
	 *            当前活动节点
	 * @param rtnList
	 *            存储回退节点集合
	 * @param tempList
	 *            临时存储节点集合（存储一次迭代过程中的同级userTask节点）
	 * @return 回退节点集合
	 */
	private List<ActivityImpl> iteratorBackActivity(String taskId, ActivityImpl currActivity,
			List<ActivityImpl> rtnList, List<ActivityImpl> tempList) throws Exception {
		// 查询流程定义，生成流程树结构
		ProcessInstance processInstance = findProcessInstanceByTaskId(taskId);

		// 当前节点的流入来源
		List<PvmTransition> incomingTransitions = currActivity.getIncomingTransitions();
		// 条件分支节点集合，userTask节点遍历完毕，迭代遍历此集合，查询条件分支对应的userTask节点
		List<ActivityImpl> exclusiveGateways = new ArrayList<ActivityImpl>();
		// 并行节点集合，userTask节点遍历完毕，迭代遍历此集合，查询并行节点对应的userTask节点
		List<ActivityImpl> parallelGateways = new ArrayList<ActivityImpl>();
		// 遍历当前节点所有流入路径
		for (PvmTransition pvmTransition : incomingTransitions) {
			TransitionImpl transitionImpl = (TransitionImpl) pvmTransition;
			ActivityImpl activityImpl = transitionImpl.getSource();
			String type = (String) activityImpl.getProperty("type");
			/**
			 * 并行节点配置要求：<br>
			 * 必须成对出现，且要求分别配置节点ID为:XXX_start(开始)，XXX_end(结束)
			 */
			if ("parallelGateway".equals(type)) {// 并行路线
				String gatewayId = activityImpl.getId();
				String gatewayType = gatewayId.substring(gatewayId.lastIndexOf("_") + 1);
				if ("START".equals(gatewayType.toUpperCase())) {// 并行起点，停止递归
					return rtnList;
				} else {// 并行终点，临时存储此节点，本次循环结束，迭代集合，查询对应的userTask节点
					parallelGateways.add(activityImpl);
				}
			} else if ("startEvent".equals(type)) {// 开始节点，停止递归
				return rtnList;
			} else if ("userTask".equals(type)) {// 用户任务
				tempList.add(activityImpl);
			} else if ("exclusiveGateway".equals(type)) {// 分支路线，临时存储此节点，本次循环结束，迭代集合，查询对应的userTask节点
				currActivity = transitionImpl.getSource();
				exclusiveGateways.add(currActivity);
			}
		}

		/**
		 * 迭代条件分支集合，查询对应的userTask节点
		 */
		for (ActivityImpl activityImpl : exclusiveGateways) {
			iteratorBackActivity(taskId, activityImpl, rtnList, tempList);
		}

		/**
		 * 迭代并行集合，查询对应的userTask节点
		 */
		for (ActivityImpl activityImpl : parallelGateways) {
			iteratorBackActivity(taskId, activityImpl, rtnList, tempList);
		}

		/**
		 * 根据同级userTask集合，过滤最近发生的节点
		 */
		currActivity = filterNewestActivity(processInstance, tempList);
		if (currActivity != null) {
			// 查询当前节点的流向是否为并行终点，并获取并行起点ID
			String id = findParallelGatewayId(currActivity);
			if (StringUtils.isEmpty(id)) {// 并行起点ID为空，此节点流向不是并行终点，符合驳回条件，存储此节点
				rtnList.add(currActivity);
			} else {// 根据并行起点ID查询当前节点，然后迭代查询其对应的userTask任务节点
				currActivity = findActivitiImpl(taskId, id);
			}

			// 清空本次迭代临时集合
			tempList.clear();
			// 执行下次迭代
			iteratorBackActivity(taskId, currActivity, rtnList, tempList);
		}
		return rtnList;
	}

	/**
	 * 反向排序list集合，便于驳回节点按顺序显示
	 * 
	 * @param list
	 * @return
	 */
	private List<ActivityImpl> reverList(List<ActivityImpl> list) {
		List<ActivityImpl> rtnList = new ArrayList<ActivityImpl>();
		// 由于迭代出现重复数据，排除重复
		for (int i = list.size(); i > 0; i--) {
			if (!rtnList.contains(list.get(i - 1)))
				rtnList.add(list.get(i - 1));
		}
		return rtnList;
	}

	/**
	 * 根据当前节点，查询输出流向是否为并行终点，如果为并行终点，则拼装对应的并行起点ID
	 * 
	 * @param activityImpl
	 *            当前节点
	 * @return
	 */
	private String findParallelGatewayId(ActivityImpl activityImpl) {
		List<PvmTransition> incomingTransitions = activityImpl.getOutgoingTransitions();
		for (PvmTransition pvmTransition : incomingTransitions) {
			TransitionImpl transitionImpl = (TransitionImpl) pvmTransition;
			activityImpl = transitionImpl.getDestination();
			String type = (String) activityImpl.getProperty("type");
			if ("parallelGateway".equals(type)) {// 并行路线
				String gatewayId = activityImpl.getId();
				String gatewayType = gatewayId.substring(gatewayId.lastIndexOf("_") + 1);
				if ("END".equals(gatewayType.toUpperCase())) {
					return gatewayId.substring(0, gatewayId.lastIndexOf("_")) + "_start";
				}
			}
		}
		return null;
	}

	/**
	 * 根据流入任务集合，查询最近一次的流入任务节点
	 * 
	 * @param processInstance
	 *            流程实例
	 * @param tempList
	 *            流入任务集合
	 * @return
	 */
	private ActivityImpl filterNewestActivity(ProcessInstance processInstance, List<ActivityImpl> tempList) {
		while (tempList.size() > 0) {
			ActivityImpl activity_1 = tempList.get(0);
			HistoricActivityInstance activityInstance_1 = findHistoricUserTask(processInstance, activity_1.getId());
			if (activityInstance_1 == null) {
				tempList.remove(activity_1);
				continue;
			}

			if (tempList.size() > 1) {
				ActivityImpl activity_2 = tempList.get(1);
				HistoricActivityInstance activityInstance_2 = findHistoricUserTask(processInstance, activity_2.getId());
				if (activityInstance_2 == null) {
					tempList.remove(activity_2);
					continue;
				}

				if (activityInstance_1.getEndTime().before(activityInstance_2.getEndTime())) {
					tempList.remove(activity_1);
				} else {
					tempList.remove(activity_2);
				}
			} else {
				break;
			}
		}
		if (tempList.size() > 0) {
			return tempList.get(0);
		}
		return null;
	}

	/**
	 * 查询指定任务节点的最新记录
	 * 
	 * @param processInstance
	 *            流程实例
	 * @param activityId
	 * @return
	 */
	private HistoricActivityInstance findHistoricUserTask(ProcessInstance processInstance, String activityId) {
		HistoricActivityInstance rtnVal = null;
		// 查询当前流程实例审批结束的历史节点
		List<HistoricActivityInstance> historicActivityInstances = historyService.createHistoricActivityInstanceQuery()
				.activityType("userTask").processInstanceId(processInstance.getId()).activityId(activityId).finished()
				.orderByHistoricActivityInstanceEndTime().desc().list();
		if (historicActivityInstances.size() > 0) {
			rtnVal = historicActivityInstances.get(0);
		}

		return rtnVal;
	}

	/**
	 * 根据流程实例查询最新记录节点
	 * 
	 * @param findHistoricUserTask
	 *            流程实例 id
	 * @param activityId
	 * @return
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public HistoricActivityInstance findHistoricUserTask(String instanceId) {
		HistoricActivityInstance rtnVal = null;
		// 查询当前流程实例审批结束的历史节点
		List<HistoricActivityInstance> historicActivityInstances = historyService.createHistoricActivityInstanceQuery()
				.activityType("userTask").processInstanceId(instanceId).finished()
				.orderByHistoricActivityInstanceEndTime().desc().list();
		if (historicActivityInstances.size() > 0) {
			rtnVal = historicActivityInstances.get(0);
		}

		return rtnVal;
	}

	/**
	 * *************************************************************************
	 * ******************************<br>
	 * ********************************以上为查询流程驳回节点核心逻辑**************************
	 * *********************<br>
	 * *************************************************************************
	 * *******************************<br>
	 */

	/**
	 * *************************************************************************
	 * *******<br>
	 * **********************以下为根据 任务节点ID 获取流程各对象查询方法**********************<br>
	 * *************************************************************************
	 * ********<br>
	 */

	/**
	 * 根据任务ID获得任务实例
	 * 
	 * @param taskId
	 *            任务ID
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public TaskEntity findTaskById(String taskId) throws Exception {
		TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId(taskId).singleResult();
		if (task == null) {
			throw new AppException("该流程已不在您的审批节点!");
		}
		return task;
	}

	/**
	 * 根据流程实例ID和任务key值查询所有同级任务集合
	 * 
	 * @param processInstanceId
	 * @param key
	 * @return
	 */
	private List<Task> findTaskListByKey(String processInstanceId, String key) {
		return taskService.createTaskQuery().processInstanceId(processInstanceId).taskDefinitionKey(key).list();
	}

	/**
	 * 根据任务ID获取对应的流程实例
	 * 
	 * @param taskId
	 *            任务ID
	 * @return
	 * @throws Exception
	 */
	public ProcessInstance findProcessInstanceByTaskId(String taskId) throws Exception {
		// 找到流程实例
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
				.processInstanceId(findTaskById(taskId).getProcessInstanceId()).singleResult();
		if (processInstance == null) {
			throw new Exception("流程实例未找到!");
		}
		return processInstance;
	}

	/**
	 * 根据任务ID获取流程定义
	 * 
	 * @param taskId
	 *            任务ID
	 * @return
	 * @throws Exception
	 */
	private ProcessDefinitionEntity findProcessDefinitionEntityByTaskId(String taskId) throws Exception {
		// 取得流程定义
		ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
				.getDeployedProcessDefinition(findTaskById(taskId).getProcessDefinitionId());

		if (processDefinition == null) {
			throw new Exception("流程定义未找到!");
		}

		return processDefinition;
	}

	/**
	 * 根据任务ID和节点ID获取活动节点 <br>
	 * 
	 * @param taskId
	 *            任务ID
	 * @param activityId
	 *            活动节点ID <br>
	 *            如果为null或""，则默认查询当前活动节点 <br>
	 *            如果为"end"，则查询结束节点 <br>
	 * 
	 * @return
	 * @throws Exception
	 */
	public ActivityImpl findActivitiImpl(String taskId, String activityId) throws Exception {
		// 取得流程定义
		ProcessDefinitionEntity processDefinition = findProcessDefinitionEntityByTaskId(taskId);

		// 获取当前活动节点ID
		if (StringUtils.isEmpty(activityId)) {
			activityId = findTaskById(taskId).getTaskDefinitionKey();
		}

		// 根据流程定义，获取该流程实例的结束节点
		if (activityId.toUpperCase().equals("END")) {
			for (ActivityImpl activityImpl : processDefinition.getActivities()) {
				List<PvmTransition> pvmTransitionList = activityImpl.getOutgoingTransitions();
				if (pvmTransitionList.isEmpty()) {
					return activityImpl;
				}
			}
		}

		// 根据节点ID，获取对应的活动节点
		ActivityImpl activityImpl = ((ProcessDefinitionImpl) processDefinition).findActivity(activityId);

		return activityImpl;
	}

	public List<String> seqList(String taskId) {
		// 根据 taskid获取对应的流程实例对象
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		// 获取当前任务的节点id
		String taskKey = task.getTaskDefinitionKey();
		// 获取当前流程定义的ID
		String processDefinitionId = task.getProcessDefinitionId();
		// 根据流程定义ID获取bpmn文件的对象,
		BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);
		// 获取bpmn对象中所有sequenceFlow节点的对象
		List<SequenceFlow> sequences = bpmnModel.getMainProcess().findFlowElementsOfType(SequenceFlow.class);
		List<String> nameList = new ArrayList<String>();
		// 将当前任务的后的所有连接线名称加入到列表中
		for (SequenceFlow flow : sequences) {
			if (flow.getSourceRef().equals(taskKey)) {
				nameList.add(flow.getName());
			}
		}
		return nameList;
	}

	/**
	 * *************************************************************************
	 * *******<br>
	 * **********************以上为根据 任务节点ID 获取流程各对象查询方法**********************<br>
	 * *************************************************************************
	 * ********<br>
	 */

	/**
	 * 根据任务id，加签人进行加签
	 * 
	 * @param taskId
	 * @param assignee
	 */
	public void signAdd(String taskId, String assignee) {
		managementService.executeCommand(new SelfCountersignAddCmd(taskId, assignee));
	}

	/**
	 * 获取各个节点的具体的信息
	 * 
	 * @param processDefinitionId
	 *            流程定义id
	 * @return
	 */
	public List<Map<String, Object>> getProcessTrace(String processDefinitionId) throws Exception {
		List<Map<String, Object>> activityInfos = new ArrayList<Map<String, Object>>();
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId)
				.latestVersion().singleResult();
		ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
				.getDeployedProcessDefinition(pd.getId());
		List<ActivityImpl> activitiList = processDefinition.getActivities();// 所有节点信息

		for (ActivityImpl activity : activitiList) {
			Map<String, Object> activityInfo = new HashMap<String, Object>();
			activityInfo.put("width", activity.getWidth());
			activityInfo.put("height", activity.getHeight());
			activityInfo.put("act_x", activity.getX());
			activityInfo.put("act_y", activity.getY());
			activityInfo.put("act_id", activity.getId());
			activityInfo.put("act_name", activity.getProperty("name"));
			log.info("act_properties=" + activity.getProperties().toString());
			Object obj = activity.getProperty("taskDefinition");
			if (obj != null) {
				TaskDefinition taskDefinition = (TaskDefinition) obj;
				String expressionText = taskDefinition.getAssigneeExpression().getExpressionText();
				activityInfo.put("act_assignee", expressionText);
				System.out.println("act_assignee=" + expressionText);

			} else {
				activityInfo.put("act_assignee", "");
			}
			// 获取自定义属性
			@SuppressWarnings("unchecked")
			Map<String, List<ExtensionElement>> extensionMap = (Map<String, List<ExtensionElement>>) activity
					.getProperty(SelfExtensionConstans.EXTENSION_ELEMENT_OPERATIONS);
			if (extensionMap != null) {
				for (String key : extensionMap.keySet()) {
					List<ExtensionElement> extensionList = extensionMap.get(key);
					for (ExtensionElement en : extensionList) {
						String enName = en.getName();// 扩展字段名
						String enValue = en.getElementText();// 扩展字段值
						activityInfo.put(enName, enValue);
						log.info("en_name=" + enName + "en_value=" + enValue);
					}
				}
			}

			activityInfos.add(activityInfo);

		}

		return activityInfos;
	}

	/**
	 * 根据流程定义id 获取所有的节点审批人
	 */

	public List<Map<String, Object>> getDefAssigneeList(String processDefinitionId) throws Exception {
		List<Map<String, Object>> activityInfos = new ArrayList<Map<String, Object>>();
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId)
				.singleResult();
		ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
				.getDeployedProcessDefinition(pd.getId());
		List<ActivityImpl> activitiList = processDefinition.getActivities();

		for (ActivityImpl activity : activitiList) {
			// 节点类型
			String act_type = (String) activity.getProperty("type");
			// 只获取用户节点的信息
			if (!"userTask".equalsIgnoreCase(act_type)) {
				continue;
			}
			Map<String, Object> activityInfo = new HashMap<String, Object>();
			activityInfo.put("act_id", activity.getId());
			activityInfo.put("act_name", activity.getProperty("name"));
			activityInfo.put("act_type", act_type);
			log.info("act_properties=" + activity.getProperties().toString());
			Object obj = activity.getProperty("taskDefinition");
			// 审批组list
			List<String> groupList = new ArrayList<String>();
			// 共享人list
			List<String> userList = new ArrayList<String>();
			if (obj != null) {
				TaskDefinition taskDefinition = (TaskDefinition) obj;
				Expression exp = taskDefinition.getAssigneeExpression();
				// 共享组
				Set<Expression> setExp = taskDefinition.getCandidateGroupIdExpressions();

				// 共享人
				Set<Expression> setUser = taskDefinition.getCandidateUserIdExpressions();

				String expressionText = "";
				if (exp != null && !"".equals(exp)) {
					expressionText = exp.getExpressionText();
				}
				if (setExp != null) {
					Iterator<Expression> groupId = setExp.iterator();
					while (groupId.hasNext()) {
						Expression ess = groupId.next();
						String group = ess.getExpressionText();
						groupList.add(group);
					}
				}
				if (setUser != null) {
					Iterator<Expression> userId = setUser.iterator();
					while (userId.hasNext()) {
						Expression ess = userId.next();
						String user = ess.getExpressionText();
						userList.add(user);
					}
				}
				activityInfo.put("tag_assignee", expressionText);
				activityInfo.put("condidate_group", groupList);
				activityInfo.put("condidate_user", userList);

			} else {
				activityInfo.put("tag_assignee", "");
				activityInfo.put("condidate_group", groupList);
				activityInfo.put("condidate_user", userList);
			}
			// 获取自定义属性
			@SuppressWarnings("unchecked")
			Map<String, List<ExtensionElement>> extensionMap = (Map<String, List<ExtensionElement>>) activity
					.getProperty(SelfExtensionConstans.EXTENSION_ELEMENT_OPERATIONS);
			if (extensionMap != null) {
				for (String key : extensionMap.keySet()) {
					List<ExtensionElement> extensionList = extensionMap.get(key);
					for (ExtensionElement en : extensionList) {
						String enName = en.getName();// 扩展字段名
						String enValue = en.getElementText();// 扩展字段值
						activityInfo.put(enName, enValue);
						log.info("en_name=" + enName + "en_value=" + enValue);
					}
				}
			}

			activityInfos.add(activityInfo);

		}

		return activityInfos;
	}

	/**
	 * 根据inst_id,申请id，对应activiti的business_id,查询该流程实例当前节点信息，如审核人，节点信息
	 * 
	 * @return
	 */
	public Map<String, Object> tagInfo(String busId) {
		HistoricProcessInstance hisInstance = historyService.createHistoricProcessInstanceQuery()
				.processInstanceBusinessKey(busId).singleResult();
		// 结束时间
		Date endDate = hisInstance.getEndTime();
		// 流程实例id
		String procInstanceId = hisInstance.getId();
		// 当前节点id
		String curTagId = "";
		// 当前节点名称
		String curTagName = "";
		// 当前审核人
		String curTagAssignee = "";
		// 根据流程
		// 判断是否有结束时间，如果有说明该流程实例已经结束，如果没有，说明还在进行中
		if (endDate == null) {
			// 首先是根据流程ID获取当前任务：
			List<Task> tasks = taskService.createTaskQuery().processInstanceId(procInstanceId).list();
			// 获取一条task所在的任务节点上id
			Task task = tasks.get(0);
			curTagId = task.getTaskDefinitionKey();
			curTagName = task.getName();
			curTagAssignee = task.getAssignee();
		} else {
			curTagId = hisInstance.getEndActivityId();
			curTagName = "结束节点";
		}
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("cur_tag_id", curTagId);
		info.put("cur_tag_name", curTagName);
		info.put("cur_tag_assignee", curTagAssignee);
		return info;
	}

	/**
	 * 根据inst_id,申请id，对应activiti的business_id,查询该流程实例当前节点信息，如审核人，节点信息
	 * 
	 * @return
	 */
	public List<Map<String, Object>> tagInfoList(String busId) {
		// 根据流程
		List<Map<String, Object>> list = new ArrayList<>();
		// 查询已经经过的节点
		Map<String, Object> paMap = new HashMap<String, Object>();
		paMap.put("bus_id", busId);// 流程业务id，也是发起id
		List<Map<String, Object>> doList = actMapper.queryDoDeal(paMap);
		for (Map<String, Object> map : doList) {
			Map<String, Object> info = new HashMap<String, Object>();
			info.put("cur_tag_id", map.get("inst_tag"));
			info.put("cur_tag_name", map.get("inst_tag_name"));
			info.put("cur_tag_assignee", map.get("check_emp_id"));
			list.add(info);
		}

		return list;
	}

	/**
	 * 根据业务id，审批人，查询预处理节点信息
	 * 
	 * @throws Exception
	 * 
	 */
	public List<Map<String, Object>> preTagInfo(String busId) throws Exception {

		// 查询已经经过的节点
		Map<String, Object> paMap = new HashMap<String, Object>();
		paMap.put("bus_id", busId);// 流程业务id，也是发起id
		List<Map<String, Object>> tagList = actMapper.instTagList(paMap);
		HistoricProcessInstance hispro = historyService.createHistoricProcessInstanceQuery()
				.processInstanceBusinessKey(busId).singleResult();
		List<Map<String, Object>> allTagList = new ArrayList<Map<String, Object>>();
		if (hispro != null) {
			// 说明流程没结束
			allTagList = getDefAssigneeList(hispro.getProcessDefinitionId());
		}

		// 组装新的节点list
		List<Map<String, Object>> removeTagList = new ArrayList<Map<String, Object>>();

		for (Map<String, Object> allMap : allTagList) {
			String tagId = (String) allMap.get("act_id");// 节点id
			for (Map<String, Object> mp : tagList) {
				String mpTagId = (String) mp.get("act_id");// 节点id
				if (tagId.equals(mpTagId)) {
					// 说明已经经过该节点了
					removeTagList.add(allMap);
					break;
				}
			}
		}
		// 移出经过的节点，只留下剩下未经过的用户节点
		allTagList.removeAll(removeTagList);
		return allTagList;
	}

	/**
	 * 根据业务id，审批人，查询经过自己的预处理节点信息
	 * 
	 * @throws Exception
	 * 
	 */
	public List<Map<String, Object>> preSelfTagInfo(String busId, String assignee) throws Exception {

		// 查询剩下预经过的的节点
		List<Map<String, Object>> preList = preTagInfo(busId);
		// 判断是否经过过我节点
		List<Map<String, Object>> newTagList = new ArrayList<Map<String, Object>>();

		for (Map<String, Object> preMap : preList) {
			String act_assigne = (String) preMap.get("act_assignee");// 预节点审批人
			if (assignee.equals(act_assigne)) {
				newTagList.add(preMap);
			}

		}
		return newTagList;
	}

	/**
	 * 根据业务id，审批人，查询经过自己的,包含
	 * 
	 * @throws Exception
	 * 
	 */
	public List<Map<String, Object>> preSelfTagInfo(String busId, String checkEmpId, List<String> assigneeList)
			throws Exception {

		if (assigneeList == null || assigneeList.isEmpty()) {
			// 说明没有我要处理的节点，直接结束
			return new ArrayList<Map<String, Object>>();
		}
		// 查询剩下预经过的的节点
		List<Map<String, Object>> preList = preTagInfo(busId);
		// 判断是否经过过我节点
		List<Map<String, Object>> newTagList = new ArrayList<Map<String, Object>>();

		for (Map<String, Object> preMap : preList) {
			String act_assigne = (String) preMap.get("act_assignee");// 预节点审批人
			for (String assignee : assigneeList) {
				if (assignee.equals(act_assigne)) {
					// 把原处理人，更改为受托人就是当前登录人
					preMap.put("act_assignee", checkEmpId);
					newTagList.add(preMap);
				}
			}
		}
		return newTagList;
	}

	/**
	 * 根据业务id，查询经过的预处理的实例审批人
	 * 
	 * @throws Exception
	 * 
	 */
	public List<Map<String, Object>> preSelfTagInfo(String busId) throws Exception {

		// 查询剩下预经过的的节点
		// List<Map<String, Object>> preList= preTagInfo(busId);

		List<Map<String, Object>> preList = preTagProperties(busId);
		// List<Map<String, Object>> newList = new ArrayList(new
		// HashSet(preList));
		// 判断是否经过过我节点
		List<Map<String, Object>> newTagList = new ArrayList<Map<String, Object>>();

		for (Map<String, Object> preMap : preList) {

			String assignee = (String) preMap.get("act_assignee");
			// 候选人，共享审批人
			List<String> userList = (List) preMap.get("condidate_user");
			// 候选组
			List<String> groupList = (List) preMap.get("condidate_group");
			// 是否支持指定审批人
			String isassignee = (String) preMap.get("isassignee");
			if ("1".equals(isassignee)) {
				// 如果支持指定审批人，则该节点过滤掉
				continue;
			}
			// 说明有审批人
			Map<String, Object> checkMap = new HashMap<>();
			checkMap.put("check_emp_id", preMap.get("act_assignee"));
			checkMap.put("inst_tag", preMap.get("act_id"));
			checkMap.put("inst_tag_name", preMap.get("act_name"));
			checkMap.put("check_id", null);
			checkMap.put("arrive_date_time", null);
			checkMap.put("read_date_time", null);
			checkMap.put("task_id", null);
			if (assignee != null && !"".equals(assignee)) {
				newTagList.add(checkMap);
			} else {
				// 如果为空，则判断是否有候选人
				if (userList != null && userList.size() > 0) {
					for (String empId : userList) {
						Map<String, Object> empMap = new HashMap<String, Object>();
						empMap.putAll(checkMap);
						empMap.put("check_emp_id", empId);
						newTagList.add(empMap);
					}
				} else {
					// 如果候选人为空，判断是否有候选组
					if (groupList != null && groupList.size() > 0) {
						// 根据候选组查询候选组里面的审批人
						// 查询该候选组里面有多少人
						List<Map<String, Object>> roleUserList = processCommonService.roleUsers(groupList);
						for (Map<String, Object> groupMap : roleUserList) {
							Map<String, Object> empMap = new HashMap<String, Object>();
							empMap.putAll(checkMap);
							empMap.put("check_emp_id", (String) groupMap.get("emp_id"));
							newTagList.add(empMap);
						}
					} else {
						// 如果也没有候选组，则判断是否是主管领导审批，获取节点主管领导审批属性
						// 当前节点id等于该节点id,获取主分管信息
						String upmanage = (String) preMap.get("upmanage");
						// 获取到流程实例信息
						FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(busId);
						if (upmanage != null && !"".equals(upmanage)) {
							// HistoricActivityInstance
							// hisActInstance=actProcessService.findHistoricUserTask(instanceId);
							HistoricActivityInstance hisActInstance = null;
							// 查询当前流程实例审批结束的历史节点
							List<HistoricActivityInstance> historicActivityInstances = historyService
									.createHistoricActivityInstanceQuery().activityType("userTask")
									.processInstanceId(busId).finished().orderByHistoricActivityInstanceEndTime().desc()
									.list();
							if (historicActivityInstances.size() > 0) {
								hisActInstance = historicActivityInstances.get(0);
							}
							// 说明还没有节点审批完成
							if (hisActInstance == null) {
								// 主分管(0:发起人主管,1:发起人分管,2:前一审批人主管,3:前一审批人分管)
								if ("0".equals(upmanage) || "1".equals(upmanage) || "2".equals(upmanage)
										|| "3".equals(upmanage) || "4".equals(upmanage)) {
									Map<String, Object> paramMap = new HashMap<String, Object>();
									paramMap.put("emp_id", fbBusInst.getApplyId());// 发起人id
									paramMap.put("org_id", fbBusInst.getOrgId());// 发起人部门
									List<Map<String, Object>> dataLi = (List<Map<String, Object>>) secService
											.upManageSearch(paramMap);
									if ("0".equals(upmanage) && null != dataLi && !dataLi.isEmpty()) {// 一级审批人
										for (Map<String, Object> dataMap : dataLi) {
											int checkOrder = (int) dataMap.get("check_order");
											if (1 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									} else if ("1".equals(upmanage) && null != dataLi && !dataLi.isEmpty()) {// 二级审批人
										for (Map<String, Object> dataMap : dataLi) {
											int checkOrder = (int) dataMap.get("check_order");
											if (2 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									} else if ("2".equals(upmanage) && null != dataLi && !dataLi.isEmpty()) {// 三级审批人
										for (Map<String, Object> dataMap : dataLi) {
											int checkOrder = (int) dataMap.get("check_order");
											if (3 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									} else if ("3".equals(upmanage) && null != dataLi && !dataLi.isEmpty()) {// 四级审批人
										for (Map<String, Object> dataMap : dataLi) {
											int checkOrder = (int) dataMap.get("check_order");
											if (4 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									} else if ("4".equals(upmanage) && null != dataLi && !dataLi.isEmpty()) {// 五级审批人
										for (Map<String, Object> dataMap : dataLi) {
											int checkOrder = (int) dataMap.get("check_order");
											if (5 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}

								}
							} else {
								// 如果上一任务节点id，不等于当前创建的任务节点id，说明跳转节点了，那么在查询主管信息
								// 主分管(0:发起人主管,1:发起人分管,2:前一审批人主管,3:前一审批人分管)
								if ("0".equals(upmanage) || "1".equals(upmanage) || "2".equals(upmanage)
										|| "3".equals(upmanage) || "4".equals(upmanage)) {
									Map<String, Object> paramMap = new HashMap<String, Object>();
									paramMap.put("emp_id", fbBusInst.getApplyId());// 发起人id
									paramMap.put("org_id", fbBusInst.getOrgId());// 发起人部门
									List<Map<String, Object>> dataLi = (List<Map<String, Object>>) secService
											.upManageSearch(paramMap);
									if ("0".equals(upmanage) && null != dataLi && !dataLi.isEmpty()) {// 一级审批人
										for (Map<String, Object> dataMap : dataLi) {
											int checkOrder = (int) dataMap.get("check_order");
											if (1 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									} else if ("1".equals(upmanage) && null != dataLi && !dataLi.isEmpty()) {// 二级审批人
										for (Map<String, Object> dataMap : dataLi) {
											int checkOrder = (int) dataMap.get("check_order");
											if (2 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									} else if ("2".equals(upmanage) && null != dataLi && !dataLi.isEmpty()) {// 三级审批人
										for (Map<String, Object> dataMap : dataLi) {
											int checkOrder = (int) dataMap.get("check_order");
											if (3 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									} else if ("3".equals(upmanage) && null != dataLi && !dataLi.isEmpty()) {// 四级审批人
										for (Map<String, Object> dataMap : dataLi) {
											int checkOrder = (int) dataMap.get("check_order");
											if (4 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									} else if ("4".equals(upmanage) && null != dataLi && !dataLi.isEmpty()) {// 五级审批人
										for (Map<String, Object> dataMap : dataLi) {
											int checkOrder = (int) dataMap.get("check_order");
											if (5 == checkOrder) {
												assignee = (String) dataMap.get("check_emp_id");
											}
										}
									}
								}
								/**
								 * else if("2".equals(upmanage) ||
								 * "3".equals(upmanage)){ Map<String , Object>
								 * paramMap=new HashMap<String , Object>();
								 * paramMap.put("emp_id",
								 * beforAssignee);//上一节点审批人id Map<String,
								 * Object>
								 * dataMap=secService.manageSearch(paramMap);
								 * if("2".equals(upmanage)){
								 * assignee=(String)dataMap.get("manage_emp_id")
								 * ;//主管领导 }else if("3".equals(upmanage)){
								 * assignee=(String)dataMap.get("charge_emp_id")
								 * ;//分管领导 } }
								 **/
							}
							if (assignee != null && !"".equals(assignee)) {
								Map<String, Object> empMap = new HashMap<String, Object>();
								empMap.putAll(checkMap);
								empMap.put("check_emp_id", assignee);
								newTagList.add(empMap);
							}

						}
					}
				}

			}

		}

		return newTagList;
	}

	/**
	 * 查询所有未完成的 流程实例
	 * 
	 * @throws Exception
	 * 
	 */
	public List<Map<String, Object>> preInstList() throws Exception {
		// 查询未完成的流程实例
		// List<HistoricProcessInstance>
		// instanceList=historyService.createHistoricProcessInstanceQuery().unfinished().list();
		return null;
	}

	/**
	 * 查询所有已经完成的节点信息
	 * 
	 * @throws Exception
	 * 
	 */
	public List<Map<String, Object>> instfinishTagList(String busId) throws Exception {
		// 查询已经完成的用户节点
		Map<String, Object> map = new HashMap<>();
		map.put("bus_id", busId);// 流程业务id，也是发起id
		List<Map<String, Object>> finishTagList = actMapper.instfinishTagList(map);
		return finishTagList;
	}

	public List<Map<String, Object>> backTagList(Map<String, Object> appMap) throws Exception {
		String instId = (String) appMap.get("inst_id");
		// 查该流程已经审批过的节点（为了过滤自动跳过的节点）
		FbBusCheckExample checkExample = new FbBusCheckExample();
		checkExample.createCriteria().andInstIdEqualTo(instId);
		List<FbBusCheck> checkList = fbBusCheckMapper.selectByExample(checkExample);
		List<String> tagList = new ArrayList<String>();

		String taskId = (String) appMap.get("task_id");
		List<ActivityImpl> actImpList = findBackAvtivity(taskId);
		List<Map<String, Object>> backList = new ArrayList<>();
		for (ActivityImpl act : actImpList) {
			String actId = act.getId();// 节点id
			if (!"form_start".equals(actId)) {
				if (null != checkList && !checkList.isEmpty()) {
					for (FbBusCheck fbBusCheck : checkList) {
						String checkInstTag = fbBusCheck.getInstTag();
						tagList.add(checkInstTag);
					}
				}
				if (!tagList.contains(actId)) {
					continue;
				}
			}

			String actName = (String) act.getProperty("name");// 节点名称
			Map<String, Object> backMap = new HashMap<String, Object>();
			backMap.put("finish_tag_id", actId);
			backMap.put("finish_tag_name", actName);
			backList.add(backMap);
		}
		return backList;
	}

	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void deleteInst(String instId, String reson) {
		// 根据业务id，查询流程实例id
		HistoricProcessInstance hisInstance = historyService.createHistoricProcessInstanceQuery()
				.processInstanceBusinessKey(instId).singleResult();
		String procesInstanceId = hisInstance.getId();
		// 判断流程是否结束
		if (hisInstance.getEndTime() == null) {// 说明没有结束
			runtimeService.deleteProcessInstance(procesInstanceId, reson);
			historyService.deleteHistoricProcessInstance(procesInstanceId);// (顺序不能换)
		} else {
			// 流程已经结束：
			historyService.deleteHistoricProcessInstance(procesInstanceId);
			// runtimeService.suspendProcessInstanceById(procesInstanceId);
		}

	}

	/**
	 * 根据业务id，查询待办+预处理列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public List<Map<String, Object>> queryDoDeal(String instId) throws Exception {
		// 查询已经经过的节点
		Map<String, Object> paMap = new HashMap<String, Object>();
		paMap.put("bus_id", instId);// 流程业务id，也是发起id
		List<Map<String, Object>> doList = actMapper.queryDoDeal(paMap);
		// 查询预处理的待办列表
		List<Map<String, Object>> preList = preSelfTagInfo(instId);
		doList.addAll(preList);
		return doList;
	}

	/**
	 * 根据任务id查询当前实例所在的节点
	 * 
	 * @param taskId
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public List<Map<String, Object>> curTaskTagList(String taskId) {
		// 获得当前任务的所有节点 /****/
		// 根据 taskid获取对应的流程实例对象
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		// 获取当前流程定义的ID
		String processDefinitionId = task.getProcessDefinitionId();

		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId)
				.latestVersion().singleResult();
		ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
				.getDeployedProcessDefinition(pd.getId());
		List<ActivityImpl> activitiList = processDefinition.getActivities();
		// 根据实例id，查询当前节点运行的节点信息
		List<String> ActiveActivityIds = runtimeService.getActiveActivityIds(task.getProcessInstanceId());

		List<ActivityImpl> actImpls = new ArrayList<ActivityImpl>();
		List<Map<String, Object>> activityInfos = new ArrayList<Map<String, Object>>();

		for (String activeId : ActiveActivityIds) {
			for (ActivityImpl activityImpl : activitiList) {
				String id = activityImpl.getId();
				if (activityImpl.isScope()) {
					if (activityImpl.getActivities().size() > 1) {
						List<ActivityImpl> subAcList = activityImpl.getActivities();
						for (ActivityImpl subActImpl : subAcList) {
							String subid = subActImpl.getId();
							System.out.println("subImpl:" + subid);
							if (activeId.equals(subid)) {
								// 获得执行到那个节点
								actImpls.add(subActImpl);
								break;
							}
						}
					}
				}
				if (activeId.equals(id)) {
					// 获得执行到那个节点
					actImpls.add(activityImpl);
					System.out.println(id);
				}
			}
		}

		for (ActivityImpl activity : activitiList) {
			// 节点类型
			String act_type = (String) activity.getProperty("type");
			// 只获取用户节点的信息
			if (!"userTask".equalsIgnoreCase(act_type)) {
				continue;
			}
			Map<String, Object> activityInfo = new HashMap<String, Object>();
			activityInfo.put("act_id", activity.getId());
			activityInfo.put("act_name", activity.getProperty("name"));
			activityInfo.put("act_type", act_type);
			log.info("act_properties=" + activity.getProperties().toString());
			Object obj = activity.getProperty("taskDefinition");
			if (obj != null) {
				TaskDefinition taskDefinition = (TaskDefinition) obj;
				Expression exp = taskDefinition.getAssigneeExpression();
				Set<Expression> setExp = taskDefinition.getCandidateGroupIdExpressions();
				String expressionText = "";
				Iterator<Expression> groupId = null;
				if (exp != null && !"".equals(exp)) {
					expressionText = taskDefinition.getAssigneeExpression().getExpressionText();
				}
				if (setExp != null) {
					groupId = setExp.iterator();
				}
				activityInfo.put("act_assignee", expressionText);
				activityInfo.put("act_condidate_group", groupId);

			} else {
				activityInfo.put("act_assignee", "");
				activityInfo.put("act_condidate_group", null);
			}
			// 获取自定义属性
			@SuppressWarnings("unchecked")
			Map<String, List<ExtensionElement>> extensionMap = (Map<String, List<ExtensionElement>>) activity
					.getProperty(SelfExtensionConstans.EXTENSION_ELEMENT_OPERATIONS);
			if (extensionMap != null) {
				for (String key : extensionMap.keySet()) {
					List<ExtensionElement> extensionList = extensionMap.get(key);
					for (ExtensionElement en : extensionList) {
						String enName = en.getName();// 扩展字段名
						String enValue = en.getElementText();// 扩展字段值
						activityInfo.put(enName, enValue);
						log.info("en_name=" + enName + "en_value=" + enValue);
					}
				}
			}

			activityInfos.add(activityInfo);

		}

		return activityInfos;

	}

	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Boolean finished(String busId) {
		Boolean flag = false;
		HistoricProcessInstance hisInstance = historyService.createHistoricProcessInstanceQuery()
				.processInstanceBusinessKey(busId).singleResult();
		if (hisInstance == null) {
			flag = true;
		} else {
			// 结束时间
			Date endDate = hisInstance.getEndTime();
			if (endDate != null) {// 时间不为空，说明已经结束了
				flag = true;
			}
		}

		return flag;
	}

	/**
	 * 根据taskId判断该任务是否是多人共享任务,如果传入认领人,则认领
	 * 
	 * @return
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Boolean taskIdLinks(String taskId, String assignee) {

		Boolean taskType = false;
		List<IdentityLink> idLinklist = taskService.getIdentityLinksForTask(taskId);
		for (IdentityLink link : idLinklist) {
			String LinkType = link.getType();
			if ("candidate".equals(LinkType)) {// 说明是共享任务
				taskType = true;
			} else if ("assignee".equals(LinkType)) {// 说明有认领人
				taskType = false;
				break;
			}
		}

		if (taskType) {// 说明共享任务没有人认领
			if (assignee != null && !"".equals(assignee)) {
				taskService.claim(taskId, assignee);
			}
		}

		return taskType;
	}

	/**
	 * 下一节点属性
	 * 
	 * @return
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public List<Map<String, Object>> nextTagProperties(String instId) {
		// 获取流程实例
		HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery()
				.processInstanceBusinessKey(instId).singleResult();
		// 获取流程定义
		ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
				.getDeployedProcessDefinition(processInstance.getProcessDefinitionId());
		// 查询当前实例所在的节点
		List<HistoricActivityInstance> hisActList = historyService.createHistoricActivityInstanceQuery()
				.activityType("userTask").processInstanceId(processInstance.getId()).unfinished().list();
		// 获取节点属性
		List<Map<String, Object>> activityInfos = new ArrayList<Map<String, Object>>();
		// 获取流程定义
		for (HistoricActivityInstance hisAct : hisActList) {
			// 当前节点id
			String activityId = hisAct.getActivityId();
			// 获取流出节点
			// 根据节点ID，获取对应的活动节点
			ActivityImpl activityImpl = ((ProcessDefinitionImpl) processDefinition).findActivity(activityId);
			// 该活动节点流出的节点
			List<PvmTransition> pvmTransitionList = activityImpl.getOutgoingTransitions();
			for (PvmTransition pvmTransition : pvmTransitionList) {
				PvmActivity pvmAct = pvmTransition.getDestination();
				ActivityImpl nextAct = ((ActivityImpl) pvmAct);
				List<ActivityImpl> nextActivityImpList = nextTagList(nextAct);
				for (ActivityImpl activity : nextActivityImpList) {
					// 节点类型
					String act_type = (String) activity.getProperty("type");
					// 只获取用户节点的信息
					if (!"userTask".equalsIgnoreCase(act_type)) {
						continue;
					}
					Map<String, Object> activityInfo = new HashMap<String, Object>();
					activityInfo.put("tag_id", activity.getId());
					activityInfo.put("tag_name", activity.getProperty("name"));
					// activityInfo.put("act_type", act_type);
					log.info("act_properties=" + activity.getProperties().toString());
					Object obj = activity.getProperty("taskDefinition");
					// 审批组list
					List<String> groupList = new ArrayList<String>();
					// 共享人list
					List<String> userList = new ArrayList<String>();
					if (obj != null) {
						TaskDefinition taskDefinition = (TaskDefinition) obj;
						Expression exp = taskDefinition.getAssigneeExpression();
						// 共享组
						Set<Expression> setExp = taskDefinition.getCandidateGroupIdExpressions();

						// 共享人
						Set<Expression> setUser = taskDefinition.getCandidateUserIdExpressions();

						String expressionText = "";
						if (exp != null && !"".equals(exp)) {
							expressionText = exp.getExpressionText();
						}
						if (setExp != null) {
							Iterator<Expression> groupId = setExp.iterator();
							while (groupId.hasNext()) {
								Expression ess = groupId.next();
								String group = ess.getExpressionText();
								groupList.add(group);
							}
						}
						if (setUser != null) {
							Iterator<Expression> userId = setUser.iterator();
							while (userId.hasNext()) {
								Expression ess = userId.next();
								String user = ess.getExpressionText();
								userList.add(user);
							}
						}
						activityInfo.put("tag_assignee", expressionText);
						activityInfo.put("condidate_group", groupList);
						activityInfo.put("condidate_user", userList);

					} else {
						activityInfo.put("tag_assignee", "");
						activityInfo.put("condidate_group", groupList);
						activityInfo.put("condidate_user", userList);
					}
					// 获取自定义属性
					@SuppressWarnings("unchecked")
					Map<String, List<ExtensionElement>> extensionMap = (Map<String, List<ExtensionElement>>) activity
							.getProperty(SelfExtensionConstans.EXTENSION_ELEMENT_OPERATIONS);
					if (extensionMap != null) {
						for (String key : extensionMap.keySet()) {
							List<ExtensionElement> extensionList = extensionMap.get(key);
							for (ExtensionElement en : extensionList) {
								String enName = en.getName();// 扩展字段名
								String enValue = en.getElementText();// 扩展字段值
								activityInfo.put(enName, enValue);
								log.info("en_name=" + enName + "en_value=" + enValue);
							}
						}
					}

					activityInfos.add(activityInfo);

				}
			}

		}
		return activityInfos;
	}

	/**
	 * 根据发布id，当前节点id，查询下一节点属性信息
	 * 
	 * @param deploymentId
	 * @param curTagId
	 * @return
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public List<Map<String, Object>> nextTagProperties(String deploymentId, String curTagId) {
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().deploymentId(deploymentId)
				.latestVersion().singleResult();
		// 获取流程定义
		ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
				.getDeployedProcessDefinition(pd.getId());
		// 获取节点属性
		List<Map<String, Object>> activityInfos = new ArrayList<Map<String, Object>>();

		// 当前节点id
		String activityId = curTagId;
		// 获取流出节点
		// 根据节点ID，获取对应的活动节点
		ActivityImpl activityImpl = ((ProcessDefinitionImpl) processDefinition).findActivity(activityId);
		if (activityImpl == null) {
			// 如果为空，说明没有这样的节点
			return activityInfos;
		}
		// 该活动节点流出的节点
		List<PvmTransition> pvmTransitionList = activityImpl.getOutgoingTransitions();
		for (PvmTransition pvmTransition : pvmTransitionList) {
			PvmActivity pvmAct = pvmTransition.getDestination();
			ActivityImpl nextAct = ((ActivityImpl) pvmAct);
			List<ActivityImpl> nextActivityImpList = nextTagList(nextAct);
			for (ActivityImpl activity : nextActivityImpList) {
				// 节点类型
				String act_type = (String) activity.getProperty("type");
				// 只获取用户节点的信息
				if (!"userTask".equalsIgnoreCase(act_type)) {
					continue;
				}
				Map<String, Object> activityInfo = new HashMap<String, Object>();
				activityInfo.put("tag_id", activity.getId());
				activityInfo.put("tag_name", activity.getProperty("name"));
				// activityInfo.put("act_type", act_type);
				log.info("act_properties=" + activity.getProperties().toString());
				Object obj = activity.getProperty("taskDefinition");
				// 审批组list
				List<String> groupList = new ArrayList<String>();
				// 共享人list
				List<String> userList = new ArrayList<String>();
				if (obj != null) {
					TaskDefinition taskDefinition = (TaskDefinition) obj;
					Expression exp = taskDefinition.getAssigneeExpression();
					// 共享组
					Set<Expression> setExp = taskDefinition.getCandidateGroupIdExpressions();

					// 共享人
					Set<Expression> setUser = taskDefinition.getCandidateUserIdExpressions();

					String expressionText = "";
					if (exp != null && !"".equals(exp)) {
						expressionText = exp.getExpressionText();
					}
					if (setExp != null) {
						Iterator<Expression> groupId = setExp.iterator();
						while (groupId.hasNext()) {
							Expression ess = groupId.next();
							String group = ess.getExpressionText();
							groupList.add(group);
						}
					}
					if (setUser != null) {
						Iterator<Expression> userId = setUser.iterator();
						while (userId.hasNext()) {
							Expression ess = userId.next();
							String user = ess.getExpressionText();
							userList.add(user);
						}
					}
					activityInfo.put("tag_assignee", expressionText);
					activityInfo.put("condidate_group", groupList);
					activityInfo.put("condidate_user", userList);

				} else {
					activityInfo.put("tag_assignee", "");
					activityInfo.put("condidate_group", groupList);
					activityInfo.put("condidate_user", userList);
				}
				// 获取自定义属性
				@SuppressWarnings("unchecked")
				Map<String, List<ExtensionElement>> extensionMap = (Map<String, List<ExtensionElement>>) activity
						.getProperty(SelfExtensionConstans.EXTENSION_ELEMENT_OPERATIONS);
				if (extensionMap != null) {
					for (String key : extensionMap.keySet()) {
						List<ExtensionElement> extensionList = extensionMap.get(key);
						for (ExtensionElement en : extensionList) {
							String enName = en.getName();// 扩展字段名
							String enValue = en.getElementText();// 扩展字段值
							activityInfo.put(enName, enValue);
							log.info("en_name=" + enName + "en_value=" + enValue);
						}
					}
				}

				activityInfos.add(activityInfo);

			}
		}

		return activityInfos;
	}

	/**
	 * 当前节点查询下一节点
	 * 
	 * @param act
	 * @return
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public List<ActivityImpl> nextTagList(ActivityImpl nextAct) {
		// 下一个节点list
		List<ActivityImpl> actListImpl = new ArrayList<ActivityImpl>();
		// 如果是用户节点就统计上
		if ("userTask".equals(nextAct.getProperty("type"))) {
			actListImpl.add(nextAct);
		} else if ("exclusiveGateway".equals(nextAct.getProperty("type"))
				|| "parallelGateway".equals(nextAct.getProperty("type"))) {
			// 如果是排他分支网关或者并行网关
			List<PvmTransition> outTransitionsTemp = nextAct.getOutgoingTransitions();
			for (PvmTransition tr1 : outTransitionsTemp) {
				List<ActivityImpl> newActListImpl = nextTagList((ActivityImpl) tr1.getDestination());
				actListImpl.addAll(newActListImpl);
			}
		}
		return actListImpl;

	}

	/**
	 * 查询流程启动时设置排他网关判断条件信息
	 * 
	 * @param String
	 *            gatewayId 排他网关Id信息, 流程启动时设置网关路线判断条件key为网关Id信息
	 * @param String
	 *            processInstanceId 流程实例Id信息
	 * @return
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public String getGatewayCondition(String gatewayId, String processInstanceId) {
		Execution execution = runtimeService.createExecutionQuery().processInstanceId(processInstanceId).singleResult();
		Object object = runtimeService.getVariable(execution.getId(), gatewayId);
		return object == null ? "" : object.toString();
	}

	/**
	 * 根据key和value判断el表达式是否通过信息
	 * 
	 * @param String
	 *            key el表达式key信息
	 * @param String
	 *            el el表达式信息
	 * @param String
	 *            value el表达式传入值信息
	 * @return
	 */
	public boolean isCondition(String key, String el, String value) {
		org.activiti.engine.impl.javax.el.ExpressionFactory factory = new ExpressionFactoryImpl();
		SimpleContext context = new SimpleContext();
		context.setVariable(key, factory.createValueExpression(value, String.class));
		ValueExpression e = factory.createValueExpression(context, el, boolean.class);
		return (Boolean) e.getValue(context);
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
	 * 预处理节点属性
	 * 
	 * @return
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public List<Map<String, Object>> preTagProperties(String instId) {
		log.info("----pre instId=" + instId);
		// 获取流程实例
		HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery()
				.processInstanceBusinessKey(instId).singleResult();
		if (processInstance == null) {
			// 如果是结束的流程，不存在实例信息
			return new ArrayList<>();
		}
		// 获取流程定义
		ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
				.getDeployedProcessDefinition(processInstance.getProcessDefinitionId());
		// 查询当前实例所在的节点
		List<HistoricActivityInstance> hisActList = historyService.createHistoricActivityInstanceQuery()
				.activityType("userTask").processInstanceId(processInstance.getId()).unfinished().list();
		// 获取节点属性
		List<Map<String, Object>> activityInfos = new ArrayList<Map<String, Object>>();
		// 获取流程定义
		for (HistoricActivityInstance hisAct : hisActList) {
			// 当前节点id
			String activityId = hisAct.getActivityId();
			// 获取流出节点
			// 根据节点ID，获取对应的活动节点
			ActivityImpl activityImpl = ((ProcessDefinitionImpl) processDefinition).findActivity(activityId);
			// 该活动节点流出的节点
			List<PvmTransition> pvmTransitionList = activityImpl.getOutgoingTransitions();
			for (PvmTransition pvmTransition : pvmTransitionList) {
				PvmActivity pvmAct = pvmTransition.getDestination();
				ActivityImpl nextAct = ((ActivityImpl) pvmAct);
				List<ActivityImpl> nextActivityImpList = preTagList(nextAct);
				for (ActivityImpl activity : nextActivityImpList) {
					// 节点类型
					String act_type = (String) activity.getProperty("type");
					// 只获取用户节点的信息
					if (!"userTask".equalsIgnoreCase(act_type)) {
						continue;
					}
					Map<String, Object> activityInfo = new HashMap<String, Object>();
					activityInfo.put("act_id", activity.getId());
					activityInfo.put("act_name", activity.getProperty("name"));
					// activityInfo.put("act_type", act_type);
					log.info("act_properties=" + activity.getProperties().toString());
					Object obj = activity.getProperty("taskDefinition");
					// 审批组list
					List<String> groupList = new ArrayList<String>();
					// 共享人list
					List<String> userList = new ArrayList<String>();
					if (obj != null) {
						TaskDefinition taskDefinition = (TaskDefinition) obj;
						Expression exp = taskDefinition.getAssigneeExpression();
						// 共享组
						Set<Expression> setExp = taskDefinition.getCandidateGroupIdExpressions();

						// 共享人
						Set<Expression> setUser = taskDefinition.getCandidateUserIdExpressions();

						String expressionText = "";
						if (exp != null && !"".equals(exp)) {
							expressionText = exp.getExpressionText();
						}
						if (setExp != null) {
							Iterator<Expression> groupId = setExp.iterator();
							while (groupId.hasNext()) {
								Expression ess = groupId.next();
								String group = ess.getExpressionText();
								groupList.add(group);
							}
						}
						if (setUser != null) {
							Iterator<Expression> userId = setUser.iterator();
							while (userId.hasNext()) {
								Expression ess = userId.next();
								String user = ess.getExpressionText();
								userList.add(user);
							}
						}
						activityInfo.put("act_assignee", expressionText);
						activityInfo.put("condidate_group", groupList);
						activityInfo.put("condidate_user", userList);

					} else {
						activityInfo.put("act_assignee", "");
						activityInfo.put("condidate_group", groupList);
						activityInfo.put("condidate_user", userList);
					}
					// 获取自定义属性
					@SuppressWarnings("unchecked")
					Map<String, List<ExtensionElement>> extensionMap = (Map<String, List<ExtensionElement>>) activity
							.getProperty(SelfExtensionConstans.EXTENSION_ELEMENT_OPERATIONS);
					if (extensionMap != null) {
						for (String key : extensionMap.keySet()) {
							List<ExtensionElement> extensionList = extensionMap.get(key);
							for (ExtensionElement en : extensionList) {
								String enName = en.getName();// 扩展字段名
								String enValue = en.getElementText();// 扩展字段值
								activityInfo.put(enName, enValue);
								log.info("en_name=" + enName + "en_value=" + enValue);
							}
						}
					}

					activityInfos.add(activityInfo);

				}
			}

		}

		// 去重
		List<Map<String, Object>> preList = new ArrayList<Map<String, Object>>();
		// 由于迭代出现重复数据，排除重复
		for (int i = 0; i < activityInfos.size(); i++) {
			if (!preList.contains(activityInfos.get(i)))
				preList.add(activityInfos.get(i));
		}
		return preList;
	}

	/**
	 * 当前节点查询下一节点
	 * 
	 * @param act
	 * @return
	 */
	public List<ActivityImpl> preTagList(ActivityImpl nextAct) {
		// 下一个节点list
		List<ActivityImpl> actListImpl = new ArrayList<ActivityImpl>();
		// 如果是用户节点就统计上
		if ("userTask".equalsIgnoreCase((String) nextAct.getProperty("type"))) {
			actListImpl.add(nextAct);
			// 如果是排他分支网关或者并行网关
			List<PvmTransition> outTransitionsTemp = nextAct.getOutgoingTransitions();
			for (PvmTransition tr1 : outTransitionsTemp) {
				List<ActivityImpl> newActListImpl = preTagList((ActivityImpl) tr1.getDestination());
				actListImpl.addAll(newActListImpl);
			}
		} else if ("parallelGateway".equalsIgnoreCase((String) nextAct.getProperty("type"))) {
			// 如果是并行网关
			List<PvmTransition> outTransitionsTemp = nextAct.getOutgoingTransitions();
			for (PvmTransition tr1 : outTransitionsTemp) {
				List<ActivityImpl> newActListImpl = preTagList((ActivityImpl) tr1.getDestination());
				actListImpl.addAll(newActListImpl);
			}
		} else if ("exclusiveGateway".equalsIgnoreCase((String) nextAct.getProperty("type"))) {
			// 如果是分支节点则返回
			return actListImpl;
		} else if ("endEvent".equalsIgnoreCase((String) nextAct.getProperty("type"))) {
			// 如果是结束节点
			return actListImpl;
		}
		return actListImpl;

	}

	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.NOT_SUPPORTED)
	public void taskComplete(String taskId, Map<String, Object> variables) {
		taskService.complete(taskId, variables);
	}

	/**
	 * 判断该任务是否完成
	 * 
	 * @param busId
	 * @return
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Boolean taskFinished(String taskId) {
		Boolean flag = false;
		TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId(taskId).singleResult();
		if (task == null) {
			// 如果为空说明任务已完成
			flag = true;
		}
		return flag;
	}
}
