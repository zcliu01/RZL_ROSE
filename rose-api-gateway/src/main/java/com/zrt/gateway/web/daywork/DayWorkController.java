package com.zrt.gateway.web.daywork;

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
import com.zrt.gateway.api.client.daywork.IDayWorkClient;
import com.zrt.gateway.web.base.BaseController;

@RestController
@RequestMapping(value="/v1.0/daywork", produces = { "application/json;charset=UTF-8" })
public class DayWorkController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(DayWorkController.class);
	@Resource(name="HystrixDayWorkClient")
	private IDayWorkClient dayWorkClient;
	
	/**
	 * 新建日程
	 */
	@RequestMapping(value = "/save",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> save(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的DayWorkController中save方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = dayWorkClient.save(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 删除日程
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> delete(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的DayWorkController中delete方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = dayWorkClient.delete(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 更新日程
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> update(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的DayWorkController中update方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = dayWorkClient.update(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 查询日程详情
	 */
	
	@RequestMapping(value = "/detail",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> detail(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的DayWorkController中detail方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = dayWorkClient.detail(requestMap);
		return response(resultMap);
	}
	
	
	
	/**
	 * 查询日程列表
	 */
	@RequestMapping(value = "/list",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> list(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的DayWorkController中list方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = dayWorkClient.list(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 查询全部日程
	 */
	@RequestMapping(value = "/checkAll",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> checkAll(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的DayWorkController中checkAll方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = dayWorkClient.checkAll(requestMap);
		return response(resultMap);
	}
	
	
}
