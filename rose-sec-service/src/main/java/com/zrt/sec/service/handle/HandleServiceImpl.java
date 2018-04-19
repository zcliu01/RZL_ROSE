package com.zrt.sec.service.handle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.commons.AppException;
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.utils.ChineseToHanYuPYUtils;
import com.zrt.commons.utils.FirstLetterUtils;
import com.zrt.commons.utils.PreConditionHandleUtils;
import com.zrt.commons.utils.SubStr;
import com.zrt.mybatis.domain.SysPlatPosition;
import com.zrt.mybatis.domain.SysSecEmp;
import com.zrt.mybatis.domain.SysSecEmpPosition;
import com.zrt.mybatis.domain.SysSecOrg;
import com.zrt.mybatis.domain.SysSecOrgCheck;
import com.zrt.mybatis.mapper.SysPlatPositionMapper;
import com.zrt.mybatis.mapper.SysSecEmpMapper;
import com.zrt.mybatis.mapper.SysSecEmpPositionMapper;
import com.zrt.mybatis.mapper.SysSecOrgCheckMapper;
import com.zrt.mybatis.mapper.SysSecOrgMapper;
import com.zrt.sec.mapper.handle.HandlerMapper;
import com.zrt.sec.service.serial.SerialService;

@Service("handleServiceImpl")
public class HandleServiceImpl implements HandleService {

	@Autowired
	private SerialService serialService;

	@Autowired
	private SysSecEmpMapper sysSecEmpMapper;

	@Autowired
	private HandlerMapper handlerMapper;

	@Autowired
	private SysSecOrgMapper sysSecOrgMapper;

	@Autowired
	private SysPlatPositionMapper sysPlatPositionMapper;

	@Autowired
	private SysSecEmpPositionMapper sysSecEmpPositionMapper;
	@Autowired
	private SysSecOrgCheckMapper sysSecOrgCheckMapper;

