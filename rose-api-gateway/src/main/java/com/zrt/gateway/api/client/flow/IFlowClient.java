package com.zrt.gateway.api.client.flow;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(FlowConstant.FLOW_INSTANCE)
public interface IFlowClient extends FlowConstant {

	@RequestMapping(value = LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> list(Map<String, Object> requestMap);

	@RequestMapping(value = SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> save(Map<String, Object> requestMap);

	@RequestMapping(value = SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> search(Map<String, Object> requestMap);

	@RequestMapping(value = UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> update(Map<String, Object> requestMap);

	@RequestMapping(value = DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> delete(Map<String, Object> requestMap);

	@RequestMapping(value = FORM_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> formList(Map<String, Object> requestMap);

	@RequestMapping(value = FORM_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> formSave(Map<String, Object> requestMap);

	@RequestMapping(value = FORM_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> formSearch(Map<String, Object> requestMap);

	@RequestMapping(value = FORM_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> formUpdate(Map<String, Object> requestMap);

	@RequestMapping(value = FORM_DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> formDelete(Map<String, Object> requestMap);

	@RequestMapping(value = OPEN_FORM, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> openform(Map<String, Object> requestMap);

	@RequestMapping(value = CLOSE_FORM, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> closeform(Map<String, Object> requestMap);

	@RequestMapping(value = FORM_DEAIL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> formdeail(Map<String, Object> requestMap);

	@RequestMapping(value = FORM_FORMSAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> formFormsave(Map<String, Object> requestMap);

	@RequestMapping(value = FBTYPE_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> fbtypeList(Map<String, Object> requestMap);

	@RequestMapping(value = FBTYPE_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> fbtypeSave(Map<String, Object> requestMap);

	@RequestMapping(value = FBTYPE_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> fbtypeSearch(Map<String, Object> requestMap);

	@RequestMapping(value = FBTYPE_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> fbtypeUpdate(Map<String, Object> requestMap);

	@RequestMapping(value = FBTYPE_DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> fbtypeDelete(Map<String, Object> requestMap);

	@RequestMapping(value = FBTEMP_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> fbtempList(Map<String, Object> requestMap);

	@RequestMapping(value = FBTEMP_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> fbtempSave(Map<String, Object> requestMap);

	@RequestMapping(value = FBTEMP_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> fbtempSearch(Map<String, Object> requestMap);

	@RequestMapping(value = FBTEMP_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> fbtempUpdate(Map<String, Object> requestMap);

	@RequestMapping(value = FBTEMP_DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> fbtempDelete(Map<String, Object> requestMap);

	@RequestMapping(value = OPEN_FBTEMP, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> openfbtemp(Map<String, Object> requestMap);

	@RequestMapping(value = CLOSE_FBTEMP, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> closefbtemp(Map<String, Object> requestMap);

	@RequestMapping(value = FBTEMPFORM_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> fbtempFormList(Map<String, Object> requestMap);

	@RequestMapping(value = FBTEMP_FORMSAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> fbtempFormsave(Map<String, Object> requestMap);

	@RequestMapping(value = RUN_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> runList(Map<String, Object> requestMap);

	@RequestMapping(value = RUNFLOW_DETAIL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> runFlowDetail(Map<String, Object> requestMap);

	@RequestMapping(value = STOP_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> stopList(Map<String, Object> requestMap);

	@RequestMapping(value = STOPFLOW_DETAIL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> stopFlowDetail(Map<String, Object> requestMap);

	@RequestMapping(value = CHECK_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> checkList(Map<String, Object> requestMap);

	@RequestMapping(value = ENTED_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> entedList(Map<String, Object> requestMap);

	@RequestMapping(value = ENTRUST_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> entrustList(Map<String, Object> requestMap);

	@RequestMapping(value = ENT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> ent(Map<String, Object> requestMap);

	@RequestMapping(value = CANCEL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> cancel(Map<String, Object> requestMap);

	@RequestMapping(value = MODEL_SEARCH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> getEditorJson(@PathVariable("modelId") String modelId);

	@RequestMapping(value = MODEL_SAVE, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveModel(@PathVariable("modelId") String modelId,
			MultiValueMap<String, String> requestMap);

	@RequestMapping(value = MODEL_NEW, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> newModel(Map<String, Object> requestMap);

	@RequestMapping(value = DRAFT_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> draftList(Map<String, Object> requestMap);

	@RequestMapping(value = NOTIFY_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> notifyList(Map<String, Object> requestMap);

	@RequestMapping(value = SELF_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> selfList(Map<String, Object> requestMap);

	@RequestMapping(value = PRE_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> preList(Map<String, Object> requestMap);

	@RequestMapping(value = DEAL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> deal(Map<String, Object> requestMap);

	@RequestMapping(value = PRE_CANCEL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> preCancel(Map<String, Object> requestMap);

	@RequestMapping(value = CARE_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> careList(Map<String, Object> requestMap);

	@RequestMapping(value = APPLY_CHECK_WITH_FILE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> applyCheckWithFile(Map<String, Object> requestMap);

	@RequestMapping(value = CARE_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> careSave(Map<String, Object> requestMap);

	@RequestMapping(value = JOIN_SIGN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> joinSign(Map<String, Object> requestMap);

	@RequestMapping(value = JOINSIGN_CHECK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> joinSignCheck(Map<String, Object> requestMap);

	@RequestMapping(value = APPLY_CHECK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> applyCheck(Map<String, Object> requestMap);

	@RequestMapping(value = APPLYCHECK_WITHCON, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> applyCheckWithCon(Map<String, Object> requestMap);

	@RequestMapping(value = RETURN_CHECK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> returnCheck(Map<String, Object> requestMap);

	@RequestMapping(value = SIGN_ADD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> signAdd(Map<String, Object> requestMap);

	@RequestMapping(value = ACT_INFOLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> actInfoList(Map<String, Object> requestMap);

	@RequestMapping(value = INST_READ, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> instRead(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_DRAFT_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> draftSave(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_SEND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> send(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_DRAFT_DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> draftDelete(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_DEPLOY, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> deploy(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_APPLY, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> apply(Map<String, Object> requestMap);

	@RequestMapping(value = APPLY_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> applyList(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_OPER_FLOW_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowList(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_OPER_ENTRUST_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> entList(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_OPER_PRE_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> operPreList(Map<String, Object> requestMap);

	@RequestMapping(value = SELF_APPLY, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> selfApply(Map<String, Object> requestMap);

	@RequestMapping(value = SELF_DOLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> selfDoList(Map<String, Object> requestMap);

	@RequestMapping(value = SELF_HASHDOLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> selfHashDoList(Map<String, Object> requestMap);

	@RequestMapping(value = SELF_SIGN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> selfSign(Map<String, Object> requestMap);

	@RequestMapping(value = CHECK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> check(Map<String, Object> requestMap);

	@RequestMapping(value = FORM_DETAIL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> fmDetail(Map<String, Object> requestMap);

	@RequestMapping(value = INST_APPLY_DETAIL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> applyDetail(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_DRAFT_DETAIL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> draftDetail(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_DRAFT_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> draftUpdate(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_DRAFT_APPLY, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> draftApply(Map<String, Object> requestMap);

	@RequestMapping(value = RES, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> res(Map<String, Object> requestMap);

	@RequestMapping(value = CONFIRM, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> confirm(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_EDIT_SUBMIT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> editSubmit(Map<String, Object> requestMap);

	@RequestMapping(value = APPLYCHECK_CON, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> applyCheckCon(Map<String, Object> requestMap);

	@RequestMapping(value = SELF_APPLY_RES, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> selfApplyRes(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_PRE_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowPreList(Map<String, Object> requestMap);

	@RequestMapping(value = DIC_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> dicList(Map<String, Object> requestMap);

	@RequestMapping(value = DIC_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> dicSave(Map<String, Object> requestMap);

	@RequestMapping(value = DIC_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> dicSearch(Map<String, Object> requestMap);

	@RequestMapping(value = DIC_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> dicUpdate(Map<String, Object> requestMap);

	@RequestMapping(value = DIC_DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> dicDelete(Map<String, Object> requestMap);

	@RequestMapping(value = DICPM_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> dicPmList(Map<String, Object> requestMap);

	@RequestMapping(value = DICPM_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> dicPmSave(Map<String, Object> requestMap);

	@RequestMapping(value = DICPM_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> dicPmSearch(Map<String, Object> requestMap);

	@RequestMapping(value = DICPM_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> dicPmUpdate(Map<String, Object> requestMap);

	@RequestMapping(value = DICPM_DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> dicPmDelete(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_IMG, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> img(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_REMIND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> remind(Map<String, Object> requestMap);

	@RequestMapping(value = NOTIFY_NOTIFY, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> notify(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_NEXT_TAGLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> actNextList(Map<String, Object> requestMap);

	@RequestMapping(value = HANDLE_APPLY, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> handleApply(Map<String, Object> requestMap);

	@RequestMapping(value = HANDLE_CHECK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> handleCheck(Map<String, Object> requestMap);

	@RequestMapping(value = HANDLE_DETAIL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> handDetail(Map<String, Object> requestMap);

	@RequestMapping(value = HANDLE_END, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> handleEnd(Map<String, Object> requestMap);

	@RequestMapping(value = HANDLE_DRAFT_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> handleDraftSave(Map<String, Object> requestMap);

	@RequestMapping(value = HANDLE_DRAFT_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> handleDraftUpdate(Map<String, Object> requestMap);

	@RequestMapping(value = HANDLE_DRAFT_APPLY, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> handleDraftApply(Map<String, Object> requestMap);

	@RequestMapping(value = HANDLE_DRAFT_DETAIL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> handleDraftDetail(Map<String, Object> requestMap);

	@RequestMapping(value = INST_INFOR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> instInfor(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_CANCLE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> instCancel(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_SELF_ABOUT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> selfAboutList(Map<String, Object> requestMap);

	@RequestMapping(value = CARE_CANCLE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> careCancle(Map<String, Object> requestMap);

	@RequestMapping(value = FBTEM_NOTIFY_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> fbNotifyList(Map<String, Object> requestMap);

	@RequestMapping(value = FBTEM_NOTIFY, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> fbNotify(Map<String, Object> requestMap);

	@RequestMapping(value = SELFAPPLY_CONFIRM, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> selfApplyConfirm(Map<String, Object> requestMap);

	@RequestMapping(value = FLOWDELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowDelete(Map<String, Object> requestMap);

	@RequestMapping(value = FLOWEND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> end(Map<String, Object> requestMap);

	@RequestMapping(value = IS_HANDLE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> isHandle(Map<String, Object> requestMap);

}
