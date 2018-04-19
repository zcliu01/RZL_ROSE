package com.zrt.sec.service.resource;

import java.util.List;
import java.util.Map;

import com.zrt.mybatis.domain.SysSecResource;

public interface ResourceService {
	// 资源新增
	int resourceSave(Map<String, Object> appMap) throws Exception;

	// 资源列表查询
	List<SysSecResource> resourceList(Map<String, Object> appMap) throws Exception;

	// 资源信息查询
	SysSecResource resourceSearch(Map<String, Object> appMap) throws Exception;

	// 资源更新
	int resourceUpdate(Map<String, Object> appMap) throws Exception;

	// 资源删除
	int resourceDelete(Map<String, Object> appMap) throws Exception;
}
