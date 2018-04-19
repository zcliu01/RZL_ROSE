package com.zrt.contacts.web.manage.friend;

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
@SpringApplicationConfiguration(classes = FriendControllerTest.class)
public class FriendControllerTest {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://127.0.0.1:9002");
		this.template = new TestRestTemplate();
	}

	/**
	 * 测试 friendSave
	 * 
	 * @throws Exception
	 */
	@Test
	public void friendSave() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		/*
		 * List<String> list = new ArrayList<String>();
		 * list.add("2f960953-4388-11e7-b66c-3c970e5c");
		 * list.add("2f960dea-4388-11e7-b66c-3c970e5c");
		 */

		String friend_emp_id = "dad43d1d-612b-11e7-90f1-0050569b;fae77966-4f42-11e7-ac31-3c970e5c;";
		// String
		// friend_emp_id="2f960953-4388-11e7-b66c-3c970e5c;2f960dea-4388-11e7-b66c-3c970e5c;";
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("friend_emp_id", friend_emp_id);

		String result = template.postForObject(base.toString() + "/v1.0/friend/friendSave", buildEntity(messageMap),
				String.class);
		System.out.println("--添加常用联系人：" + result);
	}

	/**
	 * 测试 PC端个人详情
	 * 
	 * @throws Exception
	 */
	@Test
	public void selectEmpDetails() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("friend_emp_id", "2f960953-4388-11e7-b66c-3c970e5c");

		String result = template.postForObject(base.toString() + "/v1.0/friend/selectEmpDetails",
				buildEntity(messageMap), String.class);
		System.out.println("--查询个人详情：" + result);
	}

	/**
	 * 测试 PC端个人详情
	 * 
	 * @throws Exception
	 */
	@Test
	public void setRedis() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		String result = template.postForObject(base.toString() + "/v1.0/redis/setRedis",
				buildEntity(messageMap), String.class);
		System.out.println("--查询个人详情：" + result);
	}
	@Test
	public void getRedis() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		
		String result = template.postForObject(base.toString() + "/v1.0/redis/getRedis",
				buildEntity(messageMap), String.class);
		System.out.println("--查询个人详情：" + result);
	}

	/**
	 * 测试 PC端个人详情
	 * 
	 * @throws Exception
	 */
	@Test
	public void updateEmpDetails() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("type", "2");
		// messageMap.put("emp_phone", "2222222222");
		messageMap.put("emp_mobile_phone", "213243434");
		// messageMap.put("emp_address", "2f960953-4388-11e7-b66c-3c970e5c");
		// messageMap.put("emp_work_address",
		// "2f960953-4388-11e7-b66c-3c970e5c");

		String result = template.postForObject(base.toString() + "/v1.0/friend/updateEmpDetails",
				buildEntity(messageMap), String.class);
		System.out.println("--修改个人详情：" + result);
	}

	@Test
	public void test() throws Exception {
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		Map<String, Object> baseMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		map.put("emp_name", "李朝阳");
		baseMap.put("baseMessage", map);

		List<Map<String, Object>> positionMessageList = new ArrayList<Map<String, Object>>();
		Map<String, Object> positionMap1 = new HashMap<String, Object>();
		positionMap1.put("up_emp_name", "职级信息中上级1  黄威");
		positionMap1.put("up_emp_id", "2f960ecb-4388-11e7-b66c-3c970e5c");
		Map<String, Object> positionMap2 = new HashMap<String, Object>();
		positionMap2.put("up_emp_name", "职级信息中上级2  黄威");
		positionMap2.put("up_emp_id", "2f960ecb-4388-11e7-b66c-3c970e5c");
		baseMap.put("positionMessageList", positionMessageList);

		returnlist.add(baseMap);

		Map<String, Object> map2 = returnlist.get(0);

		Map<String, Object> map3 = returnlist.get(1);
		// String result =
		// template.postForObject(base.toString()+"/v1.0/friend/selectEmpDetails",
		// buildEntity(messageMap), String.class);
		// System.out.println("--查询个人详情："+result);
	}

	/**
	 * 测试 PC端常用联系人列表
	 * 
	 * @throws Exception
	 */
	@Test
	public void empList() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		// messageMap.put("emp_active", "1");
		// messageMap.put("emp_enabled", "0");
		// messageMap.put("emp_email", "@qq.com");
		// messageMap.put("pageNo", "1");
		// messageMap.put("maxResult", "2");

		String result = template.postForObject(base.toString() + "/v1.0/friend/empList", buildEntity(messageMap),
				String.class);
		System.out.println("--常用联系人列表：" + result);
	}

	/**
	 * 测试 PC端 组织通讯录员工列表
	 * 
	 * @throws Exception
	 */
	@Test
	public void orgEmpList() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		// messageMap.put("org_id", "8");
		// messageMap.put("emp_active", "0");
		messageMap.put("pageNo", "0");
		messageMap.put("maxResult", "2");

		String result = template.postForObject(base.toString() + "/v1.0/friend/orgEmpList", buildEntity(messageMap),
				String.class);
		System.out.println("--组织通讯录员工查询列表：" + result);
	}

	/**
	 * 测试 PC端 导出常用联系人
	 * 
	 * @throws Exception
	 */
	@Test
	public void exportFriendToExcel() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		// List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		/*
		 * Map<String,Object> map1= new HashMap<String,Object>();
		 * map1.put("emp_code", "2909"); map1.put("emp_name", "王晓丽");
		 * map1.put("org_name", "部门经理");
		 */
		// list.add(map1);
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("emp_ids", "2f960f88-4388-11e7-b66c-3c970e5c;dad43d1d-612b-11e7-90f1-0050569b");

		String result = template.postForObject(base.toString() + "/v1.0/friend/exportFriendToExcel",
				buildEntity(messageMap), String.class);
		System.out.println("--导出联系人：" + result);
	}

	/**
	 * 测试 PC端 导出组织通讯录
	 * 
	 * @throws Exception
	 */
	@Test
	public void exportEmpToExcel() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		/* messageMap.put("org_id", "1"); */
		messageMap.put("emp_ids", "2f960f88-4388-11e7-b66c-3c970e5c;dad43d1d-612b-11e7-90f1-0050569b");

		String result = template.postForObject(base.toString() + "/v1.0/friend/exportEmpToExcel",
				buildEntity(messageMap), String.class);
		System.out.println("--导出组织通讯录：" + result);
	}

	/**
	 * 测试 PC端 打印组织通讯录
	 * 
	 * @throws Exception
	 */
	@Test
	public void orgEmpPrint() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		/* messageMap.put("org_id", "1"); */
		// messageMap.put("emp_ids",
		// "2f960f88-4388-11e7-b66c-3c970e5c;dad43d1d-612b-11e7-90f1-0050569b");

		String result = template.postForObject(base.toString() + "/v1.0/friend/orgEmpPrint", buildEntity(messageMap),
				String.class);
		System.out.println("--打印组织通讯录列表：" + result);
	}

	private HttpEntity<String> buildEntity(Map<String, Object> params) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}
	
	
	
	/**
	 * 测试 PC端 导出组织通讯录
	 * 
	 * @throws Exception
	 */
	@Test
	public void temp() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		String result = template.postForObject(base.toString() + "/v1.0/friend/temp",
				buildEntity(messageMap), String.class);
		
		System.out.println("=========>：" + result);
	}

}
