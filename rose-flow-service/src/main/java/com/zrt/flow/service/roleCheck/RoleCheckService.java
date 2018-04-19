package com.zrt.flow.service.roleCheck;

import java.util.Map;

public interface RoleCheckService {

	// 角色新增
	void roleSave(Map<String, Object> appMap) throws Exception;

	// 角色更新
	void roleUpdate(Map<String, Object> appMap) throws Exception;

	// 角色删除
	void roleDelete(Map<String, Object> appMap) throws Exception;

	// 角色绑定员工
	void roleEmpAdd(Map<String, Object> appMap) throws Exception;

	// 角色用户批量删除
	void roleEmpBatchDelete(Map<String, Object> appMap) throws Exception;

	//流程角色功能查询
	Map<String, Object> roleFlowList(Map<String, Object> appMap) throws Exception; 
	//流程角色绑定
	Map<String, Object> roleFlowSet(Map<String, Object> appMap) throws Exception; 
}
