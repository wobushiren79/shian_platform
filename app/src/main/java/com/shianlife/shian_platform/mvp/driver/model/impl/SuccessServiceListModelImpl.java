package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.driver.bean.SuccessServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.SuccessServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.model.ISuccessServiceListModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class SuccessServiceListModelImpl implements ISuccessServiceListModel {


    @Override
    public void getSuccessServiceListData(Context context, SuccessServiceListBean params, final OnGetDataListener<SuccessServiceListResultBean> listener) {
        MHttpManagerFactory.getCarManager().getSuccessServiceList(context, params, new HttpResponseHandler<SuccessServiceListResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(SuccessServiceListResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
