package com.zrt.vm.service.mtmanage;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.AppException;
import com.zrt.commons.Constant;
import com.zrt.commons.PageInit;
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.utils.SeclectVidyoRoom;
import com.zrt.mybatis.domain.VmBusPartin;
import com.zrt.mybatis.domain.VmBusPartinExample;
import com.zrt.mybatis.domain.VmBusPartinExample.Criteria;
import com.zrt.mybatis.domain.VmBusRecord;
import com.zrt.mybatis.domain.VmBusRecordExample;
import com.zrt.mybatis.domain.VmBusVidyoRoom;
import com.zrt.mybatis.domain.VmBusVidyoRoomExample;
import com.zrt.mybatis.mapper.VmBusPartinMapper;
import com.zrt.mybatis.mapper.VmBusRecordMapper;
import com.zrt.mybatis.mapper.VmBusVidyoRoomMapper;
import com.zrt.vm.domain.VmBusRecordDomain;
import com.zrt.vm.mapper.mtmanage.VmCustomMapper;
import com.zrt.vm.mapper.mtmanage.VmVedioMapper;
import com.zrt.vm.service.contacts.ContactsService;
import com.zrt.vm.service.infor.InforService;
import com.zrt.vm.service.redis.RedisService;
import com.zrt.vm.service.runnable.CreatRoomThread;
import com.zrt.vm.service.serial.SerialService;
import com.zrt.vm.service.vmvif.VmvifService;

@Service
public class MeetingServiceImpl implements MeetingService {

	private static final Logger log = LoggerFactory.getLogger(MeetingServiceImpl.class);

	@Autowired
	private VmCustomMapper vmCustomMapper;
	@Autowired
	private VmBusPartinMapper vmBusPartinMapper;
	@Autowired
	private VmBusRecordMapper vmBusRecordMapper;
	@Autowired
	private VmVedioMapper vedioMapper;
	@Autowired
	private SerialService serialService;
	@Autowired
	private ContactsService contactsService;
	@Autowired
	private InforService inforService;
	@Autowired
	private VmvifService vmvifService;
	@Autowired
	private RedisService redisService;
	@Autowired
	private VmBusVidyoRoomMapper vmBusVidyoRoomMapper;
	@Autowired
	private CreatRoomThread creatRoomThread;
	@Autowired
	private SeclectVidyoRoom seclectVidyoRoom;

	@Value("${im.appId}")
	private String imAppId;

