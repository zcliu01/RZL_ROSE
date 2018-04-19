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
	private IContactsClient contactsClient;

	private Logger logger = LoggerFactory.getLogger(IContactsClient.class);

	public Map<String, Object> fallback(Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		String fallback = ("请求失败(contacts)");
		return new com.zrt.gateway.commons.context.ResultMap().failure().errmsg(fallback).map();
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> orgAllList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.orgAllList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> preCancelOrgList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.preCancelOrgList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> friendSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.friendSave(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> empList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.empList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> exportFriendToExcel(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.exportFriendToExcel(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> friendPrint(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.friendPrint(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> orgEmpList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.orgEmpList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> exportEmpToExcel(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.exportEmpToExcel(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> orgEmpPrint(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.orgEmpPrint(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> friendDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.friendDelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> friendSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.friendSearch(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> getOrgPosition(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.getOrgPosition(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> getWorkRedeploy(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.getWorkRedeploy(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> getEmpName(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.getEmpName(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> selectEmpDetails(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.selectEmpDetails(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> updateEmpDetails(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.updateEmpDetails(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> exportEmpDetailsToExcel(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.exportEmpDetailsToExcel(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> empDetailsPrint(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.empDetailsPrint(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> friendGroupTree(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.friendGroupTree(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> friendGroupSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.friendGroupSave(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> friendGroupDetails(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.friendGroupDetails(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> groupDismissOrQuit(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.groupDismissOrQuit(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> friendGroupUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.friendGroupUpdate(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> groupMemList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.groupMemList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> groupMemberSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.groupMemberSave(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> groupMemberDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.groupMemberDelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> exportGroupMemToExcel(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.exportGroupMemToExcel(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> commonEmpSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.commonEmpSearch(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> moreMateSearchTree(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.moreMateSearchTree(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> projectList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.projectList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> selectByOrg(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.selectByOrg(requestMap);
	}

	/**
	 * 查询所有远id
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> searchAll(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.searchAll(requestMap);
	}

	/**
	 * 发送im
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> send(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return contactsClient.send(requestMap);
	}
}
