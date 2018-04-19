package com.zrt.infor.service.inforinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.AppException;
import com.zrt.commons.Constant;
import com.zrt.commons.PageInit;
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.utils.ImPushMsg;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.infor.domain.InforAccessory;
import com.zrt.infor.domain.InforInbox;
import com.zrt.infor.domain.InforOutbox;
import com.zrt.infor.mapper.inforinner.AppInforInnerMapper;
import com.zrt.infor.mapper.inforinner.InforInnerMapper;
import com.zrt.infor.service.contacts.ContactsService;
import com.zrt.infor.service.inforrecord.InforRecordService;
import com.zrt.infor.service.redis.RedisService;
import com.zrt.infor.service.serial.SerialService;
import com.zrt.infor.service.vif.VifService;
import com.zrt.mybatis.domain.PlatInforAccessoryExample;
import com.zrt.mybatis.domain.PlatInforInbox;
import com.zrt.mybatis.domain.PlatInforInboxExample;
import com.zrt.mybatis.domain.PlatInforOutbox;
import com.zrt.mybatis.domain.PlatInforOutboxExample;
import com.zrt.mybatis.domain.PlatInforRecord;
import com.zrt.mybatis.domain.PlatInforRecordExample;
import com.zrt.mybatis.domain.PlatInforRelevanceExample;
import com.zrt.mybatis.domain.PlatInforRelevanceExample.Criteria;
import com.zrt.mybatis.mapper.PlatInforAccessoryMapper;
import com.zrt.mybatis.mapper.PlatInforInboxMapper;
import com.zrt.mybatis.mapper.PlatInforOutboxMapper;
import com.zrt.mybatis.mapper.PlatInforRecordMapper;
import com.zrt.mybatis.mapper.PlatInforRelevanceMapper;

/**
 * Created by msKui on 2017/3/21.
 */
@Service
public class InforInnerServiceImpl implements InforInnerService {

	@Autowired
	private InforInnerMapper inforInnerMapper;

	@Autowired
	private InforRecordService inforRecordService;
	@Autowired
	private VifService vifService;
	@Autowired
	private ImPushMsg imPushMsg;

	@Autowired
	private PlatInforRecordMapper platInforRecordMapper;
	@Autowired
	private PlatInforInboxMapper platInforInboxMapper;
	@Autowired
	private PlatInforRelevanceMapper platInforRelevanceMapper;
	@Autowired
	private PlatInforAccessoryMapper platInforAccessoryMapper;

	@Autowired
	private PlatInforOutboxMapper platInforOutboxMapper;

	@Autowired
	private SerialService serialService;

	@Autowired
	private ContactsService contactsService;
	@Autowired
	private RedisService redisService;

