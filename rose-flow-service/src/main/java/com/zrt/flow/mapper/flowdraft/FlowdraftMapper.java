package com.zrt.flow.mapper.flowdraft;

import java.util.List;
import java.util.Map;

/**
 * Created by dwliu on 2017/9/19.
 */
public interface FlowdraftMapper {

    //查询流程草稿列表
    List<Map<String,Object>> flowdraftList(Map<String, Object> map);

    //查询流程草稿列表
    List<Map<String,Object>> appFlowdraftList(Map<String, Object> map);
}
