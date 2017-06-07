package com.shianlife.shian_platform.mvp.driver.model;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.TakePersonBean;
import com.shianlife.shian_platform.mvp.driver.bean.TakePersonResultBean;

/**
 * Created by zm.
 */

public interface ITakePersonModel {
    /**
     * 接人
     * @param context
     * @param params
     * @param listener
     */
    void takePerson(Context context, TakePersonBean params, OnGetDataListener<TakePersonResultBean> listener);
}
