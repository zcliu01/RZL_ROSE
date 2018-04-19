package com.zrt.flow.service.fbTemp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
import com.zrt.flow.mapper.fbBusTemp.FbBusTempCustomMapper;
import com.zrt.flow.service.contacts.ContactsService;
import com.zrt.flow.service.serial.SerialService;
import com.zrt.mybatis.domain.FbBusFm;
import com.zrt.mybatis.domain.FbBusFmExample;
import com.zrt.mybatis.domain.FbBusFmExample.Criteria;
import com.zrt.mybatis.domain.FbBusTemplate;
import com.zrt.mybatis.domain.FbBusTemplateExample;
import com.zrt.mybatis.domain.FbBusTemplateNotify;
import com.zrt.mybatis.domain.FbBusTemplateNotifyExample;
import com.zrt.mybatis.domain.FbBusType;
import com.zrt.mybatis.domain.FmBusTemplate;
import com.zrt.mybatis.domain.FmBusType;
import com.zrt.mybatis.mapper.FbBusFmMapper;
import com.zrt.mybatis.mapper.FbBusTemplateMapper;
import com.zrt.mybatis.mapper.FbBusTemplateNotifyMapper;
import com.zrt.mybatis.mapper.FbBusTypeMapper;
import com.zrt.mybatis.mapper.FmBusTemplateMapper;
import com.zrt.mybatis.mapper.FmBusTypeMapper;

@Service
public class FbTempServiceImpl implements FbTempService {

	@Autowired
	private FbBusTemplateMapper fbBusTemplateMapper;
	@Autowired
	private FmBusTemplateMapper fmBusTemplateMapper;
	@Autowired
	private FbBusTypeMapper fbBusTypeMapper;
	@Autowired
	private FbBusTempCustomMapper fbBusTempCustomMapper;
	@Autowired
	private FbBusFmMapper fbBusFmMapper;
	@Autowired
	private SerialService serialService;
	@Autowired
	private ContactsService contactsService;
	@Autowired
	private FmBusTypeMapper fmBusTypeMapper;
	@Autowired
	private FbBusTemplateNotifyMapper fbBusTemplateNotifyMapper;

	@Override
	public Map<String, Object> getFormList(Map<String, Object> map) throws Exception {

		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);

