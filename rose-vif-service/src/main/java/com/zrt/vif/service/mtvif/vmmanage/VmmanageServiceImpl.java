package com.zrt.vif.service.mtvif.vmmanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrt.commons.AppException;
import com.zrt.portal.admin.Room;
import com.zrt.vif.service.video.AdminVideoService;
import com.zrt.vif.service.video.ReplayVideoService;
import com.zrt.vif.service.video.UserVideoService;

@Service
public class VmmanageServiceImpl implements VmmanageService {

	private static final Logger log = LoggerFactory.getLogger(VmmanageServiceImpl.class);

	@Autowired
	private AdminVideoService adminService;
	@Autowired
	private UserVideoService userService;
	@Autowired
	private ReplayVideoService replayService;

	@Override
	public Map<String, Object> createPublicRoom(Map<String, Object> map) throws Exception {

		String displayName = (String) map.get("displayName");
		String ownerName = (String) map.get("auth_name");

		Map<String, Object> resMap = adminService.createPublicRoom(displayName, ownerName);
		return resMap;
	}

	@Override
	public Map<String, Object> deleteRoom(Map<String, Object> map) throws Exception {
		int roomId = (int) map.get("room_id");

		Map<String, Object> resMap = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(String.valueOf(roomId))) {
			// 判断房间是否存在
			log.info("开始调用video服务的getRoom接口;roomId为：" + roomId);
			boolean f = adminService.getRoom(roomId);
			if (f == true) {
				log.info("开始调用video服务的deleteRoom接口");
				resMap = adminService.deleteRoom(roomId);
			} else {
				throw new AppException("该房间不存在!");
			}
			// Map<String, Object> roomResMap = adminService.getRooms();
			// @SuppressWarnings("unchecked")
			// List<Room> roomList = (List<Room>) roomResMap.get("roomList");
			// if (roomList != null && roomList.size() > 0) {
			// for (Room room : roomList) {
			// if (roomId == room.getRoomID()) {
			// log.info("开始调用video服务的deleteRoom接口");
			// resMap = adminService.deleteRoom(roomId);
			// }
			// }
			// }

		}

