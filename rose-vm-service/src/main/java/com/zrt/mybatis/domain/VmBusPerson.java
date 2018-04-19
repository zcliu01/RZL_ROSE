package com.zrt.mybatis.domain;

public class VmBusPerson {
    private String id;

    private String recordId;

    private String recEmpId;

    private String recEmpName;

    private String orgId;

    private String orgName;

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
}