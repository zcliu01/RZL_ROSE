package com.zrt.gateway.api.client.task;

public interface TaskConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String TASK_INSTANCE = "task";
	
	//新增任务
	String ADD = "/v1.0/task/add";
	//WEB任务列表查询
	String WEBSEARCH = "/v1.0/task/webSearch";
	//查看任务详情
	String SEARCHINFO = "/v1.0/task/searchInfo";
	//任务终止
	String STOP = "/v1.0/task/stop";
	//待办任务查询
	String TODOSEARCH = "/v1.0/task/todoSearch";
	//任务分配
	String CALLCHILD = "/v1.0/task/callChild";
	//任务反馈
	String BACKINFO = "/v1.0/task/backInfo";
	
	//任务修改
	String CHANGE = "/v1.0/task/change";
	
	
	//任务删除
	String DELETE = "/v1.0/task/delete";
	
}
