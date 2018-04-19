package com.zrt.infoPub.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface MyInfoPubMapper {

	//查找查看人的的信息
	List<Map<String,Object>> searchViewer(Map<String, Object> map);
	
	//查找附件的的信息
	List<Map<String,Object>> searchAttach(Map<String, Object> map);
	
	//查找公示信息
	List<Map<String,Object>> searchInfoPub(Map<String, Object> map);
	
	
	//查找公示信息
	List<Map<String,Object>> searchInfoPubByView(Map<String, Object> map);
	
	//查找公示信息
	List<Map<String,Object>> searchInfoPubByEveryOne(Map<String, Object> map);
	
	//查找公示类型
	List<Map<String,Object>> searchInfoType(Map<String, Object> map);
	
	//查询公示类型的最大编号
	Map<String,Object> searchMax();
	
	//删除附件
	int deleteAttach(Map<String, Object> map);
	
	//修改信息的阅读状态
	int updateIsRead(Map<String, Object> map);
	
	
	//删除查看人
	int deleteViewer(Map<String, Object> map);
	
	List<String> search(@Param("list") List<String> list);
	
}
