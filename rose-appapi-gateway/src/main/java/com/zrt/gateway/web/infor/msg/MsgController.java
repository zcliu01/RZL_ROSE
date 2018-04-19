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
@RequestMapping(value = "/v1.0/appInforInner", produces = { "application/json;charset=UTF-8" })
public class MsgController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(MsgController.class);
	@Resource(name = "HystrixInforClient")
	private IInforClient inforClient;

	/**
	 * 收件箱信息
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforReceiveList(@RequestBody Map<String, Object> appMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的MsgController中inforList方法");
		setEmpId(emp_id, appMap);
		Map<String, Object> resultMap = inforClient.inforReceiveList(appMap);
		return response(resultMap);
	}

	/**
	 * 已办、已阅讯息
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDeal", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforDeal(@RequestBody Map<String, Object> appMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的MsgController中inforDeal方法");
		setEmpId(emp_id, appMap);
		Map<String, Object> resultMap = inforClient.inforDeal(appMap);
		return response(resultMap);
	}

	/**
	 * 隐藏、显示讯息
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforShowHid", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforShowHid(@RequestBody Map<String, Object> appMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的MsgController中inforShowHid方法");
		setEmpId(emp_id, appMap);
		Map<String, Object> resultMap = inforClient.inforShowHid(appMap);
		return response(resultMap);
	}

	/**
	 * 讯息详情
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDetail", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforDetail(@RequestBody Map<String, Object> appMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的MsgController中inforDetail方法");
		setEmpId(emp_id, appMap);
		Map<String, Object> resultMap = inforClient.inforDetail(appMap);
		return response(resultMap);
	}

	/**
	 * 草稿发送
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDraftSend", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforDraftSend(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的MsgController中inforDraftSend方法");
		Map<String, Object> resultMap = inforClient.inforDraftSend(appMap);
		return response(resultMap);
	}

	/**
	 * 草稿删除
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDraftDelete", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforDraftDelete(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的MsgController中inforDraftDelete方法");
		Map<String, Object> resultMap = inforClient.inforDraftDelete(appMap);
		return response(resultMap);
	}

	/**
	 * 获取待阅标识
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforCountFlag", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforCountFlag(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的MsgController中inforCountFlag方法");
		Map<String, Object> resultMap = inforClient.inforCountFlag(appMap);
		return response(resultMap);
	}

}
