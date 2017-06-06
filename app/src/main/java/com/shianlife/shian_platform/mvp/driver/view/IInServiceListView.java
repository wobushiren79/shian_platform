package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.InServiceListResultBean;

/**
 * Created by zm.
 */

public interface IInServiceListView {
    Context getContext();

    void getInServiceListSuccess(InServiceListResultBean result);

    void getInServiceListFail(String msg);
}
