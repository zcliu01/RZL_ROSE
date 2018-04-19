package com.zrt.mybatis.domain;

public class DocHander {
    private Integer docHanderId;

    private String docId;

    private String handerid;

    private String handerName;

    private String handType;

    private String handInfo;

    private String docRead;

    private String handTime;

    private String handState;

    private String remark;

    private String tenantId;

    private String createDateTime;

    private String updateDateTime;

    private Integer handerOrder;

    public Integer getDocHanderId() {
        return docHanderId;
    }

    public void setDocHanderId(Integer docHanderId) {
        this.docHanderId = docHanderId;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public String getHanderid() {
        return handerid;
    }

    public void setHanderid(String handerid) {
        this.handerid = handerid == null ? null : handerid.trim();
    }

    public String getHanderName() {
        return handerName;
    }

    public void setHanderName(String handerName) {
        this.handerName = handerName == null ? null : handerName.trim();
    }

    public String getHandType() {
        return handType;
    }

    public void setHandType(String handType) {
        this.handType = handType == null ? null : handType.trim();
    }

    public String getHandInfo() {
        return handInfo;
    }

    public void setHandInfo(String handInfo) {
        this.handInfo = handInfo == null ? null : handInfo.trim();
    }

    public String getDocRead() {
        return docRead;
    }

    public void setDocRead(String docRead) {
        this.docRead = docRead == null ? null : docRead.trim();
    }

    public String getHandTime() {
        return handTime;
    }

    public void setHandTime(String handTime) {
        this.handTime = handTime == null ? null : handTime.trim();
    }

    public String getHandState() {
        return handState;
    }

    public void setHandState(String handState) {
        this.handState = handState == null ? null : handState.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Integer getHanderOrder() {
        return handerOrder;
    }

    public void setHanderOrder(Integer handerOrder) {
        this.handerOrder = handerOrder;
    }
}