package com.zrt.client.vmvif;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient(VmvifServiceUrlConstant.VMVIF_INSTANCE)
public interface VmvifClient extends VmvifServiceUrlConstant {

	@RequestMapping(value = CREATE_PUBLICROOM, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> createPublicRoom(Map<String, Object> requestJson);

	@RequestMapping(value = DELETE_ROOM, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> deleteRoom(Map<String, Object> requestJson);

	@RequestMapping(value = AUDIO_SINGLECONTROL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> audioSingleControl(Map<String, Object> requestJson);

	@RequestMapping(value = MUTEAUDIO_SERVERALL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> muteAudioServerAll(Map<String, Object> requestJson);

	@RequestMapping(value = VIDEO_SINGLECONTROL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> videoSingleControl(Map<String, Object> requestJson);

	@RequestMapping(value = MUTEVIDEO_SERVERALL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> muteVideoServerAll(Map<String, Object> requestJson);

	@RequestMapping(value = LEAVE_CONFERENCE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> leaveConference(Map<String, Object> requestJson);

	@RequestMapping(value = CREATE_ROOMPIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> createRoomPIN(Map<String, Object> requestJson);

	@RequestMapping(value = REMOVE_ROOMPIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> removeRoomPIN(Map<String, Object> requestJson);

	@RequestMapping(value = LOCK_ROOMCONTROL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> lockRoomControl(Map<String, Object> requestJson);

	@RequestMapping(value = DISCONNECT_CONFERENCEALL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> disconnectConferenceAll(Map<String, Object> requestJson);

	@RequestMapping(value = IM_PUSH_MSG, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> pushMsg(Map<String, Object> requestJson);

	@RequestMapping(value = RECORD_CONTROL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> recordControl(Map<String, Object> requestJson);

	@RequestMapping(value = RECORDS_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> recordsSearch(Map<String, Object> requestJson);

	@RequestMapping(value = LINE_PERSON, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> linePerson(Map<String, Object> requestJson);

	@RequestMapping(value = GET_ROOMS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	Map<String, Object> getRooms();

}
