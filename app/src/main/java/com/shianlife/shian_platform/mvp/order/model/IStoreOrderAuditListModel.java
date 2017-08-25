package com.shianlife.shian_platform.mvp.order.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderAuditListBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderAuditResultListBean;

/**
 * Created by zm.
 */

public interface IStoreOrderAuditListModel {
    void getStoreOrderAuditListData(Context context, StoreOrderAuditListBean params, OnGetDataListener<StoreOrderAuditResultListBean> listener);
}
