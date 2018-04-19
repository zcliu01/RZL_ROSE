package com.zrt.mybatis.domain;

public class EmpContactsCmuctRcd {
    private String cmuctRcdId;

    private String tenantId;

    private String empId;

    private String cmuctId;

    private String cmuctType;

    private String createDateTime;

    private String note;

    public String getCmuctRcdId() {
        return cmuctRcdId;
    }

    public void setCmuctRcdId(String cmuctRcdId) {
        this.cmuctRcdId = cmuctRcdId == null ? null : cmuctRcdId.trim();
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

    public String getCmuctId() {
        return cmuctId;
    }

    public void setCmuctId(String cmuctId) {
        this.cmuctId = cmuctId == null ? null : cmuctId.trim();
    }

    public String getCmuctType() {
        return cmuctType;
    }

    public void setCmuctType(String cmuctType) {
        this.cmuctType = cmuctType == null ? null : cmuctType.trim();
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime == null ? null : createDateTime.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}