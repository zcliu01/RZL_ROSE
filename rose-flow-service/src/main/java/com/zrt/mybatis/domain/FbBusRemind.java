package com.zrt.mybatis.domain;

public class FbBusRemind {
    private String id;

    private String tenantId;

    private String remindEmpId;

    private String instId;

    private String instTag;

    private String instTagName;

    private String createDateTime;

    private String updateDateTime;

    private String beremindEmpId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getRemindEmpId() {
        return remindEmpId;
    }

    public void setRemindEmpId(String remindEmpId) {
        this.remindEmpId = remindEmpId == null ? null : remindEmpId.trim();
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

    public String getBeremindEmpId() {
        return beremindEmpId;
    }

    public void setBeremindEmpId(String beremindEmpId) {
        this.beremindEmpId = beremindEmpId == null ? null : beremindEmpId.trim();
    }
}