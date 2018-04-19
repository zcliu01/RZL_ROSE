package com.zrt.task.mapper.task;

import java.util.List;
import java.util.Map;


public interface QueryTaskMapper {

	List<Map<String, Object>> searchTask(Map<String, Object> map);
	
	List<Map<String, Object>> webSearchTask(Map<String, Object> map);
	
	List<Map<String, Object>> searchTaskByExecutor(Map<String, Object> map);
	
	List<Map<String, Object>> searchTaskByState(Map<String, Object> map);
	
	List<Map<String, Object>> attach(Map<String, Object> map);

	List<Map<String, Object>> executor(Map<String, Object> map);
	
	List<Map<String, Object>> executorByTaskId(Map<String, Object> map);
	
	List<Map<String, Object>> searchTaskByOwner(Map<String, Object> map);
	
	Map<String, Object> minNumber(Map<String, Object> map);
	
	Map<String, Object> maxMunber(Map<String, Object> map);
	
	/**
	 * 根据任务ID查找相关的关联信息
	 */
	List<Map<String, Object>> relevance(Map<String, Object> map);
}
