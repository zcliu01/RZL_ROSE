package com.zrt.gateway.api.client.infor;

public interface InforConstant {
	String HYSTRIX_TIMEOUT ="3000";
	
	String SEC_INSTANCE = "infor";

	/**收件讯息列表*/
	String INFOR_RECEIVE_LIST = "/v1.0/appInforInner/inforList";
	/** 已办、已阅讯息 */
	String INFOR_DEAL = "/v1.0/appInforInner/inforDeal";	
	/** 讯息隐藏、显示 */
	String INFOR_SHOWHID = "/v1.0/appInforInner/inforShowHid";
	/** 普通讯息详情 */
	String INFOR_DETAIL = "/v1.0/appInforInner/inforDetail";
	/** 获取讯息待阅标识 */
	String INFOR_COUNTFLAG = "/v1.0/appInforInner/inforCountFlag";
	
	
	/** 关注讯息分类查询 */
	String DIC_LIST = "/v1.0/appInforInnerCare/dicList";
	/** 关注讯息分类新增 */
	String DIC_ADD = "/v1.0/appInforInnerCare/dicAdd";
	/** 添加关注讯息 */
	String CONCERN_INFOR = "/v1.0/appInforInnerCare/concernInfor";
	/** 取消关注讯息 */
	String CONCERNINFOR_CANCEL = "/v1.0/appInforInnerCare/concernInforCancel";
	/** 关注讯息详情 */ 
	String INFORCARE_DETAIL = "/v1.0/appInforInnerCare/inforCareDetail";
	
	/** 新建讯息 */
	String SAVE_AND_SENDINFOR = "/v1.0/appInforRecord/saveAndSendInfor";
	/** 保存至草稿 */
	String SAVE_INFOR = "/v1.0/appInforRecord/saveInfor";
	/** 回复讯息 */
	String RELAY_INFOR = "/v1.0/appInforRecord/relayInfor";
	/** 转发讯息 */
	String TRANSMIT_INFOR = "/v1.0/appInforRecord/transmitInfor";
	/** 修改个人资料发送讯息 */
	String SENDUPDATE_INFOR = "/v1.0/appInforRecord/sendUpdateInfor";
	
	/**草稿发送**/
	final String INFOR_DRAFT_SEND="/v1.0/appInforInner/inforDraftSend";
	/**草稿删除**/
	final String INFOR_DRAFT_DELETE="/v1.0/appInforInner/inforDraftDelete";
	
	/**
	 * 讯息监控模块
	 */
	/** 所有发送讯息列表*/
	String WITHINFOR_LIST = "/v1.0/appInforControl/withInforList";
	/** 监控详情*/
	String WITHINFOR_DETAILS = "/v1.0/appInforControl/withInforDetails";
	/** 监控详情搜索*/
	String INFORDETAILS_SEARCH = "/v1.0/appInforControl/inforDetailsSearch";
	/** 发送给某个员工所有信息列表*/
	String WITHEMP_LIST = "/v1.0/appInforControl/withEmpList";
	/** 发送给某个员工所有信息列表搜索*/
	String INFOREMP_SEARCH = "/v1.0/appInforControl/inforEmpSearch";
}
