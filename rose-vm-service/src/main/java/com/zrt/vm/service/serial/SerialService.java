package com.zrt.vm.service.serial;

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
	
	 public String getUUID()  {
		    Map<String , Object> reqMap=new HashMap<String , Object>();
			Map<String, Object> result = serialClient.getUUID(reqMap);
			return (String)result.get("serial_id");
		}
}