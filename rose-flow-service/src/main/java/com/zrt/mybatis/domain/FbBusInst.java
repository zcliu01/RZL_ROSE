package com.zrt.mybatis.domain;

public class FbBusInst {
    private String id;

    private String applyId;

    private String applyName;

    private String orgId;

    private String orgName;

    private String fbId;

    private String fbTitle;

    private String createDateTime;

    private String startDateTime;

    private String updateDateTime;

    private String instStatus;

    private String tenantId;

    private String instTag;

    private String instTagName;

    private String fbContent;

    private String nextInstTag;

    private String nextInstTagName;

    private String nextTagAssignee;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName == null ? null : applyName.trim();
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

    public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId == null ? null : fbId.trim();
    }

    public String getFbTitle() {
        return fbTitle;
    }

    public void setFbTitle(String fbTitle) {
        this.fbTitle = fbTitle == null ? null : fbTitle.trim();
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime == null ? null : createDateTime.trim();
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime == null ? null : startDateTime.trim();
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime == null ? null : updateDateTime.trim();
    }

    public String getInstStatus() {
        return instStatus;
    }

    public void setInstStatus(String instStatus) {
        this.instStatus = instStatus == null ? null : instStatus.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getInstTag() {
        return instTag;
    }

    public void setInstTag(String instTag) {
        this.instTag = instTag == null ? null : instTag.trim();
    }

    public String getInstTagName() {
        return instTagName;
    }

    public void setInstTagName(String instTagName) {
        this.instTagName = instTagName == null ? null : instTagName.trim();
    }

    public String getFbContent() {
        return fbContent;
    }

    public void setFbContent(String fbContent) {
        this.fbContent = fbContent == null ? null : fbContent.trim();
    }

    public String getNextInstTag() {
        return nextInstTag;
    }

    public void setNextInstTag(String nextInstTag) {
        this.nextInstTag = nextInstTag == null ? null : nextInstTag.trim();
    }

    public String getNextInstTagName() {
        return nextInstTagName;
    }

    public void setNextInstTagName(String nextInstTagName) {
        this.nextInstTagName = nextInstTagName == null ? null : nextInstTagName.trim();
    }

    public String getNextTagAssignee() {
        return nextTagAssignee;
    }

    public void setNextTagAssignee(String nextTagAssignee) {
        this.nextTagAssignee = nextTagAssignee == null ? null : nextTagAssignee.trim();
    }
}