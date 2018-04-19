package com.zrt.gateway.web.tcmp;

import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.api.client.vif.IVifClient;
import com.zrt.gateway.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by dwliu on 2017/9/27.
 */
@RestController
@RequestMapping(value = "v1.0/oaToTcmp", produces = { "application/json;charset=UTF-8" })
public class TCMPController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(TCMPController.class);

	@Resource(name = "HystrixVifClient")
	private IVifClient iVifClient;

	/**
	 * TCMP推送代办流程到OA
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/waitDeal", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> waitDeal(@RequestBody Map<String, Object> requestMap) throws Exception {
		log.info("TCMPController中waitDeal方法");
		Map<String, Object> resultMap = iVifClient.waitDeal(requestMap);
		return response(resultMap);
	}

	/**
	 * TCMP推送已办任务到OA
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dealComplete", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> dealComplete(@RequestBody Map<String, Object> requestMap) throws Exception {
		log.info("TCMPController中dealComplete方法");
		Map<String, Object> resultMap = iVifClient.dealComplete(requestMap);
		return response(resultMap);
	}


	/**
	 * TCMP推送结束的流程到OA
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/flowEnd", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> flowEnd(@RequestBody Map<String, Object> requestMap)
			throws Exception {
		log.info("TCMPController中flowEnd方法");
		Map<String, Object> resultMap = iVifClient.flowEnd(requestMap);
		return response(resultMap);
	}

}
