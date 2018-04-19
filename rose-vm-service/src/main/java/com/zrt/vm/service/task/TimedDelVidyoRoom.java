package com.zrt.vm.service.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.commons.date.DateUtil;
import com.zrt.mybatis.domain.VmBusPartin;
import com.zrt.mybatis.domain.VmBusPartinExample;
import com.zrt.mybatis.domain.VmBusRecord;
import com.zrt.mybatis.domain.VmBusRecordExample;
import com.zrt.mybatis.domain.VmBusVidyoRoom;
import com.zrt.mybatis.domain.VmBusVidyoRoomExample;
import com.zrt.mybatis.mapper.VmBusPartinMapper;
import com.zrt.mybatis.mapper.VmBusRecordMapper;
import com.zrt.mybatis.mapper.VmBusVidyoRoomMapper;
import com.zrt.vm.mapper.mtmanage.VmVedioMapper;
import com.zrt.vm.service.appVmoper.AppVmOperServiceImpl;
import com.zrt.vm.service.runnable.CreatRoomThread;
import com.zrt.vm.service.vmvif.VmvifService;

@Service
public class TimedDelVidyoRoom {

	private static final Logger log = LoggerFactory.getLogger(TimedDelVidyoRoom.class);

	@Value("${vidyo.recordURL}")
	private String recordURL;
	@Autowired
	private VmBusRecordMapper vmBusRecordMapper;
	@Autowired
	private VmBusPartinMapper vmBusPartinMapper;
	@Autowired
	private VmvifService vmvifService;
	@Autowired
	private VmVedioMapper vedioMapper;
	@Autowired
	private VmBusVidyoRoomMapper vmBusVidyoRoomMapper;
	@Autowired
	private CreatRoomThread creatRoomThread;

	@Scheduled(cron = "${vm.deleteVidyo.time}") // 每天2点执行一次
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void delRoom() throws InterruptedException {

		String curDate = DateUtil.getCurrentDateTime();

		// 根据OA记录表查询会议状态没有结束的记录去删除publicRoom
		VmBusRecordExample example = new VmBusRecordExample();
		example.createCriteria().andMtStatusEqualTo("1");// 会议状态为未结束
		List<VmBusRecord> vbrList = vmBusRecordMapper.selectByExample(example);
		if (vbrList != null && vbrList.size() > 0) {
			log.info("根据OA记录表查询到有空闲视频房间，开始执行删除任务！");
			for (VmBusRecord vbr : vbrList) {
				vbr.setMtStatus("2");
				vbr.setRealEndDateTime(curDate);

				if ("1".equals(vbr.getVideoFlag())) {// 1为启动录播状态
					Map<String, Object> recordReqMap = new HashMap<String, Object>();
					recordReqMap.put("room_id", vbr.getRoomId());
					recordReqMap.put("video_flag", "3");// 3:停止录制
					vmvifService.recordControl(recordReqMap);
					vbr.setVideoStatus("3");// 3:会议状态结束

					// 获取URL
					Thread.sleep(3000);
					Map<String, Object> urlReqMap = new HashMap<String, Object>();
					urlReqMap.put("ownerName", vbr.getAuthName());
					urlReqMap.put("roomName", vbr.getRoomName());
					Map<String, Object> urlResMap = vmvifService.recordsSearch(urlReqMap);
					String guid = (String) urlResMap.get("guid");
					String vidyoURL = recordURL + guid + ".flv";
					vbr.setVideoUrl(vidyoURL);
				}

				Integer roomId = vbr.getRoomId();
				if (StringUtils.isNotBlank(String.valueOf(roomId))) {
					Map<String, Object> delReqMap = new HashMap<String, Object>();
					delReqMap.put("room_id", roomId);
					vmvifService.deleteRoom(delReqMap);// 删除视频房间
					// 删除预存视频房间表的记录
					VmBusVidyoRoomExample example2 = new VmBusVidyoRoomExample();
					example2.createCriteria().andRoomIdEqualTo(roomId);
					List<VmBusVidyoRoom> vidyoRoomList = vmBusVidyoRoomMapper.selectByExample(example2);
					if (vidyoRoomList != null && vidyoRoomList.size() > 0) {
						vmBusVidyoRoomMapper.deleteByExample(example2);

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

				vmBusRecordMapper.updateByPrimaryKeySelective(vbr);// 修改会议记录表

				// 参会人员表修改参会结束时间
				String recordId = vbr.getId();
				Map<String, Object> recEmpMap = new HashMap<String, Object>();
				recEmpMap.put("record_id", recordId);
				List<Map<String, Object>> recEmpList = vedioMapper.getRevEmpIds(recEmpMap);// 获取参会人id
				if (recEmpList != null && recEmpList.size() > 0) {
					for (Map<String, Object> recEmpIdMap : recEmpList) {
						String recEmpId = (String) recEmpIdMap.get("rec_emp_id");
						VmBusPartinExample partinExample = new VmBusPartinExample();
						partinExample.createCriteria().andRecordIdEqualTo(recordId).andRecEmpIdEqualTo(recEmpId);
						VmBusPartin vmBusPartin = vmBusPartinMapper.selectByExample(partinExample).get(0);
						if (StringUtils.isBlank(vmBusPartin.getEndDateTime())) {
							vmBusPartin.setEndDateTime(curDate);
							vmBusPartinMapper.updateByPrimaryKeySelective(vmBusPartin);
						}
					}
				}
			}
		}

		// 直接查询vidyo后台，如果有未释放的publicRoom就删除
		@SuppressWarnings("unchecked")
		Map<String, Object> roomMap = (Map<String, Object>) vmvifService.getRooms().get("data");
		@SuppressWarnings("unchecked")
		List<Integer> roomIdList = (List<Integer>) roomMap.get("roomIdList");
		if (roomIdList != null && roomIdList.size() > 0) {
			log.info("直接在vidyo后台查询到有空闲视频房间！");
			for (Integer roomId : roomIdList) {
				Map<String, Object> delReqMap = new HashMap<String, Object>();
				delReqMap.put("room_id", roomId);
				VmBusRecordExample exampleRoom = new VmBusRecordExample();
				exampleRoom.createCriteria().andRoomIdEqualTo(roomId);// 代表改房间在业务中使用过
				List<VmBusRecord> roomidList = vmBusRecordMapper.selectByExample(exampleRoom);
				if (roomidList != null && roomidList.size() > 0) {
					vmvifService.deleteRoom(delReqMap);// 删除视频房间
					// 删除预存视频房间表的记录
					VmBusVidyoRoomExample example2 = new VmBusVidyoRoomExample();
					example2.createCriteria().andRoomIdEqualTo(roomId);
					List<VmBusVidyoRoom> vidyoRoomList = vmBusVidyoRoomMapper.selectByExample(example2);
					if (vidyoRoomList != null && vidyoRoomList.size() > 0) {
						vmBusVidyoRoomMapper.deleteByExample(example2);

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
			log.info("直接在vidyo后台删除视频房间成功！");
		}

		log.info("2点执行删除视频房间任务结束！");
	}
}
