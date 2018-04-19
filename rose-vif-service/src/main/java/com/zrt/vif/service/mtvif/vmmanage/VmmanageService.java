package com.zrt.vif.service.mtvif.vmmanage;

import java.util.Map;

public interface VmmanageService {

	// 创建视频会议室
	Map<String, Object> createPublicRoom(Map<String, Object> map) throws Exception;

	// 删除视频会议室
	Map<String, Object> deleteRoom(Map<String, Object> map) throws Exception;

	// 单人音频屏蔽、开启
	Map<String, Object> audioSingleControl(Map<String, Object> map) throws Exception;

	// 全部音频屏蔽、开启
	Map<String, Object> audioAllControl(Map<String, Object> map) throws Exception;

	// 单人视频屏蔽、开启
	Map<String, Object> videoSingleControl(Map<String, Object> map) throws Exception;

	// 全部音频屏蔽、开启
	Map<String, Object> videoAllControl(Map<String, Object> map) throws Exception;

	// 踢人
	Map<String, Object> leaveConference(Map<String, Object> map) throws Exception;

	// 设置密码
	Map<String, Object> createRoomPIN(Map<String, Object> map) throws Exception;

	// 移除密码
	Map<String, Object> removeRoomPIN(Map<String, Object> map) throws Exception;

	// 房间加锁、移除
	Map<String, Object> lockRoomControl(Map<String, Object> map) throws Exception;

	// 结束会议
	Map<String, Object> disconnectConferenceAll(Map<String, Object> map) throws Exception;

	// 录制管理
	Map<String, Object> recordControl(Map<String, Object> map) throws Exception;

	// 获取录制视频URL
	Map<String, Object> recordsSearch(Map<String, Object> map) throws Exception;

	// 获取视频房间在线人员
	Map<String, Object> getLinePerson(Map<String, Object> map) throws Exception;

	// 获取所有的视频房间
	Map<String, Object> getRooms() throws Exception;
}