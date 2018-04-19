package com.zrt.contacts.web.manage.empsearchwindow;

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
@SpringApplicationConfiguration(classes = EmpSearchWindowControllerTest.class)
public class EmpSearchWindowControllerTest {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://127.0.0.1:9002");
		this.template = new TestRestTemplate();
	}
	

	
	/**
	 *测试 创建我的群组中的，组织机构下面对应员工的展示（树）moreMateSearchTree
	 * @throws Exception
	 */
	@Test
	public void moreMateSearchTree() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_id","2f960953-4388-11e7-b66c-3c970e5c");
//		messageMap.put("root_id", "3");//1:常用联系人 2：机构组织  3：我的群组 4：待撤销部门
//    	messageMap.put("search", "李,黄");
//		messageMap.put("search", "李,王");//ok
//		messageMap.put("search", "z,w");//ok
		
	    String result = template.postForObject(base.toString()+"/v1.0/empSearchWindow/moreMateSearchTree", buildEntity(messageMap), String.class);
	    System.out.println("--创建群组窗口初始化："+result);
	}
	
	/**
	 *测试 通用的联系人搜索功能 
	 * @throws Exception
	 */
	@Test
	public void commonEmpSearch() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_id","dad43f45-612b-11e7-90f1-0050569b");//刘备
		messageMap.put("search", "dad43a24-612b-11e7-90f1-0050569b;dad43f45-612b-11e7-90f1-0050569b");
//		messageMap.put("search", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("type", "0");
		
	    String result = template.postForObject(base.toString()+"/v1.0/empSearchWindow/commonEmpSearch", buildEntity(messageMap), String.class);
	    System.out.println("--通用的联系人检索列表："+result);
	}
	

	/**
	 *测试 讯息收件人按职级排序
	 * @throws Exception
	 */
	@Test
	public void infoReceiverOrderByRank() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_ids","2f960953-4388-11e7-b66c-3c970e5c;2f960dea-4388-11e7-b66c-3c970e5c;dad4305d-612b-11e7-90f1-0050569b;");
		
	
	    String result = template.postForObject(base.toString()+"/v1.0/empSearchWindow/infoReceiverOrderByRank", buildEntity(messageMap), String.class);
	    System.out.println("--讯息收件人按职级排序查询列表："+result);
	}
	
	
	/**
	 *测试 讯息收件人按职级排序
	 * @throws Exception
	 */
	@Test
	public void meetEmpInfo() throws Exception {
		List<String> reList=new ArrayList<String>();
		//Map<String,Object> recMap=new HashMap<>();
		//recMap.put("rec_emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		reList.add("2f960953-4388-11e7-b66c-3c970e5c");
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_ids",reList);
		messageMap.put("rec_emp_name","");
		messageMap.put("org_name","z");
	    String result = template.postForObject(base.toString()+"/v1.0/empSearchWindow/meetEmpInfo", buildEntity(messageMap), String.class);
	    System.out.println("6.5查询员工信息(会议服务提供)："+result);
	}
	
	private HttpEntity<String> buildEntity(Map<String,Object> params){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}
	
	
}
