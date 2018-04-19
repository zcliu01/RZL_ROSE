package com.zrt.contacts.mapper.friend;

import org.apache.ibatis.annotations.Param;

import com.zrt.mybatis.domain.EmpContactsFriend;

import java.util.List;
import java.util.Map;

/**
 * Created by msKui on 2017/3/6.
 */
public interface FriendCustomMapper {
	/**
	 * 插入多条记录
	 * 
	 * @param listContactsFriend
	 * @return
	 */
	Integer insertMore(List<EmpContactsFriend> listContactsFriend);

	/**
	 * 查看员工基本信息+奖惩信息
	 * 
	 * @param empId
	 * @return
	 */
	Map<String, Object> selectEmpDetail(String empId);

	/**
	 * 获取用户部门和职位信息
	 * 
	 * @param userId
	 * @param isFirstOrg
	 * @return
	 */
	List<Map<String, Object>> selectEmpOrgPosition(@Param("userId") String userId,
			@Param("isFirstOrg") String isFirstOrg);

	/**
	 * 删除多个常用联系人
	 * 
	 * @param empId
	 * @param friendEmpIdArr
	 * @return
	 */
	Integer friendDeleteIn(@Param("empId") String empId, @Param("friendEmpIdArr") String[] friendEmpIdArr);

	/**
	 * 常用联系人列表
	 * 
	 * @param mapParam
	 * @return
	 */
	List<Map<String, Object>> empList(@Param("mapParam") Map<String, Object> mapParam);
	
	
	/**
	 * 常用联系人列表
	 * 
	 * @param mapParam
	 * @return
	 */
	List<Map<String, Object>> orgEmpListByOrgName(@Param("mapParam") Map<String, Object> mapParam);

	/**
	 * 导出员工列表
	 * 
	 * @param empIdArr
	 * @return
	 */
	// List<Map<String,Object>> exportEmpToExcel(@Param("empIdArr") String[]
	// empIdArr);
	List<Map<String, Object>> exportEmpToExcel(@Param("empIdList") List<String> empIdList);

	/**
	 * 员工履历信息
	 * 
	 * @param empId
	 * @return
	 */
	List<Map<String, Object>> getWorkRedeploy(String empId);

	// 查询机构树列表
	List<Map<String, Object>> orgAllList(Map<String, Object> appMap) throws Exception;

	/**
	 * 机构员工列表
	 * 
	 * @param mapParam
	 * @return
	 */
	List<Map<String, Object>> orgEmpList(@Param("mapParam") Map<String, Object> mapParam);
	/**
	 * 云盘获取员工列表
	 * 
	 * @param mapParam
	 * @return
	 */
	List<Map<String, Object>> ypEmpList(@Param("mapParam") Map<String, Object> mapParam);

	/**
	 * App端通讯录 员工列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> empAppList(Map<String, Object> map);

	/**
	 * App端 常用联系人 统计数
	 * 
	 * @param status
	 * 
	 * @param mapParam
	 * @return
	 */
	Integer contactsCount(@Param("empId") String empId, @Param("status") String status);

	/**
	 * APP端 保存(添加)常用联系人
	 * 
	 * @param empContactsFriend
	 * @return
	 */
	Integer insert(EmpContactsFriend empContactsFriend);

	/**
	 * App端 显示常用联系人列表
	 * 
	 * @param empId
	 * @return
	 */
	List<Map<String, Object>> friendList(@Param("map") Map<String, Object> map);

	/**
	 * App端 添加常用联系人初始化页面
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> friendSavePage(@Param("map") Map<String, Object> map);

	/***
	 * pc端 根据员工ID查询员工信息
	 * 
	 * @param empId
	 * @return
	 */
	Map<String, Object> selectEmpByEmpId(@Param("empId") String empId);
}
