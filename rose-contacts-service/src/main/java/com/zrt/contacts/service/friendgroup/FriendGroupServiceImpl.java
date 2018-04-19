package com.zrt.contacts.service.friendgroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.commons.AppException;
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.utils.PreConditionHandleUtils;
import com.zrt.contacts.mapper.friendgroup.FriendGroupCustomMapper;
import com.zrt.contacts.mapper.groupmember.GroupMemberCustomMapper;
import com.zrt.contacts.service.groupmember.GroupMemberService;
import com.zrt.contacts.service.serial.SerialService;
import com.zrt.mybatis.domain.EmpContactsFriendGroup;
import com.zrt.mybatis.domain.EmpContactsFriendGroupExample;
import com.zrt.mybatis.domain.EmpContactsGroupMember;
import com.zrt.mybatis.domain.EmpContactsGroupMemberExample;
import com.zrt.mybatis.mapper.EmpContactsFriendGroupMapper;
import com.zrt.mybatis.mapper.EmpContactsGroupMemberMapper;

/**
 * Created by msKui on 2017/3/6.
 */
@Service
public class FriendGroupServiceImpl implements FriendGroupService {
	@Autowired
	private EmpContactsFriendGroupMapper sysContactsFriendGroupMapper;

	@Autowired
	private GroupMemberService groupMemberService;

	@Autowired
	private FriendGroupCustomMapper friendGroupCustomMapper;

	@Autowired
	private GroupMemberCustomMapper groupMemberCustomMapper;

	@Autowired
	private EmpContactsFriendGroupMapper empContactsFriendGroupMapper;

	@Autowired
	private EmpContactsGroupMemberMapper empContactsGroupMemeberMapper;

	@Autowired
	private SerialService serialService;

	@Override
	public Integer friendGroupSave(EmpContactsFriendGroup contactsFriendGroup, String groupMembers) {
		Integer i = sysContactsFriendGroupMapper.insertSelective(contactsFriendGroup);

		// 保存群成员
		groupMemberService.groupMemberSave(contactsFriendGroup.getFriendGroupId(), contactsFriendGroup.getCreateEmpId(),
				groupMembers);

		return i;
	}

	/**
	 * PC端 我的群组
	 */
	@Override
	public List<Map<String, Object>> selectFriendGroupTree(Map<String, Object> map) {

		List<Map<String, Object>> listMap = friendGroupCustomMapper.selectFriendGroupTree(map);

		return listMap;
	}

	@Override
	public List<EmpContactsFriendGroup> selectFriendGroup(EmpContactsFriendGroup contactsFriendGroup) {
		EmpContactsFriendGroupExample example = new EmpContactsFriendGroupExample();
		addWhere(example, contactsFriendGroup);

		List<EmpContactsFriendGroup> list = sysContactsFriendGroupMapper.selectByExample(example);

		return list;
	}

	@Override
	public Integer friendGroupDeleteByPK(String friendGroupId) {
		return null;
	}

	@Override
	public Integer friendGroupDelete(EmpContactsFriendGroup contactsFriendGroup) {
		if (contactsFriendGroup == null)
			return null;

		EmpContactsFriendGroupExample example = new EmpContactsFriendGroupExample();
		addWhere(example, contactsFriendGroup);

		Integer i = sysContactsFriendGroupMapper.deleteByExample(example);

		EmpContactsGroupMember sysContactsGroupMember = new EmpContactsGroupMember();
		sysContactsGroupMember.setFriendGroupId(contactsFriendGroup.getFriendGroupId());
		groupMemberService.groupMemberDelete(sysContactsGroupMember);
		return i;
	}

