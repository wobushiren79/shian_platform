package com.shianlife.shian_platform.mvp.main.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.main.bean.AppUpDateBean;
import com.shianlife.shian_platform.mvp.main.presenter.OnAppUpDateListener;

/**
 * Created by zm.
 */

public interface IAppUpDateModel {
    /**
     * 获取APP更新信息
     *
     * @param context
     * @param params
     * @param listener
     */
    void getAppUpDateInfo(Context context, AppUpDateBean params, OnAppUpDateListener listener);
}
