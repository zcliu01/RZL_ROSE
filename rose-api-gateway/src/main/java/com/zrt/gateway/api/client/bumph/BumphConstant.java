package com.zrt.gateway.api.client.bumph;

public interface BumphConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String BUMPH_INSTANCE = "bumph";

	//公文登记
	String REGIS = "/v1.0/docPro/regis";
	
	//待发布公文详情
	String DETAIL = "/v1.0/docPro/detail";
	
	//新建公文
	String ADD = "/v1.0/docPro/add";
	
	//待办公文
	String DETAILSEARCH = "/v1.0/docPro/detailSearch";
	
	//公文审核查看
	String AUDITVIEW = "/v1.0/docPro/auditView";

	//公文审核办理
	String AUDITATTEND = "/v1.0/docPro/auditAttend";
	
	//公文监控
	String MONITOR = "/v1.0/docPro/Monitor";
	
	//公文详情
	String DETAILVIEW = "/v1.0/ docPro/detailView";
	
	//公文修改
	String UPDATE = "/v1.0/docPro/update";
	
	//公文删除
	String DELETE = "/v1.0/docPro/delete";
	
	
	//公文类型维护
	String STATESAVE = "/v1.0/docPro/state_save";
	
	
	//公文类型查询
	String STATESEARCH = "/v1.0/docPro/state_search";
	
	//公文查询
	String DOCUMENTSEARCH = "/v1.0/docPro/documentSearch";
	
	
	//管理审核人
	String EXECUTE = "/v1.0/docPro/execute";
	
	
	//管理审核人
	String ADDEXECUTES = "/v1.0/docPro/addExecutes";
	
	
	//管理审核人
	String BACKOUT = "/v1.0/docPro/backout";
	
}
