package com.zrt.infor.service.commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.AppException;
import com.zrt.commons.PageInit;
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.infor.domain.InforAccessory;
import com.zrt.infor.domain.InforInbox;
import com.zrt.infor.domain.InforOutbox;
import com.zrt.infor.domain.InforRelevance;
import com.zrt.infor.mapper.inforCategory.InforCategoryMapper;
import com.zrt.infor.mapper.inforCommons.InforCommonsMapper;
import com.zrt.infor.mapper.inforrecord.InforrecordMapper;
import com.zrt.infor.service.contacts.ContactsService;
import com.zrt.infor.service.serial.SerialService;
import com.zrt.mybatis.domain.PlatInforConcern;
import com.zrt.mybatis.domain.PlatInforConcernExample;
import com.zrt.mybatis.domain.PlatInforDetail;
import com.zrt.mybatis.domain.PlatInforDetailExample;
import com.zrt.mybatis.domain.PlatInforDic;
import com.zrt.mybatis.domain.PlatInforDicExample;
import com.zrt.mybatis.domain.PlatInforInbox;
import com.zrt.mybatis.domain.PlatInforInboxExample;
import com.zrt.mybatis.domain.PlatInforInboxExample.Criteria;
import com.zrt.mybatis.domain.PlatInforOutbox;
import com.zrt.mybatis.domain.PlatInforOutboxExample;
import com.zrt.mybatis.mapper.PlatInforConcernMapper;
import com.zrt.mybatis.mapper.PlatInforDetailMapper;
import com.zrt.mybatis.mapper.PlatInforDicMapper;
import com.zrt.mybatis.mapper.PlatInforInboxMapper;
import com.zrt.mybatis.mapper.PlatInforOutboxMapper;

/**
 * Created by msKui on 2017/3/21.
 */
@Service
public class InforCommonsServiceImpl implements InforCommonsService {
	@Autowired
	private InforrecordMapper inforrecordMapper;
	@Autowired
	private PlatInforInboxMapper platInforInboxMapper;
	@Autowired
	private PlatInforOutboxMapper platInforOutboxMapper;
	@Autowired
	private PlatInforConcernMapper platInforConcernMapper;
	@Autowired
	private PlatInforDicMapper platInforDicMapper;
	@Autowired
	private InforCommonsMapper inforCommonsMapper;
	@Autowired
	private PlatInforDetailMapper platInforDetailMapper;
	@Autowired
	private ContactsService contactsService;
	@Autowired
	private SerialService serialService;
	@Autowired
	private InforCategoryMapper inforCategoryMapper;

