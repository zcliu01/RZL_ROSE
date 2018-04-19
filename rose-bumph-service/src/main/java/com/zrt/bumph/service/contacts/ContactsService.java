package com.zrt.bumph.service.contacts;

import java.util.Map;

/**
 * Created by msKui 
 */
public interface ContactsService {
    Map<String,Object> commonEmpSearch(Map<String, Object> map);
    
    
    Map<String,Object> selectEmpDetails(Map<String, Object> map);
    
    
    
    Map<String,Object> temp(Map<String, Object> map);
    
}
