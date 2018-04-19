package com.zrt.flow.mapper.roleFlow;

import java.util.List;
import java.util.Map;

public interface RoleFlowMapper {

	//用户拥有的流程权限
	List<Map<String, Object>> roleFlowList(Map<String, Object> appMap);
	
	//用户拥有的流程权限
		List<Map<String, Object>> flowList(Map<String, Object> appMap);
}
