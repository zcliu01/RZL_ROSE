package com.zrt.flow.service.act;

import java.util.Date;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cfg.IdGenerator;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.task.Task;
import org.apache.commons.beanutils.BeanUtils;


/***
 * 加签
 * @author wwfu
 *
 */
public class SelfCountersignAddCmd implements Command<Void>{
    private String taskId;//任务id
    
    private String assignee;//执行人员
	
    /**
	@Override
	public Void execute(CommandContext commandContext) {
		ProcessEngineConfigurationImpl pec=commandContext.getProcessEngineConfiguration();
		RuntimeService runtimeService=pec.getRuntimeService();
		TaskService taskService=pec.getTaskService();
		IdGenerator idGenerator=pec.getIdGenerator();
		
		//获取当前任务
		Task newTask=taskService.createTaskQuery().taskId(taskId).singleResult();
		TaskEntity t=(TaskEntity)newTask;
		String executionId=newTask.getExecutionId();
		
		//获取执行实例
		Execution execution=runtimeService.createExecutionQuery().executionId(executionId).singleResult();
		ExecutionEntity ee=(ExecutionEntity)execution;
		//获取父级实例
		ExecutionEntity parent=ee.getParent();
		//创建执行实例
		ExecutionEntity newExecution=parent.createExecution();
		newExecution.setActive(true);//设置激活状态 true
		newExecution.setConcurrent(true);//表示创建的为分支
		newExecution.setScope(false);
		
		//创建新的任务
		TaskEntity taskEntity=new TaskEntity();
		taskEntity.setCreateTime(new Date());
		taskEntity.setTaskDefinition(t.getTaskDefinition());
		taskEntity.setTaskDefinitionKey(t.getTaskDefinitionKey());
		taskEntity.setProcessDefinitionId(t.getProcessDefinitionId());
		taskEntity.setProcessInstanceId(t.getProcessInstanceId());
		taskEntity.setExecutionId(newExecution.getId());
		taskEntity.setName(newExecution.getName());
		taskEntity.setId(idGenerator.getNextId());
		taskEntity.setExecution(newExecution);
		taskEntity.setAssignee(assignee);
		taskService.saveTask(taskEntity);
		int loopCounter=SelfLoopVariableUtils.getLoopVariable(newExecution, "nrOfInstances");
		int nrOfActiveInstances=SelfLoopVariableUtils.getLoopVariable(newExecution, "nrOfActiveInstances");
		SelfLoopVariableUtils.setLoopVariable(newExecution, "nrOfInstances", loopCounter+1);
		SelfLoopVariableUtils.setLoopVariable(newExecution, "nrOfActiveInstances", nrOfActiveInstances+1);

		return null;
	}**/
    

	@Override
	public Void execute(CommandContext commandContext) {
		try{
		ProcessEngineConfigurationImpl pec=commandContext.getProcessEngineConfiguration();
		RuntimeService runtimeService=pec.getRuntimeService();
		TaskService taskService=pec.getTaskService();
		IdGenerator idGenerator=pec.getIdGenerator();
		//获取当前任务
		Task newTask=taskService.createTaskQuery().taskId(taskId).singleResult();
		TaskEntity t=(TaskEntity)newTask;
		String executionId=newTask.getExecutionId();
		
		//获取执行实例
		Execution execution=runtimeService.createExecutionQuery().executionId(executionId).singleResult();
		ExecutionEntity ee=(ExecutionEntity)execution;
//		ExecutionEntity newExecution=ee.createExecution();
		 ExecutionEntity newExecution = new ExecutionEntity();
		 BeanUtils.copyProperties(newExecution, ee);
		 String newExecutionId=idGenerator.getNextId();
		 newExecution.setId(newExecutionId);
		 newExecution.setRevision(1);
		 commandContext
	      .getDbSqlSession()
	      .insert(newExecution);
		//创建新的任务
		TaskEntity taskEntity=new TaskEntity();
		taskEntity.setCreateTime(new Date());
		taskEntity.setTaskDefinition(t.getTaskDefinition());
		taskEntity.setTaskDefinitionKey(t.getTaskDefinitionKey());
		taskEntity.setProcessDefinitionId(t.getProcessDefinitionId());
		taskEntity.setProcessInstanceId(t.getProcessInstanceId());
		taskEntity.setExecutionId(newExecution.getId());
		taskEntity.setName(newExecution.getName());
		taskEntity.setId(idGenerator.getNextId());
		taskEntity.setExecution(newExecution);
		taskEntity.setAssignee(assignee);
//		taskEntity.setRevision(t.getRevisionNext());
		taskService.saveTask(taskEntity);
		}catch(Exception e){
			
		}
		return null;
	}
	
	public SelfCountersignAddCmd(String taskId,String assignee){
		this.taskId=taskId;
		this.assignee=assignee;
	}

}
