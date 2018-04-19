package com.zrt.sec.service.org;

import java.util.List;
import java.util.Map;

import com.zrt.mybatis.domain.SysSecOrg;

public interface OrgService {
	// 组织机构新增
	int orgSave(Map<String, Object> appMap) throws Exception;

	// 组织机构列表查询
	List<SysSecOrg> orgList(Map<String, Object> appMap) throws Exception;

	// 组织机构信息查询
	Map<String, Object> orgSearch(Map<String, Object> appMap) throws Exception;

	// 组织机构更新
	void orgUpdate(Map<String, Object> appMap) throws Exception;

	/*
	 * // 组织机构删除 int orgDelete(Map<String, Object> appMap) throws Exception;
	 */

	// 机构树列表
	List<Map<String, Object>> orgAllList(Map<String, Object> appMap) throws Exception;

	// 机构模糊检索
	List<Map<String,Object>> orgNameSearch(Map<String, Object> appMap) throws Exception;

}
