package com.zrt.client.infor;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.client.AbstactHystrixClient;
import com.zrt.commons.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("HystrixInforClient")
public class HystrixInforClient extends AbstactHystrixClient implements IInforClient {
    @Autowired
	private IInforClient iInforClient;
	
	private Logger logger = LoggerFactory.getLogger(IInforClient.class);

	
	public Map<String, Object> fallback(Map<String, Object> requestJson,Throwable e) {
		logger.error("FAILED SERVICE CALL!"+e.getMessage(),e);
		String fallback = ("请求失败(infor)");
		return new ResultMap().failure().errmsg(fallback).map();
	}
	
	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> sendUpdateInfor(Map requestJson) {
		return iInforClient.sendUpdateInfor(requestJson);
	}
	
	
	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> flowInforRead(Map requestJson) {
		return iInforClient.flowInforRead(requestJson);
	}

}
