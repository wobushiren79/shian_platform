package com.shianlife.shian_platform.mvp.ordercenter.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterSubmitAuditBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterSubmitAuditResultBean;

/**
 * Created by zm.
 */

public interface IOrderCenterSubmitAuditModel {
    void submitAudit(Context context, OrderCenterSubmitAuditBean params, OnGetDataListener<OrderCenterSubmitAuditResultBean> listener);
}
