package com.zrt.gateway.api.client.vm;

public interface VmConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String VM_INSTANCE = "vm";

	/** 进行中会议列表 */
	String VM_ONGOINGMEETING_LIST = "/v1.0/vm/ongoingMeetingList";
	/** 加入会议 */
	String VM_MEETING_JOIN = "/v1.0/vm/joinMeeting";
	/** 历史会议列表 */
	String VM_HISTORICALMEETING_LIST = "/v1.0/vm/historicalMeetingList";
	/** 我的会议室会议列表 */
	String VM_MYMEETING_LIST = "/v1.0/vm/myMeetingList";
	/** 开启会议 */
	String VM_MEETING_OPEN = "/v1.0/vm/openMeeting";
	/** 取消会议 */
	String VM_MEETING_DELETE = "/v1.0/vm/cancelMeeting";
	/** 新建会议 */
	String VM_MEETING_SAVE = "/v1.0/vm/saveMeeting";
	/** 修改会议 */
	String VM_MEETING_UPDATE = "/v1.0/vm/updateMeeting";

	/** 获取会议中人员列表 */
	String MTPERSON_LIST = "/v1.0/vmmanage/mtPersonList";
	/** 音频屏蔽 */
	String MUTE_AUDIO = "/v1.0/vmmanage/muteAudio";
	/** 取消音频屏蔽 */
	String UNMUTE_AUDIO = "/v1.0/vmmanage/unmuteAudio";
	/** 视频屏蔽 */
	String STOP_VIDEO = "/v1.0/vmmanage/stopVideo";
	/** 取消视频屏蔽 */
	String START_VIDEO = "/v1.0/vmmanage/startVideo";
	/** 踢人 */
	String LEAVE_CONFERENCE = "/v1.0/vmmanage/leaveConference";
	/** 结束会议 */
	String DISCONNECT_CONFERENCEALL = "/v1.0/vmmanage/disconnectConferenceAll";
	/** 暂停、继续录制视频 */
	String RESUME_RECOD = "/v1.0/vmmanage/resumeRecod";
	/** 加人 */
	String REC_ADD = "/v1.0/vmmanage/recAdd";
	
	
	
	/** web发起失败 */
	String LAUNCH = "/v1.0/vmoper/launch";

}
