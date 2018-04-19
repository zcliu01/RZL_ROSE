package com.zrt.vm.service.vmmanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zrt.commons.AppException;
import com.zrt.commons.Constant;
import com.zrt.commons.date.DateUtil;
import com.zrt.mybatis.domain.VmBusRecord;
import com.zrt.mybatis.domain.VmBusVidyoRoom;
import com.zrt.mybatis.domain.VmBusVidyoRoomExample;
import com.zrt.mybatis.mapper.VmBusRecordMapper;
import com.zrt.mybatis.mapper.VmBusVidyoRoomMapper;
import com.zrt.vm.service.contacts.ContactsService;
import com.zrt.vm.service.runnable.CreatRoomThread;
import com.zrt.vm.service.vmvif.VmvifService;

@Service
public class VmmanageServiceImpl implements VmmanageService {

	@Value("${vidyo.recordURL}")
	private String recordURL;
	@Autowired
	private VmvifService vmvifService;
	@Autowired
	private VmBusRecordMapper vmBusRecordMapper;
	@Autowired
	private ContactsService contactsService;
	@Autowired
	private VmBusVidyoRoomMapper vmBusVidyoRoomMapper;
	@Autowired
	private CreatRoomThread creatRoomThread;

	@Value("${im.appId}")
	private String imAppId;

	/**
	 * IM消息推送参数拼接
	 * 
	 * @param empId
	 * @param receiver
	 * @param msgDomain
	 * @return
	 */
	public Map<String, Object> getPushMsg(String empId, String[] receiver, String msgDomain) {

		Map<String, Object> imReqMap = new HashMap<String, Object>();
		imReqMap.put("pushType", "1");// 1:个人
		imReqMap.put("appId", imAppId);
		imReqMap.put("sender", empId);
		imReqMap.put("receiver", receiver);
		imReqMap.put("msgType", "1");// 1：文本消息
		imReqMap.put("msgContent", "");
		imReqMap.put("msgDomain", "customtype=200," + msgDomain);

		return imReqMap;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getMtPersonList(Map<String, Object> map) throws AppException {

		String recordId = (String) map.get("record_id");
		String recEmpName = (String) map.get("rec_emp_name");
		String orgName = (String) map.get("org_name");

		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);
		Integer roomId = vmBusRecord.getRoomId();

		Map<String, Object> lineReqMap = new HashMap<String, Object>();
		lineReqMap.put("room_id", roomId);
		// 调用video的获取视频房间在线人数接口
		boolean result = (boolean) vmvifService.linePerson(lineReqMap).get("result");
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (result) {
			Map<String, Object> viodeResMap = (Map<String, Object>) vmvifService.linePerson(lineReqMap).get("data");

			if (!viodeResMap.isEmpty() && null != viodeResMap) {
				List<Map<String, Object>> dataList = (List<Map<String, Object>>) viodeResMap.get("data");
				List<String> empIdList = new ArrayList<String>();
				if (dataList != null && dataList.size() > 0) {
					for (Map<String, Object> dataMap : dataList) {
						empIdList.add((String) dataMap.get("emp_id"));
					}

				}

				// 调用组织通讯录接口
				Map<String, Object> empReqMap = new HashMap<String, Object>();
				if (empIdList != null && empIdList.size() > 0) {
					empReqMap.put("emp_ids", empIdList);
				}
				if (StringUtils.isNotBlank(recEmpName)) {
					empReqMap.put("rec_emp_name", recEmpName);
				}
				if (StringUtils.isNotBlank(recEmpName)) {
					empReqMap.put("org_name", orgName);
				}
				Map<String, Object> empResMap = new HashMap<String, Object>();
				empResMap = contactsService.meetEmpInfo(empReqMap);

				String videoFlag = vmBusRecord.getVideoFlag();
				String videoStatus = vmBusRecord.getVideoStatus();

				resMap = (Map<String, Object>) empResMap.get("data");
				if (null != resMap) {
					if (!resMap.isEmpty()) {
						resMap.put("video_flag", videoFlag);
						resMap.put("video_status", videoStatus);
					}

				}

			}
		}

		return resMap;
	}

