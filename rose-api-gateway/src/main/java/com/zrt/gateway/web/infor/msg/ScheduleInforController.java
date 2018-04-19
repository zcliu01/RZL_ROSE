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
@RequestMapping("/v1.0/scheduleInfor")
public class ScheduleInforController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(ScheduleInforController.class);
	@Resource(name = "HystrixInforClient")
	private IInforClient inforClient;

	/**
	 * 全部列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/scheduleAllList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> scheduleAllList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ScheduleInforController中scheduleAllList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.scheduleAllList(requestMap);
		return response(resultMap);
	}

	/**
	 * 待阅列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/scheduleNoReadList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> scheduleNoReadList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ScheduleInforController中scheduleNoReadList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.scheduleNoReadList(requestMap);
		return response(resultMap);
	}
	/**
	 * 已阅列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/scheduleReadList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> scheduleReadList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ScheduleInforController中scheduleReadList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.scheduleReadList(requestMap);
		return response(resultMap);
	}
	/**
	 * 已办列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/scheduleDealList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> scheduleDealList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ScheduleInforController中scheduleDealList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.scheduleDealList(requestMap);
		return response(resultMap);
	}
	/**
	 * 关注列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/scheduleCareList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> scheduleCareList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ScheduleInforController中scheduleCareList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.scheduleCareList(requestMap);
		return response(resultMap);
	}
	/**
	 * 已阅
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeScheduleRead", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> changeScheduleRead(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ScheduleInforController中changeScheduleRead方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.changeScheduleRead(requestMap);
		return response(resultMap);
	}
	/**
	 * 已办
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeScheduleDeal", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> changeScheduleDeal(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ScheduleInforController中changeScheduleDeal方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.changeScheduleDeal(requestMap);
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
		log.info("Server端的ScheduleInforController中careSchedule方法");
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
	public ResponseEntity<String> scheduleCareCancel(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ScheduleInforController中scheduleCareCancel方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.scheduleCareCancel(requestMap);
		return response(resultMap);
	}
	/**
	 * 隐藏
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/hiddenSchedule", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> hiddenSchedule(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ScheduleInforController中hiddenSchedule方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.hiddenSchedule(requestMap);
		return response(resultMap);
	}
}
