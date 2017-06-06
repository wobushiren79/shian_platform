package com.shianlife.shian_platform.mvp.driver.model;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.TakeCarBean;
import com.shianlife.shian_platform.mvp.driver.bean.TakeCarResultBean;

/**
 * Created by zm.
 */

public interface ITakeCarModel {
    /**
     * 保存取車數據
     */
    void saveTakeCarData(Context context, TakeCarBean params, OnGetDataListener<TakeCarResultBean> listener);
}
