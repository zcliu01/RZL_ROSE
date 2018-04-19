package com.zrt.contacts.service.friend;

import java.util.List;
import java.util.Map;

import com.zrt.commons.AppException;
import com.zrt.mybatis.domain.EmpContactsFriend;

/**
 * Created by msKui on 2017/3/3.
 */
public interface FriendService {

	/**
	 * 保存常用联系人
	 * 
	 * @param contactsFriend
	 * @return 保存成功后的条数
	 */
	Integer friendSave(EmpContactsFriend contactsFriend);

	/**
	 * 保存常用联系人
	 * 
	 * @param listContactsFriend
	 * @return 保存成功后的条数
	 */
	Integer friendSave(List<EmpContactsFriend> listContactsFriend);

	/**
	 * 搜索常用联系人
	 * 
	 * @param empId
	 * @return
	 */
	Map<String, Object> friendSearch(String empId);

	/**
	 * 查询用户的组织机构和对应职位 isFirstOrg = 1 ：查询主职位 isFirstOrg = 0 ：查询次职位 isFirstOrg =
	 * null ：查询主次职位
	 * 
	 * @param userId
	 * @param isFirstOrg
	 * @return
	 */
	List<Map<String, Object>> empSearch(String userId, String isFirstOrg);

	/**
	 * 删除常用联系人
	 * 
	 * @param contactsFriend
	 * @return
	 */
	Integer friendDelete(EmpContactsFriend contactsFriend);

	/**
	 * 删除常用联系人
	 * 
	 * @param empId
	 * @param friendEmpIdArr
	 * @return
	 */
	Integer friendDelete(String empId, String[] friendEmpIdArr);

	/**
	 * 查询常用联系人
	 * 
	 * @param mapParam
	 * @return
	 */
	List<Map<String, Object>> empList(Map<String, Object> mapParam) throws AppException;

	/**
	 * 导出员工列表
	 * 
	 * @param empIdArr
	 * @return
	 */
	List<Map<String, Object>> exportEmpToExcel(Map<String, Object> map) throws Exception;

	/**
	 * 员工履历信息
	 * 
	 * @param empId
	 * @return
	 */
	List<Map<String, Object>> getWorkRedeploy(String empId);

	// 机构树列表
	List<Map<String, Object>> orgAllList(Map<String, Object> appMap) throws Exception;

	/**
	 * 机构员工列表
	 * 
	 * @param map
	 * @return
	 */

	List<Map<String, Object>> orgEmpList(Map<String, Object> map) throws AppException;

	/**
	 * 云盘获取员工列表
	 * 
	 * @param map
	 * @return
	 */

	List<Map<String, Object>> ypEmpList(Map<String, Object> map) throws AppException;

	/**
	 * 查询常用联系人的数目
	 * 
	 * @param empId
	 * @param status
	 *            查询在职员工还是离职员工
	 * 
	 * @return Integer
	 */
	Integer contactsCount(String empId, String status);

	/**
	 * APP端 常用联系人列表
	 * 
	 * @param empContactsFriend
	 * @return
	 */
	List<Map<String, Object>> friendList(Map<String, Object> map) throws AppException;

	/**
	 * 添加常用联系人之前,判断是否已存在,若已添加,提示已添加消息;若不存在,则添加
	 * 
	 * @param empId
	 * @param friendEmpId
	 * @return
	 */
	Integer selectFriendIsExists(String empId, String friendEmpId);

	/**
	 * APP端判断两人是否是常用联系人的关系
	 * 
	 * @param empId
	 * @param userEmpId
	 * @return
	 */
	int selectIsNotFriend(String empId, String userEmpId);

	/**
	 * 根据员工ID 获取员工姓名、部门id、部门名称
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getEmpName(Map<String, Object> map);

	/**
	 * App端 添加常用联系人初始化页面
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> friendSavePage(Map<String, Object> map) throws AppException;

	/**
	 * 批量添加常用联系人
	 * 
	 * @param map
	 */
	Integer friendSave(Map<String, Object> map) throws AppException;

	/**
	 * 批量删除常用联系人
	 * 
	 * @param map
	 */
	void friendDelete(Map<String, Object> map) throws AppException;
}
