package com.shianlife.shian_platform.mvp.store.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderGetPerformBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderGetPerformResultBean;


/**
 * Created by zm.
 */

public interface IStoreOrderGetPerformModel {
    void getPerformInfo(Context context, StoreOrderGetPerformBean params, OnGetDataListener<StoreOrderGetPerformResultBean> listener);
}
