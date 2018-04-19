package com.zrt.gateway.web.sec.handle;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.api.client.sec.ISecUserClient;
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
public class HandController extends BaseController{

	@Resource(name = "HystrixSecUserClient")
	private ISecUserClient secUserClient;
	
	/**
	 * 新增员工
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addUser",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> addUser(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.addUser(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 查询职务
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchPosition",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> searchPosition(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.searchPosition(requestMap);
		return response(resultMap);
	}

	/**
	 * 新增部门
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addOrg",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> addOrg(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.addOrg(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 新增职务
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addPosition",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> addPosition(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.addPosition(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 查询部门
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchOrg",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> searchOrg(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.searchOrg(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 模糊查询部门
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commonSearchOrg",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> commonSearchOrg(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.commonSearchOrg(requestMap);
		return response(resultMap);
	}
}
