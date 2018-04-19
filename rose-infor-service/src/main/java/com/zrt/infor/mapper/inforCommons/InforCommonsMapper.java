package com.zrt.infor.mapper.inforCommons;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface InforCommonsMapper {

	// 首页获取不同分类讯息未阅条数
	List<Map<String, Object>> inforCountList(@Param("mapParam") Map<String, Object> mapParam);

	// 首页获取我的关注未阅条数
	List<Map<String, Object>> inforCareCountList(@Param("mapParam") Map<String, Object> mapParam);

	// 根据流程的bus_id和bus_domain查询有关的讯息
	List<Map<String, Object>> getFlowInfor(Map<String, Object> map);

	// 批量插入讯息收件表
	void inforAllInsert(List<Map<String, Object>> list) throws Exception;

	// 批量插入讯息处理表
	void inforDealInsert(List<Map<String, Object>> list) throws Exception;

}
