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
@RequestMapping("/v1.0/appInforRecord")
public class AppInforRecordController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(AppInforRecordController.class);

	@Resource(name = "HystrixInforClient")
	private IInforClient inforClient;

	/**
	 * 新建讯息
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveAndSendInfor", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> saveAndSendInfor(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的AppInforRecordController中saveAndSendInfor方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.saveAndSendInfor(requestMap);
		return response(resultMap);
	}

	/**
	 * 保存草稿
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveInfor", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> saveInfor(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppInforRecordController中saveInfor方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.saveInfor(requestMap);
		return response(resultMap);
	}

	/**
	 * 回复讯息
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/relayInfor", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> relayInfor(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppInforRecordController中relayInfor方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.relayInfor(requestMap);
		return response(resultMap);
	}

	/**
	 * 转发讯息
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/transmitInfor", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> transmitInfor(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppInforRecordController中transmitInfor方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.transmitInfor(requestMap);
		return response(resultMap);
	}
	/**
	 * 修改个人资料发送讯息
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/sendUpdateInfor", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> sendUpdateInfor(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppInforRecordController中sendUpdateInfor方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.sendUpdateInfor(requestMap);
		return response(resultMap);
	}
}
