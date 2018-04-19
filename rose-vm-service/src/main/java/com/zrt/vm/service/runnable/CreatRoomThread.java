package com.zrt.vm.service.runnable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrt.commons.AppException;
import com.zrt.mybatis.domain.VmBusVidyoRoom;
import com.zrt.mybatis.mapper.VmBusVidyoRoomMapper;
import com.zrt.vm.mapper.mtmanage.VmVedioMapper;
import com.zrt.vm.service.serial.SerialService;
import com.zrt.vm.service.vmvif.VmvifService;

@Service
public class CreatRoomThread implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(CreatRoomThread.class);

	@Autowired
	private VmvifService vmvifService;
	@Autowired
	private VmVedioMapper vedioMapper;
	@Autowired
	private SerialService serialService;
	@Autowired
	private VmBusVidyoRoomMapper vmBusVidyoRoomMapper;

	@Override
	public void run() {
		log.info("进入执行预存创建视频房间线程！");
		for (int i = 0; i < 50; i++) {
			// 调用video创建视频会议室房间接口
			Map<String, Object> viodeReqMap = new HashMap<String, Object>();
			List<Map<String, Object>> vedioUserList = vedioMapper.getVedioUserList();// 获取可创建视频房间的视频用户
			Map<String, Object> vedioUserMap = new HashMap<String, Object>();
			if (vedioUserList != null && vedioUserList.size() > 0) {
				for (int j = 0; j < vedioUserList.size(); j++) {
					vedioUserMap = vedioUserList.get(j);
					Map<String, Object> reqRoomMap = new HashMap<String, Object>();
					reqRoomMap.put("auth_name", (String) vedioUserMap.get("auth_name"));
					Map<String, Object> resRoomMap = vedioMapper.getVidvoRoomCount(reqRoomMap);
					long roomCount = (long) resRoomMap.get("roomCount");
					if (roomCount > 4) {
						continue;
					} else {
						break;
					}
				}

			} else {
				try {
					throw new AppException("没有可创建视频房间的用户！");
				} catch (AppException e) {
					e.printStackTrace();
				}
			}
			String authName = (String) vedioUserMap.get("auth_name");
			String authPwd = (String) vedioUserMap.get("auth_pwd");
			String displayName = authName + serialService.getUUID();

			viodeReqMap.put("auth_name", authName);
			viodeReqMap.put("auth_pwd", authPwd);
			viodeReqMap.put("displayName", displayName);
			Map<String, Object> viodeResMap = vmvifService.createPublicRoom(viodeReqMap);
			Integer roomId = (Integer) viodeResMap.get("room_id");
			String roomUrl = (String) viodeResMap.get("room_URL");
			String extension = (String) viodeResMap.get("extension");
			String roomName = displayName;

			VmBusVidyoRoom vmVidyoRoom = new VmBusVidyoRoom();
			vmVidyoRoom.setId(serialService.getUUID());
			vmVidyoRoom.setRoomId(roomId);
			vmVidyoRoom.setRoomUrl(roomUrl);
			vmVidyoRoom.setExtension(extension);
			vmVidyoRoom.setAuthName(authName);
			vmVidyoRoom.setRoomName(roomName);
			vmVidyoRoom.setRoomStatus("0");// 默认未使用
			vmBusVidyoRoomMapper.insert(vmVidyoRoom);
		}

	}

}
