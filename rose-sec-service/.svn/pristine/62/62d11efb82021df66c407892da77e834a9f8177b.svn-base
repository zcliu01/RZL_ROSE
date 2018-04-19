package com.zrt.sec.web.app.login;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.AppLoginException;
import com.zrt.commons.ResultMap;
import com.zrt.sec.service.login.LoginService;

@RestController
@RequestMapping("/v1.0/sec")
public class AppLoginController {
	private static final Logger log = LoggerFactory.getLogger(AppLoginController.class);
	@Resource(name="loginServiceImpl")
	private LoginService loginService;
	/**
	 * 登录管理-登录
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/appLogin", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> appLogin(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的loginController中appLogin方法");
		ResultMap resultMap=new ResultMap();
		try {
			    //获取用户列表
			Map<String,Object> dataMap=loginService.appLogin(appMap);
			resultMap.data(dataMap);
			resultMap.success();
			return resultMap.map();
		} catch (AppLoginException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}
	}

	/**
	 * 登录管理-登录filter校验，判断用户是否登录过，验证token
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/appLoginCheck", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> appLoginCheck(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的loginController中appLoginCheck方法");
		ResultMap resultMap=new ResultMap();
		try {
			//获取用户列表
			Map<String,Object> dataMap=loginService.appLoginCheck(appMap);
			resultMap.data(dataMap);
			resultMap.success();
			return resultMap.map();
		} catch (AppLoginException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}
	}
	
    
	/**
	 * 登录管理-登录
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/pcLogin", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> pcLogin(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的loginController中pcLogin方法");
		ResultMap resultMap=new ResultMap();
		try {
			    //获取用户列表
			Map<String,Object> dataMap=loginService.pcLogin(appMap);
			resultMap.data(dataMap);
			resultMap.success();
			return resultMap.map();
		} catch (AppLoginException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}
	}
}
