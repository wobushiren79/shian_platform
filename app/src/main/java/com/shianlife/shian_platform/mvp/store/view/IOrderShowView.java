package com.shianlife.shian_platform.mvp.store.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.store.bean.OrderShowResultBean;

/**
 * Created by zm.
 */

public interface IOrderShowView {
    Context getContext();

    void showOrderItems(OrderShowResultBean resultBean);
}
