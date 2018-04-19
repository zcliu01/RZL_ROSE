package com.zrt.contacts.service.sys;
/**
 * @ClassName:SysSecOrgServiceImpl
 * @Description:  <p> 系统机构   服务实现类 </p>
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrt.contacts.mapper.sys.SysSecEmpCustomMapper;
import com.zrt.contacts.mapper.sys.SysSecOrgCustomMapper;
import com.zrt.mybatis.domain.SysSecEmp;
import com.zrt.mybatis.domain.SysSecOrg;

@Service
public class SysSecOrgServiceImpl implements SysSecOrgService {

	@Autowired 
	private SysSecOrgCustomMapper sysSecOrgCustomMapper;
	@Autowired 
	private SysSecEmpCustomMapper sysSecEmpCustomMapper;
	/**
	 * APP端  部门+部门人数 列表
	 */
	@Override
	public List<Map<String, Object>> orgList(Map<String, Object> map) {
		return sysSecOrgCustomMapper.orgList(map);
	}
	/**
	 * 查询待撤销部门列表
	 */
	/*@Override
	public List<Map<String, Object>> selectCancelOrgList(Map<String, Object> map) {
		return sysSecOrgCustomMapper.selectCancelOrgList(map);
	}*/
	/**
	 * 查询待撤销部门列表
	 */
	@Override
	public List<Map<String, Object>> preCancelOrgList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sysSecOrgCustomMapper.preCancelOrgList(map);
	}

	/**部门列表
	 * 部门名称+人数+员工列表(测试阶段)
	 * @param map
     * @return list 
	 */
	/*@Override
	public List<Map<String,Object>> orgAndEmpList(Map<String, Object> map) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		System.out.println(map.get("type"));
		List<SysSecOrg> orgList = sysSecOrgCustomMapper.orgList(map);//所有部门列表

		for (SysSecOrg sysSecOrg : orgList) {
			String orgId = sysSecOrg.getOrgId();
			map.put("org_id",orgId);
			map.put("org_name",sysSecOrg.getOrgName());
			
			Integer empCount = sysSecEmpCustomMapper.selectEmpCount(orgId);//查询部门下 的员工数目
			map.put("empCount",empCount);
			if(StringUtils.isNotBlank(orgId)){
			List<Map<String,Object>> empList = sysSecEmpCustomMapper.selectEmpListByOrgId(orgId);	//查询部门下的员工信息
			map.put("empList", empList);
			list.add(map);
			}
		}
		return list;
	}*/
	
	
}
