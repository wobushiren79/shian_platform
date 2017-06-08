package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.OrderDetailsResultBean;

/**
 * Created by zm.
 */

public interface IOrderDetailsView {
    Context getContext();

    void getOrderDetailsSuccess(OrderDetailsResultBean result);

    void getOrderDetailsFail(String msg);
}
