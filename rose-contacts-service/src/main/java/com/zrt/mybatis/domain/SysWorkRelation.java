package com.zrt.mybatis.domain;

public class SysWorkRelation {
    private String eWId;

    private String orgId;

    private String empId;

    private String manageEmpId;

    private String manageEmpName;

    private String chargeEmpId;

    private String chargeEmpName;

    private String tenantId;

    private String createDateTime;

    private String updateDateTime;

    public String geteWId() {
        return eWId;
    }

    public void seteWId(String eWId) {
        this.eWId = eWId == null ? null : eWId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public String getManageEmpId() {
        return manageEmpId;
    }

    public void setManageEmpId(String manageEmpId) {
        this.manageEmpId = manageEmpId == null ? null : manageEmpId.trim();
    }

    public String getManageEmpName() {
        return manageEmpName;
    }

    public void setManageEmpName(String manageEmpName) {
        this.manageEmpName = manageEmpName == null ? null : manageEmpName.trim();
    }

    public String getChargeEmpId() {
        return chargeEmpId;
    }

    public void setChargeEmpId(String chargeEmpId) {
        this.chargeEmpId = chargeEmpId == null ? null : chargeEmpId.trim();
    }

    public String getChargeEmpName() {
        return chargeEmpName;
    }

    public void setChargeEmpName(String chargeEmpName) {
        this.chargeEmpName = chargeEmpName == null ? null : chargeEmpName.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
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