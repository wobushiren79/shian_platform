package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IFailServiceListModel;

/**
 * Created by zm.
 */

public class FailServiceListModelImpl implements IFailServiceListModel {
    @Override
    public void getFailServiceListData(Context context, FailServiceListBean params, OnGetDataListener<FailServiceListResultBean> listener) {
        listener.getDataSuccess(null);
    }
}
