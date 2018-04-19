package com.zrt.sec.mapper.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface UserMapper {
	// 员工列表列表
	List<Map<String, Object>> empList(Map<String, Object> appMap) throws Exception;

	// 员工信息查询
	Map<String, Object> userSearch(Map<String, Object> appMap) throws Exception;

	List<Map<String, Object>> userSearchorgspp(Map<String, Object> appMap) throws Exception;

	List<Map<String, Object>> userSearredeploy(Map<String, Object> appMap) throws Exception;

	// 员工上级领导查询
	List<Map<String, Object>> manageSearch(Map<String, Object> appMap) throws Exception;
	// 员工org查询
	Map<String, Object> orgSearch(Map<String, Object> appMap) throws Exception;
	
	// 员工所在机构上级领导查询
	List<Map<String, Object>> upManageSearch(Map<String, Object> appMap) throws Exception;
	
	// 查询员工直接上级
	String upSearch(@Param("up_emp_id") String empId) throws Exception;
	
	// 修改员工直接上级
	int updateManager(Map<String, Object> appMap) throws Exception;
	
	
	// 修改员工是否同步数据
	int userSync(Map<String, Object> appMap) throws Exception;
	// 修改员工是否同步数据
	int deletePosition(Map<String, Object> appMap) throws Exception;
}
