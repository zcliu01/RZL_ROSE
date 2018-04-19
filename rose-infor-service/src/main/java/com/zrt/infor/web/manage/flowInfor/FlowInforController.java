package com.zrt.infor.web.manage.flowInfor;

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
@RequestMapping("/v1.0/flowInfor")
public class FlowInforController {
	private static final Logger log = LoggerFactory.getLogger(FlowInforController.class);

	@Autowired
	private InforCommonsService inforCommonsService;
	@Autowired
	private InforCategoryService inforCategoryService;

	/**
	 * 全部列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/flowAllList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> flowAllList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中flowAllList方法");
		ResultMap resultMap = new ResultMap();
		try {
			map.put("category", "flowInfor");
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
	@RequestMapping(value = "/flowNoReadList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> flowNoReadList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中flowNoReadList方法");
		ResultMap resultMap = new ResultMap();
		try {
			map.put("category", "flowInfor");
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
	@RequestMapping(value = "/flowReadList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> flowReadList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中flowReadList方法");
		ResultMap resultMap = new ResultMap();
		try {
			map.put("category", "flowInfor");
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
	@RequestMapping(value = "/flowDealList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> flowDealList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中flowDealList方法");
		ResultMap resultMap = new ResultMap();
		try {
			map.put("category", "flowInfor");
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
	@RequestMapping(value = "/flowCareList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> flowCareList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中flowCareList方法");
		ResultMap resultMap = new ResultMap();
		try {
			map.put("category", "flowInfor");
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
	@RequestMapping(value = "/changeFlowRead", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> changeFlowRead(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中changeFlowRead方法");
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
	@RequestMapping(value = "/changeFlowDeal", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> changeFlowDeal(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中changeFlowDeal方法");
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
	@RequestMapping(value = "/careFlow", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> careFlow(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中careFlow方法");
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
		log.info("Server端的FlowInforController中careCancel方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			if (list != null && list.size() > 0) {
				for (Map<String, Object> inforNoMap : list) {
					inforCommonsService.concernInforCancel(inforNoMap);
				}
			}
			resultMap.success().sucmsg("取消关注成功!");
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
	@RequestMapping(value = "/hiddenFlow", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> hiddenFlow(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中hiddenFlow方法");
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

	/**
	 * 流程办理后自动已阅该流程讯息
	 */
	@RequestMapping(value = "/flowInforRead", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> flowInforRead(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中flowInforRead方法");
		ResultMap resultMap = new ResultMap();
		try {
			inforCommonsService.flowInforRead(map);
			resultMap.success().sucmsg("流程讯息已阅成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程讯息已阅失败!").map();
		}
	}

}
