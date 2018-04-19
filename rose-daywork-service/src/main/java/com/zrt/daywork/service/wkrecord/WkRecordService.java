package com.zrt.daywork.service.wkrecord;

import java.util.List;
import java.util.Map;
import java.util.Set;




public interface WkRecordService {

	//日程添加
	int save(Map<String, Object> map) throws Exception;
	
	//日程删除
	int delete(Map<String, Object> map) throws Exception;
	
	//批量日程删除
	int deleteList(Map<String, Object> map) throws Exception;
	
	//日程更新
	int update(Map<String, Object> map) throws Exception;
	
	//日程详情查询
	Map<String, Object> detail(Map<String, Object> map) throws Exception;
	
	//日程列表查询
	List<Map<String, Object>> list(Map<String, Object> map) throws Exception;
	
	//查看全部日程(带分页,一页十条信息)
	Map<String, Object> checkAll(Map<String, Object> map) throws Exception;
	
	//查询所有日期
	Set<String> searchDate(Map<String, Object> map) throws Exception;
}

