package com.zrt.mybatis.domain;

public class FbBusInstNotifyEmp {
    private String id;

    private String notifyEmpId;

    private String notifyEmpName;

    private String notifyOrgId;

    private String notifyOrgName;

    private String createDateTime;

    private String updateDateTime;

    private String notifyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNotifyEmpId() {
        return notifyEmpId;
    }

    public void setNotifyEmpId(String notifyEmpId) {
        this.notifyEmpId = notifyEmpId == null ? null : notifyEmpId.trim();
    }

    public String getNotifyEmpName() {
        return notifyEmpName;
    }

    public void setNotifyEmpName(String notifyEmpName) {
        this.notifyEmpName = notifyEmpName == null ? null : notifyEmpName.trim();
    }

    public String getNotifyOrgId() {
        return notifyOrgId;
    }

    public void setNotifyOrgId(String notifyOrgId) {
        this.notifyOrgId = notifyOrgId == null ? null : notifyOrgId.trim();
    }

    public String getNotifyOrgName() {
        return notifyOrgName;
    }

    public void setNotifyOrgName(String notifyOrgName) {
        this.notifyOrgName = notifyOrgName == null ? null : notifyOrgName.trim();
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

    public String getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(String notifyId) {
        this.notifyId = notifyId == null ? null : notifyId.trim();
    }
}