package com.zrt.contacts.service.empsearchwindow;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrt.client.sec.ISecClient;
import com.zrt.commons.AppException;
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.utils.PreConditionHandleUtils;
import com.zrt.contacts.mapper.empsearchwindow.EmpSearchWindowCustomMapper;
import com.zrt.contacts.mapper.sys.SysSecEmpCustomMapper;
import com.zrt.contacts.mapper.sys.SysSecOrgCustomMapper;
import com.zrt.contacts.service.friendgroup.FriendGroupService;
import com.zrt.mybatis.domain.SysSecEmpExample;
import com.zrt.mybatis.domain.SysSecEmpPositionExample;
import com.zrt.mybatis.mapper.SysSecEmpMapper;
import com.zrt.mybatis.mapper.SysSecEmpPositionMapper;

/**
 * Created by msKui on 2017/3/8.
 */
@Service
public class EmpSearchWindowServiceImpl implements EmpSearchWindowService {
	@Autowired
	private EmpSearchWindowCustomMapper empSearchWindowCustomMapper;

	@Autowired
	private SysSecOrgCustomMapper sysSecOrgCustomMapper;

	@Autowired
	private SysSecEmpCustomMapper sysSecEmpCustomMapper;

	@Autowired
	private SysSecEmpMapper sysSecEmpMapper;

	@Autowired
	FriendGroupService friendGroupService;
	@Autowired
	private SysSecEmpPositionMapper sysSecEmpPositionMapper;

	@Resource(name = "HystrixSecClient")
	private ISecClient secClient;

	@Override
	public List<Map<String, Object>> treeRoute(Map<String, Object> map) throws Exception {
		String rootId = map.get("root_id").toString();

		if (StringUtils.isBlank(rootId))
			return null;

		List<Map<String, Object>> list = new ArrayList<>();

		if (rootId.equals("2")) {// 公司组织机构
			Map<String, Object> orgMap = secClient.orgAllList(map);
			Boolean result = (Boolean) orgMap.get("result");
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			if (result) {
				list = (List<Map<String, Object>>) orgMap.get("data");

			} else {
				throw new Exception("查询机构失败!");
			}
		} else if (rootId.equals("3")) {// 我的群组
			list = friendGroupTree(map);
		}

		return list;
	}

