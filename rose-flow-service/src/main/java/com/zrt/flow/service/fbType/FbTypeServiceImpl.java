package com.zrt.flow.service.fbType;

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
import com.zrt.mybatis.domain.FbBusTemplateExample;
import com.zrt.mybatis.domain.FbBusType;
import com.zrt.mybatis.domain.FbBusTypeExample;
import com.zrt.mybatis.domain.FbBusTypeExample.Criteria;
import com.zrt.mybatis.mapper.FbBusTemplateMapper;
import com.zrt.mybatis.mapper.FbBusTypeMapper;

@Service
public class FbTypeServiceImpl implements FbTypeService {

	@Autowired
	private FbBusTypeMapper fbBusTypeMapper;
	@Autowired
	private FbBusTemplateMapper fbBusTemplateMapper;
	@Autowired
	private SerialService serialService;

	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getFmTypeList(Map<String, Object> map) throws Exception {

		FbBusTypeExample example = new FbBusTypeExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank((String) map.get("t_name"))) {
			criteria.andTNameEqualTo((String) map.get("t_name"));
		}
		criteria.andTEnabledEqualTo("1");
		List<FbBusType> list = fbBusTypeMapper.selectByExample(example);

		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();

		if (list != null && list.size() > 0) {
			for (FbBusType fbBusType : list) {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				dataMap.put("id", fbBusType.getId());
				dataMap.put("parent_id", fbBusType.getParentId());
				dataMap.put("t_name", fbBusType.gettName());
				dataMap.put("t_desc", fbBusType.gettDesc());
				dataMap.put("create_date_time", fbBusType.getCreateDateTime());
				dataMap.put("update_date_time", fbBusType.getUpdateDateTime());

				listMap.add(dataMap);
			}
		}
		return listMap;
	}

	public List<Map<String, Object>> convertinforDomain(List<FbBusType> listDomain)
			throws ReflectiveOperationException {
		List<Map<String, Object>> listMap = new ArrayList<>();
		for (FbBusType FbBusType : listDomain) {
			Map<String, Object> map = MapEntityConverter.getMapFromEntity(
					new String[] { "id", "parent_id", "t_name", "t_desc", "create_date_time", "update_date_time" },
					FbBusType);

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

		FbBusTypeExample example = new FbBusTypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andTNameEqualTo((String) map.get("t_name"));
		int count = fbBusTypeMapper.countByExample(example);

		if (count > 0) {
			throw new AppException("该分类已经存在!");
		} else {
			FbBusType FbBusType = new FbBusType();
			FbBusType.setId(serialService.getUUID());
			if (StringUtils.isNotBlank((String) map.get("parent_id"))) {
				FbBusType.setParentId((String) map.get("parent_id"));
			}
			FbBusType.settName((String) map.get("t_name"));
			FbBusType.settDesc((String) map.get("t_desc"));
			FbBusType.setCreateDateTime(DateUtil.getCurrentDateTime());
			FbBusType.settEnabled("1");
			return fbBusTypeMapper.insert(FbBusType);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getFmTypeDetail(Map<String, Object> map) throws Exception {

		FbBusType FbBusType = fbBusTypeMapper.selectByPrimaryKey((String) map.get("id"));

		Map<String, Object> dataMap = MapEntityConverter.getMapFromEntity(
				new String[] { "id", "parent_id", "t_name", "t_desc", "create_date_time", "update_date_time" },
				FbBusType);

		return dataMap;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int update(Map<String, Object> map) throws Exception {

		FbBusType FbBusType = fbBusTypeMapper.selectByPrimaryKey((String) map.get("id"));
		FbBusType.settName((String) map.get("t_name"));
		FbBusType.settDesc((String) map.get("t_desc"));
		FbBusType.setUpdateDateTime(DateUtil.getCurrentDateTime());

		return fbBusTypeMapper.updateByPrimaryKeySelective(FbBusType);
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int delete(Map<String, Object> map) throws Exception {

		FbBusTypeExample fbBusTypeExample = new FbBusTypeExample();
		fbBusTypeExample.createCriteria().andParentIdEqualTo((String) map.get("id"));
		List<FbBusType> fbBusTypeList = fbBusTypeMapper.selectByExample(fbBusTypeExample);
		if (fbBusTypeList != null && fbBusTypeList.size() > 0) {
			throw new AppException("该分类为一级分类，不能删除！");
		} else {
			FbBusTemplateExample example = new FbBusTemplateExample();
			com.zrt.mybatis.domain.FbBusTemplateExample.Criteria criteria = example.createCriteria();
			criteria.andFBTIdEqualTo((String) map.get("id"));
			int count = fbBusTemplateMapper.countByExample(example);

			if (count > 0) {
				throw new AppException("该分类下有流程，不能删除！");
			} else {

				return fbBusTypeMapper.deleteByPrimaryKey((String) map.get("id"));
			}
		}

	}

}
