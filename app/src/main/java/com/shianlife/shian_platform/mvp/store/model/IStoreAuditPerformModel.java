package com.shianlife.shian_platform.mvp.store.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformResultBean;

/**
 * Created by zm.
 */

public interface IStoreAuditPerformModel {
    void getStoreAuditPerformDetails(Context context, StoreAuditPerformBean params, OnGetDataListener<StoreAuditPerformResultBean> listener);
}
