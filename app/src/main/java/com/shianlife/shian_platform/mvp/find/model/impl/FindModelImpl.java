package com.shianlife.shian_platform.mvp.find.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.find.bean.FindBean;
import com.shianlife.shian_platform.mvp.find.bean.FindResultBean;
import com.shianlife.shian_platform.mvp.find.model.IFindModel;
import com.shianlife.shian_platform.mvp.find.presenter.OnFindListener;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class FindModelImpl implements IFindModel {

    @Override
    public void getFindData(Context context, FindBean params, final OnFindListener listener) {
        MHttpManagerFactory.getPHPManager().getSiftListData(context, params, new HttpResponseHandler<FindResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(FindResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
