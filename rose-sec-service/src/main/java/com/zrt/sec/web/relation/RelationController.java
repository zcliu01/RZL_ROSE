package com.zrt.sec.web.relation;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.sec.service.relation.RelationService;

/**
 * Created by dwliu on 2017/9/14.
 */

@RestController
@RequestMapping("/v1.0/sec")
public class RelationController {

	private static final Logger log = LoggerFactory.getLogger(RelationController.class);
	@Resource(name = "relationServiceImpl")
	private RelationService relationService;

	/**
	 * 员工管理-员工领导信息查询
	 *
	 * @param appMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/relationSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> relationSearch(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的RelationController中relationSearch方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> dataMap = relationService.relationSearch(appMap);
			resultMap.data(dataMap.get("data"));
			return resultMap.success().map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("查询员工领导信息失败!").map();
		}
	}

	/**
	 * 员工管理-员工领导更新
	 *
	 * @param appMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/relationUpdate", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> relationUpdate(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的RelationController中relationUpdate方法");
		ResultMap resultMap = new ResultMap();
		try {
			relationService.relationUpdate(appMap);
			resultMap.success().sucmsg("更新成功!");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("修改员工领导信息失败!").map();
		}
	}
	
	
	/**
	 * 员工管理-员工领导信息查询
	 *
	 * @param appMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/upManageSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> upManageSearch(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的RelationController中upManageSearch方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> dataMap = relationService.upManageSearch(appMap);
			resultMap.data(dataMap.get("data"));
			return resultMap.success().map();
		} catch (Exception e) {
			log.error("json error", e);
			 return resultMap.failure().errmsg("查询员工领导信息失败!").map();
		}
	}
}
