package com.zrt.sec.service.relation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrt.mybatis.domain.SysSecOrg;
import com.zrt.mybatis.mapper.SysSecOrgMapper;
import com.zrt.sec.mapper.user.UserMapper;

/**
 * Created by dwliu on 2017/9/14.
 */
@Service
public class RelationServiceImpl implements RelationService {

	@Autowired
	private SysSecOrgMapper sysSecOrgMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public void relationUpdate(Map<String, Object> appMap) throws Exception {

//		Map<String, Object> orgMap = userMapper.manageSearch(appMap);
//		if (!orgMap.isEmpty()) {
//			String orgId = (String) orgMap.get("org_id");
//			SysSecOrg sysSecOrg = sysSecOrgMapper.selectByPrimaryKey(orgId);
//			sysSecOrg.setChargeEmpId((String)appMap.get("charge_emp_id"));
//			sysSecOrg.setChargeEmpName((String)appMap.get("charge_emp_name"));
//			sysSecOrg.setManageEmpId((String)appMap.get("manage_emp_id"));
//			sysSecOrg.setManageEmpName((String)appMap.get("manage_emp_name"));
//			sysSecOrg.setHeadEmpId((String)appMap.get("head_emp_id"));
//			sysSecOrg.setHeadEmpName((String)appMap.get("head_emp_id"));
//			sysSecOrg.setSeniorEmpId((String)appMap.get("senior_emp_id"));
//			sysSecOrg.setSeniorEmpName((String)appMap.get("senior_emp_id"));
//			sysSecOrg.setLeaderEmpId((String)appMap.get("leader_emp_id"));
//			sysSecOrg.setLeaderEmpName((String)appMap.get("leader_emp_id"));
//			sysSecOrgMapper.updateByPrimaryKeySelective(sysSecOrg);
//		}
	}

	@Override
	public Map<String, Object> relationSearch(Map<String, Object> appMap) throws Exception {
		List<Map<String, Object>> dataList = userMapper.manageSearch(appMap);
		Map<String,Object> dataMap=new HashMap<String,Object>();
		dataMap.put("data", dataList);
		return dataMap;
	}

	@Override
	public Map<String, Object> upManageSearch(Map<String, Object> appMap) throws Exception {
		List<Map<String, Object>> dataList = userMapper.upManageSearch(appMap);
		Map<String,Object> dataMap=new HashMap<String,Object>();
		dataMap.put("data", dataList);
		return dataMap;
	}

}
