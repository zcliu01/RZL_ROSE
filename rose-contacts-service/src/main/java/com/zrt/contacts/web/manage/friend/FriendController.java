package com.zrt.contacts.web.manage.friend;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.client.sec.ISecClient;
import com.zrt.commons.AppException;
import com.zrt.commons.PageInit;
import com.zrt.commons.ResultMap;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.contacts.service.friend.FriendService;
import com.zrt.contacts.service.serial.SerialService;
import com.zrt.contacts.service.sys.SysSecEmpService;
import com.zrt.contacts.service.sys.SysSecOrgService;
import com.zrt.mybatis.domain.EmpContactsFriend;

/**
 * Created by msKui on 2017/3/3.
 */
@RestController
@RequestMapping("/v1.0/friend")
public class FriendController {

	private static final Logger log = LoggerFactory.getLogger(FriendController.class);

	@Resource(name = "HystrixSecClient")
	private ISecClient secClient;
	@Autowired
	private FriendService friendService;
	@Autowired
	private SysSecEmpService sysSecEmpService;
	@Autowired
	private SysSecOrgService sysSecOrgService;
	@Autowired
	private SerialService serialService;

	/**
	 * PC端添加常用联系人
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/friendSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> friendSave(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的FriendController中friendSave方法");

		if (map.size() <= 0 || null == map.get("friend_emp_id"))
			throw new AppException("传入的参数错误");

		ResultMap resultMap = new ResultMap();

		try {
			Integer friendSaveCount = friendService.friendSave(map);
			if (friendSaveCount == -2) {
				resultMap.success().sucmsg("您不能添加自己!");
			}
			if (friendSaveCount == -1||friendSaveCount == 0) {
				resultMap.success().sucmsg("您已添加该员工为常用联系人!");
			} else if (friendSaveCount > 0) {
				resultMap.success().sucmsg("新增成功!");
			}

			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("常用联系人新增失败!");
		}

	}

	@RequestMapping(value = "/getMoreFriend", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<EmpContactsFriend> getMoreFriend(@RequestBody String empId, String friendEmpId, String creatDateTime) {
		List<EmpContactsFriend> list = new ArrayList<>();

		String[] fEIdArr = friendEmpId.split(",");
		EmpContactsFriend contactsFriend;
		for (String str : fEIdArr) {
			if (StringUtils.isBlank(str))
				break;

			contactsFriend = new EmpContactsFriend();
			contactsFriend.setFriendId(serialService.getSerialNumberFromDB("plat_infor_friend"));
			contactsFriend.setEmpId(empId);
			contactsFriend.setFriendEmpId(str.trim());
			contactsFriend.setCreateDateTime(creatDateTime);

			list.add(contactsFriend);
		}

		return list;
	}

	/**
	 * 根据主键查询常用联系人的信息。
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/friendSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> friendSearch(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的FriendController中friendSearch方法");

		if (map.size() <= 0 || map.get("emp_id") == null)
			throw new AppException("传入的参数错误");

		ResultMap resultMap = new ResultMap();

		try {
			Map<String, Object> data = friendService.friendSearch(map.get("emp_id").toString());

			resultMap.success().data(data);
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("获取常用联系人失败!");
		}
	}

	/**
	 * 删除常用联系人。
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/friendDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> friendDelete(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的FriendController中friendDelete方法");
		ResultMap resultMap = new ResultMap();

		try {
			if (map.size() <= 0 || map.get("friend_emp_id").toString().equals(""))
				throw new AppException("传入的参数错误");

			String empId = (String) map.get("emp_id");
			EmpContactsFriend contactsFriend = new EmpContactsFriend();
			// TODO 获取当前登录人的ID
			// String empId = "2";
			contactsFriend.setEmpId(empId);
			contactsFriend.setFriendEmpId(map.get("friend_emp_id").toString());

			String[] friendEmpIdArr = contactsFriend.getFriendEmpId().split(";");
			if (friendEmpIdArr != null && friendEmpIdArr.length > 0)
				friendService.friendDelete(empId, friendEmpIdArr);
			else
				friendService.friendDelete(contactsFriend);

			resultMap.success().sucmsg("删除成功");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("常用联系人删除失败!");
		}
	}

	/**
	 * 常用联系人列表。
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/empList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> empList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的FriendController中empList方法");
		ResultMap resultMap = new ResultMap();

		try {

			List<Map<String, Object>> listMap = friendService.empList(map);

			PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(listMap);

			resultMap.success().map().put("count", pageInfo.getTotal());
			resultMap.data(listMap);
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("获取常用联系人列表失败!");
		}
	}

	/**
	 * 机构员工列表。
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/orgEmpList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> orgEmpList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的FriendController中orgEmpList方法");
		ResultMap resultMap = new ResultMap();

		try {

			if (map.get("f_join_start_time") != null && !"".equals(map.get("f_join_start_time"))) {
				map.put("f_join_start_time", map.get("f_join_start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("f_join_end_time") != null && !"".equals(map.get("f_join_end_time"))) {
				map.put("f_join_end_time", map.get("f_join_end_time").toString().replaceAll("-", "") + "235959");
			}

			List<Map<String, Object>> listMap = friendService.orgEmpList(map);

			PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(listMap);

			resultMap.success().map().put("count", pageInfo.getTotal());
			resultMap.data(listMap);
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("获取机构员工列表失败!");
		}
	}

	/**
	 * 云盘获取员工列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/ypEmpList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> ypEmpList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的FriendController中ypEmpList方法");
		ResultMap resultMap = new ResultMap();

		try {

			List<Map<String, Object>> listMap = friendService.ypEmpList(map);

			resultMap.data(listMap);
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("获取机构员工列表失败!");
		}
	}

	/**
	 * 获取常用联系人的，所有部门、职位和直接上级
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/getOrgPosition", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> getOrgPosition(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的FriendController中getOrgPosition方法");

		if (map.size() <= 0 || map.get("user_id") == null)
			throw new AppException("传入的参数错误");

		ResultMap resultMap = new ResultMap();

		try {
			List<Map<String, Object>> data = friendService.empSearch(map.get("user_id").toString(), null);

			resultMap.success().data(data);
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("获取常用联系人部门、职位和直接上级失败!");
		}
	}

	/**
	 * 获取员工履历信息
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/getWorkRedeploy", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> getWorkRedeploy(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的FriendController中getWorkRedeploy方法");
		ResultMap resultMap = new ResultMap();

		try {
			if (map.size() <= 0 || map.get("emp_id") == null)
				throw new AppException("传入的参数错误");

			List<Map<String, Object>> list = friendService.getWorkRedeploy(map.get("emp_id").toString());

			resultMap.success().data(list);
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("获取员工履历信息失败!");
		}
	}

	/**
	 * 组织机构列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/orgAllList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> orgList(@RequestBody Map<String, Object> appMap) throws AppException {
		log.info("Server端的FriendController中orgList方法");
		ResultMap resultMap = new ResultMap();

		try {
			/*
			 * if(appMap.size() <= 0 || appMap.get("emp_id") == null) throw new
			 * AppException("传入的参数错误");
			 */
			List<Map<String, Object>> list = friendService.orgAllList(appMap);
			// List<Map<String,Object>> list =
			// friendService.getWorkRedeploy(map.get("emp_id").toString());

