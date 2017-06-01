package com.shianlife.shian_platform.mvp.main.view;

import android.content.Context;

import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.main.bean.AppUpDateResultBean;

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

    void getAppUpDateInfoSuccess(AppUpDateResultBean result);

    void getAppUpDateInfoFail(String msg);
}
