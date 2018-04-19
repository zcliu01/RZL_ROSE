package com.zrt.vif.web.manage.imvif.immanage;

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
import com.zrt.vif.service.imvif.immanage.ImmanageService;

/**
 * IM service 推送
 * @author wwfu
 *
 */
@RestController
@RequestMapping("/v1.0/immanage")
public class ImmanageController {
	private static final Logger log = LoggerFactory.getLogger(ImmanageController.class);
	@Autowired
	private ImmanageService immanageService;

	/**
	 * 创建视频会议室
	 */
	@RequestMapping(value = "/pushMsg", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> pushMsg(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的ImmanageController中pushMsg方法");
		ResultMap resultMap = new ResultMap();
		try {
			immanageService.pushMsg(appMap);
			resultMap.success().sucmsg("IM消息推送成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("error", e);
			return resultMap.failure().errmsg("IM消息推送失败!").map();
		}
	}

}
