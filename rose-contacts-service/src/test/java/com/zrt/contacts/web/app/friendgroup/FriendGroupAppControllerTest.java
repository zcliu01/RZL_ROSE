package com.zrt.contacts.web.app.friendgroup;

import java.net.URL;
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
import com.zrt.mybatis.domain.EmpContactsFriendGroup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FriendGroupAppControllerTest.class)
public class FriendGroupAppControllerTest {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://127.0.0.1:9002");
		this.template = new TestRestTemplate();
	}
	
	/**
	 *测试 我的群组
	 * @throws Exception
	 */
	@Test
	public void friendGroupList() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		//测试我创建的群组
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("type", "2"); //type 0 显示创建的群组
//		messageMap.put("status", "1"); 
	    
		//测试我加入的群组
//		messageMap.put("type", "1"); //type 1 显示我加入的群组
//		messageMap.put("status", "0"); 
//	    messageMap.put("emp_id", "2f960ecb-4388-11e7-b66c-3c970e5c"); //黄威，加入1和2 的群组：群组1有3人，群组2有2人
	   
		//测试公司群组
		//messageMap.put("type", "2");
	//	messageMap.put("status", "0"); 
//		
//		messageMap.put("emp_id", "2f960ecb-4388-11e7-b66c-3c970e5c");
	   
	    //测试群组搜索
		//messageMap.put("type", "");
//		messageMap.put("status", "0");
		
	    String result = template.postForObject(base.toString()+"/v1.0/friendGroupApp/friendGroupList", buildEntity(messageMap), String.class);
	    System.out.println("----我的群组查询列表 返回："+result);
	}
	
	/**
	 *测试 群组详情
	 * @throws Exception
	 */
	@Test
	public void selectGroupDetails() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("friend_group_id", "0e4139aab97b4e5786fc8600bdec1933");
//		messageMap.put("status", "0");
		
	    String result = template.postForObject(base.toString()+"/v1.0/friendGroupApp/selectGroupDetails", buildEntity(messageMap), String.class);
	    System.out.println("--查看群组详情 返回："+result);
	}
	
	/**
	 *测试 群组成员列表
	 * @throws Exception
	 */
	@Test
	public void selectGroupMemList() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("friend_group_id", "5");
		messageMap.put("search", " L ");
//     	messageMap.put("status", "");
		
	    String result = template.postForObject(base.toString()+"/v1.0/friendGroupApp/selectGroupMemList", buildEntity(messageMap), String.class);
	    System.out.println("--查看群组成员列表 返回："+result);
	}
	
	/**
	 *测试 删除群组成员
	 * @throws Exception
	 */
	@Test
	public void groupMemDelete() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("friend_group_id", "3");
		String group_members="2f960f88-4388-11e7-b66c-3c970e5c";
		messageMap.put("group_members", group_members);
//		messageMap.put("search", " L ");
//     	messageMap.put("status", "");
		
	    String result = template.postForObject(base.toString()+"/v1.0/friendGroupApp/groupMemDelete", buildEntity(messageMap), String.class);
	    System.out.println("--删除群组成员 返回："+result);
	}
	
	/**
	 *测试 修改群组信息
	 * @throws Exception
	 */
	@Test
	public void friendGroupUpdate() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("friend_group_id", "40247e421418400fb5f1d06158458079");
		messageMap.put("friend_group_name", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab");
		
	    String result = template.postForObject(base.toString()+"/v1.0/friendGroupApp/friendGroupUpdate", buildEntity(messageMap), String.class);
	    System.out.println("--修改群组信息 返回："+result);
	}
	
	
	/**
	 *测试 添加群组成员页面初始化
	 * @throws Exception
	 */
	@Test
	public void groupMemberSavePage() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("friend_group_id", "3");
		messageMap.put("search", "H");
//		messageMap.put("status", "");
		
	    String result = template.postForObject(base.toString()+"/v1.0/friendGroupApp/groupMemberSavePage", buildEntity(messageMap), String.class);
	    System.out.println("--添加群组成员页面初始化 返回："+result);
	}
	
	
	
	/**
	 *测试 创建群组
	 * @throws Exception
	 */
	@Test
	public void friendGroupSave() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("friend_group_name", "周五嗨");
		messageMap.put("friend_group_head_photo", "/sdswd/ssfdd.jpg");
		messageMap.put("friend_group_desc", "公司团购优惠群组");
		messageMap.put("group_member_ids", "2f960dea-4388-11e7-b66c-3c970e5c;faebb6bf-4f42-11e7-ac31-3c970e5c;2f960f88-4388-11e7-b66c-3c970e5c;2f960953-4388-11e7-b66c-3c970e5c;");
//		messageMap.put("friend_group_type", "1");
	    String result = template.postForObject(base.toString()+"/v1.0/friendGroupApp/friendGroupSave", buildEntity(messageMap), String.class);
	    System.out.println("--创建群组 返回："+result);
	}
	
	private HttpEntity<String> buildEntity(Map<String,Object> params){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}
	
	
}
