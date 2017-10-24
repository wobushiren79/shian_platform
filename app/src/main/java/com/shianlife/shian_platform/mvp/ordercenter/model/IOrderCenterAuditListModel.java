package com.shianlife.shian_platform.mvp.ordercenter.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterAuditListBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterAuditListResultBean;

/**
 * Created by zm.
 */

public interface IOrderCenterAuditListModel {
    void getAuditListData(Context context, OrderCenterAuditListBean params, OnGetDataListener<OrderCenterAuditListResultBean> listener);
}
