package com.zrt.mybatis.domain;

public class FbBusRejectRule {
    private String id;

    private String instId;

    private String checkId;

    private String oldInstTag;

    private String oldInstTagName;

    private String dealFlag;

    private String createDateTime;

    private String updateDateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId == null ? null : instId.trim();
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId == null ? null : checkId.trim();
    }

    public String getOldInstTag() {
        return oldInstTag;
    }

    public void setOldInstTag(String oldInstTag) {
        this.oldInstTag = oldInstTag == null ? null : oldInstTag.trim();
    }

    public String getOldInstTagName() {
        return oldInstTagName;
    }

    public void setOldInstTagName(String oldInstTagName) {
        this.oldInstTagName = oldInstTagName == null ? null : oldInstTagName.trim();
    }

    public String getDealFlag() {
        return dealFlag;
    }

    public void setDealFlag(String dealFlag) {
        this.dealFlag = dealFlag == null ? null : dealFlag.trim();
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
}