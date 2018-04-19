package com.zrt.infor.domain;

public class InforAccessory {
	private String accId;

	private String inforNo;

	private String accAddress;

	private String accName;

	private String accType;
	private String nodeId;
	private int fileOrder;
	

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId == null ? null : accId.trim();
	}

	public String getInforNo() {
		return inforNo;
	}

	public void setInforNo(String inforNo) {
		this.inforNo = inforNo == null ? null : inforNo.trim();
	}

	public String getAccAddress() {
		return accAddress;
	}

	public void setAccAddress(String accAddress) {
		this.accAddress = accAddress == null ? null : accAddress.trim();
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName == null ? null : accName.trim();
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType == null ? null : accType.trim();
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public int getFileOrder() {
		return fileOrder;
	}

	public void setFileOrder(int fileOrder) {
		this.fileOrder = fileOrder;
	}
}