	/**
	 * 组织机构树。
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	public List<Map<String, Object>> orgTree(Map<String, Object> map) throws Exception {
		Map<String, Object> orgMap = secClient.orgAllList(map);
		Boolean result = (Boolean) orgMap.get("result");
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		if (result) {
			mapList = (List<Map<String, Object>>) orgMap.get("data");

		} else {
			throw new Exception("查询机构失败!");
		}

		return mapList;
	}

	/**
	 * 我的群组，树。
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	public List<Map<String, Object>> friendGroupTree(Map<String, Object> map) {
		Map<String, Object> map2 = new HashMap<>();
		map2.put("create_emp_id", map.get("register"));
		map2.put("friend_group_type", "2");// 包括所有人都能看到的群组。

		List<Map<String, Object>> list = friendGroupService.selectFriendGroupTree(map2);

		List<Map<String, Object>> listMap = getListMapForFriendGroup(list);

		return listMap;
	}

	public List<Map<String, Object>> getListMapForFriendGroup(List<Map<String, Object>> list) {
		List<Map<String, Object>> listMap = new ArrayList<>();
		Map<String, Object> map;
		for (Map<String, Object> m : list) {
			map = new HashMap<>();
			map.put("id", m.get("friend_group_id"));
			map.put("name", m.get("friend_group_name"));
			listMap.add(map);
		}

		return listMap;
	}

	/**
	 * 联系人树形,包括 常用联系人、组织机构、我的群组、待撤销部门
	 */
	@Override
	public List<Map<String, Object>> treeEmpRoute(Map<String, Object> map) throws AppException {

		String empId = map.get("emp_id").toString();// 获取当前登录用户的员工id
		/*
		 * PreConditionHandleUtils.searchConditionHandle(map); String search =
		 * map.get("search").toString();
		 */
		String orginalsearch = map.get("search") == null ? null : map.get("search").toString();// 搜索条件
		// String rootId = map.get("root_id")==null?null:
		// map.get("root_id").toString();//获取树形节点

		// 如果有多个搜索条件，将其分割以字符串数组格式存入map
		if (StringUtils.isNotBlank(orginalsearch)) {
			PreConditionHandleUtils.searchConditionHandle(map);
			String search = map.get("search").toString();
			if (search.contains(",")) {
				map.put("searchArr", search.split(","));
			} else if (search.contains("，")) {
				map.put("searchArr", search.contains("，"));
			} else if (search.contains(";")) {
				map.put("searchArr", search.contains(";"));
			} else if (search.contains("；")) {
				map.put("searchArr", search.contains("；"));
			}
		}

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// 常用联系人
		List<Map<String, Object>> friendEmpList = friendEmpTree(map);
		Map<String, Object> friendEmpMap = new HashMap<String, Object>();
		friendEmpMap.put("id", "1");
		friendEmpMap.put("parent_id", "-1");
		friendEmpMap.put("show_name", "常用联系人");
		friendEmpMap.put("org_id", "");
		friendEmpMap.put("org_name", "");
		friendEmpMap.put("emp_id", "");
		friendEmpMap.put("emp_name", "");
		friendEmpMap.put("emp_code", "");
		friendEmpList.add(friendEmpMap);
		map.put("friend", friendEmpList);

		// 组织结构所有部门及员工
		List<Map<String, Object>> orgEmpList = orgEmpTree(map);

		map.put("org_list", orgEmpList);

		// 我的群组
		List<Map<String, Object>> friendGroupEmpList = friendGroupEmpTree(map);
		Map<String, Object> friendGroupEmpMap = new HashMap<String, Object>();
		friendGroupEmpMap.put("id", "3");
		friendGroupEmpMap.put("parent_id", "-1");
		friendGroupEmpMap.put("show_name", "我的群组");
		friendGroupEmpMap.put("org_id", "");
		friendGroupEmpMap.put("org_name", "");
		friendGroupEmpMap.put("emp_id", "");
		friendGroupEmpMap.put("emp_name", "");
		friendGroupEmpMap.put("emp_code", "");
		friendGroupEmpList.add(friendGroupEmpMap);
		map.put("my_friend_group", friendGroupEmpList);

		/*
		 * //待撤销部门 List<Map<String,Object>> preCancelOrgEmpList =
		 * preCancelOrgEmpTree(map); Map<String,Object> preCancelOrgEmpMap = new
		 * HashMap<String,Object>(); preCancelOrgEmpMap.put("id", "4");
		 * preCancelOrgEmpMap.put("parent_id", "-1");
		 * preCancelOrgEmpMap.put("show_name", "待撤销部门");
		 * preCancelOrgEmpMap.put("org_id", "");
		 * preCancelOrgEmpMap.put("org_name", "");
		 * preCancelOrgEmpMap.put("emp_id", "");
		 * preCancelOrgEmpMap.put("emp_name", "");
		 * preCancelOrgEmpMap.put("emp_code","");
		 * preCancelOrgEmpList.add(preCancelOrgEmpMap);
		 * map.put("pre_cancel_org_list", preCancelOrgEmpList);
		 */

		list.add(map);
		return list;
	}

	public List<Map<String, Object>> getRecentlyCmuct(Map<String, Object> mapParam) {
		List<Map<String, Object>> list = empSearchWindowCustomMapper.getRecentlyCmuct(mapParam);
		return list;
	}

	@Override
	public List<Map<String, Object>> friendEmpTree(Map<String, Object> mapParam) {
		List<Map<String, Object>> list = empSearchWindowCustomMapper.friendEmpTree(mapParam);
		return list;
	}

