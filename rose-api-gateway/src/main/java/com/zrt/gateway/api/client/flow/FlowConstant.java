package com.zrt.gateway.api.client.flow;

public interface FlowConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String FLOW_INSTANCE = "flow12";

	/** 表单分类列表查询 */
	String LIST = "/v1.0/fmtype/list";
	/** 表单分类新增 */
	String SAVE = "/v1.0/fmtype/save";
	/** 表单分类明细查询 */
	String SEARCH = "/v1.0/fmtype/search";
	/** 表单分类更新 */
	String UPDATE = "/v1.0/fmtype/update";
	/** 表单分类删除 */
	String DELETE = "/v1.0/fmtype/delete";

	/** 表单列表查询 */
	String FORM_LIST = "/v1.0/fmform/list";
	/** 表单新增 */
	String FORM_SAVE = "/v1.0/fmform/save";
	/** 表单明细查询 */
	String FORM_SEARCH = "/v1.0/fmform/search";
	/** 表单更新 */
	String FORM_UPDATE = "/v1.0/fmform/update";
	/** 表单删除 */
	String FORM_DELETE = "/v1.0/fmform/delete";
	/** 表单启用 */
	String OPEN_FORM = "/v1.0/fmform/openform";
	/** 表单关闭 */
	String CLOSE_FORM = "/v1.0/fmform/closeform";
	/** 表单元素详情 */
	String FORM_DEAIL = "/v1.0/fmform/formdeail";
	/** 表单元素保存 */
	String FORM_FORMSAVE = "/v1.0/fmform/formsave";

	/** 流程分类列表查询 */
	String FBTYPE_LIST = "/v1.0/fbtype/list";
	/** 流程分类新增 */
	String FBTYPE_SAVE = "/v1.0/fbtype/save";
	/** 流程分类明细查询 */
	String FBTYPE_SEARCH = "/v1.0/fbtype/search";
	/** 流程分类更新 */
	String FBTYPE_UPDATE = "/v1.0/fbtype/update";
	/** 流程分类删除 */
	String FBTYPE_DELETE = "/v1.0/fbtype/delete";

	/** 流程列表查询 */
	String FBTEMP_LIST = "/v1.0/fbtemp/list";
	/** 流程新增 */
	String FBTEMP_SAVE = "/v1.0/fbtemp/save";
	/** 流程明细查询 */
	String FBTEMP_SEARCH = "/v1.0/fbtemp/search";
	/** 流程更新 */
	String FBTEMP_UPDATE = "/v1.0/fbtemp/update";
	/** 流程删除 */
	String FBTEMP_DELETE = "/v1.0/fbtemp/delete";
	/** 流程启用 */
	String OPEN_FBTEMP = "/v1.0/fbtemp/open";
	/** 流程关闭 */
	String CLOSE_FBTEMP = "/v1.0/fbtemp/close";
	/** 流程绑定表单查询 */
	String FBTEMPFORM_LIST = "/v1.0/fbtemp/formList";
	/** 流程绑定表单 */
	String FBTEMP_FORMSAVE = "/v1.0/fbtemp/formSave";
	/** 流程提醒人设置 */
	String FBTEM_NOTIFY_LIST = "/v1.0/fbtemp/notifyList";
	/** 流程设置提醒人 */
	String FBTEM_NOTIFY = "/v1.0/fbtemp/notify";
	/** 流程删除 */
	String FLOWDELETE = "/v1.0/flowAction/delete";
	/** 流程删除 */
	String FLOWEND = "/v1.0/flowAction/end";

	/** 运行流程列表 */
	String RUN_LIST = "/v1.0/flowfboper/runList";
	/** 运行流程明细 */
	String RUNFLOW_DETAIL = "/v1.0/flowfboper/runFlowDetail";
	/** 停用流程列表 */
	String STOP_LIST = "/v1.0/flowfboper/stopList";
	/** 停用流程明细 */
	String STOPFLOW_DETAIL = "/v1.0/flowfboper/stopFlowDetail";

	/** 查询流程模型json ***/
	String MODEL_SEARCH = "/model/{modelId}/json";

	/** 我委托的流程列表 */
	String CHECK_LIST = "/v1.0/flowent/list";
	/** 委托我的流程列表 */
	String ENTED_LIST = "/v1.0/flowent/entedList";
	/** 委托流程列表 */
	String ENTRUST_LIST = "/v1.0/flowentrust/list";
	/** 流程委托 */
	String ENT = "/v1.0/flowentrust/ent";
	/** 取消流程委托 */
	String CANCEL = "/v1.0/flowentrust/cancel";

	/** 流程模型保存 ***/
	String MODEL_SAVE = "/model/{modelId}/save";

	/** 流程模型创建 **/
	String MODEL_NEW = "/model/new";
	/** 我的草稿 **/
	String DRAFT_LIST = "/v1.0/flowdraft/list";

	/** 知会我的 **/
	String NOTIFY_LIST = "/v1.0/flownotify/notifyList";
	/** 我知会的 **/
	String SELF_LIST = "/v1.0/flownotify/selfList";
	/** 知会 **/
	String NOTIFY_NOTIFY = "/v1.0/flownotify/notify";
	/** 我的关注 **/
	String CARE_LIST = "/v1.0/flowcare/careList";
	/** 我的关注 **/
	String CARE_SAVE = "/v1.0/flowcare/careSave";
	/** 我的关注 **/
	String CARE_CANCLE = "/v1.0/flowcare/careCancle";

	/** 我的预处理流程列表 **/
	String PRE_LIST = "/v1.0/flowpre/selfList";
	/** 流程预处理同意/拒绝 **/
	String DEAL = "/v1.0/flowpre/deal";
	/** 流程预处理取消 **/
	String PRE_CANCEL = "/v1.0/flowpre/cancel";
	/** 流程审核（附条件同意） **/
	String APPLY_CHECK_WITH_FILE = "/v1.0/flow/applyCheckWithFile";

	/** 会签加人 **/
	String JOIN_SIGN = "/v1.0/flow/joinSign";
	/** 会签审批 **/
	String JOINSIGN_CHECK = "/v1.0/flow/joinSignCheck";
	/** 流程普通审核同意/拒绝 **/
	String APPLY_CHECK = "/v1.0/flow/applyCheck";
	/** 附条件同意 **/
	String APPLYCHECK_WITHCON = "/v1.0/flow/applyCheckWithCon";
	/** 驳回至审批 **/
	String RETURN_CHECK = "/v1.0/flow/returnCheck";
	/** 加签审批 **/
	String SIGN_ADD = "/v1.0/flow/signAdd";
	/** 流程节点信息查询 **/
	String ACT_INFOLIST = "/v1.0/flow/actInfoList";

	/** 流程阅读 ***/
	String INST_READ = "/v1.0/flow/instRead";
	/** 流程草稿保存 ***/
	String FLOW_DRAFT_SAVE = "/v1.0/flow/draftSave";
	/** 流程草稿发送 ***/
	String FLOW_SEND = "/v1.0/flow/send";
	/** 流程草稿删除 ***/
	String FLOW_DRAFT_DELETE = "/v1.0/flow/draftDelete";
	/** 流程发布 ***/
	String FLOW_DEPLOY = "/v1.0/flow/deploy";
	/** 流程发起 ***/
	String FLOW_APPLY = "/v1.0/flow/apply";
	/** 流程发起列表 ***/
	String APPLY_LIST = "/v1.0/flowfboper/applyList";

	/*** 管理员流程查询 ***/
	/*** 全部流程列表 **/
	String FLOW_OPER_FLOW_LIST = "/v1.0/flowoper/flowList";

	/** 委托流程列表 **/
	String FLOW_OPER_ENTRUST_LIST = "/v1.0/flowoper/entList";

	/*** 预处理流程列表 **/
	String FLOW_OPER_PRE_LIST = "/v1.0/flowoper/operPreList";

	/** 我发起的流程列表 **/
	String SELF_APPLY = "/v1.0/flowself/selfApply";
	/** 我的待办 **/
	String SELF_DOLIST = "/v1.0/flowself/selfDoList";
	/** 待确认列表 **/
	String SELFAPPLY_CONFIRM = "/v1.0/flowself/selfApplyConfirm";

	/** 我的已办 **/
	String SELF_HASHDOLIST = "/v1.0/flowself/selfHasDoList";
	/** 会签审批 **/
	String SELF_SIGN = "/v1.0/flowself/selfSign";
	/** 审批 **/
	String CHECK = "/v1.0/flowself/check";
	/** 流程模版表单明细 **/
	String FORM_DETAIL = "/v1.0/flow/fmDetail";

	/** 我发起的详情 **/
	String INST_APPLY_DETAIL = "/v1.0/flowDetail/inst";

	/** 草稿详情 **/
	String FLOW_DRAFT_DETAIL = "/v1.0/flow/draftDetail";
	/** 草稿更新 **/
	String FLOW_DRAFT_UPDATE = "/v1.0/flow/draftUpdate";
	/** 草稿提交 **/
	String FLOW_DRAFT_APPLY = "/v1.0/flow/draftApply";
	/** 草稿提交 **/
	String FLOW_EDIT_SUBMIT = "/v1.0/flow/editSubmit";
	/** 流程进度图 ***/
	String FLOW_IMG = "/v1.0/flow/img";
	/** 催办 **/
	String FLOW_REMIND = "/v1.0/flow/remind";
	/** 撤销 **/
	String FLOW_CANCLE = "/v1.0/flow/instCancel";
	/** 个人相关流程 **/
	String FLOW_SELF_ABOUT = "/v1.0/flow/selfAboutList";

	/** 附条件回复 **/
	String RES = "/v1.0/con/res";
	/** 附条件复核 **/
	String CONFIRM = "/v1.0/con/confirm";
	/** 附条件 **/
	String APPLYCHECK_CON = "/v1.0/flow/applyCheckCon";
	/** 附条件待回复 **/
	String SELF_APPLY_RES = "/v1.0/flowself/selfApplyRes";
	/** 附条件待回复 **/
	String FLOW_PRE_LIST = "/v1.0/flowpre/list";

	// 字典管理
	/** 字典列表 **/
	String DIC_LIST = "/v1.0/fmdic/list";
	/** 字典新增 **/
	String DIC_SAVE = "/v1.0/fmdic/save";
	/** 字典明细查询 **/
	String DIC_SEARCH = "/v1.0/fmdic/search";
	/** 字典更新 **/
	String DIC_UPDATE = "/v1.0/fmdic/update";
	/** 字典删除 **/
	String DIC_DELETE = "/v1.0/fmdic/delete";

	/** 字典列表 **/
	String DICPM_LIST = "/v1.0/fmdicpm/list";
	/** 字典新增 **/
	String DICPM_SAVE = "/v1.0/fmdicpm/save";
	/** 字典明细查询 **/
	String DICPM_SEARCH = "/v1.0/fmdicpm/search";
	/** 字典更新 **/
	String DICPM_UPDATE = "/v1.0/fmdicpm/update";
	/** 字典删除 **/
	String DICPM_DELETE = "/v1.0/fmdicpm/delete";

	/** 下一审批节点信息 **/
	String FLOW_NEXT_TAGLIST = "/v1.0/flow/actNextList";
	/** 签报发起 **/
	String HANDLE_APPLY = "/v1.0/handle/handleApply";
	/** 签报审批 **/
	String HANDLE_CHECK = "/v1.0/handle/handleCheck";
	/** 签报审批详情 **/
	String HANDLE_DETAIL = "/v1.0/handle/detail";
	/** 签报结束 **/
	String HANDLE_END = "/v1.0/handle/handleEnd";
	/** 草稿保存 **/
	String HANDLE_DRAFT_SAVE = "/v1.0/handle/draftSave";
	/** 草稿更新 **/
	String HANDLE_DRAFT_UPDATE = "/v1.0/handle/draftUpdate";
	/** 草稿提交 **/
	String HANDLE_DRAFT_APPLY = "/v1.0/handle/draftApply";
	/** 草稿详情 **/
	String HANDLE_DRAFT_DETAIL = "/v1.0/handle/draftDetail";

	/** 2.10 流程信息 **/
	String INST_INFOR = "/v1.0/handle/instInfor";
	/** 2.10 流程信息 **/
	String IS_HANDLE = "/v1.0/handle/isHandle";
}
