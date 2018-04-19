package com.zrt.flow.web.manage.checkRole;

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
@RequestMapping("/v1.0/roleCheck")
public class CheckRoleController {
	private static final Logger log = LoggerFactory.getLogger(CheckRoleController.class);

	@Autowired
	private RoleCheckService roleCheckService;

	/**
	 * 用户角色管理-用户角色新增
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/roleSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> roleSave(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的RoleController中roleSave方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 用户角色新增
			roleCheckService.roleSave(appMap);
			resultMap.success().sucmsg("新增成功!");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("用户角色新增失败!");
		}
	}

	/**
	 * 用户角色管理-用户角色更新
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/roleUpdate", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> roleUpdate(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的RoleController中roleUpdate方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 用户角色更新
			roleCheckService.roleUpdate(appMap);
			resultMap.success().sucmsg("更新成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("员工信息更新失败!").map();
		}
	}

	/**
	 * 用户角色管理-用户角色删除
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/roleDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> roleDelete(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的RoleController中roleDeleter方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 用户角色删除
			roleCheckService.roleDelete(appMap);
			resultMap.success().sucmsg("删除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("员工信息删除失败!").map();
		}
	}

	// 角色用户批量删除
	@RequestMapping(value = "/roleEmpBatchDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> roleEmpBatchDelete(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的RoleController中roleEmpBatchDelete方法");
		ResultMap resultMap = new ResultMap();
		try {
			roleCheckService.roleEmpBatchDelete(appMap);
			resultMap.success().sucmsg("删除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("员工信息删除失败!").map();
		}
	}

	// 角色绑定用户
	@RequestMapping(value = "/roleEmpAdd", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> roleEmpAdd(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的RoleController中roleEmpAdd方法");
		ResultMap resultMap = new ResultMap();
		try {
			roleCheckService.roleEmpAdd(appMap);
			resultMap.success().sucmsg("绑定成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("角色绑定员工信息失败!").map();
		}
	}

}
