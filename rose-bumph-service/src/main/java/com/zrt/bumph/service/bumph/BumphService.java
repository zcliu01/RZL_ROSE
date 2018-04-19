package com.zrt.bumph.service.bumph;

import java.util.List;
import java.util.Map;

public interface BumphService {
	
	//新建公文
	int add(Map<String, Object> map) throws Exception;
	
	//公文详情查询
	Map<String, Object> detailView(Map<String, Object> map) throws Exception;
	//APP公文详情查询
	Map<String, Object> APPdetailView(Map<String, Object> map) throws Exception;
	
	//待发布公文详情
	Map<String, Object> detail(Map<String, Object> map) throws Exception;
	
	//公文登记
	Map<String, Object> regis(Map<String, Object> map) throws Exception;
	
	//待办公文
	Map<String, Object> detailSearch(Map<String, Object> map) throws Exception;
	//待办公文
	Map<String, Object> APPdetailSearch(Map<String, Object> map) throws Exception;
	
	//公文审核查看
	Map<String, Object> auditView(Map<String, Object> map) throws Exception;
	//公文审核查看
	Map<String, Object> APPauditView(Map<String, Object> map) throws Exception;
	
	//公文监控
	Map<String, Object> Monitor(Map<String, Object> map) throws Exception;
	
	//公文审核办理
	int auditAttend(Map<String, Object> map) throws Exception;
	
	//公文删除
	int delete(Map<String, Object> map) throws Exception;
	
	//公文撤销
	int backout(Map<String, Object> map) throws Exception;
	
	//公文撤销
	int webBackout(Map<String, Object> map) throws Exception;
	
	
	//管理审核人
	int execute(Map<String, Object> map) throws Exception;
	
	//管理审核人
	int addExecutes(Map<String, Object> map) throws Exception;
	//管理审核人
	int appAddExecutes(Map<String, Object> map) throws Exception;
	
	//公文修改
	int update(Map<String, Object> map) throws Exception;
	
	//App端  公文筛选
	Map<String, Object> documentSearch(Map<String, Object> map) throws Exception;
	//App端  公文筛选
	Map<String, Object> APPdocumentSearch(Map<String, Object> map) throws Exception;
	
	//App端 公文管理--筛选
	Map<String, Object> manageSearch(Map<String, Object> map) throws Exception;
	//App端 公文管理--筛选
	Map<String, Object> APPmanageSearch(Map<String, Object> map) throws Exception;
	
	//公示类型查询
	List<Map<String, Object>> state_search(Map<String, Object> map) throws Exception;
	
	//公示类型维护
	int state_save(Map<String, Object> map) throws Exception;
	
}
