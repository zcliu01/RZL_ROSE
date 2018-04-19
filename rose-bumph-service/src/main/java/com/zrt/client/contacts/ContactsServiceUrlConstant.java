package com.zrt.client.contacts;

public interface ContactsServiceUrlConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String CONTACTS_INSTANCE = "contacts";

	String COMMONEMP_SEARCH = "/v1.0/empSearchWindow/commonEmpSearch";

	/**获取员工个人详情(基本信息+职位信息+履历信息)***/
	String CON_EMP_ALLDETAILS="/v1.0/friend/selectEmpDetails";
	/**测试*/
	String TEMP = "/v1.0/friend/temp";
}
