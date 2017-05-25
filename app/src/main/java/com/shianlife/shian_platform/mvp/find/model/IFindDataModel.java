package com.shianlife.shian_platform.mvp.find.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.find.bean.FindDataBean;
import com.shianlife.shian_platform.mvp.find.presenter.OnFindDataListener;

/**
 * Created by zm.
 */

public interface IFindDataModel {
    /**
     * 点赞 收藏数据
     */
    void saveData(Context context, FindDataBean findDataBean, OnFindDataListener listener);
}
