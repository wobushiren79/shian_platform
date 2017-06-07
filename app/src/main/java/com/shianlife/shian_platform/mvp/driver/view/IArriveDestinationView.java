package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.ArriveDestinationResultBean;

/**
 * Created by zm.
 */

public interface IArriveDestinationView {
    Context getContext();

    void arriveDestinationSuccess(ArriveDestinationResultBean result);

    void arriveDestinationFail(String msg);
}
