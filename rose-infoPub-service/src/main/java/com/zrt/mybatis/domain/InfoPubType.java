package com.zrt.mybatis.domain;

public class InfoPubType {
    private String infoTypeCode;

    private String infoTypeName;

    private String infoTypeState;

    private String infoTypeCreatedata;
    

    public String getInfoTypeCode() {
        return infoTypeCode;
    }


	public void setInfoTypeCode(String infoTypeCode) {
        this.infoTypeCode = infoTypeCode == null ? null : infoTypeCode.trim();
    }

    public String getInfoTypeName() {
        return infoTypeName;
    }

    public void setInfoTypeName(String infoTypeName) {
        this.infoTypeName = infoTypeName == null ? null : infoTypeName.trim();
    }

    public String getInfoTypeState() {
        return infoTypeState;
    }

    public void setInfoTypeState(String infoTypeState) {
        this.infoTypeState = infoTypeState == null ? null : infoTypeState.trim();
    }

    public String getInfoTypeCreatedata() {
        return infoTypeCreatedata;
    }

    public void setInfoTypeCreatedata(String infoTypeCreatedata) {
        this.infoTypeCreatedata = infoTypeCreatedata == null ? null : infoTypeCreatedata.trim();
    }
}