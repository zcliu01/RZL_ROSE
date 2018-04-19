package com.zrt.sec.web.login;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.mybatis.domain.SysSecUser;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.commons.AppException;
import com.zrt.commons.AppLoginException;
import com.zrt.commons.PageInit;
import com.zrt.commons.ResultMap;
import com.zrt.sec.service.login.LoginService;
import com.zrt.sec.service.user.UserService;

@RestController
@RequestMapping("/v1.0/sec")
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	@Resource(name = "loginServiceImpl")
	private LoginService loginService;

	/**
	 * 登录管理-登录
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> login(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的loginController中login方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 获取用户列表
			Map<String, Object> dataMap = loginService.login(appMap);
			resultMap.data(dataMap);
			resultMap.success();
			return resultMap.map();
		} catch (AppLoginException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}
	}

	@RequestMapping(value = "/testLogin", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> testLogin(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的loginController中testLogin方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 获取用户列表
			Map<String, Object> dataMap = loginService.testLogin(appMap);
			resultMap.data(dataMap);
			resultMap.success();
			return resultMap.map();
		} catch (AppLoginException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}
	}

	@RequestMapping(value = "/noVpnLogin", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> noVpnLogin(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的loginController中noVpnLogin方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 获取用户列表
			Map<String, Object> dataMap = loginService.noVpnLogin(appMap);
			resultMap.data(dataMap);
			resultMap.success();
			return resultMap.map();
		} catch (AppLoginException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}
	}

	/**
	 * 登录管理-登录filter校验，判断用户是否登录过，验证token
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> loginCheck(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的loginController中loginCheck方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 获取用户列表
			Map<String, Object> dataMap = loginService.loginCheck(appMap);
			resultMap.data(dataMap);
			resultMap.success();
			return resultMap.map();
		} catch (AppLoginException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}
	}

}
