package com.zrt.mybatis.domain;

public class FbBusInstNotify {
    private String id;

    private String telEmpId;

    private String telEmpName;

    private String orgId;

    private String orgName;

    private String instId;

    private String createDateTime;

    private String updateDateTime;

    private String instTag;

    private String instTagName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTelEmpId() {
        return telEmpId;
    }

    public void setTelEmpId(String telEmpId) {
        this.telEmpId = telEmpId == null ? null : telEmpId.trim();
    }

    public String getTelEmpName() {
        return telEmpName;
    }

    public void setTelEmpName(String telEmpName) {
        this.telEmpName = telEmpName == null ? null : telEmpName.trim();
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

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId == null ? null : instId.trim();
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
}