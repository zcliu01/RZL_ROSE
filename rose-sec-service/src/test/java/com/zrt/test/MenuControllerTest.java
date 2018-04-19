package com.zrt.test;

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
@SpringApplicationConfiguration(classes = MenuControllerTest.class)
public class MenuControllerTest {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:9000");
		this.template = new TestRestTemplate();
	}

	/**
	 * 菜单信息查询
	 * 
	 * @throws Exception
	 *  
	 * 
	 */
	@Test
	public void menuSearch() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("org_id", "7");
		messageMap.put("org_code", "00212");
		messageMap.put("sec_order", "1");
		messageMap.put("org_name", "股份管理部1");
		messageMap.put("parent_org_id", "1");
		String result = template.postForObject(base.toString() + "/v1.0/sec/orgUpdate", buildEntity(messageMap),
				String.class);
		System.out.println("-----机构信息更新返回：" + result);

	}
	
	

	private HttpEntity<String> buildEntity(Map<String, Object> params) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}

}
