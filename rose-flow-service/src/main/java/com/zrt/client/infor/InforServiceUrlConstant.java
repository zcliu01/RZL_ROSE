package com.zrt.client.infor;

public interface InforServiceUrlConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String INFOR_INSTANCE = "infor";

	/** 讯息推送 */
	String SENDUPDATE_INFOR = "/v1.0/inforrecord/sendUpdateInfor";
	/**讯息已阅**/
	String SEND_READ_INFOR = "/v1.0/flowInfor/flowInforRead";
}
