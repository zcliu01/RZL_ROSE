package com.zrt.infor.service.inforrecord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zrt.commons.Constant;
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.utils.ImPushMsg;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.infor.mapper.inforCommons.InforCommonsMapper;
import com.zrt.infor.mapper.inforrecord.InforrecordMapper;
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
import com.zrt.mybatis.domain.PlatInforOutboxExample;
import com.zrt.mybatis.domain.PlatInforRecord;
import com.zrt.mybatis.domain.PlatInforRecordExample;
import com.zrt.mybatis.domain.PlatInforRelevance;
import com.zrt.mybatis.mapper.PlatInforAccessoryMapper;
import com.zrt.mybatis.mapper.PlatInforDetailMapper;
import com.zrt.mybatis.mapper.PlatInforInboxMapper;
import com.zrt.mybatis.mapper.PlatInforOutboxMapper;
import com.zrt.mybatis.mapper.PlatInforRecordMapper;
import com.zrt.mybatis.mapper.PlatInforRelevanceMapper;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

/**
 * Created by msKui on 2017/3/23.
 */
@Service
public class InforRecordServiceImpl implements InforRecordService {

	private static final Logger log = LoggerFactory.getLogger(InforRecordServiceImpl.class);
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
	private PlatInforInboxMapper platInforInboxMapper;
	@Autowired
	private PlatInforOutboxMapper platInforOutboxMapper;
	@Autowired
	private InforrecordMapper inforrecordMapper;
	@Autowired
	private ContactsService contactsService;

	@Value("${hr.notify.receiver_id}")
	private String confReceiverId;
	@Value("${infor.topic}")
	private String inforTopic;

	@Override
	public int saveInfor(Map<String, Object> map, String str) throws Exception {
		String inforNo = (String) map.get("infor_no");
		if (StringUtils.isBlank(inforNo)) {
			inforNo = serialService.getSerialNumberFromDB("plat_infor_inner");
			map.put("infor_no", inforNo);
		}
		map.put("save_type", str);
		map.put("create_date_time", DateUtil.getCurrentDateTime());
		map.put("category", "innerInfor");

		Producer producer = createProducer();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		producer.send(new KeyedMessage<Integer, String>(inforTopic, json));

		// 保存讯息
		// insertInfor(map);
		return 1;
	}

	public void insertInfor(Map<String, Object> map) throws Exception {
		// 保存讯息
		int res = 0;
		res = saveInforRecord(map);
		if (1 == res) {
			// 保存发件的信息
			saveOutBox(map);

			// 保存收件的信息
			saveInBox(map);
		}
	}

