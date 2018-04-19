package com.zrt.sec.mapper.handle;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface HandlerMapper {

	/**
	 * 查询职务
	 * @author tiramisu
	 * @date   2018年3月12日下午2:21:13
	 * @return
	 */
	Map<String, Object> searchPosition(Map<String, Object> map) throws Exception ;
	
	/**
	 * 模糊查询职务
	 * @author tiramisu
	 * @date   2018年3月15日下午6:02:31
	 * @return
	 */
	List<Map<String, Object>> commonSearchPositionTree(@Param("mapParam") Map<String, Object> map) throws Exception ;
	
	
	/**
	 * 模糊查询职务
	 * @author tiramisu
	 * @date   2018年3月15日下午6:02:31
	 * @return
	 */
	List<Map<String, Object>> commonSearchPosition(@Param("mapParam") Map<String, Object> map) throws Exception ;
	
	/**
	 * 查询部门
	 * @author tiramisu
	 * @date   2018年3月12日下午2:21:13
	 * @return
	 */
	Map<String, Object> searchOrg(Map<String, Object> map) throws Exception ;
	
	/**
	 * 模糊查询
	 * @author tiramisu
	 * @date   2018年3月15日下午2:55:31
	 * @return
	 */
	List<Map<String, Object>> commonSearchOrg(@Param("mapParam") Map<String, Object> map)throws Exception ;;
	
	/**
	 * 精确查询
	 * @author tiramisu
	 * @date   2018年3月15日下午2:55:38
	 * @return
	 */
	Map<String, Object> orgTrueSearch( Map<String, Object> map);
	List<Map<String, Object>> orgTrueSearch1(@Param("mapParam") Map<String, Object> map)throws Exception ;;
	
	/**
	 * 查询员工工号是否有重复
	 */
	int searchEmpId(Map<String, Object> map) throws Exception ;
	
}
