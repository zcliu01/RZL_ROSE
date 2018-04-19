package com.zrt.vif.web.manage.vpn;

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
import com.zrt.vif.service.vpn.VpnService;

@RestController
@RequestMapping("/v1.0/vpn")
public class VpnController {
	private static final Logger log = LoggerFactory.getLogger(VpnController.class);
	@Autowired
	private VpnService vpnService;

	/**
	 * 新增设备信息
	 */
	@RequestMapping(value = "/vpnSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> vpnSave(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VpnController中vpnSave方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vpnService.vpnSave(map);
			resultMap.data(resMap);
			resultMap.success().sucmsg("新增设备信息成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("新增设备信息失败!").map();
		}
	}

	/**
	 * 删除设备信息
	 */
	@RequestMapping(value = "/vpnDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> vpnDelete(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VpnController中vpnDelete方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vpnService.vpnDelete(map);
			resultMap.data(resMap);
			resultMap.success().sucmsg("删除设备信息成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("删除设备信息失败!").map();
		}
	}

	/**
	 * 全部设备信息同步
	 */
	@RequestMapping(value = "/vpnAllSync", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> vpnAllSync(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的VpnController中vpnAllSync方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resMap = vpnService.vpnAllSync(map);
			resultMap.data(resMap);
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
