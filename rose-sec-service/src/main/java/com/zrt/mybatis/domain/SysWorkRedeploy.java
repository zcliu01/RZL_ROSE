package com.zrt.mybatis.domain;

public class SysWorkRedeploy {
    private String workRedeployId;

    private String tenantId;

    private String empId;

    private String orgId;

    private String empPositionId;

    private String createDateTime;

    private String endDateTime;

    private String updateDateTime;

    private String redeployContent;

    public String getWorkRedeployId() {
        return workRedeployId;
    }

    public void setWorkRedeployId(String workRedeployId) {
        this.workRedeployId = workRedeployId == null ? null : workRedeployId.trim();
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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getEmpPositionId() {
        return empPositionId;
    }

    public void setEmpPositionId(String empPositionId) {
        this.empPositionId = empPositionId == null ? null : empPositionId.trim();
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime == null ? null : createDateTime.trim();
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime == null ? null : endDateTime.trim();
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime == null ? null : updateDateTime.trim();
    }

    public String getRedeployContent() {
        return redeployContent;
    }

    public void setRedeployContent(String redeployContent) {
        this.redeployContent = redeployContent == null ? null : redeployContent.trim();
    }
}