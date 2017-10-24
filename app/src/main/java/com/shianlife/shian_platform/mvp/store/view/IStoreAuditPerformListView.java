package com.shianlife.shian_platform.mvp.store.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformListResultBean;

/**
 * Created by zm.
 */

public interface IStoreAuditPerformListView {

    Context getContext();

    void getAuditPerformListSuccess(StoreAuditPerformListResultBean resultBean);

    void getAuditPerformListFail(String msg);


    Long getOrderId();

    void showToast(String msg);
}
