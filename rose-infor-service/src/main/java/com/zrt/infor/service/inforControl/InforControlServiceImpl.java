package com.zrt.infor.service.inforControl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.commons.PageInit;
import com.zrt.infor.domain.InforDetail;
import com.zrt.infor.domain.InforInbox;
import com.zrt.infor.domain.InforOutbox;
import com.zrt.infor.mapper.inforControl.InforControlMapper;
import com.zrt.infor.service.contacts.ContactsService;

@Service
public class InforControlServiceImpl implements InforControlService {

	@Autowired
	private InforControlMapper inforControlMapper;
	@Autowired
	private ContactsService contactsService;

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getControlDetails(Map<String, Object> map) throws Exception {

		PageInit.setPage(map);
		if ("0".equals(map.get("status"))) {
			map.put("deal_status", "0");
		}
		Map<String, Object> resMap = new HashMap<String, Object>();// 接口返回map
		Map<String, Object> dataMap = new HashMap<String, Object>();// 接口返回map的data参数的map
		Map<String, Object> reqMap = new HashMap<String, Object>();// 查询列表请求参数的map
		List<InforOutbox> outboxlist = new ArrayList<InforOutbox>();// 查询返回的list
		// 获取单条讯息的收件总数
		long count = 0;
		Map<String, Object> countMap = inforControlMapper.singleReceiveCount(map);
		if (countMap != null) {
			count = (long) countMap.get("count");
		}

		// 获取单条讯息的收件id
		List<Map<String, Object>> inIdList = inforControlMapper.singleReceiveGroup(map);
		if (inIdList != null && inIdList.size() > 0) {
			int[] inIdArr = new int[inIdList.size()];
			for (int i = 0; i < inIdList.size(); i++) {
				int in_id = (int) inIdList.get(i).get("in_id");
				inIdArr[i] = in_id;
			}

			reqMap.put("inIdArr", inIdArr);
			outboxlist = inforControlMapper.inforDetailsList(reqMap);

			// 组装返回map
			if (outboxlist != null && outboxlist.size() > 0) {
				for (InforOutbox outbox : outboxlist) {
					dataMap.put("infor_no", outbox.getInforRecord().getInforNo());
					dataMap.put("title", outbox.getInforRecord().getTitle());
					dataMap.put("send_date_time", outbox.getSendDateTime());

					StringBuffer receiverNames = new StringBuffer();
					StringBuffer coperNames = new StringBuffer();
					List<Map<String, Object>> timeList = new ArrayList<Map<String, Object>>();

					List<InforInbox> inforInboxList = outbox.getInboxList();
					for (InforInbox inforInbox : inforInboxList) {
						if (inforInbox.getReceiverType().equals("0")) {
							receiverNames.append(inforInbox.getReceiverName() + ";");
						} else if (inforInbox.getReceiverType().equals("1")) {
							coperNames.append(inforInbox.getReceiverName() + ";");
						}

						String reId = inforInbox.getReceiverId();
						List<InforDetail> detailsList = inforInbox.getDetailList();
						Map<String, Object> timeMap = new HashMap<String, Object>();
						timeMap.put("receiver_id", inforInbox.getReceiverId());
						timeMap.put("receiver_name", inforInbox.getReceiverName());
						timeMap.put("send_date_time", outbox.getSendDateTime());
						timeMap.put("read_time", "");
						timeMap.put("deal_time", "");
						timeMap.put("reply_time", "");
						timeMap.put("transmit_time", "");
						for (InforDetail d : detailsList) {
							if (d.getCreateId().equals(reId)) {
								if (!"0".equals(d.getStatus())) {
									String timeType = judgeTimeType(d.getStatus());
									timeMap.put(timeType, d.getCreateDateTime());
								}
							}

						}
						timeList.add(timeMap);
					}
					dataMap.put("receiver_names", receiverNames);
					dataMap.put("copyer_names", coperNames);
					dataMap.put("details", timeList);
				}

			}
		}

		dataMap.put("count", count);
		resMap.put("data", dataMap);
		return resMap;
	}

