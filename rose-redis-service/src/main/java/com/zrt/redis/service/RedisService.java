package com.zrt.redis.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class RedisService implements IRedisService{

	@Autowired
    private RedisTemplate<String, ?> redisTemplate;  
     

	@Override
	public boolean hasKey(String doMain,String key) {
		// TODO Auto-generated method stub
		return redisTemplate.hasKey(key).booleanValue();
	}

	@Override
	public void hashSetMap(String doMain,String key, Map<String, Object> paramMap) {
		ObjectMapper mapper = new ObjectMapper();
		String temMap =null;
		try {
			 temMap = (String)mapper.writeValueAsString(paramMap);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
//		BoundHashOperations localBoundHashOperations = redisTemplate.boundHashOps(doMain+ ":" +key);
//	    localBoundHashOperations.putAll(paramMap);
		ValueOperations<String,Object> stringOperations = (ValueOperations<String,Object>) redisTemplate.opsForValue(); 
		stringOperations.set(doMain+ ":" +key, temMap);
	}

	@Override
	public void hashPut(String doMain,String key,String key1, Object paramObject) {
		// TODO Auto-generated method stub
		if (hasKey(doMain,key)) {
		      BoundHashOperations localBoundHashOperations = redisTemplate.boundHashOps(doMain+ ":" +key);
		      if(paramObject instanceof Map){
		    	  localBoundHashOperations.putAll((Map)paramObject);
		      }else{
		    	  localBoundHashOperations.put(key1, paramObject);
		      }
		      
		    }
	}

	@Override
	public Map<String, Object> hashGetMap(String doMain,String key) {
		// TODO Auto-generated method stub
//		BoundHashOperations localBoundHashOperations = redisTemplate.boundHashOps(doMain+ ":" +key);
		
		
		try {
			
		    ValueOperations<String,Object> stringOperations = (ValueOperations<String, Object>) redisTemplate.opsForValue(); 
		    Object resStr=stringOperations.get(doMain+ ":" +key);
		if(resStr instanceof String){
			ObjectMapper mapper = new ObjectMapper();
			if(resStr!=null && !"".equals(resStr)){
				Map<String, Object> resMap=mapper.readValue((String)resStr, HashMap.class);
				return resMap;
			}
		}else{
			BoundHashOperations localBoundHashOperations = redisTemplate.boundHashOps(doMain+ ":" +key);
		    return localBoundHashOperations.entries();
		}
		
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void hashSetMap(String doMain,String key, Map<String, Object> paramMap, long paramLong, TimeUnit paramTimeUnit) {
		// TODO Auto-generated method stub
//		BoundHashOperations localBoundHashOperations = redisTemplate.boundHashOps(doMain+ ":" +key);
//	    localBoundHashOperations.putAll(paramMap);
//	    localBoundHashOperations.expire(paramLong, paramTimeUnit);
	    ObjectMapper mapper = new ObjectMapper();
		String temMap =null;
		try {
			 temMap = (String)mapper.writeValueAsString(paramMap);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ValueOperations<String,String> stringOperations = (ValueOperations<String, String>) redisTemplate.opsForValue(); 
		stringOperations.set(doMain+ ":" +key, temMap, paramLong, paramTimeUnit);
	}

	@Override
	public void hashSetExpire(String doMain,String key, long paramLong, TimeUnit paramTimeUnit) {
		// TODO Auto-generated method stub
		BoundHashOperations localBoundHashOperations = redisTemplate.boundHashOps(doMain+ ":" +key);
	    localBoundHashOperations.expire(paramLong, paramTimeUnit);
	}

	@Override
	public void delete(String doMain,String key) {
		// TODO Auto-generated method stub
		redisTemplate.delete(doMain+ ":" +key);
	}

	@Override
	public void objSet(String doMain, String key, Object obj) {
		// TODO Auto-generated method stub
		BoundValueOperations localBoundValueOperations =redisTemplate.boundValueOps(doMain+ ":" +key);
		localBoundValueOperations.set(obj);
		
	}

	@Override
	public Object objGet(String doMain, String key) {
		// TODO Auto-generated method stub
		BoundValueOperations localBoundValueOperations =redisTemplate.boundValueOps(doMain+ ":" +key);
		return localBoundValueOperations.get();
	}  
    
	@Override
	public void objSet(String doMain,String key, Object obj, long paramLong, TimeUnit paramTimeUnit) {
		// TODO Auto-generated method stub
		BoundValueOperations localBoundValueOperations =redisTemplate.boundValueOps(doMain+ ":" +key);
		localBoundValueOperations.set(obj);
		localBoundValueOperations.expire(paramLong, paramTimeUnit);
	}
    
    
}
