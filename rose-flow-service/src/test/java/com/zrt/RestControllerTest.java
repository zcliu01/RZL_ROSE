package com.zrt;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
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
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServiceApplication.class)
@WebAppConfiguration
public class RestControllerTest {
	
	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:9008");
		this.template = new TestRestTemplate();
	}
	/**
	 * 查询流程定义列表 repository/process-definitions
	 * @throws Exception
	 */
	@Test
	public void queryProcessDefinitions() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("code", "fr43");
		String result = template.postForObject(base.toString()+"/repository/process-definitions", buildEntity(messageMap), String.class);
		System.out.println("-----调用获取合作伙伴查询返回："+result);
		
	}
	

/**
 * 流程申请
 * @throws Exception
 */
@Test
public void apply() throws Exception {
	Map<String,Object> messageMap = new HashMap<String,Object>();
//	messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
//	messageMap.put("deployment_id", "245003");
	String result = template.postForObject(base.toString()+"/v1.0/fbtemp/list", buildEntity(messageMap), String.class);
	System.out.println("-----调用获取合作伙伴查询返回："+result);
	
}

/**
 * 流程审核
 * @throws Exception
 */
@Test
public void applyCheck() throws Exception {
	Map<String,Object> messageMap = new HashMap<String,Object>();
	messageMap.put("task_id", "e86fc3f4-7696-11e7-bcdf-28d244f7fae0");
	//messageMap.put("second_emp_id", "second");
	String result = template.postForObject(base.toString()+"/v1.0/flow/check", buildEntity(messageMap), String.class);
	System.out.println("-----调用获取合作伙伴查询返回："+result);
	
}
	
	/**
	 * 流程发布
	 * @throws Exception
	 */
	@Test
	public void deploy() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("id", "232501");
		String result = template.postForObject(base.toString()+"/v1.0/flow/deploy", buildEntity(messageMap), String.class);
		System.out.println("-----调用获取合作伙伴查询返回："+result);
		
	}
	
	/**
	 * 流程key,查询所有节点属性
	 * @throws Exception
	 */
	@Test
	public void actInfo() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("key", "qingjia");
		String result = template.postForObject(base.toString()+"/v1.0/flow/actInfo", buildEntity(messageMap), String.class);
		System.out.println("-----调用获取合作伙伴查询返回："+result);
		
	}
	
	/**
	 * 流程key,查询所有节点属性
	 * @throws Exception
	 */
	@Test
	public void signAdd() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("inst_id", "c5ac5ddbd34348a685c935df9117f64e");
		messageMap.put("task_id", "0dffb559-bd4e-11e7-8494-28d244f7fae0");
		messageMap.put("check_comment", "");
		messageMap.put("check_status", "1");
		messageMap.put("check_type", "3");
		messageMap.put("sign_emp_ids", "000031");
		messageMap.put("file", new String[]{});
		messageMap.put("rel", new String[]{});
		messageMap.put("inst_id", "c5ac5ddbd34348a685c935df9117f64e");
		String result = template.postForObject(base.toString()+"/v1.0/flow/signAdd", buildEntity(messageMap), String.class);
		System.out.println("-----调用获取合作伙伴查询返回："+result);
		
	}
	
	/**
	 * 流程key,查询所有节点属性
	 * @throws Exception
	 */
	@Test
	public void selfApply() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("cur_tag_assignee", "xiaoming");
		String result = template.postForObject(base.toString()+"/v1.0/flowself/selfApply", buildEntity(messageMap), String.class);
		System.out.println("-----调用获取合作伙伴查询返回："+result);
		
	}
	
	/**
	 * 个人相关流程
	 * @throws Exception
	 */
	@Test
	public void selfAboutList() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_id", "008295");
		messageMap.put("fb_type", "1");
		messageMap.put("pageNo", "1");
		messageMap.put("maxResult", "10");
		String result = template.postForObject(base.toString()+"/v1.0/flow/selfAboutList", buildEntity(messageMap), String.class);
		System.out.println("-----调用获取合作伙伴查询返回："+result);
		
	}
	
	/**
	 * 个人相关流程
	 * @throws Exception
	 */
	@Test
	public void flowpreList() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_id", "000036");
		messageMap.put("fb_type", "1");
		messageMap.put("pageNo", "1");
		messageMap.put("maxResult", "10");
		String result = template.postForObject(base.toString()+"/v1.0/flowpre/list", buildEntity(messageMap), String.class);
		System.out.println("-----调用获取合作伙伴查询返回："+result);
		
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
	
	@Test
	public void createFile() throws IOException{
		File file=new File("D://1.txt");
		file.createNewFile();
	}
}
