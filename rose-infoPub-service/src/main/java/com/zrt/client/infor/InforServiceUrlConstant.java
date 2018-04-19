package com.zrt.client.infor;

public interface InforServiceUrlConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String INFOR_INSTANCE = "infor";

	/** 修改个人资料发送讯息 */
	String SENDUPDATE_INFOR = "/v1.0/appInforRecord/sendUpdateInfor";
	
	
	/** 修改信息状态 */
	String FLOWINFORREAD = "/v1.0/flowInfor/flowInforRead";

}
