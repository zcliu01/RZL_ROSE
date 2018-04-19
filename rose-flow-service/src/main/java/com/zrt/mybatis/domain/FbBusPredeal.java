package com.zrt.mybatis.domain;

public class FbBusPredeal {
    private String id;

    private String checkEmpId;

    private String checkEmpName;

    private String orgId;

    private String orgName;

    private String checkStatus;

    private String instId;

    private String instTag;

    private String instTagName;

    private String createDateTime;

    private String updateDateTime;

    private String checkComment;

    private String repeatFlag;

    private String preStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCheckEmpId() {
        return checkEmpId;
    }

    public void setCheckEmpId(String checkEmpId) {
        this.checkEmpId = checkEmpId == null ? null : checkEmpId.trim();
    }

    public String getCheckEmpName() {
        return checkEmpName;
    }

    public void setCheckEmpName(String checkEmpName) {
        this.checkEmpName = checkEmpName == null ? null : checkEmpName.trim();
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

    public String getCheckComment() {
        return checkComment;
    }

    public void setCheckComment(String checkComment) {
        this.checkComment = checkComment == null ? null : checkComment.trim();
    }

    public String getRepeatFlag() {
        return repeatFlag;
    }

    public void setRepeatFlag(String repeatFlag) {
        this.repeatFlag = repeatFlag == null ? null : repeatFlag.trim();
    }

    public String getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(String preStatus) {
        this.preStatus = preStatus == null ? null : preStatus.trim();
    }
}