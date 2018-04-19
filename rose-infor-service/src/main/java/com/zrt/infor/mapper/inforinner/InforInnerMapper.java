package com.zrt.infor.mapper.inforinner;

import com.zrt.infor.domain.InforOutbox;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by msKui on 2017/3/22.
 */
public interface InforInnerMapper {
    /**
     * 讯息收件列表
     * @param mapParam
     * @return
     */
    List<InforOutbox> inforSendList(@Param("mapParam") Map<String,Object> mapParam);
    Map<String, Object> inforSendListCount(@Param("mapParam") Map<String,Object> mapParam) ;
    //对发件讯息进行分组
    List<Map<String, Object>> inforSendListGroup(@Param("mapParam") Map<String,Object> mapParam) ;

    /**
     * 讯息收件列表
     * @param mapParam
     * @return
     */
    List<Map<String,Object>> inforReceiveList(@Param("mapParam") Map<String,Object> mapParam);
    
    /**
     * 所有讯息列表
     * @param mapParam
     * @return
     */
    List<Map<String,Object>> inforList(@Param("mapParam") Map<String,Object> mapParam );
    /**
     * 所有讯息列表(加状态查询只查收件)
     * @param mapParam
     * @return
     */
    List<Map<String,Object>> inforStatusList(@Param("mapParam") Map<String,Object> mapParam );
    /**
     * 所有关注讯息列表
     * @param mapParam
     * @return
     */
    List<Map<String,Object>> inforListCares(@Param("mapParam") Map<String,Object> mapParam );
    
    /**
     * 草稿列表查询
     */
    List<InforOutbox> inforDraftList(@Param("mapParam") Map<String,Object> mapParam );
    
    
    /**
     * 讯息已关注列表
     * @param mapParam
     * @return
     */
    List<Map<String,Object>> inforCareList(@Param("mapParam") Map<String,Object> mapParam);
    
    /**
     * 讯息已阅，已办
     * @param mapParam
     * @return
     */
    List<Map<String,Object>> inforDealList(@Param("mapParam") Map<String,Object> mapParam);
    
    /**
     * 讯息发件列表-关注的
     * @param mapParam
     * @return
     */
    List<InforOutbox> inforSendCareList(@Param("mapParam") Map<String,Object> mapParam);

    Map<String, Object> inforSendCareListCount(@Param("mapParam") Map<String,Object> mapParam) ;
    //对发件讯息进行分组
    List<Map<String, Object>> inforSendCareListGroup(@Param("mapParam") Map<String,Object> mapParam) ;
    /**
     * 讯息收件列表-关注的
     * @param mapParam
     * @return
     */
    List<Map<String,Object>> inforReceiveCareList(@Param("mapParam") Map<String,Object> mapParam);
    
}
