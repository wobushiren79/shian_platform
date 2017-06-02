package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderResultBean;

/**
 * Created by zm.
 */

public interface IRejectOrderView {
    Context getContext();

    void rejectOrderSuccess(RejectOrderResultBean result);

    void rejectOrderFail(String msg);
}
