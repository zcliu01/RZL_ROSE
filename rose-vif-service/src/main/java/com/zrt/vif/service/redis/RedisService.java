package com.zrt.vif.service.redis;

import com.zrt.client.redis.IRedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * 提供redis client个性化请求类
 * @author wwfu
 *
 */
@Service
public class RedisService {

	private final transient Logger logger = LoggerFactory.getLogger(RedisService.class);
	@Resource(name="HystrixRedisClient")
	private IRedisClient redisClient;
	
	
	/**
	 * 存储信息到redis缓存中
	 * @param doMain
	 * @param key
	 * @param dataMap
	 */
	public void setInfo(String doMain,String key,Map<String, Object> dataMap){
		Map<String, Object> requestMap=new HashMap<String, Object>();
		requestMap.put("doMain", doMain);
		requestMap.put("key", key);
		requestMap.put("data", dataMap);
		//请求返回的都是resMap
		logger.info("----request redis param doMain+key---"+requestMap.toString());
		redisClient.setInfo(requestMap);
	}
	
	
	/**
	 * 存储信息到redis缓存中,带缓存时间
	 * @param doMain
	 * @param key
	 * @param dataMap
	 * @param timeLong
	 * @param timeUnit
	 */
	public void setInfo(String doMain,String key,Map<String, Object> dataMap,long timeLong,TimeUnit timeUnit){
		Map<String, Object> requestMap=new HashMap<String, Object>();
		requestMap.put("doMain", doMain);
		requestMap.put("key", key);
		requestMap.put("timeLong", timeLong);
		requestMap.put("timeUnit", timeUnit);
		requestMap.put("data", dataMap);
		//请求返回的都是resMap
		logger.info("----request redis param doMain+key---"+requestMap.toString());
		redisClient.setInfo(requestMap);
	}
	/**
	 * 获取redis server存储的信息
	 * @param doMain
	 * @param key
	 * @return
	 */
	public Map<String, Object> getInfo(String doMain,String key){
		Map<String, Object> requestMap=new HashMap<String, Object>();
		Map<String, Object> dataObj=null;
		requestMap.put("doMain", doMain);
		requestMap.put("key", key);
		//请求返回的都是resMap
		logger.info("----request redis param doMain+key---"+requestMap.toString());
		Map<String, Object> resultMap=redisClient.getInfo(requestMap);
		logger.info("----result redis server doMain+key---"+resultMap.toString());
		Boolean result=(Boolean)resultMap.get("result");
		if(result){//返回成功
			dataObj=(HashMap<String, Object>)resultMap.get("data");
		}
		return dataObj;
	}
}
