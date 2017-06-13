package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.InServiceListResultBean;

/**
 * Created by zm.
 */

public interface IInServiceListView {
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

    void getInServiceListSuccess(InServiceListResultBean result);

    void getInServiceListFail(String msg);
}
