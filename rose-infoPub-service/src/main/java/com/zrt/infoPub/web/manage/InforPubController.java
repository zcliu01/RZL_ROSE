package com.zrt.infoPub.web.manage;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.infoPub.service.infoPubService.InforPubService;



@RestController
@RequestMapping("/v1.0/infoPub")
public class InforPubController {
	private static final Logger log = LoggerFactory.getLogger(InforPubController.class);
	@Resource(name = "inforPubServiceImpl")
	private InforPubService inforPubService;
	
	
	/**
	 * 新建公告
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> save(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforPubController中save方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 新建任务
			int save = inforPubService.save(map);
			if (save==2) {
				return resultMap.failure().errmsg("标题不能为空!").map();
			}
			if (save==4) {
				return resultMap.failure().errmsg("公示内容不能为空!").map();
			}
			if (save==5) {
				return resultMap.failure().errmsg("通知方式不能为空!").map();
			}
			if (save==6) {
				return resultMap.failure().errmsg("通知人不能为空!").map();
			}
			resultMap.success().sucmsg("新建成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("新建失败!").map();

		}
	}
	
	
	
	/**
	 * 修改公告
	 * 
	 */
	@RequestMapping(value = "/updateInfopub", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> updateInfopub(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforPubController中updateInfopub方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 新建任务
			inforPubService.updateInfopub(map);
			resultMap.success().sucmsg("修改成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("修改失败!").map();
			
		}
	}
	
	
	
	/**
	 * 公示状态变更
	 * 
	 */
	@RequestMapping(value = "/updateInfoType", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> updateInfoType(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforPubController中updateInfoType方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 新建任务
			inforPubService.updateInfoType(map);
			resultMap.success().sucmsg("公示状态变更成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公示状态变更失败!").map();
			
		}
	} 
	
	
	/**
	 * 
	 * 公示查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> search(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforPubController中search方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> search = inforPubService.search(map);
			resultMap.success().map().put("count", search.get("count"));
			resultMap.data(search.get("data"));
			resultMap.success().sucmsg("查询成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("查询失败!").map();

		}
	}
	
	/**
	 * 公示删除
	 * @param list
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> del(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforPubController中del方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> delMap = inforPubService.del(map);
			if (delMap!=null) {
				resultMap.data(delMap);
				return resultMap.failure().errmsg("删除失败!").map();
			}
			resultMap.success().sucmsg("删除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("删除失败!").map();
			
		}
	}
	
	/**
	 * 
	 * 查看公示详情
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchInfo", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> searchInfo(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforPubController中searchInfo方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> searchInfo = inforPubService.searchInfo(map);
			if (null==searchInfo) {
				return resultMap.failure().errmsg("该公示信息已撤销,无法查看!").map();
			}
			resultMap.data(searchInfo);
			resultMap.success().sucmsg("查询成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("查询失败!").map();
			
		}
	}
	
	/**
	 * 
	 * 公示类型维护
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/state_save", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> state_save(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforPubController中state_save方法");
		ResultMap resultMap = new ResultMap();
		try {
			int state_save = inforPubService.state_save(map);
			if (state_save==2) {
				return resultMap.failure().errmsg("该公示类型有公示信息无法删除!").map();
			}
			if (state_save==3) {
				return resultMap.failure().errmsg("公示类型名称输入不正确!").map();
			}
			resultMap.success().sucmsg("公示类型维护成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公示类型维护失败!").map();
			
		}
	}
	
	
	
	/**
	 * 
	 * 公示类型查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/state_search", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> state_search(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的InforPubController中state_search方法");
		ResultMap resultMap = new ResultMap();
		try {
			List<Map<String, Object>> state_search = inforPubService.state_search(map);
			resultMap.data(state_search);
			resultMap.success().sucmsg("公示类型查询成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("公示类型查询失败!").map();
			
		}
	}
}
