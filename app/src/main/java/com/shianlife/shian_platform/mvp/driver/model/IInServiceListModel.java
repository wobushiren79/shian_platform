package com.shianlife.shian_platform.mvp.driver.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListResultBean;

/**
 * Created by zm.
 */

public interface IInServiceListModel {
    /**
     * 获取正在服务列表
     *
     * @param context
     * @param params
     * @param listener
     */
    void getInServiceListData(Context context, InServiceListBean params, OnGetDataListener<InServiceListResultBean> listener);
}
