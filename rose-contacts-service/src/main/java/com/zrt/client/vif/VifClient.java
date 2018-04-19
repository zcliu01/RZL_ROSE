package com.zrt.client.vif;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient(VifServiceUrlConstant.VIF_INSTANCE)
public interface VifClient extends VifServiceUrlConstant {

	@RequestMapping(value = IM_PUSH_MSG, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> pushMsg(Map<String, Object> requestJson);

}
