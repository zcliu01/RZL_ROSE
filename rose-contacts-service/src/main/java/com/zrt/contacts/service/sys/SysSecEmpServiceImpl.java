package com.zrt.contacts.service.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.StringUtil;
import com.zrt.commons.AppException;
import com.zrt.commons.utils.PreConditionHandleUtils;
import com.zrt.contacts.mapper.sys.SysSecEmpCustomMapper;
import com.zrt.contacts.service.infor.InforService;
import com.zrt.mybatis.domain.SysSecEmp;
import com.zrt.mybatis.domain.SysSecEmpExample;
import com.zrt.mybatis.domain.SysSecEmpPositionExample;
import com.zrt.mybatis.domain.SysSecEmpExample.Criteria;
import com.zrt.mybatis.mapper.EmpContactsFriendMapper;
import com.zrt.mybatis.mapper.SysSecEmpMapper;
import com.zrt.mybatis.mapper.SysSecEmpPositionMapper;

/**
 * @ClassName:SysSecEmpServiceImpl
 * @Description:
 *               <p>
 *               系统员工 服务实现类
 *               </p>
 * 
 */
@Service
public class SysSecEmpServiceImpl implements SysSecEmpService {

	@Autowired
	private SysSecEmpMapper sysSecEmpMapper;
	@Autowired
	private SysSecEmpCustomMapper sysSecEmpCustomMapper;
	@Autowired
	private EmpContactsFriendMapper empContactsFriendMapper;
	@Autowired
	private InforService inforService;
	@Autowired
	private SysSecEmpPositionMapper sysSecEmpPositionMapper;

	/**
	 * 根据机构id查询员工列表 服务实现类
	 * 
	 * @param orgId
	 * @return int
	 */
	@Override
	public int countEmpByOrgId(String orgId) {

		SysSecEmpPositionExample example = new SysSecEmpPositionExample();
		com.zrt.mybatis.domain.SysSecEmpPositionExample.Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(orgId);
		// criteria.andIsFirstOrgEqualTo("1");//主岗位
		int empCount = sysSecEmpPositionMapper.countByExample(example);
		return empCount;
	}

	/**
	 * 通讯录下 查询 员工列表
	 * 
	 * @param orgId
	 * @return list
	 */
	@Override
	public List<Map<String, Object>> empsList(Map<String, Object> map) {
		// 查询出所有的员工信息
		List<Map<String, Object>> list = sysSecEmpCustomMapper.empsList(map);
		/**
		 * for(Map<String, Object> mp:list){ String
		 * firstPy=(String)mp.get("emp_py"); String empFirstPy="#";
		 * if(!firstPy.isEmpty()){ empFirstPy=firstPy.substring(0,
		 * 1).toUpperCase(); }else{ mp.put("emp_py", "#");//首字母拼音 }
		 * mp.put("emp_first_py", empFirstPy);//首字母拼音 }
		 **/
		/*
		 * String empId = (String)map.get("emp_id"); //遍历每个员工是否与当前登录人是常用联系人的关系
		 * for(int i=0;i<list.size();i++){ Map<String, Object> empMap =
		 * list.get(i); //获取员工ID String friendEmpId =
		 * (String)empMap.get("emp_id");
		 * if(friendEmpId==empId||friendEmpId.equals(empId)){ //自己,不能滑动
		 * empMap.put("show_friend_button","-1"); }else { //查询该员工与自己是否是常用联系人的关系
		 * EmpContactsFriendExample example = new EmpContactsFriendExample();
		 * example.createCriteria().andEmpIdEqualTo(empId).andFriendEmpIdEqualTo
		 * (friendEmpId); int countByExample =
		 * empContactsFriendMapper.countByExample(example);
		 * if(countByExample>0){ //两者是常用联系人的关系,滑动显示 删除常用联系人 按钮
		 * empMap.put("show_friend_button","1"); }else{ //两者不是常用联系人的关系,滑动显示
		 * 添加常用联系人按钮 empMap.put("show_friend_button","0"); } } list.add(empMap);
		 * }
		 */
		return list;
	}

	/**
	 * 通讯录下 按照部门查询所有的员工列表
	 * 
	 * @param mapParam
	 * @return
	 */

