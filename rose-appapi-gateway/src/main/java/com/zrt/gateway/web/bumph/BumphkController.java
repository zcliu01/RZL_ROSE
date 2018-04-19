package com.zrt.gateway.web.bumph;

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
import com.zrt.gateway.api.client.bumph.IBumphClient;
import com.zrt.gateway.web.base.BaseController;
import com.zrt.gateway.web.infoPub.InfoPubController;

@RestController
@RequestMapping(value="/v1.0/APPdocPro", produces = { "application/json;charset=UTF-8" })
public class BumphkController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(InfoPubController.class);
	@Resource(name="HystrixBumphClient")
	private IBumphClient bumphClient;
	
	/**
	 * 审核人管理
	 */
	@RequestMapping(value = "/execute",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> execute(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id) throws Exception {
		log.info("Server端的BumphkController中execute方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = bumphClient.execute(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 审核人管理
	 */
	@RequestMapping(value = "/addExecutes",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> addExecutes(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id) throws Exception {
		log.info("Server端的BumphkController中addExecutes方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = bumphClient.addExecutes(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 公文撤销
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> delete(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id) throws Exception {
		log.info("Server端的BumphkController中delete方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = bumphClient.delete(requestMap);
		return response(resultMap);
	}
	
	
	
	/**
	 * 公文审核办理
	 */
	@RequestMapping(value = "/auditAttend",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> auditAttend(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id) throws Exception {
		log.info("Server端的BumphkController中auditAttend方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = bumphClient.auditAttend(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 公文审核详情
	 */
	@RequestMapping(value = "/auditView",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> auditView(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id) throws Exception {
		log.info("Server端的BumphkController中auditView方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = bumphClient.auditView(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 公文详情
	 */
	@RequestMapping(value = "/detailView",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> detailView(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id) throws Exception {
		log.info("Server端的BumphkController中detailView方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = bumphClient.detailView(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 公文办理--筛选
	 */
	@RequestMapping(value = "/detailSearch",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> detailSearch(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id) throws Exception {
		log.info("Server端的BumphkController中detailSearch方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = bumphClient.detailSearch(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 公文查询--筛选
	 */
	@RequestMapping(value = "/documentSearch",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> documentSearch(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id) throws Exception {
		log.info("Server端的BumphkController中documentSearch方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = bumphClient.documentSearch(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 公文管理--筛选
	 */
	@RequestMapping(value = "/regis",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> manageSearch(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id) throws Exception {
		log.info("Server端的BumphkController中regis方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = bumphClient.regis(requestMap);
		return response(resultMap);
	}
	
}
