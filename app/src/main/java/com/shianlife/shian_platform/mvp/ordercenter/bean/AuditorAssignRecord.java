package com.shianlife.shian_platform.mvp.ordercenter.bean;

import com.shianlife.shian_platform.base.BaseEntity;

public class AuditorAssignRecord extends BaseEntity {

    /**
     * 工单id
     */
    private Long orderId;

    /**
     * 审核人员id
     */
    private Long auditorId;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }
}
