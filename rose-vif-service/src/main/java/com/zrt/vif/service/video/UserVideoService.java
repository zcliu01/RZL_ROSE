package com.zrt.vif.service.video;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zrt.commons.AppException;
import com.zrt.portal.user.DisconnectConferenceAllRequest;
import com.zrt.portal.user.DisconnectConferenceAllResponse;
import com.zrt.portal.user.LockRoomRequest;
import com.zrt.portal.user.LockRoomResponse;
import com.zrt.portal.user.MuteAudioServerAllRequest;
import com.zrt.portal.user.MuteAudioServerAllResponse;
import com.zrt.portal.user.MuteVideoServerAllRequest;
import com.zrt.portal.user.MuteVideoServerAllResponse;
import com.zrt.portal.user.UnlockRoomRequest;
import com.zrt.portal.user.UnlockRoomResponse;
import com.zrt.portal.user.VidyoPortalUserService;
import com.zrt.portal.user.VidyoPortalUserServicePortType;

@Service
public class UserVideoService {

	private static final Logger log = LoggerFactory.getLogger(UserVideoService.class);

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
	public VidyoPortalUserServicePortType serverConnection() throws AppException {
		String userAddress = adminURL + "/services/v1_1/VidyoPortalUserService";

		final String WS_URL = adminURL + "/services/v1_1/VidyoPortalUserService?wsdl";
		VidyoPortalUserServicePortType servicePort = null;
		try {
			URL url = new URL(WS_URL);
			QName qname = new QName("http://portal.vidyo.com/user/v1_1", "VidyoPortalUserService");

			VidyoPortalUserService userService = new VidyoPortalUserService(url, qname);
			servicePort = userService.getPort(VidyoPortalUserServicePortType.class);

			BindingProvider bp = (BindingProvider) servicePort;// 用户认证
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, userAddress);
			bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, adminNo);
			bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, adminPassword);

		} catch (MalformedURLException e) {
			e.printStackTrace();
			log.info("vidyo服务user连接失败！");
			throw new AppException("vidyo服务user连接失败！");
		}
		return servicePort;
	}

	/**
	 * 屏蔽/开启全部音频
	 * 
	 * @param conferenceID（会议室id）
	 * @param muteState（true屏蔽；false开启）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> muteAudioServerAll(String conferenceID, boolean muteState) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalUserServicePortType servicePort = serverConnection();
		try {
			MuteAudioServerAllRequest muteAudioServerAllRequest = new MuteAudioServerAllRequest();
			muteAudioServerAllRequest.setConferenceID(conferenceID);
			muteAudioServerAllRequest.setMuteState(muteState);

			MuteAudioServerAllResponse muteAudioServerAllResponse = servicePort
					.muteAudioServerAll(muteAudioServerAllRequest);
			String OK = muteAudioServerAllResponse.getOK();

			resMap.put("OK", OK);
			log.info("vidyo屏蔽/开启全部音频成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("vidyo屏蔽/开启全部音频失败！");
			throw new AppException("vidyo屏蔽/开启全部音频失败！");
		}
		return resMap;
	}

	/**
	 * 屏蔽/开启全部视频
	 * 
	 * @param conferenceID（会议室id）
	 * @param muteState（true屏蔽；false开启）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> muteVideoServerAll(String conferenceID, boolean muteState) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalUserServicePortType servicePort = serverConnection();
		try {
			MuteVideoServerAllRequest muteVideoServerAllRequest = new MuteVideoServerAllRequest();
			muteVideoServerAllRequest.setConferenceID(conferenceID);
			muteVideoServerAllRequest.setMuteState(muteState);

			MuteVideoServerAllResponse muteVideoServerAllResponse = servicePort
					.muteVideoServerAll(muteVideoServerAllRequest);
			String OK = muteVideoServerAllResponse.getOK();

			resMap.put("OK", OK);
			log.info("vidyo屏蔽/开启全部视频成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("vidyo屏蔽/开启全部视频失败！");
			throw new AppException("vidyo屏蔽/开启全部视频失败！");
		}
		return resMap;
	}

	/**
	 * 房间加锁
	 * 
	 * @param roomId（会议室id）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> lockRoom(String roomId) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalUserServicePortType servicePort = serverConnection();
		try {
			LockRoomRequest lockRoomRequest = new LockRoomRequest();
			lockRoomRequest.setRoomID(roomId);

			LockRoomResponse LockRoomResponse = servicePort.lockRoom(lockRoomRequest);
			String OK = LockRoomResponse.getOK();

			resMap.put("OK", OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}

	/**
	 * 移除房间锁
	 * 
	 * @param roomId（会议室id）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> unlockRoom(String roomId) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalUserServicePortType servicePort = serverConnection();
		try {
			UnlockRoomRequest unlockRoomRequest = new UnlockRoomRequest();
			unlockRoomRequest.setRoomID(roomId);

			UnlockRoomResponse unLockRoomResponse = servicePort.unlockRoom(unlockRoomRequest);
			String OK = unLockRoomResponse.getOK();

			resMap.put("OK", OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}

	/**
	 * 结束会议
	 * 
	 * @param conferenceID（会议室id）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> disconnectConferenceAll(String conferenceID) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoPortalUserServicePortType servicePort = serverConnection();
		try {
			DisconnectConferenceAllRequest disconnectConferenceAllRequest = new DisconnectConferenceAllRequest();
			disconnectConferenceAllRequest.setConferenceID(conferenceID);

			DisconnectConferenceAllResponse disconnectConferenceAllResponse = servicePort
					.disconnectConferenceAll(disconnectConferenceAllRequest);
			String OK = disconnectConferenceAllResponse.getOK();

			resMap.put("OK", OK);
			log.info("vidyo结束会议成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("vidyo结束会议失败！");
			throw new AppException("vidyo结束会议失败！");
		}
		return resMap;
	}

}
