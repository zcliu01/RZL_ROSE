package com.zrt.vm.service.appVmoper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.zrt.commons.utils.SeclectVidyoRoom;
import com.zrt.mybatis.domain.VmBusPartin;
import com.zrt.mybatis.domain.VmBusPartinExample;
import com.zrt.mybatis.domain.VmBusPerson;
import com.zrt.mybatis.domain.VmBusRecord;
import com.zrt.mybatis.domain.VmBusVidyoRoom;
import com.zrt.mybatis.domain.VmBusVidyoRoomExample;
import com.zrt.mybatis.mapper.VmBusPartinMapper;
import com.zrt.mybatis.mapper.VmBusPersonMapper;
import com.zrt.mybatis.mapper.VmBusRecordMapper;
import com.zrt.mybatis.mapper.VmBusVidyoRoomMapper;
import com.zrt.vm.mapper.mtmanage.VmVedioMapper;
import com.zrt.vm.service.contacts.ContactsService;
import com.zrt.vm.service.runnable.CreatRoomThread;
import com.zrt.vm.service.serial.SerialService;
import com.zrt.vm.service.vmvif.VmvifService;

@Service
public class AppVmOperServiceImpl implements AppVmOperService {

	private static final Logger log = LoggerFactory.getLogger(AppVmOperServiceImpl.class);
	@Value("${im.appId}")
	private String imAppId;
	@Value("${vidyo.recordURL}")
	private String recordURL;
	@Autowired
	private VmBusRecordMapper vmBusRecordMapper;
	@Autowired
	private VmBusPartinMapper vmBusPartinMapper;
	@Autowired
	private VmBusPersonMapper vmBusPersonMapper;
	@Autowired
	private VmvifService vmvifService;
	@Autowired
	private ContactsService contactsService;
	@Autowired
	private SerialService serialService;
	@Autowired
	private VmVedioMapper vedioMapper;
	@Autowired
	private VmBusVidyoRoomMapper vmBusVidyoRoomMapper;
	@Autowired
	private CreatRoomThread creatRoomThread;
	@Autowired
	private SeclectVidyoRoom seclectVidyoRoom;

	/**
	 * 根据员工ID获取员工的相关信息
	 */
	public Map<String, Object> searchEmpMapByEmpId(String empId) {
		// 获取当前登录用户的信息
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("type", "0");
		resMap.put("search", empId);
		Map<String, Object> dataMap = contactsService.commonEmpSearch(resMap);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> empList = (List<Map<String, Object>>) dataMap.get("data");
		if (empList != null && empList.size() > 0) {
			Map<String, Object> empMap = empList.get(0);
			return empMap;
		} else {
			return null;
		}

	}

