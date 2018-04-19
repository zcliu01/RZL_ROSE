package com.zrt.contacts.service.friendgroup;

import com.zrt.commons.AppException;
import com.zrt.mybatis.domain.EmpContactsFriendGroup;

import java.util.List;
import java.util.Map;

/**
 * Created by msKui on 2017/3/6.
 */
public interface FriendGroupService {

    /**
     * 保存群组--原来代码
     * @param contactsFriendGroup
     * @return 保存成功后的条数
     */
    Integer friendGroupSave(EmpContactsFriendGroup contactsFriendGroup,String groupMembers);


    /**
     * 查找群组树
     * @param map
     * @return
     */
    List<Map<String,Object>> selectFriendGroupTree(Map<String,Object> map);

    /**
     * 查找群组
     * @param contactsFriendGroup
     * @return
     */
    List<EmpContactsFriendGroup> selectFriendGroup(EmpContactsFriendGroup contactsFriendGroup);

    /**
     * 删除群组
     * @param friendGroupId
     * @return
     */
    Integer friendGroupDeleteByPK(String friendGroupId);

    /**
     * 删除群组
     * @param contactsFriendGroup
     * @return
     */
    Integer friendGroupDelete(EmpContactsFriendGroup contactsFriendGroup);

    /**
     * 更新群组
     * @param map
     * @return
     */
  void  friendGroupUpdate(Map<String, Object> map)throws AppException;

    /**
	 * 我的群组 数目统计
	 */
	Integer friendGroupCount(String empId);

	/**
	 * App端 根据员工ID(即群主ID)查询所有 我创建的群组
	 * 
	 * @param empId
	 * @return
	 */
	List<Map<String,Object>> selectCreateGroupByCreateEmpId(Map<String, Object> map);

	/**
	 * App端 根据员工ID 查询所有 我加入的群组
	 * 
	 * @param empId
	 * @return
	 */
	List<Map<String,Object>> selectJoinGroupByEmpId(Map<String, Object> map);
	/**
	 * App端 查询 公司群组 列表
	 * @return
	 */
	List<Map<String, Object>> selectCompanyGroupList(Map<String, Object> map);
/**
 * App端根据群组ID 查询群员数量
 * @param friendGroupId
 * @return
 */
	int selectGroupMemCount(String friendGroupId);

/**
 * App端  获取群组详情 (包括员工头像+员工姓名)
 * @param friendGroupId
 * @return
 */
List<Map<String, Object>> selectGroupDetails(Map<String, Object> map) throws AppException;

/**
 * 群组搜索
 * @param map
 * @return
 */
List<Map<String, Object>> selectGroupBySearch(Map<String, Object> map);

/**
 * 创建群组--第2次迭代
 * @param map
 * @return
 * @throws Exception 
 */
void friendGroupSave(Map<String, Object> map)throws AppException, Exception ;

/**
 * 查看群组详情--第2次迭代
 * @param map
 * @return
 */
List<Map<String, Object>> friendGroupDetails(Map<String, Object> map);

/**
 * 解散群组或者退出群组
 * @param map
 */
void groupDismissOrQuit(Map<String, Object> map) throws  Exception;
/**
 * APP端 群组成员列表
 * @param map
 * @return
 */
List<Map<String, Object>> selectGroupMemList(Map<String, Object> map) throws AppException;

/**
 * PC端 我的群组
 * @param map
 * @return
 * @throws AppException
 */
List<Map<String, Object>> friendGroupTree(Map<String, Object> map) throws AppException;

/***
 * APP端群组列表
 * @param map
 * @return
 */
List<Map<String, Object>> friendGroupList(Map<String, Object> map)throws AppException;


}
