package com.zrt.client.contacts;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(ContactsServiceUrlConstant.CONTACTS_INSTANCE)
public interface IContactsClient extends ContactsServiceUrlConstant {

	/**
	 * 数据库序列查询
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = COMMONEMP_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> commonEmpSearch(Map requestJson);
	
	
	/**
	 * 项目列表查询
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = PROJECT_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> projectList(Map requestJson);
	
	/**
	 * 员工机构列表
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = EMP_ORG_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> empOrgInfo(Map requestJson);

}
