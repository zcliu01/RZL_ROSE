package com.zrt.gateway.web.pc.vm;

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
import com.zrt.gateway.api.client.vm.IVmClient;
import com.zrt.gateway.web.base.BaseController;

/**
 * 会议管理模块接口请求类
 * 
 * @author:
 * @date:
 * @description TODO
 */

@RestController
@RequestMapping(value = "/v1.0/pcVmoper", produces = { "application/json;charset=UTF-8" })
public class PcVmOperController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(PcVmOperController.class);
	@Resource(name = "HystrixVmClient")
	private IVmClient vmClient;

	/**
	 * 发起即时会议
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/launch", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> launch(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VmOperController中launch方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.launch(requestMap);
		return response(resultMap);
	}

	/**
	 * 发起人入会
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/inMeeting", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inMeeting(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VmOperController中inMeeting方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.inMeeting(requestMap);
		return response(resultMap);
	}

	/**
	 * 会议临时加人
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addPerson", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> addPerson(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VmOperController中addPerson方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.addPerson(requestMap);
		return response(resultMap);
	}

	/**
	 * 参会人会议响应通知
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/isJoin", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> isJoin(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VmOperController中isJoin方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.isJoin(requestMap);
		return response(resultMap);
	}

	/**
	 * 退出通知
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/quit", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> quit(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VmOperController中quit方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.quit(requestMap);
		return response(resultMap);
	}

	/**
	 * 会议是否结束
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/isEnd", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> isEnd(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VmOperController中isEnd方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.isEnd(requestMap);
		return response(resultMap);
	}

}
