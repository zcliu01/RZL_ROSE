package com.zrt.infor.service.inforinner;

import java.util.List;
import java.util.Map;

import com.zrt.infor.domain.InforOutbox;

/**
 * Created by msKui on 2017/3/21.
 */
public interface InforInnerService {
    /**
     * 讯息发件列表
     * @param map
     * @return
     */
    Map<String,Object> inforOutboxListMap(Map<String,Object> map) throws Exception;

    /**
     * 讯息发件列表
     * @param map
     * @return
     */
    List<InforOutbox> inforOutboxListDomain(Map<String,Object> map) throws Exception;

    /**
     * 讯息收件列表
     * @param map
     * @return
     */
    List<Map<String,Object>> inforInboxList(Map<String,Object> map) throws Exception;


    /**
     * 我的监控-按讯息-所有发送讯息列表
     * @param map
     * @return
     */
    List<Map<String,Object>> monInforList(Map<String,Object> map) throws Exception;

    /**
     * 我的监控-按讯息-讯息接收后的处理情况
     * @param map
     * @return
     */
    List<Map<String,Object>> monInforManageList(Map<String,Object> map) throws Exception;

    /**
     * 我的监控-按人员-发送给某位员工的所有信息
     * @param map
     * @return
     */
    List<Map<String,Object>> monEmpList(Map<String,Object> map) throws Exception;
    
    /**
     * 全部讯息
     * @param map
     * @return
     * @throws Exception
     */
    Map<String,Object> inforList(Map<String,Object> map) throws Exception;
    
    /**
     * 草稿
     */
    Map<String,Object> inforDraftList(Map<String,Object> map) throws Exception;
    
    /**
     * 已关注
     * @param map
     * @return
     * @throws Exception
     */
    
    Map<String,Object> inforCareList(Map<String,Object> map) throws Exception;
    
    /**
     * 已关注
     * @param map
     * @return
     * @throws Exception
     */
    
    Map<String,Object> inforDealList(Map<String,Object> map) throws Exception;
    
    /**
     * app 讯息查询列表
     * @param map
     * @return
     * @throws Exception
     */
    Map<String,Object> appInfoList(Map<String,Object> map) throws Exception;
    
    //草稿删除
    int inforDraftDelete(Map<String, Object> map) throws Exception;
    //草稿发送
    int inforDraftSend(Map<String, Object> map) throws Exception;
    //获取待阅标识
    Map<String,Object> getInforCountFlag(Map<String,Object> map) throws Exception;
}
