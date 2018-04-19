package com.zrt.infor.web.app.inforinner;

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
import com.zrt.infor.service.inforinner.InforInnerService;

/**
 * Created by msKui on 2017/3/21.
 */
@RestController
@RequestMapping("/v1.0/appInforInner")
public class AppInforInnerController {
	private static final Logger log = LoggerFactory.getLogger(AppInforInnerController.class);

	@Autowired
	private InforInnerService inforInnerService;
	@Autowired
	private InforCommonsService inforCommonsService;

	/**
	 * 讯息收件列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/inforList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的AppInforInnerController中inforList方法");

		ResultMap resultMap = new ResultMap();

		try {
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			// 拼接参数
			// TODO 登录ID
			map.put("receiver_emp_id", map.get("emp_id"));
			map.put("sender_emp_id", map.get("emp_id"));

			Map<String, Object> resMap = inforInnerService.appInfoList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("讯息查询失败!").map();
		}
	}

	/**
	 * 讯息已阅、已办
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDeal", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforDeal(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppInforInnerController中inforDeal方法");
		ResultMap resultMap = new ResultMap();
		try {
			inforCommonsService.changeInforStatus(map, "app");
			resultMap.success().sucmsg("操作成功!");
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
	 * 讯息隐藏、显示
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforShowHid", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforShowHid(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppInforInnerController中inforShowHid方法");
		ResultMap resultMap = new ResultMap();
		try {
			inforCommonsService.inforShowHid(map);
			resultMap.success().sucmsg("操作成功!");
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
	 * 讯息删除
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforDelete(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppInforInnerController中inforDelete方法");
		ResultMap resultMap = new ResultMap();
		try {
			inforCommonsService.inforDelete(map);
			resultMap.success().sucmsg("删除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("删除失败!").map();
		}
	}

	/**
	 * 普通讯息详情
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDetail", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforDetail(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppInforInnerController中inforDetail方法");
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
		log.info("Server端的AppInforInnerController中inforCareDetail方法");
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
	 * 草稿发送
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDraftSend", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforDraftSend(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppInforInnerController中inforDraftSend方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			if (list != null && list.size() > 0) {
				for (Map<String, Object> inforNoMap : list) {
					inforInnerService.inforDraftSend(inforNoMap);
				}
			}
			resultMap.success().sucmsg("发送成功!");
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
	 * 草稿删除
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDraftDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforDraftDelete(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppInforInnerController中inforDraftDelete方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			if (list != null && list.size() > 0) {
				for (Map<String, Object> inforNoMap : list) {
					inforInnerService.inforDraftDelete(inforNoMap);
				}
			}
			resultMap.success().sucmsg("删除成功!");
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
	 * 讯息待阅标识
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforCountFlag", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforCountFlag(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppInforInnerController中inforCountFlag方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = inforCommonsService.getInforCount(map);
			int inforCount = Integer.valueOf(resMap.get("inner_count").toString())
					+ Integer.valueOf(resMap.get("flow_count").toString())
					+ Integer.valueOf(resMap.get("doc_count").toString())
					+ Integer.valueOf(resMap.get("pub_count").toString())
					+ Integer.valueOf(resMap.get("ask_count").toString())
					+ Integer.valueOf(resMap.get("day_count").toString());
			resMap.put("infor_count", inforCount);
			resultMap.data(resMap);
			resultMap.success();
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("获取待阅标识失败!").map();
		}
	}
}
