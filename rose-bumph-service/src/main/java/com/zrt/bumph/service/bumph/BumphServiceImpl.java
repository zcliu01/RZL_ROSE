package com.zrt.bumph.service.bumph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.zrt.bumph.mapper.QueryBumphMapper;
import com.zrt.bumph.service.contacts.ContactsService;
import com.zrt.bumph.service.info.InforService;
import com.zrt.bumph.service.redis.RedisService;
import com.zrt.bumph.service.serial.SerialService;
import com.zrt.bumph.service.vmvif.VmvifService;
import com.zrt.commons.AppException;
import com.zrt.commons.Constant;
import com.zrt.commons.PageInit;
import com.zrt.commons.date.DateUtil;
import com.zrt.mybatis.domain.BumphType;
import com.zrt.mybatis.domain.DocAttach;
import com.zrt.mybatis.domain.DocHander;
import com.zrt.mybatis.domain.Document;
import com.zrt.mybatis.mapper.BumphTypeMapper;
import com.zrt.mybatis.mapper.DocAttachMapper;
import com.zrt.mybatis.mapper.DocHanderMapper;
import com.zrt.mybatis.mapper.DocumentMapper;


@Service("bumphServiceImpl")
@SuppressWarnings("unchecked")
public class BumphServiceImpl implements BumphService {

	@Autowired
	private DocumentMapper documentMapper;
	@Autowired
	private DocHanderMapper docHanderMapper;
	@Autowired
	private DocAttachMapper docAttachMapper;
	@Autowired
	private QueryBumphMapper queryBumphMapper;
	@Autowired
	private BumphTypeMapper bumphTypeMapper;

	@Autowired
	private ContactsService contactsService;
	@Autowired
	private SerialService serialService;

	@Value("${im.appId}")
	private String imAppId;

	@Autowired
	private InforService inforService;
	@Autowired
	private VmvifService vmvifService;

	@Autowired
	private RedisService redisService;

