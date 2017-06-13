package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.ServiceOngoingResultBean;

/**
 * Created by zm.
 */

public interface IServiceOngoingRequestView {

    Context getContext();

    void saveServiceOngoingSuccess(ServiceOngoingResultBean result);

    void saveServiceOngoingFail(String msg);

}
