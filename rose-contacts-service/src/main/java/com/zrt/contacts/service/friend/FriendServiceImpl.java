package com.zrt.contacts.service.friend;

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
import com.github.pagehelper.StringUtil;
import com.zrt.commons.AppException;
import com.zrt.commons.PageInit;
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.commons.utils.PreConditionHandleUtils;
import com.zrt.contacts.mapper.friend.FriendCustomMapper;
import com.zrt.contacts.mapper.sys.SysSecOrgCustomMapper;
import com.zrt.contacts.service.serial.SerialService;
import com.zrt.mybatis.domain.EmpContactsFriend;
import com.zrt.mybatis.domain.EmpContactsFriendExample;
import com.zrt.mybatis.domain.EmpContactsFriendExample.Criteria;
import com.zrt.mybatis.domain.SysSecEmp;
import com.zrt.mybatis.domain.SysSecEmpPosition;
import com.zrt.mybatis.domain.SysSecEmpPositionExample;
import com.zrt.mybatis.domain.SysSecOrg;
import com.zrt.mybatis.domain.SysSecOrgExample;
import com.zrt.mybatis.mapper.EmpContactsFriendMapper;
import com.zrt.mybatis.mapper.SysSecEmpMapper;
import com.zrt.mybatis.mapper.SysSecEmpPositionMapper;
import com.zrt.mybatis.mapper.SysSecOrgMapper;

/**
 * Created by msKui on 2017/3/3.
 */
@Service
public class FriendServiceImpl implements FriendService {
	@Autowired
	private EmpContactsFriendMapper sysContactsFriendMapper;
	@Autowired
	private SysSecEmpMapper sysSecEmpMapper;
	@Autowired
	private SysSecOrgMapper sysSecOrgMapper;
	@Autowired
	private FriendCustomMapper friendCustomMapper;
	@Autowired
	private SerialService serialService;
	@Autowired
	private SysSecEmpPositionMapper sysSecEmpPositionMapper;
	@Autowired
	private SysSecOrgCustomMapper sysSecOrgCustomMapper;

	@Override
	public Integer friendSave(EmpContactsFriend contactsFriend) {
		Integer i = sysContactsFriendMapper.insert(contactsFriend);
		return i;
	}

	@Override
	public Integer friendSave(List<EmpContactsFriend> listContactsFriend) {
		Integer i = friendCustomMapper.insertMore(listContactsFriend);
		return i;
	}

	@Override
	public Map<String, Object> friendSearch(String empId) {
		if (StringUtils.isBlank(empId))
			return null;

		Map<String, Object> map = friendCustomMapper.selectEmpDetail(empId);

		return map;
	}

	@Override
	public List<Map<String, Object>> empSearch(String userId, String isFirstOrg) {
		List<Map<String, Object>> list = friendCustomMapper.selectEmpOrgPosition(userId, isFirstOrg);
		return list;
	}

	@Override
	public Integer friendDelete(EmpContactsFriend contactsFriend) {
		if (contactsFriend == null || StringUtils.isBlank(contactsFriend.getEmpId())
				|| StringUtils.isBlank(contactsFriend.getFriendEmpId()))
			return null;

		EmpContactsFriendExample example = new EmpContactsFriendExample();
		addWhere(example, contactsFriend);

		return sysContactsFriendMapper.deleteByExample(example);
	}

	@Override
	public Integer friendDelete(String empId, String[] friendEmpIdArr) {
		Integer i = friendCustomMapper.friendDeleteIn(empId, friendEmpIdArr);
		return i;
	}

	@Override
	public List<Map<String, Object>> empList(Map<String, Object> map) throws AppException {
		// 常用联系人列表和导出使用同一个实现类
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
			// 查询当前登录用户的user_id
			SysSecEmp secEmp = sysSecEmpMapper.selectByPrimaryKey((String) map.get("emp_id"));
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
			list = friendCustomMapper.empList(map);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> ypEmpList(Map<String, Object> map) throws AppException {
		List<Map<String, Object>> list = friendCustomMapper.ypEmpList(map);
		if (list != null && list.size() > 0) {
			for (Map<String, Object> dataMap : list) {
				dataMap.put("password", "123456");
			}
		}

		return list;
	}

	@Override
	public List<Map<String, Object>> orgEmpList(Map<String, Object> map) throws AppException {
		// 组织通讯录列表和导出使用同一个实现类
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

			String orgId = (String) map.get("org_id");
			String orgName = (String) map.get("org_name");
			if (StringUtil.isNotEmpty(orgName)&&!"中融国际信托有限公司".equals(orgName)) {
				if("000100010001".equals(orgId)||"高管".equals(orgName)){
					map.put("parent_org_id", "000100010001");
					map.put("org_id", "");
					map.put("is_first_org", "1");
				}
				list = friendCustomMapper.orgEmpListByOrgName(map);
			}else {
				if ("中融国际信托有限公司".equals(orgName)) {
					map.put("org_name", "");
				}
				if ("00010001".equals(orgId)) {
					map.put("org_id", "");
				}
				list = friendCustomMapper.orgEmpList(map);
			}
		}

		return list;
	}

