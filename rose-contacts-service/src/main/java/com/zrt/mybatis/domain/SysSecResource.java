package com.zrt.mybatis.domain;

public class SysSecResource {
    private String resourceId;

    private String menuCode;

    private String resourceName;

    private String resourceType;

    private String resourceUrl;

    private String resourceGroup;

    private Integer secOrder;

    private String secEnabled;

    private String secSysFlag;

    private String secReadonlyFlag;

    private String secDeleteFlag;

    private Integer version;

    private String createDateTime;

    private String updateDateTime;

    private String hasResourceType;

    private String tenantId;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    public String getResourceGroup() {
        return resourceGroup;
    }

    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup == null ? null : resourceGroup.trim();
    }

    public Integer getSecOrder() {
        return secOrder;
    }

    public void setSecOrder(Integer secOrder) {
        this.secOrder = secOrder;
    }

    public String getSecEnabled() {
        return secEnabled;
    }

    public void setSecEnabled(String secEnabled) {
        this.secEnabled = secEnabled == null ? null : secEnabled.trim();
    }

    public String getSecSysFlag() {
        return secSysFlag;
    }

    public void setSecSysFlag(String secSysFlag) {
        this.secSysFlag = secSysFlag == null ? null : secSysFlag.trim();
    }

    public String getSecReadonlyFlag() {
        return secReadonlyFlag;
    }

    public void setSecReadonlyFlag(String secReadonlyFlag) {
        this.secReadonlyFlag = secReadonlyFlag == null ? null : secReadonlyFlag.trim();
    }

    public String getSecDeleteFlag() {
        return secDeleteFlag;
    }

    public void setSecDeleteFlag(String secDeleteFlag) {
        this.secDeleteFlag = secDeleteFlag == null ? null : secDeleteFlag.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public String getHasResourceType() {
        return hasResourceType;
    }

    public void setHasResourceType(String hasResourceType) {
        this.hasResourceType = hasResourceType == null ? null : hasResourceType.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }
}