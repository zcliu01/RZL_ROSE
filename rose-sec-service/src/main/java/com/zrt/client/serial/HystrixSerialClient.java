package com.zrt.client.serial;

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

@Service("HystrixSerialClient")
public class HystrixSerialClient extends AbstactHystrixClient implements ISerialClient {
    @Autowired
	private ISerialClient iSerialClient;
	
	private Logger logger = LoggerFactory.getLogger(ISerialClient.class);

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

	
	public Map<String, Object> fallback(Map requestJson,Throwable e) {
		logger.error("FAILED SERVICE CALL!"+e.getMessage(),e);
		String fallback = ("FAILED SERVICE CALL! - serial FALLING BACK");
		return new ResultMap().failure().errmsg(fallback).map();
	}


}
