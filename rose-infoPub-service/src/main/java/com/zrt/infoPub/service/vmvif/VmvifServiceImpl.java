package com.zrt.infoPub.service.vmvif;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zrt.client.vmvif.VmvifClient;
import com.zrt.infoPub.service.serial.SerialService;

@Service
public class VmvifServiceImpl implements VmvifService {
	private final transient Logger logger = LoggerFactory.getLogger(SerialService.class);

	@Resource(name = "HystrixVmvifClient")
	private VmvifClient vmvifClient;



	@Override
	public Map<String, Object> pushMsg(Map<String, Object> map) {
		logger.info("调用vmvif服务pushMsg方法");
		Map<String, Object> result = vmvifClient.pushMsg(map);
		return result;
	}


}
