package com.shianlife.shian_platform.mvp.store.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.store.bean.StoreOrderGetPerformResultBean;


/**
 * Created by zm.
 */

public interface IStoreOrderGetPerformView {
    Context getContext();

    void getPerformInfoSuccess(StoreOrderGetPerformResultBean resultBean);

    void getPerformInfoFail(String msg);

}
