package com.zrt.infor.web.manage.publicityInfor;

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
@RequestMapping("/v1.0/publicityInfor")
public class PublicityInforController {
	private static final Logger log = LoggerFactory.getLogger(PublicityInforController.class);

	@Autowired
	private InforCommonsService inforCommonsService;
	@Autowired
	private InforCategoryService inforCategoryService;

	/**
	 * 全部列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/publicityAllList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> publicityAllList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中publicityAllList方法");
		ResultMap resultMap = new ResultMap();
		try {
			map.put("category", "pubInfor");
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
			return resultMap.failure().errmsg("公示讯息全部列表查询失败!").map();
		}
	}
	/**
	 * 待阅列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/publicityNoReadList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> publicityNoReadList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中publicityNoReadList方法");
		ResultMap resultMap = new ResultMap();
		try {
			map.put("category", "pubInfor");
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
			return resultMap.failure().errmsg("公示讯息待阅列表查询失败!").map();
		}
	}
	/**
	 * 已阅列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/publicityReadList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> publicityReadList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中publicityReadList方法");
		ResultMap resultMap = new ResultMap();
		try {
			map.put("category", "pubInfor");
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
			return resultMap.failure().errmsg("公示讯息已阅列表查询失败!").map();
		}
	}
	/**
	 * 已办列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/publicityDealList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> publicityDealList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中publicityDealList方法");
		ResultMap resultMap = new ResultMap();
		try {
			map.put("category", "pubInfor");
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
			return resultMap.failure().errmsg("公示讯息已办列表查询失败!").map();
		}
	}
	/**
	 * 关注列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/publicityCareList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> publicityCareList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowInforController中publicityCareList方法");
		ResultMap resultMap = new ResultMap();
		try {
			map.put("category", "pubInfor");
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
			return resultMap.failure().errmsg("公示讯息关注列表查询失败!").map();
		}
	}
	
	/**
	 * 已阅
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changePublicityRead", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> changePublicityRead(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中changePublicityRead方法");
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
	@RequestMapping(value = "/changePublicityDeal", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> changePublicityDeal(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中changePublicityDeal方法");
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
	@RequestMapping(value = "/carePublicity", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> carePublicity(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中carePublicity方法");
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
	@RequestMapping(value = "/hiddenPublicity", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> hiddenPublicity(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中hiddenPublicity方法");
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
