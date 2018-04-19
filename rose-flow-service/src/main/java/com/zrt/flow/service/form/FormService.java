package com.zrt.flow.service.form;

import java.util.Map;

public interface FormService {

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

	// 表单启用、关闭
	int openOrCloseform(Map<String, Object> map) throws Exception;

	// 表单元素详情
	Map<String, Object> getFormElementDetail(Map<String, Object> map) throws Exception;

	int formsave(Map<String, Object> map) throws Exception;
}
