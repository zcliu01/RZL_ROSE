package com.zrt.flow.service.infor;

import java.util.Map;

public interface InforService {
	//讯息推送
    Map<String,Object> sendUpdateInfor(Map<String, Object> map);
    //已办流程推送讯息，修改讯息已阅
    Map<String,Object> sendReadInfor(Map<String, Object> map);
}
