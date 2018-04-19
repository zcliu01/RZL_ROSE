package com.zrt.test;

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
@SpringApplicationConfiguration(classes = AppMeetingControllerTest.class)
public class AppMeetingControllerTest {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://127.0.0.1:9009");
		this.template = new TestRestTemplate();
	}

	/**
	 * app端进行中会议列表
	 * 
	 * @throws Exception
	 */
	@Test
	public void mtControl() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("record_id", "50ca579956b44f5d9186a5070456182e");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("rec_emp_id", "fae77966-4f42-11e7-ac31-3c970e5c");
		list.add(m1);
		messageMap.put("param", list);

		String result = template.postForObject(base.toString() + "/v1.0/vmmanage/disconnectConferenceAll",
				buildEntity(messageMap), String.class);
		System.out.println("--app端进行中会议列表返回" + result);
	}

	/**
	 * app端进行中会议列表
	 * 
	 * @throws Exception
	 */
	@Test
	public void ongoingMeetingList() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		messageMap.put("emp_id", "012346");
		// messageMap.put("pageNo", "1");
		// messageMap.put("maxResult", "10");
		// messageMap.put("mt_titile", "世界");
		// messageMap.put("real_begin_date_time_start", "2017-08-02");
		// messageMap.put("real_begin_date_time_end", "2017-08-02");

		String result = template.postForObject(base.toString() + "/v1.0/appVm/ongoingMeetingList",
				buildEntity(messageMap), String.class);
		System.out.println("--app端进行中会议列表返回" + result);
	}
	@Test
	public void oaaaa() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		// messageMap.put("pageNo", "1");
		// messageMap.put("maxResult", "10");
		// messageMap.put("mt_titile", "世界");
		// messageMap.put("real_begin_date_time_start", "2017-08-02");
		// messageMap.put("real_begin_date_time_end", "2017-08-02");
		
		String result = template.postForObject(base.toString() + "/v1.0/appVm/ongoingMeetingList",
				buildEntity(messageMap), String.class);
		System.out.println("--app端进行中会议列表返回" + result);
	}

	/**
	 * app端加入会议
	 * 
	 * @throws Exception
	 */
	@Test
	public void joinMeeting() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("record_id", "3732ebf4-7752-11e7-90f1-0050569b");
		messageMap.put("mt_pwd", "123456");

		String result = template.postForObject(base.toString() + "/v1.0/appVm/joinMeeting", buildEntity(messageMap),
				String.class);
		System.out.println("--app端加入会议返回" + result);
	}

	/**
	 * app端历史会议列表
	 * 
	 * @throws Exception
	 */
	@Test
	public void historicalMeetingList() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		messageMap.put("emp_id", "008915");

		String result = template.postForObject(base.toString() + "/v1.0/appVm/historicalMeetingList",
				buildEntity(messageMap), String.class);
		System.out.println("--app端历史会议列表返回" + result);
	}

	/**
	 * app端我的会议室会议列表
	 * 
	 * @throws Exception
	 */
	@Test
	public void myMeetingList() throws Exception {

		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "008915");

		String result = template.postForObject(base.toString() + "/v1.0/appVm/myMeetingList", buildEntity(messageMap),
				String.class);
		System.out.println("--app端我的会议室会议列表返回" + result);
	}

	/**
	 * app端开启会议
	 * 
	 * @throws Exception
	 */
	@Test
	public void openMeeting() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("record_id", "3732ed2e-7752-11e7-90f1-0050569b");

		String result = template.postForObject(base.toString() + "/v1.0/appVm/openMeeting", buildEntity(messageMap),
				String.class);
		System.out.println("--app端开启会议返回" + result);
	}

	/**
	 * app端取消会议
	 * 
	 * @throws Exception
	 */
	@Test
	public void cancelMeeting() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("record_id", "3732e442-7752-11e7-90f1-0050569b");

		String result = template.postForObject(base.toString() + "/v1.0/appVm/cancelMeeting", buildEntity(messageMap),
				String.class);
		System.out.println("--app端开启会议返回" + result);
	}

	/**
	 * app端新建会议
	 * 
	 * @throws Exception
	 */
	@Test
	public void saveMeeting() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("mt_titile", "今日立秋,凉气始肃1");
		messageMap.put("mt_address", "香山");
		messageMap.put("begin_date_time", "20170807101040");
		messageMap.put("end_date_time", "20170807154040");
		messageMap.put("mt_pwd", "123");
		messageMap.put("mt_pwd_flag", "1");
		messageMap.put("notify_type", "3");
		// 会议参加人员 ：张三 ;黄威
		messageMap.put("rec_emp_ids", "2f960dea-4388-11e7-b66c-3c970e5c;2f960ecb-4388-11e7-b66c-3c970e5c");

		String result = template.postForObject(base.toString() + "/v1.0/appVm/saveMeeting", buildEntity(messageMap),
				String.class);
		System.out.println("--app端新建会议返回" + result);
	}

	/**
	 * app端修改会议
	 * 
	 * @throws Exception
	 */
	@Test
	public void updateMeeting() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		messageMap.put("record_id", "ac9a0df34f80458083cb4d944ab2513b");
		messageMap.put("mt_titile", "立秋之日好友聚会");
		messageMap.put("mt_address", "颐和园");
		messageMap.put("begin_date_time", "20170810140040");
		messageMap.put("end_date_time", "20170810160040");
		messageMap.put("mt_pwd", "");
		messageMap.put("mt_pwd_flag", "0");
		messageMap.put("notify_type", "3");
		// 原来是张三和黄威
		// 2f960dea-4388-11e7-b66c-3c970e5c;2f960ecb-4388-11e7-b66c-3c970e5c
		// 现在改为刘备和 黄威
		// dad43f45-612b-11e7-90f1-0050569b;2f960ecb-4388-11e7-b66c-3c970e5c
		messageMap.put("rec_emp_ids", "dad43f45-612b-11e7-90f1-0050569b;2f960ecb-4388-11e7-b66c-3c970e5c");

		String result = template.postForObject(base.toString() + "/v1.0/appVm/updateMeeting", buildEntity(messageMap),
				String.class);
		System.out.println("--app端修改会议返回" + result);
	}

	/**
	 * 发起人入会
	 * 
	 * @throws Exception
	 */
	@Test
	public void inMeeting() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("record_id", "0c506d06877e4bf2b6f8ff50efcd3b62");
		messageMap.put("emp_id", "2f960ecb-4388-11e7-b66c-3c970e5c");
		String result = template.postForObject(base.toString() + "/v1.0/appVmoper/inMeeting", buildEntity(messageMap),
				String.class);
		System.out.println("--app端修改会议返回" + result);
	}

	/**
	 * 即时入会
	 * 
	 * @throws Exception
	 */
	@Test
	public void launch() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("emp_id", "2f960ecb-4388-11e7-b66c-3c970e5c");
		messageMap.put("rec_emp_ids", "fae77966-4f42-11e7-ac31-3c970e5c");
		messageMap.put("mt_type", "3");
		System.out.println("req json=" + buildEntity(messageMap));
		String result = template.postForObject(base.toString() + "/v1.0/appVmoper/launch", buildEntity(messageMap),
				String.class);
		System.out.println("--app端修改会议返回" + result);
	}

	private HttpEntity<String> buildEntity(Map<String, Object> params) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}

}
