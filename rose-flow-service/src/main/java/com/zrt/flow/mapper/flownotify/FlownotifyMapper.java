package com.zrt.flow.mapper.flownotify;

import java.util.List;
import java.util.Map;

import com.zrt.flow.domain.InstInfoDomain;

/**
 * Created by dwliu on 2017/9/20.
 */
public interface FlownotifyMapper {
    /**
     * 知会我的
     * @param map
     * @return
     */
    List<InstInfoDomain> notifyList(Map<String, Object> map);

    /**
     * 我知会的
     * @param map
     * @return
     */
    List<InstInfoDomain> selfList(Map<String, Object> map);

    List<Map<String,Object>> appNotifyList(Map<String, Object> map);

    List<Map<String,Object>> appSelfList(Map<String, Object> map);
    /**
     * 查询是否知会过
     */
    List<Map<String,Object>> tagNotifyList(Map<String, Object> map);
}
