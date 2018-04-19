package com.zrt.gateway.api.client.sec;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(SecUserConstant.SEC_INSTANCE)
public interface ISecUserClient extends SecUserConstant {

	@RequestMapping(value = SEC_USERLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> userList(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_USERSEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> userSearch(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_USERSAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> userSave(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_USERUPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> userUpdate(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_USERDELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> userDelete(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_USERROLELIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> userRoleList(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_USERROLESAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> userRoleSave(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_USERPWDRESET, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> userPwdReSet(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_USERPWDSET, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> userPwdSet(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_EMPLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> empList(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ORGALLLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> OrgAllList(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ORG_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> orgSearch(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ORG_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> orgUpdate(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ORGNAME_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> orgNameSearch(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_LOGIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> login(Map<String, Object> requestMap);

	@RequestMapping(value = TEST_LOGIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> testLogin(Map<String, Object> requestMap);

	@RequestMapping(value = NOVPN_LOGIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> noVpnLogin(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_LOGIN_CHECK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> loginCheck(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_USERSTATUSUPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> userStatusUpdate(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ROLELIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleList(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ROLESAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleSave(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ROLEUPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleUpdate(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ROLEDELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleDelete(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ROLEUSERLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleUserList(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ROLEMENULIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleMenuList(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ROLEMENURESOURCELIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleResourceSearch(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ROLERESOURCELINK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleResourceSet(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ROLEEMPDELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleEmpDelete(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ROLEEMPBATCHDELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleEmpBatchDelete(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ORG_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> orgList(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ORG_CANCEL_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> preCancelOrgList(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ROLE_ALL_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleAllList(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_USER_ROLE_BATCH_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> userRoleBatchSave(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_USER_PWD_BATCH_RESET, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> userPwdBatchReSet(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_RELATION_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> relationSearch(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_RELATION_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> relationUpdate(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ROLE_EMP_ADD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleEmpAdd(Map<String, Object> requestMap);

	@RequestMapping(value = CHECK_SEC_ROLE_ALL_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> checkRoleAllList(Map<String, Object> requestMap);

	@RequestMapping(value = CHECK_SEC_ROLELIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> checkRoleList(Map<String, Object> requestMap);

	@RequestMapping(value = CHECK_SEC_ROLESEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> checkRoleSearch(Map<String, Object> requestMap);

	@RequestMapping(value = CHECK_SEC_ROLESAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> checkRoleSave(Map<String, Object> requestMap);

	@RequestMapping(value = CHECK_SEC_ROLEUPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> checkRoleupdate(Map<String, Object> requestMap);

	@RequestMapping(value = CHECK_SEC_ROLEDELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> checkRoledelete(Map<String, Object> requestMap);

	@RequestMapping(value = CHECK_SEC_ROLEUSERLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> checkRoleuserlist(Map<String, Object> requestMap);

	@RequestMapping(value = CHECK_SEC_ROLE_EMP_ADD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> checkRoleEmpAdd(Map<String, Object> requestMap);

	@RequestMapping(value = CHECK_SEC_ROLEEMPDELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> checkRoleempdelete(Map<String, Object> requestMap);

	@RequestMapping(value = CHECK_SEC_ROLEEMPBATCHDELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> checkRoleempbatchdelete(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ROLE_EMP_SYNC, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> userSync(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_SEC_ROLE_ALL_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowRoleAllList(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_SEC_ROLELIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowRoleList(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_SEC_ROLESEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowRoleSearch(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_SEC_ROLESAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowRoleSave(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_SEC_ROLEUPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowRoleupdate(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_SEC_ROLEDELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowRoledelete(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_SEC_ROLEUSERLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowRoleuserlist(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_SEC_ROLE_EMP_ADD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowRoleEmpAdd(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_SEC_ROLEEMPDELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowRoleempdelete(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_SEC_ROLEEMPBATCHDELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowRoleempbatchdelete(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_ROLE_FLOW_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleFlowList(Map<String, Object> requestMap);

	@RequestMapping(value = FLOW_ROLE_FLOW_SET, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleFlowSet(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ADDUSER, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> addUser(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_SEARCHPOSITION, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> searchPosition(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ADDORG, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> addOrg(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_ADDPOSITION, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> addPosition(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_SEARCHORG, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> searchOrg(Map<String, Object> requestMap);

	@RequestMapping(value = SEC_COMMONSEARCHORG, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> commonSearchOrg(Map<String, Object> requestMap);
	@RequestMapping(value = LOGIN_TYPESET, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> loginTypeSet(Map<String, Object> requestMap);

}
