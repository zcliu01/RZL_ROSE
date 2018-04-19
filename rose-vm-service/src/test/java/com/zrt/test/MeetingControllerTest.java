package com.zrt.test;

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
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.zrt.mybatis.domain.VmBusVidyoAuth;
import com.zrt.mybatis.mapper.VmBusVidyoAuthMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MeetingControllerTest.class)
public class MeetingControllerTest {

	private URL base;
	private RestTemplate template;
	@Autowired
	private VmBusVidyoAuthMapper vmBusVidyoAuthMapper;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://127.0.0.1:9009");
		this.template = new TestRestTemplate();
	}

	/**
	 * web端进行中会议列表
	 * 
	 * @throws Exception
	 */
	@Test
	public void ongoingMeetingList() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("pageNo", "1");
		messageMap.put("maxResult", "10");
		// messageMap.put("mt_titile", "世界");
		// messageMap.put("real_begin_date_time_start", "2017-08-02");
		// messageMap.put("real_begin_date_time_end", "2017-08-02");

		String result = template.postForObject(base.toString() + "/v1.0/vm/ongoingMeetingList", buildEntity(messageMap),
				String.class);
		System.out.println("--web端进行中会议列表返回" + result);
	}

	/**
	 * web端加入会议
	 * 
	 * @throws Exception
	 */
	@Test
	public void joinMeeting() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("record_id", "3732ebf4-7752-11e7-90f1-0050569b");
		messageMap.put("mt_pwd", "123456");

		String result = template.postForObject(base.toString() + "/v1.0/vm/joinMeeting", buildEntity(messageMap),
				String.class);
		System.out.println("--web端加入会议返回" + result);
	}

	/**
	 * web端历史会议列表
	 * 
	 * @throws Exception
	 */
	@Test
	public void historicalMeetingList() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("pageNo", "1");
		messageMap.put("maxResult", "10");
		// messageMap.put("mt_titile", "世界");
		// messageMap.put("real_begin_date_time", "2017-08-01");
		// messageMap.put("real_end_date_time", "2017-08-03");

		String result = template.postForObject(base.toString() + "/v1.0/vm/historicalMeetingList",
				buildEntity(messageMap), String.class);
		System.out.println("--web端历史会议列表返回" + result);
	}

	/**
	 * web端我的会议室会议列表
	 * 
	 * @throws Exception
	 */
	@Test
	public void myMeetingList() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("pageNo", "1");
		messageMap.put("maxResult", "10");
		// messageMap.put("mt_titile", "世界");
		messageMap.put("begin_date_time_start", "2017-08-05");
		messageMap.put("begin_date_time_end", "2017-08-07");

		String result = template.postForObject(base.toString() + "/v1.0/vm/myMeetingList", buildEntity(messageMap),
				String.class);
		System.out.println("--web端我的会议室会议列表返回" + result);
	}

	/**
	 * web端开启会议
	 * 
	 * @throws Exception
	 */
	@Test
	public void openMeeting() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("record_id", "da1417766a4648c99efb820d37407f7a");

		String result = template.postForObject(base.toString() + "/v1.0/vm/openMeeting", buildEntity(messageMap),
				String.class);
		System.out.println("--web端开启会议返回" + result);
	}

	/**
	 * web端取消会议
	 * 
	 * @throws Exception
	 */
	@Test
	public void cancelMeeting() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("record_id", "3732e442-7752-11e7-90f1-0050569b");

		String result = template.postForObject(base.toString() + "/v1.0/vm/cancelMeeting", buildEntity(messageMap),
				String.class);
		System.out.println("--web端开启会议返回" + result);
	}

	/**
	 * web端新建会议
	 * 
	 * @throws Exception
	 */
	@Test
	public void saveMeeting() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();

		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("mt_titile", "捋起袖子一起干22");
		messageMap.put("mt_address", "香山");
		messageMap.put("begin_date_time", "2017-08-07 12:10:40");
		messageMap.put("end_date_time", "2017-08-07 23:40:40");
		messageMap.put("mt_pwd", "123");
		messageMap.put("mt_pwd_flag", "1");
		messageMap.put("notify_type", "3");
		// 会议参加人员 ：张三 ;黄威
		messageMap.put("rec_emp_ids", "2f960dea-4388-11e7-b66c-3c970e5c;2f960ecb-4388-11e7-b66c-3c970e5c");

		String result = template.postForObject(base.toString() + "/v1.0/vm/saveMeeting", buildEntity(messageMap),
				String.class);
		System.out.println("--web端新建会议返回" + result);
	}

	@Test
	public void vidyo() throws Exception {

		int id = 4;
		int j = 0002;
		for (int i = 0; i < 644; i++) {
			VmBusVidyoAuth vmBusVidyoAuth = new VmBusVidyoAuth();
			id++;
			j++;
			vmBusVidyoAuth.setId(String.valueOf(id));
			vmBusVidyoAuth.setAuthName("zrt" + String.valueOf(j));
			vmBusVidyoAuth.setAuthPwd("zrt123");
			vmBusVidyoAuth.setRoleName("ADMIN");
			vmBusVidyoAuthMapper.insert(vmBusVidyoAuth);
			continue;
		}

	}

	/**
	 * web端修改会议
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

		String result = template.postForObject(base.toString() + "/v1.0/vm/updateMeeting", buildEntity(messageMap),
				String.class);
		System.out.println("--web端修改会议返回" + result);
	}

	private HttpEntity<String> buildEntity(Map<String, Object> params) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}

}
