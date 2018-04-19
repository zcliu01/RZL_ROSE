package com.zrt.gateway.web.flow.flowfboper;

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
 * 流程管理
 * 
 * @author:
 * @date:
 * @description TODO
 */

@RestController
@RequestMapping(value = "/v1.0/flowfboper", produces = { "application/json;charset=UTF-8" })
public class FlowfboperController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(FlowfboperController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 运行流程列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/runList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> runList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowfboperController中runList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.runList(requestMap);
		return response(resultMap);
	}

	@RequestMapping(value = "/applyList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> applyList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowfboperController中applyList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.applyList(requestMap);
		return response(resultMap);
	}

	/**
	 * 运行流程明细
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/runFlowDetail", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> save(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowfboperController中runFlowDetail方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.runFlowDetail(requestMap);
		return response(resultMap);
	}

	/**
	 * 停用流程列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/stopList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> stopList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowfboperController中stopList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.stopList(requestMap);
		return response(resultMap);
	}

	/**
	 * 停用流程明细
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/stopFlowDetail", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> stopFlowDetail(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的FlowfboperController中stopFlowDetail方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.stopFlowDetail(requestMap);
		return response(resultMap);
	}

}
