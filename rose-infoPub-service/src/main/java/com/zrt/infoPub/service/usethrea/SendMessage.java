package com.zrt.infoPub.service.usethrea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.Service.State;
import com.zrt.commons.Constant;
import com.zrt.infoPub.service.contacts.ContactsService;
import com.zrt.infoPub.service.infor.InforService;
import com.zrt.infoPub.service.vmvif.VmvifService;
import com.zrt.mybatis.domain.InfoPub;
import com.zrt.mybatis.domain.InfoPubWithBLOBs;

@Service
public class SendMessage implements Runnable {


	@Value("${im.appId}")
	private String imAppId;

	@Autowired
	InforService inforService;
	
	@Autowired
	VmvifService vmvifService;

	private List<Map<String, Object>> searchViewer ;
	
	private String infoState ;
	
	private InfoPubWithBLOBs infoPub ;
	
	private String senderId ;

	

	public List<Map<String, Object>> getSearchViewer() {
		return searchViewer;
	}



	public void setSearchViewer(List<Map<String, Object>> searchViewer) {
		this.searchViewer = searchViewer;
	}



	public String getInfoState() {
		return infoState;
	}



	public void setInfoState(String infoState) {
		this.infoState = infoState;
	}



	public InfoPubWithBLOBs getInfoPub() {
		return infoPub;
	}



	public void setInfoPub(InfoPubWithBLOBs infoPub) {
		this.infoPub = infoPub;
	}



	public String getSenderId() {
		return senderId;
	}



	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}



	@Override
	public void run() {
		// 内部消息推送人的id拼接
		StringBuffer viewerId = new StringBuffer();
		// Im推送人的id的集合
		List<String> viewerList = new ArrayList<String>();
		for (Map<String, Object> viewerMap : searchViewer) {
			String id = (String) viewerMap.get("view_id");
			viewerId.append(id + ";");
			viewerList.add(id);
		}
		if ("1".equals(infoState)) {
			if ("1".equals(infoPub.getSendinfo())) {
				Map<String, Object> infoMap = new HashMap<String, Object>();
				Map<String, Object> infoMsgMap = new HashMap<String, Object>();
				infoMsgMap.put("bus_id", infoPub.getInfoId());
				JSONObject busDomain = JSONObject.parseObject(JSON.toJSONString(infoMsgMap));
				infoMap.put("title", infoPub.getInfoTitle());
				infoMap.put("content", infoPub.getInfoContent());
				infoMap.put("sender_id", senderId);
				infoMap.put("category", "pubInfor");
				infoMap.put("bus_type", "IB01");
				infoMap.put("bus_id", infoPub.getInfoId());
				infoMap.put("receiver_ids", viewerId.toString());
				infoMap.put("bus_domain", busDomain.toString());
				inforService.sendUpdateInfor(infoMap);
			}
			if ("1".equals(infoPub.getSendim())) {
				Map<String, Object> imMap = new HashMap<String, Object>();
				Map<String, Object> msgMap = new HashMap<String, Object>();
				msgMap.put("title", infoPub.getInfoTitle());
				msgMap.put("content", infoPub.getInfoContent());
				msgMap.put("status", "0");
				msgMap.put("category", "pubInfor");
				msgMap.put("bus_type", "IB01");
				msgMap.put("bus_id", infoPub.getInfoId());
				msgMap.put("info_version", infoPub.getInfoVersion());
				JSONObject msgDomain = JSONObject.parseObject(JSON.toJSONString(msgMap));
				imMap.put("pushType", "1");
				imMap.put("appId", imAppId);
				imMap.put("sender", "zrt_system");
				imMap.put("msgType", "1");
				imMap.put("msgDomain", "customtype=" + Constant.CUSTOMTYPE + "," + msgDomain);
				imMap.put("msgContent", "您有一条新的公示信息,请及时查看");
				imMap.put("receiver", viewerList);
				vmvifService.pushMsg(imMap);
			}
		}
		if ("0".equals(infoState)) {
			Map<String, Object> infoMsgMap = new HashMap<String, Object>();
			infoMsgMap.put("bus_id", infoPub.getInfoId());
			infoMsgMap.put("infor_flag", "1");
			JSONObject busDomain = JSONObject.parseObject(JSON.toJSONString(infoMsgMap));
			Map<String, Object> infoMap = new HashMap<String, Object>();
			infoMap.put("title", infoPub.getInfoTitle());
			infoMap.put("content", "该信息公示已撤销,无法查看!");
			infoMap.put("sender_id", senderId);
			infoMap.put("category", "pubInfor");
			infoMap.put("bus_type", "IB02");
			infoMap.put("bus_id", infoPub.getInfoId());
			infoMap.put("receiver_ids", viewerId.toString());
			infoMap.put("bus_domain", busDomain.toString());
			inforService.sendUpdateInfor(infoMap);
		}
	}
}
