package com.zrt.test;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UserControllerTest.class)
public class UserControllerTest {
	
	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:9000");
		this.template = new TestRestTemplate();
	}
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void userList() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("pageNo", "0");
		messageMap.put("maxResult", "10");
		messageMap.put("begin_entry_time", "2016-02-02");
		messageMap.put("end_entry_time", "2017-04-02");
		
		String result = template.postForObject(base.toString()+"/v1.0/sec/userList", buildEntity(messageMap), String.class);
		System.out.println("-----用户列表查询返回："+result);
		
	}
	/**
	 * 用户信息查询返回
	 * @throws Exception
	 */
	@Test
	public void userSearch() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		//messageMap.put("maxResult", "10");
		String result = template.postForObject(base.toString()+"/v1.0/sec/userSearch", buildEntity(messageMap), String.class);
		System.out.println("-----用户信息查询返回："+result);
		
	}
	
	/**
	 * 用户信息修改返回
	 * @throws Exception
	 */
	@Test
	public void userUpdate() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		//messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("emp_name", "张三");
		messageMap.put("emp_sex", "F");
		String result = template.postForObject(base.toString()+"/v1.0/sec/userUpdate", buildEntity(messageMap), String.class);
		System.out.println("-----用户信息修改返回："+result);
		
	}
    /**
    /**
     * 
     * 用户角色查询
     * @param params
     * @return
     */
	@Test
	public void userRoleList() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("user_id", "3e");
		String result = template.postForObject(base.toString()+"/v1.0/user/userRoleList", buildEntity(messageMap), String.class);
		System.out.println("-----用户角色列表查询返回："+result);
		
	}
    /**
     * 用户新增
     * @param params
     * @return
     */
	@Test
	public void userSave() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("org_id", "000000");
		messageMap.put("parent_org_id", "000000");
		messageMap.put("user_account", "xiaoming");
		messageMap.put("user_password", "123456");
	    messageMap.put("user_name", "小明");
		String result = template.postForObject(base.toString()+"/v1.0/sec/userSave", buildEntity(messageMap), String.class);
		System.out.println("-----用户角色列表查询返回："+result);
		
	}
	 /**
     * 用户状态
     * @param params
     * @return
     */
	@Test
	public void userStatusUpdate() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("sec_enabled", "0");
		messageMap.put("emp_enabled", "0");
		String result = template.postForObject(base.toString()+"/v1.0/sec/userStatusUpdate", buildEntity(messageMap), String.class);
		System.out.println("-----用户状态返回："+result);
		
	}
	
	
    /**
     * 用户角色新增
     * @param params
     * @return
     */
	@Test
	public void userRoleSave() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		
		List<Map<String,Object>> list=new ArrayList<>();
		Map<String,Object> roleMap1 = new HashMap<String,Object>();
		roleMap1.put("role_id", "042f16e3bb444c11b0b26a69cb71f804");
		Map<String,Object> roleMap2 = new HashMap<String,Object>();
		roleMap2.put("role_id", "ca07ef01-6d18-11e7-90f1-0050569b");
		list.add(roleMap1);
		list.add(roleMap2);
		
		messageMap.put("param", list);
		
		List<Map<String,Object>> paramEmpList=new ArrayList<>();
		Map<String,Object> empMap=new HashMap<>();
		empMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		paramEmpList.add(empMap);
		
		messageMap.put("param_emp", paramEmpList);
		
		
		String result = template.postForObject(base.toString()+"/v1.0/sec/userRoleSave", buildEntity(messageMap), String.class);
		System.out.println("-----用户角色绑定返回："+result);
		
	}
	
	
	 /**
     * 修改登录密码
     * @param params
     * @return
     */
	@Test
	public void userPwdSet() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("old_pwd", "123456");
		messageMap.put("new_pwd", "000000");
		messageMap.put("confirm_new_pwd", "000000");
		String result = template.postForObject(base.toString()+"/v1.0/sec/userPwdSet", buildEntity(messageMap), String.class);
		System.out.println("-----用户状态返回："+result);
		
	}

		@Test
		public void oa() throws Exception {
			Map<String,Object> messageMap = new HashMap<String,Object>();
			messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
			messageMap.put("old_pwd", "123456");
			messageMap.put("new_pwd", "000000");
			messageMap.put("confirm_new_pwd", "000000");
			Object result = template.getForObject("http://172.30.142.170/ucdm/admin/usermanage/oa/add?userName=ldw&cnName=张三",Object.class);
			System.out.println("-----用户状态返回："+result);
			
		}
	
	
	private HttpEntity<String> buildEntity(Map<String,Object> params){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}
	/*
	public static void main(String[] args) {
		BigDecimal b1=new BigDecimal(100000000);
		BigDecimal b2=new BigDecimal(3);
		System.out.println(b1.divide(b2,100,BigDecimal.ROUND_HALF_UP));
	}*/
}
