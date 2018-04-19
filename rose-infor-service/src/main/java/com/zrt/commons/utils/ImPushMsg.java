package com.zrt.commons.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ImPushMsg {

	@Value("${im.appId}")
	private String imAppId;
	@Value("${im.notify.sender_id}")
	private  String imSenderId;

	public  Map<String, Object> pushMsg(Map<String, Object> map) {

		Map<String, Object> imReqMap = new HashMap<String, Object>();
		imReqMap.put("pushType", "1");// 1:个人
		imReqMap.put("appId", imAppId);
		imReqMap.put("sender", imSenderId);
		imReqMap.put("receiver", map.get("receiver"));
		imReqMap.put("msgType", "1");// 1：文本消息
		imReqMap.put("msgContent", (String) map.get("msgContent"));
		imReqMap.put("msgDomain", (String) map.get("msgDomain"));

		return imReqMap;
	}

}
