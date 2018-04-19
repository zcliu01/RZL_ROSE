package com.zrt.gateway.api.client.contacts;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(ContactsConstant.SEC_INSTANCE)
public interface IContactsClient extends ContactsConstant {

	@RequestMapping(value = CON_CONTACTS_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> contactsList(Map<String, Object> requestMap);

	@RequestMapping(value = CON_ORGEMP_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> empListByOrg(Map<String, Object> requestMap);

	@RequestMapping(value = CON_EMP_DETAILS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> selectEmpDetails(Map<String, Object> requestMap);

	@RequestMapping(value = CON_EMP_POSITION_DETAILS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> selectEmpPositionDetails(Map<String, Object> requestMap);

	@RequestMapping(value = CON_EMP_WORK_DETAILS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> selectEmpWorkRedeploy(Map<String, Object> requestMap);

	@RequestMapping(value = CON_EMP_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> commonEmpSearch(Map<String, Object> requestMap);
	
	@RequestMapping(value = CON_IM_SYNCHRONIZATION, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> contactsImList(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIEND_ADD_PAGE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> friendSavePage(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIEND_ADD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> friendSave(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIEND_DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> friendDelete(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIEND_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> friendList(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIENDGROUP_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> friendGroupList(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIENDGROUP_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> friendGroupSave(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIENDGROUPMEMBER_DETAILS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> selectGroupDetails(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIENDGROUP_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> friendGroupUpdate(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIENDGROUP_QUITORDISMISS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> groupDismissOrQuit(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIENDGROUPMEMBER_ADD_PAGE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> groupMemberSavePage(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIENDGROUPMEMBER_ADD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> groupMemberSave(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIENDGROUPMEMBER_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> selectGroupMemList(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIENDGROUPMEMBER_DEL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> groupMemDelete(Map<String, Object> requestMap);

	@RequestMapping(value = CON_EMPDETAILS_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> appUpdateEmpDetails(Map<String, Object> requestMap);
}
