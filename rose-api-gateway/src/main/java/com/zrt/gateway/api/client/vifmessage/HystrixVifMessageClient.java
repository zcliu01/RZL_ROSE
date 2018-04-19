package com.zrt.gateway.api.client.vifmessage;

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

@Service("HystrixVifMessageClient")
public class HystrixVifMessageClient extends AbstactHystrixClient implements IVifMessageClient {

	@Autowired
	private IVifMessageClient vifMessageClient;

	private Logger logger = LoggerFactory.getLogger(IVifMessageClient.class);

	public Map<String, Object> fallback(Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(VifMessageConstant.VifMessage_INSTANCE, requestJson, e);
	}

	public Map<String, Object> fallbackStr(String reqStr, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(VifMessageConstant.VifMessage_INSTANCE, null, e);
	}

	public Map<String, Object> fallbackStrMap(String reqStr, MultiValueMap<String, String> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(VifMessageConstant.VifMessage_INSTANCE, null, e);
	}

	public Map<String, Object> fallbackStrMap(String reqStr, Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(VifMessageConstant.VifMessage_INSTANCE, requestJson, e);
	}

	

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> backlog(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return vifMessageClient.backlog(requestMap);
	}
	
	
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> backlogByEas(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return vifMessageClient.backlogByEas(requestMap);
	}

}
