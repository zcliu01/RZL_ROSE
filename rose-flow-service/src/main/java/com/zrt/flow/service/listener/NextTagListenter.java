package com.zrt.flow.service.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("next_tag_assignee_list")
public class NextTagListenter implements ExecutionListener,TaskListener{

	private static final long serialVersionUID = 1L;
	@Autowired
	private CommonListenerService commonListenerService;
	@Autowired
	private ExecutionListenerService executionListenerService;
	//实现TaskListener中的方法
	@Override
	@Transactional(rollbackFor={Throwable.class},propagation=Propagation.REQUIRED)
	public void notify(DelegateTask delegateTask) {
		String eventName = delegateTask.getEventName();
		if ("create".endsWith(eventName)) {  
			try {
				commonListenerService.assigneeList(delegateTask);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("create=========");  
		}else if ("assignment".endsWith(eventName)) {  
		System.out.println("assignment========");  
		}else if ("complete".endsWith(eventName)) {
		System.out.println("complete===========");  
		}else if ("delete".endsWith(eventName)) {  
		System.out.println("delete=============");  
		}  
		
	}

	//ExecutionListener类的实现
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		String eventName = execution.getEventName();  
		//start  
		if ("start".equals(eventName)) {  
		    System.out.println("start=========");  
		}else if ("end".equals(eventName)) {  
		    System.out.println("end=========");  
		}  
		else if ("take".equals(eventName)) {  
		//当走到连线的时候取下一节点审批会签审批
			executionListenerService.takeExecution(execution);
		    System.out.println("take=========");  
		} 
		
	}

}
