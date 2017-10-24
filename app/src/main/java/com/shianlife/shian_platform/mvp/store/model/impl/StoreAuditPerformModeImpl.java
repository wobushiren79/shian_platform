package com.shianlife.shian_platform.mvp.store.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformResultBean;
import com.shianlife.shian_platform.mvp.store.model.IStoreAuditPerformModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class StoreAuditPerformModeImpl implements IStoreAuditPerformModel {
    @Override
    public void getStoreAuditPerformDetails(Context context, StoreAuditPerformBean params, final OnGetDataListener<StoreAuditPerformResultBean> listener) {
        MHttpManagerFactory.getStoreManger().getStoreAuditPerformDetails(context, params, new HttpResponseHandler<StoreAuditPerformResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(StoreAuditPerformResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
