package com.zrt;



import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.HistoricDetailEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.properties"})
public class ModelControllerTest {
	
	private URL base;
	private RestTemplate template;

	
	@Autowired
	private ProcessEngine  processEngine;
	@Autowired
	private RuntimeService  runtimeService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private HistoryService historyService;
	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:9008");
		this.template = new TestRestTemplate();
	}
	/**
	 * 发布流程
	 */
	@Test
	public void deploy(){
		try{
			String modelId="232501";
			Model modelData = repositoryService.getModel(modelId);  
            ObjectNode modelNode = (ObjectNode) new ObjectMapper()  
                    .readTree(repositoryService  
                            .getModelEditorSource(modelData.getId()));  
            byte[] bpmnBytes = null;  
            BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);  
            bpmnBytes = new BpmnXMLConverter().convertToXML(model);  
            String processName = modelData.getName() + ".bpmn20.xml";  
            Deployment deployment = repositoryService.createDeployment()  
                    .name(modelData.getName())  
                    .addString(processName, new String(bpmnBytes)).deploy();  
            System.out.println(" deploymentId="+deployment.getId());
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
		proMap.put("applyId", "zhangsan");
		ProcessInstance processInstance= runtimeService.startProcessInstanceByKey("HuiQianServiceProcess",String.valueOf(Math.random()),proMap);
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
	 * 查询会签代办任务
	 */
	@Test
	public void findUsersTask(){
		String assignee="jeck";
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
		List<String> assigneeList=new ArrayList<String>(); //分配任务的人员
		assigneeList.add("tom1");
		assigneeList.add("jeck1");
		assigneeList.add("mary1");
		Map<String, Object> proMap = new HashMap<String, Object>();
		proMap.put("assigneeList", assigneeList);
		String taskId="157505";
		taskService.complete(taskId,proMap);//完成任务，参数为id
		System.out.println("任务完成，任务id="+taskId);
	}
	/**
	 * 完成待办任务
	 */
	@Test
	public void completeTask(){
		String taskId="137503";
		// 使用任务id,获取任务对象，获取流程实例id
		Task task=taskService.createTaskQuery().taskId(taskId).singleResult();
		//利用任务对象，获取流程实例id
		String processInstancesId=task.getProcessInstanceId();
		taskService.addComment(taskId, processInstancesId, "测试批注");
		taskService.complete(taskId);//完成任务，参数为id
		System.out.println("任务完成，任务id="+taskId);
	}
	/**
	 * 完成任务并提交表单数据
	 */
	@Test
	public void completeFormTask(){
		String taskId="170005";
		FormService formService=processEngine.getFormService();
		// 使用任务id,获取任务对象，获取流程实例id
		Task task=taskService.createTaskQuery().taskId(taskId).singleResult();
		//利用任务对象，获取流程实例id
		String processInstancesId=task.getProcessInstanceId();
		taskService.addComment(taskId, processInstancesId, "测试批注");
		List<String> assigneeList=new ArrayList<String>(); //分配任务的人员
		assigneeList.add("tom");
		assigneeList.add("jeck");
		assigneeList.add("mary");
		Map<String, String> proMap = new HashMap<String, String>();
		//proMap.put("assigneeList", assigneeList);
		proMap.put("check_status", "1");
		proMap.put("check_weight", "20%");
//		 formService.submitTaskFormData(taskId, proMap); 
		System.out.println("任务完成，任务id="+taskId);
		
		//taskService.getRenderedTaskForm(taskId);
		//historyService.createNativeHistoricTaskInstanceQuery().
		TaskFormData taskFormData= formService.getTaskFormData(taskId);
		List<FormProperty> formProperties=taskFormData.getFormProperties();
		for(FormProperty property:formProperties){
			System.out.println("check_status="+property.getType().getInformation("id"));
			System.out.println("task id="+taskId+";properties name="+property.getName()+";properties value="+property.getValue());
		}
	}
	
	/**
	 * 查询审批意见
	 * 
	 */
	@Test
	public void queryCommentList(){
		String taskId="160024";
		List<Comment> commentList=taskService.getTaskComments(taskId); 
		for(Comment comment: commentList){
			System.out.println(comment.getFullMessage());
		}
	}
	@Test
	public void findCommentByTaskId() {

		String taskId="137503"; // 现在的任务id
		HistoryService historyService=processEngine.getHistoryService();
		TaskService taskService=processEngine.getTaskService();
		List<Comment> list = new ArrayList();
		//使用当前的任务ID，查询当前流程对应的历史任务ID

		//使用当前任务ID，获取当前任务对象
		Task task = taskService.createTaskQuery()//
		.taskId(taskId)//使用任务ID查询
		.singleResult();
		//获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		//使用流程实例ID，查询历史任务，获取历史任务对应的每个任务ID
		List<HistoricTaskInstance> htiList = historyService.createHistoricTaskInstanceQuery()//历史任务表查询
		.processInstanceId(processInstanceId)//使用流程实例ID查询
		.list();
		//遍历集合，获取每个任务ID
		if(htiList!=null && htiList.size()>0){
		for(HistoricTaskInstance hti:htiList){
		//任务ID
		String htaskId = hti.getId();
		//获取批注信息
		List taskList = taskService.getTaskComments(htaskId);//对用历史完成后的任务ID
		list.addAll(taskList);
		}
		}
		list = taskService.getProcessInstanceComments(processInstanceId);


		for(Comment com:list){
		System.out.println("ID:"+com.getId());
		System.out.println("Message:"+com.getFullMessage());
		System.out.println("TaskId:"+com.getTaskId());
		System.out.println("ProcessInstanceId:"+com.getProcessInstanceId());
		System.out.println("UserId:"+com.getUserId());
		}

		System.out.println(list);
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
		//repositoryService.deleteDeployment("1501");//根据定义流程id删除
		//删除启动过的流程，级联删除
		repositoryService.deleteDeployment("107501", true);
	}
	/**
	 * 获取当前节点信息
	 */
	@Test
	public void query(){
		//根据流程ID获取当前任务：
		String procInstanceId="157501";
		List<Task> tasks = taskService.createTaskQuery().processInstanceId(procInstanceId).list();
		System.out.println("task size="+tasks.size());
		//然后根据当前任务获取当前流程的流程定义，然后根据流程定义获得所有的节点：//rs是指RepositoryService的实例
		String taskId="170005";
		//使用当前任务ID，获取当前任务对象
				Task task = taskService.createTaskQuery()//
				.taskId(taskId)//使用任务ID查询
				.singleResult();
		ProcessDefinitionEntity def = (ProcessDefinitionEntity) ((RepositoryServiceImpl)repositoryService).getDeployedProcessDefinition(task.getProcessDefinitionId());
		List<ActivityImpl> activitiList = def.getActivities();  
		System.out.println("activitiList="+activitiList.size());
		
		
		//根据任务获取当前流程执行ID，执行实例以及当前流程节点的ID：
		String excId = task.getExecutionId();
		ExecutionEntity execution = (ExecutionEntity) runtimeService.createExecutionQuery().executionId(excId).singleResult();
		String activitiId = execution.getActivityId();
		//然后循环activitiList 并判断出当前流程所处节点，然后得到当前节点实例，根据节点实例获取所有从当前节点出发的路径，然后根据路径获得下一个节点实例：
		for(ActivityImpl activityImpl:activitiList){
			String id = activityImpl.getId();
				if(activitiId.equals(id)){
					System.out.println("当前任务："+activityImpl.getProperty("name")); //输出某个节点的某种属性
					List<PvmTransition> inTransitions = activityImpl.getIncomingTransitions();//获取进入某个节点的所有线路
					for(PvmTransition tr:inTransitions){
						PvmActivity ac = tr.getDestination(); //获取线路的上一节点
						System.out.println("上一步任务任务："+ac.getProperty("name"));
					}
					List<PvmTransition> outTransitions = activityImpl.getOutgoingTransitions();//获取从某个节点出来的所有线路
					for(PvmTransition tr:outTransitions){
						PvmActivity ac = tr.getDestination(); //获取线路的终点节点
						System.out.println("下一步任务任务："+ac.getProperty("name"));
					}
				break;
			}
		}
	}
	/**
	 * 获取任务的审核批注信息
	 */
	@Test
	public void queryDetail(){
		//获取流程实例ID
		String processInstanceId = "157501";
		//使用流程实例ID，查询历史任务，获取历史任务对应的每个任务ID
		List<HistoricTaskInstance> htiList = historyService.createHistoricTaskInstanceQuery()//历史任务表查询
		.processInstanceId(processInstanceId)//使用流程实例ID查询
		.list();
		//遍历集合，获取每个任务ID
		List<Comment> list = new ArrayList();
		if(htiList!=null && htiList.size()>0){
		for(HistoricTaskInstance hti:htiList){
			//任务ID
			String htaskId = hti.getId();
			//获取批注信息
			List taskList = taskService.getTaskComments(htaskId);//对用历史完成后的任务ID
			System.out.println("批注信息条数："+taskList.size());
			list.addAll(taskList);
		}
		}
		//获取任务明细
		List<HistoricDetail> htiDetailList = historyService.createHistoricDetailQuery().taskId("160024").list();
 		for(HistoricDetail detail:htiDetailList){
			System.out.println("name:"+detail.getId());
		}
	}
}