	@Override
	public List<Map<String, Object>> empListByOrg(Map<String, Object> map) throws AppException {
		String orgId = (String) map.get("org_id").toString();
		if (StringUtils.isBlank(orgId)) {
			throw new AppException("获取不到部门ID!");
		}
		PreConditionHandleUtils.searchConditionHandle(map);
		if (map.get("status") == null) {
			map.put("status", "1");
		}
		List<Map<String, Object>> list = sysSecEmpCustomMapper.empListByOrg(map);
		/**
		 * for(Map<String, Object> mp:list){ String
		 * firstPy=(String)mp.get("emp_py"); String empFirstPy="#";
		 * if(!firstPy.isEmpty()){ empFirstPy=firstPy.substring(0,
		 * 1).toUpperCase(); }else{ mp.put("emp_py", "#");//首字母拼音 }
		 * mp.put("emp_first_py", empFirstPy);//首字母拼音 }
		 **/
		return list;

	}

	/*
	 * String status = (String)map.get("status"); if
	 * (StringUtils.isNotBlank(orgId)) {
	 * 
	 * if (StringUtils.isNotBlank(orgId)) { Map<String, Object> returnMap = new
	 * HashMap<String, Object>(); SysSecEmpExample example = new
	 * SysSecEmpExample(); Criteria criteria = example.createCriteria();
	 * criteria.andOrgIdEqualTo(orgId); criteria.andIsFirstOrgEqualTo("1");
	 * if(status!=null && !"".equals(status)){
	 * criteria.andEmpActiveEqualTo(status); } List<SysSecEmp> empList =
	 * sysSecEmpMapper.selectByExample(example); returnMap.put("empList",
	 * empList); return returnMap; } return null;
	 * 
	 * }
	 * 
	 * /** 根据员工id 查询直接上级姓名
	 */
	@Override
	public String selectUpEmpName(String empId) {
		if (StringUtils.isNotBlank(empId)) {
			String upEmpName = sysSecEmpCustomMapper.selectUpEmpName(empId);
			return upEmpName;
		}
		return null;
	}

	/**
	 * 通讯录下 根据员工id 查询员工详情
	 */
	@Override
	public Map<String, Object> selectEmpDetails(String empId) {
		Map<String, Object> map = sysSecEmpCustomMapper.selectEmpDetails(empId).get(0);
//		if (StringUtil.isEmpty((String)map.get("upEmpId"))) {
//			map.put("up_emp_id", "");
//			map.put("upEmpName", "");
//			return map;
//		}
		String upEmpName = sysSecEmpCustomMapper.selectUpEmpName((String)map.get("upEmpId"));
		map.put("up_emp_id", map.get("upEmpId"));
		map.put("upEmpName", upEmpName);
		return map;

	}

	/**
	 * 根据员工ID 获取个人履历
	 */
	@Override
	public List<Map<String, Object>> selectEmpWorkRedeploy(String empId) {
		if (StringUtils.isNotBlank(empId)) {
			return sysSecEmpCustomMapper.selectEmpWorkRedeploy(empId);
		}
		return null;
	}

	/**
	 * 根据员工ID 获取职位讯息
	 */
	@Override
	public List<Map<String, Object>> selectEmpPositionDetails(String empId, String isFirstOrg) {
		if (StringUtils.isNotBlank(empId)) {

			SysSecEmp sysSecEmp = sysSecEmpMapper.selectByPrimaryKey(empId);
			String userId = sysSecEmp.getEmpId();
			return sysSecEmpCustomMapper.selectEmpPositionDetails(userId, isFirstOrg);
		}
		return null;
	}

	/**
	 * PC端根据员工id 查询个人详情(基本信息+职位信息+履历信息)
	 */
	@Override
	public List<Map<String, Object>> selectEmpData(Map<String, Object> map) throws AppException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String friendEmpId = (String) map.get("friend_emp_id");
		if (StringUtils.isBlank(friendEmpId)) {
			throw new AppException("获取不到有效的员工ID!");
		}
		// 查询员工基本信息
		List<Map<String, Object>> baseMessageMapList = sysSecEmpCustomMapper.selectEmpDetails(friendEmpId);
		Map<String, Object> baseMessageMap = baseMessageMapList.get(0);
//		baseMessageMap.put("upEmpName", baseMessageMap.get("manage_emp_name"));
//		baseMessageMap.put("upEmpId", baseMessageMap.get("manage_emp_id"));
		String upEmpName = sysSecEmpCustomMapper.selectUpEmpName((String)baseMessageMap.get("upEmpId"));
		baseMessageMap.put("upEmpName", upEmpName);
		map.put("baseMessage", baseMessageMap);

