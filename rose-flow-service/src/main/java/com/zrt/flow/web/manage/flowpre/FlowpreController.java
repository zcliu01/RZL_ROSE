package com.zrt.flow.web.manage.flowpre;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.commons.date.DateUtil;
import com.zrt.flow.service.flowpre.FlowpreService;

@RestController
@RequestMapping("/v1.0/flowpre")
public class FlowpreController {
	private static final Logger log = LoggerFactory.getLogger(FlowpreController.class);

	@Autowired
	private FlowpreService flowpreService;

	/**
	 * 我的预处理列表
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/selfList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> selfList(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的FlowpreController中selfList方法");
		ResultMap resultMap = new ResultMap();
		try {

			// 格式化查询时间
			if (StringUtils.isNotBlank((String)appMap.get("begin_start_date_time"))) {
	  			appMap.put("begin_start_date_time", ((String)appMap.get("begin_start_date_time")).replace("-", "")+"000000");
			}
	  		if (StringUtils.isNotBlank((String)appMap.get("end_start_date_time"))) {
	  			appMap.put("end_start_date_time", ((String)appMap.get("end_start_date_time")).replace("-", "")+"235959");
	  		}
			Map<String, Object> resMap = flowpreService.getMyPreList(appMap);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("我的预处理流程列表查询失败!").map();
		}
	}

	/**
	 * 流程预处理同意/拒绝
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/deal", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> deal(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowpreController中deal方法");
		ResultMap resultMap = new ResultMap();
		try {

			flowpreService.deal(map);
			resultMap.success().sucmsg("流程预处理成功!");
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程预处理失败!").map();
		}
	}
	/**
	 * 流程预处理取消
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> cancel(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowpreController中cancel方法");
		ResultMap resultMap = new ResultMap();
		try {
			
			flowpreService.cancel(map);
			resultMap.success().sucmsg("流程预处理取消成功!");
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程预处理取消失败!").map();
		}
	}
	
	
	/**
	 * 流程待办预处理列表
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> list(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的FlowpreController中list方法");
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
			Map<String, Object> resMap = flowpreService.instPreList(appMap);
			resultMap.data(resMap.get("data"));
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程待办预处理查询失败!").map();
		}
	}

}
