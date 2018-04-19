package com.zrt.mybatis.domain;

public class VmBusPartin {
    private String id;

    private String recordId;

    private String recEmpId;

    private String recEmpName;

    private String orgId;

    private String orgName;

    private String mtStatus;

    private String mtDateTime;

    private String endDateTime;

    private String recType;

    private String deviceType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
    }

    public String getRecEmpId() {
        return recEmpId;
    }

    public void setRecEmpId(String recEmpId) {
        this.recEmpId = recEmpId == null ? null : recEmpId.trim();
    }

    public String getRecEmpName() {
        return recEmpName;
    }

    public void setRecEmpName(String recEmpName) {
        this.recEmpName = recEmpName == null ? null : recEmpName.trim();
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

    public String getMtStatus() {
        return mtStatus;
    }

    public void setMtStatus(String mtStatus) {
        this.mtStatus = mtStatus == null ? null : mtStatus.trim();
    }

    public String getMtDateTime() {
        return mtDateTime;
    }

    public void setMtDateTime(String mtDateTime) {
        this.mtDateTime = mtDateTime == null ? null : mtDateTime.trim();
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime == null ? null : endDateTime.trim();
    }

    public String getRecType() {
        return recType;
    }

    public void setRecType(String recType) {
        this.recType = recType == null ? null : recType.trim();
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }
}