package com.zrt.sec.service.menu;

import java.util.List;
import java.util.Map;

import com.zrt.mybatis.domain.SysSecMenu;

public interface MenuService {
	// 菜单新增
	int menuSave(Map<String, Object> appMap) throws Exception;

	// 菜单列表查询
	List<SysSecMenu> menuList(Map<String, Object> appMap) throws Exception;

	// 菜单信息查询
	SysSecMenu menuSearch(Map<String, Object> appMap) throws Exception;

	// 菜单更新
	int menuUpdate(Map<String, Object> appMap) throws Exception;

	// 菜单删除
	int menuDelete(Map<String, Object> appMap) throws Exception;
}
