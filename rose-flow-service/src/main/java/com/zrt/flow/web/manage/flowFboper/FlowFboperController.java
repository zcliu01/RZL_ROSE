package com.zrt.flow.web.manage.flowFboper;

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
import com.zrt.flow.service.flowFboper.FlowFboperService;

@RestController
@RequestMapping("/v1.0/flowfboper")
public class FlowFboperController {
	private static final Logger log = LoggerFactory.getLogger(FlowFboperController.class);

	@Autowired
	private FlowFboperService flowFboperService;

	/**
	 * 运行流程列表
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/runList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> runList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowFboperController中runList方法");
		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> resMap = flowFboperService.runList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("运行流程列表查询失败!").map();
		}
	}
	/**
	 * 运行流程列表
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/applyList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> applyList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowFboperController中applyList方法");
		ResultMap resultMap = new ResultMap();
		try {
			
			Map<String, Object> resMap = flowFboperService.applyList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("运行流程列表查询失败!").map();
		}
	}

	/**
	 * 运行流程明细查询
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/runFlowDetail", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> runFlowDetail(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowFboperController中runFlowDetail方法");
		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> resMap = flowFboperService.runFlowDetail(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("运行流程明细查询失败!").map();
		}
	}

	/**
	 * 停用流程列表
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/stopList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> stopList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowFboperController中stopList方法");
		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> resMap = flowFboperService.stopList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("停用流程列表查询失败!").map();
		}
	}

	/**
	 * 停用流程明细查询
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/stopFlowDetail", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> stopFlowDetail(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowFboperController中stopFlowDetail方法");
		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> resMap = flowFboperService.stopFlowDetail(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("停用流程明细查询失败!").map();
		}
	}

}
