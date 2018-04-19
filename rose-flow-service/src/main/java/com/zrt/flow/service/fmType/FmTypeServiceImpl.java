package com.zrt.flow.service.fmType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.commons.AppException;
import com.zrt.commons.MapEntityConverter;
import com.zrt.commons.date.DateUtil;
import com.zrt.flow.service.serial.SerialService;
import com.zrt.mybatis.domain.FmBusTemplateExample;
import com.zrt.mybatis.domain.FmBusType;
import com.zrt.mybatis.domain.FmBusTypeExample;
import com.zrt.mybatis.domain.FmBusTypeExample.Criteria;
import com.zrt.mybatis.mapper.FmBusTemplateMapper;
import com.zrt.mybatis.mapper.FmBusTypeMapper;

@Service
public class FmTypeServiceImpl implements FmTypeService {

	@Autowired
	private FmBusTypeMapper fmBusTypeMapper;
	@Autowired
	private FmBusTemplateMapper fmBusTemplateMapper;
	@Autowired
	private SerialService serialService;

	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getFmTypeList(Map<String, Object> map) throws Exception {

		FmBusTypeExample example = new FmBusTypeExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank((String) map.get("t_name"))) {
			criteria.andTNameLike((String) map.get("t_name")+"%");
		}
		criteria.andTEnabledEqualTo("1");
		List<FmBusType> list = fmBusTypeMapper.selectByExample(example);

		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		if (list != null && list.size() > 0) {
			for (FmBusType fmBusType : list) {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				dataMap.put("id", fmBusType.getId());
				dataMap.put("parent_id", fmBusType.getParentId());
				dataMap.put("t_name", fmBusType.gettName());
				dataMap.put("t_desc", fmBusType.gettDesc());
				dataMap.put("create_date_time", fmBusType.getCreateDateTime());
				dataMap.put("update_date_time", fmBusType.getUpdateDateTime());

				listMap.add(dataMap);
			}
		}
		return listMap;
	}

	public List<Map<String, Object>> convertinforDomain(List<FmBusType> listDomain)
			throws ReflectiveOperationException {
		List<Map<String, Object>> listMap = new ArrayList<>();
		for (FmBusType FmBusType : listDomain) {
			Map<String, Object> map = MapEntityConverter.getMapFromEntity(
					new String[] { "id", "parent_id", "t_name", "t_desc", "create_date_time", "update_date_time" },
					FmBusType);

			listMap.add(map);
		}
		return listMap;
	}

	/**
	 * 新增分类
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int save(Map<String, Object> map) throws Exception {

		FmBusTypeExample example = new FmBusTypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andTNameEqualTo((String) map.get("t_name"));
		int count = fmBusTypeMapper.countByExample(example);

		if (count > 0) {
			throw new AppException("该分类已经存在!");
		} else {
			FmBusType FmBusType = new FmBusType();
			FmBusType.setId(serialService.getUUID());
			if (StringUtils.isNotBlank((String) map.get("parent_id"))) {
				FmBusType.setParentId((String) map.get("parent_id"));
			}
			FmBusType.settName((String) map.get("t_name"));
			FmBusType.settDesc((String) map.get("t_desc"));
			FmBusType.setCreateDateTime(DateUtil.getCurrentDateTime());
			FmBusType.settEnabled("1");
			return fmBusTypeMapper.insert(FmBusType);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getFmTypeDetail(Map<String, Object> map) throws Exception {

		FmBusType FmBusType = fmBusTypeMapper.selectByPrimaryKey((String) map.get("id"));

		Map<String, Object> dataMap = MapEntityConverter.getMapFromEntity(
				new String[] { "id", "parent_id", "t_name", "t_desc", "create_date_time", "update_date_time" },
				FmBusType);

		return dataMap;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int update(Map<String, Object> map) throws Exception {

		FmBusType FmBusType = fmBusTypeMapper.selectByPrimaryKey((String) map.get("id"));
		FmBusType.settName((String) map.get("t_name"));
		FmBusType.settDesc((String) map.get("t_desc"));
		FmBusType.setUpdateDateTime(DateUtil.getCurrentDateTime());

		return fmBusTypeMapper.updateByPrimaryKeySelective(FmBusType);
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int delete(Map<String, Object> map) throws Exception {

		FmBusTemplateExample example = new FmBusTemplateExample();
		com.zrt.mybatis.domain.FmBusTemplateExample.Criteria criteria = example.createCriteria();
		criteria.andFBTIdEqualTo((String) map.get("id"));
		int count = fmBusTemplateMapper.countByExample(example);

		if (count > 0) {
			throw new AppException("该分类下有表单，不能删除！");
		} else {

			return fmBusTypeMapper.deleteByPrimaryKey((String) map.get("id"));
		}
	}

}
