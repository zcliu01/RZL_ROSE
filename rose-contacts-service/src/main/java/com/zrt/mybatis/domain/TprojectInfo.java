package com.zrt.mybatis.domain;

public class TprojectInfo {
    private String cProjectcode;

    private String cProjectname;

    private String cFundcode;

    public String getcProjectcode() {
        return cProjectcode;
    }

    public void setcProjectcode(String cProjectcode) {
        this.cProjectcode = cProjectcode == null ? null : cProjectcode.trim();
    }

    public String getcProjectname() {
        return cProjectname;
    }

    public void setcProjectname(String cProjectname) {
        this.cProjectname = cProjectname == null ? null : cProjectname.trim();
    }

    public String getcFundcode() {
        return cFundcode;
    }

    public void setcFundcode(String cFundcode) {
        this.cFundcode = cFundcode == null ? null : cFundcode.trim();
    }
}