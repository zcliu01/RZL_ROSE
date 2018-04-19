package com.zrt.gateway.web.flow.flowcondition;

import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.api.client.flow.IFlowClient;
import com.zrt.gateway.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 审核详情（带附件同意）
 * 
 * @author:dwliu
 * @date:2017年3月22日下午8:14:02
 * @description TODO
 */
@RestController
@RequestMapping(value="/v1.0/appFlow", produces = { "application/json;charset=UTF-8" })
public class AppFlowconditionController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(AppFlowconditionController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 审核详情（带附件同意）
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/appApplyCheckWithFile",method = RequestMethod.POST,consumes= ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> appApplyCheckWithFile(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id) throws Exception {
		log.info("Server端的AppFlowconditionController中applyCheckWithFile方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = flowClient.applyCheckWithFile(requestMap);
		return response(resultMap);
	}

}
