package com.zrt.gateway.web.sec.user;

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
import com.zrt.gateway.api.client.sec.ISecUserClient;
import com.zrt.gateway.web.base.BaseController;

/**
 * 权限系统用户管理模块接口请求类
 * 
 * @author:wwfu
 * @date:2017年3月22日下午8:14:02
 * @description TODO
 */
@RestController
@RequestMapping(value="/v1.0/sec", produces = { "application/json;charset=UTF-8" })
public class SecUserController extends BaseController{

	@Resource(name = "HystrixSecUserClient")
	private ISecUserClient secUserClient;
	
	/**
	 * 用户列表查询
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> queryDepositStas(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.userList(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 用户信息查询
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userSearch",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> userSearch(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.userSearch(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 用户新增
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userSave",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> userSave(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.userSave(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 用户更新
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userUpdate",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> userUpdate(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.userUpdate(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 用户删除
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userDelete",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> userDelete(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.userDelete(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 用户角色列表
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userRoleList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> userRoleList(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.userRoleList(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 用户角色保存
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userRoleSave",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> userRoleSave(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.userRoleSave(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 用户密码重置
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userPwdReSet",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> userPwdReSet(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.userPwdReSet(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 用户密码设置
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userPwdSet",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> userPwdSet(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = secUserClient.userPwdSet(requestMap);
		return response(resultMap);
	}

	/**
	 * 员工列表查询
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/empList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> empList(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.empList(requestMap);
		return response(resultMap);
	}
	/**
	 * 员工状态
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userStatusUpdate",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> userStatusUpdate(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.userStatusUpdate(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 员工角色批量绑定
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userRoleBatchSave",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> userRoleBatchSave(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.userRoleBatchSave(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 用户密码设置
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userPwdBatchReSet",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> userPwdBatchReSet(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.userPwdBatchReSet(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 用户密码设置
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userSync",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> userSync(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.userSync(requestMap);
		return response(resultMap);
	}
	/**
	 * 登录类型设置
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/loginTypeSet",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> loginTypeSet(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.loginTypeSet(requestMap);
		return response(resultMap);
	}


}
