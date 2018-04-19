package com.zrt.sec.service.appUpgrade;

import java.util.Map;

public interface AppUpgradeService {
	// 新版本上传
	void versionUpload(Map<String, Object> appMap) throws Exception;

	// 版本检查更新
	Map<String, Object> checkUpdate(Map<String, Object> appMap) throws Exception;

}
