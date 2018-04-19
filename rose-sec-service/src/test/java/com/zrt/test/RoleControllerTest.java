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
@SpringApplicationConfiguration(classes = RoleControllerTest.class)
public class RoleControllerTest {
	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:9000");
		this.template = new TestRestTemplate();
	}
	
	
	/**
	 * 角色信息查询
	 * @throws Exception
	 */
	@Test
	public void roleSearch() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("role_id", "ca07e3c0-6d18-11e7-90f1-0050569b");
		
	    String result = template.postForObject(base.toString()+"/v1.0/sec/roleSearch", buildEntity(messageMap), String.class);
		System.out.println("-----角色列表查询返回："+result);
	}
	/**
	 * 用户角色查询
	 * @throws Exception
	 */
	@Test
	public void roleList() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("pageNo", "0");
		messageMap.put("maxResult", "10");
		messageMap.put("role_code", "0003");
		messageMap.put("role_name", "普通角色修改");
		
	    String result = template.postForObject(base.toString()+"/v1.0/sec/roleList", buildEntity(messageMap), String.class);
		System.out.println("-----角色列表查询返回："+result);
	}
	/**
	 * 用户角色更新
	 * @throws Exception
	 */
	@Test
	public void roleUpdate() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("role_id", "042f16e3bb444c11b0b26a69cb71f804");
		messageMap.put("role_code", "09090");
		messageMap.put("role_name", "新增角色修改");
		messageMap.put("role_desc", "知道了");
	    String result = template.postForObject(base.toString()+"/v1.0/sec/roleUpdate", buildEntity(messageMap), String.class);
		System.out.println("-----角色更改返回："+result);
	}
	
	/**
	 * 用户一级菜单查询
	 * @throws Exception
	 */
	@Test
	public void roleMenuList() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
//		messageMap.put("role_id", "6bb9ee5c-70de-11e7-90f1-0050569b");
		messageMap.put("role_id", "ca07ef01-6d18-11e7-90f1-0050569b");
	    String result = template.postForObject(base.toString()+"/v1.0/sec/roleMenuList", buildEntity(messageMap), String.class);
		System.out.println("-----角色一级菜单查询返回："+result);
	}
	/**
	 * 用户角色删除
	 * @throws Exception
	 */
	@Test
	public void roleDelete() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		/*messageMap.put("pageNo", "0");
		messageMap.put("maxResult", "10");	*/	
		messageMap.put("role_id", "1");
	    String result = template.postForObject(base.toString()+"/v1.0/sec/roleDelete", buildEntity(messageMap), String.class);
		System.out.println("-----角色删除返回："+result);
	}
	/**
	 * 根据角色查询用户信息
	 * @throws Exception
	 */
	@Test
	public void roleUserList() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();			
		messageMap.put("role_id", "e7743e8a83b5482d96d2bf8df8679cb4");
		messageMap.put("pageNo", "0");
		messageMap.put("maxResult", "10");
		messageMap.put("begin_entry_time", "2000-02-02");
		messageMap.put("end_entry_time", "2017-04-02");
		
	    String result = template.postForObject(base.toString()+"/v1.0/sec/roleUserList", buildEntity(messageMap), String.class);
		System.out.println("-----根据角色查询用户信息返回："+result);
	}
	
	/**
	 * 角色菜单资源查询
	 * @throws Exception
	 */
	@Test
	public void roleResourceSearch() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();			
		messageMap.put("role_id", "ca07e3c0-6d18-11e7-90f1-0050569b");
		messageMap.put("root_menu_code", "vm00");
		
	    String result = template.postForObject(base.toString()+"/v1.0/sec/roleResourceSearch", buildEntity(messageMap), String.class);
		System.out.println("-----根据角色查询用户信息返回："+result);
	}
	
	/**
	 * 角色新增
	 * @throws Exception
	 */
	@Test
	public void roleSave() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();			
		messageMap.put("role_code", "001");
		messageMap.put("role_name", "新增角色");
		messageMap.put("role_desc", "新增角色说明");
	    String result = template.postForObject(base.toString()+"/v1.0/sec/roleSave", buildEntity(messageMap), String.class);
		System.out.println("-----角色新增返回："+result);
	}
	
	
	
	/**
	 * 角色删除
	 * @throws Exception
	 */
	@Test
	public void roleEmpDelete() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();			
		messageMap.put("role_id", "1");
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
	    String result = template.postForObject(base.toString()+"/v1.0/sec/roleEmpDelete", buildEntity(messageMap), String.class);
		System.out.println("-----根据角色查询用户信息返回："+result);
	}
	
	/**
	 * 角色批量删除
	 * @throws Exception
	 */
	@Test
	public void roleEmpBatchDelete() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();				
	    List<Map<String,Object>> emplist = new ArrayList<Map<String,Object>>();	    
	    Map<String,Object> appMap1 = new HashMap<String,Object>();
	    Map<String,Object> appMap2 = new HashMap<String,Object>();
	    appMap1.put("emp_id", "2f960dea-4388-11e7-b66c-3c970e5c");
	    appMap2.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
	    emplist.add(appMap1);
		emplist.add(appMap2);
		messageMap.put("role_id","1");
		messageMap.put("param",emplist);	    
	    String result = template.postForObject(base.toString()+"/v1.0/sec/roleEmpBatchDelete", buildEntity(messageMap), String.class);
		System.out.println("-----根据角色查询用户信息返回："+result);
	}
	/**
	 * 角色绑定员工
	 * @throws Exception
	 */
	@Test
	public void roleEmpAdd() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();				
	     messageMap.put("emp_code", "2909");
	     messageMap.put("role_id", "1");
	    String result = template.postForObject(base.toString()+"/v1.0/sec/roleEmpAdd", buildEntity(messageMap), String.class);
		System.out.println("-----根据角色查询用户信息返回："+result);
	}
	private HttpEntity<String> buildEntity(Map<String,Object> params){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}
	public static void main(String[] args) {
		BigDecimal b1=new BigDecimal(100000000);
		BigDecimal b2=new BigDecimal(3);
		System.out.println(b1.divide(b2,100,BigDecimal.ROUND_HALF_UP));
	}
}
