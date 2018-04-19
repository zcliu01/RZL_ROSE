package com.zrt.infor.web.manage.scheduleInfor;

import java.util.List;
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
import com.zrt.infor.service.commons.InforCommonsService;
import com.zrt.infor.service.inforCategory.InforCategoryService;

@RestController
@RequestMapping("/v1.0/scheduleInfor")
public class ScheduleInforController {
	private static final Logger log = LoggerFactory.getLogger(ScheduleInforController.class);

	@Autowired
	private InforCommonsService inforCommonsService;
	@Autowired
	private InforCategoryService inforCategoryService;

	/**
	 * 全部列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/scheduleAllList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> scheduleAllList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中scheduleAllList方法");
		ResultMap resultMap = new ResultMap();
		try {
			map.put("category", "dayInfor");
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			Map<String, Object> resMap = inforCategoryService.getStatusList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程讯息全部列表查询失败!").map();
		}
	}

	/**
	 * 待阅列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/scheduleNoReadList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> scheduleNoReadList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中scheduleNoReadList方法");
		ResultMap resultMap = new ResultMap();
		try {
			map.put("category", "dayInfor");
			map.put("status", "0");
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			Map<String, Object> resMap = inforCategoryService.getStatusList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程讯息待阅列表查询失败!").map();
		}
	}

	/**
	 * 已阅列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/scheduleReadList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> scheduleReadList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中scheduleReadList方法");
		ResultMap resultMap = new ResultMap();
		try {
			map.put("category", "dayInfor");
			map.put("status", "1");
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			Map<String, Object> resMap = inforCategoryService.getStatusList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程讯息已阅列表查询失败!").map();
		}
	}

	/**
	 * 已办列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/scheduleDealList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> scheduleDealList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中scheduleDealList方法");
		ResultMap resultMap = new ResultMap();
		try {
			map.put("category", "dayInfor");
			map.put("status", "3");
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			Map<String, Object> resMap = inforCategoryService.getStatusList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程讯息已办列表查询失败!").map();
		}
	}

	/**
	 * 关注列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/scheduleCareList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> scheduleCareList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中scheduleCareList方法");
		ResultMap resultMap = new ResultMap();
		try {
			map.put("category", "dayInfor");
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			Map<String, Object> resMap = inforCategoryService.getCareAllList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程讯息关注列表查询失败!").map();
		}
	}

	/**
	 * 已阅
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeScheduleRead", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> changeScheduleRead(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中changeScheduleRead方法");
		ResultMap resultMap = new ResultMap();
		try {
			inforCommonsService.changeInforStatus(map, "read");
			resultMap.success().sucmsg("已阅成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("操作失败!").map();
		}
	}

	/**
	 * 已办
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeScheduleDeal", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> changeScheduleDeal(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中changeScheduleDeal方法");
		ResultMap resultMap = new ResultMap();
		try {
			inforCommonsService.changeInforStatus(map, "deal");
			resultMap.success().sucmsg("已办成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("办结失败!").map();
		}
	}

	/**
	 * 关注
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/careSchedule", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> careSchedule(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中careSchedule方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			String dicId = map.get("dic_id").toString();
			String empId = map.get("emp_id").toString();

			if (list != null && list.size() > 0) {
				for (Map<String, Object> inforNoMap : list) {
					inforCommonsService.concernInfor(inforNoMap, dicId, empId);
				}
			}
			resultMap.success().sucmsg("关注成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("关注失败!").map();
		}
	}

	/**
	 * 取消关注
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/careCancel", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> careCancel(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中careCancel方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			if (list != null && list.size() > 0) {
				for (Map<String, Object> inforNoMap : list) {
					inforCommonsService.concernInforCancel(inforNoMap);
				}
			}
			resultMap.success();
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("取消关注失败!").map();
		}
	}

	/**
	 * 隐藏讯息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/hiddenSchedule", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> hiddenSchedule(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中hiddenSchedule方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			if (list != null && list.size() > 0) {
				for (Map<String, Object> inforNoMap : list) {
					inforNoMap.put("emp_id", map.get("emp_id"));
					inforCommonsService.inforHidden(inforNoMap);
				}
			}
			resultMap.success().sucmsg("隐藏讯息成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("隐藏讯息失败!").map();
		}
	}

}
