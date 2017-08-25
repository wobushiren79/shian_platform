package com.shianlife.shian_platform.mvp.ideaback.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.ideaback.bean.IdeaFeedBackBean;
import com.shianlife.shian_platform.mvp.ideaback.model.IIdeaFeedBackModel;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class IdeaFeedBackModelImpl implements IIdeaFeedBackModel {
    /**
     * 保存意见反馈
     *
     * @param context
     * @param params
     * @param listener
     */
    @Override
    public void saveIdeaFeedBackData(Context context, IdeaFeedBackBean params, final OnGetDataListener listener) {
        MHttpManagerFactory.getPHPManager().setOpinion(context, params, new HttpResponseHandler<Object>() {

            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(Object result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataSuccess(message);
            }
        }, true);
    }
}
