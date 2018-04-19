package com.zrt.flow.service.runnable;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrt.flow.service.vmvif.VmvifService;

@Service
public class ImThread implements Runnable {

	@Autowired
	private VmvifService vmvifService;

	private String sender;// 发送人
	private String[] receiver;// 接收人，receiver为";"分割的数组
	private String msgContent;// 消息内容
	private String msgDomain;// 扩展字段

	public void setSender(String sender) {
		this.sender = sender;
	}

	public void setReceiver(String[] receiver) {
		this.receiver = receiver;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public void setMsgDomain(String msgDomain) {
		this.msgDomain = msgDomain;
	}

	@Override
	public void run() {
		Map<String, Object> imReqMap = new HashMap<String, Object>();
		imReqMap.put("sender", sender);// 发送人
		imReqMap.put("receiver", receiver);// 接收人，receiver为";"分割的数组
		imReqMap.put("msgContent", msgContent);// 消息内容
		imReqMap.put("msgDomain", msgDomain);// 扩展字段
		vmvifService.pushMsg(imReqMap);
	}

}
