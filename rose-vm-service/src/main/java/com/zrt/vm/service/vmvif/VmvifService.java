package com.zrt.vm.service.vmvif;

import java.util.Map;

public interface VmvifService {
	Map<String, Object> createPublicRoom(Map<String, Object> map);

	Map<String, Object> deleteRoom(Map<String, Object> map);

	Map<String, Object> audioSingleControl(Map<String, Object> map);

	Map<String, Object> muteAudioServerAll(Map<String, Object> map);

	Map<String, Object> videoSingleControl(Map<String, Object> map);

	Map<String, Object> muteVideoServerAll(Map<String, Object> map);

	Map<String, Object> leaveConference(Map<String, Object> map);

	Map<String, Object> createRoomPIN(Map<String, Object> map);

	Map<String, Object> removeRoomPIN(Map<String, Object> map);

	Map<String, Object> lockRoomControl(Map<String, Object> map);

	Map<String, Object> disconnectConferenceAll(Map<String, Object> map);

	Map<String, Object> pushMsg(Map<String, Object> map);

	Map<String, Object> recordControl(Map<String, Object> map);

	Map<String, Object> recordsSearch(Map<String, Object> map);

	Map<String, Object> linePerson(Map<String, Object> map);

	Map<String, Object> getRooms();

}
