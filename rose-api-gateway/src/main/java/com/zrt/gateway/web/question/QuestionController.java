package com.zrt.gateway.web.question;

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

import com.zrt.gateway.api.client.question.IQuestionClient;
import com.zrt.gateway.web.base.BaseController;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/v1.0", produces = {"application/json;charset=UTF-8"})
public class QuestionController extends BaseController {

	private static final Logger log = LoggerFactory.getLogger (QuestionController.class);
	@Resource(name = "HystrixQuestionClient")
	private IQuestionClient iQuestionClient;

	@RequestMapping(value = "/question/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> save (@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info ("Server端的iQuestionClient中save方法");
		setEmpId (emp_id, requestMap);
		Map<String, Object> resultMap = iQuestionClient.save (requestMap);
		return response (resultMap);
	}

	@RequestMapping(value = "/question/search", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> search (@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info ("Server端的iQuestionClient中search的方法");
		return this.Both (requestMap, emp_id, "search");
	}

	private ResponseEntity<String> Both (@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id, String methodName)
			throws Exception {
		log.info ("Server端的iQuestionClient中" + methodName + "方法");
		setEmpId (emp_id, requestMap);
		Map<String, Object> resultMap = iQuestionClient.search (requestMap);
		return response (resultMap);
	}

	@RequestMapping(value = "/question/del", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> delete (@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info ("Server端的iQuestionClient中delete方法");
		setEmpId (emp_id, requestMap);
		Map<String, Object> resultMap = iQuestionClient.delete (requestMap);
		return response (resultMap);
	}

	@RequestMapping(value = "/paper/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<String> paperSave (@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info ("Server端的iQuestionClient中paperSave方法");
		setEmpId (emp_id, requestMap);
		Map<String, Object> resultMap = iQuestionClient.paperSave (requestMap);
		return response (resultMap);
	}

	@RequestMapping(value = "/paper/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<String> paperSearch (@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info ("Server端的iQuestionClient中papersearch方法");
		setEmpId (emp_id, requestMap);
		Map<String, Object> resultMap = iQuestionClient.paperSearch (requestMap);
		return response (resultMap);
	}

	@RequestMapping(value = "/paper/del", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<String> paperdel (@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info ("Server端的iQuestionClient中 paperDelete 方法");
		setEmpId (emp_id, requestMap);
		Map<String, Object> resultMap = iQuestionClient.paperDelete (requestMap);
		return response (resultMap);
	}

	@RequestMapping(value = "/paper/cancel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<String> paperCancel (@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info ("Server端的iQuestionClient中 paperDelete 方法");
		setEmpId (emp_id, requestMap);
		Map<String, Object> resultMap = iQuestionClient.paperCancel (requestMap);
		return response (resultMap);
	}

	@RequestMapping(value = "/paper/publish", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<String> paperPublish (@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info ("Server端的iQuestionClient中 paperPublish 方法");
		setEmpId (emp_id, requestMap);
		Map<String, Object> resultMap = iQuestionClient.paperPublish (requestMap);
		return response (resultMap);
	}
}
