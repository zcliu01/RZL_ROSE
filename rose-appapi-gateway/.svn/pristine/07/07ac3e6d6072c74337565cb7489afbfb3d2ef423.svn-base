package com.zrt.gateway.web.infoPub;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.api.client.infopub.IInfoPubClient;
import com.zrt.gateway.web.base.BaseController;

@RestController
@RequestMapping(value="/v1.0/appInfoPub", produces = { "application/json;charset=UTF-8" })
public class InfoPubController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(InfoPubController.class);
	@Resource(name="HystrixInfoPubClient")
	private IInfoPubClient infoPubClient;
	
	
	
	/**
	 * 公示查询
	 */
	@RequestMapping(value = "/appSearch", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> appSearch(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的appInfoPubController中appSearch方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = infoPubClient.appSearch(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 
	 * 查询公示信息详情
	 */
	@RequestMapping(value = "/searchInfo", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> searchInfo(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的appInfoPubController中searchInfo方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = infoPubClient.searchInfo(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 
	 *公示类型查询
	 */
	@RequestMapping(value = "/state_search", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> state_search(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的appInfoPubController中state_search方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = infoPubClient.state_search(requestMap);
		return response(resultMap);
	}
	
	
}
