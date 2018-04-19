package com.zrt.gateway.web.vm;

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
import com.zrt.gateway.api.client.vm.IVmClient;
import com.zrt.gateway.web.base.BaseController;

/**
 * 会议管理模块接口请求类
 * 
 * @author:
 * @date:
 * @description TODO
 */

@RestController
@RequestMapping(value = "/v1.0/vmoper", produces = { "application/json;charset=UTF-8" })
public class VmoperController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(VmoperController.class);
	@Resource(name = "HystrixVmClient")
	private IVmClient vmClient;

	/**
	 * web发起视频
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/launch", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> mtPersonList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VmoperController中launch方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.launch(requestMap);
		return response(resultMap);
	}

}
