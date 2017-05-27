package com.shianlife.shian_platform.mvp.ideaback.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.http.MHttpManagerFactory;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.mvp.ideaback.bean.IdeaFeedBackBean;
import com.shianlife.shian_platform.mvp.ideaback.model.IIdeaFeedBackModel;
import com.shianlife.shian_platform.mvp.ideaback.presenter.OnIdeaFeedBackListener;
import com.shianlife.shian_platform.ui.activity.IdeaFeedbackActivity;

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
    public void saveIdeaFeedBackData(Context context, IdeaFeedBackBean params, final OnIdeaFeedBackListener listener) {
        MHttpManagerFactory.getPHPManager().setOpinion(context, params, new HttpResponseHandler<Object>() {

            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(Object result) {
                listener.saveIdeaFeedBackSuccess(null);
            }

            @Override
            public void onError(String message) {
                listener.saveIdeaFeedBackFail(message);
            }
        }, true);
    }
}
