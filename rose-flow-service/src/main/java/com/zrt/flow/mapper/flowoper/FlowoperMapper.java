package com.zrt.flow.mapper.flowoper;

import java.util.List;
import java.util.Map;

import com.zrt.flow.domain.InstInfoDomain;

public interface FlowoperMapper {

	//查询所有实例的流程
	List<InstInfoDomain> instList(Map<String, Object> map);
	List<InstInfoDomain> instCount(Map<String, Object> map);
	Map<String, Object> instListCount(Map<String, Object> map);

	
    //查询所有的委托流程
	List<Map<String, Object>> entedList(Map<String, Object> map);
	
	//查询所有预处理过的流程实例
	List<InstInfoDomain> preList(Map<String, Object> map);
}