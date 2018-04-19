package com.zrt.flow.service.flowcare;

import java.util.Map;

/**
 * 我的关注
 * Created by dwliu on 2017/9/19.
 */
public interface FlowcareService {

    //我的关注
    Map<String, Object> flowcareList(Map<String, Object> map) throws Exception;

    //我的关注app
    Map<String, Object> appFlowcareList(Map<String, Object> map) throws Exception;

    
    //我的关注保存
    Map<String, Object> careSave(Map<String, Object> map) throws Exception;
    
    //取消关注
    Map<String, Object> careCancle(Map<String, Object> map) throws Exception;

}
