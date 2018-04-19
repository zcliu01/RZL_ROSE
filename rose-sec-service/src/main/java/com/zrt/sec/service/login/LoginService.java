package com.zrt.sec.service.login;

import java.util.Map;

public interface LoginService {
	// 用户登录
	Map<String, Object> login(Map<String, Object> appMap) throws Exception;

	// 不通过VPN登录
	Map<String, Object> testLogin(Map<String, Object> appMap) throws Exception;

	Map<String, Object> noVpnLogin(Map<String, Object> appMap) throws Exception;

	// 用户登录校验
	Map<String, Object> loginCheck(Map<String, Object> appMap) throws Exception;

	// app用户登录
	Map<String, Object> appLogin(Map<String, Object> appMap) throws Exception;

	// app用户登录校验
	Map<String, Object> appLoginCheck(Map<String, Object> appMap) throws Exception;

	Map<String, Object> pcLogin(Map<String, Object> appMap) throws Exception;
}
