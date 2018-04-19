package com.zrt.client;

import java.util.Map;

import com.zrt.commons.ResultMap;


/**
 * 服务调用返回exception,捕获异常返回
 * @author wwfu
 *
 */
public class ExceptionDeal {

	/**
	 * 
	 * @param serviceName
	 * @param requestJson
	 * @param e
	 * @return
	 */
	public static Map<String, Object> fallback(String serviceName,Map<String, Object> requestJson,Throwable e){
		String errMsg="系统异常!";
		String exceptionName=e.getClass().getName();
		if("com.zrt.commons.AppException".equals(exceptionName)){
			errMsg=e.getMessage();
		}else if("com.zrt.commons.AppLoginException".equals(exceptionName)){
			errMsg=e.getMessage();
		}else if("java.lang.Exception".equals(exceptionName)){
			errMsg=e.getMessage();
		}else{
			errMsg=("请求失败("+serviceName+")!");
		}
		
	    return new ResultMap().failure().errmsg(errMsg).map();
	}

}
