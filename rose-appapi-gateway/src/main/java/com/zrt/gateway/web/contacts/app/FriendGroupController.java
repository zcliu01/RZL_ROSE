package com.zrt.gateway.web.contacts.app;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.api.client.contacts.IContactsClient;
import com.zrt.gateway.api.client.sec.user.ISecUserClient;
import com.zrt.gateway.web.base.BaseController;

/**
 * 常用联系人 接口请求类
 * 
 * @author:ajzhou
 * @date:2017年06月07日下午8:14:02
 * @description TODO
 */
@RestController
@RequestMapping(value="/v1.0/friendGroupApp", produces = { "application/json;charset=UTF-8" })
public class FriendGroupController extends BaseController{

	@Resource(name = "HystrixContactsClient")
	private IContactsClient ContactsClient;
	
	/**
	 * 群组列表
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/friendGroupList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> friendGroupList(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.friendGroupList(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 创建群组
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/friendGroupSave",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> friendGroupSave(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.friendGroupSave(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 群组详情
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectGroupDetails",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> selectGroupDetails(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.selectGroupDetails(requestMap);
		return response(resultMap);
	}
	

	/**
	 * 修改群组信息
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/friendGroupUpdate",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> friendGroupUpdate(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.friendGroupUpdate(requestMap);
		return response(resultMap);
	}
	

	/**
	 * 退出或解散群组
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/groupDismissOrQuit",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> groupDismissOrQuit(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.groupDismissOrQuit(requestMap);
		return response(resultMap);
	}
	

	/**
	 * 添加群组成员页 初始化
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/groupMemberSavePage",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> groupMemberSavePage(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.groupMemberSavePage(requestMap);
		return response(resultMap);
	}
	

	/**
	 * 添加群组成员
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/groupMemberSave",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> groupMemberSave(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.groupMemberSave(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 群组成员列表
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectGroupMemList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> selectGroupMemList(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.selectGroupMemList(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 删除群组成员
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/groupMemDelete",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> groupMemDelete(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.groupMemDelete(requestMap);
		return response(resultMap);
	}

}
