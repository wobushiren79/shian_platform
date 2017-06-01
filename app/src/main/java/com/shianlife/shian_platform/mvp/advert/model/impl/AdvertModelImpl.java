package com.shianlife.shian_platform.mvp.advert.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.advert.bean.AdvertBean;
import com.shianlife.shian_platform.mvp.advert.bean.AdvertResultBean;
import com.shianlife.shian_platform.mvp.advert.model.IAdvertModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class AdvertModelImpl implements IAdvertModel {

    @Override
    public void getAdvertData(Context context, AdvertBean params, final OnGetDataListener listener) {
        MHttpManagerFactory.getPHPManager().getAdvertisement(context, params, new HttpResponseHandler<AdvertResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(AdvertResultBean result) {
                listener.getDataSuccess(result);
            }


            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
