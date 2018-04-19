package com.zrt.gateway.web.flow.fmForm;

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

/**
 * 表单管理
 * 
 * @author:
 * @date:
 * @description TODO
 */

@RestController
@RequestMapping(value = "/v1.0/fmform", produces = { "application/json;charset=UTF-8" })
public class FmFormController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(FmFormController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 表单列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> list(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FmTypeController中list方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.formList(requestMap);
		return response(resultMap);
	}

	/**
	 * 表单新增
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> save(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FmTypeController中save方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.formSave(requestMap);
		return response(resultMap);
	}

	/**
	 * 表单明细查询
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> search(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FmTypeController中search方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.formSearch(requestMap);
		return response(resultMap);
	}

	/**
	 * 表单更新
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> myMeetingList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FmTypeController中update方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.formUpdate(requestMap);
		return response(resultMap);
	}

	/**
	 * 表单删除
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> delete(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FmTypeController中delete方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.formDelete(requestMap);
		return response(resultMap);
	}

	/**
	 * 表单启用
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/openform", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> openform(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FmTypeController中openform方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.openform(requestMap);
		return response(resultMap);
	}

	/**
	 * 表单关闭
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/closeform", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> closeform(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FmTypeController中closeform方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.closeform(requestMap);
		return response(resultMap);
	}

	/**
	 * 表单元素详情
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/formdeail", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> formdeail(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FmTypeController中formdeail方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.formdeail(requestMap);
		return response(resultMap);
	}

	/**
	 * 表单元素保存
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/formsave", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> formsave(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FmTypeController中formsave方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.formFormsave(requestMap);
		return response(resultMap);
	}

}
