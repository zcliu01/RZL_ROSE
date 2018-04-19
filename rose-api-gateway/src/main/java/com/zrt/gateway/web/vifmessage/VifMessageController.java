package com.zrt.gateway.web.vifmessage;

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
import com.zrt.gateway.api.client.vifmessage.IVifMessageClient;
import com.zrt.gateway.web.base.BaseController;

@RestController
@RequestMapping(value="/v1.0/APPmessage", produces = { "application/json;charset=UTF-8" })
public class VifMessageController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(VifMessageController.class);
	@Resource(name="HystrixVifMessageClient")
	private IVifMessageClient vifMessageClient;
	
	
	
	/**
	 * 财务待办消息查询
	 * 
	 */
	@RequestMapping(value = "/backlog", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> backlog(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VifMessageController中backlog方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vifMessageClient.backlog(requestMap);
		return response(resultMap);
	}
	
	/**
	 * EAS待办消息查询
	 * 
	 */
	@RequestMapping(value = "/backlogByEas", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> backlogByEas(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VifMessageController中backlogByEas方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vifMessageClient.backlogByEas(requestMap);
		return response(resultMap);
	}
	
}
