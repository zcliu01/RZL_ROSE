package com.zrt.daywork.service.serial;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.zrt.client.serial.ISerialClient;

@Service
public class SerialService
{
	private final transient Logger logger = LoggerFactory.getLogger(SerialService.class);
	@Resource(name="HystrixSerialClient")
	private ISerialClient serialClient;
	
	/**
	 * 数据库获取序列号
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public String getSerialNumberFromDB(Map<String, Object> paramMap) {
		logger.info("获取序列号（getSerialNumberFromDB）的JSON参数:"+paramMap);
		Map<String, Object> result = serialClient.getSerialNumberFromDB(paramMap);
		return (String)result.get("serial_id");
	}
	
	/**
	 * 算法获取序列号
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public String getSerialNumber(Map<String, Object> paramMap)  {
		logger.info("获取序列号（getSerialNumber）的JSON参数:"+paramMap);
		Map<String, Object> result = serialClient.getSerialNumber(paramMap);
		return (String)result.get("serial_id");
	}
	
	  public String getSerialNumber(String paramString)
	  {
		  Map<String , Object> reqMap=new HashMap<String , Object>();
		  reqMap.put("biz_key", paramString);//序列key
	    return getSerialNumber(reqMap);
	  }

	  public String getSerialNumber(String paramString, boolean paramBoolean)
	  {
		  Map<String , Object> reqMap=new HashMap<String , Object>();
		  reqMap.put("biz_key", paramString);//序列key
		  reqMap.put("is_append", true);//是否追加日期
	    return getSerialNumber(reqMap);
	  }

	  public String getSerialNumber(String paramString, boolean paramBoolean, int paramInt)
	  {
		  Map<String , Object> reqMap=new HashMap<String , Object>();
		  reqMap.put("biz_key", paramString);//序列key
		  reqMap.put("is_append", true);//是否追加日期
	    return getSerialNumber(reqMap);
	  }
	  
	  
	  public String getSerialNumberFromDB(String paramString)
	  {
		  Map<String , Object> reqMap=new HashMap<String , Object>();
		  reqMap.put("biz_key", paramString);//序列key
	    return getSerialNumberFromDB(reqMap);
	  }

	  public String getSerialNumberFromDB(String paramString, boolean paramBoolean)
	  {
		  Map<String , Object> reqMap=new HashMap<String , Object>();
		  reqMap.put("biz_key", paramString);//序列key
		  reqMap.put("is_append", paramBoolean);//是否追加日期
	    return getSerialNumberFromDB(reqMap);
	  }

	  public String getSerialNumberFromDB(String paramString, boolean paramBoolean, int paramInt)
	  {
		  Map<String , Object> reqMap=new HashMap<String , Object>();
		  reqMap.put("biz_key", paramString);//序列key
		  reqMap.put("is_append", paramBoolean);//是否追加日期
		  reqMap.put("serial_num", paramInt);//序列长度
	    return getSerialNumberFromDB(reqMap);
	  }
	  
	  public String getUUID()  {
		    Map<String , Object> reqMap=new HashMap<String , Object>();
			Map<String, Object> result = serialClient.getUUID(reqMap);
			return (String)result.get("serial_id");
		}
}