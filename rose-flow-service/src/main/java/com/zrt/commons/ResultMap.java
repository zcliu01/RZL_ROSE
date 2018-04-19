package com.zrt.commons;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * 
 * @author Astro Qi
 *
 */
public final class ResultMap {

	private Map<String, Object> result = new HashMap<>();

	private static final ObjectMapper objectMapper;

	static {
		objectMapper = new ObjectMapper();
		// 去掉默认的时间戳格式
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		// 设置为中国上海时区
		objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
		// 空值不序列化
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		// 反序列化时，属性不存在的兼容处理
		objectMapper.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// 序列化时，日期的统一格式
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 单引号处理
		objectMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
	}

	public ResultMap failure() {
		result.put("result", false);
		return this;
	}

	public ResultMap success() {
		result.put("result", true);
		return this;
	}

	public ResultMap errmsg(String message) {
		result.put("errmsg", message);
		return this;
	}

	public ResultMap errcode(int code) {
		result.put("errcode", code);
		return this;
	}

	public ResultMap sucmsg(String message) {
		result.put("sucmsg", message);
		return this;
	}

	public void clear() {
		result.clear();
	}

	public Map<String, Object> map() {
		return result;
	}

	public String json() {
		// ObjectMapper mapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			// e.printStackTrace();
		}
		return null;
	}

	public ResultMap data(Object data) {
		result.put("data", data);
		return this;
	}

	public static ObjectMapper objectMapper() {
		return objectMapper;
	}
}
