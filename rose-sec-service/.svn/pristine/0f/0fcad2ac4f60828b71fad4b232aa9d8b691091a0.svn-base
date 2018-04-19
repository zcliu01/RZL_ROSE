package com.zrt.sec.web.roleFlow;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.AppException;
import com.zrt.commons.PageInit;
import com.zrt.commons.ResultMap;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.mybatis.domain.SysSecRole;
import com.zrt.sec.service.role.RoleService;

/**
 * 流程角色管理
 * @author 
 *
 */
@RestController
@RequestMapping("/v1.0/secFlow")
public class RoleFlowController {
	private static final Logger log = LoggerFactory.getLogger(RoleFlowController.class);
	@Resource(name = "roleServiceImpl")
	private RoleService roleService;

	/**
	 * 用户角色管理-用户角色列表查询
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/roleList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> roleList(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的RoleFlowController中roleList方法");
		ResultMap resultMap = new ResultMap();
		try {
			PageInit.setPage(appMap);
			PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
					Integer.parseInt(appMap.get("maxResult").toString()));

			// 获取用户角色列表
			appMap.put("role_type", "2");// 角色类型；1：审批角色;2:流程角色
			List<SysSecRole> dataList = roleService.roleList(appMap);

			List<Map<String, Object>> list = MapEntityConverter.getMapFromList(
					new String[] { "role_id", "role_code", "role_name", "role_desc" }, dataList, SysSecRole.class);

			PageInfo<SysSecRole> pageInfo = new PageInfo<>(dataList);

			resultMap.data(list);
			resultMap.success().map().put("count", pageInfo.getTotal());

			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("员工信息查询失败!").map();
		}
	}

	/**
	 * 用户角色管理-用户角色信息查询
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/roleSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> roleSearch(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的RoleFlowController中roleSearch方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 获取用户角色信息
			Map<String, Object> data = roleService.roleSearch(appMap);
			resultMap.data(data);
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("查询用户角色信息失败!");
		}
	}

	/**
	 * 用户角色管理-用户角色新增
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/roleSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> roleSave(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的RoleFlowController中roleSave方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 用户角色新增
			appMap.put("role_type", "2");// 角色类型；1：审批角色;2:流程角色
			roleService.roleSave(appMap);
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
		log.info("Server端的RoleFlowController中roleUpdate方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 用户角色更新
			roleService.roleUpdate(appMap);
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
		log.info("Server端的RoleFlowController中roleDeleter方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 用户角色删除
			appMap.put("role_type", "2");// 角色类型；1：审批角色;2:流程角色
			roleService.roleDelete(appMap);
			resultMap.success().sucmsg("删除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("角色删除失败!").map();
		}
	}

	/**
	 * 用户角色管理-根据角色查询用户信息
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/roleUserList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> roleUserList(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的RoleFlowController中userRoleList方法");
		ResultMap resultMap = new ResultMap();
		try {
			if (appMap.get("begin_entry_time") != null && !"".equals(appMap.get("begin_entry_time"))) {
				appMap.put("begin_entry_time",
						appMap.get("begin_entry_time").toString().replaceAll("-", "") + "000000");
			}
			if (appMap.get("end_entry_time") != null && !"".equals(appMap.get("end_entry_time"))) {
				appMap.put("end_entry_time", appMap.get("end_entry_time").toString().replaceAll("-", "") + "235959");
			}
			if (appMap.get("begin_create_date_time") != null && !"".equals(appMap.get("begin_create_date_time"))) {
				appMap.put("begin_create_date_time",
						appMap.get("begin_create_date_time").toString().replaceAll("-", "") + "000000");
			}
			if (appMap.get("end_create_date_time") != null && !"".equals(appMap.get("end_create_date_time"))) {
				appMap.put("end_create_date_time",
						appMap.get("end_create_date_time").toString().replaceAll("-", "") + "235959");
			}
			if (appMap.get("f_join_start_time") != null && !"".equals(appMap.get("f_join_start_time"))) {
				appMap.put("f_join_start_time",
						appMap.get("f_join_start_time").toString().replaceAll("-", "") + "000000");
			}
			if (appMap.get("f_join_end_time") != null && !"".equals(appMap.get("f_join_end_time"))) {
				appMap.put("f_join_end_time", appMap.get("f_join_end_time").toString().replaceAll("-", "") + "235959");
			}
			Map<String, Object> resMap = roleService.roleUserList(appMap);
			resultMap.data(resMap.get("data"));
			resultMap.success().map().put("count", resMap.get("count"));
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("根据角色查询用户信息失败!").map();
		}
	}

	/**
	 * 用户角色管理-用户角色删除
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/roleEmpDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> roleEmpDelete(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的RoleFlowController中roleEmpDelete方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 用户角色删除
			roleService.roleEmpDelete(appMap);
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
		log.info("Server端的RoleFlowController中roleEmpBatchDelete方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 用户角色删除
			roleService.roleEmpBatchDelete(appMap);
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
		log.info("Server端的RoleFlowController中roleEmpAdd方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 用户角色删除
			roleService.roleEmpAdd(appMap);
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

	/**
	 * 用户角色管理-用户角色列表查询
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/roleAllList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> roleAllList(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的RoleFlowController中roleAllList方法");
		ResultMap resultMap = new ResultMap();
		try {

			// 获取用户角色列表
			appMap.put("role_type", "2");// 角色类型；1：审批角色;2:流程角色
			List<SysSecRole> dataList = roleService.roleList(appMap);

			List<Map<String, Object>> list = MapEntityConverter.getMapFromList(
					new String[] { "role_id", "role_code", "role_name", "role_desc" }, dataList, SysSecRole.class);
			resultMap.success().data(list);
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("角色信息查询失败!").map();
		}
	}
	
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
			appMap.put("role_type", "2");// 角色类型；1：审批角色;2:流程角色
			Map<String, Object> dataMap = roleService.roleFlowList(appMap);

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

			// 获取用户角色列表
			appMap.put("role_type", "2");// 角色类型；1：审批角色;2:流程角色
			roleService.roleFlowSet(appMap);
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
