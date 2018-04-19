package com.zrt.flow.service.fmDicPm;

import java.util.Map;

public interface FmDicPmService {

	// 字典参数列表
	Map<String, Object> getFmDicPmList(Map<String, Object> map) throws Exception;

	// 字典参数新增
	int save(Map<String, Object> map) throws Exception;

	// 字典参数查询
	Map<String, Object> getFormDetail(Map<String, Object> map) throws Exception;

	// 字典参数更新
	int update(Map<String, Object> map) throws Exception;

	// 字典参数删除
	int delete(Map<String, Object> map) throws Exception;

}
