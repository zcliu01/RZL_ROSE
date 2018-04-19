package com.zrt.daywork.service.wkrecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.zrt.commons.PageInit;
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.daywork.mapper.wkrecord.WkRecordListMapper;
import com.zrt.daywork.service.contacts.ContactsService;
import com.zrt.daywork.service.serial.SerialService;
import com.zrt.mybatis.domain.WkRecord;
import com.zrt.mybatis.domain.WkRecordExample;
import com.zrt.mybatis.domain.WkRecordExample.Criteria;
import com.zrt.mybatis.mapper.WkRecordMapper;

@Service("wkRecordServiceImpl")
public class WkRecordServiceImpl implements WkRecordService {
	

	@Autowired
	private WkRecordMapper wkRecordMapper;
	
	@Autowired
	private WkRecordListMapper wkRecordListMapper;
	@Autowired
	private SerialService serialService;
	@Autowired
	private ContactsService contactsService;

	//添加日程
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int save(Map<String, Object> map) throws Exception {
		if(StringUtil.isEmpty((String)map.get("wk_name"))) {
			return 120;
		}
		String begin = (String)map.get("begin_date_time");
		String end = (String)map.get("end_date_time");
		if (begin.length()==16) {
			begin = DateUtil.getFormatFormat((String)map.get("begin_date_time")+":00");
			end = DateUtil.getFormatFormat((String)map.get("end_date_time")+":00");
		}
		long beginLong = Long.parseLong(begin);
		long endLong = Long.parseLong(end);
		if (beginLong >= endLong) {
			return 130;
		}
		WkRecord wkRecord = new WkRecord();
		wkRecord.setCreateDateTime(DateUtil.getCurrentDateTime());
		wkRecord.setId(serialService.getUUID());
		wkRecord.setCreateEmpId((String)map.get("emp_id"));
		wkRecord.setWkName((String)map.get("wk_name"));
		wkRecord.setWkDesc((String)map.get("wk_desc"));
		wkRecord.setBeginDateTime(begin);
		wkRecord.setEndDateTime(end);
		String relType = (String)map.get("rel_type");
		wkRecord.setRelCode((String)map.get("rel_code"));
		map.put("search", map.get("emp_id"));
		// 将员工信息返回
		Map<String, Object> commonEmpSearch = contactsService.commonEmpSearch(map);
		List<Map<String, Object>> searchList = (List<Map<String, Object>>) commonEmpSearch.get("data");

		wkRecord.setCreateEmpName(searchList.get(0).get("emp_name").toString());
		if (StringUtil.isNotEmpty(relType)) {
			wkRecord.setRelType(relType);
		}else {
			wkRecord.setRelType("0");
		}
		return wkRecordMapper.insert(wkRecord);
	}
	
	//删除日程
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int delete(Map<String, Object> map) throws Exception {
		String id = (String) map.get("id");
		return wkRecordMapper.deleteByPrimaryKey(id);
	}
	
	
	//批量删除日程
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int deleteList(Map<String, Object> appMap) throws Exception {
		List<String> allIdList = new ArrayList<String>();
		List<Map<String, Object>> list = (List<Map<String, Object>>) appMap.get("param");
		for (Map<String, Object> map : list) {
			String id = (String) map.get("id");
			allIdList.add(id);
		}
		WkRecordExample wkRecordExample = new WkRecordExample();
		Criteria createCriteria = wkRecordExample.createCriteria();
		createCriteria.andIdIn(allIdList);
		wkRecordMapper.deleteByExample(wkRecordExample);
		return 1;
	}

	//更新日程
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int update(Map<String, Object> map) throws Exception {
		WkRecord wkRecord = wkRecordMapper.selectByPrimaryKey((String)map.get("id"));
		wkRecord.setWkDesc((String)map.get("wk_desc"));
		wkRecord.setWkName((String)map.get("wk_name"));
		String begin = (String)map.get("begin_date_time")+":00";
		String end = (String)map.get("end_date_time")+":00";
		wkRecord.setBeginDateTime(DateUtil.getFormatFormat(begin));
		wkRecord.setEndDateTime(DateUtil.getFormatFormat(end));
		wkRecord.setUpdateDateTime(DateUtil.getCurrentDateTime());
		return wkRecordMapper.updateByPrimaryKey(wkRecord);
	}

