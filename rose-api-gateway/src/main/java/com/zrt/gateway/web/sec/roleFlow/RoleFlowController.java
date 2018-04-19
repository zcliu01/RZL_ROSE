package com.zrt.gateway.web.sec.roleFlow;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.api.client.sec.ISecUserClient;
import com.zrt.gateway.web.base.BaseController;
@RestController
@RequestMapping(value="/v1.0/secFlow", produces = { "application/json;charset=UTF-8" })
public class RoleFlowController extends BaseController{
	@Resource(name = "HystrixSecUserClient")
	private ISecUserClient secUserClient;
	/**
	 * 角色列表查询
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/roleList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleList(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.flowRoleList(requestMap);
		return response(resultMap);
	}
	
	@RequestMapping(value = "/roleSave",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleSave(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.flowRoleSave(requestMap);
		return response(resultMap);
	}
	
	@RequestMapping(value = "/roleUpdate",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleUpdate(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.flowRoleupdate(requestMap);
		return response(resultMap);
	}
	@RequestMapping(value = "/roleDelete",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleDelete(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.flowRoledelete(requestMap);
		return response(resultMap);
	}
	@RequestMapping(value = "/roleUserList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleUserList(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.flowRoleuserlist(requestMap);
		return response(resultMap);
	}
	
	@RequestMapping(value = "/roleEmpDelete",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleEmpDelete(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.flowRoleempdelete(requestMap);
		return response(resultMap);
	}
	@RequestMapping(value = "/roleEmpBatchDelete",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleEmpBatchDelete(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.flowRoleempbatchdelete(requestMap);
		return response(resultMap);
	}
	
	@RequestMapping(value = "/roleAllList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleAllList(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.flowRoleAllList(requestMap);
		return response(resultMap);
	}
	
	@RequestMapping(value = "/roleEmpAdd",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleEmpAdd(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.flowRoleEmpAdd(requestMap);
		return response(resultMap);
	}
	
	@RequestMapping(value = "/roleSearch",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleSearch(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.flowRoleSearch(requestMap);
		return response(resultMap);
	}
	@RequestMapping(value = "/roleFlowList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleFlowList(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.roleFlowList(requestMap);
		return response(resultMap);
	}
	@RequestMapping(value = "/roleFlowSet",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleFlowSet(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.roleFlowSet(requestMap);
		return response(resultMap);
	}
}
