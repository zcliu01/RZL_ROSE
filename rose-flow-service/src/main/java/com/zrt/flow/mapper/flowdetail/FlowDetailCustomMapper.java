package com.zrt.flow.mapper.flowdetail;

import java.util.List;
import java.util.Map;

import com.zrt.flow.domain.CheckDomain;
import com.zrt.flow.domain.InstDomain;

public interface FlowDetailCustomMapper {

	InstDomain getFlowDetail(Map<String, Object> map);
	
	//check_id查询会签信息
    List<CheckDomain> joinSignDetail(Map<String, Object> map);
}