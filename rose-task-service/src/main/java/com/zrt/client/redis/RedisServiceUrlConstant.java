package com.zrt.client.redis;

public interface RedisServiceUrlConstant {
	String HYSTRIX_TIMEOUT ="3000";
	
	String SERIAL_INSTANCE = "redis";

	String REDIS_SETINFO = "/v1.0/redis/setInfo";
	String REDIS_GETINFO = "/v1.0/redis/getInfo";
	
}
