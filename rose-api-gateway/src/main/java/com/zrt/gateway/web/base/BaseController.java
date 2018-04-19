package com.zrt.gateway.web.base;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 返回页面公共
 * @author wwfu
 *
 */
public class BaseController {

	
	/**
	 * 返回body公共类
	 * @param resultMap
	 * @return
	 * @throws Exception
	 */
	public ResponseEntity<String> response(Map<String,Object> resultMap) throws Exception{
		String resStr=new ObjectMapper().writeValueAsString(resultMap);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_UTF8.toString());
		headers.setContentLength(resStr.getBytes().length);
		return new ResponseEntity<String>(resStr, headers, HttpStatus.OK);
	}
	/**
	 * 请求放emp_id
	 */
	public Map<String, Object> setEmpId(String emp_id,Map<String,Object> requestMap){
		requestMap.put("emp_id", emp_id);
		return requestMap;
	}
}
