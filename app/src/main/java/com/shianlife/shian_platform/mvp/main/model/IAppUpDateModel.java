package com.shianlife.shian_platform.mvp.main.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.main.bean.AppUpDateBean;

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
    void getAppUpDateInfo(Context context, AppUpDateBean params, OnGetDataListener listener);
}
