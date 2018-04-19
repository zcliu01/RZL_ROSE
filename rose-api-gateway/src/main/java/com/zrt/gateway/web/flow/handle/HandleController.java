package com.zrt.gateway.web.flow.handle;

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
import com.zrt.gateway.api.client.flow.IFlowClient;
import com.zrt.gateway.web.base.BaseController;

@RestController
@RequestMapping(value = "/v1.0/handle", produces = { "application/json;charset=UTF-8" })
public class HandleController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(HandleController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 签报发起
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/handleApply", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> handleApply(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的HandleController中deploy方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.handleApply(requestMap);
		return response(resultMap);
	}
	/**
	 * 签报审批
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/handleCheck", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> handleCheck(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的HandleController中handleCheck方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.handleCheck(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 签报审批详情
	 * @param requMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> draftDetail(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的HandleController中draftSave方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.handDetail(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 签报办结
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/handleEnd", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> handleEnd(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的HandleController中handleEnd方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.handleEnd(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 签报草稿保存
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/draftSave", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> handleDraftSave(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的HandleController中handleDraftSave方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.handleDraftSave(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 签报草稿更新
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/draftUpdate", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> handleDraftUpdate(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的HandleController中handleDraftUpdate方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.handleDraftUpdate(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 签报草稿提交
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/draftApply", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> handleDraftApply(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的HandleController中handleDraftApply方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.handleDraftApply(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 管理员查询所有预处理流程列表
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/draftDetail", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> handleDraftDetail(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的HandleController中handleDraftDetail方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.handleDraftDetail(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 流程信息
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/instInfor", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> instInfor(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的HandleController中instInfor方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.instInfor(requestMap);
		return response(resultMap);
	}
	
	@RequestMapping(value = "/isHandle", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> isHandle(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的HandleController中isHandle方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.isHandle(requestMap);
		return response(resultMap);
	}
	
	

}
