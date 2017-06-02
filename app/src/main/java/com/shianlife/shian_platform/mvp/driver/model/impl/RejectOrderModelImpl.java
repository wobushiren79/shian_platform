package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderBean;
import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderBean;
import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IRejectOrderModel;

/**
 * Created by zm.
 */

public class RejectOrderModelImpl implements IRejectOrderModel {
    @Override
    public void rejectOrder(Context context, RejectOrderBean params, OnGetDataListener<RejectOrderResultBean> listener) {
        listener.getDataSuccess(null);
    }
}
