package com.shianlife.shian_platform.mvp.ordercenter.bean;



/**
 * Created by zm
 */
public class PerformRecordDetails extends PerformRecord {
    private String performerName;
    private String performerPhone;

    public String getPerformerName() {
        return performerName;
    }

    public void setPerformerName(String performerName) {
        this.performerName = performerName;
    }

    public String getPerformerPhone() {
        return performerPhone;
    }

    public void setPerformerPhone(String performerPhone) {
        this.performerPhone = performerPhone;
    }
}
