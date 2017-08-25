package com.shianlife.shian_platform.mvp.order.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderDetailsBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderDetailsResultBean;
import com.shianlife.shian_platform.mvp.order.model.IStoreOrderDetailsModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class StoreOrderDetailsModelImpl implements IStoreOrderDetailsModel {

    @Override
    public void getStoreOrderDetails(Context context, StoreOrderDetailsBean params, final OnGetDataListener<StoreOrderDetailsResultBean> listener) {
        MHttpManagerFactory.getStoreManger().getStoreOrderDetails(context, params, new HttpResponseHandler<StoreOrderDetailsResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(StoreOrderDetailsResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
