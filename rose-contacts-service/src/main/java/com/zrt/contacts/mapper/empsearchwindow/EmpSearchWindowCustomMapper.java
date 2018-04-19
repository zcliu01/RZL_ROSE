package com.zrt.contacts.mapper.empsearchwindow;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * Created by msKui on 2017/3/6.
 */
public interface EmpSearchWindowCustomMapper {

	/**
	 * 多个条件匹配的查询常用联系人，树。
	 * 
	 * @param mapParam
	 * @return
	 */
	List<Map<String, Object>> friendEmpTree(@Param("mapParam") Map<String, Object> mapParam);

	/**
	 * 多个条件匹配的查询我的群组成员，树。
	 * 
	 * @param mapParam
	 * @return
	 */
	List<Map<String, Object>> friendGroupEmpTree(@Param("mapParam") Map<String, Object> mapParam);

	/**
	 * 多条件获取组织机构下的员工，树
	 * 
	 * @param mapParam
	 * @return
	 */
	List<Map<String, Object>> orgEmpTree(@Param("mapParam") Map<String, Object> mapParam);

	/**
	 * 多条件获取最近联系人下的员工，树
	 * 
	 * @param mapParam
	 * @return
	 */
	List<Map<String, Object>> getRecentlyCmuct(@Param("mapParam") Map<String, Object> mapParam);

	/**
	 * 待撤销部门机构成员，树。
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> preCancelOrgEmpTree(@Param("mapParam") Map<String, Object> map);

	/**
	 * 通用的联系人查询功能
	 * 
	 * @param map
	 * @return
	 *//*
		 * Map<String, Object> commonEmpSearch(@Param("map") Map<String, Object>
		 * map);
		 */
	/**
	 * 联系人 模糊查询
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> EmpLikeSearch(@Param("mapParam") Map<String, Object> map);

	/**
	 * 联系人 精确查询
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> EmpTrueSearch(@Param("map") Map<String, Object> map);

	/**
	 * 讯息收件人按职级排序
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> infoReceiverOrderByRank(@Param("map") Map<String, Object> map);

	/**
	 * 参会人信息列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> meetEmpInfo(@Param("mapParam") Map<String, Object> map);

	/**
	 * 员工信息放入redis
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> setRedis();

	/**
	 * 参会人信息列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> empOrgInfo(Map<String, Object> map);

	/**
	 * 根据部门查询员工
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selectByOrg(Map<String, Object> map);
}
