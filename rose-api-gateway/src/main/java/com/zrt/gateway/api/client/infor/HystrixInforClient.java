package com.zrt.gateway.api.client.infor;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.gateway.api.AbstactHystrixClient;

@Service("HystrixInforClient")
public class HystrixInforClient extends AbstactHystrixClient implements IInforClient {

	@Autowired
	private IInforClient iInforClient;

	private Logger logger = LoggerFactory.getLogger(IInforClient.class);

	public Map<String, Object> fallback(Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		String fallback = ("请求失败(infor)");
		return new com.zrt.gateway.commons.context.ResultMap().failure().errmsg(e.getMessage()).map();
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforReceiveList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforReceiveList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforSendList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforSendList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> saveAndSendInfor(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.saveAndSendInfor(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> saveInfor(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.saveInfor(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> relayInfor(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.relayInfor(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> transmitInfor(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.transmitInfor(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> sendUpdateInfor(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.sendUpdateInfor(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> selectReceiver(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.selectReceiver(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> changeInforDeal(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.changeInforDeal(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> changeInforRead(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.changeInforRead(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforHidden(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforHidden(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforHiddenBatch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforHiddenBatch(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforCancelHiddenBatch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforCancelHiddenBatch(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> infordetail(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.infordetail(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforCount(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforCount(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> concernInfor(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.concernInfor(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforCareDetail(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforCareDetail(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> concernInforCancel(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.concernInforCancel(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> concernInforBatchCancel(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.concernInforBatchCancel(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> dicAdd(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.dicAdd(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> dicList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.dicList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforAllList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforAllList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforDraftList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforDraftList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforCareList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforCareList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforWillList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforWillList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforHasReadList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforHasReadList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforHasDealList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforHasDealList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforCancel(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforCancel(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforDraftDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforDraftDelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforDraftBatchDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforDraftBatchDelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforDraftSend(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforDraftSend(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforDrafBatchSend(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforDrafBatchSend(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> withInforList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.withInforList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> withInforDetails(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.withInforDetails(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforDetailsSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforDetailsSearch(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> withEmpList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.withEmpList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowAllList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.flowAllList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowNoReadList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.flowNoReadList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowReadList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.flowReadList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowDealList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.flowDealList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowCareList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.flowCareList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> changeFlowRead(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.changeFlowRead(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> changeFlowDeal(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.changeFlowDeal(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> careFlow(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.careFlow(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> careCancel(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.careCancel(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> hiddenFlow(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.hiddenFlow(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> documentAllList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.documentAllList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> documentNoReadList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.documentNoReadList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> documentReadList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.documentReadList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> documentDealList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.documentDealList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> documentCareList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.documentCareList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> changeDocumentRead(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.changeDocumentRead(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> changeDocumentDeal(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.changeDocumentDeal(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> careDocument(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.careDocument(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> documentCareCancel(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.documentCareCancel(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> hiddenDocument(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.hiddenDocument(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> publicityAllList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.publicityAllList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> publicityNoReadList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.publicityNoReadList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> publicityReadList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.publicityReadList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> publicityDealList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.publicityDealList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> publicityCareList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.publicityCareList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> changePublicityRead(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.changePublicityRead(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> changePublicityDeal(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.changePublicityDeal(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> carePublicity(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.carePublicity(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> publicityCareCancel(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.publicityCareCancel(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> hiddenPublicity(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.hiddenPublicity(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> questionnaireAllList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.questionnaireAllList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> questionnaireNoReadList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.questionnaireNoReadList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> questionnaireReadList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.questionnaireReadList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> questionnaireDealList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.questionnaireDealList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> questionnaireCareList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.questionnaireCareList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> changeQuestionnaireRead(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.changeQuestionnaireRead(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> changeQuestionnaireDeal(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.changeQuestionnaireDeal(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> careQuestionnaire(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.careQuestionnaire(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> questionnaireCareCancel(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.questionnaireCareCancel(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> hiddenQuestionnaire(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.hiddenQuestionnaire(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> scheduleAllList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.scheduleAllList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> scheduleNoReadList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.scheduleNoReadList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> scheduleReadList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.scheduleReadList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> scheduleDealList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.scheduleDealList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> scheduleCareList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.scheduleCareList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> changeScheduleRead(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.changeScheduleRead(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> changeScheduleDeal(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.changeScheduleDeal(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> careSchedule(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.careSchedule(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> scheduleCareCancel(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.scheduleCareCancel(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> hiddenSchedule(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.hiddenSchedule(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> careAllList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.careAllList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> careNoReadList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.careNoReadList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> careReadList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.careReadList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> careDealList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.careDealList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> changeCareRead(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.changeCareRead(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> changeCareDeal(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.changeCareDeal(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> careCareCancel(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.careCareCancel(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> hiddenCare(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.hiddenCare(requestMap);
	}

}
