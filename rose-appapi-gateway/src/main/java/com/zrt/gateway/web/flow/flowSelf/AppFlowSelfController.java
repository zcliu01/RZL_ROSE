package com.zrt.gateway.web.flow.flowSelf;

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
@RequestMapping(value = "/v1.0/appFlowself", produces = { "application/json;charset=UTF-8" })
public class AppFlowSelfController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(AppFlowSelfController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 我发起的流程列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selfApply", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> selfApply(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowSelfControl中selfApply方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.selfApply(requestMap);
		return response(resultMap);
	}

	/**
	 * 我的待办
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selfDoList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> selfDoList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowSelfControl中selfDoList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.selfDoList(requestMap);
		return response(resultMap);
	}

	/**
	 * 我的已办
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selfHasDoList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> selfHasDoList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowSelfControl中selfHasDoList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.selfHasDoList(requestMap);
		return response(resultMap);
	}

	/**
	 * 会签审批
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selfSign", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> selfSign(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowSelfControl中selfSign方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.selfSign(requestMap);
		return response(resultMap);
	}

	/**
	 * 审批
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> check(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowSelfControl中check方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.check(requestMap);
		return response(resultMap);
	}

	/**
	 * 审批
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selfApplyRes", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> selfApplyRes(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowSelfControl中selfApplyRes方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.selfApplyRes(requestMap);
		return response(resultMap);
	}

}
