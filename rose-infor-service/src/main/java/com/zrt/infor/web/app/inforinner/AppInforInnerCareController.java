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
@RequestMapping("/v1.0/appInforInnerCare")
public class AppInforInnerCareController {
	private static final Logger log = LoggerFactory.getLogger(AppInforInnerCareController.class);

	@Autowired
	private InforInnerService inforInnerService;
	@Autowired
	private InforCommonsService inforCommonsService;

	/**
	 * 关注讯息分类
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dicList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> dicList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppInforInnerCareController中dicList方法");
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
	 * 关注讯息分类新增
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dicAdd", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> dicAdd(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppInforInnerCareController中dicAdd方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> dicIdMap=inforCommonsService.appDicAdd(map);
			resultMap.data(dicIdMap);
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
			String dicId = map.get("dic_id").toString();
			String empId = map.get("emp_id").toString();
			Map<String, Object> data = null;
			if (list != null && list.size() > 0) {
				for (int m = 0; m < list.size(); m++) {
					data = list.get(m);
					inforCommonsService.concernInfor(data, dicId, empId);
					resultMap.success().sucmsg("关注成功!");
				}
			}
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
}
