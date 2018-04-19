package com.zrt.client.redis;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.client.AbstactHystrixClient;
import com.zrt.commons.ResultMap;

@Service("HystrixRedisClient")
public class HystrixRedisClient extends AbstactHystrixClient implements IRedisClient {
    @Autowired
	private IRedisClient iSerialClient;
	
	private Logger logger = LoggerFactory.getLogger(IRedisClient.class);

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> setInfo(Map requestJson) {
		return iSerialClient.setInfo(requestJson);
	}
	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> getInfo(Map requestJson) {
		return iSerialClient.getInfo(requestJson);
	}
	public Map<String, Object> fallback(Map requestJson,Throwable e) {
		logger.error("FAILED SERVICE CALL!"+e.getMessage(),e);
		String fallback = ("FAILED SERVICE CALL! - redis FALLING BACK");
		return new ResultMap().failure().errmsg(fallback).map();
	}


}
