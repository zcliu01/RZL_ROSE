package com.zrt.gateway.web.infor.msg;

import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/v1.0/documentInfor")
public class DocumentInforController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(DocumentInforController.class);
	@Resource(name = "HystrixInforClient")
	private IInforClient inforClient;

	/**
	 * 全部列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/documentAllList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> documentAllList(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的DocumentInforController中documentAllList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.documentAllList(requestMap);
		return response(resultMap);
	}

	/**
	 * 待阅列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/documentNoReadList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> documentNoReadList(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的DocumentInforController中documentNoReadList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.documentNoReadList(requestMap);
		return response(resultMap);
	}

	/**
	 * 已阅列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/documentReadList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> documentReadList(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的DocumentInforController中documentReadList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.documentReadList(requestMap);
		return response(resultMap);
	}

	/**
	 * 已办列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/documentDealList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> documentDealList(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的DocumentInforController中documentDealList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.documentDealList(requestMap);
		return response(resultMap);
	}

	/**
	 * 关注列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/documentCareList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> documentCareList(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的DocumentInforController中documentCareList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.documentCareList(requestMap);
		return response(resultMap);
	}

	/**
	 * 已阅
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeDocumentRead", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> changeDocumentRead(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的DocumentInforController中changeDocumentRead方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.changeDocumentRead(requestMap);
		return response(resultMap);
	}

	/**
	 * 已办
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeDocumentDeal", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> changeDocumentDeal(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的DocumentInforController中changeDocumentDeal方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.changeDocumentDeal(requestMap);
		return response(resultMap);
	}

	/**
	 * 关注
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/careDocument", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> careDocument(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的DocumentInforController中careDocument方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.careDocument(requestMap);
		return response(resultMap);
	}

	/**
	 * 取消关注
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/careCancel", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> documentCareCancel(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的DocumentInforController中documentCareCancel方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.documentCareCancel(requestMap);
		return response(resultMap);
	}

	/**
	 * 隐藏
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/hiddenDocument", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> hiddenDocument(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的DocumentInforController中hiddenDocument方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.hiddenDocument(requestMap);
		return response(resultMap);
	}
}
