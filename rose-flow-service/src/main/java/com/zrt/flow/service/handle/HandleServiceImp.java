package com.zrt.flow.service.handle;

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
import com.zrt.commons.AppException;
import com.zrt.commons.cons.Constants;
import com.zrt.commons.date.DateUtil;
import com.zrt.flow.mapper.handle.HandleMapper;
import com.zrt.flow.service.process.ProcessCommonService;
import com.zrt.flow.service.process.ProcessService;
import com.zrt.flow.service.runnable.RunnableService;
import com.zrt.flow.service.serial.SerialService;
import com.zrt.mybatis.domain.FbBusCheck;
import com.zrt.mybatis.domain.FbBusCheckExample;
import com.zrt.mybatis.domain.FbBusCheckExample.Criteria;
import com.zrt.mybatis.domain.FbBusHandle;
import com.zrt.mybatis.domain.FbBusHandleExample;
import com.zrt.mybatis.domain.FbBusInst;
import com.zrt.mybatis.domain.FbBusTemplate;
import com.zrt.mybatis.mapper.FbBusCheckMapper;
import com.zrt.mybatis.mapper.FbBusHandleMapper;
import com.zrt.mybatis.mapper.FbBusInstMapper;
import com.zrt.mybatis.mapper.FbBusTemplateMapper;
import com.zrt.mybatis.mapper.FbBusTemplateNotifyMapper;
import com.zrt.mybatis.mapper.FmBusTemplateMapper;

/**
 * 签报类操作服务类
 * 
 * @author wwfu
 *
 */
@Service
public class HandleServiceImp implements HandleService {
	@Autowired
	private FbBusTemplateMapper fbBusTemplateMapper;
	@Autowired
	private SerialService serialService;
	@Autowired
	private ProcessCommonService processCommonService;
	@Autowired
	private FbBusHandleMapper fbBusHandleMapper;
	@Autowired
	private FbBusInstMapper fbBusInstMapper;
	@Autowired
	private RunnableService runnableService;
	@Value("${im.notify.sender_id}")
	private String systemEmpId;
	@Autowired
	private HandleMapper handleMapper;
	@Autowired
	private FmBusTemplateMapper fmBusTemplateMapper;
	@Autowired
	private HandleCommonService handleCommonService;
	@Autowired
	private ProcessService processService;
	@Autowired
	private FbBusCheckMapper fbBusCheckMapper;
	@Autowired
	private FbBusTemplateNotifyMapper fbBusTemplateNotifyMapper;

