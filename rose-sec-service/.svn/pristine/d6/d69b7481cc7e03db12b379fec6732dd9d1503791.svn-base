package com.zrt.sec.mapper.role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
	// 用户角色列表查询
	List<Map<String, Object>> userRoleList(Map<String, Object> appMap) throws Exception;

	// 批量插入用户角色信息
	int userRoleSave(List list) throws Exception;

	// 查询角色绑定的角色资源
	List<Map<String, Object>> roleResourceList(Map<String, Object> appMap) throws Exception;

	// 查询角色绑定的角色菜单(只查菜单20171222修改)
	List<Map<String, Object>> roleMenuNewList(Map<String, Object> appMap) throws Exception;
	// 查询角色绑定的角色菜单下的按钮资源20180113
	List<Map<String, Object>> roleMenuRsList(Map<String, Object> appMap) throws Exception;

	// 批量插入角色资源信息
	int roleResourceSave(List list) throws Exception;

	// 批量插入角色菜单表（只插入菜单20171222修改）
	int roleMenuSave(List list) throws Exception;

	// 批量插入角色资源表20180113
	int roleRsSave(List list) throws Exception;

	// 根据角色id，查询资源所在的菜单
	List<Map<String, Object>> roleMenuList(Map<String, Object> appMap) throws Exception;

	// 用户角色列表查询
	List<Map<String, Object>> roleUserList(Map<String, Object> appMap) throws Exception;

	int deleteRoleResource(Map<String, Object> appMap) throws Exception;

	void deleteRoleMenu(Map<String, Object> appMap) throws Exception;

	void deleteRoleRs(Map<String, Object> appMap) throws Exception;
}
