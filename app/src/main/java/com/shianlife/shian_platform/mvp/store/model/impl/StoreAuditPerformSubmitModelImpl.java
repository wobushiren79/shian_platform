package com.shianlife.shian_platform.mvp.store.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformSubmitBean;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformSubmitResultBean;
import com.shianlife.shian_platform.mvp.store.model.IStoreAuditPerformSubmitModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class StoreAuditPerformSubmitModelImpl implements IStoreAuditPerformSubmitModel {
    @Override
    public void submitAuditPerform(Context context, StoreAuditPerformSubmitBean params, final OnGetDataListener<StoreAuditPerformSubmitResultBean> listener) {
        MHttpManagerFactory.getStoreManger().submitAuditPerform(context, params, new HttpResponseHandler<StoreAuditPerformSubmitResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(StoreAuditPerformSubmitResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
