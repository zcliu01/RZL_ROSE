package com.zrt.flow.service.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.ExclusiveGateway;
import org.activiti.bpmn.model.UserTask;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.editor.language.json.converter.SelfBpmnJsonConverter;
import org.activiti.editor.language.json.converter.SelfExclusiveGatewayJsonConverter;
import org.activiti.editor.language.json.converter.SelfUserTaskJsonConverter;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.AppException;
import com.zrt.commons.PageInit;
import com.zrt.commons.cons.Constants;
import com.zrt.commons.date.DateUtil;
import com.zrt.flow.mapper.flowself.FlowselfMapper;
import com.zrt.flow.service.act.ActProcessService;
import com.zrt.flow.service.contacts.ContactsService;
import com.zrt.flow.service.handle.HandleService;
import com.zrt.flow.service.runnable.RunnableService;
import com.zrt.flow.service.sec.SecService;
import com.zrt.flow.service.serial.SerialService;
import com.zrt.mybatis.domain.FbBusAddSign;
import com.zrt.mybatis.domain.FbBusCheck;
import com.zrt.mybatis.domain.FbBusCheckExample;
import com.zrt.mybatis.domain.FbBusCheckExample.Criteria;
import com.zrt.mybatis.domain.FbBusCondition;
import com.zrt.mybatis.domain.FbBusData;
import com.zrt.mybatis.domain.FbBusDataExample;
import com.zrt.mybatis.domain.FbBusFile;
import com.zrt.mybatis.domain.FbBusFileExample;
import com.zrt.mybatis.domain.FbBusFm;
import com.zrt.mybatis.domain.FbBusFmExample;
import com.zrt.mybatis.domain.FbBusHandleExample;
import com.zrt.mybatis.domain.FbBusInst;
import com.zrt.mybatis.domain.FbBusJoinSign;
import com.zrt.mybatis.domain.FbBusJoinSignExample;
import com.zrt.mybatis.domain.FbBusJoinSignFile;
import com.zrt.mybatis.domain.FbBusJoinSignRelevance;
import com.zrt.mybatis.domain.FbBusProjectExample;
import com.zrt.mybatis.domain.FbBusRelevance;
import com.zrt.mybatis.domain.FbBusRelevanceExample;
import com.zrt.mybatis.domain.FbBusRemind;
import com.zrt.mybatis.domain.FbBusTemplate;
import com.zrt.mybatis.domain.FbBusTemplateExample;
import com.zrt.mybatis.domain.FmBusFile;
import com.zrt.mybatis.domain.FmBusFileExample;
import com.zrt.mybatis.domain.FmBusRelevance;
import com.zrt.mybatis.domain.FmBusRelevanceExample;
import com.zrt.mybatis.domain.FmBusTemplateWithBLOBs;
import com.zrt.mybatis.mapper.FbBusAddSignMapper;
import com.zrt.mybatis.mapper.FbBusCheckMapper;
import com.zrt.mybatis.mapper.FbBusConditionMapper;
import com.zrt.mybatis.mapper.FbBusDataMapper;
import com.zrt.mybatis.mapper.FbBusFileMapper;
import com.zrt.mybatis.mapper.FbBusFmMapper;
import com.zrt.mybatis.mapper.FbBusHandleMapper;
import com.zrt.mybatis.mapper.FbBusInstMapper;
import com.zrt.mybatis.mapper.FbBusJoinSignFileMapper;
import com.zrt.mybatis.mapper.FbBusJoinSignMapper;
import com.zrt.mybatis.mapper.FbBusJoinSignRelevanceMapper;
import com.zrt.mybatis.mapper.FbBusProjectMapper;
import com.zrt.mybatis.mapper.FbBusRejectRuleMapper;
import com.zrt.mybatis.mapper.FbBusRelevanceMapper;
import com.zrt.mybatis.mapper.FbBusRemindMapper;
import com.zrt.mybatis.mapper.FbBusTemplateMapper;
import com.zrt.mybatis.mapper.FmBusFileMapper;
import com.zrt.mybatis.mapper.FmBusRelevanceMapper;
import com.zrt.mybatis.mapper.FmBusTemplateMapper;

@Service("processServiceImp")
public class ProcessServiceImp implements ProcessService {
	private static final Logger log = LoggerFactory.getLogger(ProcessServiceImp.class);
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
	private SerialService serialService;

	@Autowired
	private FbBusTemplateMapper fbBusTemplateMapper;

	@Autowired
	private ContactsService contactsService;

	@Autowired
	private FbBusInstMapper fbBusInstMapper;
	@Autowired
	private FbBusFileMapper fbBusFileMapper;
	@Autowired
	private FbBusRelevanceMapper fbBusRelevanceMapper;
	@Autowired
	private FbBusDataMapper fbBusDataMapper;

	@Autowired
	private ActProcessService actProcessService;
	@Autowired
	private FbBusCheckMapper fbBusCheckMapper;
	@Autowired
	private FbBusFmMapper fbBusFmMapper;
	@Autowired
	private FbBusJoinSignMapper fbBusJoinSignMapper;
	@Autowired
	private FbBusJoinSignFileMapper fbBusJoinSignFileMapper;
	@Autowired
	private FbBusJoinSignRelevanceMapper fbBusJoinSignRelevanceMapper;

	@Autowired
	private FbBusConditionMapper fbBusConditionMapper;

	@Autowired
	private FmBusTemplateMapper fmBusTemplateMapper;
	@Autowired
	private FmBusRelevanceMapper fmBusRelevanceMapper;
	@Autowired
	private FmBusFileMapper fmBusFileMapper;

	@Autowired
	private FbBusProjectMapper fbBusProjectMapper;

	@Autowired
	private ProcessCommonService processCommonService;

	@Autowired
	private FbBusRejectRuleMapper fbBusRejectRuleMapper;
	@Autowired
	private FbBusAddSignMapper fbBusAddSignMapper;
	@Autowired
	private RunnableService runnableService;
	@Value("${im.notify.sender_id}")
	private String systemEmpId;
	@Autowired
	private FbBusRemindMapper fbBusRemindMapper;
	@Autowired
	private SecService secService;
	@Autowired
	private FbBusHandleMapper fbBusHandleMapper;
	@Autowired
	private HandleService handleService;
	@Autowired
	private FlowselfMapper flowselfMapper;

