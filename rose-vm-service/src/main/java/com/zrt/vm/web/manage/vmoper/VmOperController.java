package com.zrt.vm.web.manage.vmoper;

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
import com.zrt.vm.service.vmoper.VmOperService;

@RestController
@RequestMapping("/v1.0/vmoper")
public class VmOperController {
	private static final Logger log = LoggerFactory.getLogger(VmOperController.class);

	@Autowired
	private VmOperService vmOperService;

	/**
	 * web发起即时会议
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/launch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> launch(@RequestBody Map<String, Object> map) throws AppException {
		log.info("Server端执行VmOperController的launch方法");

		ResultMap resultMap = new ResultMap();

		try {
			vmOperService.launch(map);
			resultMap.success().sucmsg("发起成功!");
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("发起失败!").map();

		}
	}

}
