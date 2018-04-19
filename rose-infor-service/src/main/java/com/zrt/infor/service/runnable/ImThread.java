package com.zrt.infor.service.runnable;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zrt.commons.Constant;
import com.zrt.commons.utils.ImPushMsg;
import com.zrt.infor.service.vif.VifService;

@Service
public class ImThread implements Runnable {

	@Autowired
	private VifService vifService;
	@Autowired
	private ImPushMsg imPushMsg;

	private Map<String, Object> reqMap;

	public Map<String, Object> getReqMap() {
		return reqMap;
	}

	public void setReqMap(Map<String, Object> reqMap) {
		this.reqMap = reqMap;
	}

	@Override
	public void run() {
		String receiverIds = "";
		if (StringUtils.isNotBlank((String) reqMap.get("copyer_ids"))) {
			receiverIds = (String) reqMap.get("receiver_ids") + (String) reqMap.get("copyer_ids");
		} else {
			receiverIds = (String) reqMap.get("receiver_ids");
		}

		// IM推送系统消息
		Map<String, Object> imreqMap = new HashMap<String, Object>();
		String[] receiver = receiverIds.split(";");
		imreqMap.put("receiver", receiver);
		imreqMap.put("msgContent", "您有一条新的内部讯息");

		Map<String, Object> msgDomainMap = new HashMap<String, Object>();
		msgDomainMap.put("infor_no", reqMap.get("infor_no"));
		msgDomainMap.put("title", reqMap.get("title"));
		msgDomainMap.put("content", reqMap.get("content"));
		msgDomainMap.put("status", "0");
		msgDomainMap.put("category", "innerInfor");
		// msgDomainMap.put("member", member);
		JSONObject msgDomainJSON = JSONObject.parseObject(JSON.toJSONString(msgDomainMap));
		imreqMap.put("msgDomain", "customtype=" + Constant.CUSTOMTYPE + "," + msgDomainJSON.toString());
		Map<String, Object> resMap = imPushMsg.pushMsg(imreqMap);

		vifService.pushMsg(resMap);
	}

}
