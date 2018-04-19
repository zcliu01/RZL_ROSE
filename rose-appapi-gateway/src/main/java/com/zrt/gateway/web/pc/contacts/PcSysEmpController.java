package com.zrt.gateway.web.pc.contacts;

import java.util.HashMap;
import java.util.List;
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
 * 系统员工和部门 接口请求类
 * 
 * @author:ajzhou
 * @date:2017年06月07日下午8:14:02
 * @description TODO
 */
@RestController
@RequestMapping(value="/v1.0/empSearchPc", produces = { "application/json;charset=UTF-8" })
public class PcSysEmpController extends BaseController{

	@Resource(name = "HystrixContactsClient")
	private IContactsClient ContactsClient;
	
	/**
	 * 首页员工和部门列表
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/contactsList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> contactsList(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.contactsList(requestMap);
		List<Map<String,Object>> dataList=(List<Map<String,Object>>)resultMap.get("data");
		if(!dataList.isEmpty()){
			resultMap.put("data", dataList.get(0));

		}else{
			resultMap.put("data", new HashMap<String,Object>());
		}
		return response(resultMap);
	}
	
	/**
	 * 员工详情
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectEmpDetails",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> selectEmpDetails(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.selectEmpDetails(requestMap);
		return response(resultMap);
	}

	/**
	 * 职位详情
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectEmpPositionDetails",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> selectEmpPositionDetails(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.selectEmpPositionDetails(requestMap);
		return response(resultMap);
	}

	/**
	 * 员工履历信息
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectEmpWorkRedeploy",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> selectEmpWorkRedeploy(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.selectEmpWorkRedeploy(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 部门员工列表
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/empListByOrg",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> empListByOrg(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.empListByOrg(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 批量联系人检索
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commonEmpSearch",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> commonEmpSearch(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.commonEmpSearch(requestMap);
		return response(resultMap);
	}
	
	/**
	 * IM同步组织通讯录
	 * @param requestMap
	 * @returnff
	 * @throws Exception
	 */
	@RequestMapping(value = "/contactsImList",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> contactsImList(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = ContactsClient.contactsImList(requestMap);
		return response(resultMap);
	}

}
