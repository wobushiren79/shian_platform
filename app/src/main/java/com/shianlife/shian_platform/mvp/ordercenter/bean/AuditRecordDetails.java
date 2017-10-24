package com.shianlife.shian_platform.mvp.ordercenter.bean;


public class AuditRecordDetails extends AuditRecord {
    private String auditorName;
    private String auditorPhone;

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public String getAuditorPhone() {
        return auditorPhone;
    }

    public void setAuditorPhone(String auditorPhone) {
        this.auditorPhone = auditorPhone;
    }
}
