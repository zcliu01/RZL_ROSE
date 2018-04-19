package com.zrt.gateway.api.client.sec.user;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(SecUserConstant.SEC_INSTANCE)
public interface ISecUserClient extends SecUserConstant {

	@RequestMapping(value = SEC_LOGIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> appLogin(Map<String, Object> requestMap);
	
	@RequestMapping(value = SEC_USER_DETAILS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> appMyDetails(Map<String, Object> requestMap);
	
	@RequestMapping(value = SEC_USER_DETAILS_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> appUpdateEmpDetails(Map<String, Object> requestMap);
	
	@RequestMapping(value = SEC_INVOICETITLE_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> appSelectInvoiceTitle(Map<String, Object> requestMap);
	
	
	@RequestMapping(value = SEC_LOGIN_CHECK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> appLoginCheck(Map<String, Object> requestMap);
	
	@RequestMapping(value = SEC_USER_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> appUserSearch(Map<String, Object> requestMap);
	
	@RequestMapping(value = SEC_USER_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> appUserUpdate(Map<String, Object> requestMap);
	
	@RequestMapping(value = SEC_USER_PWDSET, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> appUserPwdSet(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_RELATION_SEARCHE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> relationSearch(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_RELATION_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> relationUpdate(Map<String, Object> requestMap);
	
	@RequestMapping(value = SEC_PC_LOGIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> pcLogin(Map<String, Object> requestMap);
	
	@RequestMapping(value = CHECK_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> checkUpdate(Map<String, Object> requestMap);
}
