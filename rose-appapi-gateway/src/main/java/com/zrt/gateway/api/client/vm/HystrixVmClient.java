package com.zrt.gateway.api.client.vm;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.gateway.api.AbstactHystrixClient;
import com.zrt.gateway.api.ExceptionDeal;

@Service("HystrixVmClient")
public class HystrixVmClient extends AbstactHystrixClient implements IVmClient {

	@Autowired
	private IVmClient vmClient;

	private Logger logger = LoggerFactory.getLogger(IVmClient.class);

	public Map<String, Object> fallback(Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(VmConstant.VM_INSTANCE, requestJson, e);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> ongoingMeetingList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return vmClient.ongoingMeetingList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> joinMeeting(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return vmClient.joinMeeting(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> historicalMeetingList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return vmClient.historicalMeetingList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> myMeetingList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return vmClient.myMeetingList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> openMeeting(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return vmClient.openMeeting(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> cancelMeeting(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return vmClient.cancelMeeting(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> saveMeeting(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return vmClient.saveMeeting(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> updateMeeting(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return vmClient.updateMeeting(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> launch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return vmClient.launch(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> inMeeting(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return vmClient.inMeeting(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> addPerson(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return vmClient.addPerson(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> isJoin(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return vmClient.isJoin(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> quit(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return vmClient.quit(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> isEnd(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return vmClient.isEnd(requestMap);
	}

}
