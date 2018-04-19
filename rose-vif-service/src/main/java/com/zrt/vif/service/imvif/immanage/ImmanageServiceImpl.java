package com.zrt.vif.service.imvif.immanage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zrt.commons.AppException;
import com.zrt.commons.utils.HttpUtils;
import com.zrt.configuration.ImConfig;
import com.zrt.vif.service.contacts.ContactsService;

@Service
public class ImmanageServiceImpl implements ImmanageService {

	private static final Logger log = LoggerFactory.getLogger(ImmanageServiceImpl.class);

	@Autowired
	private ImConfig imConfig;
	@Autowired
	private ContactsService contactsService;

	@Override
	public Map<String, Object> pushMsg(Map<String, Object> appMap) throws Exception {

		Map<String, Object> reqMap = new HashMap<String, Object>();

		reqMap.put("appId", appMap.get("appId"));// 应用Id，
		reqMap.put("sender", appMap.get("sender"));// 发送者帐号，
		reqMap.put("msgType", appMap.get("msgType"));// 消息类型，1：文本消息，2：语音消息，3：视频消息，4：图片消息，5：位置消息，6：文件
		reqMap.put("msgContent", appMap.get("msgContent"));// 文本内容，最大长度2048字节，文本和附件二选一，不能都为空
		reqMap.put("msgDomain", appMap.get("msgDomain"));// 扩展字段，最大长度2048字符
		reqMap.put("msgFileName", appMap.get("msgFileName"));// 文件名，最大长度128字节
		reqMap.put("msgFileUrl", appMap.get("msgFileUrl"));// 文件绝对路径，最大长度1024个字符
		ObjectMapper mapper = new ObjectMapper();

		Map<String, Object> conMap = contactsService.searchAll(appMap);// 获取组织通讯录全部员工
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) conMap.get("data");

		@SuppressWarnings("unchecked")
		List<String> receivers = (List<String>) appMap.get("receiver");
//		log.error("dataList通讯录查询总数为：" + dataList.size());
//		log.error("receivers请求过来的总数为：" + receivers.size());
//		if (receivers.size() == dataList.size()) {// 代表发送全部员工
//			reqMap.put("pushType", "3");// 推送类型，1：个人，2：群组，默认为1；3:全体员工
//			log.error("**********推送类型为3");
//			String jsonData = mapper.writeValueAsString(reqMap);
//			HttpUtils httpUtils = new HttpUtils(imConfig);
//			String resJson = httpUtils.postRestJsonData(jsonData);
//			Map<String, Object> dataMap = mapper.readValue(resJson.getBytes(), HashMap.class);
//			if (dataMap != null) {
//				String statusCode = (String) dataMap.get("statusCode");// 请求响应码
//				if (!"000000".equals(statusCode)) {// 判断是否推送成功
//					throw new AppException("IM消息推送失败");
//				}
//			}
//		} else {
			reqMap.put("pushType", appMap.get("pushType"));// 推送类型，1：个人，2：群组，默认为1；3:全体员工

			int length = receivers.size();
			int count = 0;
			if (length > 100) {
				if (length % 100 != 0) {
					count = length / 100 + 1;
				} else {
					count = length / 100;
				}
				for (int i = 0; i < count; i++) {
					String[] receiver = null;
					if (i == count - 1) {
						receiver = new String[length - i * 100];
					} else {
						receiver = new String[100];
					}
					for (int j = 0; j < 100; j++) {
						if ((i * 100 + j) < length) {
							receiver[j] = receivers.get(i * 100 + j);
						}
					}
					if (i > 2 && i % 3 == 0) {
						Thread.sleep(30000);
					}
					reqMap.put("receiver", receiver);// 接收者帐号，
					String jsonData = mapper.writeValueAsString(reqMap);
					HttpUtils httpUtils = new HttpUtils(imConfig);
					String resJson = httpUtils.postRestJsonData(jsonData);
					Map<String, Object> dataMap = mapper.readValue(resJson.getBytes(), HashMap.class);
					if (dataMap != null) {
						String statusCode = (String) dataMap.get("statusCode");// 请求响应码
						if (!"000000".equals(statusCode)) {// 判断是否推送成功
							throw new AppException("IM消息推送失败");
						}
					}
				}
			} else {
				reqMap.put("receiver", appMap.get("receiver"));// 接收者帐号，
				String jsonData = mapper.writeValueAsString(reqMap);
				HttpUtils httpUtils = new HttpUtils(imConfig);
				String resJson = httpUtils.postRestJsonData(jsonData);
				Map<String, Object> dataMap = mapper.readValue(resJson.getBytes(), HashMap.class);
				if (dataMap != null) {
					String statusCode = (String) dataMap.get("statusCode");// 请求响应码
					if (!"000000".equals(statusCode)) {// 判断是否推送成功
						throw new AppException("IM消息推送失败");
					}
				}
			}

//		}

		return null;

	}
}
