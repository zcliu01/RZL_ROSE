package com.zrt.sec.service.common;

import java.util.Map;

/**
 * 登陆信息公共类
 * @author wwfu
 *
 */
public class CommonService {

	/**
	 * 获取登陆员工的user_id
	 */
	public static String getUserId(Map<String, Object> appMap){
		Map<String, Object> loginInfo=(Map<String, Object>)appMap.get("loginInfo");
		//获取登陆信息
		Map<String, Object> userInfo=(Map<String, Object>)loginInfo.get("userInfo");
		return (String)userInfo.get("user_id");
	}
	
	/**
	 * 获取登陆员工的emp_id
	 */
	public static String getEmpId(Map<String, Object> appMap){
		Map<String, Object> loginInfo=(Map<String, Object>)appMap.get("loginInfo");
		//获取登陆信息
		Map<String, Object> empInfo=(Map<String, Object>)loginInfo.get("empInfo");
		return (String)empInfo.get("emp_id");
	}
	
	/**
	 * 获取登陆员工上级领导的id
	 */
	public static String getUpEmpId(Map<String, Object> appMap){
		Map<String, Object> loginInfo=(Map<String, Object>)appMap.get("loginInfo");
		//获取登陆员工的上级员工id
		Map<String, Object> empInfo=(Map<String, Object>)loginInfo.get("empInfo");
		return (String)empInfo.get("up_emp_id");
	}
}
