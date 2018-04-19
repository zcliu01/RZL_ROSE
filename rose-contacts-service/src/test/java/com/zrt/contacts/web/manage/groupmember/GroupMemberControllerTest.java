package com.zrt.contacts.web.manage.groupmember;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.zrt.mybatis.domain.EmpContactsFriendGroup;
import com.zrt.mybatis.domain.EmpContactsFriendGroupExample;
import com.zrt.mybatis.mapper.EmpContactsFriendGroupMapper;
import com.zrt.mybatis.mapper.EmpContactsGroupMemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GroupMemberControllerTest.class)
public class GroupMemberControllerTest {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://127.0.0.1:9002");
		this.template = new TestRestTemplate();
	}

	/**
	 * 群组成员列表+多条件检索-- 待测试--职位检索
	 * @throws Exception
	 */
	@Test
	public void groupMemList() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("friend_group_id", "2");
		messageMap.put("emp_position_name", "副");
		
		String result = template.postForObject(base.toString() + "/v1.0/groupMember/groupMemList",
				buildEntity(messageMap), String.class);
		System.out.println("--群组成员列表：" + result);
	}

	/**
	 * 测试 批量添加群组成员 groupMemberSave()
	 * 
	 * @throws Exception
	 */
	@Test
	public void groupMemberSave() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		/*
		 * List<String> list = new ArrayList<String>();
		 * list.add("fae77966-4f42-11e7-ac31-3c970e5c");
		 * list.add("2f960f88-4388-11e7-b66c-3c970e5c");
		 */
		// String groupMembers =
		// "fae77966-4f42-11e7-ac31-3c970e5c;2f960f88-4388-11e7-b66c-3c970e5c";
		String groupMembers = "faebb8ed-4f42-11e7-ac31-3c970e5c";// 靳东，离职
//		messageMap.put("emp_id", "2f960ecb-4388-11e7-b66c-3c970e5c");
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("group_members", groupMembers);
		messageMap.put("friend_group_id", "5");
		messageMap.put("friend_group_type", "2");
		
		String result = template.postForObject(base.toString() + "/v1.0/groupMember/groupMemberSave",
				buildEntity(messageMap), String.class);
		System.out.println("--批量添加群组成员：" + result);
	}

	@Test
	public void test() {
		String str = "ssss";
		String[] split = str.split(";");
		System.out.println(split.length);
		for (String string : split) {
			System.out.println(string);
		}
		/*
		 * System.out.println(String.valueOf(Integer.parseInt("1")+1));
		 * System.out.println(Integer.parseInt("1")+1+"");
		 * System.out.println(Integer.parseInt("2")+3+"");
		 */
	}

	/**
	 * 测试 批量删除群组成员 groupMemberDelete()
	 * 
	 * @throws Exception
	 */
	@Test
	public void groupMemberDelete() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
		List<String> list = new ArrayList<String>();
		list.add("fae77966-4f42-11e7-ac31-3c970e5c");
		list.add("2f960f88-4388-11e7-b66c-3c970e5c");
		messageMap.put("group_members", list);
		messageMap.put("friend_group_id", "92df48d504c041309a0008b174bdd202");

		String result = template.postForObject(base.toString() + "/v1.0/groupMember/groupMemberDelete",
				buildEntity(messageMap), String.class);
		System.out.println("--批量删除群组成员：" + result);
	}

	/**
	 * 测试 导出群组成员 exportGroupMemToExcel
	 * 
	 * @throws Exception
	 */
	@Test
	public void exportGroupMemToExcel() throws Exception {
		Map<String, Object> messageMap = new HashMap<String, Object>();
//		messageMap.put("group_members", list);
		messageMap.put("friend_group_id", "6");
//		messageMap.put("friend_group_id", "8611fb889b7048dfb9cc628a0970804d");
		messageMap.put("emp_id", "2f960953-4388-11e7-b66c-3c970e5c");
		messageMap.put("emp_ids", "2f960ecb-4388-11e7-b66c-3c970e5c;dad437e9-612b-11e7-90f1-0050569b");
		
		String result = template.postForObject(base.toString() + "/v1.0/groupMember/exportGroupMemToExcel",
				buildEntity(messageMap), String.class);
		System.out.println("--导出群组成员：" + result);
	}

	
	private HttpEntity<String> buildEntity(Map<String, Object> params) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}

}
