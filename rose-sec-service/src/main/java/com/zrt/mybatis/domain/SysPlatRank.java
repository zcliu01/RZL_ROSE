package com.zrt.mybatis.domain;

import java.math.BigDecimal;

public class SysPlatRank {
    private String rId;

    private String rName;

    private BigDecimal rWeight;

    private String rStatus;

    private String createDateTime;

    private String updateDateTime;

    private String rDesc;

    private String tenantId;

    private Integer rOrder;

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public BigDecimal getrWeight() {
        return rWeight;
    }

    public void setrWeight(BigDecimal rWeight) {
        this.rWeight = rWeight;
    }

    public String getrStatus() {
        return rStatus;
    }

    public void setrStatus(String rStatus) {
        this.rStatus = rStatus == null ? null : rStatus.trim();
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

    public String getrDesc() {
        return rDesc;
    }

    public void setrDesc(String rDesc) {
        this.rDesc = rDesc == null ? null : rDesc.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public Integer getrOrder() {
        return rOrder;
    }

    public void setrOrder(Integer rOrder) {
        this.rOrder = rOrder;
    }
}