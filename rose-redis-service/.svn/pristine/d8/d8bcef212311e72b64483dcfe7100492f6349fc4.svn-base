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
@SpringApplicationConfiguration(classes = RedisControllerTest.class)
public class RedisControllerTest {
	
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
	public void setInfo() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("doMain", "dd");
		messageMap.put("key", "100");
		
		Map<String,Object> dataMap = new HashMap<String,Object>();
		dataMap.put("token", "32424");
		messageMap.put("data", dataMap);
		String result = template.postForObject(base.toString()+"/v1.0/redis/setInfo", buildEntity(messageMap), String.class);
		System.out.println("-----用户列表查询返回："+result);
		
	}
	
	@Test
	public void getInfo() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("doMain", "dd");
		messageMap.put("key", "100");
		String result = template.postForObject(base.toString()+"/v1.0/redis/getInfo", buildEntity(messageMap), String.class);
		System.out.println("-----用户列表查询返回："+result);
		
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
