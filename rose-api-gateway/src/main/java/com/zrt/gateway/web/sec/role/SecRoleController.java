package com.zrt.gateway.web.sec.role;

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
@RequestMapping(value="/v1.0/sec", produces = { "application/json;charset=UTF-8" })
public class SecRoleController extends BaseController{
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
		Map<String,Object>  resultMap =  secUserClient.roleList(requestMap);
		return response(resultMap);
	}
	
	@RequestMapping(value = "/roleSave",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleSave(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.roleSave(requestMap);
		return response(resultMap);
	}
	
	@RequestMapping(value = "/roleUpdate",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleUpdate(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.roleUpdate(requestMap);
		return response(resultMap);
	}
	@RequestMapping(value = "/roleDelete",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleDelete(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.roleDelete(requestMap);
		return response(resultMap);
	}
	@RequestMapping(value = "/roleUserList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleUserList(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.roleUserList(requestMap);
		return response(resultMap);
	}
	
	@RequestMapping(value = "/roleMenuList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleMenuList(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.roleMenuList(requestMap);
		return response(resultMap);
	}
	
	@RequestMapping(value = "/roleResourceSearch",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleResourceSearch(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.roleResourceSearch(requestMap);
		return response(resultMap);
	}
	
	@RequestMapping(value = "/roleResourceSet",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleResourceSet(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.roleResourceSet(requestMap);
		return response(resultMap);
	}
	
	@RequestMapping(value = "/roleEmpDelete",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleEmpDelete(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.roleEmpDelete(requestMap);
		return response(resultMap);
	}
	@RequestMapping(value = "/roleEmpBatchDelete",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleEmpBatchDelete(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.roleEmpBatchDelete(requestMap);
		return response(resultMap);
	}
	
	@RequestMapping(value = "/roleAllList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleAllList(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.roleAllList(requestMap);
		return response(resultMap);
	}
	
	@RequestMapping(value = "/roleEmpAdd",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> roleEmpAdd(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		Map<String,Object>  resultMap =  secUserClient.roleEmpAdd(requestMap);
		return response(resultMap);
	}
}
