package com.zrt.serial.web.serial;

import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.commons.ResultMap;
import com.zrt.commons.utils.UUIDUtils;
import com.zrt.serial.service.serial.SerialService;

@Service("serialController")
@SuppressWarnings("rawtypes")
public class SerialController {
	private static final Logger log = LoggerFactory.getLogger(SerialController.class);
	@Autowired
	private SerialService serialService;
	/**
	 * 获取序列
	 * @param jsonMap(biz_key,is_append,serial_num)
	 * @returnb
	 * @throws Exception
	 */
	public Map<String, Object> getSerialNumberFromDB(Map<String, Object> appMap) throws Exception{
		log.info("Server端的serialController中getSerialNumberFromDB方法");
		ResultMap resultMap=new ResultMap();
		String serial_id=null;
		try {
			String biz_key=(String)appMap.get("biz_key");
			Boolean is_append=(Boolean)appMap.get("is_append");
			Object serial_num=appMap.get("serial_num");
			if(is_append!=null){
				if(serial_num!=null){
					serial_id=serialService.getSerialNumberFromDB(biz_key, is_append, Integer.valueOf(serial_num.toString()));
				}else{
					serial_id=serialService.getSerialNumberFromDB(biz_key, is_append);
				}
			}else{
				serial_id=serialService.getSerialNumberFromDB(biz_key);
			}
			resultMap.map().put("serial_id", serial_id);
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new Exception("获取序列失败!");
		}
	}
	
	/**
	 * 获取序列
	 * @param jsonMap(biz_key,is_append)
	 * @returnb
	 * @throws Exception
	 */
	public Map<String, Object> getSerialNumber(Map<String, Object> appMap) throws Exception{
		log.info("Server端的serialController中getSerialNumber方法");
		ResultMap resultMap=new ResultMap();
		String serial_id=null;
		try {
			String biz_key=(String)appMap.get("biz_key");
			Boolean is_append=(Boolean)appMap.get("is_append");
			if(is_append!=null){
				serial_id=serialService.getSerialNumber(biz_key,is_append);
			}else{
				serial_id=serialService.getSerialNumber(biz_key);
			}
			
			log.info("-------serial_id------"+serial_id);
			resultMap.map().put("serial_id", serial_id);
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new Exception("获取序列失败!");
		}
	}
	/**
	 * 获取uuid
	 */
	
	public Map<String, Object> getUUID(Map<String, Object> appMap) throws Exception{
		log.info("Server端的serialController中getUUID方法");
		ResultMap resultMap=new ResultMap();
		String serial_id=null;
		try {
			serial_id=UUIDUtils.getUUID();
			log.info("-------serial_id------"+serial_id);
			resultMap.map().put("serial_id", serial_id);
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new Exception("获取序列失败!");
		}
	}

}
