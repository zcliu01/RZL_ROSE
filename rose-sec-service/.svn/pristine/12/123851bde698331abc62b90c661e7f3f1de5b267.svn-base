package com.zrt.sec.web.resource;

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
import com.zrt.mybatis.domain.SysSecResource;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.commons.AppException;
import com.zrt.commons.PageInit;
import com.zrt.commons.ResultMap;
import com.zrt.sec.service.resource.ResourceService;

@RestController
@RequestMapping("/v1.0/sec")
public class ResourceController {
	private static final Logger log = LoggerFactory.getLogger(ResourceController.class);
	@Resource(name = "resourceServiceImpl")
	private ResourceService resourceService;

	/**
	 * 资源管理-资源列表查询
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/resourceList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> resourceList(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的ResourceController中resourceList方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 初始化分页参数
			PageInit.setPage(appMap);
			// 开始分页
			PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()),
					Integer.parseInt(appMap.get("maxResult").toString()));

			// 获取资源列表
			List<SysSecResource> dataList = resourceService.resourceList(appMap);

			PageInfo<SysSecResource> pageInfo = new PageInfo<>(dataList);

			List<Map<String, Object>> list = MapEntityConverter.getMapFromList(
					new String[] { "resource_id", "resource_group", "resource_name", "resource_url","sec_order", "sec_enabled", "create_date_time" },
					dataList, 
					SysSecResource.class);
			
			resultMap.data(list);
			resultMap.success().map().put("count", pageInfo.getTotal());

			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			throw new AppException("查询资源列表信息失败!");
		}
	}

	/**
	 * 资源管理-资源信息查询
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/resourceSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> resourceSearch(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的ResourceController中resourceSearch方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 获取资源信息
			SysSecResource sysSecResource = resourceService.resourceSearch(appMap);
			
			Map<String, Object> resourceMap = MapEntityConverter .getMapFromEntity(
							new String[] { "resource_id", "resource_group", "resource_name", "resource_url","sec_order", "sec_enabled", "create_date_time"  },
							sysSecResource);
			
			resultMap.data(resourceMap);
			return resultMap.success().map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("查询资源信息失败!");
		}
	}

	/**
	 * 资源管理-资源新增
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/resourceSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> resourceSave(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的ResourceController中resourceSave方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 资源新增
			resourceService.resourceSave(appMap);
			resultMap.success().sucmsg("新增成功!");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("资源新增失败!");
		}
	}

	/**
	 * 资源管理-资源更新
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/resourceUpdate", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> resourceUpdate(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的ResourceController中resourceUpdate方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 资源新增
			resourceService.resourceUpdate(appMap);
			resultMap.success().sucmsg("更新成功!");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("更新资源信息失败!");
		}
	}
	
	/**
	 * 资源删除
	 * @param appMap
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="/resourceDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> resourceDelete(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的ResourceController中resourceDelete方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 资源新增
			resourceService.resourceDelete(appMap);
			resultMap.success().sucmsg("删除成功!");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("删除资源信息失败!");
		}
	}
	
}
