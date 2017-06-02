package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderResultBean;

/**
 * Created by zm.
 */

public interface IAcceptOrderView {
    Context getContext();

    void acceptOrderSuccess(AcceptOrderResultBean result);

    void acceptOrderFail(String msg);
}