	/**
	 * 添加新员工
	 * 
	 * @author tiramisu
	 * @date 2018年3月12日下午1:41:30
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int addUser(Map<String, Object> map) throws Exception {
		String EmpSl = FirstLetterUtils.getFirstLetter((String) map.get("emp_name")).toLowerCase();
		String EmpPy = ChineseToHanYuPYUtils.convertChineseToPinyin((String) map.get("emp_name")).toLowerCase();
		String empId = (String) map.get("emp_code");
		if (StringUtils.isEmpty(empId)) {
			throw new AppException("工号不能为空!!");
		}
		if (StringUtils.isEmpty((String) map.get("emp_name"))) {
			throw new AppException("姓名不能为空!!");
		}
		int count = handlerMapper.searchEmpId(map);
		if (count != 0) {
			throw new AppException("员工工号已存在,请重新输入!!");
		}
		SysSecEmp sysSecEmp = new SysSecEmp();
		sysSecEmp.setEmpId(empId);
		sysSecEmp.setEmpPassword("6qMy2/g+7kU=");
		sysSecEmp.setEmpCode(empId);
		sysSecEmp.setEmpPy(EmpPy);
		sysSecEmp.setEmpSl(EmpSl);
		sysSecEmp.setEmpAccount(empId);
		sysSecEmp.setEmpName((String) map.get("emp_name"));
		sysSecEmp.setEmpHeadPhoto((String) map.get("emp_head_photo"));
		sysSecEmp.setEmpSex((String) map.get("emp_sex"));
		sysSecEmp.setEmpEmail((String) map.get("emp_email"));
		sysSecEmp.setEmpPhone((String) map.get("emp_phone"));
		sysSecEmp.setEmpMobilePhone((String) map.get("emp_mobile_phone"));
		sysSecEmp.setCreateDateTime(((String) map.get("create_date_time")).replace("-", "") + "000000");
		sysSecEmp.setEntryTime(((String) map.get("create_date_time")).replace("-", "") + "000000");
		sysSecEmp.setEmpOrder(Integer.parseInt((String) map.get("emp_order")));
		sysSecEmp.setEmpEnabled("1");
		sysSecEmp.setEmpActive("1");
		sysSecEmp.setEmpPostcode((String) map.get("emp_postcode"));
		sysSecEmp.setEmpWorkAddress((String) map.get("emp_work_address"));
		sysSecEmp.setEmpFax((String) map.get("emp_fax"));
		sysSecEmp.setCanLoginType(0);
		sysSecEmp.setOperFlag("0");
		sysSecEmp.setAliasEmpName((String) map.get("emp_name"));
		sysSecEmp.setSynFlag("1");
		sysSecEmp.setEmpOrderMail(10000);
		sysSecEmpMapper.insert(sysSecEmp);
		String upEmpId = (String) map.get("up_emp_id");
		List<Map<String, Object>> positionList = (List<Map<String, Object>>) map.get("position");
		SysSecEmpPosition sysSecEmpPosition = new SysSecEmpPosition();
		sysSecEmpPosition.setEmpId(empId);
		sysSecEmpPosition.setCreateDateTime(DateUtil.getCurrentDateTime());
		sysSecEmpPosition.setUpEmpId(upEmpId);
		if (null == positionList || positionList.size() < 1) {
			throw new AppException("请选择部门!!");
		} else {
			for (Map<String, Object> temp : positionList) {
				sysSecEmpPosition.setId(serialService.getUUID());
				sysSecEmpPosition.setOrgId((String) temp.get("org_id"));
				sysSecEmpPosition.setOrgName((String) temp.get("org_name"));
				sysSecEmpPosition.setIsFirstOrg((String) temp.get("is_first_org"));
				sysSecEmpPosition.setTeamId((String) temp.get("org_id"));
				sysSecEmpPosition.setEmpPositionId((String) temp.get("p_s_p_id"));
				sysSecEmpPosition.setrId((String) temp.get("r_id"));
				sysSecEmpPositionMapper.insert(sysSecEmpPosition);
			}

		}
		return 1;
	}

	/**
	 * 查询职位
	 * 
	 * @author tiramisu
	 * @date 2018年3月12日下午1:41:56
	 * @return
	 */
	@Override
	public List<Map<String, Object>> searchPosition(Map<String, Object> map) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if (StringUtils.isBlank((String) map.get("type"))) {
			return handlerMapper.commonSearchPositionTree(map);
		}
		String type = (String) map.get("type");
		// 如果有多个搜索条件，将其分割以字符串数组格式存入map
		if ("0".equals(type)) {
			String orginalsearch = (String) map.get("search");// 原始search
			if (orginalsearch != null) {
				String[] searchArr = orginalsearch.split(";");
				map.put("searchArr", searchArr);
			}
			list = handlerMapper.commonSearchPosition(map);
		}
		if ("1".equals(type)) {
			List<Map<String, Object>> searchList = (List<Map<String, Object>>) map.get("search");
			for (Map<String, Object> map2 : searchList) {
				Map<String, Object> searchPosition = handlerMapper.searchPosition(map2);
				list.add(searchPosition);
			}
		}
		return list;
	}

	/**
	 * 新增部门
	 * 
	 * @author tiramisu
	 * @date 2018年3月12日下午1:41:56
	 * @return
	 */
	@Override
	public int addOrg(Map<String, Object> map) throws Exception {
		SysSecOrg sysSecOrg = new SysSecOrg();
		Map<String, Object> max = handlerMapper.searchOrg(map);
		if (null != max) {
			String orgIdMax = (String) max.get("max");
			String a = orgIdMax.substring(orgIdMax.length() - 4, orgIdMax.length());
			String b = orgIdMax.substring(0, orgIdMax.length() - 4);
			String orgId = Integer.parseInt(a) + 1 + "";
			if (orgId.length() == 1) {
				orgId = b + "000" + orgId;
			} else if (orgId.length() == 2) {
				orgId = b + "00" + orgId;
			} else if (orgId.length() == 3) {
				orgId = b + "0" + orgId;
			} else if (orgId.length() == 4) {
				orgId = b + "" + orgId;
			}
			sysSecOrg.setOrgId(orgId);
		} else {
			sysSecOrg.setOrgId((String) map.get("parent_org_id") + "0001");
		}
		sysSecOrg.setParentOrgId((String) map.get("parent_org_id"));
		SysSecOrg parentOrg = sysSecOrgMapper.selectByPrimaryKey((String) map.get("parent_org_id"));
		sysSecOrg.setCreateDateTime(DateUtil.getCurrentDateTime());
		sysSecOrg.setManageEmpId((String) map.get("manage_emp_id"));
		sysSecOrg.setManageEmpName((String) map.get("manage_emp_name"));
		sysSecOrg.setChargeEmpId((String) map.get("charge_emp_id"));
		sysSecOrg.setChargeEmpName((String) map.get("charge_emp_name"));
		sysSecOrg.setRootOrgId("0001");
		sysSecOrg.setOrgDesc((String) map.get("org_desc"));
		sysSecOrg.setOrgName((String) map.get("org_name"));
		sysSecOrg.setOrgCode((String) map.get("org_code"));
		sysSecOrg.setOrgLevel(parentOrg.getOrgLevel() + 1);
		sysSecOrg.setSecEnabled("1");
		String secOrder=(String) map.get("sec_order");
		if(StringUtils.isNotBlank(secOrder)){
			sysSecOrg.setSecOrder(Integer.parseInt(secOrder));
		}
		
		sysSecOrg.setSecReadonlyFlag("0");
		sysSecOrg.setSecDeleteFlag((String) map.get("sec_enabled"));
		sysSecOrg.setVersion(0);
		sysSecOrg.setGroupType("1");
		sysSecOrg.setOrgCodeView(parentOrg.getOrgCodeView() + "!" + (String) map.get("org_code"));
		sysSecOrg.setOrgNameAll(parentOrg.getOrgNameAll() + "_" + sysSecOrg.getOrgName());
		if (sysSecOrg.getOrgLevel() >= 4) {
			sysSecOrg.setOrgNameView(SubStr
					.getStringByGrade(sysSecOrg.getOrgNameAll().substring(3, sysSecOrg.getOrgNameAll().length()), "_"));
			sysSecOrg.setOrgNameOwner(
					SubStr.getString(sysSecOrg.getOrgNameAll().substring(3, sysSecOrg.getOrgNameAll().length()), "_"));
		} else {
			sysSecOrg.setOrgNameView(sysSecOrg.getOrgNameAll().substring(sysSecOrg.getOrgNameAll().lastIndexOf("_") + 1,
					sysSecOrg.getOrgNameAll().length()));
			sysSecOrg.setOrgNameOwner(sysSecOrg.getOrgNameAll()
					.substring(sysSecOrg.getOrgNameAll().lastIndexOf("_") + 1, sysSecOrg.getOrgNameAll().length()));
		}
		sysSecOrgMapper.insert(sysSecOrg);

		String orgId = sysSecOrg.getOrgId();
		List<Map<String, Object>> checkList = (List<Map<String, Object>>) map.get("check_emp_list");
		if (null != checkList && !checkList.isEmpty()) {
			for (Map<String, Object> checkMap : checkList) {
				SysSecOrgCheck secCheck = new SysSecOrgCheck();
				secCheck.setOrgId(orgId);
				secCheck.setCheckOrder((int) checkMap.get("check_order"));
				secCheck.setCheckEmpId((String) checkMap.get("check_emp_id"));
				secCheck.setCheckEmpName((String) checkMap.get("check_emp_name"));
				sysSecOrgCheckMapper.insert(secCheck);
			}
		}

		return 1;
	}

	/**
	 * 新增职位
	 * 
	 * @author tiramisu
	 * @date 2018年3月12日下午1:41:56
	 * @return
	 */
	@Override
	public int addPosition(Map<String, Object> map) throws Exception {
		SysPlatPosition sysPlatPosition = new SysPlatPosition();
		sysPlatPosition.setCreateDateTime(DateUtil.getCurrentDateTime());
		sysPlatPosition.setpSPId(serialService.getUUID());
		sysPlatPosition.setpName((String) map.get("p_name"));
		sysPlatPosition.setpStatus((String) map.get("p_status"));
		sysPlatPosition.setrId((String) map.get("p_status"));
		sysPlatPositionMapper.insert(sysPlatPosition);
		return 1;
	}

	/**
	 * 通用的联系人搜索功能
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@Override
	public List<Map<String, Object>> commonSearchOrg(Map<String, Object> map) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if (map.get("type") == null) {
			map.put("type", "0");// 默认模糊查询
			map.put("page", "max");
		}
		String type = (String) map.get("type");
		if ("1".equals(type)) {
			List<Map<String, Object>> searchList = (List<Map<String, Object>>) map.get("search");
			for (Map<String, Object> map2 : searchList) {
				Map<String, Object> orgTrueSearch = handlerMapper.orgTrueSearch(map2);
				list.add(orgTrueSearch);
			}
			// list = handlerMapper.orgTrueSearch1(map);
		}
		// 如果有多个搜索条件，将其分割以字符串数组格式存入map
		if ("0".equals(type)) {
			PreConditionHandleUtils.searchConditionHandle(map);
			String orginalsearch = (String) map.get("search");// 原始search
			String[] searchArr = orginalsearch.split(";");
			map.put("searchArr", searchArr);
			list = handlerMapper.commonSearchOrg(map);
		}
		return list;
	}

}
