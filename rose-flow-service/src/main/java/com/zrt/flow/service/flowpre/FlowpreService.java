package com.zrt.flow.service.flowpre;

import java.util.Map;

public interface FlowpreService {

	// 我的预处理列表
	Map<String, Object> getMyPreList(Map<String, Object> map) throws Exception;

	// App我的预处理列表
	Map<String, Object> getAppMyPreList(Map<String, Object> map) throws Exception;

	// 流程预处理同意/拒绝
	void deal(Map<String, Object> map) throws Exception;

	// 流程预处理取消
	void cancel(Map<String, Object> map) throws Exception;
	
	//流程代办预处理表
	Map<String, Object> instPreList(Map<String, Object> map) throws Exception;

}