	/**
	 * 
	 * 新建公文
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int add(Map<String, Object> map) throws Exception {
		if (StringUtil.isEmpty((String) map.get("doc_name"))) {
			return 2;
		}
		Document document = new Document();
		document.setDocId(serialService.getUUID());
		DocAttach docAttach = new DocAttach();
		docAttach.setDocId(document.getDocId());
		docAttach.setCreateDateTime(DateUtil.getCurrentDateTime());
		DocHander docHander = new DocHander();

		docHander.setDocId(document.getDocId());
		docHander.setCreateDateTime(DateUtil.getCurrentDateTime());
		docHander.setDocRead("0");
		docHander.setHandState("0");
		docHander.setHandType((String) map.get("hand_type"));
		document.setTenantId((String) map.get("hand_type"));
		document.setCreateDateTime(DateUtil.getCurrentDateTime());
		// 默认缺省状态为未发布 (0)
		document.setDocState("0");
		document.setDocVersion(0);
		document.setDocName((String) map.get("doc_name"));
		document.setDocClasses((String) map.get("doc_classes"));
		// 获取公文日期进行格式转化
		String date = (String) map.get("doc_date");
		document.setDocDate(DateUtil.getFormatFormat(date + " 00:00:00"));
		// 公文类型
		document.setDocType((String) map.get("bumph_type_code"));
		document.setDocNumber((String) map.get("doc_number"));
		document.setDocUrg((String) map.get("doc_urg"));
		document.setDocSrc((String) map.get("doc_src"));
		document.setDocOwner((String) map.get("doc_owner"));
		// 将任务创建人的id放入到map中
		String ownerId = (String) map.get("emp_id");
		map.put("search", ownerId);
		Map<String, Object> empSearch = contactsService.commonEmpSearch(map);
		// 将员工信息返回
		List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
		if (null != empSearchList) {
			document.setDocOwner((String) empSearchList.get(0).get("emp_name"));
		}
		document.setDocPhone((String) map.get("doc_phone"));
		document.setDocOrg((String) map.get("doc_org"));
		document.setDocOwnerId(ownerId);
		document.setDocDispunit((String) map.get("doc_dispunit"));
		document.setRemark((String) map.get("remark"));
		document.setSendim((String) map.get("sendim"));
		document.setSendinfo((String) map.get("sendinfo"));
		documentMapper.insert(document);
		// 添加附件
		List<Map<String, Object>> docAttachList = (List<Map<String, Object>>) map.get("doc_attach");
		if (null != docAttachList) {
			int testCount = 0 ;
			for (Map<String, Object> docAttachMap : docAttachList) {
				docAttach.setTenantId(testCount+"");
				docAttach.setDocAttackId(serialService.getUUID());
				docAttach.setNodeId((String) docAttachMap.get("node_id"));
				docAttach.setAttachType((String) docAttachMap.get("attach_type"));
				docAttach.setAttachId((String) docAttachMap.get("ATTACH_ID"));
				docAttach.setRemark((String) docAttachMap.get("REMARK"));
				docAttach.setAttachName((String) docAttachMap.get("attach_name"));
				docAttach.setDocAttachUrl((String) docAttachMap.get("doc_attach_url"));
				docAttachMapper.insert(docAttach);
				testCount++ ;
			}
		}
		// 添加处理人
		Map<String, Object> empdataMap = redisService.getRedis();
		List<Map<String, Object>> docHanderList = (List<Map<String, Object>>) map.get("doc_hander");
		for (Map<String, Object> docHanderMap : docHanderList) {
			docHander.setHanderid((String) docHanderMap.get("handerID"));
			docHander.setHanderName((String) docHanderMap.get("hander_name"));
			List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");
			for (Map<String, Object> empMap : empList) {
				for (String key : empMap.keySet()) {
					if (docHanderMap.get("handerID").equals(key)) {
						docHander.setHanderOrder(
								Integer.parseInt(((Map<String, Object>) empMap.get(key)).get("emp_order").toString()));
					}
				}
			}
			docHanderMapper.insert(docHander);
		}
		return 1;
	}

	/**
	 * 
	 * 公文详情查询
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> detailView(Map<String, Object> map) throws Exception {
		Document document = documentMapper.selectByPrimaryKey((String) map.get("doc_id"));
		if (document.getDocState().equals("0")) {
			if (!document.getDocOwnerId().equals(map.get("emp_id"))
					|| StringUtil.isNotEmpty((String) map.get("info_version"))) {
				throw new AppException("该条公文已撤销,无法查看!");
			}
		}
		if (StringUtil.isNotEmpty((String) map.get("info_version"))
				&& (document.getDocVersion() != Integer.parseInt((String) map.get("info_version")))) {
			throw new AppException("该条公文已过期,无法查看!");
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		map.put("handerID", map.get("emp_id"));
		List<Map<String, Object>> searchDocHander = queryBumphMapper.searchDocHander(map);
		if (null != searchDocHander && searchDocHander.size() > 0
				&& "0".equals(searchDocHander.get(0).get("doc_read"))) {
			map.put("doc_read", "1");
			map.put("update_date_time", DateUtil.getCurrentDateTime());
			queryBumphMapper.updateState(map);
		}
		map.remove("handerID");
		resultMap.put("doc_id", document.getDocId());
		resultMap.put("doc_name", document.getDocName());
		resultMap.put("doc_number", document.getDocName());
		String date = document.getDocDate();
		// 将任务创建人的id放入到map中
		map.put("search", document.getDocOwnerId());
		Map<String, Object> empSearch = contactsService.commonEmpSearch(map);
		// 将员工信息返回
		List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
		if (null != empSearchList) {
			resultMap.put("emp_head_photo", empSearchList.get(0).get("emp_head_photo"));
		}
		resultMap.put("doc_date", date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8));
		resultMap.put("doc_type", document.getDocType());
		resultMap.put("bumph_type_code", document.getDocType());
		List<Map<String, Object>> searchBumphType = queryBumphMapper.searchBumphType(resultMap);
		resultMap.put("bumph_type_name", searchBumphType.get(0).get("bumph_type_name"));
		resultMap.put("doc_classes", document.getDocClasses());
		resultMap.put("doc_urg", document.getDocUrg());
		resultMap.put("doc_src", document.getDocSrc());
		resultMap.put("doc_owner", document.getDocOwner());
		resultMap.put("doc_owner_id", document.getDocOwnerId());
		resultMap.put("doc_phone", document.getDocPhone());
		resultMap.put("doc_org", document.getDocOrg());
		resultMap.put("doc_dispunit", document.getDocDispunit());
		resultMap.put("remark", document.getRemark());
		resultMap.put("hand_type", document.getTenantId());
		resultMap.put("doc_state", document.getDocState());
		resultMap.put("rel_time", document.getRelTime());
		resultMap.put("sendim", document.getSendim());
		resultMap.put("sendinfo", document.getSendinfo());
		resultMap.put("create_date_time", document.getCreateDateTime());
		resultMap.put("update_date_time", document.getUpdateDateTime());
		List<Map<String, Object>> attach = queryBumphMapper.searchDocAttach(map);
		List<Map<String, Object>> hander = queryBumphMapper.searchDocHander(map);
		for (Map<String, Object> tempMap : hander) {
			if (StringUtil.isEmpty((String) tempMap.get("hand_time"))) {
				tempMap.put("transact", "否");
				tempMap.put("hand_time", "--");
			} else {
				tempMap.put("transact", "是");
				tempMap.put("hand_time",
						tempMap.get("hand_time").toString().subSequence(0, 4) + "-"
								+ tempMap.get("hand_time").toString().subSequence(4, 6) + "-"
								+ tempMap.get("hand_time").toString().subSequence(6, 8));
			}
		}
		resultMap.put("doc_attach", attach);
		resultMap.put("doc_hander", hander);
		return resultMap;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> APPdetailView(Map<String, Object> map) throws Exception {
		Document document = documentMapper.selectByPrimaryKey((String) map.get("doc_id"));
		if (document.getDocState().equals("0")) {
			if (!document.getDocOwnerId().equals(map.get("emp_id"))
					|| StringUtil.isNotEmpty((String) map.get("info_version"))) {
				throw new AppException("该条公文已撤销,无法查看!");
			}
		}
		if (StringUtil.isNotEmpty((String) map.get("info_version"))
				&& (document.getDocVersion() != Integer.parseInt((String) map.get("info_version")))) {
			throw new AppException("该条公文已过期,无法查看!");
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		map.put("handerID", map.get("emp_id"));
		List<Map<String, Object>> searchDocHander = queryBumphMapper.searchDocHander(map);
		if (null != searchDocHander && searchDocHander.size() > 0
				&& "0".equals(searchDocHander.get(0).get("doc_read"))) {
			map.put("doc_read", "1");
			map.put("update_date_time", DateUtil.getCurrentDateTime());
			queryBumphMapper.updateState(map);
		}
		map.remove("handerID");
		resultMap.put("doc_id", document.getDocId());
		resultMap.put("doc_name", document.getDocName());
		resultMap.put("doc_number", document.getDocNumber());
		String date = document.getDocDate();
		// 将任务创建人的id放入到map中
		map.put("search", document.getDocOwnerId());
		Map<String, Object> empSearch = contactsService.commonEmpSearch(map);
		// 将员工信息返回
		List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
		if (null != empSearchList) {
			resultMap.put("emp_head_photo", empSearchList.get(0).get("emp_head_photo"));
		}
		resultMap.put("doc_date", date);
		resultMap.put("doc_type", document.getDocType());
		resultMap.put("bumph_type_code", document.getDocType());
		List<Map<String, Object>> searchBumphType = queryBumphMapper.searchBumphType(resultMap);
		resultMap.put("bumph_type_name", searchBumphType.get(0).get("bumph_type_name"));
		resultMap.put("doc_classes", document.getDocClasses());
		resultMap.put("doc_urg", document.getDocUrg());
		resultMap.put("doc_src", document.getDocSrc());
		resultMap.put("doc_owner", document.getDocOwner());
		resultMap.put("doc_owner_id", document.getDocOwnerId());
		resultMap.put("doc_phone", document.getDocPhone());
		resultMap.put("doc_org", document.getDocOrg());
		resultMap.put("doc_dispunit", document.getDocDispunit());
		resultMap.put("remark", document.getRemark());

		resultMap.put("doc_state", document.getDocState());
		resultMap.put("rel_time", document.getRelTime());
		resultMap.put("sendim", document.getSendim());
		resultMap.put("sendinfo", document.getSendinfo());
		resultMap.put("create_date_time", document.getCreateDateTime());
		resultMap.put("update_date_time", document.getUpdateDateTime());
		List<Map<String, Object>> attach = queryBumphMapper.searchDocAttach(map);
		List<Map<String, Object>> hander = queryBumphMapper.searchDocHander(map);
		for (Map<String, Object> tempMap : hander) {
			if (StringUtil.isEmpty((String) tempMap.get("hand_time"))) {
				tempMap.put("transact", "否");
				tempMap.put("hand_time", "--");
			} else {
				tempMap.put("transact", "是");
				tempMap.put("hand_time", tempMap.get("hand_time").toString());
			}
		}
		resultMap.put("doc_attach", attach);
		resultMap.put("doc_hander", hander);
		return resultMap;
	}

	/**
	 * 
	 * 待发布公文详情
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> detail(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Document document = documentMapper.selectByPrimaryKey((String) map.get("doc_id"));
		if (document.getDocState().equals("0")) {
			if (!document.getDocOwnerId().equals(map.get("emp_id"))
					|| StringUtil.isNotEmpty((String) map.get("info_version"))) {
				throw new AppException("该条公文已撤销,无法查看!");
			}
		}
		if (StringUtil.isNotEmpty((String) map.get("info_version"))
				&& (document.getDocVersion() != Integer.parseInt((String) map.get("info_version")))) {
			throw new AppException("该条公文已过期,无法查看!");
		}
		map.put("handerID", map.get("emp_id"));
		List<Map<String, Object>> searchDocHander = queryBumphMapper.searchDocHander(map);
		if (null != searchDocHander && searchDocHander.size() > 0
				&& "0".equals(searchDocHander.get(0).get("doc_read"))) {
			map.put("doc_read", "1");
			map.put("update_date_time", DateUtil.getCurrentDateTime());
			queryBumphMapper.updateState(map);
		}
		map.remove("handerID");
		resultMap.put("doc_id", document.getDocId());
		resultMap.put("doc_name", document.getDocName());
		resultMap.put("doc_number", document.getDocNumber());
		String date = document.getDocDate();
		// 将任务创建人的id放入到map中
		map.put("search", document.getDocOwnerId());
		Map<String, Object> empSearch = contactsService.commonEmpSearch(map);
		// 将员工信息返回
		List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
		if (null != empSearchList) {
			resultMap.put("emp_head_photo", empSearchList.get(0).get("emp_head_photo"));
		}
		resultMap.put("doc_date", date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8));
		resultMap.put("doc_type", document.getDocType());
		resultMap.put("bumph_type_code", document.getDocType());
		List<Map<String, Object>> searchBumphType = queryBumphMapper.searchBumphType(resultMap);
		resultMap.put("bumph_type_name", searchBumphType.get(0).get("bumph_type_name"));
		resultMap.put("doc_urg", document.getDocUrg());
		resultMap.put("doc_src", document.getDocSrc());
		resultMap.put("doc_classes", document.getDocClasses());
		resultMap.put("doc_owner", document.getDocOwner());
		resultMap.put("doc_owner_id", document.getDocOwnerId());
		resultMap.put("doc_phone", document.getDocPhone());
		resultMap.put("doc_org", document.getDocOrg());
		resultMap.put("doc_dispunit", document.getDocDispunit());
		resultMap.put("hand_type", document.getTenantId());
		resultMap.put("remark", document.getRemark());
		resultMap.put("doc_state", document.getDocState());
		resultMap.put("rel_time", document.getRelTime());
		resultMap.put("sendim", document.getSendim());
		resultMap.put("sendinfo", document.getSendinfo());
		resultMap.put("create_date_time", document.getCreateDateTime());
		resultMap.put("update_date_time", document.getUpdateDateTime());
		List<Map<String, Object>> attach = queryBumphMapper.searchDocAttach(map);
		List<Map<String, Object>> hander = queryBumphMapper.searchDocHander(map);
		for (Map<String, Object> tempMap : hander) {
			if (StringUtil.isEmpty((String) tempMap.get("hand_time"))) {
				tempMap.put("transact", "否");
				tempMap.put("hand_time", "--");
			} else {
				tempMap.put("transact", "是");
				tempMap.put("hand_time",
						tempMap.get("hand_time").toString().subSequence(0, 4) + "-"
								+ tempMap.get("hand_time").toString().subSequence(4, 6) + "-"
								+ tempMap.get("hand_time").toString().subSequence(6, 8)+" "
								+ tempMap.get("hand_time").toString().subSequence(8, 10)+":"
								+ tempMap.get("hand_time").toString().subSequence(10, 12)+":"
								+ tempMap.get("hand_time").toString().subSequence(12, 14));
			}
		}
		resultMap.put("doc_attach", attach);
		resultMap.put("doc_hander", hander);
		return resultMap;
	}

	/**
	 * 
	 * 公文登记
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> regis(Map<String, Object> map) throws Exception {
		if (StringUtil.isNotEmpty((String) map.get("doc_date_start"))) {
			map.put("doc_date_start", ((String) map.get("doc_date_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String) map.get("doc_date_end"))) {
			map.put("doc_date_end", ((String) map.get("doc_date_end")).replace("-", "") + "235959");
		}
		if (StringUtil.isNotEmpty((String) map.get("create_date_time_start"))) {
			map.put("create_date_time_start", ((String) map.get("create_date_time_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String) map.get("create_date_time_end"))) {
			map.put("create_date_time_end", ((String) map.get("create_date_time_end")).replace("-", "") + "235959");
		}
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);
		map.put("doc_owner_id", map.get("emp_id"));
		if (StringUtil.isEmpty((String) map.get("doc_state"))) {
			map.put("doc_state", "0");
		}
		List<Map<String, Object>> documentList = queryBumphMapper.searchDocument(map);
		for (Map<String, Object> tempMap : documentList) {
			String date = (String) tempMap.get("create_date_time");
			tempMap.put("create_date_time", date.substring(0, 4) + "-" + date.substring(4, 6) + "-"
					+ date.substring(6, 8) + " " + date.substring(8, 10) + ":" + date.substring(10, 12));
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(documentList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", documentList);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	/**
	 * 
	 * 待办公文
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> detailSearch(Map<String, Object> map) throws Exception {
		map.put("handerID", map.get("emp_id"));
		return documentSearch(map);
	}

	/**
	 * 
	 * 待办公文
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> APPdetailSearch(Map<String, Object> map) throws Exception {
		map.put("handerID", map.get("emp_id"));
		return APPdocumentSearch(map);
	}

	/**
	 * 
	 * 公文审核查看
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> auditView(Map<String, Object> map) throws Exception {
		List<Map<String, Object>> resultList = queryBumphMapper.searchDocHander(map);
		for (Map<String, Object> tempMap : resultList) {
			String handerID = (String) tempMap.get("handerID");
			String handTime = (String) tempMap.get("hand_time");
			// 将任务创建人的id放入到map中
			map.put("search", handerID);
			Map<String, Object> empSearch = contactsService.commonEmpSearch(map);
			// 将员工信息返回
			List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
			if (null != empSearchList) {
				tempMap.put("emp_head_photo", empSearchList.get(0).get("emp_head_photo"));
				tempMap.put("org_name", empSearchList.get(0).get("org_name_owner"));
			}
			if (StringUtil.isNotEmpty(handTime)) {
				handTime = handTime.substring(0, 4) + "-" + handTime.substring(4, 6) + "-" + handTime.substring(6, 8);
				tempMap.put("hand_time", handTime);
			}

		}
		Map<String, Object> endMap = new HashMap<String, Object>();
		endMap.put("doc_hander", resultList);
		return endMap;
	}

	/**
	 * 
	 * 公文审核查看
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> APPauditView(Map<String, Object> map) throws Exception {
		List<Map<String, Object>> resultList = queryBumphMapper.searchDocHander(map);
		for (Map<String, Object> tempMap : resultList) {
			String handerID = (String) tempMap.get("handerID");
			// 将任务创建人的id放入到map中
			map.put("search", handerID);
			Map<String, Object> empSearch = contactsService.commonEmpSearch(map);
			// 将员工信息返回
			List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
			if (null != empSearchList) {
				tempMap.put("emp_head_photo", empSearchList.get(0).get("emp_head_photo"));
				tempMap.put("org_name", empSearchList.get(0).get("org_name_owner"));
			}

		}
		Map<String, Object> endMap = new HashMap<String, Object>();
		endMap.put("doc_hander", resultList);
		return endMap;
	}

	/**
	 * 
	 * 公文监控
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> Monitor(Map<String, Object> map) throws Exception {
		map.put("doc_state", "1");
		return regis(map);
	}

	/**
	 * 
	 * 公文审核办理
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int auditAttend(Map<String, Object> map) throws Exception {
		Document document = documentMapper.selectByPrimaryKey((String) map.get("doc_id"));
		if ("0".equals(document.getDocState())) {
			throw new AppException("该公文已撤销,无法办理");
		}
		List<String> imList = new ArrayList<String>();
		map.put("handerID", map.get("emp_id"));
		List<Map<String, Object>> searchDocHander = queryBumphMapper.searchDocHander(map);
		if (null != searchDocHander && searchDocHander.size() > 0) {
			if (StringUtil.isEmpty((String) map.get("hand_info"))) {
				throw new AppException("公文处理意见不能为空");
			}
			if (searchDocHander.get(0).get("hand_state").equals("0")) {
				map.put("emp_name", searchDocHander.get(0).get("hander_name"));
				String dateTime = DateUtil.getCurrentDateTime();
				map.put("hand_time", dateTime);
				map.put("hand_state", "1");
				map.put("doc_read", "1");
				map.put("update_date_time", dateTime);
				queryBumphMapper.updateState(map);
				Map<String, Object> busDomainMap = new HashMap<>();
				Map<String, Object> tempMap = new HashMap<>();
				busDomainMap.put("bus_id", map.get("doc_id"));
				tempMap.put("bus_domain", JSONObject.parseObject(JSON.toJSONString(busDomainMap)).toString());
				tempMap.put("recever_id", map.get("emp_id"));
				tempMap.put("bus_id", map.get("doc_id"));
				inforService.flowInforRead(tempMap);

				Map<String, Object> infoMap = new HashMap<String, Object>();
				Map<String, Object> infoMsgMap = new HashMap<String, Object>();
				infoMsgMap.put("bus_id", document.getDocId());
				JSONObject busDomain = JSONObject.parseObject(JSON.toJSONString(infoMsgMap));
				infoMap.put("title", "【" + (String) map.get("emp_name") + "】已办理完成公文 【" + document.getDocName() + "】");
				infoMap.put("content", document.getRemark());
				infoMap.put("sender_id", map.get("emp_id"));
				infoMap.put("category", "docInfor");
				infoMap.put("bus_type", "BM01");
				infoMap.put("bus_id", document.getDocId());
				infoMap.put("receiver_ids", document.getDocOwnerId() + ";");
				infoMap.put("bus_domain", busDomain.toString());
				inforService.sendUpdateInfor(infoMap);

				Map<String, Object> imMap = new HashMap<String, Object>();
				Map<String, Object> msgMap = new HashMap<String, Object>();
				msgMap.put("title", document.getDocName());
				msgMap.put("content", "【" + (String) map.get("emp_name") + "】已办理完成公文 【" + document.getDocName() + "】");
				msgMap.put("status", "0");
				msgMap.put("category", "docInfor");
				msgMap.put("bus_type", "BM01");
				msgMap.put("bus_id", document.getDocId());
				msgMap.put("info_version", document.getDocVersion());
				JSONObject msgDomain = JSONObject.parseObject(JSON.toJSONString(msgMap));
				imMap.put("pushType", "1");
				imMap.put("appId", imAppId);
				imMap.put("sender", "zrt_system");
				imMap.put("msgType", "1");
				imMap.put("msgDomain", "customtype=" + Constant.CUSTOMTYPE + "," + msgDomain);
				imMap.put("msgContent", "您有一条新的公文信息,请及时查看");
				imList.add(document.getDocOwnerId());
				imMap.put("receiver", imList);
				vmvifService.pushMsg(imMap);

			} else {
				throw new AppException("该公文已处理过,不能进行重复处理!");
			}
		}
		List<Map<String, Object>> handerList = (List<Map<String, Object>>) map.get("hander");
		imList.clear();
		StringBuffer handlerId = new StringBuffer();
		if (null != handerList && handerList.size() > 0) {
			DocHander hander = new DocHander();
			hander.setHandType((String) map.get("hand_type"));
			Map<String, Object> empdataMap = redisService.getRedis();
			for (Map<String, Object> tempMap : handerList) {
				hander.setCreateDateTime(DateUtil.getCurrentDateTime());
				hander.setDocId(document.getDocId());
				hander.setHanderid((String) tempMap.get("handerID"));
				hander.setHanderName((String) tempMap.get("hander_name"));
				List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");
				for (Map<String, Object> empMap : empList) {
					for (String key : empMap.keySet()) {
						if (tempMap.get("handerID").equals(key)) {
							hander.setHanderOrder(Integer
									.parseInt(((Map<String, Object>) empMap.get(key)).get("emp_order").toString()));
						}
					}
				}
				hander.setDocRead("0");
				hander.setHandState("0");
				docHanderMapper.insert(hander);
				handlerId.append((String) tempMap.get("handerID") + ";");
				imList.add((String) tempMap.get("handerID"));
			}

			if ("1".equals((String) map.get("sendinfo"))) {
				Map<String, Object> infoMap = new HashMap<String, Object>();
				Map<String, Object> infoMsgMap = new HashMap<String, Object>();
				infoMsgMap.put("bus_id", document.getDocId());
				JSONObject busDomain = JSONObject.parseObject(JSON.toJSONString(infoMsgMap));
				infoMap.put("title", document.getDocName());
				infoMap.put("content", document.getRemark());
				infoMap.put("sender_id", map.get("emp_id"));
				infoMap.put("category", "docInfor");
				infoMap.put("bus_type", "BM01");
				infoMap.put("bus_id", document.getDocId());
				infoMap.put("receiver_ids", handlerId.toString());
				infoMap.put("bus_domain", busDomain.toString());
				inforService.sendUpdateInfor(infoMap);
			}
			if ("1".equals((String) map.get("sendim"))) {
				Map<String, Object> imMap = new HashMap<String, Object>();
				Map<String, Object> msgMap = new HashMap<String, Object>();
				msgMap.put("title", document.getDocName());
				msgMap.put("content", document.getRemark());
				msgMap.put("status", "0");
				msgMap.put("category", "docInfor");
				msgMap.put("bus_type", "BM01");
				msgMap.put("bus_id", document.getDocId());
				msgMap.put("info_version", document.getDocVersion());
				JSONObject msgDomain = JSONObject.parseObject(JSON.toJSONString(msgMap));
				imMap.put("pushType", "1");
				imMap.put("appId", imAppId);
				imMap.put("sender", "zrt_system");
				imMap.put("msgType", "1");
				imMap.put("msgDomain", "customtype=" + Constant.CUSTOMTYPE + "," + msgDomain);
				imMap.put("msgContent", "您有一条新的公文信息,请及时查看");
				imMap.put("receiver", imList);
				vmvifService.pushMsg(imMap);
			}
		}
		return 1;
	}

	/**
	 * 
	 * 公文删除
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int delete(Map<String, Object> map) throws Exception {
		documentMapper.deleteByPrimaryKey((String) map.get("doc_id"));
		queryBumphMapper.deleteDocAttach(map);
		queryBumphMapper.deleteDocHander(map);
		return 1;
	}

	/**
	 * 
	 * 公文修改
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int update(Map<String, Object> map) throws Exception {
		if (StringUtil.isEmpty((String) map.get("doc_name"))) {
			throw new AppException("公文名称不能为空!");
		}
		Document document = documentMapper.selectByPrimaryKey((String) map.get("doc_id"));
		DocAttach docAttach = new DocAttach();
		DocHander docHander = new DocHander();
		docHander.setDocId(document.getDocId());
		docHander.setCreateDateTime(DateUtil.getCurrentDateTime());
		docHander.setDocRead("0");
		docHander.setHandState("0");
		docHander.setHandType((String) map.get("hand_type"));
		document.setTenantId((String) map.get("hand_type"));
		document.setUpdateDateTime(DateUtil.getCurrentDateTime());
		String docState = document.getDocState();
		if (!docState.equals(map.get("doc_state"))) {
			document.setRelTime("");
			document.setDocState((String) map.get("doc_state"));
		}
		document.setDocName((String) map.get("doc_name"));
		String date = (String) map.get("doc_date");
		document.setDocDate(DateUtil.getFormatFormat(date + " 00:00:00"));
		document.setDocType((String) map.get("bumph_type_code"));
		document.setDocClasses((String) map.get("doc_classes"));
		document.setDocNumber((String) map.get("doc_number"));
		document.setDocUrg((String) map.get("doc_urg"));
		document.setDocSrc((String) map.get("doc_src"));
		document.setDocPhone((String) map.get("doc_phone"));
		document.setDocOrg((String) map.get("doc_org"));
		document.setDocDispunit((String) map.get("doc_dispunit"));
		document.setRemark((String) map.get("remark"));
		document.setSendim((String) map.get("sendim"));
		document.setSendinfo((String) map.get("sendinfo"));
		documentMapper.updateByPrimaryKey(document);
		queryBumphMapper.deleteDocAttach(map);
		List<Map<String, Object>> searchDocHander = queryBumphMapper.searchDocHander(map);
		List<String> handerList = new ArrayList<String>();
		for (Map<String, Object> map2 : searchDocHander) {
			handerList.add((String) map2.get("handerID"));
		}
		// 添加附件
		List<Map<String, Object>> docAttachList = (List<Map<String, Object>>) map.get("doc_attach");
		if (docAttachList != null) {
			int testCount = 0 ;
			for (Map<String, Object> docAttachMap : docAttachList) {
				docAttach.setTenantId(testCount+"");
				docAttach.setDocAttackId(serialService.getUUID());
				docAttach.setAttachType((String) docAttachMap.get("attach_type"));
				docAttach.setUpdateDateTime(DateUtil.getCurrentDateTime());
				docAttach.setAttachId((String) docAttachMap.get("ATTACH_ID"));
				docAttach.setNodeId((String) docAttachMap.get("node_id"));
				docAttach.setDocId(document.getDocId());
				docAttach.setRemark((String) docAttachMap.get("REMARK"));
				docAttach.setAttachName((String) docAttachMap.get("attach_name"));
				docAttach.setDocAttachUrl((String) docAttachMap.get("doc_attach_url"));
				docAttachMapper.insert(docAttach);
				testCount++;
			}
		}
		// 内部消息推送人的id拼接
		StringBuffer executorId = new StringBuffer();
		// Im推送人的id的集合
		List<String> executorList = new ArrayList<String>();
		// 添加处理人
		List<Map<String, Object>> docHanderList = (List<Map<String, Object>>) map.get("doc_hander");
		Map<String, Object> empdataMap = redisService.getRedis();
		for (Map<String, Object> docHanderMap : docHanderList) {
			if (!handerList.contains(docHanderMap.get("handerID"))) {
				docHander.setHanderid((String) docHanderMap.get("handerID"));
				docHander.setHanderName((String) docHanderMap.get("hander_name"));
				List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");
				for (Map<String, Object> empMap : empList) {
					for (String key : empMap.keySet()) {
						if (docHanderMap.get("handerID").equals(key)) {
							docHander.setHanderOrder(Integer
									.parseInt(((Map<String, Object>) empMap.get(key)).get("emp_order").toString()));
						}
					}
				}
				docHanderMapper.insert(docHander);
			}
			// 将处理人的id放到集合里为后面讯息发送做准备
			executorId.append((String) docHanderMap.get("handerID") + ";");
			executorList.add((String) docHanderMap.get("handerID"));
		}
		for (String hander : handerList) {
			if (!executorList.contains(hander)) {
				Map<String, Object> tempMap = new HashMap<String, Object>();
				tempMap.put("handerID", hander);
				tempMap.put("doc_id", document.getDocId());
				queryBumphMapper.deleteDocHanderById(tempMap);
			}
		}
		// 判断是否发送内部讯息或者IM
		if ("1".equals(map.get("doc_state"))) {
			if ("1".equals((String) map.get("sendinfo"))) {
				Map<String, Object> infoMap = new HashMap<String, Object>();
				Map<String, Object> infoMsgMap = new HashMap<String, Object>();
				infoMsgMap.put("bus_id", document.getDocId());
				infoMsgMap.put("info_version", document.getDocVersion());
				infoMsgMap.put("doc_owner_id", document.getDocOwnerId());
				JSONObject busDomain = JSONObject.parseObject(JSON.toJSONString(infoMsgMap));
				infoMap.put("title", document.getDocName());
				infoMap.put("content", document.getRemark());
				infoMap.put("sender_id", map.get("emp_id"));
				infoMap.put("category", "docInfor");
				infoMap.put("bus_type", "BM03");
				infoMap.put("bus_id", document.getDocId());
				infoMap.put("receiver_ids", executorId.toString());
				infoMap.put("bus_domain", busDomain.toString());
				inforService.sendUpdateInfor(infoMap);
			}
			if ("1".equals((String) map.get("sendim"))) {
				Map<String, Object> imMap = new HashMap<String, Object>();
				Map<String, Object> msgMap = new HashMap<String, Object>();
				msgMap.put("title", document.getDocName());
				msgMap.put("content", document.getRemark());
				msgMap.put("status", "0");
				msgMap.put("category", "docInfor");
				msgMap.put("bus_type", "BM03");
				msgMap.put("bus_id", document.getDocId());
				msgMap.put("info_version", document.getDocVersion());
				msgMap.put("doc_owner_id", document.getDocOwnerId());
				JSONObject msgDomain = JSONObject.parseObject(JSON.toJSONString(msgMap));
				imMap.put("pushType", "1");
				imMap.put("appId", imAppId);
				imMap.put("sender", "zrt_system");
				imMap.put("msgType", "1");
				imMap.put("msgDomain", "customtype=" + Constant.CUSTOMTYPE + "," + msgDomain);
				imMap.put("msgContent", "您有一条新的公文信息,请及时查看");
				imMap.put("receiver", executorList);
				vmvifService.pushMsg(imMap);
			}
		}
		return 1;
	}

	/**
	 * 
	 * App端公文筛选,处理人或者拟稿人是自己
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> documentSearch(Map<String, Object> map) throws Exception {
		if (StringUtil.isNotEmpty((String) map.get("doc_date_start"))) {
			map.put("doc_date_start", ((String) map.get("doc_date_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String) map.get("doc_date_end"))) {
			map.put("doc_date_end", ((String) map.get("doc_date_end")).replace("-", "") + "235959");
		}
		if (StringUtil.isNotEmpty((String) map.get("rel_time_start"))) {
			map.put("rel_time_start", ((String) map.get("rel_time_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String) map.get("rel_time_end"))) {
			map.put("rel_time_end", ((String) map.get("rel_time_end")).replace("-", "") + "235959");
		}
		if (StringUtil.isNotEmpty((String) map.get("create_date_time_start"))) {
			map.put("create_date_time_start", ((String) map.get("create_date_time_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String) map.get("create_date_time_end"))) {
			map.put("create_date_time_end", ((String) map.get("create_date_time_end")).replace("-", "") + "235959");
		}
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);
		map.put("doc_state", "1");
		List<Map<String, Object>> searchAll = queryBumphMapper.searchAll(map);
		for (Map<String, Object> tempMap : searchAll) {
			tempMap.put("handerID", map.get("emp_id"));
			List<Map<String, Object>> searchDocHander = queryBumphMapper.searchDocHander(tempMap);
			if (null != searchDocHander && searchDocHander.size() > 0) {
				tempMap.put("hand_state", searchDocHander.get(0).get("hand_state"));
			}
			String createDateTime = tempMap.get("create_date_time").toString();
			String ownerId = tempMap.get("doc_owner_id").toString();
			// 将任务创建人的id放入到map中
			map.put("search", ownerId);
			Map<String, Object> empSearch = contactsService.commonEmpSearch(map);
			// 将员工信息返回
			List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
			if (null != empSearchList) {
				tempMap.put("emp_head_photo", empSearchList.get(0).get("emp_head_photo"));
			}

			createDateTime = createDateTime.substring(0, 4) + "-" + createDateTime.substring(4, 6) + "-"
					+ createDateTime.substring(6, 8) + " " + createDateTime.substring(8, 10) + ":"
					+ createDateTime.substring(10, 12);
			tempMap.put("create_date_time", createDateTime);
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(searchAll);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", searchAll);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	/**
	 * 
	 * App端公文筛选,处理人或者拟稿人是自己
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> APPdocumentSearch(Map<String, Object> map) throws Exception {
		if (StringUtil.isNotEmpty((String) map.get("rel_time_start"))) {
			map.put("rel_time_start", ((String) map.get("rel_time_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String) map.get("rel_time_end"))) {
			map.put("rel_time_end", ((String) map.get("rel_time_end")).replace("-", "") + "235959");
		}
		if (StringUtil.isNotEmpty((String) map.get("create_date_time_start"))) {
			map.put("create_date_time_start", ((String) map.get("create_date_time_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String) map.get("create_date_time_end"))) {
			map.put("create_date_time_end", ((String) map.get("create_date_time_end")).replace("-", "") + "235959");
		}
		if (StringUtil.isNotEmpty((String) map.get("doc_date_start"))) {
			map.put("doc_date_start", ((String) map.get("doc_date_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String) map.get("doc_date_end"))) {
			map.put("doc_date_end", ((String) map.get("doc_date_end")).replace("-", "") + "235959");
		}
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);
		map.put("doc_state", "1");
		List<Map<String, Object>> searchAll = queryBumphMapper.searchAll(map);
		for (Map<String, Object> tempMap : searchAll) {
			tempMap.put("handerID", map.get("emp_id"));
			List<Map<String, Object>> searchDocHander = queryBumphMapper.searchDocHander(tempMap);
			if (null != searchDocHander && searchDocHander.size() > 0) {
				tempMap.put("hand_state", searchDocHander.get(0).get("hand_state"));
			}
			String createDateTime = tempMap.get("create_date_time").toString();
			String ownerId = tempMap.get("doc_owner_id").toString();
			// 将任务创建人的id放入到map中
			map.put("search", ownerId);
			Map<String, Object> empSearch = contactsService.commonEmpSearch(map);
			// 将员工信息返回
			List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
			if (null != empSearchList) {
				tempMap.put("emp_head_photo", empSearchList.get(0).get("emp_head_photo"));
			}
			tempMap.put("create_date_time", createDateTime);
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(searchAll);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", searchAll);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	/**
	 * 
	 * 公文管理-筛选
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> manageSearch(Map<String, Object> map) throws Exception {
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);
		if (StringUtil.isNotEmpty((String) map.get("doc_date_start"))) {
			map.put("doc_date_start", ((String) map.get("doc_date_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String) map.get("doc_date_end"))) {
			map.put("doc_date_end", ((String) map.get("doc_date_end")).replace("-", "") + "235959");

		}
		if (StringUtil.isNotEmpty((String) map.get("rel_time_start"))) {
			map.put("rel_time_start", ((String) map.get("rel_time_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String) map.get("rel_time_end"))) {
			map.put("rel_time_end", ((String) map.get("rel_time_end")).replace("-", "") + "235959");
		}
		if (StringUtil.isNotEmpty((String) map.get("create_date_time_start"))) {
			map.put("create_date_time_start", ((String) map.get("create_date_time_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String) map.get("create_date_time_end"))) {
			map.put("create_date_time_end", ((String) map.get("create_date_time_end")).replace("-", "") + "235959");
		}
		map.put("doc_owner_id", map.get("emp_id"));
		List<Map<String, Object>> searchDocument = queryBumphMapper.searchDocument(map);
		String ownerId = map.get("emp_id").toString();
		// 将任务创建人的id放入到map中
		map.put("search", ownerId);

		// 将员工信息返回
		String photo = null;
		Map<String, Object> empSearch = contactsService.commonEmpSearch(map);
		List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
		if (null != empSearchList) {
			photo = (String) empSearchList.get(0).get("emp_head_photo");
		}
		for (Map<String, Object> tempMap : searchDocument) {
			tempMap.put("emp_head_photo", photo);
			String relTime = (String) tempMap.get("rel_time");
			if (null != relTime) {
				relTime = relTime.substring(0, 4) + "-" + relTime.substring(4, 6) + "-" + relTime.substring(6, 8);
			}
			tempMap.put("rel_time", relTime);
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(searchDocument);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", searchDocument);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	/**
	 * 
	 * 公文管理-筛选
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> APPmanageSearch(Map<String, Object> map) throws Exception {
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);
		map.put("doc_owner_id", map.get("emp_id"));
		if (StringUtil.isNotEmpty((String) map.get("doc_date_start"))) {
			map.put("doc_date_start", ((String) map.get("doc_date_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String) map.get("doc_date_end"))) {
			map.put("doc_date_end", ((String) map.get("doc_date_end")).replace("-", "") + "235959");

		}
		if (StringUtil.isNotEmpty((String) map.get("rel_time_start"))) {
			map.put("rel_time_start", ((String) map.get("rel_time_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String) map.get("rel_time_end"))) {
			map.put("rel_time_end", ((String) map.get("rel_time_end")).replace("-", "") + "235959");
		}
		if (StringUtil.isNotEmpty((String) map.get("create_date_time_start"))) {
			map.put("create_date_time_start", ((String) map.get("create_date_time_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String) map.get("create_date_time_end"))) {
			map.put("create_date_time_end", ((String) map.get("create_date_time_end")).replace("-", "") + "235959");
		}
		List<Map<String, Object>> searchDocument = queryBumphMapper.searchDocument(map);
		String ownerId = map.get("emp_id").toString();
		// 将任务创建人的id放入到map中
		map.put("search", ownerId);

		// 将员工信息返回
		String photo = null;
		Map<String, Object> empSearch = contactsService.commonEmpSearch(map);
		List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
		if (null != empSearchList) {
			photo = (String) empSearchList.get(0).get("emp_head_photo");
		}
		for (Map<String, Object> tempMap : searchDocument) {
			tempMap.put("emp_head_photo", photo);
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(searchDocument);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", searchDocument);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	/**
	 * 管理审核人(删除或者添加)
	 */

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int execute(Map<String, Object> map) throws Exception {
		Document document = documentMapper.selectByPrimaryKey((String) map.get("doc_id"));
		if (document.getDocState().equals("0")&&!document.getDocOwnerId().equals(map.get("emp_id"))) {
			throw new AppException("该条公文已撤销,无法添加审核人!");
		}
		if (document.getDocOwnerId().equals(map.get("emp_id"))&&StringUtil.isNotEmpty(map.get("doc_hander_id").toString())) {
			docHanderMapper.deleteByPrimaryKey(Integer.parseInt(map.get("doc_hander_id").toString()));
			return 1;
		}
		DocHander hander = new DocHander();
		Map<String, Object> empdataMap = redisService.getRedis();
		List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");
		for (Map<String, Object> empMap : empList) {
			for (String key : empMap.keySet()) {
				if (map.get("handerID").equals(key)) {
					hander.setHanderOrder(
							Integer.parseInt(((Map<String, Object>) empMap.get(key)).get("emp_order").toString()));
				}
			}
		}
		hander.setHandType((String) map.get("hand_type"));
		hander.setCreateDateTime(DateUtil.getCurrentDateTime());
		hander.setDocId((String) map.get("doc_id"));
		hander.setHanderid((String) map.get("handerID"));
		hander.setHanderName((String) map.get("hander_name"));
		hander.setRemark((String) map.get("remark"));
		hander.setDocRead("0");
		hander.setHandState("0");
		docHanderMapper.insert(hander);
		
		// Im推送人的id的集合
		List<String> handlerList = new ArrayList<String>();
		// 判断,如果可以发送IM讯息和内部讯息
		if ("1".equals(map.get("sendInfo"))) {
			Map<String, Object> infoMap = new HashMap<String, Object>();
			Map<String, Object> infoMsgMap = new HashMap<String, Object>();
			infoMsgMap.put("bus_id", document.getDocId());
			JSONObject busDomain = JSONObject.parseObject(JSON.toJSONString(infoMsgMap));
			infoMap.put("title", document.getDocName());
			infoMap.put("content", document.getRemark());
			infoMap.put("sender_id", map.get("emp_id"));
			infoMap.put("category", "docInfor");
			infoMap.put("bus_type", "BM02");
			infoMap.put("bus_id", document.getDocId());
			infoMap.put("receiver_ids", hander.getHanderid() + ";");
			infoMap.put("bus_domain", busDomain.toString());
			inforService.sendUpdateInfor(infoMap);
		}
		if ("1".equals(map.get("sendim"))) {
			Map<String, Object> imMap = new HashMap<String, Object>();
			Map<String, Object> msgMap = new HashMap<String, Object>();
			msgMap.put("title", document.getDocName());
			msgMap.put("content", document.getRemark());
			msgMap.put("status", "0");
			msgMap.put("category", "docInfor");
			msgMap.put("bus_type", "BM02");
			msgMap.put("bus_id", document.getDocId());
			msgMap.put("info_version", document.getDocVersion());
			JSONObject msgDomain = JSONObject.parseObject(JSON.toJSONString(msgMap));
			imMap.put("pushType", "1");
			imMap.put("appId", imAppId);
			imMap.put("sender", "zrt_system");
			imMap.put("msgType", "1");
			imMap.put("msgDomain", "customtype=" + Constant.CUSTOMTYPE + "," + msgDomain);
			imMap.put("msgContent", "您有一条新的公文信息,请及时查看");
			imMap.put("receiver", handlerList.add(hander.getHanderid()));
			vmvifService.pushMsg(imMap);
		}
		return 1;
	}