	//查询日程详情
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> detail(Map<String, Object> map) throws Exception {
		
		WkRecord wkRecord = wkRecordMapper.selectByPrimaryKey((String)map.get("id"));
		wkRecord.setBeginDateTime(wkRecord.getBeginDateTime().substring(0, 4)+"-"+wkRecord.getBeginDateTime().substring(4, 6)+"-"+wkRecord.getBeginDateTime().substring(6, 8)+" "+wkRecord.getBeginDateTime().substring(8, 10)+":"+wkRecord.getBeginDateTime().substring(10, 12));
		wkRecord.setEndDateTime(wkRecord.getEndDateTime().substring(0, 4)+"-"+wkRecord.getEndDateTime().substring(4, 6)+"-"+wkRecord.getEndDateTime().substring(6, 8)+" "+wkRecord.getEndDateTime().substring(8, 10)+":"+wkRecord.getEndDateTime().substring(10, 12));
		
		Map<String, Object> entity = MapEntityConverter.getMapFromEntity(new String[]{"id","wk_name","wk_desc","begin_date_time","end_date_time","rel_type","rel_code"}, wkRecord);
		return entity;
				
	}

	//查询日程列表
	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> list(Map<String, Object> map) throws Exception {
		List<Map<String, Object>> wkList = new ArrayList<Map<String, Object>>();
		if(StringUtil.isNotEmpty((String)map.get("begin_date_time"))&&StringUtil.isNotEmpty((String)map.get("end_date_time"))){
			String begin = (String) map.get("begin_date_time");
			String end = (String) map.get("end_date_time");
			if (begin.length()==10) {
				begin = begin+" 00:00:00";
			}
			if (begin.length()==13) {
				begin = begin+":00:00";
			}
			if (begin.length()==16) {
				begin = begin+":00";
			}
			if (end.length()==10) {
				end = end+" 23:59:59";
			}
			if (end.length()==13) {
				end = end+":59:59";
			}
			if (end.length()==16) {
				end = end+":59";
			}
			List<String> betweenDates = DateUtil.getBetweenDates(DateUtil.getDateString(begin), DateUtil.getDateString(end));
			for (String string : betweenDates) {
				Map<String, Object> tempMap = new HashMap<String, Object>();
				tempMap.put("wk_day", string);
				string  = string.replace("-", "");
				map.put("wk_day", string);
				List<Map<String, Object>> list2 = wkRecordListMapper.list(map);
				for (Map<String, Object> map2 : list2) {
					String beginTime = (String) map2.get("begin_date_time");
					String endTime = (String) map2.get("end_date_time");
					beginTime = beginTime.substring(0, 4)+"-"+beginTime.substring(4, 6)+"-"+beginTime.substring(6, 8)+" "+beginTime.substring(8, 10)+":"+beginTime.substring(10, 12);
					endTime = endTime.substring(0, 4)+"-"+endTime.substring(4, 6)+"-"+endTime.substring(6, 8)+" "+endTime.substring(8, 10)+":"+endTime.substring(10, 12);
					map2.put("begin_date_time", beginTime);
					map2.put("end_date_time", endTime);

				}
				tempMap.put("list", list2);
				wkList.add(tempMap);
			}
		}
		else{
				Map<String, Object> dayMap = new HashMap<String,Object>();
				String time = (String)map.get("day_time");
				dayMap.put("wk_day",time);
				List<Map<String, Object>> list = wkRecordListMapper.list(map);
				for (Map<String, Object> map2 : list) {
					String begin = (String) map2.get("begin_date_time");
					String end = (String) map2.get("end_date_time");
					begin = begin.substring(0, 4)+"-"+begin.substring(4, 6)+"-"+begin.substring(6, 8)+" "+begin.substring(8, 10)+":"+begin.substring(10, 12);
					end = end.substring(0, 4)+"-"+end.substring(4, 6)+"-"+end.substring(6, 8)+" "+end.substring(8, 10)+":"+end.substring(10, 12);
					map2.put("begin_date_time", begin);
					map2.put("end_date_time", end);

				}
				dayMap.put("list", list);
				wkList.add(dayMap);
		}
		
		return wkList;
	}
	
	
	/* 
	 * 查看全部日程
	 * 
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> checkAll(Map<String, Object> map) throws Exception {
			PageInit.setPage(map);
			PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
			Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);
			if (StringUtil.isNotEmpty((String) map.get("begin_time_begin"))) {
				String begin_time_begin = ((String) map.get("begin_time_begin")).replace("-", "").replace(" ", "").replace(":", "");
				map.put("begin_time_begin", begin_time_begin);
			}
			if (StringUtil.isNotEmpty((String) map.get("begin_time_end"))) {
				String begin_time_end = ((String) map.get("begin_time_end")).replace("-", "").replace(" ", "").replace(":", "");
				//String begin_time_end = DateUtil.getFormatFormat((String) map.get("begin_time_end")+":00");
				map.put("begin_time_end", begin_time_end);
			}
			if (StringUtil.isNotEmpty((String) map.get("end_time_begin"))) {
				String end_time_begin = ((String) map.get("end_time_begin")).replace("-", "").replace(" ", "").replace(":", "");
				if (end_time_begin.length()==12) {
					end_time_begin = end_time_begin+"59";
				}else if (end_time_begin.length()==10) {
					end_time_begin = end_time_begin+"5959";
				}else if (end_time_begin.length()==8){
					end_time_begin = end_time_begin+"235959";
				}
				map.put("end_time_begin", end_time_begin);
			}
			if (StringUtil.isNotEmpty((String) map.get("end_time_end"))) {
				String end_time_end = ((String) map.get("end_time_end")).replace("-", "").replace(" ", "").replace(":", "");
				if (end_time_end.length()==12) {
					end_time_end = end_time_end+"59";
				}else if (end_time_end.length()==10) {
					end_time_end = end_time_end+"5959";
				}else if (end_time_end.length()==8){
					end_time_end = end_time_end+"235959";
				}
				map.put("end_time_end", end_time_end);
			}
		List<Map<String, Object>> checkAll = wkRecordListMapper.checkAll(map);
		for (Map<String, Object> map2 : checkAll) {
			String begin = (String) map2.get("begin_date_time");
			String end = (String) map2.get("end_date_time");
			begin = begin.substring(0, 4)+"-"+begin.substring(4, 6)+"-"+begin.substring(6, 8)+" "+begin.substring(8, 10)+":"+begin.substring(10, 12);
			end = end.substring(0, 4)+"-"+end.substring(4, 6)+"-"+end.substring(6, 8)+" "+end.substring(8, 10)+":"+end.substring(10, 12);
			map2.put("begin_date_time", begin);
			map2.put("end_date_time", end);
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(checkAll);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("list", pageInfo.getList());
		resMap.put("count", pageInfo.getTotal());

		return resMap;
	}

	/**
	 * 
	 * 查询所有日期
	 */
	@Override
	@Transactional(readOnly = true)
	public Set<String> searchDate(Map<String, Object> map) throws Exception {
		List<Map<String, Object>> searchTime = wkRecordListMapper.searchTime(map);
		Set<String> result = new HashSet<String>();
		for (Map<String, Object> map2 : searchTime) {
			String begin = (String) map2.get("begin_date_time");
			String end = (String) map2.get("end_date_time");
			begin = begin.substring(0, 4)+"-"+begin.substring(4, 6)+"-"+begin.substring(6, 8);
			end = end.substring(0, 4)+"-"+end.substring(4, 6)+"-"+end.substring(6, 8);
			List<String> dates = DateUtil.getBetweenDates(begin, end);
			for (String string : dates) {
				result.add(string);
			}
		}
		
		return result;
	}

	
	
}
