package com.zrt.infoPub.service.infor;

import java.util.Map;

public interface InforService {
    Map<String,Object> sendUpdateInfor(Map<String, Object> map);
    
    
    
    Map<String,Object> flowInforRead(Map<String, Object> map);
}
