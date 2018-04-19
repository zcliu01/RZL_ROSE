package com.zrt.sec.service.org;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.commons.AppException;
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.number.NumberUtils;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.mybatis.domain.SysSecOrg;
import com.zrt.mybatis.domain.SysSecOrgCheck;
import com.zrt.mybatis.domain.SysSecOrgCheckExample;
import com.zrt.mybatis.domain.SysSecOrgExample;
import com.zrt.mybatis.domain.SysSecOrgExample.Criteria;
import com.zrt.mybatis.mapper.SysSecOrgCheckMapper;
import com.zrt.mybatis.mapper.SysSecOrgMapper;
import com.zrt.sec.mapper.org.OrgMapper;

@Service("orgServiceImpl")
public class OrgServiceImpl implements OrgService {
	@Autowired
	private SysSecOrgMapper sysSecOrgMapper;

	@Autowired
	private OrgMapper orgMapper;
	@Autowired
	private SysSecOrgCheckMapper SysSecOrgCheckMapper;

	@Override
	@Transactional(readOnly = true)
	public List<SysSecOrg> orgList(Map<String, Object> appMap) throws Exception {
		return sysSecOrgMapper.selectByExample(addWhere(appMap));
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int orgSave(Map<String, Object> appMap) throws Exception {
		SysSecOrg sysSecOrg = (SysSecOrg) MapEntityConverter.getEntityFromMap(appMap, SysSecOrg.class);

		// 第一级组织机构的父id为-1
		if (StringUtils.isBlank(sysSecOrg.getParentOrgId()))
			sysSecOrg.setParentOrgId("-1");
		else
			checkOrgId(sysSecOrg.getParentOrgId());

		String orgId = getOrgId(sysSecOrg.getParentOrgId());
		sysSecOrg.setOrgId(orgId);

		String orgRootId = this.getOrgRootCode(sysSecOrg.getParentOrgId(), orgId);
		sysSecOrg.setRootOrgId(orgRootId);

		Integer orgLevel = this.getOrgLevel(orgId);
		sysSecOrg.setOrgLevel(orgLevel);

		sysSecOrg.setSecEnabled("1");
		sysSecOrg.setSecSysFlag("0");
		sysSecOrg.setSecReadonlyFlag("0");
		sysSecOrg.setSecDeleteFlag("0");
		sysSecOrg.setVersion(0);
		sysSecOrg.setCreateDateTime(DateUtil.getCurrentDateTime());
		sysSecOrg.setUpdateDateTime(sysSecOrg.getCreateDateTime());

		return sysSecOrgMapper.insert(sysSecOrg);
	}

	/**
	 * 获取组织机构编码
	 * 
	 * @param parentKey
	 * @return
	 * @throws Exception
	 */
	public String getOrgId(String parentKey) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parent_org_id", parentKey);
		int countChild = sysSecOrgMapper.countByExample(addWhere(map));

		if ("-1".equals(parentKey))
			return NumberUtils.increaseNumber(countChild, 4);

		if (countChild == 0) {
			return childOrgIsZero(parentKey);
		} else if (countChild > 0 && countChild < 9999) {
			return parentKey + NumberUtils.increaseNumber(countChild, 4);
		} else {
			throw new AppException("生成组织机构编码失败");
		}
	}

	/**
	 * 子组织机构为0时，返回的org_code。 子组织机构没有，有两种情况 1.父组织机构下没有子组织机构 2.parentCode错误
	 * 
	 * @param parentKey
	 * @return
	 * @throws Exception
	 */
	public String childOrgIsZero(String parentKey) throws Exception {
		SysSecOrg sysSecOrg = this.getParentCodeIsOrgId(parentKey);

		// parentKey存在
		if (null != sysSecOrg && StringUtils.isNotBlank(sysSecOrg.getOrgId()))
			return parentKey + NumberUtils.increaseNumber("0000", 4);
		else// parentKey不存在
			throw new AppException("传入的parent_org_id有误" + parentKey);
	}

	/**
	 * 查找父组织机构。 根据子组织机构的parentCode查找。
	 * 
	 * @param parentCode
	 * @return
	 * @throws Exception
	 */
	public SysSecOrg getParentCodeIsOrgId(String parentCode) throws Exception {
		Map<String, Object> mapSearch = new HashMap<String, Object>();
		mapSearch.put("org_id", parentCode);

		Map<String, Object> resultMap = this.orgSearch(mapSearch);

		return (SysSecOrg) MapEntityConverter.getEntityFromMap(resultMap, SysSecOrg.class);
	}