	/**
	 * 导出
	 * 
	 * @throws AppException
	 */
	@Override
	public List<Map<String, Object>> exportEmpToExcel(Map<String, Object> map) throws AppException {

		// String[] strArr = map.get("emp_id").toString().split(",");
		List<String> empIdList = (List<String>) map.get("emp_ids");// 获取导出的员工ID
		if (empIdList == null || empIdList.size() <= 0)
			throw new AppException("请选择需要导出的员工");
		List<Map<String, Object>> list = friendCustomMapper.exportEmpToExcel(empIdList);
		return list;
	}

	@Override
	public List<Map<String, Object>> getWorkRedeploy(String empId) {
		List<Map<String, Object>> list = friendCustomMapper.getWorkRedeploy(empId);
		return list;
	}

	public void addWhere(EmpContactsFriendExample example, EmpContactsFriend contactsFriend) {
		EmpContactsFriendExample.Criteria criteria = example.createCriteria();

		if (null == contactsFriend)
			return;

		if (StringUtils.isNotBlank(contactsFriend.getFriendId()))
			criteria.andFriendIdEqualTo(contactsFriend.getFriendId());

		if (StringUtils.isNotBlank(contactsFriend.getEmpId()))
			criteria.andEmpIdEqualTo(contactsFriend.getEmpId());

		if (StringUtils.isNotBlank(contactsFriend.getFriendEmpId()))
			criteria.andFriendEmpIdEqualTo(contactsFriend.getFriendEmpId());

		if (StringUtils.isNotBlank(contactsFriend.getEmpStatus()))
			criteria.andEmpStatusEqualTo(contactsFriend.getEmpStatus());

	}

	/**
	 * 获取组织机构列表
	 * 
	 */
	@Override
	public List<Map<String, Object>> orgAllList(Map<String, Object> appMap) throws Exception {
		SysSecOrgExample example = new SysSecOrgExample();
		com.zrt.mybatis.domain.SysSecOrgExample.Criteria criteria = example.createCriteria();
		criteria.andSecEnabledEqualTo("1");// 状态为1的
		criteria.andGroupTypeEqualTo("1");// 正常组织机构
		List<Map<String, Object>> orgList = sysSecOrgCustomMapper.orgNewList();
		List<Map<String, Object>> resList = new ArrayList<>();
		for (Map<String, Object> orgMap : orgList) {
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("org_id", orgMap.get("org_id"));
			resMap.put("org_name", orgMap.get("org_name"));
			resMap.put("parent_org_id", orgMap.get("parent_org_id"));
			resList.add(resMap);
		}
		return resList;
	}

	/**
	 * 根据员工的id 查询 常用联系人 的数目
	 */
	@Override
	public Integer contactsCount(String empId, String status) {

		return friendCustomMapper.contactsCount(empId, status);

	}

	/**
	 * APP端常用联系人列表 实现类
	 */
	@Override
	public List<Map<String, Object>> friendList(Map<String, Object> map) throws AppException {
		if (map.get("status") == null) {
			map.put("status", "1"); // 默认查询在职员工
		}
		PreConditionHandleUtils.searchConditionHandle(map);
		return friendCustomMapper.friendList(map);
	}

	/**
	 * 添加常用联系人之前,判断是否已存在,若已添加,提示已添加消息;若不存在,则添加
	 */
	@Override
	public Integer selectFriendIsExists(String empId, String friendEmpId) {
		EmpContactsFriendExample example = new EmpContactsFriendExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpIdEqualTo(empId);
		criteria.andFriendEmpIdEqualTo(friendEmpId);
		return sysContactsFriendMapper.countByExample(example);
	}

	/**
	 * APP端判断两人是否是常用联系人的关系
	 */
	@Override
	public int selectIsNotFriend(String empId, String userEmpId) {
		EmpContactsFriendExample example = new EmpContactsFriendExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpIdEqualTo(userEmpId);
		criteria.andFriendEmpIdEqualTo(empId);

		return sysContactsFriendMapper.countByExample(example);
	}