	/**
	 * 讯息详情
	 */
	public List<Map<String, Object>> getInfoDetail(Map<String, Object> map) throws Exception {

		// 是否已经关注此讯息
		String careFlag = "0";// 0:未关注；1：已关注
		int careCount = inforrecordMapper.getCareFlag(map);
		if (careCount > 0) {
			careFlag = "1";
		}
		// 查询该讯息所有的父节点讯息
		Map<String, Object> parentNoMap = inforrecordMapper.getParent(map);
		String parentNoStr = (String) parentNoMap.get("parentNoStr");
		String[] parentNoArr = parentNoStr.split(",");
		Map<String, Object> parentNoArrMap = new HashMap<String, Object>();
		parentNoArrMap.put("parentNoArr", parentNoArr);
		List<InforOutbox> listDomain = inforrecordMapper.inforDetailList(parentNoArrMap);
		List<Map<String, Object>> listMap = new ArrayList<>();
		for (InforOutbox inforOutbox : listDomain) {
			StringBuffer receiverNames = new StringBuffer();
			StringBuffer coperNames = new StringBuffer();
			String dealStatus = "";

			StringBuffer receiverIds = new StringBuffer();
			StringBuffer coperIds = new StringBuffer();
			List<InforInbox> inforInboxList = inforOutbox.getInboxList();
			List<Map<String, Object>> receiverList = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> coperList = new ArrayList<Map<String, Object>>();

			Collections.sort(inforInboxList, new Comparator<InforInbox>() {
				public int compare(InforInbox box1, InforInbox box2) {
					return box1.getEmpOrder() - box2.getEmpOrder();
				}
			});
			for (InforInbox inforInbox : inforInboxList) {
				if ("0".equals(inforInbox.getReceiverType())) {// 收件人
					receiverNames.append(inforInbox.getReceiverName() + ";");
					receiverIds.append(inforInbox.getReceiverId() + ";");
					Map<String, Object> inMap = new HashMap<>();
					inMap.put("receiver_id", inforInbox.getReceiverId());// 收件人id
					inMap.put("receiver_name", inforInbox.getReceiverName());// 收件人名称
					receiverList.add(inMap);
				} else if ("1".equals(inforInbox.getReceiverType())) {
					coperNames.append(inforInbox.getReceiverName() + ";");
					coperIds.append(inforInbox.getReceiverId() + ";");
					Map<String, Object> inMap = new HashMap<>();
					inMap.put("receiver_id", inforInbox.getReceiverId());// 收件人id
					inMap.put("receiver_name", inforInbox.getReceiverName());// 收件人名称
					coperList.add(inMap);
				}
				if (((String) map.get("emp_id")).equals(inforInbox.getReceiverId())) {
					dealStatus = inforInbox.getDealStatus();
				}
			}

			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("infor_no", inforOutbox.getInforNo());// 讯息编号
			dataMap.put("title", inforOutbox.getInforRecord().getTitle());// 讯息标题
			dataMap.put("content", inforOutbox.getInforRecord().getContent());// 讯息内容
			dataMap.put("sender_name", inforOutbox.getSenderName());// 发送人姓名
			dataMap.put("org_name", inforOutbox.getOrgName());// 发送部门
			dataMap.put("create_date_time", inforOutbox.getCreateDateTime());// 发送人姓名
			dataMap.put("trans_type", inforOutbox.getTransType());// 发送类型
			dataMap.put("receiver_names", receiverNames);// 接收人姓名
			dataMap.put("coper_names", coperNames);// 抄送人姓名
			dataMap.put("receiver_ids", receiverIds);// 接收人ids
			dataMap.put("coper_ids", coperIds);// 抄送人ids
			dataMap.put("sender_id", inforOutbox.getSenderId());// 发送人id
			dataMap.put("receiverList", receiverList);// 接收人list
			dataMap.put("coperList", coperList);// 抄送人list
			dataMap.put("deal_status", dealStatus);
			// 讯息关联list
			List<InforRelevance> relevanceList = inforOutbox.getRelevanceList();
			List<Map<String, Object>> relList = MapEntityConverter.getMapFromList(
					new String[] { "rel_id", "rel_name", "rel_type" }, relevanceList, InforRelevance.class);
			dataMap.put("rel", relList);

			// 关联附件list
			List<InforAccessory> accessList = inforOutbox.getAccessoryList();
			List<Map<String, Object>> accList = MapEntityConverter.getMapFromList(
					new String[] { "acc_id", "acc_address", "acc_name", "acc_type", "node_id" }, accessList,
					InforAccessory.class);
			dataMap.put("acc", accList);
			dataMap.put("careFlag", careFlag);
			listMap.add(dataMap);

		}
		return listMap;
	}

