package com.zrt.infoPub.web.app;

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
@RequestMapping("/v1.0/appInfoPub")
public class AppInforPubController {

	private static final Logger log = LoggerFactory.getLogger(AppInforPubController.class);
	@Resource(name = "inforPubServiceImpl")
	private InforPubService inforPubService;
	
	
	/**
	 * 
	 * 信息公示
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/state_search", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> state_search(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppInforPubController中state_search方法");
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
	
	
	
	/**
	 * 
	 * 查看公示信息详情
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchInfo", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> searchInfo(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppInforPubController中searchInfo方法");
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
	 * 公示查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/appSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> search(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的AppInforPubController中search方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> search = inforPubService.appSearch(map);
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
}
