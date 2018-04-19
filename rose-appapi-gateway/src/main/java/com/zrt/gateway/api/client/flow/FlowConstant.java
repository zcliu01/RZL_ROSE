package com.zrt.gateway.api.client.flow;

public interface FlowConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String FLOW_INSTANCE = "flow";

	/** 我委托的流程列表 */
	String CHECK_LIST = "/v1.0/appFlowent/list";
	/** 委托我的流程列表 */
	String ENTED_LIST = "/v1.0/appFlowent/entedList";
	/** 委托流程列表 */
	String ENTRUST_LIST = "/v1.0/appFlowentrust/list";
	/** 流程委托 */
	String ENT = "/v1.0/appFlowentrust/ent";
	/** 取消流程委托 */
	String CANCEL = "/v1.0/appFlowentrust/cancel";

	/** 流程待办预处理列表 **/
	String LIST = "/v1.0/appFlowpre/list";
	/** 我的预处理流程列表 **/
	String PRE_LIST = "/v1.0/appFlowpre/selfList";
	/** 流程预处理同意/拒绝 **/
	String DEAL = "/v1.0/appFlowpre/deal";
	/** 流程预处理取消 **/
	String PRE_CANCEL = "/v1.0/appFlowpre/cancel";
	/** 我的草稿列表 **/
	String DRAFT_LIST = "/v1.0/appFlowdraft/list";
	/** 草稿发送 **/
	String SEND = "/v1.0/appFlowdraft/send";
	/** 草稿删除 **/
	String DRAFT_DELETE = "/v1.0/appFlowdraft/draftDelete";
	/** 草稿详情 **/
	String DRAFT_DETAIL = "/v1.0/appFlowdraft/draftDetail";

	/** 知会我的 **/
	String NOTIFY_LIST = "/v1.0/appFlownotify/notifyList";
	/** 我知会的 **/
	String SELF_LIST = "/v1.0/appFlownotify/selfList";
	/** 知会 **/
	String NOTIFY = "/v1.0/appFlownotify/notify";

	/** 我的关注 **/
	String CARE_LIST = "/v1.0/appFlowself/careList";
	/** 添加关注 **/
	String CARE_SAVE = "/v1.0/appFlowself/careSave";
	/** 添加关注 **/
	String CARE_CANCLE = "/v1.0/appFlowself/careCancle";

	/** 流程审核（附条件同意） **/
	String APPLY_CHECK_WITH_FILE = "/v1.0/appFlow/appApplyCheckWithFile";

	/** 我发起的流程列表 **/
	String SELF_APPLY = "/v1.0/appFlowself/selfApply";
	/** 我发起的流程列表 **/
	String SELFAPPLY_RES = "/v1.0/appFlowself/selfApplyRes";
	/** 我的待办 **/
	String SELF_DOLIST = "/v1.0/appFlowself/selfDoList";
	/** 我的已办 **/
	String SELF_HASDOLIST = "/v1.0/appFlowself/selfHasDoList";
	/** 会签审批 **/
	String SELF_SIGN = "/v1.0/appFlowself/selfSign";
	/** 审批 **/
	String CHECK = "/v1.0/appFlowself/check";

	/** 会签加人 **/
	String JOIN_SIGN = "/v1.0/appFlow/joinSign";
	/** 会签审批 **/
	String JOINSIGN_CHECK = "/v1.0/appFlow/joinSignCheck";
	/** 流程普通审核同意/拒绝 **/
	String APPLY_CHECK = "/v1.0/appFlow/applyCheck";
	/** 附条件同意 **/
	String APPLYCHECK_WITHCON = "/v1.0/appFlow/applyCheckWithCon";
	/** 驳回至审批 **/
	String RETURN_CHECK = "/v1.0/appFlow/returnCheck";
	/** 加签审批 **/
	String SIGN_ADD = "/v1.0/appFlow/signAdd";
	/** 流程节点信息查询 **/
	String ACT_INFOLIST = "/v1.0/appFlow/actInfoList";
	/** 流程表单详情查询 **/
	String FM_DETAIL = "/v1.0/appFlow/fmDetail";
	/** 流程阅读 **/
	String INST_READ = "/v1.0/appFlow/instRead";
	/** 个人相关流程 **/
	String FLOW_SELF_ABOUT = "/v1.0/appFlow/selfAboutList";
	/** 撤销 **/
	String FLOW_CANCLE = "/v1.0/appFlow/instCancel";
	/** 审批详情 **/
	String INST = "/v1.0/appFlowDetail/inst";

	/** 附条件回复 **/
	String RES = "/v1.0/appCon/res";
	/** 附条件复核 **/
	String CONFIRM = "/v1.0/appCon/confirm";
	/** 附条件 **/
	String APPLYCHECK_CON = "/v1.0/appFlow/applyCheckCon";
	/** 催办 **/
	String FLOW_REMIND = "/v1.0/appFlow/remind";

	/** 2.9 下一审批节点信息 **/
	String ACT_NEXTLIST = "/v1.0/appFlow/actNextList";
	/** 2.10 流程信息 **/
	String INST_INFOR = "/v1.0/appHandle/instInfor";
	/** 2.11.1 签报审批 **/
	String HANDLE_CHECK = "/v1.0/appHandle/handleCheck";
	/** 2.11.2 签报审批详情 **/
	String DETAIL = "/v1.0/appHandle/detail";
	/** 2.11.3 签报办结 **/
	String HANDLE_END = "/v1.0/appHandle/handleEnd";
	/** 2.11.4.1 签报流程草稿详情 **/
	String DRAFTDETAIL = "/v1.0/appHandle/draftDetail";
	/** 2.10 流程信息 **/
	String IS_HANDLE = "/v1.0/appHandle/isHandle";
}
