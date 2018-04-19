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
@RequestMapping("/v1.0/careInfor")
public class CareInforController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(CareInforController.class);
	@Resource(name = "HystrixInforClient")
	private IInforClient inforClient;

	/**
	 * 全部列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/careAllList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> careAllList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的CareInforController中careAllList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.careAllList(requestMap);
		return response(resultMap);
	}

	/**
	 * 待阅列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/careNoReadList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> careNoReadList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的CareInforController中careNoReadList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.careNoReadList(requestMap);
		return response(resultMap);
	}
	/**
	 * 已阅列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/careReadList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> careReadList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的CareInforController中careReadList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.careReadList(requestMap);
		return response(resultMap);
	}
	/**
	 * 已办列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/careDealList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> careDealList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的CareInforController中careDealList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.careDealList(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 已阅
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeCareRead", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> changeCareRead(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的CareInforController中changeCareRead方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.changeCareRead(requestMap);
		return response(resultMap);
	}
	/**
	 * 已办
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeCareDeal", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> changeCareDeal(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的CareInforController中changeCareDeal方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.changeCareDeal(requestMap);
		return response(resultMap);
	}
	/**
	 * 关注
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/careSchedule", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> careSchedule(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的CareInforController中careSchedule方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.careSchedule(requestMap);
		return response(resultMap);
	}
	/**
	 * 取消关注
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/careCancel", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> careCareCancel(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的CareInforController中careCareCancel方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.careCareCancel(requestMap);
		return response(resultMap);
	}
	/**
	 * 隐藏
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/hiddenCare", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> hiddenCare(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的CareInforController中hiddenCare方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.hiddenCare(requestMap);
		return response(resultMap);
	}
}
