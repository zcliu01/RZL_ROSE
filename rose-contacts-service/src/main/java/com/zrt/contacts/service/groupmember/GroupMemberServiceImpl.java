package com.zrt.contacts.service.groupmember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.AppException;
import com.zrt.commons.PageInit;
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.utils.PreConditionHandleUtils;
import com.zrt.contacts.mapper.friend.FriendCustomMapper;
import com.zrt.contacts.mapper.friendgroup.FriendGroupCustomMapper;
import com.zrt.contacts.mapper.groupmember.GroupMemberCustomMapper;
import com.zrt.contacts.mapper.role.SysSecRoleCustomMapper;
import com.zrt.contacts.service.friendgroup.FriendGroupService;
import com.zrt.contacts.service.serial.SerialService;
import com.zrt.mybatis.domain.EmpContactsGroupMember;
import com.zrt.mybatis.domain.EmpContactsGroupMemberExample;
import com.zrt.mybatis.domain.EmpContactsGroupMemberExample.Criteria;
import com.zrt.mybatis.domain.SysSecEmp;
import com.zrt.mybatis.domain.SysSecEmpExample;
import com.zrt.mybatis.mapper.EmpContactsFriendGroupMapper;
import com.zrt.mybatis.mapper.EmpContactsGroupMemberMapper;
import com.zrt.mybatis.mapper.SysSecEmpMapper;
import com.zrt.mybatis.mapper.SysSecUserRoleMapper;

/**
 * Created by msKui on 2017/3/8.
 */
@Service
public class GroupMemberServiceImpl implements GroupMemberService {
	@Autowired
	private EmpContactsGroupMemberMapper empContactsGroupMembersMapper;

	@Autowired
	private EmpContactsFriendGroupMapper empContactsFriendGroupMapper;
	@Autowired
	private SysSecEmpMapper sysSecEmpMapper;
	@Autowired
	private SysSecUserRoleMapper sysSecUserRoleMapper;

	@Autowired
	private FriendGroupCustomMapper friendGroupCustomMapper;

	@Autowired
	private FriendCustomMapper friendCustomMapper;

	@Autowired
	private GroupMemberCustomMapper groupMemberCustomMapper;

	@Autowired
	private SysSecRoleCustomMapper sysSecRoleCustomMapper;

	@Autowired
	FriendGroupService friendGroupService;

	@Autowired
	private SerialService serialService;

	@Override
	public Integer groupMemberSave(EmpContactsGroupMember sysContactsGroupMember) {
		Integer i = empContactsGroupMembersMapper.insert(sysContactsGroupMember);
		return i;
	}

	@Override
	public Integer groupMemberSave(String friendGroupId, String createEmpId, String groupMembers) {
		List<EmpContactsGroupMember> membersList = getGroupMembers(friendGroupId, createEmpId, groupMembers);

		Integer i = groupMemberCustomMapper.insertMore(membersList);
		return i;
	}

	@Override
	public Integer groupMemberSave(String friendGroupId, String groupMembers) {
		List<EmpContactsGroupMember> membersList = getGroupMembers(friendGroupId, groupMembers);

		Integer i = groupMemberCustomMapper.insertMore(membersList);
		return i;
	}

	public List<EmpContactsGroupMember> getGroupMembers(String friendGroupId, String createEmpId, String groupMembers) {
		EmpContactsGroupMember sysContactsGroupMember = new EmpContactsGroupMember();
		sysContactsGroupMember.setEmpId(createEmpId);
		sysContactsGroupMember.setFriendGroupId(friendGroupId);
		sysContactsGroupMember.setCreateDateTime(DateUtil.getCurrentDateTime());
		sysContactsGroupMember.setMemberLevel("1");// 群主

		List<EmpContactsGroupMember> list = getGroupMembers(friendGroupId, groupMembers);

		list.add(sysContactsGroupMember);

		return list;
	}

	public List<EmpContactsGroupMember> getGroupMembers(String friendGroupId, String groupMembers) {
		if (StringUtils.isBlank(groupMembers))
			return null;

		List<EmpContactsGroupMember> list = new ArrayList();

		String createDateTime = DateUtil.getCurrentDateTime();

		String[] strArr = groupMembers.split(",");
		EmpContactsGroupMember sysContactsGroupMember;

		for (String memberId : strArr) {
			if (StringUtils.isBlank(memberId))
				break;

			sysContactsGroupMember = new EmpContactsGroupMember();
			sysContactsGroupMember.setEmpId(memberId);
			sysContactsGroupMember.setFriendGroupId(friendGroupId);
			sysContactsGroupMember.setCreateDateTime(createDateTime);
			sysContactsGroupMember.setMemberLevel("3");// 普通成员
			list.add(sysContactsGroupMember);
		}

		return list;
	}

	@Override
	public Integer groupMemberDelete(String friendGroupId, String[] empIdArr) {
		Integer i = groupMemberCustomMapper.groupMemberDeleteIn(friendGroupId, empIdArr);
		return i;
	}

