package com.zrt.sec.service.role;

import java.util.List;
import java.util.Map;

import com.zrt.mybatis.domain.SysSecRole;


public interface RoleService {
	//用户角色新增
	 void roleSave(Map<String, Object> appMap) throws Exception;
	//用户角色列表查询
    List<SysSecRole> roleList(Map<String, Object> appMap) throws Exception;
    //用户角色信息查询
    Map<String, Object> roleSearch(Map<String, Object> appMap) throws Exception;
    //用户角色更新
  void  roleUpdate(Map<String, Object> appMap) throws Exception;
  //用户角色删除
    int roleDelete(Map<String, Object> appMap) throws Exception;
    //角色绑定功能类别查询
    List<Map<String, Object>> roleResourceSearch(Map<String, Object> appMap) throws Exception;
    //角色绑定资源功能
    void roleResourceSet(Map<String, Object> appMap) throws Exception;
  //根据角色查询用户信息
    Map<String, Object> roleUserList(Map<String, Object> appMap) throws Exception;
    //角色用户删除
	int roleEmpDelete(Map<String, Object> appMap) throws Exception;
	//角色用户批量删除
	int roleEmpBatchDelete(Map<String, Object> appMap) throws Exception;
	//角色绑定员工
	Map<String, Object> roleEmpAdd(Map<String, Object> appMap) throws Exception; 
	//角色一级菜单查询
	Map<String, Object> roleMenuList(Map<String, Object> appMap) throws Exception; 
	
	//流程角色功能查询
	Map<String, Object> roleFlowList(Map<String, Object> appMap) throws Exception; 
	//流程角色绑定
	Map<String, Object> roleFlowSet(Map<String, Object> appMap) throws Exception; 


}
