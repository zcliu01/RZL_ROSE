package com.zrt.gateway.web.contacts.app;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.api.client.contacts.IContactsClient;
import com.zrt.gateway.web.base.BaseController;

/**
 * 常用联系人 接口请求类
 * 
 * @author:ajzhou
 * @date:2017年06月07日下午8:14:02
 * @description TODO
 */
@RestController
@RequestMapping(value = "/v1.0/friendApp", produces = { "application/json;charset=UTF-8" })
public class FriendController extends BaseController {

	@Resource(name = "HystrixContactsClient")
	private IContactsClient ContactsClient;

	/**
	 * 添加常用联系人页
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/friendSavePage", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> friendSavePage(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.friendSavePage(requestMap);
		return response(resultMap);
	}

	/**
	 * 添加常用联系人
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/friendSave", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> friendSave(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.friendSave(requestMap);
		return response(resultMap);
	}

	/**
	 * 解除常用联系人
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/friendDelete", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> friendDelete(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.friendDelete(requestMap);
		return response(resultMap);
	}

	/**
	 * 常用联系人列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/friendList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> friendList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.friendList(requestMap);
		return response(resultMap);
	}

	/**
	 * 常用联系人列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/appUpdateEmpDetails", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> appUpdateEmpDetails(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.appUpdateEmpDetails(requestMap);
		return response(resultMap);
	}

}
