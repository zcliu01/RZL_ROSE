package com.zrt.contacts.mapper.groupmember;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zrt.mybatis.domain.EmpContactsGroupMember;

/**
 * Created by msKui on 2017/3/6.
 */
public interface GroupMemberCustomMapper {
	Integer insertMore(List<EmpContactsGroupMember> listGroupMember);

	void insertMemberList(List<Map<String, Object>> list) throws Exception;

	void updateMemberCount(Map<String, Object> map) throws Exception;

	Integer groupMemberDeleteIn(@Param("friendGroupId") String friendGroupId, @Param("empIdArr") String[] empIdArr);

	/**
	 * 查询我的群组中的群成员
	 * 
	 * @param mapParam
	 * @return
	 */
	List<Map<String, Object>> friendGroupEmpList(@Param("mapParam") Map<String, Object> mapParam);

	/**
	 * APP端群组成员列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> appFriendGroupMemList(@Param("map") Map<String, Object> map);

	/**
	 * APP端添加群组成员页面初始化
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> groupMemberSavePage(@Param("map") Map<String, Object> map);

}
