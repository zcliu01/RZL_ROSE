package com.zrt.flow.mapper.flowself;

import java.util.List;
import java.util.Map;

import com.zrt.flow.domain.InstInfoDomain;

public interface FlowselfMapper {

	// 查询我发起的所有实例的流程
	List<InstInfoDomain> instList(Map<String, Object> map);

	Map<String, Object> instListCount(Map<String, Object> map);

	// 查询我的待办
	List<Map<String, Object>> selfDoList(Map<String, Object> map);

	// 查询所有已处理过的流程实例
	List<Map<String, Object>> preList(Map<String, Object> map);

	// 根据流程发起id，查询委托人信息
	List<Map<String, Object>> entedList(Map<String, Object> map);

	// 查询已办列表
	// List<InstInfoDomain> selfHasDoList(Map<String, Object> map);
	List<Map<String, Object>> selfHasDoList(Map<String, Object> map);

	// 查询已办列表
	List<Map<String, Object>> selfHasDoListByPage(Map<String, Object> map);

	// 查询我发起的所有待回复实例的流程
	List<InstInfoDomain> instResList(Map<String, Object> map);

	Map<String, Object> instResListCount(Map<String, Object> map);

	// 查询个人相关流程信息
	List<Map<String, Object>> selfAboutList(Map<String, Object> map);

	// 查询附条件待确认的流程
	List<Map<String, Object>> selfApplyConfirm(Map<String, Object> map);

}