	/**
	 * 关注讯息详情
	 */
	@Override
	public List<Map<String, Object>> getInfoCareDetail(Map<String, Object> map) throws Exception {

		// 查询该讯息所有的父节点讯息

		Map<String, Object> parentNoMap = inforrecordMapper.getParent(map);
		String parentNoStr = (String) parentNoMap.get("parentNoStr");
		String[] parentNoArr = parentNoStr.split(",");
		Map<String, Object> parentNoArrMap = new HashMap<String, Object>();
		parentNoArrMap.put("parentNoArr", parentNoArr);
		List<InforOutbox> listDomain = inforrecordMapper.inforDetailList(parentNoArrMap);
		// 查询该讯息所有子节点讯息
		Map<String, Object> childNoMap = inforrecordMapper.getChild(map);
		String childNoStr = (String) childNoMap.get("childNoStr");
		String[] childNoArr = childNoStr.split(",");
		Map<String, Object> childNoArrMap = new HashMap<String, Object>();
		childNoArrMap.put("childNoArr", childNoArr);
		List<InforOutbox> listChi = inforrecordMapper.inforCareDetailList(childNoArrMap);
		if (listChi != null && listChi.size() > 0) {
			for (int i = 0; i < listDomain.size(); i++) {
				for (int j = 0; j < listChi.size(); j++) {
					if (listDomain.get(i).getInforNo().equals(listChi.get(j).getInforNo())) {
						listChi.remove(j);
					}
				}
			}
		}
		listChi.addAll(listDomain);
		List<Map<String, Object>> listMap = new ArrayList<>();
		for (InforOutbox inforOutbox : listChi) {
			StringBuffer receiverNames = new StringBuffer();
			StringBuffer coperNames = new StringBuffer();
			String dealStatus = "";

			StringBuffer receiverIds = new StringBuffer();
			StringBuffer coperIds = new StringBuffer();
			List<InforInbox> inforInboxList = inforOutbox.getInboxList();
			List<Map<String, Object>> receiverList = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> coperList = new ArrayList<Map<String, Object>>();

			Collections.sort(inforInboxList, new Comparator<InforInbox>() {
				public int compare(InforInbox box1, InforInbox box2) {
					return box1.getEmpOrder() - box2.getEmpOrder();
				}
			});
			for (InforInbox inforInbox : inforInboxList) {
				if ("0".equals(inforInbox.getReceiverType())) {// 收件人
					receiverNames.append(inforInbox.getReceiverName() + ";");
					receiverIds.append(inforInbox.getReceiverId() + ";");
					Map<String, Object> inMap = new HashMap<>();
					inMap.put("receiver_id", inforInbox.getReceiverId());// 收件人id
					inMap.put("receiver_name", inforInbox.getReceiverName());// 收件人名称
					receiverList.add(inMap);
				} else if ("1".equals(inforInbox.getReceiverType())) {
					coperNames.append(inforInbox.getReceiverName() + ";");
					coperIds.append(inforInbox.getReceiverId() + ";");
					Map<String, Object> inMap = new HashMap<>();
					inMap.put("receiver_id", inforInbox.getReceiverId());// 收件人id
					inMap.put("receiver_name", inforInbox.getReceiverName());// 收件人名称
					coperList.add(inMap);
				}
				if (((String) map.get("emp_id")).equals(inforInbox.getReceiverId())) {
					dealStatus = inforInbox.getDealStatus();
				}
			}

			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("infor_no", inforOutbox.getInforNo());// 讯息编号
			dataMap.put("title", inforOutbox.getInforRecord().getTitle());// 讯息标题
			dataMap.put("content", inforOutbox.getInforRecord().getContent());// 讯息内容
			dataMap.put("sender_name", inforOutbox.getSenderName());// 发送人姓名
			dataMap.put("org_name", inforOutbox.getOrgName());// 发送部门
			dataMap.put("create_date_time", inforOutbox.getCreateDateTime());// 发送人姓名
			dataMap.put("receiver_names", receiverNames);// 接收人姓名
			dataMap.put("coper_names", coperNames);// 抄送人姓名
			dataMap.put("receiver_ids", receiverIds);// 接收人ids
			dataMap.put("coper_ids", coperIds);// 抄送人ids
			dataMap.put("sender_id", inforOutbox.getSenderId());// 发送人id
			dataMap.put("receiverList", receiverList);// 接收人list
			dataMap.put("coperList", coperList);// 抄送人list
			dataMap.put("deal_status", dealStatus);
			// 讯息关联list
			List<InforRelevance> relevanceList = inforOutbox.getRelevanceList();
			List<Map<String, Object>> relList = MapEntityConverter.getMapFromList(
					new String[] { "rel_id", "rel_name", "rel_type" }, relevanceList, InforRelevance.class);
			dataMap.put("rel", relList);

			// 关联附件list
			List<InforAccessory> accessList = inforOutbox.getAccessoryList();
			List<Map<String, Object>> accList = MapEntityConverter.getMapFromList(
					new String[] { "acc_id", "acc_name", "acc_type" }, accessList, InforAccessory.class);
			dataMap.put("acc", accList);
			listMap.add(dataMap);
		}
		return listMap;

	}

