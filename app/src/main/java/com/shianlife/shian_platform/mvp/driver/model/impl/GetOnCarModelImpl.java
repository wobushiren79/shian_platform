package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.GetOnCarBean;
import com.shianlife.shian_platform.mvp.driver.bean.GetOnCarResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IGetOnCarModel;

/**
 * Created by zm.
 */

public class GetOnCarModelImpl implements IGetOnCarModel {
    @Override
    public void getOnCar(Context context, GetOnCarBean params, OnGetDataListener<GetOnCarResultBean> listener) {
        listener.getDataSuccess(null);
    }
}
