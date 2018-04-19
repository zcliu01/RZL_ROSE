package com.zrt.gateway.web.flow.flowdetail;

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
 * 审批详情查询
 * 
 * @author:wwfu
 * @date:2017年10月12日下午8:14:02
 * @description TODO
 */
@RestController
@RequestMapping(value="/v1.0/flowDetail", produces = { "application/json;charset=UTF-8" })
public class FlowdetailController extends BaseController{
	private static final Logger log = LoggerFactory.getLogger(FlowdetailController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 我的发起详情
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/inst",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inst(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id) throws Exception {
		log.info("Server端的FlowdraftController中inst方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = flowClient.applyDetail(requestMap);
		return response(resultMap);
	}

}
