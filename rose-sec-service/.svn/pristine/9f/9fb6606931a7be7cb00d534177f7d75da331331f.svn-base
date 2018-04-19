package com.zrt.sec.service.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.mybatis.domain.SysSecMenu;
import com.zrt.mybatis.domain.SysSecMenuExample;
import com.zrt.mybatis.domain.SysSecMenuExample.Criteria;
import com.zrt.mybatis.mapper.SysSecMenuMapper;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.commons.AppException;
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.number.NumberUtils;

@Service("menuServiceImpl")
public class MenuServiceImpl implements MenuService {
	@Autowired
	private SysSecMenuMapper sysSecMenuMapper;

	@Override
	@Transactional(readOnly = true)
	public List<SysSecMenu> menuList(Map<String, Object> appMap) throws Exception {
		return sysSecMenuMapper.selectByExample(addWhere(appMap));
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int menuSave(Map<String, Object> appMap) throws Exception {
		SysSecMenu sysSecMenu = (SysSecMenu) MapEntityConverter.getEntityFromMap(appMap,
				SysSecMenu.class);
		
		if(StringUtils.isBlank(sysSecMenu.getParentCode()))
			sysSecMenu.setParentCode("-1");
		else
			checkMenuId(sysSecMenu.getParentCode());
			
		if(!isUniqueRName(sysSecMenu.getMenuName()))
			throw new AppException("菜单名称已存在！");
		
		if(!isUniqueRUrl(sysSecMenu.getMenuUrl()))
			throw new AppException("菜单url已存在");
		
		String menuCode = this.getMenuCode(sysSecMenu.getParentCode());
		sysSecMenu.setMenuCode(menuCode);
		
		String rootMenuCode = this.getMenuRootCode(sysSecMenu.getParentCode(), menuCode);
		sysSecMenu.setRootMenuCode(rootMenuCode);
		
		Integer level = getMenuLevel(sysSecMenu.getMenuCode());
		sysSecMenu.setMenuLevel(level);
		
		sysSecMenu.setSecEnabled("1");
		sysSecMenu.setSecSysFlag("0");
		sysSecMenu.setSecReadonlyFlag("0");
		sysSecMenu.setVersion(0);
		sysSecMenu.setCreateDateTime(DateUtil.getCurrentDateTime());
		sysSecMenu.setUpdateDateTime(sysSecMenu.getCreateDateTime());
		
		return sysSecMenuMapper.insert(sysSecMenu);
	}

	/**
	 * 获取菜单编码
	 * @param parentCode
	 * @return
	 * @throws Exception
	 */
	public String getMenuCode(String parentCode) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parent_code", parentCode);
		int countChild = sysSecMenuMapper.countByExample(addWhere(map));
		
		if("-1".equals(parentCode))
			return NumberUtils.increaseNumber(countChild, 4);
		
		if(countChild == 0){
			return childMenuIsZero(parentCode);
		}else if(countChild > 0 && countChild < 9999){
			return parentCode + NumberUtils.increaseNumber(countChild, 4);
		}else{
			throw new AppException("生成菜单编码失败");
		}
	}
	
	/**
	 * 子菜单为0时，返回的menu_code。
	 * 子菜单没有，有两种情况
	 * 1.父菜单下没有子菜单
	 * 2.parentCode错误
	 * @param parentCode
	 * @return
	 * @throws Exception
	 */
	public String childMenuIsZero(String parentCode) throws Exception{
		SysSecMenu sysSecMenu = this.getParentCodeIsMenuCode(parentCode);
		
		//parentCode存在
		if(null !=sysSecMenu && StringUtils.isNotBlank(sysSecMenu.getMenuCode()))
			return parentCode + NumberUtils.increaseNumber("0000", 4);
		else//parentCode不存在
			throw new AppException("传入的parent_code有误"+parentCode);
	}
	
