package com.zrt.infor.web.manage.commons;

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

/**
 * Created by msKui on 2017/3/21.
 */
@RestController
@RequestMapping("/v1.0/inforCommons")
public class InforCommonsController {
	private static final Logger log = LoggerFactory.getLogger(InforCommonsController.class);

	@Autowired
	private InforCommonsService inforCommonsService;

	/**
	 * 普通讯息详情
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDetail", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforDetail(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中inforDetail方法");
		ResultMap resultMap = new ResultMap();
		try {
			List<Map<String, Object>> data = inforCommonsService.getInfoDetail(map);
			resultMap.data(data);
			resultMap.success();
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("讯息详情查询失败!").map();
		}
	}

	/**
	 * 关注讯息详情
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforCareDetail", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforCareDetail(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中inforCareDetail方法");
		ResultMap resultMap = new ResultMap();
		try {
			List<Map<String, Object>> data = inforCommonsService.getInfoCareDetail(map);
			resultMap.data(data);
			resultMap.success();
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("讯息详情查询失败!").map();
		}
	}

	/**
	 * 讯息办结（只能针对接收人）
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeInforDeal", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> changeInforDeal(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中changeInforDeal方法");
		ResultMap resultMap = new ResultMap();
		try {
			inforCommonsService.changeInforStatus(map, "deal");
			resultMap.success().sucmsg("办结成功!");
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
	 * 讯息已阅（只能针对接收人）
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeInforRead", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> changeInforRead(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中changeInforRead方法");
		ResultMap resultMap = new ResultMap();
		try {
			inforCommonsService.changeInforStatus(map, "read");
			resultMap.success().sucmsg("已阅!");
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
	 * 隐藏讯息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforHidden", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforHidden(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中inforHidden方法");
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
	 * 批量隐藏讯息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforHiddenBatch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforHiddenBatch(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中inforHiddenBatch方法");
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
	 * 批量取消隐藏讯息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforCancelHiddenBatch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforCancelHiddenBatch(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中inforCancelHiddenBatch方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			if (list != null && list.size() > 0) {
				for (Map<String, Object> inforNoMap : list) {
					inforNoMap.put("emp_id", map.get("emp_id"));
					inforCommonsService.inforCancelHidden(inforNoMap);
				}
			}
			resultMap.success().sucmsg("取消隐藏讯息成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("取消隐藏讯息失败!").map();
		}
	}

	/**
	 * 添加关注
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/concernInfor", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> concernInfor(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中concernInfor方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			String dicId = (String) map.get("dic_id");
			String empId = (String) map.get("emp_id");

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
	@RequestMapping(value = "/concernInforCancel", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> concernInforCancel(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中concernInforCancel方法");
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
	 * 批量取消关注
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/concernInforBatchCancel", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> concernInforBatchCancel(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中concernInforBatchCancel方法");
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
	 * 关注讯息分类新增
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dicAdd", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> dicAdd(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中dicAdd方法");
		ResultMap resultMap = new ResultMap();
		try {
			inforCommonsService.dicAdd(map);
			resultMap.success().sucmsg("关注讯息分类新增成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("关注讯息分类新增失败!").map();
		}
	}

	/**
	 * 关注讯息分类查询
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dicList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> dicList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中dicList方法");
		ResultMap resultMap = new ResultMap();
		try {
			List<Map<String, Object>> data = inforCommonsService.dicList(map);
			resultMap.data(data);
			resultMap.success();
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("关注讯息分类查询查询失败!").map();
		}
	}

	/**
	 * 撤销讯息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforCancel", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforCancel(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中inforCancel方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			if (list != null && list.size() > 0) {
				for (Map<String, Object> inforNoMap : list) {
					inforCommonsService.inforCancel(inforNoMap);
				}
			}
			resultMap.success().sucmsg("撤销讯息成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("撤销讯息失败!").map();
		}
	}

	/**
	 * 首页讯息未阅数量
	 */
	@RequestMapping(value = "/inforCount", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforCount(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中inforCount方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = inforCommonsService.getInforCount(map);
			resultMap.data(resMap);
			resultMap.success();
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("撤销讯息失败!").map();
		}
	}

}
