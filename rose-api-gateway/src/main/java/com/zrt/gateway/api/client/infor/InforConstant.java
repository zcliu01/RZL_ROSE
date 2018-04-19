package com.zrt.gateway.api.client.infor;

public interface InforConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String INSTANCE_NAME = "infor";

	/** 全部讯息 **/
	final String INFOR_LIST = "/v1.0/inforInner/inforList";
	/** 内部讯息 **/
	final String INFOR_INNER_LIST = "/v1.0/inforInner/inforAllList";
	/** 收件讯息列表 */
	String INFOR_RECEIVE_LIST = "/v1.0/inforInner/inforReceiveList";
	/** 发件讯息列表 */
	String INFOR_SEND_LIST = "/v1.0/inforInner/inforSendList";
	/** 草稿列表 **/
	final String INFOR_DRAFT_LIST = "/v1.0/inforInner/inforDraftList";
	/** 已关注 ***/
	final String INFOR_CARE_LIST = "/v1.0/inforInner/inforCareList";
	/** 待阅 **/
	final String INFOR_WILL_LIST = "/v1.0/inforInner/inforWillList";
	/** 已阅 **/
	final String INFOR_HASREAD_LIST = "/v1.0/inforInner/inforHasReadList";
	/** 已办 **/
	final String INFOR_HASDEAL_LIST = "/v1.0/inforInner/inforHasDealList";

	/** 新建讯息 */
	String SAVE_AND_SENDINFOR = "/v1.0/inforrecord/saveAndSendInfor";
	/** 保存至草稿 */
	String SAVE_INFOR = "/v1.0/inforrecord/saveInfor";
	/** 回复讯息 */
	String RELAY_INFOR = "/v1.0/inforrecord/relayInfor";
	/** 转发讯息 */
	String TRANSMIT_INFOR = "/v1.0/inforrecord/transmitInfor";
	/** 推送消息发送讯息 */
	String SENDUPDATE_INFOR = "/v1.0/inforrecord/sendUpdateInfor";
	/** 选择联系人 */
	String SELECT_RECEIVER = "/v1.0/inforrecord/selectReceiver";

	/** 讯息办结 */
	String CHANGEINFOR_DEAL = "/v1.0/inforCommons/changeInforDeal";
	/** 讯息已阅 */
	String CHANGEINFOR_READ = "/v1.0/inforCommons/changeInforRead";
	/** 讯息隐藏 */
	String INFOR_HIDDEN = "/v1.0/inforCommons/inforHidden";
	/** 批量隐藏讯息 */
	String INFOR_HIDDEN_BATCH = "/v1.0/inforCommons/inforHiddenBatch";
	/** 批量隐藏讯息 */
	String INFOR_CANCELHIDDEN_BATCH = "/v1.0/inforCommons/inforCancelHiddenBatch";
	/** 讯息详情列表 */
	String INFOR_DETAIL = "/v1.0/inforCommons/inforDetail";
	/** 首页未阅数量 */
	String INFOR_COUNT = "/v1.0/inforCommons/inforCount";

	/** 添加关注讯息 */
	String CONCERN_INFOR = "/v1.0/inforCommons/concernInfor";
	/** 关注讯息详情 */
	String INFORCARE_DETAIL = "/v1.0/inforCommons/inforCareDetail";
	/** 取消关注讯息 */
	String CONCERNINFOR_CANCEL = "/v1.0/inforCommons/concernInforCancel";
	/** 批量取消关注讯息 */
	String CONCERNINFOR_BATCHCANCEL = "/v1.0/inforCommons/concernInforBatchCancel";
	/** 新增关注讯息分类 */
	String DIC_ADD = "/v1.0/inforCommons/dicAdd";
	/** 关注讯息分类查询 */
	String DIC_LIST = "/v1.0/inforCommons/dicList";
	/** 撤销讯息 */
	String INFOR_CANCEL = "/v1.0/inforCommons/inforCancel";

	/** 草稿删除 */
	String INFORDRAFT_DELETE = "/v1.0/inforInner/inforDraftDelete";
	/** 草稿删除 */
	String INFORDRAFT_BATCHDELETE = "/v1.0/inforInner/inforDraftBatchDelete";
	/** 草稿删除 */
	String INFOR_DRAFTSEND = "/v1.0/inforInner/inforDraftSend";
	/** 草稿删除 */
	String INFORDRAF_BATCHSEND = "/v1.0/inforInner/inforDrafBatchSend";

	/**
	 * 讯息监控模块
	 */
	/** 所有发送讯息列表 */
	String WITHINFOR_LIST = "/v1.0/inforControl/withInforList";
	/** 监控详情 */
	String WITHINFOR_DETAILS = "/v1.0/inforControl/withInforDetails";
	/** 监控详情搜索 */
	String INFORDETAILS_SEARCH = "/v1.0/inforControl/inforDetailsSearch";
	/** 发送给某个员工所有信息列表 */
	String WITHEMP_LIST = "/v1.0/inforControl/withEmpList";

	/**
	 * 第四次迭代 不同类别讯息管理模块
	 */
	/** 流程讯息全部列表 */
	String FLOW_ALLLIST = "/v1.0/flowInfor/flowAllList";
	/** 流程讯息待阅列表 */
	String FLOW_NOREADLIST = "/v1.0/flowInfor/flowNoReadList";
	/** 流程讯息已阅列表 */
	String FLOW_READLIST = "/v1.0/flowInfor/flowReadList";
	/** 流程讯息已办列表 */
	String FLOW_DEALLIST = "/v1.0/flowInfor/flowDealList";
	/** 流程讯息关注列表 */
	String FLOW_CARELIST = "/v1.0/flowInfor/flowCareList";
	/** 已阅 */
	String CHANGEFLOW_READ = "/v1.0/flowInfor/changeFlowRead";
	/** 已办 */
	String CHANGEFLOW_DEAL = "/v1.0/flowInfor/changeFlowDeal";
	/** 关注 */
	String CARE_FLOW = "/v1.0/flowInfor/careFlow";
	/** 取消关注 */
	String CARE_CANCEL = "/v1.0/flowInfor/careCancel";
	/** 隐藏 */
	String HIDDEN_FLOW = "/v1.0/flowInfor/hiddenFlow";
	
	
	/** 公文讯息全部列表 */
	String DOCUMENT_ALLLIST = "/v1.0/documentInfor/documentAllList";
	/** 公文讯息待阅列表 */
	String DOCUMENT_NOREADLIST = "/v1.0/documentInfor/documentNoReadList";
	/** 公文讯息已阅列表 */
	String DOCUMENT_READLIST = "/v1.0/documentInfor/documentReadList";
	/** 公文讯息已办列表 */
	String DOCUMENT_DEALLIST = "/v1.0/documentInfor/documentDealList";
	/** 公文讯息关注列表 */
	String DOCUMENT_CARELIST = "/v1.0/documentInfor/documentCareList";
	/** 已阅 */
	String CHANGEDOCUMENT_READ = "/v1.0/documentInfor/changeDocumentRead";
	/** 已办 */
	String CHANGE_DOCUMENTDEAL = "/v1.0/documentInfor/changeDocumentDeal";
	/** 关注 */
	String CARE_DOCUMENT = "/v1.0/documentInfor/careDocument";
	/** 取消关注 */
	String DOCUMENTCARE_CANCEL = "/v1.0/documentInfor/careCancel";
	/** 隐藏 */
	String HIDDEN_DOCUMENT = "/v1.0/documentInfor/hiddenDocument";
	
	
	/** 公示讯息全部列表 */
	String PUBLICITY_ALLLIST = "/v1.0/publicityInfor/publicityAllList";
	/** 公示讯息待阅列表 */
	String PUBLICITY_NOREADLIST = "/v1.0/publicityInfor/publicityNoReadList";
	/** 公示讯息已阅列表 */
	String PUBLICITY_READLIST = "/v1.0/publicityInfor/publicityReadList";
	/** 公示讯息已办列表 */
	String PUBLICITY_DEALLIST = "/v1.0/publicityInfor/publicityDealList";
	/** 公示讯息关注列表 */
	String PUBLICITY_CARELIST = "/v1.0/publicityInfor/publicityCareList";
	/** 已阅 */
	String CHANGEPUBLICITY_READ = "/v1.0/publicityInfor/changePublicityRead";
	/** 已办 */
	String CHANGEPUBLICITY_DEAL = "/v1.0/publicityInfor/changePublicityDeal";
	/** 关注 */
	String CARE_PUBLICITY = "/v1.0/publicityInfor/carePublicity";
	/** 取消关注 */
	String PUBLICITYCARE_CANCEL = "/v1.0/publicityInfor/careCancel";
	/** 隐藏 */
	String HIDDEN_PUBLICITY = "/v1.0/publicityInfor/hiddenPublicity";
	
	
	/** 问卷讯息全部列表 */
	String QUESTIONNAIRE_ALLLIST = "/v1.0/questionnaireInfor/questionnaireAllList";
	/** 问卷讯息待阅列表 */
	String QUESTIONNAIRE_NOREADLIST = "/v1.0/questionnaireInfor/questionnaireNoReadList";
	/** 问卷讯息已阅列表 */
	String QUESTIONNAI_REREADLIST = "/v1.0/questionnaireInfor/questionnaireReadList";
	/** 问卷讯息已办列表 */
	String QUESTIONNAIRE_DEALLIST = "/v1.0/questionnaireInfor/questionnaireDealList";
	/** 问卷讯息关注列表 */
	String QUESTIONNAIRE_CARELIST = "/v1.0/questionnaireInfor/questionnaireCareList";
	/** 已阅 */
	String CHANGEQUESTIONNAIRE_READ = "/v1.0/questionnaireInfor/changeQuestionnaireRead";
	/** 已办 */
	String CHANGEQUESTIONNAIRE_DEAL = "/v1.0/questionnaireInfor/changeQuestionnaireDeal";
	/** 关注 */
	String CARE_QUESTIONNAIRE = "/v1.0/questionnaireInfor/careQuestionnaire";
	/** 取消关注 */
	String QUESTIONNAIRECARE_CANCEL = "/v1.0/questionnaireInfor/careCancel";
	/** 隐藏 */
	String HIDDEN_QUESTIONNAIRE = "/v1.0/questionnaireInfor/hiddenQuestionnaire";
	
	
	/** 日程讯息全部列表 */
	String SCHEDULE_ALLLIST = "/v1.0/scheduleInfor/scheduleAllList";
	/** 日程讯息待阅列表 */
	String SCHEDULE_NOREADLIST = "/v1.0/scheduleInfor/scheduleNoReadList";
	/** 日程讯息已阅列表 */
	String SCHEDULE_READLIST = "/v1.0/scheduleInfor/scheduleReadList";
	/** 日程讯息已办列表 */
	String SCHEDULE_DEALLIST = "/v1.0/scheduleInfor/scheduleDealList";
	/** 日程讯息关注列表 */
	String SCHEDULE_CARELIST = "/v1.0/scheduleInfor/scheduleCareList";
	/** 已阅 */
	String CHANGESCHEDULE_READ = "/v1.0/scheduleInfor/changeScheduleRead";
	/** 已办 */
	String CHANGESCHEDULE_DEAL = "/v1.0/scheduleInfor/changeScheduleDeal";
	/** 关注 */
	String CARE_SCHEDULE = "/v1.0/scheduleInfor/careSchedule";
	/** 取消关注 */
	String SCHEDULECARE_CANCEL = "/v1.0/scheduleInfor/careCancel";
	/** 隐藏 */
	String HIDDEN_SCHEDULE = "/v1.0/scheduleInfor/hiddenSchedule";
	
	
	/** 我的关注全部列表 */
	String CARE_ALLLIST = "/v1.0/careInfor/careAllList";
	/** 我的关注讯息待阅列表 */
	String CARE_NOREADLIST = "/v1.0/careInfor/careNoReadList";
	/** 我的关注讯息已阅列表 */
	String CARE_READLIST = "/v1.0/careInfor/careReadList";
	/** 我的关注讯息已办列表 */
	String CARE_DEALLIST = "/v1.0/careInfor/careDealList";
	/** 已阅 */
	String CHANGECARE_READ = "/v1.0/careInfor/changeCareRead";
	/** 已办 */
	String CHANGECARE_DEAL = "/v1.0/careInfor/changeCareDeal";
	/** 取消关注 */
	String CARECARE_CANCEL = "/v1.0/careInfor/careCancel";
	/** 隐藏 */
	String HIDDEN_CARE = "/v1.0/careInfor/hiddenCare";

}
