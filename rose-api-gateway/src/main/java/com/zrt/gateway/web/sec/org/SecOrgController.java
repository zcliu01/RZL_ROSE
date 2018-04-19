package com.zrt.gateway.web.sec.org;

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
public class SecOrgController extends BaseController{

	@Resource(name = "HystrixSecUserClient")
	private ISecUserClient secUserClient;
	
	/**
	 * 机构树列表查询
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/orgAllList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> orgAllList(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.OrgAllList(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 机构信息查询
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/orgSearch",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> orgSearch(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.orgSearch(requestMap);
		return response(resultMap);
	}

	/**
	 * 机构信息查询
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/orgUpdate",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> orgUpdate(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.orgUpdate(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 机构名称模糊检索
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/orgNameSearch",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> orgNameSearch(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.orgNameSearch(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 机构列表查询
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/orgList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> orgList(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.orgList(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 机构待撤销列表查询
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/preCancelOrgList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> preCancelOrgList(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.preCancelOrgList(requestMap);
		return response(resultMap);
	}
}
