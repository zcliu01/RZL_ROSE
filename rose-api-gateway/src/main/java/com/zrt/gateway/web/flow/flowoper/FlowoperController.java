package com.zrt.gateway.web.flow.flowoper;

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
@RequestMapping(value = "/v1.0/flowoper", produces = { "application/json;charset=UTF-8" })
public class FlowoperController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(FlowoperController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 管理员查询所有流程列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/flowList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> flowList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowoperController中flowList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.flowList(requestMap);
		return response(resultMap);
	}
	/**
	 * 管理员查询所有委托流程列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/entList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> entList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowoperController中entList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.entList(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 管理员查询所有预处理流程列表
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/operPreList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> operPreList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowoperController中operPreList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.operPreList(requestMap);
		return response(resultMap);
	}

}
