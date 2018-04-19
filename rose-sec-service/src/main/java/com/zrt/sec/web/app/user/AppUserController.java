package com.zrt.sec.web.app.user;


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
import com.zrt.sec.service.user.UserService;

@RestController
@RequestMapping("/v1.0/sec")
public class AppUserController {
	private static final Logger log = LoggerFactory.getLogger(AppUserController.class);
	@Resource(name="userServiceImpl")
	private UserService userService;
	/**
	 * App端我的详情 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/appMyDetails", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> appMyDetails(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的AppUserController中appMyDetails方法");
		ResultMap resultMap=new ResultMap();
		try {
			//获取用户信息
			Map<String,Object> dataMap=userService.userSearch(appMap);
			resultMap.data(dataMap);
			resultMap.success();
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}
	}

    /**
	 * App端修改我的详情 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/appUpdateEmpDetails", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> appUpdateEmpDetails(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的AppUserController中appUpdateEmpDetails方法");
		ResultMap resultMap=new ResultMap();
		try {
			String type=(String)appMap.get("type");
			userService.appUpdateEmpDetails(appMap);
			if(type=="0"||"0".equals(type)){
				resultMap.success().sucmsg("留言更新成功!");	
			}else{
				resultMap.success().sucmsg("提交成功,等待人事审核!");	
			}
			
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}
	}

    /**
   	 * App端发票抬头
   	 * @param jsonMap
   	 * @return
   	 * @throws AppException
   	 */
       @RequestMapping(value="/appSelectInvoiceTitle", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> appSelectInvoiceTitle(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的AppUserController中appSelectInvoiceTitle方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   		
   			List<Map<String,Object>> list = userService.appSelectInvoiceTitle(appMap);
			resultMap.data(list);
			resultMap.success();
   			return resultMap.map();
   		} catch (AppException e) {
   			log.error("json error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch (Exception e) {
   			log.error("json error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}
   	}
    
       /**
      	 * App端电子名片
      	 * @param jsonMap
      	 * @return
      	 * @throws AppException
      	 */
        /*  @RequestMapping(value="/appSelectECard", method = RequestMethod.POST, headers = "Accept=application/json")
      	public Map<String, Object> appSelectECard(@RequestBody Map<String, Object> appMap) throws Exception{
      		log.info("Server端的AppUserController中appSelectECard方法");
      		ResultMap resultMap=new ResultMap();
      		try {
      		
      	    Map<String,Object> eCardMap= userService.appSelectECard(appMap);
   		    resultMap.data(eCardMap);
   			resultMap.success();
      			return resultMap.map();
      		} catch (AppException e) {
      			log.error("json error", e);
      			return resultMap.failure().errmsg(e.getMessage()).map();
      		}catch (Exception e) {
      			log.error("json error", e);
      			return resultMap.failure().errmsg(e.getMessage()).map();
      		}
      	}*/
  
}
