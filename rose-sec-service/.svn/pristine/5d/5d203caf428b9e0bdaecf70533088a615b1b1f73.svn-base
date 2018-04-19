package com.zrt.client.vif;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(VifServiceUrlConstant.VMVIF_INSTANCE)
public interface VifClient extends VifServiceUrlConstant {

	@RequestMapping(value = UCDISK_LOGIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> ucdiskLogin(Map<String, Object> requestJson);

}
