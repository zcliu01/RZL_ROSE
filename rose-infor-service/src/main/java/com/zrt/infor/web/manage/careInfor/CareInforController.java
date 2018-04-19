package com.zrt.infor.web.manage.careInfor;

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
@RequestMapping("/v1.0/careInfor")
public class CareInforController {
	private static final Logger log = LoggerFactory.getLogger(CareInforController.class);

	@Autowired
	private InforCommonsService inforCommonsService;
	@Autowired
	private InforCategoryService inforCategoryService;

	/**
	 * 全部列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/careAllList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> careAllList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的CareInforController中careAllList方法");

		ResultMap resultMap = new ResultMap();

		try {
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
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("关注列表查询失败!").map();

		}
	}

	/**
	 * 待阅列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/careNoReadList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> careNoReadList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的CareInforController中careNoReadList方法");

		ResultMap resultMap = new ResultMap();

		try {
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			Map<String, Object> resMap = inforCategoryService.getCareList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("关注列表查询失败!").map();

		}
	}

	/**
	 * 已阅列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/careReadList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> careReadList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的CareInforController中careReadList方法");

		ResultMap resultMap = new ResultMap();

		try {
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			Map<String, Object> resMap = inforCategoryService.getCareList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("关注列表查询失败!").map();

		}
	}

	/**
	 * 已办列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/careDealList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> careDealList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的CareInforController中careDealList方法");

		ResultMap resultMap = new ResultMap();

		try {
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			Map<String, Object> resMap = inforCategoryService.getCareList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("关注列表查询失败!").map();

		}
	}

	/**
	 * 已阅
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeCareRead", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> changeCareRead(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的CareInforController中changeCareRead方法");
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
	@RequestMapping(value = "/changeCareDeal", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> changeCareDeal(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的CareInforController中changeCareDeal方法");
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
	 * 取消关注
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/careCancel", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> careCancel(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的CareInforController中careCancel方法");
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
	@RequestMapping(value = "/hiddenCare", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> hiddenCare(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的CareInforController中hiddenCare方法");
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
			resultMap.success().sucmsg("隐藏成功!");
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
