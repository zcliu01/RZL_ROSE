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
	 * 组织通讯录的通用搜索
	 * 
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = COMMONEMP_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> commonEmpSearch(Map requestJson);

	/**
	 * 参加会议中的员工信息
	 * 
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = MEET_EMPINFO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> meetEmpInfo(Map requestJson);

	@RequestMapping(value = GET_REDIS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> getRedis(Map requestJson);

}
