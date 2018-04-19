package com.zrt.gateway.api.client.sec.user;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.gateway.api.AbstactHystrixClient;
import com.zrt.gateway.api.ExceptionDeal;

@Service("HystrixSecUserClient")
public class HystrixSecUserClient extends AbstactHystrixClient implements ISecUserClient {

	private Logger logger = LoggerFactory.getLogger(ISecUserClient.class);
	@Autowired
	private ISecUserClient secUserClient;
	
	public Map<String, Object> fallback(Map<String, Object> requestJson,Throwable e) {
		logger.error("FAILED SERVICE CALL!"+e.getMessage(),e);
		return ExceptionDeal.fallback(SecUserConstant.SEC_INSTANCE, requestJson, e);
	}


	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	@Override
	public Map<String, Object> appLogin(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.appLogin(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	@Override
	public Map<String, Object> appMyDetails(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.appMyDetails(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	@Override
	public Map<String, Object> appUpdateEmpDetails(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.appUpdateEmpDetails(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	@Override
	public Map<String, Object> appSelectInvoiceTitle(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.appSelectInvoiceTitle(requestMap);
	}

	
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	@Override
	public Map<String, Object> appLoginCheck(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.appLoginCheck(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	@Override
	public Map<String, Object> appUserUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.appUserUpdate(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	@Override
	public Map<String, Object> appUserPwdSet(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.appUserUpdate(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	@Override
	public Map<String, Object> appUserSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.appUserSearch(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	@Override
	public Map<String, Object> relationSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.relationSearch(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	@Override
	public Map<String, Object> relationUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.relationUpdate(requestMap);
	}


	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	@Override
	public Map<String, Object> pcLogin(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.pcLogin(requestMap);
	}

	
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	@Override
	public Map<String, Object> checkUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.checkUpdate(requestMap);
	}

}