	/**
	 * 我的群组成员，树。
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	public List<Map<String, Object>> friendGroupEmpTree(Map<String, Object> map) {
		List<Map<String, Object>> list = empSearchWindowCustomMapper.friendGroupEmpTree(map);

		return list;
	}

	/**
	 * 组织机构成员，树。
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	public List<Map<String, Object>> orgEmpTree(Map<String, Object> map) {
		List<Map<String, Object>> mapList = empSearchWindowCustomMapper.orgEmpTree(map);
		return mapList;
	}

	/**
	 * 待撤销部门机构成员，树。
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	public List<Map<String, Object>> preCancelOrgEmpTree(Map<String, Object> map) {
		List<Map<String, Object>> mapList = empSearchWindowCustomMapper.preCancelOrgEmpTree(map);
		return mapList;
	}

	/**
	 * 通用的联系人搜索功能
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@Override
	public List<Map<String, Object>> commonEmpSearch(Map<String, Object> map) throws AppException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		// 如果有多个搜索条件，将其分割以字符串数组格式存入map
		PreConditionHandleUtils.searchConditionHandle(map);
		String orginalsearch = (String) map.get("search");// 原始search
		if (map.get("type") == null) {
			map.put("type", "0");// 默认模糊查询
		}
		String type = (String) map.get("type");
		String[] searchArr = orginalsearch.split(";");
		// 模糊查询
		// if (StringUtils.isNotBlank(orginalsearch)) {
		if ("0".equals(type)) {
			map.put("searchArr", searchArr);
			list = empSearchWindowCustomMapper.EmpLikeSearch(map);

		} else if ("1".equals(type)) {
			for (String search : searchArr) {
				map.put("singleSearch", search);
				returnMap = empSearchWindowCustomMapper.EmpTrueSearch(map);
				if (returnMap == null) {
					returnMap = new HashMap<String, Object>();
					returnMap.put("emp_code", "");
					returnMap.put("emp_head_photo", "");
					returnMap.put("org_id", "");
					returnMap.put("emp_name", "");
					returnMap.put("org_name", "");
					returnMap.put("emp_sl", "");
					returnMap.put("emp_py", "");
					returnMap.put("emp_active", "");
					returnMap.put("emp_id", "");
				}
				returnMap.put("singleSearch", search);
				list.add(returnMap);
			}
		}
		// }

		return list;
	}

	/**
	 * 讯息收件人按职级排序
	 */
	@Override
	public List<Map<String, Object>> infoReceiverOrderByRank(Map<String, Object> map) throws AppException {
		String empIds = (String) map.get("emp_ids");
		String[] searchArr = empIds.split(";");
		map.put("searchArr", searchArr);
		return empSearchWindowCustomMapper.infoReceiverOrderByRank(map);

	}

	/**
	 * IM组织通讯录同步
	 */
	@Override
	public Map<String, Object> contactsImList(Map<String, Object> map) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();
		// "synctime": "",同步时间yyyy-MM-dd HH:mm:ss，当前时间
		resMap.put("synctime", (String) DateUtil.getDateTimeFormat(new Date()));
		// “totalStaff”：“”员工数量
		SysSecEmpExample sysSecEmpExample = new SysSecEmpExample();
		int totalStaff = sysSecEmpMapper.countByExample(sysSecEmpExample);
		resMap.put("totalStaff", totalStaff);
		// “isZip”:0,0/1压缩/不压缩；默认不压缩
		resMap.put("isZip", "0");
		// “personZipLength”:0,人员信息压缩字符串长度
		resMap.put("personZipLength", "0");
		// “dept”:部门信息
		/*
		 * "did": 259,部门id "dnm": "PBSA",部门全称 "dshortName": "PBSJ",部门简称 "dpid":
		 * “”,父部门id "order": 0,部门排序 "orderField": "",部门排序字段 "deptNum":
		 * 0,当前部门下的人数（不包括子部门）
		 */

