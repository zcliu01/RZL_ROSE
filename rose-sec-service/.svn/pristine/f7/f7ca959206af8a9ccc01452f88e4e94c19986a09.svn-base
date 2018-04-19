package com.zrt.sec.service.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.mybatis.domain.SysSecResource;
import com.zrt.mybatis.domain.SysSecResourceExample;
import com.zrt.mybatis.domain.SysSecResourceExample.Criteria;
import com.zrt.mybatis.mapper.SysSecResourceMapper;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.commons.AppException;
import com.zrt.commons.date.DateUtil;
import com.zrt.sec.service.serial.SerialService;

@Service("resourceServiceImpl")
public class ResourceServiceImpl implements ResourceService {
	@Autowired
	private SysSecResourceMapper sysSecResourceMapper;

	@Autowired
	private SerialService serialService;
	
	@Override
	@Transactional(readOnly = true)
	public List<SysSecResource> resourceList(Map<String, Object> appMap) throws Exception {
		return sysSecResourceMapper.selectByExample(addWhere(appMap));
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int resourceSave(Map<String, Object> appMap) throws Exception {
		SysSecResource sysSecResource = (SysSecResource) MapEntityConverter.getEntityFromMap(appMap,
				SysSecResource.class);

		if(!isUniqueRName(sysSecResource.getResourceName()))
			throw new AppException("资源名称已存在！");
		if(!isUniqueRUrl(sysSecResource.getResourceUrl()))
			throw new AppException("资源url已存在");
		
		sysSecResource.setResourceId(serialService.getSerialNumberFromDB("sys_sec_resource"));
		sysSecResource.setSecSysFlag("0");
		sysSecResource.setSecReadonlyFlag("0");
		sysSecResource.setSecDeleteFlag("0");
		sysSecResource.setVersion(1);
		sysSecResource.setCreateDateTime(DateUtil.getCurrentDateTime());
		sysSecResource.setUpdateDateTime(sysSecResource.getCreateDateTime());
		
		return sysSecResourceMapper.insert(sysSecResource);
	}

	/**
	 * 判断resourceName在数据库表中是否是唯一记录
	 * true:唯一
	 * @param resourceName
	 * @return
	 * @throws Exception
	 */
	public boolean isUniqueRName(String resourceName) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("resource_name", resourceName);
		
		List<SysSecResource> list = this.resourceList(map);
		
		if(list.size() >= 1)
			return false;
		
		return true;
	}
	
	/**
	 * 判断resourceUrl在数据库表中是否是唯一记录
	 * true:唯一
	 * @param resourceUrl
	 * @return
	 * @throws Exception
	 */
	public boolean isUniqueRUrl(String resourceUrl) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("resource_url", resourceUrl);
		
		List<SysSecResource> list = this.resourceList(map);
		
		if(list.size() >= 1)
			return false;
		
		return true;
	}
	
	@Override
	@Transactional(readOnly = true)
	public SysSecResource resourceSearch(Map<String, Object> appMap) throws Exception {
		List<SysSecResource> list = sysSecResourceMapper.selectByExample(addWhere(appMap));
		
		if(null == list || list.size() == 0)
			return null;
		
		return list.get(0);
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int resourceUpdate(Map<String, Object> appMap) throws Exception {
		SysSecResource sysSecResource = (SysSecResource) MapEntityConverter.getEntityFromMap(appMap, SysSecResource.class);

		sysSecResource.setUpdateDateTime(DateUtil.getCurrentDateTime());

		return sysSecResourceMapper.updateByPrimaryKeySelective(sysSecResource);
	}
	
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int resourceDelete(Map<String, Object> appMap) throws Exception{
		appMap.put("sec_delete_flag", "1");
		return this.resourceUpdate(appMap);
	}

	public SysSecResourceExample addWhere(Map<String, Object> appMap) {
		SysSecResourceExample example = new SysSecResourceExample();
		Criteria criteria = example.createCriteria();

		if (null == appMap || appMap.size() == 0)
			return example;

		if (null != appMap.get("resource_id")) {
			criteria.andResourceIdEqualTo(String.valueOf(appMap.get("resource_id")));
		}
		
		if (null != appMap.get("resource_name")) {
			criteria.andResourceNameEqualTo(String.valueOf(appMap.get("resource_name")));
		}
		
		if (null != appMap.get("resource_url")) {
			criteria.andResourceUrlEqualTo(String.valueOf(appMap.get("resource_url")));
		}
		
		if (null != appMap.get("sec_delete_flag")) {
			criteria.andSecDeleteFlagEqualTo(String.valueOf(appMap.get("sec_delete_flag")));
		}
		
		if (null != appMap.get("sec_enabled")) {
			criteria.andSecEnabledEqualTo(String.valueOf(appMap.get("sec_enabled")));
		}
		
		if (null != appMap.get("sec_readonly_flag")) {
			criteria.andSecReadonlyFlagEqualTo(String.valueOf(appMap.get("sec_readonly_flag")));
		}
		
		if (null != appMap.get("sec_sys_flag")) {
			criteria.andSecSysFlagEqualTo(String.valueOf(appMap.get("sec_sys_flag")));
		}
		
		if (null != appMap.get("order_by")) {
			example.setOrderByClause(String.valueOf(appMap.get("order_by")));
		}

		return example;
	}

}
