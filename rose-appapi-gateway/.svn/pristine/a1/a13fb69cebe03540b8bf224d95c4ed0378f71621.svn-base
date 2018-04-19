package com.zrt.gateway.web.flow.flowcare;

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
import com.zrt.gateway.api.client.flow.IFlowClient;
import com.zrt.gateway.web.base.BaseController;

/**
 * 我的关注
 * 
 * @author:dwliu
 * @date:2017年3月22日下午8:14:02
 * @description TODO
 */
@RestController
@RequestMapping(value = "/v1.0/appFlowself", produces = { "application/json;charset=UTF-8" })
public class AppFlowcareController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(AppFlowcareController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 我的关注
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/careList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> careList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowcareController中careList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.careList(requestMap);
		return response(resultMap);
	}

	/**
	 * 添加关注
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/careSave", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> careSave(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowcareController中careSave方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.careSave(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 关注取消
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/careCancle",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> careCancle(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id) throws Exception {
		log.info("Server端的AppFlowcareController中careCancle方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = flowClient.careCancle(requestMap);
		return response(resultMap);
	}
}
