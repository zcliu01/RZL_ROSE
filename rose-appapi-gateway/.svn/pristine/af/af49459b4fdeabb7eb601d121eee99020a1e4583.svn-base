package com.zrt.gateway.web.flow.flow;

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
@RequestMapping(value = "/v1.0/appFlow", produces = { "application/json;charset=UTF-8" })
public class AppFlowController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(AppFlowController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 会签加人
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/joinSign", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> joinSign(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowController中joinSign方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.joinSign(requestMap);
		return response(resultMap);
	}

	/**
	 * 会签审批
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/joinSignCheck", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> joinSignCheck(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowpreController中joinSignCheck方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.joinSignCheck(requestMap);
		return response(resultMap);
	}

	/**
	 * 流程普通审核同意/拒绝
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/applyCheck", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> applyCheck(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowController中applyCheck方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.applyCheck(requestMap);
		return response(resultMap);
	}

	/**
	 * 附条件同意
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/applyCheckWithCon", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> applyCheckWithCon(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的AppFlowController中applyCheckWithCon方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.applyCheckWithCon(requestMap);
		return response(resultMap);
	}

	/**
	 * 驳回至审批
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/returnCheck", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> returnCheck(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowController中returnCheck方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.returnCheck(requestMap);
		return response(resultMap);
	}

	/**
	 * 加签审批
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/signAdd", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> signAdd(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowController中signAdd方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.signAdd(requestMap);
		return response(resultMap);
	}

	/**
	 * 流程节点信息查询
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/actInfoList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> actInfoList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowController中actInfoList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.actInfoList(requestMap);
		return response(resultMap);
	}

	/**
	 * 流程表单详情查询
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/fmDetail", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> fmDetail(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowController中fmDetail方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.fmDetail(requestMap);
		return response(resultMap);
	}

	/**
	 * 流程阅读
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/instRead", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> instRead(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppFlowController中instRead方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.instRead(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 附条件
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/applyCheckCon", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> applyCheckCon(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中applyCheckCon方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.applyCheckCon(requestMap);
		return response(resultMap);
	}

	/**
	 * 
	 * 催办
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/remind", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> remind(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中remind方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.remind(requestMap);
		return response(resultMap);
	}

	/**
	 * 
	 * 下一审批节点信息
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/actNextList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> actNextList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中actNextList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.actNextList(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 个人相关列表查询
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selfAboutList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> selfAboutList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中selfAboutList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.selfAboutList(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 
	 * 撤销
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/instCancel", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> instCancel(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中instCancel方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.instCancel(requestMap);
		return response(resultMap);
	}
}
