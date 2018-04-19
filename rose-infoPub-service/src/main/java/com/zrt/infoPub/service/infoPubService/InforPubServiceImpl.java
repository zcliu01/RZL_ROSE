package com.zrt.infoPub.service.infoPubService;

import java.util.ArrayList;
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
import com.github.pagehelper.StringUtil;
import com.zrt.commons.AppException;
import com.zrt.commons.PageInit;
import com.zrt.commons.date.DateUtil;
import com.zrt.infoPub.mapper.MyInfoPubMapper;
import com.zrt.infoPub.service.contacts.ContactsService;
import com.zrt.infoPub.service.infor.InforService;
import com.zrt.infoPub.service.serial.SerialService;
import com.zrt.infoPub.service.usethrea.SendMessage;
import com.zrt.infoPub.service.vmvif.VmvifService;
import com.zrt.mybatis.domain.InfoPubAttach;
import com.zrt.mybatis.domain.InfoPubExample;
import com.zrt.mybatis.domain.InfoPubExample.Criteria;
import com.zrt.mybatis.domain.InfoPubType;
import com.zrt.mybatis.domain.InfoPubViewer;
import com.zrt.mybatis.domain.InfoPubWithBLOBs;
import com.zrt.mybatis.mapper.InfoPubAttachMapper;
import com.zrt.mybatis.mapper.InfoPubMapper;
import com.zrt.mybatis.mapper.InfoPubTypeMapper;
import com.zrt.mybatis.mapper.InfoPubViewerMapper;

@Service("inforPubServiceImpl")
@SuppressWarnings("unchecked")
public class InforPubServiceImpl implements InforPubService {
	
	@Autowired
	InfoPubMapper infoPubMapper;
	
	@Autowired
	InfoPubTypeMapper infoPubTypeMapper;
	
	@Autowired
	InfoPubViewerMapper infoPubViewerMapper;
	
	@Autowired
	InfoPubAttachMapper infoPubAttachMapper;
	
	@Autowired
	MyInfoPubMapper myInfoPubMapper;
	
	@Autowired
	ContactsService contactsService;
	
	@Autowired
	InforService inforService ;
	
	@Autowired
	VmvifService vmvifService;
	
	@Autowired
	private SerialService serialService;
	
	@Autowired
	private SendMessage sendMessage;
	
	/*@Value("${im.appId}")
	private String imAppId;*/
	

