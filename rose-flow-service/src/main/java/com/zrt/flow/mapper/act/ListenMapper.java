package com.zrt.flow.mapper.act;

import java.util.List;
import java.util.Map;

import com.zrt.flow.domain.InstDomain;

public interface ListenMapper {

	//查询流程实例
	List<InstDomain> instInfoList(Map<String, Object> map);
	

}