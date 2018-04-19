package com.zrt.gateway.api.client.contacts;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(ContactsConstant.INSTANCE_NAME)
public interface IContactsClient extends ContactsConstant {

	@RequestMapping(value = CON_ORGALLLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> orgAllList(Map<String, Object> requestMap);

	@RequestMapping(value = CON_PRECANCELORG_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> preCancelOrgList(Map<String, Object> requestMap);

	@RequestMapping(value = CON_ORGEMPLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> orgEmpList(Map<String, Object> requestMap);

	@RequestMapping(value = CON_ORGEMP_EXPORT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> exportEmpToExcel(Map<String, Object> requestMap);

	@RequestMapping(value = CON_ORGEMP_PRINT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> orgEmpPrint(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIEND_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> empList(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIEND_EXPORT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> exportFriendToExcel(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIEND_PRINT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> friendPrint(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIEND_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> friendSave(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIEND_DEL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> friendDelete(Map<String, Object> requestMap);

	@RequestMapping(value = CON_FRIEND_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> friendSearch(Map<String, Object> requestMap);

	@RequestMapping(value = CON_EMPORGPOSITION, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> getOrgPosition(Map<String, Object> requestMap);

	@RequestMapping(value = CON_EMPWORKREDEPLOY, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> getWorkRedeploy(Map<String, Object> requestMap);

	@RequestMapping(value = CON_EMP_DETAILS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> getEmpName(Map<String, Object> requestMap);

	@RequestMapping(value = CON_EMP_ALLDETAILS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> selectEmpDetails(Map<String, Object> requestMap);

	@RequestMapping(value = CON_EMPDETAILS_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> updateEmpDetails(Map<String, Object> requestMap);

	@RequestMapping(value = CON_EMPDETAILS_EXPORT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> exportEmpDetailsToExcel(Map<String, Object> requestMap);

	@RequestMapping(value = CON_EMPDETAILS_PRINT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> empDetailsPrint(Map<String, Object> requestMap);

	@RequestMapping(value = CON_GROUP_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> friendGroupTree(Map<String, Object> requestMap);

	@RequestMapping(value = CON_GROUP_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> friendGroupSave(Map<String, Object> requestMap);

	@RequestMapping(value = CON_GROUP_DETAILS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> friendGroupDetails(Map<String, Object> requestMap);

	@RequestMapping(value = CON_GROUP_QUIT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> groupDismissOrQuit(Map<String, Object> requestMap);

	@RequestMapping(value = CON_GROUP_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> friendGroupUpdate(Map<String, Object> requestMap);

	@RequestMapping(value = CON_GROUP_MEMBER_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> groupMemList(Map<String, Object> requestMap);

	@RequestMapping(value = CON_GROUP_MEMBER_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> groupMemberSave(Map<String, Object> requestMap);

	@RequestMapping(value = CON_GROUP_MEMBER_DEL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> groupMemberDelete(Map<String, Object> requestMap);

	@RequestMapping(value = CON_GROUP_MEMBER_EXPORT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> exportGroupMemToExcel(Map<String, Object> requestMap);

	@RequestMapping(value = CON_EMP_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> commonEmpSearch(Map<String, Object> requestMap);

	@RequestMapping(value = CON_EMP_TREE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> moreMateSearchTree(Map<String, Object> requestMap);

	@RequestMapping(value = SELECTBY_ORG, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> selectByOrg(Map<String, Object> requestMap);

	/**
	 * 项目列表查询
	 * 
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = PROJECT_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> projectList(Map<String, Object> requestJson);

	/**
	 * 查询所有员工id
	 */
	@RequestMapping(value = SEARCHALL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> searchAll(Map<String, Object> requestJson);

	/**
	 * 发送im
	 */
	@RequestMapping(value = SEND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> send(Map<String, Object> requestJson);
}
