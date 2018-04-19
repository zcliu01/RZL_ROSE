package com.zrt.infor.service.runnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zrt.commons.Constant;
import com.zrt.commons.utils.ImPushMsg;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.infor.mapper.inforCommons.InforCommonsMapper;
import com.zrt.infor.service.contacts.ContactsService;
import com.zrt.infor.service.redis.RedisService;
import com.zrt.infor.service.runnable.ImThread;
import com.zrt.infor.service.serial.SerialService;
import com.zrt.infor.service.vif.VifService;
import com.zrt.mybatis.domain.PlatInforAccessory;
import com.zrt.mybatis.domain.PlatInforDetailExample;
import com.zrt.mybatis.domain.PlatInforInbox;
import com.zrt.mybatis.domain.PlatInforInboxExample;
import com.zrt.mybatis.domain.PlatInforOutbox;
import com.zrt.mybatis.domain.PlatInforRecord;
import com.zrt.mybatis.domain.PlatInforRecordExample;
import com.zrt.mybatis.domain.PlatInforRelevance;
import com.zrt.mybatis.mapper.PlatInforAccessoryMapper;
import com.zrt.mybatis.mapper.PlatInforDetailMapper;
import com.zrt.mybatis.mapper.PlatInforInboxMapper;
import com.zrt.mybatis.mapper.PlatInforOutboxMapper;
import com.zrt.mybatis.mapper.PlatInforRecordMapper;
import com.zrt.mybatis.mapper.PlatInforRelevanceMapper;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

@Service
public class KafkaThread implements Runnable {

	@Autowired
	private PlatInforRecordMapper platInforRecordMapper;
	@Autowired
	private InforCommonsMapper inforCommonsMapper;
	@Autowired
	private PlatInforDetailMapper platInforDetailMapper;

	@Autowired
	private PlatInforRelevanceMapper platInforRelevanceMapper;
	@Autowired
	private VifService vifService;
	@Autowired
	private ImPushMsg imPushMsg;
	@Autowired
	private ImThread imThread;
	@Autowired
	private PlatInforAccessoryMapper platInforAccessoryMapper;
	@Autowired
	private SerialService serialService;
	@Autowired
	private RedisService redisService;
	@Autowired
	private ContactsService contactsService;
	@Autowired
	private PlatInforInboxMapper platInforInboxMapper;

	@Autowired
	private PlatInforOutboxMapper platInforOutboxMapper;

