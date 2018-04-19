package com.zrt.mybatis.domain;

public class InfoPubWithBLOBs extends InfoPub {
    private String infoContent;

    private String infoContentStyle;

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent == null ? null : infoContent.trim();
    }

    public String getInfoContentStyle() {
        return infoContentStyle;
    }

    public void setInfoContentStyle(String infoContentStyle) {
        this.infoContentStyle = infoContentStyle == null ? null : infoContentStyle.trim();
    }
}