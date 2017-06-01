package com.shianlife.shian_platform.mvp.ideaback.model;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.ideaback.bean.IdeaFeedBackBean;

/**
 * Created by zm.
 */

public interface IIdeaFeedBackModel {
    /**
     * 保存意见反馈
     * @param context
     * @param params
     * @param listener
     */
    void saveIdeaFeedBackData(Context context, IdeaFeedBackBean params, OnGetDataListener listener);
}
