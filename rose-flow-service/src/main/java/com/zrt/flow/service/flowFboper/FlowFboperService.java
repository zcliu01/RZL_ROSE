package com.zrt.flow.service.flowFboper;

import java.util.Map;

public interface FlowFboperService {

	// 运行流程列表
	Map<String, Object> runList(Map<String, Object> map) throws Exception;
	// 运行流程列表
	Map<String, Object> applyList(Map<String, Object> map) throws Exception;

	// 运行流程明细查询
	Map<String, Object> runFlowDetail(Map<String, Object> map) throws Exception;

	// 停用流程列表
	Map<String, Object> stopList(Map<String, Object> map) throws Exception;

	// 停用流程明细查询
	Map<String, Object> stopFlowDetail(Map<String, Object> map) throws Exception;

}
