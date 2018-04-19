package com.zrt.flow.web.app.appflowself;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.commons.date.DateUtil;
import com.zrt.flow.service.flowself.FlowselfService;

@RestController
@RequestMapping("/v1.0/appFlowself")
public class AppFlowselfController {
	private static final Logger log = LoggerFactory.getLogger(AppFlowselfController.class);

	@Resource(name = "flowselfServiceImp")
	private FlowselfService flowselfService;

	/**
	 * 我 发起的流程实例
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/selfApply", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> flowList(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的AppFlowselfController中flowList方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 格式化查询时间
			if (StringUtils.isNotBlank((String) appMap.get("begin_start_date_time"))) {
				appMap.put("begin_start_date_time",
						((String) appMap.get("begin_start_date_time")).replace("-", "") + "000000");
			}
			if (StringUtils.isNotBlank((String) appMap.get("end_start_date_time"))) {
				appMap.put("end_start_date_time",
						((String) appMap.get("end_start_date_time")).replace("-", "") + "235959");
			}
			appMap.put("reqType", "app");
			Map<String, Object> resMap = flowselfService.selfApply(appMap);
			resultMap.data(resMap.get("data"));
			resultMap.success().map().put("count", resMap.get("count"));
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("我发起的流程查询失败!").map();
		}
	}

	/**
	 * 我 的待办
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/selfDoList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> selfDoList(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的AppFlowselfController中selfDoList方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 格式化查询时间
			if (StringUtils.isNotBlank((String) appMap.get("begin_start_date_time"))) {
				appMap.put("begin_start_date_time",
						((String) appMap.get("begin_start_date_time")).replace("-", "") + "000000");
			}
			if (StringUtils.isNotBlank((String) appMap.get("end_start_date_time"))) {
				appMap.put("end_start_date_time",
						((String) appMap.get("end_start_date_time")).replace("-", "") + "235959");
			}
			appMap.put("reqType", "app");
			Map<String, Object> resMap = flowselfService.selfDoList(appMap);
			resultMap.data(resMap.get("data"));
			resultMap.success().map().put("count", resMap.get("count"));
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("我的待办查询失败!").map();
		}
	}

	/**
	 * 会签审批
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/selfSign", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> selfSign(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的AppFlowselfController中selfSign方法");
		ResultMap resultMap = new ResultMap();
		try {
			flowselfService.selfSign(appMap);
			resultMap.success().sucmsg("会签成功");
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("会签失败!").map();
		}
	}

	/**
	 * 批量审批
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> check(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的FlowoperController中check方法");
		ResultMap resultMap = new ResultMap();
		try {
			flowselfService.check(appMap);
			resultMap.success().sucmsg("审批成功");
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("流程审批失败!").map();
		}
	}

	/**
	 * 我 的已办列表
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/selfHasDoList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> selfHasDoList(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的AppFlowselfController中selfHasDoList方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 格式化查询时间
			if (StringUtils.isNotBlank((String) appMap.get("begin_start_date_time"))) {
				appMap.put("begin_start_date_time",
						((String) appMap.get("begin_start_date_time")).replace("-", "") + "000000");
			}
			if (StringUtils.isNotBlank((String) appMap.get("end_start_date_time"))) {
				appMap.put("end_start_date_time",
						((String) appMap.get("end_start_date_time")).replace("-", "") + "235959");
			}
			appMap.put("reqType", "app");
			Map<String, Object> resMap = flowselfService.selfHasDoList(appMap);
			resultMap.data(resMap.get("data"));
			resultMap.success().map().put("count", resMap.get("count"));
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("我的待办查询失败!").map();
		}
	}

	/**
	 * 我 的已办列表
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/selfApplyRes", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> selfApplyRes(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的AppFlowselfController中selfApplyRes方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 格式化查询时间
			if (StringUtils.isNotBlank((String) appMap.get("begin_start_date_time"))) {
				appMap.put("begin_start_date_time",
						((String) appMap.get("begin_start_date_time")).replace("-", "") + "000000");
			}
			if (StringUtils.isNotBlank((String) appMap.get("end_start_date_time"))) {
				appMap.put("end_start_date_time",
						((String) appMap.get("end_start_date_time")).replace("-", "") + "235959");
			}
			Map<String, Object> resMap = flowselfService.selfApplyRes(appMap);
			resultMap.data(resMap.get("data"));
			resultMap.success().map().put("count", resMap.get("count"));
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("我的待办查询失败!").map();
		}
	}
}
