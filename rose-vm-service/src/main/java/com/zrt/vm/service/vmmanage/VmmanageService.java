package com.zrt.vm.service.vmmanage;

import java.util.Map;

import com.zrt.commons.AppException;

public interface VmmanageService {

	// 单人音频屏蔽
	void muteAudio(Map<String, Object> map) throws AppException;

	// 取消单人音频屏蔽
	void unmuteAudio(Map<String, Object> map) throws AppException;

	// 全部音频操作（屏蔽与开启）
	void muteAudioServerAll(Map<String, Object> map) throws AppException;

	// 单人视频屏蔽
	void stopVideo(Map<String, Object> map) throws AppException;

	// 取消单人视频屏蔽
	void startVideo(Map<String, Object> map) throws AppException;

	// 全部视频操作（屏蔽与开启）
	void muteVideoServerAll(Map<String, Object> map) throws AppException;

	// 踢人
	void leaveConference(Map<String, Object> map) throws AppException;

	// 房间加锁
	void lockRoom(Map<String, Object> map) throws AppException;

	// 移除房间锁
	void unlockRoom(Map<String, Object> map) throws AppException;

	// 结束会议
	void disconnectConferenceAll(Map<String, Object> map) throws AppException;

	// 录制操作
	void recordControl(Map<String, Object> map) throws AppException;

	/**
	 * 会控操作
	 */
	void mtControl(Map<String, Object> map) throws AppException;

	/**
	 * 获取会议中人员列表
	 */
	Map<String, Object> getMtPersonList(Map<String, Object> map) throws AppException;

	/**
	 * 加人
	 */
	void recAdd(Map<String, Object> map) throws AppException;

}
