package com.shianlife.shian_platform.mvp.store.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderDetailsBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderDetailsResultBean;

/**
 * Created by zm.
 */

public interface IStoreOrderDetailsModel {

    void getStoreOrderDetails(Context context, StoreOrderDetailsBean params, OnGetDataListener<StoreOrderDetailsResultBean> listener);
}
