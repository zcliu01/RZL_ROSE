package com.zrt.infor.service.vif;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zrt.client.vif.VifClient;
import com.zrt.infor.service.serial.SerialService;

@Service
public class VifServiceImpl implements VifService {
	private final transient Logger logger = LoggerFactory.getLogger(SerialService.class);

	@Resource(name = "HystrixVifClient")
	private VifClient vifClient;

	@Override
	public Map<String, Object> pushMsg(Map<String, Object> map) {
		logger.info("调用vif服务pushMsg方法");
		Map<String, Object> result = vifClient.pushMsg(map);
		return result;
	}

}
