package com.zrt.vm.service.vmvif;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zrt.client.vmvif.VmvifClient;
import com.zrt.vm.service.serial.SerialService;

@Service
public class VmvifServiceImpl implements VmvifService {
	private final transient Logger logger = LoggerFactory.getLogger(SerialService.class);

	@Resource(name = "HystrixVmvifClient")
	private VmvifClient vmvifClient;

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> createPublicRoom(Map<String, Object> map) {
		logger.info("调用vmvif服务createPublicRoom方法");
		Map<String, Object> result = vmvifClient.createPublicRoom(map);
		if (result != null) {
			return (Map<String, Object>) result.get("data");
		}
		return null;
	}

	@Override
	public Map<String, Object> deleteRoom(Map<String, Object> map) {
		logger.info("调用vmvif服务deleteRoom方法");
		Map<String, Object> result = vmvifClient.deleteRoom(map);
		return result;
	}

	@Override
	public Map<String, Object> audioSingleControl(Map<String, Object> map) {
		logger.info("调用vmvif服务audioSingleControl方法");
		Map<String, Object> result = vmvifClient.audioSingleControl(map);
		return result;
	}

	@Override
	public Map<String, Object> muteAudioServerAll(Map<String, Object> map) {
		logger.info("调用vmvif服务muteAudioServerAll方法");
		Map<String, Object> result = vmvifClient.muteAudioServerAll(map);
		return result;
	}

	@Override
	public Map<String, Object> videoSingleControl(Map<String, Object> map) {
		logger.info("调用vmvif服务videoSingleControl方法");
		Map<String, Object> result = vmvifClient.videoSingleControl(map);
		return result;
	}

	@Override
	public Map<String, Object> muteVideoServerAll(Map<String, Object> map) {
		logger.info("调用vmvif服务muteVideoServerAll方法");
		Map<String, Object> result = vmvifClient.muteVideoServerAll(map);
		return result;
	}

	@Override
	public Map<String, Object> createRoomPIN(Map<String, Object> map) {
		logger.info("调用vmvif服务createRoomPIN方法");
		Map<String, Object> result = vmvifClient.createRoomPIN(map);
		return result;
	}

	@Override
	public Map<String, Object> removeRoomPIN(Map<String, Object> map) {
		logger.info("调用vmvif服务removeRoomPIN方法");
		Map<String, Object> result = vmvifClient.removeRoomPIN(map);
		return result;
	}

	@Override
	public Map<String, Object> leaveConference(Map<String, Object> map) {
		logger.info("调用vmvif服务leaveConference方法");
		Map<String, Object> result = vmvifClient.leaveConference(map);
		return result;
	}

	@Override
	public Map<String, Object> lockRoomControl(Map<String, Object> map) {
		logger.info("调用vmvif服务lockRoomControl方法");
		Map<String, Object> result = vmvifClient.lockRoomControl(map);
		return result;
	}

	@Override
	public Map<String, Object> disconnectConferenceAll(Map<String, Object> map) {
		logger.info("调用vmvif服务disconnectConferenceAll方法");
		Map<String, Object> result = vmvifClient.disconnectConferenceAll(map);
		return result;
	}

	@Override
	public Map<String, Object> recordControl(Map<String, Object> map) {
		logger.info("调用vmvif服务recordControl方法");
		Map<String, Object> result = vmvifClient.recordControl(map);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> recordsSearch(Map<String, Object> map) {
		logger.info("调用vmvif服务recordsSearch方法");
		Map<String, Object> result = (Map<String, Object>) vmvifClient.recordsSearch(map);
		if (result != null) {
			return (Map<String, Object>) result.get("data");
		}
		return null;
	}

	@Override
	public Map<String, Object> pushMsg(Map<String, Object> map) {
		logger.info("调用vmvif服务pushMsg方法");
		Map<String, Object> result = vmvifClient.pushMsg(map);
		return result;
	}

	@Override
	public Map<String, Object> linePerson(Map<String, Object> map) {
		logger.info("调用vmvif服务linePerson方法");
		Map<String, Object> result = vmvifClient.linePerson(map);
		return result;
	}

	@Override
	public Map<String, Object> getRooms() {
		logger.info("调用vmvif服务getRooms方法");
		Map<String, Object> result = vmvifClient.getRooms();
		return result;
	}

}
