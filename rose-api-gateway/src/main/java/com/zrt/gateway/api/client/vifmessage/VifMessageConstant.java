package com.zrt.gateway.api.client.vifmessage;

public interface VifMessageConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String VifMessage_INSTANCE = "vifmessage";

	
	/** 财务待办消息 **/
	String BACKLOG = "/v1.0/message/backlog";
	
	/**EAS待办消息**/
	String BACKLOGBYEAS = "/v1.0/message/backlogByEas";

}
