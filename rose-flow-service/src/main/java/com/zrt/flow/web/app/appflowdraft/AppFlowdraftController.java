package com.zrt.flow.web.app.appflowdraft;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.commons.date.DateUtil;
import com.zrt.flow.service.flowdraft.FlowdraftService;
import com.zrt.flow.service.process.ProcessService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import javax.annotation.Resource;

/**
 * Created by dwliu on 2017/9/19.
 */

@RestController
@RequestMapping("/v1.0/appFlowdraft")
public class AppFlowdraftController {

	private static final Logger log = LoggerFactory.getLogger(AppFlowdraftController.class);

	@Autowired
	private FlowdraftService flowdraftService;
	@Resource(name = "processServiceImp")
	private ProcessService processService;

	/**
	 * 我的草稿
	 *
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> list(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowdraftController中list方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 格式化查询时间
			if (StringUtils.isNotBlank((String) map.get("begin_create_date_time"))) {
				map.put("begin_create_date_time",
						DateUtil.getFormatFormat((String) map.get("begin_create_date_time")) + "000000");
			}
			if (StringUtils.isNotBlank((String) map.get("end_create_date_time"))) {
				map.put("end_create_date_time",
						DateUtil.getFormatFormat((String) map.get("end_create_date_time")) + "235959");
			}
			Map<String, Object> resMap = flowdraftService.appFlowdraftList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("运行我的草稿列表查询失败!").map();
		}
	}

	/**
	 * 流程草稿发送
	 */
	@RequestMapping(value = "/send", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> send(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的ProcessController中send方法");
		ResultMap resultMap = new ResultMap();
		try {
			processService.send(appMap);
			resultMap.success().sucmsg("流程草稿发送成功");
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("流程发送失败!").map();
		}
	}

	/**
	 * 流程草稿删除
	 */
	@RequestMapping(value = "/draftDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> draftDelete(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的ProcessController中draftDelete方法");
		ResultMap resultMap = new ResultMap();
		try {
			processService.draftDelete(appMap);
			resultMap.success().sucmsg("流程草稿删除成功");
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("流程草稿删除失败!").map();
		}
	}

	/**
	 * 流程草稿详情
	 */
	@RequestMapping(value = "/draftDetail", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> draftDetail(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的ProcessController中draftDetail方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = processService.draftDetail(appMap);
			resultMap.success().data(resMap);
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("流程草稿详情查询失败!").map();
		}
	}
}
