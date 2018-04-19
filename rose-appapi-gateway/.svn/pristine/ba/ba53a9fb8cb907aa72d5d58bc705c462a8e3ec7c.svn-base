package com.zrt.gateway.api.client.infopub;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.gateway.api.AbstactHystrixClient;
import com.zrt.gateway.api.ExceptionDeal;

@Service("HystrixInfoPubClient")
public class HystrixInfoPubClient extends AbstactHystrixClient implements IInfoPubClient {

	@Autowired
	private IInfoPubClient infoPubClient;

	private Logger logger = LoggerFactory.getLogger(IInfoPubClient.class);

	public Map<String, Object> fallback(Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(InfoPubConstant.TASK_INSTANCE, requestJson, e);
	}
	
	public Map<String, Object> fallbackStr(String reqStr, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(InfoPubConstant.TASK_INSTANCE, null, e);
	}

	public Map<String, Object> fallbackStrMap(String reqStr,MultiValueMap<String, String> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(InfoPubConstant.TASK_INSTANCE, null, e);
	}
	
	public Map<String, Object> fallbackStrMap(String reqStr,Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(InfoPubConstant.TASK_INSTANCE, requestJson, e);
	}
	
	
	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> searchInfo(Map<String, Object> map) throws Exception {
		return infoPubClient.searchInfo(map);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> state_search(Map<String, Object> map) throws Exception {
		return infoPubClient.state_search(map);
	}

	@Override
	public Map<String, Object> appSearch(Map<String, Object> map) throws Exception {
		return infoPubClient.appSearch(map);
	}

}