		List<Map<String, Object>> dataList = fbBusTempCustomMapper.getFbBusTempList(map);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", pageInfo.getList());
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	/**
	 * 新增流程
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int save(Map<String, Object> map) throws Exception {

		FbBusTemplateExample example = new FbBusTemplateExample();
		com.zrt.mybatis.domain.FbBusTemplateExample.Criteria criteria = example.createCriteria();
		criteria.andTNameEqualTo((String) map.get("t_name"));
		int count = fbBusTemplateMapper.countByExample(example);

		if (count > 0) {
			throw new AppException("该流程已经存在!");
		} else {
			FbBusTemplate fbBusTemplate = new FbBusTemplate();
			fbBusTemplate.setId(serialService.getUUID());
			fbBusTemplate.settName((String) map.get("t_name"));
			fbBusTemplate.setfBTId((String) map.get("t_type_id"));
			String typeId = (String) map.get("t_type_id");
			FbBusType fbBusType = fbBusTypeMapper.selectByPrimaryKey(typeId);
			String parentId = fbBusType.getParentId();
			fbBusTemplate.setParentId(parentId);
			fbBusTemplate.settDesc((String) map.get("t_desc"));
			// 流程模版code
			String tCode = serialService.getSerialNumberFromDB("flow_code");
			// 根据需求去掉年
			tCode = tCode.substring(0, 1) + tCode.substring(3, tCode.length());
			fbBusTemplate.settCode(tCode);
			fbBusTemplate.setCreateDateTime(DateUtil.getCurrentDateTime());
			fbBusTemplate.settEnabled("1");
			fbBusTemplate.setCreateEmpId((String) map.get("emp_id"));
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
				fbBusTemplate.setCreateEmpName(data.get("emp_name") == null ? null : data.get("emp_name").toString());
			}
			fbBusTemplate.setVersion(1);
			fbBusTemplate.setProjectFlag((String) map.get("project_flag"));
			fbBusTemplate.setHandleFlag((String) map.get("handle_flag"));
			return fbBusTemplateMapper.insert(fbBusTemplate);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getFormDetail(Map<String, Object> map) throws Exception {

		FbBusTemplate FbBusTemplate = fbBusTemplateMapper.selectByPrimaryKey((String) map.get("id"));

		Map<String, Object> dataMap = MapEntityConverter.getMapFromEntity(
				new String[] { "id", "t_code", "t_name", "t_desc", "t_enabled", "t_type_id", "t_type_name",
						"create_date_time", "update_date_time", "project_flag", "handle_flag" },
				FbBusTemplate);

		return dataMap;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int update(Map<String, Object> map) throws Exception {
		FbBusTemplate FbBusTemplate = fbBusTemplateMapper.selectByPrimaryKey((String) map.get("id"));
		FbBusTemplate.settName((String) map.get("t_name"));
		FbBusTemplate.settDesc((String) map.get("t_desc"));
		FbBusTemplate.setfBTId((String) map.get("t_type_id"));
		FbBusTemplate.settCode((String) map.get("t_code"));
		FbBusTemplate.setUpdateDateTime(DateUtil.getCurrentDateTime());
		FbBusTemplate.setUpdateEmpId((String) map.get("emp_id"));
		FbBusTemplate.setUpdateEmpId((String) map.get("project_flag"));
		FbBusTemplate.setHandleFlag((String) map.get("handle_flag"));

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
			FbBusTemplate.setUpdateEmpName(data.get("emp_name") == null ? null : data.get("emp_name").toString());
		}
		FbBusTemplate.setVersion(FbBusTemplate.getVersion() + 1);

		return fbBusTemplateMapper.updateByPrimaryKeySelective(FbBusTemplate);

	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int delete(Map<String, Object> map) throws Exception {

		FbBusFmExample example = new FbBusFmExample();
		com.zrt.mybatis.domain.FbBusFmExample.Criteria criteria = example.createCriteria();
		criteria.andFbIdEqualTo((String) map.get("id"));
		List<FbBusFm> list = fbBusFmMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			throw new AppException("该流程已绑定表单，不能删除！");
		} else {
			return fbBusTemplateMapper.deleteByPrimaryKey((String) map.get("id"));
		}
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int formSave(Map<String, Object> map) throws Exception {

		FbBusFm fbBusFm = new FbBusFm();
		// 如果存在绑定过的表单，就删除
		FbBusFmExample example = new FbBusFmExample();
		Criteria criteria = example.createCriteria();
		criteria.andFbIdEqualTo((String) map.get("id"));
		fbBusFmMapper.deleteByExample(example);
		fbBusFm.setFbId((String) map.get("id"));
		fbBusFm.setFmId((String) map.get("fm_id"));
		return fbBusFmMapper.insert(fbBusFm);
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getFbFmList(Map<String, Object> map) throws Exception {

		FbBusFmExample example = new FbBusFmExample();
		com.zrt.mybatis.domain.FbBusFmExample.Criteria criteria = example.createCriteria();
		criteria.andFbIdEqualTo((String) map.get("id"));
		List<FbBusFm> list = fbBusFmMapper.selectByExample(example);

		Map<String, Object> resMap = new HashMap<String, Object>();

		if (list != null && list.size() > 0) {
			FbBusFm fbBusFm = list.get(0);
			// 根据formid查询form名称
			FmBusTemplate fmt = fmBusTemplateMapper.selectByPrimaryKey(fbBusFm.getFmId());
			// 根据分类id查询分类名称
			FmBusType fmtype = fmBusTypeMapper.selectByPrimaryKey(fmt.getfBTId());

			resMap.put("fm_id", fmt.getId());
			resMap.put("t_code", fmt.gettCode());
			resMap.put("t_name", fmt.gettName());
			resMap.put("t_type_id", fmt.getfBTId());
			resMap.put("t_type_name", fmtype.gettName());
		} else {
			resMap.put("fm_id", "");
			resMap.put("t_code", "");
			resMap.put("t_name", "");
			resMap.put("t_type_id", "");
			resMap.put("t_type_name", "");
		}
		/**
		 * FmBusTemplateExample fmExample = new FmBusTemplateExample();
		 * com.zrt.mybatis.domain.FmBusTemplateExample.Criteria fmCriteria =
		 * fmExample.createCriteria(); fmCriteria.andTEnabledEqualTo("1"); List
		 * <FmBusTemplate> fmList =
		 * fmBusTemplateMapper.selectByExample(fmExample);
		 * 
		 * List<Map<String, Object>> dataList = new ArrayList<Map<String,
		 * Object>>(); if (fmList != null && fmList.size() > 0) { for
		 * (FmBusTemplate fm : fmList) { Map<String, Object> dataMap = new
		 * HashMap<>(); dataMap.put("fm_id", fm.getId()); dataMap.put("t_code",
		 * fm.gettCode()); dataMap.put("t_name", fm.gettName()); if
		 * (fmIdList.contains(fm.getId())) { dataMap.put("is_flag", "1"); } else
		 * { dataMap.put("is_flag", "0"); } dataList.add(dataMap); } }
		 **/

