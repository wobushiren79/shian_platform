package com.shianlife.shian_platform.mvp.ordercenter.bean;

/**
 * Created by zm.
 */

public class OrderCenterRecord {
    private PerformRecordDetails performRecordDetails;
    private AuditRecordDetails auditRecordDetails;

    public PerformRecordDetails getPerformRecordDetails() {
        return performRecordDetails;
    }

    public void setPerformRecordDetails(PerformRecordDetails performRecordDetails) {
        this.performRecordDetails = performRecordDetails;
    }

    public AuditRecordDetails getAuditRecordDetails() {
        return auditRecordDetails;
    }

    public void setAuditRecordDetails(AuditRecordDetails auditRecordDetails) {
        this.auditRecordDetails = auditRecordDetails;
    }
}
