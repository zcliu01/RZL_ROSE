package com.zrt.client.contacts;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.client.AbstactHystrixClient;
import com.zrt.commons.ResultMap;

@Service("HystrixContactsClient")
public class HystrixContactsClient extends AbstactHystrixClient implements IContactsClient {
	@Autowired
	private IContactsClient iContactsClient;

	private Logger logger = LoggerFactory.getLogger(IContactsClient.class);

	public Map<String, Object> fallback(Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		String fallback = ("请求失败(contacts)");
		return new ResultMap().failure().errmsg(fallback).map();
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> orgAllList(Map requestJson) {
		return iContactsClient.orgAllList(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> ypEmpList(Map requestJson) {
		return iContactsClient.ypEmpList(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> searchAll(Map requestJson) {
		return iContactsClient.searchAll(requestJson);
	}

}
