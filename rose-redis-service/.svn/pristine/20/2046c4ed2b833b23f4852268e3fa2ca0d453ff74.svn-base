package com.zrt.redis.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author wwfu
 *redis 服务类接口
 */
public interface IRedisService { 
    
    /**
     * 判断redis是否存在该domain+key值
     * @param doMain
     * @param key
     * @return
     */
    public  boolean hasKey(String doMain,String key);

    /**
     * redis server 存储hashMap数据
     * @param doMain
     * @param key
     * @param paramMap
     */
    public  void hashSetMap(String doMain,String key, Map<String, Object> paramMap);
    
    /**
     * redis server 存储简单的K-V的值
     * @param doMain
     * @param key
     * @param obj
     */
    public  void objSet(String doMain,String key, Object obj);

    /**
     * 获取redis server HashMap的值
     * @param doMain
     * @param key
     * @return
     */
    public  Map<String, Object> hashGetMap(String doMain,String key);
    
    /**
     * 根据domain+key值，给HashMap中追加值
     * @param doMain
     * @param key
     * @param key1
     * @param paramObject
     */
    public  void hashPut(String doMain,String key,String key1, Object paramObject);
    
    /**
     * 获取redis server 简单的K-V的值
     * @param doMain
     * @param key
     * @return
     */
    public  Object objGet(String doMain,String key);
    
    /**
     * redis server 存储hashMap数据，包含存储时间
     * @param doMain
     * @param key
     * @param paramMap
     */
    public  void hashSetMap(String doMain,String key, Map<String, Object> paramMap, long paramLong, TimeUnit paramTimeUnit);

    /**
     * redis server 存储简单的K-V的值，包含存储时间
     * @param doMain
     * @param key
     * @param obj
     */
    public  void objSet(String doMain,String key, Object obj, long paramLong, TimeUnit paramTimeUnit);

    /**
     * 给domain+key值设置存储时间
     * @param doMain
     * @param key
     * @param paramLong
     * @param paramTimeUnit
     */
    public  void hashSetExpire(String doMain,String key, long paramLong, TimeUnit paramTimeUnit);

    /**
     * 根据domain+key值，删除redis server中的存储数据
     * @param doMain
     * @param key
     */
    public  void delete(String doMain,String key);
	      

}