	@Override
	public void mtControl(Map<String, Object> map) throws AppException {

		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}

		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);

		String empId = (String) map.get("emp_id");
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");

		String[] receiver = new String[1];
		String member = "";
		if (list != null && list.size() > 0) {
			receiver = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				receiver[i] = (String) list.get(i).get("rec_emp_id");
				member += (String) list.get(i).get("rec_emp_id") + ",";
			}
		}

		String action = (String) map.get("action");
		String vidyoMsgType = "";// 6打开静音；7关闭静音；8结束会议；10踢人
		if ("muteAudio".equals(action)) {
			vidyoMsgType = "6";
		} else if ("unmuteAudio".equals(action)) {
			vidyoMsgType = "7";
		} else if ("disconnectConferenceAll".equals(action)) {
			vidyoMsgType = "8";
			receiver[0] = vmBusRecord.getHostEmpId();
			member = vmBusRecord.getHostEmpId();
		} else if ("leaveConference".equals(action)) {
			vidyoMsgType = "10";
		}

		Map<String, Object> msgMap = new HashMap<String, Object>();
		msgMap.put("vidyoMsgType", vidyoMsgType);
		msgMap.put("roomUrl", Constant.IM_ROOM_URL);
		int keyIndex = vmBusRecord.getRoomUrl().lastIndexOf("=");

		msgMap.put("roomId", vmBusRecord.getRoomUrl().substring(keyIndex + 1, vmBusRecord.getRoomUrl().length()));
		msgMap.put("member", member);
		JSONObject msgDomainJSON = JSONObject.parseObject(JSON.toJSONString(msgMap));

		Map<String, Object> reqmap = getPushMsg(empId, receiver, msgDomainJSON.toString());
		vmvifService.pushMsg(reqmap);
	}

	@Override
	public void muteAudio(Map<String, Object> map) throws AppException {

		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);

		Map<String, Object> reqmap = new HashMap<String, Object>();
		reqmap.put("room_id", vmBusRecord.getRoomId());
		reqmap.put("rec_emp_id", (String) map.get("rec_emp_id"));
		reqmap.put("action_flag", "mute");// mute:屏蔽
		vmvifService.audioSingleControl(reqmap);
	}

	@Override
	public void unmuteAudio(Map<String, Object> map) throws AppException {
		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);

		Map<String, Object> reqmap = new HashMap<String, Object>();
		reqmap.put("room_id", vmBusRecord.getRoomId());
		reqmap.put("rec_emp_id", (String) map.get("rec_emp_id"));
		reqmap.put("action_flag", "unmute");// unmute:取消屏蔽
		vmvifService.audioSingleControl(reqmap);

	}

	@Override
	public void muteAudioServerAll(Map<String, Object> map) throws AppException {
		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);
		Map<String, Object> reqmap = new HashMap<String, Object>();
		reqmap.put("room_id", vmBusRecord.getRoomId());
		reqmap.put("mute_state", (String) map.get("muteState"));// true:全部屏蔽false:取消屏蔽
		vmvifService.muteAudioServerAll(reqmap);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void stopVideo(Map<String, Object> map) throws AppException {

		String recordId = (String) map.get("record_id");

		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);

		Map<String, Object> reqmap = new HashMap<String, Object>();
		reqmap.put("room_id", vmBusRecord.getRoomId());
		// 调用video的获取视频房间在线人数接口
		Map<String, Object> lineReqMap = new HashMap<String, Object>();
		lineReqMap.put("room_id", vmBusRecord.getRoomId());
		boolean result = (boolean) vmvifService.linePerson(lineReqMap).get("result");
		if (result) {
			Map<String, Object> viodeResMap = (Map<String, Object>) vmvifService.linePerson(lineReqMap).get("data");
			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			if (!viodeResMap.isEmpty()) {
				dataList = (List<Map<String, Object>>) viodeResMap.get("data");
			}
			List<Map<String, Object>> emplist = (List<Map<String, Object>>) map.get("param");
			if (emplist != null && emplist.size() > 0) {
				for (int i = 0; i < emplist.size(); i++) {
					for (Map<String, Object> dataMap : dataList) {
						if (emplist.get(i).get("rec_emp_id").equals(dataMap.get("emp_id"))) {
							reqmap.put("participantID", dataMap.get("participantID"));
							reqmap.put("action_flag", "stop");// stop:屏蔽
							vmvifService.videoSingleControl(reqmap);
						}
					}

				}
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void startVideo(Map<String, Object> map) throws AppException {

		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);

		Map<String, Object> reqmap = new HashMap<String, Object>();
		reqmap.put("room_id", vmBusRecord.getRoomId());

		// 调用video的获取视频房间在线人数接口
		Map<String, Object> lineReqMap = new HashMap<String, Object>();
		lineReqMap.put("room_id", vmBusRecord.getRoomId());
		boolean result = (boolean) vmvifService.linePerson(lineReqMap).get("result");
		if (result) {
			Map<String, Object> viodeResMap = (Map<String, Object>) vmvifService.linePerson(lineReqMap).get("data");
			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			if (!viodeResMap.isEmpty()) {
				dataList = (List<Map<String, Object>>) viodeResMap.get("data");
			}
			List<Map<String, Object>> emplist = (List<Map<String, Object>>) map.get("param");
			if (emplist != null && emplist.size() > 0) {
				for (int i = 0; i < emplist.size(); i++) {
					for (Map<String, Object> dataMap : dataList) {
						if (emplist.get(i).get("rec_emp_id").equals(dataMap.get("emp_id"))) {
							reqmap.put("participantID", dataMap.get("participantID"));
							reqmap.put("action_flag", "start");// stop:屏蔽
							vmvifService.videoSingleControl(reqmap);
						}
					}

				}
			}
		}
	}

	@Override
	public void muteVideoServerAll(Map<String, Object> map) throws AppException {
		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);
		Map<String, Object> reqmap = new HashMap<String, Object>();
		reqmap.put("room_id", vmBusRecord.getRoomId());
		reqmap.put("mute_state", (String) map.get("muteState"));// true:全部屏蔽false:取消全部屏蔽
		vmvifService.muteVideoServerAll(reqmap);

	}

	@Override
	public void leaveConference(Map<String, Object> map) throws AppException {
		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);
		Map<String, Object> reqmap = new HashMap<String, Object>();
		reqmap.put("room_id", vmBusRecord.getRoomId());
		reqmap.put("rec_emp_id", (String) map.get("rec_emp_id"));
		vmvifService.leaveConference(reqmap);

	}

	@Override
	public void lockRoom(Map<String, Object> map) throws AppException {
		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);
		Map<String, Object> reqmap = new HashMap<String, Object>();
		reqmap.put("room_id", vmBusRecord.getRoomId());
		reqmap.put("action_flag", "lock");
		vmvifService.lockRoomControl(reqmap);
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void unlockRoom(Map<String, Object> map) throws AppException {
		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);
		Map<String, Object> reqmap = new HashMap<String, Object>();
		reqmap.put("room_id", vmBusRecord.getRoomId());
		reqmap.put("action_flag", "unlock");
		vmvifService.lockRoomControl(reqmap);
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void disconnectConferenceAll(Map<String, Object> map) throws AppException {
		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);

		// 调用结束会议接口前要先停止录制视频、踢人、最后还要删除视频房间
		// Map<String, Object> recordReqMap = new HashMap<String, Object>();
		// recordReqMap.put("room_id", vmBusRecord.getRoomId());
		// recordReqMap.put("video_flag", "3");// 3:停止录制
		// vmvifService.recordsSearch(recordReqMap);

		// Map<String, Object> recEmpMap = new HashMap<String, Object>();
		// recEmpMap.put("record_id", recordId);
		// List<Map<String, Object>> recEmpList =
		// vedioMapper.getParRevEmpIds(recEmpMap);// 获取实时参会人id
		// if (recEmpList != null && recEmpList.size() > 0) {
		// for (Map<String, Object> recEmpIdMap : recEmpList) {
		// Map<String, Object> trReqMap = new HashMap<String, Object>();
		// trReqMap.put("room_id", vmBusRecord.getRoomId());
		// trReqMap.put("rec_emp_id", recEmpIdMap.get("rec_emp_id"));
		// vmvifService.leaveConference(trReqMap);// 踢人
		// // 踢人后修改踢出人参会结束时间
		// VmBusPartinExample partinExample = new VmBusPartinExample();
		// partinExample.createCriteria().andRecordIdEqualTo(recordId)
		// .andRecEmpIdEqualTo((String) recEmpIdMap.get("rec_emp_id"));
		// VmBusPartin vmBusPartin =
		// vmBusPartinMapper.selectByExample(partinExample).get(0);
		// vmBusPartin.setEndDateTime(DateUtil.getCurrentDateTime());
		// vmBusPartinMapper.updateByPrimaryKeySelective(vmBusPartin);
		// // 踢人后会议实时表删除记录
		// VmBusPersonExample example = new VmBusPersonExample();
		// example.createCriteria().andRecordIdEqualTo(recordId)
		// .andRecEmpIdEqualTo((String) recEmpIdMap.get("rec_emp_id"));
		// vmBusPersonMapper.deleteByExample(example);
		// }
		// }

		// 先停止录制再调用video的获取视频录制URL接口
		if ("1".equals(vmBusRecord.getMtType())) {
			// 停止录制
			Map<String, Object> stopRecordReqMap = new HashMap<String, Object>();
			stopRecordReqMap.put("video_flag", "3");
			stopRecordReqMap.put("room_id", vmBusRecord.getRoomId());
			vmvifService.recordControl(stopRecordReqMap);
			vmBusRecord.setVideoStatus("3");// 3:录播结束

			// 获取URL
			Map<String, Object> urlReqMap = new HashMap<String, Object>();
			urlReqMap.put("ownerName", vmBusRecord.getAuthName());
			urlReqMap.put("roomName", vmBusRecord.getRoomName());
			Map<String, Object> urlResMap = vmvifService.recordsSearch(urlReqMap);
			String guid = (String) urlResMap.get("guid");
			String vidyoURL = recordURL + guid + ".flv";
			vmBusRecord.setVideoUrl(vidyoURL);
		}

		Map<String, Object> reqmap = new HashMap<String, Object>();
		reqmap.put("room_id", vmBusRecord.getRoomId());
		vmvifService.disconnectConferenceAll(reqmap);// 结束会议

		Map<String, Object> delReqMap = new HashMap<String, Object>();
		delReqMap.put("room_id", vmBusRecord.getRoomId());
		vmvifService.deleteRoom(delReqMap);// 删除视频房间
		// 删除预存视频房间表的记录
		VmBusVidyoRoomExample example = new VmBusVidyoRoomExample();
		example.createCriteria().andRoomIdEqualTo(vmBusRecord.getRoomId());
		List<VmBusVidyoRoom> vidyoRoomList = vmBusVidyoRoomMapper.selectByExample(example);
		if (vidyoRoomList != null && vidyoRoomList.size() > 0) {
			vmBusVidyoRoomMapper.deleteByExample(example);

			VmBusVidyoRoomExample example1 = new VmBusVidyoRoomExample();
			example1.createCriteria().andRoomStatusEqualTo("0");
			List<VmBusVidyoRoom> vidyoRoomList1 = vmBusVidyoRoomMapper.selectByExample(example1);
			if (vidyoRoomList1.size() < 50) {
				// 启动创建视频房间线程创建房间
				Thread t = new Thread(creatRoomThread);
				t.start();
			}
		}

		vmBusRecord.setRealEndDateTime(DateUtil.getCurrentDateTime());
		vmBusRecord.setMtStatus("2");// 2:会议已结束

		vmBusRecordMapper.updateByPrimaryKeySelective(vmBusRecord);// 修改会议记录表

	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void recordControl(Map<String, Object> map) throws AppException {
		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);
		Map<String, Object> reqmap = new HashMap<String, Object>();
		reqmap.put("room_id", vmBusRecord.getRoomId());

		String videoStatus = (String) map.get("video_status");
		if ("1".equals(videoStatus)) {// 继续录制
			reqmap.put("video_flag", "1");
			vmvifService.recordControl(reqmap);
			vmBusRecord.setVideoStatus("1");
			vmBusRecordMapper.updateByPrimaryKeySelective(vmBusRecord);
		} else if ("2".equals(videoStatus)) {// 暂停录制
			reqmap.put("video_flag", "0");
			vmvifService.recordControl(reqmap);
			vmBusRecord.setVideoStatus("2");
			vmBusRecordMapper.updateByPrimaryKeySelective(vmBusRecord);
		} else if ("3".equals(videoStatus)) {// 开启录制
			reqmap.put("video_flag", "2");
			vmvifService.recordControl(reqmap);
			vmBusRecord.setVideoStatus("1");
			vmBusRecord.setVideoFlag("1");

			// // 调用video的获取视频录制URL接口
			// Map<String, Object> urlReqMap = new HashMap<String, Object>();
			// urlReqMap.put("ownerName", vmBusRecord.getAuthName());
			// urlReqMap.put("roomName", vmBusRecord.getRoomName());
			// Map<String, Object> urlResMap =
			// vmvifService.recordsSearch(urlReqMap);
			// String videoUrl = (String) urlResMap.get("externalPlaybackLink");
			// vmBusRecord.setVideoUrl(videoUrl);
			vmBusRecordMapper.updateByPrimaryKeySelective(vmBusRecord);
		}

	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void recAdd(Map<String, Object> map) throws AppException {
		String empId = (String) map.get("emp_id");
		String recordId = (String) map.get("record_id");
		String recEmpIds = (String) map.get("rec_emp_ids");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);
		String[] receiver = recEmpIds.split(";");

		Map<String, Object> msgMap = new HashMap<String, Object>();
		msgMap.put("vidyoMsgType", "1");
		msgMap.put("roomUrl", Constant.IM_ROOM_URL);
		String roomKey = vmBusRecord.getRoomUrl().substring(vmBusRecord.getRoomUrl().lastIndexOf("=") + 1,
				vmBusRecord.getRoomUrl().length());

		msgMap.put("roomId", roomKey);
		String member = "";
		for (String re : receiver) {
			member += re + ",";
		}
		msgMap.put("member", member);
		JSONObject msgDomainJSON = JSONObject.parseObject(JSON.toJSONString(msgMap));

		Map<String, Object> reqmap = getPushMsg(empId, receiver, msgDomainJSON.toString());
		vmvifService.pushMsg(reqmap);

	}

}
