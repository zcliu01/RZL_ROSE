package com.zrt.contacts.service.im;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zrt.commons.AppException;
import com.zrt.commons.date.DateUtil;
import com.zrt.contacts.service.vif.VifService;

@Service
public class ImServiceImpl implements ImService {

	@Autowired
	private VifService vifService;
	@Value("${im.appId}")
	private String imAppId;

	@Override
	public void send(Map<String, Object> map) throws AppException {
		Map<String, Object> imReqMap = new HashMap<String, Object>();
		imReqMap.put("pushType", "1");// 1:个人
		imReqMap.put("appId", imAppId);
		imReqMap.put("sender", map.get("sender_id"));
		imReqMap.put("receiver", ((String) map.get("receiver_ids")).split(";"));
		imReqMap.put("msgType", "1");// 1：文本消息
		imReqMap.put("msgContent", map.get("content"));
		imReqMap.put("msgDomain", "");
		vifService.pushMsg(imReqMap);

	}

}
