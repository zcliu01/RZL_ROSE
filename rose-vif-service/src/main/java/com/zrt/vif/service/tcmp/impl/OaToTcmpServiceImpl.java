package com.zrt.vif.service.tcmp.impl;

import javax.jws.WebService;

import com.zrt.vif.service.tcmp.OaToTcmpService;

@WebService(targetNamespace = "http://tcmp.service.vif.zrt.com/", endpointInterface = "com.zrt.vif.service.tcmp.OaToTcmpService")
public class OaToTcmpServiceImpl implements OaToTcmpService {

	@Override
	public String getName(String userId) {
		return "lili" + userId;
	}

}