		return resMap;
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int openOrClose(Map<String, Object> map) throws Exception {
		FbBusTemplate FbBusTemplate = fbBusTemplateMapper.selectByPrimaryKey((String) map.get("id"));
		FbBusTemplate.settEnabled((String) map.get("t_enabled"));

		return fbBusTemplateMapper.updateByPrimaryKeySelective(FbBusTemplate);
	}

	/**
	 * 流程提醒人查询
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> notifyList(Map<String, Object> map) throws Exception {
		// 根据流程编号，查询改流程设置的绑定人
		FbBusTemplateNotifyExample notifyExample = new FbBusTemplateNotifyExample();
		com.zrt.mybatis.domain.FbBusTemplateNotifyExample.Criteria notifyCriteria = notifyExample.createCriteria();
		notifyCriteria.andTCodeEqualTo((String) map.get("t_code"));
		List<FbBusTemplateNotify> notifyList = fbBusTemplateNotifyMapper.selectByExample(notifyExample);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> resMap = new HashMap<String, Object>();
		for (FbBusTemplateNotify notify : notifyList) {
			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("notify_emp_id", notify.getNotifyEmpId());
			dataMap.put("notify_emp_name", notify.getNotifyEmpName());
			dataList.add(dataMap);
		}
		resMap.put("list", dataList);
		return resMap;
	}

	/**
	 * 流程设置提醒人
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> notify(Map<String, Object> map) throws Exception {
		// 提醒人
		String notifyEmpId = (String) map.get("notify_emp_ids");
		if (notifyEmpId.endsWith(";")) {
			notifyEmpId = notifyEmpId.substring(0, notifyEmpId.length() - 1);
		}

		List<Map<String, Object>> fbCodeList = (List<Map<String, Object>>) map.get("param");
		if (fbCodeList != null && fbCodeList.size() > 0) {
			for (Map<String, Object> fbCodeMap : fbCodeList) {
				String tCode = (String) fbCodeMap.get("t_code");
				FbBusTemplateNotifyExample notifyExample = new FbBusTemplateNotifyExample();
				notifyExample.createCriteria().andTCodeEqualTo(tCode);
				List<FbBusTemplateNotify> tifyList = fbBusTemplateNotifyMapper.selectByExample(notifyExample);
				if (tifyList != null && tifyList.size() > 0) {
					fbBusTemplateNotifyMapper.deleteByExample(notifyExample);
				}
				if (StringUtils.isBlank(notifyEmpId)) {
					continue;
				}
				String[] empIds = notifyEmpId.split(";");
				for (int i = 0; i < empIds.length; i++) {
					String empId = empIds[i];
					Map<String, Object> empData = contactsService.commonEmpSearchDetail(empId);

					FbBusTemplateNotify fbBusTemplateNotify = new FbBusTemplateNotify();
					fbBusTemplateNotify.setId(serialService.getUUID());
					fbBusTemplateNotify.settCode(tCode);
					fbBusTemplateNotify.setNotifyEmpId(empId);
					fbBusTemplateNotify.setNotifyEmpName((String) empData.get("emp_name"));
					fbBusTemplateNotify.setCreateDateTime(DateUtil.getCurrentDateTime());
					FbBusTemplateNotifyExample example = new FbBusTemplateNotifyExample();
					example.createCriteria().andTCodeEqualTo(tCode).andNotifyEmpIdEqualTo(empId);
					List<FbBusTemplateNotify> notifyList = fbBusTemplateNotifyMapper.selectByExample(example);
					if (notifyList.size() < 1) {
						fbBusTemplateNotifyMapper.insert(fbBusTemplateNotify);
					}

				}

			}
		}
		return null;
	}

}
