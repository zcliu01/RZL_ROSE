package com.zrt.client.serial;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(SerialServiceUrlConstant.SERIAL_INSTANCE)
public interface ISerialClient extends SerialServiceUrlConstant {

	/**
	 * 数据库序列查询
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = SERIAL_GETSERIALNUMBERFROMDB, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> getSerialNumberFromDB(Map requestJson);

	/**
	 * 算法序列查询
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = SERIAL_GETSERIALNUMBER, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> getSerialNumber(Map requestJson);

}
