package com.zrt.vif.service.vpn;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrt.client.sec.ISecClient;

@Service
public class VpnService {
	private final transient Logger logger = LoggerFactory.getLogger(VpnService.class);

	@Autowired
	private ISecClient iSecClient;

	public Map<String, Object> vpnSave(Map<String, Object> map) throws Exception {
		logger.info("调用sec服务新增设备信息！");
		Map<String, Object> result = iSecClient.vpnSave(map);
		return result;
	}

	public Map<String, Object> vpnDelete(Map<String, Object> map) throws Exception {
		logger.info("调用sec服务删除设备信息！");
		Map<String, Object> result = iSecClient.vpnDelete(map);
		return result;
	}

	public Map<String, Object> vpnAllSync(Map<String, Object> map) throws Exception {
		logger.info("调用sec服务全部设备信息同步！");
		Map<String, Object> result = iSecClient.vpnAllSync(map);
		return result;
	}
}
