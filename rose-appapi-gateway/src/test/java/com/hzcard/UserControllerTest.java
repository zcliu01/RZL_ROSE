package com.hzcard;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.alibaba.fastjson.JSON;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UserControllerTest.class)
public class UserControllerTest {
	
	private URL base;
	private RestTemplate template;
	

//	@Resource(name = "ribbonWrappedUserClient")
//	private UserClient userClient;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:9005");
		this.template = new TestRestTemplate();
	}
	
	@Test
	public void userList() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("pageNo", "0");
		messageMap.put("maxResult", "10");
		System.out.println(base.toString()+"/v1.0/sec/userList");
		System.out.println("--req json="+buildEntity(messageMap));
		String result = template.postForObject(base.toString()+"/v1.0/sec/userList", buildEntity(messageMap), String.class);
		System.out.println("-----调用返回："+result);
		
		
		
	}
	

	private HttpEntity<String> buildEntity(Map<String,Object> params){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}
}
