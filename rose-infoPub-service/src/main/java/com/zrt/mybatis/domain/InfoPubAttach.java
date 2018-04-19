package com.zrt.mybatis.domain;

public class InfoPubAttach {
    private String infoAttackId;

    private String infoId;

    private String attachId;

    private String attachType;

    private String remark;

    private String tenantId;

    private String createDateTime;

    private String updateDateTime;

    private String attachName;

    private String infopubAttachUrl;

    private String nodeId;

    public String getInfoAttackId() {
        return infoAttackId;
    }

    public void setInfoAttackId(String infoAttackId) {
        this.infoAttackId = infoAttackId == null ? null : infoAttackId.trim();
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId == null ? null : infoId.trim();
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId == null ? null : attachId.trim();
    }

    public String getAttachType() {
        return attachType;
    }

    public void setAttachType(String attachType) {
        this.attachType = attachType == null ? null : attachType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName == null ? null : attachName.trim();
    }

    public String getInfopubAttachUrl() {
        return infopubAttachUrl;
    }

    public void setInfopubAttachUrl(String infopubAttachUrl) {
        this.infopubAttachUrl = infopubAttachUrl == null ? null : infopubAttachUrl.trim();
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }
}