package com.zrt;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.TaskService;
import org.activiti.engine.impl.util.ReflectUtil;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.zrt.flow.service.act.ActProcessService;
import com.zrt.flow.service.process.ProcessServiceImp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServiceApplication.class)
@WebAppConfiguration
public class ProcessServiceTest {

	@Autowired
	private ActProcessService actProcessService;
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ProcessServiceImp processServiceImp;
	@Test
	public void tagInfo(){
		// 查询已经完成的节点信息列表
		String taskId="b4476167-ef92-11e7-a621-02420a00007e";
		try {
//			List<Map<String, Object>> list = actProcessService.backTagList(taskId);
//			for(Map<String, Object> map:list){
//				System.out.println("finish_tag_name"+map.get("finish_tag_name"));
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void nextTagList(){
		// 查询已经完成的节点信息列表
		String taskId="b4476167-ef92-11e7-a621-02420a00007e";
		Map<String, Object> map=new HashMap<>();
		map.put("id", "7e457507dc3b4e06a81ae6ebefc83bb4");
		try {
			Map<String, Object> resMap = processServiceImp.actNextList(map);
				System.out.println("finish_tag_name"+resMap.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void isJointTask(){
		String taskId="a7cbe59a-f0f9-11e7-918b-02420a000014";
		try {
			actProcessService.isJointTask(taskId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void completeTask(){
		String taskId="a7cbe59a-f0f9-11e7-918b-02420a000014";
		// 使用任务id,获取任务对象，获取流程实例id
		Task task=taskService.createTaskQuery().taskId(taskId).singleResult();
		//利用任务对象，获取流程实例id
		String processInstancesId=task.getProcessInstanceId();
		taskService.addComment(taskId, processInstancesId, "测试批注");
		taskService.complete(taskId);//完成任务，参数为id
		System.out.println("任务完成，任务id="+taskId);
	}
	
	@Test
	public void check(){
		//String ss="'check_comment':'同意','check_status':'1','check_type':'0','file':[],'inst_id':'P18010400423','next_tag_assignee':'','rel':[],'repeat_flag':'0','task_id':'cb45d7ab-f127-11e7-8723-02420a00001a'";
		Map<String, Object> appMap=new HashMap<String, Object>();
		appMap.put("emp_id", "007327");
		appMap.put("check_comment", "同意");
		appMap.put("check_status", "1");
		appMap.put("check_type", "0");
		appMap.put("file", new ArrayList<>());
		appMap.put("inst_id", "P18010400423");
		appMap.put("next_tag_assignee", "000036");
		appMap.put("rel", new ArrayList<>());
		appMap.put("repeat_flag", "0");
		appMap.put("task_id", "cb45d7ab-f127-11e7-8723-02420a00001a");
		try {
			processServiceImp.check(appMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test(){
		byte [] bytes=new byte[]{-17, -65, -67, -17, -65, -67, 0, 5, 115, 114, 0, 26, 106, 97, 118, 97, 46, 117, 116, 105, 108, 46, 65, 114, 114, 97, 121, 115, 36, 65, 114, 114, 97, 121, 76, 105, 115, 116, -39, -92, 60, -17, -65, -67, -51, -120, 6, -17, -65, -67, 2, 0, 1, 91, 0, 1, 97, 116, 0, 19, 91, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 59, 120, 112, 117, 114, 0, 19, 91, 76, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 116, 114, 105, 110, 103, 59, -17, -65, -67, -17, -65, -67, 86, -17, -65, -67, -17, -65, -67, 29, 123, 71, 2, 0, 0, 120, 112, 0, 0, 0, 2, 116, 0, 6, 48, 48, 51, 52, 50, 55, 116, 0, 6, 48, 48, 55, 51, 50, 55};
//		byte [] bytes=new byte[]{-84, -19, 0, 5, 115, 114, 0, 26, 106, 97, 118, 97, 46, 117, 116, 105, 108, 46, 65, 114, 114, 97, 121, 115, 36, 65, 114, 114, 97, 121, 76, 105, 115, 116, -39, -92, 60, -66, -51, -120, 6, -46, 2, 0, 1, 91, 0, 1, 97, 116, 0, 19, 91, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 59, 120, 112, 117, 114, 0, 19, 91, 76, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 116, 114, 105, 110, 103, 59, -83, -46, 86, -25, -23, 29, 123, 71, 2, 0, 0, 120, 112, 0, 0, 0, 2, 116, 0, 5, 116, 111, 109, 51, 49, 116, 0, 6, 106, 101, 99, 107, 51, 51};

		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		 
		try {
			FileOutputStream fout = new FileOutputStream("C:\\copy.txt"); 
			 int b = -1;  
		      while((b=bais.read())!=-1){  
		            fout.write(b);  
		       }  
			 BufferedReader br = new BufferedReader(new InputStreamReader(bais));

			//这里就是IO的知识了
	         String line="";
	         while( (line=br.readLine())!=null ){
	             System.out.println(line);
	             //我这里就直接输出了，你可以输出到另外的文件中的,本质上就是流嘛。
	         }
			 ObjectInputStream ois =new ObjectInputStream(bais) {
			      protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
			        return ReflectUtil.loadClass(desc.getName());
			      }
			    };
			    Object deserializedObject = ois.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
