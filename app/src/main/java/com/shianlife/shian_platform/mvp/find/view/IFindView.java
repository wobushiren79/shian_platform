package com.shianlife.shian_platform.mvp.find.view;

import android.content.Context;

import com.shianlife.shian_platform.http.base.BaseDataResult;

/**
 * Created by zm.
 */

public interface IFindView {
    Context getContext();

    /**
     * 获取一页加载大小
     *
     * @return
     */
    int getPagerSize();

    /**
     * 获取当前页数
     *
     * @return
     */
    int getPagerNum();

    /**
     * 获取当前收藏类型
     *
     * @return
     */
    int getFindType();

    /**
     * 展示数据
     *
     * @param result
     */
    void showData(BaseDataResult result);

    /**
     * 展示提示
     */
    void showMsg(String msg);

}
