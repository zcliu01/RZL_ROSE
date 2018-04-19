package com.zrt.flow.service.fmDicPm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.AppException;
import com.zrt.commons.MapEntityConverter;
import com.zrt.commons.PageInit;
import com.zrt.flow.service.serial.SerialService;
import com.zrt.mybatis.domain.FbBusDicParam;
import com.zrt.mybatis.domain.FbBusDicParamExample;
import com.zrt.mybatis.domain.FbBusDicParamExample.Criteria;
import com.zrt.mybatis.mapper.FbBusDicParamMapper;

@Service
public class FmDicPmServiceImpl implements FmDicPmService {

	@Autowired
	private FbBusDicParamMapper fbBusDicParamMapper;
	@Autowired
	private SerialService serialService;

	@Override
	public Map<String, Object> getFmDicPmList(Map<String, Object> map) throws Exception {

		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);

		FbBusDicParamExample example = new FbBusDicParamExample();

		List<FbBusDicParam> dataList = fbBusDicParamMapper.selectByExample(example);
		PageInfo<FbBusDicParam> pageInfo = new PageInfo<>(dataList);

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", pageInfo.getList());
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	/**
	 * 新增字典
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int save(Map<String, Object> map) throws Exception {

		FbBusDicParamExample example = new FbBusDicParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andParamCodeEqualTo((String) map.get("param_code"));
		int count = fbBusDicParamMapper.countByExample(example);

		if (count > 0) {
			throw new AppException("该字典参数已经存在!");
		} else {
			FbBusDicParam fmBusDic = new FbBusDicParam();
			fmBusDic.setId(serialService.getUUID());
			fmBusDic.setColCode((String) map.get("col_code"));
			fmBusDic.setParamCode((String) map.get("param_code"));
			fmBusDic.setParamEnabled((String) map.get("param_enabled"));

			return fbBusDicParamMapper.insert(fmBusDic);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getFormDetail(Map<String, Object> map) throws Exception {

		FbBusDicParam fmBusDic = fbBusDicParamMapper.selectByPrimaryKey((String) map.get("id"));

		Map<String, Object> dataMap = MapEntityConverter
				.getMapFromEntity(new String[] { "id", "col_code", "param_code", "param_enabled" }, fmBusDic);

		return dataMap;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int update(Map<String, Object> map) throws Exception {
		FbBusDicParamExample example = new FbBusDicParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andParamCodeEqualTo((String) map.get("param_code"));
		List<FbBusDicParam> fmBusDicLi = fbBusDicParamMapper.selectByExample(example);
		FbBusDicParam pa = new FbBusDicParam();
		if (fmBusDicLi != null && fmBusDicLi.size() > 0) {
			pa = fmBusDicLi.get(0);
		}
		pa.setParamCode((String) map.get("param_code"));
		pa.setParamEnabled((String) map.get("param_enabled"));

		return fbBusDicParamMapper.updateByExampleSelective(pa, example);

	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int delete(Map<String, Object> map) throws Exception {

		return fbBusDicParamMapper.deleteByPrimaryKey((String) map.get("id"));

	}

}
