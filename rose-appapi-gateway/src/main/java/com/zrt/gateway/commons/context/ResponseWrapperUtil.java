package com.zrt.gateway.commons.context;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseWrapperUtil {
	
	public static void wrapper(int httpStatus,boolean accessResult,HttpServletResponse response,
			Map<String,Object> resultMap){
		response.setStatus(httpStatus);
		response.addHeader("accessResult", Boolean.toString(accessResult));
		response.setContentType("application/json; charset=utf-8");
    	ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(response.getOutputStream(), resultMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	public static void wrapper(int httpStatus,boolean accessResult,HttpServletResponse response,
			ResultMap resultMap,String errorMessage){
		response.setStatus(httpStatus);
		response.addHeader("accessResult", Boolean.toString(accessResult));
		response.setContentType("application/json; charset=utf-8");
    	ObjectMapper objectMapper = new ObjectMapper();
    	//resultMap.put("error", error);
    	//resultMap.put("errorCode", errorCode);
    	resultMap.map().put("errmsg", errorMessage);
		try {
			objectMapper.writeValue(response.getOutputStream(), resultMap.map());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return;
	}
	

}
