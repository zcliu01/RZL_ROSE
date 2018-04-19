package com.zrt.gateway.web.flow.process;

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
@RequestMapping(value = "/v1.0/flow", produces = { "application/json;charset=UTF-8" })
public class ProcessController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(ProcessController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 管理员查询所有流程列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deploy", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> deploy(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中deploy方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.deploy(requestMap);
		return response(resultMap);
	}
	/**
	 * 管理员查询所有委托流程列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/apply", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> apply(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中apply方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.apply(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 流程草稿保存
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/draftSave", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> draftSave(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中draftSave方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.draftSave(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 流程草稿保存
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/draftDelete", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> draftDelete(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中draftDelete方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.draftDelete(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 管理员查询所有预处理流程列表
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/send", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> send(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中send方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.send(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 管理员查询所有预处理流程列表
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/instRead", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> instRead(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中instRead方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.instRead(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 管理员查询所有预处理流程列表
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/joinSign", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> joinSign(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中joinSign方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.joinSign(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 管理员查询所有预处理流程列表
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/joinSignCheck", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> joinSignCheck(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中joinSignCheck方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.joinSignCheck(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 管理员查询所有预处理流程列表
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/applyCheck", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> applyCheck(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中applyCheck方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.applyCheck(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 管理员查询所有预处理流程列表
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/applyCheckWithCon", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> applyCheckWithCon(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中applyCheckWithCon方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.applyCheckWithCon(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 管理员查询所有预处理流程列表
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/returnCheck", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> returnCheck(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中returnCheck方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.returnCheck(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 管理员查询所有预处理流程列表
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/signAdd", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> signAdd(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中signAdd方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.signAdd(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 
	 * 管理员查询所有预处理流程列表
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/actInfoList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> actInfoList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中actInfoList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.actInfoList(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 流程表单详情查询
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/fmDetail", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> fmDetail(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中fmDetail方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.fmDetail(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 
	 * 流程草稿详情
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/draftDetail", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> draftDetail(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中draftDetail方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.draftDetail(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 流程草稿更新
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/draftUpdate", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> draftUpdate(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中draftUpdate方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.draftUpdate(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 流程草稿提交
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/draftApply", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> draftApply(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中draftApply方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.draftApply(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 
	 * 流程草稿提交
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editSubmit", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> editSubmit(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中editSubmit方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.editSubmit(requestMap);
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
	 * 流程进度图
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/img", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> img(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ProcessController中img方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = flowClient.img(requestMap);
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
	 * 催办
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

}
