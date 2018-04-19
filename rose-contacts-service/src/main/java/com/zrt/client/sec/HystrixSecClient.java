package com.zrt.client.sec;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.client.AbstactHystrixClient;
import com.zrt.commons.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("HystrixSecClient")
public class HystrixSecClient extends AbstactHystrixClient implements ISecClient {
    @Autowired
	private ISecClient iSecClient;
	
	private Logger logger = LoggerFactory.getLogger(ISecClient.class);

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> orgAllList(Map<String, Object> requestJson) {
		return iSecClient.orgAllList(requestJson);
	}

	public Map<String, Object> fallback(Map<String, Object> requestJson,Throwable e) {
		logger.error("FAILED SEC CALL!"+e.getMessage(),e);
		String fallback = ("FAILED SEC CALL! - sec FALLING BACK");
		return new ResultMap().failure().errmsg(fallback).map();
	}


}
