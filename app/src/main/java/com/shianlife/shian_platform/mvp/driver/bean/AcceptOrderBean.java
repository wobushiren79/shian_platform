package com.shianlife.shian_platform.mvp.driver.bean;

import com.shianlife.shian_platform.http.base.BaseHttpParams;

/**
 * Created by zm.
 */

public class AcceptOrderBean extends BaseHttpParams {
    private long orderId;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
