package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListResultBean;

/**
 * Created by zm.
 */

public interface IFailServiceListView {
    Context getContext();

    void getFailServiceListDataSuccess(FailServiceListResultBean result);

    void getFailServiceListDataFail(String msg);
}
