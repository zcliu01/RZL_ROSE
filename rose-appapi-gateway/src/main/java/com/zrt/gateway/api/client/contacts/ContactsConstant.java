package com.zrt.gateway.api.client.contacts;

public interface ContactsConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String SEC_INSTANCE = "contacts";

	/** 首页员工和部门列表 */
	String CON_CONTACTS_LIST = "/v1.0/empSearchApp/contactsList";
	/** 部门员工列表 */
	String CON_ORGEMP_LIST = "/v1.0/empSearchApp/empListByOrg";
	/** 员工详情 */
	String CON_EMP_DETAILS = "/v1.0/empSearchApp/selectEmpDetails";
	/** 修改个人详情 ***/
	String CON_EMPDETAILS_UPDATE = "/v1.0/friendApp/appUpdateEmpDetails";
	/** 职位详情 */
	String CON_EMP_POSITION_DETAILS = "/v1.0/empSearchApp/selectEmpPositionDetails";
	/** 员工履历信息 */
	String CON_EMP_WORK_DETAILS = "/v1.0/empSearchApp/selectEmpWorkRedeploy";
	/** 批量联系人检索 */
	String CON_EMP_SEARCH = "/v1.0/empSearchApp/commonEmpSearch";
	/** IM同步通讯录 */
	String CON_IM_SYNCHRONIZATION = "/v1.0/empSearchApp/contactsImList";

	/** 添加常用联系人页 */
	String CON_FRIEND_ADD_PAGE = "/v1.0/friendApp/friendSavePage";
	/** 添加常用联系人 */
	String CON_FRIEND_ADD = "/v1.0/friendApp/friendSave";
	/** 解除常用联系人 */
	String CON_FRIEND_DELETE = "/v1.0/friendApp/friendDelete";
	/** 常用联系人列表 */
	String CON_FRIEND_LIST = "/v1.0/friendApp/friendList";

	/** 群组列表 */
	String CON_FRIENDGROUP_LIST = "/v1.0/friendGroupApp/friendGroupList";
	/** 创建群组 */
	String CON_FRIENDGROUP_SAVE = "/v1.0/friendGroupApp/friendGroupSave";
	/** 群组详情 */
	String CON_FRIENDGROUPMEMBER_DETAILS = "/v1.0/friendGroupApp/selectGroupDetails";
	/** 修改群组信息 */
	String CON_FRIENDGROUP_UPDATE = "/v1.0/friendGroupApp/friendGroupUpdate";
	/** 退出或解散群组 */
	String CON_FRIENDGROUP_QUITORDISMISS = "/v1.0/friendGroupApp/groupDismissOrQuit";
	/** 添加群组成员页 初始化 */
	String CON_FRIENDGROUPMEMBER_ADD_PAGE = "/v1.0/friendGroupApp/groupMemberSavePage";
	/** 添加群组成员 */
	String CON_FRIENDGROUPMEMBER_ADD = "/v1.0/friendGroupApp/groupMemberSave";

	/** 群组成员列表 */
	String CON_FRIENDGROUPMEMBER_LIST = "/v1.0/friendGroupApp/selectGroupMemList";
	/** 删除群组成员 */
	String CON_FRIENDGROUPMEMBER_DEL = "/v1.0/friendGroupApp/groupMemDelete";

}
