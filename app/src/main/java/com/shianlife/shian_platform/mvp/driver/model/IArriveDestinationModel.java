package com.shianlife.shian_platform.mvp.driver.model;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.ArriveDestinationBean;
import com.shianlife.shian_platform.mvp.driver.bean.ArriveDestinationResultBean;

/**
 * Created by zm.
 */

public interface IArriveDestinationModel {
    /**
     * 到達目的地
     *
     * @param context
     * @param params
     * @param listener
     */
    void arriveDestination(Context context, ArriveDestinationBean params, OnGetDataListener<ArriveDestinationResultBean> listener);
}
