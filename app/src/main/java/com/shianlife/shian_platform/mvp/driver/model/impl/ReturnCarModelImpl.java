package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.ReturnCarBean;
import com.shianlife.shian_platform.mvp.driver.bean.ReturnCarResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IReturnCarModel;

/**
 * Created by zm.
 */

public class ReturnCarModelImpl implements IReturnCarModel {
    @Override
    public void returnCar(Context context, ReturnCarBean params, OnGetDataListener<ReturnCarResultBean> listener) {
        listener.getDataSuccess(null);
    }
}
