package com.zrt.flow.service.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.AppException;
import com.zrt.commons.MapEntityConverter;
import com.zrt.commons.PageInit;
import com.zrt.commons.date.DateUtil;
import com.zrt.flow.mapper.form.FormCustomMapper;
import com.zrt.flow.service.contacts.ContactsService;
import com.zrt.flow.service.serial.SerialService;
import com.zrt.mybatis.domain.FbBusFm;
import com.zrt.mybatis.domain.FbBusFmExample;
import com.zrt.mybatis.domain.FmBusFile;
import com.zrt.mybatis.domain.FmBusFileExample;
import com.zrt.mybatis.domain.FmBusFileExample.Criteria;
import com.zrt.mybatis.domain.FmBusRelevance;
import com.zrt.mybatis.domain.FmBusRelevanceExample;
import com.zrt.mybatis.domain.FmBusTemplate;
import com.zrt.mybatis.domain.FmBusTemplateExample;
import com.zrt.mybatis.domain.FmBusTemplateWithBLOBs;
import com.zrt.mybatis.mapper.FbBusFmMapper;
import com.zrt.mybatis.mapper.FmBusFileMapper;
import com.zrt.mybatis.mapper.FmBusRelevanceMapper;
import com.zrt.mybatis.mapper.FmBusTemplateMapper;

@Service
public class FormServiceImpl implements FormService {

	@Autowired
	private FmBusTemplateMapper fmBusTemplateMapper;
	@Autowired
	private FmBusRelevanceMapper fmBusRelevanceMapper;
	@Autowired
	private FmBusFileMapper fmBusFileMapper;
	@Autowired
	private FormCustomMapper formCustomMapper;
	@Autowired
	private FbBusFmMapper fbBusFmMapper;
	@Autowired
	private SerialService serialService;
	@Autowired
	private ContactsService contactsService;

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getFormList(Map<String, Object> map) throws Exception {

		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);

