package com.zrt.flow.service.flowdraft;

import java.util.Map;

/**
 * Created by dwliu on 2017/9/19.
 */
public interface FlowdraftService {

    //我的草稿
    Map<String, Object> flowdraftList(Map<String, Object> map) throws Exception;

    //我的草稿
    Map<String, Object> appFlowdraftList(Map<String, Object> map) throws Exception;



}
