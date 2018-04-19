package com.zrt.gateway.web.flow.fmType;

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
 * 表单分类管理
 * 
 * @author:
 * @date:
 * @description TODO
 */

@RestController
@RequestMapping(value = "/v1.0/fmtype", produces = { "application/json;charset=UTF-8" })
public class FmTypeController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(FmTypeController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 表单分类列表
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
		Map<String, Object> resultMap = flowClient.list(requestMap);
		return response(resultMap);
	}

	/**
	 * 表单分类新增
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
		Map<String, Object> resultMap = flowClient.save(requestMap);
		return response(resultMap);
	}

	/**
	 * 表单分类明细查询
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
		Map<String, Object> resultMap = flowClient.search(requestMap);
		return response(resultMap);
	}

	/**
	 * 表单分类更新
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
		Map<String, Object> resultMap = flowClient.update(requestMap);
		return response(resultMap);
	}

	/**
	 * 表单分类删除
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
		Map<String, Object> resultMap = flowClient.delete(requestMap);
		return response(resultMap);
	}

}
