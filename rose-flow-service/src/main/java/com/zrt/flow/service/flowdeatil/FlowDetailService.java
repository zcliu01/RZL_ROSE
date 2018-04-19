package com.zrt.flow.service.flowdeatil;

import java.util.Map;

public interface FlowDetailService {

	// 审批详情
	Map<String, Object> getFlowDetail(Map<String, Object> map) throws Exception;
	
	//预处理详情
	Map<String, Object> preInstDetail(Map<String, Object> map) throws Exception;

}
