package com.zrt.mybatis.domain;

public class FbBusTemplate {
    private String id;

    private String tCode;

    private String tName;

    private String tDesc;

    private String proDateTime;

    private String tEnabled;

    private String fBTId;

    private String parentId;

    private Integer version;

    private String tenantId;

    private String createDateTime;

    private String updateDateTime;

    private String createEmpId;

    private String createEmpName;

    private String updateEmpId;

    private String updateEmpName;

    private String deploymentId;

    private String modelId;

    private String projectFlag;

    private String handleFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String gettCode() {
        return tCode;
    }

    public void settCode(String tCode) {
        this.tCode = tCode == null ? null : tCode.trim();
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public String gettDesc() {
        return tDesc;
    }

    public void settDesc(String tDesc) {
        this.tDesc = tDesc == null ? null : tDesc.trim();
    }

    public String getProDateTime() {
        return proDateTime;
    }

    public void setProDateTime(String proDateTime) {
        this.proDateTime = proDateTime == null ? null : proDateTime.trim();
    }

    public String gettEnabled() {
        return tEnabled;
    }

    public void settEnabled(String tEnabled) {
        this.tEnabled = tEnabled == null ? null : tEnabled.trim();
    }

    public String getfBTId() {
        return fBTId;
    }

    public void setfBTId(String fBTId) {
        this.fBTId = fBTId == null ? null : fBTId.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public String getCreateEmpId() {
        return createEmpId;
    }

    public void setCreateEmpId(String createEmpId) {
        this.createEmpId = createEmpId == null ? null : createEmpId.trim();
    }

    public String getCreateEmpName() {
        return createEmpName;
    }

    public void setCreateEmpName(String createEmpName) {
        this.createEmpName = createEmpName == null ? null : createEmpName.trim();
    }

    public String getUpdateEmpId() {
        return updateEmpId;
    }

    public void setUpdateEmpId(String updateEmpId) {
        this.updateEmpId = updateEmpId == null ? null : updateEmpId.trim();
    }

    public String getUpdateEmpName() {
        return updateEmpName;
    }

    public void setUpdateEmpName(String updateEmpName) {
        this.updateEmpName = updateEmpName == null ? null : updateEmpName.trim();
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId == null ? null : deploymentId.trim();
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public String getProjectFlag() {
        return projectFlag;
    }

    public void setProjectFlag(String projectFlag) {
        this.projectFlag = projectFlag == null ? null : projectFlag.trim();
    }

    public String getHandleFlag() {
        return handleFlag;
    }

    public void setHandleFlag(String handleFlag) {
        this.handleFlag = handleFlag == null ? null : handleFlag.trim();
    }
}