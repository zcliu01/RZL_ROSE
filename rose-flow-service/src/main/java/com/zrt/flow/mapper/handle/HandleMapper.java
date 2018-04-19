package com.zrt.flow.mapper.handle;

import java.util.List;
import java.util.Map;

import com.zrt.flow.domain.InstDomain;

public interface HandleMapper {
/**
 * 获取签报明细
 * @param map
 * @return
 */
	InstDomain getFlowDetail(Map<String, Object> map);
	
	/**
	 * 签报待办
	 */
	InstDomain doList(Map<String, Object> map);
	
	/**
	 * 该流程实例模版是否委托过
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> fbEntListByInst(Map<String, Object> map);
}