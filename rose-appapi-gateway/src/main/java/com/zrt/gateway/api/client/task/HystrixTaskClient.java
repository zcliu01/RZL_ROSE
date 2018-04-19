package com.zrt.gateway.api.client.task;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.gateway.api.AbstactHystrixClient;
import com.zrt.gateway.api.ExceptionDeal;

@Service("HystrixTaskClient")
public class HystrixTaskClient extends AbstactHystrixClient implements ITaskClient {

	@Autowired
	private ITaskClient taskClient;

	private Logger logger = LoggerFactory.getLogger(ITaskClient.class);

	public Map<String, Object> fallback(Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(TaskConstant.TASK_INSTANCE, requestJson, e);
	}
	
	public Map<String, Object> fallbackStr(String reqStr, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(TaskConstant.TASK_INSTANCE, null, e);
	}

	public Map<String, Object> fallbackStrMap(String reqStr,MultiValueMap<String, String> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(TaskConstant.TASK_INSTANCE, null, e);
	}
	
	public Map<String, Object> fallbackStrMap(String reqStr,Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(TaskConstant.TASK_INSTANCE, requestJson, e);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> add(Map<String, Object> map) throws Exception {
		return taskClient.add(map);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> searchInfo(Map<String, Object> map) throws Exception {
		return taskClient.searchInfo(map);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> stop(Map<String, Object> map) throws Exception {
		return taskClient.stop(map);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> callChild(Map<String, Object> map) throws Exception {
		return taskClient.callChild(map);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> backInfo(Map<String, Object> map) throws Exception {
		return taskClient.backInfo(map);
	}

	@Override
	public Map<String, Object> search(Map<String, Object> map) throws Exception {
		return taskClient.search(map);
	}

	@Override
	public Map<String, Object> todoSearch(Map<String, Object> map) throws Exception {
		return taskClient.todoSearch(map);
	}
}
