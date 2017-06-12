package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListResultBean;

/**
 * Created by zm.
 */

public interface IWaitServiceListView {
    Context getContext();

    /**
     * 获取页大小
     *
     * @return
     */
    long getPageSize();

    /**
     * 获取页数量
     *
     * @return
     */
    long getPageNum();

    void getWaitServiceListSuccess(WaitServiceListResultBean result);

    void getWaitServiceListFail(String msg);
}
