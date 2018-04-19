package com.zrt.flow.service.flowself;

import java.util.Map;

/**
 * 
 * @author:wwfu
 * @date:2017年9月19日下午4:40:17
 * @description 个人流程查询
 */
public interface FlowselfService {

	// 我发起的所有的流程实例查询
	Map<String, Object> selfApply(Map<String, Object> appMap) throws Exception;

	// 我的待办
	Map<String, Object> selfDoList(Map<String, Object> appMap) throws Exception;

	// 会签审批
	Map<String, Object> selfSign(Map<String, Object> appMap) throws Exception;

	// 批量审批
	Map<String, Object> check(Map<String, Object> appMap) throws Exception;

	// 我的已办列表
	Map<String, Object> selfHasDoList(Map<String, Object> appMap) throws Exception;

	// 我的待回复列表
	Map<String, Object> selfApplyRes(Map<String, Object> appMap) throws Exception;

	// 我的待确认列表
	Map<String, Object> selfApplyConfirm(Map<String, Object> appMap) throws Exception;

}
