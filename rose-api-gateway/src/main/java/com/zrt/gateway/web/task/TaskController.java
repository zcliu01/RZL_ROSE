package com.zrt.gateway.web.task;

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
import com.zrt.gateway.api.client.task.ITaskClient;
import com.zrt.gateway.web.base.BaseController;

@RestController
@RequestMapping(value="/v1.0/task", produces = { "application/json;charset=UTF-8" })
public class TaskController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(TaskController.class);
	@Resource(name="HystrixTaskClient")
	private ITaskClient taskClient;
	
	
	
	
	/**
	 * 新建任务
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> save(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的TaskController中add方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = taskClient.add(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 删除任务
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> delete(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的TaskController中delete方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = taskClient.delete(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 任务修改
	 */
	@RequestMapping(value = "/change",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> change(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的TaskController中change方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = taskClient.change(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * Web任务查询
	 */
	@RequestMapping(value = "/webSearch", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> webSearch(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的TaskController中webSearch方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = taskClient.webSearch(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 
	 * 查询任务详情
	 */
	@RequestMapping(value = "/searchInfo", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> searchInfo(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的TaskController中searchInfo方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = taskClient.searchInfo(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 
	 * 任务终止或完成
	 */
	@RequestMapping(value = "/stop", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> stop(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的TaskController中stop方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = taskClient.stop(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 
	 * 任务分配
	 */
	@RequestMapping(value = "/callChild", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> callChild(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的TaskController中callChild方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = taskClient.callChild(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 任务反馈
	 * 
	 */
	@RequestMapping(value = "/backInfo", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> backInfo(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的TaskController中backInfo方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = taskClient.backInfo(requestMap);
		return response(resultMap);
	}
	
	
	
	/**
	 * 待办任务查询
	 * 
	 */
	@RequestMapping(value = "/todoSearch", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> todoSearch(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的TaskController中todoSearch方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = taskClient.todoSearch(requestMap);
		return response(resultMap);
	}
	
}
