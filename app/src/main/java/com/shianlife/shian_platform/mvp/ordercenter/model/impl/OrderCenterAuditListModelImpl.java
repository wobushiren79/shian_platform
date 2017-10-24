package com.shianlife.shian_platform.mvp.ordercenter.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterAuditListBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterAuditListResultBean;
import com.shianlife.shian_platform.mvp.ordercenter.model.IOrderCenterAuditListModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class OrderCenterAuditListModelImpl implements IOrderCenterAuditListModel {
    @Override
    public void getAuditListData(Context context, OrderCenterAuditListBean params, final OnGetDataListener<OrderCenterAuditListResultBean> listener) {
        MHttpManagerFactory.getOrderCenterManager().getAuditListData(context, params, new HttpResponseHandler<OrderCenterAuditListResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(OrderCenterAuditListResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
