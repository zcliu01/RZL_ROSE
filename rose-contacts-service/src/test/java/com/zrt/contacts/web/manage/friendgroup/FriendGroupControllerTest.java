package com.zrt.contacts.web.manage.friendgroup;

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
@SpringApplicationConfiguration(classes = FriendGroupControllerTest.class)
public class FriendGroupControllerTest {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://127.0.0.1:9002");
		this.template = new TestRestTemplate();
	}
	
	
	
	/**
	 *测试 创建群组窗口
	 * @throws Exception
	 */
	@Test
	public void friendGroupSavePage() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		
		//messageMap.put("type", "0"); //type 1 显示我加入的群组
		//messageMap.put("search", "");
	    
		String result = template.postForObject(base.toString()+"/v1.0/friendGroup/friendGroupSavePage", buildEntity(messageMap), String.class);
	    System.out.println("----创建群组 窗口初始化列表 返回："+result);
	}
	

	/**
	 *测试 创建群组功能
	 * @throws Exception
	 */
	@Test
	public void friendGroupSave() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		
		String originalGroupMemberIds="";
//		list.add("2f960f88-4388-11e7-b66c-3c970e5c");
//		list.add("fae77966-4f42-11e7-ac31-3c970e5c");
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("group_member_ids", "");
		messageMap.put("friend_group_name", "水木年华");
		
		String result = template.postForObject(base.toString()+"/v1.0/friendGroup/friendGroupSave", buildEntity(messageMap), String.class);
	    System.out.println("----创建群组 返回："+result);
	}
	
	/**
	 *测试 群组详情
	 * @throws Exception
	 */
	@Test
	public void friendGroupDetails() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		
		messageMap.put("friend_group_id", "4");
	    
	    String result = template.postForObject(base.toString()+"/v1.0/friendGroup/friendGroupDetails", buildEntity(messageMap), String.class);
	    System.out.println("--查看群组详情 返回："+result);
	}
	
	/**
	 *测试 更新群组名称以及群组简介
	 * @throws Exception
	 */
	@Test
	public void friendGroupUpdate() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		
		messageMap.put("friend_group_id", "ba72d8179a5b45578e3b784ccf679e2c");
		messageMap.put("friend_group_name", "");
		messageMap.put("friend_group_desc", "2323");
	    
	    String result = template.postForObject(base.toString()+"/v1.0/friendGroup/friendGroupUpdate", buildEntity(messageMap), String.class);
	    System.out.println("--更新群组详情返回："+result);
	}
	
	
	/**
	 *测试 解散群组或者退出群组 功能
	 * @throws Exception
	 */
	@Test
	public void groupDismissOrQuit() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		
		messageMap.put("friend_group_id", "539146ab101640798db8747d8b6f0e06");
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("is_group_host", "1");
	   
		String result = template.postForObject(base.toString()+"/v1.0/friendGroup/groupDismissOrQuit", buildEntity(messageMap), String.class);
	    System.out.println("--解散或者退出群组 返回："+result);
	}
	
	/**
	 *测试 PC端群组列表树
	 * @throws Exception
	 */
	@Test
	public void friendGroupTree() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		
		//messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
	    
	    String result = template.postForObject(base.toString()+"/v1.0/friendGroup/friendGroupTree", buildEntity(messageMap), String.class);
	    System.out.println("--pc端群组列表树 返回："+result);
	}
	
	
	
	private HttpEntity<String> buildEntity(Map<String,Object> params){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}
	
	
}
