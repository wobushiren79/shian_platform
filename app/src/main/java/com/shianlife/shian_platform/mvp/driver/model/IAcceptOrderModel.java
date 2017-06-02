package com.shianlife.shian_platform.mvp.driver.model;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderBean;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderResultBean;

/**
 * Created by zm.
 */

public interface IAcceptOrderModel {
    /**
     * 接单
     * @param context
     * @param params
     * @param listener
     */
    void acceptOrder(Context context, AcceptOrderBean params, OnGetDataListener<AcceptOrderResultBean> listener);
}