	/**
	 * 管理审核人(批量添加)
	 */

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int addExecutes(Map<String, Object> map) throws Exception {
		Document document = documentMapper.selectByPrimaryKey((String) map.get("doc_id"));
		if (document.getDocState().equals("0")&&!document.getDocOwnerId().equals(map.get("emp_id"))) {
			throw new AppException("该条公文已撤销,无法添加审核人!");
		}
		List<String> handlerList = new ArrayList<String>();
		StringBuffer stringBuffer = new StringBuffer();
		List<Map<String, Object>> handers = (List<Map<String, Object>>) map.get("hander");
		DocHander hander = new DocHander();
		hander.setCreateDateTime(DateUtil.getCurrentDateTime());
		hander.setDocId((String) map.get("doc_id"));
		hander.setHandType((String) map.get("hand_type"));
		hander.setRemark((String) map.get("remark"));
		hander.setHandState("0");
		hander.setDocRead("0");
		Map<String, Object> empdataMap = redisService.getRedis();
		for (Map<String, Object> tempMap : handers) {
			List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");
			for (Map<String, Object> empMap : empList) {
				for (String key : empMap.keySet()) {
					if (tempMap.get("handerID").equals(key)) {
						hander.setHanderOrder(
								Integer.parseInt(((Map<String, Object>) empMap.get(key)).get("emp_order").toString()));
					}
				}
			}
			hander.setHanderid((String) tempMap.get("handerID"));
			hander.setHanderName((String) tempMap.get("hander_name"));
			docHanderMapper.insert(hander);
			stringBuffer.append((String) tempMap.get("handerID") + ";");
			handlerList.add((String) tempMap.get("handerID"));
		}
		// Im推送人的id的集合
		// 判断,如果可以发送IM讯息和内部讯息

		if ("1".equals(map.get("sendinfo"))) {
			Map<String, Object> infoMap = new HashMap<String, Object>();
			Map<String, Object> infoMsgMap = new HashMap<String, Object>();
			infoMsgMap.put("bus_id", document.getDocId());
			JSONObject busDomain = JSONObject.parseObject(JSON.toJSONString(infoMsgMap));
			infoMap.put("title", document.getDocName());
			infoMap.put("content", document.getRemark());
			infoMap.put("sender_id", map.get("emp_id"));
			infoMap.put("category", "docInfor");
			infoMap.put("bus_type", "BM01");
			infoMap.put("bus_id", document.getDocId());
			infoMap.put("receiver_ids", stringBuffer.toString());
			infoMap.put("bus_domain", busDomain.toString());
			inforService.sendUpdateInfor(infoMap);
		}
		if ("1".equals(map.get("sendim"))) {
			Map<String, Object> imMap = new HashMap<String, Object>();
			Map<String, Object> msgMap = new HashMap<String, Object>();
			msgMap.put("title", document.getDocName());
			msgMap.put("content", document.getRemark());
			msgMap.put("status", "0");
			msgMap.put("category", "docInfor");
			msgMap.put("bus_type", "BM01");
			msgMap.put("bus_id", document.getDocId());
			msgMap.put("info_version", document.getDocVersion());
			JSONObject msgDomain = JSONObject.parseObject(JSON.toJSONString(msgMap));
			imMap.put("pushType", "1");
			imMap.put("appId", imAppId);
			imMap.put("sender", "zrt_system");
			imMap.put("msgType", "1");
			imMap.put("msgDomain", "customtype=" + Constant.CUSTOMTYPE + "," + msgDomain);
			imMap.put("msgContent", "您有一条新的公文信息,请及时查看");
			imMap.put("receiver", handlerList);
			vmvifService.pushMsg(imMap);
		}
		return 1;
	}
	
