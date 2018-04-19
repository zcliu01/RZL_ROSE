package com.zrt.vif.service.video;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zrt.commons.AppException;
import com.zrt.portal.admin.CreatePublicRoomRequest;
import com.zrt.portal.admin.CreatePublicRoomResponse;
import com.zrt.portal.admin.CreateRoomPINRequest;
import com.zrt.portal.admin.CreateRoomPINResponse;
import com.zrt.portal.admin.DeleteRoomRequest;
import com.zrt.portal.admin.DeleteRoomResponse;
import com.zrt.portal.admin.Entity;
import com.zrt.portal.admin.Filter;
import com.zrt.portal.admin.GetParticipantsRequest;
import com.zrt.portal.admin.GetParticipantsResponse;
import com.zrt.portal.admin.GetRoomRequest;
import com.zrt.portal.admin.GetRoomResponse;
import com.zrt.portal.admin.GetRoomsRequest;
import com.zrt.portal.admin.GetRoomsResponse;
import com.zrt.portal.admin.LeaveConferenceRequest;
import com.zrt.portal.admin.LeaveConferenceResponse;
import com.zrt.portal.admin.MuteAudioRequest;
import com.zrt.portal.admin.MuteAudioResponse;
import com.zrt.portal.admin.PauseRecordingRequest;
import com.zrt.portal.admin.PauseRecordingResponse;
import com.zrt.portal.admin.RemoveRoomPINRequest;
import com.zrt.portal.admin.RemoveRoomPINResponse;
import com.zrt.portal.admin.ResumeRecordingRequest;
import com.zrt.portal.admin.ResumeRecordingResponse;
import com.zrt.portal.admin.Room;
import com.zrt.portal.admin.StartRecordingRequest;
import com.zrt.portal.admin.StartRecordingResponse;
import com.zrt.portal.admin.StartVideoRequest;
import com.zrt.portal.admin.StartVideoResponse;
import com.zrt.portal.admin.StopRecordingRequest;
import com.zrt.portal.admin.StopRecordingResponse;
import com.zrt.portal.admin.StopVideoRequest;
import com.zrt.portal.admin.StopVideoResponse;
import com.zrt.portal.admin.UnmuteAudioRequest;
import com.zrt.portal.admin.UnmuteAudioResponse;
import com.zrt.portal.admin.VidyoPortalAdminService;
import com.zrt.portal.admin.VidyoPortalAdminServicePortType;

@Service
public class AdminVideoService {

	private static final Logger log = LoggerFactory.getLogger(AdminVideoService.class);

	@Value("${vidyo.adminURL}")
	private String adminURL;
	@Value("${vidyo.admin_no}")
	private String adminNo;
	@Value("${vidyo.admin_password}")
	private String adminPassword;

