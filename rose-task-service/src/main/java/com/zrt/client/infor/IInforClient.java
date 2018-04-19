package com.zrt.client.infor;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient(InforServiceUrlConstant.INFOR_INSTANCE)
public interface IInforClient extends InforServiceUrlConstant {

	/**
	 * 数据库序列查询
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = SENDUPDATE_INFOR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> sendUpdateInfor(Map requestJson);

	
	/**
	 * 修改内部讯息阅读状态
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = FLOWINFORREAD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> flowInforRead(Map requestJson);
}
