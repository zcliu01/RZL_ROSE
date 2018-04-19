package com.zrt.client.serial;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.client.AbstactHystrixClient;
import com.zrt.commons.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("HystrixSerialClient")
public class HystrixSerialClient extends AbstactHystrixClient implements ISerialClient {
    @Autowired
	private ISerialClient iSerialClient;
	
	private Logger logger = LoggerFactory.getLogger(ISerialClient.class);

	public Map<String, Object> fallback(Map requestJson,Throwable e) {
		logger.error("FAILED SERVICE CALL!"+e.getMessage(),e);
		String fallback = ("序列号服务调用失败!");
		return new ResultMap().failure().errmsg(fallback).map();
	}
	
	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> getSerialNumberFromDB(Map requestJson) {
		return iSerialClient.getSerialNumberFromDB(requestJson);
	}
	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> getSerialNumber(Map requestJson) {
		return iSerialClient.getSerialNumber(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> getUUID(Map requestJson) {
		// TODO Auto-generated method stub
		return iSerialClient.getUUID(requestJson);
	}


}
