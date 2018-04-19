package com.zrt.sec.service.vpn;

import java.util.Map;

public interface VpnService {
	// 设备信息新增
	void vpnSave(Map<String, Object> appMap) throws Exception;

	// 设备信息删除
	void vpnDelete(Map<String, Object> appMap) throws Exception;

	// 设备信息删除
	void vpnAllSync(Map<String, Object> appMap) throws Exception;

}
