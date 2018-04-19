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
@RequestMapping(value="/v1.0/appInforControl", produces = { "application/json;charset=UTF-8" })
public class AppInforControlController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(AppInforControlController.class);
	@Resource(name = "HystrixInforClient")
	private IInforClient inforClient;

	/** 
	 * 所有发送讯息列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/withInforList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> withInforList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的InforrecordController中withInforList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.withInforList(requestMap);
		return response(resultMap);
	}

	/**
	 * 监控详情
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/withInforDetails", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> withInforDetails(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的InforrecordController中withInforDetails方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.withInforDetails(requestMap);
		return response(resultMap);
	}

	/**
	 * 监控详情搜索
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDetailsSearch", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforDetailsSearch(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的InforrecordController中inforDetailsSearch方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.inforDetailsSearch(requestMap);
		return response(resultMap);
	}

	/**
	 * 发送给某个员工所有信息列表
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/withEmpList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> withEmpList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的InforrecordController中withEmpList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.withEmpList(requestMap);
		return response(resultMap);
	}
	/**
	 * 发送给某个员工所有信息列表搜索
	 * 
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforEmpSearch", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforEmpSearch(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的InforrecordController中inforEmpSearch方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.inforEmpSearch(requestMap);
		return response(resultMap);
	}

}
