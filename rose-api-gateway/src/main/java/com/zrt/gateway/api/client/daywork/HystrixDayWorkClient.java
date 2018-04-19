package com.zrt.gateway.api.client.daywork;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.gateway.api.AbstactHystrixClient;
import com.zrt.gateway.api.ExceptionDeal;

@Service("HystrixDayWorkClient")
public class HystrixDayWorkClient extends AbstactHystrixClient implements IDayWorkClient {

	@Autowired
	private IDayWorkClient dayWorkClient;

	private Logger logger = LoggerFactory.getLogger(IDayWorkClient.class);

	public Map<String, Object> fallback(Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(DayWorkConstant.DAYWORK_INSTANCE, requestJson, e);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> save(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return dayWorkClient.save(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> delete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return dayWorkClient.delete(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> update(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return dayWorkClient.update(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> detail(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return dayWorkClient.detail(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> list(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return dayWorkClient.list(requestMap);
	}
	
	
	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> checkAll(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return dayWorkClient.checkAll(requestMap);
	}

}
