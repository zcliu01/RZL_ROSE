package com.zrt.sec.service.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.AppException;
import com.zrt.commons.PageInit;
import com.zrt.commons.cons.Constants;
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.sign.CipherUtil;
import com.zrt.commons.utils.ChineseToHanYuPYUtils;
import com.zrt.commons.utils.FirstLetterUtils;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.mybatis.domain.SysInfoInvoice;
import com.zrt.mybatis.domain.SysInfoInvoiceExample;
import com.zrt.mybatis.domain.SysSecEmp;
import com.zrt.mybatis.domain.SysSecEmpExample;
import com.zrt.mybatis.domain.SysSecEmpPosition;
import com.zrt.mybatis.domain.SysSecRole;
import com.zrt.mybatis.domain.SysSecRoleExample;
import com.zrt.mybatis.domain.SysSecUser;
import com.zrt.mybatis.domain.SysSecUserExample;
import com.zrt.mybatis.domain.SysSecUserExample.Criteria;
import com.zrt.mybatis.domain.SysSecUserRoleExample;
import com.zrt.mybatis.mapper.SysInfoInvoiceMapper;
import com.zrt.mybatis.mapper.SysSecEmpMapper;
import com.zrt.mybatis.mapper.SysSecEmpPositionMapper;
import com.zrt.mybatis.mapper.SysSecRoleMapper;
import com.zrt.mybatis.mapper.SysSecUserMapper;
import com.zrt.mybatis.mapper.SysSecUserRoleMapper;
import com.zrt.sec.mapper.role.RoleMapper;
import com.zrt.sec.mapper.user.UserMapper;
import com.zrt.sec.service.infor.InforService;
import com.zrt.sec.service.serial.SerialService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Autowired
	private SysSecUserMapper sysSecUserMapper;
	@Autowired
	private SysSecEmpMapper sysSecEmpMapper;
	@Autowired
	private SysSecRoleMapper sysSecRoleMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private SerialService serialService;
	@Autowired
	private InforService inforService;
	@Autowired
	private SysSecUserRoleMapper sysSecUserRoleMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private SysInfoInvoiceMapper sysInfoInvoiceMapper;
	@Autowired
	private SysSecEmpPositionMapper sysSecEmpPositionMapper;

	/**
	 * 用户列表查询
	 */
	@Override
	@Transactional(readOnly = true)
	public List<SysSecUser> userList(Map<String, Object> appMap) throws Exception {
		// TODO Auto-generated method stub
		SysSecUserExample example = new SysSecUserExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank((String) appMap.get("sec_enabled"))) {
			criteria.andSecEnabledEqualTo((String) appMap.get("sec_enabled"));
		}
		if (StringUtils.isNotBlank((String) appMap.get("user_account"))) {
			criteria.andUserAccountEqualTo((String) appMap.get("user_account"));
		}
		example.setOrderByClause("create_date_time desc");
		return sysSecUserMapper.selectByExample(example);
	}

	/**
	 * F 用户新增
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int userSave(Map<String, Object> appMap) throws Exception {
		// TODO Auto-generated method stub
		appMap.put("user_id", serialService.getSerialNumberFromDB("sys_sec_user"));
		appMap.put("user_id", serialService.getUUID());
		appMap.put("user_password", CipherUtil.encrypt((String) appMap.get("user_password")));
		appMap.put("create_date_time", DateUtil.getCurrentDateTime());// 创建时间
		appMap.put("update_date_time", DateUtil.getCurrentDateTime());// 更新时间
		appMap.put("sec_enabled", Constants.USER_SEC_ENABLED_1);// 用户状态
		appMap.put("sec_order", 0);// 排序
		appMap.put("sec_sys_flag", "0");// 0:普通，1：管理员
		appMap.put("sec_readonly_flag", "0");// 只读标志
		appMap.put("sec_delete_flag", "0");// 删除标志
		appMap.put("version_", 0);//
		SysSecUser sysSecUser = (SysSecUser) MapEntityConverter.getEntityFromMap(appMap, SysSecUser.class);
		// 查询是否有相同的user_account
		SysSecUserExample example = new SysSecUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserAccountEqualTo((String) appMap.get("user_account"));
		List<SysSecUser> list = sysSecUserMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			throw new AppException("已存在相同的账号!");
		}
		return sysSecUserMapper.insert(sysSecUser);
	}

	/**
	 * 用户信息查询
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> userSearch(Map<String, Object> appMap) throws Exception {
		/*
		 * SysSecUserExample example=new SysSecUserExample(); Criteria
		 * criteria=example.createCriteria();
		 * criteria.andUserIdEqualTo((String)appMap.get("user_id"));
		 * if(StringUtils.isNotBlank((String)appMap.get("sec_enabled"))){
		 * criteria.andSecEnabledEqualTo((String)appMap.get("sec_enabled")); }
		 * if(StringUtils.isNotBlank((String)appMap.get("user_account"))){
		 * criteria.andUserAccountEqualTo((String)appMap.get("user_account")); }
		 * List<SysSecUser> list=sysSecUserMapper.selectByExample(example);
		 * SysSecUser sysSecUser=list.get(0); Map<String, Object> userMap=new
		 * HashMap<String, Object>(); userMap.put("user_id",
		 * sysSecUser.getUserId());//用户id userMap.put("user_account",
		 * sysSecUser.getUserAccount());//用户账号 userMap.put("sec_enabled",
		 * sysSecUser.getSecEnabled());//用户状态 return userMap;
		 */
		/*
		 * List<Map<String, Object>> mapUserEmp=userMapper.userIdEmp(appMap);
		 * String empIds=null; for(Map m : mapUserEmp){
		 * empIds=empIds+"'"+m.get("emp_id")+"',"; } appMap.put("emp", empIds);
		 */
		// SysSecEmp sysSecEmp = sysSecEmpMapper.selectByPrimaryKey((String)
		// appMap.get("emp_id"));
		// appMap.put("user_id", sysSecEmp.getUserId());

		Map<String, Object> map = userMapper.userSearch(appMap);
		String time = (String) map.get("create_date_time");
		if (org.apache.commons.lang3.StringUtils.isNotBlank(time)) {
			time = time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8);
			map.put("create_date_time", time);
		}
		// map.put("up_emp_id", map.get("manage_emp_id"));
		// map.put("up_emp_name", map.get("manage_emp_name"));
		String up_emp_name = userMapper.upSearch((String) map.get("up_emp_id"));
		map.put("up_emp_name", up_emp_name);
		List<Map<String, Object>> roleList = roleMapper.userRoleList(appMap);
		map.put("role", roleList);
		List<Map<String, Object>> listrs = userMapper.userSearchorgspp(appMap);
		List<Map<String, Object>> listre = userMapper.userSearredeploy(appMap);
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("userInfo", map);// 员工基本信息
		userMap.put("userPosList", listrs);// 职位信息列表
		userMap.put("userDeployList", listre);// 履历信息列表
		return userMap;
	}

	/**
	 * 用户更新
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int userUpdate(Map<String, Object> appMap) throws Exception {
		// TODO Auto-generated method stub

		String EmpSl = FirstLetterUtils.getFirstLetter((String) appMap.get("emp_name")).toLowerCase();
		String EmpPy = ChineseToHanYuPYUtils.convertChineseToPinyin((String) appMap.get("emp_name")).toLowerCase();
		SysSecEmp sysSecEmp = new SysSecEmp();
		sysSecEmp.setEmpId((String) appMap.get("emp_id"));
		sysSecEmp.setEmpName((String) appMap.get("emp_name"));
		sysSecEmp.setEmpSl(EmpSl);
		sysSecEmp.setEmpPy(EmpPy);
		sysSecEmp.setEmpHeadPhoto((String) appMap.get("emp_head_photo"));
		sysSecEmp.setEmpSex((String) appMap.get("emp_sex"));
		sysSecEmp.setEmpCode((String) appMap.get("emp_code"));
		sysSecEmp.setEmpEmail((String) appMap.get("emp_email"));
		sysSecEmp.setEmpBirthday((String) appMap.get("emp_birthday"));
		sysSecEmp.setCreateDateTime(((String) appMap.get("create_date_time")).replace("-", "") + "000000");
		sysSecEmp.setUpdateDateTime(DateUtil.getCurrentDateTime());
		sysSecEmp.setEntryTime(((String) appMap.get("create_date_time")).replace("-", "") + "000000");
		sysSecEmp.setEmpPhone((String) appMap.get("emp_phone"));
		sysSecEmp.setEmpMobilePhone((String) appMap.get("emp_mobile_phone"));
		sysSecEmp.setEmpEnabled((String) appMap.get("emp_enabled"));
		sysSecEmp.setEmpAddress((String) appMap.get("emp_address"));
		sysSecEmp.setEmpEmail((String) appMap.get("emp_email"));
		sysSecEmp.setCerType((String) appMap.get("cer_type"));
		sysSecEmp.setEmpWorkAddress((String) appMap.get("emp_work_address"));
		sysSecEmp.setEmpFax((String) appMap.get("emp_fax"));
		sysSecEmp.setCerNo((String) appMap.get("cer_no"));
		sysSecEmp.setEmpPostcode(((String) appMap.get("emp_postcode")));
		;
		// sysSecEmp.setEmpOrder((Integer) appMap.get("emp_order"));

		Object empOrder = appMap.get("emp_order");
		if (empOrder instanceof String) {
			sysSecEmp.setEmpOrder(Integer.valueOf((String) empOrder));
		} else {
			sysSecEmp.setEmpOrder(Integer.valueOf((int) empOrder));
		}
		/*
		 * Map<String, Object> upSearch = userMapper.upSearch(appMap); if
		 * (null!=upSearch) { userMapper.updateManager(appMap); }
		 */
		userMapper.deletePosition(appMap);
		List<Map<String, Object>> positionList = (List<Map<String, Object>>) appMap.get("position");
		SysSecEmpPosition sysSecEmpPosition = new SysSecEmpPosition();
		sysSecEmpPosition.setEmpId(sysSecEmp.getEmpId());
		sysSecEmpPosition.setCreateDateTime(DateUtil.getCurrentDateTime());
		sysSecEmpPosition.setUpEmpId((String) appMap.get("up_emp_id"));
		if (null == positionList || positionList.size() < 1) {
			throw new AppException("请选择部门!!");
		} else {
			for (Map<String, Object> temp : positionList) {
				sysSecEmpPosition.setId(serialService.getUUID());
				sysSecEmpPosition.setOrgId((String) temp.get("org_id"));
				sysSecEmpPosition.setOrgName((String) temp.get("org_name"));
				sysSecEmpPosition.setIsFirstOrg((String) temp.get("is_first_org"));
				sysSecEmpPosition.setTeamId((String) temp.get("org_id"));
				sysSecEmpPosition.setEmpPositionId((String) temp.get("p_s_p_id"));
				sysSecEmpPosition.setrId((String) temp.get("r_id"));
				sysSecEmpPositionMapper.insert(sysSecEmpPosition);
			}

		}
		return sysSecEmpMapper.updateByPrimaryKeySelective(sysSecEmp);

	}

	/**
	 * 查询用户绑定的角色
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> userRoleList(Map<String, Object> appMap) throws Exception {
		// TODO Auto-generated method stub
		// 先查询状态正常的角色列表
		SysSecRoleExample example = new SysSecRoleExample();
		com.zrt.mybatis.domain.SysSecRoleExample.Criteria criteria = example.createCriteria();
		criteria.andSecEnabledEqualTo(Constants.ROLE_SEC_ENABLED_1);// 状态为1的正常的
		example.setOrderByClause("role_name");
		List<SysSecRole> roleList = sysSecRoleMapper.selectByExample(example);
		// 根据用户id查询已关联的角色列表
		List<Map<String, Object>> userRoleList = roleMapper.userRoleList(appMap);
		// 分析
		List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
		for (SysSecRole role : roleList) {
			Map<String, Object> roleMap = new HashMap<String, Object>();
			roleMap.put("role_id", role.getRoleId());// 角色id
			roleMap.put("role_name", role.getRoleName());// 角色名称
			roleMap.put("is_user", false);// 用户是否绑定该角色，默认false
			for (Map<String, Object> userRole : userRoleList) {
				if (role.getRoleId().equals(userRole.get("role_id"))) {
					roleMap.put("is_user", true);// 用户绑定该角色，为true
					break;
				}
			}
			resList.add(roleMap);
		}
		return resList;
	}

	// 用户绑定角色
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int userRoleSave(Map<String, Object> appMap) throws Exception {
		List<Map<String, Object>> empList = (List<Map<String, Object>>) appMap.get("param_emp");
		List<String> eList = new ArrayList<>();
		for (Map<String, Object> map : empList) {
			eList.add((String) map.get("emp_id"));
		}
		SysSecUserRoleExample example = new SysSecUserRoleExample();
		com.zrt.mybatis.domain.SysSecUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andEmpIdIn(eList);// 批量删除相关员工id绑定的角色
		// 根据用户id删除已绑定的角色
		sysSecUserRoleMapper.deleteByExample(example);
		// 获取更新角色列表
		List<Map<String, Object>> roleList = (List<Map<String, Object>>) appMap.get("param");
		if (roleList == null || roleList.size() == 0) {
			return 0;
		}
		for (Map<String, Object> mp : empList) {
			for (Map<String, Object> map : roleList) {
				mp.put("role_id", map.get("role_id"));

			}
		}
		// 批量插入角色用户表
		roleMapper.userRoleSave(empList);
		return 0;
	}

	// 用户重置密码
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int userPwdReSet(Map<String, Object> appMap) throws Exception {
		// TODO Auto-generated method stub
		SysSecEmp sysSecEmp = sysSecEmpMapper.selectByPrimaryKey((String) appMap.get("emp_id"));
		// 根据传递过来的user_id进行重置该用户的密码
		String user_pas = CipherUtil.encrypt("123456");
		sysSecEmp.setEmpPassword(user_pas);
		sysSecEmpMapper.updateByPrimaryKeySelective(sysSecEmp);
		return 1;
	}

	// 用户修改密码
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int userPwdSet(Map<String, Object> appMap) throws Exception {
		// TODO Auto-generated method stub
		// 根据传递过来的user_id进行重置该用户的密码
		// 获取该用户的信息
		SysSecEmp sysSecEmp = sysSecEmpMapper.selectByPrimaryKey((String) appMap.get("emp_id"));
		// 原密码
		String oldPwd = (String) appMap.get("old_pwd");
		// 新密码
		String newPwd = (String) appMap.get("new_pwd");
		// 确认新密码
		String confirmNewPwd = (String) appMap.get("confirm_new_pwd");
		// 判断新密码是否一致
		if (!newPwd.equals(confirmNewPwd)) {
			throw new AppException("确认密码与新密码不一致!");
		}
		String user_pas = CipherUtil.encrypt(oldPwd);
		if (!user_pas.equals(sysSecEmp.getEmpPassword())) {
			throw new AppException("原密码不正确!");
		}
		// 更新新密码
		String new_user_pas = CipherUtil.encrypt(newPwd);
		sysSecEmp.setEmpPassword(new_user_pas);
		sysSecEmp.setUpdateDateTime(DateUtil.getCurrentDateTime());
		sysSecEmpMapper.updateByPrimaryKeySelective(sysSecEmp);
		return 0;
	}

	/**
	 * 用户列表查询
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> empList(Map<String, Object> appMap) throws Exception {
		//// 设置分页条件
		PageInit.setPage(appMap);
		PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
				Integer.parseInt(appMap.get("maxResult").toString()), true);
		// 获取用户列表
		List<Map<String, Object>> dataList = userMapper.empList(appMap);

		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", pageInfo.getList());
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	// 用户状态启用/关闭
	@Override
	public int userStatusUpdate(Map<String, Object> appMap) throws Exception {
		String sec_enabled = (String) appMap.get("sec_enabled");
		if ("0".equals(sec_enabled)) {
			sec_enabled = "1";// 启用
		} else if ("1".equals(sec_enabled)) {
			sec_enabled = "0";// 禁用
		}
		SysSecEmp sysSecEmp = sysSecEmpMapper.selectByPrimaryKey((String) appMap.get("emp_id"));

		SysSecEmp sysSecEmp1 = new SysSecEmp();
		SysSecEmpExample exampleEmp1 = new SysSecEmpExample();
		com.zrt.mybatis.domain.SysSecEmpExample.Criteria criteriaEmp1 = exampleEmp1.createCriteria();
		criteriaEmp1.andEmpIdEqualTo(sysSecEmp.getEmpId());
		sysSecEmp1.setEmpEnabled(sec_enabled);
		// 根据user_id 更新员工状态
		sysSecEmpMapper.updateByExampleSelective(sysSecEmp1, exampleEmp1);
		return 1;
	}

	/**
	 * App端修改个人详情
	 */
	@Override
	public void appUpdateEmpDetails(Map<String, Object> map) throws Exception {
		String type = (String) map.get("type");
		SysSecEmp sysSecEmp = sysSecEmpMapper.selectByPrimaryKey((String) map.get("emp_id"));
		if (type == "0" || "0".equals(type)) {// 修改留言
			String empMessage = (String) map.get("emp_message");
			sysSecEmp.setEmpMessage(empMessage);
			sysSecEmpMapper.updateByPrimaryKeySelective(sysSecEmp);
		} else {
			Map inforMap = new HashMap<>();
			String content = "";
			inforMap.put("title", "个人资料修改");
			inforMap.put("sender_id", (String) map.get("emp_id"));
			// inforMap.put("receiver_ids","2f960f88-4388-11e7-b66c-3c970e5c");
			inforMap.put("category", "innerInfor");
			inforMap.put("bus_type", "1");
			if (type == "1" || "1".equals(type)) {// 修改固定电话
				String empPhone = (String) map.get("emp_phone");
				content = "工号为" + sysSecEmp.getEmpCode() + "的" + sysSecEmp.getEmpName() + "修改 固定电话为" + empPhone;
				inforMap.put("content", content);
				inforService.sendUpdateInfor(inforMap);
			} else if (type == "2" || "2".equals(type)) {// 修改手机号码
				String empMobilePhone = (String) map.get("emp_mobile_phone");
				content = "工号为" + sysSecEmp.getEmpCode() + "的" + sysSecEmp.getEmpName() + "修改 手机号码为" + empMobilePhone;
				inforMap.put("content", content);
				inforService.sendUpdateInfor(inforMap);

			} else if (type == "3" || "3".equals(type)) {// 修改联系地址
				String empAddress = (String) map.get("emp_address");
				content = "工号为" + sysSecEmp.getEmpCode() + "的" + sysSecEmp.getEmpName() + "修改 联系地址为" + empAddress;
				inforMap.put("content", content);
				inforService.sendUpdateInfor(inforMap);

			} else if (type == "4" || "4".equals(type)) {// 修改工作地址
				String empWorkAddress = (String) map.get("emp_work_address");
				content = "工号为" + sysSecEmp.getEmpCode() + "的" + sysSecEmp.getEmpName() + "修改 工作地址为" + empWorkAddress;
				inforMap.put("content", content);
				inforService.sendUpdateInfor(inforMap);
			}
		}
	}

	/**
	 * App端获取发票抬头信息
	 */
	@Override
	public List<Map<String, Object>> appSelectInvoiceTitle(Map<String, Object> appMap) throws Exception {
		SysInfoInvoiceExample example = new SysInfoInvoiceExample();
		example.createCriteria().andEmpIdEqualTo((String) appMap.get("emp_id"));
		List<SysInfoInvoice> sysInfoInvoiceList = sysInfoInvoiceMapper.selectByExample(example);
		List<Map<String, Object>> list = MapEntityConverter.getMapFromList(new String[] { "id", "emp_id", "titile_name",
				"in_code", "com_address", "com_phone", "acc_bank", "acc_no" }, sysInfoInvoiceList,
				SysInfoInvoice.class);
		return list;
	}

	@Override
	public int userSync(Map<String, Object> appMap) throws Exception {
		String synFlag = (String) appMap.get("syn_flag");
		if ("1".equals(synFlag)) {
			appMap.put("syn_flag", "0");
		}
		if ("0".equals(synFlag)) {
			appMap.put("syn_flag", "1");
		}
		return userMapper.userSync(appMap);
	}

	@Override
	public void loginTypeSet(Map<String, Object> appMap) throws Exception {
		List<Map<String, Object>> empList = (List<Map<String, Object>>) appMap.get("param");
		int loginType = (int) appMap.get("login_type");
		if (null != empList && !empList.isEmpty()) {
			for (Map<String, Object> empMap : empList) {
				String empId = (String) empMap.get("emp_id");
				SysSecEmp emp = sysSecEmpMapper.selectByPrimaryKey(empId);
				emp.setCanLoginType(loginType);
				sysSecEmpMapper.updateByPrimaryKeySelective(emp);

			}
		}

	}

}
