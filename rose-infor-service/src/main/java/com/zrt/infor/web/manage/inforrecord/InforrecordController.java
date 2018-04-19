package com.zrt.infor.web.manage.inforrecord;

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
import com.zrt.infor.service.inforinner.InforInnerService;
import com.zrt.infor.service.inforrecord.InforRecordService;

@RestController
@RequestMapping("/v1.0/inforrecord")
public class InforrecordController {
	private static final Logger log = LoggerFactory.getLogger(InforrecordController.class);

	@Autowired
	private InforRecordService inforRecordService;
	@Autowired
	private InforInnerService inforInnerService;

	/**
	 * 新建讯息发送
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveAndSendInfor", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> saveAndSendInfor(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforrecordController中saveAndSendInfor方法");
		ResultMap resultMap = new ResultMap();
		String str = "saveAndSend";
		try {
			String inforNo = (String) map.get("infor_no");
			if (StringUtils.isNotBlank(inforNo)) {
				inforInnerService.inforDraftDelete(map);
			}
			inforRecordService.saveInfor(map, str);
			resultMap.success();
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			log.error("json error", e);
			throw new Exception("新建讯息发送失败!");
		}
	}

	/**
	 * 保存草稿
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveInfor", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> saveInfor(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforrecordController中saveInfor方法");
		ResultMap resultMap = new ResultMap();
		String str = "saveInfor";
		try {
			String inforNo = (String) map.get("infor_no");
			if (StringUtils.isNotBlank(inforNo)) {
				inforInnerService.inforDraftDelete(map);
			}
			inforRecordService.saveInfor(map, str);
			resultMap.success().sucmsg("保存草稿成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			log.error("json error", e);
			throw new Exception("保存草稿失败!");
		}
	}

	/**
	 * 回复讯息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/relayInfor", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> relayInfor(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforrecordController中relayInfor方法");
		ResultMap resultMap = new ResultMap();
		String str = "relay";
		try {
			inforRecordService.saveInfor(map, str);
			resultMap.success().sucmsg("回复讯息成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			log.error("json error", e);
			throw new Exception("回复讯息失败!");
		}
	}

	/**
	 * 转发讯息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/transmitInfor", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> transmitInfor(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforrecordController中transmitInfor方法");
		ResultMap resultMap = new ResultMap();
		String str = "transmit";
		try {
			inforRecordService.saveInfor(map, str);
			resultMap.success().sucmsg("转发讯息成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			log.error("json error", e);
			throw new Exception("转发讯息失败!");
		}
	}

	/**
	 * 讯息推送
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/sendUpdateInfor", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> sendUpdateInfor(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforRecordController中sendUpdateInfor方法");
		ResultMap resultMap = new ResultMap();
		try {
			inforRecordService.sendUpdateInfor(map);
			resultMap.success();
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			log.error("json error", e);
			throw new Exception("发送讯息失败!");
		}
	}
}
