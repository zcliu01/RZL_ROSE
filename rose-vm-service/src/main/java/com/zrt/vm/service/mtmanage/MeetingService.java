package com.zrt.vm.service.mtmanage;

import java.util.Map;

import com.zrt.commons.AppException;

public interface MeetingService {

	/**
	 * 进行中会议列表
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> ongoingMeetingList(Map<String, Object> map) throws AppException;

	/**
	 * 加入会议
	 * 
	 * @param map
	 */
	void joinMeeting(Map<String, Object> map) throws AppException;

	/**
	 * 历史会议列表
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> historicalMeetingList(Map<String, Object> map) throws AppException;

	/**
	 * 我的会议室会议列表
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> myMeetingList(Map<String, Object> map) throws AppException;

	/**
	 * web开启会议
	 * 
	 * @param map
	 */
	void openMeeting(Map<String, Object> map) throws AppException;

	/**
	 * App开启会议
	 * 
	 * @param map
	 */
	Map<String, Object> appOpenMeeting(Map<String, Object> map) throws AppException;

	/**
	 * 取消会议
	 * 
	 * @param map
	 */
	void cancelMeeting(Map<String, Object> map) throws AppException;

	/**
	 * 新建会议
	 * 
	 * @param map
	 */
	void saveMeeting(Map<String, Object> map) throws AppException;

	/**
	 * 修改会议
	 * 
	 * @param map
	 */
	void updateMeeting(Map<String, Object> map) throws AppException;

	/**
	 * app端进行中会议列表
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> appOngoingMeetingList(Map<String, Object> map) throws AppException;

	/**
	 * app端历史会议列表
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> appHistoricalMeetingList(Map<String, Object> map) throws AppException;

	/***
	 * app端我的会议室会议列表
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> appMyMeetingList(Map<String, Object> map) throws AppException;

}
