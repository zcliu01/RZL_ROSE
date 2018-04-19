package com.zrt.vm.web.manage.vmmanage;

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
import com.zrt.vm.service.vmmanage.VmmanageService;

@RestController
@RequestMapping("/v1.0/vmmanage")
public class VmmanageController {
	private static final Logger log = LoggerFactory.getLogger(VmmanageController.class);

	@Autowired
	private VmmanageService vmmanageService;

	/**
	 * 获取会议中人员列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/mtPersonList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> mtPersonList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行VmmanageController的mtPersonList方法");

		ResultMap resultMap = new ResultMap();

		try {
			Map<String, Object> resMap = vmmanageService.getMtPersonList(map);
			resultMap.success().sucmsg("获取会议中人员列表成功");
			resultMap.data(resMap);
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("获取会议中人员列表失败!").map();

		}
	}

	/**
	 * 音频屏蔽
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/muteAudio", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> muteAudio(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行VmmanageController的muteAudio方法");

		ResultMap resultMap = new ResultMap();

		try {
			map.put("action", "muteAudio");
			vmmanageService.mtControl(map);
			resultMap.success().sucmsg("单人音频屏蔽成功!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("单人音频屏蔽失败!").map();

		}
	}

	/**
	 * 取消音频屏蔽
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/unmuteAudio", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> unmuteAudio(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行VmmanageController的unmuteAudio方法");

		ResultMap resultMap = new ResultMap();

		try {
			map.put("action", "unmuteAudio");
			vmmanageService.mtControl(map);
			resultMap.success().sucmsg("取消音频屏蔽成功!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("取消单人音频屏蔽失败!").map();

		}
	}

	/**
	 * 全部音频操作（屏蔽与开启）
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	// @RequestMapping(value = "/muteAudioServerAll", method =
	// RequestMethod.POST, headers = "Accept=application/json")
	// public Map<String, Object> muteAudioServerAll(@RequestBody Map<String,
	// Object> map) throws AppException {
	// log.info("Server端执行VmmanageController的muteAudioServerAll方法");
	//
	// ResultMap resultMap = new ResultMap();
	//
	// try {
	// vmmanageService.muteAudioServerAll(map);
	// resultMap.success().sucmsg("全部音频操作成功!");
	// return resultMap.map();
	// } catch (AppException e) {
	// return resultMap.failure().errmsg(e.getMessage()).map();
	// } catch (Exception e) {
	// log.error("json error", e);
	// return resultMap.failure().errmsg("全部音频操作失败!").map();
	//
	// }
	// }

	/**
	 * 视频屏蔽
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/stopVideo", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> stopVideo(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行VmmanageController的stopVideo方法");

		ResultMap resultMap = new ResultMap();

		try {
			vmmanageService.stopVideo(map);
			resultMap.success().sucmsg("单人视频屏蔽成功!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("单人视频屏蔽失败!").map();

		}
	}

	/**
	 * 取消视频屏蔽
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/startVideo", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> startVideo(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行VmmanageController的startVideo方法");

		ResultMap resultMap = new ResultMap();

		try {
			vmmanageService.startVideo(map);
			resultMap.success().sucmsg("取消单人视频屏蔽成功!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("取消单人视频屏蔽失败!").map();

		}
	}

	/**
	 * 全部视频操作（屏蔽与开启）
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/muteVideoServerAll", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> muteVideoServerAll(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行VmmanageController的muteVideoServerAll方法");

		ResultMap resultMap = new ResultMap();

		try {
			vmmanageService.muteVideoServerAll(map);
			resultMap.success().sucmsg("全部视频操作成功!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("全部视频操作失败!").map();

		}
	}

	/**
	 * 踢人
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/leaveConference", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> leaveConference(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行VmmanageController的leaveConference方法");

		ResultMap resultMap = new ResultMap();

		try {
			map.put("action", "leaveConference");
			vmmanageService.mtControl(map);
			resultMap.success().sucmsg("踢人成功!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("踢人失败!").map();

		}
	}

	// /**
	// * 房间加锁
	// *
	// * @param map
	// * @return
	// * @throws AppException
	// */
	// @RequestMapping(value = "/lockRoom", method = RequestMethod.POST, headers
	// = "Accept=application/json")
	// public Map<String, Object> lockRoom(@RequestBody Map<String, Object> map)
	// throws AppException {
	// log.info("Server端执行VmmanageController的lockRoom方法");
	//
	// ResultMap resultMap = new ResultMap();
	//
	// try {
	// vmmanageService.lockRoom(map);
	// resultMap.success().sucmsg("房间加锁成功!");
	// return resultMap.map();
	// } catch (AppException e) {
	// return resultMap.failure().errmsg(e.getMessage()).map();
	// } catch (Exception e) {
	// log.error("json error", e);
	// return resultMap.failure().errmsg("房间加锁失败!").map();
	//
	// }
	// }
	//
	// /**
	// * 移除房间锁
	// *
	// * @param map
	// * @return
	// * @throws AppException
	// */
	// @RequestMapping(value = "/unlockRoom", method = RequestMethod.POST,
	// headers = "Accept=application/json")
	// public Map<String, Object> unlockRoom(@RequestBody Map<String, Object>
	// map) throws AppException {
	// log.info("Server端执行VmmanageController的unlockRoom方法");
	//
	// ResultMap resultMap = new ResultMap();
	//
	// try {
	// vmmanageService.unlockRoom(map);
	// resultMap.success().sucmsg("移除房间锁成功!");
	// return resultMap.map();
	// } catch (AppException e) {
	// return resultMap.failure().errmsg(e.getMessage()).map();
	// } catch (Exception e) {
	// log.error("json error", e);
	// return resultMap.failure().errmsg("移除房间锁失败!").map();
	//
	// }
	// }

	/**
	 * 结束会议
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/disconnectConferenceAll", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> disconnectConferenceAll(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行VmmanageController的disconnectConferenceAll方法");

		ResultMap resultMap = new ResultMap();

		try {
//			map.put("action", "disconnectConferenceAll");
			vmmanageService.disconnectConferenceAll(map);
			resultMap.success().sucmsg("结束会议成功!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("结束会议失败!").map();

		}
	}

	/**
	 * 暂停/继续录制
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/resumeRecod", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> resumeRecod(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行VmmanageController的resumeRecod方法");

		ResultMap resultMap = new ResultMap();

		try {
			vmmanageService.recordControl(map);
			resultMap.success().sucmsg("录制操作成功!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("录制操作失败!").map();

		}
	}

	/**
	 * 加人
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/recAdd", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> recAdd(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行VmmanageController的recAdd方法");

		ResultMap resultMap = new ResultMap();

		try {
			vmmanageService.recAdd(map);
			resultMap.success().sucmsg("加人成功!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("加人失败!").map();

		}
	}

}
