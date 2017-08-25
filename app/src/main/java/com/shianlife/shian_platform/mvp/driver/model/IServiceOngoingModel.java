package com.shianlife.shian_platform.mvp.driver.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.ServiceOngoingBean;
import com.shianlife.shian_platform.mvp.driver.bean.ServiceOngoingResultBean;

/**
 * Created by zm.
 */

public interface IServiceOngoingModel {

    /**
     * 保存服务步奏
     *
     * @param context
     * @param params
     * @param listener
     */
    void saveServiceOngoing(Context context, ServiceOngoingBean params, OnGetDataListener<ServiceOngoingResultBean> listener);
}
