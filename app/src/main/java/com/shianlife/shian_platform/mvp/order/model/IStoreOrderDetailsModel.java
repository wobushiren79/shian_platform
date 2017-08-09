package com.shianlife.shian_platform.mvp.order.model;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderDetailsBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderDetailsResultBean;

/**
 * Created by zm.
 */

public interface IStoreOrderDetailsModel {

    void getStoreOrderDetails(Context context, StoreOrderDetailsBean params, OnGetDataListener<StoreOrderDetailsResultBean> listener);
}
