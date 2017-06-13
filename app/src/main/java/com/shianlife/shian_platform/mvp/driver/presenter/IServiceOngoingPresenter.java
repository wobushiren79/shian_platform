package com.shianlife.shian_platform.mvp.driver.presenter;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.ServiceOngoingBean;

/**
 * Created by zm.
 */

public interface IServiceOngoingPresenter {

    void saveServiceOngoing();

    void saveServiceOngoing(ServiceOngoingBean param);
}
