package com.zrt.sec.service.user;

import java.util.List;
import java.util.Map;

import com.zrt.mybatis.domain.SysSecUser;

public interface UserService {
	// 用户新增
	int userSave(Map<String, Object> appMap) throws Exception;

	// 用户列表查询
	List<SysSecUser> userList(Map<String, Object> appMap) throws Exception;

	// 用户信息查询
	Map<String, Object> userSearch(Map<String, Object> appMap) throws Exception;

	// 用户更新
	int userUpdate(Map<String, Object> appMap) throws Exception;

	// 用户角色列表查询
	List<Map<String, Object>> userRoleList(Map<String, Object> appMap) throws Exception;

	// 用户绑定角色
	int userRoleSave(Map<String, Object> appMap) throws Exception;

	// 用户密码重置
	int userPwdReSet(Map<String, Object> appMap) throws Exception;

	// 用户密码修改
	int userPwdSet(Map<String, Object> appMap) throws Exception;

	// 用户列表查询
	Map<String, Object> empList(Map<String, Object> appMap) throws Exception;

	// 修改用户状态
	int userStatusUpdate(Map<String, Object> appMap) throws Exception;

	// APP端修改个人详情
	void appUpdateEmpDetails(Map<String, Object> appMap) throws Exception;

	// App端获取发票抬头信息
	List<Map<String, Object>> appSelectInvoiceTitle(Map<String, Object> appMap) throws Exception;

	//App端获取电子名片信息
//	Map<String, Object> appSelectECard(Map<String, Object> appMap) throws Exception;

	// 设置用户是否同步
	int userSync(Map<String, Object> appMap) throws Exception;

	// 员工登录类型设置
	void loginTypeSet(Map<String, Object> appMap) throws Exception;

}
