package com.zrt.gateway.api.client.sec;

public interface SecUserConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String SEC_INSTANCE = "sec12";

	/** 用户列表信息查询 */
	String SEC_USERLIST = "/v1.0/sec/userList";
	/** 用户信息查询 */
	String SEC_USERSEARCH = "/v1.0/sec/userSearch";
	/** 用户信息新增 */
	String SEC_USERSAVE = "/v1.0/sec/userSave";
	/** 用户信息更新 */
	String SEC_USERUPDATE = "/v1.0/sec/userUpdate";
	/** 用户信息删除 */
	String SEC_USERDELETE = "/v1.0/sec/userDelete";
	/** 用户角色列表查询 */
	String SEC_USERROLELIST = "/v1.0/sec/userRoleList";
	/** 用户角色绑定 */
	String SEC_USERROLESAVE = "/v1.0/sec/userRoleSave";
	/** 用户密码重置 */
	String SEC_USERPWDRESET = "/v1.0/sec/userPwdReSet";
	/** 用户密码设置 */
	String SEC_USERPWDSET = "/v1.0/sec/userPwdSet";
	/** 用户密码设置 */
	String LOGIN_TYPESET = "/v1.0/sec/loginTypeSet";
	/** 员工列表信息 */
	String SEC_EMPLIST = "/v1.0/sec/empList";
	/** 机构树列表 */
	String SEC_ORGALLLIST = "/v1.0/sec/orgAllList";
	/** 机构明细查询 */
	String SEC_ORG_SEARCH = "/v1.0/sec/orgSearch";
	/** 机构明细查询 */
	String SEC_ORG_UPDATE = "/v1.0/sec/orgUpdate";
	/** 机构名称模糊检索 */
	String SEC_ORGNAME_SEARCH = "/v1.0/sec/orgNameSearch";
	/** 机构列表 */
	String SEC_ORG_LIST = "/v1.0/sec/orgList";
	/** 机构列表 */
	String SEC_ORG_CANCEL_LIST = "/v1.0/sec/preCancelOrgList";
	/** 员工登录 **/
	String SEC_LOGIN = "/v1.0/sec/login";
	/** 员工登录 **/
	String TEST_LOGIN = "/v1.0/sec/testLogin";
	/** 员工登录 **/
	String NOVPN_LOGIN = "/v1.0/sec/noVpnLogin";
	/** 员工登录检查 ***/
	String SEC_LOGIN_CHECK = "/v1.0/sec/loginCheck";
	/** 角色列表信息查询 */
	String SEC_ROLELIST = "/v1.0/sec/roleList";
	/** 角色新增 */
	String SEC_ROLESAVE = "/v1.0/sec/roleSave";
	/** 角色列表信息查询 */
	String SEC_ROLEUPDATE = "/v1.0/sec/roleUpdate";
	/** 角色列表信息查询 */
	String SEC_ROLEDELETE = "/v1.0/sec/roleDelete";
	/** 角色列表信息查询 */
	String SEC_ROLEUSERLIST = "/v1.0/sec/roleUserList";
	/** 角色一级菜单查询 */
	String SEC_ROLEMENULIST = "/v1.0/sec/roleMenuList";
	/** 角色菜单功能查询 */
	String SEC_ROLEMENURESOURCELIST = "/v1.0/sec/roleResourceSearch";
	/** 角色资源绑定 */
	String SEC_ROLERESOURCELINK = "/v1.0/sec/roleResourceSet";

	/** 用户角色删除 */
	String SEC_ROLEEMPDELETE = "/v1.0/sec/roleEmpDelete";
	/** 用户角色批量删除 */
	String SEC_ROLEEMPBATCHDELETE = "/v1.0/sec/roleEmpBatchDelete";
	/** 用户状态 */
	String SEC_USERSTATUSUPDATE = "/v1.0/sec/userStatusUpdate";
	/** 用户角色所有查询 **/
	String SEC_ROLE_ALL_LIST = "/v1.0/sec/roleAllList";
	/** 用户角色批量新增 **/
	String SEC_USER_ROLE_BATCH_SAVE = "/v1.0/sec/userRoleBatchSave";
	/** 用户角色批量新增 **/
	String SEC_USER_PWD_BATCH_RESET = "/v1.0/sec/userPwdBatchReSet";
	/** 员工领导关系查询 **/
	String SEC_RELATION_SEARCH = "/v1.0/sec/relationSearch";
	/** 员工领导关系修改 **/
	String SEC_RELATION_UPDATE = "/v1.0/sec/relationUpdate";

	/** 角色新增用户 **/
	String SEC_ROLE_EMP_ADD = "/v1.0/sec/roleEmpAdd";

	/** 修改用户是否同步数据状态 **/
	String SEC_ROLE_EMP_SYNC = "/v1.0/sec/userSync";

	// 审批角色模块
	/** 用户角色所有查询 **/
	String CHECK_SEC_ROLE_ALL_LIST = "/v1.0/secCheck/roleAllList";
	/** 角色列表信息查询 */
	String CHECK_SEC_ROLELIST = "/v1.0/secCheck/roleList";
	/** 角色信息查询 */
	String CHECK_SEC_ROLESEARCH = "/v1.0/secCheck/roleSearch";
	/** 角色新增 */
	String CHECK_SEC_ROLESAVE = "/v1.0/secCheck/roleSave";
	/** 角色更新 */
	String CHECK_SEC_ROLEUPDATE = "/v1.0/secCheck/roleUpdate";
	/** 角色删除 */
	String CHECK_SEC_ROLEDELETE = "/v1.0/secCheck/roleDelete";
	/** 角色员工列表查询 */
	String CHECK_SEC_ROLEUSERLIST = "/v1.0/secCheck/roleUserList";
	/** 角色绑定用户 **/
	String CHECK_SEC_ROLE_EMP_ADD = "/v1.0/secCheck/roleEmpAdd";
	/** 角色用户删除 */
	String CHECK_SEC_ROLEEMPDELETE = "/v1.0/secCheck/roleEmpDelete";
	/** 角色用户批量删除 */
	String CHECK_SEC_ROLEEMPBATCHDELETE = "/v1.0/secCheck/roleEmpBatchDelete";

	// 流程角色模块
	/** 用户角色所有查询 **/
	String FLOW_SEC_ROLE_ALL_LIST = "/v1.0/secFlow/roleAllList";
	/** 角色列表信息查询 */
	String FLOW_SEC_ROLELIST = "/v1.0/secFlow/roleList";
	/** 角色信息查询 */
	String FLOW_SEC_ROLESEARCH = "/v1.0/secFlow/roleSearch";
	/** 角色新增 */
	String FLOW_SEC_ROLESAVE = "/v1.0/secFlow/roleSave";
	/** 角色更新 */
	String FLOW_SEC_ROLEUPDATE = "/v1.0/secFlow/roleUpdate";
	/** 角色删除 */
	String FLOW_SEC_ROLEDELETE = "/v1.0/secFlow/roleDelete";
	/** 角色员工列表查询 */
	String FLOW_SEC_ROLEUSERLIST = "/v1.0/secFlow/roleUserList";
	/** 角色绑定用户 **/
	String FLOW_SEC_ROLE_EMP_ADD = "/v1.0/secFlow/roleEmpAdd";
	/** 角色用户删除 */
	String FLOW_SEC_ROLEEMPDELETE = "/v1.0/secFlow/roleEmpDelete";
	/** 角色用户批量删除 */
	String FLOW_SEC_ROLEEMPBATCHDELETE = "/v1.0/secFlow/roleEmpBatchDelete";
	/** 角色流程绑定查询 */
	String FLOW_ROLE_FLOW_LIST = "/v1.0/secFlow/roleFlowList";
	/** 角色功能绑定 */
	String FLOW_ROLE_FLOW_SET = "/v1.0/secFlow/roleFlowSet";

	/** 新增员工 */
	String SEC_ADDUSER = "/v1.0/sec/addUser";

	/** 查询职务 */
	String SEC_SEARCHPOSITION = "/v1.0/sec/searchPosition";

	/** 新增部门 */
	String SEC_ADDORG = "/v1.0/sec/addOrg";

	/** 新增职务 */
	String SEC_ADDPOSITION = "/v1.0/sec/addPosition";

	/** 查询部门 */
	String SEC_SEARCHORG = "/v1.0/sec/searchOrg";

	/** 模糊查询部门 */
	String SEC_COMMONSEARCHORG = "/v1.0/sec/commonSearchOrg";

}
