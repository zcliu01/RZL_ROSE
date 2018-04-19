package com.zrt.flow.service.fmDic;

import java.util.ArrayList;
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
import com.zrt.commons.MapEntityConverter;
import com.zrt.commons.PageInit;
import com.zrt.commons.date.DateUtil;
import com.zrt.mybatis.domain.FmBusDic;
import com.zrt.mybatis.domain.FmBusDicExample;
import com.zrt.mybatis.domain.FmBusDicExample.Criteria;
import com.zrt.mybatis.mapper.FmBusDicMapper;

@Service
public class FmDicServiceImpl implements FmDicService {

	@Autowired
	private FmBusDicMapper fmBusDicMapper;

	@Override
	public Map<String, Object> getFmDicList(Map<String, Object> map) throws Exception {

		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);

		String colCode = (String) map.get("col_code");
		String colName = (String) map.get("col_name");
		String colDesc = (String) map.get("col_desc");

		FmBusDicExample example = new FmBusDicExample();
		Criteria criteria = example.createCriteria();

		if (StringUtils.isNotBlank(colCode)) {
			criteria.andColCodeLike(colCode + "%");
		}
		if (StringUtils.isNotBlank(colName)) {
			criteria.andColNameLike("%" + colName + "%");
		}
		if (StringUtils.isNotBlank(colDesc)) {
			criteria.andColDescLike("%" + colDesc + "%");
		}
		example.setOrderByClause(" create_date_time desc");
		List<FmBusDic> dataList = fmBusDicMapper.selectByExample(example);
		PageInfo<FmBusDic> pageInfo = new PageInfo<>(dataList);
		List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
		for (FmBusDic dic : dataList) {
			Map<String, Object> dicMap = new HashMap<>();
			dicMap.put("col_code", dic.getColCode());
			dicMap.put("col_name", dic.getColName());
			dicMap.put("col_desc", dic.getColDesc());
			resList.add(dicMap);
		}
		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap.put("list", resList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", listMap);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	/**
	 * 新增字典
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int save(Map<String, Object> map) throws Exception {

		FmBusDicExample example = new FmBusDicExample();
		Criteria criteria = example.createCriteria();
		criteria.andColCodeEqualTo((String) map.get("col_code"));
		int count = fmBusDicMapper.countByExample(example);

		if (count > 0) {
			throw new AppException("该字典已经存在!");
		} else {
			FmBusDic fmBusDic = new FmBusDic();
			fmBusDic.setColCode((String) map.get("col_code"));
			fmBusDic.setColName((String) map.get("col_name"));
			fmBusDic.setColDesc((String) map.get("col_desc"));
			fmBusDic.setColEnabled("1");
			fmBusDic.setCreateDateTime(DateUtil.getCurrentDateTime());
			return fmBusDicMapper.insert(fmBusDic);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getFormDetail(Map<String, Object> map) throws Exception {

		FmBusDic fmBusDic = fmBusDicMapper.selectByPrimaryKey((String) map.get("col_code"));

		Map<String, Object> dataMap = MapEntityConverter
				.getMapFromEntity(new String[] { "col_code", "col_name", "col_desc" }, fmBusDic);

		return dataMap;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int update(Map<String, Object> map) throws Exception {
		FmBusDic fmBusDic = fmBusDicMapper.selectByPrimaryKey((String) map.get("col_code"));
		fmBusDic.setColCode((String) map.get("col_code"));
		fmBusDic.setColName((String) map.get("col_name"));
		fmBusDic.setColDesc((String) map.get("col_desc"));

		return fmBusDicMapper.updateByPrimaryKeySelective(fmBusDic);

	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int delete(Map<String, Object> map) throws Exception {

		return fmBusDicMapper.deleteByPrimaryKey((String) map.get("col_code"));

	}

}
