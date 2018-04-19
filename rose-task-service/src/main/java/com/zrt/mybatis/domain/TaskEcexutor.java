package com.zrt.mybatis.domain;

public class TaskEcexutor {
    private String taskEmpId;

    private String taskId;

    private String empId;

    private String empName;

    private String backTime;

    private String backRemark;

    private String backPercent;

    private String remark;

    private String tenantId;

    private String createDateTime;

    private String updateDateTime;

    private String isRead;

    private String taskExecutorState;

    public String getTaskEmpId() {
        return taskEmpId;
    }

    public void setTaskEmpId(String taskEmpId) {
        this.taskEmpId = taskEmpId == null ? null : taskEmpId.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getBackTime() {
        return backTime;
    }

    public void setBackTime(String backTime) {
        this.backTime = backTime == null ? null : backTime.trim();
    }

    public String getBackRemark() {
        return backRemark;
    }

    public void setBackRemark(String backRemark) {
        this.backRemark = backRemark == null ? null : backRemark.trim();
    }

    public String getBackPercent() {
        return backPercent;
    }

    public void setBackPercent(String backPercent) {
        this.backPercent = backPercent == null ? null : backPercent.trim();
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

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead == null ? null : isRead.trim();
    }

    public String getTaskExecutorState() {
        return taskExecutorState;
    }

    public void setTaskExecutorState(String taskExecutorState) {
        this.taskExecutorState = taskExecutorState == null ? null : taskExecutorState.trim();
    }
}