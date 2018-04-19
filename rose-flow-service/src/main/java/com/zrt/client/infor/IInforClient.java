package com.zrt.client.infor;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(InforServiceUrlConstant.INFOR_INSTANCE)
public interface IInforClient extends InforServiceUrlConstant {

	/**
	 * 讯息推送
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = SENDUPDATE_INFOR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> sendUpdateInfor(Map requestJson);
	
	
	/**
	 * 讯息已阅
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = SEND_READ_INFOR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> sendReadInfor(Map requestJson);

}
