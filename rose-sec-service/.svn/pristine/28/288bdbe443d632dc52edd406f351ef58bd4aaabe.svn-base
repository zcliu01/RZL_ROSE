package com.zrt.client.flow;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.client.AbstactHystrixClient;
import com.zrt.client.ExceptionDeal;

@Service("HystrixFlowClient")
public class HystrixFlowClient extends AbstactHystrixClient implements IFlowClient {

	@Autowired
	private IFlowClient flowClient;

	private Logger logger = LoggerFactory.getLogger(IFlowClient.class);

	public Map<String, Object> fallback(Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(FlowConstant.FLOW_INSTANCE, requestJson, e);
	}


	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> roleSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.roleSave(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> roleUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.roleUpdate(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> roleDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.roleDelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> roleEmpAdd(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.roleEmpAdd(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> roleEmpDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.roleEmpDelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> roleFlowList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.roleFlowList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> roleFlowSet(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.roleFlowSet(requestMap);
	}


}
