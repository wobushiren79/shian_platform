package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IWaitServiceListModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class WaitServiceListModelImpl implements IWaitServiceListModel {

    @Override
    public void getWaitServiceListData(Context context, WaitServiceListBean params, final OnGetDataListener<WaitServiceListResultBean> listener) {
        MHttpManagerFactory.getCarManager().getWaitServiceList(context, params, new HttpResponseHandler<WaitServiceListResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(WaitServiceListResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });

    }
}
