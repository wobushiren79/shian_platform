package com.shianlife.shian_platform.mvp.driver.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.SuccessServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.SuccessServiceListResultBean;

/**
 * Created by zm.
 */

public interface ISuccessServiceListModel {

    /**
     * 獲取成功服務列表
     *
     * @param context
     * @param params
     * @param listener
     */
    void getSuccessServiceListData(Context context, SuccessServiceListBean params, OnGetDataListener<SuccessServiceListResultBean> listener);

}
