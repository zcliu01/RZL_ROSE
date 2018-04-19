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
@RequestMapping("/v1.0/publicityInfor")
public class PublicityInforController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(PublicityInforController.class);
	@Resource(name = "HystrixInforClient")
	private IInforClient inforClient;

	/**
	 * 全部列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/publicityAllList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> publicityAllList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的PublicityInforController中publicityAllList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.publicityAllList(requestMap);
		return response(resultMap);
	}

	/**
	 * 待阅列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/publicityNoReadList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> publicityNoReadList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的PublicityInforController中publicityNoReadList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.publicityNoReadList(requestMap);
		return response(resultMap);
	}
	/**
	 * 已阅列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/publicityReadList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> publicityReadList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的PublicityInforController中publicityReadList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.publicityReadList(requestMap);
		return response(resultMap);
	}
	/**
	 * 已办列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/publicityDealList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> publicityDealList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的PublicityInforController中publicityDealList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.publicityDealList(requestMap);
		return response(resultMap);
	}
	/**
	 * 关注列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/publicityCareList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> publicityCareList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的PublicityInforController中publicityCareList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.publicityCareList(requestMap);
		return response(resultMap);
	}
	/**
	 * 已阅
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changePublicityRead", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> changePublicityRead(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的PublicityInforController中changePublicityRead方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.changePublicityRead(requestMap);
		return response(resultMap);
	}
	/**
	 * 已办
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changePublicityDeal", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> changePublicityDeal(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的PublicityInforController中changePublicityDeal方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.changePublicityDeal(requestMap);
		return response(resultMap);
	}
	/**
	 * 关注
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/carePublicity", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> carePublicity(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的PublicityInforController中carePublicity方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.carePublicity(requestMap);
		return response(resultMap);
	}
	/**
	 * 取消关注
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/careCancel", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> publicityCareCancel(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的PublicityInforController中publicityCareCancel方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.publicityCareCancel(requestMap);
		return response(resultMap);
	}
	/**
	 * 隐藏
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/hiddenPublicity", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> hiddenPublicity(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的PublicityInforController中hiddenPublicity方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.hiddenPublicity(requestMap);
		return response(resultMap);
	}
}
