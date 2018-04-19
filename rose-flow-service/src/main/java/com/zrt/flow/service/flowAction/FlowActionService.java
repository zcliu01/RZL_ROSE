package com.zrt.flow.service.flowAction;

import java.util.Map;

public interface FlowActionService {


	// 流程删除
	void delete(Map<String, Object> map) throws Exception;

	// 流程终止
	void end(Map<String, Object> map) throws Exception;
	

}
