package com.zrt.bumph.web.app;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.bumph.service.bumph.BumphService;
import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;



@RestController
@RequestMapping("/v1.0/APPdocPro")
public class AppBumphController {

	private static final Logger log = LoggerFactory.getLogger(AppBumphController.class);
	@Resource(name="bumphServiceImpl")
	private BumphService bumphService;
	
	
	/**
	 * 公文查询筛选
	 * 
	 */
	@RequestMapping(value = "/documentSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> searchAll(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppBumphController中documentSearch方法");
		ResultMap resultMap = new ResultMap();
		try {
			//公文查询
			Map<String, Object> search = bumphService.APPdocumentSearch(map);
			resultMap.success().map().put("count", search.get("count"));
			resultMap.data(search.get("data"));
			resultMap.success().sucmsg("公文查询成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公文查询失败!").map();
			
		}
	} 
	
	
	
	/**
	 * 公文办理筛选
	 * 
	 */
	@RequestMapping(value = "/detailSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> detailSearch(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppBumphController中detailSearch方法");
		ResultMap resultMap = new ResultMap();
		try {
			//待办公文查询
			Map<String, Object> search = bumphService.APPdetailSearch(map);
			resultMap.success().map().put("count", search.get("count"));
			resultMap.data(search.get("data"));
			resultMap.success().sucmsg("公文办理筛选成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公文办理筛选失败!").map();
			
		}
	} 
	
	
	
	/**
	 * 公文管理筛选
	 * 
	 */
	@RequestMapping(value = "/regis", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> manageSearch(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppBumphController中regis方法");
		ResultMap resultMap = new ResultMap();
		try {
			//待办公文查询
			Map<String, Object> search = bumphService.APPmanageSearch(map);
			resultMap.success().map().put("count", search.get("count"));
			resultMap.data(search.get("data"));
			resultMap.success().sucmsg("公文管理筛选成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公文管理筛选失败!").map();
			
		}
	} 
	
	
	/**
	 * 公文详情
	 * 
	 */
	@RequestMapping(value = "/detailView", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> detailView(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppBumphController中detailView方法");
		ResultMap resultMap = new ResultMap();
		try {
			//公文详情查询
			Map<String, Object> detailView = bumphService.APPdetailView(map);
			if (null==detailView) {
				return resultMap.failure().errmsg("该公文已撤销,无法查看!").map();
			}
			resultMap.data(detailView);
			resultMap.success().sucmsg("查询公文详情成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公文详情查询失败!").map();
			
		}
	} 
	
	
	
	/**
	 * 公文审核详情
	 * 
	 */
	@RequestMapping(value = "/auditView", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> auditView(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppBumphController中auditView方法");
		ResultMap resultMap = new ResultMap();
		try {
			//公文详情查询
			 Map<String, Object> auditView = bumphService.APPauditView(map);
			resultMap.data(auditView);
			resultMap.success().sucmsg("查询公文详情成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公文详情查询失败!").map();
			
		}
	} 
	
	
	

	
	
	/**
	 * 公文审核办理
	 * 
	 */
	@RequestMapping(value = "/auditAttend", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> auditAttend(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的BumphController中auditAttend方法");
		ResultMap resultMap = new ResultMap();
		try {
			//公文审核办理
			bumphService.auditAttend(map);
			resultMap.success().sucmsg("公文办理成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公文办理失败!").map();
			
		}
	} 
	
	
	
	/**
	 * 公文撤销
	 * 
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> delete(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的APPBumphController中delete方法");
		ResultMap resultMap = new ResultMap();
		try {
			//公文撤销
			bumphService.backout(map);
			if ("0".equals(map.get("doc_state"))) {
				resultMap.success().sucmsg("公文撤销成功!");
			}else {
				resultMap.success().sucmsg("公文发布成功!");
				
			}
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公文撤销失败!").map();

		}
	} 
	
	
	
	
	/**
	 * 审核人管理
	 * 
	 */
	@RequestMapping(value = "/execute", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> execute(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的APPBumphController中execute方法");
		ResultMap resultMap = new ResultMap();
		try {
			//新建公文
			bumphService.execute(map);
			resultMap.success().sucmsg("审核人管理成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("审核人管理失败!").map();
			
		}
	} 
	
	
	/**
	 * 添加审核人
	 * 
	 */
	@RequestMapping(value = "/addExecutes", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> addExecutes(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的APPBumphController中addExecutes方法");
		ResultMap resultMap = new ResultMap();
		try {
			//新建公文
			bumphService.addExecutes(map);
			resultMap.success().sucmsg("审核人管理成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("审核人管理失败!").map();
			
		}
	} 
}