	/**
	 * 根据员工ID查询员工姓名、部门ID、部门名称---目前用于讯息方面
	 */
	@Override
	public List<Map<String, Object>> getEmpName(Map<String, Object> map) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<String> empIds = (List<String>) map.get("emp_ids");// 请求参数为员工ID的list集合
		for (String empId : empIds) {
			List<Map<String, Object>> empList = new ArrayList<Map<String, Object>>();
			Map<String, Object> empMap = new HashMap<String, Object>();

			SysSecEmpPositionExample example = new SysSecEmpPositionExample();
			com.zrt.mybatis.domain.SysSecEmpPositionExample.Criteria criteria = example.createCriteria();
			criteria.andEmpIdEqualTo(empId);
			criteria.andIsFirstOrgEqualTo("1");// 主岗位
			List<SysSecEmpPosition> empPositionList = sysSecEmpPositionMapper.selectByExample(example);
			SysSecEmpPosition sysSecEmpPosition = empPositionList.get(0);
			SysSecEmp sysSecEmp = sysSecEmpMapper.selectByPrimaryKey(empId);
			empMap.put("emp_name", sysSecEmp.getEmpName());
			String orgId = sysSecEmpPosition.getOrgId();// 获取部门ID
			empMap.put("org_id", orgId);
			// SysSecOrg sysSecOrg = sysSecOrgMapper.selectByPrimaryKey(orgId);
			// empMap.put("org_name", sysSecOrg.getOrgName());
			empMap.put("org_name", sysSecEmpPosition.getOrgName());
			empList.add(empMap);
			map.put(empId, empList);

		}
		list.add(map);
		return list;

	}

	/**
	 * App端 添加常用联系人初始化页面
	 * 
	 * @return
	 */
	@Override
	public List<Map<String, Object>> friendSavePage(Map<String, Object> map) throws AppException {

		String empId = map.get("emp_id") == null ? null : map.get("emp_id").toString();// 获取登录人的员工ID
		if (map.get("status") == null) {
			map.put("status", "1");// 默认查询在职员工
		}
		PreConditionHandleUtils.searchConditionHandle(map);
		List<Map<String, Object>> list = friendCustomMapper.friendSavePage(map);
		return list;

	}

	/**
	 * PC端批量添加常用联系人
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Integer friendSave(Map<String, Object> map) throws AppException {
		String empId = (String) map.get("emp_id");
		String friendIds = (String) map.get("friend_emp_id");
		if (StringUtils.isBlank(friendIds)) {
			throw new AppException("请选择常用联系人!");
		}
		// 获取登录用户的user_id
		SysSecEmp loginEmp = sysSecEmpMapper.selectByPrimaryKey(empId);
		String loginEmpId = loginEmp.getEmpId();

		if (friendIds.contains("；")) {
			friendIds = friendIds.replace('；', ';');
		}

		String[] friendIdArr = friendIds.split(";");

		// 初始化添加成功的常用联系人数目
		Integer successCount = 0;
		if (friendIdArr != null && friendIdArr.length > 0) {

			for (String friendId : friendIdArr) {
				// 查找对应的user_id
				SysSecEmp friendEmp = sysSecEmpMapper.selectByPrimaryKey(friendId);
				String friendUserId = friendEmp.getEmpId();
				if (friendUserId != loginEmpId && !loginEmpId.equals(friendUserId)) {

					// 判断两人是否已经是常用联系人的关系
					EmpContactsFriendExample friendExample = new EmpContactsFriendExample();
					friendExample.createCriteria().andEmpIdEqualTo(empId).andFriendEmpIdEqualTo(friendId);
					int countByExample = sysContactsFriendMapper.countByExample(friendExample);
					if (countByExample <= 0) {
						EmpContactsFriend contactsFriend = new EmpContactsFriend();
						// contactsFriend.setFriendId(UUIDUtils.getUUID());
						contactsFriend.setFriendId(serialService.getUUID());
						contactsFriend.setEmpId(empId);
						contactsFriend.setFriendEmpId(friendId);
						contactsFriend.setEmpStatus("1");
						contactsFriend.setCreateDateTime(DateUtil.getCurrentDateTime());
						sysContactsFriendMapper.insertSelective(contactsFriend);
						successCount++;
					}
				}

			}
		}
		return successCount;
	}

	/**
	 * 批量删除常用联系人
	 */
	@Override
	public void friendDelete(Map<String, Object> map) throws AppException {
		String empId = (String) map.get("emp_id");// 当前登录用户的员工ID
		String friendEmpIds = (String) map.get("friend_emp_id");// 获取以分号分隔的员工ID字符串

		if (StringUtils.isBlank(friendEmpIds)) {
			throw new AppException("请选择联系人!");
		}
		if (friendEmpIds.contains("；")) {
			friendEmpIds = friendEmpIds.replace('；', ';');
		}
		String[] friendEmpIdArr = friendEmpIds.split(";");
		if (friendEmpIdArr != null && friendEmpIdArr.length > 0) {
			for (String friendEmpId : friendEmpIdArr) {
				if (empId == friendEmpId || empId.equals(friendEmpId)) {
					throw new AppException("选择的联系人不能是自己！");
				}
				// 先查询两人是否是常用联系人的关系
				EmpContactsFriendExample friendExample = new EmpContactsFriendExample();
				friendExample.createCriteria().andEmpIdEqualTo(empId).andFriendEmpIdEqualTo(friendEmpId);
				int countByExample = sysContactsFriendMapper.countByExample(friendExample);
				if (countByExample <= 0) {
					throw new AppException("您与ID为" + friendEmpId + "已经解除常用联系人关系！");
				} else {
					sysContactsFriendMapper.deleteByExample(friendExample);
				}
			}

		}

	}

}
