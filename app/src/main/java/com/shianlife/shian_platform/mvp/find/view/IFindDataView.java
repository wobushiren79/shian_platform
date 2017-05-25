package com.shianlife.shian_platform.mvp.find.view;

import android.content.Context;

/**
 * Created by zm.
 */

public interface IFindDataView {
    Context getContext();

    void changeSuccess();

    void changeFail(String msg);

    /**
     * 获取改变类型
     * （1.为点赞   2.为收藏）
     */
    int getChangeType();

    /**
     * 获取发现ID
     * @return
     */
    int getSiftid();
}
