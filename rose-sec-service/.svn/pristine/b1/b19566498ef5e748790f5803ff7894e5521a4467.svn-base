package com.zrt.sec.service.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.client.vif.VifClient;
import com.zrt.commons.AppLoginException;
import com.zrt.commons.ad.AdUtils;
import com.zrt.commons.cons.Constants;
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.sign.CipherUtil;
import com.zrt.mybatis.domain.EmpLoginRecord;
import com.zrt.mybatis.domain.EmpVpnSync;
import com.zrt.mybatis.domain.EmpVpnSyncExample;
import com.zrt.mybatis.domain.SysSecEmp;
import com.zrt.mybatis.domain.SysSecEmpExample;
import com.zrt.mybatis.domain.SysSecEmpExample.Criteria;
import com.zrt.mybatis.mapper.EmpLoginRecordMapper;
import com.zrt.mybatis.mapper.EmpVpnSyncMapper;
import com.zrt.mybatis.mapper.SysSecEmpMapper;
import com.zrt.sec.mapper.login.LoginMapper;
import com.zrt.sec.service.redis.RedisService;
import com.zrt.sec.service.serial.SerialService;

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private RedisService redisService;

	@Autowired
	private LoginMapper loginMapper;
	@Autowired
	private SysSecEmpMapper sysSecEmpMapper;
	@Autowired
	private EmpVpnSyncMapper empVpnSyncMapper;
	@Autowired
	private SerialService serialService;
	@Autowired
	private EmpLoginRecordMapper empLoginRecordMapper;

	private final transient Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Resource(name = "HystrixvifClient")
	private VifClient vifClient;

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> login(Map<String, Object> appMap) throws Exception {
		String userAccount = (String) appMap.get("user_account");// 获取用户名
		String userPassword = (String) appMap.get("user_password");

		// 校验VPN设备信息
		vpnCheck(userAccount, (String) appMap.get("device_id"));

		// AD域校验
		AdUtils.connect("192.168.11.1", "389", userAccount, userPassword);

		// 根据用户名+密码查询user
		SysSecEmpExample example = new SysSecEmpExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpAccountEqualTo((String) appMap.get("user_account"));// 登录账户
		// criteria.andEmpPasswordEqualTo(CipherUtil.encrypt((String)
		// appMap.get("user_password")));// 登录密码
		// criteria.andEmpEnabledEqualTo(Constants.USER_SEC_ENABLED_1);// 登录状态

		List<SysSecEmp> userList = sysSecEmpMapper.selectByExample(example);
		SysSecEmp sysSecEmp = null;
		if (userList == null || userList.size() <= 0) {
			throw new AppLoginException("用户名或密码不正确!");
		} else {
			// 获取登录用户信息
			sysSecEmp = userList.get(0);
			String empEnable = sysSecEmp.getEmpEnabled();// 登录状态0:禁用；1：启用
			if ("0".equals(empEnable)) {
				throw new AppLoginException("该账号已禁用!");
			}
			String canLoginType = String.valueOf(sysSecEmp.getCanLoginType());
			if (StringUtils.isNotBlank(canLoginType)) {
				if ("2".equals(canLoginType)) {
					throw new AppLoginException("该账号只能通过手机端登录!");
				}else if("3".equals(canLoginType)){
					throw new AppLoginException("该账号暂时不能登录速飞!");
				}
			}
		}

		// token
		String token = UUID.randomUUID().toString().replaceAll("-", "");
		Map<String, Object> reMap = new HashMap<String, Object>();
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("token", token);
		userMap.put("emp_account", sysSecEmp.getEmpAccount());
		userMap.put("emp_enabled", sysSecEmp.getEmpEnabled());
		userMap.put("tenant_id", sysSecEmp.getTenantId());
		userMap.put("create_date_time", sysSecEmp.getCreateDateTime());
		userMap.put("update_date_time", sysSecEmp.getUpdateDateTime());
		userMap.put("emp_desc", sysSecEmp.getEmpDesc());
		reMap.put("empInfo", userMap);

		// 缓存登陆信息
		redisService.setInfo(Constants.USER_SEC_WEB_LOGIN, token, reMap);
		// 云盘登录
		Map<String, Object> ucdiskLoginMap = ucdiskLogin((String) appMap.get("user_account"));
		// logger.info("----ucdisk login infor==" + ucdiskLoginMap.toString());
		// 缓存云盘登录信息
		if (null != ucdiskLoginMap && !ucdiskLoginMap.isEmpty()) {

			redisService.setInfo(Constants.UCDISK_WEB_LOGIN_INFO, (String) appMap.get("user_account"), ucdiskLoginMap);
		}
		// 缓存员工信息
		// if(empMap.get("emp_id")!=null){
		// redisService.setInfo(Constants.USER_SEC_EMPINFO,
		// (String)empMap.get("emp_id"), empMap);
		// }

		String[] empArr = new String[1];
		empArr[0] = sysSecEmp.getEmpId();

		/*
		 * for(int i=0;i<empList.size();i++){
		 * empArr[i]=empList.get(i).getEmpId(); }
		 */
		// 获取用户拥有的角色,菜单列表
		Map<String, Object> roleReqMap = new HashMap<String, Object>();
		roleReqMap.put("empArr", empArr);
		// 获取所有菜单
		// List<Map<String, Object>> roleMenuList =
		// loginMapper.roleMenuList(roleReqMap);//原来的带按钮的版本
		Map<String, Object> menuReqMap = new HashMap<String, Object>();
		menuReqMap.put("emp_id", userAccount);
		List<Map<String, Object>> roleMenuList = loginMapper.newRoleMenuList(menuReqMap);
		List<Map<String, Object>> rsList = loginMapper.roleRsList(menuReqMap);
		if (roleMenuList != null && roleMenuList.size() > 0) {
			for (Map<String, Object> menuMap : roleMenuList) {
				List<Map<String, Object>> menuRsList = new ArrayList<Map<String, Object>>();
				String menuCode = (String) menuMap.get("menu_code");
				for (Map<String, Object> rsMap : rsList) {
					String rsMenuCode = (String) rsMap.get("menu_code");
					if (StringUtils.isNotBlank(rsMenuCode) && StringUtils.isNotBlank(menuCode)) {
						if (rsMap.get("menu_code").equals(menuCode)) {
							rsMap.remove("menu_code");
							menuRsList.add(rsMap);
						}
					}

				}
				menuMap.put("menuRsList", menuRsList);
			}
		}
		Map<String, Object> inforMap = new HashMap<String, Object>();
		inforMap.put("emp_id", sysSecEmp.getEmpId());
		// 员工信息
		Map<String, Object> empMap = loginMapper.empInfo(inforMap);
		// 返回给前端数据，token,拥有的菜单
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("token", token);
		resMap.put("emp_id", sysSecEmp.getEmpId());
		resMap.put("menuList", roleMenuList);
		resMap.put("empInfo", empMap);

		EmpLoginRecord loginRecord = new EmpLoginRecord();
		loginRecord.setEmpId(userAccount);
		// 获取redis中员工信息
		Map<String, Object> empdataMap = redisService.getRedis();
		List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");
		for (Map<String, Object> redisMap : empList) {
			for (String key : redisMap.keySet()) {
				if (userAccount.equals(key)) {
					loginRecord.setEmpName((String) ((Map<String, Object>) redisMap.get(key)).get("emp_name"));
					loginRecord.setOrgName((String) ((Map<String, Object>) redisMap.get(key)).get("org_name"));
				}
			}
		}
		loginRecord.setLoginDateTime(DateUtil.getCurrentDateTime());
		loginRecord.setLoginType("0");// 0:web;1:app
		empLoginRecordMapper.insert(loginRecord);

		return resMap;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> testLogin(Map<String, Object> appMap) throws Exception {
		String userAccount = (String) appMap.get("user_account");// 获取用户名
		String userPassword = (String) appMap.get("user_password");

		// 校验VPN设备信息
		// vpnCheck(userAccount, (String) appMap.get("device_id_nec"));

		// AD域校验
		AdUtils.connect("192.168.11.1", "389", userAccount, userPassword);

		// 根据用户名+密码查询user
		SysSecEmpExample example = new SysSecEmpExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpAccountEqualTo((String) appMap.get("user_account"));// 登录账户
		// criteria.andEmpPasswordEqualTo(CipherUtil.encrypt((String)
		// appMap.get("user_password")));// 登录密码
		criteria.andEmpEnabledEqualTo(Constants.USER_SEC_ENABLED_1);// 登录状态

		List<SysSecEmp> userList = sysSecEmpMapper.selectByExample(example);
		SysSecEmp sysSecEmp = null;
		if (userList == null || userList.size() <= 0) {
			throw new AppLoginException("用户名或密码不正确!");
		} else {
			// 获取登录用户信息
			sysSecEmp = userList.get(0);
			String empEnable = sysSecEmp.getEmpEnabled();// 登录状态0:禁用；1：启用
			if ("0".equals(empEnable)) {
				throw new AppLoginException("该账号已禁用!");
			}
			String canLoginType = String.valueOf(sysSecEmp.getCanLoginType());
			if (StringUtils.isNotBlank(canLoginType)) {
				if ("2".equals(canLoginType)) {
					throw new AppLoginException("该账号只能通过手机端登录!");
				}else if("3".equals(canLoginType)){
					throw new AppLoginException("该账号暂时不能登录速飞!");
				}
			}
		}

		// token
		String token = UUID.randomUUID().toString().replaceAll("-", "");
		Map<String, Object> reMap = new HashMap<String, Object>();
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("token", token);
		userMap.put("emp_account", sysSecEmp.getEmpAccount());
		userMap.put("emp_enabled", sysSecEmp.getEmpEnabled());
		userMap.put("tenant_id", sysSecEmp.getTenantId());
		userMap.put("create_date_time", sysSecEmp.getCreateDateTime());
		userMap.put("update_date_time", sysSecEmp.getUpdateDateTime());
		userMap.put("emp_desc", sysSecEmp.getEmpDesc());
		reMap.put("empInfo", userMap);

		// 缓存登陆信息
		redisService.setInfo(Constants.USER_SEC_WEB_LOGIN, token, reMap);
		// 云盘登录
		Map<String, Object> ucdiskLoginMap = ucdiskLogin((String) appMap.get("user_account"));
		logger.info("----ucdisk login infor==" + ucdiskLoginMap.toString());
		// 缓存云盘登录信息
		if (null != ucdiskLoginMap && !ucdiskLoginMap.isEmpty()) {
			redisService.setInfo(Constants.UCDISK_WEB_LOGIN_INFO, (String) appMap.get("user_account"), ucdiskLoginMap);
		}
		// 缓存员工信息
		// if(empMap.get("emp_id")!=null){
		// redisService.setInfo(Constants.USER_SEC_EMPINFO,
		// (String)empMap.get("emp_id"), empMap);
		// }

		String[] empArr = new String[1];
		empArr[0] = sysSecEmp.getEmpId();

		/*
		 * for(int i=0;i<empList.size();i++){
		 * empArr[i]=empList.get(i).getEmpId(); }
		 */
		// 获取用户拥有的角色,菜单列表
		Map<String, Object> roleReqMap = new HashMap<String, Object>();
		roleReqMap.put("empArr", empArr);
		// 获取所有菜单
		// List<Map<String, Object>> roleMenuList =
		// loginMapper.roleMenuList(roleReqMap);//原来的带按钮的版本
		Map<String, Object> menuReqMap = new HashMap<String, Object>();
		menuReqMap.put("emp_id", userAccount);
		List<Map<String, Object>> roleMenuList = loginMapper.newRoleMenuList(menuReqMap);
		List<Map<String, Object>> rsList = loginMapper.roleRsList(menuReqMap);
		if (roleMenuList != null && roleMenuList.size() > 0) {
			for (Map<String, Object> menuMap : roleMenuList) {
				List<Map<String, Object>> menuRsList = new ArrayList<Map<String, Object>>();
				String menuCode = (String) menuMap.get("menu_code");
				for (Map<String, Object> rsMap : rsList) {
					String rsMenuCode = (String) rsMap.get("menu_code");
					if (StringUtils.isNotBlank(rsMenuCode) && StringUtils.isNotBlank(menuCode)) {
						if (rsMap.get("menu_code").equals(menuCode)) {
							rsMap.remove("menu_code");
							menuRsList.add(rsMap);
						}
					}

				}
				menuMap.put("menuRsList", menuRsList);
			}
		}
		Map<String, Object> inforMap = new HashMap<String, Object>();
		inforMap.put("emp_id", sysSecEmp.getEmpId());
		// 员工信息
		Map<String, Object> empMap = loginMapper.empInfo(inforMap);
		// 返回给前端数据，token,拥有的菜单
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("token", token);
		resMap.put("emp_id", sysSecEmp.getEmpId());
		resMap.put("menuList", roleMenuList);
		resMap.put("empInfo", empMap);
		EmpLoginRecord loginRecord = new EmpLoginRecord();
		loginRecord.setEmpId(userAccount);
		// 获取redis中员工信息
		Map<String, Object> empdataMap = redisService.getRedis();
		List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");
		for (Map<String, Object> redisMap : empList) {
			for (String key : redisMap.keySet()) {
				if (userAccount.equals(key)) {
					loginRecord.setEmpName((String) ((Map<String, Object>) redisMap.get(key)).get("emp_name"));
					loginRecord.setOrgName((String) ((Map<String, Object>) redisMap.get(key)).get("org_name"));
				}
			}
		}
		loginRecord.setLoginDateTime(DateUtil.getCurrentDateTime());
		loginRecord.setLoginType("0");// 0:web;1:app
		empLoginRecordMapper.insert(loginRecord);

		return resMap;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> noVpnLogin(Map<String, Object> appMap) throws Exception {
		String userAccount = (String) appMap.get("user_account");// 获取用户名
		String userPassword = (String) appMap.get("user_password");

		// 校验VPN设备信息
		// vpnCheck(userAccount, (String) appMap.get("device_id_nec"));

		// AD域校验
		// AdUtils.connect("192.168.11.1", "389", userAccount, userPassword);

		// 根据用户名+密码查询user
		SysSecEmpExample example = new SysSecEmpExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpAccountEqualTo((String) appMap.get("user_account"));// 登录账户
		criteria.andEmpPasswordEqualTo(CipherUtil.encrypt((String) appMap.get("user_password")));// 登录密码
		criteria.andEmpEnabledEqualTo(Constants.USER_SEC_ENABLED_1);// 登录状态

		List<SysSecEmp> userList = sysSecEmpMapper.selectByExample(example);
		SysSecEmp sysSecEmp = null;
		if (userList == null || userList.size() <= 0) {
			throw new AppLoginException("用户名或密码不正确!");
		} else {
			// 获取登录用户信息
			sysSecEmp = userList.get(0);
			String empEnable = sysSecEmp.getEmpEnabled();// 登录状态0:禁用；1：启用
			if ("0".equals(empEnable)) {
				throw new AppLoginException("该账号已禁用!");
			}
			String canLoginType = String.valueOf(sysSecEmp.getCanLoginType());
			if (StringUtils.isNotBlank(canLoginType)) {
				if ("2".equals(canLoginType)) {
					throw new AppLoginException("该账号只能通过手机端登录!");
				}else if("3".equals(canLoginType)){
					throw new AppLoginException("该账号暂时不能登录速飞!");
				}
			}
		}

		// token
		String token = UUID.randomUUID().toString().replaceAll("-", "");
		Map<String, Object> reMap = new HashMap<String, Object>();
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("token", token);
		userMap.put("emp_account", sysSecEmp.getEmpAccount());
		userMap.put("emp_enabled", sysSecEmp.getEmpEnabled());
		userMap.put("tenant_id", sysSecEmp.getTenantId());
		userMap.put("create_date_time", sysSecEmp.getCreateDateTime());
		userMap.put("update_date_time", sysSecEmp.getUpdateDateTime());
		userMap.put("emp_desc", sysSecEmp.getEmpDesc());
		reMap.put("empInfo", userMap);

		// 缓存登陆信息
		redisService.setInfo(Constants.USER_SEC_WEB_LOGIN, token, reMap);
		// 云盘登录
		Map<String, Object> ucdiskLoginMap = ucdiskLogin((String) appMap.get("user_account"));
		logger.info("----ucdisk login infor==" + ucdiskLoginMap.toString());
		// 缓存云盘登录信息
		if (null != ucdiskLoginMap && !ucdiskLoginMap.isEmpty()) {
			redisService.setInfo(Constants.UCDISK_WEB_LOGIN_INFO, (String) appMap.get("user_account"), ucdiskLoginMap);
		}
		// 缓存员工信息
		// if(empMap.get("emp_id")!=null){
		// redisService.setInfo(Constants.USER_SEC_EMPINFO,
		// (String)empMap.get("emp_id"), empMap);
		// }

		String[] empArr = new String[1];
		empArr[0] = sysSecEmp.getEmpId();

		/*
		 * for(int i=0;i<empList.size();i++){
		 * empArr[i]=empList.get(i).getEmpId(); }
		 */
		// 获取用户拥有的角色,菜单列表
		Map<String, Object> roleReqMap = new HashMap<String, Object>();
		roleReqMap.put("empArr", empArr);
		// 获取所有菜单
		// List<Map<String, Object>> roleMenuList =
		// loginMapper.roleMenuList(roleReqMap);//原来的带按钮的版本
		Map<String, Object> menuReqMap = new HashMap<String, Object>();
		menuReqMap.put("emp_id", userAccount);
		List<Map<String, Object>> roleMenuList = loginMapper.newRoleMenuList(menuReqMap);
		List<Map<String, Object>> rsList = loginMapper.roleRsList(menuReqMap);
		if (roleMenuList != null && roleMenuList.size() > 0) {
			for (Map<String, Object> menuMap : roleMenuList) {
				List<Map<String, Object>> menuRsList = new ArrayList<Map<String, Object>>();
				String menuCode = (String) menuMap.get("menu_code");
				for (Map<String, Object> rsMap : rsList) {
					String rsMenuCode = (String) rsMap.get("menu_code");
					if (StringUtils.isNotBlank(rsMenuCode) && StringUtils.isNotBlank(menuCode)) {
						if (rsMap.get("menu_code").equals(menuCode)) {
							rsMap.remove("menu_code");
							menuRsList.add(rsMap);
						}
					}

				}
				menuMap.put("menuRsList", menuRsList);
			}
		}
		Map<String, Object> inforMap = new HashMap<String, Object>();
		inforMap.put("emp_id", sysSecEmp.getEmpId());
		// 员工信息
		Map<String, Object> empMap = loginMapper.empInfo(inforMap);
		// 返回给前端数据，token,拥有的菜单
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("token", token);
		resMap.put("emp_id", sysSecEmp.getEmpId());
		resMap.put("menuList", roleMenuList);
		resMap.put("empInfo", empMap);
		EmpLoginRecord loginRecord = new EmpLoginRecord();
		loginRecord.setEmpId(userAccount);
		// 获取redis中员工信息
		Map<String, Object> empdataMap = redisService.getRedis();
		List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");
		for (Map<String, Object> redisMap : empList) {
			for (String key : redisMap.keySet()) {
				if (userAccount.equals(key)) {
					loginRecord.setEmpName((String) ((Map<String, Object>) redisMap.get(key)).get("emp_name"));
					loginRecord.setOrgName((String) ((Map<String, Object>) redisMap.get(key)).get("org_name"));
				}
			}
		}
		loginRecord.setLoginDateTime(DateUtil.getCurrentDateTime());
		loginRecord.setLoginType("0");// 0:web;1:app
		empLoginRecordMapper.insert(loginRecord);

		return resMap;
	}

	@Override
	public Map<String, Object> loginCheck(Map<String, Object> appMap) throws Exception {
		Map<String, Object> resMap = redisService.getInfo(Constants.USER_SEC_WEB_LOGIN, (String) appMap.get("token"));
		if (resMap == null) {
			throw new AppLoginException("登录超时!");
		}
		Boolean result = (Boolean) resMap.get("result");
		if (!result) {
			throw new AppLoginException("员工信息校验失败!");
		}
		return (Map<String, Object>) resMap.get("data");
	}

	@Override
	public Map<String, Object> appLogin(Map<String, Object> appMap) throws Exception {

		String userAccount = (String) appMap.get("user_account");// 获取用户名
		String userPassword = (String) appMap.get("user_password");

		// 校验VPN设备信息
		vpnCheck((String) appMap.get("user_account"), (String) appMap.get("device_id_nec"));

		// AD域校验
		AdUtils.connect("192.168.11.1", "389", userAccount, userPassword);

		// 根据用户名+密码查询user
		SysSecEmpExample example = new SysSecEmpExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpAccountEqualTo((String) appMap.get("user_account"));// 登录账户
		// criteria.andEmpPasswordEqualTo(CipherUtil.encrypt((String)
		// appMap.get("user_password")));// 登录密码
		// criteria.andEmpEnabledEqualTo(Constants.USER_SEC_ENABLED_1);// 登录状态

		List<SysSecEmp> userList = sysSecEmpMapper.selectByExample(example);
		// if (userList == null || userList.size() <= 0) {
		// throw new AppLoginException("用户名或密码不正确!");
		// }

		// 获取登录用户信息
		// SysSecEmp sysSecEmp = userList.get(0);
		// if (userList != null && userList.size() > 0) {
		// sysSecEmp = userList.get(0);
		// } else {
		// throw new AppLoginException("没有该员工信息!");
		// }

		SysSecEmp sysSecEmp = null;
		if (userList == null || userList.size() <= 0) {
			throw new AppLoginException("用户名或密码不正确!");
		} else {
			// 获取登录用户信息
			sysSecEmp = userList.get(0);
			String empEnable = sysSecEmp.getEmpEnabled();// 登录状态0:禁用；1：启用
			if ("0".equals(empEnable)) {
				throw new AppLoginException("该账号已禁用!");
			}
			String canLoginType = String.valueOf(sysSecEmp.getCanLoginType());
			if (StringUtils.isNotBlank(canLoginType)) {
				if ("1".equals(canLoginType)) {
					throw new AppLoginException("该账号只能通过web端登录!");
				}else if("3".equals(canLoginType)){
					throw new AppLoginException("该账号暂时不能登录速飞!");
				}
			}
		}
		// token
		String token = UUID.randomUUID().toString().replaceAll("-", "");
		Map<String, Object> reMap = new HashMap<String, Object>();
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("token", token);
		userMap.put("emp_account", sysSecEmp.getEmpAccount());
		userMap.put("emp_enabled", sysSecEmp.getEmpEnabled());
		userMap.put("tenant_id", sysSecEmp.getTenantId());
		userMap.put("create_date_time", sysSecEmp.getCreateDateTime());
		userMap.put("update_date_time", sysSecEmp.getUpdateDateTime());
		userMap.put("emp_desc", sysSecEmp.getEmpDesc());
		reMap.put("empInfo", userMap);

		// 缓存登陆信息
		redisService.setInfo(Constants.USER_SEC_APP_LOGIN, token, reMap);
		// 云盘登录
		Map<String, Object> ucdiskLoginMap = ucdiskLogin((String) appMap.get("user_account"));
		// 缓存云盘登录信息
		if (null != ucdiskLoginMap && !ucdiskLoginMap.isEmpty()) {
			redisService.setInfo(Constants.UCDISK_APP_LOGIN_INFO, (String) appMap.get("user_account"), ucdiskLoginMap);
		}
		Map<String, Object> inforMap = new HashMap<String, Object>();
		inforMap.put("emp_id", sysSecEmp.getEmpId());
		// 员工信息
		Map<String, Object> empMap = loginMapper.empInfo(inforMap);
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("token", token);
		resMap.put("emp_id", sysSecEmp.getEmpId());
		resMap.put("empInfo", empMap);

		Map<String, Object> ucdiskInfo = new HashMap<String, Object>();
		ucdiskInfo.put("ucdisk_token", ucdiskLoginMap.get("emp_token"));
		ucdiskInfo.put("user_root_node_id", ucdiskLoginMap.get("emp_userRootNodeId"));
		resMap.put("ucdisk", ucdiskInfo);

		EmpLoginRecord loginRecord = new EmpLoginRecord();
		loginRecord.setEmpId(userAccount);
		// 获取redis中员工信息
		Map<String, Object> empdataMap = redisService.getRedis();
		List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");
		for (Map<String, Object> redisMap : empList) {
			for (String key : redisMap.keySet()) {
				if (userAccount.equals(key)) {
					loginRecord.setEmpName((String) ((Map<String, Object>) redisMap.get(key)).get("emp_name"));
					loginRecord.setOrgName((String) ((Map<String, Object>) redisMap.get(key)).get("org_name"));
				}
			}
		}
		loginRecord.setLoginDateTime(DateUtil.getCurrentDateTime());
		loginRecord.setLoginType("1");// 0:web;1:app
		empLoginRecordMapper.insert(loginRecord);

		return resMap;
	}

	@Override
	public Map<String, Object> appLoginCheck(Map<String, Object> appMap) throws Exception {
		Map<String, Object> resMap = redisService.getInfo(Constants.USER_SEC_APP_LOGIN, (String) appMap.get("token"));
		if (resMap == null) {
			throw new AppLoginException("登录超时!");
		}
		Boolean result = (Boolean) resMap.get("result");
		if (!result) {
			throw new AppLoginException("员工信息校验失败!");
		}
		return (Map<String, Object>) resMap.get("data");
	}

	public Map<String, Object> ucdiskLogin(String empId) throws AppLoginException {
		Map<String, Object> dataMap = new HashMap<String, Object>();

		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("emp_id", empId);
		logger.info("----vif ucdisk login empId=" + empId);
		Map<String, Object> resMap = vifClient.ucdiskLogin(reqMap);
		logger.info("----vif ucdisk login infor=" + resMap.toString());
		if (!resMap.isEmpty()) {
			Boolean result = (Boolean) resMap.get("result");
			if (result) {
				dataMap = (Map<String, Object>) resMap.get("data");
			}
			// else {
			// throw new AppLoginException("登录失败");
			// }
		}
		// else {
		// throw new AppLoginException("登录失败");
		// }
		// dataMap.put("token", "11111");
		// dataMap.put("emp_token", "11111");
		// dataMap.put("userRootNodeId", "11111");
		// dataMap.put("emp_userRootNodeId", "11111");
		return dataMap;
	}

	/**
	 * 校验VPN设备信息
	 * 
	 * @throws AppLoginException
	 */
	public void vpnCheck(String empId, String device_id_dec) throws AppLoginException {

		if (StringUtils.isBlank(device_id_dec)) {
			throw new AppLoginException("获取不到设备信息！");
		}

		EmpVpnSyncExample example = new EmpVpnSyncExample();
		example.createCriteria().andEmpIdEqualTo(empId).andDeviceIdDecEqualTo(device_id_dec);
		List<EmpVpnSync> empAndDeviceList = empVpnSyncMapper.selectByExample(example);
		EmpVpnSyncExample example1 = new EmpVpnSyncExample();
		example1.createCriteria().andDeviceIdDecEqualTo(device_id_dec);
		List<EmpVpnSync> deviceList = empVpnSyncMapper.selectByExample(example1);
		if (empAndDeviceList.size() == 0) {// 此账号和设备没有绑定
			if (deviceList != null && deviceList.size() > 0) {// 此设备已经绑定过其他用户(一个设备只能绑定一个账号)
				throw new AppLoginException("此设备已绑定其他用户！");
			} else {
				EmpVpnSync vpn = new EmpVpnSync();
				vpn.setId(serialService.getUUID());
				vpn.setEmpId(empId);
				vpn.setDeviceIdDec(device_id_dec);
				vpn.setCreateDateTime(DateUtil.getCurrentDateTime());
				empVpnSyncMapper.insertSelective(vpn);
			}

		}

	}

	/**
	 * Pc登录接口
	 */
	@Override
	public Map<String, Object> pcLogin(Map<String, Object> appMap) throws Exception {

		String userAccount = (String) appMap.get("user_account");// 获取用户名
		String userPassword = (String) appMap.get("user_password");

		// 校验VPN设备信息
		// vpnCheck((String) appMap.get("user_account"), (String)
		// appMap.get("device_id_nec"));

		// AD域校验
		// AdUtils.connect("192.168.11.1", "389", userAccount, userPassword);

		// 根据用户名+密码查询user
		SysSecEmpExample example = new SysSecEmpExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpAccountEqualTo((String) appMap.get("user_account"));// 登录账户
		// criteria.andEmpPasswordEqualTo(CipherUtil.encrypt((String)
		// appMap.get("user_password")));// 登录密码
		// criteria.andEmpEnabledEqualTo(Constants.USER_SEC_ENABLED_1);// 登录状态

		List<SysSecEmp> userList = sysSecEmpMapper.selectByExample(example);
		// if (userList == null || userList.size() <= 0) {
		// throw new AppLoginException("用户名或密码不正确!");
		// }

		// 获取登录用户信息
		SysSecEmp sysSecEmp = userList.get(0);
		// if (userList != null && userList.size() > 0) {
		// sysSecEmp = userList.get(0);
		// } else {
		// throw new AppLoginException("没有该员工信息!");
		// }
		// token
		String token = UUID.randomUUID().toString().replaceAll("-", "");
		Map<String, Object> reMap = new HashMap<String, Object>();
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("token", token);
		userMap.put("emp_account", sysSecEmp.getEmpAccount());
		userMap.put("emp_enabled", sysSecEmp.getEmpEnabled());
		userMap.put("tenant_id", sysSecEmp.getTenantId());
		userMap.put("create_date_time", sysSecEmp.getCreateDateTime());
		userMap.put("update_date_time", sysSecEmp.getUpdateDateTime());
		userMap.put("emp_desc", sysSecEmp.getEmpDesc());
		reMap.put("empInfo", userMap);

		// 缓存登陆信息
		redisService.setInfo(Constants.USER_SEC_APP_LOGIN, token, reMap);
		// 云盘登录
		Map<String, Object> ucdiskLoginMap = ucdiskLogin((String) appMap.get("user_account"));
		// 缓存云盘登录信息
		redisService.setInfo(Constants.UCDISK_APP_LOGIN_INFO, (String) appMap.get("user_account"), ucdiskLoginMap);

		Map<String, Object> inforMap = new HashMap<String, Object>();
		inforMap.put("emp_id", sysSecEmp.getEmpId());
		// 员工信息
		Map<String, Object> empMap = loginMapper.empInfo(inforMap);
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("token", token);
		resMap.put("emp_id", sysSecEmp.getEmpId());
		resMap.put("empInfo", empMap);
		return resMap;
	}
}
