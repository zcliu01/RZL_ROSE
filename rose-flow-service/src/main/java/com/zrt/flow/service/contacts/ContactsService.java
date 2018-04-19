package com.zrt.flow.service.contacts;

import java.util.List;
import java.util.Map;

/**
 * Created by wwfu on 2017/3/23.
 */
public interface ContactsService {
    Map<String,Object> commonEmpSearch(Map<String, Object> map);
    
    List<Map<String, Object>> empOrgInfo(Map<String, Object> map);
    
    Map<String,Object> commonEmpSearchDetail(String empId);
}