	/**
	 * 发起即时会议
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> appLaunch(Map<String, Object> map) throws AppException {

		// 获取当前登录用户的信息
		String curEmpId = (String) map.get("emp_id");// 当前登录人id
		Map<String, Object> empMap = searchEmpMapByEmpId(curEmpId);
		String curEmpName = (String) empMap.get("emp_name");
		String recEmpIds = (String) map.get("rec_emp_ids");// 接收人

		// 会议表添加记录
		VmBusRecord vmBusRecord = new VmBusRecord();
		String recordId = serialService.getUUID();
		vmBusRecord.setId(recordId);
		vmBusRecord.setMtTitile(curEmpId + "即时会议");
		vmBusRecord.setCreateEmpId(curEmpId);
		vmBusRecord.setCreateEmpName(curEmpName);
		vmBusRecord.setOrgId((String) empMap.get("org_id"));
		vmBusRecord.setOrgName((String) empMap.get("org_name_owner"));
		vmBusRecord.setMtStatus("0");// 会议状态（0：未开启；1：进行中；2：已结束）
		vmBusRecord.setHostEmpId(curEmpId);
		vmBusRecord.setHostEmpName(curEmpName);
		vmBusRecord.setHostOrgId((String) empMap.get("org_id"));
		vmBusRecord.setHostOrgName((String) empMap.get("org_name_owner"));
		vmBusRecord.setCreateDateTime(DateUtil.getCurrentDateTime());
		vmBusRecord.setBeginDateTime(DateUtil.getCurrentDateTime());
		vmBusRecord.setMtType((String) map.get("mt_type"));// 会议类型(1:预订,2:即时多人,3:点对点)

		// 参会人员表添加记录
		String recPartinEmpIds = "";
		if (recEmpIds.endsWith(";")) {
			recPartinEmpIds = recEmpIds + curEmpId;// 发起人+接收人
		} else {
			recPartinEmpIds = recEmpIds + ";" + curEmpId;// 发起人+接收人
		}

		String[] recPartinEmpIdArr = recPartinEmpIds.split(";");
		if (recPartinEmpIdArr.length > 0) {
			for (String recEmpId : recPartinEmpIdArr) {
				// 查询参会人员的信息
				Map<String, Object> recEmpMap = searchEmpMapByEmpId(recEmpId);
				// 新建参会人员信息表
				VmBusPartin vmBusPartin = new VmBusPartin();
				vmBusPartin.setId(serialService.getUUID());
				vmBusPartin.setRecordId(recordId);
				vmBusPartin.setRecEmpId(recEmpId);
				vmBusPartin.setRecEmpName((String) recEmpMap.get("emp_name"));
				vmBusPartin.setOrgId((String) recEmpMap.get("org_id"));
				vmBusPartin.setOrgName((String) recEmpMap.get("org_name_owner"));
				vmBusPartin.setMtStatus("0");// 参与状态：未参加
				vmBusPartin.setRecType("0");// 设置参与者类型:普通
				vmBusPartinMapper.insertSelective(vmBusPartin);
			}
		}

		VmBusVidyoRoom vmVidyoRoom = seclectVidyoRoom.seclectVidyoRoom();// 从提前创建的视频房间中拿数据
		Integer roomId = 0;
		String roomUrl = "";
		String extension = "";
		String authName = "";
		String roomName = "";
		if (null == vmVidyoRoom) {
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
				throw new AppException("没有可创建视频房间的用户！");
			}
			authName = (String) vedioUserMap.get("auth_name");
			String authPwd = (String) vedioUserMap.get("auth_pwd");
			String displayName = authName + serialService.getUUID();
			viodeReqMap.put("auth_name", authName);
			viodeReqMap.put("auth_pwd", authPwd);
			viodeReqMap.put("displayName", displayName);
			Map<String, Object> viodeResMap = vmvifService.createPublicRoom(viodeReqMap);
			roomId = (Integer) viodeResMap.get("room_id");
			roomUrl = (String) viodeResMap.get("room_URL");
			extension = (String) viodeResMap.get("extension");
			roomName = displayName;

			// 启动创建视频房间线程创建房间
			Thread t = new Thread(creatRoomThread);
			t.start();
		} else {
			roomId = vmVidyoRoom.getRoomId();
			roomUrl = vmVidyoRoom.getRoomUrl();
			extension = vmVidyoRoom.getExtension();
			authName = vmVidyoRoom.getAuthName();
			roomName = vmVidyoRoom.getRoomName();

			vmVidyoRoom.setRoomStatus("1");// 已经使用
			VmBusVidyoRoomExample example = new VmBusVidyoRoomExample();
			example.createCriteria().andRoomIdEqualTo(roomId);
			vmBusVidyoRoomMapper.updateByExample(vmVidyoRoom, example);
		}

		vmBusRecord.setRoomName(roomName);
		vmBusRecord.setAuthName(authName);
		vmBusRecord.setRoomId(roomId);
		vmBusRecord.setRoomUrl(roomUrl);
		vmBusRecord.setExtension(extension);
		String roomKey = roomUrl.substring(roomUrl.lastIndexOf("=") + 1, roomUrl.length());
		vmBusRecord.setMtStatus("1");// 1:会议进行中
		vmBusRecord.setRealBeginDateTime(DateUtil.getCurrentDateTime());
		vmBusRecordMapper.insertSelective(vmBusRecord);

		// 给接收人通过IM发送视频信息消息
		if (recPartinEmpIdArr.length > 2) {
			Map<String, Object> imReqMap = new HashMap<String, Object>();
			imReqMap.put("pushType", "1");// 1:个人
			imReqMap.put("appId", imAppId);
			imReqMap.put("sender", curEmpId);
			imReqMap.put("receiver", recEmpIds.split(";"));
			imReqMap.put("msgType", "1");// 1：文本消息
			imReqMap.put("msgContent", "你被" + (String) empMap.get("emp_name") + "邀请多人视频聊天！点" + roomUrl + "进入");

			Map<String, Object> msgMap = new HashMap<String, Object>();
			msgMap.put("oa_type", "0");
			msgMap.put("recordId", recordId);
			msgMap.put("roomUrl", Constant.IM_ROOM_URL);
			msgMap.put("roomKey", roomKey);
			msgMap.put("member", recEmpIds.replaceAll(";", ","));
			JSONObject msgDomainJSON = JSONObject.parseObject(JSON.toJSONString(msgMap));
			imReqMap.put("msgDomain", msgDomainJSON.toJSONString());
			vmvifService.pushMsg(imReqMap);
		}

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("record_id", recordId);
		resMap.put("room_url", Constant.IM_ROOM_URL);
		resMap.put("room_key", roomKey);

		return resMap;
	}

	/**
	 * 响应通知
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void getIsJoin(Map<String, Object> map) throws AppException {

		String recordId = (String) map.get("record_id");
		String mtFlag = (String) map.get("mt_flag");// 是否加入（0加入；1未加入）
		String deviceType = (String) map.get("device_type");

		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		// VmBusRecord vmBusRecord =
		// vmBusRecordMapper.selectByPrimaryKey(recordId);

		// 参会人员表修改状态
		VmBusPartinExample example = new VmBusPartinExample();
		example.createCriteria().andRecordIdEqualTo(recordId).andRecEmpIdEqualTo((String) map.get("emp_id"));
		List<VmBusPartin> vmBusPartinList = vmBusPartinMapper.selectByExample(example);
		VmBusPartin vmBusPartin = new VmBusPartin();
		if (vmBusPartinList != null && vmBusPartinList.size() > 0) {// 判断是否是中途加入的;小于0表示是中途加入
			vmBusPartin = vmBusPartinList.get(0);
			vmBusPartin.setMtStatus(mtFlag);
			vmBusPartin.setDeviceType(deviceType);
			if ("1".equals(mtFlag)) {// 只有接收才更新参会时间
				vmBusPartin.setMtDateTime(DateUtil.getCurrentDateTime());
			}
			vmBusPartinMapper.updateByPrimaryKeySelective(vmBusPartin);
		} else {
			vmBusPartin.setId(serialService.getUUID());
			vmBusPartin.setRecordId(recordId);
			vmBusPartin.setRecEmpId((String) map.get("emp_id"));
			// 查询参会人员的信息
			Map<String, Object> recEmpMap = searchEmpMapByEmpId((String) map.get("emp_id"));
			vmBusPartin.setRecEmpName((String) recEmpMap.get("emp_name"));
			vmBusPartin.setOrgId((String) recEmpMap.get("org_id"));
			vmBusPartin.setOrgName((String) recEmpMap.get("org_name_owner"));
			vmBusPartin.setMtStatus(mtFlag);
			vmBusPartin.setDeviceType(deviceType);
			if ("1".equals(mtFlag)) {// 只有接收才更新参会时间
				vmBusPartin.setMtDateTime(DateUtil.getCurrentDateTime());
			}
			vmBusPartin.setRecType("1");// 设置参与者类型:临时
			vmBusPartinMapper.insertSelective(vmBusPartin);

		}

		// 会议实时表添加记录（只有接收响应才添加）
		// if ("1".equals(mtFlag)) {
		// VmBusPerson vmBusPerson = new VmBusPerson();
		// vmBusPerson.setId(serialService.getUUID());
		// vmBusPerson.setRecordId(recordId);
		// vmBusPerson.setRecEmpId((String) map.get("emp_id"));
		// // 获取当前登录用户的信息
		// Map<String, Object> empMap = searchEmpMapByEmpId((String)
		// map.get("emp_id"));
		// vmBusPerson.setRecEmpName((String) empMap.get("emp_name"));
		// vmBusPerson.setOrgId((String) empMap.get("org_id"));
		// vmBusPerson.setOrgName((String) empMap.get("org_name"));
		// vmBusPersonMapper.insertSelective(vmBusPerson);
		// }

		// 点对点呼叫特殊处理
		// if ("3".equals(mtType)) {// 3：点对点呼叫；响应结果要推送给发起人
		// 调用IM消息推送接口
		// Map<String, Object> imReqMap = new HashMap<String, Object>();
		// imReqMap.put("pushType", "1");// 1:个人
		// imReqMap.put("appId", imAppId);
		// imReqMap.put("sender", (String) map.get("emp_id"));
		// String[] receiver = vmBusRecord.getHostEmpId().split(";");
		// imReqMap.put("receiver", receiver);
		// imReqMap.put("msgType", "1");// 1：文本消息
		// imReqMap.put("msgContent", "");
		// Map<String, Object> msgMap = new HashMap<String, Object>();
		// msgMap.put("mtFlag", mtFlag);
		// msgMap.put("vidyoMsgType", "3");// 3：拒绝视频,5:发起人挂断，
		// JSONObject msgJSON =
		// JSONObject.parseObject(JSON.toJSONString(msgMap));
		// imReqMap.put("msgDomain", "customtype=200," +
		// msgJSON.toString());
		// vmvifService.pushMsg(imReqMap);

		// if (!"1".equals(mtFlag)) {// 点对点呼叫不接收，要调用video的结束录制、踢人、结束会议、删除视频房间接口
		// Map<String, Object> recordReqMap = new HashMap<String, Object>();
		// recordReqMap.put("room_id", vmBusRecord.getRoomId());
		// recordReqMap.put("video_flag", "3");// 3:停止录制
		// vmvifService.recordsSearch(recordReqMap);
		//
		// Map<String, Object> trReqMap = new HashMap<String, Object>();
		// trReqMap.put("room_id", vmBusRecord.getRoomId());
		// trReqMap.put("rec_emp_id", vmBusRecord.getHostEmpId());// 踢的是发起人
		// vmvifService.leaveConference(trReqMap);// 踢人
		// // 踢出的发起人要修改参会表的结束时间
		// VmBusPartinExample partinExample = new VmBusPartinExample();
		// partinExample.createCriteria().andRecordIdEqualTo(recordId)
		// .andRecEmpIdEqualTo(vmBusRecord.getHostEmpId());
		// VmBusPartin vmBusP =
		// vmBusPartinMapper.selectByExample(partinExample).get(0);
		// vmBusP.setEndDateTime(DateUtil.getCurrentDateTime());
		// vmBusPartinMapper.updateByPrimaryKeySelective(vmBusP);
		// // 踢出的发起人要删除会议实时表记录
		// VmBusPersonExample perExample = new VmBusPersonExample();
		// perExample.createCriteria().andRecordIdEqualTo(recordId).andRecEmpIdEqualTo(vmBusRecord.getHostEmpId());
		// vmBusPersonMapper.deleteByExample(perExample);
		//
		// Map<String, Object> endReqMap = new HashMap<String, Object>();
		// endReqMap.put("room_id", vmBusRecord.getRoomId());
		// vmvifService.disconnectConferenceAll(endReqMap);// 结束会议
		//
		// Map<String, Object> delReqMap = new HashMap<String, Object>();
		// delReqMap.put("room_id", vmBusRecord.getRoomId());
		// vmvifService.deleteRoom(delReqMap);// 删除视频房间
		//
		// vmBusRecord.setRealEndDateTime(DateUtil.getCurrentDateTime());
		// vmBusRecord.setMtStatus("2");// 2:会议已结束
		// vmBusRecord.setVideoStatus("3");// 3:录播结束
		// vmBusRecordMapper.updateByPrimaryKeySelective(vmBusRecord);// 修改会议记录表
		//
		// }
		// }

	}

	/**
	 * 退出会议
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void quit(Map<String, Object> map) throws AppException {

		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);
		Integer roomId = vmBusRecord.getRoomId();

		// 参会人员表修改参会结束时间
		VmBusPartinExample partinExample = new VmBusPartinExample();
		partinExample.createCriteria().andRecordIdEqualTo(recordId).andRecEmpIdEqualTo((String) map.get("emp_id"));
		VmBusPartin vmBusPartin = vmBusPartinMapper.selectByExample(partinExample).get(0);
		vmBusPartin.setEndDateTime(DateUtil.getCurrentDateTime());
		vmBusPartinMapper.updateByPrimaryKeySelective(vmBusPartin);

		// 判断退出后是否需要结束录播、删除视频房间
		if (!"2".equals(vmBusRecord.getMtStatus())) {// 因为多人要调退出接口，根据在线人数判断是否会议结束，如果会议结束，其他人再调退出接口不再做以下逻辑
			Map<String, Object> lineReqMap = new HashMap<String, Object>();
			lineReqMap.put("room_id", roomId);
			try {
				Thread.sleep(3000);
				// 调用video的获取视频房间在线人数接口
				Map<String, Object> lineResMap = vmvifService.linePerson(lineReqMap);
				boolean result = (boolean) lineResMap.get("result");
				if (result) {
					@SuppressWarnings("unchecked")
					Map<String, Object> viodeResMap = (Map<String, Object>) lineResMap.get("data");
					if (!viodeResMap.isEmpty()) {
						int count = (int) viodeResMap.get("count");
						// count < 1代表该会议室已经没有人，就结束录播、删除视频房间
						if (count < 1) {
							vmBusRecord.setRealEndDateTime(DateUtil.getCurrentDateTime());
							vmBusRecord.setMtStatus("2");// 2:会议已结束
							vmBusRecordMapper.updateByPrimaryKeySelective(vmBusRecord);// 修改会议记录表

							String videoFlag = vmBusRecord.getVideoFlag();
							// 先停止录制再调用video的获取视频录制URL接口
							if ("1".equals(videoFlag)) {
								Map<String, Object> recordReqMap = new HashMap<String, Object>();
								recordReqMap.put("room_id", roomId);
								recordReqMap.put("video_flag", "3");// 3:停止录制
								vmvifService.recordControl(recordReqMap);
								vmBusRecord.setVideoStatus("3");// 3:会议状态结束

								// 获取URL
								Thread.sleep(1000);
								Map<String, Object> urlReqMap = new HashMap<String, Object>();
								urlReqMap.put("ownerName", vmBusRecord.getAuthName());
								urlReqMap.put("roomName", vmBusRecord.getRoomName());
								Map<String, Object> urlResMap = vmvifService.recordsSearch(urlReqMap);
								String guid = (String) urlResMap.get("guid");
								String vidyoURL = recordURL + guid + ".flv";
								vmBusRecord.setVideoUrl(vidyoURL);
							}

							vmBusRecordMapper.updateByPrimaryKeySelective(vmBusRecord);// 修改会议记录表

							Map<String, Object> delReqMap = new HashMap<String, Object>();
							delReqMap.put("room_id", roomId);
							vmvifService.deleteRoom(delReqMap);// 删除视频房间
							// 删除预存视频房间表的记录
							VmBusVidyoRoomExample example = new VmBusVidyoRoomExample();
							example.createCriteria().andRoomIdEqualTo(roomId);
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

						}
					}
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 会议是否结束
	 */
	@Override
	public Map<String, Object> isEnd(Map<String, Object> map) throws AppException {
		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);
		String mtStatus = vmBusRecord.getMtStatus();

