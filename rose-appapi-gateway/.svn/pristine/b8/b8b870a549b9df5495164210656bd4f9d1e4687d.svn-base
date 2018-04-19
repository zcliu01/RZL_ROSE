package com.hzcard;

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
	 * app端 添加常用联系人页
	 * @throws Exception
	 */
	@Test
	public void friendSavePage() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c"); 
		
	    String result = template.postForObject(base.toString()+"/v1.0/friendApp/friendSavePage", buildEntity(messageMap), String.class);
	    System.out.println("-----添加常用联系人页 初始化列表返回："+result);
	}
	
	/**
	 * App端根据主键查询常用联系人列表
	 * @param params
	 * @return
	 *//*
	@Test
	public void friendSearch() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
	    messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c"); //李朝阳,4个常用联系人
	    
	    String result = template.postForObject(base.toString()+"/v1.0/friendApp/friendSearch", buildEntity(messageMap), String.class);
	    System.out.println("-----常用联系人 查询列表返回："+result);
	}*/
	
	
	
	private HttpEntity<String> buildEntity(Map<String,Object> params){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}
	
}
