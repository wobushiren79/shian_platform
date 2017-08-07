package com.shianlife.shian_platform.mvp.order.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.order.bean.StoreOrderAuditResultListBean;

import java.util.List;

/**
 * Created by zm.
 */

public interface IStoreOrderAuditListView {
    Context getContext();

    void getStoreOrderAuditListSuccess(StoreOrderAuditResultListBean resultBean);

    void getStoreOrderAuditListFail(String msg);

    Integer getPagerSize();

    Integer getPagerNumber();

    List<Integer> getOrderStatus();

    Integer getPerformStatus();
}
