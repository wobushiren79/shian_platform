package com.shianlife.shian_platform.mvp.order.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderGetPerformBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderGetPerformResultBean;


/**
 * Created by zm.
 */

public interface IStoreOrderGetPerformModel {
    void getPerformInfo(Context context, StoreOrderGetPerformBean params, OnGetDataListener<StoreOrderGetPerformResultBean> listener);
}
