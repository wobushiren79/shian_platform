package com.shianlife.shian_platform.mvp.ordercenter.bean;

import com.shianlife.shian_platform.http.base.BaseHttpParams;

/**
 * Created by zm.
 */

public class OrderCenterSubmitAuditBean extends BaseHttpParams {
    private String auditSummary;//	处理摘要
    private String auditPic;//		审核图片
    private Integer auditStatus;//		审核状态 值:0再次审核 1结束审核
    private Long orderId;//	订单id

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
