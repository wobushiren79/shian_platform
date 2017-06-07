package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.SuccessServiceListResultBean;

/**
 * Created by zm.
 */

public interface ISuccessServiceListView {
    Context getContext();

    void getSuccessServiceListSuccess(SuccessServiceListResultBean result);

    void getSuccessServiceListFail(String msg);
}