		Map<String, Object> resMap = new HashMap<String, Object>();
		if ("1".equals(mtStatus)) {
			resMap.put("mt_status", "0");// 进行中
		} else {
			resMap.put("mt_status", "1");// 已结束
		}

		return resMap;
	}

	/**
	 * 发起人入会
	 */
	@Override
	public void inMeeting(Map<String, Object> map) throws AppException {

		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);

		// 获取当前登录用户的信息
		Map<String, Object> empMap = searchEmpMapByEmpId((String) map.get("emp_id"));

		// 会议实时表添加记录（即时会议发起人直接进入视频房间）
		VmBusPerson vmBusPerson = new VmBusPerson();
		vmBusPerson.setId(serialService.getUUID());
		vmBusPerson.setRecordId(recordId);
		vmBusPerson.setRecEmpId((String) map.get("emp_id"));
		vmBusPerson.setRecEmpName((String) empMap.get("emp_name"));
		vmBusPerson.setOrgId((String) empMap.get("org_id"));
		vmBusPerson.setOrgName((String) empMap.get("org_name_owner"));
		vmBusPersonMapper.insertSelective(vmBusPerson);

		// 调用video开启录制视频接口
		// Map<String, Object> recordReqMap = new HashMap<String, Object>();
		// recordReqMap.put("room_id", vmBusRecord.getRoomId());
		// recordReqMap.put("video_flag", "2");// "2"代表录制管理接口的开启录制状态
		// vmvifService.recordControl(recordReqMap);
		// vmBusRecord.setVideoFlag("1");// 是否录播 1:是；0：否
		// vmBusRecord.setVideoStatus("1");// 录播状态 1：开启
		// 调用video的获取视频录制URL接口
		// Map<String, Object> urlReqMap = new HashMap<String, Object>();
		// urlReqMap.put("ownerName", vmBusRecord.getAuthName());
		// Map<String, Object> urlResMap =
		// vmvifService.recordsSearch(urlReqMap);
		// String videoUrl = (String) urlResMap.get("externalPlaybackLink");
		// vmBusRecord.setVideoUrl(videoUrl);
		// vmBusRecordMapper.updateByPrimaryKeySelective(vmBusRecord);

		// 调用IM推送消息接口推送视频会议室房间信息
		Map<String, Object> imReqMap = new HashMap<String, Object>();
		imReqMap.put("pushType", "1");// 1:个人
		imReqMap.put("appId", imAppId);
		imReqMap.put("sender", (String) map.get("emp_id"));
		Map<String, Object> recEmpMap = new HashMap<String, Object>();
		recEmpMap.put("record_id", recordId);
		List<Map<String, Object>> recEmpList = vedioMapper.getRevEmpIds(recEmpMap);// 获取参会人id
		String recEmpIds = "";
		if (recEmpList != null && recEmpList.size() > 0) {
			for (Map<String, Object> recEmpIdMap : recEmpList) {
				recEmpIds += recEmpIdMap.get("rec_emp_id") + ",";
			}
		}
		String[] receiver = recEmpIds.split(",");
		imReqMap.put("receiver", receiver);
		imReqMap.put("msgType", "1");// 1：文本消息
		imReqMap.put("msgContent", "123");
		Map<String, Object> msgMap = new HashMap<String, Object>();
		int keyIndex = vmBusRecord.getRoomUrl().lastIndexOf("=");
		msgMap.put("recordId", recordId);
		msgMap.put("roomId", vmBusRecord.getRoomUrl().substring(keyIndex + 1, vmBusRecord.getRoomUrl().length()));
		msgMap.put("roomUrl", Constant.IM_ROOM_URL);
		msgMap.put("tel", (String) map.get("emp_id"));
		msgMap.put("nickname", (String) recEmpMap.get("emp_name"));
		msgMap.put("vidyoMsgType", "0");
		msgMap.put("syncDeviceName", "");
		msgMap.put("CO_ROOM_ID", "-1");
		msgMap.put("CO_ROOM_PASSWORD", "123456");
		msgMap.put("CO_ROOM_SERVER", "");
		msgMap.put("member", recEmpIds + "," + (String) map.get("emp_id"));
		msgMap.put("muteState", "0,0");
		JSONObject msgJSON = JSONObject.parseObject(JSON.toJSONString(msgMap));
		imReqMap.put("msgDomain", "customtype=200," + msgJSON.toString());
		vmvifService.pushMsg(imReqMap);
	}

	/**
	 * 加人
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void addPerson(Map<String, Object> map) throws AppException {
		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);

		String recEmpIds = (String) map.get("rec_emp_ids");
		String[] recEmpIdArr = recEmpIds.split(";");

		// 调用IM消息推送接口通知加入人视频房间信息
		Map<String, Object> imReqMap = new HashMap<String, Object>();
		imReqMap.put("pushType", "1");// 1:个人
		imReqMap.put("appId", imAppId);
		imReqMap.put("sender", (String) map.get("emp_id"));
		imReqMap.put("receiver", recEmpIdArr);
		imReqMap.put("msgType", "1");// 1：文本消息
		imReqMap.put("msgContent", "");
		Map<String, Object> msgMap = new HashMap<String, Object>();
		msgMap.put("recordId", recordId);
		Integer roomId = vmBusRecord.getRoomId();
		String roomUrl = vmBusRecord.getRoomUrl();
		msgMap.put("roomId", roomId);
		msgMap.put("roomUrl", roomUrl);
		JSONObject msgJSON = JSONObject.parseObject(JSON.toJSONString(msgMap));
		imReqMap.put("msgDomain", msgJSON.toString());
		vmvifService.pushMsg(imReqMap);

		// 参会人员表添加记录
		if (recEmpIdArr.length > 0) {
			for (String recEmpId : recEmpIdArr) {
				// 查询加入人员的信息
				Map<String, Object> recEmpMap = searchEmpMapByEmpId(recEmpId);

				VmBusPartin vmBusPartin = new VmBusPartin();
				vmBusPartin.setId(serialService.getUUID());
				vmBusPartin.setRecordId(recordId);
				vmBusPartin.setRecEmpId(recEmpId);
				vmBusPartin.setRecEmpName((String) recEmpMap.get("emp_name"));
				vmBusPartin.setOrgId((String) recEmpMap.get("org_id"));
				vmBusPartin.setOrgName((String) recEmpMap.get("org_name_owner"));
				vmBusPartin.setMtStatus("0");// 加入人参与状态：未参加
				vmBusPartin.setRecType("1");// 设置加入人类型 1:临时
				vmBusPartinMapper.insertSelective(vmBusPartin);
			}
		}

	}

}
