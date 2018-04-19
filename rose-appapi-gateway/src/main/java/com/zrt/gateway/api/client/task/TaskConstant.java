package com.zrt.gateway.api.client.task;

public interface TaskConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String TASK_INSTANCE = "task";
	
	//新增任务
	String ADD = "/v1.0/apptask/add";
	//任务列表查询
	String SEARCH = "/v1.0/apptask/search";
	//查看任务详情
	String SEARCHINFO = "/v1.0/apptask/searchInfo";
	//任务终止
	String STOP = "/v1.0/apptask/stop";
	//待办任务查询
	String TODOSEARCH = "/v1.0/apptask/todoSearch";
	//任务分配
	String CALLCHILD = "/v1.0/apptask/callChild";
	//任务反馈
	String BACKINFO = "/v1.0/apptask/backInfo";
	

}
