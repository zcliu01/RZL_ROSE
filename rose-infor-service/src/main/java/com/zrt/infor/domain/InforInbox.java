package com.zrt.infor.domain;

import java.util.List;

public class InforInbox {
	private int inId;

	private String tenantId;

	private String inforNo;

	private int outId;

	private String receiverId;

	private String receiverName;
	private int empOrder;

	private String receiverType;

	private String orgId;

	private String orgName;

	private String dealStatus;

	private String isShow;

	/**
	 * 一对多
	 */

	private List<InforDetail> detailList;

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId == null ? null : tenantId.trim();
	}

	public String getInforNo() {
		return inforNo;
	}

	public void setInforNo(String inforNo) {
		this.inforNo = inforNo == null ? null : inforNo.trim();
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId == null ? null : receiverId.trim();
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName == null ? null : receiverName.trim();
	}

	public String getReceiverType() {
		return receiverType;
	}

	public void setReceiverType(String receiverType) {
		this.receiverType = receiverType == null ? null : receiverType.trim();
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId == null ? null : orgId.trim();
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName == null ? null : orgName.trim();
	}

	public String getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow == null ? null : isShow.trim();
	}

	public List<InforDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<InforDetail> detailList) {
		this.detailList = detailList;
	}

	public int getOutId() {
		return outId;
	}

	public void setOutId(int outId) {
		this.outId = outId;
	}

	public int getInId() {
		return inId;
	}

	public void setInId(int inId) {
		this.inId = inId;
	}

	public int getEmpOrder() {
		return empOrder;
	}

	public void setEmpOrder(int empOrder) {
		this.empOrder = empOrder;
	}
}