package com.zrt.gateway.api.client.contacts;

public interface ContactsConstant {
	String HYSTRIX_TIMEOUT ="3000";
	
	String INSTANCE_NAME = "contacts12";

	/**机构树列表*/
	String CON_ORGALLLIST = "/v1.0/friend/orgAllList";
	/**待撤销部门列表*/
	String CON_PRECANCELORG_LIST = "/v1.0/friend/preCancelOrgList";
	/**机构组员*/
	String CON_ORGEMPLIST = "/v1.0/friend/orgEmpList";
	/**导出组织通讯录员工***/
	String CON_ORGEMP_EXPORT="/v1.0/friend/exportEmpToExcel";
	/**打印组织通讯录员工***/
	String CON_ORGEMP_PRINT="/v1.0/friend/orgEmpPrint";
	/**添加常用联系人*/
	String CON_FRIEND_SAVE = "/v1.0/friend/friendSave";
	/**删除常用联系人*/
	String CON_FRIEND_DEL = "/v1.0/friend/friendDelete";
	/**常用联系人列表***/
	String CON_FRIEND_LIST="/v1.0/friend/empList";
	/**导出常用联系人***/
	String CON_FRIEND_EXPORT="/v1.0/friend/exportFriendToExcel";
	/**打印常用联系人***/
	String CON_FRIEND_PRINT="/v1.0/friend/friendPrint";
	/**查找联系人***/
	String CON_FRIEND_SEARCH="/v1.0/friend/friendSearch";
	/**查找员工部门和职称***/
	String CON_EMPORGPOSITION="/v1.0/friend/getOrgPosition";
	/**获取员工履历信息***/
	String CON_EMPWORKREDEPLOY="/v1.0/friend/getWorkRedeploy";
	/**获取员工姓名和部门信息***/
	String CON_EMP_DETAILS="/v1.0/friend/getEmpName";
	/**获取员工个人详情(基本信息+职位信息+履历信息)***/
	String CON_EMP_ALLDETAILS="/v1.0/friend/selectEmpDetails";
	/**修改个人详情***/
	String CON_EMPDETAILS_UPDATE="/v1.0/friend/updateEmpDetails";
	/**导出个人详情(基本信息+职位信息+履历信息)***/
	String CON_EMPDETAILS_EXPORT="/v1.0/friend/exportEmpDetailsToExcel";
	/**打印个人详情(基本信息+职位信息+履历信息)***/
	String CON_EMPDETAILS_PRINT="/v1.0/friend/empDetailsPrint";
	
	/**群组查找**/
	String CON_GROUP_SEARCH="/v1.0/friendGroup/friendGroupTree";
	/**群组创建**/
	String CON_GROUP_SAVE="/v1.0/friendGroup/friendGroupSave";
	/**更新群组**/
	String CON_GROUP_UPDATE="/v1.0/friendGroup/friendGroupUpdate";
	/**群组详情**/
	String CON_GROUP_DETAILS="/v1.0/friendGroup/friendGroupDetails";
	/**群组解散或退出**/
	String CON_GROUP_QUIT="/v1.0/friendGroup/groupDismissOrQuit";
	
	
	/**群组成员列表*/
	String CON_GROUP_MEMBER_LIST="/v1.0/groupMember/groupMemList";
	/**删除群组成员*/
	String CON_GROUP_MEMBER_DEL="/v1.0/groupMember/groupMemberDelete";
	/**添加群组成员*/
	String CON_GROUP_MEMBER_SAVE="/v1.0/groupMember/groupMemberSave";
	/**导出群组成员*/
	String CON_GROUP_MEMBER_EXPORT="/v1.0/groupMember/exportGroupMemToExcel";
	/**联系人检索*/
	String CON_EMP_SEARCH="/v1.0/empSearchWindow/commonEmpSearch";
	/**联系人树形图*/
	String CON_EMP_TREE="/v1.0/empSearchWindow/moreMateSearchTree";
	/**根据部门查询员工*/
	String SELECTBY_ORG="/v1.0/empSearchWindow/selectByOrg";
	
	
	/**
	 * 项目列表
	 */
		String 	PROJECT_LIST = "/v1.0/project/list";
		
		
	/**
	 * 查找所有员工的id
	 *	
	 */
	String	SEARCHALL = "/v1.0/friend/searchAll";
	/**
	 * 发送im
	 *	
	 */
	String SEND = "/v1.0/im/send";
}
