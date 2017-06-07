package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.TakePersonResultBean;

/**
 * Created by zm.
 */

public interface ITakePersonView {
    /**
     * 獲取上下文
     *
     * @return
     */
    Context getContext();

    void takePersonSuccess(TakePersonResultBean result);

    void takePersonFail(String msg);
}
