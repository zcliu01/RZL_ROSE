package com.zrt.commons.web;

import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zrt.commons.ResultMap;


//@RestController
//@RequestMapping("/{version}")
public class BaseController {
	
	
	public static final String BIZ_URI = "/v1.0/";
	private Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	private ApplicationContext  aplicationContext ;
	
	
	@RequestMapping(value = "/{className}/{methodName}", method = RequestMethod.POST, headers = "Accept=application/json")
	public Object doAction(
			@PathVariable("version") String version,
			@PathVariable("className") String className, 
			@PathVariable("methodName") String methodName,
			@RequestBody String json, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		long beginTime=System.currentTimeMillis();
		logger.info("-----request time---"+beginTime);
		Object result = doAction1(request, response, className, methodName,json);
		logger.info("-----response time---"+(System.currentTimeMillis()-beginTime));
		return result;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object doAction1(HttpServletRequest request, HttpServletResponse response,
			String className, 
			String methodName,
			String json)
			 {
		Object result = null;
		try {
			String beanId = className + "Controller";
			logger.info("ClassName Is："+beanId+"    MethodName Is："+methodName);
			Object localService = aplicationContext.getBean(beanId);
			Class localServiceClass = localService.getClass();
			Class[] argsClass = new Class[1];  
			argsClass[0] = json.getClass();  
			Method method = localServiceClass.getMethod(methodName,Map.class);
			ObjectMapper mapper = new ObjectMapper();
			logger.info("req params:"+json);
			System.out.println("req jsonStr decode:"+URLDecoder.decode(json));
			Map jsonMap = mapper.readValue(URLDecoder.decode(json), HashMap.class);
			result = method.invoke(localService, jsonMap);
		}catch(Exception e){
			ResultMap resultMap=new ResultMap();
			resultMap.failure().errmsg(e.getCause().getMessage());
			result=resultMap.map();
		}finally {
		}

		
		return result;
	}
	
}
