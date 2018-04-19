package com.zrt.gateway.web.infor.msg;

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
import com.zrt.gateway.api.client.infor.IInforClient;
import com.zrt.gateway.web.base.BaseController;

@RestController
@RequestMapping("/v1.0/flowInfor")
public class FlowInforController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(FlowInforController.class);
	@Resource(name = "HystrixInforClient")
	private IInforClient inforClient;

	/**
	 * 全部列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/flowAllList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> flowAllList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowInforController中flowAllList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.flowAllList(requestMap);
		return response(resultMap);
	}

	/**
	 * 待阅列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/flowNoReadList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> flowNoReadList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowInforController中flowNoReadList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.flowNoReadList(requestMap);
		return response(resultMap);
	}
	/**
	 * 已阅列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/flowReadList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> flowReadList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowInforController中flowReadList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.flowReadList(requestMap);
		return response(resultMap);
	}
	/**
	 * 已办列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/flowDealList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> flowDealList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowInforController中flowDealList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.flowDealList(requestMap);
		return response(resultMap);
	}
	/**
	 * 关注列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/flowCareList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> flowCareList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowInforController中flowCareList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.flowCareList(requestMap);
		return response(resultMap);
	}
	/**
	 * 已阅
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeFlowRead", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> changeFlowRead(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowInforController中changeFlowRead方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.changeFlowRead(requestMap);
		return response(resultMap);
	}
	/**
	 * 已办
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeFlowDeal", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> changeFlowDeal(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowInforController中changeFlowDeal方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.changeFlowDeal(requestMap);
		return response(resultMap);
	}
	/**
	 * 关注
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/careFlow", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> careFlow(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowInforController中careFlow方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.careFlow(requestMap);
		return response(resultMap);
	}
	/**
	 * 取消关注
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/careCancel", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> careCancel(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowInforController中careCancel方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.careCancel(requestMap);
		return response(resultMap);
	}
	/**
	 * 隐藏
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/hiddenFlow", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> hiddenFlow(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FlowInforController中hiddenFlow方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.hiddenFlow(requestMap);
		return response(resultMap);
	}
}
