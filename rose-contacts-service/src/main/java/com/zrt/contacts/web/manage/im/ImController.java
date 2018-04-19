package com.zrt.contacts.web.manage.im;

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
import com.zrt.contacts.service.im.ImService;

/**
 * 
 * @description 项目列表服务
 * @author wwfu
 *
 */
@RestController
@RequestMapping("/v1.0/im")
public class ImController {
	private static final Logger log = LoggerFactory.getLogger(ImController.class);

	@Autowired
	ImService imService;

	@RequestMapping(value = "/send", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> list(@RequestBody Map<String, Object> map) throws Exception {
		log.info("调用contacts服务ImController中send方法");
		ResultMap resultMap = new ResultMap();

		try {
			imService.send(map);
			resultMap.success().sucmsg("发送成功!");
			return resultMap.map();

		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("发送失败!").map();
		}
	}

}
