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
	public Map<String, Object> inforDeal(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforDeal(requestMap);
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
	public Map<String, Object> inforShowHid(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforShowHid(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforDetail(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforDetail(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inforCountFlag(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforCountFlag(requestMap);
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
	public Map<String, Object> concernInfor(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.concernInfor(requestMap);
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
	public Map<String, Object> inforCareDetail(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforCareDetail(requestMap);
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
	public Map<String, Object> inforDraftSend(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforDraftSend(requestMap);
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
	public Map<String, Object> inforEmpSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.inforEmpSearch(requestMap);
	}
	
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> sendUpdateInfor(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iInforClient.sendUpdateInfor(requestMap);
	}

}
