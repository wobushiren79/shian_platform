package com.shianlife.shian_platform.mvp.driver.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.ArriveDestinationBean;
import com.shianlife.shian_platform.mvp.driver.bean.ArriveDestinationResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IArriveDestinationModel;

/**
 * Created by zm.
 */

public class ArriveDestinationModelImpl implements IArriveDestinationModel {

    @Override
    public void arriveDestination(Context context, ArriveDestinationBean params, OnGetDataListener<ArriveDestinationResultBean> listener) {
        listener.getDataSuccess(null);
    }
}
