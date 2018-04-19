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

/**
 * Created by msKui on 2017/3/21.
 */
@RestController
@RequestMapping(value = "/v1.0/appInforInnerCare", produces = { "application/json;charset=UTF-8" })
public class AppInforInnerCareController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(AppInforInnerCareController.class);

	@Resource(name = "HystrixInforClient")
	private IInforClient inforClient;

	/**
	 * 关注讯息分类查询
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dicList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> dicList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppInforInnerCareController中dicList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.dicList(requestMap);
		return response(resultMap);
	}

	/**
	 * 关注讯息分类新增
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dicAdd", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> dicAdd(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppInforInnerCareController中dicAdd方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.dicAdd(requestMap);
		return response(resultMap);
	}

	/**
	 * 添加关注讯息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/concernInfor", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> concernInfor(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppInforInnerCareController中concernInfor方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.concernInfor(requestMap);
		return response(resultMap);
	}

	/**
	 * 取消关注讯息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/concernInforCancel", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> concernInforCancel(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的AppInforInnerCareController中concernInforCancel方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.concernInforCancel(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 讯息详情
	 * @param jsonMap
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforCareDetail",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforCareDetail(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的MsgController中inforCareDetail方法");
		Map<String,Object>  resultMap = inforClient.inforCareDetail(appMap);
		return response(resultMap);
	}
}
