package com.zrt.flow.service.flowEntrust;

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
import com.zrt.flow.mapper.flowEntrust.FlowEntrustCustomMapper;
import com.zrt.flow.service.contacts.ContactsService;
import com.zrt.flow.service.serial.SerialService;
import com.zrt.mybatis.domain.FbBusEntrust;
import com.zrt.mybatis.domain.FbBusEntrustExample;
import com.zrt.mybatis.domain.FbBusTemplate;
import com.zrt.mybatis.mapper.FbBusEntrustMapper;
import com.zrt.mybatis.mapper.FbBusTemplateMapper;

@Service
public class FlowEntrustServiceImpl implements FlowEntrustService {

	@Autowired
	private FbBusEntrustMapper fbBusEntrustMapper;
	@Autowired
	private FbBusTemplateMapper fbBusTemplateMapper;
	@Autowired
	private FlowEntrustCustomMapper flowEntrustCustomMapper;
	@Autowired
	private SerialService serialService;
	@Autowired
	private ContactsService contactsService;

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getEntrustList(Map<String, Object> map) throws Exception {

		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);

		List<Map<String, Object>> dataList = flowEntrustCustomMapper.getEntrustList(map);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);

		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", pageInfo.getList());
		resMap.put("data", dataMap);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	public Map<String, Object> getAppEntrustList(Map<String, Object> map) throws Exception {

		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);

		List<Map<String, Object>> dataList = flowEntrustCustomMapper.getAppEntrustList(map);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);

		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", pageInfo.getList());
		resMap.put("data", dataMap);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void ent(Map<String, Object> map) throws Exception {

		String entrustedId = (String) map.get("entrusted_id");
		entrustedId=entrustedId.replaceAll(";", "");

		//登录人就是委托人
		String empId = (String) map.get("emp_id");
		//受委托人
		Map<String, Object> empMap = searchEmpMapByEmpId(empId);
		Map<String, Object> entrustedMap = searchEmpMapByEmpId(entrustedId);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> fbIdList = (List<Map<String, Object>>) map.get("param");
		if (fbIdList != null && fbIdList.size() > 0) {
			for (Map<String, Object> fbIdMap : fbIdList) {
				String fbId = (String) fbIdMap.get("fb_id");
				FbBusTemplate fb = fbBusTemplateMapper.selectByPrimaryKey(fbId);
				String tCode = fb.gettCode();
				FbBusEntrustExample example = new FbBusEntrustExample();
				example.createCriteria().andEntEmpIdEqualTo(entrustedId).andFbCodeEqualTo(tCode).andCheckEmpIdEqualTo(empId);
				List<FbBusEntrust> entList = fbBusEntrustMapper.selectByExample(example);
				if (entList != null && entList.size() > 0) {//一个流程不能重复委托给同一个人
					throw new AppException("《" + fb.gettName() + "》的受托人已委托过该流程!");
				} else {
					//删除已委托过的流程
					FbBusEntrustExample entExample = new FbBusEntrustExample();
					entExample.createCriteria().andCheckEmpIdEqualTo(empId).andFbCodeEqualTo(tCode);
					fbBusEntrustMapper.deleteByExample(entExample);
					
					FbBusEntrust fbBusEntrust = new FbBusEntrust();
					fbBusEntrust.setId(serialService.getUUID());
					fbBusEntrust.setFbId(fbId);
					fbBusEntrust.setFbCode(tCode);
					fbBusEntrust.setCheckEmpId(empId);
					fbBusEntrust.setCheckEmpName((String) empMap.get("emp_name"));
					fbBusEntrust.setEntEmpId(entrustedId);
					fbBusEntrust.setEntEmpName((String) entrustedMap.get("emp_name"));
					fbBusEntrust.setCreateDateTime(DateUtil.getCurrentDateTime());
					fbBusEntrust.setEntEnabled("1");
					fbBusEntrust.setBeginDateTime(DateUtil.getFormatFormat((String)map.get("begin_date_time"))+"000000");
					fbBusEntrust.setEndDateTime(DateUtil.getFormatFormat((String)map.get("end_date_time"))+"235959");

					fbBusEntrustMapper.insert(fbBusEntrust);
				}
			}

		}
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void cancel(Map<String, Object> map) throws Exception {

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> entrustIdList = (List<Map<String, Object>>) map.get("param");
		if (entrustIdList != null && entrustIdList.size() > 0) {
			for (Map<String, Object> entrustIdMap : entrustIdList) {
				String entrustId = (String) entrustIdMap.get("ent_id");
				fbBusEntrustMapper.deleteByPrimaryKey(entrustId);
			}
		}
	}

	/**
	 * 根据员工ID获取员工的相关信息
	 */
	public Map<String, Object> searchEmpMapByEmpId(String empId) {

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

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getList(Map<String, Object> map) throws Exception {
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);

		List<Map<String, Object>> dataList = flowEntrustCustomMapper.getList(map);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);

		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", pageInfo.getList());
		resMap.put("data", dataMap);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getAppList(Map<String, Object> map) throws Exception {
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);

		List<Map<String, Object>> dataList = flowEntrustCustomMapper.getAppList(map);
		if (dataList != null && dataList.size() > 0) {
			for (Map<String, Object> dataMap : dataList) {
				String entrustId = (String) dataMap.get("entrust_id");
				if (StringUtils.isNotBlank(entrustId)) {
					Map<String, Object> empMap = searchEmpMapByEmpId(entrustId);
					dataMap.put("entrust_org_id", (String) empMap.get("org_id"));
					dataMap.put("entrust_org_name", (String) empMap.get("org_name"));
					dataMap.put("entrust_emp_head_photo", (String) empMap.get("emp_head_photo"));
				}
				String entrustedId = (String) dataMap.get("entrusted_id");
				if (StringUtils.isNotBlank(entrustId)) {
					Map<String, Object> empMap = searchEmpMapByEmpId(entrustedId);
					dataMap.put("entrusted_org_id", (String) empMap.get("org_id"));
					dataMap.put("entrusted_org_name", (String) empMap.get("org_name"));
					dataMap.put("entrusted_emp_head_photo", (String) empMap.get("emp_head_photo"));
				}
			}
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);

		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", pageInfo.getList());
		resMap.put("data", dataMap);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

}
