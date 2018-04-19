package com.zrt.gateway.web.flow.fbtemp;

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
 * 流程管理
 * 
 * @author:
 * @date:
 * @description TODO
 */

@RestController
@RequestMapping(value = "/v1.0/fbtemp", produces = { "application/json;charset=UTF-8" })
public class FbtempController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(FbtempController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 流程列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> list(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FbtempController中list方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.fbtempList(requestMap);
		return response(resultMap);
	}

	/**
	 * 流程新增
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> save(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FbtempController中save方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.fbtempSave(requestMap);
		return response(resultMap);
	}

	/**
	 * 流程明细查询
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> search(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FbtempController中search方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.fbtempSearch(requestMap);
		return response(resultMap);
	}

	/**
	 * 流程更新
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> myMeetingList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FbtempController中update方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.fbtempUpdate(requestMap);
		return response(resultMap);
	}

	/**
	 * 流程删除
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> delete(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FbtempController中delete方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.fbtempDelete(requestMap);
		return response(resultMap);
	}

	/**
	 * 流程启用
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/open", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> openform(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FbtempController中openform方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.openfbtemp(requestMap);
		return response(resultMap);
	}

	/**
	 * 流程关闭
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/close", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> closeform(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FbtempController中closeform方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.closefbtemp(requestMap);
		return response(resultMap);
	}

	/**
	 * 流程绑定表单查询
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/formList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> formList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FbtempController中formList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.fbtempFormList(requestMap);
		return response(resultMap);
	}

	/**
	 * 流程绑定表单
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/formSave", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> formsave(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FbtempController中formsave方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.fbtempFormsave(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 流程提醒人查询
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/notifyList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> fbNotifyList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FbtempController中fbNotifyList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.fbNotifyList(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 流程绑定表单
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/notify", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> fbNotify(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的FbtempController中fbNotify方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.fbNotify(requestMap);
		return response(resultMap);
	}

}
