package com.zrt.mybatis.domain;

public class InfoPub {
    private String infoId;

    private String infoTitle;

    private String infoOwnerId;

    private String infoOwner;

    private String infoType;

    private String infoNumber;

    private String infoOrder;

    private String infoState;

    private String infoPubdate;

    private String tenantId;

    private String createDateTime;

    private String updateDateTime;

    private String sendinfo;

    private String sendim;

    private String infoIseveryone;

    private Integer infoVersion;

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId == null ? null : infoId.trim();
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle == null ? null : infoTitle.trim();
    }

    public String getInfoOwnerId() {
        return infoOwnerId;
    }

    public void setInfoOwnerId(String infoOwnerId) {
        this.infoOwnerId = infoOwnerId == null ? null : infoOwnerId.trim();
    }

    public String getInfoOwner() {
        return infoOwner;
    }

    public void setInfoOwner(String infoOwner) {
        this.infoOwner = infoOwner == null ? null : infoOwner.trim();
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType == null ? null : infoType.trim();
    }

    public String getInfoNumber() {
        return infoNumber;
    }

    public void setInfoNumber(String infoNumber) {
        this.infoNumber = infoNumber == null ? null : infoNumber.trim();
    }

    public String getInfoOrder() {
        return infoOrder;
    }

    public void setInfoOrder(String infoOrder) {
        this.infoOrder = infoOrder == null ? null : infoOrder.trim();
    }

    public String getInfoState() {
        return infoState;
    }

    public void setInfoState(String infoState) {
        this.infoState = infoState == null ? null : infoState.trim();
    }

    public String getInfoPubdate() {
        return infoPubdate;
    }

    public void setInfoPubdate(String infoPubdate) {
        this.infoPubdate = infoPubdate == null ? null : infoPubdate.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime == null ? null : createDateTime.trim();
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime == null ? null : updateDateTime.trim();
    }

    public String getSendinfo() {
        return sendinfo;
    }

    public void setSendinfo(String sendinfo) {
        this.sendinfo = sendinfo == null ? null : sendinfo.trim();
    }

    public String getSendim() {
        return sendim;
    }

    public void setSendim(String sendim) {
        this.sendim = sendim == null ? null : sendim.trim();
    }

    public String getInfoIseveryone() {
        return infoIseveryone;
    }

    public void setInfoIseveryone(String infoIseveryone) {
        this.infoIseveryone = infoIseveryone == null ? null : infoIseveryone.trim();
    }

    public Integer getInfoVersion() {
        return infoVersion;
    }

    public void setInfoVersion(Integer infoVersion) {
        this.infoVersion = infoVersion;
    }
}