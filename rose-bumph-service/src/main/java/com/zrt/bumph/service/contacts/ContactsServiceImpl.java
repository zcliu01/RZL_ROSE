package com.zrt.bumph.service.contacts;

import com.zrt.bumph.service.serial.SerialService;
import com.zrt.client.contacts.IContactsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by msKui on 
 */
@Service
public class ContactsServiceImpl implements ContactsService{
    private final transient Logger logger = LoggerFactory.getLogger(SerialService.class);

    @Resource(name="HystrixContactsClient")
    private IContactsClient iContactsClient;

    @Override
    public Map<String, Object> commonEmpSearch(Map<String, Object> map) {
        logger.info("从contacts服务中获取员工的员工姓名、组织机构id和组织机构名称");
        Map<String, Object> result = iContactsClient.commonEmpSearch(map);
        return result;
    }

	@Override
	public Map<String, Object> temp(Map<String, Object> map) {
        Map<String, Object> result = iContactsClient.temp(map);
        return result;
	}

	@Override
	public Map<String, Object> selectEmpDetails(Map<String, Object> map) {
		Map<String, Object> result = iContactsClient.selectEmpDetails(map);
		return result;
	}
}
