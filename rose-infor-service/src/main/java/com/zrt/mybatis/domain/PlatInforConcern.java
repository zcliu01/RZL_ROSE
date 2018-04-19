package com.zrt.mybatis.domain;

public class PlatInforConcern {
    private String concernId;

    private String tenantId;

    private String empId;

    private String inforNo;

    private String concernType;

    private String createDateTime;

    private String updateDateTime;

    public String getConcernId() {
        return concernId;
    }

    public void setConcernId(String concernId) {
        this.concernId = concernId == null ? null : concernId.trim();
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

    public String getInforNo() {
        return inforNo;
    }

    public void setInforNo(String inforNo) {
        this.inforNo = inforNo == null ? null : inforNo.trim();
    }

    public String getConcernType() {
        return concernType;
    }

    public void setConcernType(String concernType) {
        this.concernType = concernType == null ? null : concernType.trim();
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
}