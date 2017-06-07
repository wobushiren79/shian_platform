package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.GetOnCarResultBean;

/**
 * Created by zm.
 */

public interface IGetOnCarView {
    Context getContext();

    void getOnCarSuccess(GetOnCarResultBean result);

    void getOnCarFail(String msg);
}
