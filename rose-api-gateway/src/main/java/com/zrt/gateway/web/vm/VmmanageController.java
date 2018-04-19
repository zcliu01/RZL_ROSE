package com.zrt.gateway.web.vm;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.api.client.vm.IVmClient;
import com.zrt.gateway.web.base.BaseController;

/**
 * 会议管理模块接口请求类
 * 
 * @author:
 * @date:
 * @description TODO
 */

@RestController
@RequestMapping(value = "/v1.0/vmmanage", produces = { "application/json;charset=UTF-8" })
public class VmmanageController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(VmmanageController.class);
	@Resource(name = "HystrixVmClient")
	private IVmClient vmClient;

	/**
	 * 进行中会议人员列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mtPersonList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> mtPersonList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VmmanageController中mtPersonList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.mtPersonList(requestMap);
		return response(resultMap);
	}

	/**
	 * 音频屏蔽
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/muteAudio", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> muteAudio(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VmmanageController中muteAudio方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.muteAudio(requestMap);
		return response(resultMap);
	}

	/**
	 * 取消音频屏蔽
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/unmuteAudio", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> unmuteAudio(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VmmanageController中unmuteAudio方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.unmuteAudio(requestMap);
		return response(resultMap);
	}

	/**
	 * 视频屏蔽
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/stopVideo", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> stopVideo(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VmmanageController中stopVideo方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.stopVideo(requestMap);
		return response(resultMap);
	}

	/**
	 * 取消视频屏蔽
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/startVideo", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> startVideo(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VmmanageController中startVideo方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.startVideo(requestMap);
		return response(resultMap);
	}

	/**
	 * 踢人
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/leaveConference", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> leaveConference(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的VmmanageController中leaveConference方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.leaveConference(requestMap);
		return response(resultMap);
	}

	/**
	 * 结束会议
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/disconnectConferenceAll", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> disconnectConferenceAll(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的VmmanageController中disconnectConferenceAll方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.disconnectConferenceAll(requestMap);
		return response(resultMap);
	}

	/**
	 * 暂停、继续录制视频
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/resumeRecod", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> resumeRecod(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VmmanageController中resumeRecod方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.resumeRecod(requestMap);
		return response(resultMap);
	}

	/**
	 * 暂停、继续录制视频
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/recAdd", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> recAdd(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的VmmanageController中recAdd方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.recAdd(requestMap);
		return response(resultMap);
	}

}
