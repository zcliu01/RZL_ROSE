package com.zrt.flow.service.vmvif;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zrt.client.vmvif.VmvifClient;
import com.zrt.flow.service.serial.SerialService;

@Service
public class VmvifServiceImpl implements VmvifService {
	private final transient Logger logger = LoggerFactory.getLogger(SerialService.class);

	@Resource(name = "HystrixVmvifClient")
	private VmvifClient vmvifClient;
	@Value("${im.appId}")
	private String imAppId;

	@Override
	public Map<String, Object> pushMsg(Map<String, Object> map) {
		logger.info("调用vmvif服务pushMsg方法");
		Map<String, Object> imReqMap = new HashMap<String, Object>();
		imReqMap.put("pushType", "1");// 1:个人
		imReqMap.put("appId", imAppId);
		imReqMap.put("sender", map.get("sender"));// 发送人
		imReqMap.put("receiver", map.get("receiver"));// 接收人，receiver为";"分割的数组
		imReqMap.put("msgType", "1");// 1：文本消息
		imReqMap.put("msgContent", map.get("msgContent"));// 消息内容
		imReqMap.put("msgDomain", map.get("msgDomain"));//扩展字段
		Map<String, Object> result = vmvifClient.pushMsg(imReqMap);
		return result;
	}
}
