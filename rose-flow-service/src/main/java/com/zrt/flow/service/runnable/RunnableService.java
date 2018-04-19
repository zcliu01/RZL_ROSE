package com.zrt.flow.service.runnable;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunnableService {
	@Autowired
	private InforReadThread inforReadThread;
	@Autowired
	private ImThread imThread;
	@Autowired
	private InforThread inforThread;
	/**
	 * 发送流程讯息
	 * 
	 * @param map
	 */
	public void inforCall(Map<String, Object> map) {

		inforThread.setTitle((String) map.get("title"));// 讯息标题
		inforThread.setContent((String) map.get("content"));// 讯息内容
		inforThread.setSender((String) map.get("sender"));// 发送人
		inforThread.setReceiver((String) map.get("receiver"));// 接收人，以"；"分割的字符串
		inforThread.setBusType((String) map.get("bus_type"));// 推送类型：1:个人信息修改，2：会议新建，3：会议修改，4：会议取消,5:任务新建，6：任务结束，7：普通流程代办任务，8：会签流程代办任务
		inforThread.setBusDomain((String) map.get("bus_domain"));// 扩展字段
		inforThread.setBusId((String) map.get("bus_id"));// 扩展字段
		Thread t = new Thread(inforThread);
		t.start();
	}

	/**
	 * IM消息通知
	 * 
	 * @param map
	 */
	public void imCall(Map<String, Object> map) {

		imThread.setSender((String) map.get("sender"));// 发送人
		imThread.setReceiver((String[]) map.get("receiver"));// 接收人，receiver为";"分割的数组
		imThread.setMsgContent((String) map.get("msgContent"));// 消息内容
		imThread.setMsgDomain((String) map.get("msgDomain"));// 扩展字段

		Thread t = new Thread(imThread);
		t.start();
	}
	
	
	/**
	 * 讯息已阅
	 * 
	 * @param map
	 */
	public void sendReadInfor(Map<String, Object> map) {

		inforReadThread.setBusDomain((String) map.get("bus_domain"));// 扩展字段
		inforReadThread.setBusId((String) map.get("bus_id"));// 扩展字段
		Thread t = new Thread(inforReadThread);
		t.start();
	}

}
