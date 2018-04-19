package com.zrt.infor.mapper.inforinner;

import com.zrt.infor.domain.InforOutbox;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by msKui on 2017/3/22.
 */
public interface AppInforInnerMapper {
    /**
     * 讯息收件列表
     * @param mapParam
     * @return
     */
    List<Map<String,Object>> inforSendList(Map<String,Object> mapParam);

    /**
     * 讯息收件列表
     * @param mapParam
     * @return
     */
    List<Map<String,Object>> inforReceiverList(Map<String,Object> mapParam);
    
    /**
     * 所有讯息列表
     * @param mapParam
     * @return
     */
    List<Map<String,Object>> inforList( Map<String,Object> mapParam );

    
    /**
     * 讯息已关注列表
     * @param mapParam
     * @return
     */
    List<Map<String,Object>> inforCareList(Map<String,Object> mapParam);
    /**
     * 讯息已关注未阅、已阅、已办列表
     * @param mapParam
     * @return
     */
    List<Map<String,Object>> inforCareStatusList(Map<String,Object> mapParam);
    
}
