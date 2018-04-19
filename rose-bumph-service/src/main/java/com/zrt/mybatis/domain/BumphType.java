package com.zrt.mybatis.domain;

public class BumphType {
    private String bumphTypeCode;

    private String bumphTypeName;

    private String bumphTypeState;

    private String bumphTypeCreatedata;

    public String getBumphTypeCode() {
        return bumphTypeCode;
    }

    public void setBumphTypeCode(String bumphTypeCode) {
        this.bumphTypeCode = bumphTypeCode == null ? null : bumphTypeCode.trim();
    }

    public String getBumphTypeName() {
        return bumphTypeName;
    }

    public void setBumphTypeName(String bumphTypeName) {
        this.bumphTypeName = bumphTypeName == null ? null : bumphTypeName.trim();
    }

    public String getBumphTypeState() {
        return bumphTypeState;
    }

    public void setBumphTypeState(String bumphTypeState) {
        this.bumphTypeState = bumphTypeState == null ? null : bumphTypeState.trim();
    }

    public String getBumphTypeCreatedata() {
        return bumphTypeCreatedata;
    }

    public void setBumphTypeCreatedata(String bumphTypeCreatedata) {
        this.bumphTypeCreatedata = bumphTypeCreatedata == null ? null : bumphTypeCreatedata.trim();
    }
}