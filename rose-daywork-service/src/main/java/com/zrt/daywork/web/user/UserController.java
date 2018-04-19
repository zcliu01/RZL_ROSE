package com.zrt.daywork.web.user;

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
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.daywork.service.user.UserService;
import com.zrt.commons.AppException;
import com.zrt.commons.PageInit;
import com.zrt.commons.ResultMap;

@RestController
@RequestMapping("/v1.0/datasyn")
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
		
				resultMap.success();
			return resultMap.map();
		}catch(Exception e){
			log.error("json error", e);
			return resultMap.failure().errmsg("员工信息查询失败!").map();
		}
	}

    
}
