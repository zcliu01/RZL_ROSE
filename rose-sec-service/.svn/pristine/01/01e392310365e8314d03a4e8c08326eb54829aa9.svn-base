package com.zrt.sec.service.appUpgrade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.mybatis.domain.SysAppUpgrade;
import com.zrt.mybatis.domain.SysAppUpgradeExample;
import com.zrt.mybatis.mapper.SysAppUpgradeMapper;
import com.zrt.sec.mapper.sysAppUpgrade.SysAppUpgradeCustomMapper;
import com.zrt.sec.service.serial.SerialService;

@Service
public class AppUpgradeServiceImpl implements AppUpgradeService {
	@Autowired
	private SysAppUpgradeCustomMapper sysAppUpgradeCustomMapper;
	@Autowired
	private SysAppUpgradeMapper sysAppUpgradeMapper;
	@Autowired
	private SerialService serialService;

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void versionUpload(Map<String, Object> appMap) throws Exception {
		SysAppUpgrade sau = new SysAppUpgrade();
		sau.setId(serialService.getUUID());
		sau.setDeviceType((String) appMap.get("device_type"));
		Map<String, Object> versionMap = sysAppUpgradeCustomMapper.getMaxVer(appMap);
		int maxSersion = (int) versionMap.get("maxSersion");
		sau.setVersionCode(maxSersion + 1);
		String version = String.valueOf(sau.getVersionCode());
		sau.setVersion(version.substring(0, 1) + "." + version.substring(1, 2) + "." + version.substring(2, 3));
		sau.setDownloadUrl((String) appMap.get("download_url"));
		sau.setIllustrate((String) appMap.get("illustrate"));

		sysAppUpgradeMapper.insert(sau);

	}

	@Override
	public Map<String, Object> checkUpdate(Map<String, Object> appMap) throws Exception {

		Map<String, Object> versionMap = sysAppUpgradeCustomMapper.getMaxVer(appMap);
		int maxVersion = (int) versionMap.get("maxVersion");
		SysAppUpgradeExample example = new SysAppUpgradeExample();
		example.createCriteria().andDeviceTypeEqualTo((String) appMap.get("device_type"))
				.andVersionCodeEqualTo(maxVersion);
		List<SysAppUpgrade> sauList = sysAppUpgradeMapper.selectByExample(example);
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (sauList != null && sauList.size() > 0) {
			SysAppUpgrade sau = sauList.get(0);

			resMap.put("version", sau.getVersion());
			resMap.put("version_code", maxVersion);
			resMap.put("download_url", sau.getDownloadUrl());
			resMap.put("illustrate", sau.getIllustrate());
		}

		return resMap;
	}

}
