package com.zrt.sec.web.menu;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.mybatis.domain.SysSecMenu;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.commons.AppException;
import com.zrt.commons.PageInit;
import com.zrt.commons.ResultMap;
import com.zrt.sec.service.menu.MenuService;

@RestController
@RequestMapping("/v1.0/sec")
public class MenuController {
	private static final Logger log = LoggerFactory.getLogger(MenuController.class);
	@Resource(name = "menuServiceImpl")
	private MenuService menuService;

	/**
	 * 菜单管理-菜单列表查询
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/menuList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> menuList(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的MenuController中menuList方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 初始化分页参数
			PageInit.setPage(appMap);
			// 开始分页
			PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
					Integer.parseInt(appMap.get("maxResult").toString()));

			// 获取菜单列表
			List<SysSecMenu> dataList = menuService.menuList(appMap);

			PageInfo<SysSecMenu> pageInfo = new PageInfo<>(dataList);

			List<Map<String, Object>> list = MapEntityConverter.getMapFromList(
					new String[] { "menu_code", "root_menu_code", "parent_code", "menu_name","menu_level", "menu_url","sec_order","sec_enabled", "create_date_time" },
					dataList, 
					SysSecMenu.class);
			
			resultMap.data(list);
			resultMap.success().map().put("count", pageInfo.getTotal());

			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			throw new AppException("查询菜单列表信息失败!");
		}
	}

	/**
	 * 菜单管理-菜单信息查询
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/menuSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> menuSearch(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的MenuController中menuSearch方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 获取菜单信息
			SysSecMenu sysSecMenu = menuService.menuSearch(appMap);
			
			Map<String, Object> menuMap = MapEntityConverter .getMapFromEntity(
							new String[] { "menu_code", "root_menu_code", "parent_code", "menu_name","menu_level", "menu_url","sec_order","sec_enabled", "create_date_time" },
							sysSecMenu);
			
			resultMap.data(menuMap);
			return resultMap.success().map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("查询菜单信息失败!");
		}
	}

	/**
	 * 菜单管理-菜单新增
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/menuSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> menuSave(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的MenuController中menuSave方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 菜单新增
			menuService.menuSave(appMap);
			resultMap.success().sucmsg("新增成功!");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("菜单新增失败!");
		}
	}

	/**
	 * 菜单管理-菜单更新
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/menuUpdate", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> menuUpdate(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的MenuController中menuUpdate方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 菜单新增
			menuService.menuUpdate(appMap);
			resultMap.success().sucmsg("更新成功!");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("更新菜单信息失败!");
		}
	}
	
	/**
	 * 菜单删除
	 * @param appMap
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="/menuDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> menuDelete(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的MenuController中menuDelete方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 菜单新增
			menuService.menuDelete(appMap);
			resultMap.success().sucmsg("删除成功!");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("删除菜单信息失败!");
		}
	}
	
}