	/**
	 * 新建公示
	 * 
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int save(Map<String, Object> map) throws Exception {
		if (StringUtil.isEmpty((String)map.get("info_title"))) {
			return 2;
		}
		if (StringUtil.isEmpty((String)map.get("info_content_style"))) {
			return 4;
		}
		if (!"1".equals(map.get("sendinfo"))&&!"1".equals(map.get("sendim"))) {
			return 5;
		}
		List<Map<String,Object>> infoPubViewerList = (List<Map<String,Object>>) map.get("info_viewer");
		if (!"1".equals(map.get("info_isEveryOne"))&&null!=infoPubViewerList&&infoPubViewerList.size()<1) {
			return 6;
		}
		InfoPubWithBLOBs infoPub = new InfoPubWithBLOBs();
		String infoId = serialService.getUUID();
		String dateTime = DateUtil.getCurrentDateTime();
		String infoOrder = (String) map.get("info_order");
	//添加公示信息	
		infoPub.setInfoId(infoId);
		infoPub.setInfoTitle((String)map.get("info_title"));
		map.put("search", map.get("emp_id"));
		infoPub.setInfoVersion(0);
		infoPub.setInfoOwnerId((String)map.get("emp_id"));
		infoPub.setInfoOwner((String)map.get("info_owner"));
		Map<String, Object> empSearch = contactsService.commonEmpSearch(map);
		List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
		if (null!=empSearchList) {
			infoPub.setInfoOwner((String)(empSearchList.get(0).get("emp_name")));
		}
		infoPub.setInfoType((String)map.get("info_type_code"));
		infoPub.setInfoNumber((String)map.get("info_number"));
	//获取文件置顶编号,如果缺省,默认为0,否则正常添加	
		if (StringUtil.isEmpty(infoOrder)) {
			infoPub.setInfoOrder("0");
		}else {
			infoPub.setInfoOrder(infoOrder);
		}
		infoPub.setInfoContentStyle((String) map.get("info_content_style"));
		infoPub.setInfoContent((String) map.get("info_content"));
		infoPub.setSendinfo((String) map.get("sendinfo"));
		infoPub.setSendim((String) map.get("sendim"));
		infoPub.setInfoState("0");
		infoPub.setCreateDateTime(dateTime);
		infoPub.setInfoIseveryone((String)map.get("info_isEveryOne"));
		infoPubMapper.insert(infoPub);
		
		List<Map<String,Object>> infoPubAttachList = (List<Map<String,Object>>) map.get("info_attach");
		InfoPubViewer infoPubViewer = new InfoPubViewer();
		infoPubViewer.setInfoId(infoId);
		infoPubViewer.setIsRead("0");
		infoPubViewer.setCreateDateTime(DateUtil.getCurrentDateTime());
		infoPubViewer.setRemark((String)map.get("remark"));
		if (!"1".equals(map.get("info_isEveryOne"))) {
			//添加公示查看人	
			for (Map<String, Object> map2 : infoPubViewerList) {
				infoPubViewer.setViewId((String)map2.get("view_id"));
				infoPubViewer.setViewName((String)map2.get("view_name"));
				infoPubViewer.setRemark((String)map2.get("remark"));
				infoPubViewerMapper.insert(infoPubViewer);
			}
		}else {
			Map<String, Object> searchAll = contactsService.searchAll(map);
			infoPubViewerList = (List<Map<String, Object>>) searchAll.get("data");
			for (Map<String, Object> map2 : infoPubViewerList) {
				infoPubViewer.setViewId((String)map2.get("emp_id"));
				infoPubViewer.setViewName((String)map2.get("emp_name"));
				infoPubViewerMapper.insert(infoPubViewer);
			}
		}
	//添加附件,可能为空,先进行判断	
		if(infoPubAttachList.size()>0){
			int testCount = 0 ;
			for (Map<String, Object> map2 : infoPubAttachList) {
				InfoPubAttach infoPubAttach = new InfoPubAttach();
				infoPubAttach.setAttachId((String)map2.get("ATTACH_ID"));
				infoPubAttach.setAttachType((String)map2.get("attach_type"));
				infoPubAttach.setAttachName((String)map2.get("attach_name"));
				infoPubAttach.setInfopubAttachUrl((String)map2.get("infopub_attach_url"));
				infoPubAttach.setCreateDateTime(DateUtil.getCurrentDateTime());
				infoPubAttach.setInfoId(infoId);
				infoPubAttach.setNodeId((String)map2.get("node_id"));
				infoPubAttach.setInfoAttackId(serialService.getUUID());
				infoPubAttach.setRemark((String)map2.get("REMARK"));
				infoPubAttach.setTenantId(testCount+"");
				infoPubAttachMapper.insert(infoPubAttach);
				testCount++;
			}
		}
		return 1;
	}
	
	/**
	 * 
	 * 公示类型维护
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int state_save(Map<String, Object> map) throws Exception {
		if (StringUtil.isEmpty((String)map.get("info_type_name"))) {
			return 3;
		}
		String code = (String) map.get("info_type_code");
		InfoPubType infoPubType = new InfoPubType();
		if(StringUtil.isEmpty(code)){
			Map<String, Object> searchMax = myInfoPubMapper.searchMax();
			String tempCode = searchMax.get("COUNT(info_type_code)").toString();
			int infoTypeCode = Integer.parseInt(tempCode)+1;
			infoPubType.setInfoTypeCode(infoTypeCode+"");
			infoPubType.setInfoTypeCreatedata(DateUtil.getCurrentDateTime());
			infoPubType.setInfoTypeState("1");
			infoPubType.setInfoTypeName((String)map.get("info_type_name"));
			infoPubTypeMapper.insert(infoPubType);
		}else {
			List<Map<String, Object>> searchInfoPub = myInfoPubMapper.searchInfoPub(map);
	//判断公示类型下面有没有公示信息,如果有返回一个表示错误		
			if(null !=searchInfoPub &&searchInfoPub.size()>0){
				return 2;
			}
			InfoPubType tempPubType = infoPubTypeMapper.selectByPrimaryKey(code);
			tempPubType.setInfoTypeName((String)map.get("info_type_name"));
			tempPubType.setInfoTypeCode(code);
			tempPubType.setInfoTypeState((String)map.get("info_type_state"));
			infoPubTypeMapper.updateByPrimaryKeySelective(tempPubType);
		}
		return 1;
	}

	
	/**
	 * 
	 * 公示删除
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> del(Map<String, Object> map) throws Exception {
		List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
		List<String> idList = new ArrayList<String>();
		for (Map<String, Object> tempMap : list) {
			String infoPubId = (String)tempMap.get("info_id");
			myInfoPubMapper.deleteAttach(tempMap);
			myInfoPubMapper.deleteViewer(tempMap);
			idList.add(infoPubId);
		}
		InfoPubExample example = new InfoPubExample();
		Criteria criteria = example.createCriteria();
		criteria.andInfoIdIn(idList);
		infoPubMapper.deleteByExample(example);
		return null;
	}

	
	/**
	 * 
	 * 查看公示详情
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> searchInfo(Map<String, Object> map) throws Exception {
		
		String infoId = (String) map.get("info_id");
		InfoPubWithBLOBs infoPub = infoPubMapper.selectByPrimaryKey(infoId);
		if (!infoPub.getInfoOwnerId().equals(map.get("emp_id"))) {
			if (StringUtil.isNotEmpty((String)map.get("info_version"))&&(infoPub.getInfoVersion()!=Integer.parseInt((String)map.get("info_version")))) {
				throw new AppException("该条公示已过期,无法查看!");
			}
			if (infoPub.getInfoState().equals("0")) {
				throw new AppException("该条信息公示已撤销,无法查看!");
			}
		}
		map.put("info_type_code", infoPub.getInfoType());
		List<Map<String, Object>> searchInfoType = myInfoPubMapper.searchInfoType(map);
		String infoTypeName = (String) searchInfoType.get(0).get("info_type_name");
		String time = infoPub.getInfoPubdate();
		if (null != time&&StringUtil.isNotEmpty(time)) {
			infoPub.setInfoPubdate(time.substring(0, 4)+"-"+time.substring(4, 6)+"-"+time.substring(6, 8));
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("info_id", infoPub.getInfoId());
		resultMap.put("info_title", infoPub.getInfoTitle());
		resultMap.put("info_owner", infoPub.getInfoOwner());
		resultMap.put("info_owner_id", infoPub.getInfoOwnerId());
		map.put("search", infoPub.getInfoOwnerId());
		Map<String, Object> empSearch = contactsService.commonEmpSearch(map);
		List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
		if (null!=empSearchList) {
			resultMap.put("emp_head_photo", empSearchList.get(0).get("emp_head_photo"));
			resultMap.put("emp_name", empSearchList.get(0).get("emp_name"));
			resultMap.put("org_name", empSearchList.get(0).get("org_name_owner"));
		}
		resultMap.put("info_type", infoPub.getInfoType());
		resultMap.put("info_number", infoPub.getInfoNumber());
		resultMap.put("info_order", infoPub.getInfoOrder());
		resultMap.put("info_content_style",infoPub.getInfoContentStyle());
		resultMap.put("info_content", infoPub.getInfoContent());
		resultMap.put("info_state", infoPub.getInfoState());
		resultMap.put("info_pubdate", infoPub.getInfoPubdate());
		resultMap.put("sendinfo", infoPub.getSendinfo());
		resultMap.put("info_isEveryOne", infoPub.getInfoIseveryone());
		resultMap.put("sendim", infoPub.getSendim());
		List<Map<String, Object>> searchAttach = myInfoPubMapper.searchAttach(map);
		List<Map<String, Object>> searchViewer = myInfoPubMapper.searchViewer(map);
		for (Map<String, Object> tempMap : searchViewer) {
			if (map.get("emp_id").toString().equals(tempMap.get("view_id"))) {
				if ("0".equals(tempMap.get("is_read"))) {
					myInfoPubMapper.updateIsRead(tempMap);
					Map<String, Object> busDomainMap = new HashMap<>();
					Map<String, Object> map2 = new HashMap<>();
					busDomainMap.put("bus_id", map.get("info_id"));
					map2.put("bus_domain", JSONObject.parseObject(JSON.toJSONString(busDomainMap)).toString());
					map2.put("recever_id", map.get("emp_id"));
					map2.put("bus_id",map.get("info_id") );
					inforService.flowInforRead(map2);
					break ;
				}else {
					break ;
				}
			}
		}
		resultMap.put("info_type_code", infoPub.getInfoType());
		resultMap.put("info_type_name", infoTypeName);
		resultMap.put("info_viewer", searchViewer);
		resultMap.put("info_attach", searchAttach);
		return resultMap;
	}

	/**
	 * 
	 * 公示类型查询
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> state_search(Map<String, Object> map) throws Exception {
		String infoTypeState = (String) map.get("info_type_state");
		if (StringUtil.isEmpty(infoTypeState)) {
			map.put("info_type_state", "1");
			return myInfoPubMapper.searchInfoType(map);
		}
		return myInfoPubMapper.searchInfoType(map);
	}
	
	
	/**
	 * 
	 * 公示状态变更
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int updateInfoType(Map<String, Object> map) throws Exception {
		List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
		String infoState = map.get("info_state").toString();
		for (Map<String, Object> map2 : list) {
			String infoPubId = (String) map2.get("info_id");
			InfoPubWithBLOBs infoPub = infoPubMapper.selectByPrimaryKey(infoPubId);
			infoPub.setInfoState(infoState);
			String currentDateTime = DateUtil.getCurrentDateTime();
			if ("1".equals(infoState)) {
				infoPub.setInfoVersion(infoPub.getInfoVersion()+1);
				infoPub.setInfoPubdate(currentDateTime);
			}else {
				infoPub.setInfoPubdate(null);
			}
			infoPub.setUpdateDateTime(currentDateTime);
			infoPubMapper.updateByPrimaryKey(infoPub);
			List<Map<String, Object>> searchViewer = myInfoPubMapper.searchViewer(map2);
			sendMessage.setInfoPub(infoPub);
			sendMessage.setInfoState(infoState);
			sendMessage.setSenderId(map.get("emp_id").toString());
			sendMessage.setSearchViewer(searchViewer);
			Thread t = new Thread(sendMessage);
			t.start();
		}
		return 1;
	}

	
	
	/**
	 * 
	 * 公示查询
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> search(Map<String, Object> map) throws Exception {
		if (StringUtil.isNotEmpty((String)map.get("info_pubdate_start"))) {
			map.put("info_pubdate_start", ((String)map.get("info_pubdate_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String)map.get("info_pubdate_end"))) {
			map.put("info_pubdate_end", ((String)map.get("info_pubdate_end")).replace("-", "")+"235959");
		}
		if (StringUtil.isNotEmpty((String)map.get("create_date_time_start"))) {
			map.put("create_date_time_start", ((String)map.get("create_date_time_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String)map.get("create_date_time_end"))) {
			map.put("create_date_time_end", ((String)map.get("create_date_time_end")).replace("-", "")+"235959");
		}
		List<Map<String, Object>> byView = new ArrayList<Map<String, Object>>();
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
		Integer.parseInt(map.get("maxResult").toString()));
		if (StringUtil.isNotEmpty((String)map.get("info_state"))) {
			byView = myInfoPubMapper.searchInfoPub(map);
			}else{
				map.put("info_state", "1");
				byView = myInfoPubMapper.searchInfoPubByView(map);
			}
		for (Map<String, Object> tempMap : byView) {
			map.put("search", tempMap.get("info_owner_id"));
			Map<String, Object> empSearch = contactsService.commonEmpSearch(map);
			List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
			if (null!=empSearchList) {
				tempMap.put("emp_head_photo", empSearchList.get(0).get("emp_head_photo"));
				tempMap.put("emp_name", empSearchList.get(0).get("emp_name"));
				tempMap.put("org_name", empSearchList.get(0).get("org_name_owner"));
			}
			String time = (String) tempMap.get("info_pubdate");
			if (null != time&&StringUtil.isNotEmpty(time)) {
				time = time.substring(0, 4)+"-"+time.substring(4, 6)+"-"+time.substring(6, 8);
				tempMap.put("info_pubdate", time);
			}
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(byView);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", byView);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	
	
	
	/**
	 * 
	 * APP公示查询
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> appSearch(Map<String, Object> map) throws Exception {
		if (StringUtil.isNotEmpty((String)map.get("info_pubdate_start"))) {
			map.put("info_pubdate_start", ((String)map.get("info_pubdate_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String)map.get("info_pubdate_end"))) {
			map.put("info_pubdate_end", ((String)map.get("info_pubdate_end")).replace("-", "")+"235959");
		}
		if (StringUtil.isNotEmpty((String)map.get("create_date_time_start"))) {
			map.put("create_date_time_start", ((String)map.get("create_date_time_start")).replace("-", ""));
		}
		if (StringUtil.isNotEmpty((String)map.get("create_date_time_end"))) {
			map.put("create_date_time_end", ((String)map.get("create_date_time_end")).replace("-", "")+"235959");
		}
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
		Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);
		map.put("info_state", "1");
		List<Map<String, Object>> byView = myInfoPubMapper.searchInfoPubByView(map);
		for (Map<String, Object> tempMap : byView) {
			map.put("search", tempMap.get("info_owner_id"));
			Map<String, Object> empSearch = contactsService.commonEmpSearch(map);
			List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
			if (null!=empSearchList) {
				tempMap.put("emp_head_photo", empSearchList.get(0).get("emp_head_photo"));
				tempMap.put("emp_name", empSearchList.get(0).get("emp_name"));
				tempMap.put("org_name", empSearchList.get(0).get("org_name_owner"));
			}
			String time = (String) tempMap.get("info_pubdate");
			if (null != time&&StringUtil.isNotEmpty(time)) {
				time = time.substring(0, 4)+"-"+time.substring(4, 6)+"-"+time.substring(6, 8);
				tempMap.put("info_pubdate", time);
			}
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(byView);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", byView);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	
	/**
	 * 公示修改
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int updateInfopub(Map<String, Object> map) throws Exception {
		String infoId = (String) map.get("info_id");
		InfoPubWithBLOBs infoPub = infoPubMapper.selectByPrimaryKey(infoId);
		infoPub.setInfoContent((String)map.get("info_content"));
		infoPub.setInfoContentStyle((String)map.get("info_content_style"));
		infoPub.setInfoNumber((String)map.get("info_number"));
		if (StringUtil.isEmpty(map.get("info_order").toString())) {
			infoPub.setInfoOrder("0");
		}else {
			infoPub.setInfoOrder((String)map.get("info_order"));
		}
		infoPub.setInfoTitle((String)map.get("info_title"));
		infoPub.setInfoType((String)map.get("info_type_code"));
		infoPub.setSendim((String)map.get("sendim"));
		infoPub.setSendinfo((String)map.get("sendinfo"));
		infoPub.setInfoIseveryone(map.get("info_isEveryOne").toString());
		infoPub.setUpdateDateTime(DateUtil.getCurrentDateTime());
		infoPubMapper.updateByPrimaryKeyWithBLOBs(infoPub);
		myInfoPubMapper.deleteAttach(map);
		myInfoPubMapper.deleteViewer(map);
		List<Map<String,Object>> infoPubViewerList = (List<Map<String,Object>>) map.get("info_viewer");
		List<Map<String,Object>> infoPubAttachList = (List<Map<String,Object>>) map.get("info_attach");
		InfoPubViewer infoPubViewer = new InfoPubViewer();
		infoPubViewer.setInfoId(infoId);
		infoPubViewer.setCreateDateTime(DateUtil.getCurrentDateTime());
		infoPubViewer.setIsRead("0");
		if (!"1".equals(map.get("info_isEveryOne"))) {
			//添加公示查看人	
			for (Map<String, Object> map2 : infoPubViewerList) {
				infoPubViewer.setViewId((String)map2.get("view_id"));
				infoPubViewer.setViewName((String)map2.get("view_name"));
				infoPubViewer.setRemark((String)map2.get("remark"));
				infoPubViewerMapper.insert(infoPubViewer);
			}
		}else {
			Map<String, Object> searchAll = contactsService.searchAll(map);
			infoPubViewerList = (List<Map<String, Object>>) searchAll.get("data");
			for (Map<String, Object> map2 : infoPubViewerList) {
				infoPubViewer.setViewId((String)map2.get("emp_id"));
				infoPubViewer.setViewName((String)map2.get("emp_name"));
				infoPubViewer.setRemark((String)map2.get("remark"));
				infoPubViewerMapper.insert(infoPubViewer);
			}
		}
	//添加附件,可能为空,先进行判断	
		if(null!= infoPubAttachList&&infoPubAttachList.size()>0){
			int testCount = 0 ;
			for (Map<String, Object> map2 : infoPubAttachList) {
				InfoPubAttach infoPubAttach = new InfoPubAttach();
				infoPubAttach.setAttachId((String)map2.get("ATTACH_ID"));
				infoPubAttach.setAttachType((String)map2.get("attach_type"));
				infoPubAttach.setAttachName((String)map2.get("attach_name"));
				infoPubAttach.setInfopubAttachUrl((String)map2.get("infopub_attach_url"));
				infoPubAttach.setCreateDateTime(DateUtil.getCurrentDateTime());
				infoPubAttach.setInfoId(infoId);
				infoPubAttach.setNodeId((String)map2.get("node_id"));
				infoPubAttach.setInfoAttackId(serialService.getUUID());
				infoPubAttach.setRemark((String)map2.get("REMARK"));
				infoPubAttach.setTenantId(testCount+"");
				infoPubAttachMapper.insert(infoPubAttach);
				testCount++ ;
			}
		}
		return 1;
	}

}
