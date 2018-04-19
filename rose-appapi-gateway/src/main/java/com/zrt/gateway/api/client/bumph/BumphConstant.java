package com.zrt.gateway.api.client.bumph;

public interface BumphConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String BUMPH_INSTANCE = "bumph";

	/** 公文查询--筛选 */
	String DOCUMENTSEARCH = "/v1.0/APPdocPro/documentSearch";
	/** 公文办理--筛选 */
	String DETAILSEARCH = "/v1.0/APPdocPro/detailSearch";
	/** 公文管理--筛选 */
	String REGIS = "/v1.0/APPdocPro/regis";
	/** 公文详情 */
	String DETAILVIEW = "/v1.0/APPdocPro/detailView";
	/** 公文审核详情 */
	String AUDITVIEW = "/v1.0/APPdocPro/auditView";
	/** 公文审核办理 */
	String AUDITATTEND = "/v1.0/APPdocPro/auditAttend";
	/** 管理审核人 */
	String EXECUTE = "/v1.0/APPdocPro/execute";
	/** 公文撤销 */
	String DELETE = "/v1.0/APPdocPro/delete";
	/** 添加审核人 */
	String ADDEXECUTES = "/v1.0/APPdocPro/addExecutes";
	

}
