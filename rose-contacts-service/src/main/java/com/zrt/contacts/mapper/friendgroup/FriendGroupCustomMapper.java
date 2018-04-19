package com.zrt.contacts.mapper.friendgroup;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by msKui on 2017/3/8.
 */
public interface FriendGroupCustomMapper {
	/**
	 * PC端 查找我的群组 + 公共群组
	 * 
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> selectFriendGroupTree(@Param("map") Map<String, Object> map);

	/**
	 * App端根据员工id 查询 我的群组 数目
	 * 
	 * @param empId
	 * @return Integer
	 */
	Integer friendGroupCount(@Param("empId") String empId);

	/**
	 * App端 根据员工ID 查询所有 我创建的群组
	 * 
	 * @param empId
	 * @return
	 */
	List<Map<String, Object>> selectCreateGroupByCreateEmpId(@Param("map") Map<String, Object> map);

	/**
	 * App端 根据员工ID 查询所有的 我加入的群组
	 * 
	 * @param empId
	 * @return
	 */
	List<Map<String, Object>> selectJoinGroupByEmpId(@Param("map") Map<String, Object> map);

	/**
	 * App端 公司群组 列表
	 * 
	 * @return
	 */
	List<Map<String, Object>> selectCompanyGroupList(@Param("map") Map<String, Object> map);

	/**
	 * App端 获取群组详情 (包括员工头像+员工姓名)
	 * 
	 * @param friendGroupId
	 * @return
	 */
	List<Map<String, Object>> selectGroupDetails(@Param("map") Map<String, Object> map);

	/**
	 * APP端群组搜索
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selectGroupBySearch(@Param("map") Map<String, Object> map);

	/**
	 * 更新群组成员数量 +
	 * 
	 * @param friendGroupId
	 */
	void addMemberQuantity(@Param("friendGroupId") String friendGroupId);

	void addAllMemberQuantity(Map<String, Object> map);

	/**
	 * 更新群组成员数量 -
	 * 
	 * @param friendGroupId
	 */
	void subtractMemberQuantity(@Param("friendGroupId") String friendGroupId);

}
