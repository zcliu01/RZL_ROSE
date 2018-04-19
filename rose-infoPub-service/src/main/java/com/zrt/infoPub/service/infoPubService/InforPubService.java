package com.zrt.infoPub.service.infoPubService;

import java.util.List;
import java.util.Map;

public interface InforPubService {

	
		//新增信息公示(新建公告)
		int save(Map<String, Object> map) throws Exception;
		
		//公示类型维护
		int state_save(Map<String, Object> map) throws Exception;
		
		//公示删除
		Map<String, Object> del(Map<String, Object> list) throws Exception;
		
		//公示修改
		int updateInfopub(Map<String, Object> map) throws Exception;
		
		//查看公示详情
		Map<String, Object> searchInfo(Map<String, Object> map) throws Exception;
		
		//公示类型查询
		List<Map<String, Object>> state_search(Map<String, Object> map) throws Exception;
		
		//公示查询
		Map<String, Object> search(Map<String, Object> map) throws Exception;
		
		
		//公示状态变更
		int updateInfoType(Map<String, Object> map) throws Exception;
		
		
		//app公示查询
		Map<String, Object> appSearch(Map<String, Object> map) throws Exception;
		
	
}
