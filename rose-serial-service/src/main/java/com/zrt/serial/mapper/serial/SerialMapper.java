package com.zrt.serial.mapper.serial;

import java.util.Map;

public interface SerialMapper {

	//根据key查询
	Map<String, Object> serialSearch(Map<String, Object> appMap) throws Exception;
	//序列修改
	int serialUpdate(Map<String, Object> appMap) throws Exception;
	//序列新增
	int serialSave(Map<String, Object> appMap) throws Exception;
	//修改下一个序列
	int serialNextUpdate(Map<String, Object> appMap) throws Exception;
}