	/**
	 * 签报类流程发起
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> handleApply(Map<String, Object> appMap) throws Exception {
		appMap.put("inst_status", "3");// 代表已发起
		// 流程id
		FbBusTemplate fbBusTemplate = fbBusTemplateMapper.selectByPrimaryKey((String) appMap.get("id"));
		Map<String, Object> proMap = new HashMap<String, Object>();
		// 根据登录人发起的申请
		proMap.put("apply_id", appMap.get("emp_id"));// 登录人id
		// 关联的业务id
		String bus_id = serialService.getSerialNumberFromDB("flow_inst_code");
		// 根据需求去掉年
		bus_id = bus_id.substring(0, 1) + bus_id.substring(3, bus_id.length());
		// 保存表单内容信息
		processCommonService.formBus(appMap, bus_id, null, null);
		// 保存业务申请表fb_bus_inst
		FbBusInst fbBusInst = processCommonService.applyBus(appMap, bus_id, null, null);
		String signEmpIds = (String) appMap.get("handle_emp_ids");
		if (signEmpIds == null || "".equals(signEmpIds)) {
			throw new AppException("请选择签报人!");
		}
		// 保存签报人信息
		handleCommon(appMap, bus_id, fbBusInst);
		return null;
	}

	/**
	 * 签报审核
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> handleCheck(Map<String, Object> appMap) throws Exception {
		// 判断是否创建了阅读信息,保存或更新审核表

		// 会签id
		List<Map<String, Object>> paramList = (List<Map<String, Object>>) appMap.get("param");

		// 审批意见
		String checkStatus = (String) appMap.get("check_status");
		if ("2".equals(checkStatus)) {
			// 如果是驳回，则代表的是不同意
			checkStatus = "0";
		}
		// 签报意见
		String check_comment = (String) appMap.get("check_comment");
		for (Map<String, Object> map : paramList) {
			map.put("check_type", Constants.CHECK_TYPE_7);// 审核类型
			map.put("task_id", map.get("handle_id"));// 签报id，就是任务id
			map.put("repeat_flag", "0");// 默认否
			map.put("check_status", checkStatus);// 审核意见
			map.put("check_comment", check_comment);// 审核备注
			map.put("emp_id", appMap.get("emp_id"));// 审批人,登录人
			// 审批意见
			if (checkStatus == null || "".equals(checkStatus)) {
				// 如果是空说明是发起人继续添加签报人
				FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey((String) map.get("inst_id"));
				// 获取发起人
				String applyId = fbBusInst.getApplyId();
				// 登录人
				String empId = (String) appMap.get("emp_id");
				// 判断是发起人关联的附件，则关联发起人相关附件，信息
				if (applyId.equals(empId)) {
					// 如果发起人等于登录人
					// 保存流程申请附件，关联流程信息信息
					// 关联流程，信息
					List<Map<String, Object>> relList = (List<Map<String, Object>>) appMap.get("rel");
					// 附件list
					List<Map<String, Object>> fileList = (List<Map<String, Object>>) appMap.get("file");
					// 申请业务id,0-发起附件，null不是审核的附件
					processCommonService.fileBus(fileList, relList, fbBusInst.getId(), "0", null);

					// 项目list
					List<Map<String, Object>> projectList = (List<Map<String, Object>>) appMap.get("project");
					processCommonService.projectBus(projectList, fbBusInst.getId());
					// 保存签报人信息
					map.put("applyId", applyId);// 发起人再次签报也添加审批和签报记录
					map.put("handle_emp_ids", (String) map.get("handle_emp_ids") + ";" + applyId);
					handleCommon(map, (String) map.get("inst_id"), fbBusInst);
				}

			} else {
				// 更新签报信息
				String cur_date = DateUtil.getCurrentDateTime();
				FbBusHandle fbBusHandle = fbBusHandleMapper.selectByPrimaryKey((String) map.get("handle_id"));
				String handleStatus = fbBusHandle.getHandleStatus();
				if ("1".equals(handleStatus)) {
					// 审批人还会新增一条审批信息
					// Map<String, Object> newEmpData
					// =processCommonService.getEmpInfo((String)appMap.get("emp_id"));
					String handleId = serialService.getUUID();// 签报id
					// 新增审核信息
					Map<String, Object> checkMap = new HashMap<>();
					checkMap.put("check_type", Constants.CHECK_TYPE_7);// 审核类型
					checkMap.put("inst_id", (String) map.get("inst_id"));
					checkMap.put("task_id", handleId);// 签报id，就是任务id
					checkMap.put("emp_id", appMap.get("emp_id"));// 审批人,登录人
					checkMap.put("repeat_flag", "0");// 默认否
					checkMap.put("check_status", checkStatus);// 审核意见
					checkMap.put("check_comment", check_comment);// 审核备注
					checkMap.put("rel", appMap.get("rel"));// 讯息，流程
					checkMap.put("file", appMap.get("file"));// 附件
					// FbBusCheck
					// fbBusCheck=processCommonService.checkBus(checkMap,(String)map.get("inst_id"),null,null,
					// null);
					// 保存审核信息表
					String check_id = processCommonService.getId();
					Map<String, Object> empData = processCommonService.getEmpInfo((String) appMap.get("emp_id"));
					FbBusCheck fbBusCheck = new FbBusCheck();
					fbBusCheck.setId(check_id);// 审核id
					fbBusCheck.setCheckEmpId(fbBusHandle.getHandleEmpId());// 审核人id
					fbBusCheck.setCheckEmpName((String) empData.get("emp_name"));// 审核人姓名
					fbBusCheck.setOrgId((String) empData.get("org_id"));// 所在机构组织id
					fbBusCheck.setOrgName((String) empData.get("org_name"));// 组织机构名称
					fbBusCheck.setInstId((String) checkMap.get("inst_id"));// 申请id，也是业务id
					fbBusCheck.setInstTag(null);// 当前节点id
					fbBusCheck.setInstTagName(null);// 当前节点名称
					fbBusCheck.setCreateDateTime(cur_date);// 当前时间
					fbBusCheck.setUpdateDateTime(cur_date);// 更新时间
					fbBusCheck.setCheckStatus((String) checkMap.get("check_status"));// 审核状态审核状态(0:拒绝,1:同意)
					fbBusCheck.setCheckType((String) checkMap.get("check_type"));// 审核方式：0：普通，1:附条件同意,2:驳回至,3,加签,4会签,5:预处理,6:委托
					fbBusCheck.setCheckComment((String) checkMap.get("check_comment"));// 审核意见
					fbBusCheck.setOldEmpId(null);//// 原审核人id
					fbBusCheck.setOldEmpName(null);//// 原审核人name
					fbBusCheck.setArriveDateTime(cur_date);// 到达时间
					fbBusCheck.setReadDateTime(cur_date);// 阅读时间
					fbBusCheck.setTaskId((String) checkMap.get("task_id"));// 任务id
					fbBusCheck.setRepeatFlag((String) checkMap.get("repeat_flag"));// 是否规避重复审批0:否，1:是
					fbBusCheck.setCheckDateTime(cur_date);// 审核时间
					fbBusCheck.setCheckDesc((String) checkMap.get("check_desc"));// 备注
					fbBusCheckMapper.insert(fbBusCheck);

					// 关联流程，信息
					List<Map<String, Object>> relList = (List<Map<String, Object>>) appMap.get("rel");
					// 附件list
					List<Map<String, Object>> fileList = (List<Map<String, Object>>) appMap.get("file");
					// 申请业务id,1-审核附件，null不是审核的附件
					processCommonService.fileBus(fileList, relList, (String) map.get("inst_id"), "1",
							fbBusCheck.getId());
					// 新增签报信息
					FbBusHandle newfbBusHandle = new FbBusHandle();
					newfbBusHandle.setId(handleId);// 会签id
					newfbBusHandle.setHandleEmpId((String) appMap.get("emp_id"));
					newfbBusHandle.setHandleEmpName((String) empData.get("emp_name"));
					newfbBusHandle.setOrgId((String) empData.get("org_id"));
					newfbBusHandle.setOrgName((String) empData.get("org_name"));
					newfbBusHandle.setSendEmpId((String) appMap.get("emp_id"));
					newfbBusHandle.setSendEmpName((String) empData.get("emp_name"));
					newfbBusHandle.setInstId((String) map.get("inst_id"));// 发起id
					newfbBusHandle.setInstTag(null);// 流程节点id
					newfbBusHandle.setInstTagName(null);// 流程节点名称
					newfbBusHandle.setCreateDateTime(cur_date);// 签报时间
					newfbBusHandle.setUpdateDateTime(cur_date);// 更新时间
					newfbBusHandle.setHandleStatus("1");// 已签报
					newfbBusHandle.setCheckId(fbBusCheck.getId());// 审核表id
					newfbBusHandle.setCheckStatus(checkStatus);
					newfbBusHandle.setParentId((String) map.get("handle_id"));// 原签报id
					fbBusHandleMapper.insert(newfbBusHandle);
					// 如果是已签报的状态，又进行审批，则进行签报人新增
					FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey((String) map.get("inst_id"));
					// 保存签报人信息
					checkMap.put("handle_emp_ids", map.get("handle_emp_ids"));
					handleCommon(checkMap, (String) map.get("inst_id"), fbBusInst);
				} else {
					fbBusHandle.setCheckDateTime(cur_date);// 签报时间
					fbBusHandle.setUpdateDateTime(cur_date);// 更新时间
					fbBusHandle.setHandleStatus("1");// 已签报
					fbBusHandle.setCheckComment(check_comment);// 签报意见
					fbBusHandle.setCheckStatus(checkStatus);// 签报状态(0:拒绝,1:同意)
					fbBusHandleMapper.updateByPrimaryKey(fbBusHandle);
					// 更新审核信息
					map.put("rel", appMap.get("rel"));// 讯息，流程
					map.put("file", appMap.get("file"));// 附件
					processCommonService.checkBus(map, (String) map.get("inst_id"), null, null, null);
					// 更新流程实例信息，更新时间，更新审批状态
					processCommonService.instDeal((String) map.get("inst_id"), (String) appMap.get("check_status"),
							Constants.CHECK_TYPE_7);
					// 签报完成之后，签报其他人
					FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey((String) map.get("inst_id"));

					handleCommon(map, (String) map.get("inst_id"), fbBusInst);
				}

				// 审核状态，如果是驳回2，则终结
				if ("2".equals(appMap.get("check_status"))) {
					handleEnd(map);
				}

			}

			// 已阅消息通知
			Map<String, Object> readInforMap = new HashMap<String, Object>();
			readInforMap.put("bus_id", map.get("inst_id"));
			readInforMap.put("bus_domain", map.get("handle_id"));
			runnableService.sendReadInfor(readInforMap);
		}

		return null;
	}

	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void handleCommon(Map<String, Object> appMap, String bus_id, FbBusInst fbBusInst) throws Exception {

		String applyId = (String) appMap.get("applyId");
		// 签报人数组
		String signEmpIds = (String) appMap.get("handle_emp_ids");
		if (signEmpIds == null || "".equals(signEmpIds)) {
			return;
		}
		String cur_date = DateUtil.getCurrentDateTime();
		String[] handleEmpIdArr = null;
		handleEmpIdArr = signEmpIds.split(";");
		if (handleEmpIdArr == null) {
			return;
		}
		List<String> handleEmpIdList = new ArrayList<String>();
		for (int i = 0; i < handleEmpIdArr.length; i++) {
			if (!handleEmpIdList.contains(handleEmpIdArr[i])) {
				handleEmpIdList.add(handleEmpIdArr[i]);
			}
		}
		Map<String, Object> mapEnt = new HashMap<>();
		mapEnt.put("inst_id", bus_id);
		// 查询该流程实例是否委托过
		List<Map<String, Object>> entList = handleMapper.fbEntListByInst(mapEnt);
		// 保存签报人员
		for (int i = 0; i < handleEmpIdList.size(); i++) {

			// 添加的签报人信息
			String empId = handleEmpIdArr[i];
			String oldEmpId = null;
			String oldEmpName = null;
			for (Map<String, Object> entMap : entList) {
				// 获取委托人
				String checkEmpId = (String) entMap.get("entrust_id");
				String checkEmpName = (String) entMap.get("entrust_name");
				// 受委托人信息
				String entedEmpId = (String) entMap.get("entrusted_id");
				String entedEmpName = (String) entMap.get("entrusted_name");
				if (empId.equals(checkEmpId)) {
					// 如果委托人存在跟签报人相同，说明签报人委托过该流程，则获取受委托人
					oldEmpId = empId;
					oldEmpName = checkEmpName;
					empId = entedEmpId;
					break;
				}
			}
			Map<String, Object> signEmpData = processCommonService.getEmpInfo(empId);
			String handleId = serialService.getUUID();// 签报id
			// 新增审核信息
			Map<String, Object> map = new HashMap<>();
			map.put("check_type", Constants.CHECK_TYPE_7);// 审核类型
			map.put("inst_id", bus_id);
			map.put("task_id", handleId);// 签报id，就是任务id
			map.put("emp_id", empId);// 审批人
			map.put("check_desc", (String) appMap.get("check_comment"));// 签报备注
			// 保存审核信息表
			String check_id = processCommonService.getId();
			Map<String, Object> empData = processCommonService.getEmpInfo(empId);
			FbBusCheck fbBusCheck = new FbBusCheck();
			fbBusCheck.setId(check_id);// 审核id
			fbBusCheck.setCheckEmpId(empId);// 审核人id
			fbBusCheck.setCheckEmpName((String) empData.get("emp_name"));// 审核人姓名
			fbBusCheck.setOrgId((String) empData.get("org_id"));// 所在机构组织id
			fbBusCheck.setOrgName((String) empData.get("org_name"));// 组织机构名称
			fbBusCheck.setInstId((String) map.get("inst_id"));// 申请id，也是业务id
			fbBusCheck.setInstTag(null);// 当前节点id
			fbBusCheck.setInstTagName(null);// 当前节点名称
			fbBusCheck.setCreateDateTime(cur_date);// 当前时间
			fbBusCheck.setUpdateDateTime(cur_date);// 更新时间

			fbBusCheck.setCheckType((String) map.get("check_type"));// 审核方式：0：普通，1:附条件同意,2:驳回至,3,加签,4会签,5:预处理,6:委托

			fbBusCheck.setOldEmpId(oldEmpId);//// 原审核人id
			fbBusCheck.setOldEmpName(oldEmpName);//// 原审核人name
			fbBusCheck.setArriveDateTime(cur_date);// 到达时间

			if (empId.equals(applyId)) {
				fbBusCheck.setReadDateTime(cur_date);// 阅读时间
				fbBusCheck.setCheckDateTime(cur_date);// 审核时间
				fbBusCheck.setCheckStatus("1");// 审核状态审核状态(0:拒绝,1:同意)
				fbBusCheck.setCheckComment((String) appMap.get("check_comment"));// 审核意见
			} else {
				fbBusCheck.setReadDateTime(null);// 阅读时间
				fbBusCheck.setCheckDateTime(null);// 审核时间
				fbBusCheck.setCheckStatus(null);// 审核状态审核状态(0:拒绝,1:同意)
				fbBusCheck.setCheckComment(null);// 审核意见
			}
			fbBusCheck.setTaskId((String) map.get("task_id"));// 任务id
			fbBusCheck.setRepeatFlag((String) map.get("repeat_flag"));// 是否规避重复审批0:否，1:是

			fbBusCheck.setCheckDesc((String) map.get("check_desc"));// 备注
			fbBusCheckMapper.insert(fbBusCheck);
			// 新增签报信息
			FbBusHandle fbBusHandle = new FbBusHandle();
			fbBusHandle.setId(handleId);// 会签id
			fbBusHandle.setHandleEmpId(empId);
			fbBusHandle.setHandleEmpName((String) signEmpData.get("emp_name"));
			fbBusHandle.setOrgId((String) signEmpData.get("org_id"));
			fbBusHandle.setOrgName((String) signEmpData.get("org_name"));
			fbBusHandle.setSendEmpId((String) appMap.get("emp_id"));
			Map<String, Object> loginEmpData = processCommonService.getEmpInfo((String) appMap.get("emp_id"));
			fbBusHandle.setSendEmpName((String) loginEmpData.get("emp_name"));
			fbBusHandle.setInstId(bus_id);// 发起id
			fbBusHandle.setInstTag(null);// 流程节点id
			fbBusHandle.setInstTagName(null);// 流程节点名称
			fbBusHandle.setCreateDateTime(cur_date);// 签报时间
			fbBusHandle.setUpdateDateTime(cur_date);// 更新时间
			if (empId.equals(applyId)) {
				fbBusHandle.setHandleStatus("1");// 发起人再次签报设置为已签报状态
			} else {
				fbBusHandle.setHandleStatus("0");// 未签报
			}
			fbBusHandle.setCheckId(fbBusCheck.getId());// 审核表id
			fbBusHandle.setParentId((String) appMap.get("handle_id"));// 原签报id
			fbBusHandle.setHandleDesc((String) appMap.get("check_comment"));// 签报备注
			fbBusHandleMapper.insert(fbBusHandle);
			// 会签讯息通知
			// 获取到流程实例信息//流程实例状态
			String fbStatus = fbBusInst.getInstStatus();
			if ("0".equals(fbStatus)) {
				// 如果是草稿，就不通知
				continue;
			}
			// 待办人讯息通知
			if (!empId.equals(applyId)) {
				Map<String, Object> inforMap = new HashMap<String, Object>();
				inforMap.put("title", "待办流程通知");
				inforMap.put("content", "您有一个标题为《" + fbBusInst.getFbTitle() + "》的流程待处理!");
				inforMap.put("sender", systemEmpId);
				inforMap.put("receiver", empId);
				inforMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
				// ,流程讯息(flowInfor),
				// 公文讯息(docInfor),
				// 公示讯息(pubInfor),
				// 问卷讯息(askInfor),
				// 日程讯息(dayInfor))
				inforMap.put("bus_type", "FB09");// 待办类型
				inforMap.put("bus_id", fbBusInst.getId());// 实例id
				Map<String, Object> busDomainMap = new HashMap<String, Object>();
				ObjectMapper objMapper = new ObjectMapper();
				busDomainMap.put("inst_id", bus_id);// 流程实例id
				busDomainMap.put("task_id", null);// 代办任务id
				busDomainMap.put("cur_tag_id", null);// 待办节点id
				busDomainMap.put("cur_tag_name", null);// 待办节点id
				busDomainMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
				// ,流程讯息(flowInfor),
				// 公文讯息(docInfor),
				// 公示讯息(pubInfor),
				// 问卷讯息(askInfor),
				// 日程讯息(dayInfor))
				busDomainMap.put("bus_type", "FB09");// 待办类型
				busDomainMap.put("handle_id", handleId);
				String domainStr = objMapper.writeValueAsString(busDomainMap);
				inforMap.put("bus_domain", domainStr);
				runnableService.inforCall(inforMap);
			}

		}
	}

	/**
	 * 签报类详情
	 */
	@Override
	public Map<String, Object> detail(Map<String, Object> appMap) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		// 已审核的签报信息
		Map<String, Object> checkMap = handleCommonService.detail(appMap);
		// 未审核的签报信息
		Map<String, Object> doMap = handleCommonService.doDetail(appMap);
		resMap.putAll(checkMap);
		resMap.putAll(doMap);
		return resMap;
	}

	/**
	 * 签报类办结
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> handleEnd(Map<String, Object> appMap) throws Exception {
		String instId = (String) appMap.get("inst_id");
		// 删除实例是否有未审批的
		FbBusHandleExample handleExample = new FbBusHandleExample();
		com.zrt.mybatis.domain.FbBusHandleExample.Criteria handleCriteria = handleExample.createCriteria();
		handleCriteria.andInstIdEqualTo(instId);
		handleCriteria.andHandleStatusEqualTo("0");// 未签报的
		fbBusHandleMapper.deleteByExample(handleExample);
		// 删除check表未审核的数据
		FbBusCheckExample CheckExample = new FbBusCheckExample();
		com.zrt.mybatis.domain.FbBusCheckExample.Criteria CheckCriteria = CheckExample.createCriteria();
		CheckCriteria.andInstIdEqualTo(instId);
		CheckCriteria.andCheckStatusIsNull();
		fbBusCheckMapper.deleteByExample(CheckExample);
		// 更新该流程为办结

		FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);
		// 审核状态，如果是驳回2，则终结
		if ("2".equals(appMap.get("check_status"))) {
			fbBusInst.setInstStatus(Constants.INST_STATUS_4);
		} else {
			fbBusInst.setInstStatus(Constants.INST_STATUS_2);
			// 对于同意结束的流程流程模版进行讯息提醒
			processCommonService.fbTemplateNotify(fbBusInst);
		}
		// 更新申请表
		String cur_date = DateUtil.getCurrentDateTime();
		fbBusInst.setUpdateDateTime(cur_date);
		fbBusInstMapper.updateByPrimaryKey(fbBusInst);

		return null;
	}

	/**
	 * 草稿保存
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> draftSave(Map<String, Object> appMap) throws Exception {
		appMap.put("inst_status", "0");// 代表草稿
		// 流程id
		// FbBusTemplate fbBusTemplate =
		// fbBusTemplateMapper.selectByPrimaryKey((String) appMap.get("id"));
		Map<String, Object> proMap = new HashMap<String, Object>();
		// 根据登录人发起的申请
		proMap.put("apply_id", appMap.get("emp_id"));// 登录人id
		// 关联的业务id
		String bus_id = serialService.getSerialNumberFromDB("flow_inst_code");
		bus_id = bus_id.substring(0, 1) + bus_id.substring(3, bus_id.length());
		// 保存表单内容信息
		processCommonService.formBus(appMap, bus_id, null, null);
		// 保存业务申请表fb_bus_inst
		FbBusInst fbBusInst = processCommonService.applyBus(appMap, bus_id, null, null);
		// 保存签报人信息
		handleCommon(appMap, bus_id, fbBusInst);
		return null;
	}

	/**
	 * 草稿更新
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> draftUpdate(Map<String, Object> appMap) throws Exception {
		// 流程实例id
		String instId = (String) appMap.get("inst_id");
		// 先更新普通流程信息，在更新签报信息
		processService.draftUpdate(appMap);
		// 更新流程inst_id删除check,handle表信息
		FbBusCheckExample checkExample = new FbBusCheckExample();
		Criteria checkCriteria = checkExample.createCriteria();
		checkCriteria.andInstIdEqualTo(instId);
		fbBusCheckMapper.deleteByExample(checkExample);
		// 删除handle签报人信息
		FbBusHandleExample handleExample = new FbBusHandleExample();
		com.zrt.mybatis.domain.FbBusHandleExample.Criteria handleCriteria = handleExample.createCriteria();
		handleCriteria.andInstIdEqualTo(instId);
		fbBusHandleMapper.deleteByExample(handleExample);

		// 然后保存签报人信息
		// 保存签报人信息
		// 查询该实例的状态
		FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);
		handleCommon(appMap, instId, fbBusInst);
		return null;
	}

	/**
	 * 草稿提交
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> draftApply(Map<String, Object> appMap) throws Exception {
		// 流程实例id
		String instId = (String) appMap.get("inst_id");
		// 先更新普通流程信息，在更新签报信息
		processService.draftUpdate(appMap);
		// 更新流程inst_id删除check,handle表信息
		FbBusCheckExample checkExample = new FbBusCheckExample();
		Criteria checkCriteria = checkExample.createCriteria();
		checkCriteria.andInstIdEqualTo(instId);
		fbBusCheckMapper.deleteByExample(checkExample);
		// 删除handle签报人信息
		FbBusHandleExample handleExample = new FbBusHandleExample();
		com.zrt.mybatis.domain.FbBusHandleExample.Criteria handleCriteria = handleExample.createCriteria();
		handleCriteria.andInstIdEqualTo(instId);
		fbBusHandleMapper.deleteByExample(handleExample);

		// 更新实例信息
		FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);
		fbBusInst.setInstStatus(Constants.INST_STATUS_3);// 状态发起中
		fbBusInstMapper.updateByPrimaryKey(fbBusInst);
		// 发起签报
		appMap.put("inst_status", "3");// 代表已发起
		handleCommon(appMap, instId, fbBusInst);
		return null;
	}

	/**
	 * 签报类流程发送
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> send(Map<String, Object> appMap) throws Exception {
		String instId = (String) appMap.get("inst_id");
		// 更新实例信息
		String cur_date = DateUtil.getCurrentDateTime();
		FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);
		fbBusInst.setInstStatus(Constants.INST_STATUS_3);// 状态发起中
		fbBusInst.setUpdateDateTime(cur_date);
		fbBusInstMapper.updateByPrimaryKey(fbBusInst);
		// 发起签报
		appMap.put("inst_status", Constants.INST_STATUS_3);// 代表已发起
		// 查询该实例的签报人
		FbBusHandleExample handleExample = new FbBusHandleExample();
		com.zrt.mybatis.domain.FbBusHandleExample.Criteria handleCriteria = handleExample.createCriteria();
		handleCriteria.andInstIdEqualTo(instId);
		List<FbBusHandle> handleList = fbBusHandleMapper.selectByExample(handleExample);
		for (FbBusHandle fbBusHandle : handleList) {
			// 给签报人发送信息
			// 待办人讯息通知
			Map<String, Object> inforMap = new HashMap<String, Object>();
			inforMap.put("title", "待办流程通知");
			inforMap.put("content", "您有一个标题为《" + fbBusInst.getFbTitle() + "》的流程待处理!");
			inforMap.put("sender", systemEmpId);
			inforMap.put("receiver", fbBusHandle.getHandleEmpId());
			inforMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
													// ,流程讯息(flowInfor),
													// 公文讯息(docInfor),
													// 公示讯息(pubInfor),
													// 问卷讯息(askInfor),
													// 日程讯息(dayInfor))
			inforMap.put("bus_type", "FB09");// 待办类型
			inforMap.put("bus_id", fbBusInst.getId());// 实例id
			Map<String, Object> busDomainMap = new HashMap<String, Object>();
			ObjectMapper objMapper = new ObjectMapper();
			busDomainMap.put("inst_id", instId);// 流程实例id
			busDomainMap.put("task_id", null);// 代办任务id
			busDomainMap.put("cur_tag_id", null);// 待办节点id
			busDomainMap.put("cur_tag_name", null);// 待办节点id
			busDomainMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
														// ,流程讯息(flowInfor),
														// 公文讯息(docInfor),
														// 公示讯息(pubInfor),
														// 问卷讯息(askInfor),
														// 日程讯息(dayInfor))
			busDomainMap.put("bus_type", "FB09");// 待办类型
			busDomainMap.put("handle_id", fbBusHandle.getId());
			String domainStr = objMapper.writeValueAsString(busDomainMap);
			inforMap.put("bus_domain", domainStr);
			runnableService.inforCall(inforMap);
		}
		return null;
	}

	/**
	 * 草稿详情查询
	 */
	@Override
	public Map<String, Object> draftDetail(Map<String, Object> appMap) throws Exception {
		// 先更新普通流程信息，在更新签报信息
		Map<String, Object> dMap = processService.draftDetail(appMap);
		// 查询签报人信息
		FbBusHandleExample handleExample = new FbBusHandleExample();
		com.zrt.mybatis.domain.FbBusHandleExample.Criteria handleCriteria = handleExample.createCriteria();
		handleCriteria.andInstIdEqualTo((String) appMap.get("inst_id"));
		List<FbBusHandle> handleList = fbBusHandleMapper.selectByExample(handleExample);
		List<Map<String, Object>> hList = new ArrayList<Map<String, Object>>();
		for (FbBusHandle fbBusHandle : handleList) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("handle_emp_id", fbBusHandle.getHandleEmpId());
			map.put("handle_emp_name", fbBusHandle.getHandleEmpName());
			hList.add(map);
		}
		// 添加签报人信息
		dMap.put("handle_emp_list", hList);
		return dMap;
	}

	/**
	 * 流程信息
	 */
	@Override
	public Map<String, Object> instInfor(Map<String, Object> appMap) throws Exception {
		// 根据instId查询流程模版信息
		String instId = (String) appMap.get("inst_id");
		FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);
		FbBusTemplate fbBusTemplate = fbBusTemplateMapper.selectByPrimaryKey(fbBusInst.getFbId());
		String handleFlag = fbBusTemplate.getHandleFlag();
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("handle_flag", handleFlag);
		return resMap;
	}

	/**
	 * 是否已签报
	 */
	@Override
	public Map<String, Object> isHandle(Map<String, Object> appMap) throws Exception {

		Map<String, Object> resMap = new HashMap<String, Object>();

		String instId = (String) appMap.get("inst_id");
		String empId = (String) appMap.get("emp_id");
		FbBusCheckExample example = new FbBusCheckExample();
		example.createCriteria().andInstIdEqualTo(instId).andCheckEmpIdEqualTo(empId).andCheckStatusEqualTo("1");
		List<FbBusCheck> checkList = fbBusCheckMapper.selectByExample(example);
		if (null != checkList && !checkList.isEmpty()) {
			resMap.put("isHandle", "1");
		} else {
			resMap.put("isHandle", "0");
		}

		return resMap;
	}
}
