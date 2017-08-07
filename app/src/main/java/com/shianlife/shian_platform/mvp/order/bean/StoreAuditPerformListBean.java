package com.shianlife.shian_platform.mvp.order.bean;

import com.shianlife.shian_platform.http.base.BaseHttpParams;

/**
 * Created by zm.
 */

public class StoreAuditPerformListBean extends BaseHttpParams {
    /**
     * 订单id
     */
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
