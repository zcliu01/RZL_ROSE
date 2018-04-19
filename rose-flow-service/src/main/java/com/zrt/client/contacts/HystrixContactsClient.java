package com.zrt.client.contacts;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.client.AbstactHystrixClient;

@Service("HystrixContactsClient")
public class HystrixContactsClient extends AbstactHystrixClient implements IContactsClient {
    @Autowired
	private IContactsClient iContactsClient;
	
	private Logger logger = LoggerFactory.getLogger(IContactsClient.class);

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> commonEmpSearch(Map requestJson) {
		return iContactsClient.commonEmpSearch(requestJson);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> projectList(Map requestJson) {
		// TODO Auto-generated method stub
		return iContactsClient.projectList(requestJson);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	@Override
	public Map<String, Object> empOrgInfo(Map requestJson) {
		// TODO Auto-generated method stub
		return iContactsClient.empOrgInfo(requestJson);
	}

}
