package com.shianlife.shian_platform.mvp.find.model;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.find.bean.FindDataBean;

/**
 * Created by zm.
 */

public interface IFindDataModel {
    /**
     * 点赞 收藏数据
     */
    void saveData(Context context, FindDataBean findDataBean, OnGetDataListener listener);
}
