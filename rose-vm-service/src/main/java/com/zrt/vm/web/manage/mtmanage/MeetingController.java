package com.zrt.vm.web.manage.mtmanage;

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
import com.zrt.vm.service.mtmanage.MeetingService;

@RestController
@RequestMapping("/v1.0/vm")
public class MeetingController {
	private static final Logger log = LoggerFactory.getLogger(MeetingController.class);

	@Autowired
	private MeetingService meetingService;

	/**
	 * web端进行中会议列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/ongoingMeetingList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> ongoingMeetingList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行MeetingController的ongoingMeetingList方法");

		ResultMap resultMap = new ResultMap();

		try {

			Map<String, Object> resMap = meetingService.ongoingMeetingList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("获取进行中会议列表失败!").map();

		}
	}

	/**
	 * web端加入会议
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/joinMeeting", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> joinMeeting(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行MeetingController的joinMeeting方法");

		ResultMap resultMap = new ResultMap();

		try {
			meetingService.joinMeeting(map);
			resultMap.success().sucmsg("成功加入会议!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("加入会议失败!").map();

		}
	}

	/**
	 * web端历史会议列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/historicalMeetingList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> historicalMeetingList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行MeetingController的historicalMeetingList方法");

		ResultMap resultMap = new ResultMap();

		try {
			Map<String, Object> resMap = meetingService.historicalMeetingList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("获取历史会议列表失败!").map();

		}
	}

	/**
	 * web端我的会议列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/myMeetingList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> myMeetingList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行MeetingController的myMeetingList方法");

		ResultMap resultMap = new ResultMap();

		try {
			Map<String, Object> resMap = meetingService.myMeetingList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("获取我的会议室会议列表失败!").map();

		}
	}

	/**
	 * web端开启会议
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/openMeeting", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> openMeeting(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行MeetingController的openMeeting方法");

		ResultMap resultMap = new ResultMap();

		try {
			meetingService.openMeeting(map);
			resultMap.success().sucmsg("成功开启会议!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("开启会议失败!").map();

		}
	}

	/**
	 * web端取消会议
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/cancelMeeting", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> cancelMeeting(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行MeetingController的cancelMeeting方法");

		ResultMap resultMap = new ResultMap();

		try {
			meetingService.cancelMeeting(map);
			resultMap.success().sucmsg("成功取消会议!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("取消会议失败!").map();

		}
	}

	/**
	 * web端新建会议
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/saveMeeting", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> saveMeeting(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行MeetingController的saveMeeting方法");

		ResultMap resultMap = new ResultMap();

		try {
			meetingService.saveMeeting(map);
			resultMap.success().sucmsg("新建会议成功!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("新建会议失败!").map();

		}
	}

	/**
	 * web端修改会议
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/updateMeeting", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> updateMeeting(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行MeetingController的updateMeeting方法");

		ResultMap resultMap = new ResultMap();

		try {
			meetingService.updateMeeting(map);
			resultMap.success().sucmsg("修改会议成功!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("修改会议失败!").map();

		}
	}
}
