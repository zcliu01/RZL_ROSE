package com.zrt.flow.service.runnable;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrt.flow.service.infor.InforService;

@Service
public class InforThread implements Runnable {

	@Autowired
	private InforService inforService;

	private String title;// 讯息标题
	private String content;// 讯息内容
	private String sender;// 发送人
	private String receiver;// 接收人，以"；"分割的字符串
	private String busType;// 接收类型
	private String busDomain;// 扩展字段
	private String busId;// 业务id

	
	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public void setBusDomain(String busDomain) {
		this.busDomain = busDomain;
	}

	@Override
	public void run() {
		Map<String, Object> inforMap = new HashMap<String, Object>();
		inforMap.put("title", title);// 讯息标题
		inforMap.put("content", content);// 讯息内容
		inforMap.put("sender_id", sender);// 发送人
		inforMap.put("receiver_ids", receiver);// 接收人，以"；"分割的字符串
		inforMap.put("bus_type", busType);// 推送类型
		inforMap.put("bus_domain", busDomain);// 扩展字段
		inforMap.put("bus_id", busId);// 业务id
		inforService.sendUpdateInfor(inforMap);
	}

}
