package com.zrt.gateway.api.client.daywork;

public interface DayWorkConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String DAYWORK_INSTANCE = "daywork";

	/** 新建日程 */
	String DAYWORK_SAVE = "/v1.0/daywork/save";
	/** 日程删除 */
	String DAYWORK_DELETE = "/v1.0/daywork/delete";
	/** 日程更新 */
	String DAYWORK_UPDATE = "/v1.0/daywork/update";
	/** 日程详情查询 */
	String DAYWORK_DETAIL = "/v1.0/daywork/detail";
	/** 日程列表查询 */
	String DAYWORK_LIST = "/v1.0/daywork/list";
	/** 全部日程 */
	String DAYWORK_CHECKALL = "/v1.0/daywork/checkAll";
	

}
