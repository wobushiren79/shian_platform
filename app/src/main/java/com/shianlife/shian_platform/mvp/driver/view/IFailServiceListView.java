package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListResultBean;

/**
 * Created by zm.
 */

public interface IFailServiceListView {
    Context getContext();

    void getFailServiceListDataSuccess(FailServiceListResultBean result);

    void getFailServiceListDataFail(String msg);

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

}
