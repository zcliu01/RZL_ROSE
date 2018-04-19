package com.zrt.gateway.api.client.question;

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
import org.springframework.web.bind.annotation.RequestBody;

@Service("HystrixQuestionClient")
public class HystrixQuestionClient extends AbstactHystrixClient implements IQuestionClient {

	@Autowired
	private IQuestionClient QuestionClient;
	private final String serverName = QuestionConstant.QUESTION_INSTANCE;
	private final String HYSTRIX_TIMEOUT = QuestionConstant.HYSTRIX_TIMEOUT;//定义超时时长

	private Logger logger = LoggerFactory.getLogger (IQuestionClient.class);

	public Map<String, Object> fallback (Map<String, Object> requestJson, Throwable e) {
		logger.error ("FAILED SERVICE CALL!" + e.getMessage (), e);
		return ExceptionDeal.fallback (serverName, requestJson, e);
	}

	public Map<String, Object> fallbackStr (String reqStr, Throwable e) {
		logger.error ("FAILED SERVICE CALL!" + e.getMessage (), e);
		return ExceptionDeal.fallback (serverName, null, e);
	}

	public Map<String, Object> fallbackStrMap (String reqStr, MultiValueMap<String, String> requestJson, Throwable e) {
		logger.error ("FAILED SERVICE CALL!" + e.getMessage (), e);
		return ExceptionDeal.fallback (serverName, null, e);
	}

	public Map<String, Object> fallbackStrMap (String reqStr, Map<String, Object> requestJson, Throwable e) {
		logger.error ("FAILED SERVICE CALL!" + e.getMessage (), e);
		return ExceptionDeal.fallback (serverName, requestJson, e);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> save (Map<String, Object> map) throws Exception {
		return QuestionClient.save (map);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> search (@RequestBody Map<String, Object> map) throws Exception{
		return QuestionClient.search (map);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> paperSave (Map<String, Object> map) throws Exception {
		return QuestionClient.paperSave (map);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> paperSearch (@RequestBody Map<String, Object> map) throws Exception{
		return QuestionClient.paperSearch (map);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> delete (@RequestBody Map<String, Object> map) throws Exception{
		return QuestionClient.delete (map);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> paperDelete (@RequestBody Map<String, Object> map) throws Exception{
		return QuestionClient.paperDelete (map);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> paperCancel(@RequestBody Map<String, Object> map) throws Exception{
			return QuestionClient.paperCancel (map);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> paperPublish(@RequestBody Map<String, Object> map) throws Exception{
			return QuestionClient.paperPublish (map);
	}
}