	/**
	 * 查找父菜单。
	 * 根据子菜单的parentCode查找。
	 * @param parentCode
	 * @return
	 * @throws Exception
	 */
	public SysSecMenu getParentCodeIsMenuCode(String parentCode) throws Exception{
		Map<String, Object> mapSearch = new HashMap<String, Object>();
		mapSearch.put("menu_code", parentCode);
		
		return this.menuSearch(mapSearch);
	}
	
	/**
	 * 父菜单的menuRootCode就是子菜单的menuRootCode
	 * @param parentCode
	 * @param menuCode
	 * @return
	 * @throws Exception 
	 */
	public String getMenuRootCode(String parentCode,String menuCode) throws Exception{
		if("-1".equals(parentCode))
			return menuCode;
		
		SysSecMenu sysSecMenu = this.getParentCodeIsMenuCode(parentCode);
		
		return sysSecMenu.getRootMenuCode();
	}
	
	/**
	 * 计算菜单级别
	 * @param menuCode
	 * @return
	 * @throws AppException
	 */
	public Integer getMenuLevel(String menuCode) throws AppException{
		return menuCode.length() / 4;
	}

	/**
	 * 验证字符串是否是4的倍数
	 * @param idStr
	 * @throws AppException
	 */
	public void checkMenuId(String idStr) throws AppException {
		int l = idStr.length();
		if (l % 4 != 0)
			throw new AppException("组织机构的id出现错误：" + idStr);
	}
	
	/**
	 * 判断menuName在数据库表中是否是唯一记录
	 * true:唯一
	 * @param menuName
	 * @return
	 * @throws Exception
	 */
	public boolean isUniqueRName(String menuName) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("menu_name", menuName);
		
		List<SysSecMenu> list = this.menuList(map);
		
		if(list.size() >= 1)
			return false;
		
		return true;
	}
	
	/**
	 * 判断menuUrl在数据库表中是否是唯一记录
	 * true:唯一
	 * @param menuUrl
	 * @return
	 * @throws Exception
	 */
	public boolean isUniqueRUrl(String menuUrl) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("menu_url", menuUrl);
		
		List<SysSecMenu> list = this.menuList(map);
		
		if(list.size() >= 1)
			return false;
		
		return true;
	}
	
	@Override
	@Transactional(readOnly = true)
	public SysSecMenu menuSearch(Map<String, Object> appMap) throws Exception {
		List<SysSecMenu> list = sysSecMenuMapper.selectByExample(addWhere(appMap));
		
		if(null == list || list.size() == 0)
			return null;
		
		return list.get(0);
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int menuUpdate(Map<String, Object> appMap) throws Exception {
		SysSecMenu sysSecMenu = (SysSecMenu) MapEntityConverter.getEntityFromMap(appMap, SysSecMenu.class);

		sysSecMenu.setUpdateDateTime(DateUtil.getCurrentDateTime());

		return sysSecMenuMapper.updateByPrimaryKeySelective(sysSecMenu);
	}
	
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int menuDelete(Map<String, Object> appMap) throws Exception{
		if(appMap.size() == 0)
			throw new AppException("删除参数未传入");
		
		return sysSecMenuMapper.deleteByExample(addWhere(appMap));
	}

	public SysSecMenuExample addWhere(Map<String, Object> appMap) {
		SysSecMenuExample example = new SysSecMenuExample();
		Criteria criteria = example.createCriteria();

		if (null == appMap || appMap.size() == 0)
			return example;
		
		if (null != appMap.get("menu_code")) {
			criteria.andMenuCodeEqualTo(String.valueOf(appMap.get("menu_code")));
		}
		
		if (null != appMap.get("parent_code")) {
			criteria.andParentCodeEqualTo(String.valueOf(appMap.get("parent_code")));
		}
		
		if (null != appMap.get("menu_name")) {
			criteria.andMenuNameEqualTo(String.valueOf(appMap.get("menu_name")));
		}
		
		if (null != appMap.get("menu_url")) {
			criteria.andMenuUrlEqualTo(String.valueOf(appMap.get("menu_url")));
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
