package com.zrt.test;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.zrt.commons.sign.CipherUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppUserControllerTest.class)
public class LoginControllerTest {
	
	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:9000");
		this.template = new TestRestTemplate();
	}
	
	
	/**
	 * PC端登录
	 * @throws Exception
	 */
	@Test
	public void login() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
     	messageMap.put("user_account", "lichaoyang");
		messageMap.put("user_password", "123456");
	/*	messageMap.put("user_account", "004043");
		messageMap.put("user_password", "123@zrt");*/
//		messageMap.put("sec_enabled", "1");
		
		String result = template.postForObject(base.toString()+"/v1.0/sec/login", buildEntity(messageMap), String.class);
		System.out.println("----PC端登录接口测试返回："+result);
		
	}
	
	
	@Test
	public void test() throws Exception {
	
		System.out.println(CipherUtil.encrypt("123@zrt"));
	}		
	

	private HttpEntity<String> buildEntity(Map<String,Object> params){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}
	
}
