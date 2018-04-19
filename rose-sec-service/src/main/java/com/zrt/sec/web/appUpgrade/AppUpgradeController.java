package com.zrt.sec.web.appUpgrade;

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
import com.zrt.sec.service.appUpgrade.AppUpgradeService;

@RestController
@RequestMapping("/v1.0/appUpgrade")
public class AppUpgradeController {
	private static final Logger log = LoggerFactory.getLogger(AppUpgradeController.class);
	@Autowired
	private AppUpgradeService appUpgradeService;

	/**
	 * 新版本上传
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/versionUpload", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> versionUpload(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的AppUpgradeController中versionUpload方法");
		ResultMap resultMap = new ResultMap();
		try {
			appUpgradeService.versionUpload(appMap);
			resultMap.success().sucmsg("上传成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("新版本上传失败!");
		}
	}

	/**
	 * 版本检查更新
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/checkUpdate", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> checkUpdate(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的AppUpgradeController中checkUpdate方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String,Object> dataMap=appUpgradeService.checkUpdate(appMap);
			resultMap.success().data(dataMap);
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("版本检查更新失败!").map();
		}
	}

}
