package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderBean;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IAcceptOrderModel;

/**
 * Created by zm.
 */

public class AcceptOrderModelImpl implements IAcceptOrderModel {
    @Override
    public void acceptOrder(Context context, AcceptOrderBean params, OnGetDataListener<AcceptOrderResultBean> listener) {
        listener.getDataSuccess(null);
    }
}