	/***
	 * 流程发起
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> apply(Map<String, Object> appMap) throws Exception {
		appMap.put("inst_status", "3");// 代表已发起
		// 流程id
		FbBusTemplate fbBusTemplate = fbBusTemplateMapper.selectByPrimaryKey((String) appMap.get("id"));
		// 表单数据
		List<Map<String, Object>> formProperties = (List<Map<String, Object>>) appMap.get("template");
		Map<String, Object> proMap = new HashMap<String, Object>();
		// 根据登录人发起的申请
		proMap.put("apply_id", appMap.get("emp_id"));// 登录人id
		proMap.put("apply_org_id", appMap.get("apply_org_id"));// 发起部门
		proMap.put("apply_org_name", appMap.get("apply_org_name"));// 发起部门
		proMap.put("apply_org_name_like", appMap.get("apply_org_name"));// 发起部门
		String org_name = (String) appMap.get("apply_org_name");
		String orgNameLike = null;
		int i = org_name.indexOf("_");
		if (i > 0) {
			orgNameLike = org_name.substring(0, i);
		} else {
			orgNameLike = org_name;
		}
		// 如果是中融财富中心部门的员工就以一级部门
		// 中融财富中心
		proMap.put("apply_org_name_like", orgNameLike);// 发起部门
		for (Map<String, Object> map : formProperties) {
			proMap.put((String) map.get("col_code"), (String) map.get("col_value"));
		}
		// 获取下一节设置审批人参数
		String nextAssignee = (String) appMap.get("next_tag_assignee");
		// 如果传递过来下一审批人为空，则不进行task传递
		proMap.put("next_tag_assignee", nextAssignee);
		// 关联的业务id
		String bus_id = serialService.getSerialNumberFromDB("flow_inst_code");
		bus_id = bus_id.substring(0, 1) + bus_id.substring(3, bus_id.length());
		// 根据前台传的流程id，查询流程发布id
		String deployment_id = fbBusTemplate.getDeploymentId();
		ProcessDefinition prodessDefinition = repositoryService.createProcessDefinitionQuery()
				.deploymentId(deployment_id).singleResult();

		// 启动流程，绑定业务bus_id,fb_bus_inst 的主键id,流程启动默认启动最新版本key的流程定义
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(prodessDefinition.getKey(), bus_id,
				proMap);
		log.info("excutionId=" + processInstance.getId());// 流程执行id
		log.info("instanceId=" + processInstance.getProcessInstanceId());// 流程实例id
		log.info("deploymentId=" + processInstance.getDeploymentId());// 流程发布id
		// 根据执行id，发起人id,完成提交申请
		// Task task =
		// taskService.createTaskQuery().executionId(processInstance.getId())
		// .taskAssignee((String) appMap.get("emp_id")).singleResult();

		// List<Task> list=
		// taskService.createTaskQuery().taskCandidateOrAssigned((String)
		// appMap.get("emp_id")).list();
		Task task = taskService.createTaskQuery().processInstanceBusinessKey(bus_id)
				.taskAssignee((String) appMap.get("emp_id")).singleResult();
		log.info("----提交表单----个人代办任务节点=" + task.getName());
		// 节点tag
		String inst_tag = task.getTaskDefinitionKey();
		// 节点名称
		String inst_tag_name = task.getName();
		// 保存表单内容信息
		processCommonService.formBus(appMap, bus_id, inst_tag, inst_tag_name);
		// 保存业务申请表fb_bus_inst
		processCommonService.applyBus(appMap, bus_id, inst_tag, inst_tag_name);

		taskService.complete(task.getId(), proMap);

		return null;
	}

	@Override
	public Map<String, Object> queryProcessDetail(Map<String, Object> appMap) throws Exception {
		// 查询该节点已审批通过的信息

		return null;
	}

	/**
	 * 根据流程id，进行发布流程
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> deploy(Map<String, Object> appMap) throws Exception {
		// 要发布的流程模版id
		List<Map<String, Object>> tempList = (List<Map<String, Object>>) appMap.get("param");
		for (Map<String, Object> pMap : tempList) {
			pMap.put("emp_id", appMap.get("emp_id"));// 登录人
			// 流程id
			FbBusTemplate fbBusTemplate = fbBusTemplateMapper.selectByPrimaryKey((String) pMap.get("id"));

			// 获取是否签报类
			String handleFlag = fbBusTemplate.getHandleFlag();
			if ("1".equals(handleFlag)) {
				updateFbTemplate(pMap, fbBusTemplate, null);
			} else {
				// 模型id
				String modelId = fbBusTemplate.getModelId();
				Model modelData = repositoryService.getModel(modelId);
				ObjectNode modelNode = (ObjectNode) new ObjectMapper()
						.readTree(repositoryService.getModelEditorSource(modelData.getId()));
				byte[] bpmnBytes = null;
				BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
				// 发布的时候调用自定义的解析器
				SelfBpmnJsonConverter.getConvertersToBpmnMap().put("UserTask", SelfUserTaskJsonConverter.class);
				SelfBpmnJsonConverter.getConvertersToJsonMap().put(UserTask.class, SelfUserTaskJsonConverter.class);

				SelfBpmnJsonConverter.getConvertersToBpmnMap().put("ExclusiveGateway",
						SelfExclusiveGatewayJsonConverter.class);
				SelfBpmnJsonConverter.getConvertersToJsonMap().put(ExclusiveGateway.class,
						SelfExclusiveGatewayJsonConverter.class);

				BpmnModel model = jsonConverter.convertToBpmnModel(modelNode);
				bpmnBytes = new BpmnXMLConverter().convertToXML(model);
				// 流程定义名称
				String processName = modelData.getName() + ".bpmn20.xml";
				Deployment deployment = repositoryService.createDeployment().name(modelData.getName())
						.addString(processName, new String(bpmnBytes)).deploy();
				log.info("deploymentId=" + deployment.getId());

				// 根据返回的发布id，更新fb_bus_template 的deployment_id字段，进行关联
				updateFbTemplate(pMap, fbBusTemplate, deployment.getId());
			}

		}

		return null;
	}

	/**
	 * 根据任务id，审核状态，审核方式 流程审核
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> check(Map<String, Object> appMap) throws Exception {
		appMap.put("check_type", Constants.CHECK_TYPE_0);// 审核类型
		processCommonService.commonCheck(appMap, null);

		// 已阅消息通知
		Map<String, Object> readInforMap = new HashMap<String, Object>();
		readInforMap.put("bus_id", (String) appMap.get("inst_id"));
		readInforMap.put("bus_domain", (String) appMap.get("task_id"));
		runnableService.sendReadInfor(readInforMap);
		return null;
	}

	/**
	 * 根据流程id，修改deployment_id,更新时间，发布状态，发布时间
	 * 
	 * @param appMap
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void updateFbTemplate(Map<String, Object> appMap, FbBusTemplate fbTemplate, String deploymentId)
			throws Exception {
		Map<String, Object> conmap = new HashMap<>();
		conmap.put("search", appMap.get("emp_id"));
		Map<String, Object> result = contactsService.commonEmpSearch(conmap);

		List<Map<String, Object>> li = (List<Map<String, Object>>) result.get("data");
		Map<String, Object> empData = null;
		if (null != li && li.size() > 0) {
			empData = li.get(0);
		}
		// 判断当前流程模版是否有已发布的流程
		FbBusTemplateExample exampleTemp = new FbBusTemplateExample();
		com.zrt.mybatis.domain.FbBusTemplateExample.Criteria criteriaTemp = exampleTemp.createCriteria();
		criteriaTemp.andTCodeEqualTo(fbTemplate.gettCode());// 流程编号
		criteriaTemp.andTEnabledEqualTo(Constants.T_ENABLED_2);// 状态为已发布的
		List<FbBusTemplate> fbBusTemplateList = fbBusTemplateMapper.selectByExample(exampleTemp);

		if (fbBusTemplateList.isEmpty()) {
			// 如果没有已经发布的，说明是第一次发布，版本为1
			fbTemplate.setVersion(1);
		} else {
			// 已经有发布的话，就版本加1
			fbTemplate.setVersion(fbBusTemplateList.get(0).getVersion() + 1);
		}
		// 员工姓名
		String emp_name = (String) empData.get("emp_name");
		// 更新状态为启用正常的表单模版
		fbTemplate.setUpdateEmpId((String) appMap.get("emp_id"));// 更新人
		fbTemplate.setUpdateEmpName(emp_name);// 更新人名称
		fbTemplate.setUpdateDateTime(DateUtil.getCurrentDateTime());// 更新时间
		// fbTemplate.settEnabled(Constants.T_ENABLED_2);//更新为发布状态.
		fbTemplate.setProDateTime(DateUtil.getCurrentDateTime());// 发布时间
		fbTemplate.setDeploymentId(deploymentId);// 发布id
		fbBusTemplateMapper.updateByPrimaryKeySelective(fbTemplate);

		// 新增发布数据
		// 1、先查询正常状态下绑定的表单
		FbBusFmExample example = new FbBusFmExample();
		com.zrt.mybatis.domain.FbBusFmExample.Criteria criteria = example.createCriteria();
		criteria.andFbIdEqualTo((String) appMap.get("id"));// 流程id
		List<FbBusFm> fbBusFmList = fbBusFmMapper.selectByExample(example);
		if (fbBusFmList.isEmpty()) {
			throw new AppException("该流程未绑定表单");
		}

		// 2、禁用已发布过的状态
		for (FbBusTemplate tt : fbBusTemplateList) {
			tt.setUpdateDateTime(DateUtil.getCurrentDateTime());// 更新时间
			tt.settEnabled(Constants.T_ENABLED_3);// 更新为历史
			fbBusTemplateMapper.updateByPrimaryKeySelective(tt);
		}
		String fbId = getId();
		// 3、创建新的流程模版为已发布
		FbBusTemplate newFbBusTemplate = new FbBusTemplate();
		/**
		 * newFbBusTemplate.setId(fbId);
		 * newFbBusTemplate.settCode(fbTemplate.gettCode());
		 * newFbBusTemplate.settName(fbTemplate.gettName());
		 * newFbBusTemplate.settDesc(fbTemplate.gettDesc());
		 * newFbBusTemplate.setProDateTime(fbTemplate.getProDateTime());
		 * newFbBusTemplate.settEnabled(Constants.T_ENABLED_2);// 设置为已发布
		 * newFbBusTemplate.setfBTId(fbTemplate.getfBTId());
		 * newFbBusTemplate.setParentId(fbTemplate.getParentId());
		 * newFbBusTemplate.setVersion(fbTemplate.getVersion());
		 * newFbBusTemplate.setTenantId(fbTemplate.getTenantId());
		 * newFbBusTemplate.setCreateDateTime(fbTemplate.getCreateDateTime());
		 * newFbBusTemplate.setUpdateDateTime(fbTemplate.getUpdateDateTime());
		 * newFbBusTemplate.setCreateEmpId(fbTemplate.getCreateEmpId());
		 * newFbBusTemplate.setCreateEmpName(fbTemplate.getCreateEmpName());
		 * newFbBusTemplate.setUpdateEmpId(fbTemplate.getUpdateEmpId());
		 * newFbBusTemplate.setUpdateEmpName(fbTemplate.getUpdateEmpName());
		 * newFbBusTemplate.setDeploymentId(fbTemplate.getDeploymentId());
		 * newFbBusTemplate.setModelId(fbTemplate.getModelId());
		 * newFbBusTemplate.setProjectFlag(fbTemplate.getProjectFlag());
		 * newFbBusTemplate.setHandleFlag(fbTemplate.getHandleFlag());
		 **/
		BeanUtils.copyProperties(newFbBusTemplate, fbTemplate);
		newFbBusTemplate.setId(fbId);
		newFbBusTemplate.settEnabled(Constants.T_ENABLED_2);// 设置为已发布
		fbBusTemplateMapper.insert(newFbBusTemplate);
		// 4、绑定表单表复制一份
		FbBusFm fbBusFm = fbBusFmList.get(0);
		FbBusFm newFbBusFm = new FbBusFm();
		newFbBusFm.setFbId(fbId);// 模版id
		newFbBusFm.setFmId(fbBusFm.getFmId());// 表单id
		newFbBusFm.setTenantId(fbBusFm.getTenantId());
		fbBusFmMapper.insert(newFbBusFm);
	}

	public String getId() {
		// String serialId=String.valueOf(Math.random());
		// String serialId =
		// serialService.getSerialNumberFromDB("flow_inst_code");
		String serialId = serialService.getUUID();
		return serialId;
	}

	/**
	 * 可以驳回节点查询
	 */
	@Override
	public Map<String, Object> actInfo(Map<String, Object> appMap) throws Exception {
		// 查询已经完成的节点信息列表
		List<Map<String, Object>> list = actProcessService.backTagList(appMap);
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", list);
		resMap.put("data", dataMap);
		return resMap;
	}

	/**
	 * 草稿发送
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> send(Map<String, Object> appMap) throws Exception {
		// 根据发起id，进行发送
		List<Map<String, Object>> paramList = (List<Map<String, Object>>) appMap.get("param");
		Map<String, Object> proMap = new HashMap<String, Object>();
		// 根据登录人发起的申请
		proMap.put("apply_id", appMap.get("emp_id"));// 登录人id
		for (Map<String, Object> map : paramList) {
			// 发起id，业务id
			String bus_id = (String) map.get("inst_id");
			FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(bus_id);
			// 查询流程模版信息
			FbBusTemplate fbBusTemplate = fbBusTemplateMapper.selectByPrimaryKey(fbBusInst.getFbId());
			// 是否签报类类流程0:否，1:是
			String handleFlag = fbBusTemplate.getHandleFlag();
			if ("1".equals(handleFlag)) {
				handleService.send(map);
			} else {
				// 获取下一节设置审批人参数
				String nextAssignee = fbBusInst.getNextTagAssignee();
				// 如果有下一节点审批人，则设置下一审批人变量
				proMap.put("next_tag_assignee", nextAssignee);

				proMap.put("apply_org_id", fbBusInst.getApplyId());// 发起部门
				proMap.put("apply_org_name", fbBusInst.getOrgName());// 发起部门
				proMap.put("apply_org_name_like", fbBusInst.getOrgName());// 发起部门
				String org_name = fbBusInst.getOrgName();
				String orgNameLike = null;
				int i = org_name.indexOf("_");
				if (i > 0) {
					orgNameLike = org_name.substring(0, i);
				} else {
					orgNameLike = org_name;
				}
				proMap.put("apply_org_name_like", orgNameLike);// 发起部门
				// 獲取草稿的表單信息
				FbBusDataExample dataExample = new FbBusDataExample();
				com.zrt.mybatis.domain.FbBusDataExample.Criteria Criteria = dataExample.createCriteria();
				Criteria.andInstIdEqualTo(fbBusInst.getId());
				List<FbBusData> dataList = fbBusDataMapper.selectByExample(dataExample);
				for (FbBusData data : dataList) {
					proMap.put(data.getColCode(), data.getColValue());
				}
				processCommonService.draftSend(bus_id, proMap);
			}

		}
		return null;
	}

	/**
	 * 流程草稿保存
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> draftSave(Map<String, Object> appMap) throws Exception {
		// 流程草稿保存
		appMap.put("inst_status", "0");// 代表草稿

		// 关联的业务id
		String bus_id = serialService.getSerialNumberFromDB("flow_inst_code");
		bus_id = bus_id.substring(0, 1) + bus_id.substring(3, bus_id.length());
		// 保存表单内容信息
		processCommonService.formBus(appMap, bus_id, null, null);
		// 保存业务申请表fb_bus_inst
		processCommonService.applyBus(appMap, bus_id, null, null);
		return null;
	}

	/***
	 * 会签审核
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> joinSignCheck(Map<String, Object> appMap) throws Exception {
		// 会签id
		List<Map<String, Object>> paramList = (List<Map<String, Object>>) appMap.get("param");
		// 会签意见
		String check_comment = (String) appMap.get("check_comment");
		for (Map<String, Object> map : paramList) {
			// 会签id
			String cur_date = DateUtil.getCurrentDateTime();
			FbBusJoinSign fbBusJoinSign = fbBusJoinSignMapper.selectByPrimaryKey((String) map.get("sign_id"));
			if ("1".equals(fbBusJoinSign.getSignStatus())) {
				// 如果已经会签过的提示信息
				throw new AppException("已会签过该任务");
			}

			fbBusJoinSign.setCheckDateTime(cur_date);// 会签时间
			fbBusJoinSign.setUpdateDateTime(cur_date);// 更新时间
			fbBusJoinSign.setSignStatus("1");// 已会签
			fbBusJoinSign.setCheckComment(check_comment);// 会签意见
			fbBusJoinSign.setCheckStatus("1");// 暂时会签的都先填1，会签审核状态(0:拒绝,1:同意)
			fbBusJoinSignMapper.updateByPrimaryKey(fbBusJoinSign);

			// 被会签人审批后给会签人发通知
			String checkId = fbBusJoinSign.getCheckId();
			FbBusCheck fbBusCheck = fbBusCheckMapper.selectByPrimaryKey(checkId);
			String checkEmpId = fbBusCheck.getCheckEmpId();
			String instId = fbBusCheck.getInstId();
			FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);

			Map<String, Object> inforMap = new HashMap<String, Object>();
			inforMap.put("title", "会签办理通知");
			inforMap.put("content", "您有一个标题为《" + fbBusInst.getFbTitle() + "》的流程会签已审批!");
			inforMap.put("sender", systemEmpId);
			inforMap.put("receiver", checkEmpId);
			inforMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
			inforMap.put("bus_type", "FB14");// 流程办理进度通知
			inforMap.put("bus_id", fbBusInst.getId());// 实例id
			Map<String, Object> busDomainMap = new HashMap<String, Object>();
			ObjectMapper objMapper = new ObjectMapper();
			busDomainMap.put("inst_id", fbBusInst.getId());// 流程实例id
			busDomainMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
			busDomainMap.put("bus_type", "FB14");// 待办类型

			String domainStr = objMapper.writeValueAsString(busDomainMap);
			inforMap.put("bus_domain", domainStr);
			runnableService.inforCall(inforMap);

			// 会签审批关联附件，关联流程信息信息
			// 关联流程，信息
			List<Map<String, Object>> relList = (List<Map<String, Object>>) appMap.get("rel");
			// 附件list
			List<Map<String, Object>> fileList = (List<Map<String, Object>>) appMap.get("file");
			// 会签附件信息保存
			fileJoinSignBus(fileList, relList, fbBusJoinSign.getId());

			// 已阅消息通知
			Map<String, Object> readInforMap = new HashMap<String, Object>();
			readInforMap.put("bus_id", fbBusJoinSign.getInstId());
			readInforMap.put("bus_domain", (String) map.get("sign_id"));
			runnableService.sendReadInfor(readInforMap);
		}

		return null;
	}

	/**
	 * 会签审核附件表
	 * 
	 * @param appMap
	 * @param inst_id
	 * @param check_id
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void fileJoinSignBus(List<Map<String, Object>> fileList, List<Map<String, Object>> relList, String sign_id) {

		String cur_date = DateUtil.getCurrentDateTime();
		// 附件list
		if (fileList != null && !fileList.isEmpty()) {
			for (Map<String, Object> map : fileList) {
				FbBusJoinSignFile fbBusJoinSignFile = new FbBusJoinSignFile();
				fbBusJoinSignFile.setId(getId());// 主键id
				fbBusJoinSignFile.setSignId(sign_id);// 会签id
				fbBusJoinSignFile.setFileUrl((String) map.get("file_url"));// 文件url
				fbBusJoinSignFile.setFileName((String) map.get("file_name"));// 文件名称
				fbBusJoinSignFile.setFileType((String) map.get("file_type"));// 0:普通附件；1：云盘
				fbBusJoinSignFile.setNodeId((String) map.get("node_id"));// 云盘节点id
				fbBusJoinSignFile.setCreateDateTime(cur_date);// 创建时间
				fbBusJoinSignFileMapper.insert(fbBusJoinSignFile);
			}
		}

		if (relList != null && !relList.isEmpty()) {
			// 关联信息list
			for (Map<String, Object> map : relList) {
				FbBusJoinSignRelevance fbBusJoinSignRelevance = new FbBusJoinSignRelevance();
				fbBusJoinSignRelevance.setId(getId());// 主键id
				fbBusJoinSignRelevance.setSignId(sign_id);// 会签id
				fbBusJoinSignRelevance.setRelId((String) map.get("rel_id"));// 文件url
				fbBusJoinSignRelevance.setRelName((String) map.get("rel_name"));// 文件名称
				fbBusJoinSignRelevance.setRelType((String) map.get("rel_type"));// 0:普通附件；1：云盘
				fbBusJoinSignRelevance.setCreateDateTime(cur_date);// 创建时间
				fbBusJoinSignRelevanceMapper.insert(fbBusJoinSignRelevance);
			}
		}

	}

	/**
	 * 流程会签加人
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	@Override
	public Map<String, Object> joinSign(Map<String, Object> appMap) throws Exception {

		String task_id = (String) appMap.get("task_id");
		Boolean finishFlag = actProcessService.taskFinished(task_id);
		if (finishFlag) {
			// 说明任务已经完成了
			throw new AppException("该流程已不在您的审批节点!");
		}
		// 判断是否创建了阅读信息,保存或更新审核表
		appMap.put("check_type", Constants.CHECK_TYPE_4);// 审核类型
		FbBusCheck fbBusCheck = processCommonService.checkSave(appMap, null, (String) appMap.get("cur_tag_id"),
				(String) appMap.get("cur_tag_name"));
		// 会签人数组
		String signEmpIds = (String) appMap.get("sign_emp_ids");
		if (signEmpIds == null || "".equals(signEmpIds)) {
			throw new AppException("请选择会签人");
		}
		if (signEmpIds.endsWith(";")) {
			// 如果是以；分号结尾，那么就截取掉最后一位
			signEmpIds = signEmpIds.substring(0, signEmpIds.length() - 1);
		}
		String cur_date = DateUtil.getCurrentDateTime();
		String[] signEmpIdArr = null;
		signEmpIdArr = signEmpIds.split(";");
		// 获取到流程实例信息
		FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey((String) appMap.get("inst_id"));
		for (int i = 0; i < signEmpIdArr.length; i++) {
			String signEmpId = signEmpIdArr[i];
			Map<String, Object> signEmpData = getEmpInfo(signEmpId);
			// 判断该节点会签人是否会签过，根据check_id,tag_id查询会签表是否有会签信息，如果有continue过去
			FbBusJoinSignExample ex = new FbBusJoinSignExample();
			com.zrt.mybatis.domain.FbBusJoinSignExample.Criteria criteria = ex.createCriteria();
			criteria.andCheckIdEqualTo(fbBusCheck.getId());
			criteria.andInstTagEqualTo((String) appMap.get("cur_tag_id"));
			criteria.andSignEmpIdEqualTo(signEmpId);
			List<FbBusJoinSign> fbJoinSignList = fbBusJoinSignMapper.selectByExample(ex);
			if (fbJoinSignList != null && !fbJoinSignList.isEmpty()) {
				// 说明已经有该会签人信息
				throw new AppException("已存在该会签人");
			}
			String signId = getId();// 会签id
			FbBusJoinSign fbBusJoinSign = new FbBusJoinSign();
			fbBusJoinSign.setId(signId);// 会签id
			fbBusJoinSign.setSignEmpId(signEmpId);
			fbBusJoinSign.setSignEmpName((String) signEmpData.get("emp_name"));
			fbBusJoinSign.setOrgId((String) signEmpData.get("org_id"));
			fbBusJoinSign.setOrgName((String) signEmpData.get("org_name"));
			fbBusJoinSign.setInstId((String) appMap.get("inst_id"));// 发起id
			fbBusJoinSign.setInstTag((String) appMap.get("cur_tag_id"));// 流程节点id
			fbBusJoinSign.setInstTagName((String) appMap.get("cur_tag_name"));// 流程节点名称
			fbBusJoinSign.setCreateDateTime(cur_date);// 会签时间
			fbBusJoinSign.setUpdateDateTime(cur_date);// 更新时间
			fbBusJoinSign.setSignStatus("0");// 未会签
			fbBusJoinSign.setCheckId(fbBusCheck.getId());// 审核表id
			fbBusJoinSign.setSignDesc((String) appMap.get("sign_desc"));// 会签备注
			fbBusJoinSignMapper.insert(fbBusJoinSign);
			// 会签讯息通知
			// 获取到流程实例信息
			// 待办人讯息通知
			Map<String, Object> inforMap = new HashMap<String, Object>();
			inforMap.put("title", "会签流程通知");
			inforMap.put("content", "您有一个标题为《" + fbBusInst.getFbTitle() + "》的流程待处理!");
			inforMap.put("sender", systemEmpId);
			inforMap.put("receiver", signEmpId);
			inforMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
													// ,流程讯息(flowInfor),
													// 公文讯息(docInfor),
													// 公示讯息(pubInfor),
													// 问卷讯息(askInfor),
													// 日程讯息(dayInfor))
			inforMap.put("bus_type", "FB02");// 待办类型
			inforMap.put("bus_id", fbBusInst.getId());// 实例id
			Map<String, Object> busDomainMap = new HashMap<String, Object>();
			ObjectMapper objMapper = new ObjectMapper();
			busDomainMap.put("inst_id", fbBusInst.getId());// 流程实例id
			busDomainMap.put("task_id", (String) appMap.get("task_id"));// 代办任务id
			busDomainMap.put("cur_tag_id", (String) appMap.get("cur_tag_id"));// 待办节点id
			busDomainMap.put("cur_tag_name", (String) appMap.get("cur_tag_name"));// 待办节点id
			busDomainMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
														// ,流程讯息(flowInfor),
														// 公文讯息(docInfor),
														// 公示讯息(pubInfor),
														// 问卷讯息(askInfor),
														// 日程讯息(dayInfor))
			busDomainMap.put("bus_type", "FB02");// 待办类型
			busDomainMap.put("sign_id", signId);
			String domainStr = objMapper.writeValueAsString(busDomainMap);
			inforMap.put("bus_domain", domainStr);
			runnableService.inforCall(inforMap);

		}
		// 更新流程为审批中//更新申请表
		fbBusInst.setUpdateDateTime(cur_date);
		fbBusInst.setInstStatus(Constants.INST_STATUS_1);
		fbBusInstMapper.updateByPrimaryKey(fbBusInst);

		// 保存会签加人的时候添加的附件和关联信息
		// 关联流程，信息
		List<Map<String, Object>> relList = (List<Map<String, Object>>) appMap.get("rel");
		// 附件list

		if (relList != null && !relList.isEmpty()) {
			for (Map<String, Object> map : relList) {
				FbBusRelevance fbBusRelevance = new FbBusRelevance();
				fbBusRelevance.setId(getId());// 主键id
				fbBusRelevance.setInstId((String) appMap.get("inst_id"));// 流程发起id
				fbBusRelevance.setRelId((String) map.get("rel_id"));// 文件url
				fbBusRelevance.setRelName((String) map.get("rel_name"));// 文件名称
				fbBusRelevance.setRelType((String) map.get("rel_type"));// 0:普通附件；1：云盘
				fbBusRelevance.setCreateDateTime(cur_date);// 创建时间
				fbBusRelevance.setCheckId(fbBusCheck.getId());// 审核id(审核过程才会有这个id)
				fbBusRelevance.setFbType("2");// 发起/审核(0:发起，1:审核，2：会签)
				fbBusRelevanceMapper.insert(fbBusRelevance);
			}
		}

		// 附件list
		List<Map<String, Object>> fileList = (List<Map<String, Object>>) appMap.get("file");
		if (fileList != null && !fileList.isEmpty()) {
			for (Map<String, Object> map : fileList) {
				FbBusFile fbBusFile = new FbBusFile();
				fbBusFile.setId(getId());// 主键id
				fbBusFile.setInstId((String) appMap.get("inst_id"));// 流程发起id
				fbBusFile.setFileUrl((String) map.get("file_url"));// 文件url
				fbBusFile.setFileName((String) map.get("file_name"));// 文件名称
				fbBusFile.setFileType((String) map.get("file_type"));// 0:普通附件；1：云盘
				fbBusFile.setNodeId((String) map.get("node_id"));// 云盘节点id
				fbBusFile.setCreateDateTime(cur_date);// 创建时间
				fbBusFile.setCheckId(fbBusCheck.getId());// 审核id(审核过程才会有这个id)
				fbBusFile.setFbType("2");// 发起/审核(0:发起，1:审核，2：会签)
				fbBusFileMapper.insert(fbBusFile);
			}
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
	 * 流程已阅
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	@Override
	public Map<String, Object> instRead(Map<String, Object> appMap) throws Exception {
		// TODO Auto-generated method stub
		// 添加审核信息数据
		String check_id = getId();
		String cur_date = DateUtil.getCurrentDateTime();
		// 任务task_id
		FbBusCheckExample example = new FbBusCheckExample();
		Criteria criteria = example.createCriteria();
		criteria.andInstIdEqualTo((String) appMap.get("inst_id"));// id
		criteria.andTaskIdEqualTo((String) appMap.get("task_id"));// 任务id
		List<FbBusCheck> fbBusCheckList = fbBusCheckMapper.selectByExample(example);

		if (fbBusCheckList.isEmpty()) {
			String instId = (String) appMap.get("inst_id");
			FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);
			// 判断该信息详情是否是签报类
			FbBusTemplate fbBusTemplate = fbBusTemplateMapper.selectByPrimaryKey(fbBusInst.getFbId());
			// 获取是否签报类
			String handleFlag = fbBusTemplate.getHandleFlag();
			if ("1".equals(handleFlag)) {
				return null;
			} else {
				String taskId = (String) appMap.get("task_id");
				if (StringUtils.isNotBlank(taskId)) {
					TaskEntity task = actProcessService.findTaskById(taskId);
					FbBusCheck fbBusCheck = new FbBusCheck();
					fbBusCheck.setId(check_id);// 审核id
					fbBusCheck.setCheckEmpId((String) appMap.get("emp_id"));// 阅读人
					fbBusCheck.setCreateDateTime(cur_date);// 当前时间
					fbBusCheck.setUpdateDateTime(cur_date);// 更新时间
					fbBusCheck.setArriveDateTime(DateUtil.getDateFormat(task.getCreateTime(), "yyyyMMddHHmmss"));// 到达时间
					fbBusCheck.setReadDateTime(cur_date);// 阅读时间
					fbBusCheck.setTaskId((String) appMap.get("task_id"));// 任务id
					fbBusCheck.setInstId((String) appMap.get("inst_id"));// 发起id
					fbBusCheckMapper.insert(fbBusCheck);
				}

			}

		} else {
			// 如果是签报类，添加签报人的时候就已经在审核表存数据了
			// 则判断是否存在阅读时间，如果存在则不更新签报审核信息
			// 签报类的handle_id和task_id相同

			FbBusCheck fbBusCheck = fbBusCheckList.get(0);
			String readDateTime = fbBusCheck.getReadDateTime();
			if (readDateTime == null || "".equals(readDateTime)) {
				// 如果阅读时间为空，则更新阅读时间
				fbBusCheck.setReadDateTime(cur_date);
				fbBusCheck.setUpdateDateTime(cur_date);// 更新时间
				fbBusCheckMapper.updateByPrimaryKey(fbBusCheck);
			}

		}

		return null;
	}

	/**
	 * 加签审核
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRES_NEW)
	@Override
	public Map<String, Object> signAdd(Map<String, Object> appMap) throws Exception {

		appMap.put("check_type", Constants.CHECK_TYPE_3);
		// 加签默认都是同意
		appMap.put("check_status", "1");
		// 当前审核任务的id
		String task_id = (String) appMap.get("task_id");
		// 加签人数组
		String signEmpIds = (String) appMap.get("sign_emp_ids");
		String cur_date = DateUtil.getCurrentDateTime();
		String[] signEmpIdArr = null;
		signEmpIdArr = signEmpIds.split(";");

		// 判断是否存在checkId
		FbBusCheckExample example = new FbBusCheckExample();
		Criteria criteria = example.createCriteria();
		criteria.andInstIdEqualTo((String) appMap.get("inst_id"));// id
		criteria.andTaskIdEqualTo((String) appMap.get("task_id"));// 任务id
		List<FbBusCheck> fbBusCheckList = fbBusCheckMapper.selectByExample(example);
		String check_id = getId();
		if (!fbBusCheckList.isEmpty()) {
			check_id = fbBusCheckList.get(0).getId();
		}
		// 审核业务处理
		FbBusCheck fbBusCheck = processCommonService.commonCheck(appMap, check_id);
		// 加签目前按照的是转办办理的，修改下task_id,不然根据inst_id,task_id,查询信息的时候不唯一
		fbBusCheck.setTaskId(fbBusCheck.getTaskId() + "_signAdd");
		fbBusCheckMapper.updateByPrimaryKey(fbBusCheck);

		for (int i = 0; i < signEmpIdArr.length; i++) {
			String signEmpId = signEmpIdArr[i];

			// 保存加签人信息
			Map<String, Object> signEmpData = getEmpInfo(signEmpId);
			FbBusAddSign fbBusAddSign = new FbBusAddSign();
			fbBusAddSign.setId(getId());
			fbBusAddSign.setAddEmpId(signEmpId);
			fbBusAddSign.setAddEmpName((String) signEmpData.get("emp_name"));
			fbBusAddSign.setCreateDateTime(cur_date);// 会签时间
			fbBusAddSign.setUpdateDateTime(cur_date);// 更新时间
			fbBusAddSign.setInstId((String) appMap.get("inst_id"));// 发起id
			fbBusAddSign.setCheckId(check_id);// 审批id
			fbBusAddSignMapper.insert(fbBusAddSign);
			// 加签
			actProcessService.transferAssignee(task_id, signEmpId);
			// actProcessService.signAdd(task_id, signEmpId);
			// 加签完成之后给待办人发送个信息通知

		}
		// 加签信息通知
		if (signEmpIdArr != null && signEmpIdArr.length > 0) {
			// 获取到流程实例信息
			FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey((String) appMap.get("inst_id"));
			// 根据task_id获取task信息
			TaskEntity task = actProcessService.findTaskById(task_id);
			// 待办人讯息通知
			Map<String, Object> inforMap = new HashMap<String, Object>();
			inforMap.put("title", "待办流程通知");
			inforMap.put("content", "您有一个标题为《" + fbBusInst.getFbTitle() + "》的流程待处理!");
			inforMap.put("sender", systemEmpId);
			inforMap.put("receiver", signEmpIds);
			inforMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
													// ,流程讯息(flowInfor),
													// 公文讯息(docInfor),
													// 公示讯息(pubInfor),
													// 问卷讯息(askInfor),
													// 日程讯息(dayInfor))
			inforMap.put("bus_type", "FB03");// 待办类型
			inforMap.put("bus_id", fbBusInst.getId());// 实例id
			Map<String, Object> busDomainMap = new HashMap<String, Object>();
			ObjectMapper objMapper = new ObjectMapper();
			busDomainMap.put("inst_id", fbBusInst.getId());// 流程实例id
			busDomainMap.put("task_id", (String) appMap.get("task_id"));// 代办任务id
			busDomainMap.put("cur_tag_id", task.getTaskDefinitionKey());// 待办节点id
			busDomainMap.put("cur_tag_name", task.getName());// 待办节点id
			busDomainMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
														// ,流程讯息(flowInfor),
														// 公文讯息(docInfor),
														// 公示讯息(pubInfor),
														// 问卷讯息(askInfor),
														// 日程讯息(dayInfor))
			busDomainMap.put("bus_type", "FB03");// 待办类型

			String domainStr = objMapper.writeValueAsString(busDomainMap);
			inforMap.put("bus_domain", domainStr);
			runnableService.inforCall(inforMap);

		}

		return null;
	}

	/**
	 * 驳回至审批
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	@Override
	public Map<String, Object> returnCheck(Map<String, Object> appMap) throws Exception {
		appMap.put("check_type", Constants.CHECK_TYPE_2);
		// 驳回默认都是拒绝
		appMap.put("check_status", "0");
		processCommonService.commonCheck(appMap, null);
		// 已阅消息通知
		Map<String, Object> readInforMap = new HashMap<String, Object>();
		readInforMap.put("bus_id", (String) appMap.get("inst_id"));
		readInforMap.put("bus_domain", (String) appMap.get("task_id"));
		runnableService.sendReadInfor(readInforMap);
		return null;
	}

	/**
	 * 附条件同意
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	@Override
	public Map<String, Object> applyCheckWithCon(Map<String, Object> appMap) throws Exception {
		appMap.put("check_type", Constants.CHECK_TYPE_1);
		// 附条件都是同意
		appMap.put("check_status", "1");
		// 根据task_id获取task信息
		TaskEntity task = actProcessService.findTaskById((String) appMap.get("task_id"));
		// 判断是否存在checkId
		FbBusCheckExample example = new FbBusCheckExample();
		Criteria criteria = example.createCriteria();
		criteria.andInstIdEqualTo((String) appMap.get("inst_id"));// id
		criteria.andTaskIdEqualTo((String) appMap.get("task_id"));// 任务id
		List<FbBusCheck> fbBusCheckList = fbBusCheckMapper.selectByExample(example);
		String check_id = getId();
		if (!fbBusCheckList.isEmpty()) {
			check_id = fbBusCheckList.get(0).getId();
		}

		// 业务id,也是申请inst_id
		String bus_id = (String) appMap.get("inst_id");
		processCommonService.commonCheck(appMap, check_id);
		List<Map<String, Object>> conList = (List<Map<String, Object>>) appMap.get("con");
		String curr_date = DateUtil.getCurrentDateTime();// 当前时间
		if (conList != null && conList.size() > 0) {
			for (int i = 0; i < conList.size(); i++) {
				Map<String, Object> conMap = conList.get(i);
				FbBusCondition fbBusCondition = new FbBusCondition();
				String conId = getId();
				fbBusCondition.setId(conId);
				fbBusCondition.setCheckId(check_id);
				fbBusCondition.setInstId(bus_id);
				fbBusCondition.setRevContent((String) conMap.get("rev_content"));
				fbBusCondition.setCreateDateTime(curr_date);
				fbBusCondition.setRevDateTime(curr_date);
				fbBusCondition.setConStatus(Constants.CON_TYPE_3);
				fbBusConditionMapper.insert(fbBusCondition);

				// 这个是附件list
				@SuppressWarnings("unchecked")
				List<Map<String, Object>> listFile = (List<Map<String, Object>>) conMap.get("file");
				// 这个是关联信息，流程讯息list
				@SuppressWarnings("unchecked")
				List<Map<String, Object>> listRelevance = (List<Map<String, Object>>) conMap.get("rel");
				processCommonService.conFileRel(listFile, listRelevance, conId, "0");
			}

			// 附条件同意讯息通知，发送给发起人的
			// 获取到流程实例信息
			FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey((String) appMap.get("inst_id"));

			// 待办人讯息通知
			Map<String, Object> inforMap = new HashMap<String, Object>();
			inforMap.put("title", "流程附条件同意待回复通知");
			inforMap.put("content", "您有一个标题为《" + fbBusInst.getFbTitle() + "》的流程待回复!");
			inforMap.put("sender", systemEmpId);
			inforMap.put("receiver", fbBusInst.getApplyId());
			inforMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
													// ,流程讯息(flowInfor),
													// 公文讯息(docInfor),
													// 公示讯息(pubInfor),
													// 问卷讯息(askInfor),
													// 日程讯息(dayInfor))
			inforMap.put("bus_type", "FB04");// 待办类型
			inforMap.put("bus_id", fbBusInst.getId());// 实例id
			Map<String, Object> busDomainMap = new HashMap<String, Object>();
			ObjectMapper objMapper = new ObjectMapper();
			busDomainMap.put("inst_id", fbBusInst.getId());// 流程实例id
			busDomainMap.put("task_id", null);// 代办任务id
			busDomainMap.put("cur_tag_id", task.getTaskDefinitionKey());// 待办节点id
			busDomainMap.put("cur_tag_name", task.getName());// 待办节点id
			busDomainMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
														// ,流程讯息(flowInfor),
														// 公文讯息(docInfor),
														// 公示讯息(pubInfor),
														// 问卷讯息(askInfor),
														// 日程讯息(dayInfor))
			busDomainMap.put("bus_type", "FB04");// 待办类型

			String domainStr = objMapper.writeValueAsString(busDomainMap);
			inforMap.put("bus_domain", domainStr);
			runnableService.inforCall(inforMap);
		}

		// 已阅消息通知
		Map<String, Object> readInforMap = new HashMap<String, Object>();
		readInforMap.put("bus_id", (String) appMap.get("inst_id"));
		readInforMap.put("bus_domain", (String) appMap.get("task_id"));
		runnableService.sendReadInfor(readInforMap);
		return null;
	}

	/**
	 * 流程发起表单详情页面
	 */
	@Override
	public Map<String, Object> fmDetail(Map<String, Object> appMap) throws Exception {
		// 根据流程id查询流程模版信息
		FbBusTemplate fbBusTemplate = fbBusTemplateMapper.selectByPrimaryKey((String) appMap.get("id"));
		// 根据fbtemplate查询表单信息
		FbBusFmExample example = new FbBusFmExample();
		com.zrt.mybatis.domain.FbBusFmExample.Criteria criteria = example.createCriteria();
		criteria.andFbIdEqualTo(fbBusTemplate.getId());
		List<FbBusFm> list = fbBusFmMapper.selectByExample(example);
		FbBusFm fbBusFm = list.get(0);
		// 根据formId 查询表单信息
		FmBusTemplateWithBLOBs fmBusTemplate = fmBusTemplateMapper.selectByPrimaryKey(fbBusFm.getFmId());

		Map<String, Object> empMap = getEmpInfo((String) appMap.get("emp_id"));
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("apply_emp_id", empMap.get("emp_id"));
		dataMap.put("apply_emp_name", empMap.get("emp_name"));
		dataMap.put("apply_org_id", empMap.get("team_id"));
		dataMap.put("apply_org_name", empMap.get("org_name"));
		// 组装查询登录人所有的部门信息
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("search_emp_id", (String) appMap.get("emp_id"));
		dataMap.put("apply_org_list", contactsService.empOrgInfo(searchMap));
		dataMap.put("fb_id", fbBusTemplate.getId());
		dataMap.put("fm_id", fmBusTemplate.getId());
		dataMap.put("t_code", fmBusTemplate.gettCode());
		dataMap.put("t_name", fmBusTemplate.gettName());
		dataMap.put("t_desc", fmBusTemplate.gettDesc());
		dataMap.put("t_html", fmBusTemplate.gettHtml());
		dataMap.put("template", fmBusTemplate.gettTemplate());
		dataMap.put("project_flag", fbBusTemplate.getProjectFlag());// 是否是项目流程标识0：否，1：是
		// 查询表单绑定的附件
		FmBusFileExample fileExample = new FmBusFileExample();
		com.zrt.mybatis.domain.FmBusFileExample.Criteria fileCriteria = fileExample.createCriteria();
		fileCriteria.andFmIdEqualTo(fmBusTemplate.getId());
		List<FmBusFile> fileList = fmBusFileMapper.selectByExample(fileExample);
		List<Map<String, Object>> flList = new ArrayList<>();
		for (FmBusFile file : fileList) {
			Map<String, Object> dtMap = new HashMap<String, Object>();
			dtMap.put("file_url", file.getFileUrl());
			dtMap.put("file_name", file.getFileName());
			dtMap.put("file_type", file.getFileType());
			flList.add(dtMap);
		}
		// 查询表单绑定的附件
		FmBusRelevanceExample relExample = new FmBusRelevanceExample();
		com.zrt.mybatis.domain.FmBusRelevanceExample.Criteria relCriteria = relExample.createCriteria();
		relCriteria.andFmIdEqualTo(fmBusTemplate.getId());
		List<FmBusRelevance> relList = fmBusRelevanceMapper.selectByExample(relExample);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (FmBusRelevance rl : relList) {
			Map<String, Object> dtMap = new HashMap<String, Object>();
			dtMap.put("rel_id", rl.getRelId());
			dtMap.put("rel_name", rl.getRelName());
			dtMap.put("rel_type", rl.getRelType());
			reList.add(dtMap);
		}

		// 附件list
		dataMap.put("file", flList);
		// 讯息list
		dataMap.put("rel", reList);
		return dataMap;
	}

	/**
	 * 删除草稿
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> draftDelete(Map<String, Object> appMap) throws Exception {
		// 根据发起id，进行删除
		List<Map<String, Object>> paramList = (List<Map<String, Object>>) appMap.get("param");
		for (Map<String, Object> map : paramList) {
			// 流程实例id
			String instId = (String) map.get("inst_id");
			FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);
			// 查询流程模版信息
			FbBusTemplate fbBusTemplate = fbBusTemplateMapper.selectByPrimaryKey(fbBusInst.getFbId());
			// 是否签报类类流程0:否，1:是
			String handleFlag = fbBusTemplate.getHandleFlag();
			if ("1".equals(handleFlag)) {
				// 如果是签报类的流程还要删除handle,check的人员信息
				FbBusCheckExample checkExample = new FbBusCheckExample();
				Criteria checkCriteria = checkExample.createCriteria();
				checkCriteria.andInstIdEqualTo(instId);
				fbBusCheckMapper.deleteByExample(checkExample);
				// 删除handle签报人信息
				FbBusHandleExample handleExample = new FbBusHandleExample();
				com.zrt.mybatis.domain.FbBusHandleExample.Criteria handleCriteria = handleExample.createCriteria();
				handleCriteria.andInstIdEqualTo(instId);
				fbBusHandleMapper.deleteByExample(handleExample);
			}
			// 删除关联的草稿内容
			processCommonService.draftDelete(instId);
			// 删除流程实例
			fbBusInstMapper.deleteByPrimaryKey(instId);

		}
		return null;
	}

	/**
	 * 流程撤销
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> instCancel(Map<String, Object> appMap) throws Exception {
		// 流程实例id
		String instId = (String) appMap.get("inst_id");

		// 查询该实例的状态
		FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);
		if (!Constants.INST_STATUS_3.equals(fbBusInst.getInstStatus())) {
			throw new AppException("该状态不允许撤销");
		}
		// 查询流程模版信息
		FbBusTemplate fbBusTemplate = fbBusTemplateMapper.selectByPrimaryKey(fbBusInst.getFbId());
		// 是否签报类类流程0:否，1:是
		String handleFlag = fbBusTemplate.getHandleFlag();
		// 撤销过程相当于变成草稿
		fbBusInst.setInstStatus(Constants.INST_STATUS_0);
		fbBusInst.setUpdateDateTime(DateUtil.getCurrentDateTime());
		fbBusInstMapper.updateByPrimaryKey(fbBusInst);
		if (!"1".equals(handleFlag)) {
			// 如果不是1，则要销毁引擎
			actProcessService.deleteInst(instId, "instCancel");// 引擎结束
		}
		return null;
	}

	/**
	 * 草稿详情
	 */
	@Override
	public Map<String, Object> draftDetail(Map<String, Object> appMap) throws Exception {
		String instId = (String) appMap.get("inst_id");
		// 根据草稿id，查询流程信息
		FbBusInst fbBusTemplate = fbBusInstMapper.selectByPrimaryKey(instId);
		// 根据fbtemplate查询表单信息
		FbBusFmExample example = new FbBusFmExample();
		com.zrt.mybatis.domain.FbBusFmExample.Criteria criteria = example.createCriteria();
		criteria.andFbIdEqualTo(fbBusTemplate.getFbId());
		List<FbBusFm> list = fbBusFmMapper.selectByExample(example);
		FbBusFm fbBusFm = list.get(0);
		// 根据formId 查询表单信息
		FmBusTemplateWithBLOBs fmBusTemplate = fmBusTemplateMapper.selectByPrimaryKey(fbBusFm.getFmId());

		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("inst_id", fbBusTemplate.getId());
		dataMap.put("apply_emp_id", fbBusTemplate.getApplyId());
		dataMap.put("apply_emp_name", fbBusTemplate.getApplyName());
		dataMap.put("apply_org_id", fbBusTemplate.getOrgId());
		dataMap.put("apply_org_name", fbBusTemplate.getOrgName());
		// 组装查询登录人所有的部门信息
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("search_emp_id", (String) appMap.get("emp_id"));
		dataMap.put("apply_org_list", contactsService.empOrgInfo(searchMap));
		dataMap.put("fb_title", fbBusTemplate.getFbTitle());
		dataMap.put("fb_content", fbBusTemplate.getFbContent());
		dataMap.put("t_name", fmBusTemplate.gettName());// 表单名称
		dataMap.put("t_html", fmBusTemplate.gettHtml());
		// 下一审批人信息
		List<Map<String, Object>> nextList = new ArrayList<Map<String, Object>>();
		String nextTagAssignee = fbBusTemplate.getNextTagAssignee();

		if (nextTagAssignee != null && !"".equals(nextTagAssignee)) {
			String[] nextArr = nextTagAssignee.split(";");
			for (int i = 0; i < nextArr.length; i++) {
				String empId = nextArr[i];
				if (empId == null || "".equals(empId)) {
					continue;
				}
				Map<String, Object> empData = getEmpInfo(empId);
				Map<String, Object> nextAssignee = new HashMap<String, Object>();
				nextAssignee.put("next_tag_assignee", empId);
				nextAssignee.put("next_tag_assignee_name", empData.get("emp_name"));
				nextList.add(nextAssignee);
			}
		}
		dataMap.put("next_tag_assignee_list", nextList);
		// 查询关联的项目信息
		dataMap.put("project", processCommonService.projectList(instId));
		// 查询关联的表单数据
		dataMap.put("fm_data", processCommonService.instDataListWeb(instId));
		// 草稿关联的附件//查询0是发起，草稿的附件
		Map<String, Object> fileRelMap = processCommonService.fbfileRel(instId, "0", null);
		dataMap.putAll(fileRelMap);
		return dataMap;
	}

	/**
	 * 草稿更新
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> draftUpdate(Map<String, Object> appMap) throws Exception {
		// 根据草稿id，instId进行更新
		// 流程实例id
		String instId = (String) appMap.get("inst_id");

		// 查询该实例的状态
		FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);
		if (fbBusInst == null) {
			throw new AppException("该草稿不存在");
		}
		// 删除关联的草稿内容
		processCommonService.draftDelete(instId);

		// 保存项目lis
		List<Map<String, Object>> projectList = (List<Map<String, Object>>) appMap.get("project");
		processCommonService.projectBus(projectList, instId);
		// 保存表单内容信息
		processCommonService.formBus(appMap, instId, null, null);
		// 保存流程申请附件，关联流程信息信息
		// 关联流程，信息
		List<Map<String, Object>> relList = (List<Map<String, Object>>) appMap.get("rel");
		// 附件list
		List<Map<String, Object>> fileList = (List<Map<String, Object>>) appMap.get("file");
		// 申请业务id,0-发起附件，null不是审核的附件
		processCommonService.fileBus(fileList, relList, instId, "0", null);
		// 更新流程实例表
		fbBusInst.setOrgId((String) appMap.get("apply_org_id"));
		fbBusInst.setOrgId((String) appMap.get("apply_org_name"));
		fbBusInst.setFbTitle((String) appMap.get("fb_title"));
		fbBusInst.setFbContent((String) appMap.get("fb_content"));
		fbBusInst.setUpdateDateTime(DateUtil.getCurrentDateTime());
		fbBusInst.setNextTagAssignee((String) appMap.get("next_tag_assignee"));// 下一节点审批人
		fbBusInstMapper.updateByPrimaryKey(fbBusInst);
		return null;
	}

	/**
	 * 草稿发起
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> draftApply(Map<String, Object> appMap) throws Exception {
		// 流程实例id
		String instId = (String) appMap.get("inst_id");
		// 查询该实例的状态
		FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);
		if (fbBusInst == null) {
			throw new AppException("该草稿不存在");
		}
		// 删除关联的草稿内容
		processCommonService.draftDelete(instId);

		// 保存项目list
		List<Map<String, Object>> projectList = (List<Map<String, Object>>) appMap.get("project");
		processCommonService.projectBus(projectList, instId);
		// 保存表单内容信息
		processCommonService.formBus(appMap, instId, null, null);
		// 保存流程申请附件，关联流程信息信息
		// 关联流程，信息
		List<Map<String, Object>> relList = (List<Map<String, Object>>) appMap.get("rel");
		// 附件list
		List<Map<String, Object>> fileList = (List<Map<String, Object>>) appMap.get("file");
		// 申请业务id,0-发起附件，null不是审核的附件
		processCommonService.fileBus(fileList, relList, instId, "0", null);

		// 更新流程实例表
		fbBusInst.setOrgId((String) appMap.get("apply_org_id"));
		fbBusInst.setOrgName((String) appMap.get("apply_org_name"));
		fbBusInst.setFbTitle((String) appMap.get("fb_title"));
		fbBusInst.setFbContent((String) appMap.get("fb_content"));
		fbBusInst.setStartDateTime(DateUtil.getCurrentDateTime());//
		fbBusInst.setUpdateDateTime(DateUtil.getCurrentDateTime());
		fbBusInst.setNextTagAssignee((String) appMap.get("next_tag_assignee"));// 下一节点审批人
		fbBusInstMapper.updateByPrimaryKey(fbBusInst);
		// 获取下一节设置审批人参数
		// 表单数据
		Map<String, Object> varMap = new HashMap<String, Object>();
		List<Map<String, Object>> formProperties = (List<Map<String, Object>>) appMap.get("template");
		for (Map<String, Object> map : formProperties) {
			varMap.put((String) map.get("col_code"), (String) map.get("col_value"));
		}
		String nextAssignee = (String) appMap.get("next_tag_assignee");

		varMap.put("next_tag_assignee", nextAssignee);
		varMap.put("apply_id", appMap.get("emp_id"));// 登录人id
		varMap.put("apply_org_id", fbBusInst.getApplyId());// 发起部门
		varMap.put("apply_org_name", fbBusInst.getOrgName());// 发起部门
		varMap.put("apply_org_name_like", fbBusInst.getOrgName());// 发起部门
		String org_name = fbBusInst.getOrgName();
		String orgNameLike = null;
		int i = org_name.indexOf("_");
		if (i > 0) {
			orgNameLike = org_name.substring(0, i);
		} else {
			orgNameLike = org_name;
		}
		varMap.put("apply_org_name_like", orgNameLike);// 发起部门
		processCommonService.draftSend(instId, varMap);

		return null;
	}

	/**
	 * 编辑提交
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> editSubmit(Map<String, Object> appMap) throws Exception {
		// 先删除相关的表单数据，重新插入
		// 流程实例id
		String instId = (String) appMap.get("inst_id");
		// 删除产品
		FbBusProjectExample proExample = new FbBusProjectExample();
		com.zrt.mybatis.domain.FbBusProjectExample.Criteria proCriteria = proExample.createCriteria();
		proCriteria.andInstIdEqualTo(instId);
		fbBusProjectMapper.deleteByExample(proExample);
		// 删除附件
		FbBusFileExample fileExample = new FbBusFileExample();
		com.zrt.mybatis.domain.FbBusFileExample.Criteria fileCriteria = fileExample.createCriteria();
		fileCriteria.andInstIdEqualTo(instId);
		fileCriteria.andFbTypeEqualTo("0");// 代表发起带的附件
		fbBusFileMapper.deleteByExample(fileExample);
		// 删除信息
		FbBusRelevanceExample relevanceExample = new FbBusRelevanceExample();
		com.zrt.mybatis.domain.FbBusRelevanceExample.Criteria relevanceCriteria = relevanceExample.createCriteria();
		relevanceCriteria.andInstIdEqualTo(instId);
		relevanceCriteria.andFbTypeEqualTo("0");// 代表发起带的信息

		fbBusRelevanceMapper.deleteByExample(relevanceExample);
		// 删除表单数据
		FbBusDataExample dataExample = new FbBusDataExample();
		com.zrt.mybatis.domain.FbBusDataExample.Criteria dataCriteria = dataExample.createCriteria();
		dataCriteria.andInstIdEqualTo(instId);
		fbBusDataMapper.deleteByExample(dataExample);

		// 查询该实例的状态
		FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);
		// 保存项目list
		List<Map<String, Object>> projectList = (List<Map<String, Object>>) appMap.get("project");
		processCommonService.projectBus(projectList, instId);
		// 保存表单内容信息
		processCommonService.formBus(appMap, instId, null, null);
		// 保存流程申请附件，关联流程信息信息
		// 关联流程，信息
		List<Map<String, Object>> relList = (List<Map<String, Object>>) appMap.get("rel");
		// 附件list
		List<Map<String, Object>> fileList = (List<Map<String, Object>>) appMap.get("file");
		// 申请业务id,0-发起附件，null不是审核的附件
		processCommonService.fileBus(fileList, relList, instId, "0", null);

		// 更新流程实例表
		fbBusInst.setFbTitle((String) appMap.get("fb_title"));
		fbBusInst.setFbContent((String) appMap.get("fb_content"));
		fbBusInst.setUpdateDateTime(DateUtil.getCurrentDateTime());
		fbBusInst.setNextTagAssignee((String) appMap.get("next_tag_assignee"));// 下一节点审批人
		fbBusInstMapper.updateByPrimaryKey(fbBusInst);
		// 获取下一节设置审批人参数
		// 表单数据
		Map<String, Object> varMap = new HashMap<String, Object>();
		List<Map<String, Object>> formProperties = (List<Map<String, Object>>) appMap.get("template");
		for (Map<String, Object> map : formProperties) {
			varMap.put((String) map.get("col_code"), (String) map.get("col_value"));
		}
		String nextAssignee = (String) appMap.get("next_tag_assignee");

		varMap.put("next_tag_assignee", nextAssignee);
		varMap.put("apply_id", appMap.get("emp_id"));// 登录人id
		varMap.put("apply_org_id", fbBusInst.getApplyId());// 发起部门
		varMap.put("apply_org_name", fbBusInst.getOrgName());// 发起部门
		varMap.put("apply_org_name_like", fbBusInst.getOrgName());// 发起部门
		String org_name = fbBusInst.getOrgName();
		String orgNameLike = null;
		int i = org_name.indexOf("_");
		if (i > 0) {
			orgNameLike = org_name.substring(0, i);
		} else {
			orgNameLike = org_name;
		}
		varMap.put("apply_org_name_like", orgNameLike);// 发起部门
		varMap.put("deal_status", "1");// 提交默认是同意
		String taskId = (String) appMap.get("task_id");

		// 根据task_id获取task信息
		TaskEntity task = actProcessService.findTaskById(taskId);
		String cur_date = DateUtil.getCurrentDateTime();
		appMap.put("check_status", "1");// 提交默认就是同意
		appMap.put("check_date_time", cur_date);
		appMap.put("read_date_time", cur_date);
		appMap.put("check_type", Constants.CHECK_TYPE_0);
		processCommonService.checkSave(appMap, null, task.getTaskDefinitionKey(), task.getName());

		// 完成修改任务
		taskService.complete(taskId, varMap);

		// 已阅消息通知
		Map<String, Object> readInforMap = new HashMap<String, Object>();
		readInforMap.put("bus_id", (String) appMap.get("inst_id"));
		readInforMap.put("bus_domain", taskId);
		runnableService.sendReadInfor(readInforMap);
		return null;
	}

	/**
	 * 附条件同意
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> applyCheckCon(Map<String, Object> appMap) throws Exception {
		String taskId = (String) appMap.get("task_id");
		appMap.put("check_type", Constants.CHECK_TYPE_0);
		// 根据task_id获取task信息
		TaskEntity task = actProcessService.findTaskById(taskId);
		// 判断是否创建了阅读信息,保存或更新审核表
		FbBusCheck fbBusCheck = processCommonService.checkSave(appMap, null, task.getTaskDefinitionKey(),
				task.getName());
		List<Map<String, Object>> conList = (List<Map<String, Object>>) appMap.get("con");
		if (conList != null && !conList.isEmpty()) {
			String curr_date = DateUtil.getCurrentDateTime();// 当前时间
			for (int i = 0; i < conList.size(); i++) {
				Map<String, Object> conMap = conList.get(i);
				FbBusCondition fbBusCondition = new FbBusCondition();
				String conId = getId();
				fbBusCondition.setId(conId);
				fbBusCondition.setCheckId(fbBusCheck.getId());
				fbBusCondition.setInstId(fbBusCheck.getInstId());
				fbBusCondition.setRevContent((String) conMap.get("rev_content"));
				fbBusCondition.setCreateDateTime(curr_date);
				fbBusCondition.setRevDateTime(curr_date);
				fbBusCondition.setConStatus(Constants.CON_TYPE_3);
				fbBusConditionMapper.insert(fbBusCondition);
				// 这个是附件list
				@SuppressWarnings("unchecked")
				List<Map<String, Object>> listFile = (List<Map<String, Object>>) conMap.get("file");
				// 这个是关联信息，流程讯息list
				@SuppressWarnings("unchecked")
				List<Map<String, Object>> listRelevance = (List<Map<String, Object>>) conMap.get("rel");
				processCommonService.conFileRel(listFile, listRelevance, conId, "0");
			}
			// 附条件同意讯息通知，发送给发起人的
			// 获取到流程实例信息
			FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey((String) appMap.get("inst_id"));
			// 待办人讯息通知
			Map<String, Object> inforMap = new HashMap<String, Object>();
			inforMap.put("title", "流程附条件待回复通知");
			inforMap.put("content", "您有一个标题为《" + fbBusInst.getFbTitle() + "》的流程待回复!");
			inforMap.put("sender", systemEmpId);
			inforMap.put("receiver", fbBusInst.getApplyId());
			inforMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
													// ,流程讯息(flowInfor),
													// 公文讯息(docInfor),
													// 公示讯息(pubInfor),
													// 问卷讯息(askInfor),
													// 日程讯息(dayInfor))
			inforMap.put("bus_type", "FB08");// 待办类型
			inforMap.put("bus_id", fbBusInst.getId());// 实例id
			Map<String, Object> busDomainMap = new HashMap<String, Object>();
			ObjectMapper objMapper = new ObjectMapper();
			busDomainMap.put("inst_id", fbBusInst.getId());// 流程实例id
			busDomainMap.put("task_id", taskId);// 代办任务id
			busDomainMap.put("cur_tag_id", task.getTaskDefinitionKey());// 待办节点id
			busDomainMap.put("cur_tag_name", task.getName());// 待办节点id
			busDomainMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
														// ,流程讯息(flowInfor),
														// 公文讯息(docInfor),
														// 公示讯息(pubInfor),
														// 问卷讯息(askInfor),
														// 日程讯息(dayInfor))
			busDomainMap.put("bus_type", "FB08");// 待办类型

			String domainStr = objMapper.writeValueAsString(busDomainMap);
			inforMap.put("bus_domain", domainStr);
			runnableService.inforCall(inforMap);

		}

		return null;
	}

	@Override
	public Map<String, Object> img(Map<String, Object> appMap) throws Exception {

		return null;
	}

	/**
	 * 催办
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	@Override
	public Map<String, Object> remind(Map<String, Object> appMap) throws Exception {
		String curr_date = DateUtil.getCurrentDateTime();// 当前时间

		FbBusRemind fbBusRemind = new FbBusRemind();
		fbBusRemind.setId(getId());
		fbBusRemind.setInstId((String) appMap.get("inst_id"));// 流程发起id
		fbBusRemind.setRemindEmpId((String) appMap.get("emp_id"));// 当前登录人
		fbBusRemind.setInstTag((String) appMap.get("cur_tag_id"));// 催办节点id
		fbBusRemind.setInstTagName((String) appMap.get("cur_tag_name"));// 催办节点名称
		fbBusRemind.setCreateDateTime(curr_date);
		fbBusRemind.setUpdateDateTime(curr_date);
		fbBusRemind.setBeremindEmpId((String) appMap.get("cur_tag_assignee"));// 被催办人
		fbBusRemindMapper.insert(fbBusRemind);

		// 接收人
		String receiver = (String) appMap.get("cur_tag_assignee");
		// 节点id
		String tagId = (String) appMap.get("cur_tag_id");
		// 节点名称
		String tagName = (String) appMap.get("cur_tag_name");
		// 给被催办人发送讯息推送
		if (receiver != null && !"".equals(receiver)) {
			// 获取到流程实例信息
			FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey((String) appMap.get("inst_id"));
			// 根据task_id获取task信息
			// TaskEntity task=actProcessService.findTaskById(task_id);
			// 待办人讯息通知
			Map<String, Object> inforMap = new HashMap<String, Object>();
			inforMap.put("title", "催办流程通知");
			inforMap.put("content", "您有一个标题为《" + fbBusInst.getFbTitle() + "》的流程待处理!");
			inforMap.put("sender", systemEmpId);
			inforMap.put("receiver", receiver);
			inforMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
													// ,流程讯息(flowInfor),
													// 公文讯息(docInfor),
													// 公示讯息(pubInfor),
													// 问卷讯息(askInfor),
													// 日程讯息(dayInfor))
			inforMap.put("bus_type", "FB07");// 待办类型
			inforMap.put("bus_id", fbBusInst.getId());// 实例id
			Map<String, Object> busDomainMap = new HashMap<String, Object>();
			ObjectMapper objMapper = new ObjectMapper();
			busDomainMap.put("inst_id", fbBusInst.getId());// 流程实例id
			busDomainMap.put("task_id", (String) appMap.get("task_id"));// 代办任务id
			busDomainMap.put("cur_tag_id", tagId);// 待办节点id
			busDomainMap.put("cur_tag_name", tagName);// 待办节点id
			busDomainMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
														// ,流程讯息(flowInfor),
														// 公文讯息(docInfor),
														// 公示讯息(pubInfor),
														// 问卷讯息(askInfor),
														// 日程讯息(dayInfor))
			busDomainMap.put("bus_type", "FB07");// 待办类型

			String domainStr = objMapper.writeValueAsString(busDomainMap);
			inforMap.put("bus_domain", domainStr);
			runnableService.inforCall(inforMap);

		}
		return null;
	}

	/**
	 * 进行中的流程查询下一节点审批人和审批节点属性
	 */
	@Override
	public Map<String, Object> actNextList(Map<String, Object> appMap) throws Exception {
		String instId = (String) appMap.get("inst_id");// 流程业务id，也是发起id
		String fbId = (String) appMap.get("id");// 发起的时候流程模版id
		// 获取发起人的id，组织机构
		String applyId = null;
		String applyOrgId = null;
		if (instId != null && !"".equals(instId)) {
			// 如果实例不为空， 则可能为草稿或者已发起的
			FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);
			if (Constants.INST_STATUS_0.equals(fbBusInst.getInstStatus())) {
				// 如果是草稿，则需要查询表单下一个审批节点
				// 只能根据流程模版进行查询
				fbId = fbBusInst.getFbId();
			}
			applyId = fbBusInst.getApplyId();
			applyOrgId = fbBusInst.getOrgId();
		}
		List<Map<String, Object>> doList = new ArrayList<Map<String, Object>>();
		if (fbId != null && !"".equals(fbId)) {
			// 如果是发起，则找表单后面的节点
			// 表单发起节点form_start开始
			// 先查询该模版对应的引擎发布id
			FbBusTemplate fbBusTemplate = fbBusTemplateMapper.selectByPrimaryKey(fbId);
			String deploymentId = fbBusTemplate.getDeploymentId();// 流程发布id
			if (deploymentId == null) {
				throw new AppException("该流程未发布");
			}
			doList = actProcessService.nextTagProperties(deploymentId, "form_start");
			Map<String, Object> applyEmpData = getEmpInfo((String) appMap.get("emp_id"));
			applyId = (String) applyEmpData.get("emp_id");
			applyOrgId = (String) applyEmpData.get("team_id");
		} else {
			doList = actProcessService.nextTagProperties(instId);
		}

		// 去重
		List<Map<String, Object>> newList = new ArrayList<Map<String, Object>>(new HashSet(doList));
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map : newList) {
			// 实际审批人
			String assignee = (String) map.get("tag_assignee");
			// 候选人，共享审批人
			List<String> userList = (List) map.get("condidate_user");
			// 候选组
			List<String> groupList = (List) map.get("condidate_group");
			Map<String, Object> tagMap = new HashMap<>();
			tagMap.put("next_tag_id", map.get("tag_id"));// 节点id
			tagMap.put("next_tag_name", map.get("tag_name"));// 节点名称
			String isgnee = map.get("isassignee") == null ? "0" : (String) map.get("isassignee");
			tagMap.put("isassignee", isgnee);// 是否支持审批人
			List<Map<String, Object>> assList = new ArrayList();
			// 判断assignee是否是变量
			if ((assignee != null && !"".equals(assignee)) || assignee.startsWith("${")) {
				if (assignee.startsWith("${apply_id}")) {// 代表发起人
					assignee = applyId;
					// 查询发起人
					Map<String, Object> empData = getEmpInfo(assignee);
					Map<String, Object> empMap = new HashMap<String, Object>();
					empMap.put("next_tag_assignee", empData.get("emp_id"));
					empMap.put("next_tag_assignee_name", empData.get("emp_name"));
					empMap.put("emp_py", empData.get("emp_py"));
					empMap.put("emp_first_py", empData.get("emp_first_py"));
					empMap.put("check_emp_head_photo", empData.get("emp_head_photo"));
					assList.add(empMap);
				} else {
					// 如果存在实际审批人就
					Map<String, Object> empData = getEmpInfo(assignee);
					if (empData == null || empData.isEmpty()) {
						// continue;
					} else {
						Map<String, Object> empMap = new HashMap<String, Object>();
						empMap.put("next_tag_assignee", empData.get("emp_id"));
						empMap.put("next_tag_assignee_name", empData.get("emp_name"));
						empMap.put("emp_py", empData.get("emp_py"));
						empMap.put("emp_first_py", empData.get("emp_first_py"));
						empMap.put("check_emp_head_photo", empData.get("emp_head_photo"));
						assList.add(empMap);
					}

				}

			} else {
				// 如果为空，则判断是否有候选人
				if (userList != null && userList.size() > 0) {
					for (String empId : userList) {
						Map<String, Object> empData = getEmpInfo(empId);
						Map<String, Object> empMap = new HashMap<String, Object>();
						empMap.put("next_tag_assignee", empData.get("emp_id"));
						empMap.put("next_tag_assignee_name", empData.get("emp_name"));
						empMap.put("emp_py", empData.get("emp_py"));
						empMap.put("emp_first_py", empData.get("emp_first_py"));
						empMap.put("check_emp_head_photo", empData.get("emp_head_photo"));
						assList.add(empMap);
					}
				} else {
					// 如果候选人为空，判断是否有候选组
					if (groupList != null && groupList.size() > 0) {
						// 根据候选组查询候选组里面的审批人
						// 查询该候选组里面有多少人
						List<Map<String, Object>> roleUserList = processCommonService.roleUsers(groupList);
						for (Map<String, Object> groupMap : roleUserList) {
							Map<String, Object> empData = getEmpInfo((String) groupMap.get("emp_id"));
							Map<String, Object> empMap = new HashMap<String, Object>();
							empMap.put("next_tag_assignee", empData.get("emp_id"));
							empMap.put("next_tag_assignee_name", empData.get("emp_name"));
							empMap.put("emp_py", empData.get("emp_py"));
							empMap.put("emp_first_py", empData.get("emp_first_py"));
							empMap.put("check_emp_head_photo", empData.get("emp_head_photo"));
							assList.add(empMap);
						}
					} else {
						// 如果也没有候选组，则判断是否是主管领导审批，获取节点主管领导审批属性
						// 当前节点id等于该节点id,获取主分管信息
						String upmanage = (String) map.get("upmanage");
						// 获取到流程实例信息
						// FbBusInst
						// fbBusInst=fbBusInstMapper.selectByPrimaryKey(instId);
						if (upmanage != null && !"".equals(upmanage)) {
							// HistoricActivityInstance
							// hisActInstance=actProcessService.findHistoricUserTask(instanceId);
							HistoricActivityInstance hisActInstance = null;
							// 查询当前流程实例审批结束的历史节点
							if (instId != null) {
								List<HistoricActivityInstance> historicActivityInstances = historyService
										.createHistoricActivityInstanceQuery().activityType("userTask")
										.processInstanceId(instId).finished().orderByHistoricActivityInstanceEndTime()
										.desc().list();
								if (historicActivityInstances.size() > 0) {
									hisActInstance = historicActivityInstances.get(0);
								}
							}

							// 说明还没有节点审批完成
							if (hisActInstance == null) {
								// 主分管(0:发起人主管,1:发起人分管,2:前一审批人主管,3:前一审批人分管)
								if ("0".equals(upmanage) || "1".equals(upmanage) || "2".equals(upmanage)
										|| "3".equals(upmanage) || "4".equals(upmanage)) {
									Map<String, Object> paramMap = new HashMap<String, Object>();
									paramMap.put("org_id", applyOrgId);// 发起人部门
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
								// 当前解析节点id
								String actId = (String) map.get("tag_id");
								TaskEntity task = actProcessService.findTaskById((String) appMap.get("task_id"));
								String beforAssignee = (String) appMap.get("emp_id");// 上一任务审批人这是就是当前审批人
								String beforTaskActId = task.getTaskDefinitionKey();// 上一任务的审批节点,就是当前待办任务节点id
								if (!actId.equals(beforTaskActId)) {

									// 如果上一任务节点id，不等于当前创建的任务节点id，说明跳转节点了，那么在查询主管信息
									// 主分管(0:发起人主管,1:发起人分管,2:前一审批人主管,3:前一审批人分管)
									if ("0".equals(upmanage) || "1".equals(upmanage) || "2".equals(upmanage)
											|| "3".equals(upmanage) || "4".equals(upmanage)) {
										Map<String, Object> paramMap = new HashMap<String, Object>();
										paramMap.put("org_id", applyOrgId);// 发起人部门
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
									} else if ("5".equals(upmanage) || "6".equals(upmanage) || "7".equals(upmanage)
											|| "8".equals(upmanage) || "9".equals(upmanage)) {
										Map<String, Object> paramMap = new HashMap<String, Object>();
										paramMap.put("emp_id", beforAssignee);// 上一节点审批人id
										@SuppressWarnings("unchecked")
										List<Map<String, Object>> dataLi = (List<Map<String, Object>>) secService
												.manageSearch(paramMap);
										if ("5".equals(upmanage) && null != dataLi && !dataLi.isEmpty()) {// 一级审批人
											for (Map<String, Object> dataMap : dataLi) {
												int checkOrder = (int) dataMap.get("check_order");
												if (1 == checkOrder) {
													assignee = (String) dataMap.get("check_emp_id");
												}
											}
										} else if ("6".equals(upmanage) && null != dataLi && !dataLi.isEmpty()) {// 二级审批人
											for (Map<String, Object> dataMap : dataLi) {
												int checkOrder = (int) dataMap.get("check_order");
												if (2 == checkOrder) {
													assignee = (String) dataMap.get("check_emp_id");
												}
											}
										} else if ("7".equals(upmanage) && null != dataLi && !dataLi.isEmpty()) {// 三级审批人
											for (Map<String, Object> dataMap : dataLi) {
												int checkOrder = (int) dataMap.get("check_order");
												if (3 == checkOrder) {
													assignee = (String) dataMap.get("check_emp_id");
												}
											}
										} else if ("8".equals(upmanage) && null != dataLi && !dataLi.isEmpty()) {// 四级审批人
											for (Map<String, Object> dataMap : dataLi) {
												int checkOrder = (int) dataMap.get("check_order");
												if (4 == checkOrder) {
													assignee = (String) dataMap.get("check_emp_id");
												}
											}
										} else if ("9".equals(upmanage) && null != dataLi && !dataLi.isEmpty()) {// 五级审批人
											for (Map<String, Object> dataMap : dataLi) {
												int checkOrder = (int) dataMap.get("check_order");
												if (5 == checkOrder) {
													assignee = (String) dataMap.get("check_emp_id");
												}
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
												if (StringUtils.isBlank(assignee)) {
													assignee = firstOrder;
												}
											}
										}
									}
								}
							}
							if (assignee != null && !"".equals(assignee)) {
								Map<String, Object> empData = getEmpInfo(assignee);
								Map<String, Object> empMap = new HashMap<String, Object>();
								empMap.put("next_tag_assignee", empData.get("emp_id"));
								empMap.put("next_tag_assignee_name", empData.get("emp_name"));
								empMap.put("emp_py", empData.get("emp_py"));
								empMap.put("emp_first_py", empData.get("emp_first_py"));
								empMap.put("check_emp_head_photo", empData.get("emp_head_photo"));
								assList.add(empMap);
							}

						}
					}
				}
			}
			tagMap.put("assignee_list", assList);
			dataList.add(tagMap);
		}

		Map<String, Object> resMap = new HashMap<>();
		resMap.put("list", dataList);
		return resMap;
	}

	/**
	 * 查询个人流程列表
	 */
	@Override
	public Map<String, Object> selfAboutList(Map<String, Object> appMap) throws Exception {
		// 流程类型1:我发起的，2：我已办的，3：知会我的，默认为1
		String fbType = (String) appMap.get("fb_type");
		// 如果类型是空，则默认1
		if (fbType == null || "".equals(fbType)) {
			appMap.put("fb_type", "1");
		}
		if ("1".equals(fbType)) {
			appMap.put("apply_id", appMap.get("emp_id"));// 登陆人id
		}
		if ("2".equals(fbType)) {
			appMap.put("check_emp_id", appMap.get("emp_id"));// 登陆人id
		}
		if ("3".equals(fbType)) {
			appMap.put("notify_emp_id", appMap.get("emp_id"));// 登陆人id
		}
		PageInit.setPage(appMap);
		PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
				Integer.parseInt(appMap.get("maxResult").toString())).setReasonable(false);
		List<Map<String, Object>> resList = flowselfMapper.selfAboutList(appMap);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(resList);
		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap.put("list", resList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", listMap);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

}
