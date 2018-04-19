package com.zrt.gateway.api.client.infoPub;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(InfoPubConstant.TASK_INSTANCE)
public interface IInfoPubClient extends InfoPubConstant {

	@RequestMapping(value = SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> save(Map<String, Object> map) throws Exception;

	@RequestMapping(value = SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> search(Map<String, Object> map) throws Exception;

	@RequestMapping(value = DEL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> del(Map<String, Object> map) throws Exception;

	@RequestMapping(value = SEARCHINFO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> searchInfo(Map<String, Object> map) throws Exception;

	@RequestMapping(value = STATE_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> state_search(Map<String, Object> map) throws Exception;

	@RequestMapping(value = STATE_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> state_save(Map<String, Object> map) throws Exception;
	
	@RequestMapping(value = UPDATEINFOTYPE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> updateInfoType(Map<String, Object> map) throws Exception;
	
	@RequestMapping(value = UPDATEINFOPUB, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> updateInfopub(Map<String, Object> map) throws Exception;
	


}
