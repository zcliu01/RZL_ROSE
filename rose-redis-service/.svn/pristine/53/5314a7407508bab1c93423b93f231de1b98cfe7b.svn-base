package com.zrt.redis.web;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrt.commons.ResultMap;
import com.zrt.redis.service.IRedisService;

@Service("redisController")
@SuppressWarnings("rawtypes")
public class RedisController {
	private static final Logger log = LoggerFactory.getLogger(RedisController.class);
	@Autowired
	private IRedisService redisService;

	/***
	 * 用户登录保存登录个人信息，进行缓存
	 * @param appMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> setInfo(Map<String, Object> appMap) throws Exception{
		log.info("Server端的RedisController中setInfo方法");
		ResultMap resultMap=new ResultMap();
		try {
			//公共前缀
			String doMain=(String)appMap.get("doMain");
			//key
			String key=(String)appMap.get("key");
			//公共前缀
			Object timeLong=appMap.get("timeLong");
			//key
			Object timeUnit=appMap.get("timeUnit");
			//data
			HashMap<String, Object> paramMap=(HashMap<String, Object>)appMap.get("data");
            if(timeLong!=null){
            	//timeLong 不为空说明会设置key的缓存时间
            	if(timeUnit!=null){
            		//timeUnit 不为空说明会设置时间单位
//            		redisService.hashSetMap(doMain,key, paramMap,Long.valueOf(String.valueOf((Integer)timeLong)),(TimeUnit)timeUnit);
//            	}else{
            		redisService.hashSetMap(doMain,key, paramMap,Long.valueOf(String.valueOf((Integer)timeLong)),TimeUnit.MINUTES);//默认分钟
            	}
            	
            }else{
            	//设置redis存储信息
    			redisService.hashSetMap(doMain,key, paramMap);
            }
			
			
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new Exception("信息缓存失败!");
		}
	}
	
	/***
	 * 根据传递的doMain+key获取原有的保存信息，并新增新的数据
	 * @param appMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> putInfo(Map<String, Object> appMap) throws Exception{
		log.info("Server端的RedisController中putInfo方法");
		ResultMap resultMap=new ResultMap();
		try {
			//公共前缀
			String doMain=(String)appMap.get("doMain");
			//key
			String key=(String)appMap.get("key");
			//key1
			String key1=(String)appMap.get("key1");
			//data
			HashMap<String, Object> paramMap=(HashMap<String, Object>)appMap.get("data");
			// put redis存储信息
			redisService.hashPut(doMain,key,key1,paramMap);
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new Exception("获取缓存信息失败!");
		}
	}
	
	/***
	 * 根据传递的doMain+key获取存储的信息
	 * @param appMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getInfo(Map<String, Object> appMap) throws Exception{
		log.info("Server端的RedisController中getInfo方法");
		ResultMap resultMap=new ResultMap();
		try {
			//公共前缀
			String doMain=(String)appMap.get("doMain");
			//key
			String key=(String)appMap.get("key");
			//获取redis存储信息
			Map<String, Object> dataMap=redisService.hashGetMap(doMain,key);
			resultMap.data(dataMap);
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new Exception("获取缓存信息失败!");
		}
	}
	
	public Map<String, Object> delInfo(Map<String, Object> appMap) throws Exception{
		log.info("Server端的RedisController中delInfo方法");
		ResultMap resultMap=new ResultMap();
		try {
			//公共前缀
			String doMain=(String)appMap.get("doMain");
			//key
			String key=(String)appMap.get("key");
			//获取redis存储信息
			redisService.delete(doMain,key);
			resultMap.success().sucmsg("删除成功");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new Exception("删除缓存信息失败!");
		}
	}
}
