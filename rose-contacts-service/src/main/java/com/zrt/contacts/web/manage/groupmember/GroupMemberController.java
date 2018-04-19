package com.zrt.contacts.web.manage.groupmember;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.contacts.service.friend.FriendService;
import com.zrt.contacts.service.groupmember.GroupMemberService;

/**
 * Created by msKui on 2017/3/3.
 */
@RestController
@RequestMapping("/v1.0/groupMember")
public class GroupMemberController {
	private static final Logger log = LoggerFactory.getLogger(GroupMemberController.class);

	@Autowired
	private GroupMemberService groupMemberService;

	@Autowired
	FriendService friendService;

	/**
	 * 添加群组成员
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/groupMemberSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> groupMemberSave(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的GroupMemberController中friendGroupSave方法");
		ResultMap resultMap = new ResultMap();

		try {

			groupMemberService.groupMemberSave(map);
			resultMap.success().sucmsg("新增成功!");
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
	 * 删除群组成员(即移除群组)--第2次迭代
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/groupMemberDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> groupMemberDelete(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的GroupMemberController中friendGroupSave方法");
		ResultMap resultMap = new ResultMap();

		try {
			// 删除群组成员
			groupMemberService.groupMemberDelete(map);
			resultMap.success().sucmsg("移除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("移除群组成员失败!").map();
		}
	}

	/**
	 * PC端 群组成员列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/groupMemList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> groupMemList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的GroupMemberController中groupMemList方法");
		if (map.get("friend_group_id") == null || map.get("friend_group_id").equals(""))
			throw new AppException("传入参数错误!");

		ResultMap resultMap = new ResultMap();

		try {

			Map<String, Object> resMap = groupMemberService.friendGroupEmpList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("查询群组成员列表失败!").map();
		}
	}

	/**
	 * 群组成员导出--3
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/exportGroupMemToExcel", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> exportGroupMemToExcel(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的GroupMemberController中exportGroupMemToExcel方法");
		ResultMap resultMap = new ResultMap();

		try {
			map.put("flag", "导出");
			Map<String, Object> resMap = groupMemberService.friendGroupEmpList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("导出群组成员失败!").map();
		}
	}

}
