package com.zrt.gateway.web.sec.login;

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
 * 权限系统登录模块接口请求类
 * 
 * @author:wwfu
 * @date:2017年3月22日下午8:14:02
 * @description TODO
 */
@RestController
@RequestMapping(value = "/v1.0/sec", produces = { "application/json;charset=UTF-8" })
public class SecLoginController extends BaseController {

	@Resource(name = "HystrixSecUserClient")
	private ISecUserClient secUserClient;

	/**
	 * 登录
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String, Object> resultMap = secUserClient.login(requestMap);
		return response(resultMap);
	}

	@RequestMapping(value = "/testLogin", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> testLogin(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String, Object> resultMap = secUserClient.testLogin(requestMap);
		return response(resultMap);
	}

}
