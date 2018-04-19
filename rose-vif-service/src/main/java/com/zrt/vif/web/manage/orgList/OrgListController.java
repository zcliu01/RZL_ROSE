package com.zrt.vif.web.manage.orgList;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.vif.service.orgLIst.OrgListService;

@RestController
@RequestMapping("/v1.0/foreignOrg")
public class OrgListController {
	private static final Logger log = LoggerFactory.getLogger(OrgListController.class);
	@Autowired
	private OrgListService orgListService;

	/**
	 * 组织机构树
	 */
	@RequestMapping(value = "/allList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> vpnSave(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VpnController中allList方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = orgListService.orgAllList(map);
			resultMap.data(resMap.get("data"));
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
	 * 员工信息列表
	 */
	@RequestMapping(value = "/ypEmpList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> ypEmpList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VpnController中ypEmpList方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = orgListService.ypEmpList(map);
			resultMap.data(resMap.get("data"));
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
