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
@SpringApplicationConfiguration(TaskTest.class)
public class TaskTest {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:9012");
		this.template = new TestRestTemplate();
	}
	
	/**
	 * 
	 * 新建任务
	 * @throws Exception
	 */
	@Test
	public void add() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> taskMap = new HashMap<String, Object>();
		Map<String, Object> taskAttachMap = new HashMap<String, Object>();
		Map<String, Object> subtask = new HashMap<String, Object>();
		Map<String, Object> asd = new HashMap<String, Object>();
		Map<String, Object> task_executor = new HashMap<String, Object>();
		List<Map<String, Object>> subtaskList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> taskAttachList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> task_executorList = new ArrayList<Map<String, Object>>();
		taskMap.put("task_name","今天是2017年11月16号");
		taskMap.put("task_start_time","2017-11-16 20:59");
		taskMap.put("task_end_time","2017-11-18 23:59" );
		taskMap.put("task_owner","008915");//需要自动获取用户的id
		taskMap.put("task_remark","啦啦啦啦啦啦");
		taskMap.put("sendim", "1");
		taskMap.put("sendInfo", "1");
		
		/*subtask.put("task_name","上山打老虎");
		subtask.put("task_start_time","2017-11-03 20:59");
		subtask.put("task_end_time","2017-11-03 23:59" );
		subtask.put("task_owner","012634");//需要自动获取用户的id
		subtask.put("task_remark","赶快来");
		subtask.put("sendim", "1");
		subtask.put("sendInfo", "1");
		subtaskList.add(subtask);
		taskMap.put("subtask", subtaskList);*/
		
		taskAttachMap.put("attach_id","/storage/emulated/0/Tencent/QQfile_recv/APP端任务接口文档.doc");
		taskAttachMap.put("attach_name","APP端任务接口文档.doc");
		taskAttachMap.put("attach_type","1");
		taskAttachMap.put("remark","低调");
		taskAttachList.add(taskAttachMap);
		
		task_executor.put("emp_id","000021");
		task_executor.put("emp_name","柴杨");
		task_executor.put("remark","我是谁啊啊 啊啊啊啊啊 啊啊   啊啊");
		task_executorList.add(task_executor);
		asd.put("emp_id","009615");
		asd.put("emp_name","蔡萌");
		asd.put("remark","猪猪合租合租合租呼呼呼");
		task_executorList.add(asd);
		map.put("task", taskMap);
		map.put("taskattach", taskAttachList);
		map.put("task_executor", task_executorList);
		map.put("emp_id", "008915");
		String result = template.postForObject(base.toString() + "/v1.0/task/add", buildEntity(map), String.class);
		System.out.println("-----添加任务：" + result);

	}
	
	/**
	 * 任务列表查询
	 * @throws Exception
	 */
	@Test
	public void search() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("emp_id","000021");
		map.put("start_time_start", "2017-11-16");
		map.put("start_time_end", "2017-11-18");
		map.put("end_time_start", "2017-12-01");
		map.put("end_time_end", "2017-12-08");
		String result = template.postForObject(base.toString() + "/v1.0/task/webSearch", buildEntity(map), String.class);
		System.out.println("-----任务列表查询：" + result);
	}
	/**
	 * 待办任务
	 * @throws Exception
	 */
	@Test
	public void todoSearch() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("emp_id","000036");
		String result = template.postForObject(base.toString() + "/v1.0/task/todoSearch", buildEntity(map), String.class);
		System.out.println("-----任务列表查询：" + result);
		
	}
	
	
	/**
	 * 任务详情查询
	 * @throws Exception
	 */
	@Test
	public void searchInfo() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("task_id","a20ddc41f3154aa083b3a95c412fec54");
		String result = template.postForObject(base.toString() + "/v1.0/task/searchInfo", buildEntity(map), String.class);
		System.out.println("-----任务详情查询：" + result);

	}
	
	
	
	/**
	 * 任务终止和完成
	 * @throws Exception
	 */
	@Test
	public void stop() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		
		map.put("task_id", "2cd13615deef4d82851bc11b1691d8ac");
		String result = template.postForObject(base.toString() + "/v1.0/task/stop", buildEntity(map), String.class);
		System.out.println("-----任务终止：" + result);
		
	}
	/**
	 * 任务反馈
	 * @throws Exception
	 */
	@Test
	public void backInfo() throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("back_percent", "50%");
		String result = template.postForObject(base.toString() + "/v1.0/task/backInfo", buildEntity(map), String.class);
		System.out.println("-----任务终止：" + result);
		
	}
	

	private HttpEntity<String> buildEntity(Map<String, Object> params) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}
}
