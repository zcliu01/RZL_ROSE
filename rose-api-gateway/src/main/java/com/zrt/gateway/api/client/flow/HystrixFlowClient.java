package com.zrt.gateway.api.client.flow;

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

@Service("HystrixFlowClient")
public class HystrixFlowClient extends AbstactHystrixClient implements IFlowClient {

	@Autowired
	private IFlowClient flowClient;

	private Logger logger = LoggerFactory.getLogger(IFlowClient.class);

	public Map<String, Object> fallback(Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(FlowConstant.FLOW_INSTANCE, requestJson, e);
	}

	public Map<String, Object> fallbackStr(String reqStr, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(FlowConstant.FLOW_INSTANCE, null, e);
	}

	public Map<String, Object> fallbackStrMap(String reqStr, MultiValueMap<String, String> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(FlowConstant.FLOW_INSTANCE, null, e);
	}

	public Map<String, Object> fallbackStrMap(String reqStr, Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(FlowConstant.FLOW_INSTANCE, requestJson, e);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> list(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.list(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> save(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.save(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> search(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.search(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> update(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.update(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> delete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.delete(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> formList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.formList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> formSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.formSave(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> formSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.formSearch(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> formUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.formUpdate(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> formDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.formDelete(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> openform(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.openform(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> closeform(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.closeform(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> formdeail(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.formdeail(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> formFormsave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.formFormsave(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> fbtypeList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.fbtypeList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> fbtypeSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.fbtypeSave(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> fbtypeSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.fbtypeSearch(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> fbtypeUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.fbtypeUpdate(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> fbtypeDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.fbtypeDelete(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> fbtempList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.fbtempList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> fbtempSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.fbtempSave(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> fbtempSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.fbtempSearch(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> fbtempUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.fbtempUpdate(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> fbtempDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.fbtempDelete(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> openfbtemp(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.openfbtemp(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> closefbtemp(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.closefbtemp(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> fbtempFormList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.fbtempFormList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> fbtempFormsave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.fbtempFormsave(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> runList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.runList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> runFlowDetail(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.runFlowDetail(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> stopList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.stopList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> stopFlowDetail(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.stopFlowDetail(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> checkList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.checkList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> entedList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.entedList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> entrustList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.entrustList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> ent(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.ent(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> cancel(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.cancel(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallbackStr", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> getEditorJson(String modelId) {
		// TODO Auto-generated method stub
		return flowClient.getEditorJson(modelId);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallbackStrMap", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> saveModel(String modelId, MultiValueMap<String, String> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.saveModel(modelId, requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> newModel(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.newModel(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> draftList(Map<String, Object> requestMap) {
		return flowClient.draftList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> notifyList(Map<String, Object> requestMap) {
		return flowClient.notifyList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> selfList(Map<String, Object> requestMap) {
		return flowClient.selfList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> preList(Map<String, Object> requestMap) {
		return flowClient.preList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> deal(Map<String, Object> requestMap) {
		return flowClient.deal(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> preCancel(Map<String, Object> requestMap) {
		return flowClient.preCancel(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> careList(Map<String, Object> requestMap) {
		return flowClient.careList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> applyCheckWithFile(Map<String, Object> requestMap) {
		return flowClient.applyCheckWithFile(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> careSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.careSave(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> joinSign(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.joinSign(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> joinSignCheck(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.joinSignCheck(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> applyCheck(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.applyCheck(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> applyCheckWithCon(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.applyCheckWithCon(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> returnCheck(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.returnCheck(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> signAdd(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.signAdd(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> actInfoList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.actInfoList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> instRead(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.instRead(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> draftSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.draftSave(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> send(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.send(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> deploy(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.deploy(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> apply(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.apply(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> applyList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.applyList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> flowList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.flowList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> entList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.entList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> operPreList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.operPreList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> selfApply(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.selfApply(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> selfDoList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.selfDoList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> selfHashDoList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.selfHashDoList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> selfSign(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.selfSign(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> check(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.check(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> fmDetail(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.fmDetail(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> draftDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.draftDelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> applyDetail(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.applyDetail(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> draftDetail(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.draftDetail(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> draftUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.draftUpdate(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> draftApply(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.draftApply(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> res(Map<String, Object> requestMap) {
		return flowClient.res(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> confirm(Map<String, Object> requestMap) {
		return flowClient.confirm(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> editSubmit(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.editSubmit(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> applyCheckCon(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.applyCheckCon(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> selfApplyRes(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.selfApplyRes(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowPreList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.flowPreList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> dicList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.dicList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> dicSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.dicSave(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> dicSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.dicSearch(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> dicUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.dicUpdate(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> dicDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.dicDelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> dicPmList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.dicPmList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> dicPmSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.dicPmSave(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> dicPmSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.dicPmSearch(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> dicPmUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.dicPmUpdate(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> dicPmDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.dicDelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> img(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.img(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> remind(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.remind(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> notify(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.notify(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> actNextList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.actNextList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> handleApply(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.handleApply(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> handleCheck(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.handleCheck(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> handDetail(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.handDetail(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> handleEnd(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.handleEnd(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> handleDraftSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.handleDraftSave(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> handleDraftUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.handleDraftUpdate(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> handleDraftApply(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.handleDraftApply(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> handleDraftDetail(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.handleDraftDetail(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> instInfor(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.instInfor(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> instCancel(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.instCancel(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> selfAboutList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.selfAboutList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> careCancle(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.careCancle(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> fbNotifyList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.fbNotifyList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> fbNotify(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.fbNotify(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> selfApplyConfirm(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.selfApplyConfirm(requestMap);
	}
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.flowDelete(requestMap);
	}
	
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> end(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.end(requestMap);
	}
	
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> isHandle(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return flowClient.isHandle(requestMap);
	}

}
