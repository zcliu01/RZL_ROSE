package com.zrt.gateway.web.flow.flowAction;

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
 * 我的关注
 * 
 * @author:dwliu
 * @date:2017年3月22日下午8:14:02
 * @description TODO
 */
@RestController
@RequestMapping(value="/v1.0/flowAction", produces = { "application/json;charset=UTF-8" })
public class FlowActionController extends BaseController{
	private static final Logger log = LoggerFactory.getLogger(FlowActionController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 流程删除
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> delete(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id) throws Exception {
		log.info("Server端的FlowActionController中delete方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = flowClient.flowDelete(requestMap);
		return response(resultMap);
	}
	/**
	 * 流程终止
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/end",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> end(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id) throws Exception {
		log.info("Server端的FlowActionController中end方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = flowClient.end(requestMap);
		return response(resultMap);
	}
	

}
