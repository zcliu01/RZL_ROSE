package com.zrt.flow.service.flowCon;

import java.util.Map;

public interface FlowConService {

	// 附条件回复
	void res(Map<String, Object> map) throws Exception;

	// 附条件复核
	void confirm(Map<String, Object> map) throws Exception;

}
