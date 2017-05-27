package com.shianlife.shian_platform.mvp.ideaback.view;

import android.content.Context;

import com.shianlife.shian_platform.http.base.BaseDataResult;

/**
 * Created by zm.
 */

public interface IIdeaFeedBackView {
    Context getContent();

    void showData(BaseDataResult result);

    void showMsg(String msg);

    /**
     * 获取编辑信息
     *
     * @return
     */
    String getEdContent();

    /**
     * 获取使用者姓名
     *
     * @return
     */
    String getUserName();

    /**
     * 获取使用者手机号码
     *
     * @return
     */
    String getUserPhone();
}
