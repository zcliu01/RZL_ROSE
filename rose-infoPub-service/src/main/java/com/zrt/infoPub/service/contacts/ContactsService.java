package com.zrt.infoPub.service.contacts;

import java.util.Map;

public interface ContactsService {
	Map<String, Object> commonEmpSearch(Map<String, Object> map);

	Map<String, Object> meetEmpInfo(Map<String, Object> map);

	Map<String, Object> getRedis(Map<String, Object> map);
	
	Map<String, Object> searchAll(Map<String, Object> map);
}
