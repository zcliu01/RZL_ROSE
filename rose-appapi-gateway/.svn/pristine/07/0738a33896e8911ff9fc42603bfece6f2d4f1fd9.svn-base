package com.zrt.gateway.web.sec.appUpgrade;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
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
@RequestMapping(value = "/v1.0/appUpgrade", produces = { "application/json;charset=UTF-8" })
public class AppupgradeController extends BaseController {

	@Resource(name = "HystrixSecUserClient")
	private ISecUserClient secUserClient;

	@RequestMapping(value = "/checkUpdate", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> checkUpdate(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String, Object> resultMap = secUserClient.checkUpdate(requestMap);
		return response(resultMap);
	}

}
