package com.zrt.gateway.api.client.bumph;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.gateway.api.AbstactHystrixClient;
import com.zrt.gateway.api.ExceptionDeal;

@Service("HystrixBumphClient")
public class HystrixBumphClient extends AbstactHystrixClient implements IBumphClient {

	@Autowired
	private IBumphClient bumphClient;

	private Logger logger = LoggerFactory.getLogger(IBumphClient.class);

	public Map<String, Object> fallback(Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(BumphConstant.BUMPH_INSTANCE, requestJson, e);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> delete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return bumphClient.delete(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> documentSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return bumphClient.documentSearch(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> detailSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return bumphClient.detailSearch(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> detailView(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return bumphClient.detailView(requestMap);
	}
	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> addExecutes(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return bumphClient.addExecutes(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> auditView(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return bumphClient.auditView(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> auditAttend(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return bumphClient.auditAttend(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> regis(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return bumphClient.regis(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> execute(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return bumphClient.execute(requestMap);
	}

	

	

}