		// 根据员工ID获取用户ID
		String userId = friendEmpId;
		// 查询员工职位信息
		
		List<Map<String, Object>> positionMessageList = null ;
		String users = "000001;000978;000012;008808;003131;008088;002354;000015;000008;001104;008886;004965;001570;000955;000587;009988;003228";
		if (users.contains(userId)) {
			positionMessageList = sysSecEmpCustomMapper.selectEmpPositionDetailsTemp(userId, "");
		}else{
			positionMessageList = sysSecEmpCustomMapper.selectEmpPositionDetails(userId, "");// 查询所有部门，主部门和次部门
		}
		map.put("positionMessage", positionMessageList);
		// 查询履历信息
		List<Map<String, Object>> workMessageList = sysSecEmpCustomMapper.selectEmpWorkRedeploy(friendEmpId);
		map.put("workMessage", workMessageList);
		list.add(map);
		return list;
	}

	/**
	 * App端查询直接上级员工详情
	 */
	@Override
	public Map<String, Object> selectUpEmpDetails(String friendEmpId) {
		Map<String, Object> upEmpMap = sysSecEmpCustomMapper.selectUpEmpDetails(friendEmpId);
		return upEmpMap;
	}

	/**
	 * 修改个人信息
	 */
	@Override
	public void updateEmpDetails(Map<String, Object> map) throws AppException {

		String type = (String) map.get("type");
		SysSecEmp sysSecEmp = sysSecEmpMapper.selectByPrimaryKey((String) map.get("emp_id"));

		Map inforMap = new HashMap<>();
		String content = "";
		inforMap.put("title", "个人资料修改");
		inforMap.put("sender_id", (String) map.get("emp_id"));
		// inforMap.put("receiver_ids","2f960f88-4388-11e7-b66c-3c970e5c");
		inforMap.put("category", "innerInfor");
		inforMap.put("bus_type", "1");
		if (type == "1" || "1".equals(type)) {// 修改固定电话
			String empPhone = (String) map.get("emp_phone");
			content = "工号为" + sysSecEmp.getEmpCode() + "的" + sysSecEmp.getEmpName() + "修改 固定电话为" + empPhone;
			inforMap.put("content", content);
			inforService.sendUpdateInfor(inforMap);
		} else if (type == "2" || "2".equals(type)) {// 修改手机号码
			String empMobilePhone = (String) map.get("emp_mobile_phone");
			content = "工号为" + sysSecEmp.getEmpCode() + "的" + sysSecEmp.getEmpName() + "修改 手机号码为" + empMobilePhone;
			inforMap.put("content", content);
			inforService.sendUpdateInfor(inforMap);

		} else if (type == "3" || "3".equals(type)) {// 修改联系地址
			String empAddress = (String) map.get("emp_address");
			content = "工号为" + sysSecEmp.getEmpCode() + "的" + sysSecEmp.getEmpName() + "修改 联系地址为" + empAddress;
			inforMap.put("content", content);
			inforService.sendUpdateInfor(inforMap);

		} else if (type == "4" || "4".equals(type)) {// 修改工作地址
			String empWorkAddress = (String) map.get("emp_work_address");
			content = "工号为" + sysSecEmp.getEmpCode() + "的" + sysSecEmp.getEmpName() + "修改 工作地址为" + empWorkAddress;
			inforMap.put("content", content);
			inforService.sendUpdateInfor(inforMap);
		}

	}

	/**
	 * 通讯录下 查询 所有员工id
	 * 
	 * @param orgId
	 * @return list
	 */
	@Override
	public List<Map<String, Object>> searchAll(Map<String, Object> map) {
		// 查询出所有的员工信息
		List<Map<String, Object>> list = sysSecEmpCustomMapper.searchAll();

		return list;
	}

}
