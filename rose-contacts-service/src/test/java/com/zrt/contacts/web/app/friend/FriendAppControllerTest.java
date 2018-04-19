package com.zrt.contacts.web.app.friend;

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
@SpringApplicationConfiguration(classes = FriendAppControllerTest.class)
public class FriendAppControllerTest {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://127.0.0.1:9002");
		this.template = new TestRestTemplate();
	}
	
	/**
	 *app端 保存常用联系人
	 * @throws Exception
	 */
	@Test
	public void friendSave() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
	    messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
//	    messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");//李朝阳
	    /*List<String> list = new ArrayList<String> ();
	    list.add("2f960f88-4388-11e7-b66c-3c970e5c");//王娟
	    list.add("2f960ecb-4388-11e7-b66c-3c970e5c");*/
	    String  friendEmpIds="2f960f88-4388-11e7-b66c-3c970e5c;2f960ecb-4388-11e7-b66c-3c970e5c";
        messageMap.put("friend_emp_id", "fae77966-4f42-11e7-ac31-3c970e5c;3d185795-57bf-11e7-9a92-0050569b"); 
	   
	    String result = template.postForObject(base.toString()+"/v1.0/friendApp/friendSave", buildEntity(messageMap), String.class);
	    System.out.println("-----批量添加常用联系人返回："+result);
	}
	
	/**
	 * app端删除常用联系人
	 * @throws Exception
	 */
	@Test
	public void friendDelete() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");//李朝阳
	   /* List<String> list = new ArrayList<String> ();
	    list.add("2f960f88-4388-11e7-b66c-3c970e5c");//王娟
	    list.add("2f960ecb-4388-11e7-b66c-3c970e5c");*/
//	    list.add("2f960953-4388-11e7-b66c-3c970e5c");
		String friendEmpId = "2f960f88-4388-11e7-b66c-3c970e5c";
        messageMap.put("friend_emp_id", friendEmpId); //李朝阳
		
	    String result = template.postForObject(base.toString()+"/v1.0/friendApp/friendDelete", buildEntity(messageMap), String.class);
	    System.out.println("-----删除常用联系人 返回："+result);
	}
	
	/**
	 * App端根据主键查询常用联系人列表
	 * @param params
	 * @return
	 */
	@Test
	public void friendList() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
	    messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c"); //李朝阳,4个常用联系人
	    messageMap.put("search", "z"); 
//		messageMap.put("status", "");
	    String result = template.postForObject(base.toString()+"/v1.0/friendApp/friendList", buildEntity(messageMap), String.class);
	    System.out.println("-----常用联系人 查询列表返回："+result);
	}
	
	/**
	 * APP端 添加常用联系人 页面初始化 
	 * @param params
	 * @return
	 */
	@Test
	public void friendSavePage() throws Exception {
		Map<String,Object> messageMap = new HashMap<String,Object>();
	    messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c"); 
//		messageMap.put("status", "");
//	    messageMap.put("search", "Jindong");
	    String result = template.postForObject(base.toString()+"/v1.0/friendApp/friendSavePage", buildEntity(messageMap), String.class);
	    System.out.println("--添加常用联系人页面 初始化数据返回："+result);
	}
	
	@Test
	public void test(){
		String ssq="sq;s;s";
		System.out.println(ssq);
		String ss="sa；aa；sada；";
		String replaceString ="";
		if(ss.contains("；")){
		  replaceString = ss.replace('；',';');
		}
		System.out.println(replaceString);
	}
	
	private HttpEntity<String> buildEntity(Map<String,Object> params){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}
	
}