			resultMap.success().data(list);
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("获取组织机构列表信息失败!");
		}
	}

	/**
	 * 待撤销部门列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/preCancelOrgList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> preCancelOrgList(@RequestBody Map<String, Object> appMap) throws AppException {
		log.info("Server端的FriendController中preCancelOrgList方法");
		ResultMap resultMap = new ResultMap();

		try {

			List<Map<String, Object>> list = sysSecOrgService.preCancelOrgList(appMap);

			resultMap.success().data(list);
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("获取待撤销部门列表信息失败!");
		}
	}

	/**
	 * 组织通讯录员工导出-3
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/exportEmpToExcel", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> exportEmpToExcel(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FriendController中exportEmpToExcel方法");
		ResultMap resultMap = new ResultMap();

		try {
			map.put("flag", "导出");
			List<Map<String, Object>> list = friendService.orgEmpList(map);
			resultMap.data(list);
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("导出组织通讯录失败!").map();
		}
	}

	/**
	 * 常用联系人导出--3
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/exportFriendToExcel", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> exportFriendToExcel(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FriendController中exportFriendToExcel方法");
		ResultMap resultMap = new ResultMap();

		try {
			map.put("flag", "导出");
			List<Map<String, Object>> listMap = friendService.empList(map);
			resultMap.data(listMap);

			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("导出常用联系人失败!").map();
		}
	}

	/**
	 * 组织通讯录员工打印。
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/orgEmpPrint", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> orgEmpPrint(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的FriendController中orgEmpPrint方法");
		ResultMap resultMap = new ResultMap();

		try {

			List<Map<String, Object>> listMap = friendService.orgEmpList(map);
			resultMap.data(listMap);
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("打印组织通讯录员工列表失败!");
		}
	}

	/**
	 * 常用联系人打印。
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/friendPrint", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> friendPrint(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的FriendController中friendPrint方法");
		ResultMap resultMap = new ResultMap();

		try {

			List<Map<String, Object>> listMap = friendService.empList(map);
			resultMap.data(listMap);
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("打印常用联系人列表失败!");
		}
	}

	/**
	 * 个人详情信息打印。
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/empDetailsPrint", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> empDetailsPrint(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的FriendController中empDetailsPrint方法");
		ResultMap resultMap = new ResultMap();

		try {
			List<Map<String, Object>> list = sysSecEmpService.selectEmpData(map);
			resultMap.success().data(list);
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("打印常用联系人列表失败!");
		}
	}

	/**
	 * PC端根据员工id 查询个人详情(基本信息+职位信息+履历信息)
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/selectEmpDetails", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> selectEmpDetails(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FriendController中selectEmpDetails方法");
		ResultMap resultMap = new ResultMap();
		try {
			List<Map<String, Object>> list = sysSecEmpService.selectEmpData(map);
			resultMap.success().data(list);
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("获取个人详情失败!").map();
		}

	}

	/**
	 * PC端修改个人信息(固定电话+移动电话+)
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/updateEmpDetails", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> updateEmpDetails(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FriendController中updateEmpDetails方法");
		ResultMap resultMap = new ResultMap();
		try {
			String type = (String) map.get("type");
			sysSecEmpService.updateEmpDetails(map);
			if (type == "0" || "0".equals(type)) {
				resultMap.success().sucmsg("留言更新成功!");
			} else {
				resultMap.success().sucmsg("提交成功,等待人事审核!");
			}
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("修改个人详情失败!").map();
		}

	}

	/**
	 * 个人详情信息导出--3
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/exportEmpDetailsToExcel", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> exportEmpDetailsToExcel(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FriendController中exportEmpDetailsToExcel方法");
		ResultMap resultMap = new ResultMap();

		try {
			List<Map<String, Object>> list = sysSecEmpService.selectEmpData(map);
			resultMap.success().data(list);
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("导出个人详情信息失败!").map();
		}
	}

	/**
	 * 获取所有的员工id。
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/searchAll", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> temp(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的FriendController中searchAll方法");
		ResultMap resultMap = new ResultMap();

		try {
			List<Map<String, Object>> listMap = sysSecEmpService.searchAll(map);
			resultMap.data(listMap);
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("获取所有员工id失败!").map();
		}
	}

}
