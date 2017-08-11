package com.shianlife.shian_platform.mvp.order.bean;


import com.shianlife.shian_platform.http.base.BaseHttpParams;

/**
 * Created by zm.
 */

public class StoreOrderGetPerformBean extends BaseHttpParams {
    private Long performId;//执行单id

    public Long getPerformId() {
        return performId;
    }

    public void setPerformId(Long performId) {
        this.performId = performId;
    }
}
