package com.zrt.client.sec;

public interface SecServiceUrlConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String SEC_INSTANCE = "sec";

	/**
	 * 新增设备信息
	 */
	String VPN_SAVE = "/v1.0/vpn/vpnSave";
	/**
	 * 删除设备信息
	 */
	String VPN_DELETE = "/v1.0/vpn/vpnDelete";
	/**
	 * 全部设备信息同步
	 */
	String VPNALL_SYNC = "/v1.0/vpn/vpnAllSync";

}
