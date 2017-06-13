package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.SuccessServiceListResultBean;

/**
 * Created by zm.
 */

public interface ISuccessServiceListView {
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
    void getSuccessServiceListSuccess(SuccessServiceListResultBean result);

    void getSuccessServiceListFail(String msg);
}
