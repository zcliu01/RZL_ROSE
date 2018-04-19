package com.zrt.mybatis.domain;

public class FbBusAddSign {
    private String id;

    private String instId;

    private String checkId;

    private String addEmpId;

    private String addEmpName;

    private String createDateTime;

    private String updateDateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId == null ? null : instId.trim();
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId == null ? null : checkId.trim();
    }

    public String getAddEmpId() {
        return addEmpId;
    }

    public void setAddEmpId(String addEmpId) {
        this.addEmpId = addEmpId == null ? null : addEmpId.trim();
    }

    public String getAddEmpName() {
        return addEmpName;
    }

    public void setAddEmpName(String addEmpName) {
        this.addEmpName = addEmpName == null ? null : addEmpName.trim();
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