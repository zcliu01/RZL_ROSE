package com.zrt.gateway.api.client.serial;

public interface SerialServiceUrlConstant {
	String HYSTRIX_TIMEOUT ="3000";
	
	String SERIAL_INSTANCE = "serial";

	String SERIAL_GETSERIALNUMBERFROMDB = "/v1.0/serial/getSerialNumberFromDB";
	String SERIAL_GETSERIALNUMBER = "/v1.0/serial/getSerialNumber";
	
}
