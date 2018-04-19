package com.zrt.contacts.mapper.role;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zrt.mybatis.domain.SysSecEmp;

/**
 * 
 * @description 角色实体 自定义 mapper接口
 * @author ajzhou
 *
 */
public interface SysSecRoleCustomMapper {

	/**
	 * 根据当前登录用户查询是否有管理员角色
	 * 
	 * @param map
	 * @return
	 */
//	List<Map<String, Object>> empsList(@Param("map") Map<String, Object> map);

	List<Map<String, Object>> selectIsNotSysAd(Map<String, Object> map);

	


}
