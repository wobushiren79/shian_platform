package com.shianlife.shian_platform.mvp.main.view;

import android.content.Context;

import com.shianlife.shian_platform.http.base.BaseDataResult;

/**
 * Created by zm.
 */

public interface IAppUpDateView {
    /**
     * 获取上下文对象
     *
     * @return
     */
    Context getContext();

    void getAppUpDateInfoSuccess(BaseDataResult result);

    void getAppUpDateInfoFail(String msg);
}
