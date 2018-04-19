package com.zrt.flow.service.listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zrt.flow.service.runnable.RunnableService;
import com.zrt.mybatis.domain.FbBusCare;
import com.zrt.mybatis.domain.FbBusCareExample;
import com.zrt.mybatis.domain.FbBusInst;
import com.zrt.mybatis.mapper.FbBusCareMapper;
import com.zrt.mybatis.mapper.FbBusInstMapper;

/**
 * 执行监听器
 * 
 * @author wwfu
 *
 */
@Service
public class ExecutionListenerService {

	@Autowired
	private FbBusCareMapper fbBusCareMapper;
	@Autowired
	private FbBusInstMapper fbBusInstMapper;
	@Autowired
	private RunnableService runnableService;
	@Value("${im.notify.sender_id}")
	private String systemEmpId;

	/**
	 * 线条监听器
	 * 
	 * @param execution
	 */
	public void takeExecution(DelegateExecution execution) {
		// 获取实例变量
		Map<String, Object> varParamsMap = execution.getVariables();
		String nextAss = (String) varParamsMap.get("next_tag_assignee");// 下一节点审批人参数
		List<String> next_tag_assignee_list = new ArrayList<String>();
		if (nextAss == null || "".equals(nextAss)) {
			execution.setVariable("next_tag_assignee_list", next_tag_assignee_list);
			return;
		}
		// 多人是;分号分割
		if (nextAss.endsWith(";")) {
			// 如果是以；分号结尾，那么就截取掉最后一位
			nextAss = nextAss.substring(0, nextAss.length() - 1);
		}
		String[] asses = nextAss.split(";");
		next_tag_assignee_list = Arrays.asList(asses);
		Map<String, Object> proMap = new HashMap<String, Object>();
		proMap.put("next_assignee_list", next_tag_assignee_list);
		execution.setVariable("next_tag_assignee_list", next_tag_assignee_list);
		return;
	}

	/**
	 * 线条监听器--节点取消关注
	 * 
	 * @param execution
	 * @throws JsonProcessingException
	 */
	public void takeCareCancelExecution(DelegateExecution execution) throws JsonProcessingException {

		// 获取流程定义
		// ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity)
		// ((RepositoryServiceImpl) repositoryService)
		// .getDeployedProcessDefinition(execution.getProcessDefinitionId());
		// // 获取线条节点
		// ActivityImpl activityImpl = ((ProcessDefinitionImpl)
		// processDefinition)
		// .findActivity(execution.getCurrentActivityId());

		// 线条节点流入的节点
		// List<PvmTransition> pvmTransitionList =
		// activityImpl.getIncomingTransitions();
		// 获取流程实例id
		String instId = execution.getBusinessKey();
		if(StringUtils.isNotBlank(instId)){
			FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);
			// for (PvmTransition pvmTransition : pvmTransitionList) {
			// PvmActivity pvmAct = pvmTransition.getSource();// 线条的前一节点
			// String tagId = pvmAct.getId();
			FbBusCareExample example = new FbBusCareExample();
			example.createCriteria().andInstTagEqualTo(execution.getCurrentActivityId()).andInstIdEqualTo(instId);
			List<FbBusCare> careList = fbBusCareMapper.selectByExample(example);
			if (!careList.isEmpty() && null != careList) {
				// 流程关注节点通过通知
				for (FbBusCare fbCare : careList) {
					Map<String, Object> inforMap = new HashMap<String, Object>();
					inforMap.put("title", "关注流程办理通知");
					inforMap.put("content", "您关注的标题为《" + fbBusInst.getFbTitle() + "》的流程【"
							+ execution.getCurrentActivityName() + "】节点已审批通过!");
					inforMap.put("sender", systemEmpId);
					inforMap.put("receiver", fbCare.getEmpId());
					inforMap.put("category", "flowInfor");// 类别(内部讯息(innerInfor)
					inforMap.put("bus_type", "FB12");// 流程关注节点通过通知
					inforMap.put("bus_id", instId);// 实例id
					Map<String, Object> busDomainMap = new HashMap<String, Object>();
					ObjectMapper objMapper = new ObjectMapper();
					busDomainMap.put("inst_id", instId);// 流程实例id
					busDomainMap.put("bus_type", "FB12");// 待办类型

					String domainStr = objMapper.writeValueAsString(busDomainMap);
					inforMap.put("bus_domain", domainStr);
					runnableService.inforCall(inforMap);
				}

			}
			fbBusCareMapper.deleteByExample(example);
		}
		

		// }

		return;

	}

}
