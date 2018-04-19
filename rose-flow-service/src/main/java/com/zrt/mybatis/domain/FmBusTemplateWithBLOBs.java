package com.zrt.mybatis.domain;

public class FmBusTemplateWithBLOBs extends FmBusTemplate {
    private String tTemplate;

    private String tHtml;

    public String gettTemplate() {
        return tTemplate;
    }

    public void settTemplate(String tTemplate) {
        this.tTemplate = tTemplate == null ? null : tTemplate.trim();
    }

    public String gettHtml() {
        return tHtml;
    }

    public void settHtml(String tHtml) {
        this.tHtml = tHtml == null ? null : tHtml.trim();
    }
}