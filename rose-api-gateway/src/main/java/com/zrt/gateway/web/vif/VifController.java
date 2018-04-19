package com.zrt.gateway.web.vif;

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
import com.zrt.gateway.api.client.vif.IVifClient;
import com.zrt.gateway.web.base.BaseController;

@RestController
@RequestMapping(value = "/v1.0/tcmp", produces = { "application/json;charset=UTF-8" })
public class VifController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(VifController.class);
	@Resource(name = "HystrixVifClient")
	private IVifClient iVifClient;

	/**
	 * 代办流程数量
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/indexCount", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> indexCount(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VifController中indexCount方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = iVifClient.indexCount(requestMap);
		return response(resultMap);
	}

}
