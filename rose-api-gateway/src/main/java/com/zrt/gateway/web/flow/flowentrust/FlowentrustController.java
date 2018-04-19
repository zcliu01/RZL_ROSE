package com.zrt.gateway.web.flow.flowentrust;

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
@RequestMapping(value = "/v1.0/flowentrust", produces = { "application/json;charset=UTF-8" })
public class FlowentrustController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(FlowentrustController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 委托流程列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> list(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowentrustController中list方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.entrustList(requestMap);
		return response(resultMap);
	}

	/**
	 * 流程委托
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/ent", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> ent(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowentrustController中ent方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.ent(requestMap);
		return response(resultMap);
	}

	/**
	 * 取消流程委托
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> cancel(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowentrustController中cancel方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.cancel(requestMap);
		return response(resultMap);
	}

}
