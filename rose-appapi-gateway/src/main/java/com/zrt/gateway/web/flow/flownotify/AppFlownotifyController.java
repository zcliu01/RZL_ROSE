package com.zrt.gateway.web.flow.flownotify;

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
 * 知会
 * 
 * @author:dwliu
 * @date:2017年3月22日下午8:14:02
 * @description TODO
 */
@RestController
@RequestMapping(value = "/v1.0/appFlownotify", produces = { "application/json;charset=UTF-8" })
public class AppFlownotifyController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(AppFlownotifyController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 知会我的
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/notifyList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> notifyList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlownotifyController中notifyList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.notifyList(requestMap);
		return response(resultMap);
	}

	/**
	 * 我知会的
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selfList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> selfList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlownotifyController中selfList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.selfList(requestMap);
		return response(resultMap);
	}

	/**
	 * 知会
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/notify", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> notify(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlownotifyController中notify方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.notify(requestMap);
		return response(resultMap);
	}
}
