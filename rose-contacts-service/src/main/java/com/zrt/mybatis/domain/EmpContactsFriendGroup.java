package com.zrt.mybatis.domain;

public class EmpContactsFriendGroup {
    private String friendGroupId;

    private String tenantId;

    private String friendGroupName;

    private String friendGroupType;

    private String memberQuantity;

    private String friendGroupStatus;

    private String createEmpId;

    private String createDateTime;

    private String updateDateTime;

    private String friendGroupHeadPhoto;

    private String friendGroupDesc;

    private String visibleEmps;

    public String getFriendGroupId() {
        return friendGroupId;
    }

    public void setFriendGroupId(String friendGroupId) {
        this.friendGroupId = friendGroupId == null ? null : friendGroupId.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getFriendGroupName() {
        return friendGroupName;
    }

    public void setFriendGroupName(String friendGroupName) {
        this.friendGroupName = friendGroupName == null ? null : friendGroupName.trim();
    }

    public String getFriendGroupType() {
        return friendGroupType;
    }

    public void setFriendGroupType(String friendGroupType) {
        this.friendGroupType = friendGroupType == null ? null : friendGroupType.trim();
    }

    public String getMemberQuantity() {
        return memberQuantity;
    }

    public void setMemberQuantity(String memberQuantity) {
        this.memberQuantity = memberQuantity == null ? null : memberQuantity.trim();
    }

    public String getFriendGroupStatus() {
        return friendGroupStatus;
    }

    public void setFriendGroupStatus(String friendGroupStatus) {
        this.friendGroupStatus = friendGroupStatus == null ? null : friendGroupStatus.trim();
    }

    public String getCreateEmpId() {
        return createEmpId;
    }

    public void setCreateEmpId(String createEmpId) {
        this.createEmpId = createEmpId == null ? null : createEmpId.trim();
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

    public String getFriendGroupHeadPhoto() {
        return friendGroupHeadPhoto;
    }

    public void setFriendGroupHeadPhoto(String friendGroupHeadPhoto) {
        this.friendGroupHeadPhoto = friendGroupHeadPhoto == null ? null : friendGroupHeadPhoto.trim();
    }

    public String getFriendGroupDesc() {
        return friendGroupDesc;
    }

    public void setFriendGroupDesc(String friendGroupDesc) {
        this.friendGroupDesc = friendGroupDesc == null ? null : friendGroupDesc.trim();
    }

    public String getVisibleEmps() {
        return visibleEmps;
    }

    public void setVisibleEmps(String visibleEmps) {
        this.visibleEmps = visibleEmps == null ? null : visibleEmps.trim();
    }
}