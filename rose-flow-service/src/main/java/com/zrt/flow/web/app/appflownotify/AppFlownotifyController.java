package com.zrt.flow.web.app.appflownotify;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.commons.date.DateUtil;
import com.zrt.flow.service.flownotify.FlownotifyService;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by dwliu on 2017/9/20.
 */

@RestController
@RequestMapping("/v1.0/appFlownotify")
public class AppFlownotifyController {

	private static final Logger log = LoggerFactory.getLogger(AppFlownotifyController.class);

	@Autowired
	private FlownotifyService flownotifyService;

	/**
	 * 知会我的
	 *
	 * @param appMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/notifyList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> notifyList(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的FlownotifyController中notifyList方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 格式化查询时间
			if (StringUtils.isNotBlank((String) appMap.get("begin_start_date_time"))) {
				appMap.put("begin_start_date_time",
						DateUtil.getFormatFormat((String) appMap.get("begin_start_date_time")) + "000000");
			}
			if (StringUtils.isNotBlank((String) appMap.get("end_start_date_time"))) {
				appMap.put("end_start_date_time",
						DateUtil.getFormatFormat((String) appMap.get("end_start_date_time")) + "235959");
			}
			Map<String, Object> resMap = flownotifyService.notifyList(appMap);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("运行知会我的列表查询失败!").map();
		}
	}

	/**
	 * 我知会的
	 *
	 * @param appMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/selfList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> selfList(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的FlownotifyController中selfList方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 格式化查询时间
			if (StringUtils.isNotBlank((String) appMap.get("begin_start_date_time"))) {
				appMap.put("begin_start_date_time",
						DateUtil.getFormatFormat((String) appMap.get("begin_start_date_time")) + "000000");
			}
			if (StringUtils.isNotBlank((String) appMap.get("end_start_date_time"))) {
				appMap.put("end_start_date_time",
						DateUtil.getFormatFormat((String) appMap.get("end_start_date_time")) + "235959");
			}
			Map<String, Object> resMap = flownotifyService.selfList(appMap);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("运行我知会的列表查询失败!").map();
		}
	}

	/**
	 * 知会
	 *
	 * @param appMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/notify", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> notify(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的FlownotifyController中notify方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 格式化查询时间
			flownotifyService.notify(appMap);
			resultMap.success().sucmsg("知会成功");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("知会失败!").map();
		}
	}

}
