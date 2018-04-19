package com.zrt.contacts.service.sys;

import java.util.List;
import java.util.Map;

import com.zrt.commons.AppException;

/**
 * @ClassName:SysSecEmpService
 * @Description:
 *               <p>
 * 				系统员工
 *               </p>
 * 
 *
 */
public interface SysSecEmpService {
	/**
	 * 根据机构id查询员工数目
	 * 
	 * @param orgId
	 * @return
	 */
	int countEmpByOrgId(String orgId);
	
	/**
	 * 查询通讯录下 所有的员工列表
	 * 
	 * @param mapParam
	 * @return
	 */
	List<Map<String, Object>> empsList( Map<String, Object> map);

	/**
	 * 通讯录下 按照部门查询所有的员工列表
	 * @param status 
	 * 
	 * @param mapParam
	 * @return
	 */
	List<Map<String, Object>> empListByOrg(Map<String, Object> map)throws AppException;

	/**
	 * 通讯录下 根据员工id查询员工详情
	 * 
	 * @param empId
	 * @return
	 */
	Map<String, Object> selectEmpDetails(String empId);
/**
 * 根据员工ID 查询直接上级员工姓名
 * @param empId
 * @return
 */
	String selectUpEmpName(String empId);
/**
 * 根据员工ID 获取个人履历
 * @param empId
 * @return
 */
	List<Map<String,Object>> selectEmpWorkRedeploy(String empId);
/**
 * 根据用户ID 获取职位讯息
 * @param empId
 * @return
 */
List<Map<String, Object>> selectEmpPositionDetails(String empId,String isFirstOrg);
/**
 * PC端根据员工id 查询个人详情(基本信息+职位信息+履历信息)
 * @param map
 * @return
 * @throws AppException
 */
List<Map<String, Object>> selectEmpData(Map<String, Object> map) throws AppException;
/**
 * App端查询直接上级员工详情
 * @param friendEmpId
 * @return
 */
Map<String, Object> selectUpEmpDetails(String friendEmpId)throws AppException;
/**
 * pc端修改个人详情
 * @param map
 */
void updateEmpDetails(Map<String, Object> map)throws AppException;

//==========================>测试
List<Map<String, Object>> searchAll(Map<String, Object> map);

}