	@Override
	public Integer groupMemberDelete(EmpContactsGroupMember sysContactsGroupMember) {
		EmpContactsGroupMemberExample example = new EmpContactsGroupMemberExample();
		EmpContactsGroupMemberExample.Criteria criteria = example.createCriteria();

		if (StringUtils.isNotBlank(sysContactsGroupMember.getFriendGroupId()))
			criteria.andFriendGroupIdEqualTo(sysContactsGroupMember.getFriendGroupId());

		if (StringUtils.isNotBlank(sysContactsGroupMember.getEmpId()))
			criteria.andEmpIdEqualTo(sysContactsGroupMember.getEmpId());

		Integer i = empContactsGroupMembersMapper.deleteByExample(example);
		return i;
	}

	@Override
	public Map<String, Object> friendGroupEmpList(Map<String, Object> map) throws AppException {
		// 群组成员列表和导出使用同一个实现类
		Map<String, Object> resMap = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> selectMap = new HashMap<String, Object>();
		String empIds = (String) map.get("emp_ids");
		if (StringUtils.isNotBlank(empIds)) {
			// 导出勾选员工
			String[] empIdArr = empIds.split(";");
			for (String empId : empIdArr) {
				selectMap = friendCustomMapper.selectEmpByEmpId(empId);
				list.add(selectMap);
			}
		} else {
			String flag = (String) map.get("flag");
			if (!"导出".equals(flag)) {
				PageInit.setPage(map);

				if (map.get("sorts") == null || map.get("sorts").equals("")) {
					PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
							Integer.parseInt(map.get("maxResult").toString()));
				} else {
					PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
							Integer.parseInt(map.get("maxResult").toString()), map.get("sorts").toString());
				}
			}
			if (StringUtils.isNotBlank((String)map.get("f_join_start_time"))) {
				map.put("f_join_start_time", ((String)map.get("f_join_start_time")).replace("-", ""));
			}
			if (StringUtils.isNotBlank((String)map.get("f_join_end_time"))) {
				map.put("f_join_end_time", ((String)map.get("f_join_end_time")).replace("-", ""));
			}
			list = groupMemberCustomMapper.friendGroupEmpList(map);
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
			resMap.put("data", pageInfo.getList());
			resMap.put("count", pageInfo.getTotal());
		}
		return resMap;
	}

	@Override
	public Map<String, Object> newFriendGroupEmpList(Map<String, Object> map) throws AppException {
		// 群组成员列表和导出使用同一个实现类
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> selectMap = new HashMap<String, Object>();
		Map<String, Object> resMap = new HashMap<String, Object>();

		String empIds = (String) map.get("emp_ids");
		if (StringUtils.isNotBlank(empIds)) {
			// 导出勾选员工
			String[] empIdArr = empIds.split(";");
			for (String empId : empIdArr) {
				selectMap = friendCustomMapper.selectEmpByEmpId(empId);
				list.add(selectMap);
			}
		} else {
			PageInit.setPage(map);

			if (map.get("sorts") == null || map.get("sorts").equals("")) {
				PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
						Integer.parseInt(map.get("maxResult").toString()));
			} else {
				PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
						Integer.parseInt(map.get("maxResult").toString()), map.get("sorts").toString());
			}
			list = groupMemberCustomMapper.friendGroupEmpList(map);

			PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
			resMap.put("data", pageInfo.getList());
			resMap.put("count", pageInfo.getTotal());
		}
		return resMap;
	}

	/**
	 * 批量删除群组成员
	 * 
	 * @throws AppException
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void groupMemberDelete(Map<String, Object> map) throws Exception {
		// 获取当前登录人
		String empId = (String) map.get("emp_id");
		// 获取群组ID
		String friendGroupId = (String) map.get("friend_group_id");
		String groupMemberIds = map.get("group_members") == null ? null : map.get("group_members").toString();
		if (StringUtils.isBlank(empId)) {
			throw new AppException("获取不到当前登录用户的员工ID!");
		}
		if (StringUtils.isBlank(friendGroupId)) {
			throw new AppException("获取不到群组ID!");
		}
		if (StringUtils.isBlank(groupMemberIds)) {
			throw new AppException("请选择需要移除的群组成员！");
		}
		// 判断当前登录用户是否是该群的群主，如果是有删除群组成员的权限，如果不是不能删除
		String createEmpId = empContactsFriendGroupMapper.selectByPrimaryKey(friendGroupId).getCreateEmpId();
		if (empId != createEmpId && !createEmpId.equals(empId)) {
			throw new AppException("对不起,您不是该群的群主,没有删除群组成员的权限！");
		}

		String[] groupMemberIdArr = groupMemberIds.split(";");
		if (groupMemberIdArr != null && groupMemberIdArr.length > 0) {
			// 遍历 群组成员表
			for (String groupMemberId : groupMemberIdArr) {
				EmpContactsGroupMemberExample example = new EmpContactsGroupMemberExample();
				Criteria criteria = example.createCriteria();
				criteria.andFriendGroupIdEqualTo(friendGroupId);
				criteria.andEmpIdEqualTo(groupMemberId);
				int countByExample = empContactsGroupMembersMapper.countByExample(example);
				if (countByExample == 0) {
					throw new AppException("id为" + groupMemberId + "的成员已移除该群组！");
				}
				empContactsGroupMembersMapper.deleteByExample(example);
				// 解除完群组成员之后,需要更新群组的成员数量
				friendGroupCustomMapper.subtractMemberQuantity(friendGroupId);
			}
		}

	}

	/**
	 * 添加群组成员
	 * 
	 * @throws AppException
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void groupMemberSave(Map<String, Object> map) throws AppException, Exception {
		String empId = (String) map.get("emp_id");
		String friendGroupId = (String) map.get("friend_group_id");
		String groupMembers = (String) map.get("group_members");
		String friendGroupType = (String) map.get("friend_group_type");
		if (StringUtils.isBlank(friendGroupId)) {
			throw new AppException("请选择群组!");
		}

		if (StringUtils.isBlank(friendGroupType)) {
			friendGroupType = "1"; // 默认是普通群组
		}
		// if (friendGroupType == "2" || "2".equals(friendGroupType)) {//
		// 固定群组添加群组成员
		// // 只有管理员才有权限
		// String[] empIdArr = new String[1];
		// empIdArr[0] = empId;
		// Map<String, Object> resMap = new HashMap<String, Object>();
		// resMap.put("empIdArr", empIdArr);
		// List<Map<String, Object>> roleList =
		// sysSecRoleCustomMapper.selectIsNotSysAd(resMap);
		//
		// if (roleList.size() <= 0) {
		// throw new AppException("您没有权限向固定群组添加成员！");
		// }
		//
		// /*
		// * int sysRoleCount = 0; //查询该用户是否有系统管理员的角色 for (SysSecEmp sysSecEmp
		// * : sysSecEmpList) { String sysEmpId = sysSecEmp.getEmpId();
		// * SysSecUserRoleExample userRoleExample = new
		// * SysSecUserRoleExample();
		// * //目前测试数据库中ca07e3c0-6d18-11e7-90f1-0050569b代表的是系统管理员的role_id
		// * userRoleExample.createCriteria().andEmpIdEqualTo(sysEmpId).
		// * andRoleIdEqualTo(); int count =
		// * sysSecUserRoleMapper.countByExample(userRoleExample);
		// * if(count>0){ sysRoleCount++; break; } } if(sysRoleCount==0){
		// * throw new AppException("您没有权限向固定群组添加成员！"); }
		// */
		// }
		if (StringUtils.isBlank(groupMembers)) {
			throw new AppException("请选择群组成员！");
		}
		if (groupMembers.contains("；")) {
			groupMembers = groupMembers.replace('；', ';');
		}
		String[] groupMemberIds = groupMembers.split(";");

		if (groupMemberIds != null && groupMemberIds.length > 0) {
			List<Map<String, Object>> memberList = new ArrayList<Map<String, Object>>();
			for (String groupMemberId : groupMemberIds) {
				// 先查询是否已经添加该成员
				String curDate = DateUtil.getCurrentDateTime();
				EmpContactsGroupMemberExample example = new EmpContactsGroupMemberExample();
				example.createCriteria().andFriendGroupIdEqualTo(friendGroupId).andEmpIdEqualTo(groupMemberId);
				int countByExample = empContactsGroupMembersMapper.countByExample(example);
				if (countByExample <= 0) {// 如果没有添加，则插入群组成员并更新群组数量

					Map<String, Object> memberMap = new HashMap<String, Object>();
					memberMap.put("friend_group_id", friendGroupId);
					memberMap.put("emp_id", groupMemberId);
					memberMap.put("member_level", "3");
					memberMap.put("member_status", "1");
					memberMap.put("create_date_time", curDate);
					memberList.add(memberMap);
				}
			}
			if (memberList.size() > 0) {
				groupMemberCustomMapper.insertMemberList(memberList);
				// 更新群组成员数量
				Map<String, Object> berMap = new HashMap<String, Object>();
				berMap.put("friendGroupId", friendGroupId);
				berMap.put("memberCount", memberList.size());
				friendGroupCustomMapper.addAllMemberQuantity(berMap);
			}

		}
	}

	/**
	 * 添加群组成员页面初始化
	 */
	@Override
	public List<Map<String, Object>> groupMemberSavePage(Map<String, Object> map) throws AppException {
		String friendGroupId = (String) map.get("friend_group_id");
		if (StringUtils.isBlank(friendGroupId)) {
			throw new AppException("获取不到群组ID!");
		}
		if (map.get("status") == null) {
			map.put("status", "1");
		}
		PreConditionHandleUtils.searchConditionHandle(map);
		return groupMemberCustomMapper.groupMemberSavePage(map);

	}

}