	@Override
	public void run() {
		ConsumerConnector consumer = createConsumer();
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put("infor", 1); // 一次从主题中获取一个数据
		Map<String, List<KafkaStream<byte[], byte[]>>> messageStreams = consumer.createMessageStreams(topicCountMap);
		KafkaStream<byte[], byte[]> stream = messageStreams.get("infor").get(0);// 获取每次接收到的这个数据
		ConsumerIterator<byte[], byte[]> iterator = stream.iterator();
		while (iterator.hasNext()) {
			String message = new String(iterator.next().message());
			ObjectMapper mapper = new ObjectMapper();
			try {
				Map<String, Object> map = mapper.readValue(message, Map.class);
				// 保存讯息
				int res = 0;

				res = saveInforRecord(map);
				if (1 == res) {
					// 保存发件的信息
					map.put("out_id", serialService.getUUID());
					saveOutBox(map);

					// 保存收件的信息
					saveInBox(map);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private ConsumerConnector createConsumer() {
		Properties properties = new Properties();
		properties.put("zookeeper.connect", "172.27.131.87:2181,172.27.131.88:2181,172.27.131.89:2181");// 声明zk
		properties.put("group.id", "group5");// 必须要使用别的组名称，
												// 如果生产者和消费者都在同一组，则不能访问同一组内的topic数据
		return Consumer.createJavaConsumerConnector(new ConsumerConfig(properties));
	}

	/**
	 * 保存讯息
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int saveInforRecord(Map<String, Object> map) throws Exception {
		if ("saveInfor".equals(map.get("save_type"))) {
			String title = (String) map.get("title");
			String content = (String) map.get("content");
			String empId = (String) map.get("emp_id");
			PlatInforRecordExample rExample = new PlatInforRecordExample();
			rExample.createCriteria().andTitleEqualTo(title).andContentEqualTo(content).andCreateEmpIdEqualTo(empId);
			List<PlatInforRecord> rList = platInforRecordMapper.selectByExample(rExample);
			if (rList != null && rList.size() > 0) {
				return 0;
			}
		}

		PlatInforRecord platInforRecord = (PlatInforRecord) MapEntityConverter.getEntityFromMap(map,
				PlatInforRecord.class);
		platInforRecord.setInforId(serialService.getUUID());
		String parentNo = (String) map.get("parent_no");
		if (StringUtils.isNotEmpty(parentNo)) {
			platInforRecord.setParentNo(parentNo);
		}
		platInforRecord.setCreateEmpId((String) map.get("emp_id"));

		// 获取redis中员工信息
		Map<String, Object> empdataMap = redisService.getRedis();
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");
		for (Map<String, Object> empMap : empList) {
			for (String key : empMap.keySet()) {
				if (map.get("emp_id").equals(key)) {
					platInforRecord.setCreateEmpName((String) ((Map<String, Object>) empMap.get(key)).get("emp_name"));
				}
			}
		}
		platInforRecord.setCategory("innerInfor");
		List<Map<String, Object>> listRel = (List<Map<String, Object>>) map.get("rel");
		List<Map<String, Object>> listCon = (List<Map<String, Object>>) map.get("acc");

		List<PlatInforRelevance> relevanceList = new ArrayList<>();
		if (listRel != null && listRel.size() > 0) {
			for (Map<String, Object> m : listRel) {
				PlatInforRelevance platInforRelevance = (PlatInforRelevance) MapEntityConverter.getEntityFromMap(m,
						PlatInforRelevance.class);
				platInforRelevance.setRelInforId(serialService.getUUID());
				platInforRelevance.setInforNo(map.get("infor_no").toString());

				relevanceList.add(platInforRelevance);
			}
		}

		List<PlatInforAccessory> accessoryList = new ArrayList<>();
		if (listCon != null && listCon.size() > 0) {
			for (Map<String, Object> m : listCon) {
				PlatInforAccessory platInforAccessory = (PlatInforAccessory) MapEntityConverter.getEntityFromMap(m,
						PlatInforAccessory.class);
				platInforAccessory.setAccId(serialService.getUUID());
				platInforAccessory.setInforNo(map.get("infor_no").toString());
				accessoryList.add(platInforAccessory);
			}
		}

		this.saveInforRecord(platInforRecord, relevanceList, accessoryList);
		return 1;
	}

	public int saveInforRecord(PlatInforRecord platInforRecord) {
		return platInforRecordMapper.insertSelective(platInforRecord);
	}

	public int saveInforRecord(PlatInforRecord platInforRecord, List<PlatInforRelevance> relevanceList,
			List<PlatInforAccessory> accessoryList) {

		int i = platInforRecordMapper.insertSelective(platInforRecord);
		for (PlatInforRelevance platInforRelevance : relevanceList) {
			platInforRelevanceMapper.insertSelective(platInforRelevance);
		}
		for (PlatInforAccessory platInforAccessory : accessoryList) {
			platInforAccessoryMapper.insertSelective(platInforAccessory);
		}
		return i;
	}

	/**
	 * 保存发件的信息
	 * 
	 * @param map
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void saveOutBox(Map<String, Object> map) throws Exception {
		PlatInforOutbox platInforOutbox = (PlatInforOutbox) MapEntityConverter.getEntityFromMap(map,
				PlatInforOutbox.class);
		String empId = (String) map.get("emp_id");
		platInforOutbox.setSenderId(empId);
		// 获取redis中员工信息
		Map<String, Object> empdataMap = redisService.getRedis();
		List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");
		for (Map<String, Object> empMap : empList) {
			for (String key : empMap.keySet()) {
				if (empId.equals(key)) {
					platInforOutbox.setSenderName((String) ((Map<String, Object>) empMap.get(key)).get("emp_name"));
					platInforOutbox.setOrgId((String) ((Map<String, Object>) empMap.get(key)).get("org_id"));
					platInforOutbox.setOrgName((String) ((Map<String, Object>) empMap.get(key)).get("org_name"));
				}
			}
		}

		if (map.get("save_type").equals("saveAndSend")) {
			platInforOutbox.setTransType("0");
		} else if (map.get("save_type").equals("transmit")) {
			platInforOutbox.setTransType("1");
		} else if (map.get("save_type").equals("relay")) {
			platInforOutbox.setTransType("2");
		}
		if (("saveInfor").equals(map.get("save_type"))) {
			platInforOutbox.setSendStatus("0");
		} else {
			platInforOutbox.setSendStatus("1");
			platInforOutbox.setSendDateTime((String) map.get("create_date_time"));
		}
		platInforOutboxMapper.insertSelective(platInforOutbox);
	}

	/**
	 * 保存收件的信息
	 * 
	 * @param map
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void saveInBox(Map<String, Object> map) throws Exception {
		List<Map<String, Object>> inList = getInList(map);// 获取批量插入讯息收件表参数
		if (inList != null && inList.size() > 0) {
			inforCommonsMapper.inforAllInsert(inList);// 批量插入讯息收件表

			List<Map<String, Object>> dealList = getDealList(inList, map);// 获取批量插入讯息处理表参数
			if (dealList != null && dealList.size() > 0) {
				inforCommonsMapper.inforDealInsert(dealList);// 批量插入讯息处理表
			}
		}
		// 除草稿外发im消息
		if (!"saveInfor".equals(map.get("save_type"))) {
			String receiverIds = "";
			if (StringUtils.isNotBlank((String) map.get("copyer_ids"))) {
				receiverIds = (String) map.get("receiver_ids") + (String) map.get("copyer_ids");
			}
			receiverIds = (String) map.get("receiver_ids");

			// IM推送系统消息
			Map<String, Object> imreqMap = new HashMap<String, Object>();
			String[] receiver = receiverIds.split(";");
			imreqMap.put("receiver", receiver);
			imreqMap.put("msgContent", "您有一条新的内部讯息");

			Map<String, Object> msgDomainMap = new HashMap<String, Object>();
			msgDomainMap.put("infor_no", map.get("infor_no"));
			msgDomainMap.put("title", map.get("title"));
			msgDomainMap.put("content", map.get("content"));
			msgDomainMap.put("status", "0");
			msgDomainMap.put("category", "innerInfor");
			// msgDomainMap.put("member", member);
			JSONObject msgDomainJSON = JSONObject.parseObject(JSON.toJSONString(msgDomainMap));
			imreqMap.put("msgDomain", "customtype=" + Constant.CUSTOMTYPE + "," + msgDomainJSON.toString());
			Map<String, Object> resMap = imPushMsg.pushMsg(imreqMap);

			vifService.pushMsg(resMap);
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
				String creatDateTime = (String) map.get("create_date_time");

				Map<String, Object> dealMap = new HashMap<String, Object>();
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