		List<Map<String, Object>> deptList = sysSecOrgCustomMapper.selectDeptList();
		if (deptList != null && deptList.size() > 0) {
			for (Map<String, Object> deptMap : deptList) {
				String orgId = (String) deptMap.get("did");
				SysSecEmpPositionExample example = new SysSecEmpPositionExample();
				com.zrt.mybatis.domain.SysSecEmpPositionExample.Criteria criteria = example.createCriteria();
				criteria.andOrgIdEqualTo(orgId);
				// criteria.andIsFirstOrgEqualTo("1");//主岗位
				int deptEmpCount = sysSecEmpPositionMapper.countByExample(example);
				deptMap.put("deptNum", deptEmpCount);
			}
		}
		resMap.put("dept", deptList);
		// “deptZip”:””,部门信息，压缩的字符串，isZip为1时，返回压缩的字符串，压缩内容为dept后的数组；
		resMap.put("deptZip", "");
		/*
		 * “person”:”[{ "uid": 25,用户id "unm": "刘少卿",员工姓名 "sex": 0,员工性别;0,男，1，女
		 * "fnm": "lsq",名字首字母 "py": "LiuShaoQing",姓名全拼音 "up": "PBS研发",用户职位
		 * "udid": "259",用户所在部门id "udpid": "",用户所在部门的父部门id "mtel":
		 * "13011839719",员工手机号 "tel": "010-88881234",员工座机电话 "mail":
		 * "imtest2@hfbank.com.cn",员工邮箱 "qq": "",员工qq "url":
		 * "http://impre.egf-bank.com.cn:7772/common/client/download?filePath=%2Fpbs_zky_file%2FPhoto%2Frxhf10026.png"
		 * ,头像地址 "sign": "个性签名",个性签名 "md5":
		 * "f56e8e1a7f7d0afbfa879311e95af653",头像文件MD5值，客户端根据此值判断是否更新头像 "voip":
		 * "80060900000137",voip号码 "isl": 0,是否领导0，否；1，是（暂未使用） "orderField":
		 * 2,员工排序字段 "oltype": 0,员工在线状态（暂未使用）类型 1：在线 2：离线 "olsubtype":
		 * 0,员工在线子类型（暂未使用）离线子类型 1: 请勿打扰 2：离开 3：忙碌 4：隐身 "olnetwork":
		 * 0,员工在线网络（暂未使用）1: WIFI 2: 4G 3: 3G 4: 2G(EDGE) 5: INTERNET 6: other
		 * "type": 1,增量获取通讯录时使用，标识该条数据的操作,0/1/2 增加/更新/删除 "isloc":
		 * 1,是否本地（手机号码归属地）0，否；1，是 "remark": "备注",备注 "account": "rxhf10026",统一账号
		 * "oaAccount": "liusq",登陆用户名(自定义账号) "userLevel": "1",用户级别 "userStatus":
		 * "4"账号状态用户状态,0:重置密码，1:正常，2:账号锁定，3:离职（暂未使用），4:账号冻结
		 */
		List<Map<String, Object>> empList = sysSecEmpCustomMapper.selectEmpList();
		resMap.put("person", empList);
		// “personZip”:””,人员信息，压缩版字符串
		resMap.put("personZip", "");

		return resMap;
	}

	@Override
	public Map<String, Object> meetEmpInfo(Map<String, Object> map) throws AppException {
		// 获取参会人员列表
		List<String> reqList = (List<String>) map.get("emp_ids");
		String[] recStr = null;
		if (!reqList.isEmpty()) {
			recStr = new String[reqList.size()];
			for (int i = 0; i < reqList.size(); i++) {
				recStr[i] = reqList.get(i);
			}
		}

		map.put("emp_ids", recStr);
		List<Map<String, Object>> recList = empSearchWindowCustomMapper.meetEmpInfo(map);

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("list", recList);
		return resMap;
	}

	@Override
	public Map<String, Object> empOrgInfo(Map<String, Object> map) throws AppException {

		List<Map<String, Object>> dataList = empSearchWindowCustomMapper.empOrgInfo(map);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", dataList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", dataMap);
		return resMap;
	}

	@Override
	public Map<String, Object> selectByOrg(Map<String, Object> map) throws AppException {

		List<Map<String, Object>> dataList = empSearchWindowCustomMapper.selectByOrg(map);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("list", dataList);
		return resMap;
	}
}
