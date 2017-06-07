package com.shianlife.shian_platform.mvp.driver.model;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.ReturnCarBean;
import com.shianlife.shian_platform.mvp.driver.bean.ReturnCarResultBean;

/**
 * Created by zm.
 */

public interface IReturnCarModel {
    /**
     * 归还车辆
     * @param context
     * @param params
     * @param listener
     */
    void returnCar(Context context, ReturnCarBean params, OnGetDataListener<ReturnCarResultBean> listener);
}
