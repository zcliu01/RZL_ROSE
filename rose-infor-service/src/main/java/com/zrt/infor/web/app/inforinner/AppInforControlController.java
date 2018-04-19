package com.zrt.infor.web.app.inforinner;

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
import com.zrt.infor.service.inforControl.InforControlService;
import com.zrt.infor.service.inforinner.InforInnerService;

@RestController
@RequestMapping("/v1.0/appInforControl")
public class AppInforControlController {
	private static final Logger log = LoggerFactory.getLogger(AppInforControlController.class);

	@Autowired
	private InforControlService inforControlService;
	@Autowired
	private InforInnerService inforInnerService;

	/**
	 * 所有发送讯息列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/withInforList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> withInforList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforControlController中withInforList方法");
		ResultMap resultMap = new ResultMap();

		try {
			// 拼接参数
			// TODO 登录emp_ID
			map.put("sender_emp_id", map.get("emp_id"));// 发件人id
			// 内部讯息类型
			map.put("category", "innerInfor");
			// 发送状态为1-发送状态
			map.put("send_status", "1");
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			map.put("is_show", "1");// 默认都显示

			String receiverIds = map.get("receiver_id") == null ? null : map.get("receiver_id").toString();
			String[] senderIdArr = null;
			if (StringUtils.isNotBlank(receiverIds))
				senderIdArr = receiverIds.split(";");
			map.put("receiverIdArr", senderIdArr);

			Map<String, Object> resMap = inforInnerService.inforOutboxListMap(map);

			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("发件列表查询失败!").map();
		}
	}

	/**
	 * 监控详情
	 */
	@RequestMapping(value = "/withInforDetails", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> withInforDetails(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforControlController中withInforDetails方法");

		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> resMap = inforControlService.getAppControlDetails(map);
			resultMap.success();
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("监控详情查询失败!").map();
		}
	}

	/**
	 * 监控详情搜索
	 */
	@RequestMapping(value = "/inforDetailsSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforDetailsSearch(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforControlController中inforDetailsSearch方法");

		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> resMap = inforControlService.getAppDetailsSearch(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("监控详情搜索失败!").map();
		}
	}

	/**
	 * 发送给某个员工所有信息列表
	 */
	@RequestMapping(value = "/withEmpList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> withEmpList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforControlController中withEmpList方法");

		ResultMap resultMap = new ResultMap();
		try {

			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			Map<String, Object> resMap = inforControlService.getAppWithEmpList(map);
			resultMap.success().map();
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("发送给某个员工所有信息列表失败!").map();
		}
	}

	/**
	 * 发送给某位员工的所有信息列表搜索
	 */
	@RequestMapping(value = "/inforEmpSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforEmpSearch(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforControlController中inforEmpSearch方法");

		ResultMap resultMap = new ResultMap();
		try {
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			Map<String, Object> resMap = inforControlService.getInforEmpSearch(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("发送给某个员工所有信息列表失败!").map();
		}
	}
}
