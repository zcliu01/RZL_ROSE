package com.zrt.gateway.api.client.question;

import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(QuestionConstant.QUESTION_INSTANCE)
public interface IQuestionClient extends QuestionConstant{

	@ResponseBody
	@RequestMapping(value = QUESTION_SAVE, method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> save (Map<String, Object> map) throws Exception;

	@ResponseBody
	@RequestMapping(value = QUESTION_SEARCH, method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> search (@RequestBody Map<String, Object> map) throws Exception;

	@ResponseBody
	@RequestMapping(value = QUESTION_DELETE, method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> delete (@RequestBody Map<String, Object> map) throws Exception;

	/**
	 * 下面是试卷的方法
	 */

	@ResponseBody
	@RequestMapping(value = PAPER_SAVE, method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> paperSave (Map<String, Object> map) throws Exception;

	@ResponseBody
	@RequestMapping(value = PAPER_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> paperSearch (@RequestBody Map<String, Object> map) throws Exception;

	@ResponseBody
	@RequestMapping(value = PAPER_DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> paperDelete (@RequestBody Map<String, Object> map) throws Exception;

	@ResponseBody
	@RequestMapping(value = PAPER_CANCEL, method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> paperCancel (@RequestBody Map<String, Object> map) throws Exception;

	@ResponseBody
	@RequestMapping(value = PAPER_PUBLISH, method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> paperPublish (@RequestBody Map<String, Object> map) throws Exception;


}
