package com.shianlife.shian_platform.mvp.driver.model;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListResultBean;

/**
 * Created by zm.
 */

public interface IWaitServiceListModel {

    /**
     * 获取等待服务列表
     *
     * @param context
     * @param params
     * @param listener
     */
    void getWaitServiceListData(Context context, WaitServiceListBean params, OnGetDataListener<WaitServiceListResultBean> listener);
}
