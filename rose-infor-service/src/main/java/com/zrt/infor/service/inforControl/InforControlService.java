package com.zrt.infor.service.inforControl;

import java.util.Map;

public interface InforControlService {

	// 监控详情
	Map<String, Object> getControlDetails(Map<String, Object> map) throws Exception;

	// 监控详情搜索
	Map<String, Object> getDetailsSearch(Map<String, Object> map) throws Exception;

	// 发送给某个员工所有信息列表
	Map<String, Object> getWithEmpList(Map<String, Object> map) throws Exception;

	// App监控详情
	Map<String, Object> getAppControlDetails(Map<String, Object> map) throws Exception;

	// App监控详情搜索
	Map<String, Object> getAppDetailsSearch(Map<String, Object> map) throws Exception;

	// App发送给某个员工所有信息列表
	Map<String, Object> getAppWithEmpList(Map<String, Object> map) throws Exception;

	// App发送给某位员工的所有信息列表搜索
	Map<String, Object> getInforEmpSearch(Map<String, Object> map) throws Exception;

}
