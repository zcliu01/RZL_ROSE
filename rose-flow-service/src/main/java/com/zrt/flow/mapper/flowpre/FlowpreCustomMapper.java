package com.zrt.flow.mapper.flowpre;

import java.util.List;
import java.util.Map;

import com.zrt.flow.domain.InstInfoDomain;

public interface FlowpreCustomMapper {

	List<InstInfoDomain> getMyPreList(Map<String, Object> map);


	//查询代办预处理列表
	List<InstInfoDomain> preList(Map<String, Object> map);
}