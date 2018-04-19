package com.zrt.infor.service.inforCategory;

import java.util.Map;

public interface InforCategoryService {

	// 全部列表
	Map<String, Object> getAllList(Map<String, Object> map) throws Exception;
	// 不同处理状态列表
	Map<String, Object> getStatusList(Map<String, Object> map) throws Exception;
	// 关注列表
	Map<String, Object> getCareList(Map<String, Object> map) throws Exception;
	// 我的全部关注列表
	Map<String, Object> getCareAllList(Map<String, Object> map) throws Exception;

}
