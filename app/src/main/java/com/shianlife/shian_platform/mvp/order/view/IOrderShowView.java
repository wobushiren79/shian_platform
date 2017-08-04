package com.shianlife.shian_platform.mvp.order.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.order.bean.OrderShowResultBean;

/**
 * Created by zm.
 */

public interface IOrderShowView {
    Context getContext();

    void showOrderItems(OrderShowResultBean resultBean);
}
