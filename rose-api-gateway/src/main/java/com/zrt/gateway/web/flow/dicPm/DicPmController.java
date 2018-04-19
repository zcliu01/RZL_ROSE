package com.zrt.gateway.web.flow.dicPm;

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
import com.zrt.gateway.web.flow.fbtemp.FbtempController;

@RestController
@RequestMapping(value = "/v1.0/fmdicpm", produces = { "application/json;charset=UTF-8" })
public class DicPmController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(FbtempController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 字典列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> list(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的DicPmController中dicList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.dicPmList(requestMap);
		return response(resultMap);
	}
	/**
	 * 字典列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> save(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的DicPmController中save方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.dicPmSave(requestMap);
		return response(resultMap);
	}
	/**
	 * 字典明细查询
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> search(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的DicPmController中dicSearch方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.dicPmSearch(requestMap);
		return response(resultMap);
	}
	/**
	 * 字典更新
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> dicUpdate(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的DicPmController中dicUpdate方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.dicPmUpdate(requestMap);
		return response(resultMap);
	}
	/**
	 * 字典删除
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> dicDelete(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的DicPmController中dicDelete方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.dicPmDelete(requestMap);
		return response(resultMap);
	}
}
