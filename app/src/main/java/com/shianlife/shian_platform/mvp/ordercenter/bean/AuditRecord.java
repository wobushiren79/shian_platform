package com.shianlife.shian_platform.mvp.ordercenter.bean;


import com.shianlife.shian_platform.base.BaseEntity;

public class AuditRecord extends BaseEntity {

    /**
     * 处理摘要
     */
    private String  auditSummary;

    /**
     * 审核图片
     */
    private String  auditPic;

    /**
     * 审核人员id
     */
    private Long    auditorId;

    /**
     * 审核状态 值:0再次审核  1结束审核
     */
    private Integer auditStatus;

    /**
     * 订单id
     */
    private Long    orderId;



    public String getAuditSummary() {
        return auditSummary;
    }

    public void setAuditSummary(String auditSummary) {
        this.auditSummary = auditSummary;
    }

    public String getAuditPic() {
        return auditPic;
    }

    public void setAuditPic(String auditPic) {
        this.auditPic = auditPic;
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
