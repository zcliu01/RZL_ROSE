package com.zrt.sec.web.vpn;

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
import com.zrt.sec.service.vpn.VpnService;

@RestController
@RequestMapping("/v1.0/vpn")
public class VpnController {
	private static final Logger log = LoggerFactory.getLogger(VpnController.class);
	@Autowired
	private VpnService vpnService;

	/**
	 * 设备信息新增
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/vpnSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> roleSave(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的VpnController中vpnSave方法");
		ResultMap resultMap = new ResultMap();
		try {
			vpnService.vpnSave(appMap);
			resultMap.success().sucmsg("新增成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("设备信息新增失败!");
		}
	}

	/**
	 * 设备信息删除
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/vpnDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> roleDelete(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的VpnController中vpnDelete方法");
		ResultMap resultMap = new ResultMap();
		try {
			vpnService.vpnDelete(appMap);
			resultMap.success().sucmsg("删除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("设备信息删除失败!").map();
		}
	}

	/**
	 * 全部设备信息同步
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/vpnAllSync", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> vpnAllSync(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的VpnController中vpnAllSync方法");
		ResultMap resultMap = new ResultMap();
		try {
			vpnService.vpnAllSync(appMap);
			resultMap.success().sucmsg("全部设备信息同步成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("全部设备信息同步失败!").map();
		}
	}

}
