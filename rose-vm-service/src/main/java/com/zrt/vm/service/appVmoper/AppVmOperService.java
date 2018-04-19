package com.zrt.vm.service.appVmoper;

import java.util.Map;

import com.zrt.commons.AppException;

public interface AppVmOperService {

	// app发起即时会议
	Map<String, Object> appLaunch(Map<String, Object> map) throws AppException;

	// 发起人入会
	void inMeeting(Map<String, Object> map) throws AppException;

	// 会议临时加人
	void addPerson(Map<String, Object> map) throws AppException;

	// 参与人会议响应通知
	void getIsJoin(Map<String, Object> map) throws AppException;

	// 退出通知
	void quit(Map<String, Object> map) throws AppException;

	// 会议是否结束
	Map<String, Object> isEnd(Map<String, Object> map) throws AppException;

}
