package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.TakeCarResultBean;

/**
 * Created by zm.
 */

public interface ITakeCarView {
    Context getContext();

    void saveTalkCarDataSuccess(TakeCarResultBean result);

    void saveTalkCarDataFail(String msg);
}
