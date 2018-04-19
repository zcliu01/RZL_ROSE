package com.zrt.flow.web.manage.flowEntrust;

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
@RequestMapping("/v1.0/flowentrust")
public class FlowEntrustController {
	private static final Logger log = LoggerFactory.getLogger(FlowEntrustController.class);

	@Autowired
	private FlowEntrustService flowEntrustService;

	/**
	 * 流程委托列表
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> list(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowEntrustController中list方法");
		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> resMap = flowEntrustService.getEntrustList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程委托列表查询失败!").map();
		}
	}

	/**
	 * 流程委托
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/ent", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> ent(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowEntrustController中ent方法");
		ResultMap resultMap = new ResultMap();
		try {
			flowEntrustService.ent(map);
			resultMap.success().sucmsg("流程委托成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程委托失败!").map();
		}
	}

	/**
	 * 取消流程委托
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> cancel(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowEntrustController中cancel方法");
		ResultMap resultMap = new ResultMap();
		try {

			flowEntrustService.cancel(map);
			resultMap.success().sucmsg("取消流程委托成功!");
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程委托失败!").map();
		}
	}

}
