package com.zrt.flow.service.flowcondition;

import java.util.Map;

/**
 * Created by dwliu on 2017/9/22.
 */
public interface FlowconditionService {

    /**
     * 审核新增（附条件同意）
     * @param map
     * @return
     * @throws Exception
     */
    int applyCheckWithFile(Map<String, Object> map) throws Exception;
}
