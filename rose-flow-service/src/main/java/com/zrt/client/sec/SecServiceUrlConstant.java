package com.zrt.client.sec;

public interface SecServiceUrlConstant {
	String HYSTRIX_TIMEOUT ="3000";
	
	String SEC_INSTANCE = "sec";

	/**
	 * 员工所在机构的的主分管领导
	 */
	String SEC_UP_MANAGE_SEARCH = "/v1.0/sec/upManageSearch";
	
	/***
	 * 查询员工的主分管领导
	 */
	String SEC_MANAGE_SEARCH = "/v1.0/sec/relationSearch";
	
}
