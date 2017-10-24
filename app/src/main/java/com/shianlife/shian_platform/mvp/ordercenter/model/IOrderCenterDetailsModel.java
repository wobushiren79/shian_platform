package com.shianlife.shian_platform.mvp.ordercenter.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterDetailsBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterDetailsResultBean;

/**
 * Created by zm.
 */

public interface IOrderCenterDetailsModel {
    void getOrderCenterDetails(Context context, OrderCenterDetailsBean params, OnGetDataListener<OrderCenterDetailsResultBean> listener);
}
