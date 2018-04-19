package com.zrt.vif.service.imvif.immanage;

import java.util.Map;

public interface ImmanageService {

	// IM消息推送
	Map<String, Object> pushMsg(Map<String, Object> map) throws Exception;

}
