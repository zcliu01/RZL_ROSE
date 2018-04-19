package com.zrt.mybatis.domain;

public class EmpContactsFriend {
    private String friendId;

    private String tenantId;

    private String empId;

    private String friendEmpId;

    private String empStatus;

    private String createDateTime;

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId == null ? null : friendId.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public String getFriendEmpId() {
        return friendEmpId;
    }

    public void setFriendEmpId(String friendEmpId) {
        this.friendEmpId = friendEmpId == null ? null : friendEmpId.trim();
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus == null ? null : empStatus.trim();
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime == null ? null : createDateTime.trim();
    }
}