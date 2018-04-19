package com.zrt.client.vmvif;

public interface VmvifServiceUrlConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String VMVIF_INSTANCE = "vif";

	/** 创建视频公共会议室 */
	String CREATE_PUBLICROOM = "/v1.0/vmmanag/createPublicRoom";
	/** 删除视频公共会议室 */
	String DELETE_ROOM = "/v1.0/vmmanag/deleteRoom";
	/** 单人音频屏蔽操作 */
	String AUDIO_SINGLECONTROL = "/v1.0/vmmanag/audioSingleControl";
	/** 屏蔽/开启全部音频 */
	String MUTEAUDIO_SERVERALL = "/v1.0/vmmanag/muteAudioServerAll";
	/** 单人视频屏蔽操作 */
	String VIDEO_SINGLECONTROL = "/v1.0/vmmanag/videoSingleControl";
	/** 屏蔽/开启全部视频 */
	String MUTEVIDEO_SERVERALL = "/v1.0/vmmanag/muteVideoServerAll";
	/** 踢人 */
	String LEAVE_CONFERENCE = "/v1.0/vmmanag/leaveConference";
	/** 设置密码 */
	String CREATE_ROOMPIN = "/v1.0/vmmanag/createRoomPIN";
	/** 移除密码 */
	String REMOVE_ROOMPIN = "/v1.0/vmmanag/removeRoomPIN";
	/** 房间加锁控制 */
	String LOCK_ROOMCONTROL = "/v1.0/vmmanag/lockRoomControl";
	/** 创建公共会议室 */
	String DISCONNECT_CONFERENCEALL = "/v1.0/vmmanag/disconnectConferenceAll";
	/** 获取所有视频房间的id **/
	String GET_ROOMS = "/v1.0/vmmanag/getRooms";

	/** 录像控制 */
	String RECORD_CONTROL = "/v1.0/vmmanag/recordControl";
	/** 获取录像URL */
	String RECORDS_SEARCH = "/v1.0/vmmanag/recordsSearch";
	/** 获取视频房间在线人员 */
	String LINE_PERSON = "/v1.0/vmmanag/linePerson";

	/** IM 消息推送 **/
	String IM_PUSH_MSG = "/v1.0/immanage/pushMsg";

}
