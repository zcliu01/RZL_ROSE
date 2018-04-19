package com.zrt.flow.service.infor;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zrt.client.infor.IInforClient;
import com.zrt.flow.service.serial.SerialService;

@Service
public class InforServiceImpl implements InforService {
	private final transient Logger logger = LoggerFactory.getLogger(SerialService.class);

	@Resource(name = "HystrixInforClient")
	private IInforClient iInforClient;

	@Override
	public Map<String, Object> sendUpdateInfor(Map<String, Object> map) {
		logger.info("调用infor服务向指定人员发送讯息！");
		Map<String, Object> inforMap = new HashMap<String, Object>();
		inforMap.put("title", map.get("title"));// 讯息标题
		inforMap.put("content", map.get("content"));// 讯息内容
		inforMap.put("sender_id", map.get("sender_id"));// 发送人
		inforMap.put("receiver_ids", map.get("receiver_ids"));// 接收人，以"；"分割的字符串
		inforMap.put("bus_type", map.get("bus_type"));// 推送类型：1:个人信息修改，2：会议新建，3：会议修改，4：会议取消,5:任务新建，6：任务结束，7：普通流程代办任务，8：会签流程代办任务
		inforMap.put("bus_domain", map.get("bus_domain"));//扩展字段
		inforMap.put("bus_id", map.get("bus_id"));//扩展字段
		inforMap.put("category", "flowInfor");
		Map<String, Object> result = iInforClient.sendUpdateInfor(inforMap);
		return result;
	}

	@Override
	public Map<String, Object> sendReadInfor(Map<String, Object> map) {
		logger.info("调用infor服务,讯息已阅！");
		Map<String, Object> inforMap = new HashMap<String, Object>();
		inforMap.put("bus_domain", map.get("bus_domain"));//扩展字段
		inforMap.put("bus_id", map.get("bus_id"));//业务id
		inforMap.put("category", "flowInfor");
		Map<String, Object> result = iInforClient.sendReadInfor(inforMap);
		return result;
	}
}
