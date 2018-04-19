package com.zrt.infor.mapper.inforCategory;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zrt.infor.domain.InforOutbox;

public interface InforCategoryMapper {

	// 获取不同分类讯息全部列表
	List<Map<String, Object>> inforCategoryList(@Param("mapParam") Map<String, Object> mapParam);

	// 获取不同分类讯息不同状态列表
	List<Map<String, Object>> inforCategoryStatusList(@Param("mapParam") Map<String, Object> mapParam);

	// 获取不同分类讯息关注列表
	List<Map<String, Object>> inforCategoryCareList(@Param("mapParam") Map<String, Object> mapParam);

	// 我的全部关注列表
	List<Map<String, Object>> inforCategoryCareAllList(@Param("mapParam") Map<String, Object> mapParam);

}
