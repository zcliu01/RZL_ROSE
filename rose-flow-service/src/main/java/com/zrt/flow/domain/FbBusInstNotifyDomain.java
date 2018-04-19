package com.zrt.flow.domain;

import java.util.List;

import com.zrt.mybatis.domain.FbBusInstNotify;

public class FbBusInstNotifyDomain extends FbBusInstNotify{

	 //一对多
  	private List<NotifyEmpDomain> notifyEmpList;

	public List<NotifyEmpDomain> getNotifyEmpList() {
		return notifyEmpList;
	}

	public void setNotifyEmpList(List<NotifyEmpDomain> notifyEmpList) {
		this.notifyEmpList = notifyEmpList;
	}
  	
  	
  	
}
