package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IInServiceListModel;

/**
 * Created by zm.
 */

public class InServiceListModelImpl implements IInServiceListModel {
    @Override
    public void getInServiceListData(Context context, InServiceListBean params, OnGetDataListener<InServiceListResultBean> listener) {
        listener.getDataSuccess(null);
    }
}
