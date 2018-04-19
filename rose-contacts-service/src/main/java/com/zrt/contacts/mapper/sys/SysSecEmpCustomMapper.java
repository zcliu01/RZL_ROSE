package com.zrt.contacts.mapper.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zrt.mybatis.domain.SysSecEmp;

/**
 * 
 * @description 系统员工实体 自定义 mapper接口
 * @author ajzhou
 *
 */
public interface SysSecEmpCustomMapper {

	/**
	 * 所有员工列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> empsList(@Param("map") Map<String, Object> map);

	/**
	 * 通讯录下 按照部门查询所有的员工列表
	 * 
	 * @param map
	 * @return
	 */

	// List<Map<String, Object>> empListByOrg(@Param("map") String
	// orgId,@Param("search") String search);

	/**
	 * 根据机构ID查询部门下的所有员工信息
	 * 
	 * @param orgId
	 * @return
	 */
	List<Map<String, Object>> selectEmpListByOrgId(@Param("orgId") String orgId);

	/**
	 * 根据员工ID 查询直接上级员工姓名
	 * 
	 * @param empId
	 * @return
	 */
	String selectUpEmpName(@Param("upEmpId") String empId);

	/**
	 * 根据员工ID查询员工详情
	 * 
	 * @param empId
	 * @return
	 */
	List<Map<String, Object>> selectEmpDetails(@Param("empId") String empId);

	/**
	 * 根据员工ID 获取个人履历
	 * 
	 * @param empId
	 * @return
	 */
	List<Map<String, Object>> selectEmpWorkRedeploy(@Param("empId") String empId);

	/**
	 * 根据用户ID 获取职位讯息
	 * 
	 * @param empId
	 * @return
	 */
	List<Map<String, Object>> selectEmpPositionDetails(@Param("userId") String userId,
			@Param("isFirstOrg") String isFirstOrg);
	
	/**
	 * 根temp
	 * 
	 * @param empId
	 * @return
	 */
	List<Map<String, Object>> selectEmpPositionDetailsTemp(@Param("userId") String userId,
			@Param("isFirstOrg") String isFirstOrg);

	/**
	 * 查询部门下的员工数目
	 * 
	 * @param orgId
	 * @return
	 */
	Integer selectEmpCount(@Param("orgId") String orgId);

	/**
	 * App端根据部门ID查询部门下的员工 +检索+状态
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> empListByOrg(@Param("map") Map<String, Object> map);

	/**
	 * App端查询直接上级员工详情
	 * 
	 * @param friendEmpId
	 * @return
	 */
	Map<String, Object> selectUpEmpDetails(@Param("friendEmpId") String friendEmpId);

	/**
	 * 用于IM同步通讯录
	 * 
	 * @return
	 */
	List<Map<String, Object>> selectEmpList();

	List<Map<String, Object>> searchAll();

}
