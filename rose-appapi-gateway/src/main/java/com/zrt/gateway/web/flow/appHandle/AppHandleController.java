package com.zrt.gateway.web.flow.appHandle;

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
@RequestMapping(value = "/v1.0/appHandle", produces = { "application/json;charset=UTF-8" })
public class AppHandleController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(AppHandleController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 流程信息
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/instInfor", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> instInfor(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppHandleController中instInfor方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.instInfor(requestMap);
		return response(resultMap);
	}

	/**
	 * 签报审批
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/handleCheck", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> handleCheck(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppHandleController中handleCheck方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.handleCheck(requestMap);
		return response(resultMap);
	}

	/**
	 * 2.11.2 签报审批详情
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> detail(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppHandleController中detail方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.detail(requestMap);
		return response(resultMap);
	}

	/**
	 * 签报办结
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/handleEnd", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> handleEnd(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppHandleController中handleEnd方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.handleEnd(requestMap);
		return response(resultMap);
	}

	/**
	 * 签报流程草稿详情
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/draftDetail", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> draftDetail(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppHandleController中draftDetail方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.draftDetail(requestMap);
		return response(resultMap);
	}

	@RequestMapping(value = "/isHandle", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> isHandle(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppHandleController中isHandle方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.isHandle(requestMap);
		return response(resultMap);
	}

}
