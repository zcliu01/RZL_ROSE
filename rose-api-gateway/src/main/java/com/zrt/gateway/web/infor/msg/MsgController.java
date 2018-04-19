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
@RequestMapping(value = "/v1.0/inforInner", produces = { "application/json;charset=UTF-8" })
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
	@RequestMapping(value = "/inforReceiveList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforReceiveList(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的MsgController中inforReceiveList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.inforReceiveList(requestMap);
		return response(resultMap);
	}

	/**
	 * 发件箱信息
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforSendList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforSendList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的MsgController中inforSendList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.inforSendList(requestMap);
		return response(resultMap);
	}

	/**
	 * 全部讯息
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的MsgController中inforList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.inforList(requestMap);
		return response(resultMap);
	}

	/**
	 * 内部讯息
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforAllList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforAllList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的MsgController中inforAllList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.inforAllList(requestMap);
		return response(resultMap);
	}

	/**
	 * 草稿
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDraftList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforDraftList(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的MsgController中inforDraftList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.inforDraftList(requestMap);
		return response(resultMap);
	}

	/**
	 * 已关注
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforCareList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforCareList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的MsgController中inforCareList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.inforCareList(requestMap);
		return response(resultMap);
	}

	/**
	 * 待阅
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforWillList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforWillList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的MsgController中inforWillList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.inforWillList(requestMap);
		return response(resultMap);
	}

	/**
	 * 已阅
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforHasReadList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforHasReadList(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的MsgController中inforHasReadList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.inforHasReadList(requestMap);
		return response(resultMap);
	}

	/**
	 * 已办
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforHasDealList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforHasDealList(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的MsgController中inforHasDealList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.inforHasDealList(requestMap);
		return response(resultMap);
	}

	/**
	 * 已办
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDraftDelete", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforDraftDelete(@RequestBody Map<String, Object> requestMap) throws Exception {
		log.info("Server端的MsgController中inforDraftDelete方法");
		Map<String, Object> resultMap = inforClient.inforDraftDelete(requestMap);
		return response(resultMap);
	}

	/**
	 * 已办
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDraftBatchDelete", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforDraftBatchDelete(@RequestBody Map<String, Object> requestMap) throws Exception {
		log.info("Server端的MsgController中inforDraftBatchDelete方法");
		Map<String, Object> resultMap = inforClient.inforDraftBatchDelete(requestMap);
		return response(resultMap);
	}

	/**
	 * 发送草稿
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDraftSend", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforDraftSend(@RequestBody Map<String, Object> requestMap) throws Exception {
		log.info("Server端的MsgController中inforDraftSend方法");
		Map<String, Object> resultMap = inforClient.inforDraftSend(requestMap);
		return response(resultMap);
	}

	/**
	 * 批量发送草稿
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDrafBatchSend", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforDrafBatchSend(@RequestBody Map<String, Object> requestMap) throws Exception {
		log.info("Server端的MsgController中inforDrafBatchSend方法");
		Map<String, Object> resultMap = inforClient.inforDrafBatchSend(requestMap);
		return response(resultMap);
	}
	

}
