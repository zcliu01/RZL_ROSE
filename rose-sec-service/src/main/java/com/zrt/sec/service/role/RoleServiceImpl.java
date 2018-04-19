package com.zrt.sec.service.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.client.flow.IFlowClient;
import com.zrt.commons.AppException;
import com.zrt.commons.PageInit;
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.mybatis.domain.SysSecEmp;
import com.zrt.mybatis.domain.SysSecMenu;
import com.zrt.mybatis.domain.SysSecMenuExample;
import com.zrt.mybatis.domain.SysSecRole;
import com.zrt.mybatis.domain.SysSecRoleExample;
import com.zrt.mybatis.domain.SysSecRoleExample.Criteria;
import com.zrt.mybatis.domain.SysSecRoleResourceExample;
import com.zrt.mybatis.domain.SysSecUserRole;
import com.zrt.mybatis.domain.SysSecUserRoleExample;
import com.zrt.mybatis.mapper.SysSecEmpMapper;
import com.zrt.mybatis.mapper.SysSecMenuMapper;
import com.zrt.mybatis.mapper.SysSecRoleMapper;
import com.zrt.mybatis.mapper.SysSecRoleMenuMapper;
import com.zrt.mybatis.mapper.SysSecRoleResourceMapper;
import com.zrt.mybatis.mapper.SysSecUserRoleMapper;
import com.zrt.sec.mapper.resource.ResourceMapper;
import com.zrt.sec.mapper.role.RoleMapper;
import com.zrt.sec.service.serial.SerialService;

