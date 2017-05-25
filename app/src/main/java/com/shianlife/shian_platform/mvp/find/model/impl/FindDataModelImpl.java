package com.shianlife.shian_platform.mvp.find.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.find.bean.FindDataBean;
import com.shianlife.shian_platform.mvp.find.model.IFindDataModel;
import com.shianlife.shian_platform.mvp.find.presenter.OnFindDataListener;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class FindDataModelImpl implements IFindDataModel {

    @Override
    public void saveData(Context context, FindDataBean params, final OnFindDataListener listener) {
        MHttpManagerFactory.getPHPManager().setSiftData(context, params, new HttpResponseHandler<Object>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(Object result) {
                listener.changeDataSuccess();
            }

            @Override
            public void onError(String message) {
                listener.changeDataFail(message);
            }
        });
    }
}
