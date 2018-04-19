package com.zrt.gateway.api.client.infoPub;

public interface InfoPubConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String TASK_INSTANCE = "infoPub";
	
	//新增信息公示
	String SAVE = "/v1.0/infoPub/save";
	//公示查询
	String SEARCH = "/v1.0/infoPub/search";
	//公示删除
	String DEL = "/v1.0/infoPub/del";
	//查看公示详情
	String SEARCHINFO = "/v1.0/infoPub/searchInfo";
	//公示类型查询
	String STATE_SEARCH = "/v1.0/infoPub/state_search";
	//公示类型维护
	String STATE_SAVE = "/v1.0/infoPub/state_save";
	//公示状态变更
	String UPDATEINFOTYPE = "/v1.0/infoPub/updateInfoType";
	//公示修改
	String UPDATEINFOPUB = "/v1.0/infoPub/updateInfopub";
	
}
