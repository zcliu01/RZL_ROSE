package com.zrt.flow.mapper.flowcare;

import java.util.List;
import java.util.Map;

import com.zrt.flow.domain.InstInfoDomain;

/**
 * Created by dwliu on 2017/9/19.
 */
public interface FlowcareMapper {

    //查询流程关注列表
//    List<Map<String,Object>> flowcareList(Map<String, Object> map);
  //查询已办列表
  	List<InstInfoDomain> flowcareList(Map<String, Object> map);

    //查询流程关注列表
    List<Map<String,Object>> appFlowcareList(Map<String, Object> map);
}
