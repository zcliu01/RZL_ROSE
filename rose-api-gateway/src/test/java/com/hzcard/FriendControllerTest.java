package com.hzcard;

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
@SpringApplicationConfiguration(classes = FriendControllerTest.class)
public class FriendControllerTest {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://127.0.0.1:9005");
		this.template = new TestRestTemplate();
	}
	
	/**
	 *pc端 组织机构列表(有问题)
	 * @throws Exception
	 */
	@Test
	public void orgAllList() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
	   /* messageMap.put("emp_id", "2f960ecb-4388-11e7-b66c-3c970e5c"); //黄威
	    messageMap.put("friend_emp_id", "2f960953-4388-11e7-b66c-3c970e5c"); //李朝阳
*/		
	    String result = template.postForObject(base.toString()+"/v1.0/friend/orgAllList", buildEntity(messageMap), String.class);
	    System.out.println("----pc端组织结构 列表返回："+result);
	}
	
	@Test
	public void empList() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
	   /* messageMap.put("emp_id", "2f960ecb-4388-11e7-b66c-3c970e5c"); //黄威
	    messageMap.put("friend_emp_id", "2f960953-4388-11e7-b66c-3c970e5c"); //李朝阳
*/		
	    String result = template.postForObject(base.toString()+"/v1.0/friend/empList", buildEntity(messageMap), String.class);
	    System.out.println("----pc端常用联系人 列表返回："+result);
	}
	/**
	 * app端删除常用联系人
	 * @throws Exception
	 */
	@Test
	public void friendDelete() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
	    messageMap.put("emp_id", "2f960ecb-4388-11e7-b66c-3c970e5c"); //黄威
	    messageMap.put("friend_emp_id", "2f960953-4388-11e7-b66c-3c970e5c"); //李朝阳
		
	    String result = template.postForObject(base.toString()+"/v1.0/friendApp/friendDelete", buildEntity(messageMap), String.class);
	    System.out.println("-----常用联系人 查询列表返回："+result);
	}
	
	/**
	 * App端根据主键查询常用联系人列表
	 * @param params
	 * @return
	 */
	@Test
	public void friendSearch() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
	    messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c"); //李朝阳,4个常用联系人
	    
	    String result = template.postForObject(base.toString()+"/v1.0/friendApp/friendSearch", buildEntity(messageMap), String.class);
	    System.out.println("-----常用联系人 查询列表返回："+result);
	}
	
	
	
	private HttpEntity<String> buildEntity(Map<String,Object> params){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}
	
}
