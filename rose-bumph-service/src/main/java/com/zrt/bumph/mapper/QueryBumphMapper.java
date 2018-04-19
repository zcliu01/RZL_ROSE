package com.zrt.bumph.mapper;

import java.util.List;
import java.util.Map;

public interface QueryBumphMapper {

	//查询公文信息
	List<Map<String, Object>> searchDocument(Map<String, Object> map);
	
	//查询处理人信息
	List<Map<String, Object>> searchDocHander(Map<String, Object> map);
	
	//查询附件信息
	List<Map<String, Object>> searchDocAttach(Map<String, Object> map);
	
	//查询待办公文
	List<Map<String, Object>> searchBacklog(Map<String, Object> map);
	
	//办理公文----更新处理人的处理类型
	int updateState(Map<String, Object> map);
	
	//修改公文信息
	int updateDocument(Map<String, Object> map);
	
	//删除附件信息
	int deleteDocAttach(Map<String, Object> map);
	
	//删除处理人信息
	int deleteDocHander(Map<String, Object> map);
	
	//删除处理人信息
	int deleteDocHanderById(Map<String, Object> map);
	
	//App端公文筛选
	List<Map<String, Object>> searchAll(Map<String, Object> map);
	
	
	//查找公文类型
	List<Map<String,Object>> searchBumphType(Map<String, Object> map);
	
	//查询公示类型的最大编号
	Map<String,Object> searchMax();
	
	//查询公文类型下有无公文
	Map<String,Object> searchbumph(Map<String, Object> map);
	
	//初始化公文处理人的信息
	int initDocHander(Map<String, Object> map);
	
}
