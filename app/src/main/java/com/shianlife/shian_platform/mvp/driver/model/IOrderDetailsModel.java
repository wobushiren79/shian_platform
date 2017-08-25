package com.shianlife.shian_platform.mvp.driver.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.OrderDetailsBean;
import com.shianlife.shian_platform.mvp.driver.bean.OrderDetailsResultBean;

/**
 * Created by zm.
 */

public interface IOrderDetailsModel {
    /**
     * 获取司机订单详情
     * @param context
     * @param params
     * @param listener
     */
    void getOrderDetails(Context context, OrderDetailsBean params, OnGetDataListener<OrderDetailsResultBean> listener);
}
