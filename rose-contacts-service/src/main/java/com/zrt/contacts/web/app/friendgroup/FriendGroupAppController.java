package com.zrt.contacts.web.app.friendgroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.contacts.service.friendgroup.FriendGroupService;
import com.zrt.contacts.service.groupmember.GroupMemberService;
import com.zrt.contacts.service.serial.SerialService;
import com.zrt.mybatis.domain.EmpContactsFriendGroup;

/**
 * 我的群组 控制器
 * 
 * @description
 * @author ajzhou
 *
 */
@RestController
@RequestMapping("/v1.0/friendGroupApp")
public class FriendGroupAppController {
	private static final Logger log = LoggerFactory.getLogger(FriendGroupAppController.class);

	@Autowired
	FriendGroupService friendGroupService;
	@Autowired
	GroupMemberService groupMemberService;

	@Autowired
	private SerialService serialService;

	/**
	 * App端 创建群组
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/friendGroupSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> friendGroupSave(@RequestBody Map<String, Object> map) throws AppException {
		log.info("App端的FriendGroupAppController中friendGroupSave方法");

		ResultMap resultMap = new ResultMap();

		try {
			
			friendGroupService.friendGroupSave(map);
			resultMap.success().sucmsg("新增成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("创建群组失败!").map();
		}
	}

	/**
	 * 我的群组：我创建的、我加入的、公司群组
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/friendGroupList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> friendGroupList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("App端的FriendGroupAppController中friendGroupList方法");
		ResultMap resultMap = new ResultMap();

		try {

			List<Map<String, Object>> list = friendGroupService.friendGroupList(map);
			
			resultMap.success().data(list);
			return resultMap.map();
			
			/*String empId = map.get("emp_id").toString();
			String type = map.get("type").toString();
			
			List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
			if(map.get("status")==null){
				map.put("status","1");
			}
			
			if (StringUtils.isBlank(empId) || StringUtils.isBlank(type)) {
				throw new AppException("传入的参数错误");
			}
			if ("0".equals(type)) {// type：0 显示我创建的群组列表 
            
			  list = friendGroupService.selectCreateGroupByCreateEmpId(map);
			
			}
			if ("1".equals(type)) {// type：1 显示我加入的群组列表
			   list = friendGroupService.selectJoinGroupByEmpId(map);
			}
			if ("2".equals(type)) {// type：2 显示公司群组
                list = friendGroupService.selectCompanyGroupList(map);
			}
			resultMap.success().data(list);
			return resultMap.map();*/
			
		}  catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("App端群组列表查询失败!").map();
		}
	}

	/**
	 * App端根据 群组主键 查询群组详情
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/selectGroupDetails", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> selectGroupDetails(@RequestBody Map<String, Object> map) throws Exception {
		log.info("App端的FriendGroupAppController中selectGroupDetails方法");
		ResultMap resultMap = new ResultMap();
		try {
			List<Map<String, Object>> list = friendGroupService.selectGroupDetails(map);
			resultMap.success().data(list);
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("群组成员列表查询失败!").map();
		}
	}

	/**
	 * App端 群组成员列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/selectGroupMemList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> selectGroupMemList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("App端的FriendGroupAppController中selectGroupMemList方法");
		ResultMap resultMap = new ResultMap();
		try {
			List<Map<String, Object>> list = friendGroupService.selectGroupMemList(map);
			resultMap.success().data(list);
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("群组成员列表查询失败!").map();
		}

	}

	/**
	 * App端 添加群组成员初始化页面
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/groupMemberSavePage", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> groupMemberSavePage(@RequestBody Map<String, Object> map) throws Exception {
		log.info("App端的FriendGroupAppController中groupMemberSavePage方法");
		ResultMap resultMap = new ResultMap();
		try {
			List<Map<String, Object>> list = groupMemberService.groupMemberSavePage(map);
			resultMap.success().data(list);
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("添加群组成员页面初始化失败!").map();
		}

	}
	
	/**
	 * App端 添加群组成员
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/groupMemberSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> groupMemberSave(@RequestBody Map<String, Object> map) throws Exception {
		log.info("App端的FriendGroupAppController中groupMemberSave方法");
		ResultMap resultMap = new ResultMap();
		try {
		    groupMemberService.groupMemberSave(map);
		    resultMap.success().sucmsg("添加成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("添加群组成员失败!").map();
		}

	}
	
	/**
	 * App端 删除群组成员
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/groupMemDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> groupMemDelete(@RequestBody Map<String, Object> map) throws Exception {
		log.info("App端的FriendGroupAppController中groupMemDelete方法");
		ResultMap resultMap = new ResultMap();
		try {
			groupMemberService.groupMemberDelete(map);
			resultMap.success().sucmsg("移除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("群组成员列表查询失败!").map();
		}

	}
	
	/**
	 * App端 修改群组信息
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/friendGroupUpdate", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> friendGroupUpdate(@RequestBody Map<String, Object> map) throws Exception {
		log.info("App端的FriendGroupAppController中friendGroupUpdate方法");
		ResultMap resultMap = new ResultMap();
		try {
			friendGroupService.friendGroupUpdate(map);
			resultMap.success().sucmsg("修改成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("群名称修改失败!").map();
		}

	}
	
	/**
	 * App端 解散或者退出群组
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/groupDismissOrQuit", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> groupDismissOrQuit(@RequestBody Map<String, Object> map) throws Exception {
		log.info("App端的FriendGroupAppController中groupDismissOrQuit方法");
		ResultMap resultMap = new ResultMap();
		try {
			friendGroupService.groupDismissOrQuit(map);
			resultMap.success().sucmsg("解散或者退出群组成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("解散或者退出群组失败!").map();
		}

	}

}
