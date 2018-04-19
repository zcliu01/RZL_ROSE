package com.zrt.gateway.web.flow.flowpre;

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

@RestController
@RequestMapping(value = "/v1.0/flowpre", produces = { "application/json;charset=UTF-8" })
public class FlowpreController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(FlowpreController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 我的预处理流程列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selfList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> selfList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowpreController中selfList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.preList(requestMap);
		return response(resultMap);
	}
	/**
	 * 流程预处理同意/拒绝
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deal", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> deal(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowpreController中deal方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.deal(requestMap);
		return response(resultMap);
	}
	/**
	 * 流程预处理取消
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> cancel(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowpreController中cancel方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.preCancel(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 流程预处理取消
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> flowPreList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowpreController中cancel方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.flowPreList(requestMap);
		return response(resultMap);
	}

}
