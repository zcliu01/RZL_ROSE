package com.zrt.gateway.api.client.sec;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.gateway.api.AbstactHystrixClient;
import com.zrt.gateway.api.ExceptionDeal;

@Service("HystrixSecUserClient")
public class HystrixSecUserClient extends AbstactHystrixClient implements ISecUserClient {

	@Autowired
	private ISecUserClient secUserClient;

	private Logger logger = LoggerFactory.getLogger(ISecUserClient.class);

	public Map<String, Object> fallback(Map<String, Object> requestJson, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		return ExceptionDeal.fallback(SecUserConstant.SEC_INSTANCE, requestJson, e);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> userList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.userList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> userSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.userSearch(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> userSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.userSave(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> userUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.userUpdate(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> userDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.userDelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> userRoleList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.userRoleList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> userRoleSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.userRoleSave(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> userPwdReSet(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.userPwdReSet(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> userPwdSet(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.userPwdSet(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> empList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.empList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> OrgAllList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.OrgAllList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> orgSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.orgSearch(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> orgUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.orgUpdate(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> orgNameSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.orgNameSearch(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> login(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.login(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> testLogin(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.testLogin(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> noVpnLogin(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.noVpnLogin(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> loginCheck(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.loginCheck(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> userStatusUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.userStatusUpdate(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> roleList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.roleList(requestMap);

	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> roleSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.roleSave(requestMap);

	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> roleUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.roleUpdate(requestMap);

	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> roleDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.roleDelete(requestMap);

	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> roleUserList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.roleUserList(requestMap);

	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> roleMenuList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.roleMenuList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> roleResourceSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.roleResourceSearch(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> roleResourceSet(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.roleResourceSet(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> roleEmpDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.roleEmpDelete(requestMap);

	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> roleEmpBatchDelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.roleEmpBatchDelete(requestMap);

	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> orgList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.orgList(requestMap);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> preCancelOrgList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.preCancelOrgList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> roleAllList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.roleAllList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> userRoleBatchSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.userRoleBatchSave(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> userPwdBatchReSet(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.userPwdBatchReSet(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> relationSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.relationSearch(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> relationUpdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.relationUpdate(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> roleEmpAdd(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.roleEmpAdd(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> checkRoleAllList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.checkRoleAllList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> checkRoleList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.checkRoleList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> checkRoleSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.checkRoleSearch(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> checkRoleSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.checkRoleSave(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> checkRoleupdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.checkRoleupdate(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> checkRoledelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.checkRoledelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> checkRoleuserlist(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.checkRoleuserlist(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> checkRoleEmpAdd(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.checkRoleEmpAdd(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> checkRoleempdelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.checkRoleempdelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> checkRoleempbatchdelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.checkRoleempbatchdelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> userSync(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.userSync(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowRoleAllList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.flowRoleAllList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowRoleList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.flowRoleList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowRoleSearch(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.flowRoleSearch(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowRoleSave(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.flowRoleSave(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowRoleupdate(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.flowRoleupdate(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowRoledelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.flowRoledelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowRoleuserlist(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.flowRoleuserlist(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowRoleEmpAdd(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.flowRoleEmpAdd(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowRoleempdelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.flowRoleempdelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> flowRoleempbatchdelete(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.flowRoleempbatchdelete(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> roleFlowList(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.roleFlowList(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> roleFlowSet(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.roleFlowSet(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> addUser(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.addUser(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> searchPosition(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.searchPosition(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> addOrg(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.addOrg(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> addPosition(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.addPosition(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> searchOrg(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.searchOrg(requestMap);
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> commonSearchOrg(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.commonSearchOrg(requestMap);
	}
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	@Override
	public Map<String, Object> loginTypeSet(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return secUserClient.loginTypeSet(requestMap);
	}

}
