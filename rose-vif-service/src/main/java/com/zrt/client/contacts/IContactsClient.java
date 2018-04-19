package com.zrt.client.contacts;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient(ContactsServiceUrlConstant.CONTACTS_INSTANCE)
public interface IContactsClient extends ContactsServiceUrlConstant {

	/**
	 * 数据库序列查询
	 * 
	 * @param requestJson
	 * @return
	 */

	@RequestMapping(value = ORG_ALLLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> orgAllList(Map requestJson);

	@RequestMapping(value = YP_EMPLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> ypEmpList(Map requestJson);

	@RequestMapping(value = YP_EMPLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> searchAll(Map requestJson);

}
