package com.zrt.infor.service.contacts;

import java.util.Map;

/**
 * Created by msKui on 2017/3/23.
 */
public interface ContactsService {
	Map<String, Object> commonEmpSearch(Map<String, Object> map);

	Map<String, Object> getRedis(Map<String, Object> map);
}