		return resMap;
	}

	@Override
	public Map<String, Object> audioSingleControl(Map<String, Object> map) throws Exception {
		int conferenceID = (int) map.get("room_id");
		int participantID = (int) map.get("rec_emp_id");

		Map<String, Object> resMap = new HashMap<String, Object>();
		String action = (String) map.get("action_flag");
		if (action.equals("mute")) {
			log.info("开始调用video服务的muteAudio接口");
			resMap = adminService.muteAudio(conferenceID, participantID);
		} else if (action.equals("unmute")) {
			log.info("开始调用video服务的unmuteAudio接口");
			resMap = adminService.unmuteAudio(conferenceID, participantID);
		}

		return resMap;
	}

	@Override
	public Map<String, Object> audioAllControl(Map<String, Object> map) throws Exception {
		String conferenceID = (String) map.get("room_id");
		boolean muteState = (boolean) map.get("mute_state");

		log.info("开始调用video服务的muteAudioServerAll接口");
		Map<String, Object> resMap = userService.muteAudioServerAll(conferenceID, muteState);

		return resMap;
	}

	@Override
	public Map<String, Object> videoSingleControl(Map<String, Object> map) throws Exception {
		int conferenceID = (int) map.get("room_id");
		int participantID = (int) map.get("participantID");

		Map<String, Object> resMap = new HashMap<String, Object>();
		String action = (String) map.get("action_flag");
		if (action.equals("stop")) {
			log.info("开始调用video服务的stopVideo接口");
			resMap = adminService.stopVideo(conferenceID, participantID);
		} else if (action.equals("start")) {
			log.info("开始调用video服务的startVideo接口");
			resMap = adminService.startVideo(conferenceID, participantID);
		}

		return resMap;
	}

	@Override
	public Map<String, Object> videoAllControl(Map<String, Object> map) throws Exception {
		String conferenceID = (String) map.get("room_id");
		boolean muteState = (boolean) map.get("muteState");

		log.info("开始调用video服务的muteVideoServerAll接口");
		Map<String, Object> resMap = userService.muteVideoServerAll(conferenceID, muteState);

		return resMap;
	}

	@Override
	public Map<String, Object> leaveConference(Map<String, Object> map) throws Exception {
		int conferenceID = (int) map.get("room_id");
		int participantID = (int) map.get("rec_emp_id");

		log.info("开始调用video服务的leaveConference接口");
		Map<String, Object> resMap = adminService.leaveConference(conferenceID, participantID);

		return resMap;
	}

	@Override
	public Map<String, Object> createRoomPIN(Map<String, Object> map) throws Exception {
		int roomId = (int) map.get("room_id");
		String pin = (String) map.get("pin");

		log.info("开始调用video服务的createRoomPIN接口");
		Map<String, Object> resMap = adminService.createRoomPIN(roomId, pin);

		return resMap;
	}

	@Override
	public Map<String, Object> removeRoomPIN(Map<String, Object> map) throws Exception {
		int roomId = (int) map.get("room_id");

		log.info("开始调用video服务的removeRoomPIN接口");
		Map<String, Object> resMap = adminService.removeRoomPIN(roomId);

		return resMap;
	}

	@Override
	public Map<String, Object> lockRoomControl(Map<String, Object> map) throws Exception {
		String roomId = (String) map.get("room_id");

		Map<String, Object> resMap = new HashMap<String, Object>();
		String action = (String) map.get("action_flag");
		if (action.equals("lock")) {
			log.info("开始调用video服务的lockRoom接口");
			resMap = userService.lockRoom(roomId);
		} else if (action.equals("unlock")) {
			log.info("开始调用video服务的unlockRoom接口");
			resMap = userService.unlockRoom(roomId);
		}

		return resMap;
	}

	@Override
	public Map<String, Object> disconnectConferenceAll(Map<String, Object> map) throws Exception {
		int conferenceID = (int) map.get("room_id");

		log.info("开始调用video服务的disconnectConferenceAll接口");
		Map<String, Object> resMap = userService.disconnectConferenceAll(String.valueOf(conferenceID));

		return resMap;
	}

	@Override
	public Map<String, Object> recordControl(Map<String, Object> map) throws Exception {
		String action = (String) map.get("video_flag");
		int conferenceID = (int) map.get("room_id");

		Map<String, Object> resMap = new HashMap<String, Object>();
		if (action.equals("2")) {// 开启录制
			log.info("开始调用video服务的startRecording接口");
			resMap = adminService.startRecording(conferenceID);
		} else if (action.equals("0")) {// 暂停录制
			log.info("开始调用video服务的pauseRecording接口");
			resMap = adminService.pauseRecording(conferenceID);
		} else if (action.equals("1")) {// 继续录制
			log.info("开始调用video服务的resumeRecording接口");
			resMap = adminService.resumeRecording(conferenceID);
		} else if (action.equals("3")) {// 停止录制
			log.info("开始调用video服务的stopRecording接口");
			resMap = adminService.stopRecording(conferenceID);
		}
		return resMap;
	}

	@Override
	public Map<String, Object> recordsSearch(Map<String, Object> map) throws Exception {
		String ownerName = (String) map.get("ownerName");
		String roomName = (String) map.get("roomName");

		log.info("开始调用video服务的recordsSearch接口");
		Map<String, Object> resMap = replayService.recordsSearch(ownerName, roomName);

		return resMap;
	}

	@Override
	public Map<String, Object> getLinePerson(Map<String, Object> map) throws Exception {
		int conferenceID = (int) map.get("room_id");

		Map<String, Object> resMap = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(String.valueOf(conferenceID))) {
			// 判断房间是否存在
			boolean f = adminService.getRoom(conferenceID);
			if (f == true) {
				log.info("开始调用video服务的getParticipant接口");
				resMap = adminService.getParticipant(conferenceID);
			} else {
				throw new AppException("该房间不存在!");
			}
			// Map<String, Object> roomResMap = adminService.getRooms();
			// @SuppressWarnings("unchecked")
			// List<Room> roomList = (List<Room>) roomResMap.get("roomList");
			// if (roomList != null && roomList.size() > 0) {
			// for (Room room : roomList) {
			// if (conferenceID == room.getRoomID()) {
			// resMap = adminService.getParticipant(conferenceID);
			// break;
			// }
			// }
			// }
		}

		return resMap;
	}

	@Override
	public Map<String, Object> getRooms() throws Exception {

		Map<String, Object> resMap = new HashMap<String, Object>();
		List<Integer> dataList = new ArrayList<Integer>();

		log.info("开始调用video服务的getRooms接口");
		Map<String, Object> roomResMap = adminService.getRooms();
		@SuppressWarnings("unchecked")
		List<Room> roomList = (List<Room>) roomResMap.get("roomList");
		if (roomList != null && roomList.size() > 0) {
			for (Room room : roomList) {
				if ("Public".equals(room.getRoomType())) {
					dataList.add(room.getRoomID());
				}
			}
		}
		resMap.put("roomIdList", dataList);
		return resMap;
	}
}
