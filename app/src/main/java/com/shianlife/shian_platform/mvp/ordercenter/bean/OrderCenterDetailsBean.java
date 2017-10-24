package com.shianlife.shian_platform.mvp.ordercenter.bean;

import com.shianlife.shian_platform.http.base.BaseHttpParams;

/**
 * Created by zm.
 */

public class OrderCenterDetailsBean extends BaseHttpParams {
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
