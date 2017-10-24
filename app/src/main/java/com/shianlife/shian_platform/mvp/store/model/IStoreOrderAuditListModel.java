package com.shianlife.shian_platform.mvp.store.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderAuditListBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderAuditResultListBean;

/**
 * Created by zm.
 */

public interface IStoreOrderAuditListModel {
    void getStoreOrderAuditListData(Context context, StoreOrderAuditListBean params, OnGetDataListener<StoreOrderAuditResultListBean> listener);
}
