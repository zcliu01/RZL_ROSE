package com.zrt.gateway.web.sec.user;

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
import com.zrt.gateway.api.client.sec.user.ISecUserClient;
import com.zrt.gateway.web.base.BaseController;

/**
 * 权限系统用户管理模块接口请求类
 * 
 * @author:wwfu
 * @date:2017年3月22日下午8:14:02
 * @description TODO
 */
@RestController
@RequestMapping(value="/v1.0/sec", produces = { "application/json;charset=UTF-8" })
public class SecUserController extends BaseController{

	@Resource(name = "HystrixSecUserClient")
	private ISecUserClient secUserClient;
	

	/**
	 * 用户信息查询
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/appUserSearch",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> appUserSearch(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = secUserClient.appUserSearch(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 用户信息更新
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/appUserUpdate",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> appUserUpdate(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = secUserClient.appUserUpdate(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 用户密码设置
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/appUserPwdSet",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> userPwdSet(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = secUserClient.appUserPwdSet(requestMap);
		return response(resultMap);
	}

	/**
	 * 个人详情
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/appMyDetails",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> appMyDetails(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = secUserClient.appMyDetails(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 个人详情修改
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/appUpdateEmpDetails",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> appUpdateEmpDetails(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = secUserClient.appUpdateEmpDetails(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 发票抬头查询
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/appSelectInvoiceTitle",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> appSelectInvoiceTitle(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = secUserClient.appSelectInvoiceTitle(requestMap);
		return response(resultMap);
	}
	
}
