package com.zrt.task.service.task;

import java.util.List;
import java.util.Map;


public interface TaskService {

	
	/**
	 * 新增任务
	 * 
	 */
	int add(Map<String, Object> map) throws Exception;
	
	/**
	 * 修改任务
	 * 
	 */
	int change(Map<String, Object> map) throws Exception;
	
	/**
	 * 删除任务
	 * 
	 */
	int delete(Map<String, Object> map) throws Exception;
	
	/**
	 * 任务列表查询
	 * 
	 */
	Map<String, Object> search(Map<String, Object> map) throws Exception;
	
	/**
	 * Web任务列表查询
	 * 
	 */
	Map<String, Object> webSearch(Map<String, Object> map) throws Exception;
	
	/**
	 * 查看任务详情
	 * 
	 */
	Map<String, Object> searchInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 任务终止
	 * 
	 */
	int stop(Map<String, Object> map) throws Exception;
	
	/**
	 * 任务分配
	 * 
	 */
	int callChild(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * 任务反馈
	 */
	int backInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 待办任务查询
	 * 
	 */
	Map<String, Object> todoSearch(Map<String, Object> map) throws Exception;
	
}