		List<Map<String, Object>> dataList = formCustomMapper.getFormList(map);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", pageInfo.getList());
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	/**
	 * 新增表单
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int save(Map<String, Object> map) throws Exception {

		FmBusTemplateExample example = new FmBusTemplateExample();
		com.zrt.mybatis.domain.FmBusTemplateExample.Criteria criteria = example.createCriteria();
		criteria.andTNameEqualTo((String) map.get("t_name"));
		int count = fmBusTemplateMapper.countByExample(example);

		if (count > 0) {
			throw new AppException("该表单已经存在!");
		} else {
			FmBusTemplateWithBLOBs fmBusTemplate = new FmBusTemplateWithBLOBs();
			fmBusTemplate.setId(serialService.getUUID());
			fmBusTemplate.settName((String) map.get("t_name"));
			fmBusTemplate.settCode(serialService.getSerialNumberFromDB("flow_form_code"));
			fmBusTemplate.setfBTId((String) map.get("t_type_id"));
			fmBusTemplate.settDesc((String) map.get("t_desc"));
			fmBusTemplate.setCreateDateTime(DateUtil.getCurrentDateTime());
			fmBusTemplate.settEnabled((String) map.get("t_enabled"));
			fmBusTemplate.setCreateEmpId((String) map.get("emp_id"));
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
				fmBusTemplate.setCreateEmpName(data.get("emp_name") == null ? null : data.get("emp_name").toString());
			}
			fmBusTemplate.setVersion(1);

			return fmBusTemplateMapper.insert(fmBusTemplate);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getFormDetail(Map<String, Object> map) throws Exception {

		FmBusTemplate fmBusTemplate = fmBusTemplateMapper.selectByPrimaryKey((String) map.get("id"));

		Map<String, Object> dataMap = MapEntityConverter.getMapFromEntity(new String[] { "id", "t_code", "t_name",
				"t_desc", "t_enabled", "t_type_id", "t_type_name", "create_date_time", "update_date_time" },
				fmBusTemplate);

		return dataMap;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int update(Map<String, Object> map) throws Exception {
		FmBusTemplateWithBLOBs fmBusTemplate = fmBusTemplateMapper.selectByPrimaryKey((String) map.get("id"));
		fmBusTemplate.settName((String) map.get("t_name"));
		fmBusTemplate.settDesc((String) map.get("t_desc"));
		fmBusTemplate.setfBTId((String) map.get("t_type_id"));
		fmBusTemplate.settEnabled((String) map.get("t_enabled"));
		fmBusTemplate.setUpdateDateTime(DateUtil.getCurrentDateTime());
		fmBusTemplate.setUpdateEmpId((String) map.get("emp_id"));
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
			fmBusTemplate.setUpdateEmpName(data.get("emp_name") == null ? null : data.get("emp_name").toString());
		}
		fmBusTemplate.setVersion(fmBusTemplate.getVersion() + 1);

		return fmBusTemplateMapper.updateByPrimaryKeySelective(fmBusTemplate);

	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int delete(Map<String, Object> map) throws Exception {

		FbBusFmExample example = new FbBusFmExample();
		com.zrt.mybatis.domain.FbBusFmExample.Criteria criteria = example.createCriteria();
		criteria.andFmIdEqualTo((String) map.get("id"));
		List<FbBusFm> list = fbBusFmMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			throw new AppException("该表单已关联流程，不能删除！");
		} else {
			return fmBusTemplateMapper.deleteByPrimaryKey((String) map.get("id"));
		}

	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int openOrCloseform(Map<String, Object> map) throws Exception {
		FmBusTemplateWithBLOBs FmBusTemplate = fmBusTemplateMapper.selectByPrimaryKey((String) map.get("id"));
		FmBusTemplate.settEnabled((String) map.get("t_enabled"));

		return fmBusTemplateMapper.updateByPrimaryKeySelective(FmBusTemplate);
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> getFormElementDetail(Map<String, Object> map) throws Exception {

		FmBusTemplateWithBLOBs fmBusTemplate = fmBusTemplateMapper.selectByPrimaryKey((String) map.get("id"));

		Map<String, Object> dataMap =new HashMap<>();
		dataMap.put("id", fmBusTemplate.getId());
		dataMap.put("t_code", fmBusTemplate.gettCode());
		dataMap.put("t_name", fmBusTemplate.gettName());
		dataMap.put("t_desc", fmBusTemplate.gettDesc());
		dataMap.put("t_html", fmBusTemplate.gettHtml());
		dataMap.put("template", fmBusTemplate.gettTemplate());
		//查询表单绑定的附件
		FmBusFileExample fileExample=new FmBusFileExample();
		Criteria fileCriteria= fileExample.createCriteria();
		fileCriteria.andFmIdEqualTo((String) map.get("id"));
		List<FmBusFile> fileList=fmBusFileMapper.selectByExample(fileExample);
		List<Map<String, Object>> flList=new ArrayList<>();
		for(FmBusFile file:fileList){
			Map<String, Object> dtMap=new HashMap<String, Object>();
			dtMap.put("file_url", file.getFileUrl());
			dtMap.put("file_name", file.getFileName());
			dtMap.put("file_type", file.getFileType());
			flList.add(dtMap);
		}
		//查询表单绑定的附件
		FmBusRelevanceExample relExample=new FmBusRelevanceExample();
		com.zrt.mybatis.domain.FmBusRelevanceExample.Criteria relCriteria= relExample.createCriteria();
		relCriteria.andFmIdEqualTo((String) map.get("id"));
		List<FmBusRelevance> relList=fmBusRelevanceMapper.selectByExample(relExample);
		List<Map<String, Object>> reList=new ArrayList<>();
		for(FmBusRelevance rl:relList){
			Map<String, Object> dtMap=new HashMap<String, Object>();
			dtMap.put("rel_id", rl.getRelId());
			dtMap.put("rel_name", rl.getRelName());
			dtMap.put("rel_type", rl.getRelType());
			reList.add(dtMap);
		}
		
		//附件list
		dataMap.put("file", flList);
		//讯息list
		dataMap.put("rel", reList);

//		String tTemplate = fmBusTemplate.gettTemplate();
//		Map<String, Object> temMap = (Map<String, Object>) JSON.parseObject(tTemplate);
//		dataMap.put("tTemplate", temMap.get("tTemplate"));

		return dataMap;
	}

	/**
	 * 表单元素保存
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int formsave(Map<String, Object> map) throws Exception {
		FmBusTemplateWithBLOBs fmBusTemplate = fmBusTemplateMapper.selectByPrimaryKey((String) map.get("id"));
		//表单信息
		ObjectMapper mapper = new ObjectMapper();
		Object temMap = mapper.writeValueAsString(map.get("template"));
		fmBusTemplate.settTemplate((String)temMap);
		fmBusTemplate.settHtml((String) map.get("t_html"));
		
        //新增一条发布状态的表单信息
		FmBusTemplateWithBLOBs newfmBusTemplate = new FmBusTemplateWithBLOBs();
		BeanUtils.copyProperties(fmBusTemplate, newfmBusTemplate);
		newfmBusTemplate.setId(serialService.getUUID());
		newfmBusTemplate.settEnabled("3");//发布状态
		newfmBusTemplate.setUpdateDateTime(DateUtil.getCurrentDateTime());
		newfmBusTemplate.setUpdateEmpId((String) map.get("emp_id"));
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
			newfmBusTemplate.setUpdateEmpName(data.get("emp_name") == null ? null : data.get("emp_name").toString());
		}
		newfmBusTemplate.setVersion(fmBusTemplate.getVersion() + 1);
		fmBusTemplateMapper.insert(newfmBusTemplate);

		
		fmBusTemplate.setUpdateDateTime(DateUtil.getCurrentDateTime());
		fmBusTemplate.setVersion(fmBusTemplate.getVersion() + 1);
		fmBusTemplateMapper.updateByPrimaryKeySelective(fmBusTemplate);

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> listRel = (List<Map<String, Object>>) map.get("rel");
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> listCon = (List<Map<String, Object>>) map.get("file");

		if (listRel != null && listRel.size() > 0) {
			for (Map<String, Object> m : listRel) {
				FmBusRelevance fmBusRelevance = (FmBusRelevance) MapEntityConverter.getEntityFromMap(m,
						FmBusRelevance.class);
				fmBusRelevance.setId(serialService.getUUID());
				fmBusRelevance.setFmId(fmBusTemplate.getId());
				fmBusRelevance.setCreateDateTime(DateUtil.getCurrentDateTime());
				fmBusRelevanceMapper.insert(fmBusRelevance);
			}
		}

		if (listCon != null && listCon.size() > 0) {
			for (Map<String, Object> m : listCon) {
				FmBusFile fmBusFile = (FmBusFile) MapEntityConverter.getEntityFromMap(m, FmBusFile.class);
				fmBusFile.setId(serialService.getUUID());
				fmBusFile.setFmId(fmBusTemplate.getId());
				fmBusFile.setCreateDateTime(DateUtil.getCurrentDateTime());
				fmBusFileMapper.insert(fmBusFile);
			}
		}

		return 0;
	}

}
