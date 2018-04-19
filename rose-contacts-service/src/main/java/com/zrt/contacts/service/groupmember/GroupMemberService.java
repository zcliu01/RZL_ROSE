package com.zrt.contacts.service.groupmember;

import java.util.List;
import java.util.Map;

import com.zrt.commons.AppException;
import com.zrt.mybatis.domain.EmpContactsGroupMember;

/**
 * Created by msKui on 2017/3/8.
 */
public interface GroupMemberService {

	/**
	 * 普通保存操作
	 * 
	 * @param sysContactsGroupMember
	 * @return
	 */
	Integer groupMemberSave(EmpContactsGroupMember sysContactsGroupMember);

	/**
	 * 保存多条记录，包括群主信息。
	 * 
	 * @param friendGroupId
	 * @param createEmpId
	 * @param groupMembers
	 * @return
	 */
	Integer groupMemberSave(String friendGroupId, String createEmpId, String groupMembers);

	/**
	 * 保存多条记录，不包括群主信息。
	 * 
	 * @param friendGroupId
	 * @param groupMembers
	 * @return
	 */
	Integer groupMemberSave(String friendGroupId, String groupMembers);

	/**
	 * 删除多条记录。
	 * 
	 * @param friendGroupId
	 * @param empIdArr
	 * @return
	 */
	Integer groupMemberDelete(String friendGroupId, String[] empIdArr);

	/**
	 * 普通删除操作。
	 * 
	 * @param sysContactsGroupMember
	 * @return
	 */
	Integer groupMemberDelete(EmpContactsGroupMember sysContactsGroupMember);

	/**
	 * 批量删除群组成员
	 * 
	 * @throws Exception
	 */
	void groupMemberDelete(Map<String, Object> map) throws Exception;

	/**
	 * 查询我的群组成员
	 * 
	 * @param mapParam
	 * @return
	 */
	Map<String, Object> friendGroupEmpList(Map<String, Object> mapParam) throws AppException;

	/**
	 * 查询我的群组成员
	 * 
	 * @param mapParam
	 * @return
	 */
	Map<String, Object> newFriendGroupEmpList(Map<String, Object> mapParam) throws AppException;

	/**
	 * 添加群组成员
	 * 
	 * @param map
	 * @throws Exception 
	 */
	void groupMemberSave(Map<String, Object> map) throws AppException, Exception;

	/**
	 * App端 添加群组成员初始化页面
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> groupMemberSavePage(Map<String, Object> map) throws AppException;

}