	/**
	 * 讯息办结、已阅
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int changeInforStatus(Map<String, Object> map, String str) throws Exception {

		String empId = (String) map.get("emp_id");
		PlatInforInbox platInforInbox = new PlatInforInbox();
		PlatInforInboxExample platInforInboxExample = new PlatInforInboxExample();
		Criteria criteria = platInforInboxExample.createCriteria();

		if ("deal".equals(str)) {
			platInforInbox.setDealStatus("3");
		} else if ("read".equals(str)) {
			platInforInbox.setDealStatus("1");
		} else if ("app".equals(str)) {// APP已阅，已办
			platInforInbox.setDealStatus(map.get("deal_status").toString());
		}
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> listParam = (List<Map<String, Object>>) map.get("param");
		List<String> list = new ArrayList<String>();
		for (Map<String, Object> mm : listParam) {
			String inforNo = (String) mm.get("infor_no");
			if (StringUtils.isNotBlank(inforNo)) {
				list.add(inforNo);
				PlatInforInboxExample example = new PlatInforInboxExample();
				example.createCriteria().andInforNoEqualTo(inforNo).andReceiverIdEqualTo(empId);
				if (platInforInboxMapper.selectByExample(example).size() > 0) {
					PlatInforInbox inbox = platInforInboxMapper.selectByExample(example).get(0);
					if ("3".equals(inbox.getDealStatus()) && "1".equals(platInforInbox.getDealStatus())) {// 如果已办状态下再点已阅还是让数据保留已阅状态
						platInforInbox.setDealStatus("3");
					}
				}
			}

		}
		criteria.andInforNoIn(list);
		criteria.andReceiverIdEqualTo(empId);
		int i = platInforInboxMapper.updateByExampleSelective(platInforInbox, platInforInboxExample);

		if (i > 0) {
			PlatInforInboxExample example = new PlatInforInboxExample();
			Criteria criteria1 = example.createCriteria();
			criteria1.andInforNoIn(list);
			criteria1.andReceiverIdEqualTo(map.get("emp_id").toString());
			List<PlatInforInbox> platInforInboxList = platInforInboxMapper.selectByExample(example);
			int inId = 0;
			if (platInforInboxList != null && platInforInboxList.size() > 0) {
				for (PlatInforInbox inbox : platInforInboxList) {
					inId = inbox.getInId();
					Map<String, Object> detailsMap = new HashMap<String, Object>();
					detailsMap.put("in_id", inId);
					detailsMap.put("create_id", map.get("emp_id"));
					if ("deal".equals(str)) {
						detailsMap.put("status", "1");
						addInforStatus(detailsMap);
						detailsMap.put("status", "2");
					} else if ("read".equals(str)) {
						detailsMap.put("status", "1");
					} else if ("app".equals(str)) {// APP已阅，已办
						String status = map.get("deal_status").toString();
						if (status.equals("1")) {
							detailsMap.put("status", "1");
						} else if (status.equals("3")) {
							detailsMap.put("status", "1");
							addInforStatus(detailsMap);
							detailsMap.put("status", "2");
						} else if (status.equals("0")) {
							detailsMap.put("status", "0");
						}
					}
					addInforStatus(detailsMap);

				}
			}

		}
		return i;
	}

	/**
	 * PC端隐藏讯息
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int inforHidden(Map<String, Object> map) throws Exception {

		int i = 0;
		String sendFlag = (String) map.get("send_flag");
		if ("0".equals(sendFlag)) {
			PlatInforInbox platInforInbox = new PlatInforInbox();
			platInforInbox.setIsShow("0");
			PlatInforInboxExample platInforInboxExample = new PlatInforInboxExample();
			Criteria criteria = platInforInboxExample.createCriteria();
			criteria.andInforNoEqualTo((String) map.get("infor_no"));
			criteria.andReceiverIdEqualTo(map.get("emp_id").toString());
			i = platInforInboxMapper.updateByExampleSelective(platInforInbox, platInforInboxExample);
		} else if ("1".equals(sendFlag)) {
			PlatInforOutbox platInforOutbox = new PlatInforOutbox();
			platInforOutbox.setIsShow("0");
			PlatInforOutboxExample platInforOutboxExample = new PlatInforOutboxExample();
			com.zrt.mybatis.domain.PlatInforOutboxExample.Criteria criteria = platInforOutboxExample.createCriteria();
			criteria.andInforNoEqualTo((String) map.get("infor_no"));
			i = platInforOutboxMapper.updateByExampleSelective(platInforOutbox, platInforOutboxExample);
		}

		return i;
	}

	/**
	 * PC端取消隐藏讯息
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int inforCancelHidden(Map<String, Object> map) throws Exception {

		int i = 0;
		String sendFlag = (String) map.get("send_flag");
		if ("0".equals(sendFlag)) {
			PlatInforInbox platInforInbox = new PlatInforInbox();
			platInforInbox.setIsShow("1");
			PlatInforInboxExample platInforInboxExample = new PlatInforInboxExample();
			Criteria criteria = platInforInboxExample.createCriteria();
			criteria.andInforNoEqualTo((String) map.get("infor_no"));
			criteria.andReceiverIdEqualTo(map.get("emp_id").toString());
			i = platInforInboxMapper.updateByExampleSelective(platInforInbox, platInforInboxExample);
		} else if ("1".equals(sendFlag)) {
			PlatInforOutbox platInforOutbox = new PlatInforOutbox();
			platInforOutbox.setIsShow("1");
			PlatInforOutboxExample platInforOutboxExample = new PlatInforOutboxExample();
			com.zrt.mybatis.domain.PlatInforOutboxExample.Criteria criteria = platInforOutboxExample.createCriteria();
			criteria.andInforNoEqualTo((String) map.get("infor_no"));
			i = platInforOutboxMapper.updateByExampleSelective(platInforOutbox, platInforOutboxExample);
		}

		return i;
	}

	/**
	 * 添加关注
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int concernInfor(Map<String, Object> map, String dicId, String empID) throws Exception {

		if (StringUtils.isBlank(dicId)) {
			throw new AppException("该先添加关注分类!");
		}

		PlatInforConcernExample example = new PlatInforConcernExample();
		com.zrt.mybatis.domain.PlatInforConcernExample.Criteria criteria = example.createCriteria();
		criteria.andInforNoEqualTo(map.get("infor_no").toString());
		criteria.andEmpIdEqualTo(empID);
		int count = platInforConcernMapper.countByExample(example);
		if (count < 1) {
			PlatInforConcern platInforConcern = new PlatInforConcern();
			platInforConcern.setConcernId(serialService.getUUID());
			platInforConcern.setCreateDateTime(DateUtil.getCurrentDateTime());
			platInforConcern.setEmpId(empID);
			platInforConcern.setConcernType(dicId);
			platInforConcern.setInforNo(map.get("infor_no").toString());
			return platInforConcernMapper.insert(platInforConcern);
		}
		return 1;
	}

	/**
	 * 取消关注
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int concernInforCancel(Map<String, Object> map) throws Exception {
		PlatInforConcernExample example = new PlatInforConcernExample();
		com.zrt.mybatis.domain.PlatInforConcernExample.Criteria criteria = example.createCriteria();
		criteria.andInforNoEqualTo((String) map.get("infor_no"));
		return platInforConcernMapper.deleteByExample(example);
	}

	/**
	 * 新增关注分类
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int dicAdd(Map<String, Object> map) throws Exception {

		PlatInforDicExample example = new PlatInforDicExample();
		com.zrt.mybatis.domain.PlatInforDicExample.Criteria criteria = example.createCriteria();
		criteria.andDicNameEqualTo(map.get("dic_name").toString());
		criteria.andEmpIdEqualTo(map.get("emp_id").toString());
		int count = platInforDicMapper.countByExample(example);
		if (count > 0) {
			throw new AppException("该分类已经存在!");
		} else {
			PlatInforDic platInforDic = new PlatInforDic();
			platInforDic.setDicId(serialService.getUUID());
			platInforDic.setCreateDateTime(DateUtil.getCurrentDateTime());
			platInforDic.setEmpId(map.get("emp_id").toString());
			platInforDic.setDicName(map.get("dic_name").toString());
			platInforDic.setCreateEmpId(map.get("emp_id").toString());
			Map<String, Object> conmap = new HashMap<>();
			conmap.put("search", map.get("emp_id"));
			Map<String, Object> result = contactsService.commonEmpSearch(conmap);
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> li = (List<Map<String, Object>>) result.get("data");
			Map<String, Object> data = null;
			if (null != li && li.size() > 0) {
				data = li.get(0);
			}
			if (null != data && data.size() > 0) {
				platInforDic.setCreateEmpName(data.get("emp_name") == null ? null : data.get("emp_name").toString());
			}
			platInforDic.setDicCode(serialService.getSerialNumberFromDB("plat_infor_dic_code"));
			return platInforDicMapper.insert(platInforDic);
		}
	}

	/**
	 * 查询关注分类
	 */
	@Override
	public List<Map<String, Object>> dicList(Map<String, Object> map) throws Exception {
		PlatInforDicExample example = new PlatInforDicExample();
		com.zrt.mybatis.domain.PlatInforDicExample.Criteria criteria = example.createCriteria();
		criteria.andEmpIdEqualTo(map.get("emp_id").toString());
		List<PlatInforDic> list = platInforDicMapper.selectByExample(example);
		List<Map<String, Object>> listMap = null;
		try {
			listMap = convertinforDomain(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("转换为Map时出现异常");
		}
		return listMap;
	}

	public List<Map<String, Object>> convertinforDomain(List<PlatInforDic> listDomain)
			throws ReflectiveOperationException {
		List<Map<String, Object>> listMap = new ArrayList<>();
		for (PlatInforDic platInforDic : listDomain) {
			Map<String, Object> map = MapEntityConverter
					.getMapFromEntity(new String[] { "dic_id", "emp_id", "dic_code", "dic_name" }, platInforDic);

			listMap.add(map);
		}
		return listMap;
	}

	/**
	 * app端隐藏、显示讯息
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int inforShowHid(Map<String, Object> map) throws Exception {

		int i = 0;

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
		Map<String, Object> data = null;
		if (list != null && list.size() > 0) {
			for (int m = 0; m < list.size(); m++) {
				data = list.get(m);
				String sendFlag = data.get("send_flag").toString();
				if ("0".equals(sendFlag)) {
					PlatInforInbox platInforInbox = new PlatInforInbox();
					PlatInforInboxExample platInforInboxExample = new PlatInforInboxExample();
					Criteria criteria = platInforInboxExample.createCriteria();
					criteria.andInforNoEqualTo((String) data.get("infor_no"));
					criteria.andReceiverIdEqualTo(map.get("emp_id").toString());
					platInforInbox.setIsShow(map.get("is_show").toString());
					i = platInforInboxMapper.updateByExampleSelective(platInforInbox, platInforInboxExample);
				} else if ("1".equals(sendFlag)) {
					PlatInforOutbox platInforOutbox = new PlatInforOutbox();
					PlatInforOutboxExample platInforOutboxExample = new PlatInforOutboxExample();
					com.zrt.mybatis.domain.PlatInforOutboxExample.Criteria criteria = platInforOutboxExample
							.createCriteria();
					criteria.andInforNoEqualTo((String) data.get("infor_no"));
					platInforOutbox.setIsShow(map.get("is_show").toString());
					i = platInforOutboxMapper.updateByExampleSelective(platInforOutbox, platInforOutboxExample);
				}
			}
		}

		return i;
	}

	/**
	 * app端删除讯息
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int inforDelete(Map<String, Object> map) throws Exception {

		int i = 0;

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
		Map<String, Object> data = null;
		if (list != null && list.size() > 0) {
			for (int m = 0; m < list.size(); m++) {
				data = list.get(m);
				String sendFlag = data.get("send_flag").toString();
			}
		}

		return i;
	}

	/**
	 * 撤销讯息
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int inforCancel(Map<String, Object> map) throws Exception {

		int i = 0;
		boolean f = true;
		List<Map<String, Object>> dealStatusMap = inforrecordMapper.inforDealStatus(map);
		if (dealStatusMap != null && dealStatusMap.size() > 0) {
			for (Map<String, Object> dealmap : dealStatusMap) {
				if (!dealmap.get("deal_status").toString().equals("0")) {
					f = false;
					throw new AppException("该讯息无法撤销！");
				}
			}
		}
		if (f) {
			PlatInforOutbox platInforOutbox = new PlatInforOutbox();
			platInforOutbox.setSendStatus("0");
			PlatInforOutboxExample platInforOutboxExample = new PlatInforOutboxExample();
			com.zrt.mybatis.domain.PlatInforOutboxExample.Criteria criteria = platInforOutboxExample.createCriteria();
			criteria.andInforNoEqualTo((String) map.get("infor_no"));
			i = platInforOutboxMapper.updateByExampleSelective(platInforOutbox, platInforOutboxExample);

			PlatInforInbox platInforInbox = new PlatInforInbox();
			platInforInbox.setDealStatus("4");
			PlatInforInboxExample platInforInboxExample = new PlatInforInboxExample();
			platInforInboxExample.createCriteria().andInforNoEqualTo((String) map.get("infor_no"));
			platInforInboxMapper.updateByExampleSelective(platInforInbox, platInforInboxExample);

		} else {
			i = 99;
		}
		return i;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> appDicAdd(Map<String, Object> map) throws Exception {
		PlatInforDicExample example = new PlatInforDicExample();
		com.zrt.mybatis.domain.PlatInforDicExample.Criteria criteria = example.createCriteria();
		criteria.andDicNameEqualTo(map.get("dic_name").toString());
		criteria.andEmpIdEqualTo(map.get("emp_id").toString());
		int count = platInforDicMapper.countByExample(example);
		if (count > 0) {
			throw new AppException("该分类已经存在!");
		} else {
			PlatInforDic platInforDic = new PlatInforDic();
			platInforDic.setDicId(serialService.getUUID());
			platInforDic.setCreateDateTime(DateUtil.getCurrentDateTime());
			platInforDic.setEmpId(map.get("emp_id").toString());
			platInforDic.setDicName(map.get("dic_name").toString());
			platInforDic.setCreateEmpId(map.get("emp_id").toString());
			Map<String, Object> conmap = new HashMap<>();
			conmap.put("search", map.get("emp_id"));
			Map<String, Object> result = contactsService.commonEmpSearch(conmap);
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> li = (List<Map<String, Object>>) result.get("data");
			Map<String, Object> data = null;
			if (null != li && li.size() > 0) {
				data = li.get(0);
			}
			if (null != data && data.size() > 0) {
				platInforDic.setCreateEmpName(data.get("emp_name") == null ? null : data.get("emp_name").toString());
			}
			platInforDic.setDicCode(serialService.getSerialNumberFromDB("plat_infor_dic_code"));
			platInforDicMapper.insert(platInforDic);

			Map<String, Object> dicIdMap = new HashMap<String, Object>();
			dicIdMap.put("dicId", platInforDic.getDicId());
			dicIdMap.put("dicName", platInforDic.getDicName());
			return dicIdMap;
		}
	}

	/**
	 * 添加讯息处理状态
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int addInforStatus(Map<String, Object> map) throws Exception {

		PlatInforDetailExample example = new PlatInforDetailExample();
		com.zrt.mybatis.domain.PlatInforDetailExample.Criteria criteria = example.createCriteria();
		criteria.andInIdEqualTo((int) map.get("in_id"));
		criteria.andStatusEqualTo((String) map.get("status"));
		int count = platInforDetailMapper.countByExample(example);
		if (count > 0) {
			return 1;
		} else {
			PlatInforDetail platInforDetail = new PlatInforDetail();
			platInforDetail.setInId((int) map.get("in_id"));
			platInforDetail.setStatus(map.get("status").toString());// 已阅：0；已办：1；回复：2；转发：3；
			platInforDetail.setCreateId(map.get("create_id").toString());
			platInforDetail.setCreateDateTime(DateUtil.getCurrentDateTime());
			return platInforDetailMapper.insert(platInforDetail);
		}
	}

	@Override
	public Map<String, Object> getInforCount(Map<String, Object> map) throws Exception {

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("inner_count", 0);
		resMap.put("flow_count", 0);
		resMap.put("doc_count", 0);
		resMap.put("pub_count", 0);
		resMap.put("ask_count", 0);
		resMap.put("day_count", 0);

		List<Map<String, Object>> categoryList = inforCommonsMapper.inforCountList(map);
		if (categoryList != null && categoryList.size() > 0) {
			for (Map<String, Object> countMap : categoryList) {
				if (countMap.get("category").equals("innerInfor")) {
					resMap.put("inner_count", countMap.get("count"));
				} else if (countMap.get("category").equals("flowInfor")) {
					resMap.put("flow_count", countMap.get("count"));
				} else if (countMap.get("category").equals("docInfor")) {
					resMap.put("doc_count", countMap.get("count"));
				} else if (countMap.get("category").equals("pubInfor")) {
					resMap.put("pub_count", countMap.get("count"));
				} else if (countMap.get("category").equals("askInfor")) {
					resMap.put("ask_count", countMap.get("count"));
				} else if (countMap.get("category").equals("dayInfor")) {
					resMap.put("day_count", countMap.get("count"));
				}
			}
		}

		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);

		List<Map<String, Object>> dataList = inforCategoryMapper.inforCategoryCareAllList(map);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);
		resMap.put("care_count", pageInfo.getTotal());

		return resMap;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void flowInforRead(Map<String, Object> map) throws Exception {

		String receverId = (String) map.get("recever_id");
		List<Map<String, Object>> noList = inforCommonsMapper.getFlowInfor(map);
		if (noList != null && noList.size() > 0) {
			for (Map<String, Object> noMap : noList) {
				String inforNo = (String) noMap.get("infor_no");
				PlatInforInboxExample example = new PlatInforInboxExample();
				example.createCriteria().andInforNoEqualTo(inforNo);
				List<PlatInforInbox> inboxList = platInforInboxMapper.selectByExample(example);
				if (inboxList != null && inboxList.size() > 0) {
					for (PlatInforInbox inbox : inboxList) {
						String empId = inbox.getReceiverId();
						if (empId.equals(receverId) || StringUtils.isBlank(receverId)) {
							Map<String, Object> reqMap = new HashMap<>();
							List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
							Map<String, Object> inforNoMap = new HashMap<String, Object>();
							inforNoMap.put("infor_no", inforNo);
							list.add(inforNoMap);
							reqMap.put("emp_id", empId);
							reqMap.put("param", list);
							changeInforStatus(reqMap, "read");
						}

					}
				}

			}

		}

	}

}