	/**
	 * 更新群组信息
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void friendGroupUpdate(Map<String, Object> map) throws AppException {

		String friendGroupId = (String) map.get("friend_group_id");
		String newFriendGroupName = (String) map.get("friend_group_name");
		String newFriendGroupDesc = (String) map.get("friend_group_desc");
		if (StringUtils.isBlank(friendGroupId)) {
			throw new AppException("获取不到群组id!");
		}
		if (StringUtils.isBlank(newFriendGroupName)) {
			throw new AppException("请输入新的群组名称!");
		}

		if (newFriendGroupName.length() >= 33) {
			throw new AppException("请修改后的群组名称长度保持在32个字符之内!");
		}

		// 获取群组对象
		EmpContactsFriendGroup empContactsFriendGroup = empContactsFriendGroupMapper.selectByPrimaryKey(friendGroupId);
		// 获取原来的群组名称
		String friendGroupName = empContactsFriendGroup.getFriendGroupName();

		if (newFriendGroupName == friendGroupName || newFriendGroupName.equals(friendGroupName)) {
			// 点击修改按钮但是没修改内容
			empContactsFriendGroup.setUpdateDateTime(DateUtil.getCurrentDateTime());
			empContactsFriendGroup.setFriendGroupDesc(newFriendGroupDesc);
		} else {
			// 群组名称不能相同
			EmpContactsFriendGroupExample friendExample = new EmpContactsFriendGroupExample();
			friendExample.createCriteria().andFriendGroupNameEqualTo(newFriendGroupName);
			int countByExample = empContactsFriendGroupMapper.countByExample(friendExample);
			if (countByExample > 0) {
				throw new AppException("群组名称已存在!");
			}
			// 重新赋值
			empContactsFriendGroup.setFriendGroupName(newFriendGroupName);
			empContactsFriendGroup.setUpdateDateTime(DateUtil.getCurrentDateTime());
			empContactsFriendGroup.setFriendGroupDesc(newFriendGroupDesc);
		}

		/*
		 * // 获取群组对象 EmpContactsFriendGroup empContactsFriendGroup =
		 * empContactsFriendGroupMapper.selectByPrimaryKey(friendGroupId); //
		 * 重新赋值 empContactsFriendGroup.setFriendGroupName(newFriendGroupName);
		 * empContactsFriendGroup.setUpdateDateTime(DateUtil.getCurrentDateTime(
		 * )); empContactsFriendGroup.setFriendGroupDesc(newFriendGroupDesc);
		 */
		// 更新对象
		empContactsFriendGroupMapper.updateByPrimaryKeySelective(empContactsFriendGroup);

	}

	public void addWhere(EmpContactsFriendGroupExample example, EmpContactsFriendGroup contactsFriendGroup) {
		EmpContactsFriendGroupExample.Criteria criteria = example.createCriteria();

		if (null == contactsFriendGroup)
			return;

		if (StringUtils.isNotBlank(contactsFriendGroup.getFriendGroupId()))
			criteria.andFriendGroupIdEqualTo(contactsFriendGroup.getFriendGroupId());

		if (StringUtils.isNotBlank(contactsFriendGroup.getCreateEmpId()))
			criteria.andCreateEmpIdEqualTo(contactsFriendGroup.getCreateEmpId());

	}

	/**
	 * 根据员工的id查询 我的群组 数目
	 */
	@Override
	public Integer friendGroupCount(String empId) {

		if (StringUtils.isNotBlank(empId)) {
			Integer friendGroupCount = friendGroupCustomMapper.friendGroupCount(empId);
			return friendGroupCount;
		}
		return null;
	}

	/**
	 * App端 根据员工ID(即群主ID)查询所有的 我创建的群组
	 */
	@Override
	public List<Map<String, Object>> selectCreateGroupByCreateEmpId(Map<String, Object> map) {

		return friendGroupCustomMapper.selectCreateGroupByCreateEmpId(map);
	}

	/**
	 * App端 根据员工ID 查询所有的 我加入的群组
	 */
	@Override
	public List<Map<String, Object>> selectJoinGroupByEmpId(Map<String, Object> map) {

		return friendGroupCustomMapper.selectJoinGroupByEmpId(map);
	}

	/**
	 * App端 查询 公司群组 列表
	 */
	@Override
	public List<Map<String, Object>> selectCompanyGroupList(Map<String, Object> map) {
		return friendGroupCustomMapper.selectCompanyGroupList(map);
	}

	/**
	 * App端根据群组ID 查询群员数量
	 */
	@Override
	public int selectGroupMemCount(String friendGroupId) {
		EmpContactsFriendGroupExample example = new EmpContactsFriendGroupExample();
		example.createCriteria().andFriendGroupIdEqualTo(friendGroupId);
		return sysContactsFriendGroupMapper.countByExample(example);
	}

	/**
	 * App端 获取群组详情 (包括员工头像+员工姓名)
	 */
	@Override
	public List<Map<String, Object>> selectGroupDetails(Map<String, Object> map) throws AppException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String empId = (String) map.get("emp_id");
		String friendGroupId = (String) map.get("friend_group_id");// 获取群组ID
		if (StringUtils.isBlank(empId)) {
			throw new AppException("获取不到emp_id!");
		}
		if (StringUtils.isBlank(friendGroupId)) {
			throw new AppException("传入的friend_group_id参数不能为空!");
		}
		if (map.get("status") == null) {
			map.put("status", "1");// 默认是查询在职员工
		}

		EmpContactsFriendGroup friendGroup = empContactsFriendGroupMapper.selectByPrimaryKey(friendGroupId);
		String createEmpId = friendGroup.getCreateEmpId();// 获取查询出的群主ID

		if (empId == createEmpId || createEmpId.equals(empId)) {
			map.put("is_group_host", "0");// is_group_host："0"表示当前登录员工就是该群的群主，前端显示解散该群按钮

		} else {
			map.put("is_group_host", "1");// is_group_host："1"表示当前登录员工不是该群的群主，前端显示退出该群按钮
		}

		List<Map<String, Object>> groupMemberList = friendGroupCustomMapper.selectGroupDetails(map);
		map.put("group_member_list", groupMemberList);

		list.add(map);
		return list;
	}

	/**
	 * 群组搜索
	 */
	@Override
	public List<Map<String, Object>> selectGroupBySearch(Map<String, Object> map) {

		return friendGroupCustomMapper.selectGroupBySearch(map);
	}

	/**
	 * 创建群组--第2次迭代
	 * 
	 * @throws Exception
	 * 
	 * @throws ReflectiveOperationException
	 */
	@Override
	public void friendGroupSave(Map<String, Object> map) throws Exception {
		String empId = (String) map.get("emp_id");

		String friendGroupName = map.get("friend_group_name") == null ? null
				: map.get("friend_group_name").toString().trim();// 必须要有群组名称
		// 群组名称不能相同
		EmpContactsFriendGroupExample friendExample = new EmpContactsFriendGroupExample();
		friendExample.createCriteria().andFriendGroupNameEqualTo(friendGroupName).andCreateEmpIdEqualTo(empId);
		int countByExample = empContactsFriendGroupMapper.countByExample(friendExample);
		if (countByExample > 0) {
			throw new AppException("群组名称已存在!");
		}

		String friendGroupHeadPhoto = (String) map.get("friend_group_head_photo");
		String friendGroupDesc = (String) map.get("friend_group_desc");
		String friendGroupType = "1"; // 默认创建的新群组都不是公司的固定群组

		String GroupMemberIds = (String) map.get("group_member_ids");// 获取群组成员ID
		if (StringUtils.isNotBlank(GroupMemberIds)) {
			String[] groupMemberIdArr = GroupMemberIds.split(";");
			if (groupMemberIdArr != null && groupMemberIdArr.length > 0) {
				String curDate = DateUtil.getCurrentDateTime();
				List<String> idList = new ArrayList<String>(Arrays.asList(groupMemberIdArr));
//				idList.add(empId);

				// 创建群组,初始化成员数量为1
				EmpContactsFriendGroup friendGroup = new EmpContactsFriendGroup();
				friendGroup.setFriendGroupId(serialService.getUUID());
				friendGroup.setFriendGroupName(friendGroupName);
				friendGroup.setFriendGroupType(friendGroupType);
				friendGroup.setMemberQuantity("1");
				friendGroup.setFriendGroupStatus("1");
				friendGroup.setCreateEmpId(empId);
				friendGroup.setMemberQuantity(String.valueOf(idList.size()));
				friendGroup.setCreateDateTime(curDate);
				friendGroup.setFriendGroupDesc(friendGroupDesc);
				friendGroup.setFriendGroupHeadPhoto(friendGroupHeadPhoto);

				empContactsFriendGroupMapper.insertSelective(friendGroup);
				String friendGroupId = friendGroup.getFriendGroupId();// 获取创建群组的ID

				// 添加群组成员
				List<Map<String, Object>> memberList = new ArrayList<Map<String, Object>>();
				for (String groupMemberId : idList) {
					Map<String, Object> memberMap = new HashMap<String, Object>();
					memberMap.put("friend_group_id", friendGroupId);
					memberMap.put("emp_id", groupMemberId);
					if (empId.equals(groupMemberId)) {
						memberMap.put("member_level", "1");// 群主
					} else {
						memberMap.put("member_level", "3");
					}
					memberMap.put("member_status", "1");
					memberMap.put("create_date_time", curDate);
					memberList.add(memberMap);
				}

				groupMemberCustomMapper.insertMemberList(memberList);
			}
		}
	}

	/**
	 * 查看群组详情--第2次迭代
	 */
	@Override
	public List<Map<String, Object>> friendGroupDetails(Map<String, Object> map) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		String empId = map.get("emp_id").toString();
		String friendGroupId = map.get("friend_group_id").toString();// 获取群组ID
		if (StringUtils.isNotBlank(friendGroupId) && StringUtils.isNotBlank(empId)) {
			EmpContactsFriendGroup friendGroup = empContactsFriendGroupMapper.selectByPrimaryKey(friendGroupId);
			map.put("friend_group_head_photo", friendGroup.getFriendGroupHeadPhoto());
			map.put("friend_group_name", friendGroup.getFriendGroupName());
			map.put("friend_group_desc", friendGroup.getFriendGroupDesc());
			String createEmpId = friendGroup.getCreateEmpId();// 获取查询出的群主ID

			if (empId == createEmpId || createEmpId.equals(empId)) {
				map.put("is_group_host", "0");// is_group_host："0"表示当前登录员工就是该群的群主，前端显示
												// 解散该群按钮
			} else {
				map.put("is_group_host", "1");// is_group_host："1"表示当前登录员工不是该群的群主，前端不显示
												// 解散该群按钮
			}
			list.add(map);
			return list;
		}
		return null;
	}

	/**
	 * 解散群组或者退出群组
	 */
	@Override
	public void groupDismissOrQuit(Map<String, Object> map) throws Exception {
		String empId = map.get("emp_id").toString();
		String friendGroupId = map.get("friend_group_id").toString();
		if (map.get("emp_id") == null || StringUtils.isBlank(empId)) {
			throw new AppException("当前传入的emp_id有错误！");
		}
		if (map.get("friend_group_id") == null || StringUtils.isBlank(friendGroupId)) {
			throw new AppException("当前传入的friend_group_id有错误！");
		}
		String isGroupHost = (String) map.get("is_group_host");
		if (StringUtils.isBlank(isGroupHost)) {
			throw new AppException("当前传入的is_group_host有错误！");
		}

		if (StringUtils.isNotBlank(isGroupHost) && "0".equals(isGroupHost)) {// 是群主，实现解散该群功能
			// 删除所有的群组成员信息
			EmpContactsGroupMemberExample example1 = new EmpContactsGroupMemberExample();
			example1.createCriteria().andFriendGroupIdEqualTo(friendGroupId);
			empContactsGroupMemeberMapper.deleteByExample(example1);
			// 删除该群组
			EmpContactsFriendGroupExample example = new EmpContactsFriendGroupExample();
			example.createCriteria().andCreateEmpIdEqualTo(empId).andFriendGroupIdEqualTo(friendGroupId);
			empContactsFriendGroupMapper.deleteByExample(example);

		}
		if (StringUtils.isNotBlank(isGroupHost) && "1".equals(isGroupHost)) {// 是普通成员，实现退出该群功能
			// 删除当前群组成员信息
			EmpContactsGroupMemberExample example1 = new EmpContactsGroupMemberExample();
			example1.createCriteria().andFriendGroupIdEqualTo(friendGroupId).andEmpIdEqualTo(empId);
			empContactsGroupMemeberMapper.deleteByExample(example1);
		}

	}

	/**
	 * APP端 群组成员列表
	 */
	@Override
	public List<Map<String, Object>> selectGroupMemList(Map<String, Object> map) throws AppException {

		String friendGroupId = (String) map.get("friend_group_id");// 获取群组ID
		String empId = (String) map.get("emp_id");// 获取登录员工ID
		if (StringUtils.isBlank(empId)) {
			throw new AppException("传入的emp_id参数错误");
		}

		if (StringUtils.isBlank(friendGroupId)) {
			throw new AppException("传入的friend_group_id参数错误");
		}
		PreConditionHandleUtils.searchConditionHandle(map);
		map.put("status", map.get("status") == null ? "1" : map.get("status").toString());// 默认查询在职员工

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// 获取群主信息,并判断当前登录用户是否是群主
		String createEmpId = empContactsFriendGroupMapper.selectByPrimaryKey(friendGroupId).getCreateEmpId();
		String is_show_delete = (createEmpId == empId || empId.equals(createEmpId)) ? "1" : "0";
		map.put("is_show_delete", is_show_delete);
		// 获取群组成员
		List<Map<String, Object>> groupMemberList = groupMemberCustomMapper.appFriendGroupMemList(map);
		map.put("group_member_list", groupMemberList);

		list.add(map);
		return list;
	}

	/**
	 * PC端我的群组列表
	 */
	@Override
	public List<Map<String, Object>> friendGroupTree(Map<String, Object> map) throws AppException {

		if (map.get("friend_group_type") == null) {
			map.put("friend_group_type", "1");
		}
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> myGroupList = friendGroupCustomMapper.selectFriendGroupTree(map);
		map.put("myGroupList", myGroupList);// 我的群组（与我有关）
		List<Map<String, Object>> companyGroupList = friendGroupCustomMapper.selectCompanyGroupList(map);
		map.put("companyGroupList", companyGroupList);
		list.add(map);

		return list;
	}

	/**
	 * APP端群组列表(我创建的、我加入的、公司群组)
	 */
	@Override
	public List<Map<String, Object>> friendGroupList(Map<String, Object> map) throws AppException {
		String empId = (String) map.get("emp_id");
		if (StringUtils.isBlank(empId)) {
			throw new AppException("传入的emp_id参数错误!");
		}
		if (map.get("type") == null || StringUtils.isBlank(map.get("type").toString())) {
			map.put("type", "");
		}
		String type = (String) map.get("type");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		if (StringUtils.isNotBlank(type) && "0".equals(type)) {// type：0
																// 显示我创建的群组列表
			list = friendGroupCustomMapper.selectCreateGroupByCreateEmpId(map);

		}
		if (StringUtils.isNotBlank(type) && "1".equals(type)) {// type：1
																// 显示我加入的群组列表
			list = friendGroupCustomMapper.selectJoinGroupByEmpId(map);

		}
		if (StringUtils.isNotBlank(type) && "2".equals(type)) {// type：2
																// 显示公司群组
			list = friendGroupCustomMapper.selectCompanyGroupList(map);

		} else if (StringUtils.isBlank(type)) {
			// 如果type为空，则表示在搜索框中查找全部群组
			// 处理搜索内容
			PreConditionHandleUtils.searchConditionHandle(map);
			list = friendGroupCustomMapper.selectGroupBySearch(map);

		}
		return list;

	}

}