	@Autowired
	private AppInforInnerMapper appInforInnerMapper;

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> inforOutboxListMap(Map<String, Object> map) throws AppException {
		PageInit.setPage(map);
		List<InforOutbox> list = new ArrayList<InforOutbox>();
		// 请求到的状态讯息状态（“”：全部；0：未阅；1：已阅；2：未办；3：已办；4:已关注；5显示；6：隐藏）
		String status = (String) map.get("status");
		long count = 0;// 查询返回的总条数
		if ("4".equals(status)) {// 发送的所关注的讯息列表
			// 对发送讯息查询out_id进行分组
			Map<String, Object> outListCount = inforInnerMapper.inforSendCareListCount(map);
			if (outListCount != null) {
				count = (Long) outListCount.get("count");//
			}
			// 对发送讯息查询out_id进行分组
			List<Map<String, Object>> outListGroup = inforInnerMapper.inforSendCareListGroup(map);

			if (outListGroup != null && outListGroup.size() > 0) {
				int arrSize = outListGroup.size();
				int[] outIdArr = new int[arrSize];
				for (int i = 0; i < outListGroup.size(); i++) {
					int out_id = (int) (((Map<String, Object>) outListGroup.get(i)).get("out_id"));

					outIdArr[i] = out_id;
				}
				Map<String, Object> reqMap = new HashMap<String, Object>();
				reqMap.put("outIdArr", outIdArr);
				list = inforInnerMapper.inforSendCareList(reqMap);
			}
		} else {

			// 对发送讯息查询out_id进行分组
			Map<String, Object> outListCount = inforInnerMapper.inforSendListCount(map);
			if (outListCount != null) {
				count = (Long) outListCount.get("count");//
			}
			// 对发送讯息查询out_id进行分组
			List<Map<String, Object>> outListGroup = inforInnerMapper.inforSendListGroup(map);

			if (outListGroup != null && outListGroup.size() > 0) {
				int arrSize = outListGroup.size();
				int[] outIdArr = new int[arrSize];
				for (int i = 0; i < outListGroup.size(); i++) {
					int out_id = (int) (((Map<String, Object>) outListGroup.get(i)).get("out_id"));

					outIdArr[i] = out_id;
				}
				Map<String, Object> reqMap = new HashMap<String, Object>();
				reqMap.put("outIdArr", outIdArr);
				list = inforInnerMapper.inforSendList(reqMap);
			}

		}

		List<Map<String, Object>> listMap = null;
		try {
			listMap = convertinforDomain(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("转换为Map时出现异常");
		}

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", listMap);
		resMap.put("count", count);
		return resMap;
	}

	public List<Map<String, Object>> convertinforDomain(List<InforOutbox> listDomain)
			throws ReflectiveOperationException {
		List<Map<String, Object>> listMap = new ArrayList<>();
		for (InforOutbox inforOutbox : listDomain) {
			StringBuffer receiverNames = new StringBuffer();

			List<InforInbox> inforInboxList = inforOutbox.getInboxList();
			Collections.sort(inforInboxList, new Comparator<InforInbox>() {
				public int compare(InforInbox box1, InforInbox box2) {
					return box1.getEmpOrder() - box2.getEmpOrder();
				}
			});

			for (InforInbox inforInbox : inforInboxList) {
				receiverNames.append(inforInbox.getReceiverName() + ";");
			}
			List<InforAccessory> accessoryList = inforOutbox.getAccessoryList();
			if (accessoryList != null && accessoryList.size() > 0) {
				inforOutbox.setAccessoryFlag("1");
			} else {
				inforOutbox.setAccessoryFlag("0");
			}

			inforOutbox.setReceiverNames(receiverNames.toString());
			inforOutbox.setTitle(inforOutbox.getInforRecord().getTitle());
			inforOutbox.setContent(inforOutbox.getInforRecord().getContent());
			inforOutbox.setInforRecord(null);

			Map<String, Object> map = MapEntityConverter.getMapFromEntity(
					new String[] { "out_id", "infor_no", "sender_id", "title", "content", "receiver_names",
							"send_date_time", "create_date_time", "status", "trans_type", "accessory_flag" },
					inforOutbox);

			listMap.add(map);
		}

		return listMap;
	}

	@Override
	@Transactional(readOnly = true)
	public List<InforOutbox> inforOutboxListDomain(Map<String, Object> map) {
		List<InforOutbox> list = new ArrayList<InforOutbox>();
		// 请求到的状态讯息状态（“”：全部；0：未阅；1：已阅；2：未办；3：已办；4:已关注；5显示；6：隐藏）
		String status = (String) map.get("status");

		if ("4".equals(status)) {// 收到的所关注的所关注的讯息列表
			list = inforInnerMapper.inforSendCareList(map);
		} else {
			list = inforInnerMapper.inforSendList(map);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> inforInboxList(Map<String, Object> map) {
		List<Map<String, Object>> list = new ArrayList<>();
		// 请求到的状态讯息状态（“”：全部；0：未阅；1：已阅；2：未办；3：已办；4:已关注；5显示；6：隐藏）
		String status = (String) map.get("status");

		if ("4".equals(status)) {// 收到的所关注的所关注的讯息列表
			list = inforInnerMapper.inforReceiveCareList(map);
		} else {
			list = inforInnerMapper.inforReceiveList(map);
		}

		return list;
	}

	@Override
	public List<Map<String, Object>> monInforList(Map<String, Object> map) {
		return null;
	}

	@Override
	public List<Map<String, Object>> monInforManageList(Map<String, Object> map) {
		return null;
	}

	@Override
	public List<Map<String, Object>> monEmpList(Map<String, Object> map) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> inforList(Map<String, Object> map) throws Exception {
		// 请求到的状态讯息状态（“”：全部；0：未阅；1：已阅；2：未办；3：已办；4:已关注；5显示；6：隐藏）
		String status = (String) map.get("status");
		PageInit.setPage(map);
		if (map.get("sorts") == null || map.get("sorts").equals("")) {
			PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
					Integer.parseInt(map.get("maxResult").toString()));
		} else {
			PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
					Integer.parseInt(map.get("maxResult").toString()), map.get("sorts").toString());
		}
		List<Map<String, Object>> dataList = null;
		if ("4".equals(status)) {// 所关注的讯息列表
			dataList = inforInnerMapper.inforListCares(map);
		} else if ("0".equals(status) || "1".equals(status) || "2".equals(status) || "3".equals(status)) {
			dataList = inforInnerMapper.inforStatusList(map);// 根据状态查询只查收件讯息
		} else {
			dataList = inforInnerMapper.inforList(map);
		}
		if ("6".equals(status) && !dataList.isEmpty()) {// 查询隐藏状态的列表，把状态值再返回（页面显示用）
			for (Map<String, Object> dataMap : dataList) {
				dataMap.put("show", "false");
			}
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", pageInfo.getList());
		resMap.put("count", pageInfo.getTotal());

		return resMap;
	}

	/**
	 * 草稿列表查询
	 * 
	 * @throws ReflectiveOperationException
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> inforDraftList(Map<String, Object> map)
			throws AppException, ReflectiveOperationException {
		// TODO Auto-generated method stub
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString()));
		List<InforOutbox> dataList = inforInnerMapper.inforDraftList(map);
		List<Map<String, Object>> listMap = convertinforDomain(dataList);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(listMap);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", pageInfo.getList());
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	@Override
	public Map<String, Object> inforCareList(Map<String, Object> map) throws Exception {
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString()));
		List<Map<String, Object>> dataList = inforInnerMapper.inforCareList(map);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", pageInfo.getList());
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	@Override
	public Map<String, Object> inforDealList(Map<String, Object> map) throws Exception {
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString()));
		List<Map<String, Object>> dataList = inforInnerMapper.inforDealList(map);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", pageInfo.getList());
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> appInfoList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub

		// “”：全部；0：未阅；1：已阅；2：未办；3：已办；4:已关注；5显示；6：隐藏,7:发送的，8接收的，9：草稿
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
		} else if ("7".equals(status)) {// 查询发送的，状态默认1发送的
			map.put("send_status", "1");
		} else if ("8".equals(status)) {// 查询接收的
			map.put("deal_status", "");
		} else if ("9".equals(status)) {// 查询草稿，发送状态为0
			map.put("send_status", "0");
		} else if ("10".equals(status)) {// 查询已关注（未阅）
			map.put("deal_status", "0");
		} else if ("11".equals(status)) {// 查询已关注（已阅）
			map.put("deal_status", "1");
		} else if ("12".equals(status)) {// 查询已关注（已办）
			map.put("deal_status", "3");
		} else if ("13".equals(status)) {// 查询已关注（隐藏）
			map.put("is_show", "0");
		}
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);

		if ("".equals(status) || "5".equals(status) || "6".equals(status)) {
			String category = (String) map.get("category");
			if ("innerInfor".equals(category) || "".equals(status)) {// 内部讯息查发送的和接收的
				dataList = appInforInnerMapper.inforList(map);
			} else {// 其他类型讯息只查接收的
				dataList = appInforInnerMapper.inforReceiverList(map);
			}

		} else if ("0".equals(status) || "1".equals(status) || "2".equals(status) || "3".equals(status)
				|| "8".equals(status)) {
			dataList = appInforInnerMapper.inforReceiverList(map);
		} else if ("7".equals(status) || "9".equals(status)) {// 发送，草稿
			dataList = appInforInnerMapper.inforSendList(map);
		} else if ("4".equals(status)) {// 关注列表
			dataList = appInforInnerMapper.inforCareList(map);
		} else if ("10".equals(status) || "11".equals(status) || "12".equals(status) || "13".equals(status)) {// 关注列表
			dataList = appInforInnerMapper.inforCareStatusList(map);// 关注未阅、已阅、已办列表
		}
		// 获取redis中员工信息
		Map<String, Object> empdataMap = redisService.getRedis();
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");

		if (dataList != null && dataList.size() > 0) {
			for (Map<String, Object> dataMap : dataList) {
				// Map<String, Object> conmap = new HashMap<>();
				// conmap.put("search", dataMap.get("sender_id"));
				// Map<String, Object> result =
				// contactsService.commonEmpSearch(conmap);
				// @SuppressWarnings("unchecked")
				// List<Map<String, Object>> li = (List<Map<String, Object>>)
				// result.get("data");
				// Map<String, Object> data = null;
				// if (null != li && li.size() > 0) {
				// data = li.get(0);
				// }
				// if (null != data && data.size() > 0) {
				// dataMap.put("emp_head_photo", data.get("emp_head_photo"));
				// dataMap.put("org_name", data.get("org_name"));
				// }

				// 查询员工头像
				for (Map<String, Object> empMap : empList) {
					for (String key : empMap.keySet()) {
						if (dataMap.get("sender_id").equals(key)) {
//							dataMap.put("org_name", ((Map<String, Object>) empMap.get(key)).get("org_name_owner"));
							dataMap.put("emp_head_photo",
									((Map<String, Object>) empMap.get(key)).get("emp_head_photo"));

						}
					}

				}
			}
		}

		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", pageInfo.getList());
		resMap.put("count", pageInfo.getTotal());

		return resMap;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int inforDraftDelete(Map<String, Object> map) throws Exception {
		String inforNo = map.get("infor_no").toString();

		PlatInforRecordExample example = new PlatInforRecordExample();
		com.zrt.mybatis.domain.PlatInforRecordExample.Criteria criteria = example.createCriteria();
		criteria.andInforNoEqualTo(inforNo);
		platInforRecordMapper.deleteByExample(example);

		PlatInforOutboxExample platInforOutboxExample = new PlatInforOutboxExample();
		com.zrt.mybatis.domain.PlatInforOutboxExample.Criteria criteria1 = platInforOutboxExample.createCriteria();
		criteria1.andInforNoEqualTo(inforNo);
		platInforOutboxMapper.deleteByExample(platInforOutboxExample);

		PlatInforInboxExample platInforInboxExample = new PlatInforInboxExample();
		com.zrt.mybatis.domain.PlatInforInboxExample.Criteria criteria2 = platInforInboxExample.createCriteria();
		criteria2.andInforNoEqualTo(inforNo);
		platInforInboxMapper.deleteByExample(platInforInboxExample);

		PlatInforRelevanceExample platInforRelevanceExample = new PlatInforRelevanceExample();
		Criteria criteria3 = platInforRelevanceExample.createCriteria();
		criteria3.andInforNoEqualTo(inforNo);
		platInforRelevanceMapper.deleteByExample(platInforRelevanceExample);

		PlatInforAccessoryExample platInforAccessoryExample = new PlatInforAccessoryExample();
		com.zrt.mybatis.domain.PlatInforAccessoryExample.Criteria criteria4 = platInforAccessoryExample
				.createCriteria();
		criteria4.andInforNoEqualTo(inforNo);
		platInforAccessoryMapper.deleteByExample(platInforAccessoryExample);
		return 1;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int inforDraftSend(Map<String, Object> map) throws Exception {

		PlatInforInbox platInforInbox = new PlatInforInbox();
		platInforInbox.setDealStatus("0");
		PlatInforInboxExample platInforInboxExample = new PlatInforInboxExample();
		com.zrt.mybatis.domain.PlatInforInboxExample.Criteria criteria = platInforInboxExample.createCriteria();
		criteria.andInforNoEqualTo((String) map.get("infor_no"));
		platInforInboxMapper.updateByExampleSelective(platInforInbox, platInforInboxExample);

		PlatInforOutbox platInforOutbox = new PlatInforOutbox();
		platInforOutbox.setSendStatus("1");
		platInforOutbox.setUpdateDateTime(DateUtil.getCurrentDateTime());
		platInforOutbox.setSendDateTime(DateUtil.getCurrentDateTime());
		PlatInforOutboxExample platInforOutboxExample = new PlatInforOutboxExample();
		com.zrt.mybatis.domain.PlatInforOutboxExample.Criteria criteria1 = platInforOutboxExample.createCriteria();
		criteria1.andInforNoEqualTo((String) map.get("infor_no"));
		platInforOutboxMapper.updateByExampleSelective(platInforOutbox, platInforOutboxExample);

		// IM推送系统消息
		Map<String, Object> imreqMap = new HashMap<String, Object>();
		List<PlatInforInbox> inList = platInforInboxMapper.selectByExample(platInforInboxExample);
		String[] receiverIdArr = new String[inList.size()];
		if (inList != null && inList.size() > 0) {
			for (int j = 0; j < inList.size(); j++) {
				receiverIdArr[j] = inList.get(j).getReceiverId();
			}
		}

		imreqMap.put("receiver", receiverIdArr);
		imreqMap.put("msgContent", "您有一条新的内部讯息");

		Map<String, Object> msgDomainMap = new HashMap<String, Object>();
		PlatInforRecordExample example = new PlatInforRecordExample();
		example.createCriteria().andInforNoEqualTo((String) map.get("infor_no"));
		List<PlatInforRecord> recordList = platInforRecordMapper.selectByExample(example);
		PlatInforRecord platInforRecord = new PlatInforRecord();
		if (recordList != null && recordList.size() > 0) {
			platInforRecord = recordList.get(0);
		}
		msgDomainMap.put("infor_no", map.get("infor_no"));
		msgDomainMap.put("title", platInforRecord.getTitle());
		msgDomainMap.put("content", platInforRecord.getContent());
		msgDomainMap.put("status", "0");
		msgDomainMap.put("category", "innerInfor");
		JSONObject msgDomainJSON = JSONObject.parseObject(JSON.toJSONString(msgDomainMap));
		imreqMap.put("msgDomain", "customtype=" + Constant.CUSTOMTYPE + "," + msgDomainJSON.toString());
		Map<String, Object> resMap = imPushMsg.pushMsg(imreqMap);

		vifService.pushMsg(resMap);

		return 1;
	}

	@Override
	public Map<String, Object> getInforCountFlag(Map<String, Object> map) throws Exception {
		PlatInforInboxExample platInforInboxExample = new PlatInforInboxExample();
		com.zrt.mybatis.domain.PlatInforInboxExample.Criteria criteria = platInforInboxExample.createCriteria();
		criteria.andReceiverIdEqualTo((String) map.get("emp_id"));
		criteria.andDealStatusEqualTo("0");
		int count = platInforInboxMapper.countByExample(platInforInboxExample);

		Map<String, Object> flagMap = new HashMap<String, Object>();
		String innerFlag = "";
		if (count > 0) {
			innerFlag = "1";
		} else {
			innerFlag = "0";
		}
		flagMap.put("inner_flag", innerFlag);

		return flagMap;
	}
}
