package com.zrt.flow.mapper.fbBusTemp;

import java.util.List;
import java.util.Map;

public interface FbBusTempCustomMapper {

	// 流程列表
	List<Map<String, Object>> getFbBusTempList(Map<String, Object> map);

	// 运行中（停用）流程列表
	List<Map<String, Object>> getRunList(Map<String, Object> map);
	// 运行中（停用）流程列表
	List<Map<String, Object>> applyList(Map<String, Object> map);

	// 运行中（停用）流程明细
	List<Map<String, Object>> getRunDetail(Map<String, Object> map);

}