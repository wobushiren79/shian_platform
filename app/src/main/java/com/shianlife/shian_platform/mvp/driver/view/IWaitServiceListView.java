package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListResultBean;

/**
 * Created by zm.
 */

public interface IWaitServiceListView {
    Context getContext();

    void getWaitServiceListSuccess(WaitServiceListResultBean result);

    void getWaitServiceListFail(String msg);
}
