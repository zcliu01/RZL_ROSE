package com.zrt.mybatis.domain;

public class SysSecRoleMenu extends SysSecRoleMenuKey {
    private String resourceMode;

    private String tenantId;

    public String getResourceMode() {
        return resourceMode;
    }

    public void setResourceMode(String resourceMode) {
        this.resourceMode = resourceMode == null ? null : resourceMode.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }
}