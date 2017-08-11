package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IFailServiceListModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class FailServiceListModelImpl implements IFailServiceListModel {
    @Override
    public void getFailServiceListData(Context context, FailServiceListBean params, final OnGetDataListener<FailServiceListResultBean> listener) {
        MHttpManagerFactory.getCarManager().getFailServiceList(context, params, new HttpResponseHandler<FailServiceListResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(FailServiceListResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
