package com.zrt.gateway.api.client.contacts;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.gateway.api.AbstactHystrixClient;

@Service("HystrixContactsClient")
public class HystrixContactsClient extends AbstactHystrixClient implements IContactsClient {

	@Autowired
	private IContactsClient secUserClient;

	private Logger logger = LoggerFactory.getLogger(IContactsClient.class);

	public Map<String, Object> fallback(Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		String fallback = ("请求失败(contacts)");
		return new com.zrt.gateway.commons.context.ResultMap().failure().errmsg(fallback).map();
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> contactsList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.contactsList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> empListByOrg(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.empListByOrg(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> selectEmpDetails(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.selectEmpDetails(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> selectEmpPositionDetails(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.selectEmpPositionDetails(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> selectEmpWorkRedeploy(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.selectEmpWorkRedeploy(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> commonEmpSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.commonEmpSearch(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> contactsImList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.contactsImList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> friendSavePage(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.friendSavePage(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> friendSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.friendSave(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> friendDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.friendDelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> friendList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.friendList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> friendGroupList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.friendGroupList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> friendGroupSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.friendGroupSave(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> selectGroupDetails(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.selectGroupDetails(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> friendGroupUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.friendGroupUpdate(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> groupDismissOrQuit(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.groupDismissOrQuit(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> groupMemberSavePage(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.groupMemberSavePage(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> groupMemberSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.groupMemberSave(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> selectGroupMemList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.selectGroupMemList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> groupMemDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.groupMemDelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> appUpdateEmpDetails(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.appUpdateEmpDetails(requestMap);
	}

}
