package com.shianlife.shian_platform.mvp.driver.model;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.GetOnCarBean;
import com.shianlife.shian_platform.mvp.driver.bean.GetOnCarResultBean;

/**
 * Created by zm.
 */

public interface IGetOnCarModel {
    /**
     * 上車
     * @param context
     * @param params
     * @param listener
     */
    void getOnCar(Context context, GetOnCarBean params, OnGetDataListener<GetOnCarResultBean> listener);
}
