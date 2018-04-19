package com.zrt.contacts.service.sys;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:SysSecOrgService
 * @Description:
 *               <p>
 * 				系统机构 服务
 *               </p>
 * 
 */
public interface SysSecOrgService {
	/**
	 * 查询所有部门 ：部门名称+该部门下员工人数+该部门下所有员工信息(头像+姓名)
	 * 
	 * @param map
	 * @return
	 */
	// List<Map<String,Object>> orgAndEmpList(Map<String, Object> map);
	/**
	 * 查询所有部门 ：部门名称+该部门下员工人数+该部门下所有员工信息(头像+姓名)
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> orgList(Map<String, Object> map);

	/**
	 * 查询待撤销部门列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> preCancelOrgList(Map<String, Object> appMap);

}
