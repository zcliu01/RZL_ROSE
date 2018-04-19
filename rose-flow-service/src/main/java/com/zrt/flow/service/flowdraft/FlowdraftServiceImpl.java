package com.zrt.flow.service.flowdraft;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.PageInit;
import com.zrt.flow.mapper.flowdraft.FlowdraftMapper;
import com.zrt.flow.service.contacts.ContactsService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dwliu on 2017/9/19.
 */
@Service
public class FlowdraftServiceImpl implements FlowdraftService {

	@Autowired
	private FlowdraftMapper flowdraftMapper;
	@Autowired
	private ContactsService contactsService;

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> flowdraftList(Map<String, Object> map) throws Exception {
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);
		List<Map<String, Object>> dataList = flowdraftMapper.flowdraftList(map);
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
	public Map<String, Object> appFlowdraftList(Map<String, Object> map) throws Exception {
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);
		List<Map<String, Object>> dataList = flowdraftMapper.appFlowdraftList(map);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);
		for (Map<String, Object> applyMap : dataList) {
			Map<String, Object> applyEmpData = getEmpInfo((String) applyMap.get("apply_id"));
			String headPhoto = (String) applyEmpData.get("emp_head_photo");
			if (StringUtils.isNotBlank(headPhoto)) {
				applyMap.put("apply_emp_head_photo", headPhoto);
			} else {
				applyMap.put("apply_emp_head_photo", "");
			}
		}

		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", dataList);
		resMap.put("data", dataMap);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	public Map<String, Object> getEmpInfo(String emp_id) {
		Map<String, Object> conmap = new HashMap<>();
		conmap.put("search", emp_id);
		Map<String, Object> result = contactsService.commonEmpSearch(conmap);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> li = (List<Map<String, Object>>) result.get("data");
		Map<String, Object> data = new HashMap<String, Object>();
		if (null != li && li.size() > 0) {
			data = li.get(0);
		}
		return data;
	}
}
