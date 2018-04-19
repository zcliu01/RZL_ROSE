package com.zrt.client.sec;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(SecServiceUrlConstant.SEC_INSTANCE)
public interface ISecClient extends SecServiceUrlConstant {

	/**
	 * 员工所在机构的主分管领导
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = SEC_UP_MANAGE_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> upManageSearch(Map<String,Object> requestJson);

	
	/**
	 * 员工主部门主分管领导
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = SEC_MANAGE_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> manageSearch(Map<String,Object> requestJson);


}
