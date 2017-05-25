package com.shianlife.shian_platform.mvp.find.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.find.bean.FindBean;
import com.shianlife.shian_platform.mvp.find.presenter.OnFindListener;

/**
 * Created by zm.
 */

public interface IFindModel {
    /**
     * 获取发现数据
     *
     * @param params
     * @param listener
     */
    void getFindData(Context context, FindBean params, OnFindListener listener);
}
