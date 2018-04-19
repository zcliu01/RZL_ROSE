package com.zrt.client.vif;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.client.AbstactHystrixClient;
import com.zrt.commons.ResultMap;

@Service("HystrixvifClient")
public class HystrixvifClient extends AbstactHystrixClient  implements VifClient {
	private static final Logger log = LoggerFactory.getLogger(HystrixvifClient.class);
	@Autowired
	private VifClient vifClient;

	public Map<String, Object> fallback(Map<String, Object> requestJson,Throwable e) {
		log.error("FAILED SERVICE CALL!"+e.getMessage(),e);
		String fallback = ("vif服务调用失败");
		return new ResultMap().failure().errmsg(fallback).map();
	}
	


	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> ucdiskLogin(Map<String, Object> requestJson) {
		// TODO Auto-generated method stub
		return vifClient.ucdiskLogin(requestJson);
	}

}
