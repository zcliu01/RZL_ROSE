package com.zrt.sec.web.handle;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.sec.service.handle.HandleService;
import com.zrt.sec.service.user.UserService;
import com.zrt.sec.web.user.UserController;

@RestController
@RequestMapping("/v1.0/sec")
public class HandController {

	private static final Logger log = LoggerFactory.getLogger(HandController.class);
	@Resource(name="handleServiceImpl")
	private HandleService handleService ;
	
	/**
	 * 添加新用户
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> addUser(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的HandleController中addUser方法");
		ResultMap resultMap=new ResultMap();
		try {
			handleService.addUser(appMap);
			resultMap.success().sucmsg("添加成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}
    }	
		
		
	/**
	 * 添加部门
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value="/addOrg", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> addOrg(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的HandleController中addOrg方法");
		ResultMap resultMap=new ResultMap();
		try {
			handleService.addOrg(appMap);
			resultMap.success().sucmsg("添加成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}
	}		
		
		
		
	/**
	 * 添加职位
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value="/addPosition", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> addPosition(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的HandleController中addPosition方法");
		ResultMap resultMap=new ResultMap();
		try {
			handleService.addUser(appMap);
			resultMap.success().sucmsg("添加成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}
	}
		
		
		
	/**
	 * 查看职务
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value="/searchPosition", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> searchPosition(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的HandleController中searchPosition方法");
		ResultMap resultMap=new ResultMap();
		try {
			List<Map<String, Object>> searchPosition = handleService.searchPosition(appMap);
			resultMap.data(searchPosition);
			resultMap.success().sucmsg("职务查询成功") ;
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}
	}
	
	
	/**
	 * 模糊查询部门
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value="/commonSearchOrg", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> commonSearchOrg(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的HandleController中commonSearchOrg方法");
		ResultMap resultMap=new ResultMap();
		try {
			List<Map<String, Object>> searchPosition = handleService.commonSearchOrg(appMap);
			resultMap.data(searchPosition);
			resultMap.success().sucmsg("部门模糊查询成功") ;
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}
	}
	
}
