package com.zrt.gateway.api.client.infor;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(InforConstant.INSTANCE_NAME)
public interface IInforClient extends InforConstant {

	@RequestMapping(value = INFOR_RECEIVE_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforReceiveList(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_SEND_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforSendList(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforList(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_INNER_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforAllList(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_DRAFT_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforDraftList(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_CARE_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforCareList(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_WILL_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforWillList(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_HASREAD_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforHasReadList(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_HASDEAL_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforHasDealList(Map<String, Object> requestMap);

	@RequestMapping(value = SAVE_AND_SENDINFOR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> saveAndSendInfor(Map<String, Object> requestMap);

	@RequestMapping(value = RELAY_INFOR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> relayInfor(Map<String, Object> requestMap);

	@RequestMapping(value = TRANSMIT_INFOR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> transmitInfor(Map<String, Object> requestMap);

	@RequestMapping(value = SENDUPDATE_INFOR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> sendUpdateInfor(Map<String, Object> requestMap);

	@RequestMapping(value = SELECT_RECEIVER, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> selectReceiver(Map<String, Object> requestMap);

	@RequestMapping(value = SAVE_INFOR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> saveInfor(Map<String, Object> requestMap);

	@RequestMapping(value = CHANGEINFOR_DEAL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> changeInforDeal(Map<String, Object> requestMap);

	@RequestMapping(value = CHANGEINFOR_READ, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> changeInforRead(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_HIDDEN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforHidden(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_HIDDEN_BATCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforHiddenBatch(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_CANCELHIDDEN_BATCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforCancelHiddenBatch(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_DETAIL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> infordetail(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_COUNT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforCount(Map<String, Object> requestMap);

	@RequestMapping(value = CONCERN_INFOR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> concernInfor(Map<String, Object> requestMap);

	@RequestMapping(value = INFORCARE_DETAIL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforCareDetail(Map<String, Object> requestMap);

	@RequestMapping(value = CONCERNINFOR_CANCEL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> concernInforCancel(Map<String, Object> requestMap);

	@RequestMapping(value = CONCERNINFOR_BATCHCANCEL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> concernInforBatchCancel(Map<String, Object> requestMap);

	@RequestMapping(value = DIC_ADD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> dicAdd(Map<String, Object> requestMap);

	@RequestMapping(value = DIC_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> dicList(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_CANCEL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforCancel(Map<String, Object> requestMap);

	@RequestMapping(value = INFORDRAFT_DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforDraftDelete(Map<String, Object> requestMap);

	@RequestMapping(value = INFORDRAFT_BATCHDELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforDraftBatchDelete(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_DRAFTSEND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforDraftSend(Map<String, Object> requestMap);

	@RequestMapping(value = INFORDRAF_BATCHSEND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforDrafBatchSend(Map<String, Object> requestMap);

	@RequestMapping(value = WITHINFOR_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> withInforList(Map<String, Object> requestMap);

	@RequestMapping(value = WITHINFOR_DETAILS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> withInforDetails(Map<String, Object> requestMap);

	@RequestMapping(value = INFORDETAILS_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforDetailsSearch(Map<String, Object> requestMap);

	@RequestMapping(value = WITHEMP_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> withEmpList(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_ALLLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowAllList(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_NOREADLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowNoReadList(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_READLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowReadList(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_DEALLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowDealList(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_CARELIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowCareList(Map<String, Object> requestMap);

	@RequestMapping(value = CHANGEFLOW_READ, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> changeFlowRead(Map<String, Object> requestMap);

	@RequestMapping(value = CHANGEFLOW_DEAL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> changeFlowDeal(Map<String, Object> requestMap);

	@RequestMapping(value = CARE_FLOW, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> careFlow(Map<String, Object> requestMap);

	@RequestMapping(value = CARE_CANCEL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> careCancel(Map<String, Object> requestMap);

	@RequestMapping(value = HIDDEN_FLOW, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> hiddenFlow(Map<String, Object> requestMap);

	@RequestMapping(value = DOCUMENT_ALLLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> documentAllList(Map<String, Object> requestMap);

	@RequestMapping(value = DOCUMENT_NOREADLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> documentNoReadList(Map<String, Object> requestMap);

	@RequestMapping(value = DOCUMENT_READLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> documentReadList(Map<String, Object> requestMap);

	@RequestMapping(value = DOCUMENT_DEALLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> documentDealList(Map<String, Object> requestMap);

	@RequestMapping(value = DOCUMENT_CARELIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> documentCareList(Map<String, Object> requestMap);

	@RequestMapping(value = CHANGEDOCUMENT_READ, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> changeDocumentRead(Map<String, Object> requestMap);

	@RequestMapping(value = CHANGE_DOCUMENTDEAL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> changeDocumentDeal(Map<String, Object> requestMap);

	@RequestMapping(value = CARE_DOCUMENT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> careDocument(Map<String, Object> requestMap);

	@RequestMapping(value = DOCUMENTCARE_CANCEL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> documentCareCancel(Map<String, Object> requestMap);

	@RequestMapping(value = HIDDEN_DOCUMENT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> hiddenDocument(Map<String, Object> requestMap);

	@RequestMapping(value = PUBLICITY_ALLLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> publicityAllList(Map<String, Object> requestMap);

	@RequestMapping(value = PUBLICITY_NOREADLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> publicityNoReadList(Map<String, Object> requestMap);

	@RequestMapping(value = PUBLICITY_READLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> publicityReadList(Map<String, Object> requestMap);

	@RequestMapping(value = PUBLICITY_DEALLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> publicityDealList(Map<String, Object> requestMap);

	@RequestMapping(value = PUBLICITY_CARELIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> publicityCareList(Map<String, Object> requestMap);

	@RequestMapping(value = CHANGEPUBLICITY_READ, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> changePublicityRead(Map<String, Object> requestMap);

	@RequestMapping(value = CHANGEPUBLICITY_DEAL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> changePublicityDeal(Map<String, Object> requestMap);

	@RequestMapping(value = CARE_PUBLICITY, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> carePublicity(Map<String, Object> requestMap);

	@RequestMapping(value = PUBLICITYCARE_CANCEL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> publicityCareCancel(Map<String, Object> requestMap);

	@RequestMapping(value = HIDDEN_PUBLICITY, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> hiddenPublicity(Map<String, Object> requestMap);

	@RequestMapping(value = QUESTIONNAIRE_ALLLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> questionnaireAllList(Map<String, Object> requestMap);

	@RequestMapping(value = QUESTIONNAIRE_NOREADLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> questionnaireNoReadList(Map<String, Object> requestMap);

	@RequestMapping(value = QUESTIONNAI_REREADLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> questionnaireReadList(Map<String, Object> requestMap);

	@RequestMapping(value = QUESTIONNAIRE_DEALLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> questionnaireDealList(Map<String, Object> requestMap);

	@RequestMapping(value = QUESTIONNAIRE_CARELIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> questionnaireCareList(Map<String, Object> requestMap);

	@RequestMapping(value = CHANGEQUESTIONNAIRE_READ, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> changeQuestionnaireRead(Map<String, Object> requestMap);

	@RequestMapping(value = CHANGEQUESTIONNAIRE_DEAL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> changeQuestionnaireDeal(Map<String, Object> requestMap);

	@RequestMapping(value = CARE_QUESTIONNAIRE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> careQuestionnaire(Map<String, Object> requestMap);

	@RequestMapping(value = QUESTIONNAIRECARE_CANCEL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> questionnaireCareCancel(Map<String, Object> requestMap);

	@RequestMapping(value = HIDDEN_QUESTIONNAIRE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> hiddenQuestionnaire(Map<String, Object> requestMap);

	@RequestMapping(value = SCHEDULE_ALLLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> scheduleAllList(Map<String, Object> requestMap);

	@RequestMapping(value = SCHEDULE_NOREADLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> scheduleNoReadList(Map<String, Object> requestMap);

	@RequestMapping(value = SCHEDULE_READLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> scheduleReadList(Map<String, Object> requestMap);

	@RequestMapping(value = SCHEDULE_DEALLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> scheduleDealList(Map<String, Object> requestMap);

	@RequestMapping(value = SCHEDULE_CARELIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> scheduleCareList(Map<String, Object> requestMap);

	@RequestMapping(value = CHANGESCHEDULE_READ, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> changeScheduleRead(Map<String, Object> requestMap);

	@RequestMapping(value = CHANGESCHEDULE_DEAL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> changeScheduleDeal(Map<String, Object> requestMap);

	@RequestMapping(value = CARE_SCHEDULE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> careSchedule(Map<String, Object> requestMap);

	@RequestMapping(value = SCHEDULECARE_CANCEL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> scheduleCareCancel(Map<String, Object> requestMap);

	@RequestMapping(value = HIDDEN_SCHEDULE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> hiddenSchedule(Map<String, Object> requestMap);

	@RequestMapping(value = CARE_ALLLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> careAllList(Map<String, Object> requestMap);

	@RequestMapping(value = CARE_NOREADLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> careNoReadList(Map<String, Object> requestMap);

	@RequestMapping(value = CARE_READLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> careReadList(Map<String, Object> requestMap);

	@RequestMapping(value = CARE_DEALLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> careDealList(Map<String, Object> requestMap);

	@RequestMapping(value = CHANGECARE_READ, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> changeCareRead(Map<String, Object> requestMap);

	@RequestMapping(value = CHANGECARE_DEAL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> changeCareDeal(Map<String, Object> requestMap);

	@RequestMapping(value = CARECARE_CANCEL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> careCareCancel(Map<String, Object> requestMap);

	@RequestMapping(value = HIDDEN_CARE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> hiddenCare(Map<String, Object> requestMap);

}