	private Producer createProducer() {
		Properties properties = new Properties();
		properties.put("zookeeper.connect", "172.27.131.87:2181,172.27.131.88:2181,172.27.131.89:2181");// 声明zk
		properties.put("serializer.class", StringEncoder.class.getName());
		properties.put("serializer.encoding", "UTF8");
		properties.put("metadata.broker.list", "172.27.131.87:9092,172.27.131.88:9092,172.27.131.89:9092");// 声明kafka
		return new Producer<Integer, String>(new ProducerConfig(properties));
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
		String empId = (String) map.get("emp_id");
		if ("saveInfor".equals(map.get("save_type"))) {
			String title = (String) map.get("title");
			String content = (String) map.get("content");
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
		platInforRecord.setCreateEmpId(empId);

		if (empId.equals("zrt_system")) {
			platInforRecord.setCreateEmpName("系统");
		} else {
			// 获取redis中员工信息
			Map<String, Object> empdataMap = redisService.getRedis();
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");
			for (Map<String, Object> empMap : empList) {
				for (String key : empMap.keySet()) {
					if (map.get("emp_id").equals(key)) {
						platInforRecord
								.setCreateEmpName((String) ((Map<String, Object>) empMap.get(key)).get("emp_name"));
					}
				}
			}
		}
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

	@Override
	public int saveInforRecord(PlatInforRecord platInforRecord) {
		return platInforRecordMapper.insertSelective(platInforRecord);
	}

	@Override
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

		if (empId.equals("zrt_system")) {
			platInforOutbox.setSenderName("系统");
		} else {
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
		}

		if ("transmit".equals(map.get("save_type"))) {
			platInforOutbox.setTransType("1");
		} else if ("relay".equals(map.get("save_type"))) {
			platInforOutbox.setTransType("2");
		} else {
			platInforOutbox.setTransType("0");
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
		if (!inList.isEmpty()) {
			inforCommonsMapper.inforAllInsert(inList);// 批量插入讯息收件表
			List<Map<String, Object>> dealList = getDealList(inList, map);// 获取批量插入讯息处理表参数
			if (!dealList.isEmpty()) {
				inforCommonsMapper.inforDealInsert(dealList);// 批量插入讯息处理表
			}

		}
		// 除草稿外发im消息
		if (!"saveInfor".equals(map.get("save_type")) && "innerInfor".equals(map.get("category"))) {
			imThread.setReqMap(map);
			Thread t = new Thread(imThread);
			t.start();
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

		String inforNo = (String) map.get("infor_no");

		PlatInforOutboxExample example = new PlatInforOutboxExample();
		example.createCriteria().andInforNoEqualTo(inforNo);
		PlatInforOutbox outbox = platInforOutboxMapper.selectByExample(example).get(0);

		int outId = outbox.getOutId();
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
		if (!coList.isEmpty()) {
			for (int i = 0; i < reList.size(); i++) {
				for (int j = 0; j < coList.size(); j++) {
					if (reList.get(i).equals(coList.get(j))) {
						coList.remove(j);
					}
				}
			}
		}

		// 接收人数据
		if (!reList.isEmpty()) {
			for (String id : reList) {
				if (StringUtils.isBlank(id)) {
					continue;
				}
				Map<String, Object> inMap = new HashMap<String, Object>();
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
							inMap.put("emp_order", (int) ((Map<String, Object>) empMap.get(key)).get("emp_order"));
							inMap.put("org_id", (String) ((Map<String, Object>) empMap.get(key)).get("org_id"));
							inMap.put("org_name",
									(String) ((Map<String, Object>) empMap.get(key)).get("org_name_owner"));
						}
					}
				}
				inList.add(inMap);
			}
		}
		// 抄送人数据
		if (!coList.isEmpty()) {
			for (String id : coList) {
				if (StringUtils.isBlank(id)) {
					continue;
				}
				Map<String, Object> inMap = new HashMap<String, Object>();
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
							inMap.put("emp_order", (int) ((Map<String, Object>) empMap.get(key)).get("emp_order"));
							inMap.put("org_id", (String) ((Map<String, Object>) empMap.get(key)).get("org_id"));
							inMap.put("org_name",
									(String) ((Map<String, Object>) empMap.get(key)).get("org_name_owner"));
						}
					}
				}
				inList.add(inMap);
			}
		}

		if (null != inList && !inList.isEmpty()) {
			for (Map<String, Object> checkMap : inList) {
				if (StringUtils.isBlank((String) checkMap.get("receiver_name"))) {
					Map<String, Object> serEmpMap = searchEmpMapByEmpId((String) checkMap.get("receiver_id"));
					if (null != serEmpMap && !serEmpMap.isEmpty()) {
						checkMap.put("receiver_name", (String) serEmpMap.get("emp_name"));
						checkMap.put("emp_order", 10000);
						checkMap.put("org_id", serEmpMap.get("org_id"));
						checkMap.put("org_name", (String) serEmpMap.get("org_name_owner"));
					} else {
						inList.remove(checkMap);
					}
				}
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

		String creatDateTime = (String) map.get("create_date_time");
		if (!"saveInfor".equals(saveType)) {
			for (Map<String, Object> inMap : inList) {
				Map<String, Object> dealMap = new HashMap<String, Object>();
				dealMap.put("in_id", inMap.get("in_id"));
				dealMap.put("create_id", inMap.get("receiver_id"));
				dealMap.put("create_date_time", creatDateTime);
				dealMap.put("status", "0");

				dealList.add(dealMap);

			}
		}

		// 如果是回复或者转发，处理表也要添加数据
		if ("relay".equals(saveType) || "transmit".equals(saveType))

		{
			Map<String, Object> dealFirstMap = new HashMap<String, Object>();
			// 找出回复的那条讯息，插入处理表已阅状态以及回复或者转发状态
			String parentNo = (String) map.get("parent_no");
			String empId = (String) map.get("emp_id");
			PlatInforInboxExample inExample = new PlatInforInboxExample();
			inExample.createCriteria().andInforNoEqualTo(parentNo).andReceiverIdEqualTo(empId);
			List<PlatInforInbox> platInforInboxList = platInforInboxMapper.selectByExample(inExample);
			int firstInId = 0;
			if (!platInforInboxList.isEmpty()) {
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

	/**
	 * 讯息转发
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void sendUpdateInfor(Map<String, Object> map) throws Exception {

		map.put("infor_no", serialService.getSerialNumberFromDB("plat_infor_inner"));
		String curDate = DateUtil.getCurrentDateTime();
		map.put("create_date_time", curDate);

		String busType = (String) map.get("bus_type");// 推送类型：1:个人信息修改，2：会议新建，3：会议修改，4：会议取消,5:任务新建，6：任务结束，7：普通流程代办任务，8：会签流程代办任务
		String receiverIds = "";
		if ("1".equals(busType)) {
			receiverIds = confReceiverId;
		} else {
			receiverIds = (String) map.get("receiver_ids");
		}
		map.put("receiver_ids", receiverIds);
		map.put("emp_id", map.get("sender_id"));

		// 保存讯息
		boolean flag = getIsInsert(map);
		if (flag) {

			// insertInfor(map);

			Producer producer = createProducer();
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(map);
			producer.send(new KeyedMessage<Integer, String>(inforTopic, json));
		}

		String[] receiverIdArr = receiverIds.split(";");
		if (receiverIdArr.length > 0 && "flowInfor".equals((String) map.get("category"))) {
			// IM推送系统消息
			Map<String, Object> imreqMap = new HashMap<String, Object>();
			imreqMap.put("receiver", receiverIdArr);
			imreqMap.put("msgContent", "您有一条新的流程讯息");

			Map<String, Object> msgDomainMap = new HashMap<String, Object>();
			msgDomainMap.put("infor_no", map.get("infor_no"));
			msgDomainMap.put("title", map.get("title"));
			msgDomainMap.put("content", map.get("content"));
			msgDomainMap.put("status", "0");
			msgDomainMap.put("category", (String) map.get("category"));
			msgDomainMap.put("bus_type", (String) map.get("bus_type"));

			String busDomain = (String) map.get("bus_domain");
			if (StringUtils.isNotBlank(busDomain)) {
				Map<String, Object> busDomainMap = JSON.parseObject(busDomain);
				msgDomainMap.putAll(busDomainMap);
				msgDomainMap.put("bus_domain", busDomainMap);
			}
			JSONObject msgDomainJSON = JSONObject.parseObject(JSON.toJSONString(msgDomainMap));
			imreqMap.put("msgDomain", "customtype=" + Constant.CUSTOMTYPE + "," + msgDomainJSON.toString());
			Map<String, Object> resMap = imPushMsg.pushMsg(imreqMap);

			vifService.pushMsg(resMap);
		}

	}

	private boolean getIsInsert(Map<String, Object> map) {
		String category = (String) map.get("category");
		String busDomain = (String) map.get("bus_domain");

		// 公文、公示有撤销处理
		if (("docInfor".equals(category) || "pubInfor".equals(category)) && StringUtils.isNotBlank(busDomain)) {

			Map<String, Object> busDomainMap = JSON.parseObject(busDomain);
			String inforFlag = (String) busDomainMap.get("infor_flag");
			String busId = (String) busDomainMap.get("bus_id");
			if ("1".equals(inforFlag)) {
				PlatInforRecordExample example = new PlatInforRecordExample();
				example.createCriteria().andBusIdEqualTo(busId).andCategoryEqualTo(category)
						.andCreateEmpIdEqualTo((String) map.get("emp_id"));
				List<PlatInforRecord> inforRecordList = platInforRecordMapper.selectByExample(example);
				if (!inforRecordList.isEmpty()) {
					PlatInforRecord platInforRecord = inforRecordList.get(0);
					String inforId = platInforRecord.getInforId();
					platInforRecordMapper.deleteByPrimaryKey(inforId);
					String inforNo = platInforRecord.getInforNo();
					inforrecordMapper.deleteInforDetail(inforNo);

					PlatInforOutboxExample outExample = new PlatInforOutboxExample();
					outExample.createCriteria().andInforNoEqualTo(inforNo)
							.andSenderIdEqualTo((String) map.get("emp_id"));
					platInforOutboxMapper.deleteByExample(outExample);

					PlatInforInboxExample inExample = new PlatInforInboxExample();
					inExample.createCriteria().andInforNoEqualTo(inforNo);
					platInforInboxMapper.deleteByExample(inExample);
				}
				return false;

			} else {
				return true;
			}
		} else {
			return true;
		}

	}

	/**
	 * 根据员工ID获取员工的相关信息
	 */
	public Map<String, Object> searchEmpMapByEmpId(String empId) {
		// 获取当前登录用户的信息
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("type", "0");
		resMap.put("search", empId);
		Map<String, Object> dataMap = contactsService.commonEmpSearch(resMap);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> empList = (List<Map<String, Object>>) dataMap.get("data");
		if (empList != null && empList.size() > 0) {
			Map<String, Object> empMap = empList.get(0);
			return empMap;
		} else {
			return null;
		}

	}

}
