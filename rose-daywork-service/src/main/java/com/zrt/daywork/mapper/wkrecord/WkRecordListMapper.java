package com.zrt.daywork.mapper.wkrecord;

import java.util.List;
import java.util.Map;

public interface WkRecordListMapper {

	List<Map<String, Object>> list(Map<String, Object> map);
	
	List<Map<String, Object>> mouthlist(Map<String, Object> map);
	
	List<Map<String, Object>> checkAll(Map<String, Object> map);
	
	List<Map<String, Object>> searchTime(Map<String, Object> map);

}
