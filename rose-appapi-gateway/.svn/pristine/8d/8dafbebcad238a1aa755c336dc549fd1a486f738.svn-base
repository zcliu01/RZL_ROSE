package com.zrt.gateway.commons.context;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class ResultMap {

	private Map<String, Object> result = new HashMap<>();
	
	public ResultMap failure(){
		result.put("result", false);
		return this;
	}
	
	public ResultMap success(){
		result.put("result", true);
		return this;
	}
	
	public ResultMap errmsg(String errmsg){
		result.put("errmsg", errmsg);
		return this;
	}
	
	public void clear(){
		result.clear();
	}
	
	public Map<String, Object> map(){
		return result;
	}
	
	
	public String json(){
		ObjectMapper mapper = new ObjectMapper(); 
		try {
			return mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
//			e.printStackTrace();
		}
		return null;
	}
	
/*	public static void main(String[] args) {
		ResultMap r = new ResultMap();
		Map<String, Object> s = r.failure().errmsg("Errmsg").map();
		System.out.println(s);
	}*/
}
