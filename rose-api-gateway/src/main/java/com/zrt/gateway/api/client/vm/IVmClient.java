package com.zrt.gateway.api.client.vm;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(VmConstant.VM_INSTANCE)
public interface IVmClient extends VmConstant {

	@RequestMapping(value = VM_ONGOINGMEETING_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> ongoingMeetingList(Map<String, Object> requestMap);

	@RequestMapping(value = VM_MEETING_JOIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> joinMeeting(Map<String, Object> requestMap);

	@RequestMapping(value = VM_HISTORICALMEETING_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> historicalMeetingList(Map<String, Object> requestMap);

	@RequestMapping(value = VM_MYMEETING_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> myMeetingList(Map<String, Object> requestMap);

	@RequestMapping(value = VM_MEETING_OPEN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> openMeeting(Map<String, Object> requestMap);

	@RequestMapping(value = VM_MEETING_DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> cancelMeeting(Map<String, Object> requestMap);

	@RequestMapping(value = VM_MEETING_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> saveMeeting(Map<String, Object> requestMap);

	@RequestMapping(value = VM_MEETING_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> updateMeeting(Map<String, Object> requestMap);

	@RequestMapping(value = MTPERSON_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> mtPersonList(Map<String, Object> requestMap);

	@RequestMapping(value = MUTE_AUDIO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> muteAudio(Map<String, Object> requestMap);

	@RequestMapping(value = UNMUTE_AUDIO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> unmuteAudio(Map<String, Object> requestMap);

	@RequestMapping(value = STOP_VIDEO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> stopVideo(Map<String, Object> requestMap);

	@RequestMapping(value = START_VIDEO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> startVideo(Map<String, Object> requestMap);

	@RequestMapping(value = LEAVE_CONFERENCE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> leaveConference(Map<String, Object> requestMap);

	@RequestMapping(value = DISCONNECT_CONFERENCEALL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> disconnectConferenceAll(Map<String, Object> requestMap);

	@RequestMapping(value = RESUME_RECOD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> resumeRecod(Map<String, Object> requestMap);
	
	@RequestMapping(value = REC_ADD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> recAdd(Map<String, Object> requestMap);

	@RequestMapping(value = LAUNCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> launch(Map<String, Object> requestMap);

}
