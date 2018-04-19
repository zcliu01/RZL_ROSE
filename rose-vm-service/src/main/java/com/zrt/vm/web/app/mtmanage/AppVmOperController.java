package com.zrt.vm.web.app.mtmanage;

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
import com.zrt.vm.service.appVmoper.AppVmOperService;

@RestController
@RequestMapping("/v1.0/appVmoper")
public class AppVmOperController {
	private static final Logger log = LoggerFactory.getLogger(AppVmOperController.class);

	@Autowired
	private AppVmOperService appVmOperService;

	/**
	 * 发起即时会议
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/launch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> launch(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行AppVmOperController的launch方法");

		ResultMap resultMap = new ResultMap();

		try {
			Map<String, Object> resMap = appVmOperService.appLaunch(map);
			resultMap.success().sucmsg("发起成功!");
			resultMap.data(resMap);
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("发起失败!").map();

		}
	}

	/**
	 * 发起人入会
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/inMeeting", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inMeeting(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行AppVmOperController的inMeeting方法");

		ResultMap resultMap = new ResultMap();

		try {
			appVmOperService.inMeeting(map);
			resultMap.success().sucmsg("入会成功!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("入会失败!").map();

		}
	}

	// /**
	// * 会议临时加人
	// *
	// * @param map
	// * @return
	// * @throws AppException
	// */
	// @RequestMapping(value = "/addPerson", method = RequestMethod.POST,
	// headers = "Accept=application/json")
	// public Map<String, Object> addPerson(@RequestBody Map<String, Object>
	// map) throws AppException {
	// log.info("Server端执行VmOperController的addPerson方法");
	//
	// ResultMap resultMap = new ResultMap();
	//
	// try {
	// appVmOperService.addPerson(map);
	// resultMap.success().sucmsg("加人成功!");
	// return resultMap.map();
	// } catch (AppException e) {
	// return resultMap.failure().errmsg(e.getMessage()).map();
	// } catch (Exception e) {
	// log.error("json error", e);
	// return resultMap.failure().errmsg("加人失败!").map();
	//
	// }
	// }

	/**
	 * 参会人会议响应通知
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/isJoin", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> isJoin(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行AppVmOperController的isJoin方法");

		ResultMap resultMap = new ResultMap();

		try {
			appVmOperService.getIsJoin(map);
			resultMap.success().sucmsg("通知成功!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("通知失败!").map();

		}
	}

	/**
	 * 退出通知
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/quit", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> quit(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行AppVmOperController的quit方法");

		ResultMap resultMap = new ResultMap();

		try {
			appVmOperService.quit(map);
			resultMap.success().sucmsg("通知成功!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("通知失败!").map();

		}
	}

	/**
	 * 会议是否结束
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/isEnd", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> isEnd(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行AppVmOperController的isEnd方法");

		ResultMap resultMap = new ResultMap();

		try {
			Map<String, Object> resMap = appVmOperService.isEnd(map);
			resultMap.success();
			resultMap.data(resMap);
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("查询失败!").map();

		}
	}

}
