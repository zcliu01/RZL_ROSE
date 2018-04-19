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
@SpringApplicationConfiguration(InforPubTest.class)
public class InforPubTest {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:9015");
		this.template = new TestRestTemplate();
	}
	
	/**
	 * 
	 * 新建公告 Ok
	 * @throws Exception
	 */
	@Test
	public void save() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("info_title", "雪中悍刀行");
		map.put("info_owner", "李淳刚");
		map.put("info_type", "98");
		map.put("info_number", "007");
		map.put("info_order", "98");
		map.put("info_content", "天不生我李淳刚,剑道万古如长夜");
		Map<String, Object> map2 = new HashMap<String,Object>();
		Map<String, Object> map4 = new HashMap<String,Object>();
		map2.put("view_id", "002");
		map2.put("view_name", "邓太阿");
		map2.put("remark", "剑速");
		map4.put("view_id", "003");
		map4.put("view_name", "独孤求败");
		map4.put("remark", "剑招");
		
		Map<String, Object> map3 = new HashMap<String,Object>();
		Map<String, Object> map5 = new HashMap<String,Object>();
		map3.put("ATTACH_ID", "www.sogou.com");
		map3.put("attach_type", "2");
		map3.put("REMARK", "搜狗");
		map5.put("ATTACH_ID", "www.yahoo.com");
		map5.put("attach_type", "1");
		map5.put("REMARK", "雅虎");

		List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
		list1.add(map2);
		list1.add(map4);
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		list2.add(map3);
		list2.add(map5);
		map.put("info_viewer", list1);
		map.put("info_attach", list2);
		String result = template.postForObject(base.toString() + "/v1.0/infoPub/save", buildEntity(map), String.class);
		System.out.println("-----添加公示：" + result);

	}
	
	/**
	 * 公示查询             OK
	 * @throws Exception
	 */
	@Test
	public void search() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("emp_id", "007327");
		map.put("info_state", "0");
		String result = template.postForObject(base.toString() + "/v1.0/infoPub/search", buildEntity(map), String.class);
		System.out.println("-----公示查询：" + result);

	}
	
	
	/**
	 * 公示删除
	 * @throws Exception
	 */
	@Test
	public void del() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		String result = template.postForObject(base.toString() + "/v1.0/ infoPub /del", buildEntity(map), String.class);
		System.out.println("-----公示删除：" + result);

	}
	
	
	
	/**
	 * 查看公示详情   OK
	 * @throws Exception
	 */
	@Test
	public void searchInfo() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("info_ID", "7f82c7f513e442bba5c6c2b3361946b0");
		String result = template.postForObject(base.toString() + "/v1.0/ infoPub /searchInfo", buildEntity(map), String.class);
		System.out.println("-----查看公示详情：" + result);
		
	}
	/**
	 * 公示类型查询   OK
	 * @throws Exception
	 */
	@Test
	public void state_search() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		
		String result = template.postForObject(base.toString() + "/v1.0/ infoPub/state_search", buildEntity(map), String.class);
		System.out.println("-----公示类型查询：" + result);
		
	}
	
	
	/**
	 * 公示类型维护  OK
	 * @throws Exception
	 */
	@Test
	public void state_save() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("info_type_code", "2");
		map.put("info_type_state", "0");
		//map.put("info_type_name", "会议纪要");
		//map.put("info_type_name", "会议纪要");
		//map.put("info_type_name", "公司新闻");
		//map.put("info_type_name", "公司发文");
		//map.put("info_type_name", "财富专栏");
		//map.put("info_type_name", "党建知识");
		//map.put("info_type_name", "招聘信息");
		String result = template.postForObject(base.toString() + "/v1.0/ infoPub/state_save", buildEntity(map), String.class);
		System.out.println("-----公示类型维护：" + result);
		
	}
	

	private HttpEntity<String> buildEntity(Map<String, Object> params) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}
}