	/**
	 * 父组织机构的orgRootCode就是子组织机构的orgRootCode
	 * 
	 * @param parentKey
	 * @param orgKey
	 * @return
	 * @throws Exception
	 */
	public String getOrgRootCode(String parentKey, String orgKey) throws Exception {
		if ("-1".equals(parentKey))
			return orgKey;

		SysSecOrg sysSecOrg = this.getParentCodeIsOrgId(parentKey);

		return sysSecOrg.getRootOrgId();
	}

	/**
	 * 计算组织机构级别
	 * 
	 * @param orgCode
	 * @return
	 * @throws AppException
	 */
	public Integer getOrgLevel(String orgCode) throws AppException {
		return orgCode.length() / 4;
	}

	/**
	 * 验证字符串是否是4的倍数
	 * 
	 * @param idStr
	 * @throws AppException
	 */
	public void checkOrgId(String idStr) throws AppException {
		int l = idStr.length();
		if (l % 4 != 0)
			throw new AppException("组织机构的id出现错误：" + idStr);
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> orgSearch(Map<String, Object> appMap) throws Exception {
		List<SysSecOrg> list = sysSecOrgMapper.selectByExample(addWhere(appMap));

		if (null == list || list.size() == 0)
			return null;

		SysSecOrg sysSecOrg = list.get(0);

		Map<String, Object> orgMap = MapEntityConverter.getMapFromEntity(new String[] { "org_id", "root_org_id",
				"parent_org_id", "org_code", "org_name", "org_enabled", "org_desc", "create_date_time", "sec_order",
				"group_type", "manage_emp_id", "manage_emp_name", "charge_emp_id", "charge_emp_name" }, sysSecOrg);
		// 根据parent_org_id查询机构名称
		SysSecOrg parentOrg = sysSecOrgMapper.selectByPrimaryKey(sysSecOrg.getParentOrgId());
		if (parentOrg != null) {
			orgMap.put("parent_org_name", parentOrg.getOrgName());// 上级机构名称
		}
		SysSecOrgCheckExample checkExample = new SysSecOrgCheckExample();
		checkExample.createCriteria().andOrgIdEqualTo((String) appMap.get("org_id"));
		List<SysSecOrgCheck> sysSecOrgCheckList = SysSecOrgCheckMapper.selectByExample(checkExample);
		List<Map<String, Object>> checkList = new ArrayList<Map<String, Object>>();
		if (null != sysSecOrgCheckList && !sysSecOrgCheckList.isEmpty()) {
			for (SysSecOrgCheck secCheck : sysSecOrgCheckList) {
				Map<String, Object> checkMap = new HashMap<String, Object>();
				checkMap.put("check_order", secCheck.getCheckOrder());
				checkMap.put("check_emp_id", secCheck.getCheckEmpId());
				checkMap.put("check_emp_name", secCheck.getCheckEmpName());
				checkList.add(checkMap);
			}
		}
		orgMap.put("check_emp_list", checkList);
		return orgMap;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void orgUpdate(Map<String, Object> appMap) throws Exception {

		String orgId = (String) appMap.get("org_id");// 获取机构ID
		SysSecOrg sysSecOrg = sysSecOrgMapper.selectByPrimaryKey(orgId);// 获取到当前的机构对象

		sysSecOrg.setOrgCode((String) appMap.get("org_code"));
		sysSecOrg.setOrgName((String) appMap.get("org_name"));
		sysSecOrg.setOrgDesc((String) appMap.get("org_desc"));
		sysSecOrg.setChargeEmpId((String) appMap.get("charge_emp_id"));
		sysSecOrg.setChargeEmpName((String) appMap.get("charge_emp_name"));
		sysSecOrg.setManageEmpId((String) appMap.get("manage_emp_id"));
		sysSecOrg.setManageEmpName((String) appMap.get("manage_emp_name"));
		sysSecOrg.setSecOrder(Integer.valueOf((String) appMap.get("sec_order")));
		sysSecOrg.setParentOrgId((String) appMap.get("parent_org_id"));// 上级部门ID
		sysSecOrg.setUpdateDateTime(DateUtil.getCurrentDateTime());
		sysSecOrg.setGroupType((String) appMap.get("group_type"));
		sysSecOrgMapper.updateByPrimaryKeySelective(sysSecOrg);

		SysSecOrgCheckExample checkExample = new SysSecOrgCheckExample();
		checkExample.createCriteria().andOrgIdEqualTo(orgId);
		SysSecOrgCheckMapper.deleteByExample(checkExample);
		List<Map<String, Object>> checkList = (List<Map<String, Object>>) appMap.get("check_emp_list");
		if (null != checkList && !checkList.isEmpty()) {
			for (Map<String, Object> checkMap : checkList) {
				SysSecOrgCheck secCheck = new SysSecOrgCheck();
				secCheck.setOrgId(orgId);
				secCheck.setCheckOrder((int) checkMap.get("check_order"));
				secCheck.setCheckEmpId((String) checkMap.get("check_emp_id"));
				secCheck.setCheckEmpName((String) checkMap.get("check_emp_name"));
				SysSecOrgCheckMapper.insert(secCheck);
			}
		}

	}

	/**
	 * 机构模糊检索
	 * 
	 * @param appMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> orgNameSearch(Map<String, Object> appMap) throws Exception {

		/*
		 * SysSecOrgExample example = new SysSecOrgExample(); Criteria criteria
		 * = example.createCriteria();
		 * if(StringUtils.isNotBlank((String)appMap.get("search"))){
		 * criteria.andOrgNameLike((String)appMap.get("search")); }
		 * List<SysSecOrg> orgList = sysSecOrgMapper.selectByExample(example);
		 */
		List<Map<String, Object>> orgList = new ArrayList<Map<String, Object>>();
		if (StringUtils.isNotBlank((String) appMap.get("search"))) {

			orgList = orgMapper.selectOrgListBySearch(appMap);
		}

		return orgList;
	}

	/*
	 * @Override public int orgDelete(Map<String, Object> appMap) throws
	 * Exception { appMap.put("sec_delete_flag", "1"); return
	 * this.orgUpdate(appMap); }
	 */

	public SysSecOrgExample addWhere(Map<String, Object> appMap) {
		SysSecOrgExample example = new SysSecOrgExample();
		Criteria criteria = example.createCriteria();

		if (null == appMap)
			return example;

		if (null != appMap.get("org_id")) {
			criteria.andOrgIdLike(String.valueOf(appMap.get("org_id")));
		}

		if (null != appMap.get("parent_org_id")) {
			criteria.andParentOrgIdEqualTo(String.valueOf(appMap.get("parent_org_id")));
		}

		if (null != appMap.get("sec_delete_flag")) {
			criteria.andSecDeleteFlagEqualTo(String.valueOf(appMap.get("sec_delete_flag")));
		}

		if (null != appMap.get("sec_enabled")) {
			criteria.andSecEnabledEqualTo(String.valueOf(appMap.get("sec_enabled")));
		}

		if (null != appMap.get("sec_readonly_flag")) {
			criteria.andSecReadonlyFlagEqualTo(String.valueOf(appMap.get("sec_readonly_flag")));
		}

		if (null != appMap.get("sec_sys_flag")) {
			criteria.andSecSysFlagEqualTo(String.valueOf(appMap.get("sec_sys_flag")));
		}
		if (null != appMap.get("group_type")) {
			criteria.andGroupTypeEqualTo(String.valueOf(appMap.get("group_type")));
		}

		if (null != appMap.get("order_by")) {
			example.setOrderByClause(String.valueOf(appMap.get("order_by")));
		}

		return example;
	}

	/**
	 * 先暂时查询三级的机构
	 */
	@Override
	public List<Map<String, Object>> orgAllList(Map<String, Object> appMap) throws Exception {

		String groupType = (String) appMap.get("group_type");
		String secEnabled = (String) appMap.get("sec_enabled");
		SysSecOrgExample example = new SysSecOrgExample();
		Criteria criteria = example.createCriteria();
		criteria.andGroupTypeEqualTo(groupType).andSecEnabledEqualTo(secEnabled).andOrgIdLike("00010001%");
		List<SysSecOrg> orgList = sysSecOrgMapper.selectByExample(example);
		List<Map<String, Object>> list = MapEntityConverter.getMapFromList(new String[] { "org_id", "root_org_id",
				"parent_org_id", "org_code", "org_name", "org_enabled", "org_desc", "create_date_time" }, orgList,
				SysSecOrg.class);
		return list;
	}

}
