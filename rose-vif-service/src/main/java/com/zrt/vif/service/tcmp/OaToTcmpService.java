package com.zrt.vif.service.tcmp;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface OaToTcmpService {

	@WebMethod
	String getName(@WebParam(name = "userId") String userId);

//	@WebMethod
//	User getUser(@WebParam(name = "userId")String userId);
}
