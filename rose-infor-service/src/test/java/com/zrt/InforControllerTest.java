package com.zrt;

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
		this.base = new URL("http://localhost:9003");
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
		messageMap.put("title", "kFa1919999");
		messageMap.put("emp_id", "000069");
		// messageMap.put("parent_no", "innerInfor201801180000264864");
		messageMap.put("receiver_ids", "003302");
		messageMap.put("content", "kafas1919999");
		String result = template.postForObject(base.toString() + "/v1.0/inforrecord/saveAndSendInfor",
				buildEntity(messageMap), String.class);
		System.out.println("-----新建讯息返回：" + result);

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
		messageMap.put("emp_id", "001193");
		messageMap.put("infor_no", "innerInfor201801180000264864");
		// messageMap.put("status", "0");
		// messageMap.put("receiver_id", "2f960953-4388-11e7-b66c-3c970e5c");
		// messageMap.put("search_content", "吃了回家");
		String result = template.postForObject(base.toString() + "/v1.0/inforControl/withInforDetails",
				buildEntity(messageMap), String.class);
		System.out.println("-----监控讯息返回：" + result);

	}

	// 内部讯息全部列表
	@Test
	public void inforAllList() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "000001");
		String result = template.postForObject(base.toString() + "/v1.0/inforInner/inforAllList",
				buildEntity(messageMap), String.class);
		System.out.println("-----讯息列表返回：" + result);

	}
	// 内部讯息我接收到的列表
	@Test
	public void inforReceiveList() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "000001");
		String result = template.postForObject(base.toString() + "/v1.0/inforInner/inforAllList",
				buildEntity(messageMap), String.class);
		System.out.println("-----讯息列表返回：" + result);
		
	}

	// 草稿列表
	@Test
	public void darft() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "003302");
		String result = template.postForObject(base.toString() + "/v1.0/inforInner/inforDraftList",
				buildEntity(messageMap), String.class);
		System.out.println("-----讯息列表返回：" + result);

	}

	/**
	 * 讯息管理
	 * 
	 * @param params
	 * @return
	 */
	@Test
	public void inforCategory() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		// messageMap.put("category", "innerInfor");
		// messageMap.put("infor_no", "innerInfor201707010000000132");
		// messageMap.put("status", "1");
		// messageMap.put("receiver_id", "2f960953-4388-11e7-b66c-3c970e5c");
		// messageMap.put("search_content", "吃了回家");
		String result = template.postForObject(base.toString() + "/v1.0/documentInfor/documentNoReadList",
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
	public void countind() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "000001");
		// messageMap.put("category", "innerInfor");
		String result = template.postForObject(base.toString() + "/v1.0/inforCommons/inforCount",
				buildEntity(messageMap), String.class);
		System.out.println("-----未阅数量返回：" + result);

	}

	@Test
	public void appList() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("status", "7");
		String result = template.postForObject(base.toString() + "/v1.0/appInforInner/inforList",
				buildEntity(messageMap), String.class);
		System.out.println("-----app列表返回：" + result);

	}

	@Test
	public void sendList() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "010619");
		String result = template.postForObject(base.toString() + "/v1.0/inforInner/inforSendList",
				buildEntity(messageMap), String.class);
		System.out.println("-----app列表返回：" + result);

	}

	@Test
	public void appDeal() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("deal_status", "0");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("infor_no", "innerInfor201707280000000436");
		list.add(m1);
		messageMap.put("param", list);
		String result = template.postForObject(base.toString() + "/v1.0/appInforInner/inforDeal",
				buildEntity(messageMap), String.class);
		System.out.println("-----app列表返回：" + result);

	}

	// 讯息详情
	@Test
	public void inforDetail() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("infor_no", "innerInfor201801170000264437");
		String result = template.postForObject(base.toString() + "/v1.0/inforCommons/inforCareDetail",
				buildEntity(messageMap), String.class);
		System.out.println("-----app列表返回：" + result);

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
		messageMap.put("emp_id", "000001");
		// messageMap.put("send_flag", "1");
		//// messageMap.put("dic_id", "077ce63c7623411b9f8dacd2303178fb");
		// List<Map<String, Object>> list = new ArrayList<Map<String,
		// Object>>();
		// Map<String, Object> m1 = new HashMap<String, Object>();
		// m1.put("infor_no", "innerInfor201707140000000216");
		//// Map<String, Object> m2 = new HashMap<String, Object>();
		//// m2.put("infor_no", "innerInfor201707180000000235");
		// list.add(m1);
		//// list.add(m2);
		// messageMap.put("param", list);
		String result = template.postForObject(base.toString() + "/v1.0/careInfor/careAllList", buildEntity(messageMap),
				String.class);
		System.out.println("-----添加关注返回：" + result);

	}

	@Test
	public void sendUpdateInfor() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "001193");
		messageMap.put("title", "抄送人去重");
		messageMap.put("copyer_ids", "008915;");
		messageMap.put("receiver_ids", "008069;008061");
		messageMap.put("content", "其他转发转发");
		String result = template.postForObject(base.toString() + "/v1.0/inforrecord/sendUpdateInfor",
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
