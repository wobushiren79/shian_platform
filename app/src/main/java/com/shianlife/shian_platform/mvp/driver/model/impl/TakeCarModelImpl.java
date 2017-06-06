package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.TakeCarBean;
import com.shianlife.shian_platform.mvp.driver.model.ITakeCarModel;

/**
 * Created by zm.
 */

public class TakeCarModelImpl implements ITakeCarModel {

    @Override
    public void saveTakeCarData(Context context, TakeCarBean params, OnGetDataListener listener) {
        listener.getDataSuccess(null);
    }
}
