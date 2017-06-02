package com.shianlife.shian_platform.mvp.driver.model;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderBean;
import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderResultBean;

/**
 * Created by zm.
 */

public interface IRejectOrderModel {
    /**
     * 拒单
     * @param context
     * @param params
     * @param listener
     */
    void rejectOrder(Context context, RejectOrderBean params, OnGetDataListener<RejectOrderResultBean> listener);
}
