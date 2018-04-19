package com.zrt.client.contacts;

public interface ContactsServiceUrlConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String CONTACTS_INSTANCE = "contacts";

	String COMMONEMP_SEARCH = "/v1.0/empSearchWindow/commonEmpSearch";
/**
 * 项目列表
 */
	String 	PROJECT_LIST = "/v1.0/project/list";
	/**
	 * 员工机构列表
	 */
		String 	EMP_ORG_LIST = "/v1.0/empSearchWindow/empOrgInfo";
}
