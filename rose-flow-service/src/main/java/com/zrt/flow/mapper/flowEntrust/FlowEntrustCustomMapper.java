package com.zrt.flow.mapper.flowEntrust;

import java.util.List;
import java.util.Map;

public interface FlowEntrustCustomMapper {

	List<Map<String, Object>> getEntrustList(Map<String, Object> map);

	List<Map<String, Object>> getList(Map<String, Object> map);

	List<Map<String, Object>> getAppEntrustList(Map<String, Object> map);

	List<Map<String, Object>> getAppList(Map<String, Object> map);

	List<Map<String, Object>> getOldEmp(String instId);

}