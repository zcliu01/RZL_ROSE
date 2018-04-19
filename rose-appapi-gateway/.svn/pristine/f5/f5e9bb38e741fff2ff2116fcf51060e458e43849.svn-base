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
@RequestMapping(value = "/v1.0/appVm", produces = { "application/json;charset=UTF-8" })
public class MeetingController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(MeetingController.class);
	@Resource(name = "HystrixVmClient")
	private IVmClient vmClient;

	/**
	 * 进行中会议列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/ongoingMeetingList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> ongoingMeetingList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppMeetingController中ongoingMeetingList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.ongoingMeetingList(requestMap);
		return response(resultMap);
	}

	/**
	 * 加入会议
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/joinMeeting", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> joinMeeting(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的AppMeetingController中joinMeeting方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.joinMeeting(requestMap);
		return response(resultMap);
	}

	/**
	 * 历史会议列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/historicalMeetingList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> historicalMeetingList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppMeetingController中historicalMeetingList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.historicalMeetingList(requestMap);
		return response(resultMap);
	}

	/**
	 * 我的会议室会议列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/myMeetingList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> myMeetingList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppMeetingController中myMeetingList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.myMeetingList(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 开启会议
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/openMeeting", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> openMeeting(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppMeetingController中openMeeting方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.openMeeting(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 取消会议
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/cancelMeeting", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> cancelMeeting(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppMeetingController中cancelMeeting方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.cancelMeeting(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 新建会议
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveMeeting", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> saveMeeting(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppMeetingController中saveMeeting方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.saveMeeting(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 修改会议
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateMeeting", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> updateMeeting(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的AppMeetingController中updateMeeting方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = vmClient.updateMeeting(requestMap);
		return response(resultMap);
	}
	
	
	
}
