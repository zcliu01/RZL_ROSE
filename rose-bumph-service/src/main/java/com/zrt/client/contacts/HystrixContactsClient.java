package com.zrt.client.contacts;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.client.AbstactHystrixClient;
import com.zrt.commons.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("HystrixContactsClient")
public class HystrixContactsClient extends AbstactHystrixClient implements IContactsClient {
    @Autowired
	private IContactsClient iContactsClient;
	
	private Logger logger = LoggerFactory.getLogger(IContactsClient.class);

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> commonEmpSearch(Map<String, Object> requestJson) {
		return iContactsClient.commonEmpSearch(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> temp(Map<String, Object> requestJson) {
		System.out.println("============================bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		return iContactsClient.temp(requestJson);
	}
	
	
	public Map<String, Object> fallback(Map<String, Object> requestJson,Throwable e) {
		logger.error("FAILED SERVICE CALL!"+e.getMessage(),e);
		String fallback = ("FAILED SERVICE CALL! - serial FALLING BACK");
		return new ResultMap().failure().errmsg(fallback).map();
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> selectEmpDetails(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return iContactsClient.selectEmpDetails(requestMap);
	}

}
