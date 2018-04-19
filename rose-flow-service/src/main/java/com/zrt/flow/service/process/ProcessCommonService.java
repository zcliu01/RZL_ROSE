package com.zrt.flow.service.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zrt.commons.AppException;
import com.zrt.commons.MapEntityConverter;
import com.zrt.commons.cons.Constants;
import com.zrt.commons.date.DateUtil;
import com.zrt.flow.mapper.act.RoleUserMapper;
import com.zrt.flow.mapper.flowEntrust.FlowEntrustCustomMapper;
import com.zrt.flow.service.act.ActProcessService;
import com.zrt.flow.service.contacts.ContactsService;
import com.zrt.flow.service.runnable.RunnableService;
import com.zrt.flow.service.serial.SerialService;
import com.zrt.mybatis.domain.FbBusAddFile;
import com.zrt.mybatis.domain.FbBusAddRelevance;
import com.zrt.mybatis.domain.FbBusCareExample;
import com.zrt.mybatis.domain.FbBusCheck;
import com.zrt.mybatis.domain.FbBusCheckExample;
import com.zrt.mybatis.domain.FbBusData;
import com.zrt.mybatis.domain.FbBusDataExample;
import com.zrt.mybatis.domain.FbBusDataExample.Criteria;
import com.zrt.mybatis.domain.FbBusFile;
import com.zrt.mybatis.domain.FbBusFileExample;
import com.zrt.mybatis.domain.FbBusInst;
import com.zrt.mybatis.domain.FbBusProject;
import com.zrt.mybatis.domain.FbBusProjectExample;
import com.zrt.mybatis.domain.FbBusRejectRule;
import com.zrt.mybatis.domain.FbBusRejectRuleExample;
import com.zrt.mybatis.domain.FbBusRelevance;
import com.zrt.mybatis.domain.FbBusRelevanceExample;
import com.zrt.mybatis.domain.FbBusTemplate;
import com.zrt.mybatis.domain.FbBusTemplateNotify;
import com.zrt.mybatis.domain.FbBusTemplateNotifyExample;
import com.zrt.mybatis.domain.FmBusFile;
import com.zrt.mybatis.domain.FmBusFileExample;
import com.zrt.mybatis.domain.FmBusRelevance;
import com.zrt.mybatis.domain.FmBusRelevanceExample;
import com.zrt.mybatis.mapper.FbBusAddFileMapper;
import com.zrt.mybatis.mapper.FbBusAddRelevanceMapper;
import com.zrt.mybatis.mapper.FbBusCareMapper;
import com.zrt.mybatis.mapper.FbBusCheckMapper;
import com.zrt.mybatis.mapper.FbBusDataMapper;
import com.zrt.mybatis.mapper.FbBusFileMapper;
import com.zrt.mybatis.mapper.FbBusInstMapper;
import com.zrt.mybatis.mapper.FbBusProjectMapper;
import com.zrt.mybatis.mapper.FbBusRejectRuleMapper;
import com.zrt.mybatis.mapper.FbBusRelevanceMapper;
import com.zrt.mybatis.mapper.FbBusTemplateMapper;
import com.zrt.mybatis.mapper.FbBusTemplateNotifyMapper;
import com.zrt.mybatis.mapper.FmBusFileMapper;
import com.zrt.mybatis.mapper.FmBusRelevanceMapper;

/**
 * Created by wwfu on 2017/10/23.
 */

@Service
public class ProcessCommonService {
	private static final Logger log = LoggerFactory.getLogger(ProcessCommonService.class);
	@Autowired
	private FbBusProjectMapper fbBusProjectMapper;

	@Autowired
	private FbBusDataMapper fbBusDataMapper;

	@Autowired
	private FmBusRelevanceMapper fmBusRelevanceMapper;
	@Autowired
	private FmBusFileMapper fmBusFileMapper;
	@Autowired
	private FbBusFileMapper fbBusFileMapper;
	@Autowired
	private FbBusRelevanceMapper fbBusRelevanceMapper;
	@Autowired
	private FbBusRejectRuleMapper fbBusRejectRuleMapper;
	@Autowired
	private FbBusCheckMapper fbBusCheckMapper;
	@Autowired
	private ProcessService processService;

	@Autowired
	private FbBusInstMapper fbBusInstMapper;

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
	private FbBusTemplateMapper fbBusTemplateMapper;
	@Autowired
	private ActProcessService actProcessService;

	@Autowired
	private SerialService serialService;

	@Autowired
	private ContactsService contactsService;

	@Autowired
	private FbBusAddFileMapper fbBusAddFileMapper;
	@Autowired
	private FbBusAddRelevanceMapper fbBusAddRelevanceMapper;

	@Autowired
	private RoleUserMapper roleUserMapper;

	@Value("${im.notify.sender_id}")
	private String systemEmpId;
	@Autowired
	private RunnableService runnableService;

	@Autowired
	private FbBusTemplateNotifyMapper fbBusTemplateNotifyMapper;

	@Autowired
	private FbBusCareMapper fbBusCareMapper;
	@Autowired
	private FlowEntrustCustomMapper flowEntrustCustomMapper;

