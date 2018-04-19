package com.zrt.infor.service.commons;

import java.util.List;
import java.util.Map;

/**
 * Created by msKui on 2017/3/21.
 */
public interface InforCommonsService {

	// 讯息详情
	List<Map<String, Object>> getInfoDetail(Map<String, Object> map) throws Exception;

	// 办结、已阅讯息
	int changeInforStatus(Map<String, Object> map, String str) throws Exception;

	// PC端隐藏讯息
	int inforHidden(Map<String, Object> map) throws Exception;

	// PC端取消隐藏讯息
	int inforCancelHidden(Map<String, Object> map) throws Exception;

	// 添加关注
	int concernInfor(Map<String, Object> map, String dicId, String empId) throws Exception;

	// 取消关注
	int concernInforCancel(Map<String, Object> map) throws Exception;

	// 新增关注讯息分类
	int dicAdd(Map<String, Object> map) throws Exception;

	// 关注讯息分类查询
	List<Map<String, Object>> dicList(Map<String, Object> map) throws Exception;

	// APP端显示、隐藏讯息
	int inforShowHid(Map<String, Object> map) throws Exception;

	// APP端删除讯息
	int inforDelete(Map<String, Object> map) throws Exception;

	// 关注讯息详情
	List<Map<String, Object>> getInfoCareDetail(Map<String, Object> map) throws Exception;

	// 撤销讯息
	int inforCancel(Map<String, Object> map) throws Exception;

	// app关注信息分类新增
	Map<String, Object> appDicAdd(Map<String, Object> map) throws Exception;

	// 添加讯息处理情况
	int addInforStatus(Map<String, Object> map) throws Exception;

	// 首页获取讯息未阅数量
	Map<String, Object> getInforCount(Map<String, Object> map) throws Exception;

	// 流程办理后自动已阅该流程讯息
	void flowInforRead(Map<String, Object> map) throws Exception;

}
