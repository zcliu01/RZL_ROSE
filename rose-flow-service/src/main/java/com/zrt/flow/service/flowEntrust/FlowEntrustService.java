package com.zrt.flow.service.flowEntrust;

import java.util.Map;

public interface FlowEntrustService {

	// 委托流程列表
	Map<String, Object> getEntrustList(Map<String, Object> map) throws Exception;

	// 流程委托
	void ent(Map<String, Object> map) throws Exception;

	// 取消流程委托
	void cancel(Map<String, Object> map) throws Exception;

	// 我委托的和委托我的流程列表
	Map<String, Object> getList(Map<String, Object> map) throws Exception;

	// 委托流程列表
	Map<String, Object> getAppEntrustList(Map<String, Object> map) throws Exception;

	// 我委托的和委托我的流程列表
	Map<String, Object> getAppList(Map<String, Object> map) throws Exception;

}
