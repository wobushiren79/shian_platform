package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.SuccessServiceListBean;
import com.shianlife.shian_platform.mvp.driver.bean.SuccessServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.model.ISuccessServiceListModel;

/**
 * Created by zm.
 */

public class SuccessServiceListModelImpl implements ISuccessServiceListModel {


    @Override
    public void getSuccessServiceListData(Context context, SuccessServiceListBean params, OnGetDataListener<SuccessServiceListResultBean> listener) {
        listener.getDataSuccess(null);
    }
}
