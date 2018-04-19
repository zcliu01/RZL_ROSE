package com.zrt.contacts.web.app.sys;

import java.net.URL;
import java.util.HashMap;
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
@SpringApplicationConfiguration(classes = EmpSearchAppControllerTest.class)
public class EmpSearchAppControllerTest {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://127.0.0.1:9002");
		this.template = new TestRestTemplate();
	}
	
	
	@Test
	public void contactsList() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
//		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("type", "1"); //1按部门查询
		messageMap.put("status", "1");//查询全部员工
//		messageMap.put("search", " 部 ");
//		messageMap.put("parent_org_id", "000200010002");

		/*messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
        messageMap.put("type", "0"); //按人员查询
	    messageMap.put("status", "1");//查询在职员工
		//messageMap.put("memberStatus", "1");
     	messageMap.put("search", "li ");*/
		
		String result = template.postForObject(base.toString()+"/v1.0/empSearchApp/contactsList", buildEntity(messageMap), String.class);
		System.out.println("-----按人员  查询列表返回："+result);
		
	}
	
	//根据部门查询员工列表
	@Test
	public void empListByOrg() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
	    messageMap.put("org_id", "0002000100030001"); //按部门查询
//	    messageMap.put("status", "");//查询在职员工
	    messageMap.put("search", "胡猛");
		String result = template.postForObject(base.toString()+"/v1.0/empSearchApp/empListByOrg", buildEntity(messageMap), String.class);
		System.out.println("-----按部门   查询员工列表返回："+result);
		
	}
	/**
	 * 测试 根据员工id 查询员工详情
	 * @throws Exception
	 */
	@Test
	public void selectEmpDetails() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
	    messageMap.put("emp_id", "000125");
//	    messageMap.put("friend_emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
	    messageMap.put("friend_emp_id", "000125");
	    String result = template.postForObject(base.toString()+"/v1.0/empSearchApp/selectEmpDetails", buildEntity(messageMap), String.class);
		System.out.println("-----根据员工Id 查询员工详情返回："+result);
		
	}

	/**
	 * 测试 根据员工id 查询个人履历
	 * @throws Exception
	 */
	@Test
	public void selectEmpWorkRedeploy() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
	    messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		
	    String result = template.postForObject(base.toString()+"/v1.0/empSearchApp/selectEmpWorkRedeploy", buildEntity(messageMap), String.class);
		System.out.println("-----根据员工Id 查询员工详情返回："+result);
		
	}
	
	/**
	 * 测试 IM组织通讯录同步
	 * @throws Exception
	 */
	@Test
	public void contactsImList() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
//	    messageMap.put("emp_id", "012684");
		
	    String result = template.postForObject(base.toString()+"/v1.0/empSearchApp/contactsImList", buildEntity(messageMap), String.class);
		System.out.println("-----IM组织通讯录同步："+result);
		
	}
	
	/**
	 * 测试 根据用户id 查询职位信息
	 * @throws Exception
	 */
	@Test
	public void selectEmpPositionDetails() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
	    messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		
	    String result = template.postForObject(base.toString()+"/v1.0/empSearchApp/selectEmpPositionDetails", buildEntity(messageMap), String.class);
		System.out.println("-----根据用户Id 查询职位讯息返回："+result);
		
	}
	
	private HttpEntity<String> buildEntity(Map<String,Object> params){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}
	
}
