package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IWaitServiceListModel;

/**
 * Created by zm.
 */

public class WaitServiceListModelImpl implements IWaitServiceListModel {

    @Override
    public void getWaitServiceListData(Context context, WaitServiceListBean params, OnGetDataListener<WaitServiceListResultBean> listener) {
        listener.getDataSuccess(null);
    }
}
