package com.zrt.contacts.web.app.friend;

import java.util.Date;
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
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.utils.UUIDUtils;
import com.zrt.contacts.service.friend.FriendService;
import com.zrt.contacts.service.serial.SerialService;
import com.zrt.contacts.service.sys.SysSecEmpService;
import com.zrt.mybatis.domain.EmpContactsFriend;

/**
 * 
 * @description 常用联系人服务
 * @author ajzhou
 *
 */
@RestController
@RequestMapping("/v1.0/friendApp")
public class FriendAppController {
	private static final Logger log = LoggerFactory.getLogger(FriendAppController.class);

	@Autowired
	FriendService friendService;

	@Autowired
	private SerialService serialService;
	@Autowired
	private SysSecEmpService sysSecEmpService;

	/**
	 * 批量添加常用联系人(第2次迭代)
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/friendSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> friendSave(@RequestBody Map<String, Object> map) throws AppException {
		log.info("App端的FriendAppController中friendSave方法");

		ResultMap resultMap = new ResultMap();

		try {
			Integer successCount = friendService.friendSave(map);
			// 添加成功的个数
			map.put("successCount", successCount);
			resultMap.success().data(map);
			resultMap.success().sucmsg("添加" + successCount + "个常用联系人成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("常用联系人新增失败!").map();
		}
	}

	/**
	 * App端根据主键查询常用联系人列表。
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/friendList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> friendList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("App端的FriendAppController中friendList方法");
		ResultMap resultMap = new ResultMap();
		try {
			List<Map<String, Object>> list = friendService.friendList(map);
			resultMap.success().data(list);
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("常用联系人列表查询失败!").map();
		}
	}

	/**
	 * App端删除常用联系人。
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/friendDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> friendDelete(@RequestBody Map<String, Object> map) throws AppException {
		log.info("APP端的FriendAppController中friendDelete方法");
		ResultMap resultMap = new ResultMap();
		try {

			friendService.friendDelete(map);
			resultMap.success().sucmsg("删除成功");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("删除常用联系人失败!").map();
		}
	}

	/**
	 * App端 添加常用联系人页初始化
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/friendSavePage", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> friendSavePage(@RequestBody Map<String, Object> map) throws Exception {
		log.info("APP端的FriendAppController中friendSavePage方法");
		ResultMap resultMap = new ResultMap();

		try {

			List<Map<String, Object>> list = friendService.friendSavePage(map);
			resultMap.success().data(list);
			return resultMap.map();

		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("添加常用联系人页面初始化失败!").map();
		}
	}

	/**
	 * App端修改个人信息(固定电话+移动电话+)
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/appUpdateEmpDetails", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> appUpdateEmpDetails(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FriendAppController中appUpdateEmpDetails方法");
		ResultMap resultMap = new ResultMap();
		try {
			String type = (String) map.get("type");
			sysSecEmpService.updateEmpDetails(map);
			if (type == "0" || "0".equals(type)) {
				resultMap.success().sucmsg("留言更新成功!");
			} else {
				resultMap.success().sucmsg("提交成功,等待人事审核!");
			}
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("修改个人详情失败!").map();
		}

	}

}
