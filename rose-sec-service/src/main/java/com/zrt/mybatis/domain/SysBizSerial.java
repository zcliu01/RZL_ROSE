package com.zrt.mybatis.domain;

public class SysBizSerial {
    private String bizKey;

    private String bizName;

    private Integer bizSerialNo;

    private String bizPrefix;

    private String bizDate;

    private String isAppend;

    private Integer serialNum;

    private String bizRemark;

    public String getBizKey() {
        return bizKey;
    }

    public void setBizKey(String bizKey) {
        this.bizKey = bizKey == null ? null : bizKey.trim();
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName == null ? null : bizName.trim();
    }

    public Integer getBizSerialNo() {
        return bizSerialNo;
    }

    public void setBizSerialNo(Integer bizSerialNo) {
        this.bizSerialNo = bizSerialNo;
    }

    public String getBizPrefix() {
        return bizPrefix;
    }

    public void setBizPrefix(String bizPrefix) {
        this.bizPrefix = bizPrefix == null ? null : bizPrefix.trim();
    }

    public String getBizDate() {
        return bizDate;
    }

    public void setBizDate(String bizDate) {
        this.bizDate = bizDate == null ? null : bizDate.trim();
    }

    public String getIsAppend() {
        return isAppend;
    }

    public void setIsAppend(String isAppend) {
        this.isAppend = isAppend == null ? null : isAppend.trim();
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public String getBizRemark() {
        return bizRemark;
    }

    public void setBizRemark(String bizRemark) {
        this.bizRemark = bizRemark == null ? null : bizRemark.trim();
    }
}