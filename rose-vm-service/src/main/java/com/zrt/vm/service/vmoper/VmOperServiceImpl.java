package com.zrt.vm.service.vmoper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.zrt.mybatis.domain.VmBusRecord;
import com.zrt.mybatis.domain.VmBusVidyoRoom;
import com.zrt.mybatis.domain.VmBusVidyoRoomExample;
import com.zrt.mybatis.mapper.VmBusPartinMapper;
import com.zrt.mybatis.mapper.VmBusRecordMapper;
import com.zrt.mybatis.mapper.VmBusVidyoRoomMapper;
import com.zrt.vm.mapper.mtmanage.VmVedioMapper;
import com.zrt.vm.service.appVmoper.AppVmOperServiceImpl;
import com.zrt.vm.service.contacts.ContactsService;
import com.zrt.vm.service.runnable.CreatRoomThread;
import com.zrt.vm.service.serial.SerialService;
import com.zrt.vm.service.vmvif.VmvifService;

@Service
public class VmOperServiceImpl implements VmOperService {

	private static final Logger log = LoggerFactory.getLogger(AppVmOperServiceImpl.class);

	@Value("${im.appId}")
	private String imAppId;
	@Autowired
	private VmBusRecordMapper vmBusRecordMapper;
	@Autowired
	private VmBusPartinMapper vmBusPartinMapper;
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
	 * web发起即时会议
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void launch(Map<String, Object> map) throws AppException {
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
		String recPartinEmpIds = recEmpIds + ";" + curEmpId;// 发起人+接收人
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
			roomName=vmVidyoRoom.getRoomName();

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
		log.info("创建视频房间的roomUrl：" + roomUrl);
		String roomKey = roomUrl.substring(roomUrl.lastIndexOf("=") + 1, roomUrl.length());
		vmBusRecordMapper.insertSelective(vmBusRecord);

		// 通过IM给发送人和接收人发送视频信息消息（响铃）
		Map<String, Object> imReqMap = new HashMap<String, Object>();
		imReqMap.put("pushType", "1");// 1:个人
		imReqMap.put("appId", imAppId);
		imReqMap.put("sender", curEmpId);
		imReqMap.put("receiver", recPartinEmpIdArr);
		imReqMap.put("msgType", "1");// 1：文本消息
		imReqMap.put("msgContent", "你收到" + curEmpName + "在web端发起的视频通讯！点" + roomUrl + "进入!");
		Map<String, Object> msgMap = new HashMap<String, Object>();
		msgMap.put("record_id", recordId);
		msgMap.put("roomId", roomKey);
		msgMap.put("roomUrl", Constant.IM_ROOM_URL);
		msgMap.put("tel", curEmpId);
		msgMap.put("nickname", curEmpName);
		msgMap.put("vidyoMsgType", "0");
		msgMap.put("syncDeviceName", "WEB");
		msgMap.put("CO_ROOM_ID", "-1");
		msgMap.put("CO_ROOM_PASSWORD", "123456");
		msgMap.put("CO_ROOM_SERVER", "");
		msgMap.put("member", recPartinEmpIds.replace(";", ","));
		msgMap.put("muteState", "0,0");
		JSONObject msgJSON = JSONObject.parseObject(JSON.toJSONString(msgMap));
		imReqMap.put("msgDomain", "customtype=200," + msgJSON.toString());
		vmvifService.pushMsg(imReqMap);

	}

}