	private String judgeTimeType(String status) {

		String timeType = "";
		if ("1".equals(status)) {
			timeType = "read_time";
		}
		if ("2".equals(status)) {
			timeType = "deal_time";
		}
		if ("3".equals(status)) {
			timeType = "reply_time";
		}
		if ("4".equals(status)) {
			timeType = "transmit_time";
		}

		return timeType;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getDetailsSearch(Map<String, Object> map) throws Exception {

		PageInit.setPage(map);
		if ("0".equals(map.get("status"))) {
			map.put("deal_status", "0");
		}
		Map<String, Object> resMap = new HashMap<String, Object>();// 接口返回map
		Map<String, Object> reqMap = new HashMap<String, Object>();// 查询列表请求参数的map
		List<InforOutbox> outboxlist = new ArrayList<InforOutbox>();// 查询返回的list
		List<Map<String, Object>> timeList = new ArrayList<Map<String, Object>>();// 接口返回map的data参数

		// 获取单条讯息的收件总数
		long count = 0;
		Map<String, Object> countMap = inforControlMapper.singleReceiveCount(map);
		if (countMap != null) {
			count = (long) countMap.get("count");
		}

		// 获取单条讯息的收件id
		List<Map<String, Object>> inIdList = inforControlMapper.singleReceiveGroup(map);
		if (inIdList != null && inIdList.size() > 0) {
			int[] inIdArr = new int[inIdList.size()];
			for (int i = 0; i < inIdList.size(); i++) {
				int in_id = (int) inIdList.get(i).get("in_id");
				inIdArr[i] = in_id;
			}

			reqMap.put("inIdArr", inIdArr);
			outboxlist = inforControlMapper.inforDetailsList(reqMap);
			// 组装返回map
			if (outboxlist != null && outboxlist.size() > 0) {

				for (InforOutbox outbox : outboxlist) {
					List<InforInbox> inforInboxList = outbox.getInboxList();
					for (InforInbox inforInbox : inforInboxList) {

						String reId = inforInbox.getReceiverId();
						List<InforDetail> detailsList = inforInbox.getDetailList();
						Map<String, Object> timeMap = new HashMap<String, Object>();
						timeMap.put("receiver_id", inforInbox.getReceiverId());
						timeMap.put("receiver_name", inforInbox.getReceiverName());
						timeMap.put("send_date_time", outbox.getSendDateTime());
						timeMap.put("read_time", "");
						timeMap.put("deal_time", "");
						timeMap.put("reply_time", "");
						timeMap.put("transmit_time", "");
						for (InforDetail d : detailsList) {
							if (d.getCreateId().equals(reId)) {
								if (!"0".equals(d.getStatus())) {
									String timeType = judgeTimeType(d.getStatus());
									timeMap.put(timeType, d.getCreateDateTime());
								}
							}

						}
						timeList.add(timeMap);
					}
				}
			}
		}

		resMap.put("data", timeList);
		resMap.put("count", count);
		return resMap;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getWithEmpList(Map<String, Object> map) throws Exception {

		PageInit.setPage(map);
		if ("0".equals(map.get("status"))) {
			map.put("deal_status", "0");
		}

		Map<String, Object> resMap = new HashMap<String, Object>();// 接口返回map
		Map<String, Object> reqMap = new HashMap<String, Object>();// 查询列表请求参数的map
		List<InforOutbox> outboxlist = new ArrayList<InforOutbox>();// 查询返回的list
		List<Map<String, Object>> timeList = new ArrayList<Map<String, Object>>();// 接口返回map的data参数

		// 获取单条讯息的收件总数
		long count = 0;
		Map<String, Object> countMap = inforControlMapper.singleReceiveCount(map);
		if (countMap != null) {
			count = (long) countMap.get("count");
		}

		// 获取单条讯息的收件id
		List<Map<String, Object>> inIdList = inforControlMapper.singleReceiveGroup(map);
		if (inIdList != null && inIdList.size() > 0) {
			int[] inIdArr = new int[inIdList.size()];
			for (int i = 0; i < inIdList.size(); i++) {
				int in_id = (int) inIdList.get(i).get("in_id");
				inIdArr[i] = in_id;
			}

			reqMap.put("inIdArr", inIdArr);
			outboxlist = inforControlMapper.inforDetailsList(reqMap);
			// 组装返回map
			if (outboxlist != null && outboxlist.size() > 0) {

				for (InforOutbox outbox : outboxlist) {
					List<InforInbox> inforInboxList = outbox.getInboxList();
					for (InforInbox inforInbox : inforInboxList) {

						String reId = inforInbox.getReceiverId();
						List<InforDetail> detailsList = inforInbox.getDetailList();
						Map<String, Object> timeMap = new HashMap<String, Object>();
						timeMap.put("infor_no", outbox.getInforRecord().getInforNo());
						timeMap.put("in_id", inforInbox.getInId());
						timeMap.put("title", outbox.getInforRecord().getTitle());
						timeMap.put("content", outbox.getInforRecord().getContent());
						timeMap.put("receiver_id", inforInbox.getReceiverId());
						timeMap.put("receiver_name", inforInbox.getReceiverName());
						timeMap.put("send_date_time", outbox.getSendDateTime());
						timeMap.put("read_time", "");
						timeMap.put("deal_time", "");
						timeMap.put("reply_time", "");
						timeMap.put("transmit_time", "");
						for (InforDetail d : detailsList) {
							if (d.getCreateId().equals(reId)) {
								if (!"0".equals(d.getStatus())) {
									String timeType = judgeTimeType(d.getStatus());
									timeMap.put(timeType, d.getCreateDateTime());
								}
							}

						}
						timeList.add(timeMap);
					}
				}

			}
		}

		resMap.put("data", timeList);
		resMap.put("count", count);
		return resMap;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getAppControlDetails(Map<String, Object> map) throws Exception {

		PageInit.setPage(map);
		if ("0".equals(map.get("status"))) {
			map.put("deal_status", "0");
		}

		Map<String, Object> resMap = new HashMap<String, Object>();// 接口返回map
		Map<String, Object> dataMap = new HashMap<String, Object>();// 接口返回map的data参数的map
		Map<String, Object> reqMap = new HashMap<String, Object>();// 查询列表请求参数的map
		List<InforOutbox> outboxlist = new ArrayList<InforOutbox>();// 查询返回的list

		// 获取单条讯息的收件id
		List<Map<String, Object>> inIdList = inforControlMapper.singleReceiveGroup(map);
		String flag = "";
		if (inIdList == null || inIdList.size() == 0) {// 如果根据请求的处理状态没有查出结果，就根据空状态去查询该条讯息的标题等详情
			if ("0".equals(map.get("status"))) {
				map.remove("deal_status");
				map.put("status", "");
			}
			inIdList = inforControlMapper.singleReceiveGroup(map);
			flag = "y";
		}
		int[] inIdArr = new int[inIdList.size()];
		for (int i = 0; i < inIdList.size(); i++) {
			int in_id = (int) inIdList.get(i).get("in_id");
			inIdArr[i] = in_id;
		}

		reqMap.put("inIdArr", inIdArr);
		outboxlist = inforControlMapper.inforDetailsList(reqMap);

		// 组装返回map
		List<Map<String, Object>> timeList = new ArrayList<Map<String, Object>>();
		if (outboxlist != null && outboxlist.size() > 0) {
			for (InforOutbox outbox : outboxlist) {
				dataMap.put("infor_no", outbox.getInforRecord().getInforNo());
				dataMap.put("title", outbox.getInforRecord().getTitle());
				dataMap.put("send_date_time", outbox.getSendDateTime());

				StringBuffer receiverNames = new StringBuffer();
				StringBuffer coperNames = new StringBuffer();

				List<InforInbox> inforInboxList = outbox.getInboxList();
				for (InforInbox inforInbox : inforInboxList) {

					if (inforInbox.getReceiverType().equals("0")) {
						receiverNames.append(inforInbox.getReceiverName() + ";");
					} else if (inforInbox.getReceiverType().equals("1")) {
						coperNames.append(inforInbox.getReceiverName() + ";");
					}

					String reId = inforInbox.getReceiverId();
					List<InforDetail> detailsList = inforInbox.getDetailList();
					Map<String, Object> timeMap = new HashMap<String, Object>();
					timeMap.put("receiver_id", inforInbox.getReceiverId());
					timeMap.put("receiver_name", inforInbox.getReceiverName());
					timeMap.put("send_date_time", outbox.getSendDateTime());

					Map<String, Object> conmap = new HashMap<>();
					conmap.put("search", inforInbox.getReceiverId());
					Map<String, Object> result = contactsService.commonEmpSearch(conmap);
					@SuppressWarnings("unchecked")
					List<Map<String, Object>> li = (List<Map<String, Object>>) result.get("data");
					Map<String, Object> data = null;
					if (null != li && li.size() > 0) {
						data = li.get(0);
					}
					if (null != data && data.size() > 0) {
						timeMap.put("emp_code", data.get("emp_code"));
						timeMap.put("emp_head_photo", data.get("emp_head_photo"));
						timeMap.put("org_id", data.get("org_id"));
						timeMap.put("org_name", data.get("org_name_owner"));
					}
					timeMap.put("read_time", "");
					timeMap.put("deal_time", "");
					timeMap.put("reply_time", "");
					timeMap.put("transmit_time", "");

					for (InforDetail d : detailsList) {
						if (d.getCreateId().equals(reId)) {
							if (!"0".equals(d.getStatus())) {
								String timeType = judgeTimeType(d.getStatus());
								timeMap.put(timeType, d.getCreateDateTime());
							}
						}

					}
					timeList.add(timeMap);
				}
				dataMap.put("receiver_names", receiverNames);
				dataMap.put("copyer_names", coperNames);

			}
			if ("".equals(flag)) {// 判断是否组装返回的接收人详情；""代表根据请求的处理状态有接收人信息，else代表是根据空状态查询的；
				dataMap.put("details", timeList);
			} else {
				dataMap.put("details", new ArrayList<Map<String, Object>>());
			}

		}

		// 获取讯息不同处理状态的条数
		long noRead_cout = getStatusCount(map, "0");
		long read_cout = getStatusCount(map, "1");
		long deal_cout = getStatusCount(map, "2");
		long relay_cout = getStatusCount(map, "3");
		long transmit_cout = getStatusCount(map, "4");

		dataMap.put("noRead_cout", noRead_cout);
		dataMap.put("read_cout", read_cout);
		dataMap.put("deal_cout", deal_cout);
		dataMap.put("relay_cout", relay_cout);
		dataMap.put("transmit_cout", transmit_cout);

		resMap.put("data", dataMap);
		return resMap;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getAppDetailsSearch(Map<String, Object> map) throws Exception {

		PageInit.setPage(map);
		if ("0".equals(map.get("status"))) {
			map.put("deal_status", "0");
		}

		Map<String, Object> resMap = new HashMap<String, Object>();// 接口返回map
		Map<String, Object> reqMap = new HashMap<String, Object>();// 查询列表请求参数的map
		List<InforOutbox> outboxlist = new ArrayList<InforOutbox>();// 查询返回的list
		List<Map<String, Object>> timeList = new ArrayList<Map<String, Object>>();// 接口返回map的data参数

		// 获取单条讯息的收件id
		List<Map<String, Object>> inIdList = inforControlMapper.singleReceiveGroup(map);
		if (inIdList != null && inIdList.size() > 0) {
			int[] inIdArr = new int[inIdList.size()];
			for (int i = 0; i < inIdList.size(); i++) {
				int in_id = (int) inIdList.get(i).get("in_id");
				inIdArr[i] = in_id;
			}

			reqMap.put("inIdArr", inIdArr);
			outboxlist = inforControlMapper.inforDetailsList(reqMap);
		}

		// 组装返回map
		if (outboxlist != null && outboxlist.size() > 0) {
			for (InforOutbox outbox : outboxlist) {

				List<InforInbox> inforInboxList = outbox.getInboxList();
				for (InforInbox inforInbox : inforInboxList) {
					if ("0".equals((String) map.get("status"))
							&& ("1".equals(inforInbox.getDealStatus()) || "3".equals(inforInbox.getDealStatus()))) {
						continue;
					}

					String reId = inforInbox.getReceiverId();
					List<InforDetail> detailsList = inforInbox.getDetailList();
					Map<String, Object> timeMap = new HashMap<String, Object>();
					timeMap.put("receiver_id", inforInbox.getReceiverId());
					timeMap.put("receiver_name", inforInbox.getReceiverName());
					timeMap.put("send_date_time", outbox.getSendDateTime());

					Map<String, Object> conmap = new HashMap<>();
					conmap.put("search", inforInbox.getReceiverId());
					Map<String, Object> result = contactsService.commonEmpSearch(conmap);
					@SuppressWarnings("unchecked")
					List<Map<String, Object>> li = (List<Map<String, Object>>) result.get("data");
					Map<String, Object> data = null;
					if (null != li && li.size() > 0) {
						data = li.get(0);
					}
					if (null != data && data.size() > 0) {
						timeMap.put("emp_code", data.get("emp_code"));
						timeMap.put("emp_head_photo", data.get("emp_head_photo"));
						timeMap.put("org_id", data.get("org_id"));
						timeMap.put("org_name", data.get("org_name_owner"));
					}
					timeMap.put("read_time", "");
					timeMap.put("deal_time", "");
					timeMap.put("reply_time", "");
					timeMap.put("transmit_time", "");

					for (InforDetail d : detailsList) {
						if (d.getCreateId().equals(reId)) {
							if (!"0".equals(d.getStatus())) {
								String timeType = judgeTimeType(d.getStatus());
								timeMap.put(timeType, d.getCreateDateTime());
							}
						}

					}
					timeList.add(timeMap);
				}
			}

		}

		// 获取请求的处理状态结果总数
		long count = 0;
		Map<String, Object> countMap = inforControlMapper.singleReceiveCount(map);
		if (countMap != null) {
			count = (long) countMap.get("count");
		}

		resMap.put("data", timeList);
		resMap.put("count", count);
		return resMap;
	}

	private long getStatusCount(Map<String, Object> map, String status) {
		long count = 0;
		map.put("status", status);
		if (status.equals("0")) {
			map.put("deal_status", status);
		} else {
			map.remove("deal_status");
		}
		Map<String, Object> countMap = inforControlMapper.singleReceiveCount(map);
		if (countMap != null) {
			count = (long) countMap.get("count");
		}

		return count;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getAppWithEmpList(Map<String, Object> map) throws Exception {

		PageInit.setPage(map);
		if ("0".equals(map.get("status"))) {
			map.put("deal_status", "0");
		}

		Map<String, Object> resMap = new HashMap<String, Object>();// 接口返回map
		Map<String, Object> dataMap = new HashMap<String, Object>();// 接口返回map的data参数的map
		Map<String, Object> reqMap = new HashMap<String, Object>();// 查询列表请求参数的map
		List<InforOutbox> outboxlist = new ArrayList<InforOutbox>();// 查询返回的list

		// 获取单条讯息的收件id
		List<Map<String, Object>> inIdList = inforControlMapper.singleReceiveGroup(map);
		if (inIdList != null && inIdList.size() > 0) {
			String[] inIdArr = new String[inIdList.size()];
			for (int i = 0; i < inIdList.size(); i++) {
				String in_id = inIdList.get(i).get("in_id").toString();
				inIdArr[i] = in_id;
			}

			reqMap.put("inIdArr", inIdArr);
			outboxlist = inforControlMapper.inforDetailsList(reqMap);

			// 组装返回map
			List<Map<String, Object>> timeList = new ArrayList<Map<String, Object>>();
			if (outboxlist != null && outboxlist.size() > 0) {
				for (InforOutbox outbox : outboxlist) {

					List<InforInbox> inforInboxList = outbox.getInboxList();
					for (InforInbox inforInbox : inforInboxList) {
						Map<String, Object> timeMap = new HashMap<String, Object>();

						timeMap.put("infor_no", outbox.getInforRecord().getInforNo());
						timeMap.put("title", outbox.getInforRecord().getTitle());
						timeMap.put("content", outbox.getInforRecord().getContent());
						timeMap.put("send_date_time", outbox.getSendDateTime());
						timeMap.put("in_id", inforInbox.getInId());

						String reId = inforInbox.getReceiverId();
						List<InforDetail> detailsList = inforInbox.getDetailList();

						timeMap.put("receiver_id", inforInbox.getReceiverId());
						timeMap.put("receiver_name", inforInbox.getReceiverName());
						timeMap.put("send_date_time", outbox.getSendDateTime());
						timeMap.put("read_time", "");
						timeMap.put("deal_time", "");
						timeMap.put("reply_time", "");
						timeMap.put("transmit_time", "");

						for (InforDetail d : detailsList) {
							if (d.getCreateId().equals(reId)) {
								if (!"0".equals(d.getStatus())) {
									String timeType = judgeTimeType(d.getStatus());
									timeMap.put(timeType, d.getCreateDateTime());
								}
							}

						}
						timeList.add(timeMap);
					}
				}
				dataMap.put("details", timeList);

			}
		} else {
			dataMap.put("details", new ArrayList<Map<String, Object>>());
		}

		// 获取员工基本信息
		Map<String, Object> conmap = new HashMap<>();
		conmap.put("search", map.get("receiver_id"));
		Map<String, Object> result = contactsService.commonEmpSearch(conmap);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> li = (List<Map<String, Object>>) result.get("data");
		Map<String, Object> data = null;
		if (null != li && li.size() > 0) {
			data = li.get(0);
		}
		if (null != data && data.size() > 0) {
			dataMap.put("emp_code", data.get("emp_code"));
			dataMap.put("emp_head_photo", data.get("emp_head_photo"));
			dataMap.put("org_id", data.get("org_id"));
			dataMap.put("org_name", data.get("org_name_owner"));
		}

		// 获取讯息不同处理状态的条数
		long noRead_cout = getStatusCount(map, "0");
		long read_cout = getStatusCount(map, "1");
		long deal_cout = getStatusCount(map, "2");
		long relay_cout = getStatusCount(map, "3");
		long transmit_cout = getStatusCount(map, "4");

		dataMap.put("noRead_cout", noRead_cout);
		dataMap.put("read_cout", read_cout);
		dataMap.put("deal_cout", deal_cout);
		dataMap.put("relay_cout", relay_cout);
		dataMap.put("transmit_cout", transmit_cout);

		resMap.put("data", dataMap);
		return resMap;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getInforEmpSearch(Map<String, Object> map) throws Exception {

		PageInit.setPage(map);
		if ("0".equals(map.get("status"))) {
			map.put("deal_status", "0");
		}

		Map<String, Object> resMap = new HashMap<String, Object>();// 接口返回map
		Map<String, Object> reqMap = new HashMap<String, Object>();// 查询列表请求参数的map
		List<InforOutbox> outboxlist = new ArrayList<InforOutbox>();// 查询返回的list
		List<Map<String, Object>> timeList = new ArrayList<Map<String, Object>>();

		// 获取单条讯息的收件id
		List<Map<String, Object>> inIdList = inforControlMapper.singleReceiveGroup(map);
		if (inIdList != null && inIdList.size() > 0) {
			String[] inIdArr = new String[inIdList.size()];
			for (int i = 0; i < inIdList.size(); i++) {
				String in_id = inIdList.get(i).get("in_id").toString();
				inIdArr[i] = in_id;
			}

			reqMap.put("inIdArr", inIdArr);
			outboxlist = inforControlMapper.inforDetailsList(reqMap);

			// 组装返回map
			if (outboxlist != null && outboxlist.size() > 0) {
				for (InforOutbox outbox : outboxlist) {

					List<InforInbox> inforInboxList = outbox.getInboxList();
					for (InforInbox inforInbox : inforInboxList) {
						Map<String, Object> timeMap = new HashMap<String, Object>();

						timeMap.put("infor_no", outbox.getInforRecord().getInforNo());
						timeMap.put("title", outbox.getInforRecord().getTitle());
						timeMap.put("content", outbox.getInforRecord().getContent());
						timeMap.put("send_date_time", outbox.getSendDateTime());
						timeMap.put("in_id", inforInbox.getInId());

						String reId = inforInbox.getReceiverId();
						List<InforDetail> detailsList = inforInbox.getDetailList();

						timeMap.put("receiver_id", inforInbox.getReceiverId());
						timeMap.put("receiver_name", inforInbox.getReceiverName());
						timeMap.put("send_date_time", outbox.getSendDateTime());
						timeMap.put("read_time", "");
						timeMap.put("deal_time", "");
						timeMap.put("reply_time", "");
						timeMap.put("transmit_time", "");

						for (InforDetail d : detailsList) {
							if (d.getCreateId().equals(reId)) {
								if (!"0".equals(d.getStatus())) {
									String timeType = judgeTimeType(d.getStatus());
									timeMap.put(timeType, d.getCreateDateTime());
								}
							}

						}
						timeList.add(timeMap);
					}
				}
			}
		}

		// 获取请求的处理状态结果总数
		long count = 0;
		Map<String, Object> countMap = inforControlMapper.singleReceiveCount(map);
		if (countMap != null) {
			count = (long) countMap.get("count");
		}

		resMap.put("data", timeList);
		resMap.put("count", count);
		return resMap;
	}

}
