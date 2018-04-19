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
@SpringApplicationConfiguration(BumphTest.class)
public class BumphTest {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://127.0.0.1:9016");
		//this.base = new URL("http://172.30.142.167:9003");
		this.template = new TestRestTemplate();
	}
	
	/**
	 * 
	 * 新建公文              OK
	 * @throws Exception
	 */
	@Test
	public void add() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> map3 = new HashMap<String, Object>();
		Map<String, Object> map4 = new HashMap<String, Object>();
		/*map.put("doc_name", "雪中悍刀行");
		map.put("doc_number", "9527");
		map.put("doc_date", "2012-12-12 09:40:50");
		map.put("doc_type", "01");
		map.put("doc_urg", "1");
		map.put("doc_src", "1");
		map.put("emp_id", "007");
		map.put("doc_phone", "12345678900");
		map.put("doc_org", "北凉府");
		map.put("doc_dispunit", "武帝城");
		map.put("remark", "誓死守国门");*/
		
		//map.put("doc_name", "aaaaaaaaaaa");
		map.put("doc_number", "99999999");
		map.put("doc_date", "2017-10-10");
		map.put("doc_type", "1");
		map.put("doc_urg", "2");
		map.put("doc_src", "2");
		map.put("emp_id", "00000001");
		map.put("doc_phone", "010-62227777");
		map.put("doc_org", "帝国");
		map.put("doc_dispunit", "衙门");
		map.put("remark", "观海云远");
		
		List<Map<String, Object>> a = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> b = new ArrayList<Map<String, Object>>();
		map1.put("ATTACH_ID", "www.nicai.com");
		map1.put("attach_type", "1");
		map1.put("REMARK", "忘了");
		map2.put("ATTACH_ID", "www.wobucai.com");
		map2.put("attach_type", "2");
		map2.put("REMARK", "不知道");
		a.add(map1);
		a.add(map2);
		map3.put("handerID", "003");
		map3.put("hander_name", "卢云");
		map3.put("hand_type", "1");
		map3.put("remark", "儒生");
		map4.put("handerID", "004");
		map4.put("hander_name", "伍定远");
		map4.put("hand_type", "2");
		map4.put("remark", "护国将军");
		b.add(map3);
		b.add(map4);
		map.put("doc_attach", a);
		map.put("doc_hander", b);
		map.put("hand_type", "1");
		
		String result = template.postForObject(base.toString() + "/v1.0/ docPro /add", buildEntity(map), String.class);
		System.out.println("-----新建公文：" + result);
		
	}
	
	
	/**
	 * 
	 * 待办公文                              OK
	 * @throws Exception
	 */
	@Test
	public void detailSearch() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("emp_id", "006826");
		map.put("hander_state", "0");
		String result = template.postForObject(base.toString() + "/v1.0/docPro/detailSearch", buildEntity(map), String.class);
		System.out.println("-----待办公文：" + result);

	}
	
	
	/**
	 * 
	 * 公文类型维护                              
	 * @throws Exception
	 */
	@Test
	public void state_save() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		/*map.put("bumph_type_name", "会议纪要");
		map.put("bumph_type_code", "2");
		map.put("bumph_type_state", "0");*/
		String result = template.postForObject(base.toString() + "/v1.0/docPro/state_search", buildEntity(map), String.class);
		System.out.println("-----待办公文：" + result);
		
	}
	
	/**
	 * 公文审核查看                      OK
	 * @throws Exception
	 */
	@Test
	public void auditView() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("doc_id", "42a95180f56e422dad4b2724a1871d67");
		String result = template.postForObject(base.toString() + "/v1.0/docPro/auditView", buildEntity(map), String.class);
		System.out.println("-----公文审核查看：" + result);

	}
	
	
	/**
	 * 公文审核办理              OK
	 * @throws Exception
	 */
	@Test
	public void auditAttend() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("handerID", "002");
		map.put("doc_id", "8959a8b2848c47579f126c7aac041a77");
		map.put("hand_type", "1");
		map.put("hand_info", "羞涩可参");
		map.put("hand_state", "1");
		map.put("remark", "老衲这厢有礼了");
		String result = template.postForObject(base.toString() + "/v1.0/docPro/auditAttend", buildEntity(map), String.class);
		System.out.println("-----公文审核办理：" + result);

	}
	
	
	
	/**
	 * 公文监控
	 * @throws Exception
	 */
	@Test
	public void Monitor() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		String result = template.postForObject(base.toString() + "/v1.0/docPro/Monitor", buildEntity(map), String.class);
		System.out.println("-----公文监控：" + result);
		
	}
	
	
	/**
	 * 公文删除                  OK
	 * @throws Exception
	 */
	@Test
	public void delete() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("doc_id", "1");
		String result = template.postForObject(base.toString() + "/v1.0/docPro/delete", buildEntity(map), String.class);
		System.out.println("-----公文删除：" + result);
		
	}
	
	
	/**
	 * 公文详情              OK
	 * @throws Exception
	 */
	@Test
	public void detailView() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("doc_id", "42a95180f56e422dad4b2724a1871d67");
		String result = template.postForObject(base.toString() + "/v1.0/docPro/detailView", buildEntity(map), String.class);
		System.out.println("-----公文详情：" + result);
		
	}
	
	
	
	/**
	 * 公文登记                           OK
	 * @throws Exception
	 */
	@Test
	public void regis() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("emp_id", "000021");
		String result = template.postForObject(base.toString() + "/v1.0/docPro/regis", buildEntity(map), String.class);
		System.out.println("-----公文登记：" + result);
		
	}
	
	
	/**
	 * 待发布公文详情            OK
	 * @throws Exception
	 */
	@Test
	public void detanail() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("doc_id", "8959a8b2848c47579f126c7aac041a77");
		String result = template.postForObject(base.toString() + "/v1.0/docPro/detail", buildEntity(map), String.class);
		System.out.println("-----待发布公文详情：" + result);
		
	}
	
	
	
	@Test
	public void aaa() throws Exception {
		Map<String, Object> infoMap = new HashMap<String, Object>();
		infoMap.put("title", "一二三四五");
		infoMap.put("content", "上山打老虎");
		infoMap.put("sender_id", "0111");
		infoMap.put("category", "innerInfor");
		infoMap.put("bus_type", "5");
		infoMap.put("receiver_ids", "111111111");
		String result = template.postForObject(base.toString() +"/v1.0/inforrecord/sendUpdateInfor", buildEntity(infoMap), String.class);
		System.out.println("-----待发布公文详情：" + result);
		
	}
	
	
	@Test
	public void bbb() throws Exception {
		int i = 5000;
		String a = "测试数据aaaa";
		String b = "开始测试aaaa====>";
		Map<String, Object> infoMap = new HashMap<String, Object>();
		infoMap.put("sender_id","000021");
		infoMap.put("category", "docInfor");
		infoMap.put("bus_type", "BM01");
		infoMap.put("receiver_ids", "002999;012634;001726;006859;008065;");
		while (i<100000) {
			infoMap.put("title", a+i);
			infoMap.put("content", b+i);
			//inforService.sendUpdateInfor(infoMap);
			i++;
		}
		String result = template.postForObject(base.toString() +"/v1.0/inforrecord/sendUpdateInfor", buildEntity(infoMap), String.class);
		System.out.println("-----待发布公文详情：" + result);
		
	}
	
	
	/**
	 * 公文修改            OK
	 * @throws Exception
	 */
	@Test
	public void update() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		map.put("doc_id", "4d470055e92143d28b85e4fcd8c94d5c");
		map.put("doc_name", "英雄志");
		map.put("doc_number", "12345");
		map.put("doc_date", "2017-10-10 16:38:28");
		map.put("doc_type", "01");
		map.put("doc_urg", "2");
		map.put("doc_src", "2");
		map.put("emp_id", "110");
		map.put("doc_phone", "010-62227777");
		map.put("doc_org", "帝国");
		map.put("doc_dispunit", "衙门");
		map.put("remark", "观海云远");
		map.put("doc_state", "1");
		map.put("sendinfo", "1");
		map.put("sendim", "1");
		/*map.put("sendInfo", "0");
		map.put("sendim", "0");*/
		
		List<Map<String, Object>> a = new ArrayList<Map<String, Object>>();
		map1.put("ATTACH_ID", "www.nicai.com");
		map1.put("attach_type", "1");
		map1.put("REMARK", "忘了");
		map2.put("ATTACH_ID", "www.wobucai.com");
		map2.put("attach_type", "2");
		map2.put("REMARK", "不知道");
		a.add(map1);
		a.add(map2);
		
		map.put("doc_attach", a);
		String result = template.postForObject(base.toString() + "/v1.0/docPro/update", buildEntity(map), String.class);
		System.out.println("-----公文修改：" + result);
		
	}
	

	private HttpEntity<String> buildEntity(Map<String, Object> params) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}
}
