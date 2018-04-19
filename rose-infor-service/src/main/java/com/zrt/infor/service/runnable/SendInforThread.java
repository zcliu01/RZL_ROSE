package com.zrt.infor.service.runnable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zrt.commons.Constant;
import com.zrt.commons.utils.ImPushMsg;
import com.zrt.infor.mapper.inforCommons.InforCommonsMapper;
import com.zrt.infor.service.redis.RedisService;
import com.zrt.infor.service.serial.SerialService;
import com.zrt.infor.service.vif.VifService;
import com.zrt.mybatis.domain.PlatInforDetailExample;
import com.zrt.mybatis.domain.PlatInforInbox;
import com.zrt.mybatis.domain.PlatInforInboxExample;
import com.zrt.mybatis.mapper.PlatInforDetailMapper;
import com.zrt.mybatis.mapper.PlatInforInboxMapper;

/**
 * 新建讯息和转发讯息保存讯息收件表走异步
 * 
 * @author yxb
 *
 */
@Service
public class SendInforThread implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(SendInforThread.class);

	@Autowired
	private InforCommonsMapper inforCommonsMapper;
	@Autowired
	private PlatInforDetailMapper platInforDetailMapper;
	@Autowired
	private PlatInforInboxMapper platInforInboxMapper;
	@Autowired
	private VifService vifService;
	@Autowired
	private ImPushMsg imPushMsg;
	@Autowired
	private SerialService serialService;
	@Autowired
	private RedisService redisService;

	private Map<String, Object> reqMap;

	public Map<String, Object> getReqMap() {
		return reqMap;
	}

	public void setReqMap(Map<String, Object> reqMap) {
		this.reqMap = reqMap;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void run() {

		try {
			List<Map<String, Object>> inList = getInList(reqMap);// 获取批量插入讯息收件表参数
			if (inList != null && inList.size() > 0) {
				inforCommonsMapper.inforAllInsert(inList);// 批量插入讯息收件表

				List<Map<String, Object>> dealList = getDealList(inList, reqMap);// 获取批量插入讯息处理表参数
				if (dealList != null && dealList.size() > 0) {
					inforCommonsMapper.inforDealInsert(dealList);// 批量插入讯息处理表
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取批量插入讯息收件表参数
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getInList(Map<String, Object> map) {

		// 获取redis中员工信息
		Map<String, Object> empdataMap = redisService.getRedis();

		List<Map<String, Object>> inList = new ArrayList<Map<String, Object>>();

		String outId = (String) map.get("out_id");
		String inforNo = (String) map.get("infor_no");
		String saveType = (String) map.get("save_type");
		String dealStatus = "";
		if ("saveInfor".equals(saveType)) {// 草稿
			dealStatus = "4";
		} else {
			dealStatus = "0";
		}
		String copyerIds = (String) map.get("copyer_ids");
		String receiverIds = (String) map.get("receiver_ids");

		ArrayList<String> coList = new ArrayList<String>();
		ArrayList<String> reList = new ArrayList<String>();
		if (StringUtils.isNotBlank(copyerIds)) {
			String[] copyerIdArr = copyerIds.split(";");
			coList = new ArrayList<String>(Arrays.asList(copyerIdArr));
		}

		if (StringUtils.isNotBlank(receiverIds)) {
			String[] receiverIdArr = receiverIds.split(";");
			reList = new ArrayList<String>(Arrays.asList(receiverIdArr));
		}

		// 接收人抄送人去重
		if (coList != null && coList.size() > 0) {
			for (int i = 0; i < reList.size(); i++) {
				for (int j = 0; j < coList.size(); j++) {
					if (reList.get(i).equals(coList.get(j))) {
						coList.remove(j);
					}
				}
			}
		}

		// 接收人数据
		if (reList != null && reList.size() > 0) {
			for (String id : reList) {
				Map<String, Object> inMap = new HashMap<String, Object>();
				inMap.put("in_id", serialService.getUUID());
				inMap.put("out_id", outId);
				inMap.put("infor_no", inforNo);
				inMap.put("deal_status", dealStatus);
				inMap.put("is_show", "1");// 默认显示
				inMap.put("receiver_id", id);
				inMap.put("receiver_type", "0");// 接收人类型

				@SuppressWarnings("unchecked")
				List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");
				for (Map<String, Object> empMap : empList) {
					for (String key : empMap.keySet()) {
						if (id.equals(key)) {
							inMap.put("receiver_name",
									(String) ((Map<String, Object>) empMap.get(key)).get("emp_name"));
							inMap.put("org_id", (String) ((Map<String, Object>) empMap.get(key)).get("org_id"));
							inMap.put("org_name", (String) ((Map<String, Object>) empMap.get(key)).get("org_name"));
						}
					}
				}
				inList.add(inMap);
			}
		}
		// 抄送人数据
		if (coList != null && coList.size() > 0) {
			for (String id : coList) {
				Map<String, Object> inMap = new HashMap<String, Object>();
				inMap.put("in_id", serialService.getUUID());
				inMap.put("out_id", outId);
				inMap.put("infor_no", inforNo);
				inMap.put("deal_status", dealStatus);
				inMap.put("is_show", "1");// 默认显示
				inMap.put("receiver_id", id);
				inMap.put("receiver_type", "1");// 抄送人类型
				@SuppressWarnings("unchecked")
				List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");
				for (Map<String, Object> empMap : empList) {
					for (String key : empMap.keySet()) {
						if (id.equals(key)) {
							inMap.put("receiver_name",
									(String) ((Map<String, Object>) empMap.get(key)).get("emp_name"));
							inMap.put("org_id", (String) ((Map<String, Object>) empMap.get(key)).get("org_id"));
							inMap.put("org_name",
									(String) ((Map<String, Object>) empMap.get(key)).get("org_name_owner"));
						}
					}
				}
				inList.add(inMap);
			}
		}

		return inList;
	}

	/**
	 * 获取批量插入讯息处理表参数
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getDealList(List<Map<String, Object>> inList, Map<String, Object> map) {

		List<Map<String, Object>> dealList = new ArrayList<Map<String, Object>>();
		String saveType = (String) map.get("save_type");
		if (!"saveInfor".equals(saveType)) {
			for (Map<String, Object> inMap : inList) {
				String inId = (String) inMap.get("in_id");
				String receiverId = (String) inMap.get("receiver_id");
				String creatDateTime = (String) reqMap.get("create_date_time");

				Map<String, Object> dealMap = new HashMap<String, Object>();
				dealMap.put("detail_id", serialService.getUUID());
				dealMap.put("in_id", inId);
				dealMap.put("create_id", receiverId);
				dealMap.put("create_date_time", creatDateTime);
				dealMap.put("status", "0");

				dealList.add(dealMap);

			}
		}

		// 如果是回复或者转发，处理表也要添加数据
		if ("relay".equals(saveType) || "transmit".equals(saveType)) {
			Map<String, Object> dealFirstMap = new HashMap<String, Object>();
			// 找出回复的那条讯息，插入处理表已阅状态以及回复或者转发状态
			String parentNo = (String) map.get("parent_no");
			String empId = (String) map.get("emp_id");
			PlatInforInboxExample inExample = new PlatInforInboxExample();
			inExample.createCriteria().andInforNoEqualTo(parentNo).andReceiverIdEqualTo(empId);
			List<PlatInforInbox> platInforInboxList = platInforInboxMapper.selectByExample(inExample);
			int firstInId = 0;
			if (platInforInboxList != null && platInforInboxList.size() > 0) {
				firstInId = platInforInboxList.get(0).getInId();
				// 如果收件表处理状态还是未阅就要改为已阅
				if ("0".equals(platInforInboxList.get(0).getDealStatus())) {
					PlatInforInbox inbox = new PlatInforInbox();
					inbox.setDealStatus("1");
					platInforInboxMapper.updateByExampleSelective(inbox, inExample);

				}
			}
			dealFirstMap.put("detail_id", serialService.getUUID());
			dealFirstMap.put("in_id", firstInId);
			dealFirstMap.put("create_id", empId);
			dealFirstMap.put("create_date_time", map.get("create_date_time"));
			dealFirstMap.put("status", "1");// 已阅状态
			PlatInforDetailExample example = new PlatInforDetailExample();
			example.createCriteria().andInIdEqualTo((int) dealFirstMap.get("in_id"))
					.andStatusEqualTo((String) dealFirstMap.get("status"));
			int count = platInforDetailMapper.countByExample(example);
			if (count < 1) {
				dealList.add(dealFirstMap);
			}

			Map<String, Object> dealLastMap = new HashMap<String, Object>();
			dealLastMap.put("detail_id", serialService.getUUID());
			dealLastMap.put("in_id", firstInId);
			dealLastMap.put("create_id", empId);
			dealLastMap.put("create_date_time", map.get("create_date_time"));
			if ("relay".equals(saveType)) {
				dealLastMap.put("status", "3");// 回复状态
			} else if ("transmit".equals(saveType)) {
				dealLastMap.put("status", "4");// 转发状态
			}

			PlatInforDetailExample exampleNew = new PlatInforDetailExample();
			exampleNew.createCriteria().andInIdEqualTo((int) dealLastMap.get("in_id"))
					.andStatusEqualTo((String) dealLastMap.get("status"));
			int countNew = platInforDetailMapper.countByExample(exampleNew);
			if (countNew < 1) {
				dealList.add(dealLastMap);
			}

		}
		return dealList;
	}

}
