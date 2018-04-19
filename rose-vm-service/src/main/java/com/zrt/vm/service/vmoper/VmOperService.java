package com.zrt.vm.service.vmoper;

import java.util.Map;

import com.zrt.commons.AppException;

public interface VmOperService {

	// web发起即时会议
	void launch(Map<String, Object> map) throws AppException;

}
