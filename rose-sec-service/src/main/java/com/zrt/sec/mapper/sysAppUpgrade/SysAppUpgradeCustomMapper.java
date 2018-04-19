package com.zrt.sec.mapper.sysAppUpgrade;

import java.util.Map;

public interface SysAppUpgradeCustomMapper {

	// 获取app最大版本号
	Map<String, Object> getMaxVer(Map<String, Object> map) throws Exception;
}
