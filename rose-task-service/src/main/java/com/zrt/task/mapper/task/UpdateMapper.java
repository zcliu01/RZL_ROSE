package com.zrt.task.mapper.task;

import java.util.Map;

public interface UpdateMapper {

	int updateState(Map<String, Object> map);
	
	int updateExecutorState(Map<String, Object> map);
	
	int deleteExecutor(Map<String, Object> map);
	
	int deleteExecutorById(Map<String, Object> map);
	
	int deleteAttach(Map<String, Object> map);
	
	int deleteTask(Map<String, Object> map);
	
	int deleteRelevance(Map<String, Object> map);
	
	int updateRelevance(Map<String, Object> map);
	
	
	int updateIsRead(Map<String, Object> map);
	
	
	
}
