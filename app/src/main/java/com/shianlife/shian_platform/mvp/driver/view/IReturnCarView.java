package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.ReturnCarResultBean;

/**
 * Created by zm.
 */

public interface IReturnCarView {
    Context getContext();

    void returnCarSuccess(ReturnCarResultBean result);

    void returnCarFail(String msg);
}
