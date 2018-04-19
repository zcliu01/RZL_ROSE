package com.zrt.bumph.web.manage;

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
@RequestMapping("/v1.0/docPro")
public class BumphController {

	private static final Logger log = LoggerFactory.getLogger(BumphController.class);
	@Resource(name="bumphServiceImpl")
	private BumphService bumphService;
	
	
	/**
	 * 新建公文
	 * 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> add(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的BumphController中add方法");
		ResultMap resultMap = new ResultMap();
		try {
			//新建公文
			int i = bumphService.add(map);
			if (i==2) {
				return resultMap.failure().errmsg("公文名字不能为空!").map();
			}
			resultMap.success().sucmsg("新建成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公文新建失败!").map();

		}
	} 
	
	
	
	/**
	 * 公文类型维护
	 * 
	 */
	@RequestMapping(value = "/state_save", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> state_save(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的BumphController中state_save方法");
		ResultMap resultMap = new ResultMap();
		try {
			//公文类型维护
			int state_save = bumphService.state_save(map);
			if (state_save==2) {
				return resultMap.failure().errmsg("该公文类型有公文信息,无法删除!").map();
			}
			resultMap.success().sucmsg("公文类型维护成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公文类型维护失败!").map();
			
		}
	} 
	
	
	
	
	/**
	 * 公文类型查询
	 * 
	 */
	@RequestMapping(value = "/state_search", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> state_search(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的BumphController中state_search方法");
		ResultMap resultMap = new ResultMap();
		try {
			//公文类型查询
			List<Map<String, Object>> search = bumphService.state_search(map);
			resultMap.data(search);
			resultMap.success().sucmsg("查询公文类型成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公文类型查询失败!").map();
			
		}
	} 
	
	
	
	
	/**
	 * 待办公文
	 * 
	 */
	@RequestMapping(value = "/detailSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> detailSearch(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的BumphController中detailSearch方法");
		ResultMap resultMap = new ResultMap();
		try {
			//待办公文查询
			Map<String, Object> search = bumphService.detailSearch(map);
			resultMap.success().map().put("count", search.get("count"));
			resultMap.data(search.get("data"));
			resultMap.success().sucmsg("查询待办公文成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("待办公文查询失败!").map();
			
		}
	} 
	
	
	/**
	 * 公文查询
	 * 
	 */
	@RequestMapping(value = "/documentSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> documentSearch(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的BumphController中documentSearch方法");
		ResultMap resultMap = new ResultMap();
		try {
			//待办公文查询
			Map<String, Object> search = bumphService.documentSearch(map);
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
	 * 公文审核查看
	 * 
	 */
	@RequestMapping(value = "/auditView", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> auditView(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的BumphController中auditView方法");
		ResultMap resultMap = new ResultMap();
		try {
			//公文审核查看
			Map<String, Object> search = bumphService.auditView(map);
			resultMap.data(search);
			resultMap.success().sucmsg("公文审核查看成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公文新建失败!").map();
			
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
			//公文审核办理查询
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
	 * 公文监控
	 * 
	 */
	@RequestMapping(value = "/Monitor", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> Monitor(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的BumphController中Monitor方法");
		ResultMap resultMap = new ResultMap();
		try {
			//公文监控
			Map<String, Object> search = bumphService.Monitor(map);
			resultMap.success().map().put("count", search.get("count"));
			resultMap.data(search.get("data"));
			resultMap.success().sucmsg("查询公文监控成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公文监控查询失败!").map();
			
		}
	} 
	/**
	 * 公文详情
	 * 
	 */
	@RequestMapping(value = "/detailView", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> detailView(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的BumphController中detailView方法");
		ResultMap resultMap = new ResultMap();
		try {
			//公文详情查询
			Map<String, Object> detailView = bumphService.detailView(map);
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
	 * 公文登记
	 * 
	 */
	@RequestMapping(value = "/regis", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> regis(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的BumphController中regis方法");
		ResultMap resultMap = new ResultMap();
		try {
			//公文登记查询
			Map<String, Object> search = bumphService.regis(map);
			resultMap.success().map().put("count", search.get("count"));
			resultMap.data(search.get("data"));
			resultMap.success().sucmsg("公文登记查看成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公文登记查看失败!").map();
			
		}
	} 
	/**
	 * 待发布公文详情
	 * 
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> detail(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的BumphController中detail方法");
		ResultMap resultMap = new ResultMap();
		try {
			//待发布公文详情查询
			Map<String, Object> detailView = bumphService.detail(map);
			resultMap.data(detailView);
			resultMap.success().sucmsg("待发布公文详情查询成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("待发布公文详情查询失败!").map();
			
		}
	} 
	
	
	
	
	/**
	 * 公文删除
	 * 
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> delete(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的BumphController中delete方法");
		ResultMap resultMap = new ResultMap();
		try {
			//新建公文
			bumphService.delete(map);
			resultMap.success().sucmsg("公文删除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公文删除失败!").map();

		}
	} 
	
	
	
	/**
	 * 管理审核人
	 * 
	 */
	@RequestMapping(value = "/execute", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> execute(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的BumphController中execute方法");
		ResultMap resultMap = new ResultMap();
		try {
			bumphService.execute(map);
			resultMap.success().sucmsg("管理审核人成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("管理审核人失败!").map();
			
		}
	} 
	
	
	/**
	 * 管理审核人
	 * 
	 */
	@RequestMapping(value = "/addExecutes", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> addExecutes(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的BumphController中execute方法");
		ResultMap resultMap = new ResultMap();
		try {
			bumphService.addExecutes(map);
			resultMap.success().sucmsg("管理审核人成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("管理审核人失败!").map();
			
		}
	} 
	
	
	

	/**
	 * 修改公文
	 * 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> update(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的BumphController中update方法");
		ResultMap resultMap = new ResultMap();
		try {
			//新建公文
			int update = bumphService.update(map);
			if (update == 2) {
				resultMap.success().sucmsg("发布成功!");
				return resultMap.map();
			}
			resultMap.success().sucmsg("修改成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公文新建失败!").map();

		}
	}
	
	
	/**
	 * 公文撤销
	 * 
	 */
	@RequestMapping(value = "/backout", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> backout(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的APPBumphController中delete方法");
		ResultMap resultMap = new ResultMap();
		try {
			//公文撤销
			bumphService.webBackout(map);
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
	
}