	/**
	 * 管理审核人(批量添加)
	 */
	
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int appAddExecutes(Map<String, Object> map) throws Exception {
		Document document = documentMapper.selectByPrimaryKey((String) map.get("doc_id"));
		if (document.getDocState().equals("0")&&!document.getDocOwnerId().equals(map.get("emp_id"))) {
			throw new AppException("该条公文已撤销,无法添加审核人!");
		}
		List<String> handlerList = new ArrayList<String>();
		StringBuffer stringBuffer = new StringBuffer();
		List<Map<String, Object>> handers = (List<Map<String, Object>>) map.get("docHander");
		DocHander hander = new DocHander();
		hander.setCreateDateTime(DateUtil.getCurrentDateTime());
		hander.setDocId((String) map.get("doc_id"));
		hander.setHandType((String) map.get("hand_type"));
		hander.setRemark((String) map.get("remark"));
		hander.setHandState("0");
		hander.setDocRead("0");
		Map<String, Object> empdataMap = redisService.getRedis();
		for (Map<String, Object> tempMap : handers) {
			List<Map<String, Object>> empList = (List<Map<String, Object>>) empdataMap.get("empInfoList");
			for (Map<String, Object> empMap : empList) {
				for (String key : empMap.keySet()) {
					if (tempMap.get("handerID").equals(key)) {
						hander.setHanderOrder(
								Integer.parseInt(((Map<String, Object>) empMap.get(key)).get("emp_order").toString()));
					}
				}
			}
			hander.setHanderid((String) tempMap.get("handerID"));
			hander.setHanderName((String) tempMap.get("hander_name"));
			docHanderMapper.insert(hander);
			stringBuffer.append((String) tempMap.get("handerID") + ";");
			handlerList.add((String) tempMap.get("handerID"));
		}
		// Im推送人的id的集合
		// 判断,如果可以发送IM讯息和内部讯息
		
		if ("1".equals(map.get("sendinfo"))) {
			Map<String, Object> infoMap = new HashMap<String, Object>();
			Map<String, Object> infoMsgMap = new HashMap<String, Object>();
			infoMsgMap.put("bus_id", document.getDocId());
			JSONObject busDomain = JSONObject.parseObject(JSON.toJSONString(infoMsgMap));
			infoMap.put("title", document.getDocName());
			infoMap.put("content", document.getRemark());
			infoMap.put("sender_id", map.get("emp_id"));
			infoMap.put("category", "docInfor");
			infoMap.put("bus_type", "BM01");
			infoMap.put("bus_id", document.getDocId());
			infoMap.put("receiver_ids", stringBuffer.toString());
			infoMap.put("bus_domain", busDomain.toString());
			inforService.sendUpdateInfor(infoMap);
		}
		if ("1".equals(map.get("sendim"))) {
			Map<String, Object> imMap = new HashMap<String, Object>();
			Map<String, Object> msgMap = new HashMap<String, Object>();
			msgMap.put("title", document.getDocName());
			msgMap.put("content", document.getRemark());
			msgMap.put("status", "0");
			msgMap.put("category", "docInfor");
			msgMap.put("bus_type", "BM01");
			msgMap.put("bus_id", document.getDocId());
			msgMap.put("info_version", document.getDocVersion());
			JSONObject msgDomain = JSONObject.parseObject(JSON.toJSONString(msgMap));
			imMap.put("pushType", "1");
			imMap.put("appId", imAppId);
			imMap.put("sender", "zrt_system");
			imMap.put("msgType", "1");
			imMap.put("msgDomain", "customtype=" + Constant.CUSTOMTYPE + "," + msgDomain);
			imMap.put("msgContent", "您有一条新的公文信息,请及时查看");
			imMap.put("receiver", handlerList);
			vmvifService.pushMsg(imMap);
		}
		return 1;
	}

