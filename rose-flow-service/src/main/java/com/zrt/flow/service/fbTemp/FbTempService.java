package com.zrt.flow.service.fbTemp;

import java.util.Map;

public interface FbTempService {

	// 表单列表
	Map<String, Object> getFormList(Map<String, Object> map) throws Exception;

	// 表单新增
	int save(Map<String, Object> map) throws Exception;

	// 表单更新
	int update(Map<String, Object> map) throws Exception;

	// 表单删除
	int delete(Map<String, Object> map) throws Exception;

	// 表单明细
	Map<String, Object> getFormDetail(Map<String, Object> map) throws Exception;

	// 流程绑定表单查询
	Map<String, Object> getFbFmList(Map<String, Object> map) throws Exception;

	// 流程绑定表单
	int formSave(Map<String, Object> map) throws Exception;

	// 流程启用、关闭
	int openOrClose(Map<String, Object> map) throws Exception;
	
	//流程提醒人查询
	Map<String, Object> notifyList(Map<String, Object> map) throws Exception;
	
	//流程设置提醒人
	Map<String, Object> notify(Map<String, Object> map) throws Exception;
}
