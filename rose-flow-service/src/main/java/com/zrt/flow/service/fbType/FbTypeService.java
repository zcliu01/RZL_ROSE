package com.zrt.flow.service.fbType;

import java.util.List;
import java.util.Map;

public interface FbTypeService {

	// 表单分类列表
	List<Map<String, Object>> getFmTypeList(Map<String, Object> map) throws Exception;

	// 增加分类
	int save(Map<String, Object> map) throws Exception;

	// 分类明细
	Map<String, Object> getFmTypeDetail(Map<String, Object> map) throws Exception;

	// 分类更新
	int update(Map<String, Object> map) throws Exception;

	// 分类删除
	int delete(Map<String, Object> map) throws Exception;

}
