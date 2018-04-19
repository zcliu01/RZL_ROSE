package com.zrt.gateway.web.infoPub;

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
import com.zrt.gateway.api.client.infoPub.IInfoPubClient;
import com.zrt.gateway.api.client.task.ITaskClient;
import com.zrt.gateway.web.base.BaseController;

@RestController
@RequestMapping(value="/v1.0/infoPub", produces = { "application/json;charset=UTF-8" })
public class InfoPubController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(InfoPubController.class);
	@Resource(name="HystrixInfoPubClient")
	private IInfoPubClient infoPubClient;
	
	
	
	
	/**
	 * 新建公示
	 */
	@RequestMapping(value = "/save",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> save(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的InfoPubController中save方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = infoPubClient.save(requestMap);
		return response(resultMap);
	}
	/**
	 * 公示修改
	 */
	@RequestMapping(value = "/updateInfopub",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> updateInfopub(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的InfoPubController中updateInfopub方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = infoPubClient.updateInfopub(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/updateInfoType",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> updateInfoType(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的InfoPubController中updateInfoType方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = infoPubClient.updateInfoType(requestMap);
		return response(resultMap);
	}
	
	
	
	
	
	/**
	 * 公示查询
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> search(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的InfoPubController中search方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = infoPubClient.search(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 
	 * 查询公示信息详情
	 */
	@RequestMapping(value = "/searchInfo", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> searchInfo(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的InfoPubController中searchInfo方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = infoPubClient.searchInfo(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 
	 * 删除公示
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> del(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的InfoPubController中del方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = infoPubClient.del(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 
	 *公示类型查询
	 */
	@RequestMapping(value = "/state_search", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> state_search(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的InfoPubController中state_search方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = infoPubClient.state_search(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 公示类型维护
	 * 
	 */
	@RequestMapping(value = "/state_save", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> state_save(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的InfoPubController中state_save方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = infoPubClient.state_save(requestMap);
		return response(resultMap);
	}
	
	
}
