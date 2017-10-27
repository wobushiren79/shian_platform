package com.shianlife.shian_platform.mvp.ordercenter.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterSubmitAuditBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterSubmitAuditResultBean;
import com.shianlife.shian_platform.mvp.ordercenter.model.IOrderCenterSubmitAuditModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class OrderCenterSubmitAuditModelImpl implements IOrderCenterSubmitAuditModel {
    @Override
    public void submitAudit(Context context, OrderCenterSubmitAuditBean params, final OnGetDataListener<OrderCenterSubmitAuditResultBean> listener) {
        MHttpManagerFactory.getOrderCenterManager().submitAudit(context, params, new HttpResponseHandler<OrderCenterSubmitAuditResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(OrderCenterSubmitAuditResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
