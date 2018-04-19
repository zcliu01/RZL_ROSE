package com.zrt.flow.web.manage.roleFlow;

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
import com.zrt.flow.service.roleCheck.RoleCheckService;

@RestController
@RequestMapping("/v1.0/secFlow")
public class RoleFlowController {
	private static final Logger log = LoggerFactory.getLogger(RoleFlowController.class);

	@Autowired
	private RoleCheckService roleCheckService;

	/**
	 * 用户角色管理-用户角色列表查询
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/roleFlowList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> roleFlowList(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的RoleFlowController中roleFlowList方法");
		ResultMap resultMap = new ResultMap();
		try {

			// 获取用户角色列表
			Map<String, Object> dataMap = roleCheckService.roleFlowList(appMap);
			resultMap.success().data(dataMap);
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("角色绑定流程信息查询失败!").map();
		}
	}
	
	/**
	 * 用户角色管理-用户角色绑定流程
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/roleFlowSet", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> roleFlowSet(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的RoleFlowController中roleFlowSet方法");
		ResultMap resultMap = new ResultMap();
		try {

			roleCheckService.roleFlowSet(appMap);
			resultMap.success().sucmsg("绑定成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("角色绑定流程信息失败!").map();
		}
	}
}