	/**
	 * 公文类型查询
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> state_search(Map<String, Object> map) throws Exception {
		String bumphTypeState = (String) map.get("bumph_type_state");
		if (StringUtil.isEmpty(bumphTypeState)) {
			map.put("bumph_type_state", "1");
			return queryBumphMapper.searchBumphType(map);
		}
		return queryBumphMapper.searchBumphType(map);
	}

	/**
	 * 公文类型维护
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int state_save(Map<String, Object> map) throws Exception {
		String code = (String) map.get("bumph_type_code");
		BumphType bumphType = new BumphType();
		if (StringUtil.isEmpty(code)) {
			Map<String, Object> searchMax = queryBumphMapper.searchMax();
			String tempCode = searchMax.get("COUNT(bumph_type_code)").toString();
			int bumphTypeCode = Integer.parseInt(tempCode) + 1;
			bumphType.setBumphTypeCode(bumphTypeCode + "");
			bumphType.setBumphTypeCreatedata(DateUtil.getCurrentDateTime());
			bumphType.setBumphTypeState((String) map.get("bumph_type_state"));
			bumphType.setBumphTypeName((String) map.get("bumph_type_name"));
			bumphTypeMapper.insert(bumphType);
		} else {
			Map<String, Object> searchbumph = queryBumphMapper.searchbumph(map);
			if (Integer.parseInt(searchbumph.get("count(doc_id)").toString()) > 0) {
				return 2;
			}
			BumphType selectByPrimaryKey = bumphTypeMapper.selectByPrimaryKey(code);
			selectByPrimaryKey.setBumphTypeName((String) map.get("bumph_type_name"));
			selectByPrimaryKey.setBumphTypeCode(code);
			selectByPrimaryKey.setBumphTypeState((String) map.get("bumph_type_state"));
			bumphTypeMapper.updateByPrimaryKeySelective(selectByPrimaryKey);
		}
		return 1;
	}

	/**
	 * 公文撤销
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int backout(Map<String, Object> map) throws Exception {
		Document document = documentMapper.selectByPrimaryKey((String) map.get("doc_id"));
		document.setDocState(map.get("doc_state").toString());
		if ("1".equals(map.get("doc_state").toString())) {
			document.setDocVersion(document.getDocVersion() + 1);
			document.setRelTime(DateUtil.getCurrentDateTime());
			map.put("update_date_time", DateUtil.getCurrentDateTime());
			queryBumphMapper.initDocHander(map);
		}
		if ("0".equals(map.get("doc_state").toString())) {
			document.setRelTime(null);
		}
		documentMapper.updateByPrimaryKey(document);
		List<Map<String, Object>> handerList = queryBumphMapper.searchDocHander(map);
		List<String> idList = new ArrayList<String>();
		StringBuffer idString = new StringBuffer();
		for (Map<String, Object> tempMap : handerList) {
			idList.add(tempMap.get("handerID").toString());
			idString.append(tempMap.get("handerID").toString() + ";");
		}

		if ("0".equals(map.get("doc_state").toString())) {
			Map<String, Object> infoMap = new HashMap<String, Object>();
			Map<String, Object> infoMsgMap = new HashMap<String, Object>();
			infoMsgMap.put("bus_id", document.getDocId());
			infoMsgMap.put("infor_flag", "1");
			JSONObject busDomain = JSONObject.parseObject(JSON.toJSONString(infoMsgMap));
			infoMap.put("title", "公文<<" + document.getDocName() + ">>已撤销");
			infoMap.put("content", "该公文已撤销,无法进行查看及办理!");
			infoMap.put("sender_id", map.get("emp_id"));
			infoMap.put("category", "docInfor");
			infoMap.put("bus_type", "BM02");
			infoMap.put("bus_id", document.getDocId());
			infoMap.put("receiver_ids", idString.toString());
			infoMap.put("bus_domain", busDomain.toString());
			inforService.sendUpdateInfor(infoMap);
		}
		if ("1".equals(map.get("doc_state").toString())) {
			if ("1".equals(document.getSendinfo())) {
				Map<String, Object> infoMap = new HashMap<String, Object>();
				Map<String, Object> infoMsgMap = new HashMap<String, Object>();
				infoMsgMap.put("bus_id", document.getDocId());
				infoMsgMap.put("info_version", document.getDocVersion());
				infoMsgMap.put("doc_owner_id", document.getDocOwnerId());
				JSONObject busDomain = JSONObject.parseObject(JSON.toJSONString(infoMsgMap));
				infoMap.put("title", document.getDocName());
				infoMap.put("content", document.getRemark());
				infoMap.put("sender_id", map.get("emp_id"));
				infoMap.put("category", "docInfor");
				infoMap.put("bus_type", "BM03");
				infoMap.put("bus_id", document.getDocId());
				infoMap.put("receiver_ids", idString.toString());
				infoMap.put("bus_domain", busDomain.toString());
				inforService.sendUpdateInfor(infoMap);
			}
			if ("1".equals(document.getSendim())) {
				Map<String, Object> imMap = new HashMap<String, Object>();
				Map<String, Object> msgMap = new HashMap<String, Object>();
				msgMap.put("title", document.getDocName());
				msgMap.put("content", document.getRemark());
				msgMap.put("status", "0");
				msgMap.put("category", "docInfor");
				msgMap.put("bus_type", "BM03");
				msgMap.put("bus_id", document.getDocId());
				msgMap.put("info_version", document.getDocVersion());
				msgMap.put("doc_owner_id", document.getDocOwnerId());
				JSONObject msgDomain = JSONObject.parseObject(JSON.toJSONString(msgMap));
				imMap.put("pushType", "1");
				imMap.put("appId", imAppId);
				imMap.put("sender", "zrt_system");
				imMap.put("msgType", "1");
				imMap.put("msgDomain", "customtype=" + Constant.CUSTOMTYPE + "," + msgDomain);
				imMap.put("msgContent", "您有一条新的公文信息,请及时查看");
				imMap.put("receiver", idList);
				vmvifService.pushMsg(imMap);
			}
		}
		return 1;
	}

	/**
	 * Web公文撤销
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int webBackout(Map<String, Object> map) throws Exception {
		List<Map<String, Object>> param = (List<Map<String, Object>>) map.get("param");
		if (null != param) {
			for (Map<String, Object> map2 : param) {
				map.put("doc_id", map2.get("doc_id"));
				Document document = documentMapper.selectByPrimaryKey((String) map2.get("doc_id"));
				document.setDocState(map.get("doc_state").toString());
				if ("1".equals(map.get("doc_state").toString())) {
					document.setDocVersion(document.getDocVersion() + 1);
					document.setRelTime(DateUtil.getCurrentDateTime());
					map.put("update_date_time", DateUtil.getCurrentDateTime());
					queryBumphMapper.initDocHander(map);
				}
				if ("0".equals(map.get("doc_state").toString())) {
					document.setRelTime(null);
				}
				documentMapper.updateByPrimaryKey(document);
				List<Map<String, Object>> handerList = queryBumphMapper.searchDocHander(map);
				List<String> idList = new ArrayList<String>();
				StringBuffer idString = new StringBuffer();
				for (Map<String, Object> tempMap : handerList) {
					idList.add(tempMap.get("handerID").toString());
					idString.append(tempMap.get("handerID").toString() + ";");
				}

				if ("0".equals(map.get("doc_state").toString())) {
					Map<String, Object> infoMap = new HashMap<String, Object>();
					Map<String, Object> infoMsgMap = new HashMap<String, Object>();
					infoMsgMap.put("bus_id", document.getDocId());
					infoMsgMap.put("infor_flag", "1");
					JSONObject busDomain = JSONObject.parseObject(JSON.toJSONString(infoMsgMap));
					infoMap.put("title", "公文<<" + document.getDocName() + ">>已撤销");
					infoMap.put("content", "该公文已撤销,无法进行查看及办理!");
					infoMap.put("sender_id", map.get("emp_id"));
					infoMap.put("category", "docInfor");
					infoMap.put("bus_type", "BM02");
					infoMap.put("bus_id", document.getDocId());
					infoMap.put("receiver_ids", idString.toString());
					infoMap.put("bus_domain", busDomain.toString());
					inforService.sendUpdateInfor(infoMap);
				}
				if ("1".equals(map.get("doc_state").toString())) {
					if ("1".equals(document.getSendinfo())) {
						Map<String, Object> infoMap = new HashMap<String, Object>();
						Map<String, Object> infoMsgMap = new HashMap<String, Object>();
						infoMsgMap.put("bus_id", document.getDocId());
						infoMsgMap.put("info_version", document.getDocVersion());
						infoMsgMap.put("doc_owner_id", document.getDocOwnerId());
						JSONObject busDomain = JSONObject.parseObject(JSON.toJSONString(infoMsgMap));
						infoMap.put("title", document.getDocName());
						infoMap.put("content", document.getRemark());
						infoMap.put("sender_id", map.get("emp_id"));
						infoMap.put("category", "docInfor");
						infoMap.put("bus_type", "BM03");
						infoMap.put("bus_id", document.getDocId());
						infoMap.put("receiver_ids", idString.toString());
						infoMap.put("bus_domain", busDomain.toString());
						inforService.sendUpdateInfor(infoMap);
					}
					if ("1".equals(document.getSendim())) {
						Map<String, Object> imMap = new HashMap<String, Object>();
						Map<String, Object> msgMap = new HashMap<String, Object>();
						msgMap.put("title", document.getDocName());
						msgMap.put("content", document.getRemark());
						msgMap.put("status", "0");
						msgMap.put("category", "docInfor");
						msgMap.put("bus_type", "BM03");
						msgMap.put("bus_id", document.getDocId());
						msgMap.put("info_version", document.getDocVersion());
						JSONObject msgDomain = JSONObject.parseObject(JSON.toJSONString(msgMap));
						imMap.put("pushType", "1");
						imMap.put("appId", imAppId);
						imMap.put("sender", "zrt_system");
						imMap.put("msgType", "1");
						imMap.put("msgDomain", "customtype=" + Constant.CUSTOMTYPE + "," + msgDomain);
						imMap.put("msgContent", "您有一条新的公文信息,请及时查看");
						imMap.put("receiver", idList);
						vmvifService.pushMsg(imMap);
					}
				}
			}
		}
		return 1;
	}

}
