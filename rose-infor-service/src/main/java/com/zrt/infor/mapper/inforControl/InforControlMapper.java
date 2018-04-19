package com.zrt.infor.mapper.inforControl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zrt.infor.domain.InforOutbox;

public interface InforControlMapper {
	/**
	 * 监控详情
	 * 
	 * @param mapParam
	 * @return
	 */
	// 单条讯息对应的收件总数
	Map<String, Object> singleReceiveCount(@Param("mapParam") Map<String, Object> mapParam);
	
	//获取单条讯息的收件id
	List<Map<String, Object>> singleReceiveGroup(@Param("mapParam") Map<String,Object> mapParam) ;
	//获取详情列表
	List<InforOutbox> inforDetailsList(@Param("mapParam") Map<String,Object> mapParam);
	
}
