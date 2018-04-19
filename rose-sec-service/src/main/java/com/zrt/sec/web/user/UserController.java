package com.zrt.sec.web.user;

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
import com.zrt.commons.PageInit;
import com.zrt.commons.ResultMap;
import com.zrt.sec.service.user.UserService;

@RestController
@RequestMapping("/v1.0/sec")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Resource(name="userServiceImpl")
	private UserService userService;
	/**
	 * 用户管理-用户列表查询
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/userList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> userList(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的UserController中userList方法");
		ResultMap resultMap=new ResultMap();
		try {
			if(appMap.get("begin_entry_time") != null && !"".equals(appMap.get("begin_entry_time"))){
				 appMap.put("begin_entry_time", appMap.get("begin_entry_time").toString().replaceAll("-", "")+"000000");
	            }
			 if(appMap.get("end_entry_time") != null && !"".equals(appMap.get("end_entry_time"))){
				 appMap.put("end_entry_time", appMap.get("end_entry_time").toString().replaceAll("-", "")+"235959");
	            }
			 if(appMap.get("begin_create_date_time") != null && !"".equals(appMap.get("begin_create_date_time"))){
				 appMap.put("begin_create_date_time", appMap.get("begin_create_date_time").toString().replaceAll("-", "")+"000000");
	            }
			 if(appMap.get("end_create_date_time") != null && !"".equals(appMap.get("end_create_date_time"))){
				 appMap.put("end_create_date_time", appMap.get("end_create_date_time").toString().replaceAll("-", "")+"235959");
	            }
				Map<String, Object> resMap=userService.empList(appMap);
				resultMap.data(resMap.get("data"));
				resultMap.success().map().put("count", resMap.get("count"));
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch(Exception e){
			log.error("json error", e);
			return resultMap.failure().errmsg("员工信息查询失败!").map();
		}
	}

	/**
	 * 用户管理-用户信息查询
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/userSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> userSearch(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的UserController中userSearch方法");
		ResultMap resultMap=new ResultMap();
		try {
			//获取用户信息
			Map<String, Object> data=userService.userSearch(appMap);
			resultMap.data(data);
			resultMap.success();
			return resultMap.map();
		}  catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("查询用户信息失败!").map();

		}
		/*Map<String, Object> map = userService.userSearch(appMap);
		return map;*/
	}
	
	/**
	 * 用户管理-用户新增
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/userSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> userSave(Map<String, Object> appMap) throws Exception{
		log.info("Server端的UserController中userSave方法");
		ResultMap resultMap=new ResultMap();
		try {
			//用户新增
			userService.userSave(appMap);
			resultMap.success().sucmsg("新增成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("用户新增失败!").map();

		}
	}
	
	/**
	 * 用户管理-用户更新
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/userUpdate", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> userUpdate(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的UserController中userUpdate方法");
		ResultMap resultMap=new ResultMap();
		try {
			//用户更新
			userService.userUpdate(appMap);
			resultMap.success().sucmsg("更新成功!");
			return resultMap.map();
		}  catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("更新用户信息失败!").map();

		}
	}
	
	/**
	 * 用户管理-用户角色列表查询
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/userRoleList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> userRoleList(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的UserController中userRoleList方法");
		ResultMap resultMap=new ResultMap();
		try {
			//用户角色列表查询
			List<Map<String, Object>> dataList=userService.userRoleList(appMap);
			resultMap.data(dataList);
			resultMap.success();
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("查询用户角色列表失败!").map();

		}
	}
	/**
	 * 用户管理-用户角色设置
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/userRoleSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> userRoleSave(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的UserController中userRoleSave方法");
		ResultMap resultMap=new ResultMap();
		try {
			//用户新增
			userService.userRoleSave(appMap);
			resultMap.success().sucmsg("角色保存成功!");
			return resultMap.map();
		}  catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("用户角色绑定失败!").map();

		}
	}
	
	/**
	 * 用户管理-用户密码重置
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/userPwdReSet", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> userPwdReSet(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的UserController中userPwdSet方法");
		ResultMap resultMap=new ResultMap();
		try {
			//用户新增
			userService.userPwdReSet(appMap);
			resultMap.success().sucmsg("密码重置成功!");;
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("用户密码重置失败!").map();

		}
	}
	
	/**
	 * 用户管理-用户密码修改
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/userPwdSet", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> userPwdSet(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的UserController中userPwdSet方法");
		ResultMap resultMap=new ResultMap();
		try {
			//用户新增
			userService.userPwdSet(appMap);
			resultMap.success().sucmsg("密码修改成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();

		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("用户密码修改失败!").map();

		}
	}
    
    /**
	 * 用户管理-用户列表查询
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/empList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> empList(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的UserController中empList方法");
		ResultMap resultMap=new ResultMap();
		try {
		 if(appMap.get("begin_entry_time") != null && !"".equals(appMap.get("begin_entry_time"))){
			 appMap.put("begin_entry_time", appMap.get("begin_entry_time").toString().replaceAll("-", "")+"000000");
            }
		 if(appMap.get("end_entry_time") != null && !"".equals(appMap.get("end_entry_time"))){
			 appMap.put("end_entry_time", appMap.get("end_entry_time").toString().replaceAll("-", "")+"235959");
            }
		 if(appMap.get("begin_create_date_time") != null && !"".equals(appMap.get("begin_create_date_time"))){
			 appMap.put("begin_create_date_time", appMap.get("begin_create_date_time").toString().replaceAll("-", "")+"000000");
            }
		 if(appMap.get("end_create_date_time") != null && !"".equals(appMap.get("end_create_date_time"))){
			 appMap.put("end_create_date_time", appMap.get("end_create_date_time").toString().replaceAll("-", "")+"235959");
            }
			Map<String, Object> resMap=userService.empList(appMap);
			resultMap.data(resMap.get("data"));
			resultMap.success().map().put("count", resMap.get("count"));
			return resultMap.map();
		}  catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("查询员工列表信息失败!").map();
		}
	}
    /**
	 * 用户管理-用户角色批量设置
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/userRoleBatchSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> userRoleBatchSave(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的UserController中userRoleBatchSave方法");
		ResultMap resultMap=new ResultMap();
		try {
			//用户新增
			userService.userRoleSave(appMap);
			resultMap.success().sucmsg("角色批量设置成功!");
			return resultMap.map();
		}  catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("用户角色批量绑定失败!").map();

		}
	}
	
	/**
	 * 用户管理-用户密码批量重置
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/userPwdBatchReSet", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> userPwdBatchReSet(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的UserController中userPwdBatchReSet方法");
		ResultMap resultMap=new ResultMap();
		try {
			List<Map<String, Object>> list=(List<Map<String, Object>>)appMap.get("param");
			for(Map<String, Object> map:list){
				//用户角色新增
				userService.userPwdReSet(map);
			}
			
			resultMap.success().sucmsg("密码批量重置成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("用户密码批量重置失败!").map();

		}
	}
    /**
	 * 用户管理-用户状态
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/userStatusUpdate", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> userStatusUpdate(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的UserController中userPwdSet方法");
		ResultMap resultMap=new ResultMap();
		try {
			//用户状态
			userService.userStatusUpdate(appMap);
			resultMap.success().sucmsg("操作成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();

		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("员工状态修改失败!").map();

		}
	}
    
    /**
     * 修改用户是否同步数据状态
     * @param jsonMap
     * @return
     * @throws AppException
     */
    @RequestMapping(value="/userSync", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> userSync(@RequestBody Map<String, Object> appMap) throws Exception{
    	log.info("Server端的UserController中userSync方法");
    	ResultMap resultMap=new ResultMap();
    	try {
    		//用户状态
    		userService.userSync(appMap);
    		resultMap.success().sucmsg("操作成功!");
    		return resultMap.map();
    	} catch (AppException e) {
    		log.error("json error", e);
    		return resultMap.failure().errmsg(e.getMessage()).map();
    		
    	} catch (Exception e) {
    		log.error("json error", e);
    		return resultMap.failure().errmsg("员工状态修改失败!").map();
    		
    	}
    }
    /**
     * 设置员工登录类型
     * @param jsonMap
     * @return
     * @throws AppException
     */
    @RequestMapping(value="/loginTypeSet", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> loginTypeSet(@RequestBody Map<String, Object> appMap) throws Exception{
    	log.info("Server端的UserController中loginTypeSet方法");
    	ResultMap resultMap=new ResultMap();
    	try {
    		//用户状态
    		userService.loginTypeSet(appMap);
    		resultMap.success().sucmsg("设置成功!");
    		return resultMap.map();
    	} catch (AppException e) {
    		log.error("json error", e);
    		return resultMap.failure().errmsg(e.getMessage()).map();
    		
    	} catch (Exception e) {
    		log.error("json error", e);
    		return resultMap.failure().errmsg("设置失败!").map();
    		
    	}
    }
    
}
