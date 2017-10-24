package com.shianlife.shian_platform.mvp.ordercenter.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterDetailsBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterDetailsResultBean;
import com.shianlife.shian_platform.mvp.ordercenter.model.IOrderCenterDetailsModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class OrderCenterDetailsModelImpl implements IOrderCenterDetailsModel {
    @Override
    public void getOrderCenterDetails(Context context, OrderCenterDetailsBean params, final OnGetDataListener<OrderCenterDetailsResultBean> listener) {
        MHttpManagerFactory.getOrderCenterManager().getOrderDetails(context, params, new HttpResponseHandler<OrderCenterDetailsResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(OrderCenterDetailsResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