	/**
	 * 连接服务
	 * 
	 * @return
	 * @throws AppException
	 */
	public VidyoPortalAdminServicePortType serverConnection() throws AppException {
		String adminAddress = adminURL + "/services/v1_1/VidyoPortalAdminService";

		final String WS_URL = adminURL + "/services/v1_1/VidyoPortalAdminService?wsdl";
		VidyoPortalAdminServicePortType servicePort = null;
		try {
			URL url = new URL(WS_URL);
			QName qname = new QName("http://portal.vidyo.com/admin/v1_1", "VidyoPortalAdminService");

			VidyoPortalAdminService adminService = new VidyoPortalAdminService(url, qname);
//			servicePort = adminService.getPort(VidyoPortalAdminServicePortType.class);
			servicePort = adminService.getVidyoPortalAdminServicePort();

			BindingProvider bp = (BindingProvider) servicePort;// 用户认证
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, adminAddress);
			bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, adminNo);
			bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, adminPassword);

		} catch (MalformedURLException e) {
			e.printStackTrace();
			log.info("vidyo服务admin连接失败！");
			throw new AppException("vidyo服务admin连接失败！");
		}
		return servicePort;
	}

	/**
	 * 创建公共视频会议室
	 * 
	 * @param displayName（视频会议室显示名称）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> createPublicRoom(String displayName, String authName) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalAdminServicePortType servicePort = serverConnection();
		try {
			CreatePublicRoomRequest createPublicRoomRequest = new CreatePublicRoomRequest();
			createPublicRoomRequest.setDisplayName(displayName);
			createPublicRoomRequest.setOwnerName(authName);

			CreatePublicRoomResponse createPublicRoomResponse = servicePort.createPublicRoom(createPublicRoomRequest);
			int roomId = createPublicRoomResponse.getRoomID();
			String roomURL = createPublicRoomResponse.getRoomURL();
			String extension = createPublicRoomResponse.getExtension();

			resMap.put("room_id", roomId);
			resMap.put("room_URL", roomURL);
			resMap.put("extension", extension);
			log.info("vidyo创建公共视频会议室成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("vidyo创建公共视频会议室失败！");
			throw new AppException("vidyo创建公共视频会议室失败！");
		}
		return resMap;
	}

	/**
	 * 删除视频会议室
	 * 
	 * @param roomId（会议室id）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> deleteRoom(int roomId) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalAdminServicePortType servicePort = serverConnection();
		try {
			boolean f = this.getRoom(roomId);
			if (true == f) {
				DeleteRoomRequest deleteRoomRequest = new DeleteRoomRequest();
				deleteRoomRequest.setRoomID(roomId);

				DeleteRoomResponse deleteRoomResponse = servicePort.deleteRoom(deleteRoomRequest);
				String OK = deleteRoomResponse.getOK();

				resMap.put("OK", OK);
				log.info("vidyo删除视频房间成功！");
			} else {
				log.info("vidyo删除视频房间时该房间已经不存在！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
			log.info("vidyo删除视频房间失败！");
			throw new AppException("vidyo删除视频房间失败！");
		}
		return resMap;
	}

	/**
	 * 单人音频屏蔽
	 * 
	 * @param conferenceID（会议室id）
	 * @param participantID（参会人id）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> muteAudio(int conferenceID, int participantID) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalAdminServicePortType servicePort = serverConnection();
		try {
			MuteAudioRequest muteAudioRequest = new MuteAudioRequest();
			muteAudioRequest.setConferenceID(conferenceID);
			muteAudioRequest.setParticipantID(participantID);

			MuteAudioResponse muteAudioResponse = servicePort.muteAudio(muteAudioRequest);
			String OK = muteAudioResponse.getOK();

			resMap.put("OK", OK);
			log.info("vidyo单人音频屏蔽成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("vidyo单人音频屏蔽失败！");
			throw new AppException("vidyo单人音频屏蔽失败！");
		}
		return resMap;
	}

	/**
	 * 取消单人音频屏蔽
	 * 
	 * @param conferenceID（会议室id）
	 * @param participantID（参会人id）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> unmuteAudio(int conferenceID, int participantID) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalAdminServicePortType servicePort = serverConnection();
		try {
			UnmuteAudioRequest unMuteAudioRequest = new UnmuteAudioRequest();
			unMuteAudioRequest.setConferenceID(conferenceID);
			unMuteAudioRequest.setParticipantID(participantID);

			UnmuteAudioResponse unMuteAudioResponse = servicePort.unmuteAudio(unMuteAudioRequest);
			String OK = unMuteAudioResponse.getOK();

			resMap.put("OK", OK);
			log.info("vidyo取消单人音频屏蔽成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("vidyo取消单人音频屏蔽失败！");
			throw new AppException("vidyo取消单人音频屏蔽失败！");
		}
		return resMap;
	}

	/**
	 * 单人视频屏蔽
	 * 
	 * @param conferenceID（会议室id）
	 * @param participantID（参会人id）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> stopVideo(int conferenceID, int participantID) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalAdminServicePortType servicePort = serverConnection();
		try {
			StopVideoRequest stopVideoRequest = new StopVideoRequest();
			stopVideoRequest.setConferenceID(conferenceID);
			stopVideoRequest.setParticipantID(participantID);

			StopVideoResponse stopVideoResponse = servicePort.stopVideo(stopVideoRequest);
			String OK = stopVideoResponse.getOK();

			resMap.put("OK", OK);
			log.info("vidyo单人视频屏蔽成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("vidyo单人视频屏蔽失败！");
			throw new AppException("vidyo单人视频屏蔽失败！");
		}
		return resMap;
	}

	/**
	 * 取消单人视频屏蔽
	 * 
	 * @param conferenceID（会议室id）
	 * @param participantID（参会人id）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> startVideo(int conferenceID, int participantID) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalAdminServicePortType servicePort = serverConnection();
		try {
			StartVideoRequest startVideoRequest = new StartVideoRequest();
			startVideoRequest.setConferenceID(conferenceID);
			startVideoRequest.setParticipantID(participantID);

			StartVideoResponse startVideoResponse = servicePort.startVideo(startVideoRequest);
			String OK = startVideoResponse.getOK();

			resMap.put("OK", OK);
			log.info("vidyo取消单人视频屏蔽成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("vidyo取消单人视频屏蔽失败！");
			throw new AppException("vidyo取消单人视频屏蔽失败！");
		}
		return resMap;
	}

	/**
	 * 踢人
	 * 
	 * @param conferenceID（会议室id）
	 * @param participantID（参会人id）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> leaveConference(int conferenceID, int participantID) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalAdminServicePortType servicePort = serverConnection();
		try {
			LeaveConferenceRequest leaveConferenceRequest = new LeaveConferenceRequest();
			leaveConferenceRequest.setConferenceID(conferenceID);
			leaveConferenceRequest.setParticipantID(participantID);

			LeaveConferenceResponse leaveConferenceResponse = servicePort.leaveConference(leaveConferenceRequest);
			String OK = leaveConferenceResponse.getOK();

			resMap.put("OK", OK);
			log.info("vidyo踢人成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("vidyo踢人失败！");
			throw new AppException("vidyo踢人失败！");
		}
		return resMap;
	}

	/**
	 * 开启录制
	 * 
	 * @param conferenceID（会议室id）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> startRecording(int conferenceID) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalAdminServicePortType servicePort = serverConnection();
		try {
			// 获取视频清晰度
			// GetRecordingProfilesRequest getRecordingProfilesRequest = new
			// GetRecordingProfilesRequest();
			// GetRecordingProfilesResponse getRecordingProfilesResponse =
			// servicePort
			// .getRecordingProfiles(getRecordingProfilesRequest);
			// String recorderPrefix =
			// getRecordingProfilesResponse.getRecorder().get(1).getRecorderPrefix();

			StartRecordingRequest startRecordingRequest = new StartRecordingRequest();
			startRecordingRequest.setConferenceID(conferenceID);
			startRecordingRequest.setRecorderPrefix("03");// 视频清晰度
			startRecordingRequest.setWebcast(false);

			StartRecordingResponse startRecordingResponse = servicePort.startRecording(startRecordingRequest);
			String OK = startRecordingResponse.getOK();

			resMap.put("OK", OK);
			log.info("vidyo开启录制成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("vidyo开启录制失败！");
			throw new AppException("vidyo开启录制失败！");
		}
		return resMap;
	}

	/**
	 * 停止录制
	 * 
	 * @param conferenceID（会议室id）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> stopRecording(int conferenceID) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalAdminServicePortType servicePort = serverConnection();
		try {
			// 获取录制id（recorderID）
			GetParticipantsRequest getRecordingProfilesRequest = new GetParticipantsRequest();
			getRecordingProfilesRequest.setConferenceID(conferenceID);
			GetParticipantsResponse getParticipantsResponse = servicePort.getParticipants(getRecordingProfilesRequest);
			if (getParticipantsResponse.getRecorderID() != null) {
				JAXBElement<Integer> recorderID = getParticipantsResponse.getRecorderID();

				StopRecordingRequest stopRecordingRequest = new StopRecordingRequest();
				stopRecordingRequest.setConferenceID(conferenceID);
				stopRecordingRequest.setRecorderID(recorderID.getValue());
				StopRecordingResponse stopRecordingResponse = servicePort.stopRecording(stopRecordingRequest);
				String OK = stopRecordingResponse.getOK();

				resMap.put("OK", OK);
				log.info("vidyo停止录制成功！");
			} else {
				log.info("vidyo获取不到录制ID！");
				throw new AppException("vidyo获取不到录制ID！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info("vidyo停止录制失败！");
			throw new AppException("vidyo停止录制失败！");
		}
		return resMap;
	}

	/**
	 * 暂停录制
	 * 
	 * @param conferenceID（会议室id）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> pauseRecording(int conferenceID) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalAdminServicePortType servicePort = serverConnection();
		try {
			// 获取录制id（recorderID）
			GetParticipantsRequest getRecordingProfilesRequest = new GetParticipantsRequest();
			getRecordingProfilesRequest.setConferenceID(conferenceID);
			GetParticipantsResponse getParticipantsResponse = servicePort.getParticipants(getRecordingProfilesRequest);
			if (getParticipantsResponse.getRecorderID() != null) {
				JAXBElement<Integer> recorderID = getParticipantsResponse.getRecorderID();

				PauseRecordingRequest pauseRecordingRequest = new PauseRecordingRequest();
				pauseRecordingRequest.setConferenceID(conferenceID);
				pauseRecordingRequest.setRecorderID(recorderID.getValue());

				PauseRecordingResponse pauseRecordingResponse = servicePort.pauseRecording(pauseRecordingRequest);
				String OK = pauseRecordingResponse.getOK();

				log.info("vidyo暂停录制成功！");
				resMap.put("OK", OK);
			} else {
				log.info("vidyo获取不到录制ID！");
				throw new AppException("vidyo获取不到录制ID！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("vidyo暂停录制失败！");
			throw new AppException("vidyo暂停录制失败！");
		}
		return resMap;
	}

	/**
	 * 继续录制
	 * 
	 * @param conferenceID（会议室id）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> resumeRecording(int conferenceID) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalAdminServicePortType servicePort = serverConnection();
		try {
			// 获取录制id（recorderID）
			GetParticipantsRequest getRecordingProfilesRequest = new GetParticipantsRequest();
			getRecordingProfilesRequest.setConferenceID(conferenceID);
			GetParticipantsResponse getParticipantsResponse = servicePort.getParticipants(getRecordingProfilesRequest);
			if (getParticipantsResponse.getRecorderID() != null) {
				JAXBElement<Integer> recorderID = getParticipantsResponse.getRecorderID();

				ResumeRecordingRequest resumeRecordingRequest = new ResumeRecordingRequest();
				resumeRecordingRequest.setConferenceID(conferenceID);
				resumeRecordingRequest.setRecorderID(recorderID.getValue());

				ResumeRecordingResponse resumeRecordingResponse = servicePort.resumeRecording(resumeRecordingRequest);
				String OK = resumeRecordingResponse.getOK();

				resMap.put("OK", OK);
				log.info("vidyo继续录制成功！");
			} else {
				log.info("vidyo获取不到录制ID！");
				throw new AppException("vidyo获取不到录制ID！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info("vidyo继续录制失败！");
			throw new AppException("vidyo继续录制失败！");
		}
		return resMap;
	}

	/**
	 * 获取房间信息
	 * 
	 * @param conferenceID
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> getParticipant(int conferenceID) throws AppException {
		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalAdminServicePortType servicePort = serverConnection();
		try {
			GetParticipantsRequest getParticipantsRequest = new GetParticipantsRequest();
			getParticipantsRequest.setConferenceID(conferenceID);

			GetParticipantsResponse getParticipantsResponse = servicePort.getParticipants(getParticipantsRequest);
			int count = getParticipantsResponse.getTotal();
			List<Entity> entityList = getParticipantsResponse.getEntity();

			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();

			if (entityList != null && entityList.size() > 0) {
				for (Entity en : entityList) {
					Map<String, Object> dataMap = new HashMap<String, Object>();
					dataMap.put("emp_id", en.getDisplayName());
					dataMap.put("participantID", en.getParticipantID().getValue());
					dataList.add(dataMap);
				}
			}
			resMap.put("data", dataList);
			resMap.put("count", count);
			log.info("vidyo获取房间信息成功！"+count);
		} catch (Exception e) {
			log.info("vidyo获取房间信息失败！");
			throw new AppException("vidyo获取房间信息失败！");
		}
		return resMap;

	}

	public Map<String, Object> getRooms() throws AppException {
		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalAdminServicePortType servicePort = serverConnection();
		try {
			GetRoomsRequest getRoomsRequest = new GetRoomsRequest();
			GetRoomsResponse getRoomsResponse = servicePort.getRooms(getRoomsRequest);

			int total = getRoomsResponse.getTotal();
			int page = 0;
			if (total % 200 != 0) {
				page = total / 200 + 1;
			} else {
				page = total / 200;
			}

			List<Room> roomList = new ArrayList<Room>();

			for (int i = 0; i < page; i++) {
				GetRoomsRequest getRoomsRequest1 = new GetRoomsRequest();
				Filter filter = new Filter();
				JAXBElement<Integer> startJax = new JAXBElement<Integer>(
						new QName("http://portal.vidyo.com/admin/v1_1", "start"), Integer.class, i * 200);
				JAXBElement<Integer> limitJax = new JAXBElement<Integer>(
						new QName("http://portal.vidyo.com/admin/v1_1", "limit"), Integer.class, 200);

				filter.setStart(startJax);
				filter.setLimit(limitJax);
				getRoomsRequest1.setFilter(filter);
				GetRoomsResponse getRoomsResponse1 = servicePort.getRooms(getRoomsRequest1);
				List<Room> list = getRoomsResponse1.getRoom();
				roomList.addAll(list);
			}
			resMap.put("roomList", roomList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;

	}

	public boolean getRoom(int roomId) throws AppException {

		VidyoPortalAdminServicePortType servicePort = serverConnection();
		try {
			GetRoomRequest getRoomRequest = new GetRoomRequest();
			getRoomRequest.setRoomID(roomId);

			GetRoomResponse getRoomResponse = servicePort.getRoom(getRoomRequest);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	/**
	 * 设置密码
	 * 
	 * @param roomId（会议室id）
	 * @param pin（密码）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> createRoomPIN(int roomId, String pin) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalAdminServicePortType servicePort = serverConnection();
		try {
			CreateRoomPINRequest createRoomPINRequest = new CreateRoomPINRequest();
			createRoomPINRequest.setRoomID(roomId);
			createRoomPINRequest.setPIN(pin);

			CreateRoomPINResponse createRoomPINResponse = servicePort.createRoomPIN(createRoomPINRequest);
			String OK = createRoomPINResponse.getOK();

			resMap.put("OK", OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}

	/**
	 * 移除密码
	 * 
	 * @param roomId（会议室id）
	 * @param pin（密码）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> removeRoomPIN(int roomId) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalAdminServicePortType servicePort = serverConnection();
		try {
			RemoveRoomPINRequest removeRoomPINRequest = new RemoveRoomPINRequest();
			removeRoomPINRequest.setRoomID(roomId);

			RemoveRoomPINResponse removeRoomPINResponse = servicePort.removeRoomPIN(removeRoomPINRequest);
			String OK = removeRoomPINResponse.getOK();

			resMap.put("OK", OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}

}
