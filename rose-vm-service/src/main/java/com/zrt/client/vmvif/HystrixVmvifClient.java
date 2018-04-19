package com.zrt.client.vmvif;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.client.AbstactHystrixClient;
import com.zrt.commons.ResultMap;
import com.zrt.commons.date.DateUtil;

@Service("HystrixVmvifClient")
public class HystrixVmvifClient extends AbstactHystrixClient implements VmvifClient {
	private static final Logger log = LoggerFactory.getLogger(HystrixVmvifClient.class);
	@Autowired
	private VmvifClient vmvifClient;

	public Map<String, Object> fallback(Map requestJson, Throwable e) {
		log.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		String fallback = ("vif服务调用失败");
		return new ResultMap().failure().errmsg(fallback).map();
	}
	public Map<String, Object> fallback(Throwable e) {
		log.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		String fallback = ("vif服务调用失败");
		return new ResultMap().failure().errmsg(fallback).map();
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> createPublicRoom(Map<String, Object> requestJson) {
		return vmvifClient.createPublicRoom(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> deleteRoom(Map<String, Object> requestJson) {
		return vmvifClient.deleteRoom(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> audioSingleControl(Map<String, Object> requestJson) {
		return vmvifClient.audioSingleControl(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> muteAudioServerAll(Map<String, Object> requestJson) {
		return vmvifClient.muteAudioServerAll(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> videoSingleControl(Map<String, Object> requestJson) {
		return vmvifClient.videoSingleControl(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> muteVideoServerAll(Map<String, Object> requestJson) {
		return vmvifClient.muteVideoServerAll(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> leaveConference(Map<String, Object> requestJson) {
		return vmvifClient.leaveConference(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> createRoomPIN(Map<String, Object> requestJson) {
		return vmvifClient.createRoomPIN(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> removeRoomPIN(Map<String, Object> requestJson) {
		return vmvifClient.removeRoomPIN(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> lockRoomControl(Map<String, Object> requestJson) {
		return vmvifClient.lockRoomControl(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> disconnectConferenceAll(Map<String, Object> requestJson) {
		return vmvifClient.disconnectConferenceAll(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> recordControl(Map<String, Object> requestJson) {
		return vmvifClient.recordControl(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> recordsSearch(Map<String, Object> requestJson) {
		return vmvifClient.recordsSearch(requestJson);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> pushMsg(Map<String, Object> requestJson) {
		// TODO Auto-generated method stub
		return vmvifClient.pushMsg(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> linePerson(Map<String, Object> requestJson) {
		Map<String, Object> resMap = vmvifClient.linePerson(requestJson);

		return resMap;
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> getRooms() {
		Map<String, Object> resMap = vmvifClient.getRooms();

		return resMap;
	}

}
