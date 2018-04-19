package com.zrt.mybatis.domain;

public class FbBusJoinSign {
    private String id;

    private String signEmpId;

    private String signEmpName;

    private String orgId;

    private String orgName;

    private String checkStatus;

    private String instId;

    private String instTag;

    private String instTagName;

    private String createDateTime;

    private String updateDateTime;

    private String checkDateTime;

    private String checkComment;

    private String checkId;

    private String signStatus;

    private String signDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSignEmpId() {
        return signEmpId;
    }

    public void setSignEmpId(String signEmpId) {
        this.signEmpId = signEmpId == null ? null : signEmpId.trim();
    }

    public String getSignEmpName() {
        return signEmpName;
    }

    public void setSignEmpName(String signEmpName) {
        this.signEmpName = signEmpName == null ? null : signEmpName.trim();
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

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId == null ? null : instId.trim();
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

    public String getCheckDateTime() {
        return checkDateTime;
    }

    public void setCheckDateTime(String checkDateTime) {
        this.checkDateTime = checkDateTime == null ? null : checkDateTime.trim();
    }

    public String getCheckComment() {
        return checkComment;
    }

    public void setCheckComment(String checkComment) {
        this.checkComment = checkComment == null ? null : checkComment.trim();
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId == null ? null : checkId.trim();
    }

    public String getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(String signStatus) {
        this.signStatus = signStatus == null ? null : signStatus.trim();
    }

    public String getSignDesc() {
        return signDesc;
    }

    public void setSignDesc(String signDesc) {
        this.signDesc = signDesc == null ? null : signDesc.trim();
    }
}