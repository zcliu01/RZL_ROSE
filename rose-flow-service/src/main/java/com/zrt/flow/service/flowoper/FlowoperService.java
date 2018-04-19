package com.zrt.flow.service.flowoper;

import java.util.Map;

/**
 * 
 * @author:wwfu
 * @date:2017年9月11日下午4:40:17
 * @description 管理员流程实例查询
 */
public interface FlowoperService {

	//所有的流程实例查询
	Map<String, Object> flowList(Map<String, Object> appMap) throws Exception;
	
	//所有的委托流程
	Map<String, Object> entrustList(Map<String, Object> appMap) throws Exception;
	
	//查询预处理过的流程实例
	Map<String, Object> preList(Map<String, Object> appMap) throws Exception;
}
