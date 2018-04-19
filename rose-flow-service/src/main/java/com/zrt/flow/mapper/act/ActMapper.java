package com.zrt.flow.mapper.act;

import java.util.List;
import java.util.Map;

public interface ActMapper {

	//查询流程实例所有已经经过的节点，
	List<Map<String, Object>> instTagList(Map<String, Object> map);
	
	//查询实例经过已经完成的节点
	List<Map<String, Object>> instfinishTagList(Map<String, Object> map);

	//根据业务id，查询待办列表
	List<Map<String, Object>> queryDoDeal(Map<String, Object> map);
}