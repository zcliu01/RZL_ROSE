package com.zrt.client.redis;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient(RedisServiceUrlConstant.SERIAL_INSTANCE)
public interface IRedisClient extends RedisServiceUrlConstant {

	/**
	 * redis缓存数据接口
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = REDIS_SETINFO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> setInfo(Map requestJson);

	/**
	 * 获取redis缓存数据
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = REDIS_GETINFO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> getInfo(Map requestJson);

}
