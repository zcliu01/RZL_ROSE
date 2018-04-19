package com.zrt.flow.service.flownotify;

import java.util.Map;

/**
 * Created by dwliu on 2017/9/20.
 */
public interface FlownotifyService {
    /**
     * 我知会的
     * @param map
     * @return
     */
    Map<String,Object> selfList(Map<String, Object> map) throws Exception;

    /**
     * 我知会的
     * @param map
     * @return
     * @throws Exception
     */
    Map<String,Object> appSelfList(Map<String, Object> map) throws Exception;

    /**
     * 知会我的
     * @param map
     * @return
     */
    Map<String,Object> notifyList(Map<String, Object> map) throws Exception;

    /**
     * 知会我的
     * @param map
     * @return
     * @throws Exception
     */
    Map<String,Object> appNotifyList(Map<String, Object> map) throws Exception;
    
    /**
     * 只会
     */
    Map<String,Object> notify(Map<String, Object> map) throws Exception;
}