	/**
	 * 根据inst_id查询关联的产品信息
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public List<java.util.Map<String, Object>> projectList(String instId) {
		// 草稿关联的产品
		FbBusProjectExample proExample = new FbBusProjectExample();
		com.zrt.mybatis.domain.FbBusProjectExample.Criteria proCriteria = proExample.createCriteria();
		proCriteria.andInstIdEqualTo(instId);
		List<FbBusProject> projectList = fbBusProjectMapper.selectByExample(proExample);
		List<java.util.Map<String, Object>> proList = new ArrayList<>();
		for (FbBusProject project : projectList) {
			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("project_code", project.getProjectCode());
			dataMap.put("project_name", project.getProjectName());
			dataMap.put("fund_code", project.getFundCode());
			proList.add(dataMap);
		}
		return proList;
	}

	/**
	 * WEB根据inst_id查询表单数据
	 */
	public List<java.util.Map<String, Object>> instDataList(String instId) {
		FbBusDataExample dataExample = new FbBusDataExample();
		Criteria dataCriteria = dataExample.createCriteria();
		dataCriteria.andInstIdEqualTo(instId);
		List<FbBusData> dataList = fbBusDataMapper.selectByExampleWithBLOBs(dataExample);
		List<Map<String, Object>> fmDataList = new ArrayList<Map<String, Object>>();
		for (FbBusData data : dataList) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("col_code", data.getColCode());
			dataMap.put("col_title", data.getColTitle());
			dataMap.put("col_type", data.getColType());
			if ("select".equals(data.getColType())) {// 下拉框
				dataMap.put("col_value", data.getColText());
			} else {
				dataMap.put("col_value", data.getColValue());
			}
			fmDataList.add(dataMap);
		}
		return fmDataList;
	}
	/**
	 * WEB根据inst_id查询表单数据
	 */
	public List<java.util.Map<String, Object>> instDataListWeb(String instId) {
		FbBusDataExample dataExample = new FbBusDataExample();
		Criteria dataCriteria = dataExample.createCriteria();
		dataCriteria.andInstIdEqualTo(instId);
		List<FbBusData> dataList = fbBusDataMapper.selectByExampleWithBLOBs(dataExample);
		List<Map<String, Object>> fmDataList = new ArrayList<Map<String, Object>>();
		for (FbBusData data : dataList) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("col_code", data.getColCode());
			dataMap.put("col_title", data.getColTitle());
			dataMap.put("col_type", data.getColType());
			dataMap.put("col_value", data.getColValue());
			fmDataList.add(dataMap);
		}
		return fmDataList;
	}

	/**
	 * App根据inst_id查询表单数据
	 */
	public List<java.util.Map<String, Object>> instDataListApp(String instId) {
		FbBusDataExample dataExample = new FbBusDataExample();
		Criteria dataCriteria = dataExample.createCriteria();
		dataCriteria.andInstIdEqualTo(instId);
		List<FbBusData> dataList = fbBusDataMapper.selectByExampleWithBLOBs(dataExample);
		List<Map<String, Object>> fmDataList = new ArrayList<Map<String, Object>>();
		for (FbBusData data : dataList) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("col_code", data.getColCode());
			dataMap.put("col_title", data.getColTitle());
			dataMap.put("col_type", data.getColType());
			if ("select".equals(data.getColType())) {// 下拉框
				dataMap.put("col_value", data.getColText());
			} else {
				dataMap.put("col_value", data.getColValue());
			}

			fmDataList.add(dataMap);
		}
		return fmDataList;
	}

	/**
	 * 根据表单id，查询表单关联的信息，附件信息
	 * 
	 * @param fmId
	 * @return
	 */
	public Map<String, Object> fmfileRel(String fmId) {
		// 查询表单绑定的附件
		Map<String, Object> dataMap = new HashMap<>();
		FmBusFileExample fileExample = new FmBusFileExample();
		com.zrt.mybatis.domain.FmBusFileExample.Criteria fileCriteria = fileExample.createCriteria();
		fileCriteria.andFmIdEqualTo(fmId);
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
		relCriteria.andFmIdEqualTo(fmId);
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
	 * 根据instId，查询表单关联的信息，fbType附件信息 发起/审核(0:发起，1:审核)
	 * 
	 * @param fmId
	 * @return
	 */
	public Map<String, Object> fbfileRel(String instId, String fbType, String checkId) {
		// 查询表单绑定的附件
		Map<String, Object> dataMap = new HashMap<>();
		FbBusFileExample fileExample = new FbBusFileExample();
		com.zrt.mybatis.domain.FbBusFileExample.Criteria fileCriteria = fileExample.createCriteria();
		fileCriteria.andInstIdEqualTo(instId);
		if (fbType != null && !"".equals(fbType)) {
			fileCriteria.andFbTypeEqualTo(fbType);
		}
		if (checkId != null && !"".equals(checkId)) {
			fileCriteria.andCheckIdEqualTo(checkId);
		}
		List<FbBusFile> fileList = fbBusFileMapper.selectByExample(fileExample);
		List<Map<String, Object>> flList = new ArrayList<>();
		for (FbBusFile file : fileList) {
			Map<String, Object> dtMap = new HashMap<String, Object>();
			dtMap.put("file_url", file.getFileUrl());
			dtMap.put("file_name", file.getFileName());
			dtMap.put("file_type", file.getFileType());
			dtMap.put("node_id", file.getNodeId());
			flList.add(dtMap);
		}
		// 查询表单绑定的附件
		FbBusRelevanceExample relExample = new FbBusRelevanceExample();
		com.zrt.mybatis.domain.FbBusRelevanceExample.Criteria relCriteria = relExample.createCriteria();
		relCriteria.andInstIdEqualTo(instId);
		if (fbType != null && !"".equals(fbType)) {
			relCriteria.andFbTypeEqualTo(fbType);
		}
		if (checkId != null && !"".equals(checkId)) {
			relCriteria.andCheckIdEqualTo(checkId);
		}
		List<FbBusRelevance> relList = fbBusRelevanceMapper.selectByExample(relExample);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (FbBusRelevance rl : relList) {
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
	 * 根据节点id，查询驳回至信息
	 * 
	 * @return
	 */
	public List<Map<String, Object>> queryRejectTagInfo(String instId, String checkId) {
		// 根据isntId,checkId查询驳回至规则
		FbBusRejectRuleExample rejectExample = new FbBusRejectRuleExample();
		com.zrt.mybatis.domain.FbBusRejectRuleExample.Criteria rejectCriteria = rejectExample.createCriteria();
		rejectCriteria.andInstIdEqualTo(instId);
		rejectCriteria.andCheckIdEqualTo(checkId);
		List<FbBusRejectRule> rejectList = fbBusRejectRuleMapper.selectByExample(rejectExample);
		FbBusRejectRule fbBusRejectRule = null;
		if (!rejectList.isEmpty()) {
			fbBusRejectRule = rejectList.get(0);// 获取该审核的驳回至规则
			// 查询驳回至节点审核信息
			FbBusCheckExample checkExample = new FbBusCheckExample();
			com.zrt.mybatis.domain.FbBusCheckExample.Criteria checkCriteria = checkExample.createCriteria();
			checkCriteria.andInstIdEqualTo(instId);
			checkCriteria.andInstTagEqualTo(fbBusRejectRule.getOldInstTag());
			List<FbBusCheck> checkList = fbBusCheckMapper.selectByExample(checkExample);
			List<Map<String, Object>> rejectTagList = new ArrayList<>();
			for (FbBusCheck map : checkList) {
				Map<String, Object> dataMap = new HashMap<>();
				dataMap.put("reject_tag_id", map.getInstTag());
				dataMap.put("reject_tag_name", map.getInstTagName());
				dataMap.put("reject_tag_assignee", map.getCheckEmpId());
				dataMap.put("reject_tag_assignee_name", map.getCheckEmpName());
				rejectTagList.add(dataMap);
			}
			return rejectTagList;
		} else {
			return null;
		}

	}

	/***
	 * 删除草稿内容
	 */
	public void draftDelete(String instId) {
		// 删除产品
		FbBusProjectExample proExample = new FbBusProjectExample();
		com.zrt.mybatis.domain.FbBusProjectExample.Criteria proCriteria = proExample.createCriteria();
		proCriteria.andInstIdEqualTo(instId);
		fbBusProjectMapper.deleteByExample(proExample);
		// 删除附件
		FbBusFileExample fileExample = new FbBusFileExample();
		com.zrt.mybatis.domain.FbBusFileExample.Criteria fileCriteria = fileExample.createCriteria();
		fileCriteria.andInstIdEqualTo(instId);
		fbBusFileMapper.deleteByExample(fileExample);
		// 删除信息
		FbBusRelevanceExample relevanceExample = new FbBusRelevanceExample();
		com.zrt.mybatis.domain.FbBusRelevanceExample.Criteria relevanceCriteria = relevanceExample.createCriteria();
		relevanceCriteria.andInstIdEqualTo(instId);
		fbBusRelevanceMapper.deleteByExample(relevanceExample);
		// 删除表单数据
		FbBusDataExample dataExample = new FbBusDataExample();
		com.zrt.mybatis.domain.FbBusDataExample.Criteria dataCriteria = dataExample.createCriteria();
		dataCriteria.andInstIdEqualTo(instId);
		fbBusDataMapper.deleteByExample(dataExample);
	}

	/***
	 * 草稿发送instId
	 */

	public void draftSend(String instId, Map<String, Object> proMap) {
		// 发起id，业务id
		String bus_id = instId;
		FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(bus_id);

		// 查询流程模版信息
		FbBusTemplate fbBusTemplate = fbBusTemplateMapper.selectByPrimaryKey(fbBusInst.getFbId());
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
		// Task
		// task=taskService.createTaskQuery().executionId(processInstance.getId()).taskAssignee((String)proMap.get("apply_id")).singleResult();
		Task task = taskService.createTaskQuery().processInstanceBusinessKey(bus_id)
				.taskAssignee((String) proMap.get("apply_id")).singleResult();

		// 节点tag
		String inst_tag = task.getTaskDefinitionKey();
		// 节点名称
		String inst_tag_name = task.getName();

		// 更新申请表
		String cur_date = DateUtil.getCurrentDateTime();
		fbBusInst.setInstTag(inst_tag);
		fbBusInst.setInstTagName(inst_tag_name);
		fbBusInst.setUpdateDateTime(cur_date);// 更新时间
		fbBusInst.setStartDateTime(cur_date);// 开始时间
		fbBusInst.setInstStatus(Constants.INST_STATUS_3);// 状态发起中
		fbBusInstMapper.updateByPrimaryKey(fbBusInst);

		taskService.complete(task.getId(), null);
	}

	/**
	 * 审批完成处理本地数据 0:拒绝，1:同意
	 */
	public void instDeal(String instId, String dealStatus, String checkType) throws Exception {
		FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);
		String instStatus = fbBusInst.getInstStatus();// 流程状态
		// 更新申请表
		String cur_date = DateUtil.getCurrentDateTime();
		fbBusInst.setUpdateDateTime(cur_date);
		if (!Constants.CHECK_TYPE_2.equals(checkType)) {
			if ("0".equals(dealStatus)) {// 拒绝
				if (!Constants.CHECK_TYPE_7.equals(checkType)) {
					fbBusInst.setInstStatus(Constants.INST_STATUS_4);
				}
			} else if ("1".equals(dealStatus)) {// 同意
				if (instStatus.equals(Constants.INST_STATUS_3)) {
					// 如果是发起状态，则改为审批中
					fbBusInst.setInstStatus(Constants.INST_STATUS_1);
				}
				if (Constants.CHECK_TYPE_7.equals(checkType)) {
					// 如果是发起状态，则改为审批中
					fbBusInst.setInstStatus(Constants.INST_STATUS_1);
				} else {
					// 判断该流程实例是否结束，结束的话，更新状态为2，已结束
					Boolean finishFlag = actProcessService.finished(instId);
					if (finishFlag) {// 说明该流程已经结束
						fbBusInst.setInstStatus(Constants.INST_STATUS_2);
						// 对于同意结束的流程流程模版进行讯息提醒
						fbTemplateNotify(fbBusInst);
					}
				}

			} else if ("2".equals(dealStatus)) {
				// 代表签报驳回
				if (Constants.CHECK_TYPE_7.equals(checkType)) {
					fbBusInst.setInstStatus(Constants.INST_STATUS_4);
				}
			}
		} else {
			if (instStatus.equals(Constants.INST_STATUS_3)) {
				// 如果是发起状态，则改为审批中
				fbBusInst.setInstStatus(Constants.INST_STATUS_1);
			}

		}

		fbBusInstMapper.updateByPrimaryKey(fbBusInst);

		// 如果实例结束了，就删除已关注的列表
	}

	/**
	 * 流程模版讯息提醒
	 */
	public void fbTemplateNotify(FbBusInst fbBusInst) throws Exception {
		// 给流程模版提醒人进行消息通知
		// 流程提醒
		// 获取流程模版
		FbBusTemplate fbBusTemplate = fbBusTemplateMapper.selectByPrimaryKey(fbBusInst.getFbId());
		// 查询该流程模版需要提醒的人
		FbBusTemplateNotifyExample FbBusTemplateNotifyExample = new FbBusTemplateNotifyExample();
		FbBusTemplateNotifyExample.createCriteria().andTCodeEqualTo(fbBusTemplate.gettCode());
		List<FbBusTemplateNotify> fbBusTemplatNotifyList = fbBusTemplateNotifyMapper
				.selectByExample(FbBusTemplateNotifyExample);
		String signEmpIds = "";
		for (int i = 0; i < fbBusTemplatNotifyList.size(); i++) {
			FbBusTemplateNotify fbttNotify = fbBusTemplatNotifyList.get(i);
			String notifyEmpId = fbttNotify.getNotifyEmpId();
			if (i == fbBusTemplatNotifyList.size() - 1) {
				signEmpIds = signEmpIds + notifyEmpId;
			} else {
				signEmpIds = signEmpIds + notifyEmpId + ";";
			}
		}
		if (!fbBusTemplatNotifyList.isEmpty()) {
			Map<String, Object> inforMap = new HashMap<String, Object>();
			inforMap.put("title", "流程提醒通知");
			inforMap.put("content", "您有一个标题为《" + fbBusInst.getFbTitle() + "》的流程提醒!");
			inforMap.put("sender", systemEmpId);
			inforMap.put("receiver", signEmpIds);
			inforMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
													// ,流程讯息(flowInfor),
													// 公文讯息(docInfor),
													// 公示讯息(pubInfor),
													// 问卷讯息(askInfor),
													// 日程讯息(dayInfor))
			inforMap.put("bus_type", "FB06");// 待办类型
			inforMap.put("bus_id", fbBusInst.getId());// 实例id
			Map<String, Object> busDomainMap = new HashMap<String, Object>();
			ObjectMapper objMapper = new ObjectMapper();
			busDomainMap.put("inst_id", fbBusInst.getId());// 流程实例id
			busDomainMap.put("task_id", null);// 代办任务id
			busDomainMap.put("cur_tag_id", null);// 待办节点id
			busDomainMap.put("cur_tag_name", null);// 待办节点id
			busDomainMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
														// ,流程讯息(flowInfor),
														// 公文讯息(docInfor),
														// 公示讯息(pubInfor),
														// 问卷讯息(askInfor),
														// 日程讯息(dayInfor))
			busDomainMap.put("bus_type", "FB06");// 提醒
			String domainStr = objMapper.writeValueAsString(busDomainMap);
			inforMap.put("bus_domain", domainStr);
			runnableService.inforCall(inforMap);
		}
	}

	/**
	 * 实例完成就取消关注
	 * 
	 * @param appMap
	 * @param checkId
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void careCancle(FbBusInst fbBusInst) {
		FbBusCareExample careExample = new FbBusCareExample();
		careExample.createCriteria().andInstIdEqualTo(fbBusInst.getId());
		fbBusCareMapper.deleteByExample(careExample);
	}

	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public FbBusCheck commonCheck(Map<String, Object> appMap, String checkId) throws Exception {

		// 审核状态(0:拒绝,1:同意)
		String check_status = (String) appMap.get("check_status");
		// 审核方式：0：普通，1:附条件同意,2:驳回至,3,加签,4会签,5:预处理,6:委托
		String check_type = (String) appMap.get("check_type");
		// 根据登录人id，选择的任务task_id，进行任务审核
		String task_id = (String) appMap.get("task_id");
		// 审核id
		String check_id = getId();
		if (checkId != null) {
			check_id = checkId;
		}
		// 业务id,也是申请inst_id
		String bus_id = (String) appMap.get("inst_id");

		Boolean finishFlag = actProcessService.taskFinished(task_id);

		if (finishFlag) {
			// 说明任务已经完成了
			throw new AppException("该流程已不在您的审批节点!");
		}
		// 根据task_id获取task信息
		TaskEntity task = actProcessService.findTaskById(task_id);
		// 审核业务信息保存
		FbBusCheck fbBusCheck = checkBus(appMap, bus_id, check_id, task.getTaskDefinitionKey(), task.getName());

		// 如果是同意
		if (Constants.CHECK_STATUS_1.equals(check_status)) {
			/**
			 * //同意的时候判断该节点是顺序执行，还是跳转执行 //根据inst_id,inst_tag,查询是否存在驳回规则
			 * FbBusRejectRuleExample rejectRuleExample=new
			 * FbBusRejectRuleExample();
			 * com.zrt.mybatis.domain.FbBusRejectRuleExample.Criteria
			 * rejectRuleCriteria=rejectRuleExample.createCriteria();
			 * rejectRuleCriteria.andInstIdEqualTo(bus_id);
			 * rejectRuleCriteria.andOldInstTagEqualTo(task.getTaskDefinitionKey
			 * ()); List<FbBusRejectRule> fbBusRejectRuleList=
			 * fbBusRejectRuleMapper.selectByExample(rejectRuleExample);
			 * if(fbBusRejectRuleList.isEmpty()){ //参数传递 Map<String, Object>
			 * variables=new HashMap<>(); variables.put("deal_status",
			 * check_status); actProcessService.passProcess(task_id, variables);
			 * }else{ FbBusRejectRule
			 * fbBusRejectRule=fbBusRejectRuleList.get(0); String
			 * tagTag=fbBusRejectRule.getOldInstTag(); }
			 **/
			if (Constants.CHECK_TYPE_3.equals(check_type)) {
				// 如果是加签的话就转办
				// 不做流程转向
			} else {
				// 完成任务的时候先判断是否是共享任务，如果是则改变下认领人
				actProcessService.taskIdLinks(task_id, (String) appMap.get("emp_id"));

				// 获取下一节设置审批人参数
				String nextAssignee = (String) appMap.get("next_tag_assignee");
				Map<String, Object> actNextMap = processService.actNextList(appMap);
				List<Map<String, Object>> actList = (List<Map<String, Object>>) actNextMap.get("list");
				if (null != actList && !actList.isEmpty()) {
					for (Map<String, Object> actMap : actList) {
						String isassignee = (String) actMap.get("isassignee");
						if ((null == nextAssignee || "".equals(nextAssignee)) && "1".equals(isassignee)) {
							throw new AppException("请指定下一审批人！");
						}
					}
				}
				if (nextAssignee == null || "".equals(nextAssignee)) {
					// 如果传递过来下一审批人为空，则不进行task传递
					// 参数传递
					Map<String, Object> variables = new HashMap<>();
					variables.put("deal_status", check_status);
					variables.put("next_tag_assignee", nextAssignee);
					actProcessService.passProcess(task_id, variables);
				} else {
					Map<String, Object> variables = new HashMap<>();
					variables.put("deal_status", check_status);
					variables.put("next_tag_assignee", nextAssignee);
					actProcessService.passProcess(task_id, variables);
				}

			}

		} else {// 拒绝的话就进行节点回退
				// 判断审核类型
			if (Constants.CHECK_TYPE_2.equals(check_type)) {
				// 退回的节点
				String back_tag_id = (String) appMap.get("back_tag_id");
				// 驳回至信息保存到数据库
				String curr_date = DateUtil.getCurrentDateTime();// 当前时间
				FbBusRejectRule fbBusRejectRule = new FbBusRejectRule();
				fbBusRejectRule.setId(getId());// 驳回规则id
				fbBusRejectRule.setInstId(bus_id);
				fbBusRejectRule.setCheckId(fbBusCheck.getId());
				fbBusRejectRule.setOldInstTag((String) appMap.get("back_tag_id"));
				fbBusRejectRule.setOldInstTagName((String) appMap.get("back_tag_name"));
				fbBusRejectRule.setDealFlag((String) appMap.get("deal_flag"));// 驳回规则
				fbBusRejectRule.setCreateDateTime(curr_date);
				fbBusRejectRule.setUpdateDateTime(curr_date);
				fbBusRejectRuleMapper.insert(fbBusRejectRule);

				// 参数传递
				Map<String, Object> variables = new HashMap<>();
				variables.put("deal_status", check_status);
				actProcessService.backProcess(task_id, back_tag_id, variables);
			} else {
				// 流程结束
				actProcessService.deleteInst(bus_id, "reject");
			}

		}

		// 更新流程实例信息，更新时间，更新审批状态
		instDeal(bus_id, check_status, check_type);
		// 审批结束给发起人发通知
		if ("0".equals(check_type) || "2".equals(check_type)) {
			String instId = (String) appMap.get("inst_id");
			FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);

			Map<String, Object> inforMap = new HashMap<String, Object>();
			inforMap.put("title", "流程办理进度通知");
			if ("2".equals(check_type)) {
				inforMap.put("content", "您发起的标题为《" + fbBusInst.getFbTitle() + "》的流程被驳回!");
			} else {
				inforMap.put("content", "您发起的标题为《" + fbBusInst.getFbTitle() + "》的流程有新的办理进度!");
			}
			inforMap.put("sender", systemEmpId);
			inforMap.put("receiver", fbBusInst.getApplyId());
			inforMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
			inforMap.put("bus_type", "FB13");// 流程办理进度通知
			inforMap.put("bus_id", fbBusInst.getId());// 实例id
			Map<String, Object> busDomainMap = new HashMap<String, Object>();
			ObjectMapper objMapper = new ObjectMapper();
			busDomainMap.put("inst_id", fbBusInst.getId());// 流程实例id
			busDomainMap.put("task_id", task_id);// 代办任务id
			busDomainMap.put("cur_tag_id", task.getTaskDefinitionKey());// 待办节点id
			busDomainMap.put("cur_tag_name", task.getName());// 待办节点id
			busDomainMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
			busDomainMap.put("bus_type", "FB13");// 待办类型

			String domainStr = objMapper.writeValueAsString(busDomainMap);
			inforMap.put("bus_domain", domainStr);
			runnableService.inforCall(inforMap);
		}

		return fbBusCheck;

	}

	public String getId() {
		// String serialId=String.valueOf(Math.random());
		String serialId = serialService.getUUID();
		return serialId;
	}

	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public FbBusCheck checkBus(Map<String, Object> appMap, String bus_id, String check_id, String inst_tag,
			String inst_tag_name) throws Exception {
		// 判断是否创建了阅读信息,保存或更新审核表
		FbBusCheck fbBusCheck = checkSave(appMap, check_id, inst_tag, inst_tag_name);
		// 审核附件保存
		// 保存流程申请附件，关联流程信息信息
		// 关联流程，信息
		List<Map<String, Object>> relList = (List<Map<String, Object>>) appMap.get("rel");
		// 附件list
		List<Map<String, Object>> fileList = (List<Map<String, Object>>) appMap.get("file");
		// 申请业务id,1-发起附件，null不是审核的附件
		fileBus(fileList, relList, bus_id, "1", fbBusCheck.getId());

		return fbBusCheck;
	}

	/**
	 * 保存业务审核表
	 * 
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public FbBusCheck checkSave(Map<String, Object> appMap, String checkId, String inst_tag, String inst_tag_name)
			throws Exception {

		String instId = (String) appMap.get("inst_id");

		// 判断是否创建了阅读信息
		FbBusCheckExample example = new FbBusCheckExample();
		com.zrt.mybatis.domain.FbBusCheckExample.Criteria criteria = example.createCriteria();
		criteria.andCheckEmpIdEqualTo((String) appMap.get("emp_id"));// id
		criteria.andInstIdEqualTo(instId);// id
		criteria.andTaskIdEqualTo((String) appMap.get("task_id"));// 任务id
		List<FbBusCheck> fbBusCheckList = fbBusCheckMapper.selectByExample(example);

		String cur_date = DateUtil.getCurrentDateTime();
		// 登录人id
		String emp_id = (String) appMap.get("emp_id");
		Map<String, Object> empData = getEmpInfo(emp_id);
		// 原审核人id
		String oldEmpId = null;
		// 原审核人name
		String oldEmpName = null;
		// 根据发起id找原审核人信息
		List<Map<String, Object>> oldResList = flowEntrustCustomMapper.getOldEmp(instId);
		if (null != oldResList && !oldResList.isEmpty()) {
			for (Map<String, Object> oldResMap : oldResList) {
				String entEmpId = (String) oldResMap.get("ent_emp_id");
				if (StringUtils.isNotBlank(entEmpId)) {
					if (emp_id.equals(entEmpId)) {
						oldEmpId = (String) oldResMap.get("check_emp_id");
						oldEmpName = (String) oldResMap.get("check_emp_name");
					}
				}
			}
		}

		FbBusCheck fbBusCheck = null;
		// 添加审核信息数据//判断是否存在该数据，若存在，说明已阅已经保存
		if (fbBusCheckList.isEmpty()) {
			String check_id = getId();
			if (checkId != null) {
				check_id = checkId;
			}
			TaskEntity task = actProcessService.findTaskById((String) appMap.get("task_id"));

			// 保存审核信息表
			fbBusCheck = new FbBusCheck();
			fbBusCheck.setId(check_id);// 审核id
			fbBusCheck.setCheckEmpId(emp_id);// 审核人id
			fbBusCheck.setCheckEmpName((String) empData.get("emp_name"));// 审核人姓名
			fbBusCheck.setOrgId((String) empData.get("org_id"));// 所在机构组织id
			fbBusCheck.setOrgName((String) empData.get("org_name"));// 组织机构名称
			fbBusCheck.setInstId(instId);// 申请id，也是业务id
			fbBusCheck.setInstTag(inst_tag);// 当前节点id
			fbBusCheck.setInstTagName(inst_tag_name);// 当前节点名称
			fbBusCheck.setCreateDateTime(cur_date);// 当前时间
			fbBusCheck.setUpdateDateTime(cur_date);// 更新时间
			fbBusCheck.setCheckStatus((String) appMap.get("check_status"));// 审核状态审核状态(0:拒绝,1:同意)
			fbBusCheck.setCheckType((String) appMap.get("check_type"));// 审核方式：0：普通，1:附条件同意,2:驳回至,3,加签,4会签,5:预处理,6:委托
			fbBusCheck.setCheckComment((String) appMap.get("check_comment"));// 审核意见
			fbBusCheck.setOldEmpId(oldEmpId);//// 原审核人id
			fbBusCheck.setOldEmpName(oldEmpName);//// 原审核人name
			fbBusCheck.setArriveDateTime(DateUtil.getDateFormat(task.getCreateTime(), "yyyyMMddHHmmss"));// 到达时间
			if (appMap.get("read_date_time") != null && !"".equals((String) appMap.get("read_date_time"))) {
				fbBusCheck.setReadDateTime((String) appMap.get("read_date_time"));// 阅读时间
			} else {
				fbBusCheck.setReadDateTime(cur_date);// 阅读时间
			}

			fbBusCheck.setTaskId((String) appMap.get("task_id"));// 任务id
			fbBusCheck.setRepeatFlag((String) appMap.get("repeat_flag"));// 是否规避重复审批0:否，1:是
			if (appMap.get("check_date_time") != null && !"".equals((String) appMap.get("check_date_time"))) {
				fbBusCheck.setCheckDateTime((String) appMap.get("check_date_time"));// 审批时间
			} else {
				fbBusCheck.setCheckDateTime(cur_date);// 阅读时间
			}
			fbBusCheck.setCheckDesc((String) appMap.get("check_desc"));// 备注
			fbBusCheckMapper.insert(fbBusCheck);
		} else {
			// 存在审核数据
			fbBusCheck = fbBusCheckList.get(0);
			fbBusCheck.setCheckEmpId(emp_id);// 审核人id
			fbBusCheck.setCheckEmpName((String) empData.get("emp_name"));// 审核人姓名
			fbBusCheck.setOrgId((String) empData.get("org_id"));// 所在机构组织id
			fbBusCheck.setOrgName((String) empData.get("org_name"));// 组织机构名称
			fbBusCheck.setInstId(instId);// 申请id，也是业务id
			fbBusCheck.setInstTag(inst_tag);// 当前节点id
			fbBusCheck.setInstTagName(inst_tag_name);// 当前节点名称
			// fbBusCheck.setCreateDateTime(cur_date);//当前时间
			fbBusCheck.setUpdateDateTime(cur_date);// 更新时间
			fbBusCheck.setCheckStatus((String) appMap.get("check_status"));// 审核状态审核状态(0:拒绝,1:同意)
			fbBusCheck.setCheckType((String) appMap.get("check_type"));// 审核方式：0：普通，1:附条件同意,2:驳回至,3,加签,4会签,5:预处理,6:委托
			fbBusCheck.setCheckComment((String) appMap.get("check_comment"));// 审核意见
			fbBusCheck.setOldEmpId(oldEmpId);//// 原审核人id
			fbBusCheck.setOldEmpName(oldEmpName);//// 原审核人name
			// fbBusCheck.setArriveDateTime(cur_date);//到达时间
			// fbBusCheck.setReadDateTime(cur_date);//阅读时间
			fbBusCheck.setRepeatFlag((String) appMap.get("repeat_flag"));// 是否规避重复审批0:否，1:是
			fbBusCheck.setCheckDateTime(cur_date);// 审核时间
			fbBusCheckMapper.updateByPrimaryKey(fbBusCheck);
		}
		return fbBusCheck;
	}

	/**
	 * 
	 * @param appMap
	 * @param inst_id
	 * @param fb_type
	 *            0:发起的附件，1：审核附件
	 * @param check_id
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void fileBus(List<Map<String, Object>> fileList, List<Map<String, Object>> relList, String inst_id,
			String fb_type, String check_id) {

		String cur_date = DateUtil.getCurrentDateTime();
		// 附件list
		if (fileList != null && !fileList.isEmpty()) {
			for (Map<String, Object> map : fileList) {
				FbBusFile fbBusFile = new FbBusFile();
				fbBusFile.setId(getId());// 主键id
				fbBusFile.setInstId(inst_id);// 流程发起id
				fbBusFile.setFileUrl((String) map.get("file_url"));// 文件url
				fbBusFile.setFileName((String) map.get("file_name"));// 文件名称
				fbBusFile.setFileType((String) map.get("file_type"));// 0:普通附件；1：云盘
				fbBusFile.setNodeId((String) map.get("node_id"));// 云盘节点id
				fbBusFile.setCreateDateTime(cur_date);// 创建时间
				fbBusFile.setCheckId(check_id);// 审核id(审核过程才会有这个id)
				fbBusFile.setFbType(fb_type);// 发起/审核(0:发起，1:审核)
				fbBusFileMapper.insert(fbBusFile);
			}
		}

		// 关联信息list
		if (relList != null && !relList.isEmpty()) {
			for (Map<String, Object> map : relList) {
				FbBusRelevance fbBusRelevance = new FbBusRelevance();
				fbBusRelevance.setId(getId());// 主键id
				fbBusRelevance.setInstId(inst_id);// 流程发起id
				fbBusRelevance.setRelId((String) map.get("rel_id"));// 文件url
				fbBusRelevance.setRelName((String) map.get("rel_name"));// 文件名称
				fbBusRelevance.setRelType((String) map.get("rel_type"));// 0:普通附件；1：云盘
				fbBusRelevance.setCreateDateTime(cur_date);// 创建时间
				fbBusRelevance.setCheckId(check_id);// 审核id(审核过程才会有这个id)
				fbBusRelevance.setFbType(fb_type);// 发起/审核(0:发起，1:审核)
				fbBusRelevanceMapper.insert(fbBusRelevance);
			}
		}

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
	 * 附条件类型
	 * 
	 * @param listFile
	 * @param listRelevance
	 * @param conId
	 * @param conType
	 *            0：审批人，1：发起人
	 * @throws ReflectiveOperationException
	 */
	public void conFileRel(List<Map<String, Object>> listFile, List<Map<String, Object>> listRelevance, String conId,
			String conType) throws ReflectiveOperationException {
		String curr_date = DateUtil.getCurrentDateTime();// 当前时间
		if (listFile != null && listFile.size() > 0) {
			for (Map<String, Object> m : listFile) {
				FbBusAddFile fbBusAddFile = (FbBusAddFile) MapEntityConverter.getEntityFromMap(m, FbBusAddFile.class);
				fbBusAddFile.setId(getId());
				fbBusAddFile.setConId(conId);
				fbBusAddFile.setCreateDateTime(curr_date);
				fbBusAddFile.setConType(conType);
				fbBusAddFileMapper.insertSelective(fbBusAddFile);
			}
		}

		if (listRelevance != null && listRelevance.size() > 0) {
			for (Map<String, Object> m : listRelevance) {
				FbBusAddRelevance fbBusAddRelevance = (FbBusAddRelevance) MapEntityConverter.getEntityFromMap(m,
						FbBusAddRelevance.class);
				fbBusAddRelevance.setConId(conId);
				fbBusAddRelevance.setCreateDateTime(curr_date);
				fbBusAddRelevance.setId(getId());
				fbBusAddRelevance.setConType(conType);
				fbBusAddRelevanceMapper.insertSelective(fbBusAddRelevance);
			}
		}
	}

	/**
	 * 根据审批角色，查询该审批角色里面有多少人
	 * 
	 */
	public List<Map<String, Object>> roleUsers(List<String> groupIdList) {
		Object[] idArr = new String[groupIdList.size()];
		idArr = groupIdList.toArray();
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("idArr", idArr);
		List<Map<String, Object>> roleUserList = roleUserMapper.roleUserList(reqMap);
		return roleUserList;
	}

	// 保存表单内容信息
	public void formBus(Map<String, Object> appMap, String inst_id, String inst_tag, String inst_tag_name) {
		// 申请表单内容
		List<Map<String, Object>> formProperties = (List<Map<String, Object>>) appMap.get("template");
		for (Map<String, Object> map : formProperties) {
			FbBusData fbBusData = new FbBusData();
			fbBusData.setId(getId());// 主键id
			fbBusData.setInstId(inst_id);// 申请流程id
			fbBusData.setColValue((String) map.get("col_value"));// 列值
			fbBusData.setColText((String) map.get("col_text"));// 下拉框的值
			fbBusData.setColCode((String) map.get("col_code"));// 列code
			fbBusData.setColType((String) map.get("col_type"));// 列类型
			fbBusData.setColTitle((String) map.get("col_title"));// 列name
			fbBusData.setVersion(1);//
			fbBusData.setInstTag(inst_tag);// 当前节点id
			fbBusData.setInstTagName(inst_tag_name);// 当前节点name
			fbBusDataMapper.insert(fbBusData);
		}
	}

	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public FbBusInst applyBus(Map<String, Object> appMap, String bus_id, String inst_tag, String inst_tag_name) {
		Map<String, Object> conmap = new HashMap<>();
		conmap.put("search", appMap.get("emp_id"));
		Map<String, Object> result = contactsService.commonEmpSearch(conmap);

		List<Map<String, Object>> li = (List<Map<String, Object>>) result.get("data");
		Map<String, Object> empData = null;
		if (null != li && li.size() > 0) {
			empData = li.get(0);
		}
		// 员工姓名
		String emp_name = (String) empData.get("emp_name");
		// 组织机构id
		String org_id = (String) appMap.get("apply_org_id");
		// 组织机构名称
		String org_name = (String) appMap.get("apply_org_name");
		String cur_date = DateUtil.getCurrentDateTime();
		// 根据申请人保存申请信息表
		FbBusInst fbBusInst = new FbBusInst();
		fbBusInst.setId(bus_id);// 主键id
		fbBusInst.setApplyId((String) appMap.get("emp_id"));// 申请人id
		fbBusInst.setApplyName(emp_name);// 申请人姓名
		fbBusInst.setOrgId(org_id);// 申请人机构id
		fbBusInst.setOrgName(org_name);// 申请人机构名称
		fbBusInst.setFbId((String) appMap.get("id"));// 流程模版id
		fbBusInst.setFbTitle((String) appMap.get("fb_title"));

		fbBusInst.setCreateDateTime(cur_date);// 创建时间
		fbBusInst.setUpdateDateTime(cur_date);// 更新时间
		fbBusInst.setStartDateTime(cur_date);// 开始时间
		fbBusInst.setInstStatus((String) appMap.get("inst_status"));// 状态发起中
		fbBusInst.setInstTag(inst_tag);// 当前节点id
		fbBusInst.setInstTagName(inst_tag_name);// 当前节点名称
		fbBusInst.setFbContent((String) appMap.get("fb_content"));
		fbBusInst.setNextTagAssignee((String) appMap.get("next_tag_assignee"));// 下一节点审批人
		// 保存业务申请表
		fbBusInstMapper.insert(fbBusInst);

		// 保存流程申请附件，关联流程信息信息
		// 关联流程，信息
		List<Map<String, Object>> relList = (List<Map<String, Object>>) appMap.get("rel");
		// 附件list
		List<Map<String, Object>> fileList = (List<Map<String, Object>>) appMap.get("file");
		// 申请业务id,0-发起附件，null不是审核的附件
		fileBus(fileList, relList, bus_id, "0", null);

		// 项目list
		List<Map<String, Object>> projectList = (List<Map<String, Object>>) appMap.get("project");
		if (projectList != null && !projectList.isEmpty()) {
			projectBus(projectList, bus_id);
		}

		return fbBusInst;
	}

	/**
	 * 
	 * @param projectList
	 * @param inst_id
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void projectBus(List<Map<String, Object>> projectList, String inst_id) {

		String cur_date = DateUtil.getCurrentDateTime();
		if (projectList == null || projectList.size() == 0) {
			return;
		}
		// 附件list
		for (Map<String, Object> map : projectList) {
			FbBusProject fbBusProject = new FbBusProject();
			fbBusProject.setId(getId());// 主键id
			fbBusProject.setInstId(inst_id);// 流程发起id
			fbBusProject.setProjectCode((String) map.get("project_code"));// 项目编号
			fbBusProject.setProjectName((String) map.get("project_name"));// 项目名称
			fbBusProject.setFundCode((String) map.get("fund_code"));// 产品代码
			fbBusProject.setCreateDateTime(cur_date);// 创建时间
			fbBusProjectMapper.insert(fbBusProject);
		}

	}

	/**
	 * 查询流程实例，最新审批的信息
	 * 
	 * @param instId
	 * @return
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public FbBusCheck queryLastInfor(String instId) {
		FbBusCheckExample checkExample = new FbBusCheckExample();
		com.zrt.mybatis.domain.FbBusCheckExample.Criteria checkCriteria = checkExample.createCriteria();
		checkCriteria.andInstIdEqualTo(instId);
		checkCriteria.andCheckStatusEqualTo("1");// 选择同意的
		checkExample.setOrderByClause(" check_date_time desc");
		List<FbBusCheck> checkList = fbBusCheckMapper.selectByExample(checkExample);
		FbBusCheck fbBusCheck = new FbBusCheck();
		if (checkList != null && checkList.size() > 0) {
			fbBusCheck = checkList.get(0);
		}
		return fbBusCheck;
	}

}
