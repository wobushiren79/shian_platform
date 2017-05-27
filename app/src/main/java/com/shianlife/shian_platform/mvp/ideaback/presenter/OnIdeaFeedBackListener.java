package com.shianlife.shian_platform.mvp.ideaback.presenter;

import com.shianlife.shian_platform.http.base.BaseDataResult;

/**
 * Created by zm.
 */

public interface OnIdeaFeedBackListener {

    /**
     * 保存意見反饋成功
     *
     * @param result
     */
    void saveIdeaFeedBackSuccess(BaseDataResult result);

    /**
     * 保存意见反馈失败
     *
     * @param msg
     */
    void saveIdeaFeedBackFail(String msg);
}
