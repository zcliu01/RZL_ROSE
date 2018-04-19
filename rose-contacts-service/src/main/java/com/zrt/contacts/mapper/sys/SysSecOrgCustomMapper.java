package com.zrt.contacts.mapper.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zrt.mybatis.domain.SysSecOrg;

/**
 * 
 * @description 系统机构 自定义 mapper接口
 * @author ajzhou
 *
 */
public interface SysSecOrgCustomMapper {

	/**
	 * 部门列表 部门名称+人数
	 * 
	 * @param map
	 * @return list
	 */
	List<Map<String, Object>> orgList(@Param("map") Map<String, Object> map);

	/**
	 * 查询待撤销部门列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> preCancelOrgList(@Param("map") Map<String, Object> map);

	/**
	 * IM通讯录同步-查询部门列表
	 * 
	 * @return
	 */
	List<Map<String, Object>> selectDeptList();

	List<Map<String, Object>> orgNewList();

}
