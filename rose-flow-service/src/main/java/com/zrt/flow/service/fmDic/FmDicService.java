package com.zrt.flow.service.fmDic;

import java.util.Map;

public interface FmDicService {

	// 字典列表
	Map<String, Object> getFmDicList(Map<String, Object> map) throws Exception;

	// 字典新增
	int save(Map<String, Object> map) throws Exception;

	// 字典明细查询
	Map<String, Object> getFormDetail(Map<String, Object> map) throws Exception;

	// 字典更新
	int update(Map<String, Object> map) throws Exception;

	// 字典删除
	int delete(Map<String, Object> map) throws Exception;

}
