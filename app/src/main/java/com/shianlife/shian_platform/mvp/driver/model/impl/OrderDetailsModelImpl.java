package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.OrderDetailsBean;
import com.shianlife.shian_platform.mvp.driver.bean.OrderDetailsResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IOrderDetailsModel;

/**
 * Created by zm.
 */

public class OrderDetailsModelImpl implements IOrderDetailsModel {
    @Override
    public void getOrderDetails(Context context, OrderDetailsBean params, OnGetDataListener<OrderDetailsResultBean> listener) {
        listener.getDataSuccess(null);
    }
}
