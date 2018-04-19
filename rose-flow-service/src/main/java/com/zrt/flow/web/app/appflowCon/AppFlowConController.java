package com.zrt.flow.web.app.appflowCon;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.flow.service.flowCon.FlowConService;

@RestController
@RequestMapping("/v1.0/appCon")
public class AppFlowConController {
	private static final Logger log = LoggerFactory.getLogger(AppFlowConController.class);

	@Autowired
	private FlowConService flowConService;

	/**
	 * 附条件回复
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/res", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> res(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppFlowConController中res方法");
		ResultMap resultMap = new ResultMap();
		try {

			flowConService.res(map);
			resultMap.success().sucmsg("附条件回复成功");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("附条件回复失败!").map();
		}
	}

	/**
	 * 附条件复核
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/confirm", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> confirm(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppFlowConController中confirm方法");
		ResultMap resultMap = new ResultMap();
		try {

			flowConService.confirm(map);
			resultMap.success().sucmsg("附条件复核成功");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("附条件复核失败!").map();
		}
	}

}
