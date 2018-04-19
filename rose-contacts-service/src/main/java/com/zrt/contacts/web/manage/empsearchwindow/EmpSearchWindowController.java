package com.zrt.contacts.web.manage.empsearchwindow;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.contacts.service.empsearchwindow.EmpSearchWindowService;

/**
 * 查找员工弹出框。 会有多种类型。 Created by msKui on 2017/3/3.
 */
@Service
@RestController
@RequestMapping("/v1.0/empSearchWindow")
public class EmpSearchWindowController {
	private static final Logger log = LoggerFactory.getLogger(EmpSearchWindowController.class);

	@Autowired
	private EmpSearchWindowService empSearchWindowService;

	/**
	 * 创建我的群组中的，组织机构综合展示（树）
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/moreRootFriendTree", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> moreRootFriendTree(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的EmpSearchWindowController中friendGroupSave方法");
		ResultMap resultMap = new ResultMap();

		try {
			String rootId = map.get("root_id") == null ? null : map.get("root_id").toString();

			if (StringUtils.isBlank(rootId))
				throw new AppException("传入参数错误!");

			// TODO 获取当前登陆者
			String register = "2";
			map.put("register", register);

			List<Map<String, Object>> list = empSearchWindowService.treeRoute(map);

			resultMap.success().data(list);
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("查找失败!");
		}
	}

	/**
	 * 创建我的群组中的，组织机构下面对应员工的展示（树）
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/moreMateSearchTree", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> moreMateSearchTree(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的EmpSearchWindowController中moreMateTree方法");
		ResultMap resultMap = new ResultMap();

		try {
			List<Map<String, Object>> list = empSearchWindowService.treeEmpRoute(map);
			resultMap.success().data(list);
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("pc端联系人树形列表查询失败!").map();
		}

	}

	/**
	 * 通用的联系人搜索功能,可根据员工id、员工编号、员工全拼、员工简写、员工姓名、部门姓名、部门Id
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/commonEmpSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> commonEmpSearch(@RequestBody Map<String, Object> map) throws Exception {
		ResultMap resultMap = new ResultMap();

		try {
			List<Map<String, Object>> list = empSearchWindowService.commonEmpSearch(map);
			resultMap.success().data(list);
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("通用的联系人搜索查询失败!").map();
		}

	}

	/**
	 * 讯息收件人按职级排序--迭代4
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/infoReceiverOrderByRank", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> infoReceiverOrderByRank(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的EmpSearchWindowController中infoReceiverOrderByRank方法");
		ResultMap resultMap = new ResultMap();

		try {
			List<Map<String, Object>> list = empSearchWindowService.infoReceiverOrderByRank(map);
			resultMap.success().data(list);
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("讯息收件人按职级排序失败!").map();
		}

	}

	/**
	 * 6.5查询员工信息(会议服务提供)
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/meetEmpInfo", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> meetEmpInfo(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的EmpSearchWindowController中meetEmpInfo方法");
		ResultMap resultMap = new ResultMap();

		try {
			Map<String, Object> resMap = empSearchWindowService.meetEmpInfo(map);
			resultMap.success().data(resMap);
			return resultMap.map();
		} catch (AppException e) {
			log.error("error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("error", e);
			return resultMap.failure().errmsg("参会人员信息查询失败").map();
		}

	}

	/**
	 * 查询员工所在的所有部门
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/empOrgInfo", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> empOrgInfo(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的EmpSearchWindowController中empOrgInfo方法");
		ResultMap resultMap = new ResultMap();

		try {
			Map<String, Object> resMap = empSearchWindowService.empOrgInfo(map);
			resultMap.success().data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			log.error("error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("error", e);
			return resultMap.failure().errmsg("参会人员信息查询失败").map();
		}

	}

	/**
	 * 根据部门id查询该部门下所有的员工
	 */

	@RequestMapping(value = "/selectByOrg", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> selectByOrg(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的EmpSearchWindowController中selectByOrg方法");
		ResultMap resultMap = new ResultMap();

		try {
			Map<String, Object> resMap = empSearchWindowService.selectByOrg(map);
			resultMap.success().data(resMap);
			return resultMap.map();
		} catch (AppException e) {
			log.error("error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("error", e);
			return resultMap.failure().errmsg("根据部门查询员工失败").map();
		}

	}

}
