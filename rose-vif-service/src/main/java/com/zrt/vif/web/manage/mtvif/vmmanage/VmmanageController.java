package com.zrt.vif.web.manage.mtvif.vmmanage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.vif.service.mtvif.vmmanage.VmmanageService;

@RestController
@RequestMapping("/v1.0/vmmanag")
public class VmmanageController {
	private static final Logger log = LoggerFactory.getLogger(VmmanageController.class);
	@Autowired
	private VmmanageService vmmanageService;

	/**
	 * 创建视频会议室
	 */
	@RequestMapping(value = "/createPublicRoom", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> createPublicRoom(@RequestBody Map<String, Object> map) throws Exception {
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vmmanageService.createPublicRoom(map);
			resultMap.data(resMap);
			resultMap.success().sucmsg("创建视频会议室成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("创建视频会议室失败!").map();
		}
	}

	/**
	 * 删除视频会议室
	 */
	@RequestMapping(value = "/deleteRoom", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> deleteRoom(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VmmanageController中deleteRoom方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vmmanageService.deleteRoom(map);
			resultMap.data(resMap.get("data"));
			resultMap.success().sucmsg("删除视频会议室成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("删除视频会议室失败!").map();
		}
	}

	/**
	 * 单人音频屏蔽操作
	 */
	@RequestMapping(value = "/audioSingleControl", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> audioSingleControl(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VmmanageController中audioSingleControl方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vmmanageService.audioSingleControl(map);
			resultMap.data(resMap.get("data"));
			resultMap.success().sucmsg("单人音频操作成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("单人音频操作失败!").map();
		}
	}

	/**
	 * 屏蔽/开启全部音频
	 */
	@RequestMapping(value = "/muteAudioServerAll", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> muteAudioServerAll(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VmmanageController中muteAudioServerAll方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vmmanageService.audioAllControl(map);
			resultMap.data(resMap.get("data"));
			resultMap.success().sucmsg("全部音频操作成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("全部音频操作失败!").map();
		}
	}

	/**
	 * 单人视频屏蔽操作
	 */
	@RequestMapping(value = "/videoSingleControl", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> videoSingleControl(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VmmanageController中videoSingleControl方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vmmanageService.videoSingleControl(map);
			resultMap.data(resMap.get("data"));
			resultMap.success().sucmsg("单人视频操作成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("单人视频操作失败!").map();
		}
	}

	/**
	 * 屏蔽/开启全部视频
	 */
	@RequestMapping(value = "/muteVideoServerAll", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> muteVideoServerAll(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VmmanageController中muteVideoServerAll方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vmmanageService.videoAllControl(map);
			resultMap.data(resMap.get("data"));
			resultMap.success().sucmsg("全部视频操作成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("全部视频操作失败!").map();
		}
	}

	/**
	 * 踢人
	 */
	@RequestMapping(value = "/leaveConference", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> leaveConference(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VmmanageController中leaveConference方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vmmanageService.leaveConference(map);
			resultMap.data(resMap.get("data"));
			resultMap.success().sucmsg("踢人成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("踢人失败!").map();
		}
	}

	/**
	 * 设置密码
	 */
	@RequestMapping(value = "/createRoomPIN", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> createRoomPIN(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VmmanageController中createRoomPIN方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vmmanageService.createRoomPIN(map);
			resultMap.data(resMap.get("data"));
			resultMap.success().sucmsg("设置成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("设置失败!").map();
		}
	}

	/**
	 * 移除密码
	 */
	@RequestMapping(value = "/removeRoomPIN", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> removeRoomPIN(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VmmanageController中removeRoomPIN方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vmmanageService.removeRoomPIN(map);
			resultMap.data(resMap.get("data"));
			resultMap.success().sucmsg("移除密码成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("移除密码失败!").map();
		}
	}

	/**
	 * 房间加锁
	 */
	@RequestMapping(value = "/lockRoom", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> lockRoom(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VmmanageController中lockRoom方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vmmanageService.lockRoomControl(map);
			resultMap.data(resMap.get("data"));
			resultMap.success().sucmsg("房间加锁成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("房间加锁失败!").map();
		}
	}

	/**
	 * 移除房间锁
	 */
	@RequestMapping(value = "/unlockRoom", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> unlockRoom(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VmmanageController中unlockRoom方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vmmanageService.lockRoomControl(map);
			resultMap.data(resMap.get("data"));
			resultMap.success().sucmsg("移除房间锁成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("移除房间锁失败!").map();
		}
	}

	/**
	 * 结束会议
	 */
	@RequestMapping(value = "/disconnectConferenceAll", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> disconnectConferenceAll(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VmmanageController中disconnectConferenceAll方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vmmanageService.disconnectConferenceAll(map);
			resultMap.data(resMap);
			resultMap.success().sucmsg("结束会议成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("结束会议失败!").map();
		}
	}

	/**
	 * 录制管理
	 */
	@RequestMapping(value = "/recordControl", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> recordControl(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VmmanageController中recordControl方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vmmanageService.recordControl(map);
			resultMap.data(resMap.get("data"));
			resultMap.success().sucmsg("录制操作成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("录制操作失败!").map();
		}
	}

	/**
	 * 获取录制视频URL
	 */
	@RequestMapping(value = "/recordsSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> recordsSearch(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VmmanageController中recordsSearch方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vmmanageService.recordsSearch(map);
			resultMap.data(resMap);
			resultMap.success().sucmsg("获取视频URL成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("获取视频URL失败!").map();
		}
	}

	/**
	 * 获取视频房间在线人数
	 */
	@RequestMapping(value = "/linePerson", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> linePerson(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VmmanageController中linePerson方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vmmanageService.getLinePerson(map);
			resultMap.data(resMap);
			resultMap.success().sucmsg("获取视频房间在线人数成功!");
			log.info("Server端的VmmanageController中linePerson方法 end" + resultMap.map().toString());
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("获取视频房间在线人数失败!").map();
		}
	}

	/**
	 * 获取所有的视频房间
	 */
	@RequestMapping(value = "/getRooms", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> getRooms() throws Exception {
		log.info("Server端的VmmanageController中getRooms方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vmmanageService.getRooms();
			resultMap.data(resMap);
			resultMap.success().sucmsg("获取所有的视频房间成功!");
			log.info("Server端的VmmanageController中linePerson方法 end" + resultMap.map().toString());
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("获取所有的视频房间失败!").map();
		}
	}

}
