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
@SpringApplicationConfiguration(classes = AppUserControllerTest.class)
public class AppUserControllerTest {
	
	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:9000");
		this.template = new TestRestTemplate();
	}
	/**
	 * app端修改我的详情
	 * @throws Exception
	 */
	@Test
	public void appUpdateEmpDetails() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
//		messageMap.put("emp_id", "2f960dea-4388-11e7-b66c-3c970e5c");
		messageMap.put("type", "4");
		messageMap.put("emp_work_address", "工作地址修改");
		
		
		String result = template.postForObject(base.toString()+"/v1.0/sec/appUpdateEmpDetails", buildEntity(messageMap), String.class);
		System.out.println("-----修改个人详情信息查询返回："+result);
		
	}
	
	/**
	 * app端获取发票抬头列表
	 * @throws Exception
	 */
	@Test
	public void appSelectInvoiceTitle() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
//		messageMap.put("emp_id", "2f960dea-4388-11e7-b66c-3c970e5c");
		
		String result = template.postForObject(base.toString()+"/v1.0/sec/appSelectInvoiceTitle", buildEntity(messageMap), String.class);
		System.out.println("-----发票抬头列表返回："+result);
		
	}

	
	
	
	private HttpEntity<String> buildEntity(Map<String,Object> params){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}
	
	
}
