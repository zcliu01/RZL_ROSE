package com.zrt.test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.zrt.VifApplication;
import com.zrt.vif.service.imvif.immanage.ImmanageService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VifApplication.class)
@WebAppConfiguration
public class RestControllerTest {

	private URL base;
	private RestTemplate template;

	@Autowired
	private ImmanageService immanageService;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:9010");
		this.template = new TestRestTemplate();
	}

	/**
	 * 查询流程定义列表 repository/process-definitions
	 * 
	 * @throws Exception
	 */
	@Test
	public void queryProcessDefinitions() throws Exception {
		immanageService.pushMsg(new HashMap<>());

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

	@Test
	public void createFile() throws IOException {
		File file = new File("D://1.txt");
		file.createNewFile();
	}

	@Test
	public void tcmp() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		messageMap.put("emp_id", "001964");
		// messageMap.put("pageNo", "1");
		// messageMap.put("maxResult", "10");
		// messageMap.put("mt_titile", "世界");
		// messageMap.put("real_begin_date_time_start", "2017-08-02");
		// messageMap.put("real_begin_date_time_end", "2017-08-02");

		String result = template.postForObject(base.toString() + "/v1.0/tcmp/indexCount",
				buildEntity(messageMap), String.class);
		System.out.println("--app端进行中会议列表返回" + result);
	}
}
