package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.driver.bean.OrderDetailsBean;
import com.shianlife.shian_platform.mvp.driver.bean.OrderDetailsResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IOrderDetailsModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class OrderDetailsModelImpl implements IOrderDetailsModel {
    @Override
    public void getOrderDetails(Context context, OrderDetailsBean params, final OnGetDataListener<OrderDetailsResultBean> listener) {
        MHttpManagerFactory.getAccountManager().getDriverOrderDetails(context, params, new HttpResponseHandler<OrderDetailsResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(OrderDetailsResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });

    }
}
