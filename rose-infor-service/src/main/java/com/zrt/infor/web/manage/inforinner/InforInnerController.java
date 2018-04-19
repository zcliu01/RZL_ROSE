package com.zrt.infor.web.manage.inforinner;

import java.text.SimpleDateFormat;
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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.AppException;
import com.zrt.commons.PageInit;
import com.zrt.commons.ResultMap;
import com.zrt.infor.service.inforinner.InforInnerService;

/**
 * Created by msKui on 2017/3/21.
 */
@RestController
@RequestMapping("/v1.0/inforInner")
public class InforInnerController {
	private static final Logger log = LoggerFactory.getLogger(InforInnerController.class);

	@Autowired
	private InforInnerService inforInnerService;

	/**
	 * 全部讯息列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/inforList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的InforInnerController中inforList方法");

		ResultMap resultMap = new ResultMap();

		try {

			// 拼接参数
			// TODO 登录emp_ID
			map.put("sender_emp_id", map.get("emp_id"));// 发件人id
			map.put("receiver_emp_id", map.get("emp_id"));// 收件人id
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			String receiverIds = map.get("sender_id") == null ? null : map.get("sender_id").toString();
			String[] senderIdArr = null;
			if (StringUtils.isNotBlank(receiverIds))
				senderIdArr = receiverIds.split(";");
			map.put("senderIdArr", senderIdArr);

			// 请求到的状态讯息状态（“”：全部；0：未阅；1：已阅；2：未办；3：已办；4:已关注；5显示；6：隐藏）
			String status = (String) map.get("status");
			map.put("is_show", "1");// 默认显示
			if ("0".equals(status)) {// 查询未阅状态的讯息
				map.put("deal_status", "0");
			} else if ("1".equals(status)) {// 查询已阅状态的讯息
				map.put("deal_status", "1");
			} else if ("2".equals(status)) {// 查询未办状态的讯息
				map.put("deal_status", "2");
			} else if ("3".equals(status)) {// 查询已办状态的讯息
				map.put("deal_status", "3");
			} else if ("5".equals(status)) {// 查询显示状态的讯息
				map.put("is_show", "1");
			} else if ("6".equals(status)) {// 查询隐藏状态的讯息
				map.put("is_show", "0");
			}
			Map<String, Object> resMap = inforInnerService.inforList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("发件列表查询失败!").map();

		}
	}

	/**
	 * 内部讯息列表查询
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/inforAllList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforAllList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的InforInnerController中inforList方法");
		ResultMap resultMap = new ResultMap();
		PageInit.setPage(map);
		try {
			if (map.get("sorts") == null || map.get("sorts").equals("")) {
				PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
						Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);
			} else {
				PageHelper
						.startPage(Integer.parseInt(map.get("pageNo").toString()),
								Integer.parseInt(map.get("maxResult").toString()), map.get("sorts").toString())
						.setReasonable(false);
			}
			// 拼接参数
			// TODO 登录emp_ID
			map.put("sender_emp_id", map.get("emp_id"));// 发件人id
			map.put("receiver_emp_id", map.get("emp_id"));// 收件人id
			// 内部讯息类型
			map.put("category", "innerInfor");
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			String receiverIds = map.get("sender_id") == null ? null : map.get("sender_id").toString();
			String[] senderIdArr = null;
			if (StringUtils.isNotBlank(receiverIds))
				senderIdArr = receiverIds.split(";");
			map.put("senderIdArr", senderIdArr);

			// 请求到的状态讯息状态（“”：全部；0：未阅；1：已阅；2：未办；3：已办；4:已关注；5显示；6：隐藏）
			String status = (String) map.get("status");
			map.put("is_show", "1");
			if ("0".equals(status)) {// 查询未阅状态的讯息
				map.put("deal_status", "0");
			} else if ("1".equals(status)) {// 查询已阅状态的讯息
				map.put("deal_status", "1");
			} else if ("2".equals(status)) {// 查询未办状态的讯息
				map.put("deal_status", "2");
			} else if ("3".equals(status)) {// 查询已办状态的讯息
				map.put("deal_status", "3");
			} else if ("5".equals(status)) {// 查询显示状态的讯息
				map.put("is_show", "1");
			} else if ("6".equals(status)) {// 查询隐藏状态的讯息
				map.put("is_show", "0");
			}
			Map<String, Object> resMap = inforInnerService.inforList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("内部列表查询失败!").map();

		}
	}

	/**
	 * 讯息发件列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/inforSendList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforSendList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的InforCommonsController中inforSendList方法");

		ResultMap resultMap = new ResultMap();

		try {

			// 拼接参数
			// TODO 登录emp_ID
			map.put("sender_emp_id", map.get("emp_id"));// 发件人id
			// 内部讯息类型
			map.put("category", "innerInfor");
			// 发送状态为1-发送状态
			map.put("send_status", "1");
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			// 请求到的状态讯息状态（“”：全部；0：未阅；1：已阅；2：未办；3：已办；4:已关注；5显示；6：隐藏）
			String status = (String) map.get("status");
			map.put("is_show", "1");// 默认都显示

			String receiverIds = map.get("receiver_id") == null ? null : map.get("receiver_id").toString();
			String[] senderIdArr = null;
			if (StringUtils.isNotBlank(receiverIds))
				senderIdArr = receiverIds.split(";");
			map.put("receiverIdArr", senderIdArr);

			Map<String, Object> resMap = inforInnerService.inforOutboxListMap(map);

			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("发件列表查询失败!").map();

		}
	}

	/**
	 * 讯息收件列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/inforReceiveList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforReceiveList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的InforCommonsController中inforSendList方法");

		ResultMap resultMap = new ResultMap();

		try {
			PageInit.setPage(map);

			if (map.get("sorts") == null || map.get("sorts").equals("")) {
				PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
						Integer.parseInt(map.get("maxResult").toString()));
			} else {
				PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
						Integer.parseInt(map.get("maxResult").toString()), map.get("sorts").toString());
			}
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			// 拼接参数
			// TODO 登录emp_ID
			map.put("receiver_emp_id", map.get("emp_id"));// 收件人id
			map.put("category", "innerInfor");

			// 请求到的状态讯息状态（“”：全部；0：未阅；1：已阅；2：未办；3：已办；4:已关注；5显示；6：隐藏）
			String status = (String) map.get("status");
			map.put("is_show", "1");// 默认都显示
			if ("0".equals(status)) {// 查询未阅状态的讯息
				map.put("deal_status", "0");
			} else if ("1".equals(status)) {// 查询已阅状态的讯息
				map.put("deal_status", "1");
			} else if ("2".equals(status)) {// 查询未办状态的讯息
				map.put("deal_status", "2");
			} else if ("3".equals(status)) {// 查询已办状态的讯息
				map.put("deal_status", "3");
			} else if ("5".equals(status)) {// 查询显示状态的讯息
				map.put("is_show", "1");
			} else if ("6".equals(status)) {// 查询隐藏状态的讯息
				map.put("is_show", "0");
			}

			String senderIds = map.get("sender_id") == null ? null : map.get("sender_id").toString();
			String[] senderIdArr = null;
			if (StringUtils.isNotBlank(senderIds))
				senderIdArr = senderIds.split(";");
			map.put("senderIdArr", senderIdArr);

			List<Map<String, Object>> listMap = inforInnerService.inforInboxList(map);

			PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(listMap);

			resultMap.success().map().put("count", pageInfo.getTotal());
			resultMap.data(listMap);
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("获取收件讯息列表失败!");
		}
	}

	/**
	 * 讯息草稿列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/inforDraftList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforDraftList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的InforInnerController中inforDraftList方法");

		ResultMap resultMap = new ResultMap();

		try {

			// 拼接参数
			// TODO 登录emp_ID
			map.put("sender_emp_id", map.get("emp_id"));// 发件人id
			// 内部讯息类型
			map.put("category", "innerInfor");
			// 发送状态为0草稿
			map.put("send_status", "0");
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			// 请求到的状态讯息状态（“”：全部；0：未阅；1：已阅；2：未办；3：已办；4:已关注；5显示；6：隐藏）
			String status = (String) map.get("status");
			map.put("is_show", "1");// 默认都显示
			if ("0".equals(status)) {// 查询未阅状态的讯息
				map.put("deal_status", "0");
			} else if ("1".equals(status)) {// 查询已阅状态的讯息
				map.put("deal_status", "1");
			} else if ("2".equals(status)) {// 查询未办状态的讯息
				map.put("deal_status", "2");
			} else if ("3".equals(status)) {// 查询已办状态的讯息
				map.put("deal_status", "3");
			} else if ("5".equals(status)) {// 查询显示状态的讯息
				map.put("is_show", "1");
			} else if ("6".equals(status)) {// 查询隐藏状态的讯息
				map.put("is_show", "0");
			}
			String receiverIds = map.get("receiver_id") == null ? null : map.get("receiver_id").toString();
			String[] senderIdArr = null;
			if (StringUtils.isNotBlank(receiverIds))
				senderIdArr = receiverIds.split(";");
			map.put("receiverIdArr", senderIdArr);

			Map<String, Object> resMap = inforInnerService.inforOutboxListMap(map);

			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("草稿列表查询失败!").map();

		}
	}

	/**
	 * 讯息关注列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/inforCareList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforCareList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的InforInnerController中inforCareList方法");

		ResultMap resultMap = new ResultMap();

		try {
			// 拼接参数
			// TODO 登录emp_ID
			// TODO 登录emp_ID
			map.put("sender_emp_id", map.get("emp_id"));// 发件人id
			map.put("receiver_emp_id", map.get("emp_id"));// 收件人id
			// 内部讯息类型
			map.put("category", "innerInfor");
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			if (map.get("is_show") == null)
				map.put("is_show", "1");
			String receiverIds = map.get("sender_id") == null ? null : map.get("sender_id").toString();
			String[] senderIdArr = null;
			if (StringUtils.isNotBlank(receiverIds))
				senderIdArr = receiverIds.split(";");
			map.put("senderIdArr", senderIdArr);

			Map<String, Object> resMap = inforInnerService.inforCareList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("关注列表查询失败!").map();

		}
	}

	/**
	 * 讯息待阅列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/inforWillList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforWillList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的InforInnerController中inforDraftList方法");

		ResultMap resultMap = new ResultMap();

		try {
			// 拼接参数
			// 内部讯息类型
			map.put("category", "innerInfor");
			// 登陆人员工id
			map.put("receiver_emp_id", map.get("emp_id"));// 收件人id
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			if (map.get("is_show") == null)
				map.put("is_show", "1");
			String senderIds = map.get("sender_id") == null ? null : map.get("sender_id").toString();
			String[] senderIdArr = null;
			if (StringUtils.isNotBlank(senderIds))
				senderIdArr = senderIds.split(";");
			map.put("senderIdArr", senderIdArr);
			map.put("deal_status", "0");// 待阅
			Map<String, Object> resMap = inforInnerService.inforDealList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("待阅列表查询失败!").map();

		}
	}

	/**
	 * 讯息已阅列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/inforHasReadList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforHasReadList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的InforInnerController中inforHasReadList方法");

		ResultMap resultMap = new ResultMap();

		try {
			// 拼接参数
			// 内部讯息类型
			map.put("category", "innerInfor");
			// 登陆人员工id
			map.put("receiver_emp_id", map.get("emp_id"));// 收件人id
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			if (map.get("is_show") == null)
				map.put("is_show", "1");
			String senderIds = map.get("sender_id") == null ? null : map.get("sender_id").toString();
			String[] senderIdArr = null;
			if (StringUtils.isNotBlank(senderIds))
				senderIdArr = senderIds.split(";");
			map.put("senderIdArr", senderIdArr);
			map.put("deal_status", "1");// 已阅
			Map<String, Object> resMap = inforInnerService.inforDealList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("已阅列表查询失败!").map();

		}
	}

	/**
	 * 讯息已办列表
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/inforHasDealList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforHasDealList(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端的InforInnerController中inforHasDealList方法");

		ResultMap resultMap = new ResultMap();

		try {
			// 拼接参数
			// 内部讯息类型
			map.put("category", "innerInfor");
			// 登陆人员工id
			map.put("receiver_emp_id", map.get("emp_id"));// 收件人id
			if (map.get("start_time") != null && !"".equals(map.get("start_time"))) {
				map.put("start_time", map.get("start_time").toString().replaceAll("-", "") + "000000");
			}
			if (map.get("end_time") != null && !"".equals(map.get("end_time"))) {
				map.put("end_time", map.get("end_time").toString().replaceAll("-", "") + "235959");
			}
			if (map.get("is_show") == null)
				map.put("is_show", "1");
			String senderIds = map.get("sender_id") == null ? null : map.get("sender_id").toString();
			String[] senderIdArr = null;
			if (StringUtils.isNotBlank(senderIds))
				senderIdArr = senderIds.split(";");
			map.put("senderIdArr", senderIdArr);
			map.put("deal_status", "3");// 已办
			Map<String, Object> resMap = inforInnerService.inforDealList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("已办列表查询失败!").map();

		}
	}

	/**
	 * 草稿删除
	 */
	@RequestMapping(value = "/inforDraftDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforDraftDelete(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中inforDraftDelete方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			if (list != null && list.size() > 0) {
				for (Map<String, Object> inforNoMap : list) {
					inforInnerService.inforDraftDelete(inforNoMap);
				}
			}
			resultMap.success().sucmsg("草稿删除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("草稿删除失败!").map();
		}
	}

	/**
	 * 批量草稿删除
	 */
	@RequestMapping(value = "/inforDraftBatchDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforDraftBatchDelete(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中inforDraftBatchDelete方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			if (list != null && list.size() > 0) {
				for (Map<String, Object> inforNoMap : list) {
					inforInnerService.inforDraftDelete(inforNoMap);
				}
			}
			resultMap.success().sucmsg("草稿删除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("草稿删除失败!").map();
		}
	}

	/**
	 * 发送草稿
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDraftSend", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforDraftSend(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中inforDraftSend方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			if (list != null && list.size() > 0) {
				for (Map<String, Object> inforNoMap : list) {
					inforInnerService.inforDraftSend(inforNoMap);
				}
			}
			resultMap.success().sucmsg("发送草稿成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("发送草稿失败!").map();
		}
	}

	/**
	 * 批量发送草稿
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDrafBatchSend", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inforDrafBatchSend(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforCommonsController中inforDrafBatchSend方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			if (list != null && list.size() > 0) {
				for (Map<String, Object> inforNoMap : list) {
					inforInnerService.inforDraftSend(inforNoMap);
				}
			}
			resultMap.success().sucmsg("发送草稿成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("发送草稿失败!").map();
		}
	}

}
