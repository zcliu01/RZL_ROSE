package com.zrt.vif.web.manage.tcmp;

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
import com.zrt.vif.service.tcmp.TcmpService;

@RestController
@RequestMapping("/v1.0/tcmp")
public class TcmpCountController {
	private static final Logger log = LoggerFactory.getLogger(TcmpCountController.class);
	@Autowired
	private TcmpService tcmpService;

	/**
	 * 首页获取Tcmp流程待办条数
	 */
	@RequestMapping(value = "/indexCount", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> indexCount(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的TcmpCountController中indexCount方法");
		ResultMap resultMap = new ResultMap();
		try {
			map.put("userid", map.get("emp_id"));
			Map<String, Object> resMap = tcmpService.getCount(map);
			resultMap.data(resMap);
			resultMap.success().sucmsg("获取tcmp待办流程条数成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("获取tcmp待办流程条数失败!").map();
		}
	}

}
