package com.hzcard;

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
@SpringApplicationConfiguration(classes = InforControllerTest.class)
public class InforControllerTest {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:9005");
		this.template = new TestRestTemplate();
	}

	/**
	 * 新建讯息
	 * 
	 * @param params
	 * @return
	 */
	@Test
	public void inforSave() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("title", "新员工入职");
		messageMap.put("copyer_ids", "111");
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("receiver_ids", "222;333");
		messageMap.put("content", "安排新员工入职事项11111111111");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("acc_address", "fffe");
		m1.put("acc_name", "fffe");
		m1.put("acc_type", "f");
		Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("acc_address", "fffe");
		m2.put("acc_name", "fffe");
		m2.put("acc_type", "f");
		list.add(m1);
		list.add(m2);
		messageMap.put("acc", list);
		String result = template.postForObject(base.toString() + "/v1.0/appInforRecord/saveAndSendInfor",
				buildEntity(messageMap), String.class);
		System.out.println("-----新建讯息返回：" + result);

	}

	@Test
	public void countind() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "2f960ecb-4388-11e7-b66c-3c970e5c");
		String result = template.postForObject(base.toString() + "/v1.0/careInfor/careAllList", buildEntity(messageMap),
				String.class);
		System.out.println("-----未阅数量返回：" + result);
		
	}
	/**
	 * 监控
	 * 
	 * @param params
	 * @return
	 */
	@Test
	public void inforControl() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("receiver_ids", "3d185795-57bf-11e7-9a92-0050569b");
		String result = template.postForObject(base.toString() + "/v1.0/inforControl/withEmpList",
				buildEntity(messageMap), String.class);
		System.out.println("-----监控讯息返回：" + result);

	}

	@Test
	public void dicList() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		String result = template.postForObject(base.toString() + "/v1.0/inforCommons/dicList", buildEntity(messageMap),
				String.class);
		System.out.println("-----关注讯息列表返回：" + result);

	}

	@Test
	public void status() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		// messageMap.put("is_show", "1");
		// List<Map<String, Object>> list = new ArrayList<Map<String,
		// Object>>();
		// Map<String, Object> m1 = new HashMap<String, Object>();
		// m1.put("infor_no", "555");
		// m1.put("send_flag", "1");
		// Map<String, Object> m2 = new HashMap<String, Object>();
		// m2.put("infor_no", "556");
		// m2.put("send_flag", "0");
		// Map<String, Object> m3 = new HashMap<String, Object>();
		// m3.put("infor_no", "555");
		// m3.put("send_flag", "0");
		// list.add(m1);
		// list.add(m2);
		// list.add(m3);
		// messageMap.put("param", list);
		messageMap.put("infor_no", "555");
		// messageMap.put("send_flag", "1");
		String result = template.postForObject(base.toString() + "/v1.0/inforCommons/inforCancel",
				buildEntity(messageMap), String.class);
		System.out.println("-----关注讯息列表返回：" + result);

	}

	@Test
	public void dic() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		// messageMap.put("dic_name", "2222");
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("dic_id", "077ce63c7623411b9f8dacd2303178fb");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("infor_no", "fffe");
		Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("infor_no", "eeee");
		list.add(m1);
		list.add(m2);
		messageMap.put("param", list);
		String result = template.postForObject(base.toString() + "/v1.0/inforCommons/concernInfor",
				buildEntity(messageMap), String.class);
		System.out.println("-----添加关注返回：" + result);

	}

	private HttpEntity<String> buildEntity(Map<String, Object> params) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}

	public static void main(String[] args) {
		BigDecimal b1 = new BigDecimal(100000000);
		BigDecimal b2 = new BigDecimal(3);
		System.out.println(b1.divide(b2, 100, BigDecimal.ROUND_HALF_UP));
	}
}
