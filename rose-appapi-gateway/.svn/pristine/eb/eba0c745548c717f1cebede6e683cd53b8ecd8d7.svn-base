package com.zrt.gateway.api.client.infor;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author wwfu
 *
 */
@FeignClient(InforConstant.SEC_INSTANCE)
public interface IInforClient extends InforConstant {

	@RequestMapping(value = INFOR_RECEIVE_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforReceiveList(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_DEAL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforDeal(Map<String, Object> requestMap);

	@RequestMapping(value = DIC_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> dicList(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_SHOWHID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforShowHid(Map<String, Object> requestMap);
	
	@RequestMapping(value = INFOR_DETAIL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforDetail(Map<String, Object> requestMap);
	
	@RequestMapping(value = INFOR_COUNTFLAG, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforCountFlag(Map<String, Object> requestMap);

	@RequestMapping(value = DIC_ADD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> dicAdd(Map<String, Object> requestMap);

	@RequestMapping(value = CONCERN_INFOR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> concernInfor(Map<String, Object> requestMap);
	
	@RequestMapping(value = CONCERNINFOR_CANCEL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> concernInforCancel(Map<String, Object> requestMap);
	
	@RequestMapping(value = INFORCARE_DETAIL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforCareDetail(Map<String, Object> requestMap);

	@RequestMapping(value = SAVE_AND_SENDINFOR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> saveAndSendInfor(Map<String, Object> requestMap);

	@RequestMapping(value = RELAY_INFOR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> relayInfor(Map<String, Object> requestMap);

	@RequestMapping(value = TRANSMIT_INFOR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> transmitInfor(Map<String, Object> requestMap);

	@RequestMapping(value = SAVE_INFOR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> saveInfor(Map<String, Object> requestMap);
	
	@RequestMapping(value = INFOR_DRAFT_SEND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforDraftSend(Map<String, Object> requestMap);

	@RequestMapping(value = INFOR_DRAFT_DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforDraftDelete(Map<String, Object> requestMap);


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
	
	@RequestMapping(value = INFOREMP_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> inforEmpSearch(Map<String, Object> requestMap);
	
	@RequestMapping(value = SENDUPDATE_INFOR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> sendUpdateInfor(Map<String, Object> requestMap);
}
