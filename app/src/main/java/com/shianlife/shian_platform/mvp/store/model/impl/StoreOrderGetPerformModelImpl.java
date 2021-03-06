package com.shianlife.shian_platform.mvp.store.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderGetPerformBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderGetPerformResultBean;
import com.shianlife.shian_platform.mvp.store.model.IStoreOrderGetPerformModel;

import okhttp3.Request;


/**
 * Created by zm.
 */

public class StoreOrderGetPerformModelImpl implements IStoreOrderGetPerformModel {
    @Override
    public void getPerformInfo(Context context, StoreOrderGetPerformBean params, final OnGetDataListener<StoreOrderGetPerformResultBean> listener) {
        MHttpManagerFactory.getStoreManger().getPerformInfo(context, params, new HttpResponseHandler<StoreOrderGetPerformResultBean>() {


            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(StoreOrderGetPerformResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
