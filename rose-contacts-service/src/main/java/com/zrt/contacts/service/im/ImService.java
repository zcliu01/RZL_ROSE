package com.zrt.contacts.service.im;

import java.util.Map;

import com.zrt.commons.AppException;

public interface ImService {
	void send(Map<String, Object> map) throws AppException;;
}