	/**
	 * web端进行中会议列表
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> ongoingMeetingList(Map<String, Object> map) throws AppException {

		PageInit.setPage(map);

		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString()));

		if (map.get("real_begin_date_time_start") != null && !"".equals(map.get("real_begin_date_time_start"))) {
			map.put("real_begin_date_time_start",
					map.get("real_begin_date_time_start").toString().replaceAll("-", "") + "000000");
		}
		if (map.get("real_begin_date_time_end") != null && !"".equals(map.get("real_begin_date_time_end"))) {
			map.put("real_begin_date_time_end",
					map.get("real_begin_date_time_end").toString().replaceAll("-", "") + "235959");
		}

		List<Map<String, Object>> dataList = vmCustomMapper.ongoingMeetingList(map);

		// Map<String,Object> returnRecMap = new HashMap<String,Object>();
		if (dataList != null && dataList.size() > 0) {

			for (int i = 0; i < dataList.size(); i++) {
				Map<String, Object> everyMap = dataList.get(i);
				String recordId = (String) everyMap.get("record_id");// 获取当前的会议记录表ID

				VmBusPartinExample example = new VmBusPartinExample();
				example.createCriteria().andRecordIdEqualTo(recordId);
				List<VmBusPartin> recEmpList = vmBusPartinMapper.selectByExample(example);

				everyMap.put("rec_emp_list", recEmpList);

				String roomUrl = (String) everyMap.get("room_url");
				String roomKey = roomUrl.substring(roomUrl.lastIndexOf("=") + 1, roomUrl.length());
				everyMap.put("room_url", Constant.IM_ROOM_URL);
				everyMap.put("room_key", roomKey);

			}
		}

		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", pageInfo.getList());
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	/**
	 * 加入会议
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void joinMeeting(Map<String, Object> map) throws AppException {
		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("请选择你要加入的会议！");
		}

		String empId = (String) map.get("emp_id");
		// 校验当前登录用户是否是已被邀请的参会人员
		VmBusPartinExample example = new VmBusPartinExample();
		Criteria criteria = example.createCriteria();
		criteria.andRecordIdEqualTo(recordId).andRecEmpIdEqualTo(empId);
		int vmBusPartinCount = vmBusPartinMapper.countByExample(example);
		if (vmBusPartinCount <= 0) {
			throw new AppException("您没有受邀参加该会议!");
		}
		// 查询参会人员表，并更新数据
		List<VmBusPartin> vmBusPartinList = vmBusPartinMapper.selectByExample(example);
		VmBusPartin vmBusPartin = vmBusPartinList.get(0);

		// 校验是否已经参加会议
		criteria.andMtStatusEqualTo("1");
		int mtStatuscount = vmBusPartinMapper.countByExample(example);
		if (mtStatuscount > 0) {
			throw new AppException("您已经加入该会议!");
		}

		// 获取参会密码
		String mtPwd = (String) map.get("mt_pwd");
		if (StringUtils.isNotBlank(mtPwd)) {
			VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);
			String realMtPwd = vmBusRecord.getMtPwd();
			if (mtPwd != realMtPwd && !realMtPwd.equals(mtPwd)) {
				throw new AppException("您输入的密码不正确,请重新输入!");
			}
			vmBusPartin.setMtStatus("1");// 已参与
			vmBusPartin.setMtDateTime(DateUtil.getCurrentDateTime());
			vmBusPartinMapper.updateByPrimaryKey(vmBusPartin);
		} else if (map.get("mt_pwd") == null) { // 无需密码参会
			vmBusPartin.setMtStatus("1");// 已参与
			vmBusPartin.setMtDateTime(DateUtil.getCurrentDateTime());
			vmBusPartinMapper.updateByPrimaryKey(vmBusPartin);
		}
	}

	/**
	 * 历史会议列表
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> historicalMeetingList(Map<String, Object> map) throws AppException {

		PageInit.setPage(map);

		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString()));

		if (map.get("real_begin_date_time_start") != null && !"".equals(map.get("real_begin_date_time_start"))) {
			map.put("history_real_begin_date_time",
					map.get("real_begin_date_time_start").toString().replaceAll("-", "") + "000000");
			map.remove("real_begin_date_time_start");

		}
		if (map.get("real_begin_date_time_end") != null && !"".equals(map.get("real_begin_date_time_end"))) {
			map.put("history_real_end_date_time",
					map.get("real_begin_date_time_end").toString().replaceAll("-", "") + "235959");
			map.remove("real_begin_date_time_end");
		}

		List<Map<String, Object>> dataList = vmCustomMapper.historicalMeetingList(map);
		if (dataList != null && dataList.size() > 0) {
			for (int i = 0; i < dataList.size(); i++) {
				Map<String, Object> everyMap = dataList.get(i);
				String recordId = (String) everyMap.get("record_id");// 获取当前的会议记录表ID

				VmBusPartinExample example = new VmBusPartinExample();
				example.createCriteria().andRecordIdEqualTo(recordId);
				List<VmBusPartin> recEmpList = vmBusPartinMapper.selectByExample(example);
				// List<Map<String,Object>>
				// recEmpList=vmCustomMapper.selectRecEmpList(recordId);
				everyMap.put("rec_emp_list", recEmpList);

			}
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", pageInfo.getList());
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	/**
	 * 我的会议室会议列表
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> myMeetingList(Map<String, Object> map) throws AppException {
		searchHandle(map);
		List<Map<String, Object>> dataList = vmCustomMapper.myMeetingList(map);
		if (dataList != null && dataList.size() > 0) {
			for (int i = 0; i < dataList.size(); i++) {
				Map<String, Object> everyMap = dataList.get(i);
				String recordId = (String) everyMap.get("record_id");// 获取当前的会议记录表ID
				String hostEmpId = (String) everyMap.get("host_emp_id");// 获取会议主持人的ID
				String empId = (String) map.get("emp_id");// 获取当前登录用户ID
				String empMtStatus = (hostEmpId.equals(empId)) ? "0" : "1";
				everyMap.put("emp_mt_status", empMtStatus);// emp_mt_status:
															// 0：创建，1：受邀
				VmBusPartinExample example = new VmBusPartinExample();
				example.createCriteria().andRecordIdEqualTo(recordId);
				List<VmBusPartin> recEmpList = vmBusPartinMapper.selectByExample(example);
				// List<Map<String,Object>>
				// recEmpList=vmCustomMapper.selectRecEmpList(recordId);
				everyMap.put("rec_emp_list", recEmpList);

			}
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", pageInfo.getList());
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	/**
	 * 通用的查询条件处理
	 */
	public void searchHandle(Map<String, Object> map) throws AppException {
		PageInit.setPage(map);

		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString()));
		// 进行中会议时间处理
		if (map.get("real_begin_date_time_start") != null && !"".equals(map.get("real_begin_date_time_start"))) {
			map.put("real_begin_date_time_start",
					map.get("real_begin_date_time_start").toString().replaceAll("-", "") + "000000");
		}
		if (map.get("real_begin_date_time_end") != null && !"".equals(map.get("real_begin_date_time_end"))) {
			map.put("real_begin_date_time_end",
					map.get("real_begin_date_time_end").toString().replaceAll("-", "") + "235959");
		}

		// 历史会议时间处理
		if (map.get("real_begin_date_time") != null && !"".equals(map.get("real_begin_date_time"))) {
			map.put("real_begin_date_time", map.get("real_begin_date_time").toString().replaceAll("-", "") + "000000");
		}
		if (map.get("real_end_date_time") != null && !"".equals(map.get("real_end_date_time"))) {
			map.put("real_end_date_time", map.get("real_end_date_time").toString().replaceAll("-", "") + "235959");
		}
		// 我的会议室会议时间处理
		if (map.get("begin_date_time_start") != null && !"".equals(map.get("begin_date_time_start"))) {
			map.put("begin_date_time_start",
					map.get("begin_date_time_start").toString().replaceAll("-", "") + "000000");
		}
		if (map.get("begin_date_time_end") != null && !"".equals(map.get("begin_date_time_end"))) {
			map.put("begin_date_time_end", map.get("begin_date_time_end").toString().replaceAll("-", "") + "235959");
		}
	}

	/*
	 * //遍历参会人员 public List<Map<String, Object>>
	 * searchRecEmpList(List<Map<String, Object>> dataList){ if (dataList !=
	 * null && dataList.size() > 0) { for (int i = 0; i < dataList.size(); i++)
	 * { Map everyMap = dataList.get(i); String recordId = (String)
	 * everyMap.get("record_id");// 获取当前的会议记录表ID
	 * 
	 * VmBusPartinExample example = new VmBusPartinExample();
	 * example.createCriteria().andRecordIdEqualTo(recordId); List<VmBusPartin>
	 * recEmpList = vmBusPartinMapper.selectByExample(example); //
	 * List<Map<String,Object>> //
	 * recEmpList=vmCustomMapper.selectRecEmpList(recordId);
	 * everyMap.put("rec_emp_list", recEmpList);
	 * 
	 * } } return dataList;
	 * 
	 * }
	 */
	/**
	 * App开启会议
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> appOpenMeeting(Map<String, Object> map) throws AppException {

		String recordId = (String) map.get("record_id");
		String curEmpId = (String) map.get("emp_id");
		Map<String, Object> empMap = searchEmpMapByEmpId(curEmpId);
		String curEmpName = (String) empMap.get("emp_name");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);
		// 校验当前登录员工是否是该会议的主持人
		String empId = (String) map.get("emp_id");
		if (empId != vmBusRecord.getHostEmpId() && !empId.equals(vmBusRecord.getHostEmpId())) {
			throw new AppException("您没有权限开启该会议!");
		}
		if ("1".equals(vmBusRecord.getMtStatus())) {
			throw new AppException("该会议正在进行中!");
		}
		if ("2".equals(vmBusRecord.getMtStatus())) {
			throw new AppException("该会议已结束,不能开启!");
		}
		if ("3".equals(vmBusRecord.getMtStatus())) {
			throw new AppException("该会议已取消,不能开启!");
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
		vmBusRecord.setRoomId(roomId);
		vmBusRecord.setRoomUrl(roomUrl);
		vmBusRecord.setExtension(extension);
		String roomKey = roomUrl.substring(roomUrl.lastIndexOf("=") + 1, roomUrl.length());

		String mtPwdFlag = vmBusRecord.getMtPwdFlag();// 是否需要密码0:否,1:是
		// if ("1".equals(mtPwdFlag)) {
		// String mtPwd = vmBusRecord.getMtPwd();
		// if (StringUtils.isNotBlank(mtPwd)) {// 需要密码且密码不为空
		// // 调用video的设置密码接口
		// Map<String, Object> pinReqMap = new HashMap<String, Object>();
		// pinReqMap.put("room_id", roomId);
		// pinReqMap.put("pin", mtPwdFlag);
		// vmvifService.createRoomPIN(pinReqMap);
		// }
		// }

		String creatFlag = vmBusRecord.getCreateFlag();// 创建会议时设置是否启动录播 1：是；0：否
		if ("1".equals(creatFlag)) {
			// 调用video开启录制视频接口
			Map<String, Object> recordReqMap = new HashMap<String, Object>();
			recordReqMap.put("room_id", roomId);
			recordReqMap.put("video_flag", "2");// "2"代表录制管理接口的开启录制状态
			vmvifService.recordControl(recordReqMap);
			vmBusRecord.setVideoFlag("1");// 是否录播 1:是；0：否
			vmBusRecord.setVideoStatus("1");// 录播状态 1：开启

		}
		// 给接收人通过IM发送视频信息消息
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
				if (!curEmpId.equals(recEmpIdMap.get("rec_emp_id"))) {
					recEmpIds += recEmpIdMap.get("rec_emp_id") + ";";
				}
			}
		}
		log.info("通过IM发送的消息中接收人id有：" + recEmpIds);
		String[] receiver = recEmpIds.split(";");
		imReqMap.put("receiver", receiver);
		imReqMap.put("msgType", "1");// 1：文本消息
		if ("1".equals(mtPwdFlag)) {
			imReqMap.put("msgContent",
					"你被邀请的《" + vmBusRecord.getMtTitile() + "》会议已经开始啦！点" + roomUrl + "进入！密码为：" + vmBusRecord.getMtPwd());
		} else {
			imReqMap.put("msgContent", "你被邀请的《" + vmBusRecord.getMtTitile() + "》会议已经开始啦！移动设备入会方式：" + roomUrl
					+ "宝利通入会方式：" + Constant.VIDYO_GATEWAY + vmBusRecord.getExtension());
		}

		Map<String, Object> msgMap = new HashMap<String, Object>();
		msgMap.put("oa_type", "0");
		msgMap.put("recordId", recordId);
		msgMap.put("roomUrl", Constant.IM_ROOM_URL);
		msgMap.put("roomKey", roomKey);
		msgMap.put("member", recEmpIds.replaceAll(";", ","));
		JSONObject msgDomainJSON = JSONObject.parseObject(JSON.toJSONString(msgMap));
		imReqMap.put("msgDomain", msgDomainJSON.toJSONString());
		vmvifService.pushMsg(imReqMap);

		vmBusRecord.setAuthName(authName);
		vmBusRecord.setMtStatus("1");// 设置会议状态为进行中
		vmBusRecord.setUpdateDateTime(DateUtil.getCurrentDateTime());
		vmBusRecord.setRealBeginDateTime(DateUtil.getCurrentDateTime());// 设置会议实际开始时间
		vmBusRecordMapper.updateByPrimaryKeySelective(vmBusRecord);
		// 会议主持人更新参与状态
		VmBusPartinExample example = new VmBusPartinExample();
		example.createCriteria().andRecordIdEqualTo(recordId).andRecEmpIdEqualTo(empId);
		VmBusPartin hostEmp = vmBusPartinMapper.selectByExample(example).get(0);
		hostEmp.setMtStatus("1");// 参会状态：1已参加
		hostEmp.setMtDateTime(DateUtil.getCurrentDateTime());// 参会时间
		vmBusPartinMapper.updateByPrimaryKeySelective(hostEmp);

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("record_id", recordId);
		resMap.put("room_url", Constant.IM_ROOM_URL);
		resMap.put("room_key", roomKey);

		return resMap;

		// 实时表添加会议主持人记录
		// VmBusPerson vmBusPerson = new VmBusPerson();
		// vmBusPerson.setId(serialService.getUUID());
		// vmBusPerson.setRecordId(recordId);
		// vmBusPerson.setRecEmpId((String) map.get("emp_id"));
		// Map<String, Object> empMap = searchEmpMapByEmpId((String)
		// map.get("emp_id"));// 获取当前登录用户的信息
		// vmBusPerson.setRecEmpName((String) empMap.get("emp_name"));
		// vmBusPerson.setOrgId((String) empMap.get("org_id"));
		// vmBusPerson.setOrgName((String) empMap.get("org_name"));
		// vmBusPersonMapper.insertSelective(vmBusPerson);

	}

	/**
	 * web开启会议
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void openMeeting(Map<String, Object> map) throws AppException {

		String recordId = (String) map.get("record_id");
		String curEmpId = (String) map.get("emp_id");
		Map<String, Object> empMap = searchEmpMapByEmpId(curEmpId);
		String curEmpName = (String) empMap.get("emp_name");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);
		// 校验当前登录员工是否是该会议的主持人
		String empId = (String) map.get("emp_id");
		if (empId != vmBusRecord.getHostEmpId() && !empId.equals(vmBusRecord.getHostEmpId())) {
			throw new AppException("您没有权限开启该会议!");
		}
		if ("1".equals(vmBusRecord.getMtStatus())) {
			throw new AppException("该会议正在进行中!");
		}
		if ("2".equals(vmBusRecord.getMtStatus())) {
			throw new AppException("该会议已结束,不能开启!");
		}
		if ("3".equals(vmBusRecord.getMtStatus())) {
			throw new AppException("该会议已取消,不能开启!");
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
		vmBusRecord.setRoomId(roomId);
		vmBusRecord.setRoomUrl(roomUrl);
		vmBusRecord.setExtension(extension);
		log.info("创建视频房间的roomUrl：" + roomUrl);
		String roomKey = roomUrl.substring(roomUrl.lastIndexOf("=") + 1, roomUrl.length());

		String mtPwdFlag = vmBusRecord.getMtPwdFlag();// 是否需要密码0:否,1:是
		// if ("1".equals(mtPwdFlag)) {
		// String mtPwd = vmBusRecord.getMtPwd();
		// if (StringUtils.isNotBlank(mtPwd)) {// 需要密码且密码不为空
		// // 调用video的设置密码接口
		// Map<String, Object> pinReqMap = new HashMap<String, Object>();
		// pinReqMap.put("room_id", roomId);
		// pinReqMap.put("pin", mtPwdFlag);
		// vmvifService.createRoomPIN(pinReqMap);
		// }
		// }

		String creatFlag = vmBusRecord.getCreateFlag();// 创建会议时设置是否启动录播 1：是；0：否
		if ("1".equals(creatFlag)) {
			// 调用video开启录制视频接口
			Map<String, Object> recordReqMap = new HashMap<String, Object>();
			recordReqMap.put("room_id", roomId);
			recordReqMap.put("video_flag", "2");// "2"代表录制管理接口的开启录制状态
			vmvifService.recordControl(recordReqMap);
			vmBusRecord.setVideoFlag("1");// 是否录播 1:是；0：否
			vmBusRecord.setVideoStatus("1");// 录播状态 1：开启

		}
		vmBusRecord.setAuthName(authName);
		vmBusRecord.setMtStatus("1");// 设置会议状态为进行中
		vmBusRecord.setUpdateDateTime(DateUtil.getCurrentDateTime());
		vmBusRecord.setRealBeginDateTime(DateUtil.getCurrentDateTime());// 设置会议实际开始时间
		vmBusRecordMapper.updateByPrimaryKeySelective(vmBusRecord);

		// 给接收人通过IM发送视频信息文字消息
		Map<String, Object> imReqMap = new HashMap<String, Object>();
		imReqMap.put("pushType", "1");// 1:个人
		imReqMap.put("appId", imAppId);
		imReqMap.put("sender", curEmpId);

		Map<String, Object> recEmpMap = new HashMap<String, Object>();
		recEmpMap.put("record_id", recordId);
		List<Map<String, Object>> recEmpList = vedioMapper.getRevEmpIds(recEmpMap);// 获取参会人id
		String recEmpIds = "";
		if (recEmpList != null && recEmpList.size() > 0) {
			for (Map<String, Object> recEmpIdMap : recEmpList) {
				if (!curEmpId.equals(recEmpIdMap.get("rec_emp_id"))) {
					recEmpIds += recEmpIdMap.get("rec_emp_id") + ";";
				}

			}
		}
		log.info("通过IM发送的消息中接收人id有：" + recEmpIds);
		String[] receiver = recEmpIds.split(";");
		imReqMap.put("receiver", receiver);
		imReqMap.put("msgType", "1");// 1：文本消息
		if ("1".equals(mtPwdFlag)) {
			imReqMap.put("msgContent",
					"你被邀请的《" + vmBusRecord.getMtTitile() + "》会议已经开始啦！点" + roomUrl + "进入！密码为：" + vmBusRecord.getMtPwd());
		} else {
			imReqMap.put("msgContent",
					"你被邀请的《" + vmBusRecord.getMtTitile() + "》会议已经开始啦！" + System.getProperty("line.separator")
							+ "移动设备入会方式：点" + roomUrl + System.getProperty("line.separator") + "宝利通入会方式："
							+ Constant.VIDYO_GATEWAY + vmBusRecord.getExtension());
		}

		Map<String, Object> msgMap = new HashMap<String, Object>();
		msgMap.put("oa_type", "0");
		msgMap.put("recordId", recordId);
		msgMap.put("roomUrl", Constant.IM_ROOM_URL);
		msgMap.put("roomKey", roomKey);
		msgMap.put("member", recEmpIds.replaceAll(";", ","));
		JSONObject msgDomainJSON = JSONObject.parseObject(JSON.toJSONString(msgMap));
		imReqMap.put("msgDomain", msgDomainJSON.toJSONString());
		vmvifService.pushMsg(imReqMap);

		// 会议主持人更新参与状态
		VmBusPartinExample example = new VmBusPartinExample();
		example.createCriteria().andRecordIdEqualTo(recordId).andRecEmpIdEqualTo(empId);
		VmBusPartin hostEmp = vmBusPartinMapper.selectByExample(example).get(0);
		hostEmp.setMtStatus("1");// 参会状态：1已参加
		hostEmp.setMtDateTime(DateUtil.getCurrentDateTime());// 参会时间
		vmBusPartinMapper.updateByPrimaryKeySelective(hostEmp);

		// 通过IM给发送人和接收人发送视频响铃
		Map<String, Object> imRingReqMap = new HashMap<String, Object>();
		imRingReqMap.put("pushType", "1");// 1:个人
		imRingReqMap.put("appId", imAppId);
		imRingReqMap.put("sender", curEmpId);
		String recPartinEmpIds = recEmpIds + curEmpId;
		String[] recPartinEmpIdArr = recPartinEmpIds.split(";");
		imRingReqMap.put("receiver", recPartinEmpIdArr);
		imRingReqMap.put("msgType", "1");// 1：文本消息
		imRingReqMap.put("msgContent", "你收到" + curEmpName + "在web端发起的视频通讯！点" + roomUrl + "进入!");
		Map<String, Object> msgRingMap = new HashMap<String, Object>();
		msgRingMap.put("record_id", recordId);
		msgRingMap.put("roomId", roomKey);
		msgRingMap.put("roomUrl", Constant.IM_ROOM_URL);
		msgRingMap.put("tel", curEmpId);
		msgRingMap.put("nickname", curEmpName);
		msgRingMap.put("vidyoMsgType", "0");
		msgRingMap.put("syncDeviceName", "WEB");
		msgRingMap.put("CO_ROOM_ID", "-1");
		msgRingMap.put("CO_ROOM_PASSWORD", "123456");
		msgRingMap.put("CO_ROOM_SERVER", "");
		msgRingMap.put("member", recPartinEmpIds.replace(";", ","));
		msgRingMap.put("muteState", "0,0");
		JSONObject msgJSON = JSONObject.parseObject(JSON.toJSONString(msgRingMap));
		imRingReqMap.put("msgDomain", "customtype=200," + msgJSON.toString());
		vmvifService.pushMsg(imRingReqMap);

		// 实时表添加会议主持人记录
		// VmBusPerson vmBusPerson = new VmBusPerson();
		// vmBusPerson.setId(serialService.getUUID());
		// vmBusPerson.setRecordId(recordId);
		// vmBusPerson.setRecEmpId((String) map.get("emp_id"));
		// Map<String, Object> empMap = searchEmpMapByEmpId((String)
		// map.get("emp_id"));// 获取当前登录用户的信息
		// vmBusPerson.setRecEmpName((String) empMap.get("emp_name"));
		// vmBusPerson.setOrgId((String) empMap.get("org_id"));
		// vmBusPerson.setOrgName((String) empMap.get("org_name"));
		// vmBusPersonMapper.insertSelective(vmBusPerson);

	}

	/**
	 * 取消会议
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void cancelMeeting(Map<String, Object> map) throws AppException {
		String recordId = (String) map.get("record_id");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("获取不到会议记录表ID!");
		}
		// 根据主键查询会议记录表对象
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);
		// 校验当前登录员工是否是该会议的主持人
		String empId = (String) map.get("emp_id");
		if (empId != vmBusRecord.getHostEmpId() && !empId.equals(vmBusRecord.getHostEmpId())) {
			throw new AppException("您没有权限取消该会议!");
		}
		if ("1".equals(vmBusRecord.getMtStatus())) {
			throw new AppException("该会议正在进行中,不能取消!");
		}
		if ("2".equals(vmBusRecord.getMtStatus())) {
			throw new AppException("该会议已结束,不能取消!");
		}
		if ("3".equals(vmBusRecord.getMtStatus())) {
			throw new AppException("该会议已取消!");
		}
		vmBusRecord.setMtStatus("3");// 设置会议状态为取消
		vmBusRecord.setUpdateDateTime(DateUtil.getCurrentDateTime());// 更新修改时间
		vmBusRecordMapper.updateByPrimaryKeySelective(vmBusRecord);

		// 查询参会人员
		VmBusPartinExample example = new VmBusPartinExample();
		example.createCriteria().andRecordIdEqualTo(recordId);
		List<VmBusPartin> vmBusPartinList = vmBusPartinMapper.selectByExample(example);
		String receiverIds = "";// 内部讯息接收人
		for (VmBusPartin vmBusPartin : vmBusPartinList) {
			receiverIds += vmBusPartin.getRecEmpId() + ";";
		}

		// 获取该会议的通知方式
		String notifyType = vmBusRecord.getNotifyType();
		if ("2".equals(notifyType) || "3".equals(notifyType)) {
			// 发送内部讯息
			Map<String, Object> inforMap = new HashMap<String, Object>();
			inforMap.put("title", "会议取消提醒");
			inforMap.put("content",
					"主题为" + vmBusRecord.getMtTitile() + ",预计"
							+ DateUtil.getDateTimeFormat(
									DateUtil.formatDate(vmBusRecord.getBeginDateTime(), "yyyyMMddHHmmss"))
							+ "开始的会议已取消");
			inforMap.put("sender_id", vmBusRecord.getHostEmpId());
			inforMap.put("receiver_ids", receiverIds);
			inforMap.put("category", "innerInfor");
			inforMap.put("bus_type", "4");
			inforService.sendUpdateInfor(inforMap);
		}
		if ("1".equals(notifyType) || "3".equals(notifyType)) {
			// 发送IM消息
			Map<String, Object> imReqMap = new HashMap<String, Object>();
			imReqMap.put("pushType", "1");// 1:个人
			imReqMap.put("appId", imAppId);
			imReqMap.put("sender", vmBusRecord.getHostEmpId());
			imReqMap.put("receiver", receiverIds.split(";"));
			imReqMap.put("msgType", "1");// 1：文本消息
			imReqMap.put("msgContent",
					"主题为：《" + vmBusRecord.getMtTitile() + "》,预计"
							+ DateUtil.getDateTimeFormat(
									DateUtil.formatDate(vmBusRecord.getBeginDateTime(), "yyyyMMddHHmmss"))
							+ "开始的会议已取消");
			imReqMap.put("msgDomain", "");
			vmvifService.pushMsg(imReqMap);

		}

	}

	/***
	 * 新建会议
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void saveMeeting(Map<String, Object> map) throws AppException {

		// 处理预计开始时间和预计结束时间的格式
		String reqBeginDateTime = (String) map.get("begin_date_time");
		String reqEndDateTime = (String) map.get("end_date_time");
		String beginDateTime = reqBeginDateTime.replace(" ", "").replace("-", "").replace(":", "") + "00";
		String endDateTime = reqEndDateTime.replace(" ", "").replace("-", "").replace(":", "") + "00";
		// 判断开始时间和结束时间的大小
		if (Long.parseLong(beginDateTime) >= Long.parseLong(endDateTime)) {
			throw new AppException("会议的预计结束时间填写有误,必须大于开始时间");
		}
		// 获取当前登录用户的信息
		Map<String, Object> empMap = searchEmpMapByEmpId((String) map.get("emp_id"));

		String mtTitile = (String) map.get("mt_titile");// 获取会议主题
		if (StringUtils.isBlank(mtTitile)) {
			throw new AppException("会议主题不能为空!");
		}
		// 校验会议主题不能相同
		VmBusRecordExample example = new VmBusRecordExample();
		example.createCriteria().andMtTitileEqualTo(mtTitile).andCreateEmpIdEqualTo((String) map.get("emp_id"));
		int countByExample = vmBusRecordMapper.countByExample(example);
		if (countByExample > 0) {
			throw new AppException("会议主题已存在,请重新输入!");
		}

		// 获取通知方式
		String notifyType = (String) map.get("notify_type");

		VmBusRecord vmBusRecord = new VmBusRecord();
		String recordId = serialService.getUUID();
		vmBusRecord.setId(recordId);
		vmBusRecord.setMtTitile(mtTitile);
		vmBusRecord.setCreateEmpId((String) map.get("emp_id"));
		vmBusRecord.setCreateEmpName((String) empMap.get("emp_name"));
		vmBusRecord.setOrgId((String) empMap.get("org_id"));
		vmBusRecord.setOrgName((String) empMap.get("org_name_owner"));
		// vmBusRecord.setMtDesc(mtDesc);
		vmBusRecord.setNotifyType(notifyType);
		vmBusRecord.setMtStatus("0");
		vmBusRecord.setHostEmpId((String) map.get("emp_id"));
		vmBusRecord.setHostEmpName((String) empMap.get("emp_name"));
		vmBusRecord.setHostOrgId((String) empMap.get("org_id"));
		vmBusRecord.setHostOrgName((String) empMap.get("org_name_owner"));
		vmBusRecord.setMtPwd((String) map.get("mt_pwd"));
		vmBusRecord.setMtPwdFlag((String) map.get("mt_pwd_flag"));
		vmBusRecord.setCreateDateTime(DateUtil.getCurrentDateTime());
		// vmBusRecord.setUpdateDateTime(updateDateTime);
		vmBusRecord.setBeginDateTime(beginDateTime);
		vmBusRecord.setEndDateTime(endDateTime);
		vmBusRecord.setMtAddress((String) map.get("mt_address"));
		vmBusRecord.setCreateFlag((String) map.get("create_flag"));// 是否启动录播
		if ("1".equals((String) map.get("create_flag"))) {
			vmBusRecord.setVideoFlag("1");
		} else if ("0".equals((String) map.get("create_flag"))) {
			vmBusRecord.setVideoFlag("0");
		}
		vmBusRecord.setMtType("1");// 会议类型(1:预订,2:即时多人,3:点对点) 默认设置预定
		vmBusRecordMapper.insertSelective(vmBusRecord);

		if (map.get("rec_emp_ids") != null) {
			String recEmpIds = (String) map.get("emp_id") + ";" + (String) map.get("rec_emp_ids");
			String[] recEmpArr = recEmpIds.split(";");
			for (String recEmpId : recEmpArr) {
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
				vmBusPartin.setMtStatus("0");// 默认参与状态：未参加
				vmBusPartin.setRecType("0");// 设置参与者类型:普通
				vmBusPartinMapper.insertSelective(vmBusPartin);
			}

			// 创建会议后,通知参会人员
			// 内部讯息接收人
			String receiverIds = (String) map.get("rec_emp_ids");

			// 获取该会议的通知方式
			if ("2".equals(notifyType) || "3".equals(notifyType)) {
				// 发送内部讯息
				Map<String, Object> inforMap = new HashMap<String, Object>();
				inforMap.put("title", "新会议提醒");
				inforMap.put("content",
						"您有一场主题为：《" + mtTitile + "》的会议，预计开始时间为："
								+ DateUtil.getDateTimeFormat(
										DateUtil.formatDate(vmBusRecord.getBeginDateTime(), "yyyyMMddHHmmss"))
								+ "请您准时参加！");
				inforMap.put("sender_id", (String) map.get("emp_id"));
				inforMap.put("receiver_ids", receiverIds);
				inforMap.put("category", "innerInfor");
				inforMap.put("bus_type", "2");
				inforService.sendUpdateInfor(inforMap);
			}
			if ("1".equals(notifyType) || "3".equals(notifyType)) {
				// 发送内IM
				Map<String, Object> imReqMap = new HashMap<String, Object>();
				imReqMap.put("pushType", "1");// 1:个人
				imReqMap.put("appId", imAppId);
				imReqMap.put("sender", vmBusRecord.getHostEmpId());
				imReqMap.put("receiver", receiverIds.split(";"));
				imReqMap.put("msgType", "1");// 1：文本消息
				imReqMap.put("msgContent",
						"您有一场主题为：《" + mtTitile + "》的会议，预计开始时间为："
								+ DateUtil.getDateTimeFormat(
										DateUtil.formatDate(vmBusRecord.getBeginDateTime(), "yyyyMMddHHmmss"))
								+ "请您准时参加！");
				imReqMap.put("msgDomain", "");
				vmvifService.pushMsg(imReqMap);

			}

		}
	}

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
	 * 修改会议
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void updateMeeting(Map<String, Object> map) throws AppException {
		String recordId = (String) map.get("record_id");
		String mtTitile = (String) map.get("mt_titile");
		if (StringUtils.isBlank(recordId)) {
			throw new AppException("请选择会议!");
		}
		if (StringUtils.isBlank(mtTitile)) {
			throw new AppException("会议主题不能为空!");
		}
		// 处理预计开始时间和预计结束时间的格式
		String reqBeginDateTime = (String) map.get("begin_date_time");
		String reqEndDateTime = (String) map.get("end_date_time");
		String beginDateTime = reqBeginDateTime.replace(" ", "").replace("-", "").replace(":", "") + "00";
		String endDateTime = reqEndDateTime.replace(" ", "").replace("-", "").replace(":", "") + "00";
		// 判断开始时间和结束时间的大小
		if (Long.parseLong(beginDateTime) >= Long.parseLong(endDateTime)) {
			throw new AppException("会议的预计结束时间填写有误,必须大于开始时间");
		}
		// 校验会议主题
		VmBusRecordExample example = new VmBusRecordExample();
		example.createCriteria().andMtTitileEqualTo(mtTitile);
		int countByExample = vmBusRecordMapper.countByExample(example);
		if (countByExample >= 2) {
			throw new AppException("会议主题已存在,请重新输入!");
		}

		// 查询会议记录表
		VmBusRecord vmBusRecord = vmBusRecordMapper.selectByPrimaryKey(recordId);
		vmBusRecord.setMtTitile(mtTitile);
		vmBusRecord.setMtAddress((String) map.get("mt_address"));
		vmBusRecord.setBeginDateTime(beginDateTime);
		vmBusRecord.setEndDateTime(endDateTime);
		vmBusRecord.setMtPwd((String) map.get("mt_pwd"));
		vmBusRecord.setMtPwdFlag((String) map.get("mt_pwd_flag"));
		vmBusRecord.setNotifyType((String) map.get("notify_type"));
		vmBusRecord.setCreateFlag((String) map.get("create_flag"));// 是否启动录播
		vmBusRecord.setUpdateDateTime(DateUtil.getCurrentDateTime());
		vmBusRecordMapper.updateByPrimaryKeySelective(vmBusRecord);
		// 获取修改后的参会人员
		String recEmpIds = (String) map.get("rec_emp_ids");
		String[] recEmpArr = recEmpIds.split(";");

		// 获取会议的通知方式
		String notifyType = (String) map.get("notify_type");

		if (map.get("rec_emp_ids") != null) {
			for (String recEmpId : recEmpArr) {
				// 已有的保留,没有的添加,删除的删除
				VmBusPartinExample updatePartinExample = new VmBusPartinExample();
				updatePartinExample.createCriteria().andRecordIdEqualTo(recordId).andRecEmpIdEqualTo(recEmpId);
				int updateCount = vmBusPartinMapper.countByExample(updatePartinExample);
				if (updateCount <= 0) {// 表示是新增人员
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
					vmBusPartin.setMtStatus("0");// 默认参与状态：未参加
					vmBusPartin.setRecType("0");// 设置参与者类型:普通
					vmBusPartinMapper.insertSelective(vmBusPartin);

					// 向新参会人员发送通知
					if ("2".equals(notifyType) || "3".equals(notifyType)) {
						// 发送内部讯息
						Map<String, Object> inforMap = new HashMap<String, Object>();
						inforMap.put("title", "新会议提醒");
						inforMap.put("content",
								"您有一场主题为：《" + mtTitile + "》的会议，预计开始时间为："
										+ DateUtil.getDateTimeFormat(
												DateUtil.formatDate(vmBusRecord.getBeginDateTime(), "yyyyMMddHHmmss"))
										+ "请您准时参加！");
						inforMap.put("sender_id", (String) map.get("emp_id"));
						inforMap.put("receiver_ids", recEmpId);
						inforMap.put("category", "innerInfor");
						inforMap.put("bus_type", "2");
						inforService.sendUpdateInfor(inforMap);
					}
					if ("1".equals(notifyType) || "3".equals(notifyType)) {
						// 发送内IM
						Map<String, Object> imReqMap = new HashMap<String, Object>();
						imReqMap.put("pushType", "1");// 1:个人
						imReqMap.put("appId", imAppId);
						imReqMap.put("sender", vmBusRecord.getHostEmpId());
						imReqMap.put("receiver", new String[] { recEmpId });
						imReqMap.put("msgType", "1");// 1：文本消息
						imReqMap.put("msgContent",
								"您有一场主题为：《" + mtTitile + "》的会议，预计开始时间为："
										+ DateUtil.getDateTimeFormat(
												DateUtil.formatDate(vmBusRecord.getBeginDateTime(), "yyyyMMddHHmmss"))
										+ "请您准时参加！");
						imReqMap.put("msgDomain", "");
						vmvifService.pushMsg(imReqMap);

					}

				}
			}
		}
		// 删除修改后之前存在的参会人员
		List<String> updateRecEmpList = Arrays.asList(recEmpArr);
		// 查询修改之前会议的所有参会人员
		VmBusPartinExample beforePartinExample = new VmBusPartinExample();
		beforePartinExample.createCriteria().andRecordIdEqualTo(recordId);
		List<VmBusPartin> beforeVmBusPartinList = vmBusPartinMapper.selectByExample(beforePartinExample);
		for (VmBusPartin beforeVmBusPartin : beforeVmBusPartinList) {
			String beforeRecEmpId = beforeVmBusPartin.getRecEmpId();
			if (!updateRecEmpList.contains(beforeRecEmpId) && !vmBusRecord.getHostEmpId().equals(beforeRecEmpId)) { // 之前的参会人员别删除
				VmBusPartinExample deleteExample = new VmBusPartinExample();
				deleteExample.createCriteria().andRecordIdEqualTo(recordId).andRecEmpIdEqualTo(beforeRecEmpId);
				vmBusPartinMapper.deleteByExample(deleteExample);

				// 删除参会人员后通知会议已取消
				// 向新参会人员发送通知
				if ("2".equals(notifyType) || "3".equals(notifyType)) {
					// 发送内部讯息
					Map<String, Object> inforMap = new HashMap<String, Object>();
					inforMap.put("title", "会议取消");
					inforMap.put("content",
							"您有一场主题为：《" + mtTitile + "》的会议，预计开始时间为："
									+ DateUtil.getDateTimeFormat(
											DateUtil.formatDate(vmBusRecord.getBeginDateTime(), "yyyyMMddHHmmss"))
									+ "请您准时参加！");
					inforMap.put("sender_id", (String) map.get("emp_id"));
					inforMap.put("receiver_ids", beforeRecEmpId);
					inforMap.put("category", "innerInfor");
					inforMap.put("bus_type", "4");
					inforService.sendUpdateInfor(inforMap);
				}
				if ("1".equals(notifyType) || "3".equals(notifyType)) {
					// 发送内IM
					Map<String, Object> imReqMap = new HashMap<String, Object>();
					imReqMap.put("pushType", "1");// 1:个人
					imReqMap.put("appId", imAppId);
					imReqMap.put("sender", vmBusRecord.getHostEmpId());
					imReqMap.put("receiver", new String[] { beforeRecEmpId });
					imReqMap.put("msgType", "1");// 1：文本消息
					imReqMap.put("msgContent",
							"您有一场主题为：《" + mtTitile + "》的会议，预计开始时间为："
									+ DateUtil.getDateTimeFormat(
											DateUtil.formatDate(vmBusRecord.getBeginDateTime(), "yyyyMMddHHmmss"))
									+ "请您准时参加！");
					imReqMap.put("msgDomain", "");
					vmvifService.pushMsg(imReqMap);

				}
			}
		}
	}

	/**
	 * app端进行中会议列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> appOngoingMeetingList(Map<String, Object> map) throws AppException {

		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString()));
		// 获取redis中员工信息
		Map<String, Object> empdataMap = redisService.getRedis();
		List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");

		List<Map<String, Object>> appOngoingMeetingList = vmCustomMapper.ongoingMeetingList(map);
		if (appOngoingMeetingList != null && appOngoingMeetingList.size() > 0) {
			for (int i = 0; i < appOngoingMeetingList.size(); i++) {
				Map<String, Object> everyMap = appOngoingMeetingList.get(i);
				String recordId = (String) everyMap.get("record_id");// 获取当前的会议记录表ID

				String hostEmpId = (String) everyMap.get("host_emp_id");
				// 查询会议主持人头像
				for (Map<String, Object> empMap : empList) {
					for (String key : empMap.keySet()) {
						if (hostEmpId.equals(key)) {
							everyMap.put("emp_head_photo",
									((Map<String, Object>) empMap.get(key)).get("emp_head_photo"));

						}
					}
				}

				// 遍历参会人员
				VmBusPartinExample example = new VmBusPartinExample();
				example.createCriteria().andRecordIdEqualTo(recordId);
				List<VmBusPartin> vmBusPartinList = vmBusPartinMapper.selectByExample(example);
				List<Map<String, Object>> recEmpList = new ArrayList<Map<String, Object>>();
				if (vmBusPartinList != null && vmBusPartinList.size() > 0) {
					for (VmBusPartin vmBusPartin : vmBusPartinList) {
						// search += vmBusPartin.getRecEmpId() + ";";
						Map<String, Object> vpMap = new HashMap<String, Object>();
						for (Map<String, Object> empMap : empList) {
							for (String key : empMap.keySet()) {
								if (vmBusPartin.getRecEmpId().equals(key)) {
									vpMap.put("emp_id", ((Map<String, Object>) empMap.get(key)).get("emp_code"));
									vpMap.put("emp_name", ((Map<String, Object>) empMap.get(key)).get("emp_name"));
									vpMap.put("emp_head_photo",
											((Map<String, Object>) empMap.get(key)).get("emp_head_photo"));

								}
							}

						}
						recEmpList.add(vpMap);
					}
				}
				everyMap.put("rec_emp_list", recEmpList);

				String roomUrl = (String) everyMap.get("room_url");
				String roomKey = roomUrl.substring(roomUrl.lastIndexOf("=") + 1, roomUrl.length());
				everyMap.put("room_url", Constant.IM_ROOM_URL);
				everyMap.put("room_key", roomKey);
			}
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(appOngoingMeetingList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", pageInfo.getList());
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	/**
	 * app端历史会议列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> appHistoricalMeetingList(Map<String, Object> map) throws AppException {

		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString()));

		// 获取redis中员工信息
		Map<String, Object> empdataMap = redisService.getRedis();
		List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");

		List<Map<String, Object>> dataList = vmCustomMapper.historicalMeetingList(map);
		if (dataList != null && dataList.size() > 0) {
			for (int i = 0; i < dataList.size(); i++) {
				Map<String, Object> everyMap = dataList.get(i);
				String recordId = (String) everyMap.get("record_id");// 获取当前的会议记录表ID

				String hostEmpId = (String) everyMap.get("host_emp_id");
				String empId = (String) map.get("emp_id");
				String empMtStatus = (hostEmpId.equals(empId)) ? "0" : "1";
				everyMap.put("emp_mt_status", empMtStatus);// emp_mt_status:
															// 0：创建，1：受邀
				// 查询会议主持人头像
				// Map<String, Object> hostEmpMap =
				// searchEmpMapByEmpId(hostEmpId);
				// everyMap.put("host_emp_head_photo",
				// hostEmpMap.get("emp_head_photo"));
				for (Map<String, Object> empMap : empList) {
					for (String key : empMap.keySet()) {
						if (hostEmpId.equals(key)) {
							everyMap.put("emp_head_photo",
									((Map<String, Object>) empMap.get(key)).get("emp_head_photo"));

						}
					}
				}

				// 遍历参会人员
				VmBusPartinExample example = new VmBusPartinExample();
				example.createCriteria().andRecordIdEqualTo(recordId);
				List<VmBusPartin> vmBusPartinList = vmBusPartinMapper.selectByExample(example);
				// String search = "";
				List<Map<String, Object>> recEmpList = new ArrayList<Map<String, Object>>();
				if (vmBusPartinList != null && vmBusPartinList.size() > 0) {
					for (VmBusPartin vmBusPartin : vmBusPartinList) {
						// search += vmBusPartin.getRecEmpId() + ";";
						Map<String, Object> vpMap = new HashMap<String, Object>();
						for (Map<String, Object> empMap : empList) {
							for (String key : empMap.keySet()) {
								if (vmBusPartin.getRecEmpId().equals(key)) {
									vpMap.put("emp_id", ((Map<String, Object>) empMap.get(key)).get("emp_code"));
									vpMap.put("emp_name", ((Map<String, Object>) empMap.get(key)).get("emp_name"));
									vpMap.put("emp_head_photo",
											((Map<String, Object>) empMap.get(key)).get("emp_head_photo"));

								}
							}

						}
						recEmpList.add(vpMap);
					}
				}
				everyMap.put("rec_emp_list", recEmpList);
				// 调用contacts服务的commonEmpSearch接口查询
				// Map<String, Object> recMap = new HashMap<String, Object>();
				// recMap.put("type", "0");
				// recMap.put("search", search);
				// Map<String, Object> returnRecMap =
				// contactsService.commonEmpSearch(recMap);
				//
				// @SuppressWarnings("unchecked")
				// List<Map<String, Object>> recEmpList = (List<Map<String,
				// Object>>) returnRecMap.get("data");
				// // List<Map<String,Object>> recEmpList = new
				// // ArrayList<Map<String,Object>>();
				// everyMap.put("rec_emp_list", recEmpList);
			}
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", pageInfo.getList());
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	/**
	 * app端我的会议室会议列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> appMyMeetingList(Map<String, Object> map) throws AppException {

		PageInit.setPage(map);

		// 获取redis中员工信息
		Map<String, Object> empdataMap = redisService.getRedis();
		List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");

		List<Map<String, Object>> recIdList = vmCustomMapper.singleVmGroup(map);
		Map<String, Object> reqMap = new HashMap<String, Object>();
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		if (recIdList != null && recIdList.size() > 0) {
			String[] recIdArr = new String[recIdList.size()];
			for (int i = 0; i < recIdList.size(); i++) {
				String rec_id = recIdList.get(i).get("record_id").toString();
				recIdArr[i] = rec_id;
			}

			reqMap.put("recIdArr", recIdArr);
			reqMap.put("emp_id", (String) map.get("emp_id"));
			List<VmBusRecordDomain> vrList = vmCustomMapper.myAppMeetingList(reqMap);

			if (vrList != null && vrList.size() > 0) {
				for (VmBusRecordDomain vr : vrList) {
					Map<String, Object> dataMap = new HashMap<String, Object>();
					dataMap.put("record_id", vr.getId());
					dataMap.put("mt_titile", vr.getMtTitile());
					dataMap.put("host_emp_id", vr.getHostEmpId());
					dataMap.put("host_emp_name", vr.getHostEmpName());
					dataMap.put("host_org_id", vr.getHostOrgId());
					dataMap.put("host_org_name", vr.getHostOrgName());
					dataMap.put("begin_date_time", vr.getBeginDateTime());
					dataMap.put("end_date_time", vr.getEndDateTime());
					dataMap.put("mt_pwd_flag", vr.getMtPwdFlag());
					dataMap.put("mt_pwd", vr.getMtPwd());
					dataMap.put("notify_type", vr.getNotifyType());
					dataMap.put("emp_mt_status", vr.getEmpMtStatus());
					List<VmBusPartin> partinList = vr.getPartinList();
					List<Map<String, Object>> vpMapList = new ArrayList<Map<String, Object>>();
					if (partinList != null && partinList.size() > 0) {
						for (VmBusPartin vp : partinList) {
							Map<String, Object> vpMap = new HashMap<String, Object>();
							vpMap.put("emp_id", vp.getRecEmpId());
							vpMap.put("emp_name", vp.getRecEmpName());
							// 查询员工头像
							for (Map<String, Object> empMap : empList) {
								for (String key : empMap.keySet()) {
									if (vp.getRecEmpId().equals(key)) {
										vpMap.put("emp_head_photo",
												((Map<String, Object>) empMap.get(key)).get("emp_head_photo"));

									}
								}
							}
							vpMapList.add(vpMap);
						}
					}
					dataMap.put("rec_emp_list", vpMapList);
					dataList.add(dataMap);
				}
			}
		}

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", dataList);

		long count = 0;
		Map<String, Object> countMap = vmCustomMapper.myAppMeetingCount(map);
		if (countMap != null) {
			count = (long) countMap.get("count");
		}
		resMap.put("count", count);
		return resMap;
	}
}
