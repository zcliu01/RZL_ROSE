package com.zrt.gateway.web.contacts.manage;

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
import com.zrt.gateway.api.client.contacts.IContactsClient;
import com.zrt.gateway.web.base.BaseController;

/**
 * 权限系统用户管理模块接口请求类
 * 
 * @author:ajzhou
 * @date:2017年6月07日15:14
 * @description TODO
 */
@RestController
@RequestMapping(value="/v1.0/friendGroup", produces = { "application/json;charset=UTF-8" })
public class GroupController extends BaseController{
	private static final Logger log = LoggerFactory.getLogger(GroupController.class);
	@Resource(name = "HystrixContactsClient")
	private IContactsClient ContactsClient;
	
	
	/**
	 * 查找群组
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/friendGroupTree",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> friendGroupTree(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的GroupController中friendGroupTree方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.friendGroupTree(requestMap);
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
		log.info("Server端的GroupController中friendGroupSave方法");
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
	@RequestMapping(value = "/friendGroupDetails",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> friendGroupDetails(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的GroupController中friendGroupDetails方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.friendGroupDetails(requestMap);
		return response(resultMap);
	}
	

	/**
	 * 解散群组或者退出群组
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/groupDismissOrQuit",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> groupDismissOrQuit(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的GroupController中groupDismissOrQuit方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.groupDismissOrQuit(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 更新群组
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/friendGroupUpdate",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> friendGroupUpdate(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的GroupController中friendGroupUpdate方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.friendGroupUpdate(requestMap);
		return response(resultMap);
	}
	

}
