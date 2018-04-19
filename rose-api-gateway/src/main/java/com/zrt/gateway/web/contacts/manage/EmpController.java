package com.zrt.gateway.web.contacts.manage;

import java.util.Date;
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
 * 系统员工模块接口请求类
 * 
 * @author:ajzhou
 * @date:2017年6月26日14:27:57
 * @description TODO
 */
@RestController
@RequestMapping(value = "/v1.0/empSearchWindow", produces = { "application/json;charset=UTF-8" })
public class EmpController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(EmpController.class);
	@Resource(name = "HystrixContactsClient")
	private IContactsClient ContactsClient;

	/**
	 * 通用的联系人检索功能
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commonEmpSearch", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> commonEmpSearch(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的EmpSearchWindowController中commonEmpSearch方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.commonEmpSearch(requestMap);
		return response(resultMap);
	}

	/**
	 * 联系人树形图 -- 常用联系人、组织机构、我的群组、待撤销部门
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/moreMateSearchTree", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> moreMateSearchTree(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的EmpSearchWindowController中moreMateSearchTree方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.moreMateSearchTree(requestMap);
		return response(resultMap);
	}

	/**
	 * 根据部门查员工
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectByOrg", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> selectByOrg(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的EmpSearchWindowController中selectByOrg方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.selectByOrg(requestMap);
		return response(resultMap);
	}
}
