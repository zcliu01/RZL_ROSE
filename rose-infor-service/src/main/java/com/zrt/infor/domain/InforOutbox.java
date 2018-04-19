package com.zrt.infor.domain;

import java.util.List;

public class InforOutbox {
    private int outId;

    private String tenantId;

    private String inforNo;

    private String senderId;

    private String senderName;

    private String orgId;

    private String orgName;

    private String sendStatus;

    private String transType;

    private String isShow;

    private String createDateTime;

    private String sendDateTime;

    private String updateDateTime;

    /**
     * 一对多
     */
    private List<InforInbox> inboxList;
    
    

    /**
     * 一对一
     */
    private InforRecord inforRecord;

    private String receiverNames;
    private String coperNames;

    private String title;

    private String content;
    
    private String accessoryFlag;//是否有附件标识
    
    
    /**
     * 一对多
     */
    private List<InforAccessory> accessoryList;
    
    /**
     * 一对多
     */
    private List<InforRelevance> relevanceList;
    
    
    
    

    public List<InforAccessory> getAccessoryList() {
		return accessoryList;
	}

	public void setAccessoryList(List<InforAccessory> accessoryList) {
		this.accessoryList = accessoryList;
	}

	public List<InforRelevance> getRelevanceList() {
		return relevanceList;
	}
	public void setRelevanceList(List<InforRelevance> relevanceList) {
		this.relevanceList = relevanceList;
	}


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

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId == null ? null : senderId.trim();
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName == null ? null : senderName.trim();
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

    

    public String getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}

	public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime == null ? null : createDateTime.trim();
    }

    public String getSendDateTime() {
        return sendDateTime;
    }

    public void setSendDateTime(String sendDateTime) {
        this.sendDateTime = sendDateTime == null ? null : sendDateTime.trim();
    }

    public List<InforInbox> getInboxList() {
        return inboxList;
    }

    public void setInboxList(List<InforInbox> inboxList) {
        this.inboxList = inboxList;
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime == null ? null : updateDateTime.trim();
    }

    public InforRecord getInforRecord() {
        return inforRecord;
    }

    public String getReceiverNames() {
        return receiverNames;
    }

    public void setReceiverNames(String receiverNames) {
        this.receiverNames = receiverNames;
    }

    public void setInforRecord(InforRecord inforRecord) {

        this.inforRecord = inforRecord;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

	public String getCoperNames() {
		return coperNames;
	}

	public void setCoperNames(String coperNames) {
		this.coperNames = coperNames;
	}

	public String getAccessoryFlag() {
		return accessoryFlag;
	}

	public void setAccessoryFlag(String accessoryFlag) {
		this.accessoryFlag = accessoryFlag;
	}

	public int getOutId() {
		return outId;
	}

	public void setOutId(int outId) {
		this.outId = outId;
	}
    
    
}