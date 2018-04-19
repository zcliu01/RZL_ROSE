package com.zrt;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.properties"})
public class DemoProcessTest {
	@Autowired
	private ProcessEngine  processEngine;
	@Autowired
	private RuntimeService  runtimeService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private TaskService taskService;
	@Before
	public void setUp() throws Exception {
		//processEngine=ProcessEngines.getDefaultProcessEngine();
	}
	/**
	 * 发布流程
	 */
	@Test
	public void deploy(){
		try{
		Deployment deployment =processEngine.getRepositoryService().createDeployment().name("demoProcessName").addClasspathResource("diagrams/demoProcess.bpmn").addClasspathResource("diagrams/demoProcess.png").deploy();
	    System.out.println(deployment.getId());
	    System.out.println(deployment.getName());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 启动流程
	 */
	@Test
	public void flowStart(){
		Map<String, Object> proMap = new HashMap<String, Object>();
		proMap.put("apply_id", "lili");
		ProcessInstance processInstance= runtimeService.startProcessInstanceByKey("qingjia",proMap);
		System.out.println(processInstance.getId());//流程实例id
	    System.out.println(processInstance.getDeploymentId());//流程定义Id
	    
//	    ProcessDefinition ProcessDefinition=  repositoryService.getProcessDefinition(processInstance.getDeploymentId());
//	    System.out.println(processInstance.getId());//流程实例id
//	    System.out.println(ProcessDefinition.getKey());//流程定义名称
	}
	
	/**
	 * 查询当前人代办任务
	 */
	@Test
	public void findTask(){
		String assignee="zhangsan";
		List<Task> taskList=taskService.createTaskQuery().taskAssignee(assignee).list();
		System.out.println("待办条数："+taskList.size());
		for(Task task: taskList){
			System.out.println("代办任务Id:"+task.getId());
			System.out.println("任务名称:"+task.getName());
			System.out.println("任务创建时间:"+task.getCreateTime());
			System.out.println("任务办理人:"+task.getAssignee());
			System.out.println("流程实例ID:"+task.getProcessInstanceId());
			System.out.println("执行对象ID:"+task.getExecutionId());
			System.out.println("流程定义ID:"+task.getProcessDefinitionId());
		}
	}
	/**
	 * 完成待办任务带退回的
	 */
	@Test
	public void completeTaskDeal(){
		Map<String, Object> proMap = new HashMap<String, Object>();
		proMap.put("deal_status", 0);
		String taskId="7502";
		taskService.complete(taskId,proMap);//完成任务，参数为id
		System.out.println("任务完成，任务id="+taskId);
	}
	/**
	 * 完成待办任务
	 */
	@Test
	public void completeTask(){
		String taskId="10005";
		taskService.complete(taskId);//完成任务，参数为id
		System.out.println("任务完成，任务id="+taskId);
	}
	/**
	 * 查询流程定义
	 */
	@Test
	public void findProcessDefintion(){
		List<ProcessDefinition> processDefinitionList=repositoryService.createProcessDefinitionQuery().orderByProcessDefinitionName().desc()
				//.count();//返回结果集的数量
		       // .listPage(firstResult, maxResult);//分页查询
				.list();
		for(ProcessDefinition pd: processDefinitionList){
			System.out.println("流程定义ID:"+pd.getId());
			System.out.println("任务名称:"+pd.getName());
			System.out.println("流程定义key:"+pd.getKey());
			System.out.println("流程定义的版本:"+pd.getVersion());
			System.out.println("资源名称bmpn文件:"+pd.getResourceName());
			System.out.println("资源名称png文件:"+pd.getDiagramResourceName());
			System.out.println("部署Id:"+pd.getDeploymentId());
		}
		
	}
	/**
	 * 删除流程定义
	 */
	@Test
	public void deleteProcessDefintion(){
		//只删除没有启动的流程定义，如果启动会抛错
		repositoryService.deleteDeployment("1501");//根据定义流程id删除
		//删除启动过的流程，级联删除
		repositoryService.deleteDeployment("1501", true);
	}
	

	
}
