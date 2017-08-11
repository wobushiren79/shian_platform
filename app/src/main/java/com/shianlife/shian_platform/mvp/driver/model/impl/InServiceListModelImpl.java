package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IInServiceListModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class InServiceListModelImpl implements IInServiceListModel {
    @Override
    public void getInServiceListData(Context context, InServiceListBean params, final OnGetDataListener<InServiceListResultBean> listener) {
        MHttpManagerFactory.getCarManager().getInServiceList(context, params, new HttpResponseHandler<InServiceListResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(InServiceListResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });

    }
}
