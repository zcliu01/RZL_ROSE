package com.zrt.client.sec;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient(SecServiceUrlConstant.SEC_INSTANCE)
public interface ISecClient extends SecServiceUrlConstant {

	/**
	 * 树形结构列表
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = SEC_ORGALLLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> orgAllList(Map<String,Object> requestJson);


}
