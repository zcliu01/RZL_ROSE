package com.zrt.gateway.web.flow.flowdraft;

import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.api.client.flow.IFlowClient;
import com.zrt.gateway.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 我的草稿
 * 
 * @author:dwliu
 * @date:2017年3月22日下午8:14:02
 * @description TODO
 */
@RestController
@RequestMapping(value = "/v1.0/appFlowdraft", produces = { "application/json;charset=UTF-8" })
public class AppFlowdraftController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(AppFlowdraftController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 我的草稿
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> list(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowdraftController中list方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.draftList(requestMap);
		return response(resultMap);
	}

	/**
	 * 草稿发送
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/send", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> send(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowdraftController中send方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.send(requestMap);
		return response(resultMap);
	}

	/**
	 * 草稿删除
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/draftDelete", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> draftDelete(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowdraftController中draftDelete方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.draftDelete(requestMap);
		return response(resultMap);
	}

	/**
	 * 草稿详情
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/draftDetail", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> draftDetail(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowdraftController中draftDetail方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.draftDetail(requestMap);
		return response(resultMap);
	}

}
