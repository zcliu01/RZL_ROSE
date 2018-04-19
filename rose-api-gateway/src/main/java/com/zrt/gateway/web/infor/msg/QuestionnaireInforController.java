package com.zrt.gateway.web.infor.msg;

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
import com.zrt.gateway.api.client.infor.IInforClient;
import com.zrt.gateway.web.base.BaseController;

@RestController
@RequestMapping("/v1.0/questionnaireInfor")
public class QuestionnaireInforController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(QuestionnaireInforController.class);
	@Resource(name = "HystrixInforClient")
	private IInforClient inforClient;

	/**
	 * 全部列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/questionnaireAllList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> questionnaireAllList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的QuestionnaireInforController中questionnaireAllList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.questionnaireAllList(requestMap);
		return response(resultMap);
	}

	/**
	 * 待阅列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/questionnaireNoReadList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> questionnaireNoReadList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的QuestionnaireInforController中questionnaireNoReadList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.questionnaireNoReadList(requestMap);
		return response(resultMap);
	}
	/**
	 * 已阅列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/questionnaireReadList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> questionnaireReadList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的QuestionnaireInforController中questionnaireReadList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.questionnaireReadList(requestMap);
		return response(resultMap);
	}
	/**
	 * 已办列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/questionnaireDealList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> questionnaireDealList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的QuestionnaireInforController中questionnaireDealList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.questionnaireDealList(requestMap);
		return response(resultMap);
	}
	/**
	 * 关注列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/questionnaireCareList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> questionnaireCareList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的QuestionnaireInforController中questionnaireCareList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.questionnaireCareList(requestMap);
		return response(resultMap);
	}
	/**
	 * 已阅
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeQuestionnaireRead", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> changeQuestionnaireRead(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的QuestionnaireInforController中changeQuestionnaireRead方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.changeQuestionnaireRead(requestMap);
		return response(resultMap);
	}
	/**
	 * 已办
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeQuestionnaireDeal", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> changeQuestionnaireDeal(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的QuestionnaireInforController中changeQuestionnaireDeal方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.changeQuestionnaireDeal(requestMap);
		return response(resultMap);
	}
	/**
	 * 关注
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/careQuestionnaire", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> careQuestionnaire(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的QuestionnaireInforController中careQuestionnaire方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.careQuestionnaire(requestMap);
		return response(resultMap);
	}
	/**
	 * 取消关注
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/careCancel", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> questionnaireCareCancel(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的QuestionnaireInforController中questionnaireCareCancel方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.questionnaireCareCancel(requestMap);
		return response(resultMap);
	}
	/**
	 * 隐藏
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/hiddenQuestionnaire", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> hiddenQuestionnaire(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的QuestionnaireInforController中hiddenQuestionnaire方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.hiddenQuestionnaire(requestMap);
		return response(resultMap);
	}
}