@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private SysSecRoleMapper sysSecRoleMapper;
	@Autowired
	private SerialService serialService;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private ResourceMapper resourceMapper;
	@Autowired
	private SysSecRoleMenuMapper sysSecRoleMenuMapper;
	@Autowired
	private SysSecRoleResourceMapper sysSecRoleResourceMapper;
	@Autowired
	private SysSecEmpMapper sysSecEmpMapper;
	@Autowired
	private SysSecUserRoleMapper sysSecUserRoleMapper;
	@Autowired
	private SysSecMenuMapper sysSecMenuMapper;

	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 角色列表查询
	 */
	@Override
	@Transactional(readOnly = true)
	public List<SysSecRole> roleList(Map<String, Object> appMap) throws Exception {

		/* return sysSecRoleMapper.selectByExample(addWhere(appMap)); */
		SysSecRoleExample example = new SysSecRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andSecEnabledEqualTo("1");
		if (StringUtils.isNotBlank((String) appMap.get("role_code"))) {
			criteria.andRoleCodeEqualTo((String) appMap.get("role_code"));
		}
		if (StringUtils.isNotBlank((String) appMap.get("role_name"))) {
			criteria.andRoleNameEqualTo((String) appMap.get("role_name"));
		}
		if (StringUtils.isNotBlank((String) appMap.get("role_type"))) {
			criteria.andRoleTypeEqualTo((String) appMap.get("role_type"));
		}
		example.setOrderByClause(" create_date_time desc");
		List<SysSecRole> sysSecRoleList = sysSecRoleMapper.selectByExample(example);

		return sysSecRoleList;
	}

	/**
	 * 角色列表删除
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int roleDelete(Map<String, Object> appMap) throws Exception {

		SysSecRoleResourceExample roleresource = new SysSecRoleResourceExample();
		com.zrt.mybatis.domain.SysSecRoleResourceExample.Criteria criteria1 = roleresource.createCriteria();
		criteria1.andRoleIdEqualTo((String) appMap.get("role_id"));

		SysSecUserRoleExample userrole = new SysSecUserRoleExample();
		com.zrt.mybatis.domain.SysSecUserRoleExample.Criteria userroleCriteria = userrole.createCriteria();
		userroleCriteria.andRoleIdEqualTo((String) appMap.get("role_id"));
		// 删除角色资源表
		sysSecRoleResourceMapper.deleteByExample(roleresource);
		// 删除角色绑定的用户
		sysSecUserRoleMapper.deleteByExample(userrole);
		// 删除角色表
		sysSecRoleMapper.deleteByPrimaryKey((String) appMap.get("role_id"));

		// 调用审批同步，删除角色
		flowClient.roleDelete(appMap);
		return 1;

	}

	/**
	 * 角色用户删除
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int roleEmpDelete(Map<String, Object> appMap) throws Exception {

		SysSecUserRoleExample example = new SysSecUserRoleExample();
		com.zrt.mybatis.domain.SysSecUserRoleExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andRoleIdEqualTo((String) appMap.get("role_id"));
		createCriteria.andEmpIdEqualTo((String) appMap.get("emp_id"));
		sysSecUserRoleMapper.deleteByExample(example);

		// 同步审批信息删除审批用户
		List<Map<String, Object>> empids = new ArrayList<Map<String, Object>>();
		empids.add(appMap);
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("param", empids);
		reqMap.put("role_id", (String) appMap.get("role_id"));
		flowClient.roleEmpDelete(reqMap);
		return 1;

	}

	/**
	 * 角色用户批量删除
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int roleEmpBatchDelete(Map<String, Object> appMap) throws Exception {
		List<Map<String, Object>> empids = (List<Map<String, Object>>) appMap.get("param");
		for (Map<String, Object> empidmap : empids) {
			SysSecUserRoleExample example = new SysSecUserRoleExample();
			com.zrt.mybatis.domain.SysSecUserRoleExample.Criteria createCriteria = example.createCriteria();
			createCriteria.andRoleIdEqualTo((String) appMap.get("role_id"));
			createCriteria.andEmpIdEqualTo((String) empidmap.get("emp_id"));
			sysSecUserRoleMapper.deleteByExample(example);
		}
		// 删除审批角色用户
		flowClient.roleEmpDelete(appMap);
		return 1;
	}

	/**
	 * 角色新增
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void roleSave(Map<String, Object> appMap) throws Exception {

		if (StringUtils.isBlank((String) appMap.get("role_name"))) {
			throw new AppException("角色名称不能为空!");
		}
		SysSecRole sysSecRole = new SysSecRole();
		sysSecRole.setRoleId(serialService.getUUID());
		sysSecRole.setRoleCode(serialService.getSerialNumberFromDB("sys_sec_role"));
		sysSecRole.setRoleName((String) appMap.get("role_name"));
		sysSecRole.setRoleDesc((String) appMap.get("role_desc"));
		sysSecRole.setRoleType((String) appMap.get("role_type"));
		sysSecRole.setSecOrder(0);
		sysSecRole.setSecEnabled("1");// 正常
		sysSecRole.setSecSysFlag("1");
		sysSecRole.setSecReadonlyFlag("1");
		sysSecRole.setSecDeleteFlag("0");
		sysSecRole.setCreateDateTime(DateUtil.getCurrentDateTime());
		sysSecRole.setUpdateDateTime(DateUtil.getCurrentDateTime());
		sysSecRole.setVersion(1);
		sysSecRoleMapper.insertSelective(sysSecRole);

		/*
		 * SysSecRole sysSecRole = (SysSecRole)
		 * MapEntityConverter.getEntityFromMap(appMap, SysSecRole.class);
		 * 
		 * sysSecRole.setRoleId(serialService.getSerialNumberFromDB(
		 * "sys_sec_role")); sysSecRole.setSecOrder(0);
		 * sysSecRole.setSecEnabled(Constants.ROLE_SEC_ENABLED_1);
		 * sysSecRole.setSecSysFlag("0"); sysSecRole.setSecReadonlyFlag("0");
		 * sysSecRole.setSecDeleteFlag("0"); sysSecRole.setVersion(0);
		 * sysSecRole.setCreateDateTime(DateUtil.getCurrentDateTime());
		 * sysSecRole.setUpdateDateTime(DateUtil.getCurrentDateTime());
		 */

		// 如果是审批角色新增，则进行同步
		if ("1".equals((String) appMap.get("role_type")) || "2".equals((String) appMap.get("role_type"))) {
			Map<String, Object> reqMap = MapEntityConverter.getMapFromEntity(new String[] { "role_id", "role_code",
					"org_id", "org_level_type", "role_name", "role_desc", "sec_order", "sec_enabled", "sec_sys_flag",
					"sec_readonly_flag", "sec_delete_flag", "create_date_time", "update_date_time", "version_",
					"group_code", "tenant_id", "role_type" }, sysSecRole);
			// 审批角色新增
			flowClient.roleSave(reqMap);
		}

	}

	/**
	 * 角色信息查询
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> roleSearch(Map<String, Object> appMap) throws Exception {
		/*
		 * List<SysSecRole> list =
		 * sysSecRoleMapper.selectByExample(addWhere(appMap));
		 * 
		 * SysSecRole sysSecRole = list.get(0);
		 * 
		 * Map<String, Object> roleMap = MapEntityConverter.getMapFromEntity(new
		 * String[]{"role_id","role_code","role_name","role_enabled","role_desc"
		 * ,"create_date_time"}, sysSecRole);
		 */
		SysSecRole sysSecRole = sysSecRoleMapper.selectByPrimaryKey((String) appMap.get("role_id"));
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("role_id", sysSecRole.getOrgId());
		resMap.put("role_code", sysSecRole.getRoleCode());
		resMap.put("role_name", sysSecRole.getRoleName());
		resMap.put("role_desc", sysSecRole.getRoleDesc());
		return resMap;
	}

	/**
	 * 角色更新
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void roleUpdate(Map<String, Object> appMap) throws Exception {
		/*
		 * SysSecRole sysSecRole = (SysSecRole)
		 * MapEntityConverter.getEntityFromMap(appMap, SysSecRole.class);
		 * 
		 * sysSecRole.setUpdateDateTime(DateUtil.getCurrentDateTime());
		 * 
		 * return sysSecRoleMapper.updateByPrimaryKeySelective(sysSecRole);
		 */
		SysSecRole sysSecRole = sysSecRoleMapper.selectByPrimaryKey((String) appMap.get("role_id"));

		// sysSecRole.setRoleCode((String) appMap.get("role_code"));
		sysSecRole.setRoleName((String) appMap.get("role_name"));
		sysSecRole.setRoleDesc((String) appMap.get("role_desc"));
		sysSecRole.setUpdateDateTime(DateUtil.getCurrentDateTime());
		sysSecRoleMapper.updateByPrimaryKeySelective(sysSecRole);

		// 如果是审批角色新增，则进行同步
		if ("1".equals((String) appMap.get("role_type")) || "2".equals((String) appMap.get("role_type"))) {
			Map<String, Object> reqMap = MapEntityConverter.getMapFromEntity(new String[] { "role_id", "role_code",
					"org_id", "org_level_type", "role_name", "role_desc", "sec_order", "sec_enabled", "sec_sys_flag",
					"sec_readonly_flag", "sec_delete_flag", "create_date_time", "update_date_time", "version_",
					"group_code", "tenant_id", "role_type" }, sysSecRole);
			// 审批角色新增
			flowClient.roleUpdate(reqMap);
		}
	}

	/**
	 * 角色资源列表
	 */
	// @Override
	// @Transactional(readOnly = true)
	// public List<Map<String, Object>> roleResourceSearch(Map<String, Object>
	// appMap) throws Exception {
	// // 查询该角色已绑定的功能//角色id，root_menu_code,查询该角色下拥有的资源
	// List<Map<String, Object>> roleResourceList =
	// roleMapper.roleResourceList(appMap);
	// // 查询所有的功能列表
	// List<Map<String, Object>> allResourceList =
	// resourceMapper.resourceList(appMap);
	// // 分析
	// List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
	// for (Map<String, Object> resMap : allResourceList) {
	// Map<String, Object> dataMap = new HashMap<String, Object>();
	// dataMap.put("resource_id", resMap.get("resource_id"));// 资源id
	// dataMap.put("resource_name", resMap.get("resource_name"));// 资源名称
	// dataMap.put("menu_code", resMap.get("menu_code"));// 菜单code
	// // dataMap.put("menu_level", resMap.get("menu_level"));//菜单级别
	// dataMap.put("menu_name", resMap.get("menu_name"));// 菜单名称
	// // dataMap.put("parent_code", resMap.get("parent_code"));//父级菜单
	// // dataMap.put("root_menu_code", resMap.get("root_menu_code"));//根菜单
	// dataMap.put("is_role", false);// 默认没有绑定角色
	// String res_id = (String) resMap.get("resource_id");// 资源id
	// for (Map<String, Object> map : roleResourceList) {
	// String rid = (String) map.get("resource_id");// 资源id
	// if (res_id.equals(rid)) {
	// dataMap.put("is_role", true);
	// break;
	// }
	// }
	// resList.add(dataMap);
	// }
	// return resList;
	// }
	/**
	 * 角色资源列表--菜单级别20171222修改
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> roleResourceSearch(Map<String, Object> appMap) throws Exception {
		// 查询角色下已绑定的菜单
		List<Map<String, Object>> roleMenuList = roleMapper.roleMenuNewList(appMap);
		// 查询角色下已绑定的菜单下的按钮资源
		List<Map<String, Object>> roleRsList = roleMapper.roleMenuRsList(appMap);
		// 查询所有的功能列表
		List<Map<String, Object>> allResourceList = resourceMapper.menuAllList(appMap);
		// 分析
		List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> resMap : allResourceList) {
			String menuCode = (String) resMap.get("menu_code");// 菜单code
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("menu_code", menuCode);// 菜单code
			// 根据菜单code查询该菜单下的按钮
			Map<String, Object> rsReqMap = new HashMap<>();
			rsReqMap.put("menu_code", menuCode);
			List<Map<String, Object>> rsList = resourceMapper.rsList(rsReqMap);
			if (rsList != null && rsList.size() > 0) {
				for (Map<String, Object> rsMap : rsList) {
					String rsId = (String) rsMap.get("resource_id");
					String rsName = (String) rsMap.get("resource_name");
					Map<String, Object> dataRsMap = new HashMap<String, Object>();
					dataRsMap.put("is_role", false);
					dataRsMap.put("parent_code", menuCode);
					dataRsMap.put("menu_code", rsId);
					dataRsMap.put("menu_name", rsName);
					dataRsMap.put("menu_level", 99);
					if (roleRsList != null && roleRsList.size() > 0) {
						for (Map<String, Object> map : roleRsList) {
							String rid = (String) map.get("resource_id");// 资源id
							if (rsId.equals(rid)) {
								dataRsMap.put("is_role", true);
								break;
							}
						}
					}
					resList.add(dataRsMap);
				}
			}

			// dataMap.put("rsList", rsList);// 菜单下按钮
			dataMap.put("menu_name", resMap.get("menu_name"));// 菜单名称
			dataMap.put("parent_code", resMap.get("parent_code"));// 父级菜单
			dataMap.put("menu_level", resMap.get("menu_level"));// 菜单级别
			dataMap.put("is_role", false);// 默认没有绑定角色
			if (roleMenuList != null && roleMenuList.size() > 0) {
				for (Map<String, Object> map : roleMenuList) {
					String mid = (String) map.get("menu_code");// 菜单id
					if (menuCode.equals(mid)) {
						dataMap.put("is_role", true);
						break;
					}
				}
			}

			resList.add(dataMap);
		}

		return resList;
	}

	/**
	 * 角色绑定功能列表查询
	 */
	@SuppressWarnings({ "unchecked", "unchecked", "unchecked", "null" })
	// @Override
	// @Transactional(rollbackFor = { Throwable.class }, propagation =
	// Propagation.REQUIRED)
	// public void roleResourceSet(Map<String, Object> appMap) throws Exception
	// {
	// // 删除roleId对应的资源
	// Map<String, Object> delMap = new HashMap<>();
	// delMap.put("role_id", appMap.get("role_id"));// 角色id
	// delMap.put("root_menu_code", appMap.get("root_menu_code"));// 一级菜单分组
	// roleMapper.deleteRoleResource(delMap);
	// // 批量插入角色，资源关联表
	// // 获取更新角色列表
	// List<Map<String, Object>> roleResourceList = (List<Map<String, Object>>)
	// appMap.get("param");
	// if (roleResourceList == null || roleResourceList.size() == 0) {
	// return;
	// }
	// for (Map<String, Object> map : roleResourceList) {
	// map.put("role_id", appMap.get("role_id"));
	// }
	// // 批量插入角色用户表
	// roleMapper.roleResourceSave(roleResourceList);
	// /**
	// * //根据role_id，查询该资源列表所关联的菜单 List<Map<String, Object>>
	// * roleMenuList=roleMapper.roleMenuList(appMap); //插入到角色菜单表
	// * for(Map<String, Object> map:roleMenuList){ SysSecRoleMenu
	// * roleMenu=new SysSecRoleMenu();
	// * roleMenu.setMenuCode((String)map.get("menu_code"));//菜单编号
	// * roleMenu.setRoleId((String)appMap.get("role_id"));//角色id
	// * sysSecRoleMenuMapper.insert(roleMenu); }
	// **/
	// }
	/**
	 * 角色绑定功能列表查询（只绑定到菜单20171222修改）
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void roleResourceSet(Map<String, Object> appMap) throws Exception {
		// 先删除roleId对应的菜单，再根据菜单删除对应的按钮资源
		Map<String, Object> delMap = new HashMap<>();
		delMap.put("role_id", appMap.get("role_id"));// 角色id
		delMap.put("root_menu_code", appMap.get("root_menu_code"));// 一级菜单分组
		roleMapper.deleteRoleMenu(delMap);// 删菜单
		roleMapper.deleteRoleRs(delMap);// 删菜单下的按钮资源

		// 前端把按钮和菜单当做同种类型提交，先把菜单和按钮解析提取出来再分别保存
		List<Map<String, Object>> menuList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> resourceList = new ArrayList<Map<String, Object>>();

		List<Map<String, Object>> paramList = (List<Map<String, Object>>) appMap.get("param");
		if (paramList != null && paramList.size() > 0) {
			for (Map<String, Object> paramMap : paramList) {
				String codeType = ((String) paramMap.get("menu_code")).substring(0, 3);// resource表的resource_id命名须有规则
				if ("rs_".equals(codeType)) {// "rs_"开头的为按钮
					Map<String, Object> resourceMap = new HashMap<String, Object>();
					resourceMap.put("resource_id", (String) paramMap.get("menu_code"));
					resourceMap.put("menu_code", (String) paramMap.get("parent_code"));
					resourceMap.put("role_id", appMap.get("role_id"));
					resourceList.add(resourceMap);
				} else {
					Map<String, Object> menuMap = new HashMap<String, Object>();
					menuMap.put("menu_code", (String) paramMap.get("menu_code"));
					menuMap.put("role_id", appMap.get("role_id"));
					menuList.add(menuMap);
				}
			}
		}

		// 批量插入角色资源表
		if (resourceList != null && resourceList.size() > 0) {
			roleMapper.roleRsSave(resourceList);
		}

		if (menuList != null && menuList.size() > 0) {
			Map<String, Object> menuRootMap = new HashMap<>();
			menuRootMap.put("menu_code", appMap.get("root_menu_code"));// 一级菜单
			menuRootMap.put("role_id", appMap.get("role_id"));// 一级菜单
			menuList.add(menuRootMap);
			roleMapper.roleMenuSave(menuList);
		}
	}

	public SysSecRoleExample addWhere(Map<String, Object> appMap) {
		SysSecRoleExample example = new SysSecRoleExample();
		Criteria criteria = example.createCriteria();

		if (null == appMap)
			return example;
		criteria.andSecEnabledEqualTo("1");// 状态是正常的
		if (StringUtils.isNotBlank((String) appMap.get("role_id"))) {
			criteria.andRoleIdEqualTo(String.valueOf(appMap.get("role_id")));
		}
		if (StringUtils.isNotBlank((String) appMap.get("role_code"))) {
			criteria.andRoleIdEqualTo((String) appMap.get("role_code"));
		}
		if (StringUtils.isNotBlank((String) appMap.get("role_name"))) {
			criteria.andRoleIdEqualTo((String) appMap.get("role_name"));
		}
		return example;
	}

	// 根据角色查询用户信息
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> roleUserList(Map<String, Object> appMap) throws Exception {
		// TODO Auto-generated method stub
		//// 设置分页条件
		PageInit.setPage(appMap);
		PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
				Integer.parseInt(appMap.get("maxResult").toString()), true);
		// 获取用户列表
		List<Map<String, Object>> dataList = roleMapper.roleUserList(appMap);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", pageInfo.getList());
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	// 角色绑定员工
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> roleEmpAdd(Map<String, Object> appMap) throws Exception {
		String empIds = (String) appMap.get("emp_code");
		if (empIds.endsWith(";")) {
			empIds = empIds.substring(0, empIds.length() - 1);
		}
		String[] ids = empIds.split(";");
		for (int i = 0; i < ids.length; i++) {
			if (StringUtils.isNotBlank(ids[i])) {
				SysSecEmp emp = sysSecEmpMapper.selectByPrimaryKey(ids[i]);
				// 查询员工是否有这个角色
				SysSecUserRoleExample exampleUserRole = new SysSecUserRoleExample();
				com.zrt.mybatis.domain.SysSecUserRoleExample.Criteria criteriaUserRole = exampleUserRole
						.createCriteria();
				criteriaUserRole.andRoleIdEqualTo((String) appMap.get("role_id"));
				criteriaUserRole.andEmpIdEqualTo(emp.getEmpId());
				List<SysSecUserRole> listUserRole = sysSecUserRoleMapper.selectByExample(exampleUserRole);
				if (listUserRole != null && listUserRole.size() > 0) {
					continue;
				}

				// 新增角色员工表数据
				SysSecUserRole sysSecUserRole = new SysSecUserRole();
				sysSecUserRole.setEmpId(emp.getEmpId());
				sysSecUserRole.setRoleId((String) appMap.get("role_id"));
				sysSecUserRoleMapper.insert(sysSecUserRole);

				Map<String, Object> reqMap = new HashMap<String, Object>();
				reqMap.put("emp_id", emp.getEmpId());
				reqMap.put("role_id", (String) appMap.get("role_id"));
				// 审批角色用户新增
				SysSecRole sysSecRole = sysSecRoleMapper.selectByPrimaryKey((String) appMap.get("role_id"));
				if ("1".equalsIgnoreCase(sysSecRole.getRoleType()) || "2".equalsIgnoreCase(sysSecRole.getRoleType())) {
					flowClient.roleEmpAdd(reqMap);
				}
			}

		}

		return null;

	}

	@Override
	public Map<String, Object> roleMenuList(Map<String, Object> appMap) throws Exception {
		// 查询所有的一级菜单
		SysSecMenuExample menuExample = new SysSecMenuExample();
		com.zrt.mybatis.domain.SysSecMenuExample.Criteria menuCriteria = menuExample.createCriteria();
		menuCriteria.andMenuLevelEqualTo(1);// 代表菜单为一级的
		// menuExample.setOrderByClause(" sec_order");
		menuExample.setOrderByClause("sec_order");
		List<SysSecMenu> menuList = sysSecMenuMapper.selectByExample(menuExample);
		List<Map<String, Object>> menuMapList = MapEntityConverter
				.getMapFromList(new String[] { "root_menu_code", "menu_name" }, menuList, SysSecMenu.class);

		Map<String, Object> resMap = new HashMap<>();
		resMap.put("role_id", appMap.get("role_id"));// 角色id
		resMap.put("menuList", menuMapList);// 菜单编号
		return resMap;
	}

	/**
	 * 流程角色功能查询
	 */
	@Override
	public Map<String, Object> roleFlowList(Map<String, Object> appMap) throws Exception {
		Map<String, Object> resultMap = flowClient.roleFlowList(appMap);
		Boolean result = (Boolean) resultMap.get("result");
		Map<String, Object> dataObj = new HashMap<String, Object>();
		if (result) {// 返回成功
			dataObj = (HashMap<String, Object>) resultMap.get("data");
		}
		return dataObj;
	}

	/**
	 * 流程角色功能绑定
	 */
	@Override
	public Map<String, Object> roleFlowSet(Map<String, Object> appMap) throws Exception {
		Map<String, Object> resultMap = flowClient.roleFlowSet(appMap);
		Boolean result = (Boolean) resultMap.get("result");
		if (!result) {// 返回成功
			throw new AppException("流程权限绑定失败");
		}
		return null;
	}
}
