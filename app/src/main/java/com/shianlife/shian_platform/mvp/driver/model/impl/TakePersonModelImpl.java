package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.TakePersonBean;
import com.shianlife.shian_platform.mvp.driver.bean.TakePersonResultBean;
import com.shianlife.shian_platform.mvp.driver.model.ITakePersonModel;

/**
 * Created by zm.
 */

public class TakePersonModelImpl implements ITakePersonModel {
    @Override
    public void takePerson(Context context, TakePersonBean params, OnGetDataListener<TakePersonResultBean> listener) {
        listener.getDataSuccess(null);
    }
}
