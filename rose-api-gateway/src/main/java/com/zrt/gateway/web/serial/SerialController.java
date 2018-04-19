package com.zrt.gateway.web.serial;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.api.client.sec.ISecUserClient;
import com.zrt.gateway.api.client.serial.ISerialClient;
import com.zrt.gateway.web.base.BaseController;

@RestController
@RequestMapping(value="/v1.0/serial", produces = { "application/json;charset=UTF-8" })
public class SerialController extends BaseController{
	private static final Logger log = LoggerFactory.getLogger(SerialController.class);
	@Resource(name = "HystrixSerialClient")
	private ISerialClient serialClient;
	/**
	 * 获取序列
	 * @param jsonMap(biz_key,is_append,serial_num)
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/getSerialNumberFromDB",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> getSerialNumberFromDB(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的serialController中getSerialNumberFromDB方法");
		Map<String,Object>  resultMap = serialClient.getSerialNumberFromDB(appMap);
		return response(resultMap);
	}
	
	/**
	 * 获取序列
	 * @param jsonMap(biz_key,is_append)
	 * @returnb
	 * @throws Exception
	 */
	@RequestMapping(value = "/getSerialNumber",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> getSerialNumber(@RequestBody  Map<String, Object> appMap) throws Exception{
		log.info("Server端的serialController中getSerialNumber方法");
		Map<String,Object>  resultMap = serialClient.getSerialNumber(appMap);
		return response(resultMap);
	}

}
