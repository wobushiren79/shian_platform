package com.shianlife.shian_platform.mvp.driver.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListResultBean;

/**
 * Created by zm.
 */

public interface IFailServiceListModel {
    /**
     * 获取服务失败列表数据
     * @param context
     * @param params
     * @param listener
     */
    void getFailServiceListData(Context context, FailServiceListBean params, OnGetDataListener<FailServiceListResultBean> listener);
}
