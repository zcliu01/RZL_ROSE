package com.zrt.flow.web.manage.flowent;

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
import com.zrt.flow.service.flowEntrust.FlowEntrustService;

@RestController
@RequestMapping("/v1.0/flowent")
public class FlowEntController {
	private static final Logger log = LoggerFactory.getLogger(FlowEntController.class);

	@Autowired
	private FlowEntrustService flowEntrustService;

	/**
	 * 我委托的流程列表
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> list(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowEntController中list方法");
		ResultMap resultMap = new ResultMap();
		try {

			map.put("ent_flag", "0");// 我是委托人
			Map<String, Object> resMap = flowEntrustService.getList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("我委托的流程列表查询失败!").map();
		}
	}

	/**
	 * 委托我的流程列表
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/entedList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> entedList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowEntController中entedList方法");
		ResultMap resultMap = new ResultMap();
		try {

			map.put("ent_flag", "1");// 我是受托人
			Map<String, Object> resMap = flowEntrustService.getList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("委托我的流程列表查询失败!").map();
		}
	}

}
